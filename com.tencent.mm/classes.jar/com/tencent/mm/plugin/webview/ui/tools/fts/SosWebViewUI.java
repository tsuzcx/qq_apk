package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ca;
import com.tencent.mm.b.e;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.t;
import java.lang.ref.WeakReference;

public class SosWebViewUI
  extends WebViewUI
{
  private boolean XeX;
  private int XeY;
  private String XeZ;
  private ca Xfa;
  private boolean Xfb;
  private int Xfc;
  private MMHandler Xfd;
  private a Xfe;
  private int subType;
  private int syO;
  
  public SosWebViewUI()
  {
    AppMethodBeat.i(80773);
    this.XeX = false;
    this.syO = 0;
    this.subType = 0;
    this.XeY = 0;
    this.XeZ = "";
    this.Xfa = new ca();
    this.Xfb = false;
    this.Xfc = 0;
    this.Xfd = new MMHandler(Looper.getMainLooper())
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
          finally
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.SosWebViewUI", paramAnonymousMessage, "pageHandler", new Object[0]);
          }
        }
        AppMethodBeat.o(80766);
      }
    };
    this.Xfe = new a();
    AppMethodBeat.o(80773);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(296844);
    super.b(paramWebView, paramString);
    if (this.Xfb) {
      this.Xfc += 1;
    }
    AppMethodBeat.o(296844);
  }
  
  public final k dhx()
  {
    AppMethodBeat.i(296853);
    k localk = super.dhx();
    if (localk != null) {
      localk.a(this.Xfe);
    }
    AppMethodBeat.o(296853);
    return localk;
  }
  
  public final boolean dhz()
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
    this.sMP.addJavascriptInterface(new b(this), "SosJSApi");
    this.syO = getIntent().getIntExtra("from_scence", 0);
    this.subType = getIntent().getIntExtra("subtype", 0);
    this.XeZ = getIntent().getStringExtra("rawUrl");
    paramBundle = getIntent().getStringExtra("key_init_url");
    if (paramBundle != null) {
      bool = true;
    }
    this.Xfb = bool;
    ca localca;
    if (this.Xfb)
    {
      this.Xfa.iuE = cn.bDw();
      localca = this.Xfa;
      localca.iuS = localca.F("InitUrl", paramBundle.replace(",", "!"), true);
      paramBundle = getIntent().getStringExtra("key_search_query");
      if (paramBundle != null) {
        break label177;
      }
    }
    label177:
    for (paramBundle = "";; paramBundle = paramBundle.replace(",", "!"))
    {
      localca = this.Xfa;
      localca.iuQ = localca.F("Query", paramBundle, true);
      AppMethodBeat.o(80774);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80775);
    this.sMP.removeJavascriptInterface("SosJSApi");
    this.Wzl.b(this.Xfe);
    this.Wzl.b(this.Xfe.Xfg);
    if (this.Xfb)
    {
      this.Xfa.iuR = getActivityBrowseTimeMs();
      this.Xfa.iuT = this.Xfc;
      this.Xfa.bMH();
      Log.i("MicroMsg.WebSearch.SosWebViewUI", "FTSRelatedSugH5ReportStruct.report url : %s, enterTime : %d, stayTime : %d, getQuery : %s ,id : %d, pageChangeCount : %d.", new Object[] { this.Xfa.iuS, Long.valueOf(this.Xfa.iuE), Long.valueOf(this.Xfa.iuR), this.Xfa.iuQ, Integer.valueOf(22251), Integer.valueOf(this.Xfc) });
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
    extends m
  {
    a Xfg;
    
    a()
    {
      AppMethodBeat.i(296896);
      this.Xfg = new a();
      AppMethodBeat.o(296896);
    }
    
    final class a
      extends h
    {
      a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(296842);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramString2)))
        {
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedError %d %s", new Object[] { Integer.valueOf(paramInt), paramString1 });
          SosWebViewUI.a(SosWebViewUI.this, paramInt);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(296842);
      }
      
      public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
      {
        AppMethodBeat.i(296846);
        super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramWebResourceRequest.getUrl().toString())))
        {
          SosWebViewUI.a(SosWebViewUI.this, paramWebResourceResponse.mStatusCode);
          if ((SosWebViewUI.e(SosWebViewUI.this) < 400) || (SosWebViewUI.e(SosWebViewUI.this) >= 600))
          {
            Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError not report %s %d", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)) });
            AppMethodBeat.o(296846);
            return;
          }
        }
        try
        {
          paramWebView = new String(e.readFromStream(paramWebResourceResponse.mInputStream));
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError %s %d %s", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)), paramWebView });
          SosWebViewUI.b(SosWebViewUI.this, paramWebView);
          AppMethodBeat.o(296846);
          return;
        }
        finally
        {
          for (;;)
          {
            paramWebView = "";
          }
        }
      }
      
      public final void a(WebView paramWebView, t paramt, SslError paramSslError)
      {
        AppMethodBeat.i(296852);
        super.a(paramWebView, paramt, paramSslError);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramSslError.getUrl())))
        {
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedSslError");
          SosWebViewUI.a(SosWebViewUI.this, -1);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(296852);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296837);
        super.b(paramWebView, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        if (!SosWebViewUI.c(SosWebViewUI.this)) {
          SosWebViewUI.b(SosWebViewUI.this).sendEmptyMessageDelayed(0, 1000L);
        }
        AppMethodBeat.o(296837);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(296834);
        SosWebViewUI.a(SosWebViewUI.this, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        AppMethodBeat.o(296834);
      }
    }
  }
  
  static final class b
  {
    WeakReference<SosWebViewUI> Xfi;
    
    public b(SosWebViewUI paramSosWebViewUI)
    {
      AppMethodBeat.i(296899);
      this.Xfi = null;
      this.Xfi = new WeakReference(paramSosWebViewUI);
      AppMethodBeat.o(296899);
    }
    
    @JavascriptInterface
    public final void onHtmlContentReport(String paramString)
    {
      AppMethodBeat.i(80772);
      if (this.Xfi == null)
      {
        Log.i("MicroMsg.WebSearch.SosWebViewUI", "onHtmlContentReport webViewUIWeakReference is null.");
        AppMethodBeat.o(80772);
        return;
      }
      SosWebViewUI localSosWebViewUI = (SosWebViewUI)this.Xfi.get();
      if (localSosWebViewUI != null)
      {
        SosWebViewUI.b(localSosWebViewUI, paramString);
        AppMethodBeat.o(80772);
        return;
      }
      Log.i("MicroMsg.WebSearch.SosWebViewUI", "onHtmlContentReport tmpSosWebViewUI is null.");
      AppMethodBeat.o(80772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.SosWebViewUI
 * JD-Core Version:    0.7.0.1
 */