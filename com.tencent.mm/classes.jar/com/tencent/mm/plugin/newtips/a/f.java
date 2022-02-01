package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static Map<Integer, h> wsA;
  static Map<Integer, j> wsB;
  private static f wsC;
  
  private f()
  {
    AppMethodBeat.i(127219);
    wsA = new HashMap();
    wsB = new HashMap();
    AppMethodBeat.o(127219);
  }
  
  public static h LN(int paramInt)
  {
    AppMethodBeat.i(127220);
    h localh2 = (h)wsA.get(Integer.valueOf(paramInt));
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = null;
      ad.i("MicroMsg.NewTips.NewTipsFilterPool", "Invalid tipsId:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(127220);
    return localh1;
  }
  
  public static f dus()
  {
    AppMethodBeat.i(127218);
    if (wsC == null) {
      wsC = new f();
    }
    f localf = wsC;
    AppMethodBeat.o(127218);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.f
 * JD-Core Version:    0.7.0.1
 */