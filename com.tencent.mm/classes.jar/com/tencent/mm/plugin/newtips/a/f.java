package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static Map<Integer, h> uek;
  static Map<Integer, j> uel;
  private static f uem;
  
  private f()
  {
    AppMethodBeat.i(127219);
    uek = new HashMap();
    uel = new HashMap();
    AppMethodBeat.o(127219);
  }
  
  public static h Im(int paramInt)
  {
    AppMethodBeat.i(127220);
    h localh2 = (h)uek.get(Integer.valueOf(paramInt));
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = null;
      ad.i("MicroMsg.NewTips.NewTipsFilterPool", "Invalid tipsId:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(127220);
    return localh1;
  }
  
  public static f cWx()
  {
    AppMethodBeat.i(127218);
    if (uem == null) {
      uem = new f();
    }
    f localf = uem;
    AppMethodBeat.o(127218);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.f
 * JD-Core Version:    0.7.0.1
 */