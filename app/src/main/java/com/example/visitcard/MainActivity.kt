package com.example.visitcard



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = stringResource(R.string.photo_description),
                    modifier = Modifier.size(120.dp)
                )
                Text(
                    text = stringResource(R.string.full_name),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )

                Text(
                    text = stringResource(R.string.title),
                    fontSize = 18.sp,
                    color = Color(0xFF3ddc84),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
        }

        ContactSection()
    }
}

@Composable
fun ContactRow(icon: String, contactText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Text(
            text = icon,
            fontSize = 20.sp
        )
        Text(
            text = contactText,
            fontSize = 16.sp,
            color = Color.Blue
        )
    }
}
@Composable
fun ContactSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    ) {
        Column(
            modifier = Modifier.width(180.dp),
            horizontalAlignment = Alignment.Start

        ) {
            ContactRow(
                icon = "📞 ",
                contactText = stringResource(R.string.phone)
            )

            ContactRow(
                icon = "🌐 ",
                contactText = stringResource(R.string.social)
            )

            ContactRow(
                icon = "✉️ ",
                contactText = stringResource(R.string.email)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    VisitCardTheme {
        BusinessCard()
    }
}