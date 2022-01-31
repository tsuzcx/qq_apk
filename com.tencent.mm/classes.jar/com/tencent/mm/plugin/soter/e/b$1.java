package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.d.e;

final class b$1
  implements e
{
  public final void cym()
  {
    AppMethodBeat.i(156642);
    h.qsU.idkeyStat(1104L, 5L, 1L, false);
    AppMethodBeat.o(156642);
  }
  
  public final void cyn()
  {
    AppMethodBeat.i(156644);
    h.qsU.idkeyStat(1104L, 7L, 1L, false);
    AppMethodBeat.o(156644);
  }
  
  public final void cyo()
  {
    AppMethodBeat.i(156645);
    h.qsU.idkeyStat(1104L, 8L, 1L, false);
    AppMethodBeat.o(156645);
  }
  
  public final void cyp()
  {
    AppMethodBeat.i(156646);
    ab.i("MicroMsg.SoterInitManager", "no service when calling");
    h.qsU.idkeyStat(1104L, 9L, 1L, false);
    AppMethodBeat.o(156646);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(156643);
    h.qsU.idkeyStat(1104L, 6L, 1L, false);
    AppMethodBeat.o(156643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b.1
 * JD-Core Version:    0.7.0.1
 */