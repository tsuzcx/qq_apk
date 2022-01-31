package com.tencent.mm.pluginsdk.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class AbstractVideoView$9
  implements Runnable
{
  AbstractVideoView$9(AbstractVideoView paramAbstractVideoView) {}
  
  public final void run()
  {
    if ((this.rYV.kjT != null) && (this.rYV.kjT.getVisibility() != 8))
    {
      y.i(this.rYV.TAG, "%s hide loading", new Object[] { this.rYV.ayL() });
      this.rYV.kjT.setVisibility(8);
      if (this.rYV.oIn != null) {
        this.rYV.oIn.bM(this.rYV.getSessionId(), this.rYV.getMediaId());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.9
 * JD-Core Version:    0.7.0.1
 */