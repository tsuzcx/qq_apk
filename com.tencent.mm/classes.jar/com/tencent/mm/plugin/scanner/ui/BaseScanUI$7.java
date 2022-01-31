package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class BaseScanUI$7
  implements DialogInterface.OnClickListener
{
  BaseScanUI$7(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseScanUI.b(this.nJg, true);
    BaseScanUI.A(this.nJg);
    BaseScanUI.B(this.nJg);
    this.nJg.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.7
 * JD-Core Version:    0.7.0.1
 */