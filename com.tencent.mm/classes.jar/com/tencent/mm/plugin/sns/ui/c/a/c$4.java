package com.tencent.mm.plugin.sns.ui.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;

final class c$4
  implements Runnable
{
  c$4(c paramc, b.c.a parama, n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(40100);
    this.sge.sgb.setVisibility(0);
    this.sge.sgb.cxM();
    this.sge.sgb.setPaintColor(this.sgg.color);
    this.sge.sgb.setOnGestureListener(new c.4.1(this));
    AppMethodBeat.o(40100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c.4
 * JD-Core Version:    0.7.0.1
 */