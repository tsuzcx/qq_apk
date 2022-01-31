package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class i$6
  implements MediaPlayer.OnErrorListener
{
  i$6(i parami) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.release();
      this.qbG.qbC = 5;
      y.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramMediaPlayer, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i.6
 * JD-Core Version:    0.7.0.1
 */