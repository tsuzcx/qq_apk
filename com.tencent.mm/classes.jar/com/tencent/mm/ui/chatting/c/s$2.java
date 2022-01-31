package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.d;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;

final class s$2
  implements ap.a
{
  s$2(s params) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(31455);
    if (this.zGl.caz == null)
    {
      AppMethodBeat.o(31455);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.priority.a.a.a.a.caM();
    int i = this.zGl.caz.getFirstVisiblePosition();
    int m = this.zGl.caz.getHeaderViewsCount();
    int j = this.zGl.caz.getLastVisiblePosition();
    int k = this.zGl.caz.getHeaderViewsCount();
    h localh = (h)this.zGl.caz.ay(h.class);
    i = Math.max(i - m, 0);
    j = Math.max(Math.min(j - k, localh.getCount()), 0);
    ab.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
    if (j < i)
    {
      ab.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
      s.a(this.zGl).ag(1000L, 1000L);
      AppMethodBeat.o(31455);
      return false;
    }
    o.ahD().fDE = true;
    while (i <= j)
    {
      bi localbi = localh.Pz(i);
      if ((localbi != null) && (localbi.field_isSend == 0) && (localbi.dvX()))
      {
        e locale = o.ahC().gS(localbi.field_msgSvrId);
        if ((!locale.ahg()) && (localbi.dHb != 2)) {
          if (localbi.dHb != 1)
          {
            if (bool)
            {
              c.afT();
              if (!c.u(localbi)) {}
            }
          }
          else {
            ((b)com.tencent.mm.kernel.g.E(b.class)).a(localbi, new s.a(this.zGl, localbi, locale, i));
          }
        }
      }
      i += 1;
    }
    o.ahD().ahe();
    AppMethodBeat.o(31455);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.s.2
 * JD-Core Version:    0.7.0.1
 */