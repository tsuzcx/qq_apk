package com.tencent.mm.ui.chatting.k;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgetchatroommsg.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.b;
import com.tencent.mm.ui.chatting.f.d.d;
import java.util.List;

public final class b
  implements g<cc>
{
  private boolean KiQ;
  long aeJA;
  private long aeJB;
  int aeJC;
  private Bundle aeJD;
  private d.d aeJE;
  private d.a aeJy;
  long aeJz;
  Cursor gw;
  String lMU;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36633);
    this.aeJB = paramLong1;
    this.aeJz = paramLong2;
    this.aeJA = paramLong3;
    this.aeJC = paramInt;
    this.lMU = paramString;
    this.aeJy = parama;
    this.aeJD = paramBundle;
    this.aeJE = paramd;
    this.KiQ = paramBoolean;
    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.aeJz + " mLastBottomCreateTime:" + this.aeJA + " isFromSearch:" + paramBoolean + " mLastCount:" + this.aeJC + " mLastBottomMsgSeq:" + this.aeJB + " mTalker:" + this.lMU + " action:" + parama);
    AppMethodBeat.o(36633);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(36635);
    long l1 = jwU();
    long l2 = jwX();
    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.gw = ((n)h.ax(n.class)).gaZ().d(this.lMU, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(36635);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(36636);
    boolean bool;
    if ((this.aeJE.aeHX != null) && (this.aeJE.aeHX.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.aeJE.aeHX == null) || (!this.aeJE.aeHX.getBoolean("has_position_search", false))) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label178;
      }
      cc localcc = ((n)h.ax(n.class)).gaZ().aLG(this.lMU);
      if ((localcc == null) || (localcc.field_isSend != 1) || (localcc.field_msgSeq != 0L)) {
        break label178;
      }
      b(paramb);
      if (this.aeJE.aeHX == null) {
        this.aeJE.aeHX = new Bundle();
      }
      this.aeJE.aeHX.putBoolean("need_scroll_to_bottom", true);
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(36636);
      return;
      bool = false;
      break;
    }
    label178:
    long l2 = jwW();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.aeJA;; l1 = jwV())
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.lMU + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.gw = ((n)h.ax(n.class)).gaZ().d(this.lMU, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(36636);
      return;
    }
  }
  
  private long jwV()
  {
    AppMethodBeat.i(36642);
    al localal = ((n)h.ax(n.class)).gaU().aLq(this.lMU);
    if (this.aeJB > 0L)
    {
      Object localObject = localal.zb(this.aeJB);
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() > 0)
      {
        localObject = jwY();
        l = ((cc)localObject).getCreateTime();
        StringBuilder localStringBuilder = new StringBuilder("[findUpdateLastCreateTime]isSender=");
        if (((fi)localObject).field_isSend == 1) {}
        for (boolean bool = true;; bool = false)
        {
          Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", bool + " mLastBottomMsgSeq=" + this.aeJB + " chatroomMsgSeq:" + localal + " mLastBottomCreateTime=" + this.aeJA + " localLastMsgCreateTime=" + l);
          if (((fi)localObject).field_isSend != 1) {
            break;
          }
          AppMethodBeat.o(36642);
          return l;
        }
        l = this.aeJA;
        AppMethodBeat.o(36642);
        return l;
      }
    }
    long l = jwX();
    AppMethodBeat.o(36642);
    return l;
  }
  
  private long jwW()
  {
    AppMethodBeat.i(36643);
    if (this.aeJz == 0L)
    {
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.aeJz = ((n)h.ax(n.class)).gaZ().l(this.lMU, jwX(), 18);
    }
    long l = this.aeJz;
    AppMethodBeat.o(36643);
    return l;
  }
  
  private cc jwY()
  {
    AppMethodBeat.i(36645);
    cc localcc = ((n)h.ax(n.class)).gaZ().aLG(this.lMU);
    AppMethodBeat.o(36645);
    return localcc;
  }
  
  final long Ar(long paramLong)
  {
    AppMethodBeat.i(36641);
    com.tencent.mm.h.a.a.c localc = ((n)h.ax(n.class)).gaU().d(this.lMU, paramLong, true);
    if (localc != null)
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.lPR + " time:" + paramLong);
      paramLong = localc.lPR;
      AppMethodBeat.o(36641);
      return paramLong;
    }
    paramLong = jwX();
    AppMethodBeat.o(36641);
    return paramLong;
  }
  
  public final void a(final d.b paramb)
  {
    AppMethodBeat.i(36634);
    switch (6.aeJk[this.aeJy.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36634);
      return;
      b(paramb);
      AppMethodBeat.o(36634);
      return;
      if ((this.aeJD != null) && (this.aeJD.getBoolean("load_bottom", false)))
      {
        localObject = ((n)h.ax(n.class)).gaU().aLq(this.lMU);
        l1 = ((al)localObject).field_lastPushSeq;
        l2 = ((al)localObject).field_lastLocalSeq;
        com.tencent.mm.modelgetchatroommsg.b.bJr().a(this.lMU, l1, 1L + l2, 1, new b.b()
        {
          public final void q(int paramAnonymousInt, List<cc> paramAnonymousList)
          {
            AppMethodBeat.i(36628);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.jwU();
              long l2 = b.this.jwX();
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.lMU + " from:" + l1 + " to:" + l2);
              b.this.gw = ((n)h.ax(n.class)).gaZ().d(b.this.lMU, l1, l2, 18);
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
      Object localObject = ((n)h.ax(n.class)).gaU();
      com.tencent.mm.h.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).d(this.lMU, this.aeJA, true);
      if (localc != null)
      {
        com.tencent.mm.modelgetchatroommsg.b.bJr().a(this.lMU, localc.lPP, localc.lPQ, 0, new b.b()
        {
          public final void q(int paramAnonymousInt, List<cc> paramAnonymousList)
          {
            AppMethodBeat.i(36629);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.aeJz;
              paramAnonymousList = (cc)paramAnonymousList.get(paramAnonymousList.size() - 1);
              long l2 = b.this.Ar(paramAnonymousList.getCreateTime());
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.lMU + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramAnonymousList.getCreateTime());
              b.this.gw = ((n)h.ax(n.class)).gaZ().d(b.this.lMU, l1, l2, 2147483647);
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
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.lMU + " mLastBottomCreateTime:" + this.aeJA);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aLq(this.lMU);
      long l1 = ((al)localObject).field_lastPushSeq;
      final long l2 = ((al)localObject).field_lastLocalSeq;
      com.tencent.mm.modelgetchatroommsg.b.bJr().a(this.lMU, 1L + l2, l1, 0, new b.b()
      {
        public final void q(int paramAnonymousInt, List<cc> paramAnonymousList)
        {
          AppMethodBeat.i(36630);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            long l1 = b.this.aeJz;
            cc localcc = (cc)paramAnonymousList.get(paramAnonymousList.size() - 1);
            long l2 = b.this.Ar(localcc.getCreateTime());
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.lMU + " from:" + l1 + " to:" + l2 + " size:" + paramAnonymousList.size());
            b.this.gw = ((n)h.ax(n.class)).gaZ().d(b.this.lMU, l1, l2, 2147483647);
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
      localObject = ((n)h.ax(n.class)).gaU();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aQ(this.lMU, this.aeJz);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.aeJz;
        i = ((n)h.ax(n.class)).gaZ().I(this.lMU, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.lMU).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
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
        l2 = this.aeJA;
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.lMU + " from:" + l1 + " to:" + l2 + " count:" + (this.aeJC + 18));
        this.gw = ((n)h.ax(n.class)).gaZ().d(this.lMU, l1, l2, this.aeJC + 18);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        l1 = localc.lPS;
        break;
      }
      label620:
      if (localc != null)
      {
        l1 = localc.lPQ;
        l2 = localc.lPP;
        l3 = localc.lPS;
        l4 = localc.lPR;
        com.tencent.mm.modelgetchatroommsg.b.bJr().a(this.lMU, l1, l2, 1, new b.b()
        {
          public final void q(int paramAnonymousInt, List<cc> paramAnonymousList)
          {
            AppMethodBeat.i(36631);
            long l2;
            if (paramAnonymousInt >= 0)
            {
              l2 = l4;
              if (paramAnonymousList.size() <= 0) {
                break label273;
              }
              l2 = ((cc)paramAnonymousList.get(0)).getCreateTime();
            }
            label273:
            for (;;)
            {
              long l1 = l2;
              if (l3.aQ(b.this.lMU, l2) == null)
              {
                l1 = l2;
                if (paramAnonymousList.size() < 18) {
                  l1 = ((n)h.ax(n.class)).gaZ().l(b.this.lMU, l2, 18 - paramAnonymousList.size());
                }
              }
              l2 = l1;
              if (l1 <= 0L) {
                l2 = l4;
              }
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.lMU + " firstCreateTime:" + l4 + " lastCreateTime:" + paramb + " from:" + l2);
              b.this.gw = ((n)h.ax(n.class)).gaZ().d(b.this.lMU, l2, b.this.aeJA, b.this.aeJC + 18);
              this.aeHM.next();
              AppMethodBeat.o(36631);
              return;
              b.this.d(this.aeHM);
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
      if (this.KiQ)
      {
        l1 = this.aeJD.getLong("MSG_ID");
        bool = this.aeJD.getBoolean("IS_LOAD_ALL", false);
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzD().sl(l1);
        if ((localObject == null) || (((fi)localObject).field_msgId != l1))
        {
          Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(36634);
          return;
        }
        l2 = ((cc)localObject).getCreateTime();
        Log.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.aeJz), Long.valueOf(this.aeJA) });
        if ((l2 < this.aeJz) || (l2 > this.aeJA))
        {
          l2 = ((cc)localObject).getCreateTime();
          bh.bCz();
          l3 = com.tencent.mm.model.c.bzD().m(this.lMU, l2, 18);
          l3 = Math.min(Ar(((cc)localObject).getCreateTime()), l3);
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.gw = ((n)h.ax(n.class)).gaZ().d(this.lMU, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.aeJE.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(36634);
          return;
          this.gw = ((n)h.ax(n.class)).gaZ().d(this.lMU, this.aeJz, this.aeJA, 2147483647);
          bh.bCz();
          i = com.tencent.mm.model.c.bzD().I(this.lMU, this.aeJz, l2) - 1;
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((n)h.ax(n.class)).gaU();
      if (this.aeJD == null)
      {
        bool = true;
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.aeJD != null) {
          break label1305;
        }
      }
      label1305:
      for (int i = 0;; i = this.aeJD.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1319;
        }
        l1 = jwV();
        l2 = ((n)h.ax(n.class)).gaZ().l(this.lMU, l1, i);
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.lMU + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.gw = ((n)h.ax(n.class)).gaZ().d(this.lMU, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        bool = false;
        break;
      }
      label1319:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aLp(this.lMU);
      if (localObject == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.lMU });
        d(paramb);
        AppMethodBeat.o(36634);
        return;
      }
      l1 = ((com.tencent.mm.h.a.a.c)localObject).lPP;
      l2 = ((com.tencent.mm.h.a.a.c)localObject).lPR;
      final long l3 = ((com.tencent.mm.h.a.a.c)localObject).lPQ;
      final long l4 = ((com.tencent.mm.h.a.a.c)localObject).lPS;
      com.tencent.mm.modelgetchatroommsg.b.bJr().a(this.lMU, l1, l3, 0, new b.b()
      {
        public final void q(int paramAnonymousInt, List<cc> paramAnonymousList)
        {
          AppMethodBeat.i(36627);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.lMU + " fromCreateTime:" + l2 + " toCreateTime:" + paramb + " addSize:" + paramAnonymousList.size());
            long l = paramb;
            if (paramAnonymousList.size() <= 18) {
              l = b.this.Ar(((cc)paramAnonymousList.get(paramAnonymousList.size() - 1)).getCreateTime());
            }
            b.this.gw = ((n)h.ax(n.class)).gaZ().d(b.this.lMU, l2, l, 36);
            this.aeHM.next();
            AppMethodBeat.o(36627);
            return;
          }
          b.this.d(this.aeHM);
          AppMethodBeat.o(36627);
        }
      });
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(36639);
    if (this.gw != null) {
      this.gw.close();
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
  
  public final int dWF()
  {
    AppMethodBeat.i(36637);
    bh.bCz();
    int i = com.tencent.mm.model.c.bzD().aLW(this.lMU);
    AppMethodBeat.o(36637);
    return i;
  }
  
  final long jwU()
  {
    AppMethodBeat.i(36640);
    com.tencent.mm.h.a.a.c localc = ((n)h.ax(n.class)).gaU().aLp(this.lMU);
    if (localc != null)
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.lPS + " seq:" + localc.lPP + "~" + localc.lPQ);
      l = localc.lPS;
      AppMethodBeat.o(36640);
      return l;
    }
    long l = this.aeJz;
    AppMethodBeat.o(36640);
    return l;
  }
  
  final long jwX()
  {
    AppMethodBeat.i(36644);
    long l = ((n)h.ax(n.class)).gaZ().Hq(this.lMU);
    AppMethodBeat.o(36644);
    return l;
  }
  
  public final void nI(List<cc> paramList)
  {
    AppMethodBeat.i(36638);
    if (this.gw == null)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(36638);
      return;
    }
    this.gw.moveToFirst();
    try
    {
      while (!this.gw.isAfterLast())
      {
        cc localcc = new cc();
        localcc.convertFrom(this.gw);
        paramList.add(localcc);
        this.gw.moveToNext();
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
 * Qualified Name:     com.tencent.mm.ui.chatting.k.b
 * JD-Core Version:    0.7.0.1
 */