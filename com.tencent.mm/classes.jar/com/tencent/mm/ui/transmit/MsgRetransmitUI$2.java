package com.tencent.mm.ui.transmit;

import com.tencent.mm.R.l;
import com.tencent.mm.ah.g;
import com.tencent.mm.ah.m;
import com.tencent.mm.ui.widget.a.c;

final class MsgRetransmitUI$2
  implements g
{
  MsgRetransmitUI$2(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    if ((MsgRetransmitUI.b(this.wgG) == null) || (paramInt2 == 0)) {
      return;
    }
    paramInt1 = (int)(paramInt1 * 100L / paramInt2);
    MsgRetransmitUI.b(this.wgG).setMessage(this.wgG.getString(R.l.msgretr_uploading_img, new Object[] { Integer.valueOf(MsgRetransmitUI.c(this.wgG)), Integer.valueOf(MsgRetransmitUI.d(this.wgG)), Integer.valueOf(paramInt1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.2
 * JD-Core Version:    0.7.0.1
 */