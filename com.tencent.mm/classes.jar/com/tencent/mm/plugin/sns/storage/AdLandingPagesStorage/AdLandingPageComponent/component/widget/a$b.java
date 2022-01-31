package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.Surface;
import android.view.View;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class a$b
  implements Runnable
{
  a.c oIB;
  volatile boolean stop = false;
  
  private a$b(a parama) {}
  
  public final void run()
  {
    if ((a.q(this.oIA) != null) && (a.q(this.oIA).bBi() != null) && (a.q(this.oIA).bBi().getVisibility() == 0)) {
      a.g(this.oIA).post(new Runnable()
      {
        public final void run()
        {
          a.q(a.b.this.oIA).bBi().setVisibility(8);
        }
      });
    }
    if (a.e(this.oIA) < 0)
    {
      y.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()), a.a(this.oIA) });
      return;
    }
    if (this.stop)
    {
      y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()) });
      return;
    }
    if (a.r(this.oIA) == 0L)
    {
      if (a.s(this.oIA) != null)
      {
        a.s(this.oIA).type = 1;
        a.s(this.oIA).run();
      }
      a.a(this.oIA, System.currentTimeMillis());
    }
    int j = 0;
    int i = j;
    if (a.t(this.oIA) != -1.0D)
    {
      if (this.oIA.oeL) {
        break label600;
      }
      i = j;
      if (SightVideoJNI.seekStream(a.t(this.oIA), a.e(this.oIA)) > 0)
      {
        if (a.s(this.oIA) == null) {
          a.a(this.oIA, new a.i(this.oIA, (byte)0));
        }
        a.s(this.oIA).type = 4;
        a.s(this.oIA).oeR = a.t(this.oIA);
        a.s(this.oIA).run();
        i = 1;
      }
    }
    float f3 = (float)(System.currentTimeMillis() - a.r(this.oIA));
    float f1;
    label360:
    float f2;
    double d;
    if (i != 0)
    {
      f1 = 0.0F;
      f2 = f1;
      if (this.oIA.oeL)
      {
        f2 = f1;
        if (a.u(this.oIA))
        {
          a.a(this.oIA, false);
          f2 = f1;
          if (a.s(this.oIA) != null)
          {
            d = a.s(this.oIA).bBk() / 1000.0D;
            f2 = f1;
            if (SightVideoJNI.seekStream(d, a.e(this.oIA)) > 0)
            {
              f2 = 0.0F;
              y.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
            }
          }
        }
      }
      if (a.v(this.oIA)) {
        y.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(a.e(this.oIA)), Float.valueOf(f3), Float.valueOf(f2) });
      }
      a.a(this.oIA, System.currentTimeMillis());
      if (f2 < 2.0F) {
        break label793;
      }
      a.w(this.oIA);
    }
    for (;;)
    {
      if (!a.c(this.oIA)) {
        break label817;
      }
      y.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(a.x(this.oIA)) });
      this.oIA.clear();
      return;
      label600:
      if (a.s(this.oIA) != null)
      {
        a.s(this.oIA).type = 4;
        a.s(this.oIA).oeR = a.t(this.oIA);
        a.s(this.oIA).run();
        a.g(this.oIA).postDelayed(new a.b.2(this), 100L);
        i = j;
        break;
      }
      i = j;
      if (SightVideoJNI.seekStream(a.t(this.oIA), a.e(this.oIA)) <= 0) {
        break;
      }
      if (a.s(this.oIA) == null) {
        a.a(this.oIA, new a.i(this.oIA, (byte)0));
      }
      a.s(this.oIA).type = 4;
      a.s(this.oIA).oeR = a.t(this.oIA);
      a.s(this.oIA).run();
      i = 1;
      break;
      f1 = f3 / this.oIA.oes + 0.5F;
      break label360;
      label793:
      a.c(this.oIA, Math.max(0, a.x(this.oIA) - 1));
    }
    label817:
    int k = 0;
    j = 0;
    int m = 0;
    if (1 == a.d(this.oIA)) {
      if ((a.m(this.oIA) != null) && (!a.m(this.oIA).isValid()))
      {
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()) });
        this.stop = true;
        if (this.oIB == null) {
          break label1367;
        }
        this.oIB.stop = true;
        i = 0;
        j = m;
        label921:
        if (a.s(this.oIA) == null) {
          break label2106;
        }
        y.d("MicroMsg.SightPlayController", "voice time is" + a.s(this.oIA).bBk() / 1000.0D);
      }
    }
    label1692:
    label2106:
    for (;;)
    {
      if (1 == j) {
        a.g(this.oIA).post(new a.b.4(this));
      }
      if (this.stop)
      {
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()) });
        if (a.s(this.oIA) == null) {
          break;
        }
        a.s(this.oIA).type = 0;
        a.s(this.oIA).run();
        return;
        i = SightVideoJNI.drawSurfaceFrame(a.e(this.oIA), a.m(this.oIA), (int)f2, a.o(this.oIA), a.y(this.oIA));
        if (a.z(this.oIA) != null)
        {
          d = SightVideoJNI.getVideoPlayTime(a.e(this.oIA));
          j = (int)d;
          if (j != (int)this.oIA.oeO) {
            a.z(this.oIA).gj(j);
          }
          this.oIA.oeO = d;
        }
        if (i == 0)
        {
          a.a(this.oIA, -1.0D);
          k = 0;
          j = i;
          i = k;
          break label921;
        }
        if (1 == i)
        {
          a.a(this.oIA, -1.0D);
          k = 1;
          a.a(this.oIA, 0L);
          a.A(this.oIA);
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
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
        this.stop = true;
        if (this.oIB != null) {
          this.oIB.stop = true;
        }
        this.oIA.bFG();
        j = i;
        if (a.b(this.oIA) != null)
        {
          a.b(this.oIA).yi(-1);
          j = i;
        }
        label1367:
        i = 0;
        break label921;
        m = SightVideoJNI.drawFrame(a.e(this.oIA), a.B(this.oIA), (int)f2, null, false, a.y(this.oIA));
        if (a.z(this.oIA) != null)
        {
          d = SightVideoJNI.getVideoPlayTime(a.e(this.oIA));
          i = (int)d;
          if (i != (int)this.oIA.oeO) {
            a.z(this.oIA).gj(i);
          }
          this.oIA.oeO = d;
          if (a.v(this.oIA)) {
            y.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
          }
        }
        for (;;)
        {
          if (m != 0) {
            break label1692;
          }
          a.a(this.oIA, -1.0D);
          j = m;
          i = k;
          break;
          if (a.v(this.oIA))
          {
            d = SightVideoJNI.getVideoPlayTime(a.e(this.oIA));
            if (a.v(this.oIA)) {
              y.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          else if (a.v(this.oIA))
          {
            y.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          }
        }
        if (1 == m)
        {
          a.a(this.oIA, -1.0D);
          i = 1;
          a.a(this.oIA, 0L);
          a.A(this.oIA);
          j = m;
          continue;
        }
        a.a(this.oIA, -1.0D);
        y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
        this.stop = true;
        if (this.oIB != null) {
          this.oIB.stop = true;
        }
        a.g(this.oIA).post(new Runnable()
        {
          public final void run()
          {
            a.b.this.oIA.G(null);
          }
        });
        j = m;
        i = k;
        if (a.b(this.oIA) == null) {
          continue;
        }
        a.b(this.oIA).yi(-1);
        j = m;
        i = k;
        continue;
      }
      long l;
      if (1 == a.d(this.oIA))
      {
        l = this.oIA.oes - (System.currentTimeMillis() - a.r(this.oIA));
        if (a.r(this.oIA) == 0L) {
          o.g(this, this.oIA.oes * 5);
        }
      }
      while (a.s(this.oIA) != null)
      {
        y.d("MicroMsg.SightPlayController", "voice time is" + a.s(this.oIA).bBk() / 1000.0D);
        return;
        if (l > 0L)
        {
          o.g(this, l);
        }
        else
        {
          o.g(this, 0L);
          continue;
          if ((i != 0) && (a.q(this.oIA) != null))
          {
            i = a.q(this.oIA).bBh();
            a.g(this.oIA).post(new a.b.5(this));
            this.oIB.ofg = j;
            a.g(this.oIA).postDelayed(this.oIB, i);
          }
          else
          {
            this.oIB.ofg = j;
            a.g(this.oIA).post(this.oIB);
          }
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.b
 * JD-Core Version:    0.7.0.1
 */