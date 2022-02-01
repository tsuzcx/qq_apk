package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$17
  implements DialogInterface.OnClickListener
{
  BaseScanUI$17(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(169977);
    BaseScanUI.Q(this.CJV);
    this.CJV.finish();
    AppMethodBeat.o(169977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.17
 * JD-Core Version:    0.7.0.1
 */