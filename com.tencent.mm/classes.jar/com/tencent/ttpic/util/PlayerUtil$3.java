package com.tencent.ttpic.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PlayerUtil$3
  implements MediaPlayer.OnSeekCompleteListener
{
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(50273);
    ((PlayerUtil.Player)paramMediaPlayer).start();
    AppMethodBeat.o(50273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.PlayerUtil.3
 * JD-Core Version:    0.7.0.1
 */