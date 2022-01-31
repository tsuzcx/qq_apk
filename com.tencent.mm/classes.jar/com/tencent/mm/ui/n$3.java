package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;

final class n$3
  implements DialogInterface.OnClickListener
{
  n$3(n paramn, int paramInt, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29509);
    if (this.jMc == 32) {
      e.qrI.idkeyStat(462L, 6L, 1L, true);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      MMAppMgr.l(this.val$activity, true);
      this.val$activity.finish();
      AppMethodBeat.o(29509);
      return;
      if (this.jMc == 96) {
        e.qrI.idkeyStat(462L, 7L, 1L, true);
      } else {
        e.qrI.idkeyStat(462L, 8L, 1L, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.n.3
 * JD-Core Version:    0.7.0.1
 */