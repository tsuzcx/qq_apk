package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$22
  implements DialogInterface.OnClickListener
{
  BaseScanUI$22(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(51707);
    BaseScanUI.Q(this.yqg);
    this.yqg.finish();
    AppMethodBeat.o(51707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.22
 * JD-Core Version:    0.7.0.1
 */