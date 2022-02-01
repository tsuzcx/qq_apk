package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.c;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.plugin.traceroute.b.a.e;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.plugin.traceroute.b.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import java.util.Map;

final class NetworkDiagnoseUI$6
  implements bq.a
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
    String str = v.aAC();
    NetworkDiagnoseUI.a(this.BRA, new a(str));
    NetworkDiagnoseUI.d(this.BRA).c(parame.getIPsString(true), true);
    NetworkDiagnoseUI.d(this.BRA).c(parame.getIPsString(false), false);
    NetworkDiagnoseUI.d(this.BRA).BQG = new a.d()
    {
      public final void aVl()
      {
        AppMethodBeat.i(29711);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BRA).sendEmptyMessageDelayed(2, 500L);
        AppMethodBeat.o(29711);
      }
    };
    NetworkDiagnoseUI.d(this.BRA).BQF = new a.e()
    {
      public final void euM()
      {
        AppMethodBeat.i(29712);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BRA).sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(29712);
      }
    };
    NetworkDiagnoseUI.d(this.BRA).BQI = new a.b()
    {
      public final void euK()
      {
        AppMethodBeat.i(29713);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BRA).sendEmptyMessage(3);
        AppMethodBeat.o(29713);
      }
    };
    NetworkDiagnoseUI.d(this.BRA).BQH = new a.c()
    {
      public final void euL()
      {
        AppMethodBeat.i(29714);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.BRA).sendEmptyMessage(4);
        AppMethodBeat.o(29714);
      }
    };
    parame = NetworkDiagnoseUI.d(this.BRA);
    if ((parame.BQE == null) || (parame.BQE.size() == 0)) {
      ae.e("MicroMsg.MMTraceRoute", "no iplist");
    }
    for (;;)
    {
      NetworkDiagnoseUI.j(this.BRA).ay(1200L, 1200L);
      AppMethodBeat.o(29715);
      return;
      if (a.BQA == null) {
        a.BQA = new c();
      }
      b.c(new a.j(parame, (byte)0), "MMTraceRoute_start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.6
 * JD-Core Version:    0.7.0.1
 */