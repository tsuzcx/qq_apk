package com.tencent.mm.ui.chatting.h;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements f<bu>
{
  private MMChattingListView JVb;
  public a JVc;
  private a cWM;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.JVb = paramMMChattingListView;
    this.cWM = parama;
  }
  
  public final void a(d.d paramd)
  {
    AppMethodBeat.i(36420);
    this.cWM.JOY = false;
    ad.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
    Object localObject = (s)this.cWM.bh(s.class);
    if ((localObject != null) && (((s)localObject).fDC() != null) && (((s)localObject).fDC().uCj))
    {
      ad.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
      this.cWM.xR(true);
    }
    if (paramd.JVl != d.a.JVf)
    {
      localObject = this.JVb;
      MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).JmB, 4);
      MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).BKV, 4);
    }
    ((u)this.cWM.bh(u.class)).startTimer();
    if (this.JVc != null) {
      this.JVc.a(this.JVb, paramd);
    }
    AppMethodBeat.o(36420);
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(194226);
    if (!this.cWM.cBJ)
    {
      ad.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(194226);
      return false;
    }
    if (!this.cWM.JOX)
    {
      ad.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", new Object[] { parama });
      a locala = this.cWM;
      ad.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", new Object[] { Boolean.TRUE, bt.flS() });
      locala.JOY = true;
      locala.JPb.add(parama);
      AppMethodBeat.o(194226);
      return false;
    }
    AppMethodBeat.o(194226);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(MMChattingListView paramMMChattingListView, d.d<bu> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b
 * JD-Core Version:    0.7.0.1
 */