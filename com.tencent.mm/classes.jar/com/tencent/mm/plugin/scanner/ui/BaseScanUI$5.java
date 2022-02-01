package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class BaseScanUI$5
  implements DialogInterface.OnClickListener
{
  BaseScanUI$5(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(314956);
    Log.i("MicroMsg.ScanUI", "checkCameraUsing user confirm and finish");
    this.OYm.dmh();
    AppMethodBeat.o(314956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.5
 * JD-Core Version:    0.7.0.1
 */