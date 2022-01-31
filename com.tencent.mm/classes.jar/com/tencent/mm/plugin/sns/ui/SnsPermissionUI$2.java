package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.w;

final class SnsPermissionUI$2
  implements DialogInterface.OnCancelListener
{
  SnsPermissionUI$2(SnsPermissionUI paramSnsPermissionUI, w paramw) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    SnsPermissionUI.a(this.pbB);
    g.DQ();
    g.DO().dJT.c(this.pbC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI.2
 * JD-Core Version:    0.7.0.1
 */