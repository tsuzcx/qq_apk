package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class MsgRetransmitUI$4$2
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$4$2(MsgRetransmitUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35065);
    if (MsgRetransmitUI.b(this.Azy.Azx) != null) {
      MsgRetransmitUI.b(this.Azy.Azx).show();
    }
    AppMethodBeat.o(35065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.4.2
 * JD-Core Version:    0.7.0.1
 */