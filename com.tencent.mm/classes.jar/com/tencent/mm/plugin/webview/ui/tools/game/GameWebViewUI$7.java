package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class GameWebViewUI$7
  implements Runnable
{
  GameWebViewUI$7(GameWebViewUI paramGameWebViewUI) {}
  
  public final void run()
  {
    if (GameWebViewUI.H(this.rwB) != null)
    {
      y.i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", new Object[] { GameWebViewUI.I(this.rwB) });
      GameWebViewUI.J(this.rwB).stopLoading();
      GameWebViewUI.L(this.rwB).loadUrl(GameWebViewUI.K(this.rwB));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */