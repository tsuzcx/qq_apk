package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcel;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.h;

final class SnsUploadUI$11
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$11(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = Parcel.obtain();
    this.pjp.getIntent().putExtra(e.h.uHV, SnsUploadUI.f(this.pjp).getText().toString());
    this.pjp.getIntent().writeToParcel(paramDialogInterface, 0);
    paramDialogInterface = paramDialogInterface.marshall();
    if (SnsUploadUI.g(this.pjp) == 9)
    {
      g.DQ();
      g.DP().Dz().c(ac.a.upV, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      SnsUploadUI.h(this.pjp);
      switch (SnsUploadUI.g(this.pjp))
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      h.nFQ.f(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), SnsUploadUI.i(this.pjp), Long.valueOf(bk.UX()) });
      SnsUploadUI.j(this.pjp);
      return;
      g.DQ();
      g.DP().Dz().c(ac.a.upU, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      break;
      paramInt = 1;
      continue;
      paramInt = 3;
      continue;
      paramInt = 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.11
 * JD-Core Version:    0.7.0.1
 */