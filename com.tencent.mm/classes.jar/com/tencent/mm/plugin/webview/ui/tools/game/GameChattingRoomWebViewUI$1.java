package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class GameChattingRoomWebViewUI$1
  implements q.a
{
  GameChattingRoomWebViewUI$1(GameChattingRoomWebViewUI paramGameChattingRoomWebViewUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.rvW.setResult(GameChattingRoomWebViewUI.a(this.rvW), new Intent());
    this.rvW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */