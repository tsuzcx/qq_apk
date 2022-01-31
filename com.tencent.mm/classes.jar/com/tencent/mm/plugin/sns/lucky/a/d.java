package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class d
  implements bx.a
{
  public final void a(e.a parama)
  {
    y.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.jdMethod_if(67);
    if ((parama == null) || (parama.dBs == null))
    {
      y.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      return;
    }
    e locale = new e();
    parama = aa.a(parama.dBs.svH);
    locale.hJQ = new StringBuffer();
    Map localMap = bn.s(parama, "sysmsg");
    locale.level = 0;
    if (localMap == null)
    {
      y.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.jdMethod_if(68);
    }
    for (;;)
    {
      y.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.hJQ.toString());
      g.DQ();
      g.DP().Dz().c(ac.a.urP, parama);
      g.DQ();
      g.DP().Dz().mC(true);
      return;
      locale.level = bk.ZR((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      y.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.jdMethod_if(69);
      } else if (locale.level == 1) {
        b.jdMethod_if(70);
      } else if (locale.level == 2) {
        b.jdMethod_if(71);
      } else if (locale.level == 3) {
        b.jdMethod_if(72);
      } else if (locale.level == 4) {
        b.jdMethod_if(73);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */