package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.ab;

final class b$7
  implements Runnable
{
  b$7(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(84523);
    ab.i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", new Object[] { Boolean.valueOf(f.whQ), Boolean.valueOf(f.whR) });
    h localh = h.qsU;
    if (f.whQ)
    {
      l = 100L;
      localh.idkeyStat(148L, l, 1L, true);
      localh = h.qsU;
      if (!f.whR) {
        break label95;
      }
    }
    label95:
    for (long l = 102L;; l = 103L)
    {
      localh.idkeyStat(148L, l, 1L, true);
      AppMethodBeat.o(84523);
      return;
      l = 101L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.7
 * JD-Core Version:    0.7.0.1
 */