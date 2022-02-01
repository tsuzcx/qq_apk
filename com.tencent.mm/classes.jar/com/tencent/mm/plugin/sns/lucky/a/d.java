package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Map;

public final class d
  implements cd.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(95177);
    ad.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.ma(67);
    if ((parama == null) || (parama.gqE == null))
    {
      ad.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95177);
      return;
    }
    e locale = new e();
    parama = z.a(parama.gqE.Fvk);
    locale.nxl = new StringBuffer();
    Map localMap = bw.M(parama, "sysmsg");
    locale.level = 0;
    if (localMap == null)
    {
      ad.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.ma(68);
    }
    for (;;)
    {
      ad.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.nxl.toString());
      g.ajD();
      g.ajC().ajl().set(al.a.Ius, parama);
      g.ajD();
      g.ajC().ajl().fqc();
      AppMethodBeat.o(95177);
      return;
      locale.level = bt.aRe((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      ad.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.ma(69);
      } else if (locale.level == 1) {
        b.ma(70);
      } else if (locale.level == 2) {
        b.ma(71);
      } else if (locale.level == 3) {
        b.ma(72);
      } else if (locale.level == 4) {
        b.ma(73);
      }
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */