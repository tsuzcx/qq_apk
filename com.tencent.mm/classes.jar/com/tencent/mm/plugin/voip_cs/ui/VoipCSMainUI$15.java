package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class VoipCSMainUI$15
  implements DialogInterface.OnClickListener
{
  VoipCSMainUI$15(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125456);
    ae.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
    paramDialogInterface.dismiss();
    this.CNO.VI(8);
    AppMethodBeat.o(125456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.15
 * JD-Core Version:    0.7.0.1
 */