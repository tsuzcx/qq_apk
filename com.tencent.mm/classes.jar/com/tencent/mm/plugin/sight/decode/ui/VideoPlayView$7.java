package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoPlayView$7
  implements Runnable
{
  VideoPlayView$7(VideoPlayView paramVideoPlayView) {}
  
  public final void run()
  {
    AppMethodBeat.i(70322);
    if (VideoPlayView.c(this.qUK) != null) {
      VideoPlayView.c(this.qUK).setIsPlay(false);
    }
    AppMethodBeat.o(70322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.7
 * JD-Core Version:    0.7.0.1
 */