package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.f;

final class p$2
  implements DialogInterface.OnClickListener
{
  p$2(p paramp, int paramInt, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.hSt == 32) {
      f.nEG.a(462L, 3L, 1L, true);
    }
    for (;;)
    {
      Intent localIntent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localIntent.addFlags(268435456);
      this.val$activity.startActivity(localIntent);
      paramDialogInterface.dismiss();
      MMAppMgr.i(this.val$activity, true);
      this.val$activity.finish();
      return;
      if (this.hSt == 96) {
        f.nEG.a(462L, 4L, 1L, true);
      } else {
        f.nEG.a(462L, 5L, 1L, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.p.2
 * JD-Core Version:    0.7.0.1
 */