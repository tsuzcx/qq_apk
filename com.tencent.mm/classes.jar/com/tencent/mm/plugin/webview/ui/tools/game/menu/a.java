package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final List<coq> JrL;
  
  static
  {
    AppMethodBeat.i(80956);
    JrL = new LinkedList();
    coq localcoq = new coq();
    localcoq.Title = MMApplicationContext.getResources().getString(2131761279);
    localcoq.ThumbUrl = "game_menu_icon_share_to_friend";
    localcoq.MuP = 1;
    localcoq.MuO = 1;
    localcoq.KWb = c.a.JrR.code;
    JrL.add(localcoq);
    localcoq = new coq();
    localcoq.Title = MMApplicationContext.getResources().getString(2131761277);
    localcoq.ThumbUrl = "game_menu_icon_exit";
    localcoq.MuP = 2;
    localcoq.MuO = 2;
    localcoq.KWb = c.a.JrQ.code;
    JrL.add(localcoq);
    localcoq = new coq();
    localcoq.Title = MMApplicationContext.getResources().getString(2131761278);
    localcoq.ThumbUrl = "game_menu_icon_refresh";
    localcoq.MuP = 4;
    localcoq.MuO = 5;
    localcoq.KWb = c.a.JrT.code;
    JrL.add(localcoq);
    localcoq = new coq();
    localcoq.Title = MMApplicationContext.getResources().getString(2131761275);
    localcoq.ThumbUrl = "game_menu_icon_collect";
    localcoq.MuP = 3;
    localcoq.MuO = 6;
    localcoq.KWb = c.a.JrS.code;
    JrL.add(localcoq);
    localcoq = new coq();
    localcoq.Title = MMApplicationContext.getResources().getString(2131761276);
    localcoq.ThumbUrl = "game_menu_icon_complaint";
    localcoq.MuP = 6;
    localcoq.MuO = 7;
    localcoq.KWb = c.a.JrV.code;
    JrL.add(localcoq);
    localcoq = new coq();
    localcoq.Title = MMApplicationContext.getResources().getString(2131761274);
    localcoq.ThumbUrl = "game_menu_icon_add_to_desktop";
    localcoq.MuP = 5;
    localcoq.MuO = 8;
    localcoq.KWb = c.a.JrU.code;
    JrL.add(localcoq);
    AppMethodBeat.o(80956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.a
 * JD-Core Version:    0.7.0.1
 */