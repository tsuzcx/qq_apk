package com.tencent.mm.plugin.subapp.c;

import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class j$2
  implements Runnable
{
  j$2(j paramj) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - j.j(this.pvX);
    y.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.e(this.pvX) + " timeWait:" + l + " sending:" + j.g(this.pvX) + " recving:" + j.f(this.pvX));
    if (j.e(this.pvX))
    {
      if (l < 60000L) {
        return;
      }
      y.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.e(this.pvX) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + j.g(this.pvX) + " recving:" + j.f(this.pvX));
    }
    j.k(this.pvX);
    j.b(this.pvX);
    j.a(this.pvX, 3);
    j.a(this.pvX);
    this.pvX.bEc.dzS = SystemClock.elapsedRealtime();
    j.l(this.pvX).S(10L, 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j.2
 * JD-Core Version:    0.7.0.1
 */