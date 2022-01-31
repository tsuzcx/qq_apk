package com.tencent.mm.ui.chatting.k.a;

import android.widget.ListView;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.e.d.d;
import com.tencent.mm.ui.chatting.e.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class b
  extends a
{
  private long voj = ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDS();
  private int vzT;
  
  public b(com.tencent.mm.ui.chatting.c.a parama, e parame)
  {
    super(parama, parame);
  }
  
  private int cGY()
  {
    return ((q)this.byx.ac(q.class)).cEP();
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.vyj;
    int i = paramd.vyk.size();
    int j = paramd.dsw;
    int k;
    switch (b.1.vzn[locala.ordinal()])
    {
    case 3: 
    default: 
      y.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = this.byx.getTalkerUserName();
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Gb().Hp(paramd);
      au.Hx();
      k = com.tencent.mm.model.c.Fy().r(paramd, 0L, l);
      y.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(k) });
      if (j - k > i) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramMMChattingListView.setIsTopShowAll(bool);
      paramMMChattingListView.setIsBottomShowAll(true);
      return;
      paramMMChattingListView.na(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      com.tencent.mm.pluginsdk.ui.tools.j.a(paramMMChattingListView.getListView(), k - m + 1, cGY() + paramMMChattingListView.getTopHeight(), false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GY(k);
      break;
      paramMMChattingListView.nb(false);
      com.tencent.mm.pluginsdk.ui.tools.j.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - cGY(), false);
      break;
      this.byx.cCW();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.b
 * JD-Core Version:    0.7.0.1
 */