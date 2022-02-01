package com.tencent.mm.ui.chatting.o;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.b.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.b;
import com.tencent.mm.ui.chatting.h.d.d;
import java.util.List;

public final class b
  implements g<ca>
{
  private boolean Eqj;
  private d.a WZU;
  long WZV;
  long WZW;
  private long WZX;
  int WZY;
  private Bundle WZZ;
  private d.d Xaa;
  Cursor fB;
  String jkq;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36633);
    this.WZX = paramLong1;
    this.WZV = paramLong2;
    this.WZW = paramLong3;
    this.WZY = paramInt;
    this.jkq = paramString;
    this.WZU = parama;
    this.WZZ = paramBundle;
    this.Xaa = paramd;
    this.Eqj = paramBoolean;
    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.WZV + " mLastBottomCreateTime:" + this.WZW + " isFromSearch:" + paramBoolean + " mLastCount:" + this.WZY + " mLastBottomMsgSeq:" + this.WZX + " mTalker:" + this.jkq + " action:" + parama);
    AppMethodBeat.o(36633);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(36635);
    long l1 = hTs();
    long l2 = hTv();
    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.fB = ((n)h.ae(n.class)).eSe().d(this.jkq, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(36635);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(36636);
    boolean bool;
    if ((this.Xaa.WYx != null) && (this.Xaa.WYx.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.Xaa.WYx == null) || (!this.Xaa.WYx.getBoolean("has_position_search", false))) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label178;
      }
      ca localca = ((n)h.ae(n.class)).eSe().aOH(this.jkq);
      if ((localca == null) || (localca.field_isSend != 1) || (localca.field_msgSeq != 0L)) {
        break label178;
      }
      b(paramb);
      if (this.Xaa.WYx == null) {
        this.Xaa.WYx = new Bundle();
      }
      this.Xaa.WYx.putBoolean("need_scroll_to_bottom", true);
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(36636);
      return;
      bool = false;
      break;
    }
    label178:
    long l2 = hTu();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.WZW;; l1 = hTt())
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.jkq + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.fB = ((n)h.ae(n.class)).eSe().d(this.jkq, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(36636);
      return;
    }
  }
  
  private long hTt()
  {
    AppMethodBeat.i(36642);
    aj localaj = ((n)h.ae(n.class)).eRZ().aOr(this.jkq);
    if (this.WZX > 0L)
    {
      Object localObject = localaj.US(this.WZX);
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() > 0)
      {
        localObject = hTw();
        l = ((et)localObject).field_createTime;
        StringBuilder localStringBuilder = new StringBuilder("[findUpdateLastCreateTime]isSender=");
        if (((et)localObject).field_isSend == 1) {}
        for (boolean bool = true;; bool = false)
        {
          Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", bool + " mLastBottomMsgSeq=" + this.WZX + " chatroomMsgSeq:" + localaj + " mLastBottomCreateTime=" + this.WZW + " localLastMsgCreateTime=" + l);
          if (((et)localObject).field_isSend != 1) {
            break;
          }
          AppMethodBeat.o(36642);
          return l;
        }
        l = this.WZW;
        AppMethodBeat.o(36642);
        return l;
      }
    }
    long l = hTv();
    AppMethodBeat.o(36642);
    return l;
  }
  
  private long hTu()
  {
    AppMethodBeat.i(36643);
    if (this.WZV == 0L)
    {
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.WZV = ((n)h.ae(n.class)).eSe().j(this.jkq, hTv(), 18);
    }
    long l = this.WZV;
    AppMethodBeat.o(36643);
    return l;
  }
  
  private ca hTw()
  {
    AppMethodBeat.i(36645);
    ca localca = ((n)h.ae(n.class)).eSe().aOH(this.jkq);
    AppMethodBeat.o(36645);
    return localca;
  }
  
  final long Wg(long paramLong)
  {
    AppMethodBeat.i(36641);
    com.tencent.mm.k.a.a.c localc = ((n)h.ae(n.class)).eRZ().d(this.jkq, paramLong, true);
    if (localc != null)
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.jmG + " time:" + paramLong);
      paramLong = localc.jmG;
      AppMethodBeat.o(36641);
      return paramLong;
    }
    paramLong = hTv();
    AppMethodBeat.o(36641);
    return paramLong;
  }
  
  public final void a(final d.b paramb)
  {
    AppMethodBeat.i(36634);
    switch (6.WZK[this.WZU.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36634);
      return;
      b(paramb);
      AppMethodBeat.o(36634);
      return;
      if ((this.WZZ != null) && (this.WZZ.getBoolean("load_bottom", false)))
      {
        localObject = ((n)h.ae(n.class)).eRZ().aOr(this.jkq);
        l1 = ((aj)localObject).field_lastPushSeq;
        l2 = ((aj)localObject).field_lastLocalSeq;
        com.tencent.mm.av.b.blw().a(this.jkq, l1, 1L + l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(36628);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.hTs();
              long l2 = b.this.hTv();
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.jkq + " from:" + l1 + " to:" + l2);
              b.this.fB = ((n)h.ae(n.class)).eSe().d(b.this.jkq, l1, l2, 18);
              paramb.next();
              AppMethodBeat.o(36628);
              return;
            }
            b.this.d(paramb);
            AppMethodBeat.o(36628);
          }
        });
        AppMethodBeat.o(36634);
        return;
      }
      Object localObject = ((n)h.ae(n.class)).eRZ();
      com.tencent.mm.k.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).d(this.jkq, this.WZW, true);
      if (localc != null)
      {
        com.tencent.mm.av.b.blw().a(this.jkq, localc.jmE, localc.jmF, 0, new b.b()
        {
          public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(36629);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.WZV;
              paramAnonymousList = (ca)paramAnonymousList.get(paramAnonymousList.size() - 1);
              long l2 = b.this.Wg(paramAnonymousList.field_createTime);
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.jkq + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramAnonymousList.field_createTime);
              b.this.fB = ((n)h.ae(n.class)).eSe().d(b.this.jkq, l1, l2, 2147483647);
              paramb.next();
              AppMethodBeat.o(36629);
              return;
            }
            b.this.d(paramb);
            AppMethodBeat.o(36629);
          }
        });
        AppMethodBeat.o(36634);
        return;
      }
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.jkq + " mLastBottomCreateTime:" + this.WZW);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aOr(this.jkq);
      long l1 = ((aj)localObject).field_lastPushSeq;
      final long l2 = ((aj)localObject).field_lastLocalSeq;
      com.tencent.mm.av.b.blw().a(this.jkq, 1L + l2, l1, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
        {
          AppMethodBeat.i(36630);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            long l1 = b.this.WZV;
            ca localca = (ca)paramAnonymousList.get(paramAnonymousList.size() - 1);
            long l2 = b.this.Wg(localca.field_createTime);
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.jkq + " from:" + l1 + " to:" + l2 + " size:" + paramAnonymousList.size());
            b.this.fB = ((n)h.ae(n.class)).eSe().d(b.this.jkq, l1, l2, 2147483647);
            paramb.next();
            AppMethodBeat.o(36630);
            return;
          }
          Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(paramAnonymousInt)));
          b.this.d(paramb);
          AppMethodBeat.o(36630);
        }
      });
      AppMethodBeat.o(36634);
      return;
      localObject = ((n)h.ae(n.class)).eRZ();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aH(this.jkq, this.WZV);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.WZV;
        i = ((n)h.ae(n.class)).eSe().D(this.jkq, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.jkq).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
        if (localc != null) {
          break label614;
        }
      }
      label614:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", bool);
        if ((i < 18) && (localc != null)) {
          break label620;
        }
        l2 = this.WZW;
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.jkq + " from:" + l1 + " to:" + l2 + " count:" + (this.WZY + 18));
        this.fB = ((n)h.ae(n.class)).eSe().d(this.jkq, l1, l2, this.WZY + 18);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        l1 = localc.jmH;
        break;
      }
      label620:
      if (localc != null)
      {
        l1 = localc.jmF;
        l2 = localc.jmE;
        l3 = localc.jmH;
        l4 = localc.jmG;
        com.tencent.mm.av.b.blw().a(this.jkq, l1, l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(36631);
            long l2;
            if (paramAnonymousInt >= 0)
            {
              l2 = l4;
              if (paramAnonymousList.size() <= 0) {
                break label273;
              }
              l2 = ((ca)paramAnonymousList.get(0)).field_createTime;
            }
            label273:
            for (;;)
            {
              long l1 = l2;
              if (l3.aH(b.this.jkq, l2) == null)
              {
                l1 = l2;
                if (paramAnonymousList.size() < 18) {
                  l1 = ((n)h.ae(n.class)).eSe().j(b.this.jkq, l2, 18 - paramAnonymousList.size());
                }
              }
              l2 = l1;
              if (l1 <= 0L) {
                l2 = l4;
              }
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.jkq + " firstCreateTime:" + l4 + " lastCreateTime:" + paramb + " from:" + l2);
              b.this.fB = ((n)h.ae(n.class)).eSe().d(b.this.jkq, l2, b.this.WZW, b.this.WZY + 18);
              this.WYm.next();
              AppMethodBeat.o(36631);
              return;
              b.this.d(this.WYm);
              AppMethodBeat.o(36631);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(36634);
      return;
      c(paramb);
      AppMethodBeat.o(36634);
      return;
      if (this.Eqj)
      {
        l1 = this.WZZ.getLong("MSG_ID");
        bool = this.WZZ.getBoolean("IS_LOAD_ALL", false);
        bh.beI();
        localObject = com.tencent.mm.model.c.bbO().Oq(l1);
        if (((et)localObject).field_msgId != l1)
        {
          Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(36634);
          return;
        }
        l2 = ((et)localObject).field_createTime;
        Log.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.WZV), Long.valueOf(this.WZW) });
        if ((l2 < this.WZV) || (l2 > this.WZW))
        {
          l2 = ((et)localObject).field_createTime;
          bh.beI();
          l3 = com.tencent.mm.model.c.bbO().k(this.jkq, l2, 18);
          l3 = Math.min(Wg(((et)localObject).field_createTime), l3);
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.fB = ((n)h.ae(n.class)).eSe().d(this.jkq, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.Xaa.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(36634);
          return;
          this.fB = ((n)h.ae(n.class)).eSe().d(this.jkq, this.WZV, this.WZW, 2147483647);
          bh.beI();
          i = com.tencent.mm.model.c.bbO().D(this.jkq, this.WZV, l2) - 1;
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((n)h.ae(n.class)).eRZ();
      if (this.WZZ == null)
      {
        bool = true;
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.WZZ != null) {
          break label1300;
        }
      }
      label1300:
      for (int i = 0;; i = this.WZZ.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1314;
        }
        l1 = hTt();
        l2 = ((n)h.ae(n.class)).eSe().j(this.jkq, l1, i);
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.jkq + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.fB = ((n)h.ae(n.class)).eSe().d(this.jkq, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        bool = false;
        break;
      }
      label1314:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aOq(this.jkq);
      if (localObject == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.jkq });
        d(paramb);
        AppMethodBeat.o(36634);
        return;
      }
      l1 = ((com.tencent.mm.k.a.a.c)localObject).jmE;
      l2 = ((com.tencent.mm.k.a.a.c)localObject).jmG;
      final long l3 = ((com.tencent.mm.k.a.a.c)localObject).jmF;
      final long l4 = ((com.tencent.mm.k.a.a.c)localObject).jmH;
      com.tencent.mm.av.b.blw().a(this.jkq, l1, l3, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
        {
          AppMethodBeat.i(36627);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.jkq + " fromCreateTime:" + l2 + " toCreateTime:" + paramb + " addSize:" + paramAnonymousList.size());
            long l = paramb;
            if (paramAnonymousList.size() <= 18) {
              l = b.this.Wg(((ca)paramAnonymousList.get(paramAnonymousList.size() - 1)).field_createTime);
            }
            b.this.fB = ((n)h.ae(n.class)).eSe().d(b.this.jkq, l2, l, 36);
            this.WYm.next();
            AppMethodBeat.o(36627);
            return;
          }
          b.this.d(this.WYm);
          AppMethodBeat.o(36627);
        }
      });
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(36639);
    if (this.fB != null) {
      this.fB.close();
    }
    AppMethodBeat.o(36639);
  }
  
  final void d(d.b paramb)
  {
    AppMethodBeat.i(36646);
    Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
    c(paramb);
    AppMethodBeat.o(36646);
  }
  
  public final int dpe()
  {
    AppMethodBeat.i(36637);
    bh.beI();
    int i = com.tencent.mm.model.c.bbO().aOW(this.jkq);
    AppMethodBeat.o(36637);
    return i;
  }
  
  final long hTs()
  {
    AppMethodBeat.i(36640);
    com.tencent.mm.k.a.a.c localc = ((n)h.ae(n.class)).eRZ().aOq(this.jkq);
    if (localc != null)
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.jmH + " seq:" + localc.jmE + "~" + localc.jmF);
      l = localc.jmH;
      AppMethodBeat.o(36640);
      return l;
    }
    long l = this.WZV;
    AppMethodBeat.o(36640);
    return l;
  }
  
  final long hTv()
  {
    AppMethodBeat.i(36644);
    long l = ((n)h.ae(n.class)).eSe().aPa(this.jkq);
    AppMethodBeat.o(36644);
    return l;
  }
  
  public final void ks(List<ca> paramList)
  {
    AppMethodBeat.i(36638);
    if (this.fB == null)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(36638);
      return;
    }
    this.fB.moveToFirst();
    try
    {
      while (!this.fB.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(this.fB);
        paramList.add(localca);
        this.fB.moveToNext();
      }
      AppMethodBeat.o(36638);
    }
    catch (IllegalStateException paramList)
    {
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingGetDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36638);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.b
 * JD-Core Version:    0.7.0.1
 */