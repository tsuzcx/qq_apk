package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;

final class c$4
  implements Runnable
{
  c$4(c paramc, c.a parama, b.c.a parama1, n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(40141);
    c.a.b(this.sii).setVisibility(0);
    c.a.b(this.sii).cxM();
    c.a.b(this.sii).setPaintColor(this.sgg.color);
    c.a.b(this.sii).setOnGestureListener(new c.4.1(this));
    AppMethodBeat.o(40141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c.4
 * JD-Core Version:    0.7.0.1
 */