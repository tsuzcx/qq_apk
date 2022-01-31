package com.tencent.mm.plugin.wepkg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, a.b> vGU;
  
  private a()
  {
    AppMethodBeat.i(63607);
    this.vGU = new ConcurrentHashMap();
    AppMethodBeat.o(63607);
  }
  
  public final void k(Set<String> paramSet)
  {
    AppMethodBeat.i(63608);
    if (paramSet.isEmpty())
    {
      h.qsU.idkeyStat(859L, 20L, 1L, false);
      AppMethodBeat.o(63608);
      return;
    }
    h.qsU.idkeyStat(859L, 21L, 1L, false);
    a.b localb = new a.b(this);
    localb.vGW = paramSet.size();
    localb.fVT = 0L;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      this.vGU.put(str, localb);
    }
    AppMethodBeat.o(63608);
  }
  
  public final void p(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(63609);
    paramString1 = ag.cE(paramString1 + paramString2);
    paramString1 = (a.b)this.vGU.remove(paramString1);
    if (paramString1 != null)
    {
      paramString1.vGW -= 1;
      paramString1.fVT += paramLong;
      if (paramString1.vGW == 0)
      {
        ab.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", new Object[] { Long.valueOf(paramString1.fVT) });
        com.tencent.mm.game.report.api.a.ezM.g(1, "", String.valueOf(paramString1.fVT));
      }
    }
    AppMethodBeat.o(63609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.a
 * JD-Core Version:    0.7.0.1
 */