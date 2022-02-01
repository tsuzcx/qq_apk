package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<bpp> Bok;
  
  static
  {
    AppMethodBeat.i(80956);
    Bok = new LinkedList();
    bpp localbpp = new bpp();
    localbpp.Title = aj.getResources().getString(2131759930);
    localbpp.ThumbUrl = "game_menu_icon_share_to_friend";
    localbpp.DOa = 1;
    localbpp.DNZ = 1;
    localbpp.CKO = c.a.Boq.code;
    Bok.add(localbpp);
    localbpp = new bpp();
    localbpp.Title = aj.getResources().getString(2131759928);
    localbpp.ThumbUrl = "game_menu_icon_exit";
    localbpp.DOa = 2;
    localbpp.DNZ = 2;
    localbpp.CKO = c.a.Bop.code;
    Bok.add(localbpp);
    localbpp = new bpp();
    localbpp.Title = aj.getResources().getString(2131759929);
    localbpp.ThumbUrl = "game_menu_icon_refresh";
    localbpp.DOa = 4;
    localbpp.DNZ = 5;
    localbpp.CKO = c.a.Bos.code;
    Bok.add(localbpp);
    localbpp = new bpp();
    localbpp.Title = aj.getResources().getString(2131759926);
    localbpp.ThumbUrl = "game_menu_icon_collect";
    localbpp.DOa = 3;
    localbpp.DNZ = 6;
    localbpp.CKO = c.a.Bor.code;
    Bok.add(localbpp);
    localbpp = new bpp();
    localbpp.Title = aj.getResources().getString(2131759927);
    localbpp.ThumbUrl = "game_menu_icon_complaint";
    localbpp.DOa = 6;
    localbpp.DNZ = 7;
    localbpp.CKO = c.a.Bou.code;
    Bok.add(localbpp);
    localbpp = new bpp();
    localbpp.Title = aj.getResources().getString(2131759925);
    localbpp.ThumbUrl = "game_menu_icon_add_to_desktop";
    localbpp.DOa = 5;
    localbpp.DNZ = 8;
    localbpp.CKO = c.a.Bot.code;
    Bok.add(localbpp);
    AppMethodBeat.o(80956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */