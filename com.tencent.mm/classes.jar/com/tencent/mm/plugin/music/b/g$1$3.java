package com.tencent.mm.plugin.music.b;

import com.tencent.mm.sdk.platformtools.y;

final class g$1$3
  implements Runnable
{
  g$1$3(g.1 param1, int paramInt) {}
  
  public final void run()
  {
    String str = this.mxE.mxC.bFM;
    y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(this.fH), str });
    if (this.fH == 3)
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
      g.1.b(this.mxE);
      this.mxE.mxC.mxz = System.currentTimeMillis();
    }
    do
    {
      return;
      if (this.fH == 2)
      {
        y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
        y.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - this.mxE.mxC.mxz) });
        g.1.a(this.mxE);
        return;
      }
      if (this.fH == 4)
      {
        y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
        y.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - this.mxE.mxC.mxz) });
        g.1.c(this.mxE);
        return;
      }
      if (this.fH == 5)
      {
        y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
        g.1.d(this.mxE);
        return;
      }
      if (this.fH == 6)
      {
        y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
        g.1.e(this.mxE);
        return;
      }
      if (this.fH == 7)
      {
        y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
        g.1.f(this.mxE);
        return;
      }
      if (this.fH == 8)
      {
        y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
        g.1.bmD();
        return;
      }
    } while (this.fH != 9);
    y.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g.1.3
 * JD-Core Version:    0.7.0.1
 */