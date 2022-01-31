package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.d.a;

public final class g
{
  private static String a(Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(142952);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(142952);
      return null;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int j = paramInt + 0;
    if (j <= 0)
    {
      AppMethodBeat.o(142952);
      return "";
    }
    if (paramArrayOfObject[0] == null) {}
    for (int i = 16;; i = paramArrayOfObject[0].toString().length())
    {
      paramString = new a((i + str.length()) * j);
      i = 0;
      while (i < paramInt)
      {
        if (i > 0) {
          paramString.azP(str);
        }
        if (paramArrayOfObject[i] != null) {
          paramString.eo(paramArrayOfObject[i]);
        }
        i += 1;
      }
    }
    paramArrayOfObject = paramString.toString();
    AppMethodBeat.o(142952);
    return paramArrayOfObject;
  }
  
  public static String ab(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(116957);
    if (paramArrayOfObject[0] == null) {}
    a locala;
    for (int i = 16;; i = paramArrayOfObject[0].toString().length())
    {
      locala = new a((i + 1) * 3);
      i = 0;
      while (i < 3)
      {
        if (i > 0) {
          locala.eru();
        }
        if (paramArrayOfObject[i] != null) {
          locala.eo(paramArrayOfObject[i]);
        }
        i += 1;
      }
    }
    paramArrayOfObject = locala.toString();
    AppMethodBeat.o(116957);
    return paramArrayOfObject;
  }
  
  public static String b(Object[] paramArrayOfObject, String paramString)
  {
    AppMethodBeat.i(142951);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(142951);
      return null;
    }
    paramArrayOfObject = a(paramArrayOfObject, paramString, paramArrayOfObject.length);
    AppMethodBeat.o(142951);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.g
 * JD-Core Version:    0.7.0.1
 */