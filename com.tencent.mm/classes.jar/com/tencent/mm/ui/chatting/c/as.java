package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.ah;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.c.b.x;

@com.tencent.mm.ui.chatting.c.a.a(eYT=ah.class)
@Deprecated
public final class as
  extends a
  implements bh.a, ah
{
  public static int Gyj = 350;
  public boolean Gyk;
  public boolean Gyl;
  public boolean Gym;
  private com.tencent.mm.sdk.b.c Gyn;
  private boolean Gyo;
  
  public final void a(final am paramam, final bh parambh)
  {
    AppMethodBeat.i(35617);
    ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramam.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.cOd.ctF)
    {
      ad.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(35617);
      return;
    }
    bl localbl1;
    final int k;
    int m;
    label725:
    label737:
    bl localbl2;
    bl localbl3;
    int i2;
    final int i3;
    if ((this.cOd.eZb()) && (this.cOd.zgX.field_username.equals(paramam.field_username)))
    {
      parambh = (i)this.cOd.be(i.class);
      int i = paramam.field_msgCount;
      final int j = parambh.eKa();
      ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.Gyk), Integer.valueOf(paramam.field_UnDeliverCount) });
      if (i > j)
      {
        localbl1 = paramam.FxX;
        if ((localbl1 == null) || (localbl1.field_msgId == 0L))
        {
          AppMethodBeat.o(35617);
          return;
        }
        if (i - j > 1) {
          this.Gyo = true;
        }
        k = localbl1.field_flag;
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[] { Long.valueOf(localbl1.field_msgSvrId), Long.valueOf(localbl1.field_msgSeq), Integer.valueOf(k), bt.eGN() });
        if ((k & 0x2) == 0)
        {
          AppMethodBeat.o(35617);
          return;
        }
        if ((this.cOd.getListView() == null) || (parambh == null) || (this.cOd.GzL == null))
        {
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[] { this.cOd.getListView(), parambh, this.cOd.GzL });
          AppMethodBeat.o(35617);
          return;
        }
        if ((k & 0x4) == 0)
        {
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[] { Boolean.valueOf(this.Gyk) });
          if (this.Gyk)
          {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
            AppMethodBeat.o(35617);
            return;
          }
          k = this.cOd.getFirstVisiblePosition();
          m = parambh.getCount();
          n = parambh.getCount();
          i1 = n - m;
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[] { this.cOd.zgX.field_username, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i - j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(0), Boolean.valueOf(this.Gyl) });
          if (i1 > 1)
          {
            paramam = this.cOd.getListView();
            i = paramam.getFirstVisiblePosition();
            j = paramam.getChildCount();
            if ((k >= i) && (k <= j + i - 1)) {
              break label725;
            }
            paramam = paramam.getAdapter().getView(k, null, paramam);
            if (paramam != null) {
              break label737;
            }
          }
          for (i = 0;; i = paramam.getTop())
          {
            j = i - this.cOd.GzL.getBottomHeight();
            this.cOd.getListView().setAdapter(this.cOd.getListView().getAdapter());
            this.cOd.jt(k, j);
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[] { Integer.valueOf(k), paramam, Integer.valueOf(i), Integer.valueOf(j) });
            this.cOd.getListView().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35613);
                as.this.cOd.jt(k, j);
                ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", new Object[] { Integer.valueOf(as.this.cOd.getFirstVisiblePosition()), Integer.valueOf(as.this.cOd.getLastVisiblePosition()), Integer.valueOf(parambh.getCount()) });
                AppMethodBeat.o(35613);
              }
            });
            this.cOd.getListView().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35614);
                as.this.cOd.jt(k, j);
                ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", new Object[] { Integer.valueOf(as.this.cOd.getFirstVisiblePosition()), Integer.valueOf(as.this.cOd.getLastVisiblePosition()), Integer.valueOf(parambh.getCount()) });
                AppMethodBeat.o(35614);
              }
            }, 200L);
            AppMethodBeat.o(35617);
            return;
            paramam = paramam.getChildAt(k - i);
            break;
          }
        }
        k = this.cOd.getFirstVisiblePosition();
        m = this.cOd.getLastVisiblePosition();
        localbl2 = parambh.YE(k);
        localbl3 = parambh.YE(m);
        int n = parambh.getCount();
        int i1 = parambh.getCount();
        i2 = i - j;
        i3 = i1 - n;
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[] { this.cOd.zgX.field_username, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(0), Boolean.valueOf(this.Gyl) });
        if ((localbl3 == null) || (localbl3.field_msgId == 0L) || (localbl3.field_createTime >= localbl1.field_createTime)) {
          break label1098;
        }
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
      }
    }
    for (;;)
    {
      this.cOd.GzL.eVS();
      if (paramam.field_UnDeliverCount <= 0) {
        ((x)this.cOd.be(x.class)).eYd();
      }
      if (this.Gyl)
      {
        this.Gyl = false;
        this.cOd.GzL.setIsBottomShowAll(false);
        boolean bool = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYw();
        this.cOd.GzL.setBottomViewVisible(bool);
        this.cOd.GzL.vM(false);
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[] { Boolean.valueOf(this.Gyl) });
        com.tencent.mm.ui.chatting.d.a.eZd().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35616);
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[] { Integer.valueOf(paramam.field_UnDeliverCount), Integer.valueOf(paramam.field_unReadCount) });
            AppMethodBeat.o(35616);
          }
        }, 500L);
      }
      AppMethodBeat.o(35617);
      return;
      label1098:
      if (i3 > 0)
      {
        parambh.YG(i3);
        long l1;
        if (localbl2 == null)
        {
          l1 = -1L;
          label1121:
          if (localbl3 != null) {
            break label1292;
          }
        }
        for (long l2 = -1L;; l2 = localbl3.field_createTime)
        {
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(localbl1.field_createTime) });
          ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3 + 1), Integer.valueOf(k) });
          this.cOd.jt(i3 + 1, ((w)this.cOd.be(w.class)).eYb() + this.cOd.GzL.getTopHeight());
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35615);
              as.this.cOd.jt(i3 + 1, ((w)as.this.cOd.be(w.class)).eYb() + as.this.cOd.GzL.getTopHeight());
              AppMethodBeat.o(35615);
            }
          });
          break;
          l1 = localbl2.field_createTime;
          break label1121;
        }
      }
      label1292:
      ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0) });
    }
  }
  
  public final void bJ(bl parambl)
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
    if ((parambl != null) && (parambl.field_msgId != 0L))
    {
      l3 = parambl.field_msgSeq;
      if ((parambl.field_flag & 0x4) == 0) {
        break label330;
      }
      bool = true;
      az.arV();
      localObject = com.tencent.mm.model.c.apR().aIn(this.cOd.zgX.field_username);
      if (localObject == null) {
        break label356;
      }
      if (!bool) {
        break label336;
      }
      l1 = ((ay)localObject).field_firstUnDeliverSeq;
      if ((!bool) || (l1 != 0L)) {
        break label351;
      }
      i = ((ay)localObject).field_UnDeliverCount;
      l2 = l1;
      j = i;
      if (bool)
      {
        l2 = l1;
        j = i;
        if (l1 > l3)
        {
          localObject = ((k)g.ab(k.class)).cOI().aT(this.cOd.zgX.field_username, l3);
          l2 = l1;
          j = i;
          if (localObject != null)
          {
            l2 = l1;
            j = i;
            if (((du)localObject).field_msgSeq < l3)
            {
              ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[] { Long.valueOf(l1), Long.valueOf(((du)localObject).field_msgSeq) });
              l2 = ((du)localObject).field_msgSeq;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(parambl.field_flag), Boolean.valueOf(bool) });
      this.Gyk = false;
      parambl = this.cOd.zgX.field_username;
      int k = (int)l2;
      int m = (int)l3;
      if (bool) {}
      for (i = 1;; i = 0)
      {
        new com.tencent.mm.plugin.chatroom.a.a(parambl, k, m, j, i);
        AppMethodBeat.o(35618);
        return;
        label330:
        bool = false;
        break;
        label336:
        l1 = ((ay)localObject).field_lastSeq;
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
  
  public final void eQA()
  {
    AppMethodBeat.i(35620);
    this.Gyk = false;
    this.Gym = this.cOd.eZb();
    this.Gyk = false;
    this.Gyl = false;
    AppMethodBeat.o(35620);
  }
  
  public final void eQE() {}
  
  public final void eQF()
  {
    AppMethodBeat.i(35621);
    com.tencent.mm.sdk.b.a.ESL.d(this.Gyn);
    az.arV();
    com.tencent.mm.model.c.apR().b(this);
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
          paramAbsListView = this.cOd.getChildAt(this.cOd.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.cOd.eZb()) {
              break label873;
            }
            paramAbsListView = ((i)this.cOd.be(i.class)).YE(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.cOd.GzL.eVR();
              }
            }
            AppMethodBeat.o(35619);
            return;
          }
          if ((!this.cOd.eZb()) || (this.cOd.getChildAt(this.cOd.getListView().getChildCount() - 1) == null)) {
            break label873;
          }
          localObject = (i)this.cOd.be(i.class);
          if (this.cOd.getLastVisiblePosition() != this.cOd.getListView().getAdapter().getCount() - 1) {
            break label873;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label890;
          }
          paramAbsListView = ((i)this.cOd.be(i.class)).YE(((i)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label893;
            }
            localObject = ((k)g.ab(k.class)).cOI().aE(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((du)localObject).field_msgId == 0L) || (((du)localObject).field_msgId != paramAbsListView.field_msgId) || ((((du)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((du)localObject).field_msgId), Integer.valueOf(((du)localObject).field_flag) });
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
        this.cOd.GzL.setIsBottomShowAll(false);
        this.cOd.GzL.setBottomViewVisible(true);
        this.cOd.GzL.vM(true);
        ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        az.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35612);
            e.vIY.idkeyStat(403L, 7L, 1L, false);
            as.this.bJ(paramAbsListView);
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
          az.arV();
          localObject = com.tencent.mm.model.c.apO().agq(paramAbsListView.field_talker);
          if ((localObject != null) && (((du)localObject).field_msgId != 0L) && (((du)localObject).field_createTime > paramAbsListView.field_createTime)) {
            ad.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((du)localObject).field_flag), Integer.valueOf(((du)localObject).field_isSend), Long.valueOf(((du)localObject).field_msgId), Long.valueOf(((du)localObject).field_msgSvrId), Long.valueOf(((du)localObject).field_msgSeq), Long.valueOf(((du)localObject).field_createTime), Integer.valueOf(((bl)localObject).getType()), ((du)localObject).field_talker });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.as
 * JD-Core Version:    0.7.0.1
 */