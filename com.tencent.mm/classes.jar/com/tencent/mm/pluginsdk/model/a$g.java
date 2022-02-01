package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class a$g
  implements Runnable
{
  public static final g DgL;
  
  static
  {
    AppMethodBeat.i(124806);
    DgL = new g();
    AppMethodBeat.o(124806);
  }
  
  public final void run()
  {
    AppMethodBeat.i(124805);
    Object localObject = a.Dgo;
    ac.i("MicroMsg.BizImageBlankReporter", "alvinluo reportImageLoadCountInfo %s", new Object[] { a.eKu() });
    localObject = h.wUl;
    a locala = a.Dgo;
    int i = a.eKu().fAw;
    locala = a.Dgo;
    int j = a.eKu().DgH;
    locala = a.Dgo;
    int k = a.eKu().DgG;
    locala = a.Dgo;
    ((h)localObject).f(17890, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(a.eKu().DgF) });
    localObject = a.Dgo;
    a.eKv();
    AppMethodBeat.o(124805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.g
 * JD-Core Version:    0.7.0.1
 */