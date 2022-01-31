package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$28
  implements DialogInterface.OnClickListener
{
  BaseScanUI$28(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80942);
    BaseScanUI.o(this.qwI);
    this.qwI.finish();
    AppMethodBeat.o(80942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.28
 * JD-Core Version:    0.7.0.1
 */