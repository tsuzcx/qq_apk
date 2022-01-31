package com.tencent.mm.plugin.sight.decode.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoPlayView$1$1
  implements Runnable
{
  VideoPlayView$1$1(VideoPlayView.1 param1, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(70309);
    ab.i("MicroMsg.VideoPlayView", "play time " + this.ieP + " video time " + this.qUL);
    if (this.qUL > 0)
    {
      VideoPlayView.b(this.qUM.qUK, this.qUL);
      if ((VideoPlayView.c(this.qUM.qUK) != null) && (VideoPlayView.h(this.qUM.qUK))) {
        VideoPlayView.i(this.qUM.qUK);
      }
      VideoPlayView.f(this.qUM.qUK).Dv(this.qUL);
    }
    if (VideoPlayView.c(this.qUM.qUK) != null)
    {
      if (VideoPlayView.c(this.qUM.qUK).getVideoTotalTime() != this.qUL) {
        VideoPlayView.c(this.qUM.qUK).setVideoTotalTime(this.qUL);
      }
      VideoPlayView.c(this.qUM.qUK).seek(this.ieP);
      VideoPlayView.c(this.qUM.qUK).setIsPlay(true);
    }
    if (VideoPlayView.j(this.qUM.qUK).getVisibility() == 0) {
      VideoPlayView.j(this.qUM.qUK).setVisibility(8);
    }
    VideoPlayView.a(this.qUM.qUK, this.ieP);
    AppMethodBeat.o(70309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.1.1
 * JD-Core Version:    0.7.0.1
 */