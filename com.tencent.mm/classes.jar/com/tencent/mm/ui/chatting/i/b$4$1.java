package com.tencent.mm.ui.chatting.i;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.t;
import com.tencent.mm.af.t.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class b$4$1
  implements t
{
  b$4$1(b.4 param4) {}
  
  public final boolean Yr()
  {
    return true;
  }
  
  public final void a(t.a parama) {}
  
  public final void b(t.a parama)
  {
    AppMethodBeat.i(153909);
    if (parama == t.a.fkd)
    {
      parama = new b.4.1.1(this);
      parama.cpO = this.zPi.fkQ.field_msgId;
      this.zPi.zPf.iVH.remove(parama);
      this.zPi.zPf.zPe.remove(parama);
    }
    AppMethodBeat.o(153909);
  }
  
  public final void c(t.a parama)
  {
    AppMethodBeat.i(153910);
    ab.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[] { Thread.currentThread(), parama });
    if (parama == t.a.fkd) {
      this.zPi.zPf.zPd.ajb.notifyChanged();
    }
    AppMethodBeat.o(153910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b.4.1
 * JD-Core Version:    0.7.0.1
 */