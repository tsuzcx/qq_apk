package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

class BuildInfo$StringUtil
{
  public static String diffStr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125203);
    if (paramString1 == null)
    {
      AppMethodBeat.o(125203);
      return null;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(125203);
      return paramString1;
    }
    paramString1 = String.format("%s(%s)", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(125203);
    return paramString1;
  }
  
  public static String stringFrom(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125202);
    if (paramString1 == null)
    {
      AppMethodBeat.o(125202);
      return null;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(125202);
      return paramString1;
    }
    paramString1 = paramString1.substring(i);
    AppMethodBeat.o(125202);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BuildInfo.StringUtil
 * JD-Core Version:    0.7.0.1
 */