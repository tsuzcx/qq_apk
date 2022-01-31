package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ab;

final class AppUpdaterUI$12
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$12(AppUpdaterUI paramAppUpdaterUI, c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28827);
    ab.d("MicroMsg.AppUpdaterUI", "click download button");
    AppUpdaterUI.a(this.ykv, 11);
    if (this.yky != null) {
      this.yky.deleteTempFile();
    }
    paramDialogInterface = AppUpdaterUI.e(this.ykv);
    paramDialogInterface.ylG = true;
    paramDialogInterface.drS();
    AppMethodBeat.o(28827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.12
 * JD-Core Version:    0.7.0.1
 */