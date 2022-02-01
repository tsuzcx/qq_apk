package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class SnsUploadUI$16
  implements DialogInterface.OnClickListener
{
  SnsUploadUI$16(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(307841);
    b.lx(this.REd.getContext());
    paramDialogInterface.dismiss();
    AppMethodBeat.o(307841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.16
 * JD-Core Version:    0.7.0.1
 */