package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Map;

public final class j
  implements bz.a
{
  public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(35888);
    ab.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
    b.kS(74);
    if ((parama == null) || (parama.eyJ == null))
    {
      ab.e(TAG, "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(35888);
      return;
    }
    i locali = new i();
    String str1 = aa.a(parama.eyJ.woR);
    locali.jDt = new StringBuffer();
    Map localMap = br.F(str1, "sysmsg");
    locali.rcu.clear();
    if (localMap == null)
    {
      ab.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[] { str1 });
      b.kS(75);
    }
    for (;;)
    {
      ab.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + locali.jDt.toString());
      g.RM();
      g.RL().Ru().set(ac.a.yBE, str1);
      g.RM();
      g.RL().Ru().dww();
      AppMethodBeat.o(35888);
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
        l1 = bo.apW((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "BeginTime" })));
        locali.jDt.append("BeginTime:" + l1 + ";");
        if (i != 0) {
          break label539;
        }
        parama = "";
        l2 = bo.apW((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "EndTime" })));
        locali.jDt.append("EndTime:" + l2 + ";");
        if (i != 0) {
          break label547;
        }
        parama = "";
        str2 = bo.bf((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "ActionID" })), "");
        locali.jDt.append("ActionID:" + str2 + ";");
        if (bo.isNullOrNil(str2)) {
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
        parama = bo.bf((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "TipsMessage" })), "");
        locali.jDt.append("TipsMessage:" + parama + ";\n");
        h localh = new h();
        localh.rcr = str2;
        localh.fKC = l1;
        localh.jKE = l2;
        localh.rcs = parama;
        locali.rcu.add(localh);
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
      if (locali.rcu.size() == 0) {
        b.kS(76);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.j
 * JD-Core Version:    0.7.0.1
 */