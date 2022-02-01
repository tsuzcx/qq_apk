package com.tencent.mm.plugin.monitor;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.e;
import java.io.File;

final class b$6
  implements Runnable
{
  b$6(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(51505);
    for (;;)
    {
      long l7;
      long l8;
      long l9;
      long l10;
      long l11;
      int i;
      long l6;
      try
      {
        Object localObject1 = new e(ae.FfH + "SdcardInfo.cfg");
        Object localObject2 = h.vKh;
        if (((e)localObject1).exists())
        {
          l1 = 10L;
          ((h)localObject2).idkeyStat(340L, l1, 1L, true);
          boolean bool1 = bi.eGw();
          localObject2 = g.getDataDirectory().getPath();
          String str1 = g.getExternalStorageDirectory().getPath();
          Object localObject3 = new StatFs((String)localObject2);
          long l12 = ((StatFs)localObject3).getBlockSize();
          long l13 = ((StatFs)localObject3).getBlockCount();
          long l14 = ((StatFs)localObject3).getAvailableBlocks();
          long l15 = l12 * l13;
          long l16 = l12 * l14;
          if (l13 <= 0L) {
            break label1255;
          }
          k = Math.round((float)l14 * 100.0F / (float)l13);
          localObject3 = new StatFs(str1);
          l7 = ((StatFs)localObject3).getBlockSize();
          l8 = ((StatFs)localObject3).getBlockCount();
          l9 = ((StatFs)localObject3).getAvailableBlocks();
          l10 = l7 * l8;
          l11 = l7 * l9;
          i = -1;
          if (l8 > 0L) {
            i = Math.round((float)l9 * 100.0F / (float)l8);
          }
          boolean bool2 = com.tencent.mm.loader.j.b.aib().equals(str1);
          if (bool2) {
            break label1230;
          }
          localObject3 = new StatFs(com.tencent.mm.loader.j.b.aib());
          l5 = ((StatFs)localObject3).getBlockSize();
          l4 = ((StatFs)localObject3).getBlockCount();
          l2 = ((StatFs)localObject3).getAvailableBlocks();
          l6 = l5 * l4;
          l1 = l5 * l2;
          if (l4 <= 0L) {
            break label1217;
          }
          j = Math.round((float)l2 * 100.0F / (float)l4);
          l3 = l2;
          l2 = l6;
          localObject3 = bi.aFO(com.tencent.mm.loader.j.b.aib());
          String str2 = bi.aFO((String)localObject2);
          Object localObject4 = com.tencent.mm.loader.j.b.aib();
          if (((e)localObject1).exists())
          {
            m = 1;
            ad.i("MicroMsg.SubCoreBaseMonitor", "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]", new Object[] { localObject2, str1, localObject4, localObject3, Boolean.valueOf(bool1), Long.valueOf(l12), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Integer.valueOf(k), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Integer.valueOf(i), Boolean.valueOf(bool2), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(m), str2 });
            h.vKh.idkeyStat(340L, 0L, 1L, true);
            localObject4 = h.vKh;
            if (!bool1) {
              continue;
            }
            l6 = 1L;
            ((h)localObject4).idkeyStat(340L, l6, 1L, true);
            localObject4 = h.vKh;
            if (!bool2) {
              continue;
            }
            l6 = 3L;
            ((h)localObject4).idkeyStat(340L, l6, 1L, true);
            localObject4 = h.vKh;
            String str3 = com.tencent.mm.loader.j.b.aib();
            if (!bool1) {
              continue;
            }
            m = 1;
            if (!bool2) {
              continue;
            }
            n = 1;
            if (!((e)localObject1).exists()) {
              continue;
            }
            i1 = 1;
            ((h)localObject4).f(11098, new Object[] { Integer.valueOf(5000), String.format("%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s", new Object[] { localObject2, str1, str3, localObject3, Integer.valueOf(m), Long.valueOf(l12), Long.valueOf(l13), Long.valueOf(l14), Long.valueOf(l15), Long.valueOf(l16), Integer.valueOf(k), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Long.valueOf(l11), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l5), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(i1), str2 }) });
            h.vKh.f(11098, new Object[] { Integer.valueOf(5001), (String)localObject2 + ";" + str2 });
            h.vKh.f(11098, new Object[] { Integer.valueOf(5002), com.tencent.mm.loader.j.b.aib() + ";" + (String)localObject3 });
            localObject2 = h.vKh;
            if (!((e)localObject1).exists()) {
              continue;
            }
            i = 1;
            ((h)localObject2).f(11098, new Object[] { Integer.valueOf(5003), Integer.valueOf(i) });
            localObject1 = h.vKh;
            if (!bool1) {
              continue;
            }
            i = 1;
            ((h)localObject1).f(11098, new Object[] { Integer.valueOf(5004), Integer.valueOf(i) });
            h.vKh.idkeyStat(340L, 7L, 1L, true);
            AppMethodBeat.o(51505);
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
        j = i;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", localException, "reportSDStatus err!", new Object[0]);
        h.vKh.idkeyStat(340L, 8L, 1L, true);
        AppMethodBeat.o(51505);
        return;
      }
      label1217:
      long l3 = l2;
      long l2 = l6;
      continue;
      label1230:
      int j = i;
      long l1 = l11;
      l2 = l10;
      l3 = l9;
      long l4 = l8;
      long l5 = l7;
      continue;
      label1255:
      int k = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.6
 * JD-Core Version:    0.7.0.1
 */