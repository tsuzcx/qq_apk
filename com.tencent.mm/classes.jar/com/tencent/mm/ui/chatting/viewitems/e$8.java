package com.tencent.mm.ui.chatting.viewitems;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class e$8
  implements a.a
{
  e$8(s params, a parama) {}
  
  public final void ewC()
  {
    AppMethodBeat.i(200319);
    h.IzE.p(1293L, 32L, 1L);
    this.ucj.cancel();
    AppMethodBeat.o(200319);
  }
  
  public final void ewD()
  {
    AppMethodBeat.i(200325);
    w.makeText(this.QWD.WQv.getContext(), R.l.loading_failed, 0).show();
    this.ucj.cancel();
    AppMethodBeat.o(200325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.8
 * JD-Core Version:    0.7.0.1
 */