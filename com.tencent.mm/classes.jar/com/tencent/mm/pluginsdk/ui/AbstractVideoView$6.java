package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;

final class AbstractVideoView$6
  implements b
{
  AbstractVideoView$6(AbstractVideoView paramAbstractVideoView) {}
  
  public final void aFf() {}
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(117939);
    if (this.vPL.d(paramInt, true)) {
      this.vPL.dh(false);
    }
    this.vPL.vPr.setIsPlay(true);
    AppMethodBeat.o(117939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.6
 * JD-Core Version:    0.7.0.1
 */