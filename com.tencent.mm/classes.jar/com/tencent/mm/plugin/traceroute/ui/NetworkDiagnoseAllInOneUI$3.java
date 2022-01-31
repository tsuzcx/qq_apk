package com.tencent.mm.plugin.traceroute.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class NetworkDiagnoseAllInOneUI$3
  implements ap.a
{
  NetworkDiagnoseAllInOneUI$3(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25998);
    NetworkDiagnoseAllInOneUI.a(this.tns, NetworkDiagnoseAllInOneUI.m(this.tns) + 1);
    ab.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(this.tns)) });
    if (NetworkDiagnoseAllInOneUI.m(this.tns) > 99)
    {
      AppMethodBeat.o(25998);
      return false;
    }
    if (NetworkDiagnoseAllInOneUI.a(this.tns) == 1) {
      NetworkDiagnoseAllInOneUI.n(this.tns).setText(this.tns.getString(2131298967, new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.m(this.tns)) }));
    }
    AppMethodBeat.o(25998);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.3
 * JD-Core Version:    0.7.0.1
 */