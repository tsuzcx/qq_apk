package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.j;

final class MsgRetransmitUI$7
  implements DialogInterface.OnCancelListener
{
  MsgRetransmitUI$7(MsgRetransmitUI paramMsgRetransmitUI, j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(35069);
    this.zJg.dlb();
    this.Azx.Azw = true;
    this.Azx.finish();
    AppMethodBeat.o(35069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.7
 * JD-Core Version:    0.7.0.1
 */