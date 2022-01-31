package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class MsgRetransmitUI$4
  implements DialogInterface.OnCancelListener
{
  MsgRetransmitUI$4(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    h.a(this.wgG, R.l.msgretr_cancel_confirm, R.l.app_tip, R.l.app_yes, R.l.app_no, new MsgRetransmitUI.4.1(this), new MsgRetransmitUI.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.4
 * JD-Core Version:    0.7.0.1
 */