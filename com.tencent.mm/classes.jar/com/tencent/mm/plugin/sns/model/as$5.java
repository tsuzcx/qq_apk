package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fo;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class as$5
  implements Runnable
{
  as$5(as paramas, k paramk1, List paramList, k paramk2, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(210264);
    fo localfo;
    Object localObject1;
    int j;
    int i;
    Object localObject2;
    int k;
    int i1;
    long l;
    int m;
    Object localObject3;
    int n;
    label520:
    Object localObject4;
    if (this.Czq != null)
    {
      localfo = f.ydE.yek;
      localObject1 = new LinkedList(this.Czq.yaO);
      ((LinkedList)localObject1).removeAll(this.Czq.qJs);
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      j = 0;
      i = 0;
      if (i < this.Czq.yaO.size())
      {
        if (i < this.xWD.xWf * j)
        {
          localObject2 = (List)localLinkedList1.peekLast();
          k = j;
          if (localObject2 != null)
          {
            ((List)localObject2).add(this.Czq.yaO.get(i));
            k = j;
          }
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j + 1;
          localObject2 = new ArrayList();
          ((List)localObject2).add(this.Czq.yaO.get(i));
          localLinkedList1.add(localObject2);
        }
      }
      j = 0;
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        if (i < this.xWD.xWf * j)
        {
          localObject2 = (List)localLinkedList2.peekLast();
          k = j;
          if (localObject2 != null)
          {
            ((List)localObject2).add(((LinkedList)localObject1).get(i));
            k = j;
          }
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j + 1;
          localObject2 = new ArrayList();
          ((List)localObject2).add(((LinkedList)localObject1).get(i));
          localLinkedList2.add(localObject2);
        }
      }
      i1 = Math.max(localLinkedList2.size(), localLinkedList1.size());
      l = System.currentTimeMillis();
      j = 0;
      if (j < i1)
      {
        localObject1 = new StringBuffer();
        localObject2 = new StringBuffer();
        m = 0;
        if (j < localLinkedList1.size())
        {
          localObject3 = (List)localLinkedList1.get(j);
          i = ((List)localObject3).size();
          localObject3 = ((List)localObject3).iterator();
          for (;;)
          {
            k = i;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            ((StringBuffer)localObject1).append(q.wX(((Long)((Iterator)localObject3).next()).longValue())).append("|");
          }
        }
        k = 0;
        if (j < localLinkedList2.size())
        {
          localObject3 = (List)localLinkedList2.get(j);
          i = ((List)localObject3).size();
          localObject3 = ((List)localObject3).iterator();
          for (;;)
          {
            m = i;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            ((StringBuffer)localObject2).append(q.wX(((Long)((Iterator)localObject3).next()).longValue())).append("|");
          }
        }
        i = 0;
        localObject3 = this.CAR.iterator();
        n = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (k)((Iterator)localObject3).next();
          if (!this.xWD.a((k)localObject4))
          {
            n += 1;
          }
          else
          {
            if ((localObject4 == null) || (bs.gY(((k)localObject4).qJs))) {
              break label949;
            }
            i += 1;
          }
        }
      }
    }
    label949:
    for (;;)
    {
      break label520;
      if (this.CAS != null)
      {
        if (!bs.gY(this.CAS.yaO))
        {
          localfo.dYw = (this.CAS.yaO.size() - this.CAS.yaQ);
          localfo.dYv = this.CAS.yaO.size();
        }
        if (!bs.gY(this.CAS.qJs))
        {
          localfo.dYd = ((Long)this.CAS.yaO.peek()).longValue();
          localObject3 = new StringBuffer();
          localObject4 = this.CAS.qJs.iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((StringBuffer)localObject3).append(q.wX(((Long)((Iterator)localObject4).next()).longValue())).append("|");
          }
          localfo.dYg = localfo.t("JumpBreakLayerFeeds", ((StringBuffer)localObject3).toString(), true);
        }
      }
      localfo.dYu = this.xWD.xWB;
      localfo.dFe = localfo.t("SessionId", this.xWD.sessionId, true);
      localfo.dYl = localfo.t("NewFeeds", ((StringBuffer)localObject1).toString(), true);
      localfo.dYm = k;
      localfo.dYn = localfo.t("ExposureNewFeeds", ((StringBuffer)localObject2).toString(), true);
      localfo.dYo = m;
      localfo.dYp = i;
      localfo.dYq = n;
      localfo.dYr = this.xWD.xWA;
      localfo.dYc = this.CAT;
      localfo.dRy = l;
      localfo.dSE = j;
      localfo.dSF = i1;
      localfo.aHZ();
      j += 1;
      break;
      f.ydE.yek = new fo();
      this.xWD.xWA = 0;
      this.xWD.xWB = 0L;
      AppMethodBeat.o(210264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as.5
 * JD-Core Version:    0.7.0.1
 */