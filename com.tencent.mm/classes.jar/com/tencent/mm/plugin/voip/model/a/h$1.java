package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.csz;

final class h$1
  implements f
{
  h$1(h paramh) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4719);
    a.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.tzQ.tvE.mStatus);
    if (paramInt2 != 0)
    {
      a.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(4719);
      return;
    }
    paramString = (csz)this.tzQ.cOt();
    a.Logi("MicroMsg.Voip.Redirect", "room " + paramString.wQP + " member " + paramString.xCv + " key " + paramString.wQQ + " relay addr cnt " + paramString.ycd + " RedirectThreshold " + paramString.yci + " RedirectDecision " + paramString.ycj);
    paramm = new crn();
    crn localcrn1 = new crn();
    crn localcrn2 = new crn();
    paramm.yak = paramString.ycd;
    paramm.yal = paramString.yce;
    localcrn1.yak = paramString.ycf;
    localcrn1.yal = paramString.ycg;
    localcrn2.yak = paramString.ych;
    localcrn2.yal = paramString.yaO;
    this.tzQ.tvE.tvj.a(paramm, localcrn1, localcrn2, paramString.yci, paramString.ycj);
    AppMethodBeat.o(4719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h.1
 * JD-Core Version:    0.7.0.1
 */