package com.tencent.mm.plugin.traceroute.ui;

import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class NetworkDiagnoseAllInOneUI$3
  implements am.a
{
  NetworkDiagnoseAllInOneUI$3(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final boolean tC()
  {
    NetworkDiagnoseAllInOneUI.a(this.pJe, NetworkDiagnoseAllInOneUI.k(this.pJe) + 1);
    y.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.k(this.pJe)) });
    if (NetworkDiagnoseAllInOneUI.k(this.pJe) > 99) {
      return false;
    }
    if (NetworkDiagnoseAllInOneUI.a(this.pJe) == 1) {
      NetworkDiagnoseAllInOneUI.l(this.pJe).setText(this.pJe.getString(R.l.diagnose_state_doing, new Object[] { Integer.valueOf(NetworkDiagnoseAllInOneUI.k(this.pJe)) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.3
 * JD-Core Version:    0.7.0.1
 */