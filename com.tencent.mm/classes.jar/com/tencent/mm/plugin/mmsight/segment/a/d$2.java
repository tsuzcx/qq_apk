package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  implements MediaPlayer.OnSeekCompleteListener
{
  d$2(d paramd, a.c paramc) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(3746);
    this.oNj.bX(paramMediaPlayer);
    AppMethodBeat.o(3746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.d.2
 * JD-Core Version:    0.7.0.1
 */