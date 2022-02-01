package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static f GwA;
  private static Map<Integer, h> Gwy;
  static Map<Integer, j> Gwz;
  
  private f()
  {
    AppMethodBeat.i(127219);
    Gwy = new HashMap();
    Gwz = new HashMap();
    AppMethodBeat.o(127219);
  }
  
  public static h aam(int paramInt)
  {
    AppMethodBeat.i(127220);
    h localh2 = (h)Gwy.get(Integer.valueOf(paramInt));
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = null;
      Log.i("MicroMsg.NewTips.NewTipsFilterPool", "Invalid tipsId:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(127220);
    return localh1;
  }
  
  public static f fiT()
  {
    AppMethodBeat.i(127218);
    if (GwA == null) {
      GwA = new f();
    }
    f localf = GwA;
    AppMethodBeat.o(127218);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.f
 * JD-Core Version:    0.7.0.1
 */