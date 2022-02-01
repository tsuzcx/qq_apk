package com.tencent.mm.ui.chatting.h;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements f<bv>
{
  private MMChattingListView Krt;
  public a Kru;
  private a cXJ;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.Krt = paramMMChattingListView;
    this.cXJ = parama;
  }
  
  public final void a(d.d paramd)
  {
    AppMethodBeat.i(36420);
    this.cXJ.Kkk = false;
    ae.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
    Object localObject = (s)this.cXJ.bh(s.class);
    if ((localObject != null) && (((s)localObject).fHF() != null) && (((s)localObject).fHF().uNO))
    {
      ae.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
      this.cXJ.xY(true);
    }
    if (paramd.KrD != d.a.Krx)
    {
      localObject = this.Krt;
      MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).JHq, 4);
      MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).Ccu, 4);
    }
    ((u)this.cXJ.bh(u.class)).startTimer();
    if (this.Kru != null) {
      this.Kru.a(this.Krt, paramd);
    }
    AppMethodBeat.o(36420);
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(187617);
    if (!this.cXJ.cCq)
    {
      ae.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(187617);
      return false;
    }
    if (!this.cXJ.Kkj)
    {
      ae.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", new Object[] { parama });
      a locala = this.cXJ;
      ae.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", new Object[] { Boolean.TRUE, bu.fpN() });
      locala.Kkk = true;
      locala.Kkn.add(parama);
      AppMethodBeat.o(187617);
      return false;
    }
    AppMethodBeat.o(187617);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(MMChattingListView paramMMChattingListView, d.d<bv> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b
 * JD-Core Version:    0.7.0.1
 */