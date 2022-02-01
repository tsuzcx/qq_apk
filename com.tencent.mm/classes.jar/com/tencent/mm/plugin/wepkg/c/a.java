package com.tencent.mm.plugin.wepkg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, b> EYi;
  
  private a()
  {
    AppMethodBeat.i(110765);
    this.EYi = new ConcurrentHashMap();
    AppMethodBeat.o(110765);
  }
  
  public final void m(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(110767);
    paramString1 = aj.ej(paramString1 + paramString2);
    paramString1 = (b)this.EYi.remove(paramString1);
    if (paramString1 != null)
    {
      paramString1.EYk -= 1;
      paramString1.ivu += paramLong;
      if (paramString1.EYk == 0)
      {
        ae.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", new Object[] { Long.valueOf(paramString1.ivu) });
        com.tencent.mm.game.report.api.a.guC.a(1, "", String.valueOf(paramString1.ivu), 0L);
      }
    }
    AppMethodBeat.o(110767);
  }
  
  public final void r(Set<String> paramSet)
  {
    AppMethodBeat.i(110766);
    if (paramSet.isEmpty())
    {
      g.yxI.idkeyStat(859L, 20L, 1L, false);
      AppMethodBeat.o(110766);
      return;
    }
    g.yxI.idkeyStat(859L, 21L, 1L, false);
    b localb = new b();
    localb.EYk = paramSet.size();
    localb.ivu = 0L;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      this.EYi.put(str, localb);
    }
    AppMethodBeat.o(110766);
  }
  
  public static final class a
  {
    private static a EYj;
    
    static
    {
      AppMethodBeat.i(110764);
      EYj = new a((byte)0);
      AppMethodBeat.o(110764);
    }
  }
  
  public final class b
  {
    int EYk;
    long ivu;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.a
 * JD-Core Version:    0.7.0.1
 */