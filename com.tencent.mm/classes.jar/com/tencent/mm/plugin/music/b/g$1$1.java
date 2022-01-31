package com.tencent.mm.plugin.music.b;

import com.tencent.mm.sdk.platformtools.y;

final class g$1$1
  implements Runnable
{
  g$1$1(g.1 param1, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(this.mxD) });
    if (this.mxE.mxC.startTime != 0)
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(this.mxE.mxC.startTime) });
      this.mxE.mxC.startTime = 0;
      g.1.a(this.mxE);
    }
    g.1 local1;
    do
    {
      return;
      local1 = this.mxE;
      y.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
      local1.mxC.bms();
    } while (!local1.mxC.Pu());
    y.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
    local1.mxC.bmp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g.1.1
 * JD-Core Version:    0.7.0.1
 */