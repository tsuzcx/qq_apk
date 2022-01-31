package com.tencent.mm.pluginsdk.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AbstractVideoView$8
  implements Runnable
{
  AbstractVideoView$8(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(117941);
    if ((this.vPL.mEy != null) && (this.vPL.mEy.getVisibility() != 0))
    {
      ab.i(this.vPL.TAG, "%s show loading", new Object[] { this.vPL.bas() });
      this.vPL.mEy.setVisibility(0);
      if (this.vPL.ryi != null) {
        this.vPL.ryi.cu(this.vPL.getSessionId(), this.vPL.getMediaId());
      }
    }
    AppMethodBeat.o(117941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.8
 * JD-Core Version:    0.7.0.1
 */