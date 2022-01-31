package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.1;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class b$13$2
  implements Runnable
{
  b$13$2(b.13 param13, a parama) {}
  
  public final void run()
  {
    b.a(this.msv.msl, null);
    List localList = ((j)g.r(j.class)).Gb().bhS();
    if (bk.dk(localList)) {
      y.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
    }
    for (int i = 0;; i = localList.size())
    {
      y.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        h.nFQ.a(418L, 8L, 1L, true);
      }
      b.a(this.msv.msl, b.a(this.msv.msl, this.msw));
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.o(this.msv.msl) });
      return;
      e.post(new bd.1(localList), "checkUnfinishedDeleteMsgTask");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.13.2
 * JD-Core Version:    0.7.0.1
 */