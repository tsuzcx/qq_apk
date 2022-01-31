package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipCSMainUI$15
  implements DialogInterface.OnClickListener
{
  VoipCSMainUI$15(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(135403);
    paramDialogInterface.dismiss();
    this.tLK.Ic(9);
    AppMethodBeat.o(135403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.15
 * JD-Core Version:    0.7.0.1
 */