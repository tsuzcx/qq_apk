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
import com.tencent.i.a.a;
import com.tencent.i.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class H5Activity
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233482);
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (!getIntent().hasExtra("url")))
    {
      finish();
      AppMethodBeat.o(233482);
      return;
    }
    setContentView(a.b.wwapi_activity_h5_layout);
    findViewById(a.a.back).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233458);
        H5Activity.this.finish();
        AppMethodBeat.o(233458);
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
        AppMethodBeat.i(233463);
        try
        {
          paramAnonymousString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
          paramAnonymousString1 = H5Activity.this;
          paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousString2);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString1, paramAnonymousString2.aFh(), "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString1.startActivity((Intent)paramAnonymousString2.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString1, "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(233463);
          return;
        }
        catch (Throwable paramAnonymousString1)
        {
          AppMethodBeat.o(233463);
        }
      }
    });
    paramBundle.setWebChromeClient(new WebChromeClient()
    {
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(233467);
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(233467);
        return bool;
      }
      
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(233464);
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(233464);
      }
      
      public void onReceivedIcon(WebView paramAnonymousWebView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(233466);
        super.onReceivedIcon(paramAnonymousWebView, paramAnonymousBitmap);
        AppMethodBeat.o(233466);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(233465);
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        ((TextView)H5Activity.this.findViewById(a.a.title)).setText(paramAnonymousString);
        AppMethodBeat.o(233465);
      }
    });
    paramBundle.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {}
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(233476);
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(233476);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(233478);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(233478);
      }
      
      public void onReceivedHttpAuthRequest(WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(233479);
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(233479);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(233474);
        try
        {
          if (!Uri.parse(paramAnonymousString).getScheme().toLowerCase().contains("http"))
          {
            Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            H5Activity localH5Activity = H5Activity.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localH5Activity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localH5Activity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localH5Activity, "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(233474);
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
          AppMethodBeat.o(233474);
          return bool;
        }
      }
    });
    paramBundle.loadUrl(getIntent().getStringExtra("url"));
    AppMethodBeat.o(233482);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.view.H5Activity
 * JD-Core Version:    0.7.0.1
 */