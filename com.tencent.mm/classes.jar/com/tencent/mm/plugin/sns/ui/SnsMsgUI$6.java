package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class SnsMsgUI$6
  implements DialogInterface.OnCancelListener
{
  SnsMsgUI$6(SnsMsgUI paramSnsMsgUI, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.DQ();
    g.DO().dJT.c(this.par);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.6
 * JD-Core Version:    0.7.0.1
 */