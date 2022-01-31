package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.booter.y.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.be;

final class k$4
  implements Runnable
{
  k$4(k paramk, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(31347);
    if (this.zFp == 2) {}
    for (int i = n.nv(this.zFo.caz.getTalkerUserName());; i = 0)
    {
      aw.aaz();
      Object localObject = c.YF().arH(this.zFo.caz.getTalkerUserName());
      if (localObject == null) {}
      for (int j = 0;; j = ((au)localObject).field_unReadCount)
      {
        localObject = com.tencent.mm.booter.y.dZP;
        String str = this.zFo.caz.getTalkerUserName();
        int k = this.zFp;
        int m = this.zFq;
        if (((com.tencent.mm.booter.y)localObject).dZZ == null) {
          ((com.tencent.mm.booter.y)localObject).dZZ = r.Zn();
        }
        if (!((com.tencent.mm.booter.y)localObject).dZZ.equals(str))
        {
          if (((com.tencent.mm.booter.y)localObject).dZT != null)
          {
            ab.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[] { ((com.tencent.mm.booter.y)localObject).dZT.eag });
            ((com.tencent.mm.booter.y)localObject).kA(((com.tencent.mm.booter.y)localObject).dZT.eag);
          }
          if (((com.tencent.mm.booter.y)localObject).dZQ.Nr(6) == 0) {
            ((com.tencent.mm.booter.y)localObject).dZQ.setLong(4, ah.aox());
          }
          com.tencent.mm.sdk.b.a.ymk.b(((com.tencent.mm.booter.y)localObject).dZR);
          com.tencent.mm.sdk.b.a.ymk.b(((com.tencent.mm.booter.y)localObject).dZS);
          ((com.tencent.mm.booter.y)localObject).appForegroundListener.alive();
          ((com.tencent.mm.booter.y)localObject).dZT = new y.a((com.tencent.mm.booter.y)localObject);
          ((com.tencent.mm.booter.y)localObject).dZT.eal = ((com.tencent.mm.booter.y)localObject).dZU;
          ((com.tencent.mm.booter.y)localObject).dZU = 0;
          ((com.tencent.mm.booter.y)localObject).dZT.eag = str;
          ((com.tencent.mm.booter.y)localObject).dZX = ah.yB();
          ((com.tencent.mm.booter.y)localObject).dZT.type = k;
          ((com.tencent.mm.booter.y)localObject).dZT.eah = m;
          ((com.tencent.mm.booter.y)localObject).dZT.cmy = j;
          ((com.tencent.mm.booter.y)localObject).dZT.eai = i;
          ((com.tencent.mm.booter.y)localObject).dZT.eaj = ah.aox();
          ab.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i) });
        }
        AppMethodBeat.o(31347);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k.4
 * JD-Core Version:    0.7.0.1
 */