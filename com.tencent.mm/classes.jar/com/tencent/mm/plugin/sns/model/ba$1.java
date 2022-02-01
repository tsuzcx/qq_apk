package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class ba$1
  implements Runnable
{
  ba$1(ba paramba) {}
  
  public final void run()
  {
    AppMethodBeat.i(221346);
    label1055:
    label1070:
    label1073:
    label1076:
    for (;;)
    {
      int k;
      Object localObject2;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder3;
      int i;
      synchronized (this.znh)
      {
        Iterator localIterator2;
        Object localObject3;
        BitmapFactory.Options localOptions;
        int j;
        try
        {
          ad.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[] { Integer.valueOf(ba.aQu().size()) });
          k = q.dSO();
          Iterator localIterator1 = ba.aQu().keySet().iterator();
          if (!localIterator1.hasNext()) {
            break label1055;
          }
          localObject2 = (String)localIterator1.next();
          localObject2 = (ba.b)ba.aQu().get(localObject2);
          if ((localObject2 == null) || (!((ba.b)localObject2).uvK)) {
            continue;
          }
          if ((((ba.b)localObject2).zni == -1L) || (((ba.b)localObject2).znf == -1L) || (((ba.b)localObject2).startTime == -1L)) {
            continue;
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder2 = new StringBuilder();
          localStringBuilder3 = new StringBuilder();
          i = 0;
          localIterator2 = ((ba.b)localObject2).znl.iterator();
          if (localIterator2.hasNext())
          {
            localObject3 = (String)localIterator2.next();
            localObject3 = (ba.a)((ba.b)localObject2).znm.get(localObject3);
            if (localObject3 == null) {
              break label1073;
            }
            localOptions = com.tencent.mm.sdk.platformtools.g.aQc(((ba.a)localObject3).filePath);
            j = 0;
            i = 0;
            if (localOptions != null)
            {
              j = localOptions.outWidth;
              i = localOptions.outHeight;
            }
            localStringBuilder1.append(j).append("|");
            localStringBuilder2.append(i).append("|");
            localStringBuilder3.append(0).append("|");
            i = ((ba.a)localObject3).mediaType;
            break label1073;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11600, new Object[] { Integer.valueOf(((ba.b)localObject2).hDC), Long.valueOf(((ba.b)localObject2).znf), Long.valueOf(((ba.b)localObject2).zni), Integer.valueOf(((ba.b)localObject2).znj), Integer.valueOf(k), Long.valueOf(((ba.b)localObject2).znk), Long.valueOf(((ba.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          ad.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((ba.b)localObject2).hDC), Long.valueOf(((ba.b)localObject2).znf), Long.valueOf(((ba.b)localObject2).zni), Integer.valueOf(((ba.b)localObject2).znj), Integer.valueOf(k), Long.valueOf(((ba.b)localObject2).znk), Long.valueOf(((ba.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
          continue;
        }
        catch (Throwable localThrowable)
        {
          ad.e("MicroMsg.TimelineSmallPicStat", "reportAll failed, error : %s", new Object[] { localThrowable.getMessage() });
        }
        AppMethodBeat.o(221346);
        return;
        if (((ba.b)localObject2).startTime == -1L) {
          continue;
        }
        ((ba.b)localObject2).endTime = System.currentTimeMillis();
        ((ba.b)localObject2).zni = (((ba.b)localObject2).endTime - ((ba.b)localObject2).startTime);
        if (((ba.b)localObject2).hDC == ((ba.b)localObject2).znj)
        {
          ((ba.b)localObject2).znf = 1L;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder2 = new StringBuilder();
          localStringBuilder3 = new StringBuilder();
          i = 0;
          localIterator2 = ((ba.b)localObject2).znl.iterator();
          if (localIterator2.hasNext())
          {
            localObject3 = (String)localIterator2.next();
            localObject3 = (ba.a)((ba.b)localObject2).znm.get(localObject3);
            if (localObject3 == null) {
              break label1070;
            }
            localOptions = com.tencent.mm.sdk.platformtools.g.aQc(((ba.a)localObject3).filePath);
            j = 0;
            i = 0;
            if (localOptions != null)
            {
              j = localOptions.outWidth;
              i = localOptions.outHeight;
            }
            localStringBuilder1.append(j).append("|");
            localStringBuilder2.append(i).append("|");
            localStringBuilder3.append(0).append("|");
            i = ((ba.a)localObject3).mediaType;
            break label1076;
          }
        }
        else
        {
          ((ba.b)localObject2).znf = 2L;
        }
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11600, new Object[] { Integer.valueOf(((ba.b)localObject2).hDC), Long.valueOf(((ba.b)localObject2).znf), Long.valueOf(((ba.b)localObject2).zni), Integer.valueOf(((ba.b)localObject2).znj), Integer.valueOf(k), Long.valueOf(((ba.b)localObject2).znk), Long.valueOf(((ba.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
      ad.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", new Object[] { Integer.valueOf(((ba.b)localObject2).hDC), Long.valueOf(((ba.b)localObject2).znf), Long.valueOf(((ba.b)localObject2).zni), Integer.valueOf(((ba.b)localObject2).znj), Integer.valueOf(k), Long.valueOf(((ba.b)localObject2).znk), Long.valueOf(((ba.b)localObject2).startTime), localStringBuilder1.toString(), localStringBuilder2.toString(), localStringBuilder3.toString(), Integer.valueOf(i) });
      continue;
      ba.aQu().clear();
      ba.fmO().clear();
      continue;
      break label1076;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ba.1
 * JD-Core Version:    0.7.0.1
 */