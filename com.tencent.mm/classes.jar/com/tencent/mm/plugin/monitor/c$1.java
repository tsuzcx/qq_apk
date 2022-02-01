package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;

final class c$1
  implements com.tencent.mm.am.h
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(51500);
    if (paramp == null) {}
    for (int i = -1;; i = paramp.getType())
    {
      Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(51499);
            e.gNS();
            AppMethodBeat.o(51499);
          }
        });
      }
      AppMethodBeat.o(51500);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.1
 * JD-Core Version:    0.7.0.1
 */