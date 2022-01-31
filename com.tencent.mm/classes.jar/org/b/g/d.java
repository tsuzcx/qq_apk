package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class d
{
  private static final Pattern CSl;
  
  static
  {
    AppMethodBeat.i(77307);
    CSl = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");
    AppMethodBeat.o(77307);
  }
  
  private static void C(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(77310);
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.trim().length() > 0) {}
    }
    else
    {
      str = "Received an invalid parameter";
    }
    if (!paramBoolean)
    {
      paramString = new IllegalArgumentException(str);
      AppMethodBeat.o(77310);
      throw paramString;
    }
    AppMethodBeat.o(77310);
  }
  
  public static void jJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77309);
    if ((paramString1 != null) && (!paramString1.trim().equals(""))) {}
    for (boolean bool = true;; bool = false)
    {
      C(bool, paramString2);
      AppMethodBeat.o(77309);
      return;
    }
  }
  
  public static void s(Object paramObject, String paramString)
  {
    AppMethodBeat.i(77308);
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      C(bool, paramString);
      AppMethodBeat.o(77308);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.b.g.d
 * JD-Core Version:    0.7.0.1
 */