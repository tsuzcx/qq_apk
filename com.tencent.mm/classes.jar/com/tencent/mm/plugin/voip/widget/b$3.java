package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements am.a
{
  b$3(b paramb) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.d(this.qcP));
    if ((b.d(this.qcP) == 8) || (b.d(this.qcP) == 262) || (!d.bSm()))
    {
      ((a)g.t(a.class)).getNotification().cancel(40);
      y.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking...CALLING_STATE_FINISH state..cancel notification..");
      if ((b.f(this.qcP) != null) && (!b.f(this.qcP).crl())) {
        b.f(this.qcP).stopTimer();
      }
      return false;
    }
    y.i("MicroMsg.Voip.VoipSmallWindow", "show voice talking, first timer trigger..");
    String str = b.g(this.qcP);
    this.qcP.f(str, r.gV(b.c(this.qcP).field_username), str, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b.3
 * JD-Core Version:    0.7.0.1
 */