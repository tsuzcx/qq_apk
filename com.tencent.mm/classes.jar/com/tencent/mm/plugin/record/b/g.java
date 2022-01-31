package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.b.a;

public final class g
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(24163);
    gi localgi = new gi();
    localgi.cuX.type = 2;
    localgi.cuX.cuZ = paramb.cuL;
    a.ymk.l(localgi);
    paramb = localgi.cuY.path;
    AppMethodBeat.o(24163);
    return paramb;
  }
  
  public static String b(b paramb)
  {
    AppMethodBeat.i(24164);
    gi localgi = new gi();
    localgi.cuX.type = 2;
    localgi.cuX.cuZ = paramb.cuL;
    a.ymk.l(localgi);
    paramb = localgi.cuY.thumbPath;
    AppMethodBeat.o(24164);
    return paramb;
  }
  
  public static boolean c(b paramb)
  {
    AppMethodBeat.i(24165);
    gi localgi = new gi();
    localgi.cuX.type = 14;
    localgi.cuX.cuZ = paramb.cuL;
    a.ymk.l(localgi);
    if (localgi.cuY.ret == 1)
    {
      AppMethodBeat.o(24165);
      return true;
    }
    AppMethodBeat.o(24165);
    return false;
  }
  
  public static com.tencent.mm.plugin.fav.a.g kY(long paramLong)
  {
    AppMethodBeat.i(24166);
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
    AppMethodBeat.o(24166);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */