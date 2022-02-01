package com.tencent.mm.ui.chatting.g;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements f<bl>
{
  private MMChattingListView GER;
  public a GES;
  private a cOd;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.GER = paramMMChattingListView;
    this.cOd = parama;
  }
  
  public final void a(d.d paramd)
  {
    AppMethodBeat.i(36420);
    this.cOd.GzP = false;
    ad.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
    Object localObject = (q)this.cOd.be(q.class);
    if ((localObject != null) && (((q)localObject).eXs() != null) && (((q)localObject).eXs().srJ))
    {
      ad.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
      this.cOd.wc(true);
    }
    if (paramd.GFc != d.a.GEW)
    {
      localObject = this.GER;
      MMPullDownView.m((ViewGroup)((MMPullDownView)localObject).FYV, 4);
      MMPullDownView.m((ViewGroup)((MMPullDownView)localObject).FJA, 4);
    }
    ((s)this.cOd.be(s.class)).startTimer();
    if (this.GES != null) {
      this.GES.a(this.GER, paramd);
    }
    AppMethodBeat.o(36420);
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(191564);
    if (!this.cOd.ctF)
    {
      ad.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(191564);
      return false;
    }
    if (!this.cOd.GzO)
    {
      ad.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", new Object[] { parama });
      a locala = this.cOd;
      ad.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", new Object[] { Boolean.TRUE, bt.eGN() });
      locala.GzP = true;
      locala.GzR.add(parama);
      AppMethodBeat.o(191564);
      return false;
    }
    AppMethodBeat.o(191564);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(MMChattingListView paramMMChattingListView, d.d<bl> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.b
 * JD-Core Version:    0.7.0.1
 */