package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<awk> rwG = new LinkedList();
  
  static
  {
    awk localawk = new awk();
    localawk.bGw = ae.getResources().getString(R.l.game_menu_share_to_friend);
    localawk.mQp = "game_menu_icon_share_to_friend";
    localawk.tta = 1;
    localawk.tsZ = 1;
    localawk.sYX = c.a.rwN.code;
    rwG.add(localawk);
    localawk = new awk();
    localawk.bGw = ae.getResources().getString(R.l.game_menu_exit);
    localawk.mQp = "game_menu_icon_exit";
    localawk.tta = 2;
    localawk.tsZ = 2;
    localawk.sYX = c.a.rwM.code;
    rwG.add(localawk);
    localawk = new awk();
    localawk.bGw = ae.getResources().getString(R.l.game_menu_refresh);
    localawk.mQp = "game_menu_icon_refresh";
    localawk.tta = 4;
    localawk.tsZ = 5;
    localawk.sYX = c.a.rwP.code;
    rwG.add(localawk);
    localawk = new awk();
    localawk.bGw = ae.getResources().getString(R.l.game_menu_collect);
    localawk.mQp = "game_menu_icon_collect";
    localawk.tta = 3;
    localawk.tsZ = 6;
    localawk.sYX = c.a.rwO.code;
    rwG.add(localawk);
    localawk = new awk();
    localawk.bGw = ae.getResources().getString(R.l.game_menu_complaint);
    localawk.mQp = "game_menu_icon_complaint";
    localawk.tta = 6;
    localawk.tsZ = 7;
    localawk.sYX = c.a.rwR.code;
    rwG.add(localawk);
    localawk = new awk();
    localawk.bGw = ae.getResources().getString(R.l.game_menu_add_to_desktop);
    localawk.mQp = "game_menu_icon_add_to_desktop";
    localawk.tta = 5;
    localawk.tsZ = 8;
    localawk.sYX = c.a.rwQ.code;
    rwG.add(localawk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */