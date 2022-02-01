package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.Log;

final class c$8
  implements Runnable
{
  c$8(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(163487);
    Log.i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", new Object[] { Boolean.valueOf(f.Yxs), Boolean.valueOf(f.Yxt) });
    h localh = h.OAn;
    if (f.Yxs)
    {
      l = 100L;
      localh.idkeyStat(148L, l, 1L, true);
      localh = h.OAn;
      if (!f.Yxt) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.8
 * JD-Core Version:    0.7.0.1
 */