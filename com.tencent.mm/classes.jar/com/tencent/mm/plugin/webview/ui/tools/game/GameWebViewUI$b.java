package com.tencent.mm.plugin.webview.ui.tools.game;

import android.webkit.ConsoleMessage;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class GameWebViewUI$b
  extends WebViewUI.h
{
  protected GameWebViewUI$b(GameWebViewUI paramGameWebViewUI)
  {
    super(paramGameWebViewUI);
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null) {}
    for (String str = paramConsoleMessage.message(); (!bk.bl(str)) && (str.equalsIgnoreCase("weixin://whiteScreenEnd")); str = null)
    {
      y.d("MicroMsg.Wepkg.GameWebViewUI", "whiteScreenEnd");
      if (GameWebViewUI.F(this.rwB) != null) {
        GameWebViewUI.F(this.rwB).rNX = true;
      }
      return true;
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */