package com.tencent.mm.plugin.traceroute.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NetworkDiagnoseReportUI$1
  implements MenuItem.OnMenuItemClickListener
{
  NetworkDiagnoseReportUI$1(NetworkDiagnoseReportUI paramNetworkDiagnoseReportUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26016);
    this.tnG.finish();
    AppMethodBeat.o(26016);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.1
 * JD-Core Version:    0.7.0.1
 */