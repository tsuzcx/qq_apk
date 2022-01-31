package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Map;

final class b$h
  implements Runnable
{
  volatile boolean stop = false;
  
  private b$h(b paramb) {}
  
  public final void run()
  {
    if (b.c(this.oeY)) {
      y.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
    }
    for (;;)
    {
      return;
      b localb = this.oeY;
      String str = b.a(this.oeY);
      if (1 == b.d(this.oeY)) {}
      for (int i = 0;; i = 1)
      {
        b.a(localb, SightVideoJNI.openFile(str, i, 1, false));
        if (b.e(this.oeY) >= 0) {
          break label166;
        }
        y.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(b.e(this.oeY)), b.a(this.oeY) });
        this.oeY.F(null);
        if (b.b(this.oeY) == null) {
          break;
        }
        b.b(this.oeY).d(this.oeY, -1);
        return;
      }
      label166:
      if (((Boolean)g.DP().Dz().get(344065, Boolean.valueOf(false))).booleanValue())
      {
        if (b.f(this.oeY) == null) {
          b.a(this.oeY, new b.j(this.oeY, (byte)0));
        }
        b.g(this.oeY).removeCallbacks(b.f(this.oeY));
        b.g(this.oeY).post(b.f(this.oeY));
      }
      i = Math.max(1, SightVideoJNI.getVideoWidth(b.e(this.oeY)));
      int j = Math.max(1, SightVideoJNI.getVideoHeight(b.e(this.oeY)));
      if (b.d(this.oeY) == 0)
      {
        if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          y.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return;
        }
        b.a(this.oeY, i, j);
      }
      this.oeY.bBc();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        y.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bk.bl(b.a(this.oeY))) {
          b.bBf().put(b.a(this.oeY), Integer.valueOf(2));
        }
        b.a(this.oeY, 0L);
        b.b(this.oeY, b.e(this.oeY));
        b.a(this.oeY, -1);
        b.a(this.oeY, "");
        b.b(this.oeY, "ERROR#PATH");
        b.a(this.oeY, null);
        this.stop = true;
        if (b.b(this.oeY) != null) {
          b.b(this.oeY).d(this.oeY, -1);
        }
      }
      else
      {
        this.oeY.cw(i, j);
        if (1 == b.d(this.oeY))
        {
          b.a(this.oeY, new b.b(this.oeY, (byte)0));
          b.a(this.oeY, null);
          if (!this.stop) {
            o.g(b.h(this.oeY), 0L);
          }
        }
        while (this.stop)
        {
          y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(this.oeY.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
          return;
          b.a(this.oeY, new b.b(this.oeY, (byte)0));
          b.a(this.oeY, new b.c(this.oeY));
          b.h(this.oeY).ofd = b.i(this.oeY);
          b.i(this.oeY).ofh = b.h(this.oeY);
          if (!this.stop) {
            o.g(b.h(this.oeY), 0L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.h
 * JD-Core Version:    0.7.0.1
 */