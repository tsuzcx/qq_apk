package com.tencent.mm.plugin.q;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  boolean zGa = false;
  a.a zGb;
  
  public static LinkedList<a> aFu(String paramString)
  {
    AppMethodBeat.i(26519);
    LinkedList localLinkedList = new LinkedList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26519);
      return localLinkedList;
    }
    int i = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().aEM(paramString);
    Log.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", new Object[] { paramString, Integer.valueOf(i) });
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
    paramd = new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "msgSynchronizePackThread";
      }
      
      public final void run()
      {
        AppMethodBeat.i(26517);
        long l2 = Util.nowMilliSecond();
        int i;
        if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
        {
          if (paramLinkedList == null) {}
          for (i = -1;; i = paramLinkedList.size())
          {
            Log.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", new Object[] { Integer.valueOf(i) });
            if (c.this.zGb != null) {
              c.this.zGb.onCancel();
            }
            AppMethodBeat.o(26517);
            return;
          }
        }
        com.tencent.mm.plugin.backup.b.g.agw(g.elw());
        com.tencent.mm.plugin.backup.b.g.agw(g.elx());
        Object localObject1 = new StringBuilder();
        bg.aVF();
        com.tencent.mm.plugin.backup.b.g.agw(com.tencent.mm.model.c.getAccPath() + "msgsynchronize/");
        localObject1 = new StringBuilder();
        bg.aVF();
        com.tencent.mm.plugin.backup.b.g.agw(com.tencent.mm.model.c.getAccPath() + "msgsynchronize.zip");
        Object localObject2 = new LinkedList();
        localObject1 = (String)com.tencent.mm.plugin.backup.h.d.cgP().cgQ().azQ().get(2, null);
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
            if (!c.this.zGa) {
              break label298;
            }
            Log.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
          }
          label274:
          label298:
          do
          {
            if (!c.this.zGa) {
              break label554;
            }
            Log.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
            AppMethodBeat.o(26517);
            return;
            localObject4 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aST().bjY(locala.oJo);
            if (localObject4 != null) {}
            for (i = ((bb)localObject4).field_unReadCount;; i = 0)
            {
              if (!paramd.action.equals(b.zFP)) {
                break label422;
              }
              c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.zGe);
              if (localPLong.value < b.zFZ) {
                break;
              }
              Log.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", new Object[] { Long.valueOf(localPLong.value) });
              break label274;
            }
          } while (((PInt)localObject3).value >= b.zFV);
          label422:
          Object localObject4 = new k();
          ((k)localObject4).UserName = locala.oJo;
          ((k)localObject4).oTD = ((int)(com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().aEQ(locala.oJo) / 1000L));
          ((k)localObject4).oTE = i;
          ((LinkedList)localObject2).add(localObject4);
          ((PInt)localObject3).value += 1;
          if (localPInt.value < b.zFT) {
            c.this.a(paramd, locala, paramLong1, paramInt, (String)localObject1, i, localPInt, localPLong, this.zGe);
          }
        }
        label554:
        if (!paramd.action.equals(b.zFP))
        {
          localObject3 = new l();
          ((l)localObject3).oTF = ((LinkedList)localObject2);
          ((l)localObject3).oTG = com.tencent.mm.bj.d.bgN().gCR();
        }
        try
        {
          localObject2 = ((l)localObject3).toByteArray();
          g.e(g.elv(), "sessionlist", (byte[])localObject2);
          Log.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
          s.nz(g.elw(), g.elx());
          long l1 = s.boW(g.elx());
          Log.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", new Object[] { Integer.valueOf(localPInt.value), Long.valueOf(localPLong.value), Long.valueOf(l1 / 1024L), Long.valueOf(Util.milliSecondsToNow(l2)) });
          localObject2 = paramd;
          l2 = localPInt.value;
          long l3 = localPLong.value;
          l1 /= 1024L;
          ((d)localObject2).zGh = l2;
          ((d)localObject2).zGi = l3;
          ((d)localObject2).zGj = l1;
          ((d)localObject2).gna = new String((String)localObject1);
          if (c.this.zGb != null) {
            c.this.zGb.a(paramd, g.elx(), paramLinkedList.size());
          }
          AppMethodBeat.o(26517);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[] { Integer.valueOf(((l)localObject3).oTF.size()), localException.getMessage() });
          }
        }
      }
    };
    com.tencent.f.h.RTc.ba(paramd);
    AppMethodBeat.o(26520);
  }
  
  public final boolean a(d paramd, a parama, long paramLong1, long paramLong2, String paramString, int paramInt1, PInt paramPInt, PLong paramPLong, int paramInt2)
  {
    AppMethodBeat.i(26521);
    boolean bool = paramd.action.equals(b.zFP);
    bg.aVF();
    if (as.akh(com.tencent.mm.model.c.aSN().Kn(parama.oJo).field_verifyFlag))
    {
      AppMethodBeat.o(26521);
      return true;
    }
    Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", new Object[] { parama.oJo, Integer.valueOf(paramInt1) });
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = new ArrayList(paramInt2);
    int i = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().G(parama.oJo, paramLong1, paramLong2);
    if (i <= 0)
    {
      Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().b(parama.oJo, paramLong1, paramLong2, paramInt2);
    if (bool)
    {
      if (i <= paramInt2) {
        break label221;
      }
      paramd.zGl = 0;
    }
    label293:
    while (((Cursor)localObject2).moveToNext()) {
      if (this.zGa)
      {
        Log.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
        ((Cursor)localObject2).close();
        AppMethodBeat.o(26521);
        return false;
        label221:
        paramd.zGl = 1;
      }
      else
      {
        paramd = new ca();
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
      Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(26521);
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramd = (ca)((Iterator)localObject1).next();
        if (this.zGa)
        {
          Log.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
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
            Log.d("MicroMsg.MsgSynchronizePack", "bakItem:%s", new Object[] { paramd.toString() });
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
            Log.printErrStackTrace("MicroMsg.MsgSynchronizePack", paramd, "packMsg", new Object[0]);
            paramd = null;
          }
        }
      }
    }
    Log.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    paramd = new it();
    paramd.oTA = localLinkedList1;
    paramd.oTz = localLinkedList1.size();
    try
    {
      paramString = paramd.toByteArray();
      parama = "MSG_" + localLinkedList1.size() + "_" + parama.oJo + "_" + Util.nowMilliSecond();
      g.e(g.elv(), parama, paramString);
      Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", new Object[] { parama });
      paramPInt.value += 1;
      AppMethodBeat.o(26521);
      return true;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", new Object[] { Integer.valueOf(paramd.oTz), parama.getMessage() });
      }
    }
  }
  
  public final LinkedList<a> elu()
  {
    AppMethodBeat.i(26518);
    long l = Util.nowMilliSecond();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aST().c(ab.iCF, com.tencent.mm.plugin.backup.b.g.cfd(), "*");
    if (localCursor.getCount() == 0)
    {
      Log.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
      localCursor.close();
      AppMethodBeat.o(26518);
      return localLinkedList;
    }
    Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    int i = 0;
    for (;;)
    {
      if (localCursor.moveToNext())
      {
        if (this.zGa)
        {
          localCursor.close();
          Log.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
          AppMethodBeat.o(26518);
          return localLinkedList;
        }
        if (i >= b.zFV) {
          Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        localCursor.close();
        Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + Util.milliSecondsToNow(l));
        AppMethodBeat.o(26518);
        return localLinkedList;
      }
      az localaz = new az();
      localaz.convertFrom(localCursor);
      if (!Util.isNullOrNil(localaz.field_username))
      {
        int j = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().aEM(localaz.field_username);
        Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", new Object[] { localaz.field_username, Integer.valueOf(j), Integer.valueOf(i) });
        if (j > 0)
        {
          localLinkedList.add(new a(localaz.field_username));
          i += 1;
        }
      }
    }
  }
  
  public static final class a
  {
    public String oJo;
    
    public a(String paramString)
    {
      this.oJo = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.q.c
 * JD-Core Version:    0.7.0.1
 */