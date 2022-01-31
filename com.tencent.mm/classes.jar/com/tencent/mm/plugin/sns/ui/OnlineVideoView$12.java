package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class OnlineVideoView$12
  implements Runnable
{
  OnlineVideoView$12(OnlineVideoView paramOnlineVideoView, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if ((OnlineVideoView.h(this.oRM) != null) && (OnlineVideoView.h(this.oRM).getVisibility() != 8)) {
      OnlineVideoView.h(this.oRM).setVisibility(8);
    }
    if (OnlineVideoView.i(this.oRM) != null)
    {
      if (OnlineVideoView.i(this.oRM).getVisibility() != 0) {
        OnlineVideoView.i(this.oRM).setVisibility(0);
      }
      y.i("MicroMsg.OnlineVideoView", "%d update progress %d %d", new Object[] { Integer.valueOf(this.oRM.hashCode()), Integer.valueOf(this.ejr), Integer.valueOf(this.epd) });
      if ((OnlineVideoView.i(this.oRM).getMax() != this.epd) && (this.epd > 0)) {
        OnlineVideoView.i(this.oRM).setMax(this.epd);
      }
      OnlineVideoView.i(this.oRM).setProgress(this.ejr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.12
 * JD-Core Version:    0.7.0.1
 */