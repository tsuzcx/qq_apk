package com.tencent.mm.plugin.x;

import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.aw;
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
    long l2 = bk.UY();
    int i;
    if ((this.msQ == null) || (this.msQ.size() <= 0)) {
      if (this.msQ == null)
      {
        i = -1;
        y.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", new Object[] { Integer.valueOf(i) });
        if (this.msT.msP != null) {
          this.msT.msP.onCancel();
        }
      }
    }
    for (;;)
    {
      return;
      i = this.msQ.size();
      break;
      e.K(g.bky(), true);
      e.K(g.bkz(), true);
      Object localObject1 = new StringBuilder();
      au.Hx();
      e.K(com.tencent.mm.model.c.FU() + "msgsynchronize/", true);
      localObject1 = new StringBuilder();
      au.Hx();
      e.K(com.tencent.mm.model.c.FU() + "msgsynchronize.zip", true);
      Object localObject2 = new LinkedList();
      localObject1 = (String)com.tencent.mm.plugin.backup.h.d.avi().avj().Dz().get(2, null);
      PInt localPInt = new PInt();
      Object localObject3 = new PInt();
      PLong localPLong = new PLong();
      Iterator localIterator = this.msQ.iterator();
      for (;;)
      {
        c.a locala;
        if (localIterator.hasNext())
        {
          locala = (c.a)localIterator.next();
          if (!this.msT.msO) {
            break label288;
          }
          y.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
        }
        label270:
        label288:
        do
        {
          if (!this.msT.msO) {
            break label544;
          }
          y.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
          return;
          localObject4 = com.tencent.mm.plugin.backup.h.d.avi().avj().FB().abv(locala.hFB);
          if (localObject4 != null) {}
          for (i = ((as)localObject4).field_unReadCount;; i = 0)
          {
            if (!this.msR.action.equals(b.msD)) {
              break label412;
            }
            this.msT.a(this.msR, locala, this.eow, this.eGZ, (String)localObject1, i, localPInt, localPLong, this.msS);
            if (localPLong.value < b.msN) {
              break;
            }
            y.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", new Object[] { Long.valueOf(localPLong.value) });
            break label270;
          }
        } while (((PInt)localObject3).value >= b.msJ);
        label412:
        Object localObject4 = new k();
        ((k)localObject4).hPY = locala.hFB;
        ((k)localObject4).hPW = ((int)(com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().HV(locala.hFB) / 1000L));
        ((k)localObject4).hPX = i;
        ((LinkedList)localObject2).add(localObject4);
        ((PInt)localObject3).value += 1;
        if (localPInt.value < b.msH) {
          this.msT.a(this.msR, locala, this.eow, this.eGZ, (String)localObject1, i, localPInt, localPLong, this.msS);
        }
      }
      label544:
      if (!this.msR.action.equals(b.msD))
      {
        localObject3 = new l();
        ((l)localObject3).hPZ = ((LinkedList)localObject2);
        ((l)localObject3).hQa = com.tencent.mm.bh.d.RY().cuU();
      }
      try
      {
        localObject2 = ((l)localObject3).toByteArray();
        g.f(g.bkx(), "sessionlist", (byte[])localObject2);
        y.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
        localObject2 = g.bky();
        localObject3 = g.bkz();
        if ((localObject2 == null) || (((String)localObject2).isEmpty()))
        {
          long l1 = e.aeQ(g.bkz());
          y.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", new Object[] { Integer.valueOf(localPInt.value), Long.valueOf(localPLong.value), Long.valueOf(l1 / 1024L), Long.valueOf(bk.co(l2)) });
          localObject2 = this.msR;
          l2 = localPInt.value;
          long l3 = localPLong.value;
          l1 /= 1024L;
          ((d)localObject2).msV = l2;
          ((d)localObject2).msW = l3;
          ((d)localObject2).msX = l1;
          ((d)localObject2).diG = new String((String)localObject1);
          if (this.msT.msP == null) {
            continue;
          }
          this.msT.msP.a(this.msR, g.bkz(), this.msQ.size());
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[] { Integer.valueOf(((l)localObject3).hPZ.size()), localException.getMessage() });
          continue;
          e.m(Collections.singletonList(localException), (String)localObject3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.x.c.1
 * JD-Core Version:    0.7.0.1
 */