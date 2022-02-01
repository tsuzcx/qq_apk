package com.tencent.mm.ui.chatting.o.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.tools.r;
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
  private long WFI;
  private int Xar;
  
  public b(com.tencent.mm.ui.chatting.e.a parama, e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(36658);
    this.WFI = ((d)hmp().bC(d.class)).hOs();
    AppMethodBeat.o(36658);
  }
  
  private int hTB()
  {
    AppMethodBeat.i(36660);
    int i = ((aa)hmp().bC(aa.class)).hPV();
    AppMethodBeat.o(36660);
    return i;
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd)
  {
    AppMethodBeat.i(36659);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.WYy;
    int i = paramd.WYz.size();
    int j = paramd.jlf;
    int k;
    switch (1.WZK[locala.ordinal()])
    {
    case 3: 
    default: 
      Log.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = hmp().getTalkerUserName();
      long l = ((n)h.ae(n.class)).bco().aOu(paramd);
      bh.beI();
      k = com.tencent.mm.model.c.bbO().D(paramd, 0L, l);
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
      paramMMChattingListView.FP(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      r.a(paramMMChattingListView.getListView(), k - m + 1, hTB() + paramMMChattingListView.getTopHeight(), false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((k)hmp().bC(k.class)).avv(k);
      break;
      paramMMChattingListView.FQ(false);
      r.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - hTB(), false);
      break;
      hmp().Gi(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.a.b
 * JD-Core Version:    0.7.0.1
 */