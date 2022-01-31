package com.tencent.mm.plugin.monitor;

import android.os.StatFs;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.io.File;

final class b$5
  implements Runnable
{
  b$5(b paramb) {}
  
  public final void run()
  {
    for (;;)
    {
      long l8;
      long l9;
      long l10;
      long l11;
      long l12;
      int i;
      long l6;
      try
      {
        Object localObject1 = new com.tencent.mm.vfs.b(ac.dOP + "SdcardInfo.cfg");
        Object localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
        if (((com.tencent.mm.vfs.b)localObject1).exists())
        {
          l1 = 10L;
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(340L, l1, 1L, true);
          boolean bool1 = az.crI();
          localObject2 = com.tencent.mm.compatible.util.h.getDataDirectory().getPath();
          String str1 = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getPath();
          Object localObject3 = new StatFs((String)localObject2);
          long l13 = ((StatFs)localObject3).getBlockSize();
          long l14 = ((StatFs)localObject3).getBlockCount();
          long l15 = ((StatFs)localObject3).getAvailableBlocks();
          long l16 = l13 * l14;
          long l17 = l13 * l15;
          if (l14 <= 0L) {
            break label1272;
          }
          k = Math.round((float)l15 * 100.0F / (float)l14);
          localObject3 = new StatFs(str1);
          l8 = ((StatFs)localObject3).getBlockSize();
          l9 = ((StatFs)localObject3).getBlockCount();
          l10 = ((StatFs)localObject3).getAvailableBlocks();
          l11 = l8 * l9;
          l12 = l8 * l10;
          i = -1;
          if (l9 > 0L) {
            i = Math.round((float)l10 * 100.0F / (float)l9);
          }
          boolean bool2 = e.bkF.equals(str1);
          if (bool2) {
            break label1247;
          }
          localObject3 = new StatFs(e.bkF);
          l1 = ((StatFs)localObject3).getBlockSize();
          l2 = ((StatFs)localObject3).getBlockCount();
          l3 = ((StatFs)localObject3).getAvailableBlocks();
          l5 = l1 * l2;
          l4 = l1 * l3;
          if (l2 <= 0L) {
            break label1218;
          }
          j = Math.round((float)l3 * 100.0F / (float)l2);
          l6 = l4;
          l7 = l5;
          l5 = l1;
          l4 = l2;
          l2 = l7;
          l1 = l6;
          localObject3 = az.Zw(e.bkF);
          String str2 = az.Zw((String)localObject2);
          Object localObject4 = e.bkF;
          if (((com.tencent.mm.vfs.b)localObject1).exists())
          {
            m = 1;
            y.i("MicroMsg.SubCoreBaseMonitor", "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]", new Object[] { localObject2, str1, localObject4, localObject3, Boolean.valueOf(bool1), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Integer.valueOf(k), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l12), Integer.valueOf(i), Boolean.valueOf(bool2), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(m), str2 });
            com.tencent.mm.plugin.report.service.h.nFQ.a(340L, 0L, 1L, true);
            localObject4 = com.tencent.mm.plugin.report.service.h.nFQ;
            if (!bool1) {
              continue;
            }
            l6 = 1L;
            ((com.tencent.mm.plugin.report.service.h)localObject4).a(340L, l6, 1L, true);
            localObject4 = com.tencent.mm.plugin.report.service.h.nFQ;
            if (!bool2) {
              continue;
            }
            l6 = 3L;
            ((com.tencent.mm.plugin.report.service.h)localObject4).a(340L, l6, 1L, true);
            localObject4 = com.tencent.mm.plugin.report.service.h.nFQ;
            String str3 = e.bkF;
            if (!bool1) {
              continue;
            }
            m = 1;
            if (!bool2) {
              continue;
            }
            n = 1;
            if (!((com.tencent.mm.vfs.b)localObject1).exists()) {
              continue;
            }
            i1 = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject4).f(11098, new Object[] { Integer.valueOf(5000), String.format("%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s", new Object[] { localObject2, str1, str3, localObject3, Integer.valueOf(m), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Long.valueOf(l17), Integer.valueOf(k), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Long.valueOf(l12), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(i1), str2 }) });
            com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(5001), (String)localObject2 + ";" + str2 });
            com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(5002), e.bkF + ";" + (String)localObject3 });
            localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
            if (!((com.tencent.mm.vfs.b)localObject1).exists()) {
              continue;
            }
            i = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject2).f(11098, new Object[] { Integer.valueOf(5003), Integer.valueOf(i) });
            localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
            if (!bool1) {
              continue;
            }
            i = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject1).f(11098, new Object[] { Integer.valueOf(5004), Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.h.nFQ.a(340L, 7L, 1L, true);
          }
        }
        else
        {
          l1 = 11L;
          continue;
        }
        int m = 0;
        continue;
        l6 = 2L;
        continue;
        l6 = 4L;
        continue;
        m = 0;
        continue;
        int n = 0;
        continue;
        int i1 = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        l6 = l2;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportSDStatus err!", new Object[0]);
        com.tencent.mm.plugin.report.service.h.nFQ.a(340L, 8L, 1L, true);
        return;
      }
      label1218:
      long l7 = l1;
      int j = i;
      long l1 = l4;
      long l2 = l5;
      long l4 = l6;
      long l5 = l7;
      continue;
      label1247:
      l1 = l12;
      l2 = l11;
      long l3 = l10;
      l4 = l9;
      l5 = l8;
      j = i;
      continue;
      label1272:
      int k = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.5
 * JD-Core Version:    0.7.0.1
 */