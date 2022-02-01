package com.tencent.mm.ui.chatting.viewitems;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.lite.api.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class e$7
  implements c.a
{
  e$7(w paramw, a parama) {}
  
  public final void csx()
  {
    AppMethodBeat.i(255201);
    h.OAn.p(1293L, 32L, 1L);
    this.xin.cancel();
    AppMethodBeat.o(255201);
  }
  
  public final void csy()
  {
    AppMethodBeat.i(255206);
    aa.makeText(this.XSz.aezO.getContext(), R.l.loading_failed, 0).show();
    this.xin.cancel();
    AppMethodBeat.o(255206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.7
 * JD-Core Version:    0.7.0.1
 */