package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$19
  implements DialogInterface.OnClickListener
{
  BaseScanUI$19(BaseScanUI paramBaseScanUI)
  {
    AppMethodBeat.i(161006);
    AppMethodBeat.o(161006);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(169979);
    BaseScanUI.I(this.vRt);
    this.vRt.finish();
    AppMethodBeat.o(169979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.19
 * JD-Core Version:    0.7.0.1
 */