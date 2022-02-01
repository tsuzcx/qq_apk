package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;
import java.util.Map;

public final class j
  implements cc.a
{
  public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(95185);
    ac.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
    b.lA(74);
    if ((parama == null) || (parama.fXi == null))
    {
      ac.e(TAG, "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95185);
      return;
    }
    i locali = new i();
    String str1 = z.a(parama.fXi.DPV);
    locali.mWO = new StringBuffer();
    Map localMap = bv.L(str1, "sysmsg");
    locali.xPf.clear();
    if (localMap == null)
    {
      ac.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[] { str1 });
      b.lA(75);
    }
    for (;;)
    {
      ac.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + locali.mWO.toString());
      g.agS();
      g.agR().agA().set(ah.a.GHP, str1);
      g.agS();
      g.agR().agA().faa();
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
        l1 = bs.aLz((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "BeginTime" })));
        locali.mWO.append("BeginTime:" + l1 + ";");
        if (i != 0) {
          break label539;
        }
        parama = "";
        l2 = bs.aLz((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "EndTime" })));
        locali.mWO.append("EndTime:" + l2 + ";");
        if (i != 0) {
          break label547;
        }
        parama = "";
        str2 = bs.bG((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "ActionID" })), "");
        locali.mWO.append("ActionID:" + str2 + ";");
        if (bs.isNullOrNil(str2)) {
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
        parama = bs.bG((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "TipsMessage" })), "");
        locali.mWO.append("TipsMessage:" + parama + ";\n");
        h localh = new h();
        localh.xPc = str2;
        localh.hOl = l1;
        localh.ndU = l2;
        localh.xPd = parama;
        locali.xPf.add(localh);
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
      if (locali.xPf.size() == 0) {
        b.lA(76);
      }
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.j
 * JD-Core Version:    0.7.0.1
 */