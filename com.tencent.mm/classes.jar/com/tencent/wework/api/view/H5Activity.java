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
    AppMethodBeat.i(193348);
    super.onCreate(paramBundle);
    if ((getIntent() == null) || (!getIntent().hasExtra("url")))
    {
      finish();
      AppMethodBeat.o(193348);
      return;
    }
    setContentView(2131496504);
    findViewById(2131308229).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193338);
        H5Activity.this.finish();
        AppMethodBeat.o(193338);
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
        AppMethodBeat.i(193339);
        try
        {
          paramAnonymousString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
          paramAnonymousString1 = H5Activity.this;
          paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousString2);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, paramAnonymousString2.ahE(), "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousString1.startActivity((Intent)paramAnonymousString2.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString1, "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(193339);
          return;
        }
        catch (Throwable paramAnonymousString1)
        {
          AppMethodBeat.o(193339);
        }
      }
    });
    paramBundle.setWebChromeClient(new WebChromeClient()
    {
      public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        AppMethodBeat.i(193343);
        boolean bool = super.onJsPrompt(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
        AppMethodBeat.o(193343);
        return bool;
      }
      
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        AppMethodBeat.i(193340);
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        AppMethodBeat.o(193340);
      }
      
      public void onReceivedIcon(WebView paramAnonymousWebView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(193342);
        super.onReceivedIcon(paramAnonymousWebView, paramAnonymousBitmap);
        AppMethodBeat.o(193342);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(193341);
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        ((TextView)H5Activity.this.findViewById(2131305902)).setText(paramAnonymousString);
        AppMethodBeat.o(193341);
      }
    });
    paramBundle.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {}
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(193345);
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(193345);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193346);
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(193346);
      }
      
      public void onReceivedHttpAuthRequest(WebView paramAnonymousWebView, HttpAuthHandler paramAnonymousHttpAuthHandler, String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AppMethodBeat.i(193347);
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        AppMethodBeat.o(193347);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(193344);
        try
        {
          if (!Uri.parse(paramAnonymousString).getScheme().toLowerCase().contains("http"))
          {
            Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            H5Activity localH5Activity = H5Activity.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localH5Activity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localH5Activity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localH5Activity, "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(193344);
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          boolean bool = super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
          AppMethodBeat.o(193344);
          return bool;
        }
      }
    });
    paramBundle.loadUrl(getIntent().getStringExtra("url"));
    AppMethodBeat.o(193348);
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