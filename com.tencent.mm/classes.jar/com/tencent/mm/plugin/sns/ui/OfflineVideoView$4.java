package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class OfflineVideoView$4
  implements Runnable
{
  OfflineVideoView$4(OfflineVideoView paramOfflineVideoView, boolean paramBoolean, float paramFloat) {}
  
  public final void run()
  {
    AppMethodBeat.i(38363);
    ab.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(this.rJb.hashCode()), Boolean.valueOf(this.kvP), Float.valueOf(this.rJc) });
    View localView = (View)OfflineVideoView.b(this.rJb);
    if (this.kvP)
    {
      localView.setAlpha(this.rJc);
      localView.setVisibility(0);
      OfflineVideoView.c(this.rJb).setVisibility(0);
      OfflineVideoView.c(this.rJb).setAlpha(this.rJc);
      if (this.rJc >= 1.0D)
      {
        OfflineVideoView.a(this.rJb).setVisibility(8);
        AppMethodBeat.o(38363);
      }
    }
    else
    {
      localView.setVisibility(0);
      OfflineVideoView.c(this.rJb).setVisibility(0);
      OfflineVideoView.c(this.rJb).setAlpha(0.0F);
      OfflineVideoView.a(this.rJb).setVisibility(0);
    }
    AppMethodBeat.o(38363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.4
 * JD-Core Version:    0.7.0.1
 */