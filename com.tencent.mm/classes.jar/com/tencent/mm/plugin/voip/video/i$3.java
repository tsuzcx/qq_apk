package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.ah;

final class i$3
  implements MediaPlayer.OnCompletionListener
{
  i$3(i parami, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (System.currentTimeMillis() - this.qbG.qbD > 70000L) {
      this.qbG.qbC = 4;
    }
    if (this.qbG.bus)
    {
      this.qbG.qbF = new i.a(this.qbG, this.qbH, this.qbI, this.qbJ, this.qbK);
      this.qbG.dPi.postDelayed(this.qbG.qbF, this.qbI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i.3
 * JD-Core Version:    0.7.0.1
 */