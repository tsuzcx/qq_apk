package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MsgRetransmitUI$16
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$16(MsgRetransmitUI paramMsgRetransmitUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35080);
    MsgRetransmitUI.a(this.Azx, this.Azx.getIntent(), this.efI);
    AppMethodBeat.o(35080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.16
 * JD-Core Version:    0.7.0.1
 */