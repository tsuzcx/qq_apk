package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class SnsUploadUI$16
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$16(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39752);
    if (SnsUploadUI.g(this.sbR) == 9)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yzV, "");
    }
    for (;;)
    {
      SnsUploadUI.h(this.sbR);
      SnsUploadUI.k(this.sbR);
      AppMethodBeat.o(39752);
      return;
      g.RM();
      g.RL().Ru().set(ac.a.yzU, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.16
 * JD-Core Version:    0.7.0.1
 */