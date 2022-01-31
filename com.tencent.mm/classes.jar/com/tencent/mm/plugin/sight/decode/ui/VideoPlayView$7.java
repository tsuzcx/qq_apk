package com.tencent.mm.plugin.sight.decode.ui;

final class VideoPlayView$7
  implements Runnable
{
  VideoPlayView$7(VideoPlayView paramVideoPlayView) {}
  
  public final void run()
  {
    if (VideoPlayView.c(this.ogv) != null) {
      VideoPlayView.c(this.ogv).setIsPlay(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.7
 * JD-Core Version:    0.7.0.1
 */