package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"DEFAULT_SLOT_SECONDS", "", "now", "isExpire", "", "seconds", "", "millSeconds", "libcompatible_release"})
public final class as
{
  public static final boolean ad(long paramLong, int paramInt)
  {
    AppMethodBeat.i(156398);
    boolean bool = au(paramLong, paramInt * 1000L);
    AppMethodBeat.o(156398);
    return bool;
  }
  
  public static final boolean au(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(156397);
    if (System.currentTimeMillis() - paramLong1 > paramLong2)
    {
      AppMethodBeat.o(156397);
      return true;
    }
    AppMethodBeat.o(156397);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.as
 * JD-Core Version:    0.7.0.1
 */