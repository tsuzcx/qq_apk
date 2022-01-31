package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$7
  implements ViewTreeObserver.OnPreDrawListener
{
  a$7(a parama) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(113124);
    if (this.ANs.ANi)
    {
      this.ANs.ANi = false;
      a locala = this.ANs;
      locala.AMT.removeCallbacks(locala.ANo);
      locala.AMT.postDelayed(locala.ANo, 100L);
    }
    AppMethodBeat.o(113124);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.7
 * JD-Core Version:    0.7.0.1
 */