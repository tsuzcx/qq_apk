package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class b
{
  private static long uNW = 2592000L;
  private static b uNX;
  private c uNY;
  private Map<String, Long> uNZ;
  private long uOa;
  
  public b()
  {
    AppMethodBeat.i(5625);
    this.uNZ = new HashMap();
    this.uOa = 0L;
    AppMethodBeat.o(5625);
  }
  
  private static long aN(String paramString, long paramLong)
  {
    AppMethodBeat.i(5633);
    if (paramString.equals("wx62d9035fd4fd2059"))
    {
      AppMethodBeat.o(5633);
      return paramLong - 52428800L;
    }
    AppMethodBeat.o(5633);
    return paramLong - 10485760L;
  }
  
  private long agJ(String paramString)
  {
    AppMethodBeat.i(5632);
    if (this.uNZ.containsKey(paramString))
    {
      l = ((Long)this.uNZ.get(paramString)).longValue();
      AppMethodBeat.o(5632);
      return l;
    }
    long l = daw().agJ(paramString);
    AppMethodBeat.o(5632);
    return l;
  }
  
  public static b dav()
  {
    AppMethodBeat.i(5626);
    if (uNX == null) {
      uNX = new b();
    }
    b localb = uNX;
    AppMethodBeat.o(5626);
    return localb;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(5628);
    long l1 = daw().hl(paramString1, paramString2);
    long l2 = paramString2.getBytes().length + paramString3.getBytes().length;
    long l3 = l2 - l1;
    long l4 = agJ(paramString1) + l3;
    long l5 = aN(paramString1, l4);
    ab.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5) });
    if ((l5 > 0L) && (!paramBoolean))
    {
      AppMethodBeat.o(5628);
      return false;
    }
    com.tencent.mm.plugin.webview.a.a.O(new b.1(this, l5, paramString1, l4, paramString2, paramString3, paramString4, paramString5));
    AppMethodBeat.o(5628);
    return true;
  }
  
  public final void agI(String paramString)
  {
    AppMethodBeat.i(5631);
    daw().agI(paramString);
    AppMethodBeat.o(5631);
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(5630);
    daw().b(paramString, paramJSONArray);
    AppMethodBeat.o(5630);
  }
  
  public final c daw()
  {
    AppMethodBeat.i(5627);
    if (this.uNY == null)
    {
      g.RM();
      this.uNY = new c(g.RL().eHS);
    }
    c localc = this.uNY;
    AppMethodBeat.o(5627);
    return localc;
  }
  
  public final a hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5629);
    paramString1 = daw().hk(paramString1, paramString2);
    AppMethodBeat.o(5629);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.b
 * JD-Core Version:    0.7.0.1
 */