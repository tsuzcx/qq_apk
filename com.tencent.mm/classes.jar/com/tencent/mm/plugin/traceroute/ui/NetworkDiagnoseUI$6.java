package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.c;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.plugin.traceroute.b.a.e;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.plugin.traceroute.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Map;

final class NetworkDiagnoseUI$6
  implements bu.a
{
  NetworkDiagnoseUI$6(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(29715);
    if (paramg == null)
    {
      AppMethodBeat.o(29715);
      return;
    }
    String str = z.aTY();
    NetworkDiagnoseUI.a(this.Gsi, new a(str));
    NetworkDiagnoseUI.d(this.Gsi).c(paramg.getIPsString(true), true);
    NetworkDiagnoseUI.d(this.Gsi).c(paramg.getIPsString(false), false);
    NetworkDiagnoseUI.d(this.Gsi).Grn = new a.d()
    {
      public final void onFinished()
      {
        AppMethodBeat.i(29711);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Gsi).sendEmptyMessageDelayed(2, 500L);
        AppMethodBeat.o(29711);
      }
    };
    NetworkDiagnoseUI.d(this.Gsi).Grm = new a.e()
    {
      public final void fAf()
      {
        AppMethodBeat.i(29712);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Gsi).sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(29712);
      }
    };
    NetworkDiagnoseUI.d(this.Gsi).Grp = new a.b()
    {
      public final void fAd()
      {
        AppMethodBeat.i(29713);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Gsi).sendEmptyMessage(3);
        AppMethodBeat.o(29713);
      }
    };
    NetworkDiagnoseUI.d(this.Gsi).Gro = new a.c()
    {
      public final void fAe()
      {
        AppMethodBeat.i(29714);
        NetworkDiagnoseUI.i(NetworkDiagnoseUI.6.this.Gsi).sendEmptyMessage(4);
        AppMethodBeat.o(29714);
      }
    };
    paramg = NetworkDiagnoseUI.d(this.Gsi);
    if ((paramg.Grl == null) || (paramg.Grl.size() == 0)) {
      Log.e("MicroMsg.MMTraceRoute", "no iplist");
    }
    for (;;)
    {
      NetworkDiagnoseUI.j(this.Gsi).startTimer(1200L);
      AppMethodBeat.o(29715);
      return;
      if (a.Grh == null) {
        a.Grh = new c();
      }
      ThreadPool.post(new a.j(paramg, (byte)0), "MMTraceRoute_start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.6
 * JD-Core Version:    0.7.0.1
 */