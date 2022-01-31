package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class AppUpdaterUI$6
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$6(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28819);
    if ((AppUpdaterUI.b(this.ykv) != null) && (!AppUpdaterUI.b(this.ykv).isShowing())) {
      AppUpdaterUI.b(this.ykv).show();
    }
    AppMethodBeat.o(28819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.6
 * JD-Core Version:    0.7.0.1
 */