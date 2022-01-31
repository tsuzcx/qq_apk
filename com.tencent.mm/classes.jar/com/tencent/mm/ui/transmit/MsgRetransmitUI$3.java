package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.a.c;

final class MsgRetransmitUI$3
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$3(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (MsgRetransmitUI.b(this.wgG) != null) {
      MsgRetransmitUI.b(this.wgG).cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.3
 * JD-Core Version:    0.7.0.1
 */