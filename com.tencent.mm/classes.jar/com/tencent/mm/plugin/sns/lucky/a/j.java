package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Map;

public final class j
  implements bx.a
{
  public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";
  
  public final void a(e.a parama)
  {
    y.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
    b.jdMethod_if(74);
    if ((parama == null) || (parama.dBs == null))
    {
      y.e(TAG, "onPreAddMessage cmdAM is null");
      return;
    }
    i locali = new i();
    String str1 = aa.a(parama.dBs.svH);
    locali.hJQ = new StringBuffer();
    Map localMap = bn.s(str1, "sysmsg");
    locali.ood.clear();
    if (localMap == null)
    {
      y.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[] { str1 });
      b.jdMethod_if(75);
    }
    for (;;)
    {
      y.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + locali.hJQ.toString());
      g.DQ();
      g.DP().Dz().c(ac.a.urE, str1);
      g.DQ();
      g.DP().Dz().mC(true);
      return;
      int i = 0;
      label179:
      long l1;
      label248:
      long l2;
      label319:
      String str2;
      if (i == 0)
      {
        parama = "";
        l1 = bk.ZS((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "BeginTime" })));
        locali.hJQ.append("BeginTime:" + l1 + ";");
        if (i != 0) {
          break label525;
        }
        parama = "";
        l2 = bk.ZS((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "EndTime" })));
        locali.hJQ.append("EndTime:" + l2 + ";");
        if (i != 0) {
          break label533;
        }
        parama = "";
        str2 = bk.aM((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "ActionID" })), "");
        locali.hJQ.append("ActionID:" + str2 + ";");
        if (bk.bl(str2)) {
          break label549;
        }
        if (i != 0) {
          break label541;
        }
      }
      label525:
      label533:
      label541:
      for (parama = "";; parama = String.valueOf(i))
      {
        parama = bk.aM((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "TipsMessage" })), "");
        locali.hJQ.append("TipsMessage:" + parama + ";\n");
        h localh = new h();
        localh.ooa = str2;
        localh.euQ = l1;
        localh.hRd = l2;
        localh.oob = parama;
        locali.ood.add(localh);
        i += 1;
        break;
        parama = String.valueOf(i);
        break label179;
        parama = String.valueOf(i);
        break label248;
        parama = String.valueOf(i);
        break label319;
      }
      label549:
      if (locali.ood.size() == 0) {
        b.jdMethod_if(76);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.j
 * JD-Core Version:    0.7.0.1
 */