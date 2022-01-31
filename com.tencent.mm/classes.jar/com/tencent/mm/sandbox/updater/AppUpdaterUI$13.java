package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppUpdaterUI$13
  implements DialogInterface.OnCancelListener
{
  AppUpdaterUI$13(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(28828);
    ab.d("MicroMsg.AppUpdaterUI", "click cancel button");
    AppUpdaterUI.a(this.ykv, 12);
    AppUpdaterUI.i(this.ykv);
    AppMethodBeat.o(28828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.13
 * JD-Core Version:    0.7.0.1
 */