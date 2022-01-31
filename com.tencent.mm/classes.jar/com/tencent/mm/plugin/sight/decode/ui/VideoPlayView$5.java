package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class VideoPlayView$5
  implements b
{
  public VideoPlayView$5(VideoPlayView paramVideoPlayView) {}
  
  public final void aFf()
  {
    AppMethodBeat.i(70319);
    VideoPlayView.l(this.qUK).removeCallbacks(VideoPlayView.n(this.qUK));
    VideoPlayView.d(this.qUK);
    AppMethodBeat.o(70319);
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(70320);
    ab.i("MicroMsg.VideoPlayView", "onSeek time ".concat(String.valueOf(paramInt)));
    VideoPlayView.a(this.qUK, paramInt);
    VideoPlayView.a(this.qUK).A(paramInt);
    VideoPlayView.l(this.qUK).removeCallbacks(VideoPlayView.n(this.qUK));
    VideoPlayView.l(this.qUK).postDelayed(VideoPlayView.n(this.qUK), 3000L);
    AppMethodBeat.o(70320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5
 * JD-Core Version:    0.7.0.1
 */