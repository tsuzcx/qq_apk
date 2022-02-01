package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.ae;

final class b$8
  implements Runnable
{
  b$8(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(163487);
    ae.i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", new Object[] { Boolean.valueOf(f.FFQ), Boolean.valueOf(f.FFR) });
    g localg = g.yxI;
    if (f.FFQ)
    {
      l = 100L;
      localg.idkeyStat(148L, l, 1L, true);
      localg = g.yxI;
      if (!f.FFR) {
        break label95;
      }
    }
    label95:
    for (long l = 102L;; l = 103L)
    {
      localg.idkeyStat(148L, l, 1L, true);
      AppMethodBeat.o(163487);
      return;
      l = 101L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.8
 * JD-Core Version:    0.7.0.1
 */