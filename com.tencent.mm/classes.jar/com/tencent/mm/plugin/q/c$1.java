package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

final class c$1
  implements Runnable
{
  c$1(c paramc, LinkedList paramLinkedList, d paramd, long paramLong1, long paramLong2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(22893);
    long l2 = bo.aoy();
    int i;
    if ((this.oSB == null) || (this.oSB.size() <= 0))
    {
      if (this.oSB == null) {}
      for (i = -1;; i = this.oSB.size())
      {
        ab.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", new Object[] { Integer.valueOf(i) });
        if (this.oSE.oSA != null) {
          this.oSE.oSA.onCancel();
        }
        AppMethodBeat.o(22893);
        return;
      }
    }
    e.O(g.bSy(), true);
    e.O(g.bSz(), true);
    Object localObject1 = new StringBuilder();
    com.tencent.mm.model.aw.aaz();
    e.O(com.tencent.mm.model.c.getAccPath() + "msgsynchronize/", true);
    localObject1 = new StringBuilder();
    com.tencent.mm.model.aw.aaz();
    e.O(com.tencent.mm.model.c.getAccPath() + "msgsynchronize.zip", true);
    Object localObject2 = new LinkedList();
    localObject1 = (String)com.tencent.mm.plugin.backup.h.d.aUK().aUL().Ru().get(2, null);
    PInt localPInt = new PInt();
    Object localObject3 = new PInt();
    PLong localPLong = new PLong();
    Iterator localIterator = this.oSB.iterator();
    for (;;)
    {
      c.a locala;
      if (localIterator.hasNext())
      {
        locala = (c.a)localIterator.next();
        if (!this.oSE.oSz) {
          break label306;
        }
        ab.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
      }
      label282:
      label306:
      do
      {
        if (!this.oSE.oSz) {
          break label562;
        }
        ab.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
        AppMethodBeat.o(22893);
        return;
        localObject4 = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YF().arH(locala.jyY);
        if (localObject4 != null) {}
        for (i = ((au)localObject4).field_unReadCount;; i = 0)
        {
          if (!this.oSC.action.equals(b.oSo)) {
            break label430;
          }
          this.oSE.a(this.oSC, locala, this.fET, this.fWP, (String)localObject1, i, localPInt, localPLong, this.oSD);
          if (localPLong.value < b.oSy) {
            break;
          }
          ab.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", new Object[] { Long.valueOf(localPLong.value) });
          break label282;
        }
      } while (((PInt)localObject3).value >= b.oSu);
      label430:
      Object localObject4 = new k();
      ((k)localObject4).jJA = locala.jyY;
      ((k)localObject4).jJy = ((int)(com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().TE(locala.jyY) / 1000L));
      ((k)localObject4).jJz = i;
      ((LinkedList)localObject2).add(localObject4);
      ((PInt)localObject3).value += 1;
      if (localPInt.value < b.oSs) {
        this.oSE.a(this.oSC, locala, this.fET, this.fWP, (String)localObject1, i, localPInt, localPLong, this.oSD);
      }
    }
    label562:
    if (!this.oSC.action.equals(b.oSo))
    {
      localObject3 = new l();
      ((l)localObject3).jJB = ((LinkedList)localObject2);
      ((l)localObject3).jJC = com.tencent.mm.bi.d.ali().dxy();
    }
    try
    {
      localObject2 = ((l)localObject3).toByteArray();
      g.f(g.bSx(), "sessionlist", (byte[])localObject2);
      ab.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
      localObject2 = g.bSy();
      localObject3 = g.bSz();
      if ((localObject2 == null) || (((String)localObject2).isEmpty()))
      {
        long l1 = e.avI(g.bSz());
        ab.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", new Object[] { Integer.valueOf(localPInt.value), Long.valueOf(localPLong.value), Long.valueOf(l1 / 1024L), Long.valueOf(bo.hl(l2)) });
        localObject2 = this.oSC;
        l2 = localPInt.value;
        long l3 = localPLong.value;
        l1 /= 1024L;
        ((d)localObject2).oSG = l2;
        ((d)localObject2).oSH = l3;
        ((d)localObject2).oSI = l1;
        ((d)localObject2).dZZ = new String((String)localObject1);
        if (this.oSE.oSA != null) {
          this.oSE.oSA.a(this.oSC, g.bSz(), this.oSB.size());
        }
        AppMethodBeat.o(22893);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[] { Integer.valueOf(((l)localObject3).jJB.size()), localException.getMessage() });
        continue;
        e.n(Collections.singletonList(localException), (String)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.q.c.1
 * JD-Core Version:    0.7.0.1
 */