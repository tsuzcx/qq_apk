package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements MediaPlayer.OnPreparedListener
{
  d$1(d paramd, a.b paramb) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(3745);
    this.oNh.bW(paramMediaPlayer);
    AppMethodBeat.o(3745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.d.1
 * JD-Core Version:    0.7.0.1
 */