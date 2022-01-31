package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$6
  implements am.a
{
  private int mCount = 0;
  
  b$6(b paramb, String paramString1, String paramString2, String paramString3) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.d(this.qcP));
    this.mCount += 1;
    if ((b.d(this.qcP) == 8) || (b.d(this.qcP) == 262) || (!d.bSm()))
    {
      y.i("MicroMsg.Voip.VoipSmallWindow", "CALLING_STATE_FINISH state..cancel notification..");
      ((a)g.t(a.class)).getNotification().cancel(40);
      if ((b.f(this.qcP) != null) && (!b.f(this.qcP).crl())) {
        b.f(this.qcP).stopTimer();
      }
      return false;
    }
    b localb = this.qcP;
    StringBuilder localStringBuilder = new StringBuilder().append(this.qcR);
    if (this.mCount % 2 == 1) {}
    for (String str = " ";; str = "")
    {
      localb.f(str, this.dYK, this.ezi, false);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b.6
 * JD-Core Version:    0.7.0.1
 */