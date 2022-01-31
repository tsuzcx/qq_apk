package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$a
  implements Runnable
{
  boolean isStop = true;
  
  private h$a(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(137363);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
    for (;;)
    {
      if (!this.isStop) {
        try
        {
          if ((this.oXy.oXm != null) && (this.oXy.aiw())) {
            this.oXy.bUJ();
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
            ab.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + localException.getMessage());
          }
        }
      }
    }
    AppMethodBeat.o(137363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h.a
 * JD-Core Version:    0.7.0.1
 */