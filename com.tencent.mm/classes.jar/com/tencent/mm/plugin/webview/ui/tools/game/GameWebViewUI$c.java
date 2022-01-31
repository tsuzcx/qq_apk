package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

final class GameWebViewUI$c
  extends GameBaseWebViewUI.a
{
  private GameWebViewUI$c(GameWebViewUI paramGameWebViewUI)
  {
    super(paramGameWebViewUI);
  }
  
  public final m a(WebView paramWebView, l paraml)
  {
    Object localObject;
    if ((paraml == null) || (paraml.getUrl() == null)) {
      localObject = super.a(paramWebView, paraml);
    }
    m localm;
    do
    {
      return localObject;
      localm = GameWebViewUI.F(this.rwB).UP(paraml.getUrl().toString());
      localObject = localm;
    } while (localm != null);
    return super.a(paramWebView, paraml);
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    Object localObject;
    if ((paraml == null) || (paraml.getUrl() == null)) {
      localObject = super.a(paramWebView, paraml);
    }
    m localm;
    do
    {
      return localObject;
      localm = GameWebViewUI.F(this.rwB).UP(paraml.getUrl().toString());
      localObject = localm;
    } while (localm != null);
    return super.a(paramWebView, paraml, paramBundle);
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    GameWebViewUI.G(this.rwB);
    super.a(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    if (GameWebViewUI.E(this.rwB).dCR == 0L) {
      GameWebViewUI.E(this.rwB).dCR = System.currentTimeMillis();
    }
    GameWebViewUI.G(this.rwB);
    GameWebViewUI.F(this.rwB).h(paramWebView, paramString);
    super.a(paramWebView, paramString);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (GameWebViewUI.E(this.rwB).dCQ == 0L) {
      GameWebViewUI.E(this.rwB).dCQ = System.currentTimeMillis();
    }
    GameWebViewUI.F(this.rwB).g(paramWebView, paramString);
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    m localm = GameWebViewUI.F(this.rwB).UP(paramString);
    if (localm != null) {
      return localm;
    }
    return super.c(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.c
 * JD-Core Version:    0.7.0.1
 */