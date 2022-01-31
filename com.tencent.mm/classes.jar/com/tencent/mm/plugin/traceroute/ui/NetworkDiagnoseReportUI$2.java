package com.tencent.mm.plugin.traceroute.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NetworkDiagnoseReportUI$2
  implements MenuItem.OnMenuItemClickListener
{
  NetworkDiagnoseReportUI$2(NetworkDiagnoseReportUI paramNetworkDiagnoseReportUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26017);
    this.tnG.finish();
    AppMethodBeat.o(26017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseReportUI.2
 * JD-Core Version:    0.7.0.1
 */