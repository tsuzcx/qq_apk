package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NetworkDiagnoseUI$7
  implements DialogInterface.OnClickListener
{
  NetworkDiagnoseUI$7(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(26033);
    NetworkDiagnoseUI.e(this.tnM);
    this.tnM.finish();
    AppMethodBeat.o(26033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.7
 * JD-Core Version:    0.7.0.1
 */