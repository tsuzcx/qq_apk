package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class ag
{
  private static Set<String> ufn = new HashSet();
  
  public static boolean Zm(String paramString)
  {
    if (Zo(paramString))
    {
      y.d("MicroMsg.MMEntryLock", "locked-" + paramString);
      return false;
    }
    y.d("MicroMsg.MMEntryLock", "lock-" + paramString);
    return ufn.add(paramString);
  }
  
  public static void Zn(String paramString)
  {
    ufn.remove(paramString);
    y.d("MicroMsg.MMEntryLock", "unlock-" + paramString);
  }
  
  public static boolean Zo(String paramString)
  {
    return ufn.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ag
 * JD-Core Version:    0.7.0.1
 */