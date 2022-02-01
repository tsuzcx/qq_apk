package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.al;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.d.b.z;

@com.tencent.mm.ui.chatting.d.a.a(fFo=al.class)
@Deprecated
public final class aw
  extends a
  implements bq.a, al
{
  public static int JNg = 350;
  public boolean JNh;
  public boolean JNi;
  public boolean JNj;
  private com.tencent.mm.sdk.b.c JNk;
  private boolean JNl;
  
  public final void a(final at paramat, final bq parambq)
  {
    AppMethodBeat.i(35617);
    ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramat.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.cWM.cBJ)
    {
      ad.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(35617);
      return;
    }
    bu localbu1;
    final int k;
    int m;
    label725:
    label737:
    bu localbu2;
    bu localbu3;
    int i2;
    final int i3;
    if ((this.cWM.fFv()) && (this.cWM.BYG.field_username.equals(paramat.field_username)))
    {
      parambq = (k)this.cWM.bh(k.class);
      int i = paramat.field_msgCount;
      final int j = parambq.fpw();
      ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.JNh), Integer.valueOf(paramat.field_UnDeliverCount) });
      if (i > j)
      {
        localbu1 = paramat.IKk;
        if ((localbu1 == null) || (localbu1.field_msgId == 0L))
        {
          AppMethodBeat.o(35617);
          return;
        }
        if (i - j > 1) {
          this.JNl = true;
        }
        k = localbu1.field_flag;
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[] { Long.valueOf(localbu1.field_msgSvrId), Long.valueOf(localbu1.field_msgSeq), Integer.valueOf(k), bt.flS() });
        if ((k & 0x2) == 0)
        {
          AppMethodBeat.o(35617);
          return;
        }
        if ((this.cWM.getListView() == null) || (parambq == null) || (this.cWM.JOT == null))
        {
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[] { this.cWM.getListView(), parambq, this.cWM.JOT });
          AppMethodBeat.o(35617);
          return;
        }
        if ((k & 0x4) == 0)
        {
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[] { Boolean.valueOf(this.JNh) });
          if (this.JNh)
          {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
            AppMethodBeat.o(35617);
            return;
          }
          k = this.cWM.getFirstVisiblePosition();
          m = parambq.getCount();
          n = parambq.getCount();
          i1 = n - m;
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[] { this.cWM.BYG.field_username, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i - j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(0), Boolean.valueOf(this.JNi) });
          if (i1 > 1)
          {
            paramat = this.cWM.getListView();
            i = paramat.getFirstVisiblePosition();
            j = paramat.getChildCount();
            if ((k >= i) && (k <= j + i - 1)) {
              break label725;
            }
            paramat = paramat.getAdapter().getView(k, null, paramat);
            if (paramat != null) {
              break label737;
            }
          }
          for (i = 0;; i = paramat.getTop())
          {
            j = i - this.cWM.JOT.getBottomHeight();
            this.cWM.getListView().setAdapter(this.cWM.getListView().getAdapter());
            this.cWM.jR(k, j);
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[] { Integer.valueOf(k), paramat, Integer.valueOf(i), Integer.valueOf(j) });
            this.cWM.getListView().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35613);
                aw.this.cWM.jR(k, j);
                ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", new Object[] { Integer.valueOf(aw.this.cWM.getFirstVisiblePosition()), Integer.valueOf(aw.this.cWM.getLastVisiblePosition()), Integer.valueOf(parambq.getCount()) });
                AppMethodBeat.o(35613);
              }
            });
            this.cWM.getListView().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35614);
                aw.this.cWM.jR(k, j);
                ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", new Object[] { Integer.valueOf(aw.this.cWM.getFirstVisiblePosition()), Integer.valueOf(aw.this.cWM.getLastVisiblePosition()), Integer.valueOf(parambq.getCount()) });
                AppMethodBeat.o(35614);
              }
            }, 200L);
            AppMethodBeat.o(35617);
            return;
            paramat = paramat.getChildAt(k - i);
            break;
          }
        }
        k = this.cWM.getFirstVisiblePosition();
        m = this.cWM.getLastVisiblePosition();
        localbu2 = parambq.ada(k);
        localbu3 = parambq.ada(m);
        int n = parambq.getCount();
        int i1 = parambq.getCount();
        i2 = i - j;
        i3 = i1 - n;
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[] { this.cWM.BYG.field_username, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(0), Boolean.valueOf(this.JNi) });
        if ((localbu3 == null) || (localbu3.field_msgId == 0L) || (localbu3.field_createTime >= localbu1.field_createTime)) {
          break label1098;
        }
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
      }
    }
    for (;;)
    {
      this.cWM.JOT.fBU();
      if (paramat.field_UnDeliverCount <= 0) {
        ((z)this.cWM.bh(z.class)).fEm();
      }
      if (this.JNi)
      {
        this.JNi = false;
        this.cWM.JOT.setIsBottomShowAll(false);
        boolean bool = ((ai)this.cWM.bh(ai.class)).fEM();
        this.cWM.JOT.setBottomViewVisible(bool);
        this.cWM.JOT.xB(false);
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[] { Boolean.valueOf(this.JNi) });
        com.tencent.mm.ui.chatting.e.a.fFx().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35616);
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[] { Integer.valueOf(paramat.field_UnDeliverCount), Integer.valueOf(paramat.field_unReadCount) });
            AppMethodBeat.o(35616);
          }
        }, 500L);
      }
      AppMethodBeat.o(35617);
      return;
      label1098:
      if (i3 > 0)
      {
        parambq.adc(i3);
        long l1;
        if (localbu2 == null)
        {
          l1 = -1L;
          label1121:
          if (localbu3 != null) {
            break label1292;
          }
        }
        for (long l2 = -1L;; l2 = localbu3.field_createTime)
        {
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(localbu1.field_createTime) });
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3 + 1), Integer.valueOf(k) });
          this.cWM.jR(i3 + 1, ((y)this.cWM.bh(y.class)).fEk() + this.cWM.JOT.getTopHeight());
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35615);
              aw.this.cWM.jR(i3 + 1, ((y)aw.this.cWM.bh(y.class)).fEk() + aw.this.cWM.JOT.getTopHeight());
              AppMethodBeat.o(35615);
            }
          });
          break;
          l1 = localbu2.field_createTime;
          break label1121;
        }
      }
      label1292:
      ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0) });
    }
  }
  
  public final void bR(bu parambu)
  {
    AppMethodBeat.i(35618);
    long l3;
    boolean bool;
    Object localObject;
    long l1;
    label78:
    int i;
    label96:
    long l2;
    int j;
    if ((parambu != null) && (parambu.field_msgId != 0L))
    {
      l3 = parambu.field_msgSeq;
      if ((parambu.field_flag & 0x4) == 0) {
        break label330;
      }
      bool = true;
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azv().aTz(this.cWM.BYG.field_username);
      if (localObject == null) {
        break label356;
      }
      if (!bool) {
        break label336;
      }
      l1 = ((com.tencent.mm.g.c.ba)localObject).field_firstUnDeliverSeq;
      if ((!bool) || (l1 != 0L)) {
        break label351;
      }
      i = ((com.tencent.mm.g.c.ba)localObject).field_UnDeliverCount;
      l2 = l1;
      j = i;
      if (bool)
      {
        l2 = l1;
        j = i;
        if (l1 > l3)
        {
          localObject = ((l)g.ab(l.class)).dlK().aW(this.cWM.BYG.field_username, l3);
          l2 = l1;
          j = i;
          if (localObject != null)
          {
            l2 = l1;
            j = i;
            if (((ei)localObject).field_msgSeq < l3)
            {
              ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[] { Long.valueOf(l1), Long.valueOf(((ei)localObject).field_msgSeq) });
              l2 = ((ei)localObject).field_msgSeq;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(parambu.field_flag), Boolean.valueOf(bool) });
      this.JNh = false;
      parambu = this.cWM.BYG.field_username;
      int k = (int)l2;
      int m = (int)l3;
      if (bool) {}
      for (i = 1;; i = 0)
      {
        new com.tencent.mm.plugin.chatroom.a.a(parambu, k, m, j, i);
        AppMethodBeat.o(35618);
        return;
        label330:
        bool = false;
        break;
        label336:
        l1 = ((com.tencent.mm.g.c.ba)localObject).field_lastSeq;
        break label78;
      }
      label351:
      i = 0;
      break label96;
      label356:
      j = 0;
      l2 = 0L;
    }
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35620);
    this.JNh = false;
    this.JNj = this.cWM.fFv();
    this.JNh = false;
    this.JNi = false;
    AppMethodBeat.o(35620);
  }
  
  public final void fww() {}
  
  public final void fwx()
  {
    AppMethodBeat.i(35621);
    com.tencent.mm.sdk.b.a.IbL.d(this.JNk);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().b(this);
    AppMethodBeat.o(35621);
  }
  
  public final void onScrollStateChanged(final AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35619);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    Object localObject;
    if (paramInt == 0)
    {
      for (;;)
      {
        try
        {
          paramAbsListView = this.cWM.getChildAt(this.cWM.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.cWM.fFv()) {
              break label873;
            }
            paramAbsListView = ((k)this.cWM.bh(k.class)).ada(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.cWM.JOT.fBT();
              }
            }
            AppMethodBeat.o(35619);
            return;
          }
          if ((!this.cWM.fFv()) || (this.cWM.getChildAt(this.cWM.getListView().getChildCount() - 1) == null)) {
            break label873;
          }
          localObject = (k)this.cWM.bh(k.class);
          if (this.cWM.getLastVisiblePosition() != this.cWM.getListView().getAdapter().getCount() - 1) {
            break label873;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label890;
          }
          paramAbsListView = ((k)this.cWM.bh(k.class)).ada(((k)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label893;
            }
            localObject = ((l)g.ab(l.class)).dlK().aJ(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((ei)localObject).field_msgId == 0L) || (((ei)localObject).field_msgId != paramAbsListView.field_msgId) || ((((ei)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Integer.valueOf(((ei)localObject).field_flag) });
            AppMethodBeat.o(35619);
            return;
          }
        }
        catch (Exception paramAbsListView)
        {
          ad.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramAbsListView, "silenceMsgImp handleIdelScrollChange", new Object[0]);
          AppMethodBeat.o(35619);
          return;
        }
        paramInt += 1;
      }
      ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.cWM.JOT.setIsBottomShowAll(false);
        this.cWM.JOT.setBottomViewVisible(true);
        this.cWM.JOT.xB(true);
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        com.tencent.mm.model.ba.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35612);
            e.ygI.idkeyStat(403L, 7L, 1L, false);
            aw.this.bR(paramAbsListView);
            AppMethodBeat.o(35612);
          }
        });
        AppMethodBeat.o(35619);
        return;
      }
      AppMethodBeat.o(35619);
      return;
    }
    for (;;)
    {
      label710:
      int i;
      if ((paramAbsListView.field_flag & 0x2) != 0)
      {
        i = 1;
        label721:
        if ((i & paramInt) != 0)
        {
          com.tencent.mm.model.ba.aBQ();
          localObject = com.tencent.mm.model.c.azs().apX(paramAbsListView.field_talker);
          if ((localObject != null) && (((ei)localObject).field_msgId != 0L) && (((ei)localObject).field_createTime > paramAbsListView.field_createTime)) {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((ei)localObject).field_flag), Integer.valueOf(((ei)localObject).field_isSend), Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), Long.valueOf(((ei)localObject).field_msgSeq), Long.valueOf(((ei)localObject).field_createTime), Integer.valueOf(((bu)localObject).getType()), ((ei)localObject).field_talker });
          }
        }
        label873:
        AppMethodBeat.o(35619);
        return;
      }
      label890:
      label893:
      do
      {
        paramInt = 0;
        break label710;
        i = 0;
        break label721;
        break;
      } while (paramAbsListView == null);
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aw
 * JD-Core Version:    0.7.0.1
 */