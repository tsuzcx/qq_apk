package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.plugin.traceroute.b.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class NetworkDiagnoseUI$6
  implements bi.a
{
  NetworkDiagnoseUI$6(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    if (parame == null) {
      return;
    }
    String str = q.Gj();
    NetworkDiagnoseUI.a(this.pJy, new a(str));
    NetworkDiagnoseUI.d(this.pJy).b(parame.getIPsString(true), true);
    NetworkDiagnoseUI.d(this.pJy).b(parame.getIPsString(false), false);
    NetworkDiagnoseUI.d(this.pJy).pIE = new NetworkDiagnoseUI.6.1(this);
    NetworkDiagnoseUI.d(this.pJy).pID = new NetworkDiagnoseUI.6.2(this);
    NetworkDiagnoseUI.d(this.pJy).pIG = new NetworkDiagnoseUI.6.3(this);
    NetworkDiagnoseUI.d(this.pJy).pIF = new NetworkDiagnoseUI.6.4(this);
    parame = NetworkDiagnoseUI.d(this.pJy);
    if ((parame.pIC == null) || (parame.pIC.size() == 0)) {
      y.e("MicroMsg.MMTraceRoute", "no iplist");
    }
    for (;;)
    {
      NetworkDiagnoseUI.j(this.pJy).S(1200L, 1200L);
      return;
      if (a.pIy == null) {
        a.pIy = new c();
      }
      com.tencent.mm.sdk.f.e.post(new a.j(parame, (byte)0), "MMTraceRoute_start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.6
 * JD-Core Version:    0.7.0.1
 */