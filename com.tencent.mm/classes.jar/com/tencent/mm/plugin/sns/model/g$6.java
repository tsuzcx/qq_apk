package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class g$6
  implements Runnable
{
  g$6(g paramg, SparseArray paramSparseArray1, SparseArray paramSparseArray2, SparseArray paramSparseArray3, String paramString, az paramaz, int paramInt) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(36140);
    int k = this.rdQ.size();
    int i = 0;
    int m;
    Object localObject1;
    while (i < k)
    {
      m = this.rdQ.keyAt(i);
      localObject1 = (bcs)this.rdQ.get(m);
      if (!g.a(this.rdL, 0, (bcs)localObject1))
      {
        ??? = new com.tencent.mm.plugin.sns.data.e((bcs)localObject1);
        ((com.tencent.mm.plugin.sns.data.e)???).rbj = 0;
        ((com.tencent.mm.plugin.sns.data.e)???).ohe = ((bcs)localObject1).Id;
        this.rdR.put(m, ???);
        this.rdS.put(m, localObject1);
      }
      i += 1;
    }
    Object localObject4;
    Object localObject5;
    az localaz;
    SparseArray localSparseArray;
    Object localObject6;
    if (this.rdS.size() > 0)
    {
      localObject1 = ag.cpa();
      localObject4 = this.fWS;
      ??? = this.rdS;
      localObject5 = this.rdR;
      localaz = this.rdT;
      k = this.rdU;
      m = ((SparseArray)???).size();
      i = 0;
      while (i < m)
      {
        aw.aaH(((bcs)((SparseArray)???).valueAt(i)).Id);
        i += 1;
      }
      if (!i.ZK(ag.getAccPath()))
      {
        ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { ag.getAccPath(), com.tencent.mm.compatible.util.e.eQx });
        AppMethodBeat.o(36140);
        return;
      }
      localSparseArray = new SparseArray();
      i = j;
      if (i < m)
      {
        j = ((SparseArray)???).keyAt(i);
        localObject6 = (bcs)((SparseArray)???).get(j);
        if ((!((bcs)localObject6).Id.startsWith("Locall_path")) && (!((bcs)localObject6).Id.startsWith("pre_temp_sns_pic"))) {
          localSparseArray.put(j, localObject6);
        }
        for (;;)
        {
          i += 1;
          break;
          ((SparseArray)localObject5).remove(j);
        }
      }
      if (localSparseArray.size() <= 0)
      {
        ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
        AppMethodBeat.o(36140);
        return;
      }
      localObject6 = i.ZE((String)localObject4);
    }
    for (;;)
    {
      synchronized (((b)localObject1).eFQ)
      {
        if (!((b)localObject1).rdg.containsKey(localObject6))
        {
          ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", new Object[] { localObject4 });
          ((b)localObject1).rdg.put(localObject6, new c((SparseArray)localObject5));
          ((b)localObject1).elu.add(new f((String)localObject4, localSparseArray, (String)localObject6, localaz, k));
          continue;
          if (Looper.myLooper() == null) {
            break label590;
          }
          Looper.myQueue().addIdleHandler(new b.d((b)localObject1));
          ((b)localObject1).cok();
          ((b)localObject1).col();
          if (((b)localObject1).elu.size() > 0)
          {
            ab.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            ((b)localObject1).ahb();
          }
          AppMethodBeat.o(36140);
        }
        else
        {
          localObject4 = ((b)localObject1).elu.iterator();
        }
        if (!((Iterator)localObject4).hasNext()) {
          continue;
        }
        localObject5 = (f)((Iterator)localObject4).next();
        if (!((f)localObject5).key.equals(localObject6)) {
          continue;
        }
        if (((b)localObject1).elu.remove(localObject5)) {
          ((b)localObject1).elu.addLast(localObject5);
        }
        ab.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label590:
      ab.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.6
 * JD-Core Version:    0.7.0.1
 */