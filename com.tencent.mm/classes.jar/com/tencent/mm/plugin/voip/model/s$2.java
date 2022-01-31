package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class s$2
  implements am.a
{
  s$2(s params) {}
  
  public final boolean tC()
  {
    Object localObject = this.pTW.pNq;
    ((j)localObject).pQm += 1;
    if (this.pTW.pNq.pQe.lpD == 0)
    {
      a.Loge("MicroMsg.Voip.VoipServiceEx", g.zI() + "double link switch roomId == 0 ");
      s.a(this.pTW).stopTimer();
    }
    do
    {
      return true;
      this.pTW.pNq.pQe.app2EngineDataEx(this.pTW.pNq.pQe.pVD, this.pTW.pNq.pQe.pVE, this.pTW.pNq.pQe.pVF, 0, 0);
      if ((!this.pTW.pNq.pQl) && (1 == this.pTW.pNq.pQe.field_mGetValidSample))
      {
        this.pTW.pNq.pQl = true;
        this.pTW.pNq.pQn = this.pTW.pNq.pQm;
      }
      if (1 == this.pTW.pNq.pPR) {
        this.pTW.pNq.pPR = 15;
      }
    } while ((true != this.pTW.pNq.pQl) || (this.pTW.pNq.pQm - this.pTW.pNq.pQn != this.pTW.pNq.pPR) || ((this.pTW.pNq.pQe.pVu & 0x1) != 0));
    this.pTW.pNq.pQn = this.pTW.pNq.pQm;
    int i = this.pTW.pNq.pQe.isDCSameLan();
    int k = this.pTW.pNq.pQe.getCurrentConnType();
    if ((1 == i) && (1 == k))
    {
      a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = " + i);
      localObject = this.pTW.pNq;
      ((j)localObject).pQm += 1;
      return true;
    }
    int m = this.pTW.pNq.pQe.getcurstrategy();
    int n = this.pTW.pNq.pQe.isRelayConnReady();
    int i1 = this.pTW.pNq.pQe.isDCReady();
    int j = this.pTW.pNq.pPR - 3;
    i = j;
    if (j > 15) {
      i = 15;
    }
    this.pTW.pNq.pQe.app2EngineLinkQualityEx(i, s.b(this.pTW));
    new d(this.pTW.pNq.pQe.lpD, this.pTW.pNq.pQe.lpE, this.pTW.pNq.pQe.lpL, k, n, i1, m, s.b(this.pTW), this.pTW.pNq.pQe.field_realLinkQualityInfoBuffLen).bRB();
    localObject = this.pTW.pNq.pQe;
    ((v2protocal)localObject).pVw += 1;
    a.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + this.pTW.pNq.pPR + " isFirstValidSampleSet " + this.pTW.pNq.pQl + " mGetValidSample " + this.pTW.pNq.pQe.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + this.pTW.pNq.pQe.pVw + "mTimerCounter " + this.pTW.pNq.pQm + "mLastSwitchTimer " + this.pTW.pNq.pQn);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s.2
 * JD-Core Version:    0.7.0.1
 */