package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.ah;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.c.b.x;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ah.class)
@Deprecated
public final class as
  extends a
  implements bk.a, ah
{
  public static int HYa = 350;
  public boolean HYb;
  public boolean HYc;
  public boolean HYd;
  private com.tencent.mm.sdk.b.c HYe;
  private boolean HYf;
  
  public final void a(final com.tencent.mm.storage.ap paramap, final bk parambk)
  {
    AppMethodBeat.i(35617);
    ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramap.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.cLy.cqM)
    {
      ac.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(35617);
      return;
    }
    bo localbo1;
    final int k;
    int m;
    label725:
    label737:
    bo localbo2;
    bo localbo3;
    int i2;
    final int i3;
    if ((this.cLy.foQ()) && (this.cLy.AzG.field_username.equals(paramap.field_username)))
    {
      parambk = (i)this.cLy.bf(i.class);
      int i = paramap.field_msgCount;
      final int j = parambk.eZx();
      ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.HYb), Integer.valueOf(paramap.field_UnDeliverCount) });
      if (i > j)
      {
        localbo1 = paramap.GWX;
        if ((localbo1 == null) || (localbo1.field_msgId == 0L))
        {
          AppMethodBeat.o(35617);
          return;
        }
        if (i - j > 1) {
          this.HYf = true;
        }
        k = localbo1.field_flag;
        ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[] { Long.valueOf(localbo1.field_msgSvrId), Long.valueOf(localbo1.field_msgSeq), Integer.valueOf(k), bs.eWi() });
        if ((k & 0x2) == 0)
        {
          AppMethodBeat.o(35617);
          return;
        }
        if ((this.cLy.getListView() == null) || (parambk == null) || (this.cLy.HZH == null))
        {
          ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[] { this.cLy.getListView(), parambk, this.cLy.HZH });
          AppMethodBeat.o(35617);
          return;
        }
        if ((k & 0x4) == 0)
        {
          ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[] { Boolean.valueOf(this.HYb) });
          if (this.HYb)
          {
            ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
            AppMethodBeat.o(35617);
            return;
          }
          k = this.cLy.getFirstVisiblePosition();
          m = parambk.getCount();
          n = parambk.getCount();
          i1 = n - m;
          ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[] { this.cLy.AzG.field_username, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i - j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(0), Boolean.valueOf(this.HYc) });
          if (i1 > 1)
          {
            paramap = this.cLy.getListView();
            i = paramap.getFirstVisiblePosition();
            j = paramap.getChildCount();
            if ((k >= i) && (k <= j + i - 1)) {
              break label725;
            }
            paramap = paramap.getAdapter().getView(k, null, paramap);
            if (paramap != null) {
              break label737;
            }
          }
          for (i = 0;; i = paramap.getTop())
          {
            j = i - this.cLy.HZH.getBottomHeight();
            this.cLy.getListView().setAdapter(this.cLy.getListView().getAdapter());
            this.cLy.jF(k, j);
            ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[] { Integer.valueOf(k), paramap, Integer.valueOf(i), Integer.valueOf(j) });
            this.cLy.getListView().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35613);
                as.this.cLy.jF(k, j);
                ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", new Object[] { Integer.valueOf(as.this.cLy.getFirstVisiblePosition()), Integer.valueOf(as.this.cLy.getLastVisiblePosition()), Integer.valueOf(parambk.getCount()) });
                AppMethodBeat.o(35613);
              }
            });
            this.cLy.getListView().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35614);
                as.this.cLy.jF(k, j);
                ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", new Object[] { Integer.valueOf(as.this.cLy.getFirstVisiblePosition()), Integer.valueOf(as.this.cLy.getLastVisiblePosition()), Integer.valueOf(parambk.getCount()) });
                AppMethodBeat.o(35614);
              }
            }, 200L);
            AppMethodBeat.o(35617);
            return;
            paramap = paramap.getChildAt(k - i);
            break;
          }
        }
        k = this.cLy.getFirstVisiblePosition();
        m = this.cLy.getLastVisiblePosition();
        localbo2 = parambk.aaP(k);
        localbo3 = parambk.aaP(m);
        int n = parambk.getCount();
        int i1 = parambk.getCount();
        i2 = i - j;
        i3 = i1 - n;
        ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[] { this.cLy.AzG.field_username, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(0), Boolean.valueOf(this.HYc) });
        if ((localbo3 == null) || (localbo3.field_msgId == 0L) || (localbo3.field_createTime >= localbo1.field_createTime)) {
          break label1098;
        }
        ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
      }
    }
    for (;;)
    {
      this.cLy.HZH.flE();
      if (paramap.field_UnDeliverCount <= 0) {
        ((x)this.cLy.bf(x.class)).fnP();
      }
      if (this.HYc)
      {
        this.HYc = false;
        this.cLy.HZH.setIsBottomShowAll(false);
        boolean bool = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi();
        this.cLy.HZH.setBottomViewVisible(bool);
        this.cLy.HZH.wQ(false);
        ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[] { Boolean.valueOf(this.HYc) });
        com.tencent.mm.ui.chatting.d.a.foS().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35616);
            ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[] { Integer.valueOf(paramap.field_UnDeliverCount), Integer.valueOf(paramap.field_unReadCount) });
            AppMethodBeat.o(35616);
          }
        }, 500L);
      }
      AppMethodBeat.o(35617);
      return;
      label1098:
      if (i3 > 0)
      {
        parambk.aaR(i3);
        long l1;
        if (localbo2 == null)
        {
          l1 = -1L;
          label1121:
          if (localbo3 != null) {
            break label1292;
          }
        }
        for (long l2 = -1L;; l2 = localbo3.field_createTime)
        {
          ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(localbo1.field_createTime) });
          ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3 + 1), Integer.valueOf(k) });
          this.cLy.jF(i3 + 1, ((w)this.cLy.bf(w.class)).fnN() + this.cLy.HZH.getTopHeight());
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35615);
              as.this.cLy.jF(i3 + 1, ((w)as.this.cLy.bf(w.class)).fnN() + as.this.cLy.HZH.getTopHeight());
              AppMethodBeat.o(35615);
            }
          });
          break;
          l1 = localbo2.field_createTime;
          break label1121;
        }
      }
      label1292:
      ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0) });
    }
  }
  
  public final void bL(bo parambo)
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
    if ((parambo != null) && (parambo.field_msgId != 0L))
    {
      l3 = parambo.field_msgSeq;
      if ((parambo.field_flag & 0x4) == 0) {
        break label330;
      }
      bool = true;
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awG().aNI(this.cLy.AzG.field_username);
      if (localObject == null) {
        break label356;
      }
      if (!bool) {
        break label336;
      }
      l1 = ((com.tencent.mm.g.c.az)localObject).field_firstUnDeliverSeq;
      if ((!bool) || (l1 != 0L)) {
        break label351;
      }
      i = ((com.tencent.mm.g.c.az)localObject).field_UnDeliverCount;
      l2 = l1;
      j = i;
      if (bool)
      {
        l2 = l1;
        j = i;
        if (l1 > l3)
        {
          localObject = ((k)g.ab(k.class)).dcr().aV(this.cLy.AzG.field_username, l3);
          l2 = l1;
          j = i;
          if (localObject != null)
          {
            l2 = l1;
            j = i;
            if (((dy)localObject).field_msgSeq < l3)
            {
              ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[] { Long.valueOf(l1), Long.valueOf(((dy)localObject).field_msgSeq) });
              l2 = ((dy)localObject).field_msgSeq;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(parambo.field_flag), Boolean.valueOf(bool) });
      this.HYb = false;
      parambo = this.cLy.AzG.field_username;
      int k = (int)l2;
      int m = (int)l3;
      if (bool) {}
      for (i = 1;; i = 0)
      {
        new com.tencent.mm.plugin.chatroom.a.a(parambo, k, m, j, i);
        AppMethodBeat.o(35618);
        return;
        label330:
        bool = false;
        break;
        label336:
        l1 = ((com.tencent.mm.g.c.az)localObject).field_lastSeq;
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
  
  public final void fgg()
  {
    AppMethodBeat.i(35620);
    this.HYb = false;
    this.HYd = this.cLy.foQ();
    this.HYb = false;
    this.HYc = false;
    AppMethodBeat.o(35620);
  }
  
  public final void fgk() {}
  
  public final void fgl()
  {
    AppMethodBeat.i(35621);
    com.tencent.mm.sdk.b.a.GpY.d(this.HYe);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().b(this);
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
          paramAbsListView = this.cLy.getChildAt(this.cLy.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.cLy.foQ()) {
              break label873;
            }
            paramAbsListView = ((i)this.cLy.bf(i.class)).aaP(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.cLy.HZH.flD();
              }
            }
            AppMethodBeat.o(35619);
            return;
          }
          if ((!this.cLy.foQ()) || (this.cLy.getChildAt(this.cLy.getListView().getChildCount() - 1) == null)) {
            break label873;
          }
          localObject = (i)this.cLy.bf(i.class);
          if (this.cLy.getLastVisiblePosition() != this.cLy.getListView().getAdapter().getCount() - 1) {
            break label873;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label890;
          }
          paramAbsListView = ((i)this.cLy.bf(i.class)).aaP(((i)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label893;
            }
            localObject = ((k)g.ab(k.class)).dcr().aG(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((dy)localObject).field_msgId == 0L) || (((dy)localObject).field_msgId != paramAbsListView.field_msgId) || ((((dy)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((dy)localObject).field_msgId), Integer.valueOf(((dy)localObject).field_flag) });
            AppMethodBeat.o(35619);
            return;
          }
        }
        catch (Exception paramAbsListView)
        {
          ac.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramAbsListView, "silenceMsgImp handleIdelScrollChange", new Object[0]);
          AppMethodBeat.o(35619);
          return;
        }
        paramInt += 1;
      }
      ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.cLy.HZH.setIsBottomShowAll(false);
        this.cLy.HZH.setBottomViewVisible(true);
        this.cLy.HZH.wQ(true);
        ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        com.tencent.mm.model.az.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35612);
            e.wTc.idkeyStat(403L, 7L, 1L, false);
            as.this.bL(paramAbsListView);
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
          com.tencent.mm.model.az.ayM();
          localObject = com.tencent.mm.model.c.awD().alk(paramAbsListView.field_talker);
          if ((localObject != null) && (((dy)localObject).field_msgId != 0L) && (((dy)localObject).field_createTime > paramAbsListView.field_createTime)) {
            ac.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((dy)localObject).field_flag), Integer.valueOf(((dy)localObject).field_isSend), Long.valueOf(((dy)localObject).field_msgId), Long.valueOf(((dy)localObject).field_msgSvrId), Long.valueOf(((dy)localObject).field_msgSeq), Long.valueOf(((dy)localObject).field_createTime), Integer.valueOf(((bo)localObject).getType()), ((dy)localObject).field_talker });
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
 * Qualified Name:     com.tencent.mm.ui.chatting.c.as
 * JD-Core Version:    0.7.0.1
 */