package com.tencent.mm.pluginsdk.ui;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$10
  implements Runnable
{
  AbstractVideoView$10(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(117943);
    if ((this.vPL.vPq != null) && (this.vPL.vPq.getVisibility() != 0)) {
      this.vPL.vPq.setVisibility(0);
    }
    AppMethodBeat.o(117943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.10
 * JD-Core Version:    0.7.0.1
 */