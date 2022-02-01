package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<bug> CGr;
  
  static
  {
    AppMethodBeat.i(80956);
    CGr = new LinkedList();
    bug localbug = new bug();
    localbug.Title = ai.getResources().getString(2131759930);
    localbug.ThumbUrl = "game_menu_icon_share_to_friend";
    localbug.Fkr = 1;
    localbug.Fkq = 1;
    localbug.Edq = c.a.CGx.code;
    CGr.add(localbug);
    localbug = new bug();
    localbug.Title = ai.getResources().getString(2131759928);
    localbug.ThumbUrl = "game_menu_icon_exit";
    localbug.Fkr = 2;
    localbug.Fkq = 2;
    localbug.Edq = c.a.CGw.code;
    CGr.add(localbug);
    localbug = new bug();
    localbug.Title = ai.getResources().getString(2131759929);
    localbug.ThumbUrl = "game_menu_icon_refresh";
    localbug.Fkr = 4;
    localbug.Fkq = 5;
    localbug.Edq = c.a.CGz.code;
    CGr.add(localbug);
    localbug = new bug();
    localbug.Title = ai.getResources().getString(2131759926);
    localbug.ThumbUrl = "game_menu_icon_collect";
    localbug.Fkr = 3;
    localbug.Fkq = 6;
    localbug.Edq = c.a.CGy.code;
    CGr.add(localbug);
    localbug = new bug();
    localbug.Title = ai.getResources().getString(2131759927);
    localbug.ThumbUrl = "game_menu_icon_complaint";
    localbug.Fkr = 6;
    localbug.Fkq = 7;
    localbug.Edq = c.a.CGB.code;
    CGr.add(localbug);
    localbug = new bug();
    localbug.Title = ai.getResources().getString(2131759925);
    localbug.ThumbUrl = "game_menu_icon_add_to_desktop";
    localbug.Fkr = 5;
    localbug.Fkq = 8;
    localbug.Edq = c.a.CGA.code;
    CGr.add(localbug);
    AppMethodBeat.o(80956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */