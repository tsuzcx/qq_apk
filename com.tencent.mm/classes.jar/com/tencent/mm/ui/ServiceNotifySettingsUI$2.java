package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ServiceNotifySettingsUI$2
  implements DialogInterface.OnCancelListener
{
  ServiceNotifySettingsUI$2(ServiceNotifySettingsUI paramServiceNotifySettingsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29851);
    this.zeQ.finish();
    AppMethodBeat.o(29851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.2
 * JD-Core Version:    0.7.0.1
 */