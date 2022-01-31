package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;

final class BaseSOSWebViewUI$b
  extends LoadDataWebviewUI.a
{
  private BaseSOSWebViewUI$b(BaseSOSWebViewUI paramBaseSOSWebViewUI)
  {
    super(paramBaseSOSWebViewUI);
  }
  
  private static s aiH(String paramString)
  {
    AppMethodBeat.i(8356);
    ab.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = e.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new s("image/*", "utf8", paramString);
        AppMethodBeat.o(8356);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(8356);
    }
    return null;
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(8354);
    if ((paramr != null) && (paramr.getUrl() != null) && (paramr.getUrl().toString().startsWith("weixin://fts")))
    {
      s locals = aiH(paramr.getUrl().toString());
      if (locals != null)
      {
        AppMethodBeat.o(8354);
        return locals;
      }
    }
    paramWebView = super.a(paramWebView, paramr);
    AppMethodBeat.o(8354);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(8353);
    if ((paramr != null) && (paramr.getUrl() != null) && (paramr.getUrl().toString().startsWith("weixin://fts")))
    {
      paramBundle = aiH(paramr.getUrl().toString());
      if (paramBundle != null)
      {
        AppMethodBeat.o(8353);
        return paramBundle;
      }
    }
    paramWebView = super.a(paramWebView, paramr);
    AppMethodBeat.o(8353);
    return paramWebView;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8351);
    super.b(paramWebView, paramString);
    ab.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(this.vjG.scene), paramString });
    this.vjG.showOptionMenu(false);
    if ((this.vjG.vjz != null) && (!BaseSOSWebViewUI.a(this.vjG)))
    {
      this.vjG.vjz.naN.clearFocus();
      this.vjG.hideVKB();
    }
    BaseSOSWebViewUI.b(this.vjG);
    this.vjG.dfx();
    AppMethodBeat.o(8351);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(8352);
    super.b(paramWebView, paramString, paramBitmap);
    ab.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onPageStarted %s", new Object[] { paramString });
    this.vjG.showOptionMenu(false);
    if ((this.vjG.vjz != null) && (!BaseSOSWebViewUI.a(this.vjG)))
    {
      this.vjG.vjz.naN.clearFocus();
      this.vjG.hideVKB();
    }
    AppMethodBeat.o(8352);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8355);
    if (paramString.startsWith("weixin://fts"))
    {
      s locals = aiH(paramString);
      if (locals != null)
      {
        AppMethodBeat.o(8355);
        return locals;
      }
    }
    paramWebView = super.c(paramWebView, paramString);
    AppMethodBeat.o(8355);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */