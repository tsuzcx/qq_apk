package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMSlideDelView$2
  implements Runnable
{
  MMSlideDelView$2(MMSlideDelView paramMMSlideDelView) {}
  
  public final void run()
  {
    AppMethodBeat.i(106774);
    this.zmk.setPressed(false);
    ab.v("MicroMsg.MMSlideDelView", "onClick");
    MMSlideDelView.b(this.zmk).r(this.zmk, MMSlideDelView.a(this.zmk), 0);
    this.zmk.dEj();
    AppMethodBeat.o(106774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.2
 * JD-Core Version:    0.7.0.1
 */