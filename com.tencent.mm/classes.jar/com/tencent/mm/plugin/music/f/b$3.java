package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements MediaPlayer.OnPreparedListener
{
  b$3(b paramb) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.mAy.eLh != null) {
      y.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
    }
    try
    {
      this.mAy.eLh.start();
      this.mAy.stop = false;
      this.mAy.onStart();
      if (this.mAy.mAx != null) {
        this.mAy.mAx.isStop = true;
      }
      this.mAy.mAx = new b.a(this.mAy, (byte)0);
      paramMediaPlayer = this.mAy.mAx;
      paramMediaPlayer.isStop = false;
      e.post(paramMediaPlayer, "music_play_progress_runnable");
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramMediaPlayer, "start", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.3
 * JD-Core Version:    0.7.0.1
 */