package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;

final class FTSBaseWebViewUI$b
  extends PreLoadWebViewUI.a
{
  private FTSBaseWebViewUI$b(FTSBaseWebViewUI paramFTSBaseWebViewUI)
  {
    super(paramFTSBaseWebViewUI);
  }
  
  private static s aiH(String paramString)
  {
    AppMethodBeat.i(8403);
    ab.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = e.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new s("image/*", "utf8", paramString);
        AppMethodBeat.o(8403);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(8403);
    }
    return null;
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(8401);
    if ((paramr != null) && (paramr.getUrl() != null) && (paramr.getUrl().toString().startsWith("weixin://fts")))
    {
      s locals = aiH(paramr.getUrl().toString());
      if (locals != null)
      {
        AppMethodBeat.o(8401);
        return locals;
      }
    }
    paramWebView = super.a(paramWebView, paramr);
    AppMethodBeat.o(8401);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(8400);
    if ((paramr != null) && (paramr.getUrl() != null) && (paramr.getUrl().toString().startsWith("weixin://fts")))
    {
      paramBundle = aiH(paramr.getUrl().toString());
      if (paramBundle != null)
      {
        AppMethodBeat.o(8400);
        return paramBundle;
      }
    }
    paramWebView = super.a(paramWebView, paramr);
    AppMethodBeat.o(8400);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(8404);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if ((paramString2 != null) && (paramString2.equals(this.vkg.cJr))) {
      an.reportIdKey649ForLook(FTSBaseWebViewUI.a(this.vkg), 16);
    }
    AppMethodBeat.o(8404);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8398);
    super.b(paramWebView, paramString);
    ab.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
    this.vkg.showOptionMenu(false);
    if ((FTSBaseWebViewUI.c(this.vkg) != null) && (!FTSBaseWebViewUI.d(this.vkg)))
    {
      FTSBaseWebViewUI.c(this.vkg).getFtsEditText().naN.clearFocus();
      this.vkg.hideVKB();
    }
    AppMethodBeat.o(8398);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(8399);
    super.b(paramWebView, paramString, paramBitmap);
    ab.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
    this.vkg.showOptionMenu(false);
    if ((FTSBaseWebViewUI.c(this.vkg) != null) && (!FTSBaseWebViewUI.d(this.vkg)))
    {
      FTSBaseWebViewUI.c(this.vkg).getFtsEditText().naN.clearFocus();
      this.vkg.hideVKB();
    }
    an.reportIdKey649ForLook(FTSBaseWebViewUI.a(this.vkg), 1);
    an.gF(FTSBaseWebViewUI.a(this.vkg), 1);
    AppMethodBeat.o(8399);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8402);
    if (paramString.startsWith("weixin://fts"))
    {
      s locals = aiH(paramString);
      if (locals != null)
      {
        AppMethodBeat.o(8402);
        return locals;
      }
    }
    paramWebView = super.c(paramWebView, paramString);
    AppMethodBeat.o(8402);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */