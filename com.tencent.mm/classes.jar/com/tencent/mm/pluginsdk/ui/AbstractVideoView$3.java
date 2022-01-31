package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$3
  implements Runnable
{
  AbstractVideoView$3(AbstractVideoView paramAbstractVideoView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(117936);
    this.vPL.vPA = true;
    this.vPL.rl(this.vPM);
    this.vPL.d(this.vPM, true);
    this.vPL.vPA = false;
    AppMethodBeat.o(117936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.3
 * JD-Core Version:    0.7.0.1
 */