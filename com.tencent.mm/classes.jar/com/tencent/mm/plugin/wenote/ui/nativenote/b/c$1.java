package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.l;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27151);
    if ((c.a(this.vDt) != null) && (c.a(this.vDt).vxk.booleanValue())) {
      c.a(this.vDt).vxl = Boolean.TRUE;
    }
    AppMethodBeat.o(27151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.c.1
 * JD-Core Version:    0.7.0.1
 */