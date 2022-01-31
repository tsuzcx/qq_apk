package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class OnlineVideoView$13
  implements Runnable
{
  OnlineVideoView$13(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    y.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(this.oRM.hashCode()), Integer.valueOf(OnlineVideoView.j(this.oRM)) });
    if (OnlineVideoView.j(this.oRM) == 1)
    {
      if ((OnlineVideoView.h(this.oRM) != null) && (OnlineVideoView.h(this.oRM).getVisibility() != 0)) {
        OnlineVideoView.h(this.oRM).setVisibility(0);
      }
      if ((OnlineVideoView.i(this.oRM) != null) && (OnlineVideoView.i(this.oRM).getVisibility() != 8)) {
        OnlineVideoView.i(this.oRM).setVisibility(8);
      }
    }
    if (OnlineVideoView.j(this.oRM) == 2)
    {
      if ((OnlineVideoView.i(this.oRM) != null) && (OnlineVideoView.i(this.oRM).getVisibility() != 0)) {
        OnlineVideoView.i(this.oRM).setVisibility(0);
      }
      if ((OnlineVideoView.h(this.oRM) != null) && (OnlineVideoView.h(this.oRM).getVisibility() != 8)) {
        OnlineVideoView.h(this.oRM).setVisibility(8);
      }
    }
    if (OnlineVideoView.j(this.oRM) == 3)
    {
      if ((OnlineVideoView.i(this.oRM) != null) && (OnlineVideoView.i(this.oRM).getVisibility() != 0))
      {
        OnlineVideoView.i(this.oRM).setVisibility(0);
        OnlineVideoView.i(this.oRM).cJO();
      }
      if ((OnlineVideoView.h(this.oRM) != null) && (OnlineVideoView.h(this.oRM).getVisibility() != 8)) {
        OnlineVideoView.h(this.oRM).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.13
 * JD-Core Version:    0.7.0.1
 */