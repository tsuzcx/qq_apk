package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.h.a.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.b;

final class w$9
  implements DialogInterface.OnClickListener
{
  w$9(Intent paramIntent, Activity paramActivity) {}
  
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
      paramDialogInterface = new y();
      paramDialogInterface.bFX.bFY = true;
      a.udP.m(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.w.9
 * JD-Core Version:    0.7.0.1
 */