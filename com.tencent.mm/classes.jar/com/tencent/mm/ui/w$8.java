package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.ui.base.b;

final class w$8
  implements DialogInterface.OnClickListener
{
  w$8(Intent paramIntent, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.w.8
 * JD-Core Version:    0.7.0.1
 */