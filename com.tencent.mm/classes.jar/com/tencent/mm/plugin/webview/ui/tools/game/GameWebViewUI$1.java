package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.event.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class GameWebViewUI$1
  extends b
{
  GameWebViewUI$1(GameWebViewUI paramGameWebViewUI, String paramString) {}
  
  public final void bFx()
  {
    AppMethodBeat.i(8722);
    ab.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
    GameWebViewUI.a(this.vnt);
    if (GameWebViewUI.b(this.vnt)) {
      GameWebViewUI.c(this.vnt);
    }
    AppMethodBeat.o(8722);
  }
  
  public final void bFy()
  {
    AppMethodBeat.i(8723);
    if (!GameWebViewUI.d(this.vnt))
    {
      GameWebViewUI.a(this.vnt, true);
      GameWebViewUI.f(this.vnt).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(8720);
          if (GameWebViewUI.d(GameWebViewUI.1.this.vnt)) {
            GameWebViewUI.e(GameWebViewUI.1.this.vnt);
          }
          AppMethodBeat.o(8720);
        }
      }, 1000L);
    }
    AppMethodBeat.o(8723);
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(8724);
    GameWebViewUI.k(this.vnt).post(new GameWebViewUI.1.2(this, paramBoolean));
    AppMethodBeat.o(8724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */