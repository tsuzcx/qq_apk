package com.tencent.mm.plugin.music.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class c$4
  implements Runnable
{
  c$4(c paramc, String paramString, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void run()
  {
    AppMethodBeat.i(104819);
    label1163:
    for (;;)
    {
      synchronized (c.bFm())
      {
        ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear appId:%s", new Object[] { this.val$appId });
        int k = 0;
        Object localObject4 = c.Nt().entrySet().iterator();
        int i = 0;
        Object localObject1 = "";
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          localObject3 = (String)((Map.Entry)localObject5).getKey();
          k += ((Integer)((Map.Entry)localObject5).getValue()).intValue();
          if (((Integer)((Map.Entry)localObject5).getValue()).intValue() <= i) {
            break label1163;
          }
          i = ((Integer)((Map.Entry)localObject5).getValue()).intValue();
          localObject1 = localObject3;
          ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear real invoke audioKey:%s, lostCount:%s", new Object[] { localObject3, ((Map.Entry)localObject5).getValue() });
          continue;
        }
        c.Nt().clear();
        Object localObject5 = c.bFm().entrySet().iterator();
        int j = 0;
        Object localObject3 = "";
        int m = 0;
        Object localObject6;
        int n;
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          localObject4 = (String)((Map.Entry)localObject6).getKey();
          n = ((Integer)((Map.Entry)localObject6).getValue()).intValue();
          if (((Integer)((Map.Entry)localObject6).getValue()).intValue() > j)
          {
            j = ((Integer)((Map.Entry)localObject6).getValue()).intValue();
            localObject3 = localObject4;
            ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear audioKey:%s, lostCount:%s", new Object[] { localObject4, ((Map.Entry)localObject6).getValue() });
            m += n;
          }
        }
        else
        {
          c.bFm().clear();
          localObject4 = new c.b(this.oXO);
          localObject5 = new c.b(this.oXO);
          localObject6 = new c.b(this.oXO);
          c.a((c.b)localObject4, c.bUO());
          c.a((c.b)localObject5, c.bUP());
          c.a((c.b)localObject6, c.bUQ());
          c.bUO().clear();
          c.bUP().clear();
          c.bUQ().clear();
          ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear invokeTotalLostCount:%s, invokeMaxLostCount:%s, invokeMaxLostKey:%s, totalCostCount:%s, totalCostTime:%s, averageCostTime:%s, totalJsCostCount:%s, totalJSCostTime:%s, averageJSCostTime:%s,totalInvokeCostCount:%s, totalInvokeCostTime:%s, averageInvokeCostTime:%s,totalLostCount:%s, maxLostCount:%s, maxLostKey:%s, realInvokeTotalCount:%s, reachMaxPlayerCount:%s, audioPlayerType:%s, useQQAudioPlayerCount:%s, useAudioMixPlayerCount:%s, mixAverageTime:%s, maxCacheBufferSize:%s, realCacheBufferSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), localObject1, Integer.valueOf(((c.b)localObject4).oXZ), Long.valueOf(((c.b)localObject4).bCz), Long.valueOf(((c.b)localObject4).oYa), Integer.valueOf(((c.b)localObject5).oXZ), Long.valueOf(((c.b)localObject5).bCz), Long.valueOf(((c.b)localObject5).oYa), Integer.valueOf(((c.b)localObject6).oXZ), Long.valueOf(((c.b)localObject6).bCz), Long.valueOf(((c.b)localObject6).oYa), Integer.valueOf(m), Integer.valueOf(j), localObject3, Integer.valueOf(c.access$200()), Integer.valueOf(c.AS()), Integer.valueOf(c.amn()), Integer.valueOf(c.access$1100()), Integer.valueOf(c.bUU()), Long.valueOf(this.oXV), Long.valueOf(this.oXW), Long.valueOf(this.oXX) });
          ab.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear invokeQQAudioPlayerPlayCount:%s, invokeMixPlayerPlayCount:%s, useQQAudioPlayerPlayLostCount:%s, useMixPlayerPlayLostCount:%s, ", new Object[] { Integer.valueOf(c.access$400()), Integer.valueOf(c.access$300()), Integer.valueOf(c.access$400() - c.access$1100() + c.AS()), Integer.valueOf(c.access$300() - c.bUU()) });
          if ((((c.b)localObject4).oXZ > 0) && (((c.b)localObject5).oXZ > 0) && (((c.b)localObject6).oXZ > 0))
          {
            h.qsU.e(15686, new Object[] { this.val$appId, Integer.valueOf(k), Integer.valueOf(i), localObject1, Integer.valueOf(((c.b)localObject4).oXZ), Long.valueOf(((c.b)localObject4).bCz), Long.valueOf(((c.b)localObject4).oYa), Integer.valueOf(((c.b)localObject5).oXZ), Long.valueOf(((c.b)localObject5).bCz), Long.valueOf(((c.b)localObject5).oYa), Integer.valueOf(((c.b)localObject6).oXZ), Long.valueOf(((c.b)localObject6).bCz), Long.valueOf(((c.b)localObject6).oYa), Integer.valueOf(m), Integer.valueOf(j), localObject3, Integer.valueOf(c.access$200()), Integer.valueOf(c.AS()), Integer.valueOf(c.amn()), Integer.valueOf(c.access$1100()), Integer.valueOf(c.bUU()), Long.valueOf(this.oXV), Long.valueOf(this.oXW), Long.valueOf(this.oXX), Integer.valueOf(c.access$400() - c.access$1100() + c.AS()), Integer.valueOf(c.access$300() - c.bUU()) });
            i = c.amn();
            long l1 = ((c.b)localObject5).oYa;
            long l2 = ((c.b)localObject6).oYa;
            long l3 = ((c.b)localObject4).oYa;
            j = c.AS();
            long l4 = this.oXW;
            long l5 = this.oXX;
            n = c.access$400();
            int i1 = c.access$1100();
            c.a(i, l1, l2, l3, m + j, k, l4, l5, c.AS() + (n - i1), c.access$300() - c.bUU());
          }
          c.bUV();
          c.AV();
          c.zT(0);
          c.bUW();
          c.aTC();
          c.bUX();
          c.bUY();
          c.Vb(this.val$appId);
          c.bUT().clear();
          AppMethodBeat.o(104819);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.c.4
 * JD-Core Version:    0.7.0.1
 */