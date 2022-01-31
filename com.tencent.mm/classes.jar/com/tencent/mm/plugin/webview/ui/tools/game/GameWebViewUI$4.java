package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.ab;

final class GameWebViewUI$4
  implements Runnable
{
  GameWebViewUI$4(GameWebViewUI paramGameWebViewUI, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(8727);
    if ((this.vnt.isFinishing()) || (GameWebViewUI.C(this.vnt)))
    {
      ab.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
      AppMethodBeat.o(8727);
      return;
    }
    this.vnv.crd();
    AppMethodBeat.o(8727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */