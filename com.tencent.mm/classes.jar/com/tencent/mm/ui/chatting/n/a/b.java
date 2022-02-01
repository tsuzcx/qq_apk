package com.tencent.mm.ui.chatting.n.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.h.d.d;
import com.tencent.mm.ui.chatting.h.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class b
  extends a
{
  private long KaB;
  private int Kto;
  
  public b(com.tencent.mm.ui.chatting.e.a parama, e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(36658);
    this.KaB = ((d)fif().bh(d.class)).fGW();
    AppMethodBeat.o(36658);
  }
  
  private int fLw()
  {
    AppMethodBeat.i(36660);
    int i = ((y)fif().bh(y.class)).fIn();
    AppMethodBeat.o(36660);
    return i;
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bv> paramd)
  {
    AppMethodBeat.i(36659);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.KrD;
    int i = paramd.KrE.size();
    int j = paramd.fVS;
    int k;
    switch (1.KsJ[locala.ordinal()])
    {
    case 3: 
    default: 
      ae.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = fif().getTalkerUserName();
      long l = ((l)g.ab(l.class)).aAi().aqP(paramd);
      bc.aCg();
      k = com.tencent.mm.model.c.azI().D(paramd, 0L, l);
      ae.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", new Object[] { paramd, Long.valueOf(l), Integer.valueOf(k) });
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
      paramMMChattingListView.xI(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), k - m + 1, fLw() + paramMMChattingListView.getTopHeight(), false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((k)fif().bh(k.class)).adK(k);
      break;
      paramMMChattingListView.xJ(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - fLw(), false);
      break;
      fif().xY(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.b
 * JD-Core Version:    0.7.0.1
 */