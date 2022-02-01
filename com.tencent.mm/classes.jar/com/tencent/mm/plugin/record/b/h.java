package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;

public final class h
{
  public static com.tencent.mm.plugin.fav.a.g HT(long paramLong)
  {
    AppMethodBeat.i(27803);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
    AppMethodBeat.o(27803);
    return localg;
  }
  
  public static String a(b paramb)
  {
    AppMethodBeat.i(27800);
    hb localhb = new hb();
    localhb.dLm.type = 2;
    localhb.dLm.dLo = paramb.dKT;
    EventCenter.instance.publish(localhb);
    paramb = localhb.dLn.path;
    AppMethodBeat.o(27800);
    return paramb;
  }
  
  public static String b(b paramb)
  {
    AppMethodBeat.i(27801);
    hb localhb = new hb();
    localhb.dLm.type = 2;
    localhb.dLm.dLo = paramb.dKT;
    EventCenter.instance.publish(localhb);
    paramb = localhb.dLn.thumbPath;
    AppMethodBeat.o(27801);
    return paramb;
  }
  
  public static boolean c(b paramb)
  {
    AppMethodBeat.i(27802);
    hb localhb = new hb();
    localhb.dLm.type = 14;
    localhb.dLm.dLo = paramb.dKT;
    EventCenter.instance.publish(localhb);
    if (localhb.dLn.ret == 1)
    {
      AppMethodBeat.o(27802);
      return true;
    }
    AppMethodBeat.o(27802);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.h
 * JD-Core Version:    0.7.0.1
 */