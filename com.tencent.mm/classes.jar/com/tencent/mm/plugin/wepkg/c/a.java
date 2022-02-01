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
  private Map<String, b> QNs;
  
  private a()
  {
    AppMethodBeat.i(110765);
    this.QNs = new ConcurrentHashMap();
    AppMethodBeat.o(110765);
  }
  
  public final void s(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(110767);
    paramString1 = MD5Util.getMD5String(paramString1 + paramString2);
    paramString1 = (b)this.QNs.remove(paramString1);
    if (paramString1 != null)
    {
      paramString1.QNu -= 1;
      paramString1.mgh += paramLong;
      if (paramString1.QNu == 0)
      {
        Log.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", new Object[] { Long.valueOf(paramString1.mgh) });
        com.tencent.mm.game.report.api.a.jTp.a(1, "", String.valueOf(paramString1.mgh), 0L);
      }
    }
    AppMethodBeat.o(110767);
  }
  
  public final void x(Set<String> paramSet)
  {
    AppMethodBeat.i(110766);
    if (paramSet.isEmpty())
    {
      h.IzE.idkeyStat(859L, 20L, 1L, false);
      AppMethodBeat.o(110766);
      return;
    }
    h.IzE.idkeyStat(859L, 21L, 1L, false);
    b localb = new b();
    localb.QNu = paramSet.size();
    localb.mgh = 0L;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      this.QNs.put(str, localb);
    }
    AppMethodBeat.o(110766);
  }
  
  public static final class a
  {
    private static a QNt;
    
    static
    {
      AppMethodBeat.i(110764);
      QNt = new a((byte)0);
      AppMethodBeat.o(110764);
    }
  }
  
  public final class b
  {
    int QNu;
    long mgh;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.a
 * JD-Core Version:    0.7.0.1
 */