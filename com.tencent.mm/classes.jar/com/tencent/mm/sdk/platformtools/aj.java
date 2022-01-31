package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class aj
{
  private static Set<String> ynN;
  
  static
  {
    AppMethodBeat.i(52065);
    ynN = new HashSet();
    AppMethodBeat.o(52065);
  }
  
  public static boolean apk(String paramString)
  {
    AppMethodBeat.i(52062);
    if (apm(paramString))
    {
      ab.d("MicroMsg.MMEntryLock", "locked-".concat(String.valueOf(paramString)));
      AppMethodBeat.o(52062);
      return false;
    }
    ab.d("MicroMsg.MMEntryLock", "lock-".concat(String.valueOf(paramString)));
    boolean bool = ynN.add(paramString);
    AppMethodBeat.o(52062);
    return bool;
  }
  
  public static void apl(String paramString)
  {
    AppMethodBeat.i(52063);
    ynN.remove(paramString);
    ab.d("MicroMsg.MMEntryLock", "unlock-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(52063);
  }
  
  public static boolean apm(String paramString)
  {
    AppMethodBeat.i(52064);
    boolean bool = ynN.contains(paramString);
    AppMethodBeat.o(52064);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aj
 * JD-Core Version:    0.7.0.1
 */