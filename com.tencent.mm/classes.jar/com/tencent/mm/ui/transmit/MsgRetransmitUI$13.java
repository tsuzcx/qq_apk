package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MsgRetransmitUI$13
  implements DialogInterface.OnCancelListener
{
  MsgRetransmitUI$13(MsgRetransmitUI paramMsgRetransmitUI, MsgRetransmitUI.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(35076);
    this.zCq.AzG = true;
    this.Azx.finish();
    AppMethodBeat.o(35076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.13
 * JD-Core Version:    0.7.0.1
 */