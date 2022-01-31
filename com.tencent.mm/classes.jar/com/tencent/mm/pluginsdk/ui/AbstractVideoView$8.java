package com.tencent.mm.pluginsdk.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class AbstractVideoView$8
  implements Runnable
{
  AbstractVideoView$8(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    if ((this.rYV.kjT != null) && (this.rYV.kjT.getVisibility() != 0))
    {
      y.i(this.rYV.TAG, "%s show loading", new Object[] { this.rYV.ayL() });
      this.rYV.kjT.setVisibility(0);
      if (this.rYV.oIn != null) {
        this.rYV.oIn.bL(this.rYV.getSessionId(), this.rYV.getMediaId());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.8
 * JD-Core Version:    0.7.0.1
 */