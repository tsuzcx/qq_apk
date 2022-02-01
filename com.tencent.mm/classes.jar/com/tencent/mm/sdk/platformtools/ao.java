package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class ao
{
  private static Set<String> IxR;
  
  static
  {
    AppMethodBeat.i(157622);
    IxR = new HashSet();
    AppMethodBeat.o(157622);
  }
  
  public static boolean aRR(String paramString)
  {
    AppMethodBeat.i(157619);
    if (aRT(paramString))
    {
      ae.d("MicroMsg.MMEntryLock", "locked-".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157619);
      return false;
    }
    ae.d("MicroMsg.MMEntryLock", "lock-".concat(String.valueOf(paramString)));
    boolean bool = IxR.add(paramString);
    AppMethodBeat.o(157619);
    return bool;
  }
  
  public static void aRS(String paramString)
  {
    AppMethodBeat.i(157620);
    IxR.remove(paramString);
    ae.d("MicroMsg.MMEntryLock", "unlock-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(157620);
  }
  
  public static boolean aRT(String paramString)
  {
    AppMethodBeat.i(157621);
    boolean bool = IxR.contains(paramString);
    AppMethodBeat.o(157621);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ao
 * JD-Core Version:    0.7.0.1
 */