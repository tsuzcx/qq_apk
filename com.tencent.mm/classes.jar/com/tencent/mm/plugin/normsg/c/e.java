package com.tencent.mm.plugin.normsg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> wKH;
  
  static
  {
    AppMethodBeat.i(189728);
    wKH = Collections.unmodifiableSet(new HashSet(Arrays.asList("US,JP,AU,CA,GB".split("\\s*,\\s*"))));
    AppMethodBeat.o(189728);
  }
  
  public static boolean auL(String paramString)
  {
    AppMethodBeat.i(189727);
    if ((b.Gw(paramString)) || (wKH.contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(189727);
      return true;
    }
    AppMethodBeat.o(189727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.e
 * JD-Core Version:    0.7.0.1
 */