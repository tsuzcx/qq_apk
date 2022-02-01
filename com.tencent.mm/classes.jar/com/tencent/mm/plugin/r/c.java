package com.tencent.mm.plugin.r;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  boolean tNJ = false;
  a.a tNK;
  
  public static LinkedList<a> ahl(String paramString)
  {
    AppMethodBeat.i(26519);
    LinkedList localLinkedList = new LinkedList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26519);
      return localLinkedList;
    }
    int i = com.tencent.mm.plugin.backup.h.d.bxT().bxU().apO().agE(paramString);
    ad.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", new Object[] { paramString, Integer.valueOf(i) });
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
        long l2 = bt.eGO();
        int i;
        if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
        {
          if (paramLinkedList == null) {}
          for (i = -1;; i = paramLinkedList.size())
          {
            ad.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", new Object[] { Integer.valueOf(i) });
            if (c.this.tNK != null) {
              c.this.tNK.onCancel();
            }
            AppMethodBeat.o(26517);
            return;
          }
        }
        com.tencent.mm.plugin.backup.b.g.Og(g.cRw());
        com.tencent.mm.plugin.backup.b.g.Og(g.cRx());
        Object localObject1 = new StringBuilder();
        com.tencent.mm.model.az.arV();
        com.tencent.mm.plugin.backup.b.g.Og(com.tencent.mm.model.c.getAccPath() + "msgsynchronize/");
        localObject1 = new StringBuilder();
        com.tencent.mm.model.az.arV();
        com.tencent.mm.plugin.backup.b.g.Og(com.tencent.mm.model.c.getAccPath() + "msgsynchronize.zip");
        Object localObject2 = new LinkedList();
        localObject1 = (String)com.tencent.mm.plugin.backup.h.d.bxT().bxU().afk().get(2, null);
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
            if (!c.this.tNJ) {
              break label298;
            }
            ad.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
          }
          label274:
          label298:
          do
          {
            if (!c.this.tNJ) {
              break label554;
            }
            ad.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
            AppMethodBeat.o(26517);
            return;
            localObject4 = com.tencent.mm.plugin.backup.h.d.bxT().bxU().apR().aIn(locala.mqv);
            if (localObject4 != null) {}
            for (i = ((ay)localObject4).field_unReadCount;; i = 0)
            {
              if (!paramd.action.equals(b.tNy)) {
                break label422;
              }
              c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.tNN);
              if (localPLong.value < b.tNI) {
                break;
              }
              ad.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", new Object[] { Long.valueOf(localPLong.value) });
              break label274;
            }
          } while (((PInt)localObject3).value >= b.tNE);
          label422:
          Object localObject4 = new k();
          ((k)localObject4).mAQ = locala.mqv;
          ((k)localObject4).mAO = ((int)(com.tencent.mm.plugin.backup.h.d.bxT().bxU().apO().agI(locala.mqv) / 1000L));
          ((k)localObject4).mAP = i;
          ((LinkedList)localObject2).add(localObject4);
          ((PInt)localObject3).value += 1;
          if (localPInt.value < b.tNC) {
            c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.tNN);
          }
        }
        label554:
        if (!paramd.action.equals(b.tNy))
        {
          localObject3 = new l();
          ((l)localObject3).mAR = ((LinkedList)localObject2);
          ((l)localObject3).mAS = com.tencent.mm.bk.d.aCo().eLD();
        }
        try
        {
          localObject2 = ((l)localObject3).toByteArray();
          g.e(g.cRv(), "sessionlist", (byte[])localObject2);
          ad.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
          com.tencent.mm.vfs.i.lG(g.cRw(), g.cRx());
          long l1 = com.tencent.mm.vfs.i.aMN(g.cRx());
          ad.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", new Object[] { Integer.valueOf(localPInt.value), Long.valueOf(localPLong.value), Long.valueOf(l1 / 1024L), Long.valueOf(bt.vM(l2)) });
          localObject2 = paramd;
          l2 = localPInt.value;
          long l3 = localPLong.value;
          l1 /= 1024L;
          ((d)localObject2).tNQ = l2;
          ((d)localObject2).tNR = l3;
          ((d)localObject2).tNS = l1;
          ((d)localObject2).fki = new String((String)localObject1);
          if (c.this.tNK != null) {
            c.this.tNK.a(paramd, g.cRx(), paramLinkedList.size());
          }
          AppMethodBeat.o(26517);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[] { Integer.valueOf(((l)localObject3).mAR.size()), localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.Iye.aS(paramd);
    AppMethodBeat.o(26520);
  }
  
  public final boolean a(d paramd, a parama, long paramLong1, long paramLong2, String paramString, int paramInt1, PInt paramPInt, PLong paramPLong, int paramInt2)
  {
    AppMethodBeat.i(26521);
    boolean bool = paramd.action.equals(b.tNy);
    com.tencent.mm.model.az.arV();
    if (af.Wy(com.tencent.mm.model.c.apM().aHY(parama.mqv).field_verifyFlag))
    {
      AppMethodBeat.o(26521);
      return true;
    }
    ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", new Object[] { parama.mqv, Integer.valueOf(paramInt1) });
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = new ArrayList(paramInt2);
    int i = com.tencent.mm.plugin.backup.h.d.bxT().bxU().apO().G(parama.mqv, paramLong1, paramLong2);
    if (i <= 0)
    {
      ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.backup.h.d.bxT().bxU().apO().a(parama.mqv, paramLong1, paramLong2, paramInt2);
    if (bool)
    {
      if (i <= paramInt2) {
        break label221;
      }
      paramd.tNU = 0;
    }
    while (((Cursor)localObject2).moveToNext()) {
      if (this.tNJ)
      {
        ad.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
        ((Cursor)localObject2).close();
        AppMethodBeat.o(26521);
        return false;
        label221:
        paramd.tNU = 1;
      }
      else
      {
        paramd = new bl();
        paramd.convertFrom((Cursor)localObject2);
        if ((paramd.field_createTime >= paramLong1) && (paramd.field_createTime <= paramLong2)) {
          ((ArrayList)localObject1).add(paramd);
        }
      }
    }
    ((Cursor)localObject2).close();
    if (((ArrayList)localObject1).size() <= 0)
    {
      ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramd = (bl)((Iterator)localObject1).next();
        if (this.tNJ)
        {
          ad.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
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
            ad.d("MicroMsg.MsgSynchronizePack", "bakItem:%s", new Object[] { paramd.toString() });
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
            ad.printErrStackTrace("MicroMsg.MsgSynchronizePack", paramd, "packMsg", new Object[0]);
            paramd = null;
          }
        }
      }
    }
    ad.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    paramd = new hv();
    paramd.mAL = localLinkedList1;
    paramd.mAK = localLinkedList1.size();
    try
    {
      paramString = paramd.toByteArray();
      parama = "MSG_" + localLinkedList1.size() + "_" + parama.mqv + "_" + bt.eGO();
      g.e(g.cRv(), parama, paramString);
      ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", new Object[] { parama });
      paramPInt.value += 1;
      AppMethodBeat.o(26521);
      return true;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", new Object[] { Integer.valueOf(paramd.mAK), parama.getMessage() });
      }
    }
  }
  
  public final LinkedList<a> cRu()
  {
    AppMethodBeat.i(26518);
    long l = bt.eGO();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = com.tencent.mm.plugin.backup.h.d.bxT().bxU().apR().c(w.gMn, com.tencent.mm.plugin.backup.b.g.bwk(), "*");
    if (localCursor.getCount() == 0)
    {
      ad.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
      localCursor.close();
      AppMethodBeat.o(26518);
      return localLinkedList;
    }
    ad.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    int i = 0;
    for (;;)
    {
      if (localCursor.moveToNext())
      {
        if (this.tNJ)
        {
          localCursor.close();
          ad.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
          AppMethodBeat.o(26518);
          return localLinkedList;
        }
        if (i >= b.tNE) {
          ad.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        localCursor.close();
        ad.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bt.vM(l));
        AppMethodBeat.o(26518);
        return localLinkedList;
      }
      am localam = new am();
      localam.convertFrom(localCursor);
      if (!bt.isNullOrNil(localam.field_username))
      {
        int j = com.tencent.mm.plugin.backup.h.d.bxT().bxU().apO().agE(localam.field_username);
        ad.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", new Object[] { localam.field_username, Integer.valueOf(j), Integer.valueOf(i) });
        if (j > 0)
        {
          localLinkedList.add(new a(localam.field_username));
          i += 1;
        }
      }
    }
  }
  
  public static final class a
  {
    public String mqv;
    
    public a(String paramString)
    {
      this.mqv = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.c
 * JD-Core Version:    0.7.0.1
 */