package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class SnsUploadUI$15
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$15(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39751);
    if (SnsUploadUI.g(this.sbR) == 9)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yzV, "");
      SnsUploadUI.h(this.sbR);
      if ((SnsUploadUI.d(this.sbR) instanceof ad)) {
        SnsUploadUI.f(this.sbR).setText("");
      }
      switch (SnsUploadUI.g(this.sbR))
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      h.qsU.e(14247, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), SnsUploadUI.i(this.sbR), Long.valueOf(bo.aox()) });
      SnsUploadUI.k(this.sbR);
      AppMethodBeat.o(39751);
      return;
      g.RM();
      g.RL().Ru().set(ac.a.yzU, "");
      break;
      paramInt = 2;
      continue;
      paramInt = 4;
      continue;
      paramInt = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.15
 * JD-Core Version:    0.7.0.1
 */