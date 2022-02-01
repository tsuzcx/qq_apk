package com.tencent.mm.plugin.r;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  boolean wly = false;
  a.a wlz;
  
  public static LinkedList<a> asa(String paramString)
  {
    AppMethodBeat.i(26519);
    LinkedList localLinkedList = new LinkedList();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26519);
      return localLinkedList;
    }
    int i = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().arr(paramString);
    ae.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", new Object[] { paramString, Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(26519);
      return localLinkedList;
    }
    localLinkedList.add(new a(paramString));
    AppMethodBeat.o(26519);
    return localLinkedList;
  }
  
  public final void a(final d paramd, final LinkedList<a> paramLinkedList, final long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(26520);
    paramd = new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "msgSynchronizePackThread";
      }
      
      public final void run()
      {
        AppMethodBeat.i(26517);
        long l2 = bu.fpO();
        int i;
        if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
        {
          if (paramLinkedList == null) {}
          for (i = -1;; i = paramLinkedList.size())
          {
            ae.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", new Object[] { Integer.valueOf(i) });
            if (c.this.wlz != null) {
              c.this.wlz.onCancel();
            }
            AppMethodBeat.o(26517);
            return;
          }
        }
        com.tencent.mm.plugin.backup.b.g.WA(g.drC());
        com.tencent.mm.plugin.backup.b.g.WA(g.drD());
        Object localObject1 = new StringBuilder();
        bc.aCg();
        com.tencent.mm.plugin.backup.b.g.WA(com.tencent.mm.model.c.getAccPath() + "msgsynchronize/");
        localObject1 = new StringBuilder();
        bc.aCg();
        com.tencent.mm.plugin.backup.b.g.WA(com.tencent.mm.model.c.getAccPath() + "msgsynchronize.zip");
        Object localObject2 = new LinkedList();
        localObject1 = (String)com.tencent.mm.plugin.backup.h.d.bJW().bJX().ajA().get(2, null);
        PInt localPInt = new PInt();
        Object localObject3 = new PInt();
        PLong localPLong = new PLong();
        Iterator localIterator = paramLinkedList.iterator();
        for (;;)
        {
          c.a locala;
          if (localIterator.hasNext())
          {
            locala = (c.a)localIterator.next();
            if (!c.this.wly) {
              break label298;
            }
            ae.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
          }
          label274:
          label298:
          do
          {
            if (!c.this.wly) {
              break label554;
            }
            ae.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
            AppMethodBeat.o(26517);
            return;
            localObject4 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azL().aVa(locala.nyq);
            if (localObject4 != null) {}
            for (i = ((ba)localObject4).field_unReadCount;; i = 0)
            {
              if (!paramd.action.equals(b.wln)) {
                break label422;
              }
              c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.wlC);
              if (localPLong.value < b.wlx) {
                break;
              }
              ae.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", new Object[] { Long.valueOf(localPLong.value) });
              break label274;
            }
          } while (((PInt)localObject3).value >= b.wlt);
          label422:
          Object localObject4 = new k();
          ((k)localObject4).nIJ = locala.nyq;
          ((k)localObject4).nIH = ((int)(com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().arv(locala.nyq) / 1000L));
          ((k)localObject4).nII = i;
          ((LinkedList)localObject2).add(localObject4);
          ((PInt)localObject3).value += 1;
          if (localPInt.value < b.wlr) {
            c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.wlC);
          }
        }
        label554:
        if (!paramd.action.equals(b.wln))
        {
          localObject3 = new l();
          ((l)localObject3).nIK = ((LinkedList)localObject2);
          ((l)localObject3).nIL = com.tencent.mm.bj.d.aMM().fvk();
        }
        try
        {
          localObject2 = ((l)localObject3).toByteArray();
          g.e(g.drB(), "sessionlist", (byte[])localObject2);
          ae.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
          o.mI(g.drC(), g.drD());
          long l1 = o.aZR(g.drD());
          ae.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", new Object[] { Integer.valueOf(localPInt.value), Long.valueOf(localPLong.value), Long.valueOf(l1 / 1024L), Long.valueOf(bu.DD(l2)) });
          localObject2 = paramd;
          l2 = localPInt.value;
          long l3 = localPLong.value;
          l1 /= 1024L;
          ((d)localObject2).wlF = l2;
          ((d)localObject2).wlG = l3;
          ((d)localObject2).wlH = l1;
          ((d)localObject2).fHO = new String((String)localObject1);
          if (c.this.wlz != null) {
            c.this.wlz.a(paramd, g.drD(), paramLinkedList.size());
          }
          AppMethodBeat.o(26517);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[] { Integer.valueOf(((l)localObject3).nIK.size()), localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.MqF.aR(paramd);
    AppMethodBeat.o(26520);
  }
  
  public final boolean a(d paramd, a parama, long paramLong1, long paramLong2, String paramString, int paramInt1, PInt paramPInt, PLong paramPLong, int paramInt2)
  {
    AppMethodBeat.i(26521);
    boolean bool = paramd.action.equals(b.wln);
    bc.aCg();
    if (an.abz(com.tencent.mm.model.c.azF().BH(parama.nyq).field_verifyFlag))
    {
      AppMethodBeat.o(26521);
      return true;
    }
    ae.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", new Object[] { parama.nyq, Integer.valueOf(paramInt1) });
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = new ArrayList(paramInt2);
    int i = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().F(parama.nyq, paramLong1, paramLong2);
    if (i <= 0)
    {
      ae.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().b(parama.nyq, paramLong1, paramLong2, paramInt2);
    if (bool)
    {
      if (i <= paramInt2) {
        break label221;
      }
      paramd.wlJ = 0;
    }
    label293:
    while (((Cursor)localObject2).moveToNext()) {
      if (this.wly)
      {
        ae.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
        ((Cursor)localObject2).close();
        AppMethodBeat.o(26521);
        return false;
        label221:
        paramd.wlJ = 1;
      }
      else
      {
        paramd = new bv();
        paramd.convertFrom((Cursor)localObject2);
        if ((paramd.field_createTime >= paramLong1) && (paramd.field_createTime <= paramLong2))
        {
          if (paramd.getType() == 922746929) {}
          for (paramInt2 = 0;; paramInt2 = 1)
          {
            if (paramInt2 == 0) {
              break label293;
            }
            ((ArrayList)localObject1).add(paramd);
            break;
          }
        }
      }
    }
    ((Cursor)localObject2).close();
    if (((ArrayList)localObject1).size() <= 0)
    {
      ae.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramd = (bv)((Iterator)localObject1).next();
        if (this.wly)
        {
          ae.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
          AppMethodBeat.o(26521);
          return false;
        }
        localObject2 = new PLong();
        LinkedList localLinkedList2 = new LinkedList();
        if (paramInt1 > 0) {
          bool = true;
        }
        try
        {
          for (;;)
          {
            paramd = com.tencent.mm.plugin.backup.f.h.a(paramd, false, paramString, (PLong)localObject2, localLinkedList2, null, bool, true, 0L);
            if (paramd == null) {
              break;
            }
            localLinkedList1.add(paramd);
            ae.d("MicroMsg.MsgSynchronizePack", "bakItem:%s", new Object[] { paramd.toString() });
            paramPLong.value += 1L;
            paramInt1 -= 1;
            break;
            bool = false;
          }
        }
        catch (Exception paramd)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.MsgSynchronizePack", paramd, "packMsg", new Object[0]);
            paramd = null;
          }
        }
      }
    }
    ae.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    paramd = new ig();
    paramd.nIE = localLinkedList1;
    paramd.nID = localLinkedList1.size();
    try
    {
      paramString = paramd.toByteArray();
      parama = "MSG_" + localLinkedList1.size() + "_" + parama.nyq + "_" + bu.fpO();
      g.e(g.drB(), parama, paramString);
      ae.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", new Object[] { parama });
      paramPInt.value += 1;
      AppMethodBeat.o(26521);
      return true;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", new Object[] { Integer.valueOf(paramd.nID), parama.getMessage() });
      }
    }
  }
  
  public final LinkedList<a> drA()
  {
    AppMethodBeat.i(26518);
    long l = bu.fpO();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azL().c(x.hHV, com.tencent.mm.plugin.backup.b.g.bIm(), "*");
    if (localCursor.getCount() == 0)
    {
      ae.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
      localCursor.close();
      AppMethodBeat.o(26518);
      return localLinkedList;
    }
    ae.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    int i = 0;
    for (;;)
    {
      if (localCursor.moveToNext())
      {
        if (this.wly)
        {
          localCursor.close();
          ae.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
          AppMethodBeat.o(26518);
          return localLinkedList;
        }
        if (i >= b.wlt) {
          ae.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        localCursor.close();
        ae.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bu.DD(l));
        AppMethodBeat.o(26518);
        return localLinkedList;
      }
      au localau = new au();
      localau.convertFrom(localCursor);
      if (!bu.isNullOrNil(localau.field_username))
      {
        int j = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().arr(localau.field_username);
        ae.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", new Object[] { localau.field_username, Integer.valueOf(j), Integer.valueOf(i) });
        if (j > 0)
        {
          localLinkedList.add(new a(localau.field_username));
          i += 1;
        }
      }
    }
  }
  
  public static final class a
  {
    public String nyq;
    
    public a(String paramString)
    {
      this.nyq = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.c
 * JD-Core Version:    0.7.0.1
 */