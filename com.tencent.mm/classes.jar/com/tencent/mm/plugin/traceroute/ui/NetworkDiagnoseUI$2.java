package com.tencent.mm.plugin.traceroute.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MMProgressBar;

final class NetworkDiagnoseUI$2
  extends ak
{
  NetworkDiagnoseUI$2(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(26024);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26024);
      return;
      if (NetworkDiagnoseUI.b(this.tnM) < 95) {
        NetworkDiagnoseUI.c(this.tnM).setProgress(95);
      }
      NetworkDiagnoseUI.d(this.tnM).cKG();
      AppMethodBeat.o(26024);
      return;
      NetworkDiagnoseUI.e(this.tnM);
      if (NetworkDiagnoseUI.b(this.tnM) < 95) {
        NetworkDiagnoseUI.c(this.tnM).setProgress(95);
      }
      NetworkDiagnoseUI.d(this.tnM).cKG();
      AppMethodBeat.o(26024);
      return;
      NetworkDiagnoseUI.c(this.tnM).setProgress(100);
      NetworkDiagnoseUI.a(this.tnM, false);
      AppMethodBeat.o(26024);
      return;
      NetworkDiagnoseUI.c(this.tnM).setProgress(100);
      NetworkDiagnoseUI.a(this.tnM, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.2
 * JD-Core Version:    0.7.0.1
 */