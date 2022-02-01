package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.c;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.plugin.traceroute.b.a.e;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.plugin.traceroute.b.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import java.util.Map;

final class NetworkDiagnoseUI$6
  implements bo.a
{
  NetworkDiagnoseUI$6(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(29715);
    if (parame == null)
    {
      AppMethodBeat.o(29715);
      return;
    }
    String str = u.aAm();
    NetworkDiagnoseUI.a(this.BAc, new a(str));
    NetworkDiagnoseUI.d(this.BAc).c(parame.getIPsString(true), true);
    NetworkDiagnoseUI.d(this.BAc).c(parame.getIPsString(false), false);
    NetworkDiagnoseUI.d(this.BAc).Bzi = new a.d()
    {
      public final void aUM()
      {
        AppMethodBeat.i(29711);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BAc).sendEmptyMessageDelayed(2, 500L);
        AppMethodBeat.o(29711);
      }
    };
    NetworkDiagnoseUI.d(this.BAc).Bzh = new a.e()
    {
      public final void erf()
      {
        AppMethodBeat.i(29712);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BAc).sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(29712);
      }
    };
    NetworkDiagnoseUI.d(this.BAc).Bzk = new a.b()
    {
      public final void erd()
      {
        AppMethodBeat.i(29713);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BAc).sendEmptyMessage(3);
        AppMethodBeat.o(29713);
      }
    };
    NetworkDiagnoseUI.d(this.BAc).Bzj = new a.c()
    {
      public final void ere()
      {
        AppMethodBeat.i(29714);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BAc).sendEmptyMessage(4);
        AppMethodBeat.o(29714);
      }
    };
    parame = NetworkDiagnoseUI.d(this.BAc);
    if ((parame.Bzg == null) || (parame.Bzg.size() == 0)) {
      ad.e("MicroMsg.MMTraceRoute", "no iplist");
    }
    for (;;)
    {
      NetworkDiagnoseUI.j(this.BAc).az(1200L, 1200L);
      AppMethodBeat.o(29715);
      return;
      if (a.Bzc == null) {
        a.Bzc = new c();
      }
      b.c(new a.j(parame, (byte)0), "MMTraceRoute_start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.6
 * JD-Core Version:    0.7.0.1
 */