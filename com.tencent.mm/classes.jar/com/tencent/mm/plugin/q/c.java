package com.tencent.mm.plugin.q;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  a.a oSA;
  boolean oSz = false;
  
  public static LinkedList<c.a> Ue(String paramString)
  {
    AppMethodBeat.i(22895);
    LinkedList localLinkedList = new LinkedList();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22895);
      return localLinkedList;
    }
    int i = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().TA(paramString);
    ab.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", new Object[] { paramString, Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(22895);
      return localLinkedList;
    }
    localLinkedList.add(new c.a(paramString));
    AppMethodBeat.o(22895);
    return localLinkedList;
  }
  
  public final void a(d paramd, LinkedList<c.a> paramLinkedList, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(22896);
    com.tencent.mm.sdk.g.d.a(new c.1(this, paramLinkedList, paramd, paramLong1, paramLong2, paramInt), "msgSynchronizePackThread", 10).start();
    AppMethodBeat.o(22896);
  }
  
  public final boolean a(d paramd, c.a parama, long paramLong1, long paramLong2, String paramString, int paramInt1, PInt paramPInt, PLong paramPLong, int paramInt2)
  {
    AppMethodBeat.i(22897);
    boolean bool = paramd.action.equals(b.oSo);
    aw.aaz();
    if (ad.Nt(com.tencent.mm.model.c.YA().arw(parama.jyY).field_verifyFlag))
    {
      AppMethodBeat.o(22897);
      return true;
    }
    ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", new Object[] { parama.jyY, Integer.valueOf(paramInt1) });
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = new ArrayList(paramInt2);
    int i = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().B(parama.jyY, paramLong1, paramLong2);
    if (i <= 0)
    {
      ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(22897);
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().b(parama.jyY, paramLong1, paramLong2, paramInt2);
    if (bool)
    {
      if (i <= paramInt2) {
        break label221;
      }
      paramd.oSK = 0;
    }
    while (((Cursor)localObject2).moveToNext()) {
      if (this.oSz)
      {
        ab.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
        ((Cursor)localObject2).close();
        AppMethodBeat.o(22897);
        return false;
        label221:
        paramd.oSK = 1;
      }
      else
      {
        paramd = new bi();
        paramd.convertFrom((Cursor)localObject2);
        if ((paramd.field_createTime >= paramLong1) && (paramd.field_createTime <= paramLong2)) {
          ((ArrayList)localObject1).add(paramd);
        }
      }
    }
    ((Cursor)localObject2).close();
    if (((ArrayList)localObject1).size() <= 0)
    {
      ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      AppMethodBeat.o(22897);
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramd = (bi)((Iterator)localObject1).next();
        if (this.oSz)
        {
          ab.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
          AppMethodBeat.o(22897);
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
            ab.printErrStackTrace("MicroMsg.MsgSynchronizePack", paramd, "packMsg", new Object[0]);
            paramd = null;
          }
        }
      }
    }
    ab.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    paramd = new gy();
    paramd.jJv = localLinkedList1;
    paramd.jJu = localLinkedList1.size();
    try
    {
      paramString = paramd.toByteArray();
      parama = "MSG_" + localLinkedList1.size() + "_" + parama.jyY + "_" + bo.aoy();
      g.f(g.bSx(), parama, paramString);
      ab.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", new Object[] { parama });
      paramPInt.value += 1;
      AppMethodBeat.o(22897);
      return true;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", new Object[] { Integer.valueOf(paramd.jJu), parama.getMessage() });
      }
    }
  }
  
  public final LinkedList<c.a> bSw()
  {
    AppMethodBeat.i(22894);
    long l = bo.aoy();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YF().c(t.flc, com.tencent.mm.plugin.backup.b.g.aSY(), "*");
    if (localCursor.getCount() == 0)
    {
      ab.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
      localCursor.close();
      AppMethodBeat.o(22894);
      return localLinkedList;
    }
    ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    int i = 0;
    for (;;)
    {
      if (localCursor.moveToNext())
      {
        if (this.oSz)
        {
          localCursor.close();
          ab.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
          AppMethodBeat.o(22894);
          return localLinkedList;
        }
        if (i >= b.oSu) {
          ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        localCursor.close();
        ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bo.hl(l));
        AppMethodBeat.o(22894);
        return localLinkedList;
      }
      ak localak = new ak();
      localak.convertFrom(localCursor);
      if (!bo.isNullOrNil(localak.field_username))
      {
        int j = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().TA(localak.field_username);
        ab.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", new Object[] { localak.field_username, Integer.valueOf(j), Integer.valueOf(i) });
        if (j > 0)
        {
          localLinkedList.add(new c.a(localak.field_username));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.q.c
 * JD-Core Version:    0.7.0.1
 */