package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.mm.pluginsdk.ui.tools.f;

final class VideoPlayView$8
  implements Runnable
{
  VideoPlayView$8(VideoPlayView paramVideoPlayView) {}
  
  public final void run()
  {
    if (!VideoPlayView.a(this.ogv).isPlaying()) {
      ((AdVideoPlayerLoadingBar)VideoPlayView.c(this.ogv)).akP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.8
 * JD-Core Version:    0.7.0.1
 */