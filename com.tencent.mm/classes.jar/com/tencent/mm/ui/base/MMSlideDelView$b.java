package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMSlideDelView$b
  implements Runnable
{
  MMSlideDelView$b(MMSlideDelView paramMMSlideDelView) {}
  
  public final void run()
  {
    AppMethodBeat.i(106776);
    ab.v("MicroMsg.MMSlideDelView", "checkfortap");
    this.zmk.setPressed(true);
    AppMethodBeat.o(106776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.b
 * JD-Core Version:    0.7.0.1
 */