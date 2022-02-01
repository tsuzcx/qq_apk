package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.b.a;

public final class g
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(27800);
    gt localgt = new gt();
    localgt.dhx.type = 2;
    localgt.dhx.dhz = paramb.dhe;
    a.GpY.l(localgt);
    paramb = localgt.dhy.path;
    AppMethodBeat.o(27800);
    return paramb;
  }
  
  public static String b(b paramb)
  {
    AppMethodBeat.i(27801);
    gt localgt = new gt();
    localgt.dhx.type = 2;
    localgt.dhx.dhz = paramb.dhe;
    a.GpY.l(localgt);
    paramb = localgt.dhy.thumbPath;
    AppMethodBeat.o(27801);
    return paramb;
  }
  
  public static boolean c(b paramb)
  {
    AppMethodBeat.i(27802);
    gt localgt = new gt();
    localgt.dhx.type = 14;
    localgt.dhx.dhz = paramb.dhe;
    a.GpY.l(localgt);
    if (localgt.dhy.ret == 1)
    {
      AppMethodBeat.o(27802);
      return true;
    }
    AppMethodBeat.o(27802);
    return false;
  }
  
  public static com.tencent.mm.plugin.fav.a.g ws(long paramLong)
  {
    AppMethodBeat.i(27803);
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
    AppMethodBeat.o(27803);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */