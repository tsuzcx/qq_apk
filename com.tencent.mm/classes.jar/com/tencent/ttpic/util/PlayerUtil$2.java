package com.tencent.ttpic.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PlayerUtil$2
  implements MediaPlayer.OnErrorListener
{
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50272);
    PlayerUtil.destroyPlayer((PlayerUtil.Player)paramMediaPlayer);
    AppMethodBeat.o(50272);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.PlayerUtil.2
 * JD-Core Version:    0.7.0.1
 */