package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.ui.base.b;

final class w$10
  implements DialogInterface.OnCancelListener
{
  w$10(Intent paramIntent, Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.uNZ != null)
    {
      if (!(this.eRW instanceof LauncherUI)) {
        this.eRW.finish();
      }
      this.eRW.startActivity(this.uNZ);
      b.D(this.eRW, this.uNZ);
      w.bM(this.eRW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.w.10
 * JD-Core Version:    0.7.0.1
 */