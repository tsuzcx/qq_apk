package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$14
  implements DialogInterface.OnClickListener
{
  BaseScanUI$14(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(138470);
    BaseScanUI.a(this.qwI, true);
    BaseScanUI.E(this.qwI);
    BaseScanUI.F(this.qwI);
    this.qwI.overridePendingTransition(0, 0);
    AppMethodBeat.o(138470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.14
 * JD-Core Version:    0.7.0.1
 */