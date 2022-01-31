package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;

final class OnlineVideoView$11
  implements Runnable
{
  OnlineVideoView$11(OnlineVideoView paramOnlineVideoView, boolean paramBoolean, float paramFloat) {}
  
  public final void run()
  {
    y.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(this.oRM.hashCode()), Boolean.valueOf(this.iuL), Float.valueOf(this.oRq) });
    View localView = (View)OnlineVideoView.d(this.oRM);
    if (this.iuL)
    {
      OnlineVideoView.f(this.oRM).setAlpha(this.oRq);
      OnlineVideoView.f(this.oRM).setVisibility(0);
      localView.setAlpha(this.oRq);
      localView.setVisibility(0);
      if (this.oRq >= 1.0D) {
        OnlineVideoView.g(this.oRM).setVisibility(8);
      }
      return;
    }
    OnlineVideoView.f(this.oRM).setVisibility(8);
    localView.setVisibility(8);
    OnlineVideoView.g(this.oRM).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.11
 * JD-Core Version:    0.7.0.1
 */