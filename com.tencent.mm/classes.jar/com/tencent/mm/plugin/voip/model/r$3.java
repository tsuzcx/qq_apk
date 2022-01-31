package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class r$3
  implements am.a
{
  r$3(r paramr) {}
  
  public final boolean tC()
  {
    y.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
    if (r.c(this.pTG) == null)
    {
      r.d(this.pTG);
      r.e(this.pTG).stopTimer();
      return false;
    }
    if (r.em(ae.getContext()))
    {
      this.pTG.T(r.c(this.pTG).sST, r.c(this.pTG).sSU);
      this.pTG.a(r.c(this.pTG));
      r.f(this.pTG);
      r.d(this.pTG);
      r.e(this.pTG).stopTimer();
      h.nFQ.a(500L, 5L, 1L, false);
      return false;
    }
    if (System.currentTimeMillis() - r.g(this.pTG) < 60000L) {
      return true;
    }
    r.f(this.pTG);
    r.d(this.pTG);
    r.e(this.pTG).stopTimer();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r.3
 * JD-Core Version:    0.7.0.1
 */