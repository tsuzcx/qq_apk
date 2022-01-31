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
    AppMethodBeat.i(135397);
    paramDialogInterface.dismiss();
    this.tLK.Ic(3);
    AppMethodBeat.o(135397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.9
 * JD-Core Version:    0.7.0.1
 */