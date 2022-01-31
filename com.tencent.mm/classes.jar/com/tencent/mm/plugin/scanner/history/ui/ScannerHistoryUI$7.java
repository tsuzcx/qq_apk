package com.tencent.mm.plugin.scanner.history.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ScannerHistoryUI$7
  implements DialogInterface.OnClickListener
{
  ScannerHistoryUI$7(ScannerHistoryUI paramScannerHistoryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80806);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(80806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */