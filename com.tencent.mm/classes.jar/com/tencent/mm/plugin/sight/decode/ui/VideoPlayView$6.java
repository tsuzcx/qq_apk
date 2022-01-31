package com.tencent.mm.plugin.sight.decode.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ah;

public final class VideoPlayView$6
  implements View.OnClickListener
{
  public VideoPlayView$6(VideoPlayView paramVideoPlayView) {}
  
  public final void onClick(View paramView)
  {
    VideoPlayView.l(this.ogv).removeCallbacks(VideoPlayView.n(this.ogv));
    VideoPlayView.l(this.ogv).postDelayed(VideoPlayView.n(this.ogv), 3000L);
    if (VideoPlayView.a(this.ogv).isPlaying())
    {
      VideoPlayView.o(this.ogv);
      if (VideoPlayView.c(this.ogv) != null) {
        VideoPlayView.c(this.ogv).setIsPlay(false);
      }
    }
    do
    {
      return;
      VideoPlayView.a(this.ogv, false);
      VideoPlayView.a(this.ogv).x(VideoPlayView.g(this.ogv));
    } while (VideoPlayView.c(this.ogv) == null);
    VideoPlayView.c(this.ogv).setIsPlay(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6
 * JD-Core Version:    0.7.0.1
 */