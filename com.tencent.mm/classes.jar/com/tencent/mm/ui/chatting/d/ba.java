package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.k;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ap.class)
@Deprecated
public final class ba
  extends a
  implements bw.a, ap
{
  public static int PtY = 350;
  public boolean PtZ;
  public boolean Pua;
  public boolean Pub;
  private IListener Puc;
  private boolean Pud;
  
  public final void a(final az paramaz, final bw parambw)
  {
    AppMethodBeat.i(35617);
    Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramaz.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.dom.cQp)
    {
      Log.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(35617);
      return;
    }
    ca localca1;
    final int k;
    int m;
    label725:
    label737:
    ca localca2;
    ca localca3;
    int i2;
    final int i3;
    if ((this.dom.gRM()) && (this.dom.GUe.field_username.equals(paramaz.field_username)))
    {
      parambw = (k)this.dom.bh(k.class);
      int i = paramaz.field_msgCount;
      final int j = parambw.cZm();
      Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.PtZ), Integer.valueOf(paramaz.field_UnDeliverCount) });
      if (i > j)
      {
        localca1 = paramaz.OoM;
        if ((localca1 == null) || (localca1.field_msgId == 0L))
        {
          AppMethodBeat.o(35617);
          return;
        }
        if (i - j > 1) {
          this.Pud = true;
        }
        k = localca1.field_flag;
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[] { Long.valueOf(localca1.field_msgSvrId), Long.valueOf(localca1.field_msgSeq), Integer.valueOf(k), Util.getStack() });
        if ((k & 0x2) == 0)
        {
          AppMethodBeat.o(35617);
          return;
        }
        if ((this.dom.getListView() == null) || (parambw == null) || (this.dom.Pwe == null))
        {
          Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[] { this.dom.getListView(), parambw, this.dom.Pwe });
          AppMethodBeat.o(35617);
          return;
        }
        if ((k & 0x4) == 0)
        {
          Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[] { Boolean.valueOf(this.PtZ) });
          if (this.PtZ)
          {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
            AppMethodBeat.o(35617);
            return;
          }
          k = this.dom.getFirstVisiblePosition();
          m = parambw.getCount();
          n = parambw.getCount();
          i1 = n - m;
          Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[] { this.dom.GUe.field_username, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i - j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(0), Boolean.valueOf(this.Pua) });
          if (i1 > 1)
          {
            paramaz = this.dom.getListView();
            i = paramaz.getFirstVisiblePosition();
            j = paramaz.getChildCount();
            if ((k >= i) && (k <= j + i - 1)) {
              break label725;
            }
            paramaz = paramaz.getAdapter().getView(k, null, paramaz);
            if (paramaz != null) {
              break label737;
            }
          }
          for (i = 0;; i = paramaz.getTop())
          {
            j = i - this.dom.Pwe.getBottomHeight();
            this.dom.getListView().setAdapter(this.dom.getListView().getAdapter());
            this.dom.lf(k, j);
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[] { Integer.valueOf(k), paramaz, Integer.valueOf(i), Integer.valueOf(j) });
            this.dom.getListView().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35613);
                ba.this.dom.lf(k, j);
                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", new Object[] { Integer.valueOf(ba.this.dom.getFirstVisiblePosition()), Integer.valueOf(ba.this.dom.getLastVisiblePosition()), Integer.valueOf(parambw.getCount()) });
                AppMethodBeat.o(35613);
              }
            });
            this.dom.getListView().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35614);
                ba.this.dom.lf(k, j);
                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", new Object[] { Integer.valueOf(ba.this.dom.getFirstVisiblePosition()), Integer.valueOf(ba.this.dom.getLastVisiblePosition()), Integer.valueOf(parambw.getCount()) });
                AppMethodBeat.o(35614);
              }
            }, 200L);
            AppMethodBeat.o(35617);
            return;
            paramaz = paramaz.getChildAt(k - i);
            break;
          }
        }
        k = this.dom.getFirstVisiblePosition();
        m = this.dom.getLastVisiblePosition();
        localca2 = parambw.amt(k);
        localca3 = parambw.amt(m);
        int n = parambw.getCount();
        int i1 = parambw.getCount();
        i2 = i - j;
        i3 = i1 - n;
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[] { this.dom.GUe.field_username, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(0), Boolean.valueOf(this.Pua) });
        if ((localca3 == null) || (localca3.field_msgId == 0L) || (localca3.field_createTime >= localca1.field_createTime)) {
          break label1098;
        }
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
      }
    }
    for (;;)
    {
      this.dom.Pwe.gOb();
      if (paramaz.field_UnDeliverCount <= 0) {
        ((ab)this.dom.bh(ab.class)).gQB();
      }
      if (this.Pua)
      {
        this.Pua = false;
        this.dom.Pwe.setIsBottomShowAll(false);
        boolean bool = ((am)this.dom.bh(am.class)).gQZ();
        this.dom.Pwe.setBottomViewVisible(bool);
        this.dom.Pwe.By(false);
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[] { Boolean.valueOf(this.Pua) });
        com.tencent.mm.ui.chatting.e.a.gRP().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35616);
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[] { Integer.valueOf(paramaz.field_UnDeliverCount), Integer.valueOf(paramaz.field_unReadCount) });
            AppMethodBeat.o(35616);
          }
        }, 500L);
      }
      AppMethodBeat.o(35617);
      return;
      label1098:
      if (i3 > 0)
      {
        parambw.amv(i3);
        long l1;
        if (localca2 == null)
        {
          l1 = -1L;
          label1121:
          if (localca3 != null) {
            break label1292;
          }
        }
        for (long l2 = -1L;; l2 = localca3.field_createTime)
        {
          Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(localca1.field_createTime) });
          Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3 + 1), Integer.valueOf(k) });
          this.dom.lf(i3 + 1, ((aa)this.dom.bh(aa.class)).gQy() + this.dom.Pwe.getTopHeight());
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35615);
              ba.this.dom.lf(i3 + 1, ((aa)ba.this.dom.bh(aa.class)).gQy() + ba.this.dom.Pwe.getTopHeight());
              AppMethodBeat.o(35615);
            }
          });
          break;
          l1 = localca2.field_createTime;
          break label1121;
        }
      }
      label1292:
      Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0) });
    }
  }
  
  public final void cFy() {}
  
  public final void cg(ca paramca)
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
    if ((paramca != null) && (paramca.field_msgId != 0L))
    {
      l3 = paramca.field_msgSeq;
      if ((paramca.field_flag & 0x4) == 0) {
        break label330;
      }
      bool = true;
      bg.aVF();
      localObject = c.aST().bjY(this.dom.GUe.field_username);
      if (localObject == null) {
        break label356;
      }
      if (!bool) {
        break label336;
      }
      l1 = ((bb)localObject).field_firstUnDeliverSeq;
      if ((!bool) || (l1 != 0L)) {
        break label351;
      }
      i = ((bb)localObject).field_UnDeliverCount;
      l2 = l1;
      j = i;
      if (bool)
      {
        l2 = l1;
        j = i;
        if (l1 > l3)
        {
          localObject = ((l)g.af(l.class)).eiy().aX(this.dom.GUe.field_username, l3);
          l2 = l1;
          j = i;
          if (localObject != null)
          {
            l2 = l1;
            j = i;
            if (((eo)localObject).field_msgSeq < l3)
            {
              Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[] { Long.valueOf(l1), Long.valueOf(((eo)localObject).field_msgSeq) });
              l2 = ((eo)localObject).field_msgSeq;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(paramca.field_flag), Boolean.valueOf(bool) });
      this.PtZ = false;
      paramca = this.dom.GUe.field_username;
      int k = (int)l2;
      int m = (int)l3;
      if (bool) {}
      for (i = 1;; i = 0)
      {
        new com.tencent.mm.plugin.chatroom.a.a(paramca, k, m, j, i);
        AppMethodBeat.o(35618);
        return;
        label330:
        bool = false;
        break;
        label336:
        l1 = ((bb)localObject).field_lastSeq;
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
  
  public final void gIk()
  {
    AppMethodBeat.i(35620);
    this.PtZ = false;
    this.Pub = this.dom.gRM();
    this.PtZ = false;
    this.Pua = false;
    AppMethodBeat.o(35620);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35621);
    EventCenter.instance.removeListener(this.Puc);
    bg.aVF();
    c.aST().b(this);
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
          paramAbsListView = this.dom.getChildAt(this.dom.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.dom.gRM()) {
              break label873;
            }
            paramAbsListView = ((k)this.dom.bh(k.class)).amt(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.dom.Pwe.gOa();
              }
            }
            AppMethodBeat.o(35619);
            return;
          }
          if ((!this.dom.gRM()) || (this.dom.getChildAt(this.dom.getListView().getChildCount() - 1) == null)) {
            break label873;
          }
          localObject = (k)this.dom.bh(k.class);
          if (this.dom.getLastVisiblePosition() != this.dom.getListView().getAdapter().getCount() - 1) {
            break label873;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label890;
          }
          paramAbsListView = ((k)this.dom.bh(k.class)).amt(((k)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label893;
            }
            localObject = ((l)g.af(l.class)).eiy().aK(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((eo)localObject).field_msgId == 0L) || (((eo)localObject).field_msgId != paramAbsListView.field_msgId) || ((((eo)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((eo)localObject).field_msgId), Integer.valueOf(((eo)localObject).field_flag) });
            AppMethodBeat.o(35619);
            return;
          }
        }
        catch (Exception paramAbsListView)
        {
          Log.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramAbsListView, "silenceMsgImp handleIdelScrollChange", new Object[0]);
          AppMethodBeat.o(35619);
          return;
        }
        paramInt += 1;
      }
      Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.dom.Pwe.setIsBottomShowAll(false);
        this.dom.Pwe.setBottomViewVisible(true);
        this.dom.Pwe.By(true);
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35612);
            e.Cxv.idkeyStat(403L, 7L, 1L, false);
            ba.this.cg(paramAbsListView);
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
          bg.aVF();
          localObject = c.aSQ().aEx(paramAbsListView.field_talker);
          if ((localObject != null) && (((eo)localObject).field_msgId != 0L) && (((eo)localObject).field_createTime > paramAbsListView.field_createTime)) {
            Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((eo)localObject).field_flag), Integer.valueOf(((eo)localObject).field_isSend), Long.valueOf(((eo)localObject).field_msgId), Long.valueOf(((eo)localObject).field_msgSvrId), Long.valueOf(((eo)localObject).field_msgSeq), Long.valueOf(((eo)localObject).field_createTime), Integer.valueOf(((ca)localObject).getType()), ((eo)localObject).field_talker });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ba
 * JD-Core Version:    0.7.0.1
 */