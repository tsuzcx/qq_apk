package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.TimerTask;

final class c$a
  extends TimerTask
{
  c$a(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(4322);
    System.currentTimeMillis();
    if ((c.a(this.ttT) == 1) && (this.ttT.ttj == true))
    {
      System.currentTimeMillis();
      if ((c.b(this.ttT) + this.ttT.gam < c.c(this.ttT)) && (c.d(this.ttT) == 0))
      {
        c.a(this.ttT, 1);
        int i = this.ttT.ttu.M(c.e(this.ttT), this.ttT.gam);
        c.a(this.ttT, 0);
        if (i < 0)
        {
          ab.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
          AppMethodBeat.o(4322);
          return;
        }
        synchronized (c.f(this.ttT))
        {
          System.arraycopy(c.e(this.ttT), 0, c.g(this.ttT), c.b(this.ttT), this.ttT.gam);
          c.b(this.ttT, c.b(this.ttT) + this.ttT.gam);
          c.c(this.ttT, c.h(this.ttT) + (this.ttT.gam >> 1));
          AppMethodBeat.o(4322);
          return;
        }
      }
    }
    AppMethodBeat.o(4322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c.a
 * JD-Core Version:    0.7.0.1
 */