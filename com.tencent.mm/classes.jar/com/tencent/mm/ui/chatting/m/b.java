package com.tencent.mm.ui.chatting.m;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.b.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.b;
import com.tencent.mm.ui.chatting.g.d.d;
import java.util.List;

public final class b
  implements e<bo>
{
  private d.a Igo;
  long Igp;
  long Igq;
  private long Igr;
  int Igs;
  private Bundle Igt;
  private d.d Igu;
  Cursor Rn;
  String fzK;
  private boolean udM;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36633);
    this.Igr = paramLong1;
    this.Igp = paramLong2;
    this.Igq = paramLong3;
    this.Igs = paramInt;
    this.fzK = paramString;
    this.Igo = parama;
    this.Igt = paramBundle;
    this.Igu = paramd;
    this.udM = paramBoolean;
    ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.Igp + " mLastBottomCreateTime:" + this.Igq + " isFromSearch:" + paramBoolean + " mLastCount:" + this.Igs + " mLastBottomMsgSeq:" + this.Igr + " mTalker:" + this.fzK + " action:" + parama);
    AppMethodBeat.o(36633);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(36635);
    long l1 = fql();
    long l2 = fqo();
    ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.Rn = ((k)g.ab(k.class)).dcr().d(this.fzK, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(36635);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(36636);
    boolean bool;
    if ((this.Igu.IeX != null) && (this.Igu.IeX.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.Igu.IeX == null) || (!this.Igu.IeX.getBoolean("has_position_search", false))) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label178;
      }
      bo localbo = ((k)g.ab(k.class)).dcr().alk(this.fzK);
      if ((localbo == null) || (localbo.field_isSend != 1) || (localbo.field_msgSeq != 0L)) {
        break label178;
      }
      b(paramb);
      if (this.Igu.IeX == null) {
        this.Igu.IeX = new Bundle();
      }
      this.Igu.IeX.putBoolean("need_scroll_to_bottom", true);
      ac.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(36636);
      return;
      bool = false;
      break;
    }
    label178:
    long l2 = fqn();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.Igq;; l1 = fqm())
    {
      ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.fzK + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.Rn = ((k)g.ab(k.class)).dcr().d(this.fzK, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(36636);
      return;
    }
  }
  
  private long fqm()
  {
    AppMethodBeat.i(36642);
    z localz = ((k)g.ab(k.class)).dcm().akV(this.fzK);
    if (this.Igr > 0L)
    {
      Object localObject = localz.AN(this.Igr);
      ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() > 0)
      {
        localObject = fqp();
        l = ((dy)localObject).field_createTime;
        StringBuilder localStringBuilder = new StringBuilder("[findUpdateLastCreateTime]isSender=");
        if (((dy)localObject).field_isSend == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ac.w("MicroMsg.ChattingLoader.ChattingGetDataSource", bool + " mLastBottomMsgSeq=" + this.Igr + " chatroomMsgSeq:" + localz + " mLastBottomCreateTime=" + this.Igq + " localLastMsgCreateTime=" + l);
          if (((dy)localObject).field_isSend != 1) {
            break;
          }
          AppMethodBeat.o(36642);
          return l;
        }
        l = this.Igq;
        AppMethodBeat.o(36642);
        return l;
      }
    }
    long l = fqo();
    AppMethodBeat.o(36642);
    return l;
  }
  
  private long fqn()
  {
    AppMethodBeat.i(36643);
    if (this.Igp == 0L)
    {
      ac.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.Igp = ((k)g.ab(k.class)).dcr().g(this.fzK, fqo(), 18);
    }
    long l = this.Igp;
    AppMethodBeat.o(36643);
    return l;
  }
  
  private bo fqp()
  {
    AppMethodBeat.i(36645);
    bo localbo = ((k)g.ab(k.class)).dcr().alk(this.fzK);
    AppMethodBeat.o(36645);
    return localbo;
  }
  
  final long Bu(long paramLong)
  {
    AppMethodBeat.i(36641);
    com.tencent.mm.j.a.a.c localc = ((k)g.ab(k.class)).dcm().f(this.fzK, paramLong, true);
    if (localc != null)
    {
      ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.fCa + " time:" + paramLong);
      paramLong = localc.fCa;
      AppMethodBeat.o(36641);
      return paramLong;
    }
    paramLong = fqo();
    AppMethodBeat.o(36641);
    return paramLong;
  }
  
  public final void a(final d.b paramb)
  {
    AppMethodBeat.i(36634);
    switch (6.Igf[this.Igo.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36634);
      return;
      b(paramb);
      AppMethodBeat.o(36634);
      return;
      if ((this.Igt != null) && (this.Igt.getBoolean("load_bottom", false)))
      {
        localObject = ((k)g.ab(k.class)).dcm().akV(this.fzK);
        l1 = ((z)localObject).field_lastPushSeq;
        l2 = ((z)localObject).field_lastLocalSeq;
        com.tencent.mm.as.b.aER().a(this.fzK, l1, 1L + l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bo> paramAnonymousList)
          {
            AppMethodBeat.i(36628);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.fql();
              long l2 = b.this.fqo();
              ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.fzK + " from:" + l1 + " to:" + l2);
              b.this.Rn = ((k)g.ab(k.class)).dcr().d(b.this.fzK, l1, l2, 18);
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
      Object localObject = ((k)g.ab(k.class)).dcm();
      com.tencent.mm.j.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).f(this.fzK, this.Igq, true);
      if (localc != null)
      {
        com.tencent.mm.as.b.aER().a(this.fzK, localc.fBY, localc.fBZ, 0, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bo> paramAnonymousList)
          {
            AppMethodBeat.i(36629);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.Igp;
              paramAnonymousList = (bo)paramAnonymousList.get(paramAnonymousList.size() - 1);
              long l2 = b.this.Bu(paramAnonymousList.field_createTime);
              ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fzK + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramAnonymousList.field_createTime);
              b.this.Rn = ((k)g.ab(k.class)).dcr().d(b.this.fzK, l1, l2, 2147483647);
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
      ac.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.fzK + " mLastBottomCreateTime:" + this.Igq);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).akV(this.fzK);
      long l1 = ((z)localObject).field_lastPushSeq;
      final long l2 = ((z)localObject).field_lastLocalSeq;
      com.tencent.mm.as.b.aER().a(this.fzK, 1L + l2, l1, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bo> paramAnonymousList)
        {
          AppMethodBeat.i(36630);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            long l1 = b.this.Igp;
            bo localbo = (bo)paramAnonymousList.get(paramAnonymousList.size() - 1);
            long l2 = b.this.Bu(localbo.field_createTime);
            ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.fzK + " from:" + l1 + " to:" + l2 + " size:" + paramAnonymousList.size());
            b.this.Rn = ((k)g.ab(k.class)).dcr().d(b.this.fzK, l1, l2, 2147483647);
            paramb.next();
            AppMethodBeat.o(36630);
            return;
          }
          ac.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(paramAnonymousInt)));
          b.this.d(paramb);
          AppMethodBeat.o(36630);
        }
      });
      AppMethodBeat.o(36634);
      return;
      localObject = ((k)g.ab(k.class)).dcm();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aB(this.fzK, this.Igp);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.Igp;
        i = ((k)g.ab(k.class)).dcr().C(this.fzK, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.fzK).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
        if (localc != null) {
          break label614;
        }
      }
      label614:
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", bool);
        if ((i < 18) && (localc != null)) {
          break label620;
        }
        l2 = this.Igq;
        ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.fzK + " from:" + l1 + " to:" + l2 + " count:" + (this.Igs + 18));
        this.Rn = ((k)g.ab(k.class)).dcr().d(this.fzK, l1, l2, this.Igs + 18);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        l1 = localc.fCb;
        break;
      }
      label620:
      if (localc != null)
      {
        l1 = localc.fBZ;
        l2 = localc.fBY;
        l3 = localc.fCb;
        l4 = localc.fCa;
        com.tencent.mm.as.b.aER().a(this.fzK, l1, l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<bo> paramAnonymousList)
          {
            AppMethodBeat.i(36631);
            long l2;
            if (paramAnonymousInt >= 0)
            {
              l2 = l4;
              if (paramAnonymousList.size() <= 0) {
                break label273;
              }
              l2 = ((bo)paramAnonymousList.get(0)).field_createTime;
            }
            label273:
            for (;;)
            {
              long l1 = l2;
              if (l3.aB(b.this.fzK, l2) == null)
              {
                l1 = l2;
                if (paramAnonymousList.size() < 18) {
                  l1 = ((k)g.ab(k.class)).dcr().g(b.this.fzK, l2, 18 - paramAnonymousList.size());
                }
              }
              l2 = l1;
              if (l1 <= 0L) {
                l2 = l4;
              }
              ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.fzK + " firstCreateTime:" + l4 + " lastCreateTime:" + paramb + " from:" + l2);
              b.this.Rn = ((k)g.ab(k.class)).dcr().d(b.this.fzK, l2, b.this.Igq, b.this.Igs + 18);
              this.IeM.next();
              AppMethodBeat.o(36631);
              return;
              b.this.d(this.IeM);
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
      if (this.udM)
      {
        l1 = this.Igt.getLong("MSG_ID");
        bool = this.Igt.getBoolean("IS_LOAD_ALL", false);
        az.ayM();
        localObject = com.tencent.mm.model.c.awD().vP(l1);
        if (((dy)localObject).field_msgId != l1)
        {
          ac.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(36634);
          return;
        }
        l2 = ((dy)localObject).field_createTime;
        ac.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.Igp), Long.valueOf(this.Igq) });
        if ((l2 < this.Igp) || (l2 > this.Igq))
        {
          l2 = ((dy)localObject).field_createTime;
          az.ayM();
          l3 = com.tencent.mm.model.c.awD().h(this.fzK, l2, 18);
          l3 = Math.min(Bu(((dy)localObject).field_createTime), l3);
          ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.Rn = ((k)g.ab(k.class)).dcr().d(this.fzK, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.Igu.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(36634);
          return;
          this.Rn = ((k)g.ab(k.class)).dcr().d(this.fzK, this.Igp, this.Igq, 2147483647);
          az.ayM();
          i = com.tencent.mm.model.c.awD().C(this.fzK, this.Igp, l2) - 1;
          ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((k)g.ab(k.class)).dcm();
      if (this.Igt == null)
      {
        bool = true;
        ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.Igt != null) {
          break label1300;
        }
      }
      label1300:
      for (int i = 0;; i = this.Igt.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1314;
        }
        l1 = fqm();
        l2 = ((k)g.ab(k.class)).dcr().g(this.fzK, l1, i);
        ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.fzK + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.Rn = ((k)g.ab(k.class)).dcr().d(this.fzK, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        bool = false;
        break;
      }
      label1314:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).akU(this.fzK);
      if (localObject == null)
      {
        ac.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.fzK });
        d(paramb);
        AppMethodBeat.o(36634);
        return;
      }
      l1 = ((com.tencent.mm.j.a.a.c)localObject).fBY;
      l2 = ((com.tencent.mm.j.a.a.c)localObject).fCa;
      final long l3 = ((com.tencent.mm.j.a.a.c)localObject).fBZ;
      final long l4 = ((com.tencent.mm.j.a.a.c)localObject).fCb;
      com.tencent.mm.as.b.aER().a(this.fzK, l1, l3, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<bo> paramAnonymousList)
        {
          AppMethodBeat.i(36627);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.fzK + " fromCreateTime:" + l2 + " toCreateTime:" + paramb + " addSize:" + paramAnonymousList.size());
            long l = paramb;
            if (paramAnonymousList.size() <= 18) {
              l = b.this.Bu(((bo)paramAnonymousList.get(paramAnonymousList.size() - 1)).field_createTime);
            }
            b.this.Rn = ((k)g.ab(k.class)).dcr().d(b.this.fzK, l2, l, 36);
            this.IeM.next();
            AppMethodBeat.o(36627);
            return;
          }
          b.this.d(this.IeM);
          AppMethodBeat.o(36627);
        }
      });
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(36639);
    if (this.Rn != null) {
      this.Rn.close();
    }
    AppMethodBeat.o(36639);
  }
  
  final void d(d.b paramb)
  {
    AppMethodBeat.i(36646);
    ac.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
    c(paramb);
    AppMethodBeat.o(36646);
  }
  
  public final int eZx()
  {
    AppMethodBeat.i(36637);
    az.ayM();
    int i = com.tencent.mm.model.c.awD().aly(this.fzK);
    AppMethodBeat.o(36637);
    return i;
  }
  
  final long fql()
  {
    AppMethodBeat.i(36640);
    com.tencent.mm.j.a.a.c localc = ((k)g.ab(k.class)).dcm().akU(this.fzK);
    if (localc != null)
    {
      ac.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.fCb + " seq:" + localc.fBY + "~" + localc.fBZ);
      l = localc.fCb;
      AppMethodBeat.o(36640);
      return l;
    }
    long l = this.Igp;
    AppMethodBeat.o(36640);
    return l;
  }
  
  final long fqo()
  {
    AppMethodBeat.i(36644);
    long l = ((k)g.ab(k.class)).dcr().alC(this.fzK);
    AppMethodBeat.o(36644);
    return l;
  }
  
  public final void ib(List<bo> paramList)
  {
    AppMethodBeat.i(36638);
    if (this.Rn == null)
    {
      ac.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(36638);
      return;
    }
    this.Rn.moveToFirst();
    try
    {
      while (!this.Rn.isAfterLast())
      {
        bo localbo = new bo();
        localbo.convertFrom(this.Rn);
        paramList.add(localbo);
        this.Rn.moveToNext();
      }
      AppMethodBeat.o(36638);
    }
    catch (IllegalStateException paramList)
    {
      ac.printErrStackTrace("MicroMsg.ChattingLoader.ChattingGetDataSource", paramList, "", new Object[0]);
      AppMethodBeat.o(36638);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.b
 * JD-Core Version:    0.7.0.1
 */