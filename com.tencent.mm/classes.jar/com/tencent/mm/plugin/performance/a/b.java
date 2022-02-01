package com.tencent.mm.plugin.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static String aJR(String paramString)
  {
    AppMethodBeat.i(145999);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(145999);
      return paramString;
    }
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((char)(byte)(((byte)paramString.charAt(i) ^ i - j ^ 0x3C) & 0xFF));
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(145999);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.b
 * JD-Core Version:    0.7.0.1
 */