package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class b$h
  implements Runnable
{
  volatile boolean oIr = false;
  
  private b$h(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(37424);
    if (b.c(this.ryy))
    {
      ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
      AppMethodBeat.o(37424);
      return;
    }
    b localb = this.ryy;
    String str = b.a(this.ryy);
    if (1 == b.d(this.ryy)) {}
    for (int i = 0;; i = 1)
    {
      b.a(localb, SightVideoJNI.openFile(str, i, 1, false));
      if (b.e(this.ryy) >= 0) {
        break;
      }
      ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.ryy.hashCode()), Integer.valueOf(b.e(this.ryy)), b.a(this.ryy) });
      this.ryy.crB();
      if (b.b(this.ryy) != null) {
        b.b(this.ryy).Eh(-1);
      }
      AppMethodBeat.o(37424);
      return;
    }
    if (((Boolean)AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.FALSE)).booleanValue())
    {
      if (b.f(this.ryy) == null) {
        b.a(this.ryy, new b.j(this.ryy, (byte)0));
      }
      b.g(this.ryy).removeCallbacks(b.f(this.ryy));
      b.g(this.ryy).post(b.f(this.ryy));
    }
    i = Math.max(1, SightVideoJNI.getVideoWidth(b.e(this.ryy)));
    int j = Math.max(1, SightVideoJNI.getVideoHeight(b.e(this.ryy)));
    if (b.d(this.ryy) == 0)
    {
      if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
      {
        ab.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(37424);
        return;
      }
      b.a(this.ryy, i, j);
    }
    this.ryy.cmC();
    if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
    {
      ab.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (!bo.isNullOrNil(b.a(this.ryy))) {
        b.crC().put(b.a(this.ryy), Integer.valueOf(2));
      }
      b.a(this.ryy, 0L);
      b.b(this.ryy, b.e(this.ryy));
      b.a(this.ryy, -1);
      b.a(this.ryy, "");
      b.b(this.ryy, "ERROR#PATH");
      b.a(this.ryy, null);
      this.oIr = true;
      if (b.b(this.ryy) != null) {
        b.b(this.ryy).Eh(-1);
      }
      AppMethodBeat.o(37424);
      return;
    }
    this.ryy.dQ(i, j);
    if (1 == b.d(this.ryy))
    {
      b.a(this.ryy, new b.b(this.ryy, (byte)0));
      b.a(this.ryy, null);
      if (!this.oIr) {
        o.j(b.h(this.ryy), 0L);
      }
    }
    for (;;)
    {
      if (this.oIr) {
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(this.ryy.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.oIr) });
      }
      AppMethodBeat.o(37424);
      return;
      b.a(this.ryy, new b.b(this.ryy, (byte)0));
      b.a(this.ryy, new b.c(this.ryy));
      b.h(this.ryy).ryz = b.i(this.ryy);
      b.i(this.ryy).ryB = b.h(this.ryy);
      if (!this.oIr) {
        o.j(b.h(this.ryy), 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.h
 * JD-Core Version:    0.7.0.1
 */