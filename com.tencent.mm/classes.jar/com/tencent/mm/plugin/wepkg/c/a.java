package com.tencent.mm.plugin.wepkg.c;

import com.tencent.mm.game.report.api.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, a.b> rQc = new ConcurrentHashMap();
  
  public final void g(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = ad.bB(paramString1 + paramString2);
    paramString1 = (a.b)this.rQc.remove(paramString1);
    if (paramString1 != null)
    {
      paramString1.rQe -= 1;
      paramString1.eGc += paramLong;
      if (paramString1.rQe == 0)
      {
        y.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", new Object[] { Long.valueOf(paramString1.eGc) });
        c.dCx.J("", String.valueOf(paramString1.eGc));
      }
    }
  }
  
  public final void j(Set<String> paramSet)
  {
    if (paramSet.isEmpty()) {
      h.nFQ.a(859L, 20L, 1L, false);
    }
    for (;;)
    {
      return;
      h.nFQ.a(859L, 21L, 1L, false);
      a.b localb = new a.b(this);
      localb.rQe = paramSet.size();
      localb.eGc = 0L;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        this.rQc.put(str, localb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.a
 * JD-Core Version:    0.7.0.1
 */