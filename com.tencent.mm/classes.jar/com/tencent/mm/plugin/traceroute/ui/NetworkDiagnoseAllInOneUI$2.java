package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class NetworkDiagnoseAllInOneUI$2
  implements b.a
{
  NetworkDiagnoseAllInOneUI$2(NetworkDiagnoseAllInOneUI paramNetworkDiagnoseAllInOneUI) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(25997);
    ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (NetworkDiagnoseAllInOneUI.f(this.tns) != null) {
      NetworkDiagnoseAllInOneUI.f(this.tns).c(NetworkDiagnoseAllInOneUI.g(this.tns));
    }
    al.d(new NetworkDiagnoseAllInOneUI.2.1(this));
    NetworkDiagnoseAllInOneUI.j(this.tns);
    if (paramBoolean) {
      str = String.valueOf(paramFloat2) + "-" + String.valueOf(paramFloat1);
    }
    for (String str = str + "," + NetworkDiagnoseAllInOneUI.j(this.tns);; str = "," + NetworkDiagnoseAllInOneUI.j(this.tns))
    {
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(14533, str);
      AppMethodBeat.o(25997);
      return false;
      if ((!NetworkDiagnoseAllInOneUI.k(this.tns)) && (!d.agR()))
      {
        NetworkDiagnoseAllInOneUI.l(this.tns);
        com.tencent.mm.ui.base.h.a(this.tns, this.tns.getString(2131300538), this.tns.getString(2131297087), this.tns.getString(2131300996), this.tns.getString(2131296888), false, new NetworkDiagnoseAllInOneUI.2.2(this), null);
      }
      ab.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.2
 * JD-Core Version:    0.7.0.1
 */