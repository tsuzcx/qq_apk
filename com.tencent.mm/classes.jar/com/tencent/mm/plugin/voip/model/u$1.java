package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.sdk.platformtools.ap.a;

final class u$1
  implements ap.a
{
  u$1(u paramu) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(4643);
    if (this.tzy.ttm.tvj.tAa == 1)
    {
      k localk = this.tzy.ttm;
      if ((localk.mStatus != 2) && (localk.mStatus != 4)) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        a.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
        this.tzy.ttm.tvj.tBN.twb = 101;
        h.qsU.e(11521, new Object[] { Integer.valueOf(b.cLC().cNU()), Long.valueOf(b.cLC().cNV()), Long.valueOf(b.cLC().cMb()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
        this.tzy.cOg();
        this.tzy.ttm.tvk.cMZ();
      }
      AppMethodBeat.o(4643);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u.1
 * JD-Core Version:    0.7.0.1
 */