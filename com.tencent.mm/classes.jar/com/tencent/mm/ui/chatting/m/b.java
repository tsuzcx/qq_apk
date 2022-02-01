package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.b.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.b;
import com.tencent.mm.ui.chatting.g.d.d;
import java.util.List;

public final class b
  implements e<bl>
{
  private d.a GGs;
  long GGt;
  long GGu;
  private long GGv;
  int GGw;
  private Bundle GGx;
  private d.d GGy;
  Cursor Qs;
  String fwd;
  private boolean sVA;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36633);
    this.GGv = paramLong1;
    this.GGt = paramLong2;
    this.GGu = paramLong3;
    this.GGw = paramInt;
    this.fwd = paramString;
    this.GGs = parama;
    this.GGx = paramBundle;
    this.GGy = paramd;
    this.sVA = paramBoolean;
    ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.GGt + " mLastBottomCreateTime:" + this.GGu + " isFromSearch:" + paramBoolean + " mLastCount:" + this.GGw + " mLastBottomMsgSeq:" + this.GGv + " mTalker:" + this.fwd + " action:" + parama);
    AppMethodBeat.o(36633);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(36635);
    long l1 = fav();
    long l2 = fay();
    ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.Qs = ((k)g.ab(k.class)).cOI().c(this.fwd, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(36635);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(36636);
    boolean bool;
    if ((this.GGy.GFb != null) && (this.GGy.GFb.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.GGy.GFb == null) || (!this.GGy.GFb.getBoolean("has_position_search", false))) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label178;
      }
      bl localbl = ((k)g.ab(k.class)).cOI().agq(this.fwd);
      if ((localbl == null) || (localbl.field_isSend != 1) || (localbl.field_msgSeq != 0L)) {
        break label178;
      }
      b(paramb);
      if (this.GGy.GFb == null) {
        this.GGy.GFb = new Bundle();
      }
      this.GGy.GFb.putBoolean("need_scroll_to_bottom", true);
      ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(36636);
      return;
      bool = false;
      break;
    }
    label178:
    long l2 = fax();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.GGu;; l1 = faw())
    {
      ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.fwd + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.Qs = ((k)g.ab(k.class)).cOI().c(this.fwd, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(36636);
      return;
    }
  }
  
  private long faw()
  {
    AppMethodBeat.i(36642);
    y localy = ((k)g.ab(k.class)).cOD().agb(this.fwd);
    if (this.GGv > 0L)
    {
      Object localObject = localy.wk(this.GGv);
      ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() > 0)
      {
        localObject = faz();
        l = ((du)localObject).field_createTime;
        StringBuilder localStringBuilder = new StringBuilder("[findUpdateLastCreateTime]isSender=");
        if (((du)localObject).field_isSend == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", bool + " mLastBottomMsgSeq=" + this.GGv + " chatroomMsgSeq:" + localy + " mLastBottomCreateTime=" + this.GGu + " localLastMsgCreateTime=" + l);
          if (((du)localObject).field_isSend != 1) {
            break;
          }
          AppMethodBeat.o(36642);
          return l;
        }
        l = this.GGu;
        AppMethodBeat.o(36642);
        return l;
      }
    }
    long l = fay();
    AppMethodBeat.o(36642);
    return l;
  }
  
  private long fax()
  {
    AppMethodBeat.i(36643);
    if (this.GGt == 0L)
    {
      ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.GGt = ((k)g.ab(k.class)).cOI().g(this.fwd, fay(), 18);
    }
    long l = this.GGt;
    AppMethodBeat.o(36643);
    return l;
  }
  
  private bl faz()
  {
    AppMethodBeat.i(36645);
    bl localbl = ((k)g.ab(k.class)).cOI().agq(this.fwd);
    AppMethodBeat.o(36645);
    return localbl;
  }
  
  public final void a(final d.b paramb)
  {
    AppMethodBeat.i(36634);
    switch (6.GGj[this.GGs.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36634);
      return;
      b(paramb);
      AppMethodBeat.o(36634);
      return;
      if ((this.GGx != null) && (this.GGx.getBoolean("load_bottom", false)))
      {
        localObject = ((k)g.ab(k.class)).cOD().agb(this.fwd);
        l1 = ((y)localObject).field_lastPushSeq;
        l2 = ((y)localObject).field_lastLocalSeq;
        com.tencent.mm.at.b.axZ().a(this.fwd, l1, 1L + l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bl> paramAnonymousList)
          {
            AppMethodBeat.i(36628);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.fav();
              long l2 = b.this.fay();
              ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.fwd + " from:" + l1 + " to:" + l2);
              b.this.Qs = ((k)g.ab(k.class)).cOI().c(b.this.fwd, l1, l2, 18);
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
      Object localObject = ((k)g.ab(k.class)).cOD();
      com.tencent.mm.j.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).f(this.fwd, this.GGu, true);
      if (localc != null)
      {
        com.tencent.mm.at.b.axZ().a(this.fwd, localc.fyr, localc.fys, 0, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bl> paramAnonymousList)
          {
            AppMethodBeat.i(36629);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.GGt;
              paramAnonymousList = (bl)paramAnonymousList.get(paramAnonymousList.size() - 1);
              long l2 = b.this.wR(paramAnonymousList.field_createTime);
              ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fwd + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramAnonymousList.field_createTime);
              b.this.Qs = ((k)g.ab(k.class)).cOI().c(b.this.fwd, l1, l2, 2147483647);
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
      ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.fwd + " mLastBottomCreateTime:" + this.GGu);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).agb(this.fwd);
      long l1 = ((y)localObject).field_lastPushSeq;
      final long l2 = ((y)localObject).field_lastLocalSeq;
      com.tencent.mm.at.b.axZ().a(this.fwd, 1L + l2, l1, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bl> paramAnonymousList)
        {
          AppMethodBeat.i(36630);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            long l1 = b.this.GGt;
            bl localbl = (bl)paramAnonymousList.get(paramAnonymousList.size() - 1);
            long l2 = b.this.wR(localbl.field_createTime);
            ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fwd + " from:" + l1 + " to:" + l2 + " size:" + paramAnonymousList.size());
            b.this.Qs = ((k)g.ab(k.class)).cOI().c(b.this.fwd, l1, l2, 2147483647);
            paramb.next();
            AppMethodBeat.o(36630);
            return;
          }
          ad.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(paramAnonymousInt)));
          b.this.d(paramb);
          AppMethodBeat.o(36630);
        }
      });
      AppMethodBeat.o(36634);
      return;
      localObject = ((k)g.ab(k.class)).cOD();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).az(this.fwd, this.GGt);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.GGt;
        i = ((k)g.ab(k.class)).cOI().E(this.fwd, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.fwd).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
        if (localc != null) {
          break label614;
        }
      }
      label614:
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", bool);
        if ((i < 18) && (localc != null)) {
          break label620;
        }
        l2 = this.GGu;
        ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.fwd + " from:" + l1 + " to:" + l2 + " count:" + (this.GGw + 18));
        this.Qs = ((k)g.ab(k.class)).cOI().c(this.fwd, l1, l2, this.GGw + 18);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        l1 = localc.fyu;
        break;
      }
      label620:
      if (localc != null)
      {
        l1 = localc.fys;
        l2 = localc.fyr;
        l3 = localc.fyu;
        l4 = localc.fyt;
        com.tencent.mm.at.b.axZ().a(this.fwd, l1, l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bl> paramAnonymousList)
          {
            AppMethodBeat.i(36631);
            long l2;
            if (paramAnonymousInt >= 0)
            {
              l2 = l4;
              if (paramAnonymousList.size() <= 0) {
                break label273;
              }
              l2 = ((bl)paramAnonymousList.get(0)).field_createTime;
            }
            label273:
            for (;;)
            {
              long l1 = l2;
              if (l3.az(b.this.fwd, l2) == null)
              {
                l1 = l2;
                if (paramAnonymousList.size() < 18) {
                  l1 = ((k)g.ab(k.class)).cOI().g(b.this.fwd, l2, 18 - paramAnonymousList.size());
                }
              }
              l2 = l1;
              if (l1 <= 0L) {
                l2 = l4;
              }
              ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.fwd + " firstCreateTime:" + l4 + " lastCreateTime:" + paramb + " from:" + l2);
              b.this.Qs = ((k)g.ab(k.class)).cOI().c(b.this.fwd, l2, b.this.GGu, b.this.GGw + 18);
              this.GEP.next();
              AppMethodBeat.o(36631);
              return;
              b.this.d(this.GEP);
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
      if (this.sVA)
      {
        l1 = this.GGx.getLong("MSG_ID");
        bool = this.GGx.getBoolean("IS_LOAD_ALL", false);
        az.arV();
        localObject = com.tencent.mm.model.c.apO().rm(l1);
        if (((du)localObject).field_msgId != l1)
        {
          ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(36634);
          return;
        }
        l2 = ((du)localObject).field_createTime;
        ad.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.GGt), Long.valueOf(this.GGu) });
        if ((l2 < this.GGt) || (l2 > this.GGu))
        {
          l2 = ((du)localObject).field_createTime;
          az.arV();
          l3 = com.tencent.mm.model.c.apO().h(this.fwd, l2, 18);
          l3 = Math.min(wR(((du)localObject).field_createTime), l3);
          ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.Qs = ((k)g.ab(k.class)).cOI().c(this.fwd, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.GGy.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(36634);
          return;
          this.Qs = ((k)g.ab(k.class)).cOI().c(this.fwd, this.GGt, this.GGu, 2147483647);
          az.arV();
          i = com.tencent.mm.model.c.apO().E(this.fwd, this.GGt, l2) - 1;
          ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((k)g.ab(k.class)).cOD();
      if (this.GGx == null)
      {
        bool = true;
        ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.GGx != null) {
          break label1300;
        }
      }
      label1300:
      for (int i = 0;; i = this.GGx.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1314;
        }
        l1 = faw();
        l2 = ((k)g.ab(k.class)).cOI().g(this.fwd, l1, i);
        ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.fwd + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.Qs = ((k)g.ab(k.class)).cOI().c(this.fwd, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        bool = false;
        break;
      }
      label1314:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aga(this.fwd);
      if (localObject == null)
      {
        ad.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.fwd });
        d(paramb);
        AppMethodBeat.o(36634);
        return;
      }
      l1 = ((com.tencent.mm.j.a.a.c)localObject).fyr;
      l2 = ((com.tencent.mm.j.a.a.c)localObject).fyt;
      final long l3 = ((com.tencent.mm.j.a.a.c)localObject).fys;
      final long l4 = ((com.tencent.mm.j.a.a.c)localObject).fyu;
      com.tencent.mm.at.b.axZ().a(this.fwd, l1, l3, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bl> paramAnonymousList)
        {
          AppMethodBeat.i(36627);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.fwd + " fromCreateTime:" + l2 + " toCreateTime:" + paramb + " addSize:" + paramAnonymousList.size());
            long l = paramb;
            if (paramAnonymousList.size() <= 18) {
              l = b.this.wR(((bl)paramAnonymousList.get(paramAnonymousList.size() - 1)).field_createTime);
            }
            b.this.Qs = ((k)g.ab(k.class)).cOI().c(b.this.fwd, l2, l, 36);
            this.GEP.next();
            AppMethodBeat.o(36627);
            return;
          }
          b.this.d(this.GEP);
          AppMethodBeat.o(36627);
        }
      });
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(36639);
    if (this.Qs != null) {
      this.Qs.close();
    }
    AppMethodBeat.o(36639);
  }
  
  final void d(d.b paramb)
  {
    AppMethodBeat.i(36646);
    ad.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
    c(paramb);
    AppMethodBeat.o(36646);
  }
  
  public final int eKa()
  {
    AppMethodBeat.i(36637);
    az.arV();
    int i = com.tencent.mm.model.c.apO().agE(this.fwd);
    AppMethodBeat.o(36637);
    return i;
  }
  
  final long fav()
  {
    AppMethodBeat.i(36640);
    com.tencent.mm.j.a.a.c localc = ((k)g.ab(k.class)).cOD().aga(this.fwd);
    if (localc != null)
    {
      ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.fyu + " seq:" + localc.fyr + "~" + localc.fys);
      l = localc.fyu;
      AppMethodBeat.o(36640);
      return l;
    }
    long l = this.GGt;
    AppMethodBeat.o(36640);
    return l;
  }
  
  final long fay()
  {
    AppMethodBeat.i(36644);
    long l = ((k)g.ab(k.class)).cOI().agI(this.fwd);
    AppMethodBeat.o(36644);
    return l;
  }
  
  public final void hO(List<bl> paramList)
  {
    AppMethodBeat.i(36638);
    if (this.Qs == null)
    {
      ad.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(36638);
      return;
    }
    this.Qs.moveToFirst();
    try
    {
      while (!this.Qs.isAfterLast())
      {
        bl localbl = new bl();
        localbl.convertFrom(this.Qs);
        paramList.add(localbl);
        this.Qs.moveToNext();
      }
      AppMethodBeat.o(36638);
    }
    catch (IllegalStateException paramList)
    {
      ad.printErrStackTrace("MicroMsg.ChattingLoader.ChattingGetDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36638);
      return;
    }
  }
  
  final long wR(long paramLong)
  {
    AppMethodBeat.i(36641);
    com.tencent.mm.j.a.a.c localc = ((k)g.ab(k.class)).cOD().f(this.fwd, paramLong, true);
    if (localc != null)
    {
      ad.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.fyt + " time:" + paramLong);
      paramLong = localc.fyt;
      AppMethodBeat.o(36641);
      return paramLong;
    }
    paramLong = fay();
    AppMethodBeat.o(36641);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.b
 * JD-Core Version:    0.7.0.1
 */