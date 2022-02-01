package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<cxc> Qph;
  
  static
  {
    AppMethodBeat.i(80956);
    Qph = new LinkedList();
    cxc localcxc = new cxc();
    localcxc.fwr = MMApplicationContext.getResources().getString(c.i.game_menu_share_to_friend);
    localcxc.ThumbUrl = "game_menu_icon_share_to_friend";
    localcxc.TFG = 1;
    localcxc.TFF = 1;
    localcxc.RXp = c.a.Qpo.code;
    Qph.add(localcxc);
    localcxc = new cxc();
    localcxc.fwr = MMApplicationContext.getResources().getString(c.i.game_menu_exit);
    localcxc.ThumbUrl = "game_menu_icon_exit";
    localcxc.TFG = 2;
    localcxc.TFF = 2;
    localcxc.RXp = c.a.Qpn.code;
    Qph.add(localcxc);
    localcxc = new cxc();
    localcxc.fwr = MMApplicationContext.getResources().getString(c.i.game_menu_refresh);
    localcxc.ThumbUrl = "game_menu_icon_refresh";
    localcxc.TFG = 4;
    localcxc.TFF = 5;
    localcxc.RXp = c.a.Qpq.code;
    Qph.add(localcxc);
    localcxc = new cxc();
    localcxc.fwr = MMApplicationContext.getResources().getString(c.i.game_menu_collect);
    localcxc.ThumbUrl = "game_menu_icon_collect";
    localcxc.TFG = 3;
    localcxc.TFF = 6;
    localcxc.RXp = c.a.Qpp.code;
    Qph.add(localcxc);
    localcxc = new cxc();
    localcxc.fwr = MMApplicationContext.getResources().getString(c.i.game_menu_complaint);
    localcxc.ThumbUrl = "game_menu_icon_complaint";
    localcxc.TFG = 6;
    localcxc.TFF = 7;
    localcxc.RXp = c.a.Qps.code;
    Qph.add(localcxc);
    localcxc = new cxc();
    localcxc.fwr = MMApplicationContext.getResources().getString(c.i.game_menu_add_to_desktop);
    localcxc.ThumbUrl = "game_menu_icon_add_to_desktop";
    localcxc.TFG = 5;
    localcxc.TFF = 8;
    localcxc.RXp = c.a.Qpr.code;
    Qph.add(localcxc);
    AppMethodBeat.o(80956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */