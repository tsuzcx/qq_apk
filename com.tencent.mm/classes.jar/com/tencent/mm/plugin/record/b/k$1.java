package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class k$1
  implements Runnable
{
  k$1(k paramk, com.tencent.mm.plugin.record.a.g paramg) {}
  
  public final void run()
  {
    if (this.nti != null)
    {
      if ((k.e)this.ntj.nsR.get(this.nti.field_localId) == null)
      {
        y.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(this.nti.field_localId), Long.valueOf(this.nti.field_msgId) });
        localObject1 = new k.e((byte)0);
        this.ntj.nsR.put(this.nti.field_localId, localObject1);
      }
      this.ntj.b(this.nti);
    }
    k localk = this.ntj;
    if (localk.nsO)
    {
      y.d("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
      return;
    }
    if (localk.nsS.isEmpty())
    {
      y.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
      localObject1 = n.bvz().bvu().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.record.a.g)((Iterator)localObject1).next();
        au.Hx();
        if (c.Fy().fd(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId).getType() != 49)
        {
          y.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId) });
          n.bvz().wz(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId);
        }
        else
        {
          localObject3 = (k.e)localk.nsR.get(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId);
          if (localObject3 != null)
          {
            if ((((k.e)localObject3).eRR < 0) && (SystemClock.elapsedRealtime() - ((k.e)localObject3).nsV < 300000L)) {
              continue;
            }
            if (((k.e)localObject3).eRR < 0) {
              ((k.e)localObject3).eRR = 3;
            }
          }
          for (;;)
          {
            y.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.g)localObject2).field_msgId) });
            localk.b((com.tencent.mm.plugin.record.a.g)localObject2);
            break;
            localObject3 = new k.e((byte)0);
            localk.nsR.put(((com.tencent.mm.plugin.record.a.g)localObject2).field_localId, localObject3);
          }
        }
      }
    }
    if (localk.nsS.isEmpty())
    {
      y.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
      localk.finish();
      return;
    }
    Object localObject3 = (com.tencent.mm.plugin.record.a.g)localk.nsS.removeFirst();
    Object localObject2 = (k.e)localk.nsR.get(((com.tencent.mm.plugin.record.a.g)localObject3).field_localId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new k.e((byte)0);
      localk.nsR.put(((com.tencent.mm.plugin.record.a.g)localObject3).field_localId, localObject1);
    }
    ((k.e)localObject1).eRR -= 1;
    int i;
    if (((k.e)localObject1).eRR < 0) {
      if (300000L > SystemClock.elapsedRealtime() - ((k.e)localObject1).nsV) {
        i = 0;
      }
    }
    while (i != 0)
    {
      localk.nsO = true;
      switch (((com.tencent.mm.plugin.record.a.g)localObject3).field_type)
      {
      default: 
        localk.nsO = false;
        return;
        ((k.e)localObject1).eRR = 2;
        ((k.e)localObject1).nsV = SystemClock.elapsedRealtime();
        i = 1;
        break;
      case 1: 
        com.tencent.mm.sdk.f.e.post(new k.c(localk, (com.tencent.mm.plugin.record.a.g)localObject3), "RecordMsgSendService_favDataCopy");
        return;
      case 2: 
        com.tencent.mm.sdk.f.e.post(new k.a(localk, (com.tencent.mm.plugin.record.a.g)localObject3), "RecordMsgSendService_chatDataCopy");
        return;
      case 0: 
        com.tencent.mm.sdk.f.e.post(new k.d(localk, (com.tencent.mm.plugin.record.a.g)localObject3), "RecordMsgSendService_normalDataCopy");
        return;
      case 3: 
        com.tencent.mm.sdk.f.e.post(new k.b(localk, (com.tencent.mm.plugin.record.a.g)localObject3), "RecordMsgSendService_chatDataDownLoad");
        return;
      }
    }
    localk.a(null);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k.1
 * JD-Core Version:    0.7.0.1
 */