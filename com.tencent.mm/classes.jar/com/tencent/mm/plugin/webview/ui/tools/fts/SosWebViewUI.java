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
import com.tencent.xweb.q;

public class SosWebViewUI
  extends WebViewUI
{
  private boolean Bmh;
  private int Bmi;
  private String Bmj;
  private ap Bmk;
  private int kme;
  private int subType;
  
  public SosWebViewUI()
  {
    AppMethodBeat.i(80773);
    this.Bmh = false;
    this.kme = 0;
    this.subType = 0;
    this.Bmi = 0;
    this.Bmj = "";
    this.Bmk = new ap(Looper.getMainLooper())
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
  
  public final h bFq()
  {
    AppMethodBeat.i(188099);
    h localh = super.bFq();
    if (localh != null) {
      localh.a(new a());
    }
    AppMethodBeat.o(188099);
    return localh;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80774);
    super.onCreate(paramBundle);
    this.nhy.addJavascriptInterface(new b(), "SosJSApi");
    this.kme = getIntent().getIntExtra("from_scence", 0);
    this.subType = getIntent().getIntExtra("subtype", 0);
    AppMethodBeat.o(80774);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80775);
    this.nhy.removeJavascriptInterface("SosJSApi");
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
        AppMethodBeat.i(188095);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        if (SosWebViewUI.d(SosWebViewUI.this).equals(paramString2))
        {
          ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedError %d %s", new Object[] { Integer.valueOf(paramInt), paramString1 });
          SosWebViewUI.a(SosWebViewUI.this, paramInt);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(188095);
      }
      
      public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
      {
        AppMethodBeat.i(188096);
        super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        if (SosWebViewUI.d(SosWebViewUI.this).equals(paramWebResourceRequest.getUrl().toString()))
        {
          SosWebViewUI.a(SosWebViewUI.this, paramWebResourceResponse.mStatusCode);
          if ((SosWebViewUI.e(SosWebViewUI.this) < 400) || (SosWebViewUI.e(SosWebViewUI.this) >= 600))
          {
            ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError not report %s %d", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)) });
            AppMethodBeat.o(188096);
            return;
          }
        }
        try
        {
          paramWebView = new String(com.tencent.mm.b.e.readFromStream(paramWebResourceResponse.mInputStream));
          ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError %s %d %s", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)), paramWebView });
          SosWebViewUI.b(SosWebViewUI.this, paramWebView);
          AppMethodBeat.o(188096);
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
      
      public final void a(WebView paramWebView, q paramq, SslError paramSslError)
      {
        AppMethodBeat.i(188097);
        super.a(paramWebView, paramq, paramSslError);
        if (SosWebViewUI.d(SosWebViewUI.this).equals(paramSslError.getUrl()))
        {
          ad.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedSslError");
          SosWebViewUI.a(SosWebViewUI.this, -1);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(188097);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188094);
        super.b(paramWebView, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        if (!SosWebViewUI.c(SosWebViewUI.this)) {
          SosWebViewUI.b(SosWebViewUI.this).sendEmptyMessageDelayed(0, 1000L);
        }
        AppMethodBeat.o(188094);
      }
      
      public final void m(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(188093);
        SosWebViewUI.a(SosWebViewUI.this, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        AppMethodBeat.o(188093);
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