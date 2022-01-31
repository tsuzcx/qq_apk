package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;

final class AppUpdaterUI$5
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$5(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
    if ((AppUpdaterUI.b(this.ucg) != null) && (AppUpdaterUI.b(this.ucg).isShowing())) {
      AppUpdaterUI.b(this.ucg).dismiss();
    }
    AppUpdaterUI.a(this.ucg, 6);
    if (AppUpdaterUI.e(this.ucg).udt)
    {
      h.nFQ.a(614L, 59L, 1L, true);
      y.d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
    }
    AppUpdaterUI.e(this.ucg).cancel();
    AppUpdaterUI.e(this.ucg).an(2, true);
    AppUpdaterUI.f(this.ucg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.5
 * JD-Core Version:    0.7.0.1
 */