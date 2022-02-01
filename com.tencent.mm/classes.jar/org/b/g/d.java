package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class d
{
  private static final Pattern URL_PATTERN;
  
  static
  {
    AppMethodBeat.i(40576);
    URL_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");
    AppMethodBeat.o(40576);
  }
  
  private static void J(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(40579);
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
      AppMethodBeat.o(40579);
      throw paramString;
    }
    AppMethodBeat.o(40579);
  }
  
  public static void j(Object paramObject, String paramString)
  {
    AppMethodBeat.i(40577);
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      J(bool, paramString);
      AppMethodBeat.o(40577);
      return;
    }
  }
  
  public static void mP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40578);
    if ((paramString1 != null) && (!paramString1.trim().equals(""))) {}
    for (boolean bool = true;; bool = false)
    {
      J(bool, paramString2);
      AppMethodBeat.o(40578);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.g.d
 * JD-Core Version:    0.7.0.1
 */