package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import java.util.Map;

public final class j
  implements ck.a
{
  public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(95185);
    Log.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
    b.rE(74);
    if ((parama == null) || (parama.jQG == null))
    {
      Log.e(TAG, "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95185);
      return;
    }
    i locali = new i();
    String str1 = z.a(parama.jQG.RIF);
    locali.sb = new StringBuffer();
    Map localMap = XmlParser.parseXml(str1, "sysmsg", null);
    locali.JSX.clear();
    if (localMap == null)
    {
      Log.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[] { str1 });
      b.rE(75);
    }
    for (;;)
    {
      Log.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + locali.sb.toString());
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VkG, str1);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().hxT();
      AppMethodBeat.o(95185);
      return;
      int i = 0;
      label194:
      long l1;
      label263:
      long l2;
      label334:
      String str2;
      if (i == 0)
      {
        parama = "";
        l1 = Util.safeParseLong((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "BeginTime" })));
        locali.sb.append("BeginTime:" + l1 + ";");
        if (i != 0) {
          break label540;
        }
        parama = "";
        l2 = Util.safeParseLong((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "EndTime" })));
        locali.sb.append("EndTime:" + l2 + ";");
        if (i != 0) {
          break label548;
        }
        parama = "";
        str2 = Util.nullAs((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "ActionID" })), "");
        locali.sb.append("ActionID:" + str2 + ";");
        if (Util.isNullOrNil(str2)) {
          break label564;
        }
        if (i != 0) {
          break label556;
        }
      }
      label540:
      label548:
      label556:
      for (parama = "";; parama = String.valueOf(i))
      {
        parama = Util.nullAs((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "TipsMessage" })), "");
        locali.sb.append("TipsMessage:" + parama + ";\n");
        h localh = new h();
        localh.JSU = str2;
        localh.lVM = l1;
        localh.rWG = l2;
        localh.JSV = parama;
        locali.JSX.add(localh);
        i += 1;
        break;
        parama = String.valueOf(i);
        break label194;
        parama = String.valueOf(i);
        break label263;
        parama = String.valueOf(i);
        break label334;
      }
      label564:
      if (locali.JSX.size() == 0) {
        b.rE(76);
      }
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.j
 * JD-Core Version:    0.7.0.1
 */