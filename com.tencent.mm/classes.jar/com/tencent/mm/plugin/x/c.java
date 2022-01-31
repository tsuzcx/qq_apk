package com.tencent.mm.plugin.x;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  boolean msO = false;
  a.a msP;
  
  public final void a(d paramd, LinkedList<c.a> paramLinkedList, long paramLong1, long paramLong2, int paramInt)
  {
    e.c(new c.1(this, paramLinkedList, paramd, paramLong1, paramLong2, paramInt), "msgSynchronizePackThread", 10).start();
  }
  
  public final boolean a(d paramd, c.a parama, long paramLong1, long paramLong2, String paramString, int paramInt1, PInt paramPInt, PLong paramPLong, int paramInt2)
  {
    boolean bool = paramd.action.equals(b.msD);
    au.Hx();
    if (ad.Fn(com.tencent.mm.model.c.Fw().abl(parama.hFB).field_verifyFlag)) {
      return true;
    }
    y.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", new Object[] { parama.hFB, Integer.valueOf(paramInt1) });
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = new ArrayList(paramInt2);
    int i = com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().t(parama.hFB, paramLong1, paramLong2);
    if (i <= 0)
    {
      y.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().b(parama.hFB, paramLong1, paramLong2, paramInt2);
    if (bool)
    {
      if (i <= paramInt2) {
        break label197;
      }
      paramd.msZ = 0;
    }
    while (((Cursor)localObject2).moveToNext()) {
      if (this.msO)
      {
        y.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
        ((Cursor)localObject2).close();
        return false;
        label197:
        paramd.msZ = 1;
      }
      else
      {
        paramd = new bi();
        paramd.d((Cursor)localObject2);
        if ((paramd.field_createTime >= paramLong1) && (paramd.field_createTime <= paramLong2)) {
          ((ArrayList)localObject1).add(paramd);
        }
      }
    }
    ((Cursor)localObject2).close();
    if (((ArrayList)localObject1).size() <= 0)
    {
      y.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        paramd = (bi)((Iterator)localObject1).next();
        if (this.msO)
        {
          y.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
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
            paramd = h.a(paramd, false, paramString, (PLong)localObject2, localLinkedList2, null, bool, true, 0L);
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
            y.printErrStackTrace("MicroMsg.MsgSynchronizePack", paramd, "packMsg", new Object[0]);
            paramd = null;
          }
        }
      }
    }
    y.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
    paramd = new fp();
    paramd.hPT = localLinkedList1;
    paramd.hPS = localLinkedList1.size();
    try
    {
      paramString = paramd.toByteArray();
      parama = "MSG_" + localLinkedList1.size() + "_" + parama.hFB + "_" + bk.UY();
      g.f(g.bkx(), parama, paramString);
      y.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", new Object[] { parama });
      paramPInt.value += 1;
      return true;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        y.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", new Object[] { Integer.valueOf(paramd.hPS), parama.getMessage() });
      }
    }
  }
  
  public final LinkedList<c.a> bkw()
  {
    long l = bk.UY();
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = com.tencent.mm.plugin.backup.h.d.avi().avj().FB().c(s.dUT, com.tencent.mm.plugin.backup.b.g.atA(), "*");
    if (localCursor.getCount() == 0)
    {
      y.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
      localCursor.close();
      return localLinkedList;
    }
    y.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", new Object[] { Integer.valueOf(localCursor.getCount()) });
    int i = 0;
    for (;;)
    {
      if (localCursor.moveToNext())
      {
        if (this.msO)
        {
          localCursor.close();
          y.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
          return localLinkedList;
        }
        if (i >= b.msJ) {
          y.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        localCursor.close();
        y.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bk.co(l));
        return localLinkedList;
      }
      ak localak = new ak();
      localak.d(localCursor);
      if (!bk.bl(localak.field_username))
      {
        int j = com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().HP(localak.field_username);
        y.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", new Object[] { localak.field_username, Integer.valueOf(j), Integer.valueOf(i) });
        if (j > 0)
        {
          localLinkedList.add(new c.a(localak.field_username));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.x.c
 * JD-Core Version:    0.7.0.1
 */