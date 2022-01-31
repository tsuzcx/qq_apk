package com.tencent.mm.plugin.sight.decode.a;

import android.view.Surface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class b$b
  implements Runnable
{
  volatile boolean oIr = false;
  b.c qTs;
  
  private b$b(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(70237);
    if ((b.r(this.qTn) != null) && (b.r(this.qTn).cmI() != null) && (b.r(this.qTn).cmI().getVisibility() == 0)) {
      b.h(this.qTn).post(new b.b.1(this));
    }
    if (b.e(this.qTn) < 0)
    {
      ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()), b.a(this.qTn) });
      AppMethodBeat.o(70237);
      return;
    }
    if (this.oIr)
    {
      ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(70237);
      return;
    }
    if (b.s(this.qTn) == 0L)
    {
      if (b.t(this.qTn) != null)
      {
        b.t(this.qTn).type = 1;
        b.t(this.qTn).run();
      }
      b.a(this.qTn, System.currentTimeMillis());
    }
    int j = 0;
    int i = j;
    if (b.u(this.qTn) != -1.0D)
    {
      if (this.qTn.qTa) {
        break label620;
      }
      i = j;
      if (SightVideoJNI.seekStream(b.u(this.qTn), b.e(this.qTn)) > 0)
      {
        if (b.t(this.qTn) == null) {
          b.a(this.qTn, new b.i(this.qTn, (byte)0));
        }
        b.t(this.qTn).type = 4;
        b.t(this.qTn).qTg = b.u(this.qTn);
        b.t(this.qTn).run();
        i = 1;
      }
    }
    float f3 = (float)(System.currentTimeMillis() - b.s(this.qTn));
    float f1;
    label375:
    float f2;
    double d;
    if (i != 0)
    {
      f1 = 0.0F;
      f2 = f1;
      if (this.qTn.qTa)
      {
        f2 = f1;
        if (b.v(this.qTn))
        {
          b.a(this.qTn, false);
          f2 = f1;
          if (b.t(this.qTn) != null)
          {
            d = b.t(this.qTn).cmK() / 1000.0D;
            f2 = f1;
            if (SightVideoJNI.seekStream(d, b.e(this.qTn)) > 0)
            {
              f2 = 0.0F;
              ab.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
            }
          }
        }
      }
      if (b.w(this.qTn)) {
        ab.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(b.e(this.qTn)), Float.valueOf(f3), Float.valueOf(f2) });
      }
      b.a(this.qTn, System.currentTimeMillis());
      if (f2 < 2.0F) {
        break label813;
      }
      b.x(this.qTn);
    }
    for (;;)
    {
      if (!b.c(this.qTn)) {
        break label837;
      }
      ab.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.y(this.qTn)) });
      this.qTn.clear();
      AppMethodBeat.o(70237);
      return;
      label620:
      if (b.t(this.qTn) != null)
      {
        b.t(this.qTn).type = 4;
        b.t(this.qTn).qTg = b.u(this.qTn);
        b.t(this.qTn).run();
        b.h(this.qTn).postDelayed(new b.b.2(this), 100L);
        i = j;
        break;
      }
      i = j;
      if (SightVideoJNI.seekStream(b.u(this.qTn), b.e(this.qTn)) <= 0) {
        break;
      }
      if (b.t(this.qTn) == null) {
        b.a(this.qTn, new b.i(this.qTn, (byte)0));
      }
      b.t(this.qTn).type = 4;
      b.t(this.qTn).qTg = b.u(this.qTn);
      b.t(this.qTn).run();
      i = 1;
      break;
      f1 = f3 / this.qTn.qSH + 0.5F;
      break label375;
      label813:
      b.b(this.qTn, Math.max(0, b.y(this.qTn) - 1));
    }
    label837:
    int k = 0;
    j = 0;
    int m = 0;
    if (1 == b.d(this.qTn)) {
      if ((b.n(this.qTn) != null) && (!b.n(this.qTn).isValid()))
      {
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()) });
        this.oIr = true;
        if (this.qTs == null) {
          break label1403;
        }
        this.qTs.oIr = true;
        i = 0;
        j = m;
        if (b.t(this.qTn) == null) {
          break label2156;
        }
        ab.d("MicroMsg.SightPlayController", "voice time is" + b.t(this.qTn).cmK() / 1000.0D);
      }
    }
    label1732:
    label2156:
    for (;;)
    {
      if (1 == j) {
        b.h(this.qTn).post(new b.b.4(this));
      }
      if (this.oIr)
      {
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()) });
        if (b.t(this.qTn) != null)
        {
          b.t(this.qTn).type = 0;
          b.t(this.qTn).run();
        }
        AppMethodBeat.o(70237);
        return;
        i = SightVideoJNI.drawSurfaceFrame(b.e(this.qTn), b.n(this.qTn), (int)f2, b.p(this.qTn), b.z(this.qTn));
        if (b.A(this.qTn) != null)
        {
          d = SightVideoJNI.getVideoPlayTime(b.e(this.qTn));
          j = (int)d;
          if (j != (int)this.qTn.qTd) {
            b.A(this.qTn).b(this.qTn, j);
          }
          this.qTn.qTd = d;
        }
        if (i == 0)
        {
          b.a(this.qTn, -1.0D);
          k = 0;
          j = i;
          i = k;
          break;
        }
        if (1 == i)
        {
          b.a(this.qTn, -1.0D);
          k = 1;
          b.a(this.qTn, 0L);
          b.B(this.qTn);
          j = i;
          i = k;
          break;
        }
        if (-7 == i)
        {
          ab.w("MicroMsg.SightPlayController", "surface is null, continue");
          k = 0;
          j = i;
          i = k;
          break;
        }
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
        this.oIr = true;
        if (this.qTs != null) {
          this.qTs.oIr = true;
        }
        this.qTn.R(null);
        j = i;
        if (b.b(this.qTn) != null)
        {
          b.b(this.qTn).c(this.qTn, -1);
          j = i;
        }
        label1403:
        i = 0;
        break;
        m = SightVideoJNI.drawFrame(b.e(this.qTn), b.C(this.qTn), (int)f2, null, false, b.z(this.qTn));
        if (b.A(this.qTn) != null)
        {
          d = SightVideoJNI.getVideoPlayTime(b.e(this.qTn));
          i = (int)d;
          if (i != (int)this.qTn.qTd) {
            b.A(this.qTn).b(this.qTn, i);
          }
          this.qTn.qTd = d;
          if (b.w(this.qTn)) {
            ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
          }
        }
        for (;;)
        {
          if (m != 0) {
            break label1732;
          }
          b.a(this.qTn, -1.0D);
          j = m;
          i = k;
          break;
          if (b.w(this.qTn))
          {
            d = SightVideoJNI.getVideoPlayTime(b.e(this.qTn));
            if (b.w(this.qTn)) {
              ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          else if (b.w(this.qTn))
          {
            ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          }
        }
        if (1 == m)
        {
          b.a(this.qTn, -1.0D);
          i = 1;
          b.a(this.qTn, 0L);
          b.B(this.qTn);
          j = m;
          continue;
        }
        b.a(this.qTn, -1.0D);
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
        this.oIr = true;
        if (this.qTs != null) {
          this.qTs.oIr = true;
        }
        b.h(this.qTn).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(70234);
            b.b.this.qTn.S(null);
            AppMethodBeat.o(70234);
          }
        });
        j = m;
        i = k;
        if (b.b(this.qTn) == null) {
          continue;
        }
        b.b(this.qTn).c(this.qTn, -1);
        j = m;
        i = k;
        continue;
      }
      long l;
      if (1 == b.d(this.qTn))
      {
        l = this.qTn.qSH - (System.currentTimeMillis() - b.s(this.qTn));
        if (b.s(this.qTn) == 0L) {
          o.j(this, this.qTn.qSH * 5);
        }
      }
      for (;;)
      {
        if (b.t(this.qTn) != null) {
          ab.d("MicroMsg.SightPlayController", "voice time is" + b.t(this.qTn).cmK() / 1000.0D);
        }
        AppMethodBeat.o(70237);
        return;
        if (l > 0L)
        {
          o.j(this, l);
        }
        else
        {
          o.j(this, 0L);
          continue;
          if ((i != 0) && (b.r(this.qTn) != null))
          {
            i = b.r(this.qTn).cmH();
            b.h(this.qTn).post(new b.b.5(this));
            this.qTs.qTu = j;
            b.h(this.qTn).postDelayed(this.qTs, i);
          }
          else
          {
            this.qTs.qTu = j;
            b.h(this.qTn).post(this.qTs);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.b
 * JD-Core Version:    0.7.0.1
 */