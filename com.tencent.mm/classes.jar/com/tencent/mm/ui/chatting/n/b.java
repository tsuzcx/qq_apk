package com.tencent.mm.ui.chatting.n;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.b.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.b;
import com.tencent.mm.ui.chatting.h.d.d;
import java.util.List;

public final class b
  implements f<ca>
{
  private d.a PFh;
  long PFi;
  long PFj;
  private long PFk;
  int PFl;
  private Bundle PFm;
  private d.d PFn;
  Cursor To;
  String gAn;
  private boolean yMq;
  
  public b(String paramString, d.a parama, Bundle paramBundle, long paramLong1, long paramLong2, long paramLong3, int paramInt, d.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36633);
    this.PFk = paramLong1;
    this.PFi = paramLong2;
    this.PFj = paramLong3;
    this.PFl = paramInt;
    this.gAn = paramString;
    this.PFh = parama;
    this.PFm = paramBundle;
    this.PFn = paramd;
    this.yMq = paramBoolean;
    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.PFi + " mLastBottomCreateTime:" + this.PFj + " isFromSearch:" + paramBoolean + " mLastCount:" + this.PFl + " mLastBottomMsgSeq:" + this.PFk + " mTalker:" + this.gAn + " action:" + parama);
    AppMethodBeat.o(36633);
  }
  
  private void b(d.b paramb)
  {
    AppMethodBeat.i(36635);
    long l1 = gTM();
    long l2 = gTP();
    Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    this.To = ((l)g.af(l.class)).eiy().d(this.gAn, l1, l2, 18);
    paramb.next();
    AppMethodBeat.o(36635);
  }
  
  private void c(d.b paramb)
  {
    AppMethodBeat.i(36636);
    boolean bool;
    if ((this.PFn.PDK != null) && (this.PFn.PDK.getBoolean("has_position_tongue", false)))
    {
      bool = true;
      if ((this.PFn.PDK == null) || (!this.PFn.PDK.getBoolean("has_position_search", false))) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (!bool) {
        break label178;
      }
      ca localca = ((l)g.af(l.class)).eiy().aEx(this.gAn);
      if ((localca == null) || (localca.field_isSend != 1) || (localca.field_msgSeq != 0L)) {
        break label178;
      }
      b(paramb);
      if (this.PFn.PDK == null) {
        this.PFn.PDK = new Bundle();
      }
      this.PFn.PDK.putBoolean("need_scroll_to_bottom", true);
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
      AppMethodBeat.o(36636);
      return;
      bool = false;
      break;
    }
    label178:
    long l2 = gTO();
    if ((!bool) && (i != 0)) {}
    for (long l1 = this.PFj;; l1 = gTN())
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.gAn + " from:" + l2 + " to:" + l1 + " hasTongue:" + bool);
      this.To = ((l)g.af(l.class)).eiy().d(this.gAn, l2, l1, 2147483647);
      paramb.next();
      AppMethodBeat.o(36636);
      return;
    }
  }
  
  private long gTN()
  {
    AppMethodBeat.i(36642);
    aj localaj = ((l)g.af(l.class)).eit().aEh(this.gAn);
    if (this.PFk > 0L)
    {
      Object localObject = localaj.Ng(this.PFk);
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] list size=", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).size() > 0)
      {
        localObject = gTQ();
        l = ((eo)localObject).field_createTime;
        StringBuilder localStringBuilder = new StringBuilder("[findUpdateLastCreateTime]isSender=");
        if (((eo)localObject).field_isSend == 1) {}
        for (boolean bool = true;; bool = false)
        {
          Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", bool + " mLastBottomMsgSeq=" + this.PFk + " chatroomMsgSeq:" + localaj + " mLastBottomCreateTime=" + this.PFj + " localLastMsgCreateTime=" + l);
          if (((eo)localObject).field_isSend != 1) {
            break;
          }
          AppMethodBeat.o(36642);
          return l;
        }
        l = this.PFj;
        AppMethodBeat.o(36642);
        return l;
      }
    }
    long l = gTP();
    AppMethodBeat.o(36642);
    return l;
  }
  
  private long gTO()
  {
    AppMethodBeat.i(36643);
    if (this.PFi == 0L)
    {
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
      this.PFi = ((l)g.af(l.class)).eiy().i(this.gAn, gTP(), 18);
    }
    long l = this.PFi;
    AppMethodBeat.o(36643);
    return l;
  }
  
  private ca gTQ()
  {
    AppMethodBeat.i(36645);
    ca localca = ((l)g.af(l.class)).eiy().aEx(this.gAn);
    AppMethodBeat.o(36645);
    return localca;
  }
  
  final long NT(long paramLong)
  {
    AppMethodBeat.i(36641);
    com.tencent.mm.k.a.a.c localc = ((l)g.af(l.class)).eit().e(this.gAn, paramLong, true);
    if (localc != null)
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + localc.gCA + " time:" + paramLong);
      paramLong = localc.gCA;
      AppMethodBeat.o(36641);
      return paramLong;
    }
    paramLong = gTP();
    AppMethodBeat.o(36641);
    return paramLong;
  }
  
  public final void a(final d.b paramb)
  {
    AppMethodBeat.i(36634);
    switch (6.PEY[this.PFh.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36634);
      return;
      b(paramb);
      AppMethodBeat.o(36634);
      return;
      if ((this.PFm != null) && (this.PFm.getBoolean("load_bottom", false)))
      {
        localObject = ((l)g.af(l.class)).eit().aEh(this.gAn);
        l1 = ((aj)localObject).field_lastPushSeq;
        l2 = ((aj)localObject).field_lastLocalSeq;
        com.tencent.mm.as.b.bch().a(this.gAn, l1, 1L + l2, 1, new b.b()
        {
          public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(36628);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.gTM();
              long l2 = b.this.gTP();
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.gAn + " from:" + l1 + " to:" + l2);
              b.this.To = ((l)g.af(l.class)).eiy().d(b.this.gAn, l1, l2, 18);
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
      Object localObject = ((l)g.af(l.class)).eit();
      com.tencent.mm.k.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).e(this.gAn, this.PFj, true);
      if (localc != null)
      {
        com.tencent.mm.as.b.bch().a(this.gAn, localc.gCy, localc.gCz, 0, new b.b()
        {
          public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(36629);
            if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
            {
              long l1 = b.this.PFi;
              paramAnonymousList = (ca)paramAnonymousList.get(paramAnonymousList.size() - 1);
              long l2 = b.this.NT(paramAnonymousList.field_createTime);
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.gAn + " from:" + l1 + " to:" + l2 + " addMsg.CreateTime:" + paramAnonymousList.field_createTime);
              b.this.To = ((l)g.af(l.class)).eiy().d(b.this.gAn, l1, l2, 2147483647);
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
      Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.gAn + " mLastBottomCreateTime:" + this.PFj);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aEh(this.gAn);
      long l1 = ((aj)localObject).field_lastPushSeq;
      final long l2 = ((aj)localObject).field_lastLocalSeq;
      com.tencent.mm.as.b.bch().a(this.gAn, 1L + l2, l1, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
        {
          AppMethodBeat.i(36630);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            long l1 = b.this.PFi;
            ca localca = (ca)paramAnonymousList.get(paramAnonymousList.size() - 1);
            long l2 = b.this.NT(localca.field_createTime);
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.gAn + " from:" + l1 + " to:" + l2 + " size:" + paramAnonymousList.size());
            b.this.To = ((l)g.af(l.class)).eiy().d(b.this.gAn, l1, l2, 2147483647);
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
      localObject = ((l)g.af(l.class)).eit();
      localc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aF(this.gAn, this.PFi);
      StringBuilder localStringBuilder;
      if (localc == null)
      {
        l1 = 0L;
        l2 = this.PFi;
        i = ((l)g.af(l.class)).eiy().E(this.gAn, l1, l2);
        localStringBuilder = new StringBuilder("[handleLoadTop] talker:").append(this.gAn).append(" from:").append(l1).append(" to:").append(l2).append(" count:").append(i).append(" seqBlock is null? ");
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
        l2 = this.PFj;
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.gAn + " from:" + l1 + " to:" + l2 + " count:" + (this.PFl + 18));
        this.To = ((l)g.af(l.class)).eiy().d(this.gAn, l1, l2, this.PFl + 18);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        l1 = localc.gCB;
        break;
      }
      label620:
      if (localc != null)
      {
        l1 = localc.gCz;
        l2 = localc.gCy;
        l3 = localc.gCB;
        l4 = localc.gCA;
        com.tencent.mm.as.b.bch().a(this.gAn, l1, l2, 1, new b.b()
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
              if (l3.aF(b.this.gAn, l2) == null)
              {
                l1 = l2;
                if (paramAnonymousList.size() < 18) {
                  l1 = ((l)g.af(l.class)).eiy().i(b.this.gAn, l2, 18 - paramAnonymousList.size());
                }
              }
              l2 = l1;
              if (l1 <= 0L) {
                l2 = l4;
              }
              Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.gAn + " firstCreateTime:" + l4 + " lastCreateTime:" + paramb + " from:" + l2);
              b.this.To = ((l)g.af(l.class)).eiy().d(b.this.gAn, l2, b.this.PFj, b.this.PFl + 18);
              this.PDz.next();
              AppMethodBeat.o(36631);
              return;
              b.this.d(this.PDz);
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
      if (this.yMq)
      {
        l1 = this.PFm.getLong("MSG_ID");
        bool = this.PFm.getBoolean("IS_LOAD_ALL", false);
        bg.aVF();
        localObject = com.tencent.mm.model.c.aSQ().Hb(l1);
        if (((eo)localObject).field_msgId != l1)
        {
          Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", new Object[] { Long.valueOf(l1) });
          paramb.next();
          AppMethodBeat.o(36634);
          return;
        }
        l2 = ((eo)localObject).field_createTime;
        Log.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(this.PFi), Long.valueOf(this.PFj) });
        if ((l2 < this.PFi) || (l2 > this.PFj))
        {
          l2 = ((eo)localObject).field_createTime;
          bg.aVF();
          l3 = com.tencent.mm.model.c.aSQ().j(this.gAn, l2, 18);
          l3 = Math.min(NT(((eo)localObject).field_createTime), l3);
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(0) });
          this.To = ((l)g.af(l.class)).eiy().d(this.gAn, l2, l3, 2147483647);
          i = 0;
        }
        for (;;)
        {
          this.PFn.selection = Math.max(0, i);
          paramb.next();
          AppMethodBeat.o(36634);
          return;
          this.To = ((l)g.af(l.class)).eiy().d(this.gAn, this.PFi, this.PFj, 2147483647);
          bg.aVF();
          i = com.tencent.mm.model.c.aSQ().E(this.gAn, this.PFi, l2) - 1;
          Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool) });
        }
      }
      localObject = ((l)g.af(l.class)).eit();
      if (this.PFm == null)
      {
        bool = true;
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "null == mSourceArgs?%s", new Object[] { Boolean.valueOf(bool) });
        if (this.PFm != null) {
          break label1300;
        }
      }
      label1300:
      for (int i = 0;; i = this.PFm.getInt("MSG_POSITION_UNREAD_COUNT"))
      {
        if (i <= 0) {
          break label1314;
        }
        l1 = gTN();
        l2 = ((l)g.af(l.class)).eiy().i(this.gAn, l1, i);
        Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.gAn + " from:" + l2 + " to:" + l1 + " unreadCount:" + i);
        this.To = ((l)g.af(l.class)).eiy().d(this.gAn, l2, l1, 2147483647);
        paramb.next();
        AppMethodBeat.o(36634);
        return;
        bool = false;
        break;
      }
      label1314:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject).aEg(this.gAn);
      if (localObject == null)
      {
        Log.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", new Object[] { this.gAn });
        d(paramb);
        AppMethodBeat.o(36634);
        return;
      }
      l1 = ((com.tencent.mm.k.a.a.c)localObject).gCy;
      l2 = ((com.tencent.mm.k.a.a.c)localObject).gCA;
      final long l3 = ((com.tencent.mm.k.a.a.c)localObject).gCz;
      final long l4 = ((com.tencent.mm.k.a.a.c)localObject).gCB;
      com.tencent.mm.as.b.bch().a(this.gAn, l1, l3, 0, new b.b()
      {
        public final void b(int paramAnonymousInt, List<ca> paramAnonymousList)
        {
          AppMethodBeat.i(36627);
          if ((paramAnonymousInt >= 0) && (paramAnonymousList.size() > 0))
          {
            Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.gAn + " fromCreateTime:" + l2 + " toCreateTime:" + paramb + " addSize:" + paramAnonymousList.size());
            long l = paramb;
            if (paramAnonymousList.size() <= 18) {
              l = b.this.NT(((ca)paramAnonymousList.get(paramAnonymousList.size() - 1)).field_createTime);
            }
            b.this.To = ((l)g.af(l.class)).eiy().d(b.this.gAn, l2, l, 36);
            this.PDz.next();
            AppMethodBeat.o(36627);
            return;
          }
          b.this.d(this.PDz);
          AppMethodBeat.o(36627);
        }
      });
    }
  }
  
  public final int cZm()
  {
    AppMethodBeat.i(36637);
    bg.aVF();
    int i = com.tencent.mm.model.c.aSQ().aEM(this.gAn);
    AppMethodBeat.o(36637);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(36639);
    if (this.To != null) {
      this.To.close();
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
  
  final long gTM()
  {
    AppMethodBeat.i(36640);
    com.tencent.mm.k.a.a.c localc = ((l)g.af(l.class)).eit().aEg(this.gAn);
    if (localc != null)
    {
      Log.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + localc.gCB + " seq:" + localc.gCy + "~" + localc.gCz);
      l = localc.gCB;
      AppMethodBeat.o(36640);
      return l;
    }
    long l = this.PFi;
    AppMethodBeat.o(36640);
    return l;
  }
  
  final long gTP()
  {
    AppMethodBeat.i(36644);
    long l = ((l)g.af(l.class)).eiy().aEQ(this.gAn);
    AppMethodBeat.o(36644);
    return l;
  }
  
  public final void jA(List<ca> paramList)
  {
    AppMethodBeat.i(36638);
    if (this.To == null)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
      AppMethodBeat.o(36638);
      return;
    }
    this.To.moveToFirst();
    try
    {
      while (!this.To.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(this.To);
        paramList.add(localca);
        this.To.moveToNext();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.b
 * JD-Core Version:    0.7.0.1
 */