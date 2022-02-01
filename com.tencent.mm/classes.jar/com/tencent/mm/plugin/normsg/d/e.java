package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> Gzr;
  
  static
  {
    AppMethodBeat.i(257679);
    Gzr = Collections.unmodifiableSet(new HashSet(Arrays.asList("US,JP,AU,CA,GB".split("\\s*,\\s*"))));
    AppMethodBeat.o(257679);
  }
  
  public static boolean aTt(String paramString)
  {
    AppMethodBeat.i(257676);
    if ((b.WF(paramString)) || (Gzr.contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(257676);
      return true;
    }
    AppMethodBeat.o(257676);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.e
 * JD-Core Version:    0.7.0.1
 */