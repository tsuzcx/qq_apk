package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.t;
import com.tencent.mm.af.t.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.e.a.b;
import java.util.ArrayList;
import java.util.List;

final class e$5$1
  implements t
{
  e$5$1(e.5 param5) {}
  
  public final boolean Yr()
  {
    return true;
  }
  
  public final void a(t.a parama) {}
  
  public final void b(t.a parama)
  {
    AppMethodBeat.i(153911);
    if (parama == t.a.fkd) {
      e.a(this.zPv.zPs).removeAll(this.zPv.ieO);
    }
    AppMethodBeat.o(153911);
  }
  
  public final void c(t.a parama)
  {
    AppMethodBeat.i(153912);
    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[] { Thread.currentThread(), Integer.valueOf(this.zPv.ieO.size()), parama });
    if ((parama == t.a.fkd) && (e.c(this.zPv.zPs) != null)) {
      e.c(this.zPv.zPs).byi();
    }
    AppMethodBeat.o(153912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e.5.1
 * JD-Core Version:    0.7.0.1
 */