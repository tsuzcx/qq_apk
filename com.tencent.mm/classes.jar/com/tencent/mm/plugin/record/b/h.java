package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;

public final class h
{
  public static g Po(long paramLong)
  {
    AppMethodBeat.i(27803);
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
    AppMethodBeat.o(27803);
    return localg;
  }
  
  public static String a(b paramb)
  {
    AppMethodBeat.i(27800);
    hi localhi = new hi();
    localhi.fEb.type = 2;
    localhi.fEb.fEd = paramb.fDI;
    EventCenter.instance.publish(localhi);
    paramb = localhi.fEc.path;
    AppMethodBeat.o(27800);
    return paramb;
  }
  
  public static String b(b paramb)
  {
    AppMethodBeat.i(27801);
    hi localhi = new hi();
    localhi.fEb.type = 2;
    localhi.fEb.fEd = paramb.fDI;
    EventCenter.instance.publish(localhi);
    paramb = localhi.fEc.thumbPath;
    AppMethodBeat.o(27801);
    return paramb;
  }
  
  public static boolean c(b paramb)
  {
    AppMethodBeat.i(27802);
    hi localhi = new hi();
    localhi.fEb.type = 14;
    localhi.fEb.fEd = paramb.fDI;
    EventCenter.instance.publish(localhi);
    if (localhi.fEc.ret == 1)
    {
      AppMethodBeat.o(27802);
      return true;
    }
    AppMethodBeat.o(27802);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.h
 * JD-Core Version:    0.7.0.1
 */