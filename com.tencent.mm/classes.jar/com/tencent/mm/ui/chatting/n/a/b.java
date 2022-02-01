package com.tencent.mm.ui.chatting.n.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
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
  private long JFK;
  private int JWX;
  
  public b(com.tencent.mm.ui.chatting.e.a parama, e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(36658);
    this.JFK = ((d)fep().bh(d.class)).fCU();
    AppMethodBeat.o(36658);
  }
  
  private int fHe()
  {
    AppMethodBeat.i(36660);
    int i = ((y)fep().bh(y.class)).fEk();
    AppMethodBeat.o(36660);
    return i;
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<bu> paramd)
  {
    AppMethodBeat.i(36659);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.JVl;
    int i = paramd.JVm.size();
    int j = paramd.fTM;
    int k;
    switch (1.JWs[locala.ordinal()])
    {
    case 3: 
    default: 
      ad.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = fep().getTalkerUserName();
      long l = ((l)g.ab(l.class)).azS().apK(paramd);
      ba.aBQ();
      k = com.tencent.mm.model.c.azs().D(paramd, 0L, l);
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
      paramMMChattingListView.xA(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      n.a(paramMMChattingListView.getListView(), k - m + 1, fHe() + paramMMChattingListView.getTopHeight(), false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((k)fep().bh(k.class)).adc(k);
      break;
      paramMMChattingListView.xB(false);
      n.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - fHe(), false);
      break;
      fep().xR(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.b
 * JD-Core Version:    0.7.0.1
 */