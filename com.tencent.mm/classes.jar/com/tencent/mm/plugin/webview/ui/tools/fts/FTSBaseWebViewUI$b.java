package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.net.Uri;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.core.e;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.sdk.platformtools.ac;
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
  
  private static WebResourceResponse aDv(String paramString)
  {
    AppMethodBeat.i(188524);
    ac.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = i.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new WebResourceResponse("image/*", "utf8", paramString);
        AppMethodBeat.o(188524);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(188524);
    }
    return null;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(188523);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
    {
      paramWebView = aDv(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(188523);
      return paramWebView;
    }
    AppMethodBeat.o(188523);
    return null;
  }
  
  public final e eza()
  {
    AppMethodBeat.i(188522);
    a locala = new a((byte)0);
    AppMethodBeat.o(188522);
    return locala;
  }
  
  final class a
    extends e
  {
    private a() {}
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(188521);
      if ((paramString2 != null) && (paramString2.equals(FTSBaseWebViewUI.b.this.CDb.bLL()))) {
        ai.iE(FTSBaseWebViewUI.a(FTSBaseWebViewUI.b.this.CDb), 16);
      }
      AppMethodBeat.o(188521);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188519);
      ac.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
      FTSBaseWebViewUI.b.this.CDb.showOptionMenu(false);
      if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.CDb) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.b.this.CDb)))
      {
        FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.CDb).getFtsEditText().ty.clearFocus();
        FTSBaseWebViewUI.b.this.CDb.hideVKB();
      }
      AppMethodBeat.o(188519);
    }
    
    public final void m(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188520);
      ac.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
      FTSBaseWebViewUI.b.this.CDb.showOptionMenu(false);
      if ((FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.CDb) != null) && (!FTSBaseWebViewUI.d(FTSBaseWebViewUI.b.this.CDb)))
      {
        FTSBaseWebViewUI.c(FTSBaseWebViewUI.b.this.CDb).getFtsEditText().ty.clearFocus();
        FTSBaseWebViewUI.b.this.CDb.hideVKB();
      }
      ai.iE(FTSBaseWebViewUI.a(FTSBaseWebViewUI.b.this.CDb), 1);
      ai.iF(FTSBaseWebViewUI.a(FTSBaseWebViewUI.b.this.CDb), 1);
      AppMethodBeat.o(188520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */