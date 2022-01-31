package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.c.b.ac;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.c.b.z;

@com.tencent.mm.ui.chatting.c.a.a(dJy=ac.class)
@Deprecated
public final class ak
  extends a
  implements be.a, ac
{
  public static int zIb = 350;
  public boolean zIc;
  public boolean zId;
  public boolean zIe;
  private com.tencent.mm.sdk.b.c zIf;
  private boolean zIg;
  
  public final void a(com.tencent.mm.storage.ak paramak, be parambe)
  {
    AppMethodBeat.i(31715);
    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramak.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.caz.bSe)
    {
      ab.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
      AppMethodBeat.o(31715);
      return;
    }
    bi localbi1;
    int k;
    int m;
    label732:
    label744:
    bi localbi2;
    bi localbi3;
    int i2;
    int i3;
    if ((this.caz.dJG()) && (this.caz.txj.field_username.equals(paramak.field_username)))
    {
      parambe = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
      int i = paramak.field_msgCount;
      int j = parambe.dwi();
      ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.zIc), Integer.valueOf(paramak.field_UnDeliverCount) });
      if (i > j)
      {
        localbi1 = paramak.yMq;
        if ((localbi1 == null) || (localbi1.field_msgId == 0L))
        {
          AppMethodBeat.o(31715);
          return;
        }
        if (i - j > 1) {
          this.zIg = true;
        }
        k = localbi1.field_flag;
        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[] { Long.valueOf(localbi1.field_msgSvrId), Long.valueOf(localbi1.field_msgSeq), Integer.valueOf(k), bo.dtY() });
        if ((k & 0x2) == 0)
        {
          AppMethodBeat.o(31715);
          return;
        }
        if ((this.caz.getListView() == null) || (parambe == null) || (this.caz.zJB == null))
        {
          ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[] { this.caz.getListView(), parambe, this.caz.zJB });
          AppMethodBeat.o(31715);
          return;
        }
        if ((k & 0x4) == 0)
        {
          ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[] { Boolean.valueOf(this.zIc) });
          if (this.zIc)
          {
            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
            AppMethodBeat.o(31715);
            return;
          }
          k = this.caz.getFirstVisiblePosition();
          m = parambe.getCount();
          n = parambe.getCount();
          i1 = n - m;
          ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[] { this.caz.txj.field_username, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i - j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(0), Boolean.valueOf(this.zId) });
          if (i1 > 1)
          {
            paramak = this.caz.getListView();
            i = paramak.getFirstVisiblePosition();
            j = paramak.getChildCount();
            if ((k >= i) && (k <= j + i - 1)) {
              break label732;
            }
            paramak = paramak.getAdapter().getView(k, null, paramak);
            if (paramak != null) {
              break label744;
            }
          }
          for (i = 0;; i = paramak.getTop())
          {
            j = i - this.caz.zJB.getBottomHeight();
            this.caz.getListView().setAdapter(this.caz.getListView().getAdapter());
            this.caz.hF(k, j);
            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[] { Integer.valueOf(k), paramak, Integer.valueOf(i), Integer.valueOf(j) });
            this.caz.getListView().post(new ak.2(this, k, j, parambe));
            this.caz.getListView().postDelayed(new ak.3(this, k, j, parambe), 200L);
            AppMethodBeat.o(31715);
            return;
            paramak = paramak.getChildAt(k - i);
            break;
          }
        }
        k = this.caz.getFirstVisiblePosition();
        m = this.caz.getLastVisiblePosition();
        localbi2 = parambe.Pz(k);
        localbi3 = parambe.Pz(m);
        int n = parambe.getCount();
        int i1 = parambe.getCount();
        i2 = i - j;
        i3 = i1 - n;
        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[] { this.caz.txj.field_username, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(0), Boolean.valueOf(this.zId) });
        if ((localbi3 == null) || (localbi3.field_msgId == 0L) || (localbi3.field_createTime >= localbi1.field_createTime)) {
          break label1106;
        }
        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
      }
    }
    for (;;)
    {
      this.caz.zJB.dGM();
      if (paramak.field_UnDeliverCount <= 0) {
        ((s)this.caz.ay(s.class)).dII();
      }
      if (this.zId)
      {
        this.zId = false;
        this.caz.zJB.setIsBottomShowAll(false);
        boolean bool = ((z)this.caz.ay(z.class)).dJb();
        this.caz.zJB.setBottomViewVisible(bool);
        this.caz.zJB.qE(false);
        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[] { Boolean.valueOf(this.zId) });
        com.tencent.mm.ui.chatting.d.a.dJI().postDelayed(new ak.5(this, paramak), 500L);
      }
      AppMethodBeat.o(31715);
      return;
      label1106:
      if (i3 > 0)
      {
        parambe.PB(i3);
        long l1;
        if (localbi2 == null)
        {
          l1 = -1L;
          label1129:
          if (localbi3 != null) {
            break label1300;
          }
        }
        for (long l2 = -1L;; l2 = localbi3.field_createTime)
        {
          ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(localbi1.field_createTime) });
          ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3 + 1), Integer.valueOf(k) });
          this.caz.hF(i3 + 1, ((r)this.caz.ay(r.class)).dIG() + this.caz.zJB.getTopHeight());
          al.d(new ak.4(this, i3));
          break;
          l1 = localbi2.field_createTime;
          break label1129;
        }
      }
      label1300:
      ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0) });
    }
  }
  
  public final void bl(bi parambi)
  {
    AppMethodBeat.i(31716);
    long l3;
    boolean bool;
    Object localObject;
    long l1;
    label78:
    int i;
    label96:
    long l2;
    int j;
    if ((parambi != null) && (parambi.field_msgId != 0L))
    {
      l3 = parambi.field_msgSeq;
      if ((parambi.field_flag & 0x4) == 0) {
        break label330;
      }
      bool = true;
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().arH(this.caz.txj.field_username);
      if (localObject == null) {
        break label356;
      }
      if (!bool) {
        break label336;
      }
      l1 = ((au)localObject).field_firstUnDeliverSeq;
      if ((!bool) || (l1 != 0L)) {
        break label351;
      }
      i = ((au)localObject).field_UnDeliverCount;
      l2 = l1;
      j = i;
      if (bool)
      {
        l2 = l1;
        j = i;
        if (l1 > l3)
        {
          localObject = ((j)g.E(j.class)).bPQ().au(this.caz.txj.field_username, l3);
          l2 = l1;
          j = i;
          if (localObject != null)
          {
            l2 = l1;
            j = i;
            if (((dd)localObject).field_msgSeq < l3)
            {
              ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[] { Long.valueOf(l1), Long.valueOf(((dd)localObject).field_msgSeq) });
              l2 = ((dd)localObject).field_msgSeq;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(parambi.field_flag), Boolean.valueOf(bool) });
      this.zIc = false;
      parambi = this.caz.txj.field_username;
      int k = (int)l2;
      int m = (int)l3;
      if (bool) {}
      for (i = 1;; i = 0)
      {
        new com.tencent.mm.plugin.chatroom.a.a(parambi, k, m, j, i);
        AppMethodBeat.o(31716);
        return;
        label330:
        bool = false;
        break;
        label336:
        l1 = ((au)localObject).field_lastSeq;
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
  
  public final void dBY()
  {
    AppMethodBeat.i(31718);
    this.zIc = false;
    this.zIe = this.caz.dJG();
    this.zIc = false;
    this.zId = false;
    AppMethodBeat.o(31718);
  }
  
  public final void dCc() {}
  
  public final void dCd()
  {
    AppMethodBeat.i(31719);
    com.tencent.mm.sdk.b.a.ymk.d(this.zIf);
    aw.aaz();
    com.tencent.mm.model.c.YF().b(this);
    AppMethodBeat.o(31719);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(31717);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    Object localObject;
    if (paramInt == 0)
    {
      for (;;)
      {
        try
        {
          paramAbsListView = this.caz.getChildAt(this.caz.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.caz.dJG()) {
              break label873;
            }
            paramAbsListView = ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).Pz(0);
            if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L))
            {
              ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
              if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) != 0)) {
                this.caz.zJB.dGL();
              }
            }
            AppMethodBeat.o(31717);
            return;
          }
          if ((!this.caz.dJG()) || (this.caz.getChildAt(this.caz.getListView().getChildCount() - 1) == null)) {
            break label873;
          }
          localObject = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
          if (this.caz.getLastVisiblePosition() != this.caz.getListView().getAdapter().getCount() - 1) {
            break label873;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label890;
          }
          paramAbsListView = ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).Pz(((com.tencent.mm.ui.chatting.c.b.h)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label893;
            }
            localObject = ((j)g.E(j.class)).bPQ().ah(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((dd)localObject).field_msgId == 0L) || (((dd)localObject).field_msgId != paramAbsListView.field_msgId) || ((((dd)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((dd)localObject).field_msgId), Integer.valueOf(((dd)localObject).field_flag) });
            AppMethodBeat.o(31717);
            return;
          }
        }
        catch (Exception paramAbsListView)
        {
          ab.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramAbsListView, "silenceMsgImp handleIdelScrollChange", new Object[0]);
          AppMethodBeat.o(31717);
          return;
        }
        paramInt += 1;
      }
      ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.caz.zJB.setIsBottomShowAll(false);
        this.caz.zJB.setBottomViewVisible(true);
        this.caz.zJB.qE(true);
        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        aw.RO().ac(new ak.1(this, paramAbsListView));
        AppMethodBeat.o(31717);
        return;
      }
      AppMethodBeat.o(31717);
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
          aw.aaz();
          localObject = com.tencent.mm.model.c.YC().Tm(paramAbsListView.field_talker);
          if ((localObject != null) && (((dd)localObject).field_msgId != 0L) && (((dd)localObject).field_createTime > paramAbsListView.field_createTime)) {
            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((dd)localObject).field_flag), Integer.valueOf(((dd)localObject).field_isSend), Long.valueOf(((dd)localObject).field_msgId), Long.valueOf(((dd)localObject).field_msgSvrId), Long.valueOf(((dd)localObject).field_msgSeq), Long.valueOf(((dd)localObject).field_createTime), Integer.valueOf(((bi)localObject).getType()), ((dd)localObject).field_talker });
          }
        }
        label873:
        AppMethodBeat.o(31717);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ak
 * JD-Core Version:    0.7.0.1
 */