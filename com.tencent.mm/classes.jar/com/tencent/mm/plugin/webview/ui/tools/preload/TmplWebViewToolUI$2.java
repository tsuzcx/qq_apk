package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;

final class TmplWebViewToolUI$2
  extends WebViewUI.i
{
  TmplWebViewToolUI$2(TmplWebViewToolUI paramTmplWebViewToolUI)
  {
    super(paramTmplWebViewToolUI);
  }
  
  public final m a(WebView paramWebView, l paraml)
  {
    String str = paraml.getUrl().toString();
    y.v("MicroMsg.WebviewUIForTmpl", "shouldInterceptRequest url:%s isReady:%b", new Object[] { str, Boolean.valueOf(TmplWebViewToolUI.h(this.rBF).lgV) });
    if (str.equals(TmplWebViewToolUI.h(this.rBF).rfY)) {
      return TmplWebViewToolUI.h(this.rBF).getWebViewClient().a(paramWebView, paraml);
    }
    return super.a(paramWebView, paraml);
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    String str = paraml.getUrl().toString();
    y.v("MicroMsg.WebviewUIForTmpl", "shouldInterceptRequest url:%s isReady:%b", new Object[] { str, Boolean.valueOf(TmplWebViewToolUI.h(this.rBF).lgV) });
    if (str.equals(TmplWebViewToolUI.h(this.rBF).rfY)) {
      return TmplWebViewToolUI.h(this.rBF).getWebViewClient().a(paramWebView, paraml);
    }
    return super.a(paramWebView, paraml, paramBundle);
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.WebviewUIForTmpl", "onPageFinished url:%s isReady:%b", new Object[] { paramString, Boolean.valueOf(TmplWebViewToolUI.h(this.rBF).lgV) });
    if (paramString.equals(TmplWebViewToolUI.h(this.rBF).rfY))
    {
      TmplWebViewToolUI.h(this.rBF).getWebViewClient().a(paramWebView, paramString);
      return;
    }
    super.a(paramWebView, paramString);
  }
  
  public final void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.WebviewUIForTmpl", "doUpdateVisitedHistory url:%s", new Object[] { paramString, Boolean.valueOf(TmplWebViewToolUI.h(this.rBF).lgV) });
    if (paramString.equals(TmplWebViewToolUI.h(this.rBF).rfY)) {
      return;
    }
    super.a(paramWebView, paramString, paramBoolean);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    y.i("MicroMsg.WebviewUIForTmpl", "onPageStarted url:%s, isReady:%b", new Object[] { paramString, Boolean.valueOf(TmplWebViewToolUI.h(this.rBF).lgV) });
    if (paramString.equals(TmplWebViewToolUI.h(this.rBF).rfY))
    {
      TmplWebViewToolUI.h(this.rBF).getWebViewClient().b(paramWebView, paramString, paramBitmap);
      return;
    }
    if (TmplWebViewToolUI.i(this.rBF) != null)
    {
      TmplWebViewToolUI.j(this.rBF).rvc = false;
      TmplWebViewToolUI.a(this.rBF, new a.a());
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    y.v("MicroMsg.WebviewUIForTmpl", "shouldInterceptRequest url:%s isReady:%b", new Object[] { paramString, Boolean.valueOf(TmplWebViewToolUI.h(this.rBF).lgV) });
    if (paramString.equals(TmplWebViewToolUI.h(this.rBF).rfY)) {
      return TmplWebViewToolUI.h(this.rBF).getWebViewClient().c(paramWebView, paramString);
    }
    return super.c(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewToolUI.2
 * JD-Core Version:    0.7.0.1
 */