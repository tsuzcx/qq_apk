package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.net.Uri;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.e;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;

final class BaseSOSWebViewUI$b
  extends j
{
  private BaseSOSWebViewUI$b(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  private static WebResourceResponse aIW(String paramString)
  {
    AppMethodBeat.i(208161);
    ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = com.tencent.mm.vfs.i.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new WebResourceResponse("image/*", "utf8", paramString);
        AppMethodBeat.o(208161);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(208161);
    }
    return null;
  }
  
  public final boolean aGw(String paramString)
  {
    AppMethodBeat.i(208157);
    if (this.Egk.DNn)
    {
      AppMethodBeat.o(208157);
      return true;
    }
    boolean bool = super.aGw(paramString);
    AppMethodBeat.o(208157);
    return bool;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(208160);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
    {
      paramWebView = aIW(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(208160);
      return paramWebView;
    }
    AppMethodBeat.o(208160);
    return null;
  }
  
  public final e eNP()
  {
    AppMethodBeat.i(208158);
    a locala = new a((byte)0);
    AppMethodBeat.o(208158);
    return locala;
  }
  
  public final com.tencent.mm.plugin.webview.core.i eNQ()
  {
    AppMethodBeat.i(208159);
    b localb = new b((byte)0);
    AppMethodBeat.o(208159);
    return localb;
  }
  
  final class a
    extends e
  {
    private a() {}
    
    public final void aGk(String paramString)
    {
      AppMethodBeat.i(208155);
      ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onPageStarted %s", new Object[] { paramString });
      BaseSOSWebViewUI.b.this.Egk.showOptionMenu(false);
      if ((BaseSOSWebViewUI.b.this.Egk.Egb != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.b.this.Egk)))
      {
        BaseSOSWebViewUI.b.this.Egk.Egb.vr.clearFocus();
        BaseSOSWebViewUI.b.this.Egk.hideVKB();
      }
      AppMethodBeat.o(208155);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(208154);
      ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.b.this.Egk.scene), paramString });
      BaseSOSWebViewUI.b.this.Egk.showOptionMenu(false);
      if ((BaseSOSWebViewUI.b.this.Egk.Egb != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.b.this.Egk)))
      {
        BaseSOSWebViewUI.b.this.Egk.Egb.vr.clearFocus();
        BaseSOSWebViewUI.b.this.Egk.hideVKB();
      }
      AppMethodBeat.o(208154);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.webview.core.i
  {
    private b() {}
    
    public final void bRf()
    {
      AppMethodBeat.i(208156);
      BaseSOSWebViewUI.b(BaseSOSWebViewUI.b.this.Egk);
      BaseSOSWebViewUI.b.this.Egk.eTN();
      AppMethodBeat.o(208156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */