package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.csn;

final class d$1
  implements f
{
  d$1(d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4705);
    a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.tzM.tvE.mStatus);
    if (paramInt2 != 0)
    {
      a.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(4705);
      return;
    }
    paramString = (csn)this.tzM.cOt();
    this.tzM.tvE.tuW = paramString.xvA;
    if (this.tzM.tvE.tuW == 0)
    {
      AppMethodBeat.o(4705);
      return;
    }
    if (this.tzM.tvE.tvj.doubleLinkSwitch(paramString.ybe) == 0)
    {
      if (1 != paramString.ybe) {
        break label315;
      }
      paramm = this.tzM.tvE.tvj;
      paramm.tBc += 1;
    }
    for (;;)
    {
      a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + paramString.wQP + " member " + paramString.xCv + " key " + paramString.wQQ + "report flag " + paramString.xvA + "switch to link type " + paramString.ybe + "doubleLinkSwitchReportStatus " + this.tzM.tvE.tuW + "mDoubleLinkSwitchSucToDirectCnt" + this.tzM.tvE.tvj.tBc + "mDoubleLinkSwitchSucToRelayCnt" + this.tzM.tvE.tvj.tBd);
      AppMethodBeat.o(4705);
      return;
      label315:
      if (2 == paramString.ybe)
      {
        paramm = this.tzM.tvE.tvj;
        paramm.tBd += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d.1
 * JD-Core Version:    0.7.0.1
 */