package com.tencent.mm.plugin.music.b;

import com.tencent.mm.sdk.platformtools.y;

final class g$a
  implements Runnable
{
  boolean isStop = true;
  
  private g$a(g paramg) {}
  
  public final void run()
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
    for (;;)
    {
      if (!this.isStop) {
        try
        {
          if ((this.mxC.mxp != null) && (this.mxC.Pu())) {
            this.mxC.bmC();
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
            y.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + localException.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g.a
 * JD-Core Version:    0.7.0.1
 */