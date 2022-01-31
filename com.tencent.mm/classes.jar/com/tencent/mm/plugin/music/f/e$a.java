package com.tencent.mm.plugin.music.f;

import com.tencent.mm.sdk.platformtools.y;

final class e$a
  implements Runnable
{
  boolean isStop = true;
  
  private e$a(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
    for (;;)
    {
      if (!this.isStop) {
        try
        {
          if ((this.mAN.mxp != null) && (this.mAN.Pu())) {
            this.mAN.bmC();
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
            y.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + localException.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e.a
 * JD-Core Version:    0.7.0.1
 */