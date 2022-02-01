package com.tencent.mm.plugin.r;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  boolean vZu = false;
  a.a vZv;
  
  public static LinkedList<a> aqV(String paramString)
  {
    AppMethodBeat.i(26519);
    LinkedList localLinkedList = new LinkedList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26519);
      return localLinkedList;
    }
    int i = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().aqm(paramString);
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
        long l2 = bt.flT();
        int i;
        if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
        {
          if (paramLinkedList == null) {}
          for (i = -1;; i = paramLinkedList.size())
          {
            ad.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", new Object[] { Integer.valueOf(i) });
            if (c.this.vZv != null) {
              c.this.vZv.onCancel();
            }
            AppMethodBeat.o(26517);
            return;
          }
        }
        com.tencent.mm.plugin.backup.b.g.VO(g.doE());
        com.tencent.mm.plugin.backup.b.g.VO(g.doF());
        Object localObject1 = new StringBuilder();
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.plugin.backup.b.g.VO(com.tencent.mm.model.c.getAccPath() + "msgsynchronize/");
        localObject1 = new StringBuilder();
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.plugin.backup.b.g.VO(com.tencent.mm.model.c.getAccPath() + "msgsynchronize.zip");
        Object localObject2 = new LinkedList();
        localObject1 = (String)com.tencent.mm.plugin.backup.h.d.bIY().bIZ().ajl().get(2, null);
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
            if (!c.this.vZu) {
              break label298;
            }
            ad.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
          }
          label274:
          label298:
          do
          {
            if (!c.this.vZu) {
              break label554;
            }
            ad.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
            AppMethodBeat.o(26517);
            return;
            localObject4 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azv().aTz(locala.nsV);
            if (localObject4 != null) {}
            for (i = ((com.tencent.mm.g.c.ba)localObject4).field_unReadCount;; i = 0)
            {
              if (!paramd.action.equals(b.vZj)) {
                break label422;
              }
              c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.vZy);
              if (localPLong.value < b.vZt) {
                break;
              }
              ad.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", new Object[] { Long.valueOf(localPLong.value) });
              break label274;
            }
          } while (((PInt)localObject3).value >= b.vZp);
          label422:
          Object localObject4 = new k();
          ((k)localObject4).nDo = locala.nsV;
          ((k)localObject4).nDm = ((int)(com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().aqq(locala.nsV) / 1000L));
          ((k)localObject4).nDn = i;
          ((LinkedList)localObject2).add(localObject4);
          ((PInt)localObject3).value += 1;
          if (localPInt.value < b.vZn) {
            c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.vZy);
          }
        }
        label554:
        if (!paramd.action.equals(b.vZj))
        {
          localObject3 = new l();
          ((l)localObject3).nDp = ((LinkedList)localObject2);
          ((l)localObject3).nDq = com.tencent.mm.bk.d.aMo().frk();
        }
        try
        {
          localObject2 = ((l)localObject3).toByteArray();
          g.e(g.doD(), "sessionlist", (byte[])localObject2);
          ad.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
          com.tencent.mm.vfs.i.mC(g.doE(), g.doF());
          long l1 = com.tencent.mm.vfs.i.aYo(g.doF());
          ad.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", new Object[] { Integer.valueOf(localPInt.value), Long.valueOf(localPLong.value), Long.valueOf(l1 / 1024L), Long.valueOf(bt.Df(l2)) });
          localObject2 = paramd;
          l2 = localPInt.value;
          long l3 = localPLong.value;
          l1 /= 1024L;
          ((d)localObject2).vZB = l2;
          ((d)localObject2).vZC = l3;
          ((d)localObject2).vZD = l1;
          ((d)localObject2).fFK = new String((String)localObject1);
          if (c.this.vZv != null) {
            c.this.vZv.a(paramd, g.doF(), paramLinkedList.size());
          }
          AppMethodBeat.o(26517);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[] { Integer.valueOf(((l)localObject3).nDp.size()), localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.LTJ.aU(paramd);
    AppMethodBeat.o(26520);
  }
  
  public final boolean a(d paramd, a parama, long paramLong1, long paramLong2, String paramString, int paramInt1, PInt paramPInt, PLong paramPLong, int paramInt2)
  {
    AppMethodBeat.i(26521);
    boolean bool = paramd.action.equals(b.vZj);
    com.tencent.mm.model.ba.aBQ();
    if (am.aaR(com.tencent.mm.model.c.azp().Bf(parama.nsV).field_verifyFlag))
    {
      AppMethodBeat.o(26521);
      return true;
    }
    ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", new Object[] { parama.nsV, Integer.valueOf(paramInt1) });
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = new ArrayList(paramInt2);
    int i = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().F(parama.nsV, paramLong1, paramLong2);
    if (i <= 0)
    {
      ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().b(parama.nsV, paramLong1, paramLong2, paramInt2);
    if (bool)
    {
      if (i <= paramInt2) {
        break label221;
      }
      paramd.vZF = 0;
    }
    label293:
    while (((Cursor)localObject2).moveToNext()) {
      if (this.vZu)
      {
        ad.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
        ((Cursor)localObject2).close();
        AppMethodBeat.o(26521);
        return false;
        label221:
        paramd.vZF = 1;
      }
      else
      {
        paramd = new bu();
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
      ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramd = (bu)((Iterator)localObject1).next();
        if (this.vZu)
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
    paramd = new ig();
    paramd.nDj = localLinkedList1;
    paramd.nDi = localLinkedList1.size();
    try
    {
      paramString = paramd.toByteArray();
      parama = "MSG_" + localLinkedList1.size() + "_" + parama.nsV + "_" + bt.flT();
      g.e(g.doD(), parama, paramString);
      ad.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", new Object[] { parama });
      paramPInt.value += 1;
      AppMethodBeat.o(26521);
      return true;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", new Object[] { Integer.valueOf(paramd.nDi), parama.getMessage() });
      }
    }
  }
  
  public final LinkedList<a> doC()
  {
    AppMethodBeat.i(26518);
    long l = bt.flT();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azv().c(w.hFd, com.tencent.mm.plugin.backup.b.g.bHo(), "*");
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
        if (this.vZu)
        {
          localCursor.close();
          ad.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
          AppMethodBeat.o(26518);
          return localLinkedList;
        }
        if (i >= b.vZp) {
          ad.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        localCursor.close();
        ad.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bt.Df(l));
        AppMethodBeat.o(26518);
        return localLinkedList;
      }
      at localat = new at();
      localat.convertFrom(localCursor);
      if (!bt.isNullOrNil(localat.field_username))
      {
        int j = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().aqm(localat.field_username);
        ad.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", new Object[] { localat.field_username, Integer.valueOf(j), Integer.valueOf(i) });
        if (j > 0)
        {
          localLinkedList.add(new a(localat.field_username));
          i += 1;
        }
      }
    }
  }
  
  public static final class a
  {
    public String nsV;
    
    public a(String paramString)
    {
      this.nsV = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.c
 * JD-Core Version:    0.7.0.1
 */