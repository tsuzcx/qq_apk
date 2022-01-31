package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.a.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ab;

public class GameChattingRoomWebViewUI
  extends WebViewUI
{
  private String jumpUrl;
  private int vmi;
  private int vmj;
  final q.a vmk;
  final q.a vml;
  
  public GameChattingRoomWebViewUI()
  {
    AppMethodBeat.i(8645);
    this.jumpUrl = "";
    this.vmi = 4;
    this.vmj = 5;
    this.vmk = new GameChattingRoomWebViewUI.1(this);
    this.vml = new GameChattingRoomWebViewUI.2(this);
    AppMethodBeat.o(8645);
  }
  
  public final void ais(String paramString)
  {
    AppMethodBeat.i(8646);
    ab.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[] { paramString });
    this.jumpUrl = paramString;
    String str1 = getIntent().getStringExtra("action");
    if (str1 != null)
    {
      paramString = getIntent().getStringExtra("app_name");
      if (paramString == null) {}
      String str2;
      for (paramString = getString(2131296546);; paramString = getString(2131298498, new Object[] { paramString }))
      {
        str2 = getString(2131298505);
        if (!str1.equals("action_create")) {
          break;
        }
        a.a(this.mController, getString(2131298885), paramString, str2, this.vmk, this.vml);
        AppMethodBeat.o(8646);
        return;
      }
      if (str1.equals("action_join")) {
        a.a(this.mController, getString(2131300975), paramString, str2, this.vmk, this.vml);
      }
    }
    AppMethodBeat.o(8646);
  }
  
  public final boolean ait(String paramString)
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI
 * JD-Core Version:    0.7.0.1
 */