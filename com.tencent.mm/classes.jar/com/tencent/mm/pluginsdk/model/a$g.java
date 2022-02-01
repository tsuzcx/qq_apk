package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class a$g
  implements Runnable
{
  public static final g BOx;
  
  static
  {
    AppMethodBeat.i(124806);
    BOx = new g();
    AppMethodBeat.o(124806);
  }
  
  public final void run()
  {
    AppMethodBeat.i(124805);
    Object localObject = a.BOa;
    ad.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", new Object[] { a.eva() });
    localObject = h.vKh;
    a locala = a.BOa;
    int i = a.eva().fwP;
    locala = a.BOa;
    int j = a.eva().BOt;
    locala = a.BOa;
    int k = a.eva().BOs;
    locala = a.BOa;
    ((h)localObject).f(17890, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(a.eva().BOr) });
    localObject = a.BOa;
    a.evb();
    AppMethodBeat.o(124805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.g
 * JD-Core Version:    0.7.0.1
 */