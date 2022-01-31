package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class OnlineVideoView$14
  implements Runnable
{
  OnlineVideoView$14(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    if ((OnlineVideoView.h(this.oRM) != null) && (OnlineVideoView.h(this.oRM).getVisibility() != 8))
    {
      y.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(this.oRM.hashCode()) });
      OnlineVideoView.h(this.oRM).setVisibility(8);
    }
    if ((OnlineVideoView.i(this.oRM) != null) && (OnlineVideoView.i(this.oRM).getVisibility() != 8))
    {
      y.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[] { Integer.valueOf(this.oRM.hashCode()) });
      OnlineVideoView.i(this.oRM).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.14
 * JD-Core Version:    0.7.0.1
 */