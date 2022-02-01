package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> Mvz;
  
  static
  {
    AppMethodBeat.i(261941);
    Mvz = Collections.unmodifiableSet(new HashSet(Arrays.asList("US,JP,AU,CA,GB".split("\\s*,\\s*"))));
    AppMethodBeat.o(261941);
  }
  
  public static boolean aQt(String paramString)
  {
    AppMethodBeat.i(261940);
    if ((b.OE(paramString)) || (Mvz.contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(261940);
      return true;
    }
    AppMethodBeat.o(261940);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.e
 * JD-Core Version:    0.7.0.1
 */