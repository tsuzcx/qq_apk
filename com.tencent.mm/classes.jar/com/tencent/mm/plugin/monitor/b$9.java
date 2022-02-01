package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.Log;

final class b$9
  implements Runnable
{
  b$9(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(193749);
    Log.i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", new Object[] { Boolean.valueOf(f.RAO), Boolean.valueOf(f.RAP) });
    h localh = h.IzE;
    if (f.RAO)
    {
      l = 100L;
      localh.idkeyStat(148L, l, 1L, true);
      localh = h.IzE;
      if (!f.RAP) {
        break label95;
      }
    }
    label95:
    for (long l = 102L;; l = 103L)
    {
      localh.idkeyStat(148L, l, 1L, true);
      AppMethodBeat.o(193749);
      return;
      l = 101L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.9
 * JD-Core Version:    0.7.0.1
 */