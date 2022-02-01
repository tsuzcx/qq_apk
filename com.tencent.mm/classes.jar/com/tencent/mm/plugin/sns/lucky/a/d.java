package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Map;

public final class d
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(95177);
    ad.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.lI(67);
    if ((parama == null) || (parama.fTo == null))
    {
      ad.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95177);
      return;
    }
    e locale = new e();
    parama = z.a(parama.fTo.Cxz);
    locale.muN = new StringBuffer();
    Map localMap = bw.K(parama, "sysmsg");
    locale.level = 0;
    if (localMap == null)
    {
      ad.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.lI(68);
    }
    for (;;)
    {
      ad.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.muN.toString());
      g.afC();
      g.afB().afk().set(ae.a.Fkl, parama);
      g.afC();
      g.afB().afk().eKy();
      AppMethodBeat.o(95177);
      return;
      locale.level = bt.aGh((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      ad.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.lI(69);
      } else if (locale.level == 1) {
        b.lI(70);
      } else if (locale.level == 2) {
        b.lI(71);
      } else if (locale.level == 3) {
        b.lI(72);
      } else if (locale.level == 4) {
        b.lI(73);
      }
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */