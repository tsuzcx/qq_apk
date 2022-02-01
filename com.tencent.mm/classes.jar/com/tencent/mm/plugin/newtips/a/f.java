package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static f MsA;
  private static Map<Integer, h> Msy;
  static Map<Integer, j> Msz;
  
  private f()
  {
    AppMethodBeat.i(127219);
    Msy = new HashMap();
    Msz = new HashMap();
    AppMethodBeat.o(127219);
  }
  
  public static h aeF(int paramInt)
  {
    AppMethodBeat.i(127220);
    h localh2 = (h)Msy.get(Integer.valueOf(paramInt));
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = null;
      Log.i("MicroMsg.NewTips.NewTipsFilterPool", "Invalid tipsId:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(127220);
    return localh1;
  }
  
  public static f gtk()
  {
    AppMethodBeat.i(127218);
    if (MsA == null) {
      MsA = new f();
    }
    f localf = MsA;
    AppMethodBeat.o(127218);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.f
 * JD-Core Version:    0.7.0.1
 */