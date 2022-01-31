package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class i$1
  implements MediaPlayer.OnCompletionListener
{
  i$1(i parami) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (System.currentTimeMillis() - this.qbG.qbD > 70000L) {
      this.qbG.qbC = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i.1
 * JD-Core Version:    0.7.0.1
 */