package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.ab;

final class GameWebViewUI$5
  implements Runnable
{
  GameWebViewUI$5(GameWebViewUI paramGameWebViewUI, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(8728);
    if ((this.vnt.isFinishing()) || (GameWebViewUI.D(this.vnt)))
    {
      ab.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
      AppMethodBeat.o(8728);
      return;
    }
    this.vnv.crd();
    AppMethodBeat.o(8728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */