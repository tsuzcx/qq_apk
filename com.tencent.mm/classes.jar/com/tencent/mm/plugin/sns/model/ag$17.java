package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.om.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;

final class ag$17
  extends com.tencent.mm.sdk.b.c<om>
{
  ag$17(ag paramag)
  {
    AppMethodBeat.i(36442);
    this.__eventId = om.class.getName().hashCode();
    AppMethodBeat.o(36442);
  }
  
  private static boolean a(om paramom)
  {
    AppMethodBeat.i(36443);
    try
    {
      SnsAdClick localSnsAdClick = paramom.cFa.cFb;
      paramom = ag.cpi().lQ(localSnsAdClick.cIo);
      if (paramom == null)
      {
        AppMethodBeat.o(36443);
        return false;
      }
      n localn = paramom.csn();
      if (localSnsAdClick.cpt == 2)
      {
        paramom = localn.cse();
        if (paramom == null) {
          break label335;
        }
        if (localSnsAdClick.cpt != 2) {
          break label192;
        }
        ab.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + localSnsAdClick.fQA + ", clkPos=" + localSnsAdClick.fQt);
        paramom = new com.tencent.mm.plugin.sns.a.b.c(localSnsAdClick.cIo, paramom.hpq, localSnsAdClick.fQt, localSnsAdClick.fQu, localSnsAdClick.fQs, "", localn.csS(), localn.csh().rHA, localSnsAdClick.fQz, localn.csQ().csl(), localn.csQ().csm(), 0L);
        g.RM();
        g.RK().eHt.a(paramom, 0);
      }
      for (;;)
      {
        AppMethodBeat.o(36443);
        return true;
        paramom = localn.csd();
        break;
        label192:
        ab.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.fQA + ", clkPos=" + localSnsAdClick.fQt + ", source=" + localSnsAdClick.cpt);
        paramom = new com.tencent.mm.plugin.sns.a.b.c(localSnsAdClick.cIo, paramom.hpq, localSnsAdClick.fQt, localSnsAdClick.fQu, localSnsAdClick.fQs, "", localn.csS(), localn.csh().rHA, localSnsAdClick.fQz, localn.csQ().csj(), localn.csQ().csk(), localSnsAdClick.fQA);
        g.RM();
        g.RK().eHt.a(paramom, 0);
      }
      label335:
      return false;
    }
    catch (Exception paramom)
    {
      ab.printErrStackTrace("MicroMsg.SnsCore", paramom, "report ad click error", new Object[0]);
      AppMethodBeat.o(36443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag.17
 * JD-Core Version:    0.7.0.1
 */