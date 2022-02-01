package com.tencent.mm.plugin.r;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  boolean uWm = false;
  a.a uWn;
  
  public static LinkedList<a> amg(String paramString)
  {
    AppMethodBeat.i(26519);
    LinkedList localLinkedList = new LinkedList();
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26519);
      return localLinkedList;
    }
    int i = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().aly(paramString);
    ac.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", new Object[] { paramString, Integer.valueOf(i) });
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
        long l2 = bs.eWj();
        int i;
        if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
        {
          if (paramLinkedList == null) {}
          for (i = -1;; i = paramLinkedList.size())
          {
            ac.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", new Object[] { Integer.valueOf(i) });
            if (c.this.uWn != null) {
              c.this.uWn.onCancel();
            }
            AppMethodBeat.o(26517);
            return;
          }
        }
        com.tencent.mm.plugin.backup.b.g.Sq(g.dfg());
        com.tencent.mm.plugin.backup.b.g.Sq(g.dfh());
        Object localObject1 = new StringBuilder();
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.plugin.backup.b.g.Sq(com.tencent.mm.model.c.getAccPath() + "msgsynchronize/");
        localObject1 = new StringBuilder();
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.plugin.backup.b.g.Sq(com.tencent.mm.model.c.getAccPath() + "msgsynchronize.zip");
        Object localObject2 = new LinkedList();
        localObject1 = (String)com.tencent.mm.plugin.backup.h.d.bEP().bEQ().agA().get(2, null);
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
            if (!c.this.uWm) {
              break label298;
            }
            ac.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
          }
          label274:
          label298:
          do
          {
            if (!c.this.uWm) {
              break label554;
            }
            ac.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
            AppMethodBeat.o(26517);
            return;
            localObject4 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awG().aNI(locala.mSx);
            if (localObject4 != null) {}
            for (i = ((com.tencent.mm.g.c.az)localObject4).field_unReadCount;; i = 0)
            {
              if (!paramd.action.equals(b.uWb)) {
                break label422;
              }
              c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.uWq);
              if (localPLong.value < b.uWl) {
                break;
              }
              ac.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", new Object[] { Long.valueOf(localPLong.value) });
              break label274;
            }
          } while (((PInt)localObject3).value >= b.uWh);
          label422:
          Object localObject4 = new k();
          ((k)localObject4).ncR = locala.mSx;
          ((k)localObject4).ncP = ((int)(com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().alC(locala.mSx) / 1000L));
          ((k)localObject4).ncQ = i;
          ((LinkedList)localObject2).add(localObject4);
          ((PInt)localObject3).value += 1;
          if (localPInt.value < b.uWf) {
            c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.uWq);
          }
        }
        label554:
        if (!paramd.action.equals(b.uWb))
        {
          localObject3 = new l();
          ((l)localObject3).ncS = ((LinkedList)localObject2);
          ((l)localObject3).ncT = com.tencent.mm.bj.d.aJe().fbh();
        }
        try
        {
          localObject2 = ((l)localObject3).toByteArray();
          g.e(g.dff(), "sessionlist", (byte[])localObject2);
          ac.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
          com.tencent.mm.vfs.i.mc(g.dfg(), g.dfh());
          long l1 = com.tencent.mm.vfs.i.aSp(g.dfh());
          ac.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", new Object[] { Integer.valueOf(localPInt.value), Long.valueOf(localPLong.value), Long.valueOf(l1 / 1024L), Long.valueOf(bs.Ap(l2)) });
          localObject2 = paramd;
          l2 = localPInt.value;
          long l3 = localPLong.value;
          l1 /= 1024L;
          ((d)localObject2).uWt = l2;
          ((d)localObject2).uWu = l3;
          ((d)localObject2).uWv = l1;
          ((d)localObject2).fnC = new String((String)localObject1);
          if (c.this.uWn != null) {
            c.this.uWn.a(paramd, g.dfh(), paramLinkedList.size());
          }
          AppMethodBeat.o(26517);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[] { Integer.valueOf(((l)localObject3).ncS.size()), localException.getMessage() });
          }
        }
      }
    };
    com.tencent.e.h.JZN.aV(paramd);
    AppMethodBeat.o(26520);
  }
  
  public final boolean a(d paramd, a parama, long paramLong1, long paramLong2, String paramString, int paramInt1, PInt paramPInt, PLong paramPLong, int paramInt2)
  {
    AppMethodBeat.i(26521);
    boolean bool = paramd.action.equals(b.uWb);
    com.tencent.mm.model.az.ayM();
    if (ai.YI(com.tencent.mm.model.c.awB().aNt(parama.mSx).field_verifyFlag))
    {
      AppMethodBeat.o(26521);
      return true;
    }
    ac.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", new Object[] { parama.mSx, Integer.valueOf(paramInt1) });
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = new ArrayList(paramInt2);
    int i = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().E(parama.mSx, paramLong1, paramLong2);
    if (i <= 0)
    {
      ac.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().b(parama.mSx, paramLong1, paramLong2, paramInt2);
    if (bool)
    {
      if (i <= paramInt2) {
        break label221;
      }
      paramd.uWx = 0;
    }
    while (((Cursor)localObject2).moveToNext()) {
      if (this.uWm)
      {
        ac.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
        ((Cursor)localObject2).close();
        AppMethodBeat.o(26521);
        return false;
        label221:
        paramd.uWx = 1;
      }
      else
      {
        paramd = new bo();
        paramd.convertFrom((Cursor)localObject2);
        if ((paramd.field_createTime >= paramLong1) && (paramd.field_createTime <= paramLong2)) {
          ((ArrayList)localObject1).add(paramd);
        }
      }
    }
    ((Cursor)localObject2).close();
    if (((ArrayList)localObject1).size() <= 0)
    {
      ac.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramd = (bo)((Iterator)localObject1).next();
        if (this.uWm)
        {
          ac.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
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
            ac.d("MicroMsg.MsgSynchronizePack", "bakItem:%s", new Object[] { paramd.toString() });
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
            ac.printErrStackTrace("MicroMsg.MsgSynchronizePack", paramd, "packMsg", new Object[0]);
            paramd = null;
          }
        }
      }
    }
    ac.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    paramd = new hz();
    paramd.ncM = localLinkedList1;
    paramd.ncL = localLinkedList1.size();
    try
    {
      paramString = paramd.toByteArray();
      parama = "MSG_" + localLinkedList1.size() + "_" + parama.mSx + "_" + bs.eWj();
      g.e(g.dff(), parama, paramString);
      ac.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", new Object[] { parama });
      paramPInt.value += 1;
      AppMethodBeat.o(26521);
      return true;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", new Object[] { Integer.valueOf(paramd.ncL), parama.getMessage() });
      }
    }
  }
  
  public final LinkedList<a> dfe()
  {
    AppMethodBeat.i(26518);
    long l = bs.eWj();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awG().c(w.hmN, com.tencent.mm.plugin.backup.b.g.bDg(), "*");
    if (localCursor.getCount() == 0)
    {
      ac.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
      localCursor.close();
      AppMethodBeat.o(26518);
      return localLinkedList;
    }
    ac.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    int i = 0;
    for (;;)
    {
      if (localCursor.moveToNext())
      {
        if (this.uWm)
        {
          localCursor.close();
          ac.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
          AppMethodBeat.o(26518);
          return localLinkedList;
        }
        if (i >= b.uWh) {
          ac.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        localCursor.close();
        ac.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bs.Ap(l));
        AppMethodBeat.o(26518);
        return localLinkedList;
      }
      ap localap = new ap();
      localap.convertFrom(localCursor);
      if (!bs.isNullOrNil(localap.field_username))
      {
        int j = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().aly(localap.field_username);
        ac.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", new Object[] { localap.field_username, Integer.valueOf(j), Integer.valueOf(i) });
        if (j > 0)
        {
          localLinkedList.add(new a(localap.field_username));
          i += 1;
        }
      }
    }
  }
  
  public static final class a
  {
    public String mSx;
    
    public a(String paramString)
    {
      this.mSx = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.c
 * JD-Core Version:    0.7.0.1
 */