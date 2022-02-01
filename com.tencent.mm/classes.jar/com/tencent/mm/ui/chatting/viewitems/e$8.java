package com.tencent.mm.ui.chatting.viewitems;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class e$8
  implements a.a
{
  e$8(q paramq, a parama) {}
  
  public final void dTt()
  {
    AppMethodBeat.i(233592);
    h.CyF.n(1293L, 32L, 1L);
    this.qDi.cancel();
    AppMethodBeat.o(233592);
  }
  
  public final void dTu()
  {
    AppMethodBeat.i(233593);
    u.makeText(this.PHb.Pwc.getContext(), 2131762444, 0).show();
    this.qDi.cancel();
    AppMethodBeat.o(233593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.8
 * JD-Core Version:    0.7.0.1
 */