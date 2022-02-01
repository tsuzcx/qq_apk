package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;
import java.util.Map;

public final class j
  implements cd.a
{
  public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(95185);
    ad.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
    b.ma(74);
    if ((parama == null) || (parama.gqE == null))
    {
      ad.e(TAG, "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(95185);
      return;
    }
    i locali = new i();
    String str1 = z.a(parama.gqE.Fvk);
    locali.nxl = new StringBuffer();
    Map localMap = bw.M(str1, "sysmsg");
    locali.zeZ.clear();
    if (localMap == null)
    {
      ad.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[] { str1 });
      b.ma(75);
    }
    for (;;)
    {
      ad.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + locali.nxl.toString());
      g.ajD();
      g.ajC().ajl().set(al.a.Iuh, str1);
      g.ajD();
      g.ajC().ajl().fqc();
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
        l1 = bt.aRf((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "BeginTime" })));
        locali.nxl.append("BeginTime:" + l1 + ";");
        if (i != 0) {
          break label539;
        }
        parama = "";
        l2 = bt.aRf((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "EndTime" })));
        locali.nxl.append("EndTime:" + l2 + ";");
        if (i != 0) {
          break label547;
        }
        parama = "";
        str2 = bt.bI((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "ActionID" })), "");
        locali.nxl.append("ActionID:" + str2 + ";");
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
        parama = bt.bI((String)localMap.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", new Object[] { parama, "TipsMessage" })), "");
        locali.nxl.append("TipsMessage:" + parama + ";\n");
        h localh = new h();
        localh.zeW = str2;
        localh.ihz = l1;
        localh.nEr = l2;
        localh.zeX = parama;
        locali.zeZ.add(localh);
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
      if (locali.zeZ.size() == 0) {
        b.ma(76);
      }
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.j
 * JD-Core Version:    0.7.0.1
 */