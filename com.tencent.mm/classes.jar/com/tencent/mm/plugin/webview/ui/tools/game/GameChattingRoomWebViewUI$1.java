package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class GameChattingRoomWebViewUI$1
  implements q.a
{
  GameChattingRoomWebViewUI$1(GameChattingRoomWebViewUI paramGameChattingRoomWebViewUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(8643);
    this.vmm.setResult(GameChattingRoomWebViewUI.a(this.vmm), new Intent());
    this.vmm.finish();
    AppMethodBeat.o(8643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */