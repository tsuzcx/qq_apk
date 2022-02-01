package com.tencent.mm.ui.chatting.g;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements f<bo>
{
  private MMChattingListView IeO;
  public a IeP;
  private a cLy;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.IeO = paramMMChattingListView;
    this.cLy = parama;
  }
  
  public final void a(d.d paramd)
  {
    AppMethodBeat.i(36420);
    this.cLy.HZK = false;
    ac.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
    Object localObject = (q)this.cLy.bf(q.class);
    if ((localObject != null) && (((q)localObject).fne() != null) && (((q)localObject).fne().tzA))
    {
      ac.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
      this.cLy.xg(true);
    }
    if (paramd.IeY != d.a.IeS)
    {
      localObject = this.IeO;
      MMPullDownView.m((ViewGroup)((MMPullDownView)localObject).HyK, 4);
      MMPullDownView.m((ViewGroup)((MMPullDownView)localObject).HiH, 4);
    }
    ((s)this.cLy.bf(s.class)).startTimer();
    if (this.IeP != null) {
      this.IeP.a(this.IeO, paramd);
    }
    AppMethodBeat.o(36420);
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(196629);
    if (!this.cLy.cqM)
    {
      ac.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(196629);
      return false;
    }
    if (!this.cLy.HZJ)
    {
      ac.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", new Object[] { parama });
      a locala = this.cLy;
      ac.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", new Object[] { Boolean.TRUE, bs.eWi() });
      locala.HZK = true;
      locala.HZM.add(parama);
      AppMethodBeat.o(196629);
      return false;
    }
    AppMethodBeat.o(196629);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(MMChattingListView paramMMChattingListView, d.d<bo> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.b
 * JD-Core Version:    0.7.0.1
 */