package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;

final class y$6
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(207278);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qul, 1) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1378L, 1L, 1L, false);
        Object localObject = ag.aGf();
        ad.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
        ((x)localObject).hHS.execSQL("BizTimeLineInfo", "delete from BizTimeLineInfo");
        ad.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end");
        localObject = ag.aGg();
        ad.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
        ((z)localObject).hHS.execSQL("BizTimeLineSingleMsgInfo", "delete from BizTimeLineSingleMsgInfo");
        ad.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end");
      }
      AppMethodBeat.o(207278);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.y.6
 * JD-Core Version:    0.7.0.1
 */