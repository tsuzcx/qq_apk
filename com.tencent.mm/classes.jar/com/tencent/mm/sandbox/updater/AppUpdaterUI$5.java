package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;

final class AppUpdaterUI$5
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$5(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28818);
    ab.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
    if ((AppUpdaterUI.b(this.ykv) != null) && (AppUpdaterUI.b(this.ykv).isShowing())) {
      AppUpdaterUI.b(this.ykv).dismiss();
    }
    AppUpdaterUI.a(this.ykv, 6);
    if (AppUpdaterUI.e(this.ykv).ylI)
    {
      h.qsU.idkeyStat(614L, 59L, 1L, true);
      ab.d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
    }
    AppUpdaterUI.e(this.ykv).cancel();
    AppUpdaterUI.e(this.ykv).aE(2, true);
    AppUpdaterUI.f(this.ykv);
    AppMethodBeat.o(28818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.5
 * JD-Core Version:    0.7.0.1
 */