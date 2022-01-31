package com.tencent.mm.plugin.voip.model;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(4321);
    Process.setThreadPriority(-19);
    ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
    int j = 0;
    while ((this.ttT.ttj) && (this.ttT.ayN != null))
    {
      int i;
      long l;
      try
      {
        i = this.ttT.ayN.getPlaybackHeadPosition();
        l = System.currentTimeMillis();
        c.d(this.ttT, c.j(this.ttT) - i);
        if (c.k(this.ttT) == 1)
        {
          c.e(this.ttT, i);
          c.a(this.ttT, l);
          c.b(this.ttT, l);
          c.l(this.ttT);
          c.c(this.ttT, l);
          if ((i != 0) && (this.ttT.ttl)) {
            c.t(this.ttT);
          }
          if (this.ttT.ttu == null) {
            break label1223;
          }
          c.h(this.ttT, c.u(this.ttT) + this.ttT.gam);
          if (c.a(this.ttT) != 0) {
            break label570;
          }
          i = this.ttT.ttu.M(c.v(this.ttT), this.ttT.gam);
          if (i >= 0) {
            break label824;
          }
          a.HJ(5);
          ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[] { localException });
          c.i(this.ttT);
          i = 0;
          continue;
          int k = i - c.m(this.ttT);
          if (k > c.n(this.ttT))
          {
            c.f(this.ttT, k);
            label309:
            c.c(this.ttT, l);
            if (c.o(this.ttT) != 0) {
              break label464;
            }
            c.g(this.ttT, c.p(this.ttT) + c.q(this.ttT));
          }
          for (;;)
          {
            if (c.p(this.ttT) < c.s(this.ttT)) {
              c.g(this.ttT, c.s(this.ttT));
            }
            if (c.p(this.ttT) < c.q(this.ttT)) {
              c.g(this.ttT, c.q(this.ttT));
            }
            if (k <= 0) {
              break;
            }
            c.e(this.ttT, i);
            break;
            c.f(this.ttT, (int)(c.n(this.ttT) * 49999.0F / 50000.0F + k / 50000.0F));
            break label309;
            label464:
            if (l > c.r(this.ttT) + 5000L)
            {
              c.b(this.ttT, l);
              if (c.n(this.ttT) < c.p(this.ttT) >> 1) {
                c.g(this.ttT, c.p(this.ttT) - (c.q(this.ttT) >> 2));
              }
              if (c.n(this.ttT) > c.p(this.ttT)) {
                c.g(this.ttT, c.n(this.ttT));
              }
            }
          }
          label570:
          System.currentTimeMillis();
          if (c.b(this.ttT) >= this.ttT.gam) {
            synchronized (c.f(this.ttT))
            {
              System.arraycopy(c.g(this.ttT), 0, c.v(this.ttT), 0, this.ttT.gam);
              i = c.b(this.ttT) - this.ttT.gam;
              System.arraycopy(c.g(this.ttT), this.ttT.gam, c.w(this.ttT), 0, i);
              System.arraycopy(c.w(this.ttT), 0, c.g(this.ttT), 0, i);
              c.b(this.ttT, c.b(this.ttT) - this.ttT.gam);
              i = 0;
            }
          }
          if ((c.o(this.ttT) >= c.x(this.ttT) * 5 / 1000) || (c.y(this.ttT) != 0)) {
            break;
          }
          c.i(this.ttT, 1);
          i = this.ttT.ttu.M(c.v(this.ttT), this.ttT.gam);
          c.i(this.ttT, 0);
        }
        a.HJ(2);
      }
      continue;
      label824:
      if (c.z(this.ttT))
      {
        ab.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.z(this.ttT));
        a.HJ(10);
      }
      else
      {
        c.a(this.ttT, l);
        if (c.A(this.ttT) >= this.ttT.gam)
        {
          if (!c.z(this.ttT))
          {
            i = this.ttT.ayN.write(c.v(this.ttT), 0, this.ttT.gam);
            if (i < 0)
            {
              c.j(this.ttT, i);
              ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
            }
            c.k(this.ttT, c.j(this.ttT) + (this.ttT.gam >> 1));
          }
        }
        else
        {
          System.arraycopy(c.v(this.ttT), 0, c.B(this.ttT), j, c.A(this.ttT) - j);
          i = this.ttT.ayN.write(c.B(this.ttT), 0, c.B(this.ttT).length);
          if (i < 0)
          {
            c.j(this.ttT, i);
            ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
          }
          c.k(this.ttT, c.j(this.ttT) + (c.B(this.ttT).length >> 1));
          j = c.A(this.ttT) - j;
          i = this.ttT.gam - j;
          while (i >= c.A(this.ttT))
          {
            this.ttT.ayN.write(c.v(this.ttT), j, c.A(this.ttT));
            j += c.A(this.ttT);
            i -= c.A(this.ttT);
            c.k(this.ttT, c.j(this.ttT) + (c.A(this.ttT) >> 1));
          }
          System.arraycopy(c.v(this.ttT), j, c.B(this.ttT), 0, i);
          j = i;
          continue;
          label1223:
          a.HJ(10);
        }
      }
    }
    AppMethodBeat.o(4321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c.1
 * JD-Core Version:    0.7.0.1
 */