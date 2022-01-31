package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements MediaPlayer.OnCompletionListener
{
  h$1(h paramh) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(5092);
    if (System.currentTimeMillis() - this.tHs.tHp > 70000L) {
      this.tHs.tHo = 4;
    }
    AppMethodBeat.o(5092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.h.1
 * JD-Core Version:    0.7.0.1
 */