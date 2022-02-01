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
  private MMChattingListView WYo;
  public a WYp;
  private a fgR;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.WYo = paramMMChattingListView;
    this.fgR = parama;
  }
  
  public final void a(d.d paramd)
  {
    AppMethodBeat.i(36420);
    this.fgR.WQC = false;
    Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
    Object localObject = (u)this.fgR.bC(u.class);
    if ((localObject != null) && (((u)localObject).hPj() != null) && (((u)localObject).hPj().BSf))
    {
      Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
      this.fgR.Gi(true);
    }
    if (paramd.WYy != d.a.WYs)
    {
      localObject = this.WYo;
      MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).Wlv, 4);
      MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).Nsh, 4);
    }
    ((w)this.fgR.bC(w.class)).startTimer();
    if (this.WYp != null) {
      this.WYp.a(this.WYo, paramd);
    }
    AppMethodBeat.o(36420);
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(243174);
    if (!this.fgR.dgo)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(243174);
      return false;
    }
    if (!this.fgR.WQB)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", new Object[] { parama });
      a locala = this.fgR;
      Log.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", new Object[] { Boolean.TRUE, Util.getStack() });
      locala.WQC = true;
      locala.WQF.add(parama);
      AppMethodBeat.o(243174);
      return false;
    }
    AppMethodBeat.o(243174);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(MMChattingListView paramMMChattingListView, d.d<ca> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b
 * JD-Core Version:    0.7.0.1
 */