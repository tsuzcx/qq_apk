package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Map;
import java.util.Queue;

final class b$h
  implements Runnable
{
  volatile boolean oIr = false;
  
  private b$h(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(70241);
    if (b.c(this.qTn))
    {
      ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
      AppMethodBeat.o(70241);
      return;
    }
    b localb = this.qTn;
    String str = b.a(this.qTn);
    if (1 == b.d(this.qTn)) {}
    for (int i = 0;; i = 1)
    {
      b.a(localb, SightVideoJNI.openFile(str, i, 1, false));
      ab.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", new Object[] { b.a(this.qTn), Integer.valueOf(b.e(this.qTn)) });
      b.f(this.qTn).offer(Integer.valueOf(b.e(this.qTn)));
      if (b.e(this.qTn) >= 0) {
        break;
      }
      ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(b.e(this.qTn)), b.a(this.qTn) });
      this.qTn.R(null);
      if (b.b(this.qTn) != null) {
        b.b(this.qTn).c(this.qTn, -1);
      }
      AppMethodBeat.o(70241);
      return;
    }
    if (((Boolean)g.RL().Ru().get(344065, Boolean.FALSE)).booleanValue())
    {
      if (b.g(this.qTn) == null) {
        b.a(this.qTn, new b.j(this.qTn, (byte)0));
      }
      b.h(this.qTn).removeCallbacks(b.g(this.qTn));
      b.h(this.qTn).post(b.g(this.qTn));
    }
    i = Math.max(1, SightVideoJNI.getVideoWidth(b.e(this.qTn)));
    int j = Math.max(1, SightVideoJNI.getVideoHeight(b.e(this.qTn)));
    if (b.d(this.qTn) == 0)
    {
      if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
      {
        ab.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(70241);
        return;
      }
      b.a(this.qTn, i, j);
    }
    this.qTn.cmC();
    if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
    {
      ab.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (!bo.isNullOrNil(b.a(this.qTn))) {
        b.cmF().put(b.a(this.qTn), Integer.valueOf(2));
      }
      b.a(this.qTn, 0L);
      b.a(this.qTn, b.f(this.qTn));
      b.a(this.qTn, -1);
      b.a(this.qTn, "");
      b.b(this.qTn, "ERROR#PATH");
      b.a(this.qTn, null);
      this.oIr = true;
      if (b.b(this.qTn) != null) {
        b.b(this.qTn).c(this.qTn, -1);
      }
      AppMethodBeat.o(70241);
      return;
    }
    this.qTn.dQ(i, j);
    if (1 == b.d(this.qTn))
    {
      b.a(this.qTn, new b.b(this.qTn, (byte)0));
      b.a(this.qTn, null);
      if (!this.oIr) {
        o.j(b.i(this.qTn), 0L);
      }
    }
    for (;;)
    {
      if (this.oIr) {
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.oIr) });
      }
      AppMethodBeat.o(70241);
      return;
      b.a(this.qTn, new b.b(this.qTn, (byte)0));
      b.a(this.qTn, new b.c(this.qTn));
      b.i(this.qTn).qTs = b.j(this.qTn);
      b.j(this.qTn).qTv = b.i(this.qTn);
      if (!this.oIr) {
        o.j(b.i(this.qTn), 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.h
 * JD-Core Version:    0.7.0.1
 */