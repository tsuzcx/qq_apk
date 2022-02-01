package com.tencent.mm.ui.chatting.n.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.h.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class b
  extends a
{
  private int PFD;
  private long PlX;
  
  public b(com.tencent.mm.ui.chatting.e.a parama, e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(36658);
    this.PlX = ((d)grq().bh(d.class)).gPc();
    AppMethodBeat.o(36658);
  }
  
  private int gTR()
  {
    AppMethodBeat.i(36660);
    int i = ((aa)grq().bh(aa.class)).gQy();
    AppMethodBeat.o(36660);
    return i;
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    AppMethodBeat.i(36659);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.PDL;
    int i = paramd.PDM.size();
    int j = paramd.gAZ;
    int k;
    switch (1.PEY[locala.ordinal()])
    {
    case 3: 
    default: 
      Log.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = grq().getTalkerUserName();
      long l = ((l)g.af(l.class)).aTq().aEk(paramd);
      bg.aVF();
      k = com.tencent.mm.model.c.aSQ().E(paramd, 0L, l);
      Log.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(k) });
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
      paramMMChattingListView.Bx(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      p.a(paramMMChattingListView.getListView(), k - m + 1, gTR() + paramMMChattingListView.getTopHeight(), false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((k)grq().bh(k.class)).amv(k);
      break;
      paramMMChattingListView.By(false);
      p.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - gTR(), false);
      break;
      grq().BN(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.b
 * JD-Core Version:    0.7.0.1
 */