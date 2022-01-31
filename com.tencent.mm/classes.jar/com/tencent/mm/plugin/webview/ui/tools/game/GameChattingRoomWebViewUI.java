package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.y;

public class GameChattingRoomWebViewUI
  extends WebViewUI
{
  private String jumpUrl = "";
  private int rvS = 4;
  private int rvT = 5;
  final q.a rvU = new GameChattingRoomWebViewUI.1(this);
  final q.a rvV = new GameChattingRoomWebViewUI.2(this);
  
  protected final void Tp(String paramString)
  {
    y.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[] { paramString });
    this.jumpUrl = paramString;
    String str1 = getIntent().getStringExtra("action");
    String str2;
    if (str1 != null)
    {
      paramString = getIntent().getStringExtra("app_name");
      if (paramString != null) {
        break label99;
      }
      paramString = getString(R.l.app_back);
      str2 = getString(R.l.confirm_dialog_stay_in_weixin);
      if (!str1.equals("action_create")) {
        break label118;
      }
      g.a(this.mController, getString(R.l.created_chatroom), paramString, str2, this.rvU, this.rvV);
    }
    label99:
    label118:
    while (!str1.equals("action_join"))
    {
      return;
      paramString = getString(R.l.confirm_dialog_back_app, new Object[] { paramString });
      break;
    }
    g.a(this.mController, getString(R.l.joined_chatroom), paramString, str2, this.rvU, this.rvV);
  }
  
  protected final boolean Tq(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI
 * JD-Core Version:    0.7.0.1
 */