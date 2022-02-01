package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.e;

final class NetworkDiagnoseAllInOneUI$4
  implements bn.a
{
  NetworkDiagnoseAllInOneUI$4(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(29682);
    if (parame == null)
    {
      AppMethodBeat.o(29682);
      return;
    }
    try
    {
      parame.avj();
      AppMethodBeat.o(29682);
      return;
    }
    catch (Exception parame)
    {
      AppMethodBeat.o(29682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.4
 * JD-Core Version:    0.7.0.1
 */