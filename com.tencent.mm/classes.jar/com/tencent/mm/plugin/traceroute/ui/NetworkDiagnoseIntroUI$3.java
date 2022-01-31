package com.tencent.mm.plugin.traceroute.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NetworkDiagnoseIntroUI$3
  implements MenuItem.OnMenuItemClickListener
{
  NetworkDiagnoseIntroUI$3(NetworkDiagnoseIntroUI paramNetworkDiagnoseIntroUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26013);
    this.tny.finish();
    AppMethodBeat.o(26013);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI.3
 * JD-Core Version:    0.7.0.1
 */