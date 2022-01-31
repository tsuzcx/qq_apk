package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.j;

final class SnsUploadUI$14
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$14(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39750);
    paramDialogInterface = Parcel.obtain();
    this.sbR.getIntent().putExtra(e.j.yVi, SnsUploadUI.f(this.sbR).getText().toString());
    this.sbR.getIntent().putExtra("KparseLen", SnsUploadUI.f(this.sbR).getPasterLen());
    this.sbR.getIntent().writeToParcel(paramDialogInterface, 0);
    paramDialogInterface = paramDialogInterface.marshall();
    if (SnsUploadUI.g(this.sbR) == 9)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yzV, com.tencent.e.f.e.bytesToHexString(paramDialogInterface));
      SnsUploadUI.h(this.sbR);
      switch (SnsUploadUI.g(this.sbR))
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      h.qsU.e(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), SnsUploadUI.i(this.sbR), Long.valueOf(bo.aox()) });
      SnsUploadUI.j(this.sbR);
      AppMethodBeat.o(39750);
      return;
      g.RM();
      g.RL().Ru().set(ac.a.yzU, com.tencent.e.f.e.bytesToHexString(paramDialogInterface));
      break;
      paramInt = 1;
      continue;
      paramInt = 3;
      continue;
      paramInt = 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.14
 * JD-Core Version:    0.7.0.1
 */