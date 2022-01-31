package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class u$2
  implements ap.a
{
  u$2(u paramu) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(4644);
    Object localObject = this.tzy.ttm;
    ((k)localObject).tvr += 1;
    if (this.tzy.ttm.tvj.nMZ == 0)
    {
      a.Loge("MicroMsg.Voip.VoipServiceEx", g.Ml() + "double link switch roomId == 0 ");
      u.a(this.tzy).stopTimer();
    }
    for (;;)
    {
      AppMethodBeat.o(4644);
      return true;
      this.tzy.ttm.tvj.app2EngineDataEx(this.tzy.ttm.tvj.tBi, this.tzy.ttm.tvj.tBj, this.tzy.ttm.tvj.tBk, 0, 0);
      if ((!this.tzy.ttm.tvq) && (1 == this.tzy.ttm.tvj.field_mGetValidSample))
      {
        this.tzy.ttm.tvq = true;
        this.tzy.ttm.tvs = this.tzy.ttm.tvr;
      }
      if (1 == this.tzy.ttm.tuW) {
        this.tzy.ttm.tuW = 15;
      }
      if ((true == this.tzy.ttm.tvq) && (this.tzy.ttm.tvr - this.tzy.ttm.tvs == this.tzy.ttm.tuW) && ((this.tzy.ttm.tvj.tAZ & 0x1) == 0))
      {
        this.tzy.ttm.tvs = this.tzy.ttm.tvr;
        int i = this.tzy.ttm.tvj.isDCSameLan();
        int k = this.tzy.ttm.tvj.getCurrentConnType();
        if ((1 == i) && (1 == k))
        {
          a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
          localObject = this.tzy.ttm;
          ((k)localObject).tvr += 1;
          AppMethodBeat.o(4644);
          return true;
        }
        int m = this.tzy.ttm.tvj.getcurstrategy();
        int n = this.tzy.ttm.tvj.isRelayConnReady();
        int i1 = this.tzy.ttm.tvj.isDCReady();
        int j = this.tzy.ttm.tuW - 3;
        i = j;
        if (j > 15) {
          i = 15;
        }
        this.tzy.ttm.tvj.app2EngineLinkQualityEx(i, u.b(this.tzy));
        new d(this.tzy.ttm.tvj.nMZ, this.tzy.ttm.tvj.nNa, this.tzy.ttm.tvj.nNh, k, n, i1, m, u.b(this.tzy), this.tzy.ttm.tvj.field_realLinkQualityInfoBuffLen).cOs();
        localObject = this.tzy.ttm.tvj;
        ((v2protocal)localObject).tBb += 1;
        a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + this.tzy.ttm.tuW + " isFirstValidSampleSet " + this.tzy.ttm.tvq + " mGetValidSample " + this.tzy.ttm.tvj.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + this.tzy.ttm.tvj.tBb + "mTimerCounter " + this.tzy.ttm.tvr + "mLastSwitchTimer " + this.tzy.ttm.tvs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u.2
 * JD-Core Version:    0.7.0.1
 */