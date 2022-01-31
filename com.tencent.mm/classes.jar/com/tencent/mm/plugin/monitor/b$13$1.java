package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$13$1
  implements a
{
  b$13$1(b.13 param13) {}
  
  public final void a(int paramInt, a.a parama)
  {
    b.a(this.msv.msl, System.currentTimeMillis());
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(b.l(this.msv.msl)), b.o(this.msv.msl), parama });
    b.a(this.msv.msl, null);
    if ((paramInt == 0) && (!parama.esC))
    {
      g.DQ();
      g.DP().Dz().c(ac.a.uue, Long.valueOf(b.l(this.msv.msl)));
      g.DQ();
      g.DP().Dz().mC(false);
    }
    try
    {
      b.b(this.msv.msl, parama);
      return;
    }
    catch (Exception parama)
    {
      y.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", parama, "doReportSDInfo err!", new Object[0]);
      h.nFQ.a(418L, 6L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.13.1
 * JD-Core Version:    0.7.0.1
 */