package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.g;

final class NetworkDiagnoseAllInOneUI$4
  implements bv.a
{
  NetworkDiagnoseAllInOneUI$4(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(29682);
    if (paramg == null)
    {
      AppMethodBeat.o(29682);
      return;
    }
    try
    {
      paramg.biz();
      AppMethodBeat.o(29682);
      return;
    }
    catch (Exception paramg)
    {
      AppMethodBeat.o(29682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.4
 * JD-Core Version:    0.7.0.1
 */