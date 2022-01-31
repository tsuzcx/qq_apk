package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

final class c$4
  implements bz.a
{
  c$4(c paramc) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(126828);
    parama = aa.a(parama.eyJ.woR);
    if ((parama == null) || (parama.length() == 0))
    {
      ab.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
      AppMethodBeat.o(126828);
      return;
    }
    parama = br.F(parama, "sysmsg");
    if (parama == null)
    {
      AppMethodBeat.o(126828);
      return;
    }
    int i = bo.getInt((String)parama.get(".sysmsg.crowdtest.$clientversion"), 0);
    if (i <= d.whH)
    {
      AppMethodBeat.o(126828);
      return;
    }
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
      label123:
      String str2;
      boolean bool;
      break label123;
    }
    if (l1 < System.currentTimeMillis())
    {
      c.cjP();
      AppMethodBeat.o(126828);
      return;
    }
    str1 = (String)parama.get(".sysmsg.crowdtest.apply.link");
    str2 = (String)parama.get(".sysmsg.crowdtest.feedback.link");
    g.RL().Ru().set(ac.a.yGt, Integer.valueOf(i));
    g.RL().Ru().set(ac.a.yGu, Long.valueOf(l1));
    g.RL().Ru().set(ac.a.yGv, str1);
    g.RL().Ru().set(ac.a.yGw, str2);
    i = bo.getInt((String)parama.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
    parama = com.tencent.mm.x.c.PJ();
    if (i > 0) {}
    for (bool = true;; bool = false)
    {
      parama.y(262157, bool);
      if (i < 3) {
        com.tencent.mm.x.c.PJ().ce(262157, 266261);
      }
      if (i < 2) {
        com.tencent.mm.x.c.PJ().ce(262157, 266262);
      }
      AppMethodBeat.o(126828);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.4
 * JD-Core Version:    0.7.0.1
 */