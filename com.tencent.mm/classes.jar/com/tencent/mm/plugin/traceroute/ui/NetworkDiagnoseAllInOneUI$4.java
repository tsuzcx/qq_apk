package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;

final class NetworkDiagnoseAllInOneUI$4
  implements bk.a
{
  NetworkDiagnoseAllInOneUI$4(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(25999);
    if (parame == null)
    {
      AppMethodBeat.o(25999);
      return;
    }
    try
    {
      parame.adL();
      AppMethodBeat.o(25999);
      return;
    }
    catch (Exception parame)
    {
      AppMethodBeat.o(25999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.4
 * JD-Core Version:    0.7.0.1
 */