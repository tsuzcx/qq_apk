package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.e.d.b;
import com.tencent.mm.ui.chatting.e.d.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements e<bi>
{
  Cursor JM;
  String drJ;
  private boolean mbA;
  int vzA;
  private Bundle vzB;
  private d.d vzC;
  private d.a vzw;
  long vzx;
  long vzy;
  private long vzz;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    this.vzz = paramLong1;
    this.vzx = paramLong2;
    this.vzy = paramLong3;
    this.vzA = paramInt;
    this.drJ = paramString;
    this.vzw = parama;
    this.vzB = paramBundle;
    this.vzC = paramd;
    this.mbA = paramBoolean;
    y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.vzx + " mLastBottomCreateTime:" + this.vzy + " isFromSearch:" + paramBoolean + " mLastCount:" + this.vzA + " mLastBottomMsgSeq:" + this.vzz + " mTalker:" + this.drJ + " action:" + parama);
  }
  
  private void b(d.b paramb)
  {
    long l1 = cGV();
    long l2 = cGX();
    y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.drJ, l1, l2, 18);
    paramb.cN();
  }
  
  private void c(d.b paramb)
  {
    boolean bool;
    if ((this.vzC.vyi != null) && (this.vzC.vyi.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.vzC.vyi == null) || (!this.vzC.vyi.getBoolean("has_position_search", false))) {
        break label163;
      }
    }
    label163:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label168;
      }
      bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(this.drJ);
      if ((localbi == null) || (localbi.field_isSend != 1) || (localbi.field_msgSeq != 0L)) {
        break label168;
      }
      b(paramb);
      if (this.vzC.vyi == null) {
        this.vzC.vyi = new Bundle();
      }
      this.vzC.vyi.putBoolean("need_scroll_to_bottom", true);
      y.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      return;
      bool = false;
      break;
    }
    label168:
    if (this.vzx == 0L)
    {
      y.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.vzx = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().e(this.drJ, cGX(), 18);
    }
    long l2 = this.vzx;
    long l1;
    if (bool) {
      l1 = cGW();
    }
    for (;;)
    {
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.drJ + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.drJ, l2, l1, 2147483647);
      paramb.cN();
      return;
      if (i != 0) {
        l1 = this.vzy;
      } else {
        l1 = cGX();
      }
    }
  }
  
  private long cGW()
  {
    w localw = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().Hm(this.drJ);
    if (this.vzz > 0L)
    {
      long l = this.vzz;
      LinkedList localLinkedList = new LinkedList();
      if (localw.field_seqBlockInfo != null)
      {
        Iterator localIterator = localw.field_seqBlockInfo.dtR.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.k.a.a.c localc = (com.tencent.mm.k.a.a.c)localIterator.next();
          if (localc.dtN > l) {
            localLinkedList.add(localc);
          }
        }
      }
      if (localLinkedList.size() > 0)
      {
        y.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] mLastBottomMsgSeq:" + this.vzz + " chatroomMsgSeq:" + localw);
        return this.vzy;
      }
    }
    return cGX();
  }
  
  public final void a(d.b paramb)
  {
    boolean bool;
    switch (b.6.vzn[this.vzw.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      com.tencent.mm.k.a.a.c localc;
      do
      {
        return;
        b(paramb);
        return;
        if ((this.vzB != null) && (this.vzB.getBoolean("load_bottom", false)))
        {
          localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().Hm(this.drJ);
          l1 = ((w)localObject).field_lastPushSeq;
          l2 = ((w)localObject).field_lastLocalSeq;
          com.tencent.mm.ap.b.Oi().a(this.drJ, l1, 1L + l2, 1, new b.2(this, paramb));
          return;
        }
        localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
        localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).f(this.drJ, this.vzy, true);
        if (localc != null)
        {
          com.tencent.mm.ap.b.Oi().a(this.drJ, localc.dtN, localc.dtO, 0, new b.3(this, paramb));
          return;
        }
        y.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.drJ + " mLastBottomCreateTime:" + this.vzy);
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).Hm(this.drJ);
        l1 = ((w)localObject).field_lastPushSeq;
        l2 = ((w)localObject).field_lastLocalSeq;
        com.tencent.mm.ap.b.Oi().a(this.drJ, 1L + l2, l1, 0, new b.4(this, paramb));
        return;
        localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
        localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).K(this.drJ, this.vzx);
        StringBuilder localStringBuilder;
        if (localc == null)
        {
          l1 = 0L;
          l2 = this.vzx;
          i = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().r(this.drJ, l1, l2);
          localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.drJ).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
          if (localc != null) {
            break label570;
          }
        }
        for (bool = true;; bool = false)
        {
          y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", bool);
          if ((i < 18) && (localc != null)) {
            break label576;
          }
          l2 = this.vzy;
          y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.drJ + " from:" + l1 + " to:" + l2 + " count:" + (this.vzA + 18));
          this.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.drJ, l1, l2, this.vzA + 18);
          paramb.cN();
          return;
          l1 = localc.dtQ;
          break;
        }
      } while (localc == null);
      l1 = localc.dtO;
      l2 = localc.dtN;
      l3 = localc.dtQ;
      l4 = localc.dtP;
      com.tencent.mm.ap.b.Oi().a(this.drJ, l1, l2, 1, new b.5(this, l4, (com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject, l3, paramb));
      return;
    case 4: 
      label570:
      label576:
      c(paramb);
      return;
    }
    if (this.mbA)
    {
      l1 = this.vzB.getLong("MSG_ID");
      bool = this.vzB.getBoolean("IS_LOAD_ALL", false);
      au.Hx();
      localObject = com.tencent.mm.model.c.Fy().fd(l1);
      if (((cs)localObject).field_msgId != l1)
      {
        y.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
        paramb.cN();
        return;
      }
      l2 = ((cs)localObject).field_createTime;
      y.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.vzx), Long.valueOf(this.vzy) });
      if ((l2 < this.vzx) || (l2 > this.vzy))
      {
        l2 = ((cs)localObject).field_createTime;
        au.Hx();
        l3 = com.tencent.mm.model.c.Fy().f(this.drJ, l2, 18);
        l3 = Math.min(id(((cs)localObject).field_createTime), l3);
        y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
        this.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.drJ, l2, l3, 2147483647);
        i = 0;
      }
      for (;;)
      {
        this.vzC.nul = Math.max(0, i);
        paramb.cN();
        return;
        this.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.drJ, this.vzx, this.vzy, 2147483647);
        au.Hx();
        i = com.tencent.mm.model.c.Fy().r(this.drJ, this.vzx, l2) - 1;
        y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
      }
    }
    Object localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
    if (this.vzB == null)
    {
      bool = true;
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.vzB != null) {
        break label1226;
      }
    }
    label1226:
    for (int i = 0;; i = this.vzB.getInt("MSG_POSITION_UNREAD_COUNT"))
    {
      if (i <= 0) {
        break label1240;
      }
      l1 = cGW();
      l2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().e(this.drJ, l1, i);
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.drJ + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
      this.JM = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().d(this.drJ, l2, l1, 2147483647);
      paramb.cN();
      return;
      bool = false;
      break;
    }
    label1240:
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).Hl(this.drJ);
    if (localObject == null)
    {
      y.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.drJ });
      d(paramb);
      return;
    }
    long l1 = ((com.tencent.mm.k.a.a.c)localObject).dtN;
    long l2 = ((com.tencent.mm.k.a.a.c)localObject).dtP;
    long l3 = ((com.tencent.mm.k.a.a.c)localObject).dtO;
    long l4 = ((com.tencent.mm.k.a.a.c)localObject).dtQ;
    com.tencent.mm.ap.b.Oi().a(this.drJ, l1, l3, 0, new b.1(this, l2, l4, paramb));
  }
  
  public final int cDk()
  {
    au.Hx();
    return com.tencent.mm.model.c.Fy().HP(this.drJ);
  }
  
  final long cGV()
  {
    com.tencent.mm.k.a.a.c localc = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().Hl(this.drJ);
    if (localc != null)
    {
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.dtQ + " seq:" + localc.dtN + "~" + localc.dtO);
      return localc.dtQ;
    }
    return this.vzx;
  }
  
  final long cGX()
  {
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HV(this.drJ);
  }
  
  public final void close()
  {
    if (this.JM != null) {
      this.JM.close();
    }
  }
  
  final void d(d.b paramb)
  {
    y.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
    c(paramb);
  }
  
  public final void ei(List<bi> paramList)
  {
    this.JM.moveToFirst();
    while (!this.JM.isAfterLast())
    {
      bi localbi = new bi();
      localbi.d(this.JM);
      paramList.add(localbi);
      this.JM.moveToNext();
    }
  }
  
  final long id(long paramLong)
  {
    com.tencent.mm.k.a.a.c localc = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ().f(this.drJ, paramLong, true);
    if (localc != null)
    {
      y.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.dtP + " time:" + paramLong);
      return localc.dtP;
    }
    return cGX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b
 * JD-Core Version:    0.7.0.1
 */