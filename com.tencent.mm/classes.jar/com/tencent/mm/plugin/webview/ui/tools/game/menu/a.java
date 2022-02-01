package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<byv> Ekd;
  
  static
  {
    AppMethodBeat.i(80956);
    Ekd = new LinkedList();
    byv localbyv = new byv();
    localbyv.Title = aj.getResources().getString(2131759930);
    localbyv.ThumbUrl = "game_menu_icon_share_to_friend";
    localbyv.GTZ = 1;
    localbyv.GTY = 1;
    localbyv.FJz = c.a.Ekj.code;
    Ekd.add(localbyv);
    localbyv = new byv();
    localbyv.Title = aj.getResources().getString(2131759928);
    localbyv.ThumbUrl = "game_menu_icon_exit";
    localbyv.GTZ = 2;
    localbyv.GTY = 2;
    localbyv.FJz = c.a.Eki.code;
    Ekd.add(localbyv);
    localbyv = new byv();
    localbyv.Title = aj.getResources().getString(2131759929);
    localbyv.ThumbUrl = "game_menu_icon_refresh";
    localbyv.GTZ = 4;
    localbyv.GTY = 5;
    localbyv.FJz = c.a.Ekl.code;
    Ekd.add(localbyv);
    localbyv = new byv();
    localbyv.Title = aj.getResources().getString(2131759926);
    localbyv.ThumbUrl = "game_menu_icon_collect";
    localbyv.GTZ = 3;
    localbyv.GTY = 6;
    localbyv.FJz = c.a.Ekk.code;
    Ekd.add(localbyv);
    localbyv = new byv();
    localbyv.Title = aj.getResources().getString(2131759927);
    localbyv.ThumbUrl = "game_menu_icon_complaint";
    localbyv.GTZ = 6;
    localbyv.GTY = 7;
    localbyv.FJz = c.a.Ekn.code;
    Ekd.add(localbyv);
    localbyv = new byv();
    localbyv.Title = aj.getResources().getString(2131759925);
    localbyv.ThumbUrl = "game_menu_icon_add_to_desktop";
    localbyv.GTZ = 5;
    localbyv.GTY = 8;
    localbyv.FJz = c.a.Ekm.code;
    Ekd.add(localbyv);
    AppMethodBeat.o(80956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */