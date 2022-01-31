package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.nn;
import com.tencent.mm.h.a.nn.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.y;

final class af$21
  extends com.tencent.mm.sdk.b.c<nn>
{
  af$21(af paramaf)
  {
    this.udX = nn.class.getName().hashCode();
  }
  
  private static boolean a(nn paramnn)
  {
    try
    {
      SnsAdClick localSnsAdClick = paramnn.bXh.bXi;
      paramnn = af.bDI().gk(localSnsAdClick.eAA);
      if (paramnn == null) {
        return false;
      }
      n localn = paramnn.bGl();
      if (localSnsAdClick.source == 2) {
        paramnn = localn.bGc();
      }
      while (paramnn != null) {
        if (localSnsAdClick.source == 2)
        {
          y.i("MicroMsg.SnsCore", "at_friend_detail report ad click");
          new com.tencent.mm.plugin.sns.a.b.c(localSnsAdClick.eAA, paramnn.fVM, localSnsAdClick.eAB, localSnsAdClick.eAC, localSnsAdClick.eAz, "", localn.bGP(), localn.bGe().oPO, localSnsAdClick.eAH, localn.bGN().bGi(), localn.bGN().bGj());
          break label248;
          paramnn = localn.bGb();
        }
        else
        {
          y.i("MicroMsg.SnsCore", "report ad click");
          paramnn = new com.tencent.mm.plugin.sns.a.b.c(localSnsAdClick.eAA, paramnn.fVM, localSnsAdClick.eAB, localSnsAdClick.eAC, localSnsAdClick.eAz, "", localn.bGP(), localn.bGe().oPO, localSnsAdClick.eAH, localn.bGN().bGg(), localn.bGN().bGh());
          g.DQ();
          g.DO().dJT.a(paramnn, 0);
          g.DQ();
          g.DO().dJT.a(paramnn, 0);
        }
      }
    }
    catch (Exception paramnn)
    {
      y.printErrStackTrace("MicroMsg.SnsCore", paramnn, "report ad click error", new Object[0]);
    }
    return false;
    label248:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.21
 * JD-Core Version:    0.7.0.1
 */