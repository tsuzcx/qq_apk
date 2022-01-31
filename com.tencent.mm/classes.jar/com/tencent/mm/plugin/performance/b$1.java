package com.tencent.mm.plugin.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ad;

final class b$1
  implements a
{
  public final boolean WP(String paramString)
  {
    AppMethodBeat.i(111039);
    boolean bool = ad.a(paramString, r.Zn(), true, false);
    AppMethodBeat.o(111039);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.1
 * JD-Core Version:    0.7.0.1
 */