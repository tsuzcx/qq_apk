package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipCSMainUI$9
  implements DialogInterface.OnClickListener
{
  VoipCSMainUI$9(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125450);
    paramDialogInterface.dismiss();
    this.CNO.VI(0);
    AppMethodBeat.o(125450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.9
 * JD-Core Version:    0.7.0.1
 */