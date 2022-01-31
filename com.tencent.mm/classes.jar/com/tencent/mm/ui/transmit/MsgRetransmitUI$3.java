package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class MsgRetransmitUI$3
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$3(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35063);
    if (MsgRetransmitUI.b(this.Azx) != null) {
      MsgRetransmitUI.b(this.Azx).cancel();
    }
    AppMethodBeat.o(35063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.3
 * JD-Core Version:    0.7.0.1
 */