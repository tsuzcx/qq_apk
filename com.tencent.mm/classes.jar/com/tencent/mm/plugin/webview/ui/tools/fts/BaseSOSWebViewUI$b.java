package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.net.Uri;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.e;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;

final class BaseSOSWebViewUI$b
  extends j
{
  private BaseSOSWebViewUI$b(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  private static WebResourceResponse aDv(String paramString)
  {
    AppMethodBeat.i(188511);
    ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = com.tencent.mm.vfs.i.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new WebResourceResponse("image/*", "utf8", paramString);
        AppMethodBeat.o(188511);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(188511);
    }
    return null;
  }
  
  public final boolean aBb(String paramString)
  {
    AppMethodBeat.i(188507);
    if (this.CCB.Ckh)
    {
      AppMethodBeat.o(188507);
      return true;
    }
    boolean bool = super.aBb(paramString);
    AppMethodBeat.o(188507);
    return bool;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(188510);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
    {
      paramWebView = aDv(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(188510);
      return paramWebView;
    }
    AppMethodBeat.o(188510);
    return null;
  }
  
  public final e eza()
  {
    AppMethodBeat.i(188508);
    a locala = new a((byte)0);
    AppMethodBeat.o(188508);
    return locala;
  }
  
  public final com.tencent.mm.plugin.webview.core.i ezb()
  {
    AppMethodBeat.i(188509);
    b localb = new b((byte)0);
    AppMethodBeat.o(188509);
    return localb;
  }
  
  final class a
    extends e
  {
    private a() {}
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188504);
      ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(BaseSOSWebViewUI.b.this.CCB.scene), paramString });
      BaseSOSWebViewUI.b.this.CCB.showOptionMenu(false);
      if ((BaseSOSWebViewUI.b.this.CCB.CCu != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.b.this.CCB)))
      {
        BaseSOSWebViewUI.b.this.CCB.CCu.ty.clearFocus();
        BaseSOSWebViewUI.b.this.CCB.hideVKB();
      }
      AppMethodBeat.o(188504);
    }
    
    public final void m(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188505);
      ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onPageStarted %s", new Object[] { paramString });
      BaseSOSWebViewUI.b.this.CCB.showOptionMenu(false);
      if ((BaseSOSWebViewUI.b.this.CCB.CCu != null) && (!BaseSOSWebViewUI.a(BaseSOSWebViewUI.b.this.CCB)))
      {
        BaseSOSWebViewUI.b.this.CCB.CCu.ty.clearFocus();
        BaseSOSWebViewUI.b.this.CCB.hideVKB();
      }
      AppMethodBeat.o(188505);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.webview.core.i
  {
    private b() {}
    
    public final void bMF()
    {
      AppMethodBeat.i(188506);
      BaseSOSWebViewUI.b(BaseSOSWebViewUI.b.this.CCB);
      BaseSOSWebViewUI.b.this.CCB.eEU();
      AppMethodBeat.o(188506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */