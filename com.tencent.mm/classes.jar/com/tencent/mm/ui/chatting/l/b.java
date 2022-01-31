package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.b;
import com.tencent.mm.ui.chatting.f.d.d;
import java.util.List;

public final class b
  implements e<bi>
{
  Cursor Js;
  String ejr;
  private boolean oCb;
  private d.a zPT;
  long zPU;
  long zPV;
  private long zPW;
  int zPX;
  private Bundle zPY;
  private d.d zPZ;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(32693);
    this.zPW = paramLong1;
    this.zPU = paramLong2;
    this.zPV = paramLong3;
    this.zPX = paramInt;
    this.ejr = paramString;
    this.zPT = parama;
    this.zPY = paramBundle;
    this.zPZ = paramd;
    this.oCb = paramBoolean;
    ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.zPU + " mLastBottomCreateTime:" + this.zPV + " isFromSearch:" + paramBoolean + " mLastCount:" + this.zPX + " mLastBottomMsgSeq:" + this.zPW + " mTalker:" + this.ejr + " action:" + parama);
    AppMethodBeat.o(32693);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(32695);
    long l1 = dLh();
    long l2 = dLk();
    ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.Js = ((j)g.E(j.class)).bPQ().d(this.ejr, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(32695);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(32696);
    boolean bool;
    if ((this.zPZ.zOD != null) && (this.zPZ.zOD.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.zPZ.zOD == null) || (!this.zPZ.zOD.getBoolean("has_position_search", false))) {
        break label175;
      }
    }
    label175:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label180;
      }
      bi localbi = ((j)g.E(j.class)).bPQ().Tm(this.ejr);
      if ((localbi == null) || (localbi.field_isSend != 1) || (localbi.field_msgSeq != 0L)) {
        break label180;
      }
      b(paramb);
      if (this.zPZ.zOD == null) {
        this.zPZ.zOD = new Bundle();
      }
      this.zPZ.zOD.putBoolean("need_scroll_to_bottom", true);
      ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(32696);
      return;
      bool = false;
      break;
    }
    label180:
    long l2 = dLj();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.zPV;; l1 = dLi())
    {
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.ejr + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.Js = ((j)g.E(j.class)).bPQ().d(this.ejr, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(32696);
      return;
    }
  }
  
  private long dLi()
  {
    AppMethodBeat.i(32702);
    w localw = ((j)g.E(j.class)).bPL().SY(this.ejr);
    if ((this.zPW > 0L) && (localw.om(this.zPW).size() > 0))
    {
      ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] mLastBottomMsgSeq:" + this.zPW + " chatroomMsgSeq:" + localw);
      l = this.zPV;
      AppMethodBeat.o(32702);
      return l;
    }
    long l = dLk();
    AppMethodBeat.o(32702);
    return l;
  }
  
  private long dLj()
  {
    AppMethodBeat.i(32703);
    if (this.zPU == 0L)
    {
      ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.zPU = ((j)g.E(j.class)).bPQ().g(this.ejr, dLk(), 18);
    }
    long l = this.zPU;
    AppMethodBeat.o(32703);
    return l;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(32694);
    switch (b.6.zPK[this.zPT.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(32694);
      return;
      b(paramb);
      AppMethodBeat.o(32694);
      return;
      if ((this.zPY != null) && (this.zPY.getBoolean("load_bottom", false)))
      {
        localObject = ((j)g.E(j.class)).bPL().SY(this.ejr);
        l1 = ((w)localObject).field_lastPushSeq;
        l2 = ((w)localObject).field_lastLocalSeq;
        com.tencent.mm.aq.b.agX().a(this.ejr, l1, 1L + l2, 1, new b.2(this, paramb));
        AppMethodBeat.o(32694);
        return;
      }
      Object localObject = ((j)g.E(j.class)).bPL();
      com.tencent.mm.j.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).f(this.ejr, this.zPV, true);
      if (localc != null)
      {
        com.tencent.mm.aq.b.agX().a(this.ejr, localc.elA, localc.elB, 0, new b.3(this, paramb));
        AppMethodBeat.o(32694);
        return;
      }
      ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.ejr + " mLastBottomCreateTime:" + this.zPV);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).SY(this.ejr);
      long l1 = ((w)localObject).field_lastPushSeq;
      long l2 = ((w)localObject).field_lastLocalSeq;
      com.tencent.mm.aq.b.agX().a(this.ejr, 1L + l2, l1, 0, new b.4(this, paramb));
      AppMethodBeat.o(32694);
      return;
      localObject = ((j)g.E(j.class)).bPL();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).ac(this.ejr, this.zPU);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.zPU;
        i = ((j)g.E(j.class)).bPQ().z(this.ejr, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.ejr).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
        if (localc != null) {
          break label613;
        }
      }
      label613:
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", bool);
        if ((i < 18) && (localc != null)) {
          break label619;
        }
        l2 = this.zPV;
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.ejr + " from:" + l1 + " to:" + l2 + " count:" + (this.zPX + 18));
        this.Js = ((j)g.E(j.class)).bPQ().d(this.ejr, l1, l2, this.zPX + 18);
        paramb.next();
        AppMethodBeat.o(32694);
        return;
        l1 = localc.elD;
        break;
      }
      label619:
      if (localc != null)
      {
        l1 = localc.elB;
        l2 = localc.elA;
        l3 = localc.elD;
        l4 = localc.elC;
        com.tencent.mm.aq.b.agX().a(this.ejr, l1, l2, 1, new b.5(this, l4, (com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject, l3, paramb));
      }
      AppMethodBeat.o(32694);
      return;
      c(paramb);
      AppMethodBeat.o(32694);
      return;
      if (this.oCb)
      {
        l1 = this.zPY.getLong("MSG_ID");
        bool = this.zPY.getBoolean("IS_LOAD_ALL", false);
        aw.aaz();
        localObject = com.tencent.mm.model.c.YC().kB(l1);
        if (((dd)localObject).field_msgId != l1)
        {
          ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(32694);
          return;
        }
        l2 = ((dd)localObject).field_createTime;
        ab.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.zPU), Long.valueOf(this.zPV) });
        if ((l2 < this.zPU) || (l2 > this.zPV))
        {
          l2 = ((dd)localObject).field_createTime;
          aw.aaz();
          l3 = com.tencent.mm.model.c.YC().h(this.ejr, l2, 18);
          l3 = Math.min(oP(((dd)localObject).field_createTime), l3);
          ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.Js = ((j)g.E(j.class)).bPQ().d(this.ejr, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.zPZ.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(32694);
          return;
          this.Js = ((j)g.E(j.class)).bPQ().d(this.ejr, this.zPU, this.zPV, 2147483647);
          aw.aaz();
          i = com.tencent.mm.model.c.YC().z(this.ejr, this.zPU, l2) - 1;
          ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((j)g.E(j.class)).bPL();
      if (this.zPY == null)
      {
        bool = true;
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.zPY != null) {
          break label1299;
        }
      }
      label1299:
      for (int i = 0;; i = this.zPY.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1313;
        }
        l1 = dLi();
        l2 = ((j)g.E(j.class)).bPQ().g(this.ejr, l1, i);
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.ejr + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.Js = ((j)g.E(j.class)).bPQ().d(this.ejr, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(32694);
        return;
        bool = false;
        break;
      }
      label1313:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).SX(this.ejr);
      if (localObject == null)
      {
        ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.ejr });
        d(paramb);
        AppMethodBeat.o(32694);
        return;
      }
      l1 = ((com.tencent.mm.j.a.a.c)localObject).elA;
      l2 = ((com.tencent.mm.j.a.a.c)localObject).elC;
      long l3 = ((com.tencent.mm.j.a.a.c)localObject).elB;
      long l4 = ((com.tencent.mm.j.a.a.c)localObject).elD;
      com.tencent.mm.aq.b.agX().a(this.ejr, l1, l3, 0, new b.1(this, l2, l4, paramb));
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(32699);
    if (this.Js != null) {
      this.Js.close();
    }
    AppMethodBeat.o(32699);
  }
  
  final void d(d.b paramb)
  {
    AppMethodBeat.i(32705);
    ab.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
    c(paramb);
    AppMethodBeat.o(32705);
  }
  
  final long dLh()
  {
    AppMethodBeat.i(32700);
    com.tencent.mm.j.a.a.c localc = ((j)g.E(j.class)).bPL().SX(this.ejr);
    if (localc != null)
    {
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.elD + " seq:" + localc.elA + "~" + localc.elB);
      l = localc.elD;
      AppMethodBeat.o(32700);
      return l;
    }
    long l = this.zPU;
    AppMethodBeat.o(32700);
    return l;
  }
  
  final long dLk()
  {
    AppMethodBeat.i(32704);
    long l = ((j)g.E(j.class)).bPQ().TE(this.ejr);
    AppMethodBeat.o(32704);
    return l;
  }
  
  public final int dwi()
  {
    AppMethodBeat.i(32697);
    aw.aaz();
    int i = com.tencent.mm.model.c.YC().TA(this.ejr);
    AppMethodBeat.o(32697);
    return i;
  }
  
  public final void fs(List<bi> paramList)
  {
    AppMethodBeat.i(32698);
    if (this.Js == null)
    {
      ab.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(32698);
      return;
    }
    this.Js.moveToFirst();
    try
    {
      while (!this.Js.isAfterLast())
      {
        bi localbi = new bi();
        localbi.convertFrom(this.Js);
        paramList.add(localbi);
        this.Js.moveToNext();
      }
      AppMethodBeat.o(32698);
    }
    catch (IllegalStateException paramList)
    {
      ab.printErrStackTrace("MicroMsg.ChattingLoader.ChattingGetDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(32698);
      return;
    }
  }
  
  final long oP(long paramLong)
  {
    AppMethodBeat.i(32701);
    com.tencent.mm.j.a.a.c localc = ((j)g.E(j.class)).bPL().f(this.ejr, paramLong, true);
    if (localc != null)
    {
      ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.elC + " time:" + paramLong);
      paramLong = localc.elC;
      AppMethodBeat.o(32701);
      return paramLong;
    }
    paramLong = dLk();
    AppMethodBeat.o(32701);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.b
 * JD-Core Version:    0.7.0.1
 */