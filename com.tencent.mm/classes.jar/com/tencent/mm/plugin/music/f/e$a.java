package com.tencent.mm.plugin.music.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$a
  implements Runnable
{
  boolean isStop = true;
  
  private e$a(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(137610);
    ab.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
    for (;;)
    {
      if (!this.isStop) {
        try
        {
          if ((this.paR.oXm != null) && (this.paR.aiw())) {
            this.paR.bUJ();
          }
          try
          {
            Thread.sleep(200L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + localException.getMessage());
          }
        }
      }
    }
    AppMethodBeat.o(137610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e.a
 * JD-Core Version:    0.7.0.1
 */