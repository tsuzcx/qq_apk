package com.tencent.wework.api.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
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
import com.tencent.wwapi.a.a;
import com.tencent.wwapi.a.b;

public class H5Activity
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(210598);
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (!getIntent().hasExtra("url")))
    {
      finish();
      AppMethodBeat.o(210598);
      return;
    }
    setContentView(a.b.wwapi_activity_h5_layout);
    findViewById(a.a.back).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210563);
        H5Activity.this.finish();
        AppMethodBeat.o(210563);
      }
    });
    paramBundle = (WebView)findViewById(a.a.web_view);
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
    paramBundle.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        AppMethodBeat.i(210559);
        try
        {
          paramAnonymousString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
          paramAnonymousString1 = H5Activity.this;
          paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString2);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString1, paramAnonymousString2.aYi(), "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString1.startActivity((Intent)paramAnonymousString2.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString1, "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          return;
        }
        finally
        {
          AppMethodBeat.o(210559);
        }
      }
    });
    paramBundle.setWebChromeClient(new WebChromeClient()
    {
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(210600);
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(210600);
        return bool;
      }
      
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(210572);
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(210572);
      }
      
      public void onReceivedIcon(WebView paramAnonymousWebView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(210592);
        super.onReceivedIcon(paramAnonymousWebView, paramAnonymousBitmap);
        AppMethodBeat.o(210592);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(210585);
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        ((TextView)H5Activity.this.findViewById(a.a.title)).setText(paramAnonymousString);
        AppMethodBeat.o(210585);
      }
    });
    paramBundle.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {}
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(210577);
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(210577);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210580);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(210580);
      }
      
      public void onReceivedHttpAuthRequest(WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(210587);
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(210587);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(210569);
        try
        {
          if (!Uri.parse(paramAnonymousString).getScheme().toLowerCase().contains("http"))
          {
            Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            H5Activity localH5Activity = H5Activity.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localH5Activity, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localH5Activity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localH5Activity, "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(210569);
            return true;
          }
        }
        finally
        {
          boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
          AppMethodBeat.o(210569);
          return bool;
        }
      }
    });
    paramBundle.loadUrl(getIntent().getStringExtra("url"));
    AppMethodBeat.o(210598);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wework.api.view.H5Activity
 * JD-Core Version:    0.7.0.1
 */