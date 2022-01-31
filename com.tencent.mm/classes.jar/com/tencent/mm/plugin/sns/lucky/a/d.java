package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class d
  implements bz.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(35880);
    ab.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.kS(67);
    if ((parama == null) || (parama.eyJ == null))
    {
      ab.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(35880);
      return;
    }
    e locale = new e();
    parama = aa.a(parama.eyJ.woR);
    locale.jDt = new StringBuffer();
    Map localMap = br.F(parama, "sysmsg");
    locale.level = 0;
    if (localMap == null)
    {
      ab.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.kS(68);
    }
    for (;;)
    {
      ab.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.jDt.toString());
      g.RM();
      g.RL().Ru().set(ac.a.yBP, parama);
      g.RM();
      g.RL().Ru().dww();
      AppMethodBeat.o(35880);
      return;
      locale.level = bo.apV((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      ab.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.kS(69);
      } else if (locale.level == 1) {
        b.kS(70);
      } else if (locale.level == 2) {
        b.kS(71);
      } else if (locale.level == 3) {
        b.kS(72);
      } else if (locale.level == 4) {
        b.kS(73);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */