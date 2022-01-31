package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements MediaPlayer.OnVideoSizeChangedListener
{
  d$3(d paramd, a.d paramd1) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3747);
    this.oNk.Z(paramInt1, paramInt2, 0);
    AppMethodBeat.o(3747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.d.3
 * JD-Core Version:    0.7.0.1
 */