package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$2
  implements Runnable
{
  AbstractVideoView$2(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(117935);
    try
    {
      this.vPL.rl(0);
      AbstractVideoView.a(this.vPL, this.vPL.isPlaying());
      AppMethodBeat.o(117935);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(117935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.2
 * JD-Core Version:    0.7.0.1
 */