package com.tencent.mm.pluginsdk.model.app;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class ao$a$3
  implements Runnable
{
  ao$a$3(ao.a parama) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - ao.a.k(this.rVh);
    y.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + ao.a.f(this.rVh) + " timeWait:" + l + " sending:" + ao.a.h(this.rVh) + " recving:" + ao.a.g(this.rVh));
    if (ao.a.f(this.rVh))
    {
      if (l < 180000L) {
        return;
      }
      y.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + ao.a.f(this.rVh) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + ao.a.h(this.rVh) + " recving:" + ao.a.g(this.rVh));
    }
    ao.a.l(this.rVh);
    ao.a.b(this.rVh);
    ao.a.m(this.rVh);
    ao.a.a(this.rVh);
    this.rVh.bEc.dzS = SystemClock.elapsedRealtime();
    ao.a.n(this.rVh).S(10L, 10L);
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao.a.3
 * JD-Core Version:    0.7.0.1
 */