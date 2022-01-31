package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class q$1
  implements Runnable
{
  q$1(q paramq, com.tencent.mm.plugin.record.a.j paramj, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(135722);
    if (this.pYP != null)
    {
      if ((q.e)this.pYR.pYx.get(this.pYP.field_localId) == null)
      {
        ab.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(this.pYP.field_localId), Long.valueOf(this.pYP.field_msgId) });
        localObject1 = new q.e((byte)0);
        this.pYR.pYx.put(this.pYP.field_localId, localObject1);
      }
      this.pYR.b(this.pYP);
    }
    q localq = this.pYR;
    boolean bool = this.pYQ;
    if (localq.pYu)
    {
      ab.i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
      AppMethodBeat.o(135722);
      return;
    }
    if (localq.pYy.isEmpty())
    {
      ab.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
      localObject1 = ((a)com.tencent.mm.kernel.g.G(a.class)).getRecordMsgStorage().cfN().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.record.a.j)((Iterator)localObject1).next();
        if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(((com.tencent.mm.plugin.record.a.j)localObject2).field_msgId).getType() != 49)
        {
          ab.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.j)localObject2).field_msgId) });
          ((a)com.tencent.mm.kernel.g.G(a.class)).getRecordMsgStorage().Cl(((com.tencent.mm.plugin.record.a.j)localObject2).field_localId);
        }
        else
        {
          localObject3 = (q.e)localq.pYx.get(((com.tencent.mm.plugin.record.a.j)localObject2).field_localId);
          if (localObject3 != null)
          {
            if ((((q.e)localObject3).gjM < 0) && (SystemClock.elapsedRealtime() - ((q.e)localObject3).pYB < 300000L)) {
              continue;
            }
            if (((q.e)localObject3).gjM < 0) {
              ((q.e)localObject3).gjM = 3;
            }
          }
          for (;;)
          {
            ab.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject2).field_localId), Long.valueOf(((com.tencent.mm.plugin.record.a.j)localObject2).field_msgId) });
            localq.b((com.tencent.mm.plugin.record.a.j)localObject2);
            break;
            localObject3 = new q.e((byte)0);
            localq.pYx.put(((com.tencent.mm.plugin.record.a.j)localObject2).field_localId, localObject3);
          }
        }
      }
    }
    if (localq.pYy.isEmpty())
    {
      ab.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
      localq.finish();
      AppMethodBeat.o(135722);
      return;
    }
    Object localObject3 = (com.tencent.mm.plugin.record.a.j)localq.pYy.removeFirst();
    Object localObject2 = (q.e)localq.pYx.get(((com.tencent.mm.plugin.record.a.j)localObject3).field_localId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new q.e((byte)0);
      localq.pYx.put(((com.tencent.mm.plugin.record.a.j)localObject3).field_localId, localObject1);
    }
    ((q.e)localObject1).gjM -= 1;
    int i;
    if (((q.e)localObject1).gjM < 0) {
      if (300000L > SystemClock.elapsedRealtime() - ((q.e)localObject1).pYB) {
        i = 0;
      }
    }
    while (i != 0)
    {
      localq.pYu = true;
      switch (((com.tencent.mm.plugin.record.a.j)localObject3).field_type)
      {
      default: 
        localq.pYu = false;
        AppMethodBeat.o(135722);
        return;
        ((q.e)localObject1).gjM = 2;
        ((q.e)localObject1).pYB = SystemClock.elapsedRealtime();
        i = 1;
        break;
      case 1: 
        d.post(new q.c(localq, (com.tencent.mm.plugin.record.a.j)localObject3), "RecordMsgSendService_favDataCopy");
        AppMethodBeat.o(135722);
        return;
      case 2: 
        d.post(new q.a(localq, (com.tencent.mm.plugin.record.a.j)localObject3), "RecordMsgSendService_chatDataCopy");
        AppMethodBeat.o(135722);
        return;
      case 0: 
        d.post(new q.d(localq, (com.tencent.mm.plugin.record.a.j)localObject3, bool), "RecordMsgSendService_normalDataCopy");
        AppMethodBeat.o(135722);
        return;
      case 3: 
        d.post(new q.b(localq, (com.tencent.mm.plugin.record.a.j)localObject3), "RecordMsgSendService_chatDataDownLoad");
        AppMethodBeat.o(135722);
        return;
      }
    }
    localq.a(null, false);
    AppMethodBeat.o(135722);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135723);
    String str = super.toString() + "|run";
    AppMethodBeat.o(135723);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q.1
 * JD-Core Version:    0.7.0.1
 */