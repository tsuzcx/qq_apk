package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MsgRetransmitUI$17
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$17(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35081);
    this.Azx.finish();
    AppMethodBeat.o(35081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.17
 * JD-Core Version:    0.7.0.1
 */