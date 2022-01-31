package com.tencent.mm.plugin.traceroute.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMProgressBar.a;

final class NetworkDiagnoseUI$3
  implements MMProgressBar.a
{
  NetworkDiagnoseUI$3(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void GM(int paramInt)
  {
    AppMethodBeat.i(26025);
    if (paramInt < 5)
    {
      NetworkDiagnoseUI.f(this.tnM).setText(this.tnM.getString(2131298516));
      AppMethodBeat.o(26025);
      return;
    }
    if ((paramInt >= 5) && (paramInt < 95))
    {
      NetworkDiagnoseUI.f(this.tnM).setText(this.tnM.getString(2131300533));
      AppMethodBeat.o(26025);
      return;
    }
    NetworkDiagnoseUI.f(this.tnM).setText(this.tnM.getString(2131304448));
    AppMethodBeat.o(26025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.3
 * JD-Core Version:    0.7.0.1
 */