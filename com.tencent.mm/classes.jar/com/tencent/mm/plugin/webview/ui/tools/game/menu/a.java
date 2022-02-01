package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<doh> Xhv;
  
  static
  {
    AppMethodBeat.i(80956);
    Xhv = new LinkedList();
    doh localdoh = new doh();
    localdoh.hAP = MMApplicationContext.getResources().getString(c.i.game_menu_share_to_friend);
    localdoh.ThumbUrl = "game_menu_icon_share_to_friend";
    localdoh.aaVn = 1;
    localdoh.aaVm = 1;
    localdoh.YVh = c.a.XhC.code;
    Xhv.add(localdoh);
    localdoh = new doh();
    localdoh.hAP = MMApplicationContext.getResources().getString(c.i.game_menu_exit);
    localdoh.ThumbUrl = "game_menu_icon_exit";
    localdoh.aaVn = 2;
    localdoh.aaVm = 2;
    localdoh.YVh = c.a.XhB.code;
    Xhv.add(localdoh);
    localdoh = new doh();
    localdoh.hAP = MMApplicationContext.getResources().getString(c.i.game_menu_refresh);
    localdoh.ThumbUrl = "game_menu_icon_refresh";
    localdoh.aaVn = 4;
    localdoh.aaVm = 5;
    localdoh.YVh = c.a.XhE.code;
    Xhv.add(localdoh);
    localdoh = new doh();
    localdoh.hAP = MMApplicationContext.getResources().getString(c.i.game_menu_collect);
    localdoh.ThumbUrl = "game_menu_icon_collect";
    localdoh.aaVn = 3;
    localdoh.aaVm = 6;
    localdoh.YVh = c.a.XhD.code;
    Xhv.add(localdoh);
    localdoh = new doh();
    localdoh.hAP = MMApplicationContext.getResources().getString(c.i.game_menu_complaint);
    localdoh.ThumbUrl = "game_menu_icon_complaint";
    localdoh.aaVn = 6;
    localdoh.aaVm = 7;
    localdoh.YVh = c.a.XhG.code;
    Xhv.add(localdoh);
    localdoh = new doh();
    localdoh.hAP = MMApplicationContext.getResources().getString(c.i.game_menu_add_to_desktop);
    localdoh.ThumbUrl = "game_menu_icon_add_to_desktop";
    localdoh.aaVn = 5;
    localdoh.aaVm = 8;
    localdoh.YVh = c.a.XhF.code;
    Xhv.add(localdoh);
    AppMethodBeat.o(80956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */