package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class p
{
  static void aVE()
  {
    AppMethodBeat.i(79563);
    m localm = new m();
    g.RK().eHt.a(localm, 0);
    dms();
    AppMethodBeat.o(79563);
  }
  
  private static void dms()
  {
    AppMethodBeat.i(79562);
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(79562);
      return;
    }
    long l = bo.aox();
    g.RL().Ru().set(ac.a.yAS, Long.valueOf(l + 86400L));
    AppMethodBeat.o(79562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.p
 * JD-Core Version:    0.7.0.1
 */