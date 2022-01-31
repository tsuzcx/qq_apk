package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import com.tencent.mm.pluginsdk.model.j.a;

final class MsgRetransmitUI$6
  implements j.a
{
  MsgRetransmitUI$6(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void ckA()
  {
    if (MsgRetransmitUI.f(this.wgG) != null)
    {
      MsgRetransmitUI.f(this.wgG).dismiss();
      MsgRetransmitUI.g(this.wgG);
    }
    this.wgG.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.6
 * JD-Core Version:    0.7.0.1
 */