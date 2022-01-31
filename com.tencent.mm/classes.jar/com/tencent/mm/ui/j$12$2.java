package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ab;

final class j$12$2
  implements DialogInterface.OnCancelListener
{
  j$12$2(j.12 param12, ab paramab) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().b(384, this.uJS.uJI.uJD);
    this.uJS.uJI.uJD = null;
    au.Dk().c(this.feF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.j.12.2
 * JD-Core Version:    0.7.0.1
 */