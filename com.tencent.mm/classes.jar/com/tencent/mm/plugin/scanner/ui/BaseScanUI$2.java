package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$2
  implements DialogInterface.OnClickListener
{
  BaseScanUI$2(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80912);
    this.qwI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    BaseScanUI.b(this.qwI, true);
    this.qwI.finish();
    AppMethodBeat.o(80912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.2
 * JD-Core Version:    0.7.0.1
 */