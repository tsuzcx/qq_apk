package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.sdk.platformtools.am.a;

final class s$1
  implements am.a
{
  s$1(s params) {}
  
  public final boolean tC()
  {
    if (this.pTW.pNq.pQe.pUz == 1)
    {
      j localj = this.pTW.pNq;
      if ((localj.mStatus != 2) && (localj.mStatus != 4)) {
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        a.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
        this.pTW.pNq.pQe.pWi.pQU = 101;
        h.nFQ.f(11521, new Object[] { Integer.valueOf(b.bPx().bRd()), Long.valueOf(b.bPx().bRe()), Long.valueOf(b.bPx().bRf()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
        this.pTW.bRs();
        this.pTW.pNq.pQf.bQH();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s.1
 * JD-Core Version:    0.7.0.1
 */