package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.cfc;

final class d$1
  implements f
{
  d$1(d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.pUk.pQA.mStatus);
    if (paramInt2 != 0) {
      a.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:" + paramInt2);
    }
    do
    {
      return;
      paramString = (cfc)this.pUk.bRC();
      this.pUk.pQA.pPR = paramString.tvp;
    } while (this.pUk.pQA.pPR == 0);
    if (this.pUk.pQA.pQe.doubleLinkSwitch(paramString.tTN) == 0)
    {
      if (1 != paramString.tTN) {
        break label297;
      }
      paramm = this.pUk.pQA.pQe;
      paramm.pVx += 1;
    }
    for (;;)
    {
      a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramString.sST + " member " + paramString.tAN + " key " + paramString.sSU + "report flag " + paramString.tvp + "switch to link type " + paramString.tTN + "doubleLinkSwitchReportStatus " + this.pUk.pQA.pPR + "mDoubleLinkSwitchSucToDirectCnt" + this.pUk.pQA.pQe.pVx + "mDoubleLinkSwitchSucToRelayCnt" + this.pUk.pQA.pQe.pVy);
      return;
      label297:
      if (2 == paramString.tTN)
      {
        paramm = this.pUk.pQA.pQe;
        paramm.pVy += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d.1
 * JD-Core Version:    0.7.0.1
 */