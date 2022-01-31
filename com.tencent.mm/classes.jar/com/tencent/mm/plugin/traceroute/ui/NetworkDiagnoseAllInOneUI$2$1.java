package com.tencent.mm.plugin.traceroute.ui;

import android.widget.Button;
import com.tencent.mm.ui.base.p;

final class NetworkDiagnoseAllInOneUI$2$1
  implements Runnable
{
  NetworkDiagnoseAllInOneUI$2$1(NetworkDiagnoseAllInOneUI.2 param2) {}
  
  public final void run()
  {
    NetworkDiagnoseAllInOneUI.h(this.pJh.pJe).setEnabled(true);
    if ((NetworkDiagnoseAllInOneUI.i(this.pJh.pJe) != null) && (NetworkDiagnoseAllInOneUI.i(this.pJh.pJe).isShowing())) {
      NetworkDiagnoseAllInOneUI.i(this.pJh.pJe).dismiss();
    }
    NetworkDiagnoseAllInOneUI.b(this.pJh.pJe, 6);
    NetworkDiagnoseAllInOneUI.b(this.pJh.pJe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.2.1
 * JD-Core Version:    0.7.0.1
 */