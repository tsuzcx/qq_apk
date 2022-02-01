package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.LinkedList;
import java.util.Map;

public final class j
  implements cf.a
{
  public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(95185);
    ae.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
    b.md(74);
    if ((parama == null) || (parama.gte == null))
    {
      ae.e(TAG, "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95185);
      return;
    }
    i locali = new i();
    String str1 = z.a(parama.gte.FNI);
    locali.nCG = new StringBuffer();
    Map localMap = bx.M(str1, "sysmsg");
    locali.zvO.clear();
    if (localMap == null)
    {
      ae.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[] { str1 });
      b.md(75);
    }
    for (;;)
    {
      ae.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + locali.nCG.toString());
      g.ajS();
      g.ajR().ajA().set(am.a.IOE, str1);
      g.ajS();
      g.ajR().ajA().fuc();
      AppMethodBeat.o(95185);
      return;
      int i = 0;
      label193:
      long l1;
      label262:
      long l2;
      label333:
      String str2;
      if (i == 0)
      {
        parama = "";
        l1 = bu.aSC((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "BeginTime" })));
        locali.nCG.append("BeginTime:" + l1 + ";");
        if (i != 0) {
          break label539;
        }
        parama = "";
        l2 = bu.aSC((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "EndTime" })));
        locali.nCG.append("EndTime:" + l2 + ";");
        if (i != 0) {
          break label547;
        }
        parama = "";
        str2 = bu.bI((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "ActionID" })), "");
        locali.nCG.append("ActionID:" + str2 + ";");
        if (bu.isNullOrNil(str2)) {
          break label563;
        }
        if (i != 0) {
          break label555;
        }
      }
      label539:
      label547:
      label555:
      for (parama = "";; parama = String.valueOf(i))
      {
        parama = bu.bI((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "TipsMessage" })), "");
        locali.nCG.append("TipsMessage:" + parama + ";\n");
        h localh = new h();
        localh.zvL = str2;
        localh.iks = l1;
        localh.nJM = l2;
        localh.zvM = parama;
        locali.zvO.add(localh);
        i += 1;
        break;
        parama = String.valueOf(i);
        break label193;
        parama = String.valueOf(i);
        break label262;
        parama = String.valueOf(i);
        break label333;
      }
      label563:
      if (locali.zvO.size() == 0) {
        b.md(76);
      }
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.j
 * JD-Core Version:    0.7.0.1
 */