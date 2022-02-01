package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
{
  public static String p(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(143283);
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (paramString.contains("?")) {}
    for (paramString = "&";; paramString = "?")
    {
      localStringBuilder.append(paramString);
      int i = 0;
      while (i <= 0)
      {
        localStringBuilder.append(paramVarArgs[0]);
        i += 1;
      }
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(143283);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.x
 * JD-Core Version:    0.7.0.1
 */