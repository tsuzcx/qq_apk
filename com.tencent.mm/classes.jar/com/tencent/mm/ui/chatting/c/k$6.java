package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.roomexpt.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.d.a;

final class k$6
  implements Runnable
{
  k$6(k paramk, String paramString) {}
  
  public final void run()
  {
    boolean bool2 = false;
    AppMethodBeat.i(31349);
    if (!bo.isNullOrNil(this.zFr))
    {
      k.a(this.zFo, u.ag(this.zFr, t.flc));
      ab.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[] { this.zFr, Integer.valueOf(k.a(this.zFo)), bo.nT(k.b(this.zFo)), Long.valueOf(k.b(this.zFo)) });
      boolean bool1 = bool2;
      if (this.zFo.caz.dJF())
      {
        bool1 = bool2;
        if (this.zFo.caz.txj.dqK == 0) {
          bool1 = true;
        }
      }
      ((d)g.E(d.class)).aK(this.zFr, bool1);
    }
    AppMethodBeat.o(31349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k.6
 * JD-Core Version:    0.7.0.1
 */