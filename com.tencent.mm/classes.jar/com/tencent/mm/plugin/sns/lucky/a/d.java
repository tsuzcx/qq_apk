package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Map;

public final class d
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(95177);
    ac.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.lA(67);
    if ((parama == null) || (parama.fXi == null))
    {
      ac.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95177);
      return;
    }
    e locale = new e();
    parama = z.a(parama.fXi.DPV);
    locale.mWO = new StringBuffer();
    Map localMap = bv.L(parama, "sysmsg");
    locale.level = 0;
    if (localMap == null)
    {
      ac.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.lA(68);
    }
    for (;;)
    {
      ac.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.mWO.toString());
      g.agS();
      g.agR().agA().set(ah.a.GIa, parama);
      g.agS();
      g.agR().agA().faa();
      AppMethodBeat.o(95177);
      return;
      locale.level = bs.aLy((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      ac.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.lA(69);
      } else if (locale.level == 1) {
        b.lA(70);
      } else if (locale.level == 2) {
        b.lA(71);
      } else if (locale.level == 3) {
        b.lA(72);
      } else if (locale.level == 4) {
        b.lA(73);
      }
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */