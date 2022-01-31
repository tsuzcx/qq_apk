package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.f;

final class p$3
  implements DialogInterface.OnClickListener
{
  p$3(p paramp, int paramInt, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.hSt == 32) {
      f.nEG.a(462L, 6L, 1L, true);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      MMAppMgr.i(this.val$activity, true);
      this.val$activity.finish();
      return;
      if (this.hSt == 96) {
        f.nEG.a(462L, 7L, 1L, true);
      } else {
        f.nEG.a(462L, 8L, 1L, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.p.3
 * JD-Core Version:    0.7.0.1
 */