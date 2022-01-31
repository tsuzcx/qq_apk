package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.byz;
import com.tencent.mm.protocal.c.bza;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class c
  implements a
{
  public ArrayList<c.a> dFz = new ArrayList(1);
  public int iks = 0;
  public final d[] pKD = new d[1];
  public Queue<c.c> pKE = new LinkedList();
  public HashMap<String, Integer> pKF = new HashMap();
  
  private void b(int paramInt, SparseArray<c.c> paramSparseArray)
  {
    Iterator localIterator = this.dFz.iterator();
    while (localIterator.hasNext()) {
      ((c.a)localIterator.next()).a(paramInt, paramSparseArray);
    }
  }
  
  public final boolean PT(String paramString)
  {
    return this.pKF.containsKey(paramString);
  }
  
  public final void a(int paramInt, SparseArray<c.c> paramSparseArray, LinkedList<bza> paramLinkedList)
  {
    this.iks -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      y.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c.c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c.c)paramSparseArray.valueAt(i)).pKI));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        if (localIterator.hasNext())
        {
          bza localbza = (bza)localIterator.next();
          c.c localc = (c.c)paramSparseArray.get(localbza.tPa);
          String str = localbza.tPd;
          paramLinkedList = str;
          if (localc.type == 1)
          {
            paramLinkedList = bd.Z(str, localc.pKJ);
            localc.cbK = bd.Z(localc.cbK, localc.pKJ);
          }
          localc.cbR = paramLinkedList;
          localc.ret = localbza.sze;
          localc.cad = localbza.tPe;
          if ((localbza.sZU != null) && (localbza.sZU.tFM != null)) {}
          for (paramLinkedList = localbza.sZU.tFM.oY;; paramLinkedList = null)
          {
            localc.cQQ = paramLinkedList;
            localc.pKH = localbza.tPf;
            this.pKF.remove(localc.id);
            if (localObject == null) {
              break;
            }
            ((HashMap)localObject).remove(localc.id);
            break;
          }
        }
      }
      else
      {
        i = 0;
        while (i < paramSparseArray.size())
        {
          paramLinkedList = (c.c)paramSparseArray.valueAt(i);
          if (paramLinkedList.type == 1) {
            paramLinkedList.cbK = bd.Z(paramLinkedList.cbK, paramLinkedList.pKJ);
          }
          i += 1;
        }
      }
      if ((localObject != null) && (((HashMap)localObject).size() > 0))
      {
        paramLinkedList = ((HashMap)localObject).entrySet().iterator();
        while (paramLinkedList.hasNext())
        {
          localObject = (Map.Entry)paramLinkedList.next();
          this.pKF.remove(((Map.Entry)localObject).getKey());
          y.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      bOW();
      return;
      localObject = null;
    }
  }
  
  public final void bOW()
  {
    y.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.pKE.size()) });
    if (this.pKE.size() == 0) {}
    while (this.iks > this.pKD.length) {
      return;
    }
    int j = 0;
    label53:
    d locald;
    Queue localQueue;
    int i;
    if (j < this.pKD.length)
    {
      if (this.pKD[j] == null)
      {
        this.pKD[j] = new d(j, this);
        locald = this.pKD[j];
        au.Dk().a(631, locald);
      }
      if (!this.pKD[j].pKM)
      {
        locald = this.pKD[j];
        localQueue = this.pKE;
        if (!locald.pKM) {
          break label162;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0) {
        this.iks += 1;
      }
      j += 1;
      break label53;
      break;
      label162:
      locald.pKL = new SparseArray();
      if (localQueue.size() == 0)
      {
        i = 0;
      }
      else
      {
        locald.pKM = true;
        LinkedList localLinkedList = new LinkedList();
        i = 0;
        if ((i < 512) && (localQueue.size() > 0))
        {
          c.c localc = (c.c)localQueue.peek();
          int k = localc.cbK.getBytes().length;
          byz localbyz;
          if ((i == 0) || (i + k <= 512))
          {
            localQueue.poll();
            localbyz = new byz();
            localbyz.tPa = localc.pKI;
            localbyz.tPb = localc.cbK;
            localbyz.sZU = new bmk().bs(localc.cQQ);
            if ((localc.type == 1) || (s.fn(localc.aWf))) {
              localbyz.tPc = localc.aWf;
            }
            switch (localc.type)
            {
            }
          }
          for (;;)
          {
            y.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localbyz.pyo), localc.id });
            localLinkedList.add(localbyz);
            locald.pKL.put(localc.pKI, localc);
            i += k;
            break;
            localbyz.pyo = 4;
            continue;
            localbyz.pyo = 1;
            continue;
            localbyz.pyo = 2;
            continue;
            localbyz.pyo = 3;
          }
        }
        locald.pKN = new b(localLinkedList);
        au.Dk().a(locald.pKN, 0);
        locald.start = System.currentTimeMillis();
        locald.pKP.S(60000L, 60000L);
        i = 1;
      }
    }
  }
  
  private static final class b
  {
    public static final c pKG = new c((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.c
 * JD-Core Version:    0.7.0.1
 */