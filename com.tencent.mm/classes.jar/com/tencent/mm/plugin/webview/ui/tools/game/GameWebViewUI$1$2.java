package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.ui.widget.MMWebView;

final class GameWebViewUI$1$2
  implements Runnable
{
  GameWebViewUI$1$2(GameWebViewUI.1 param1, boolean paramBoolean) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(8721);
    if (GameWebViewUI.d(this.vnu.vnt))
    {
      GameWebViewUI.a(this.vnu.vnt, false);
      GameWebViewUI.g(this.vnu.vnt);
      if (this.egM)
      {
        GameWebViewUI.h(this.vnu.vnt).stopLoading();
        c localc = GameWebViewUI.j(this.vnu.vnt);
        String str = this.vnu.gjT;
        if (!GameWebViewUI.i(this.vnu.vnt)) {
          bool = true;
        }
        localc.bV(str, bool);
        GameWebViewUI.a(this.vnu.vnt, this.vnu.gjT);
      }
    }
    AppMethodBeat.o(8721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.1.2
 * JD-Core Version:    0.7.0.1
 */