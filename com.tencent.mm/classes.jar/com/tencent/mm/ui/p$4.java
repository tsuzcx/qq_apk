package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.f;

final class p$4
  implements DialogInterface.OnClickListener
{
  p$4(p paramp, int paramInt, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.hSt == 33) {
      f.nEG.a(462L, 12L, 1L, true);
    }
    for (;;)
    {
      Intent localIntent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localIntent.addFlags(268435456);
      this.val$activity.startActivity(localIntent);
      paramDialogInterface.dismiss();
      this.uLK.fht = true;
      MMAppMgr.i(this.val$activity, true);
      this.val$activity.finish();
      return;
      if (this.hSt == 97) {
        f.nEG.a(462L, 13L, 1L, true);
      } else {
        f.nEG.a(462L, 14L, 1L, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.p.4
 * JD-Core Version:    0.7.0.1
 */