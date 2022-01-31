package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;

final class n$4
  implements DialogInterface.OnClickListener
{
  n$4(n paramn, int paramInt, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29510);
    if (this.jMc == 33) {
      e.qrI.idkeyStat(462L, 12L, 1L, true);
    }
    for (;;)
    {
      Intent localIntent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localIntent.addFlags(268435456);
      this.val$activity.startActivity(localIntent);
      paramDialogInterface.dismiss();
      this.yZP.gzb = true;
      MMAppMgr.l(this.val$activity, true);
      this.val$activity.finish();
      AppMethodBeat.o(29510);
      return;
      if (this.jMc == 97) {
        e.qrI.idkeyStat(462L, 13L, 1L, true);
      } else {
        e.qrI.idkeyStat(462L, 14L, 1L, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.n.4
 * JD-Core Version:    0.7.0.1
 */