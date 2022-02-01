package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class an
{
  private static Set<String> EUF;
  
  static
  {
    AppMethodBeat.i(157622);
    EUF = new HashSet();
    AppMethodBeat.o(157622);
  }
  
  public static boolean aFx(String paramString)
  {
    AppMethodBeat.i(157619);
    if (aFz(paramString))
    {
      ad.d("MicroMsg.MMEntryLock", "locked-".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157619);
      return false;
    }
    ad.d("MicroMsg.MMEntryLock", "lock-".concat(String.valueOf(paramString)));
    boolean bool = EUF.add(paramString);
    AppMethodBeat.o(157619);
    return bool;
  }
  
  public static void aFy(String paramString)
  {
    AppMethodBeat.i(157620);
    EUF.remove(paramString);
    ad.d("MicroMsg.MMEntryLock", "unlock-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(157620);
  }
  
  public static boolean aFz(String paramString)
  {
    AppMethodBeat.i(157621);
    boolean bool = EUF.contains(paramString);
    AppMethodBeat.o(157621);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.an
 * JD-Core Version:    0.7.0.1
 */