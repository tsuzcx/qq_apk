package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUploadConfigView$8$1
  implements DialogInterface.OnClickListener
{
  SnsUploadConfigView$8$1(SnsUploadConfigView.8 param8) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39694);
    paramDialogInterface = this.sbD.sbB;
    if (SnsUploadConfigView.d(this.sbD.sbB)) {}
    for (boolean bool = false;; bool = true)
    {
      SnsUploadConfigView.b(paramDialogInterface, bool);
      SnsUploadConfigView.e(this.sbD.sbB);
      AppMethodBeat.o(39694);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.8.1
 * JD-Core Version:    0.7.0.1
 */