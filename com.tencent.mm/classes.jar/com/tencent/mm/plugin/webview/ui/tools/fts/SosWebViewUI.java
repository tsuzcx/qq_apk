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
import com.tencent.mm.b.e;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;

public class SosWebViewUI
  extends WebViewUI
{
  private boolean Jpn;
  private int Jpo;
  private String Jpp;
  private av Jpq;
  private boolean Jpr;
  private int Jps;
  private MMHandler Jpt;
  private a Jpu;
  private int mve;
  private int subType;
  
  public SosWebViewUI()
  {
    AppMethodBeat.i(80773);
    this.Jpn = false;
    this.mve = 0;
    this.subType = 0;
    this.Jpo = 0;
    this.Jpp = "";
    this.Jpq = new av();
    this.Jpr = false;
    this.Jps = 0;
    this.Jpt = new MMHandler(Looper.getMainLooper())
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
            Log.printErrStackTrace("MicroMsg.WebSearch.SosWebViewUI", paramAnonymousMessage, "pageHandler", new Object[0]);
          }
        }
        AppMethodBeat.o(80766);
      }
    };
    this.Jpu = new a();
    AppMethodBeat.o(80773);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(211302);
    super.b(paramWebView, paramString);
    if (this.Jpr) {
      this.Jps += 1;
    }
    AppMethodBeat.o(211302);
  }
  
  public final i cpO()
  {
    AppMethodBeat.i(211303);
    i locali = super.cpO();
    if (locali != null) {
      locali.a(this.Jpu);
    }
    AppMethodBeat.o(211303);
    return locali;
  }
  
  public final boolean cpz()
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
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(80774);
    super.onCreate(paramBundle);
    this.pGj.addJavascriptInterface(new b(), "SosJSApi");
    this.mve = getIntent().getIntExtra("from_scence", 0);
    this.subType = getIntent().getIntExtra("subtype", 0);
    this.Jpp = getIntent().getStringExtra("rawUrl");
    paramBundle = getIntent().getStringExtra("key_init_url");
    if (paramBundle != null) {
      bool = true;
    }
    this.Jpr = bool;
    av localav;
    if (this.Jpr)
    {
      this.Jpq.eqk = cl.aWA();
      localav = this.Jpq;
      localav.eqx = localav.x("InitUrl", paramBundle.replace(",", "!"), true);
      paramBundle = getIntent().getStringExtra("key_search_query");
      if (paramBundle != null) {
        break label177;
      }
    }
    label177:
    for (paramBundle = "";; paramBundle = paramBundle.replace(",", "!"))
    {
      localav = this.Jpq;
      localav.eqv = localav.x("Query", paramBundle, true);
      AppMethodBeat.o(80774);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80775);
    this.pGj.removeJavascriptInterface("SosJSApi");
    this.IMH.b(this.Jpu);
    this.IMH.b(this.Jpu.Jpw);
    if (this.Jpr)
    {
      this.Jpq.eqw = getActivityBrowseTimeMs();
      this.Jpq.eqy = this.Jps;
      this.Jpq.bfK();
      Log.i("MicroMsg.WebSearch.SosWebViewUI", "FTSRelatedSugH5ReportStruct.report url : %s, enterTime : %d, stayTime : %d, getQuery : %s ,id : %d, pageChangeCount : %d.", new Object[] { this.Jpq.eqx, Long.valueOf(this.Jpq.eqk), Long.valueOf(this.Jpq.eqw), this.Jpq.eqv, Integer.valueOf(22251), Integer.valueOf(this.Jps) });
    }
    super.onDestroy();
    AppMethodBeat.o(80775);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends k
  {
    a Jpw;
    
    a()
    {
      AppMethodBeat.i(211301);
      this.Jpw = new a();
      AppMethodBeat.o(211301);
    }
    
    final class a
      extends f
    {
      a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(211298);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramString2)))
        {
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedError %d %s", new Object[] { Integer.valueOf(paramInt), paramString1 });
          SosWebViewUI.a(SosWebViewUI.this, paramInt);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(211298);
      }
      
      public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
      {
        AppMethodBeat.i(211299);
        super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramWebResourceRequest.getUrl().toString())))
        {
          SosWebViewUI.a(SosWebViewUI.this, paramWebResourceResponse.mStatusCode);
          if ((SosWebViewUI.e(SosWebViewUI.this) < 400) || (SosWebViewUI.e(SosWebViewUI.this) >= 600))
          {
            Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError not report %s %d", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)) });
            AppMethodBeat.o(211299);
            return;
          }
        }
        try
        {
          paramWebView = new String(e.readFromStream(paramWebResourceResponse.mInputStream));
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError %s %d %s", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)), paramWebView });
          SosWebViewUI.b(SosWebViewUI.this, paramWebView);
          AppMethodBeat.o(211299);
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
        AppMethodBeat.i(211300);
        super.a(paramWebView, paramr, paramSslError);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramSslError.getUrl())))
        {
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedSslError");
          SosWebViewUI.a(SosWebViewUI.this, -1);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(211300);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(211297);
        super.b(paramWebView, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        if (!SosWebViewUI.c(SosWebViewUI.this)) {
          SosWebViewUI.b(SosWebViewUI.this).sendEmptyMessageDelayed(0, 1000L);
        }
        AppMethodBeat.o(211297);
      }
      
      public final void i(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(211296);
        SosWebViewUI.a(SosWebViewUI.this, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        AppMethodBeat.o(211296);
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