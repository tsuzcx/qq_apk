package com.tencent.wework.api.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class H5Activity
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199028);
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (!getIntent().hasExtra("url")))
    {
      finish();
      AppMethodBeat.o(199028);
      return;
    }
    setContentView(2131497104);
    findViewById(2131297158).setOnClickListener(new H5Activity.1(this));
    paramBundle = (WebView)findViewById(2131310380);
    if (Build.VERSION.SDK_INT >= 11) {
      paramBundle.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    paramBundle.getSettings().setJavaScriptEnabled(true);
    paramBundle.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramBundle.getSettings().setAllowFileAccess(true);
    paramBundle.getSettings().setAllowFileAccessFromFileURLs(false);
    paramBundle.getSettings().setAllowUniversalAccessFromFileURLs(false);
    paramBundle.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    paramBundle.getSettings().setSupportZoom(true);
    paramBundle.getSettings().setBuiltInZoomControls(true);
    paramBundle.getSettings().setUseWideViewPort(true);
    paramBundle.getSettings().setLoadWithOverviewMode(true);
    paramBundle.getSettings().setAppCacheEnabled(true);
    paramBundle.getSettings().setDomStorageEnabled(true);
    paramBundle.getSettings().setDatabaseEnabled(true);
    paramBundle.getSettings().setGeolocationEnabled(true);
    paramBundle.getSettings().setSupportMultipleWindows(false);
    paramBundle.setDownloadListener(new H5Activity.2(this));
    paramBundle.setWebChromeClient(new WebChromeClient()
    {
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(199023);
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(199023);
        return bool;
      }
      
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(199020);
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(199020);
      }
      
      public void onReceivedIcon(WebView paramAnonymousWebView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(199022);
        super.onReceivedIcon(paramAnonymousWebView, paramAnonymousBitmap);
        AppMethodBeat.o(199022);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(199021);
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        ((TextView)H5Activity.this.findViewById(2131309195)).setText(paramAnonymousString);
        AppMethodBeat.o(199021);
      }
    });
    paramBundle.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {}
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(199025);
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(199025);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(199026);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(199026);
      }
      
      public void onReceivedHttpAuthRequest(WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(199027);
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(199027);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(199024);
        try
        {
          if (!Uri.parse(paramAnonymousString).getScheme().toLowerCase().contains("http"))
          {
            Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            H5Activity localH5Activity = H5Activity.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localH5Activity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localH5Activity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localH5Activity, "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(199024);
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
          AppMethodBeat.o(199024);
          return bool;
        }
      }
    });
    paramBundle.loadUrl(getIntent().getStringExtra("url"));
    AppMethodBeat.o(199028);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wework.api.view.H5Activity
 * JD-Core Version:    0.7.0.1
 */