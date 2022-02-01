package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> AGi;
  
  static
  {
    AppMethodBeat.i(187606);
    AGi = Collections.unmodifiableSet(new HashSet(Arrays.asList("US,JP,AU,CA,GB".split("\\s*,\\s*"))));
    AppMethodBeat.o(187606);
  }
  
  public static boolean aIX(String paramString)
  {
    AppMethodBeat.i(187605);
    if ((b.Pi(paramString)) || (AGi.contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(187605);
      return true;
    }
    AppMethodBeat.o(187605);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.e
 * JD-Core Version:    0.7.0.1
 */