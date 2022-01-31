package com.tencent.mm.plugin.voip.model;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    Process.setThreadPriority(-19);
    y.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
    int j = 0;
    while ((this.pNX.pNn) && (this.pNX.awx != null))
    {
      int i;
      long l;
      try
      {
        i = this.pNX.awx.getPlaybackHeadPosition();
        l = System.currentTimeMillis();
        b.d(this.pNX, b.j(this.pNX) - i);
        if (b.k(this.pNX) == 1)
        {
          b.e(this.pNX, i);
          b.a(this.pNX, l);
          b.b(this.pNX, l);
          b.l(this.pNX);
          b.c(this.pNX, l);
          if ((i != 0) && (this.pNX.pNp)) {
            b.t(this.pNX);
          }
          if (this.pNX.pNy == null) {
            break label1232;
          }
          b.h(this.pNX, b.u(this.pNX) + this.pNX.eKG);
          if (b.a(this.pNX) != 0) {
            break label571;
          }
          i = this.pNX.pNy.L(b.v(this.pNX), this.pNX.eKG);
          if (i >= 0) {
            break label819;
          }
          com.tencent.mm.plugin.voip.a.a.Ar(5);
          y.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + i);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[] { localException });
          b.i(this.pNX);
          i = 0;
          continue;
          int k = i - b.m(this.pNX);
          if (k > b.n(this.pNX))
          {
            b.f(this.pNX, k);
            label310:
            b.c(this.pNX, l);
            if (b.o(this.pNX) != 0) {
              break label465;
            }
            b.g(this.pNX, b.p(this.pNX) + b.q(this.pNX));
          }
          for (;;)
          {
            if (b.p(this.pNX) < b.s(this.pNX)) {
              b.g(this.pNX, b.s(this.pNX));
            }
            if (b.p(this.pNX) < b.q(this.pNX)) {
              b.g(this.pNX, b.q(this.pNX));
            }
            if (k <= 0) {
              break;
            }
            b.e(this.pNX, i);
            break;
            b.f(this.pNX, (int)(b.n(this.pNX) * 49999.0F / 50000.0F + k / 50000.0F));
            break label310;
            label465:
            if (l > b.r(this.pNX) + 5000L)
            {
              b.b(this.pNX, l);
              if (b.n(this.pNX) < b.p(this.pNX) >> 1) {
                b.g(this.pNX, b.p(this.pNX) - (b.q(this.pNX) >> 2));
              }
              if (b.n(this.pNX) > b.p(this.pNX)) {
                b.g(this.pNX, b.n(this.pNX));
              }
            }
          }
          label571:
          System.currentTimeMillis();
          if (b.b(this.pNX) >= this.pNX.eKG) {
            synchronized (b.f(this.pNX))
            {
              System.arraycopy(b.g(this.pNX), 0, b.v(this.pNX), 0, this.pNX.eKG);
              i = b.b(this.pNX) - this.pNX.eKG;
              System.arraycopy(b.g(this.pNX), this.pNX.eKG, b.w(this.pNX), 0, i);
              System.arraycopy(b.w(this.pNX), 0, b.g(this.pNX), 0, i);
              b.b(this.pNX, b.b(this.pNX) - this.pNX.eKG);
              i = 0;
            }
          }
          if ((b.o(this.pNX) >= b.x(this.pNX) * 5 / 1000) || (b.y(this.pNX) != 0)) {
            break;
          }
          b.i(this.pNX, 1);
          i = this.pNX.pNy.L(b.v(this.pNX), this.pNX.eKG);
          b.i(this.pNX, 0);
        }
        com.tencent.mm.plugin.voip.a.a.Ar(2);
      }
      continue;
      label819:
      if (b.z(this.pNX))
      {
        y.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + b.z(this.pNX));
        com.tencent.mm.plugin.voip.a.a.Ar(10);
      }
      else
      {
        b.a(this.pNX, l);
        if (b.A(this.pNX) >= this.pNX.eKG)
        {
          if (!b.z(this.pNX))
          {
            i = this.pNX.awx.write(b.v(this.pNX), 0, this.pNX.eKG);
            if (i < 0)
            {
              b.j(this.pNX, i);
              y.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + i);
            }
            b.k(this.pNX, b.j(this.pNX) + (this.pNX.eKG >> 1));
          }
        }
        else
        {
          System.arraycopy(b.v(this.pNX), 0, b.B(this.pNX), j, b.A(this.pNX) - j);
          i = this.pNX.awx.write(b.B(this.pNX), 0, b.B(this.pNX).length);
          if (i < 0)
          {
            b.j(this.pNX, i);
            y.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + i);
          }
          b.k(this.pNX, b.j(this.pNX) + (b.B(this.pNX).length >> 1));
          j = b.A(this.pNX) - j;
          i = this.pNX.eKG - j;
          while (i >= b.A(this.pNX))
          {
            this.pNX.awx.write(b.v(this.pNX), j, b.A(this.pNX));
            j += b.A(this.pNX);
            i -= b.A(this.pNX);
            b.k(this.pNX, b.j(this.pNX) + (b.A(this.pNX) >> 1));
          }
          System.arraycopy(b.v(this.pNX), j, b.B(this.pNX), 0, i);
          j = i;
          continue;
          label1232:
          com.tencent.mm.plugin.voip.a.a.Ar(10);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.b.1
 * JD-Core Version:    0.7.0.1
 */