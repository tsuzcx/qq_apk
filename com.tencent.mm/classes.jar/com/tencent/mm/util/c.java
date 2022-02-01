package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class c
{
  public static final int fwV()
  {
    AppMethodBeat.i(152882);
    if ((g.agR().agA().getInt(ah.a.GWl, 0) & 0x1) > 0)
    {
      AppMethodBeat.o(152882);
      return 1;
    }
    AppMethodBeat.o(152882);
    return 0;
  }
  
  public static final boolean fwW()
  {
    AppMethodBeat.i(152883);
    if (fwV() == 1)
    {
      AppMethodBeat.o(152883);
      return true;
    }
    AppMethodBeat.o(152883);
    return false;
  }
  
  public static final boolean fwX()
  {
    AppMethodBeat.i(192719);
    if ((g.agR().agA().getInt(ah.a.GWl, 0) & 0x2) > 0)
    {
      AppMethodBeat.o(192719);
      return true;
    }
    AppMethodBeat.o(192719);
    return false;
  }
  
  public static final boolean fwY()
  {
    return (h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED);
  }
  
  public static final boolean fwZ()
  {
    AppMethodBeat.i(192720);
    if ((h.DEBUG) || (fwY()) || (bt.eWo()))
    {
      AppMethodBeat.o(192720);
      return true;
    }
    AppMethodBeat.o(192720);
    return false;
  }
  
  public static final boolean ghj()
  {
    AppMethodBeat.i(210361);
    if ((g.agR().agA().getInt(ah.a.GWl, 0) & 0x4) > 0)
    {
      AppMethodBeat.o(210361);
      return true;
    }
    AppMethodBeat.o(210361);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.util.c
 * JD-Core Version:    0.7.0.1
 */