package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bn.a;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import java.util.Map;

final class NetworkDiagnoseUI$6
  implements bn.a
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
    String str = u.axw();
    NetworkDiagnoseUI.a(this.Aiq, new a(str));
    NetworkDiagnoseUI.d(this.Aiq).d(parame.getIPsString(true), true);
    NetworkDiagnoseUI.d(this.Aiq).d(parame.getIPsString(false), false);
    NetworkDiagnoseUI.d(this.Aiq).Ahw = new a.d()
    {
      public final void aRA()
      {
        AppMethodBeat.i(29711);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Aiq).sendEmptyMessageDelayed(2, 500L);
        AppMethodBeat.o(29711);
      }
    };
    NetworkDiagnoseUI.d(this.Aiq).Ahv = new a.e()
    {
      public final void eeO()
      {
        AppMethodBeat.i(29712);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Aiq).sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(29712);
      }
    };
    NetworkDiagnoseUI.d(this.Aiq).Ahy = new a.b()
    {
      public final void eeM()
      {
        AppMethodBeat.i(29713);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Aiq).sendEmptyMessage(3);
        AppMethodBeat.o(29713);
      }
    };
    NetworkDiagnoseUI.d(this.Aiq).Ahx = new a.c()
    {
      public final void eeN()
      {
        AppMethodBeat.i(29714);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Aiq).sendEmptyMessage(4);
        AppMethodBeat.o(29714);
      }
    };
    parame = NetworkDiagnoseUI.d(this.Aiq);
    if ((parame.Ahu == null) || (parame.Ahu.size() == 0)) {
      ac.e("MicroMsg.MMTraceRoute", "no iplist");
    }
    for (;;)
    {
      NetworkDiagnoseUI.j(this.Aiq).au(1200L, 1200L);
      AppMethodBeat.o(29715);
      return;
      if (a.Ahq == null) {
        a.Ahq = new c();
      }
      b.c(new a.j(parame, (byte)0), "MMTraceRoute_start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.6
 * JD-Core Version:    0.7.0.1
 */