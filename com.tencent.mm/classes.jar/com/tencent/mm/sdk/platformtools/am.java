package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class am
{
  private static Set<String> GrR;
  
  static
  {
    AppMethodBeat.i(157622);
    GrR = new HashSet();
    AppMethodBeat.o(157622);
  }
  
  public static boolean aKO(String paramString)
  {
    AppMethodBeat.i(157619);
    if (aKQ(paramString))
    {
      ac.d("MicroMsg.MMEntryLock", "locked-".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157619);
      return false;
    }
    ac.d("MicroMsg.MMEntryLock", "lock-".concat(String.valueOf(paramString)));
    boolean bool = GrR.add(paramString);
    AppMethodBeat.o(157619);
    return bool;
  }
  
  public static void aKP(String paramString)
  {
    AppMethodBeat.i(157620);
    GrR.remove(paramString);
    ac.d("MicroMsg.MMEntryLock", "unlock-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(157620);
  }
  
  public static boolean aKQ(String paramString)
  {
    AppMethodBeat.i(157621);
    boolean bool = GrR.contains(paramString);
    AppMethodBeat.o(157621);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.am
 * JD-Core Version:    0.7.0.1
 */