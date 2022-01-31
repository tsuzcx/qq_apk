package com.tencent.mm.ui.widget.snackbar;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnackContainer$1
  implements Runnable
{
  SnackContainer$1(SnackContainer paramSnackContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(112991);
    if (this.AKD.getVisibility() == 0) {
      this.AKD.startAnimation(SnackContainer.a(this.AKD));
    }
    AppMethodBeat.o(112991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.1
 * JD-Core Version:    0.7.0.1
 */