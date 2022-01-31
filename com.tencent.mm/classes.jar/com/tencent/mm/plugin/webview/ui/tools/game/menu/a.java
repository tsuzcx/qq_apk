package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<bcz> vnz;
  
  static
  {
    AppMethodBeat.i(8804);
    vnz = new LinkedList();
    bcz localbcz = new bcz();
    localbcz.Title = ah.getResources().getString(2131300417);
    localbcz.ThumbUrl = "game_menu_icon_share_to_friend";
    localbcz.xta = 1;
    localbcz.xsZ = 1;
    localbcz.wzE = c.a.vnG.code;
    vnz.add(localbcz);
    localbcz = new bcz();
    localbcz.Title = ah.getResources().getString(2131300415);
    localbcz.ThumbUrl = "game_menu_icon_exit";
    localbcz.xta = 2;
    localbcz.xsZ = 2;
    localbcz.wzE = c.a.vnF.code;
    vnz.add(localbcz);
    localbcz = new bcz();
    localbcz.Title = ah.getResources().getString(2131300416);
    localbcz.ThumbUrl = "game_menu_icon_refresh";
    localbcz.xta = 4;
    localbcz.xsZ = 5;
    localbcz.wzE = c.a.vnI.code;
    vnz.add(localbcz);
    localbcz = new bcz();
    localbcz.Title = ah.getResources().getString(2131300413);
    localbcz.ThumbUrl = "game_menu_icon_collect";
    localbcz.xta = 3;
    localbcz.xsZ = 6;
    localbcz.wzE = c.a.vnH.code;
    vnz.add(localbcz);
    localbcz = new bcz();
    localbcz.Title = ah.getResources().getString(2131300414);
    localbcz.ThumbUrl = "game_menu_icon_complaint";
    localbcz.xta = 6;
    localbcz.xsZ = 7;
    localbcz.wzE = c.a.vnK.code;
    vnz.add(localbcz);
    localbcz = new bcz();
    localbcz.Title = ah.getResources().getString(2131300412);
    localbcz.ThumbUrl = "game_menu_icon_add_to_desktop";
    localbcz.xta = 5;
    localbcz.xsZ = 8;
    localbcz.wzE = c.a.vnJ.code;
    vnz.add(localbcz);
    AppMethodBeat.o(8804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */