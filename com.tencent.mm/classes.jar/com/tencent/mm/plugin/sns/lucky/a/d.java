package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Map;

public final class d
  implements cf.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(95177);
    ae.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.md(67);
    if ((parama == null) || (parama.gte == null))
    {
      ae.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95177);
      return;
    }
    e locale = new e();
    parama = z.a(parama.gte.FNI);
    locale.nCG = new StringBuffer();
    Map localMap = bx.M(parama, "sysmsg");
    locale.level = 0;
    if (localMap == null)
    {
      ae.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.md(68);
    }
    for (;;)
    {
      ae.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.nCG.toString());
      g.ajS();
      g.ajR().ajA().set(am.a.IOP, parama);
      g.ajS();
      g.ajR().ajA().fuc();
      AppMethodBeat.o(95177);
      return;
      locale.level = bu.aSB((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      ae.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.md(69);
      } else if (locale.level == 1) {
        b.md(70);
      } else if (locale.level == 2) {
        b.md(71);
      } else if (locale.level == 3) {
        b.md(72);
      } else if (locale.level == 4) {
        b.md(73);
      }
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */