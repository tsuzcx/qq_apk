package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class SnsUploadUI$13
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$13(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SnsUploadUI.g(this.pjp) == 9)
    {
      g.DQ();
      g.DP().Dz().c(ac.a.upV, "");
    }
    for (;;)
    {
      SnsUploadUI.h(this.pjp);
      SnsUploadUI.k(this.pjp);
      return;
      g.DQ();
      g.DP().Dz().c(ac.a.upU, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.13
 * JD-Core Version:    0.7.0.1
 */