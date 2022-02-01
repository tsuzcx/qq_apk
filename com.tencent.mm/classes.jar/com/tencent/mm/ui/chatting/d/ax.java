package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.d.b.z;

@com.tencent.mm.ui.chatting.d.a.a(fJv=am.class)
@Deprecated
public final class ax
  extends a
  implements br.a, am
{
  public static int Kid = 350;
  public boolean Kie;
  public boolean Kif;
  public boolean Kig;
  private com.tencent.mm.sdk.b.c Kih;
  private boolean Kii;
  
  public final void a(final au paramau, final br parambr)
  {
    AppMethodBeat.i(35617);
    ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramau.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.cXJ.cCq)
    {
      ae.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(35617);
      return;
    }
    bv localbv1;
    final int k;
    int m;
    label725:
    label737:
    bv localbv2;
    bv localbv3;
    int i2;
    final int i3;
    if ((this.cXJ.fJC()) && (this.cXJ.Cqh.field_username.equals(paramau.field_username)))
    {
      parambr = (k)this.cXJ.bh(k.class);
      int i = paramau.field_msgCount;
      final int j = parambr.ftv();
      ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.Kie), Integer.valueOf(paramau.field_UnDeliverCount) });
      if (i > j)
      {
        localbv1 = paramau.JeR;
        if ((localbv1 == null) || (localbv1.field_msgId == 0L))
        {
          AppMethodBeat.o(35617);
          return;
        }
        if (i - j > 1) {
          this.Kii = true;
        }
        k = localbv1.field_flag;
        ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[] { Long.valueOf(localbv1.field_msgSvrId), Long.valueOf(localbv1.field_msgSeq), Integer.valueOf(k), bu.fpN() });
        if ((k & 0x2) == 0)
        {
          AppMethodBeat.o(35617);
          return;
        }
        if ((this.cXJ.getListView() == null) || (parambr == null) || (this.cXJ.Kkf == null))
        {
          ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[] { this.cXJ.getListView(), parambr, this.cXJ.Kkf });
          AppMethodBeat.o(35617);
          return;
        }
        if ((k & 0x4) == 0)
        {
          ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[] { Boolean.valueOf(this.Kie) });
          if (this.Kie)
          {
            ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
            AppMethodBeat.o(35617);
            return;
          }
          k = this.cXJ.getFirstVisiblePosition();
          m = parambr.getCount();
          n = parambr.getCount();
          i1 = n - m;
          ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[] { this.cXJ.Cqh.field_username, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i - j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(0), Boolean.valueOf(this.Kif) });
          if (i1 > 1)
          {
            paramau = this.cXJ.getListView();
            i = paramau.getFirstVisiblePosition();
            j = paramau.getChildCount();
            if ((k >= i) && (k <= j + i - 1)) {
              break label725;
            }
            paramau = paramau.getAdapter().getView(k, null, paramau);
            if (paramau != null) {
              break label737;
            }
          }
          for (i = 0;; i = paramau.getTop())
          {
            j = i - this.cXJ.Kkf.getBottomHeight();
            this.cXJ.getListView().setAdapter(this.cXJ.getListView().getAdapter());
            this.cXJ.jV(k, j);
            ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[] { Integer.valueOf(k), paramau, Integer.valueOf(i), Integer.valueOf(j) });
            this.cXJ.getListView().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35613);
                ax.this.cXJ.jV(k, j);
                ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", new Object[] { Integer.valueOf(ax.this.cXJ.getFirstVisiblePosition()), Integer.valueOf(ax.this.cXJ.getLastVisiblePosition()), Integer.valueOf(parambr.getCount()) });
                AppMethodBeat.o(35613);
              }
            });
            this.cXJ.getListView().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35614);
                ax.this.cXJ.jV(k, j);
                ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", new Object[] { Integer.valueOf(ax.this.cXJ.getFirstVisiblePosition()), Integer.valueOf(ax.this.cXJ.getLastVisiblePosition()), Integer.valueOf(parambr.getCount()) });
                AppMethodBeat.o(35614);
              }
            }, 200L);
            AppMethodBeat.o(35617);
            return;
            paramau = paramau.getChildAt(k - i);
            break;
          }
        }
        k = this.cXJ.getFirstVisiblePosition();
        m = this.cXJ.getLastVisiblePosition();
        localbv2 = parambr.adI(k);
        localbv3 = parambr.adI(m);
        int n = parambr.getCount();
        int i1 = parambr.getCount();
        i2 = i - j;
        i3 = i1 - n;
        ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[] { this.cXJ.Cqh.field_username, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(0), Boolean.valueOf(this.Kif) });
        if ((localbv3 == null) || (localbv3.field_msgId == 0L) || (localbv3.field_createTime >= localbv1.field_createTime)) {
          break label1098;
        }
        ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
      }
    }
    for (;;)
    {
      this.cXJ.Kkf.fFW();
      if (paramau.field_UnDeliverCount <= 0) {
        ((z)this.cXJ.bh(z.class)).fIq();
      }
      if (this.Kif)
      {
        this.Kif = false;
        this.cXJ.Kkf.setIsBottomShowAll(false);
        boolean bool = ((aj)this.cXJ.bh(aj.class)).fIP();
        this.cXJ.Kkf.setBottomViewVisible(bool);
        this.cXJ.Kkf.xJ(false);
        ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[] { Boolean.valueOf(this.Kif) });
        com.tencent.mm.ui.chatting.e.a.fJE().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35616);
            ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[] { Integer.valueOf(paramau.field_UnDeliverCount), Integer.valueOf(paramau.field_unReadCount) });
            AppMethodBeat.o(35616);
          }
        }, 500L);
      }
      AppMethodBeat.o(35617);
      return;
      label1098:
      if (i3 > 0)
      {
        parambr.adK(i3);
        long l1;
        if (localbv2 == null)
        {
          l1 = -1L;
          label1121:
          if (localbv3 != null) {
            break label1292;
          }
        }
        for (long l2 = -1L;; l2 = localbv3.field_createTime)
        {
          ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(localbv1.field_createTime) });
          ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3 + 1), Integer.valueOf(k) });
          this.cXJ.jV(i3 + 1, ((y)this.cXJ.bh(y.class)).fIn() + this.cXJ.Kkf.getTopHeight());
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35615);
              ax.this.cXJ.jV(i3 + 1, ((y)ax.this.cXJ.bh(y.class)).fIn() + ax.this.cXJ.Kkf.getTopHeight());
              AppMethodBeat.o(35615);
            }
          });
          break;
          l1 = localbv2.field_createTime;
          break label1121;
        }
      }
      label1292:
      ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0) });
    }
  }
  
  public final void bQ(bv parambv)
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
    if ((parambv != null) && (parambv.field_msgId != 0L))
    {
      l3 = parambv.field_msgSeq;
      if ((parambv.field_flag & 0x4) == 0) {
        break label330;
      }
      bool = true;
      bc.aCg();
      localObject = com.tencent.mm.model.c.azL().aVa(this.cXJ.Cqh.field_username);
      if (localObject == null) {
        break label356;
      }
      if (!bool) {
        break label336;
      }
      l1 = ((ba)localObject).field_firstUnDeliverSeq;
      if ((!bool) || (l1 != 0L)) {
        break label351;
      }
      i = ((ba)localObject).field_UnDeliverCount;
      l2 = l1;
      j = i;
      if (bool)
      {
        l2 = l1;
        j = i;
        if (l1 > l3)
        {
          localObject = ((l)g.ab(l.class)).doJ().aX(this.cXJ.Cqh.field_username, l3);
          l2 = l1;
          j = i;
          if (localObject != null)
          {
            l2 = l1;
            j = i;
            if (((ei)localObject).field_msgSeq < l3)
            {
              ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[] { Long.valueOf(l1), Long.valueOf(((ei)localObject).field_msgSeq) });
              l2 = ((ei)localObject).field_msgSeq;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(parambv.field_flag), Boolean.valueOf(bool) });
      this.Kie = false;
      parambv = this.cXJ.Cqh.field_username;
      int k = (int)l2;
      int m = (int)l3;
      if (bool) {}
      for (i = 1;; i = 0)
      {
        new com.tencent.mm.plugin.chatroom.a.a(parambv, k, m, j, i);
        AppMethodBeat.o(35618);
        return;
        label330:
        bool = false;
        break;
        label336:
        l1 = ((ba)localObject).field_lastSeq;
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
  
  public final void fAs()
  {
    AppMethodBeat.i(35620);
    this.Kie = false;
    this.Kig = this.cXJ.fJC();
    this.Kie = false;
    this.Kif = false;
    AppMethodBeat.o(35620);
  }
  
  public final void fAw() {}
  
  public final void fAx()
  {
    AppMethodBeat.i(35621);
    com.tencent.mm.sdk.b.a.IvT.d(this.Kih);
    bc.aCg();
    com.tencent.mm.model.c.azL().b(this);
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
          paramAbsListView = this.cXJ.getChildAt(this.cXJ.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.cXJ.fJC()) {
              break label873;
            }
            paramAbsListView = ((k)this.cXJ.bh(k.class)).adI(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.cXJ.Kkf.fFV();
              }
            }
            AppMethodBeat.o(35619);
            return;
          }
          if ((!this.cXJ.fJC()) || (this.cXJ.getChildAt(this.cXJ.getListView().getChildCount() - 1) == null)) {
            break label873;
          }
          localObject = (k)this.cXJ.bh(k.class);
          if (this.cXJ.getLastVisiblePosition() != this.cXJ.getListView().getAdapter().getCount() - 1) {
            break label873;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label890;
          }
          paramAbsListView = ((k)this.cXJ.bh(k.class)).adI(((k)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label893;
            }
            localObject = ((l)g.ab(l.class)).doJ().aK(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((ei)localObject).field_msgId == 0L) || (((ei)localObject).field_msgId != paramAbsListView.field_msgId) || ((((ei)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Integer.valueOf(((ei)localObject).field_flag) });
            AppMethodBeat.o(35619);
            return;
          }
        }
        catch (Exception paramAbsListView)
        {
          ae.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramAbsListView, "silenceMsgImp handleIdelScrollChange", new Object[0]);
          AppMethodBeat.o(35619);
          return;
        }
        paramInt += 1;
      }
      ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.cXJ.Kkf.setIsBottomShowAll(false);
        this.cXJ.Kkf.setBottomViewVisible(true);
        this.cXJ.Kkf.xJ(true);
        ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        bc.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35612);
            e.ywz.idkeyStat(403L, 7L, 1L, false);
            ax.this.bQ(paramAbsListView);
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
          bc.aCg();
          localObject = com.tencent.mm.model.c.azI().arc(paramAbsListView.field_talker);
          if ((localObject != null) && (((ei)localObject).field_msgId != 0L) && (((ei)localObject).field_createTime > paramAbsListView.field_createTime)) {
            ae.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((ei)localObject).field_flag), Integer.valueOf(((ei)localObject).field_isSend), Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), Long.valueOf(((ei)localObject).field_msgSeq), Long.valueOf(((ei)localObject).field_createTime), Integer.valueOf(((bv)localObject).getType()), ((ei)localObject).field_talker });
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ax
 * JD-Core Version:    0.7.0.1
 */