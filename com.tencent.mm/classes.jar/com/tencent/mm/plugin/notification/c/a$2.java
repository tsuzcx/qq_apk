package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements com.tencent.mm.plugin.notification.ui.a
{
  a$2(a parama) {}
  
  public final void bpy()
  {
    y.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
    ai.d(new Runnable()
    {
      public final void run()
      {
        h.nFQ.f(11425, new Object[] { Integer.valueOf(a.2.this.mIE.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
        a.2.this.mIE.bpv();
        a.a(a.2.this.mIE);
        a.2.this.mIE.bpo();
      }
    });
  }
  
  public final void bpz()
  {
    y.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
    ai.d(new Runnable()
    {
      public final void run()
      {
        h.nFQ.f(11425, new Object[] { Integer.valueOf(a.2.this.mIE.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
        a.2.this.mIE.bpv();
        a.2.this.mIE.bpr();
        a.b(a.2.this.mIE);
        a.2.this.mIE.mIv.dismiss();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.2
 * JD-Core Version:    0.7.0.1
 */