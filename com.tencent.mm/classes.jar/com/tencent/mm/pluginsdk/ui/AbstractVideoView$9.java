package com.tencent.mm.pluginsdk.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AbstractVideoView$9
  implements Runnable
{
  AbstractVideoView$9(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(117942);
    if ((this.vPL.mEy != null) && (this.vPL.mEy.getVisibility() != 8))
    {
      ab.i(this.vPL.TAG, "%s hide loading", new Object[] { this.vPL.bas() });
      this.vPL.mEy.setVisibility(8);
      if (this.vPL.ryi != null) {
        this.vPL.ryi.cv(this.vPL.getSessionId(), this.vPL.getMediaId());
      }
    }
    AppMethodBeat.o(117942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.9
 * JD-Core Version:    0.7.0.1
 */