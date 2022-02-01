package com.tencent.mm.ui.chatting.m.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.g.d.d;
import com.tencent.mm.ui.chatting.g.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class b
  extends a
{
  private int GGO;
  private long Gsa;
  
  public b(com.tencent.mm.ui.chatting.d.a parama, e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(36658);
    this.Gsa = ((d)faA().be(d.class)).eWP();
    AppMethodBeat.o(36658);
  }
  
  private int faB()
  {
    AppMethodBeat.i(36660);
    int i = ((w)faA().be(w.class)).eYb();
    AppMethodBeat.o(36660);
    return i;
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bl> paramd)
  {
    AppMethodBeat.i(36659);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.GFc;
    int i = paramd.GFd.size();
    int j = paramd.fwP;
    int k;
    switch (1.GGj[locala.ordinal()])
    {
    case 3: 
    default: 
      ad.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = faA().getTalkerUserName();
      long l = ((k)g.ab(k.class)).aqo().age(paramd);
      az.arV();
      k = com.tencent.mm.model.c.apO().E(paramd, 0L, l);
      ad.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(k) });
      if (j - k > i) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramMMChattingListView.setIsTopShowAll(bool);
      paramMMChattingListView.setIsBottomShowAll(true);
      AppMethodBeat.o(36659);
      return;
      paramMMChattingListView.vL(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), k - m + 1, faB() + paramMMChattingListView.getTopHeight(), false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((i)faA().be(i.class)).YG(k);
      break;
      paramMMChattingListView.vM(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - faB(), false);
      break;
      faA().wc(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.b
 * JD-Core Version:    0.7.0.1
 */