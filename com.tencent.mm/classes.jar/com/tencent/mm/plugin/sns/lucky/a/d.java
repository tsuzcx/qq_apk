package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;

public final class d
  implements cl.a
{
  public final void a(g.a parama)
  {
    AppMethodBeat.i(95177);
    Log.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.rG(67);
    if ((parama == null) || (parama.mpN == null))
    {
      Log.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95177);
      return;
    }
    e locale = new e();
    parama = w.a(parama.mpN.YFG);
    locale.sb = new StringBuffer();
    Map localMap = XmlParser.parseXml(parama, "sysmsg", null);
    locale.level = 0;
    if (localMap == null)
    {
      Log.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.rG(68);
    }
    for (;;)
    {
      Log.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.sb.toString());
      h.baF();
      h.baE().ban().set(at.a.acMl, parama);
      h.baF();
      h.baE().ban().iZy();
      AppMethodBeat.o(95177);
      return;
      locale.level = Util.safeParseInt((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      Log.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.rG(69);
      } else if (locale.level == 1) {
        b.rG(70);
      } else if (locale.level == 2) {
        b.rG(71);
      } else if (locale.level == 3) {
        b.rG(72);
      } else if (locale.level == 4) {
        b.rG(73);
      }
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */