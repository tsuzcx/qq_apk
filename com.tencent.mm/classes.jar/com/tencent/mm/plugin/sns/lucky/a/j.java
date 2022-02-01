package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;
import java.util.Map;

public final class j
  implements cc.a
{
  public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(95185);
    ad.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
    b.lI(74);
    if ((parama == null) || (parama.fTo == null))
    {
      ad.e(TAG, "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95185);
      return;
    }
    i locali = new i();
    String str1 = z.a(parama.fTo.Cxz);
    locali.muN = new StringBuffer();
    Map localMap = bw.K(str1, "sysmsg");
    locali.wCK.clear();
    if (localMap == null)
    {
      ad.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[] { str1 });
      b.lI(75);
    }
    for (;;)
    {
      ad.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + locali.muN.toString());
      g.afC();
      g.afB().afk().set(ae.a.Fka, str1);
      g.afC();
      g.afB().afk().eKy();
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
        l1 = bt.aGi((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "BeginTime" })));
        locali.muN.append("BeginTime:" + l1 + ";");
        if (i != 0) {
          break label539;
        }
        parama = "";
        l2 = bt.aGi((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "EndTime" })));
        locali.muN.append("EndTime:" + l2 + ";");
        if (i != 0) {
          break label547;
        }
        parama = "";
        str2 = bt.by((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "ActionID" })), "");
        locali.muN.append("ActionID:" + str2 + ";");
        if (bt.isNullOrNil(str2)) {
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
        parama = bt.by((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "TipsMessage" })), "");
        locali.muN.append("TipsMessage:" + parama + ";\n");
        h localh = new h();
        localh.wCH = str2;
        localh.hnI = l1;
        localh.mBT = l2;
        localh.wCI = parama;
        locali.wCK.add(localh);
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
      if (locali.wCK.size() == 0) {
        b.lI(76);
      }
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.j
 * JD-Core Version:    0.7.0.1
 */