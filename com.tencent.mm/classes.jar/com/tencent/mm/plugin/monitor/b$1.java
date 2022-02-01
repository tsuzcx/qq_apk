package com.tencent.mm.plugin.monitor;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.sdk.platformtools.ad;

final class b$1
  implements g
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(51500);
    if (paramn == null) {}
    for (int i = -1;; i = paramn.getType())
    {
      ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        h.Iye.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(51499);
            e.dkL();
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
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.1
 * JD-Core Version:    0.7.0.1
 */