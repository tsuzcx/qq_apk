package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;

final class OfflineVideoView$4
  implements Runnable
{
  OfflineVideoView$4(OfflineVideoView paramOfflineVideoView, boolean paramBoolean, float paramFloat) {}
  
  public final void run()
  {
    y.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(this.oRp.hashCode()), Boolean.valueOf(this.iuL), Float.valueOf(this.oRq) });
    View localView = (View)OfflineVideoView.b(this.oRp);
    if (this.iuL)
    {
      localView.setAlpha(this.oRq);
      localView.setVisibility(0);
      OfflineVideoView.c(this.oRp).setVisibility(0);
      OfflineVideoView.c(this.oRp).setAlpha(this.oRq);
      if (this.oRq >= 1.0D) {
        OfflineVideoView.a(this.oRp).setVisibility(8);
      }
      return;
    }
    localView.setVisibility(0);
    OfflineVideoView.c(this.oRp).setVisibility(0);
    OfflineVideoView.c(this.oRp).setAlpha(0.0F);
    OfflineVideoView.a(this.oRp).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.4
 * JD-Core Version:    0.7.0.1
 */