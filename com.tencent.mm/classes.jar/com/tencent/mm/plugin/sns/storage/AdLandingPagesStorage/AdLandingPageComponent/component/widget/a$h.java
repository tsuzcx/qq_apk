package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$h
  implements Runnable
{
  volatile boolean stop = false;
  
  private a$h(a parama) {}
  
  public final void run()
  {
    if (a.c(this.oIA)) {
      y.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
    }
    for (;;)
    {
      return;
      a locala = this.oIA;
      String str = a.a(this.oIA);
      if (1 == a.d(this.oIA)) {}
      for (int i = 0;; i = 1)
      {
        a.a(locala, SightVideoJNI.openFile(str, i, 1, false));
        if (a.e(this.oIA) >= 0) {
          break label161;
        }
        y.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(a.e(this.oIA)), a.a(this.oIA) });
        this.oIA.bFG();
        if (a.b(this.oIA) == null) {
          break;
        }
        a.b(this.oIA).yi(-1);
        return;
      }
      label161:
      if (((Boolean)AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.valueOf(false))).booleanValue())
      {
        if (a.f(this.oIA) == null) {
          a.a(this.oIA, new a.j(this.oIA, (byte)0));
        }
        a.g(this.oIA).removeCallbacks(a.f(this.oIA));
        a.g(this.oIA).post(a.f(this.oIA));
      }
      i = Math.max(1, SightVideoJNI.getVideoWidth(a.e(this.oIA)));
      int j = Math.max(1, SightVideoJNI.getVideoHeight(a.e(this.oIA)));
      if (a.d(this.oIA) == 0)
      {
        if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          y.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return;
        }
        a.a(this.oIA, i, j);
      }
      this.oIA.bBc();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        y.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bk.bl(a.a(this.oIA))) {
          a.bBf().put(a.a(this.oIA), Integer.valueOf(2));
        }
        a.a(this.oIA, 0L);
        a.b(this.oIA, a.e(this.oIA));
        a.a(this.oIA, -1);
        a.a(this.oIA, "");
        a.b(this.oIA, "ERROR#PATH");
        a.a(this.oIA, null);
        this.stop = true;
        if (a.b(this.oIA) != null) {
          a.b(this.oIA).yi(-1);
        }
      }
      else
      {
        this.oIA.cw(i, j);
        if (1 == a.d(this.oIA))
        {
          a.a(this.oIA, new a.b(this.oIA, (byte)0));
          a.a(this.oIA, null);
          if (!this.stop) {
            o.g(a.h(this.oIA), 0L);
          }
        }
        while (this.stop)
        {
          y.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(this.oIA.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
          return;
          a.a(this.oIA, new a.b(this.oIA, (byte)0));
          a.a(this.oIA, new a.c(this.oIA));
          a.h(this.oIA).oIB = a.i(this.oIA);
          a.i(this.oIA).oID = a.h(this.oIA);
          if (!this.stop) {
            o.g(a.h(this.oIA), 0L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.h
 * JD-Core Version:    0.7.0.1
 */