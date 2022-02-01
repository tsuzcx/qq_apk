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

public class H5Activity
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190376);
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (!getIntent().hasExtra("url")))
    {
      finish();
      AppMethodBeat.o(190376);
      return;
    }
    setContentView(2131496504);
    findViewById(2131308229).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190366);
        H5Activity.this.finish();
        AppMethodBeat.o(190366);
      }
    });
    paramBundle = (WebView)findViewById(2131308468);
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
        AppMethodBeat.i(190367);
        try
        {
          paramAnonymousString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
          paramAnonymousString1 = H5Activity.this;
          paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousString2);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, paramAnonymousString2.ahp(), "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString1.startActivity((Intent)paramAnonymousString2.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(190367);
          return;
        }
        catch (Throwable paramAnonymousString1)
        {
          AppMethodBeat.o(190367);
        }
      }
    });
    paramBundle.setWebChromeClient(new WebChromeClient()
    {
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(190371);
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(190371);
        return bool;
      }
      
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(190368);
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(190368);
      }
      
      public void onReceivedIcon(WebView paramAnonymousWebView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(190370);
        super.onReceivedIcon(paramAnonymousWebView, paramAnonymousBitmap);
        AppMethodBeat.o(190370);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(190369);
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        ((TextView)H5Activity.this.findViewById(2131305902)).setText(paramAnonymousString);
        AppMethodBeat.o(190369);
      }
    });
    paramBundle.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {}
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(190373);
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(190373);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(190374);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(190374);
      }
      
      public void onReceivedHttpAuthRequest(WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(190375);
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(190375);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(190372);
        try
        {
          if (!Uri.parse(paramAnonymousString).getScheme().toLowerCase().contains("http"))
          {
            Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            H5Activity localH5Activity = H5Activity.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localH5Activity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localH5Activity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localH5Activity, "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(190372);
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
          AppMethodBeat.o(190372);
          return bool;
        }
      }
    });
    paramBundle.loadUrl(getIntent().getStringExtra("url"));
    AppMethodBeat.o(190376);
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