package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.plugin.traceroute.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Map;

final class NetworkDiagnoseUI$6
  implements bk.a
{
  NetworkDiagnoseUI$6(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(26032);
    if (parame == null)
    {
      AppMethodBeat.o(26032);
      return;
    }
    String str = r.Zn();
    NetworkDiagnoseUI.a(this.tnM, new a(str));
    NetworkDiagnoseUI.d(this.tnM).c(parame.getIPsString(true), true);
    NetworkDiagnoseUI.d(this.tnM).c(parame.getIPsString(false), false);
    NetworkDiagnoseUI.d(this.tnM).tmS = new NetworkDiagnoseUI.6.1(this);
    NetworkDiagnoseUI.d(this.tnM).tmR = new NetworkDiagnoseUI.6.2(this);
    NetworkDiagnoseUI.d(this.tnM).tmU = new NetworkDiagnoseUI.6.3(this);
    NetworkDiagnoseUI.d(this.tnM).tmT = new NetworkDiagnoseUI.6.4(this);
    parame = NetworkDiagnoseUI.d(this.tnM);
    if ((parame.tmQ == null) || (parame.tmQ.size() == 0)) {
      ab.e("MicroMsg.MMTraceRoute", "no iplist");
    }
    for (;;)
    {
      NetworkDiagnoseUI.j(this.tnM).ag(1200L, 1200L);
      AppMethodBeat.o(26032);
      return;
      if (a.tmM == null) {
        a.tmM = new c();
      }
      d.post(new a.j(parame, (byte)0), "MMTraceRoute_start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.6
 * JD-Core Version:    0.7.0.1
 */