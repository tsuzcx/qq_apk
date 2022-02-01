package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class MMEntryLock
{
  private static final String TAG = "MicroMsg.MMEntryLock";
  private static Set<String> locks;
  
  static
  {
    AppMethodBeat.i(157622);
    locks = new HashSet();
    AppMethodBeat.o(157622);
  }
  
  public static boolean isLocked(String paramString)
  {
    AppMethodBeat.i(157621);
    boolean bool = locks.contains(paramString);
    AppMethodBeat.o(157621);
    return bool;
  }
  
  public static boolean lock(String paramString)
  {
    AppMethodBeat.i(157619);
    if (isLocked(paramString))
    {
      Log.d("MicroMsg.MMEntryLock", "locked-".concat(String.valueOf(paramString)));
      AppMethodBeat.o(157619);
      return false;
    }
    Log.d("MicroMsg.MMEntryLock", "lock-".concat(String.valueOf(paramString)));
    boolean bool = locks.add(paramString);
    AppMethodBeat.o(157619);
    return bool;
  }
  
  public static void unlock(String paramString)
  {
    AppMethodBeat.i(157620);
    locks.remove(paramString);
    Log.d("MicroMsg.MMEntryLock", "unlock-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(157620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMEntryLock
 * JD-Core Version:    0.7.0.1
 */