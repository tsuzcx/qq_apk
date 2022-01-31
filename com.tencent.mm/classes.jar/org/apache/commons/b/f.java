package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private static final String CPu = "\"";
  private static final char[] CPv = { 44, 34, 13, 10 };
  
  public static String azJ(String paramString)
  {
    AppMethodBeat.i(116956);
    if (paramString == null)
    {
      AppMethodBeat.o(116956);
      return null;
    }
    paramString = c.CPk.unescape(paramString);
    AppMethodBeat.o(116956);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.b.f
 * JD-Core Version:    0.7.0.1
 */