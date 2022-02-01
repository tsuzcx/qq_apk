package com.tencent.mm.plugin.wepkg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, b> DbN;
  
  private a()
  {
    AppMethodBeat.i(110765);
    this.DbN = new ConcurrentHashMap();
    AppMethodBeat.o(110765);
  }
  
  public final void k(Set<String> paramSet)
  {
    AppMethodBeat.i(110766);
    if (paramSet.isEmpty())
    {
      h.wUl.idkeyStat(859L, 20L, 1L, false);
      AppMethodBeat.o(110766);
      return;
    }
    h.wUl.idkeyStat(859L, 21L, 1L, false);
    b localb = new b();
    localb.DbP = paramSet.size();
    localb.hZe = 0L;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      this.DbN.put(str, localb);
    }
    AppMethodBeat.o(110766);
  }
  
  public final void y(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(110767);
    paramString1 = ah.dg(paramString1 + paramString2);
    paramString1 = (b)this.DbN.remove(paramString1);
    if (paramString1 != null)
    {
      paramString1.DbP -= 1;
      paramString1.hZe += paramLong;
      if (paramString1.DbP == 0)
      {
        ac.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", new Object[] { Long.valueOf(paramString1.hZe) });
        com.tencent.mm.game.report.api.a.fYF.a(1, "", String.valueOf(paramString1.hZe), 0L);
      }
    }
    AppMethodBeat.o(110767);
  }
  
  public static final class a
  {
    private static a DbO;
    
    static
    {
      AppMethodBeat.i(110764);
      DbO = new a((byte)0);
      AppMethodBeat.o(110764);
    }
  }
  
  public final class b
  {
    int DbP;
    long hZe;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.a
 * JD-Core Version:    0.7.0.1
 */