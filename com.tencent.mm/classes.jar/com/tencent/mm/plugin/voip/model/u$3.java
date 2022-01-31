package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.f;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class u$3
  implements ap.a
{
  u$3(u paramu) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(4645);
    if (this.tzy.ttm.tvj.nMZ == 0)
    {
      a.Loge("MicroMsg.Voip.VoipServiceEx", g.Ml() + " roomId == 0 ");
      u.c(this.tzy).stopTimer();
    }
    label138:
    for (;;)
    {
      AppMethodBeat.o(4645);
      return true;
      if (this.tzy.ttm.mStatus >= 5) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label138;
        }
        new f(this.tzy.ttm.tvj.nMZ, this.tzy.ttm.tvj.nNa, this.tzy.ttm.tvw).cOs();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u.3
 * JD-Core Version:    0.7.0.1
 */