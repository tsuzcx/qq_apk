package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMSlideDelView$a
  extends MMSlideDelView.h
  implements Runnable
{
  private MMSlideDelView$a(MMSlideDelView paramMMSlideDelView)
  {
    super(paramMMSlideDelView, (byte)0);
  }
  
  public final void run()
  {
    AppMethodBeat.i(106775);
    if ((this.zmk.hasWindowFocus()) && (MMSlideDelView.c(this.zmk) == this.zml)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!MMSlideDelView.d(this.zmk)))
      {
        ab.i("MicroMsg.MMSlideDelView", "is long press");
        if (this.zmk.getParent() != null)
        {
          MMSlideDelView.e(this.zmk);
          this.zmk.performLongClick();
        }
      }
      AppMethodBeat.o(106775);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.a
 * JD-Core Version:    0.7.0.1
 */