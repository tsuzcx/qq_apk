package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.notification.ui.b;
import com.tencent.mm.plugin.report.service.h;

final class a$3
  implements b
{
  a$3(a parama) {}
  
  public final void bpA()
  {
    h.nFQ.f(11425, new Object[] { Integer.valueOf(this.mIE.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    this.mIE.bpv();
    this.mIE.bpx();
    if (!this.mIE.mIw) {
      this.mIE.mIv.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.3
 * JD-Core Version:    0.7.0.1
 */