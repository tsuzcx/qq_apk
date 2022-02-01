package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.net.Uri;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.webview.core.e;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;

final class FTSBaseWebViewUI$b
  extends j
{
  private FTSBaseWebViewUI$b(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  private static WebResourceResponse aIW(String paramString)
  {
    AppMethodBeat.i(208179);
    ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = i.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new WebResourceResponse("image/*", "utf8", paramString);
        AppMethodBeat.o(208179);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(208179);
    }
    return null;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(208178);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
    {
      paramWebView = aIW(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(208178);
      return paramWebView;
    }
    AppMethodBeat.o(208178);
    return null;
  }
  
  public final e eNP()
  {
    AppMethodBeat.i(208177);
    a locala = new a((byte)0);
    AppMethodBeat.o(208177);
    return locala;
  }
  
  final class a
    extends e
  {
    private a() {}
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(208176);
      if ((paramString2 != null) && (paramString2.equals(FTSBaseWebViewUI.b.this.EgM.bQm()))) {
        am.iR(FTSBaseWebViewUI.a(FTSBaseWebViewUI.b.this.EgM), 16);
      }
      AppMethodBeat.o(208176);
    }
    
    public final void aGk(String paramString)
    {
      AppMethodBeat.i(208175);
      ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
      FTSBaseWebViewUI.b.this.EgM.showOptionMenu(false);
      if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.EgM) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.b.this.EgM)))
      {
        FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.EgM).getFtsEditText().vr.clearFocus();
        FTSBaseWebViewUI.b.this.EgM.hideVKB();
      }
      am.iR(FTSBaseWebViewUI.a(FTSBaseWebViewUI.b.this.EgM), 1);
      am.iS(FTSBaseWebViewUI.a(FTSBaseWebViewUI.b.this.EgM), 1);
      AppMethodBeat.o(208175);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(208174);
      ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
      FTSBaseWebViewUI.b.this.EgM.showOptionMenu(false);
      if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.EgM) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.b.this.EgM)))
      {
        FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.EgM).getFtsEditText().vr.clearFocus();
        FTSBaseWebViewUI.b.this.EgM.hideVKB();
      }
      AppMethodBeat.o(208174);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */