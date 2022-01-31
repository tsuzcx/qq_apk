package com.tencent.mm.plugin.sight.decode.a;

import android.view.Surface;
import android.view.View;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class b$b
  implements Runnable
{
  b.c ofd;
  volatile boolean stop = false;
  
  private b$b(b paramb) {}
  
  public final void run()
  {
    if ((b.q(this.oeY) != null) && (b.q(this.oeY).bBi() != null) && (b.q(this.oeY).bBi().getVisibility() == 0)) {
      b.g(this.oeY).post(new b.b.1(this));
    }
    if (b.e(this.oeY) < 0)
    {
      y.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()), b.a(this.oeY) });
      return;
    }
    if (this.stop)
    {
      y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()) });
      return;
    }
    if (b.r(this.oeY) == 0L)
    {
      if (b.s(this.oeY) != null)
      {
        b.s(this.oeY).type = 1;
        b.s(this.oeY).run();
      }
      b.a(this.oeY, System.currentTimeMillis());
    }
    int j = 0;
    int i = j;
    if (b.t(this.oeY) != -1.0D)
    {
      if (this.oeY.oeL) {
        break label600;
      }
      i = j;
      if (SightVideoJNI.seekStream(b.t(this.oeY), b.e(this.oeY)) > 0)
      {
        if (b.s(this.oeY) == null) {
          b.a(this.oeY, new b.i(this.oeY, (byte)0));
        }
        b.s(this.oeY).type = 4;
        b.s(this.oeY).oeR = b.t(this.oeY);
        b.s(this.oeY).run();
        i = 1;
      }
    }
    float f3 = (float)(System.currentTimeMillis() - b.r(this.oeY));
    float f1;
    label360:
    float f2;
    double d;
    if (i != 0)
    {
      f1 = 0.0F;
      f2 = f1;
      if (this.oeY.oeL)
      {
        f2 = f1;
        if (b.u(this.oeY))
        {
          b.a(this.oeY, false);
          f2 = f1;
          if (b.s(this.oeY) != null)
          {
            d = b.s(this.oeY).bBk() / 1000.0D;
            f2 = f1;
            if (SightVideoJNI.seekStream(d, b.e(this.oeY)) > 0)
            {
              f2 = 0.0F;
              y.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
            }
          }
        }
      }
      if (b.v(this.oeY)) {
        y.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(b.e(this.oeY)), Float.valueOf(f3), Float.valueOf(f2) });
      }
      b.a(this.oeY, System.currentTimeMillis());
      if (f2 < 2.0F) {
        break label793;
      }
      b.w(this.oeY);
    }
    for (;;)
    {
      if (!b.c(this.oeY)) {
        break label817;
      }
      y.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.x(this.oeY)) });
      this.oeY.clear();
      return;
      label600:
      if (b.s(this.oeY) != null)
      {
        b.s(this.oeY).type = 4;
        b.s(this.oeY).oeR = b.t(this.oeY);
        b.s(this.oeY).run();
        b.g(this.oeY).postDelayed(new b.b.2(this), 100L);
        i = j;
        break;
      }
      i = j;
      if (SightVideoJNI.seekStream(b.t(this.oeY), b.e(this.oeY)) <= 0) {
        break;
      }
      if (b.s(this.oeY) == null) {
        b.a(this.oeY, new b.i(this.oeY, (byte)0));
      }
      b.s(this.oeY).type = 4;
      b.s(this.oeY).oeR = b.t(this.oeY);
      b.s(this.oeY).run();
      i = 1;
      break;
      f1 = f3 / this.oeY.oes + 0.5F;
      break label360;
      label793:
      b.c(this.oeY, Math.max(0, b.x(this.oeY) - 1));
    }
    label817:
    int k = 0;
    j = 0;
    int m = 0;
    if (1 == b.d(this.oeY)) {
      if ((b.m(this.oeY) != null) && (!b.m(this.oeY).isValid()))
      {
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()) });
        this.stop = true;
        if (this.ofd == null) {
          break label1376;
        }
        this.ofd.stop = true;
        i = 0;
        j = m;
        label921:
        if (b.s(this.oeY) == null) {
          break label2123;
        }
        y.d("MicroMsg.SightPlayController", "voice time is" + b.s(this.oeY).bBk() / 1000.0D);
      }
    }
    label1705:
    label2123:
    for (;;)
    {
      if (1 == j) {
        b.g(this.oeY).post(new b.b.4(this));
      }
      if (this.stop)
      {
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()) });
        if (b.s(this.oeY) == null) {
          break;
        }
        b.s(this.oeY).type = 0;
        b.s(this.oeY).run();
        return;
        i = SightVideoJNI.drawSurfaceFrame(b.e(this.oeY), b.m(this.oeY), (int)f2, b.o(this.oeY), b.y(this.oeY));
        if (b.z(this.oeY) != null)
        {
          d = SightVideoJNI.getVideoPlayTime(b.e(this.oeY));
          j = (int)d;
          if (j != (int)this.oeY.oeO) {
            b.z(this.oeY).b(this.oeY, j);
          }
          this.oeY.oeO = d;
        }
        if (i == 0)
        {
          b.a(this.oeY, -1.0D);
          k = 0;
          j = i;
          i = k;
          break label921;
        }
        if (1 == i)
        {
          b.a(this.oeY, -1.0D);
          k = 1;
          b.a(this.oeY, 0L);
          b.A(this.oeY);
          j = i;
          i = k;
          break label921;
        }
        if (-7 == i)
        {
          y.w("MicroMsg.SightPlayController", "surface is null, continue");
          k = 0;
          j = i;
          i = k;
          break label921;
        }
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
        this.stop = true;
        if (this.ofd != null) {
          this.ofd.stop = true;
        }
        this.oeY.F(null);
        j = i;
        if (b.b(this.oeY) != null)
        {
          b.b(this.oeY).d(this.oeY, -1);
          j = i;
        }
        label1376:
        i = 0;
        break label921;
        m = SightVideoJNI.drawFrame(b.e(this.oeY), b.B(this.oeY), (int)f2, null, false, b.y(this.oeY));
        if (b.z(this.oeY) != null)
        {
          d = SightVideoJNI.getVideoPlayTime(b.e(this.oeY));
          i = (int)d;
          if (i != (int)this.oeY.oeO) {
            b.z(this.oeY).b(this.oeY, i);
          }
          this.oeY.oeO = d;
          if (b.v(this.oeY)) {
            y.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
          }
        }
        for (;;)
        {
          if (m != 0) {
            break label1705;
          }
          b.a(this.oeY, -1.0D);
          j = m;
          i = k;
          break;
          if (b.v(this.oeY))
          {
            d = SightVideoJNI.getVideoPlayTime(b.e(this.oeY));
            if (b.v(this.oeY)) {
              y.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          else if (b.v(this.oeY))
          {
            y.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          }
        }
        if (1 == m)
        {
          b.a(this.oeY, -1.0D);
          i = 1;
          b.a(this.oeY, 0L);
          b.A(this.oeY);
          j = m;
          continue;
        }
        b.a(this.oeY, -1.0D);
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
        this.stop = true;
        if (this.ofd != null) {
          this.ofd.stop = true;
        }
        b.g(this.oeY).post(new Runnable()
        {
          public final void run()
          {
            b.b.this.oeY.G(null);
          }
        });
        j = m;
        i = k;
        if (b.b(this.oeY) == null) {
          continue;
        }
        b.b(this.oeY).d(this.oeY, -1);
        j = m;
        i = k;
        continue;
      }
      long l;
      if (1 == b.d(this.oeY))
      {
        l = this.oeY.oes - (System.currentTimeMillis() - b.r(this.oeY));
        if (b.r(this.oeY) == 0L) {
          o.g(this, this.oeY.oes * 5);
        }
      }
      while (b.s(this.oeY) != null)
      {
        y.d("MicroMsg.SightPlayController", "voice time is" + b.s(this.oeY).bBk() / 1000.0D);
        return;
        if (l > 0L)
        {
          o.g(this, l);
        }
        else
        {
          o.g(this, 0L);
          continue;
          if ((i != 0) && (b.q(this.oeY) != null))
          {
            i = b.q(this.oeY).bBh();
            b.g(this.oeY).post(new b.b.5(this));
            this.ofd.ofg = j;
            b.g(this.oeY).postDelayed(this.ofd, i);
          }
          else
          {
            this.ofd.ofg = j;
            b.g(this.oeY).post(this.ofd);
          }
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.b
 * JD-Core Version:    0.7.0.1
 */