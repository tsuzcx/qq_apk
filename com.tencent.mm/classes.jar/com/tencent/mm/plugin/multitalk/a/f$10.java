package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class f$10
  implements am.a
{
  f$10(f paramf) {}
  
  public final boolean tC()
  {
    y.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
    if (this.mtZ.mtT == null)
    {
      this.mtZ.mtU = 0L;
      this.mtZ.mtV.stopTimer();
      return false;
    }
    if (f.dR(ae.getContext()))
    {
      this.mtZ.b(this.mtZ.mtT);
      this.mtZ.mtT = null;
      this.mtZ.mtU = 0L;
      this.mtZ.mtV.stopTimer();
      h.nFQ.a(500L, 7L, 1L, false);
      return false;
    }
    if (System.currentTimeMillis() - this.mtZ.mtU < 60000L) {
      return true;
    }
    this.mtZ.mtT = null;
    this.mtZ.mtU = 0L;
    this.mtZ.mtV.stopTimer();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.10
 * JD-Core Version:    0.7.0.1
 */