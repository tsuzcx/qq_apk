package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MsgRetransmitUI$21
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$21(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35085);
    this.Azx.finish();
    AppMethodBeat.o(35085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.21
 * JD-Core Version:    0.7.0.1
 */