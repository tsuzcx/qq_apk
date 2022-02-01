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
import com.tencent.mm.f.b.a.be;
import com.tencent.mm.model.cm;
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
import java.lang.ref.WeakReference;

public class SosWebViewUI
  extends WebViewUI
{
  private boolean QmH;
  private int QmI;
  private String QmJ;
  private be QmK;
  private boolean QmL;
  private int QmM;
  private MMHandler QmN;
  private a QmO;
  private int ptD;
  private int subType;
  
  public SosWebViewUI()
  {
    AppMethodBeat.i(80773);
    this.QmH = false;
    this.ptD = 0;
    this.subType = 0;
    this.QmI = 0;
    this.QmJ = "";
    this.QmK = new be();
    this.QmL = false;
    this.QmM = 0;
    this.QmN = new MMHandler(Looper.getMainLooper())
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
    this.QmO = new a();
    AppMethodBeat.o(80773);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(268324);
    super.b(paramWebView, paramString);
    if (this.QmL) {
      this.QmM += 1;
    }
    AppMethodBeat.o(268324);
  }
  
  public final i cDV()
  {
    AppMethodBeat.i(268325);
    i locali = super.cDV();
    if (locali != null) {
      locali.a(this.QmO);
    }
    AppMethodBeat.o(268325);
    return locali;
  }
  
  public final boolean cDX()
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
    this.pHS.addJavascriptInterface(new b(this), "SosJSApi");
    this.ptD = getIntent().getIntExtra("from_scence", 0);
    this.subType = getIntent().getIntExtra("subtype", 0);
    this.QmJ = getIntent().getStringExtra("rawUrl");
    paramBundle = getIntent().getStringExtra("key_init_url");
    if (paramBundle != null) {
      bool = true;
    }
    this.QmL = bool;
    be localbe;
    if (this.QmL)
    {
      this.QmK.glw = cm.bfE();
      localbe = this.QmK;
      localbe.glO = localbe.z("InitUrl", paramBundle.replace(",", "!"), true);
      paramBundle = getIntent().getStringExtra("key_search_query");
      if (paramBundle != null) {
        break label177;
      }
    }
    label177:
    for (paramBundle = "";; paramBundle = paramBundle.replace(",", "!"))
    {
      localbe = this.QmK;
      localbe.glM = localbe.z("Query", paramBundle, true);
      AppMethodBeat.o(80774);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80775);
    this.pHS.removeJavascriptInterface("SosJSApi");
    this.PIQ.b(this.QmO);
    this.PIQ.b(this.QmO.QmQ);
    if (this.QmL)
    {
      this.QmK.glN = getActivityBrowseTimeMs();
      this.QmK.glP = this.QmM;
      this.QmK.bpa();
      Log.i("MicroMsg.WebSearch.SosWebViewUI", "FTSRelatedSugH5ReportStruct.report url : %s, enterTime : %d, stayTime : %d, getQuery : %s ,id : %d, pageChangeCount : %d.", new Object[] { this.QmK.glO, Long.valueOf(this.QmK.glw), Long.valueOf(this.QmK.glN), this.QmK.glM, Integer.valueOf(22251), Integer.valueOf(this.QmM) });
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
    a QmQ;
    
    a()
    {
      AppMethodBeat.i(218657);
      this.QmQ = new a();
      AppMethodBeat.o(218657);
    }
    
    final class a
      extends f
    {
      a() {}
      
      public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
      {
        AppMethodBeat.i(264020);
        super.a(paramWebView, paramInt, paramString1, paramString2);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramString2)))
        {
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedError %d %s", new Object[] { Integer.valueOf(paramInt), paramString1 });
          SosWebViewUI.a(SosWebViewUI.this, paramInt);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(264020);
      }
      
      public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
      {
        AppMethodBeat.i(264022);
        super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramWebResourceRequest.getUrl().toString())))
        {
          SosWebViewUI.a(SosWebViewUI.this, paramWebResourceResponse.mStatusCode);
          if ((SosWebViewUI.e(SosWebViewUI.this) < 400) || (SosWebViewUI.e(SosWebViewUI.this) >= 600))
          {
            Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError not report %s %d", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)) });
            AppMethodBeat.o(264022);
            return;
          }
        }
        try
        {
          paramWebView = new String(e.readFromStream(paramWebResourceResponse.mInputStream));
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError %s %d %s", new Object[] { paramWebResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.e(SosWebViewUI.this)), paramWebView });
          SosWebViewUI.b(SosWebViewUI.this, paramWebView);
          AppMethodBeat.o(264022);
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
        AppMethodBeat.i(264023);
        super.a(paramWebView, paramr, paramSslError);
        if ((SosWebViewUI.d(SosWebViewUI.this) != null) && (SosWebViewUI.d(SosWebViewUI.this).equals(paramSslError.getUrl())))
        {
          Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedSslError");
          SosWebViewUI.a(SosWebViewUI.this, -1);
          SosWebViewUI.b(SosWebViewUI.this, "");
        }
        AppMethodBeat.o(264023);
      }
      
      public final void b(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(264019);
        super.b(paramWebView, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        if (!SosWebViewUI.c(SosWebViewUI.this)) {
          SosWebViewUI.b(SosWebViewUI.this).sendEmptyMessageDelayed(0, 1000L);
        }
        AppMethodBeat.o(264019);
      }
      
      public final void h(WebView paramWebView, String paramString)
      {
        AppMethodBeat.i(264018);
        SosWebViewUI.a(SosWebViewUI.this, paramString);
        SosWebViewUI.b(SosWebViewUI.this).removeMessages(0);
        AppMethodBeat.o(264018);
      }
    }
  }
  
  static final class b
  {
    WeakReference<SosWebViewUI> QmS;
    
    public b(SosWebViewUI paramSosWebViewUI)
    {
      AppMethodBeat.i(224785);
      this.QmS = null;
      this.QmS = new WeakReference(paramSosWebViewUI);
      AppMethodBeat.o(224785);
    }
    
    @JavascriptInterface
    public final void onHtmlContentReport(String paramString)
    {
      AppMethodBeat.i(80772);
      if (this.QmS == null)
      {
        Log.i("MicroMsg.WebSearch.SosWebViewUI", "onHtmlContentReport webViewUIWeakReference is null.");
        AppMethodBeat.o(80772);
        return;
      }
      SosWebViewUI localSosWebViewUI = (SosWebViewUI)this.QmS.get();
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