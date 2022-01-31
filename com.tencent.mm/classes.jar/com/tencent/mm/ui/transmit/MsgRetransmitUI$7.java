package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.j;

final class MsgRetransmitUI$7
  implements DialogInterface.OnCancelListener
{
  MsgRetransmitUI$7(MsgRetransmitUI paramMsgRetransmitUI, j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.vto.ckw();
    this.wgG.wgF = true;
    this.wgG.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.7
 * JD-Core Version:    0.7.0.1
 */