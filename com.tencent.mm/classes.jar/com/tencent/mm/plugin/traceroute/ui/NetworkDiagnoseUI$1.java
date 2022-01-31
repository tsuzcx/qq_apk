package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.MMProgressBar;

final class NetworkDiagnoseUI$1
  implements ap.a
{
  NetworkDiagnoseUI$1(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26023);
    NetworkDiagnoseUI.a(this.tnM, NetworkDiagnoseUI.a(this.tnM) + 1);
    NetworkDiagnoseUI.b(this.tnM, NetworkDiagnoseUI.b(this.tnM));
    if (NetworkDiagnoseUI.b(this.tnM) < 100)
    {
      NetworkDiagnoseUI.c(this.tnM).setProgress(NetworkDiagnoseUI.b(this.tnM));
      AppMethodBeat.o(26023);
      return true;
    }
    NetworkDiagnoseUI.c(this.tnM).setProgress(100);
    AppMethodBeat.o(26023);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.1
 * JD-Core Version:    0.7.0.1
 */