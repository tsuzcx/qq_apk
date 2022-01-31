package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.h.a.od;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$3
  implements Runnable
{
  e$3(e parame, long paramLong) {}
  
  public final void run()
  {
    y.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[] { Long.valueOf(this.byn) });
    od localod = new od();
    localod.bXQ.bXR = ((int)this.byn);
    a.udP.m(localod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e.3
 * JD-Core Version:    0.7.0.1
 */