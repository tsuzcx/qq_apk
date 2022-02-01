package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;

public final class d
  implements ck.a
{
  public final void a(h.a parama)
  {
    AppMethodBeat.i(95177);
    Log.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
    b.rE(67);
    if ((parama == null) || (parama.jQG == null))
    {
      Log.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95177);
      return;
    }
    e locale = new e();
    parama = z.a(parama.jQG.RIF);
    locale.sb = new StringBuffer();
    Map localMap = XmlParser.parseXml(parama, "sysmsg", null);
    locale.level = 0;
    if (localMap == null)
    {
      Log.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[] { parama });
      b.rE(68);
    }
    for (;;)
    {
      Log.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + locale.sb.toString());
      h.aHH();
      h.aHG().aHp().set(ar.a.VkR, parama);
      h.aHH();
      h.aHG().aHp().hxT();
      AppMethodBeat.o(95177);
      return;
      locale.level = Util.safeParseInt((String)localMap.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
      Log.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[] { Integer.valueOf(locale.level) });
      if (locale.level == 0) {
        b.rE(69);
      } else if (locale.level == 1) {
        b.rE(70);
      } else if (locale.level == 2) {
        b.rE(71);
      } else if (locale.level == 3) {
        b.rE(72);
      } else if (locale.level == 4) {
        b.rE(73);
      }
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.d
 * JD-Core Version:    0.7.0.1
 */