package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ab;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.b.r;

@com.tencent.mm.ui.chatting.b.a.a(cFA=ab.class)
@Deprecated
public final class aj
  extends a
  implements be.a, ab
{
  public static int vsu = 350;
  public boolean vsv;
  public boolean vsw;
  public boolean vsx;
  private com.tencent.mm.sdk.b.c vsy;
  private boolean vsz;
  
  public final void a(final ak paramak, be parambe)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[] { paramak.field_username, Long.valueOf(Thread.currentThread().getId()) });
    if (!this.byx.euf) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
    }
    label47:
    bi localbi1;
    do
    {
      do
      {
        do
        {
          do
          {
            break label47;
            break label47;
            break label47;
            do
            {
              return;
            } while ((!this.byx.cFE()) || (!this.byx.pSb.field_username.equals(paramak.field_username)));
            parambe = (com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class);
            i = paramak.field_msgCount;
            j = parambe.cDk();
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.vsv), Integer.valueOf(paramak.field_UnDeliverCount) });
          } while (i <= j);
          localbi1 = paramak.uAh;
        } while ((localbi1 == null) || (localbi1.field_msgId == 0L));
        if (i - j > 1) {
          this.vsz = true;
        }
        k = localbi1.field_flag;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[] { Long.valueOf(localbi1.field_msgSvrId), Long.valueOf(localbi1.field_msgSeq), Integer.valueOf(k), bk.csb() });
      } while ((k & 0x2) == 0);
      if ((this.byx.getListView() == null) || (parambe == null) || (this.byx.vtB == null))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[] { this.byx.getListView(), parambe, this.byx.vtB });
        return;
      }
      if ((k & 0x4) != 0) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[] { Boolean.valueOf(this.vsv) });
      if (this.vsv)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
        return;
      }
      k = this.byx.getFirstVisiblePosition();
      m = parambe.getCount();
      n = parambe.getCount();
      i1 = n - m;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[] { this.byx.pSb.field_username, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i - j), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(0), Boolean.valueOf(this.vsw) });
    } while (i1 <= 1);
    paramak = this.byx.getListView();
    int i = paramak.getFirstVisiblePosition();
    int j = paramak.getChildCount();
    if ((k < i) || (k > j + i - 1))
    {
      paramak = paramak.getAdapter().getView(k, null, paramak);
      if (paramak != null) {
        break label700;
      }
    }
    label700:
    for (i = 0;; i = paramak.getTop())
    {
      j = i - this.byx.vtB.getBottomHeight();
      this.byx.getListView().setAdapter(this.byx.getListView().getAdapter());
      this.byx.fx(k, j);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[] { Integer.valueOf(k), paramak, Integer.valueOf(i), Integer.valueOf(j) });
      this.byx.getListView().post(new aj.2(this, k, j, parambe));
      this.byx.getListView().postDelayed(new aj.3(this, k, j, parambe), 200L);
      return;
      paramak = paramak.getChildAt(k - i);
      break;
    }
    int k = this.byx.getFirstVisiblePosition();
    int m = this.byx.getLastVisiblePosition();
    bi localbi2 = parambe.GW(k);
    bi localbi3 = parambe.GW(m);
    int n = parambe.getCount();
    int i1 = parambe.getCount();
    int i2 = i - j;
    int i3 = i1 - n;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[] { this.byx.pSb.field_username, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i3), Integer.valueOf(0), Boolean.valueOf(this.vsw) });
    if ((localbi3 != null) && (localbi3.field_msgId != 0L) && (localbi3.field_createTime < localbi1.field_createTime)) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
    }
    for (;;)
    {
      this.byx.vtB.cDa();
      if (paramak.field_UnDeliverCount <= 0) {
        ((r)this.byx.ac(r.class)).cER();
      }
      if (!this.vsw) {
        break;
      }
      this.vsw = false;
      this.byx.vtB.setIsBottomShowAll(false);
      boolean bool = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj();
      this.byx.vtB.setBottomViewVisible(bool);
      this.byx.vtB.nb(false);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[] { Boolean.valueOf(this.vsw) });
      com.tencent.mm.ui.chatting.c.a.cFG().postDelayed(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[] { Integer.valueOf(paramak.field_UnDeliverCount), Integer.valueOf(paramak.field_unReadCount) });
        }
      }, 500L);
      return;
      if (i3 > 0)
      {
        parambe.GY(i3);
        long l1;
        if (localbi2 == null)
        {
          l1 = -1L;
          label1078:
          if (localbi3 != null) {
            break label1249;
          }
        }
        label1249:
        for (long l2 = -1L;; l2 = localbi3.field_createTime)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(localbi1.field_createTime) });
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3 + 1), Integer.valueOf(k) });
          this.byx.fx(i3 + 1, ((q)this.byx.ac(q.class)).cEP() + this.byx.vtB.getTopHeight());
          ai.d(new aj.4(this, i3));
          break;
          l1 = localbi2.field_createTime;
          break label1078;
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0) });
    }
  }
  
  public final void aZ(bi parambi)
  {
    long l3;
    boolean bool;
    Object localObject;
    long l1;
    label72:
    int i;
    label90:
    long l2;
    int j;
    if ((parambi != null) && (parambi.field_msgId != 0L))
    {
      l3 = parambi.field_msgSeq;
      if ((parambi.field_flag & 0x4) == 0) {
        break label318;
      }
      bool = true;
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().abv(this.byx.pSb.field_username);
      if (localObject == null) {
        break label344;
      }
      if (!bool) {
        break label324;
      }
      l1 = ((as)localObject).field_firstUnDeliverSeq;
      if ((!bool) || (l1 != 0L)) {
        break label339;
      }
      i = ((as)localObject).field_UnDeliverCount;
      l2 = l1;
      j = i;
      if (bool)
      {
        l2 = l1;
        j = i;
        if (l1 > l3)
        {
          localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().ac(this.byx.pSb.field_username, l3);
          l2 = l1;
          j = i;
          if (localObject != null)
          {
            l2 = l1;
            j = i;
            if (((cs)localObject).field_msgSeq < l3)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[] { Long.valueOf(l1), Long.valueOf(((cs)localObject).field_msgSeq) });
              l2 = ((cs)localObject).field_msgSeq;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(parambi.field_flag), Boolean.valueOf(bool) });
      this.vsv = false;
      parambi = this.byx.pSb.field_username;
      int k = (int)l2;
      int m = (int)l3;
      if (bool) {}
      for (i = 1;; i = 0)
      {
        new com.tencent.mm.plugin.chatroom.a.a(parambi, k, m, j, i);
        return;
        label318:
        bool = false;
        break;
        label324:
        l1 = ((as)localObject).field_lastSeq;
        break label72;
      }
      label339:
      i = 0;
      break label90;
      label344:
      j = 0;
      l2 = 0L;
    }
  }
  
  public final void cyM()
  {
    this.vsv = false;
    this.vsx = this.byx.cFE();
    this.vsv = false;
    this.vsw = false;
  }
  
  public final void cyQ() {}
  
  public final void cyR()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.vsy);
    au.Hx();
    com.tencent.mm.model.c.FB().b(this);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    Object localObject;
    if (paramInt == 0)
    {
      for (;;)
      {
        try
        {
          paramAbsListView = this.byx.getChildAt(this.byx.getFirstVisiblePosition());
          if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
            if (!this.byx.cFE()) {
              break label850;
            }
            paramAbsListView = ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GW(0);
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label850;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
            if (((paramAbsListView.field_flag & 0x1) == 0) || ((paramAbsListView.field_flag & 0x4) == 0)) {
              break label850;
            }
            this.byx.vtB.cCZ();
            return;
          }
          if ((!this.byx.cFE()) || (this.byx.getChildAt(this.byx.getListView().getChildCount() - 1) == null)) {
            break label850;
          }
          localObject = (com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class);
          if (this.byx.getLastVisiblePosition() != this.byx.getListView().getAdapter().getCount() - 1) {
            break label850;
          }
          paramAbsListView = null;
          paramInt = 1;
          if (paramInt >= 5) {
            break label847;
          }
          paramAbsListView = ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GW(((com.tencent.mm.ui.chatting.b.b.g)localObject).getCount() - paramInt);
          if ((paramAbsListView != null) && (paramAbsListView.field_msgId != 0L) && ((paramAbsListView.field_flag & 0x1) != 0))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[] { Integer.valueOf(paramInt) });
            if ((paramAbsListView == null) || (paramAbsListView.field_msgId == 0L)) {
              break label851;
            }
            localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().P(paramAbsListView.field_talker, paramAbsListView.field_msgSeq);
            if ((((cs)localObject).field_msgId == 0L) || (((cs)localObject).field_msgId != paramAbsListView.field_msgId) || ((((cs)localObject).field_flag & 0x1) != 0)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[] { Long.valueOf(((cs)localObject).field_msgId), Integer.valueOf(((cs)localObject).field_flag) });
            return;
          }
        }
        catch (Exception paramAbsListView)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramAbsListView, "silenceMsgImp handleIdelScrollChange", new Object[0]);
          return;
        }
        paramInt += 1;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[] { Integer.valueOf(paramAbsListView.field_flag), Integer.valueOf(paramAbsListView.field_isSend), Long.valueOf(paramAbsListView.field_msgId), Long.valueOf(paramAbsListView.field_msgSvrId), Long.valueOf(paramAbsListView.field_msgSeq), Long.valueOf(paramAbsListView.field_createTime), Integer.valueOf(paramAbsListView.getType()), paramAbsListView.field_talker });
      if (((paramAbsListView.field_flag & 0x1) != 0) && ((paramAbsListView.field_flag & 0x4) == 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
        this.byx.vtB.setIsBottomShowAll(false);
        this.byx.vtB.setBottomViewVisible(true);
        this.byx.vtB.nb(true);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
        au.DS().O(new aj.1(this, paramAbsListView));
        return;
      }
    }
    for (;;)
    {
      label673:
      int i;
      if ((paramAbsListView.field_flag & 0x2) != 0)
      {
        i = 1;
        label684:
        if ((i & paramInt) == 0) {
          break label850;
        }
        au.Hx();
        localObject = com.tencent.mm.model.c.Fy().HA(paramAbsListView.field_talker);
        if ((localObject == null) || (((cs)localObject).field_msgId == 0L) || (((cs)localObject).field_createTime <= paramAbsListView.field_createTime)) {
          break label850;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[] { Integer.valueOf(((cs)localObject).field_flag), Integer.valueOf(((cs)localObject).field_isSend), Long.valueOf(((cs)localObject).field_msgId), Long.valueOf(((cs)localObject).field_msgSvrId), Long.valueOf(((cs)localObject).field_msgSeq), Long.valueOf(((cs)localObject).field_createTime), Integer.valueOf(((bi)localObject).getType()), ((cs)localObject).field_talker });
      }
      label847:
      label850:
      label851:
      do
      {
        paramInt = 0;
        break label673;
        i = 0;
        break label684;
        break;
        return;
      } while (paramAbsListView == null);
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.aj
 * JD-Core Version:    0.7.0.1
 */