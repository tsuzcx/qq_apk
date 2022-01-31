package com.tencent.mm.ui.chatting.l.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.f.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class b
  extends a
{
  private long zDF;
  private int zQq;
  
  public b(com.tencent.mm.ui.chatting.d.a parama, e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(32717);
    this.zDF = ((d)this.caz.ay(d.class)).dHI();
    AppMethodBeat.o(32717);
  }
  
  private int dLl()
  {
    AppMethodBeat.i(32719);
    int i = ((r)this.caz.ay(r.class)).dIG();
    AppMethodBeat.o(32719);
    return i;
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bi> paramd)
  {
    AppMethodBeat.i(32718);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.zOE;
    int i = paramd.zOF.size();
    int j = paramd.eke;
    int k;
    switch (b.1.zPK[locala.ordinal()])
    {
    case 3: 
    default: 
      ab.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = this.caz.getTalkerUserName();
      long l = ((j)g.E(j.class)).Zc().Tb(paramd);
      aw.aaz();
      k = com.tencent.mm.model.c.YC().z(paramd, 0L, l);
      ab.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(k) });
      if (j - k > i) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramMMChattingListView.setIsTopShowAll(bool);
      paramMMChattingListView.setIsBottomShowAll(true);
      AppMethodBeat.o(32718);
      return;
      paramMMChattingListView.qD(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      k.a(paramMMChattingListView.getListView(), k - m + 1, dLl() + paramMMChattingListView.getTopHeight(), false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).PB(k);
      break;
      paramMMChattingListView.qE(false);
      k.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - dLl(), false);
      break;
      this.caz.qT(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.b
 * JD-Core Version:    0.7.0.1
 */