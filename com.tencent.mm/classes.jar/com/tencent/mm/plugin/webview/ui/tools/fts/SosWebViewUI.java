package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;

public class SosWebViewUI
  extends WebViewUI
{
  private boolean Eic;
  private int Eid;
  private String Eie;
  private ap Eif;
  private int ljZ;
  private int subType;
  
  public SosWebViewUI()
  {
    AppMethodBeat.i(80773);
    this.Eic = false;
    this.ljZ = 0;
    this.subType = 0;
    this.Eid = 0;
    this.Eie = "";
    this.Eif = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(80766);
        if (paramAnonymousMessage.what == 0) {
          try
          {
            SosWebViewUI.a(SosWebViewUI.this).evaluateJavascript("javascript:window.SosJSApi.onHtmlContentReport('<body>'+document.getElementsByTagName('body')[0].innerHTML+'</body>');", null);
            AppMethodBeat.o(80766);
            return;
          }
          catch (Throwable paramAnonymousMessage)
          {
            ad.printErrStackTrace("MicroMsg.WebSearch.SosWebViewUI", paramAnonymousMessage, "pageHandler", new Object[0]);
          }
        }
        AppMethodBeat.o(80766);
      }
    };
    AppMethodBeat.o(80773);
  }
  
  public final boolean bQO()
  {
    AppMethodBeat.i(175839);
    if (!getIntent().getBooleanExtra("disable_minimize", false))
    {
      AppMethodBeat.o(175839);
      return true;
    }
    AppMethodBeat.o(175839);
    return false;
  }
  
  public final h bRd()
  {
    AppMethodBeat.i(208215);
    h localh = super.bRd();
    if (localh != null) {
      localh.a(new a());
    }
    AppMethodBeat.o(208215);
    return localh;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80774);
    super.onCreate(paramBundle);
    this.omW.addJavascriptInterface(new b(), "SosJSApi");
    this.ljZ = getIntent().getIntExtra("from_scence", 0);
    this.subType = getIntent().getIntExtra("subtype", 0);
    AppMethodBeat.o(80774);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80775);
    this.omW.removeJavascriptInterface("SosJSApi");
    super.onDestroy();
    AppMethodBeat.o(80775);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends j
  {
    a() {}
    
    final class a
      extends com.tencent.mm.plugin.webview.core.e
    {
      a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(208211);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        if (SosWebViewUI.d(SosWebViewUI.this).equals(paramString2))
        {
          ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedError %d %s", new Object[] { Integer.valueOf(paramInt), paramString1 });
          SosWebViewUI.a(SosWebViewUI.this, paramInt);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(208211);
      }
      
      public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
      {
        AppMethodBeat.i(208212);
        super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        if (SosWebViewUI.d(SosWebViewUI.this).equals(paramWebResourceRequest.getUrl().toString()))
        {
          SosWebViewUI.a(SosWebViewUI.this, paramWebResourceResponse.mStatusCode);
          if ((SosWebViewUI.e(SosWebViewUI.this) < 400) || (SosWebViewUI.e(SosWebViewUI.this) >= 600))
          {
            ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError not report %s %d", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)) });
            AppMethodBeat.o(208212);
            return;
          }
        }
        try
        {
          paramWebView = new String(com.tencent.mm.b.e.readFromStream(paramWebResourceResponse.mInputStream));
          ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError %s %d %s", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)), paramWebView });
          SosWebViewUI.b(SosWebViewUI.this, paramWebView);
          AppMethodBeat.o(208212);
          return;
        }
        catch (Throwable paramWebView)
        {
          for (;;)
          {
            paramWebView = "";
          }
        }
      }
      
      public final void a(WebView paramWebView, r paramr, SslError paramSslError)
      {
        AppMethodBeat.i(208213);
        super.a(paramWebView, paramr, paramSslError);
        if (SosWebViewUI.d(SosWebViewUI.this).equals(paramSslError.getUrl()))
        {
          ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedSslError");
          SosWebViewUI.a(SosWebViewUI.this, -1);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(208213);
      }
      
      public final void aGk(String paramString)
      {
        AppMethodBeat.i(208209);
        SosWebViewUI.a(SosWebViewUI.this, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        AppMethodBeat.o(208209);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(208210);
        super.b(paramWebView, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        if (!SosWebViewUI.c(SosWebViewUI.this)) {
          SosWebViewUI.b(SosWebViewUI.this).sendEmptyMessageDelayed(0, 1000L);
        }
        AppMethodBeat.o(208210);
      }
    }
  }
  
  final class b
  {
    b() {}
    
    @JavascriptInterface
    public final void onHtmlContentReport(String paramString)
    {
      AppMethodBeat.i(80772);
      SosWebViewUI.b(SosWebViewUI.this, paramString);
      AppMethodBeat.o(80772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.SosWebViewUI
 * JD-Core Version:    0.7.0.1
 */