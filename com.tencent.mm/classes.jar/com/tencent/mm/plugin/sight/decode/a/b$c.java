package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ab;

final class b$c
  implements Runnable
{
  volatile boolean oIr;
  int qTu;
  b.b qTv;
  
  public b$c(b paramb)
  {
    AppMethodBeat.i(70238);
    this.oIr = false;
    ab.i("MicroMsg.SightPlayController", "make sure drawJob alive");
    AppMethodBeat.o(70238);
  }
  
  public final void run()
  {
    AppMethodBeat.i(70239);
    if (this.oIr)
    {
      ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(this.qTn.hashCode()), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(70239);
      return;
    }
    this.qTn.S(b.C(this.qTn));
    if (b.s(this.qTn) == 0L)
    {
      o.j(this.qTv, 0L);
      AppMethodBeat.o(70239);
      return;
    }
    long l = this.qTn.qSH - (System.currentTimeMillis() - b.s(this.qTn));
    if (l > 0L)
    {
      o.j(this.qTv, l);
      AppMethodBeat.o(70239);
      return;
    }
    o.j(this.qTv, 0L);
    AppMethodBeat.o(70239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.c
 * JD-Core Version:    0.7.0.1
 */