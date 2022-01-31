package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.e.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.x;

public final class e
  extends a
{
  private String talker = this.byx.getTalkerUserName();
  private volatile long vAd = 0L;
  private volatile long vAe = 0L;
  private volatile long vAf = 0L;
  private Runnable vAi;
  
  public e(com.tencent.mm.ui.chatting.c.a parama, com.tencent.mm.ui.chatting.e.d paramd)
  {
    super(parama, paramd);
    y.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", new Object[] { this.talker });
  }
  
  private int cGY()
  {
    return ((q)this.byx.ac(q.class)).cEP();
  }
  
  protected final com.tencent.mm.ui.chatting.k.e a(d.a parama, Bundle paramBundle, d.d paramd)
  {
    int i;
    int j;
    long l;
    switch (2.vzn[parama.ordinal()])
    {
    default: 
      i = 0;
      j = 0;
    case 1: 
    case 2: 
      boolean bool;
      for (;;)
      {
        y.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { parama, Long.valueOf(this.vAd), Long.valueOf(this.vAe), Long.valueOf(this.vAf), Integer.valueOf(j), Integer.valueOf(i) });
        return new com.tencent.mm.ui.chatting.k.d(this.byx.getTalkerUserName(), this.vAd, this.vAe);
        if (paramBundle == null)
        {
          y.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
          i = 0;
          j = 0;
        }
        else
        {
          l = paramBundle.getLong("MSG_ID");
          bool = paramBundle.getBoolean("IS_LOAD_ALL", false);
          au.Hx();
          paramBundle = c.Fy().fd(l);
          if (paramBundle.field_msgId == l) {
            break;
          }
          y.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", new Object[] { Long.valueOf(l) });
          i = 0;
          j = 0;
        }
      }
      l = paramBundle.field_createTime;
      if ((l < this.vAd) || (l > this.vAe))
      {
        this.vAd = l;
        this.vAf = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HV(this.talker);
        if (bool)
        {
          this.vAe = this.vAf;
          label296:
          au.Hx();
          i = c.Fy().r(this.talker, this.vAd, this.vAe);
          y.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
          if (i >= 48) {
            break label699;
          }
          y.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.vAd), Integer.valueOf(0) });
          au.Hx();
          this.vAd = c.Fy().e(this.talker, this.vAd, 48);
          au.Hx();
          i = c.Fy().r(this.talker, this.vAd, l);
        }
      }
      break;
    }
    for (;;)
    {
      paramd.nul = i;
      i = 0;
      j = 0;
      break;
      au.Hx();
      this.vAe = c.Fy().f(this.talker, l, 48);
      break label296;
      au.Hx();
      i = c.Fy().r(this.talker, this.vAd, l);
      continue;
      au.Hx();
      l = c.Fy().e(this.talker, this.vAd, 48);
      au.Hx();
      j = Math.max(0, c.Fy().r(this.talker, l, this.vAd) - 1);
      this.vAd = l;
      i = 0;
      break;
      au.Hx();
      l = c.Fy().f(this.talker, this.vAe, 48);
      au.Hx();
      i = Math.max(0, c.Fy().r(this.talker, this.vAe, l) - 1);
      this.vAe = l;
      j = 0;
      break;
      this.vAf = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HV(this.talker);
      au.Hx();
      i = Math.max(0, c.Fy().r(this.talker, this.vAe, this.vAf) - 1);
      this.vAe = this.vAf;
      j = 0;
      break;
      label699:
      i = 0;
    }
  }
  
  public final void a(final MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    boolean bool2 = true;
    super.a(paramMMChattingListView, paramd);
    Object localObject = paramd.vyj;
    final int i = paramd.nul;
    paramMMChattingListView.getListView().setTranscriptMode(0);
    switch (2.vzn[localObject.ordinal()])
    {
    default: 
      if (this.byx.getLastVisiblePosition() == paramd.vyl - 1) {
        paramMMChattingListView.getListView().setTranscriptMode(1);
      }
      paramMMChattingListView.setBottomViewVisible(true);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HU(this.talker);
      y.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.vAd) });
      if (this.vAd <= l)
      {
        bool1 = true;
        label163:
        paramMMChattingListView.setIsTopShowAll(bool1);
        if (this.vAe < this.vAf) {
          break label411;
        }
      }
      break;
    }
    label411:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramMMChattingListView.setIsBottomShowAll(bool1);
      return;
      paramMMChattingListView.na(false);
      i = paramMMChattingListView.getCurCount();
      int j = paramMMChattingListView.getPreCount();
      com.tencent.mm.pluginsdk.ui.tools.j.a(paramMMChattingListView.getListView(), i - j + 1, cGY() + paramMMChattingListView.getTopHeight(), false);
      i = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (i <= 0) {
        break;
      }
      ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GY(i);
      break;
      paramMMChattingListView.nb(false);
      com.tencent.mm.pluginsdk.ui.tools.j.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - cGY(), false);
      break;
      if (i < 0) {
        break;
      }
      bool1 = this.byx.vtz.getBooleanExtra("need_hight_item", false).booleanValue();
      HH(i);
      if (!bool1) {
        break;
      }
      this.byx.vtz.getLongExtra("msg_local_id", -1L);
      y.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", new Object[] { Integer.valueOf(i) });
      ai.S(this.vAi);
      localObject = new Runnable()
      {
        public final void run()
        {
          int i = Math.max(0, i - e.this.byx.getFirstVisiblePosition());
          e.this.HH(i);
          paramMMChattingListView.setHighLightChild(i);
          au.Hx();
          c.Dz().c(ac.a.ury, Boolean.valueOf(false));
        }
      };
      this.vAi = ((Runnable)localObject);
      ai.l((Runnable)localObject, 500L);
      break;
      bool1 = false;
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.e
 * JD-Core Version:    0.7.0.1
 */