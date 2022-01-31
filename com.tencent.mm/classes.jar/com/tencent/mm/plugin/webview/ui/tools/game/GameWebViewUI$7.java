package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class GameWebViewUI$7
  implements Runnable
{
  GameWebViewUI$7(GameWebViewUI paramGameWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8730);
    if (GameWebViewUI.H(this.vnt) != null)
    {
      ab.i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", new Object[] { GameWebViewUI.I(this.vnt) });
      GameWebViewUI.J(this.vnt).stopLoading();
      GameWebViewUI.L(this.vnt).loadUrl(GameWebViewUI.K(this.vnt));
    }
    AppMethodBeat.o(8730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */