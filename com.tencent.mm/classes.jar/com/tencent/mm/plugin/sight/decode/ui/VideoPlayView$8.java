package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;

final class VideoPlayView$8
  implements Runnable
{
  VideoPlayView$8(VideoPlayView paramVideoPlayView) {}
  
  public final void run()
  {
    AppMethodBeat.i(70323);
    if (!VideoPlayView.a(this.qUK).isPlaying()) {
      ((AdVideoPlayerLoadingBar)VideoPlayView.c(this.qUK)).aFy();
    }
    AppMethodBeat.o(70323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.8
 * JD-Core Version:    0.7.0.1
 */