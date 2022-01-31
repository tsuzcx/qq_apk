package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class GameChattingRoomWebViewUI$2
  implements q.a
{
  GameChattingRoomWebViewUI$2(GameChattingRoomWebViewUI paramGameChattingRoomWebViewUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    paramString = new Intent();
    paramString.putExtra("rawUrl", GameChattingRoomWebViewUI.b(this.rvW));
    this.rvW.setResult(GameChattingRoomWebViewUI.c(this.rvW), paramString);
    this.rvW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */