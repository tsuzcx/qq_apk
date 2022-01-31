package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$7
  implements DialogInterface.OnClickListener
{
  BaseScanUI$7(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(138461);
    BaseScanUI.b(this.qwI, true);
    this.qwI.finish();
    AppMethodBeat.o(138461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.7
 * JD-Core Version:    0.7.0.1
 */