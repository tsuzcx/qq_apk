package com.tencent.mm.plugin.traceroute.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class NetworkDiagnoseAllInOneUI$2$1
  implements Runnable
{
  NetworkDiagnoseAllInOneUI$2$1(NetworkDiagnoseAllInOneUI.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(25995);
    NetworkDiagnoseAllInOneUI.h(this.tnv.tns).setEnabled(true);
    if ((NetworkDiagnoseAllInOneUI.i(this.tnv.tns) != null) && (NetworkDiagnoseAllInOneUI.i(this.tnv.tns).isShowing())) {
      NetworkDiagnoseAllInOneUI.i(this.tnv.tns).dismiss();
    }
    NetworkDiagnoseAllInOneUI.b(this.tnv.tns, 6);
    NetworkDiagnoseAllInOneUI.b(this.tnv.tns);
    AppMethodBeat.o(25995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.2.1
 * JD-Core Version:    0.7.0.1
 */