package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.y;

final class GameWebViewUI$5
  implements Runnable
{
  GameWebViewUI$5(GameWebViewUI paramGameWebViewUI, d paramd) {}
  
  public final void run()
  {
    if ((this.rwB.isFinishing()) || (GameWebViewUI.D(this.rwB)))
    {
      y.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
      return;
    }
    this.rwC.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */