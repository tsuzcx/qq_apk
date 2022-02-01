package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static Map<Integer, h> ADt;
  static Map<Integer, j> ADu;
  private static f ADv;
  
  private f()
  {
    AppMethodBeat.i(127219);
    ADt = new HashMap();
    ADu = new HashMap();
    AppMethodBeat.o(127219);
  }
  
  public static h Tz(int paramInt)
  {
    AppMethodBeat.i(127220);
    h localh2 = (h)ADt.get(Integer.valueOf(paramInt));
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = null;
      Log.i("MicroMsg.NewTips.NewTipsFilterPool", "Invalid tipsId:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(127220);
    return localh1;
  }
  
  public static f exq()
  {
    AppMethodBeat.i(127218);
    if (ADv == null) {
      ADv = new f();
    }
    f localf = ADv;
    AppMethodBeat.o(127218);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.f
 * JD-Core Version:    0.7.0.1
 */