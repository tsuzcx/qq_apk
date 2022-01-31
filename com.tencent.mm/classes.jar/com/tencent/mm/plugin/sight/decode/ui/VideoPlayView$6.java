package com.tencent.mm.plugin.sight.decode.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ak;

public final class VideoPlayView$6
  implements View.OnClickListener
{
  public VideoPlayView$6(VideoPlayView paramVideoPlayView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70321);
    VideoPlayView.l(this.qUK).removeCallbacks(VideoPlayView.n(this.qUK));
    VideoPlayView.l(this.qUK).postDelayed(VideoPlayView.n(this.qUK), 3000L);
    if (VideoPlayView.a(this.qUK).isPlaying())
    {
      VideoPlayView.o(this.qUK);
      if (VideoPlayView.c(this.qUK) != null)
      {
        VideoPlayView.c(this.qUK).setIsPlay(false);
        AppMethodBeat.o(70321);
      }
    }
    else
    {
      VideoPlayView.a(this.qUK, false);
      VideoPlayView.a(this.qUK).A(VideoPlayView.g(this.qUK));
      if (VideoPlayView.c(this.qUK) != null) {
        VideoPlayView.c(this.qUK).setIsPlay(true);
      }
    }
    AppMethodBeat.o(70321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6
 * JD-Core Version:    0.7.0.1
 */