package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString) {}
  
  public final void run()
  {
    for (;;)
    {
      synchronized ()
      {
        y.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear appId:%s", new Object[] { this.val$appId });
        Object localObject4 = a.aYI().entrySet().iterator();
        int i = 0;
        Object localObject1 = "";
        int j = 0;
        Object localObject5;
        Object localObject3;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          localObject3 = (String)((Map.Entry)localObject5).getKey();
          j += ((Integer)((Map.Entry)localObject5).getValue()).intValue();
          if (((Integer)((Map.Entry)localObject5).getValue()).intValue() > i)
          {
            i = ((Integer)((Map.Entry)localObject5).getValue()).intValue();
            localObject1 = localObject3;
            y.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear audioKey:%s, lostCount:%s", new Object[] { localObject3, ((Map.Entry)localObject5).getValue() });
          }
        }
        else
        {
          a.aYI().clear();
          localObject3 = new a.a(this.mxL);
          localObject4 = new a.a(this.mxL);
          localObject5 = new a.a(this.mxL);
          a.a((a.a)localObject3, a.AD());
          a.a((a.a)localObject4, a.bmE());
          a.a((a.a)localObject5, a.bmF());
          a.AD().clear();
          a.bmE().clear();
          a.bmF().clear();
          y.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear totalJsCostCount:%s, averageJSCostTime:%s, totalJSCostTime:%s,totalInvokeCostCount:%s, averageInvokeCostTime:%s, totalInvokeCostTime:%s,averageCostTime:%s, totalCostCount:%s, totalCostTime:%s, totalLostCount:%s, maxLostCount:%s, maxLostKey:%s", new Object[] { Integer.valueOf(((a.a)localObject4).mxP), Long.valueOf(((a.a)localObject4).mxQ), Long.valueOf(((a.a)localObject4).fXf), Integer.valueOf(((a.a)localObject5).mxP), Long.valueOf(((a.a)localObject5).mxQ), Long.valueOf(((a.a)localObject5).fXf), Integer.valueOf(((a.a)localObject3).mxP), Long.valueOf(((a.a)localObject3).mxQ), Long.valueOf(((a.a)localObject3).fXf), Integer.valueOf(j), Integer.valueOf(i), localObject1 });
          h.nFQ.f(15686, new Object[] { this.val$appId, Integer.valueOf(j), Integer.valueOf(i), localObject1, Integer.valueOf(((a.a)localObject3).mxP), Long.valueOf(((a.a)localObject3).fXf), Long.valueOf(((a.a)localObject3).mxQ), Integer.valueOf(((a.a)localObject4).mxP), Long.valueOf(((a.a)localObject4).fXf), Long.valueOf(((a.a)localObject4).mxQ), Integer.valueOf(((a.a)localObject5).mxP), Long.valueOf(((a.a)localObject5).fXf), Long.valueOf(((a.a)localObject5).mxQ) });
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.a.3
 * JD-Core Version:    0.7.0.1
 */