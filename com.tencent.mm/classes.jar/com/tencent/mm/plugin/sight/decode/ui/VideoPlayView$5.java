package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class VideoPlayView$5
  implements b
{
  public VideoPlayView$5(VideoPlayView paramVideoPlayView) {}
  
  public final void akz()
  {
    VideoPlayView.l(this.ogv).removeCallbacks(VideoPlayView.n(this.ogv));
    VideoPlayView.d(this.ogv);
  }
  
  public final void lE(int paramInt)
  {
    y.i("MicroMsg.VideoPlayView", "onSeek time " + paramInt);
    VideoPlayView.a(this.ogv, paramInt);
    VideoPlayView.a(this.ogv).x(paramInt);
    VideoPlayView.l(this.ogv).removeCallbacks(VideoPlayView.n(this.ogv));
    VideoPlayView.l(this.ogv).postDelayed(VideoPlayView.n(this.ogv), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5
 * JD-Core Version:    0.7.0.1
 */