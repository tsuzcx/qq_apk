package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class SnsUploadUI$12
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$12(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SnsUploadUI.g(this.pjp) == 9)
    {
      g.DQ();
      g.DP().Dz().c(ac.a.upV, "");
      SnsUploadUI.h(this.pjp);
      if ((SnsUploadUI.d(this.pjp) instanceof ad)) {
        SnsUploadUI.f(this.pjp).setText("");
      }
      switch (SnsUploadUI.g(this.pjp))
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      h.nFQ.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), SnsUploadUI.i(this.pjp), Long.valueOf(bk.UX()) });
      SnsUploadUI.k(this.pjp);
      return;
      g.DQ();
      g.DP().Dz().c(ac.a.upU, "");
      break;
      paramInt = 2;
      continue;
      paramInt = 4;
      continue;
      paramInt = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.12
 * JD-Core Version:    0.7.0.1
 */