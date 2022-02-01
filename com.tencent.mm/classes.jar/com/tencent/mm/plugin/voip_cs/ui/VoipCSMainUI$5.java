package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipCSMainUI$5
  implements DialogInterface.OnClickListener
{
  VoipCSMainUI$5(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(193490);
    paramDialogInterface.dismiss();
    this.CNO.VI(2);
    AppMethodBeat.o(193490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.5
 * JD-Core Version:    0.7.0.1
 */