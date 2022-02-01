package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.ac;

final class b$8
  implements Runnable
{
  b$8(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(163487);
    ac.i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", new Object[] { Boolean.valueOf(f.DIl), Boolean.valueOf(f.DIm) });
    h localh = h.wUl;
    if (f.DIl)
    {
      l = 100L;
      localh.idkeyStat(148L, l, 1L, true);
      localh = h.wUl;
      if (!f.DIm) {
        break label95;
      }
    }
    label95:
    for (long l = 102L;; l = 103L)
    {
      localh.idkeyStat(148L, l, 1L, true);
      AppMethodBeat.o(163487);
      return;
      l = 101L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.8
 * JD-Core Version:    0.7.0.1
 */