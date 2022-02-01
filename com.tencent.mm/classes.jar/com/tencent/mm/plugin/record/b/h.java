package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.b.a;

public final class h
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(27800);
    gw localgw = new gw();
    localgw.dsV.type = 2;
    localgw.dsV.dsX = paramb.dsC;
    a.IbL.l(localgw);
    paramb = localgw.dsW.path;
    AppMethodBeat.o(27800);
    return paramb;
  }
  
  public static String b(b paramb)
  {
    AppMethodBeat.i(27801);
    gw localgw = new gw();
    localgw.dsV.type = 2;
    localgw.dsV.dsX = paramb.dsC;
    a.IbL.l(localgw);
    paramb = localgw.dsW.thumbPath;
    AppMethodBeat.o(27801);
    return paramb;
  }
  
  public static boolean c(b paramb)
  {
    AppMethodBeat.i(27802);
    gw localgw = new gw();
    localgw.dsV.type = 14;
    localgw.dsV.dsX = paramb.dsC;
    a.IbL.l(localgw);
    if (localgw.dsW.ret == 1)
    {
      AppMethodBeat.o(27802);
      return true;
    }
    AppMethodBeat.o(27802);
    return false;
  }
  
  public static com.tencent.mm.plugin.fav.a.g yE(long paramLong)
  {
    AppMethodBeat.i(27803);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
    AppMethodBeat.o(27803);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.h
 * JD-Core Version:    0.7.0.1
 */