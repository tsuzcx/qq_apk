package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<bzp> ECh;
  
  static
  {
    AppMethodBeat.i(80956);
    ECh = new LinkedList();
    bzp localbzp = new bzp();
    localbzp.Title = ak.getResources().getString(2131759930);
    localbzp.ThumbUrl = "game_menu_icon_share_to_friend";
    localbzp.HnA = 1;
    localbzp.Hnz = 1;
    localbzp.GbY = c.a.ECn.code;
    ECh.add(localbzp);
    localbzp = new bzp();
    localbzp.Title = ak.getResources().getString(2131759928);
    localbzp.ThumbUrl = "game_menu_icon_exit";
    localbzp.HnA = 2;
    localbzp.Hnz = 2;
    localbzp.GbY = c.a.ECm.code;
    ECh.add(localbzp);
    localbzp = new bzp();
    localbzp.Title = ak.getResources().getString(2131759929);
    localbzp.ThumbUrl = "game_menu_icon_refresh";
    localbzp.HnA = 4;
    localbzp.Hnz = 5;
    localbzp.GbY = c.a.ECp.code;
    ECh.add(localbzp);
    localbzp = new bzp();
    localbzp.Title = ak.getResources().getString(2131759926);
    localbzp.ThumbUrl = "game_menu_icon_collect";
    localbzp.HnA = 3;
    localbzp.Hnz = 6;
    localbzp.GbY = c.a.ECo.code;
    ECh.add(localbzp);
    localbzp = new bzp();
    localbzp.Title = ak.getResources().getString(2131759927);
    localbzp.ThumbUrl = "game_menu_icon_complaint";
    localbzp.HnA = 6;
    localbzp.Hnz = 7;
    localbzp.GbY = c.a.ECr.code;
    ECh.add(localbzp);
    localbzp = new bzp();
    localbzp.Title = ak.getResources().getString(2131759925);
    localbzp.ThumbUrl = "game_menu_icon_add_to_desktop";
    localbzp.HnA = 5;
    localbzp.Hnz = 8;
    localbzp.GbY = c.a.ECq.code;
    ECh.add(localbzp);
    AppMethodBeat.o(80956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */