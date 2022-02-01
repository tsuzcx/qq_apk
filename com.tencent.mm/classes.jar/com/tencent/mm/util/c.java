package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class c
{
  public static final int fgV()
  {
    AppMethodBeat.i(152882);
    if ((g.afB().afk().getInt(ae.a.Fxr, 0) & 0x1) > 0)
    {
      AppMethodBeat.o(152882);
      return 1;
    }
    AppMethodBeat.o(152882);
    return 0;
  }
  
  public static final boolean fgW()
  {
    AppMethodBeat.i(152883);
    if (fgV() == 1)
    {
      AppMethodBeat.o(152883);
      return true;
    }
    AppMethodBeat.o(152883);
    return false;
  }
  
  public static final boolean fgX()
  {
    return (h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED);
  }
  
  public static final boolean gao()
  {
    AppMethodBeat.i(203581);
    if ((h.DEBUG) || (fgX()) || (bu.eGT()))
    {
      AppMethodBeat.o(203581);
      return true;
    }
    AppMethodBeat.o(203581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.util.c
 * JD-Core Version:    0.7.0.1
 */