package com.tencent.mm.plugin.monitor;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm == null) {}
    for (int i = -1;; i = paramm.getType())
    {
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        e.bwV();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.1
 * JD-Core Version:    0.7.0.1
 */