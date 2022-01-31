package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.b;

final class w$5
  implements DialogInterface.OnCancelListener
{
  w$5(Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    h.nFQ.a(405L, 39L, 1L, true);
    if (this.uNZ != null)
    {
      this.eRW.finish();
      this.eRW.startActivity(this.uNZ);
      b.D(this.eRW, this.uNZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.w.5
 * JD-Core Version:    0.7.0.1
 */