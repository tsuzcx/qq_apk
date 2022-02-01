package com.tencent.mm.ui.chatting.h;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.d.b.w;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements f<ca>
{
  private MMChattingListView PDB;
  public a PDC;
  private a dom;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.PDB = paramMMChattingListView;
    this.dom = parama;
  }
  
  public final void a(d.d paramd)
  {
    AppMethodBeat.i(36420);
    this.dom.Pwj = false;
    Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
    Object localObject = (u)this.dom.bh(u.class);
    if ((localObject != null) && (((u)localObject).gPO() != null) && (((u)localObject).gPO().xfU))
    {
      Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
      this.dom.BN(true);
    }
    if (paramd.PDL != d.a.PDF)
    {
      localObject = this.PDB;
      MMPullDownView.n((ViewGroup)((MMPullDownView)localObject).OSi, 4);
      MMPullDownView.n((ViewGroup)((MMPullDownView)localObject).GEr, 4);
    }
    ((w)this.dom.bh(w.class)).startTimer();
    if (this.PDC != null) {
      this.PDC.a(this.PDB, paramd);
    }
    AppMethodBeat.o(36420);
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(233462);
    if (!this.dom.cQp)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(233462);
      return false;
    }
    if (!this.dom.Pwi)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", new Object[] { parama });
      a locala = this.dom;
      Log.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", new Object[] { Boolean.TRUE, Util.getStack() });
      locala.Pwj = true;
      locala.Pwm.add(parama);
      AppMethodBeat.o(233462);
      return false;
    }
    AppMethodBeat.o(233462);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b
 * JD-Core Version:    0.7.0.1
 */