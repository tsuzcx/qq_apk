package com.tencent.mm.plugin.wepkg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, b> XGQ;
  
  private a()
  {
    AppMethodBeat.i(110765);
    this.XGQ = new ConcurrentHashMap();
    AppMethodBeat.o(110765);
  }
  
  public final void I(Set<String> paramSet)
  {
    AppMethodBeat.i(110766);
    if (paramSet.isEmpty())
    {
      h.OAn.idkeyStat(859L, 20L, 1L, false);
      AppMethodBeat.o(110766);
      return;
    }
    h.OAn.idkeyStat(859L, 21L, 1L, false);
    b localb = new b();
    localb.XGS = paramSet.size();
    localb.oZd = 0L;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      this.XGQ.put(str, localb);
    }
    AppMethodBeat.o(110766);
  }
  
  public final void u(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(110767);
    paramString1 = MD5Util.getMD5String(paramString1 + paramString2);
    paramString1 = (b)this.XGQ.remove(paramString1);
    if (paramString1 != null)
    {
      paramString1.XGS -= 1;
      paramString1.oZd += paramLong;
      if (paramString1.XGS == 0)
      {
        Log.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", new Object[] { Long.valueOf(paramString1.oZd) });
        com.tencent.mm.game.report.api.a.mtH.a(1, "", String.valueOf(paramString1.oZd), 0L);
      }
    }
    AppMethodBeat.o(110767);
  }
  
  public static final class a
  {
    private static a XGR;
    
    static
    {
      AppMethodBeat.i(110764);
      XGR = new a((byte)0);
      AppMethodBeat.o(110764);
    }
  }
  
  public final class b
  {
    int XGS;
    long oZd;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.a
 * JD-Core Version:    0.7.0.1
 */