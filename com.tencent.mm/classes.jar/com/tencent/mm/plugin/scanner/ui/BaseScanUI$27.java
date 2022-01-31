package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$27
  implements DialogInterface.OnClickListener
{
  BaseScanUI$27(BaseScanUI paramBaseScanUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80941);
    this.qwI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    BaseScanUI.o(this.qwI);
    this.qwI.finish();
    AppMethodBeat.o(80941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.27
 * JD-Core Version:    0.7.0.1
 */