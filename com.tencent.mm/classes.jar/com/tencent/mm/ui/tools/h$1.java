package com.tencent.mm.ui.tools;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  h$1(h paramh) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(142763);
    if (this.AvB.Avq != null) {
      h.a(this.AvB);
    }
    AppMethodBeat.o(142763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.h.1
 * JD-Core Version:    0.7.0.1
 */