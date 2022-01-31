package com.tencent.mm.pluginsdk.ui;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbstractVideoView$11
  implements Runnable
{
  AbstractVideoView$11(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(117944);
    if ((this.vPL.vPq != null) && (this.vPL.vPq.getVisibility() != 8)) {
      this.vPL.vPq.setVisibility(8);
    }
    AppMethodBeat.o(117944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.11
 * JD-Core Version:    0.7.0.1
 */