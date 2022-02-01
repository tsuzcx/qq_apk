package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsUserUI$13
  implements DialogInterface.OnClickListener
{
  SnsUserUI$13(SnsUserUI paramSnsUserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(99639);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(99639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.13
 * JD-Core Version:    0.7.0.1
 */