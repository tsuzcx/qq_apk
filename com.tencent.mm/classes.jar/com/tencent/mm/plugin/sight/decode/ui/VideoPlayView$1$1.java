package com.tencent.mm.plugin.sight.decode.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;

final class VideoPlayView$1$1
  implements Runnable
{
  VideoPlayView$1$1(VideoPlayView.1 param1, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    y.i("MicroMsg.VideoPlayView", "play time " + this.gFM + " video time " + this.ogw);
    if (this.ogw > 0)
    {
      VideoPlayView.b(this.ogx.ogv, this.ogw);
      if ((VideoPlayView.c(this.ogx.ogv) != null) && (VideoPlayView.h(this.ogx.ogv))) {
        VideoPlayView.i(this.ogx.ogv);
      }
      VideoPlayView.f(this.ogx.ogv).xv(this.ogw);
    }
    if (VideoPlayView.c(this.ogx.ogv) != null)
    {
      if (VideoPlayView.c(this.ogx.ogv).getVideoTotalTime() != this.ogw) {
        VideoPlayView.c(this.ogx.ogv).setVideoTotalTime(this.ogw);
      }
      VideoPlayView.c(this.ogx.ogv).seek(this.gFM);
      VideoPlayView.c(this.ogx.ogv).setIsPlay(true);
    }
    if (VideoPlayView.j(this.ogx.ogv).getVisibility() == 0) {
      VideoPlayView.j(this.ogx.ogv).setVisibility(8);
    }
    VideoPlayView.a(this.ogx.ogv, this.gFM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.1.1
 * JD-Core Version:    0.7.0.1
 */