package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.ui.base.l;
import java.util.List;

final class GameWebViewUI$3
  implements b.b
{
  GameWebViewUI$3(GameWebViewUI paramGameWebViewUI) {}
  
  public final void a(l paraml)
  {
    h.nFQ.a(480L, 0L, 1L, false);
    l locall = GameWebViewUI.B(this.rwB);
    if (locall != null) {
      paraml.uWD.addAll(locall.uWD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */