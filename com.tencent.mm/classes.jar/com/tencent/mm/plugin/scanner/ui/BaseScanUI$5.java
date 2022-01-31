package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$5
  implements DialogInterface.OnClickListener
{
  BaseScanUI$5(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80915);
    BaseScanUI.o(this.qwI);
    this.qwI.finish();
    AppMethodBeat.o(80915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.5
 * JD-Core Version:    0.7.0.1
 */