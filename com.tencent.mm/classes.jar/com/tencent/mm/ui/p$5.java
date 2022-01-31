package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.f;

final class p$5
  implements DialogInterface.OnClickListener
{
  p$5(p paramp, int paramInt, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.hSt == 33) {
      f.nEG.a(462L, 15L, 1L, true);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      this.uLK.fht = true;
      MMAppMgr.i(this.val$activity, true);
      this.val$activity.finish();
      return;
      if (this.hSt == 97) {
        f.nEG.a(462L, 16L, 1L, true);
      } else {
        f.nEG.a(462L, 17L, 1L, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.p.5
 * JD-Core Version:    0.7.0.1
 */