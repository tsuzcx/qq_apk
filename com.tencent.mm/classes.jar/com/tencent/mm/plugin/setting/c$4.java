package com.tencent.mm.plugin.setting;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

final class c$4
  implements bx.a
{
  c$4(c paramc) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    if ((parama == null) || (parama.length() == 0)) {
      y.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
    }
    do
    {
      do
      {
        return;
        parama = bn.s(parama, "sysmsg");
      } while (parama == null);
      i = bk.getInt((String)parama.get(".sysmsg.crowdtest.$clientversion"), 0);
    } while (i <= d.spa);
    long l1 = 0L;
    try
    {
      str1 = (String)parama.get(".sysmsg.crowdtest.apply.$expire");
      long l2 = new SimpleDateFormat("yyyy-MM-dd").parse(str1).getTime();
      l1 = l2;
    }
    catch (Exception localException)
    {
      String str1;
      label101:
      String str2;
      boolean bool;
      break label101;
    }
    if (l1 < System.currentTimeMillis())
    {
      c.byF();
      return;
    }
    str1 = (String)parama.get(".sysmsg.crowdtest.apply.link");
    str2 = (String)parama.get(".sysmsg.crowdtest.feedback.link");
    g.DP().Dz().c(ac.a.uwl, Integer.valueOf(i));
    g.DP().Dz().c(ac.a.uwm, Long.valueOf(l1));
    g.DP().Dz().c(ac.a.uwn, str1);
    g.DP().Dz().c(ac.a.uwo, str2);
    int i = bk.getInt((String)parama.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
    parama = com.tencent.mm.y.c.BS();
    if (i > 0) {}
    for (bool = true;; bool = false)
    {
      parama.w(262157, bool);
      if (i < 3) {
        com.tencent.mm.y.c.BS().bd(262157, 266261);
      }
      if (i >= 2) {
        break;
      }
      com.tencent.mm.y.c.BS().bd(262157, 266262);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.4
 * JD-Core Version:    0.7.0.1
 */