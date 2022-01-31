package com.tencent.ttpic.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PlayerUtil$1
  implements MediaPlayer.OnCompletionListener
{
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(50271);
    PlayerUtil.Player.access$002((PlayerUtil.Player)paramMediaPlayer, false);
    AppMethodBeat.o(50271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.PlayerUtil.1
 * JD-Core Version:    0.7.0.1
 */