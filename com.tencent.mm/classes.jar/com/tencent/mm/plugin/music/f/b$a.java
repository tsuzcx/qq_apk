package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import com.tencent.mm.sdk.platformtools.y;

final class b$a
  implements Runnable
{
  boolean isStop = true;
  
  private b$a(b paramb) {}
  
  public final void run()
  {
    y.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
    for (;;)
    {
      if (this.isStop) {
        return;
      }
      try
      {
        if ((this.mAy.eLh != null) && (this.mAy.eLh.isPlaying()))
        {
          int i = this.mAy.eLh.getCurrentPosition();
          int j = this.mAy.eLh.getDuration();
          if ((i > 0) && (j > 0))
          {
            i = i * 100 / j;
            this.mAy.uU(i);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "onPlayUpdate", new Object[0]);
        }
      }
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException localInterruptedException)
      {
        y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localInterruptedException, "sleep", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.a
 * JD-Core Version:    0.7.0.1
 */