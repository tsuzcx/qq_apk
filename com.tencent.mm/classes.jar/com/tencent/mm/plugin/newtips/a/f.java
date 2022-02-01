package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static Map<Integer, h> vni;
  static Map<Integer, j> vnj;
  private static f vnk;
  
  private f()
  {
    AppMethodBeat.i(127219);
    vni = new HashMap();
    vnj = new HashMap();
    AppMethodBeat.o(127219);
  }
  
  public static h Kl(int paramInt)
  {
    AppMethodBeat.i(127220);
    h localh2 = (h)vni.get(Integer.valueOf(paramInt));
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = null;
      ac.i("MicroMsg.NewTips.NewTipsFilterPool", "Invalid tipsId:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(127220);
    return localh1;
  }
  
  public static f dkg()
  {
    AppMethodBeat.i(127218);
    if (vnk == null) {
      vnk = new f();
    }
    f localf = vnk;
    AppMethodBeat.o(127218);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.f
 * JD-Core Version:    0.7.0.1
 */