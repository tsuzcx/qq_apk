package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class MsgRetransmitUI$4
  implements DialogInterface.OnCancelListener
{
  MsgRetransmitUI$4(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(35066);
    h.a(this.Azx, 2131301640, 2131297087, 2131297115, 2131297014, new MsgRetransmitUI.4.1(this), new MsgRetransmitUI.4.2(this));
    AppMethodBeat.o(35066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.4
 * JD-Core Version:    0.7.0.1
 */