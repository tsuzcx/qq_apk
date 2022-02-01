package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.b.a;

public final class g
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(27800);
    gs localgs = new gs();
    localgs.dkc.type = 2;
    localgs.dkc.dke = paramb.djJ;
    a.ESL.l(localgs);
    paramb = localgs.dkd.path;
    AppMethodBeat.o(27800);
    return paramb;
  }
  
  public static String b(b paramb)
  {
    AppMethodBeat.i(27801);
    gs localgs = new gs();
    localgs.dkc.type = 2;
    localgs.dkc.dke = paramb.djJ;
    a.ESL.l(localgs);
    paramb = localgs.dkd.thumbPath;
    AppMethodBeat.o(27801);
    return paramb;
  }
  
  public static boolean c(b paramb)
  {
    AppMethodBeat.i(27802);
    gs localgs = new gs();
    localgs.dkc.type = 14;
    localgs.dkc.dke = paramb.djJ;
    a.ESL.l(localgs);
    if (localgs.dkd.ret == 1)
    {
      AppMethodBeat.o(27802);
      return true;
    }
    AppMethodBeat.o(27802);
    return false;
  }
  
  public static com.tencent.mm.plugin.fav.a.g rP(long paramLong)
  {
    AppMethodBeat.i(27803);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
    AppMethodBeat.o(27803);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */