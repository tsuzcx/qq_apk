package com.tencent.mm.plugin.voip.model;

import java.util.Timer;
import java.util.TimerTask;

final class j$5
  extends TimerTask
{
  j$5(j paramj) {}
  
  public final void run()
  {
    j.d(this.pQy);
    if ((this.pQy.pQe.pVW != 0) || (j.e(this.pQy) > 10))
    {
      j.f(this.pQy);
      j.g(this.pQy).cancel();
      j.h(this.pQy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j.5
 * JD-Core Version:    0.7.0.1
 */