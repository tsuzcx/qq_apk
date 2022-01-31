package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;

final class GameWebViewUI$c
  extends GameBaseWebViewUI.a
{
  private GameWebViewUI$c(GameWebViewUI paramGameWebViewUI)
  {
    super(paramGameWebViewUI);
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(8738);
    if ((paramr == null) || (paramr.getUrl() == null))
    {
      paramWebView = super.a(paramWebView, paramr);
      AppMethodBeat.o(8738);
      return paramWebView;
    }
    s locals = GameWebViewUI.j(this.vnt).akj(paramr.getUrl().toString());
    if (locals != null)
    {
      AppMethodBeat.o(8738);
      return locals;
    }
    paramWebView = super.a(paramWebView, paramr);
    AppMethodBeat.o(8738);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(8739);
    if ((paramr == null) || (paramr.getUrl() == null))
    {
      paramWebView = super.a(paramWebView, paramr);
      AppMethodBeat.o(8739);
      return paramWebView;
    }
    s locals = GameWebViewUI.j(this.vnt).akj(paramr.getUrl().toString());
    if (locals != null)
    {
      AppMethodBeat.o(8739);
      return locals;
    }
    paramWebView = super.a(paramWebView, paramr, paramBundle);
    AppMethodBeat.o(8739);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(8736);
    GameWebViewUI.G(this.vnt);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    AppMethodBeat.o(8736);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8735);
    if (GameWebViewUI.E(this.vnt).eAm == 0L) {
      GameWebViewUI.E(this.vnt).eAm = System.currentTimeMillis();
    }
    if (GameWebViewUI.F(this.vnt).vmZ == 0L) {
      GameWebViewUI.F(this.vnt).vmZ = System.currentTimeMillis();
    }
    GameWebViewUI.G(this.vnt);
    GameWebViewUI.j(this.vnt).l(paramWebView, paramString);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(8735);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(8734);
    if (GameWebViewUI.E(this.vnt).eAl == 0L) {
      GameWebViewUI.E(this.vnt).eAl = System.currentTimeMillis();
    }
    if (GameWebViewUI.F(this.vnt).vmY == 0L) {
      GameWebViewUI.F(this.vnt).vmY = System.currentTimeMillis();
    }
    GameWebViewUI.j(this.vnt).k(paramWebView, paramString);
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(8734);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(8737);
    s locals = GameWebViewUI.j(this.vnt).akj(paramString);
    if (locals != null)
    {
      AppMethodBeat.o(8737);
      return locals;
    }
    paramWebView = super.c(paramWebView, paramString);
    AppMethodBeat.o(8737);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.c
 * JD-Core Version:    0.7.0.1
 */