package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.b.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.b;
import com.tencent.mm.ui.chatting.h.d.d;
import java.util.List;

public final class b
  implements e<bu>
{
  private d.a JWB;
  long JWC;
  long JWD;
  private long JWE;
  int JWF;
  private Bundle JWG;
  private d.d JWH;
  Cursor Tc;
  String fTa;
  private boolean vgw;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36633);
    this.JWE = paramLong1;
    this.JWC = paramLong2;
    this.JWD = paramLong3;
    this.JWF = paramInt;
    this.fTa = paramString;
    this.JWB = parama;
    this.JWG = paramBundle;
    this.JWH = paramd;
    this.vgw = paramBoolean;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.JWC + " mLastBottomCreateTime:" + this.JWD + " isFromSearch:" + paramBoolean + " mLastCount:" + this.JWF + " mLastBottomMsgSeq:" + this.JWE + " mTalker:" + this.fTa + " action:" + parama);
    AppMethodBeat.o(36633);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(36635);
    long l1 = fGZ();
    long l2 = fHc();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.Tc = ((l)g.ab(l.class)).dlK().d(this.fTa, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(36635);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(36636);
    boolean bool;
    if ((this.JWH.JVk != null) && (this.JWH.JVk.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.JWH.JVk == null) || (!this.JWH.JVk.getBoolean("has_position_search", false))) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label178;
      }
      bu localbu = ((l)g.ab(l.class)).dlK().apX(this.fTa);
      if ((localbu == null) || (localbu.field_isSend != 1) || (localbu.field_msgSeq != 0L)) {
        break label178;
      }
      b(paramb);
      if (this.JWH.JVk == null) {
        this.JWH.JVk = new Bundle();
      }
      this.JWH.JVk.putBoolean("need_scroll_to_bottom", true);
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(36636);
      return;
      bool = false;
      break;
    }
    label178:
    long l2 = fHb();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.JWD;; l1 = fHa())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.fTa + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.Tc = ((l)g.ab(l.class)).dlK().d(this.fTa, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(36636);
      return;
    }
  }
  
  private long fHa()
  {
    AppMethodBeat.i(36642);
    com.tencent.mm.storage.ad localad = ((l)g.ab(l.class)).dlF().apH(this.fTa);
    if (this.JWE > 0L)
    {
      Object localObject = localad.DD(this.JWE);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() > 0)
      {
        localObject = fHd();
        l = ((ei)localObject).field_createTime;
        StringBuilder localStringBuilder = new StringBuilder("[findUpdateLastCreateTime]isSender=");
        if (((ei)localObject).field_isSend == 1) {}
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", bool + " mLastBottomMsgSeq=" + this.JWE + " chatroomMsgSeq:" + localad + " mLastBottomCreateTime=" + this.JWD + " localLastMsgCreateTime=" + l);
          if (((ei)localObject).field_isSend != 1) {
            break;
          }
          AppMethodBeat.o(36642);
          return l;
        }
        l = this.JWD;
        AppMethodBeat.o(36642);
        return l;
      }
    }
    long l = fHc();
    AppMethodBeat.o(36642);
    return l;
  }
  
  private long fHb()
  {
    AppMethodBeat.i(36643);
    if (this.JWC == 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.JWC = ((l)g.ab(l.class)).dlK().i(this.fTa, fHc(), 18);
    }
    long l = this.JWC;
    AppMethodBeat.o(36643);
    return l;
  }
  
  private bu fHd()
  {
    AppMethodBeat.i(36645);
    bu localbu = ((l)g.ab(l.class)).dlK().apX(this.fTa);
    AppMethodBeat.o(36645);
    return localbu;
  }
  
  final long Em(long paramLong)
  {
    AppMethodBeat.i(36641);
    com.tencent.mm.k.a.a.c localc = ((l)g.ab(l.class)).dlF().e(this.fTa, paramLong, true);
    if (localc != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.fVo + " time:" + paramLong);
      paramLong = localc.fVo;
      AppMethodBeat.o(36641);
      return paramLong;
    }
    paramLong = fHc();
    AppMethodBeat.o(36641);
    return paramLong;
  }
  
  public final void a(final d.b paramb)
  {
    AppMethodBeat.i(36634);
    switch (6.JWs[this.JWB.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36634);
      return;
      b(paramb);
      AppMethodBeat.o(36634);
      return;
      if ((this.JWG != null) && (this.JWG.getBoolean("load_bottom", false)))
      {
        localObject = ((l)g.ab(l.class)).dlF().apH(this.fTa);
        l1 = ((com.tencent.mm.storage.ad)localObject).field_lastPushSeq;
        l2 = ((com.tencent.mm.storage.ad)localObject).field_lastLocalSeq;
        com.tencent.mm.at.b.aHW().a(this.fTa, l1, 1L + l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bu> paramAnonymousList)
          {
            AppMethodBeat.i(36628);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.fGZ();
              long l2 = b.this.fHc();
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.fTa + " from:" + l1 + " to:" + l2);
              b.this.Tc = ((l)g.ab(l.class)).dlK().d(b.this.fTa, l1, l2, 18);
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
      Object localObject = ((l)g.ab(l.class)).dlF();
      com.tencent.mm.k.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).e(this.fTa, this.JWD, true);
      if (localc != null)
      {
        com.tencent.mm.at.b.aHW().a(this.fTa, localc.fVm, localc.fVn, 0, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bu> paramAnonymousList)
          {
            AppMethodBeat.i(36629);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.JWC;
              paramAnonymousList = (bu)paramAnonymousList.get(paramAnonymousList.size() - 1);
              long l2 = b.this.Em(paramAnonymousList.field_createTime);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fTa + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramAnonymousList.field_createTime);
              b.this.Tc = ((l)g.ab(l.class)).dlK().d(b.this.fTa, l1, l2, 2147483647);
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
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.fTa + " mLastBottomCreateTime:" + this.JWD);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).apH(this.fTa);
      long l1 = ((com.tencent.mm.storage.ad)localObject).field_lastPushSeq;
      final long l2 = ((com.tencent.mm.storage.ad)localObject).field_lastLocalSeq;
      com.tencent.mm.at.b.aHW().a(this.fTa, 1L + l2, l1, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bu> paramAnonymousList)
        {
          AppMethodBeat.i(36630);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            long l1 = b.this.JWC;
            bu localbu = (bu)paramAnonymousList.get(paramAnonymousList.size() - 1);
            long l2 = b.this.Em(localbu.field_createTime);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fTa + " from:" + l1 + " to:" + l2 + " size:" + paramAnonymousList.size());
            b.this.Tc = ((l)g.ab(l.class)).dlK().d(b.this.fTa, l1, l2, 2147483647);
            paramb.next();
            AppMethodBeat.o(36630);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(paramAnonymousInt)));
          b.this.d(paramb);
          AppMethodBeat.o(36630);
        }
      });
      AppMethodBeat.o(36634);
      return;
      localObject = ((l)g.ab(l.class)).dlF();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aE(this.fTa, this.JWC);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.JWC;
        i = ((l)g.ab(l.class)).dlK().D(this.fTa, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.fTa).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
        if (localc != null) {
          break label614;
        }
      }
      label614:
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", bool);
        if ((i < 18) && (localc != null)) {
          break label620;
        }
        l2 = this.JWD;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.fTa + " from:" + l1 + " to:" + l2 + " count:" + (this.JWF + 18));
        this.Tc = ((l)g.ab(l.class)).dlK().d(this.fTa, l1, l2, this.JWF + 18);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        l1 = localc.fVp;
        break;
      }
      label620:
      if (localc != null)
      {
        l1 = localc.fVn;
        l2 = localc.fVm;
        l3 = localc.fVp;
        l4 = localc.fVo;
        com.tencent.mm.at.b.aHW().a(this.fTa, l1, l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bu> paramAnonymousList)
          {
            AppMethodBeat.i(36631);
            long l2;
            if (paramAnonymousInt >= 0)
            {
              l2 = l4;
              if (paramAnonymousList.size() <= 0) {
                break label273;
              }
              l2 = ((bu)paramAnonymousList.get(0)).field_createTime;
            }
            label273:
            for (;;)
            {
              long l1 = l2;
              if (l3.aE(b.this.fTa, l2) == null)
              {
                l1 = l2;
                if (paramAnonymousList.size() < 18) {
                  l1 = ((l)g.ab(l.class)).dlK().i(b.this.fTa, l2, 18 - paramAnonymousList.size());
                }
              }
              l2 = l1;
              if (l1 <= 0L) {
                l2 = l4;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.fTa + " firstCreateTime:" + l4 + " lastCreateTime:" + paramb + " from:" + l2);
              b.this.Tc = ((l)g.ab(l.class)).dlK().d(b.this.fTa, l2, b.this.JWD, b.this.JWF + 18);
              this.JUZ.next();
              AppMethodBeat.o(36631);
              return;
              b.this.d(this.JUZ);
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
      if (this.vgw)
      {
        l1 = this.JWG.getLong("MSG_ID");
        bool = this.JWG.getBoolean("IS_LOAD_ALL", false);
        ba.aBQ();
        localObject = com.tencent.mm.model.c.azs().xY(l1);
        if (((ei)localObject).field_msgId != l1)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(36634);
          return;
        }
        l2 = ((ei)localObject).field_createTime;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.JWC), Long.valueOf(this.JWD) });
        if ((l2 < this.JWC) || (l2 > this.JWD))
        {
          l2 = ((ei)localObject).field_createTime;
          ba.aBQ();
          l3 = com.tencent.mm.model.c.azs().j(this.fTa, l2, 18);
          l3 = Math.min(Em(((ei)localObject).field_createTime), l3);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.Tc = ((l)g.ab(l.class)).dlK().d(this.fTa, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.JWH.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(36634);
          return;
          this.Tc = ((l)g.ab(l.class)).dlK().d(this.fTa, this.JWC, this.JWD, 2147483647);
          ba.aBQ();
          i = com.tencent.mm.model.c.azs().D(this.fTa, this.JWC, l2) - 1;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((l)g.ab(l.class)).dlF();
      if (this.JWG == null)
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.JWG != null) {
          break label1300;
        }
      }
      label1300:
      for (int i = 0;; i = this.JWG.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1314;
        }
        l1 = fHa();
        l2 = ((l)g.ab(l.class)).dlK().i(this.fTa, l1, i);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.fTa + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.Tc = ((l)g.ab(l.class)).dlK().d(this.fTa, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        bool = false;
        break;
      }
      label1314:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).apG(this.fTa);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.fTa });
        d(paramb);
        AppMethodBeat.o(36634);
        return;
      }
      l1 = ((com.tencent.mm.k.a.a.c)localObject).fVm;
      l2 = ((com.tencent.mm.k.a.a.c)localObject).fVo;
      final long l3 = ((com.tencent.mm.k.a.a.c)localObject).fVn;
      final long l4 = ((com.tencent.mm.k.a.a.c)localObject).fVp;
      com.tencent.mm.at.b.aHW().a(this.fTa, l1, l3, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bu> paramAnonymousList)
        {
          AppMethodBeat.i(36627);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.fTa + " fromCreateTime:" + l2 + " toCreateTime:" + paramb + " addSize:" + paramAnonymousList.size());
            long l = paramb;
            if (paramAnonymousList.size() <= 18) {
              l = b.this.Em(((bu)paramAnonymousList.get(paramAnonymousList.size() - 1)).field_createTime);
            }
            b.this.Tc = ((l)g.ab(l.class)).dlK().d(b.this.fTa, l2, l, 36);
            this.JUZ.next();
            AppMethodBeat.o(36627);
            return;
          }
          b.this.d(this.JUZ);
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
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
    c(paramb);
    AppMethodBeat.o(36646);
  }
  
  final long fGZ()
  {
    AppMethodBeat.i(36640);
    com.tencent.mm.k.a.a.c localc = ((l)g.ab(l.class)).dlF().apG(this.fTa);
    if (localc != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.fVp + " seq:" + localc.fVm + "~" + localc.fVn);
      l = localc.fVp;
      AppMethodBeat.o(36640);
      return l;
    }
    long l = this.JWC;
    AppMethodBeat.o(36640);
    return l;
  }
  
  final long fHc()
  {
    AppMethodBeat.i(36644);
    long l = ((l)g.ab(l.class)).dlK().aqq(this.fTa);
    AppMethodBeat.o(36644);
    return l;
  }
  
  public final int fpw()
  {
    AppMethodBeat.i(36637);
    ba.aBQ();
    int i = com.tencent.mm.model.c.azs().aqm(this.fTa);
    AppMethodBeat.o(36637);
    return i;
  }
  
  public final void in(List<bu> paramList)
  {
    AppMethodBeat.i(36638);
    if (this.Tc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(36638);
      return;
    }
    this.Tc.moveToFirst();
    try
    {
      while (!this.Tc.isAfterLast())
      {
        bu localbu = new bu();
        localbu.convertFrom(this.Tc);
        paramList.add(localbu);
        this.Tc.moveToNext();
      }
      AppMethodBeat.o(36638);
    }
    catch (IllegalStateException paramList)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ChattingLoader.ChattingGetDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36638);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.b
 * JD-Core Version:    0.7.0.1
 */