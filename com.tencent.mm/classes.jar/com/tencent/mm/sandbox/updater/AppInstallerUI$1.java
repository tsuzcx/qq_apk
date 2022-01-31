package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppInstallerUI$1
  implements DialogInterface.OnCancelListener
{
  AppInstallerUI$1(AppInstallerUI paramAppInstallerUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(28797);
    AppInstallerUI.a(this.yko);
    AppMethodBeat.o(28797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI.1
 * JD-Core Version:    0.7.0.1
 */