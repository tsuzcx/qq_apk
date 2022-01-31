package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.h.a.ob;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class d$3
  implements Runnable
{
  d$3(d paramd, long paramLong, bi parambi) {}
  
  public final void run()
  {
    y.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(this.byn) });
    ob localob = new ob();
    localob.bXM.bFH = this.dUy;
    a.udP.m(localob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d.3
 * JD-Core Version:    0.7.0.1
 */