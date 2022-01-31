package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class OfflineVideoView$5
  implements Runnable
{
  OfflineVideoView$5(OfflineVideoView paramOfflineVideoView) {}
  
  public final void run()
  {
    y.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(this.oRp.hashCode()), Integer.valueOf(this.oRp.hashCode()) });
    if ((OfflineVideoView.d(this.oRp) != null) && (OfflineVideoView.d(this.oRp).getVisibility() != 0)) {
      OfflineVideoView.d(this.oRp).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.5
 * JD-Core Version:    0.7.0.1
 */