package com.tencent.ttpic.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

final class AudioUtils$3
  implements MediaPlayer.OnSeekCompleteListener
{
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    ((AudioUtils.Player)paramMediaPlayer).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtils.3
 * JD-Core Version:    0.7.0.1
 */