package com.tencent.mm.plugin.traceroute.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.MMProgressBar.a;

final class NetworkDiagnoseUI$3
  implements MMProgressBar.a
{
  NetworkDiagnoseUI$3(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void apf(int paramInt)
  {
    AppMethodBeat.i(29708);
    if (paramInt < 5)
    {
      NetworkDiagnoseUI.f(this.TRG).setText(this.TRG.getString(R.l.gAy));
      AppMethodBeat.o(29708);
      return;
    }
    if ((paramInt >= 5) && (paramInt < 95))
    {
      NetworkDiagnoseUI.f(this.TRG).setText(this.TRG.getString(R.l.gJd));
      AppMethodBeat.o(29708);
      return;
    }
    NetworkDiagnoseUI.f(this.TRG).setText(this.TRG.getString(R.l.gXB));
    AppMethodBeat.o(29708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.3
 * JD-Core Version:    0.7.0.1
 */