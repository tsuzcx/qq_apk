package com.tencent.mm.ui.chatting.k.a;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.List;

public final class b
  extends a
{
  private int aeKa;
  private long aenl;
  
  public b(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.f.e parame)
  {
    super(parama, parame);
    AppMethodBeat.i(36658);
    this.aenl = ((com.tencent.mm.ui.chatting.component.api.e)iNh().cm(com.tencent.mm.ui.chatting.component.api.e.class)).jrk();
    AppMethodBeat.o(36658);
  }
  
  private int jxd()
  {
    AppMethodBeat.i(36660);
    int i = ((ad)iNh().cm(ad.class)).jsS();
    AppMethodBeat.o(36660);
    return i;
  }
  
  public final void a(MMChattingListView paramMMChattingListView, d.d<cc> paramd)
  {
    AppMethodBeat.i(36659);
    super.a(paramMMChattingListView, paramd);
    d.a locala = paramd.aeHY;
    int i = paramd.aeHZ.size();
    int j = paramd.lNX;
    int k;
    switch (1.aeJk[locala.ordinal()])
    {
    case 3: 
    default: 
      Log.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
      paramd = iNh().getTalkerUserName();
      long l = ((n)h.ax(n.class)).bAd().aLt(paramd);
      bh.bCz();
      k = com.tencent.mm.model.c.bzD().I(paramd, 0L, l);
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
      paramMMChattingListView.LB(false);
      k = paramMMChattingListView.getCurCount();
      int m = paramMMChattingListView.getPreCount();
      q.a(paramMMChattingListView.getListView(), k - m + 1, jxd() + paramMMChattingListView.getTopHeight(), false, false);
      k = paramMMChattingListView.getCurCount() - paramMMChattingListView.getPreCount();
      if (k <= 0) {
        break;
      }
      ((m)iNh().cm(m.class)).aBX(k);
      break;
      paramMMChattingListView.LC(false);
      q.a(paramMMChattingListView.getListView(), paramMMChattingListView.getPreCount() + 1, paramMMChattingListView.getListView().getHeight() - jxd(), false, false);
      break;
      iNh().Mf(false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.b
 * JD-Core Version:    0.7.0.1
 */