package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class NetworkDiagnoseAllInOneUI$2
  implements a.a
{
  NetworkDiagnoseAllInOneUI$2(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    y.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    NetworkDiagnoseAllInOneUI.g(this.pJe).c(NetworkDiagnoseAllInOneUI.f(this.pJe));
    ai.d(new NetworkDiagnoseAllInOneUI.2.1(this));
    NetworkDiagnoseAllInOneUI.j(this.pJe);
    if (paramBoolean) {
      str = String.valueOf(paramFloat2) + "-" + String.valueOf(paramFloat1);
    }
    for (String str = str + "," + NetworkDiagnoseAllInOneUI.j(this.pJe);; str = "," + NetworkDiagnoseAllInOneUI.j(this.pJe))
    {
      h.nFQ.aC(14533, str);
      return false;
      y.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.2
 * JD-Core Version:    0.7.0.1
 */