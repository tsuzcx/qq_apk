package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.b.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.b;
import com.tencent.mm.ui.chatting.h.d.d;
import java.util.List;

public final class b
  implements e<bv>
{
  private d.a KsS;
  long KsT;
  long KsU;
  private long KsV;
  int KsW;
  private Bundle KsX;
  private d.d KsY;
  Cursor Tc;
  String fVg;
  private boolean vsD;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36633);
    this.KsV = paramLong1;
    this.KsT = paramLong2;
    this.KsU = paramLong3;
    this.KsW = paramInt;
    this.fVg = paramString;
    this.KsS = parama;
    this.KsX = paramBundle;
    this.KsY = paramd;
    this.vsD = paramBoolean;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.KsT + " mLastBottomCreateTime:" + this.KsU + " isFromSearch:" + paramBoolean + " mLastCount:" + this.KsW + " mLastBottomMsgSeq:" + this.KsV + " mTalker:" + this.fVg + " action:" + parama);
    AppMethodBeat.o(36633);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(36635);
    long l1 = fLr();
    long l2 = fLu();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.Tc = ((l)g.ab(l.class)).doJ().d(this.fVg, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(36635);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(36636);
    boolean bool;
    if ((this.KsY.KrC != null) && (this.KsY.KrC.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.KsY.KrC == null) || (!this.KsY.KrC.getBoolean("has_position_search", false))) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label178;
      }
      bv localbv = ((l)g.ab(l.class)).doJ().arc(this.fVg);
      if ((localbv == null) || (localbv.field_isSend != 1) || (localbv.field_msgSeq != 0L)) {
        break label178;
      }
      b(paramb);
      if (this.KsY.KrC == null) {
        this.KsY.KrC = new Bundle();
      }
      this.KsY.KrC.putBoolean("need_scroll_to_bottom", true);
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(36636);
      return;
      bool = false;
      break;
    }
    label178:
    long l2 = fLt();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.KsU;; l1 = fLs())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.fVg + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.Tc = ((l)g.ab(l.class)).doJ().d(this.fVg, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(36636);
      return;
    }
  }
  
  private long fLs()
  {
    AppMethodBeat.i(36642);
    com.tencent.mm.storage.ae localae = ((l)g.ab(l.class)).doE().aqM(this.fVg);
    if (this.KsV > 0L)
    {
      Object localObject = localae.Ec(this.KsV);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() > 0)
      {
        localObject = fLv();
        l = ((ei)localObject).field_createTime;
        StringBuilder localStringBuilder = new StringBuilder("[findUpdateLastCreateTime]isSender=");
        if (((ei)localObject).field_isSend == 1) {}
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingLoader.ChattingGetDataSource", bool + " mLastBottomMsgSeq=" + this.KsV + " chatroomMsgSeq:" + localae + " mLastBottomCreateTime=" + this.KsU + " localLastMsgCreateTime=" + l);
          if (((ei)localObject).field_isSend != 1) {
            break;
          }
          AppMethodBeat.o(36642);
          return l;
        }
        l = this.KsU;
        AppMethodBeat.o(36642);
        return l;
      }
    }
    long l = fLu();
    AppMethodBeat.o(36642);
    return l;
  }
  
  private long fLt()
  {
    AppMethodBeat.i(36643);
    if (this.KsT == 0L)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.KsT = ((l)g.ab(l.class)).doJ().i(this.fVg, fLu(), 18);
    }
    long l = this.KsT;
    AppMethodBeat.o(36643);
    return l;
  }
  
  private bv fLv()
  {
    AppMethodBeat.i(36645);
    bv localbv = ((l)g.ab(l.class)).doJ().arc(this.fVg);
    AppMethodBeat.o(36645);
    return localbv;
  }
  
  final long EO(long paramLong)
  {
    AppMethodBeat.i(36641);
    com.tencent.mm.k.a.a.c localc = ((l)g.ab(l.class)).doE().e(this.fVg, paramLong, true);
    if (localc != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.fXu + " time:" + paramLong);
      paramLong = localc.fXu;
      AppMethodBeat.o(36641);
      return paramLong;
    }
    paramLong = fLu();
    AppMethodBeat.o(36641);
    return paramLong;
  }
  
  public final void a(final d.b paramb)
  {
    AppMethodBeat.i(36634);
    switch (6.KsJ[this.KsS.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36634);
      return;
      b(paramb);
      AppMethodBeat.o(36634);
      return;
      if ((this.KsX != null) && (this.KsX.getBoolean("load_bottom", false)))
      {
        localObject = ((l)g.ab(l.class)).doE().aqM(this.fVg);
        l1 = ((com.tencent.mm.storage.ae)localObject).field_lastPushSeq;
        l2 = ((com.tencent.mm.storage.ae)localObject).field_lastLocalSeq;
        com.tencent.mm.as.b.aIn().a(this.fVg, l1, 1L + l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bv> paramAnonymousList)
          {
            AppMethodBeat.i(36628);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.fLr();
              long l2 = b.this.fLu();
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.fVg + " from:" + l1 + " to:" + l2);
              b.this.Tc = ((l)g.ab(l.class)).doJ().d(b.this.fVg, l1, l2, 18);
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
      Object localObject = ((l)g.ab(l.class)).doE();
      com.tencent.mm.k.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).e(this.fVg, this.KsU, true);
      if (localc != null)
      {
        com.tencent.mm.as.b.aIn().a(this.fVg, localc.fXs, localc.fXt, 0, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bv> paramAnonymousList)
          {
            AppMethodBeat.i(36629);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.KsT;
              paramAnonymousList = (bv)paramAnonymousList.get(paramAnonymousList.size() - 1);
              long l2 = b.this.EO(paramAnonymousList.field_createTime);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fVg + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramAnonymousList.field_createTime);
              b.this.Tc = ((l)g.ab(l.class)).doJ().d(b.this.fVg, l1, l2, 2147483647);
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
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.fVg + " mLastBottomCreateTime:" + this.KsU);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aqM(this.fVg);
      long l1 = ((com.tencent.mm.storage.ae)localObject).field_lastPushSeq;
      final long l2 = ((com.tencent.mm.storage.ae)localObject).field_lastLocalSeq;
      com.tencent.mm.as.b.aIn().a(this.fVg, 1L + l2, l1, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bv> paramAnonymousList)
        {
          AppMethodBeat.i(36630);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            long l1 = b.this.KsT;
            bv localbv = (bv)paramAnonymousList.get(paramAnonymousList.size() - 1);
            long l2 = b.this.EO(localbv.field_createTime);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fVg + " from:" + l1 + " to:" + l2 + " size:" + paramAnonymousList.size());
            b.this.Tc = ((l)g.ab(l.class)).doJ().d(b.this.fVg, l1, l2, 2147483647);
            paramb.next();
            AppMethodBeat.o(36630);
            return;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(paramAnonymousInt)));
          b.this.d(paramb);
          AppMethodBeat.o(36630);
        }
      });
      AppMethodBeat.o(36634);
      return;
      localObject = ((l)g.ab(l.class)).doE();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aF(this.fVg, this.KsT);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.KsT;
        i = ((l)g.ab(l.class)).doJ().D(this.fVg, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.fVg).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
        if (localc != null) {
          break label614;
        }
      }
      label614:
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", bool);
        if ((i < 18) && (localc != null)) {
          break label620;
        }
        l2 = this.KsU;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.fVg + " from:" + l1 + " to:" + l2 + " count:" + (this.KsW + 18));
        this.Tc = ((l)g.ab(l.class)).doJ().d(this.fVg, l1, l2, this.KsW + 18);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        l1 = localc.fXv;
        break;
      }
      label620:
      if (localc != null)
      {
        l1 = localc.fXt;
        l2 = localc.fXs;
        l3 = localc.fXv;
        l4 = localc.fXu;
        com.tencent.mm.as.b.aIn().a(this.fVg, l1, l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bv> paramAnonymousList)
          {
            AppMethodBeat.i(36631);
            long l2;
            if (paramAnonymousInt >= 0)
            {
              l2 = l4;
              if (paramAnonymousList.size() <= 0) {
                break label273;
              }
              l2 = ((bv)paramAnonymousList.get(0)).field_createTime;
            }
            label273:
            for (;;)
            {
              long l1 = l2;
              if (l3.aF(b.this.fVg, l2) == null)
              {
                l1 = l2;
                if (paramAnonymousList.size() < 18) {
                  l1 = ((l)g.ab(l.class)).doJ().i(b.this.fVg, l2, 18 - paramAnonymousList.size());
                }
              }
              l2 = l1;
              if (l1 <= 0L) {
                l2 = l4;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.fVg + " firstCreateTime:" + l4 + " lastCreateTime:" + paramb + " from:" + l2);
              b.this.Tc = ((l)g.ab(l.class)).doJ().d(b.this.fVg, l2, b.this.KsU, b.this.KsW + 18);
              this.Krr.next();
              AppMethodBeat.o(36631);
              return;
              b.this.d(this.Krr);
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
      if (this.vsD)
      {
        l1 = this.KsX.getLong("MSG_ID");
        bool = this.KsX.getBoolean("IS_LOAD_ALL", false);
        bc.aCg();
        localObject = com.tencent.mm.model.c.azI().ys(l1);
        if (((ei)localObject).field_msgId != l1)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(36634);
          return;
        }
        l2 = ((ei)localObject).field_createTime;
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.KsT), Long.valueOf(this.KsU) });
        if ((l2 < this.KsT) || (l2 > this.KsU))
        {
          l2 = ((ei)localObject).field_createTime;
          bc.aCg();
          l3 = com.tencent.mm.model.c.azI().j(this.fVg, l2, 18);
          l3 = Math.min(EO(((ei)localObject).field_createTime), l3);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.Tc = ((l)g.ab(l.class)).doJ().d(this.fVg, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.KsY.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(36634);
          return;
          this.Tc = ((l)g.ab(l.class)).doJ().d(this.fVg, this.KsT, this.KsU, 2147483647);
          bc.aCg();
          i = com.tencent.mm.model.c.azI().D(this.fVg, this.KsT, l2) - 1;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((l)g.ab(l.class)).doE();
      if (this.KsX == null)
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.KsX != null) {
          break label1300;
        }
      }
      label1300:
      for (int i = 0;; i = this.KsX.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1314;
        }
        l1 = fLs();
        l2 = ((l)g.ab(l.class)).doJ().i(this.fVg, l1, i);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.fVg + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.Tc = ((l)g.ab(l.class)).doJ().d(this.fVg, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        bool = false;
        break;
      }
      label1314:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aqL(this.fVg);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.fVg });
        d(paramb);
        AppMethodBeat.o(36634);
        return;
      }
      l1 = ((com.tencent.mm.k.a.a.c)localObject).fXs;
      l2 = ((com.tencent.mm.k.a.a.c)localObject).fXu;
      final long l3 = ((com.tencent.mm.k.a.a.c)localObject).fXt;
      final long l4 = ((com.tencent.mm.k.a.a.c)localObject).fXv;
      com.tencent.mm.as.b.aIn().a(this.fVg, l1, l3, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bv> paramAnonymousList)
        {
          AppMethodBeat.i(36627);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.fVg + " fromCreateTime:" + l2 + " toCreateTime:" + paramb + " addSize:" + paramAnonymousList.size());
            long l = paramb;
            if (paramAnonymousList.size() <= 18) {
              l = b.this.EO(((bv)paramAnonymousList.get(paramAnonymousList.size() - 1)).field_createTime);
            }
            b.this.Tc = ((l)g.ab(l.class)).doJ().d(b.this.fVg, l2, l, 36);
            this.Krr.next();
            AppMethodBeat.o(36627);
            return;
          }
          b.this.d(this.Krr);
          AppMethodBeat.o(36627);
        }
      });
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(36639);
    if (this.Tc != null) {
      this.Tc.close();
    }
    AppMethodBeat.o(36639);
  }
  
  final void d(d.b paramb)
  {
    AppMethodBeat.i(36646);
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
    c(paramb);
    AppMethodBeat.o(36646);
  }
  
  final long fLr()
  {
    AppMethodBeat.i(36640);
    com.tencent.mm.k.a.a.c localc = ((l)g.ab(l.class)).doE().aqL(this.fVg);
    if (localc != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.fXv + " seq:" + localc.fXs + "~" + localc.fXt);
      l = localc.fXv;
      AppMethodBeat.o(36640);
      return l;
    }
    long l = this.KsT;
    AppMethodBeat.o(36640);
    return l;
  }
  
  final long fLu()
  {
    AppMethodBeat.i(36644);
    long l = ((l)g.ab(l.class)).doJ().arv(this.fVg);
    AppMethodBeat.o(36644);
    return l;
  }
  
  public final int ftv()
  {
    AppMethodBeat.i(36637);
    bc.aCg();
    int i = com.tencent.mm.model.c.azI().arr(this.fVg);
    AppMethodBeat.o(36637);
    return i;
  }
  
  public final void ix(List<bv> paramList)
  {
    AppMethodBeat.i(36638);
    if (this.Tc == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(36638);
      return;
    }
    this.Tc.moveToFirst();
    try
    {
      while (!this.Tc.isAfterLast())
      {
        bv localbv = new bv();
        localbv.convertFrom(this.Tc);
        paramList.add(localbv);
        this.Tc.moveToNext();
      }
      AppMethodBeat.o(36638);
    }
    catch (IllegalStateException paramList)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.ChattingLoader.ChattingGetDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36638);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.b
 * JD-Core Version:    0.7.0.1
 */