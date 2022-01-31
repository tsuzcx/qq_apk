package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a
  implements Runnable
{
  boolean isStop = true;
  
  private b$a(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(137552);
    ab.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
    for (;;)
    {
      if (this.isStop) {
        break label128;
      }
      try
      {
        if ((this.paE.gaO != null) && (this.paE.gaO.isPlaying()))
        {
          int i = this.paE.gaO.getCurrentPosition();
          int j = this.paE.gaO.getDuration();
          if ((i > 0) && (j > 0))
          {
            i = i * 100 / j;
            this.paE.Av(i);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "onPlayUpdate", new Object[0]);
        }
      }
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localInterruptedException, "sleep", new Object[0]);
      }
    }
    label128:
    AppMethodBeat.o(137552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.a
 * JD-Core Version:    0.7.0.1
 */