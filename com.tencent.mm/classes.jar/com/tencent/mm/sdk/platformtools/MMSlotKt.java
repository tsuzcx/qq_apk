package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"DEFAULT_SLOT_SECONDS", "", "now", "isExpire", "", "seconds", "", "millSeconds", "libcompatible_release"})
public final class MMSlotKt
{
  private static final long DEFAULT_SLOT_SECONDS = 900L;
  
  public static final boolean isExpire(long paramLong, int paramInt)
  {
    AppMethodBeat.i(156398);
    boolean bool = isExpire(paramLong, paramInt * 1000L);
    AppMethodBeat.o(156398);
    return bool;
  }
  
  public static final boolean isExpire(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(156397);
    if (now() - paramLong1 > paramLong2)
    {
      AppMethodBeat.o(156397);
      return true;
    }
    AppMethodBeat.o(156397);
    return false;
  }
  
  public static final long now()
  {
    AppMethodBeat.i(215495);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(215495);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMSlotKt
 * JD-Core Version:    0.7.0.1
 */