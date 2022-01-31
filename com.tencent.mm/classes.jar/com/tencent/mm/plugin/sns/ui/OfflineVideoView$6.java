package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class OfflineVideoView$6
  implements Runnable
{
  OfflineVideoView$6(OfflineVideoView paramOfflineVideoView) {}
  
  public final void run()
  {
    if ((OfflineVideoView.d(this.oRp) != null) && (OfflineVideoView.d(this.oRp).getVisibility() != 8))
    {
      y.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(this.oRp.hashCode()) });
      OfflineVideoView.d(this.oRp).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.6
 * JD-Core Version:    0.7.0.1
 */