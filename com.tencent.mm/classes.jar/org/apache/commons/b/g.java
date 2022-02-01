package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.b.c.a;

public final class g
{
  public static String a(Collection paramCollection, String paramString)
  {
    AppMethodBeat.i(40749);
    paramCollection = a(paramCollection.iterator(), paramString);
    AppMethodBeat.o(40749);
    return paramCollection;
  }
  
  public static String a(Iterator paramIterator, String paramString)
  {
    AppMethodBeat.i(40748);
    if (paramIterator == null)
    {
      AppMethodBeat.o(40748);
      return null;
    }
    if (!paramIterator.hasNext())
    {
      AppMethodBeat.o(40748);
      return "";
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext())
    {
      paramIterator = e.toString(localObject);
      AppMethodBeat.o(40748);
      return paramIterator;
    }
    a locala = new a(256);
    if (localObject != null) {
      locala.fT(localObject);
    }
    while (paramIterator.hasNext())
    {
      if (paramString != null) {
        locala.aRA(paramString);
      }
      localObject = paramIterator.next();
      if (localObject != null) {
        locala.fT(localObject);
      }
    }
    paramIterator = locala.toString();
    AppMethodBeat.o(40748);
    return paramIterator;
  }
  
  public static String a(Object[] paramArrayOfObject, char paramChar, int paramInt)
  {
    AppMethodBeat.i(40745);
    int j = paramInt + 0;
    if (j <= 0)
    {
      AppMethodBeat.o(40745);
      return "";
    }
    if (paramArrayOfObject[0] == null) {}
    a locala;
    for (int i = 16;; i = paramArrayOfObject[0].toString().length())
    {
      locala = new a((i + 1) * j);
      i = 0;
      while (i < paramInt)
      {
        if (i > 0) {
          locala.I(paramChar);
        }
        if (paramArrayOfObject[i] != null) {
          locala.fT(paramArrayOfObject[i]);
        }
        i += 1;
      }
    }
    paramArrayOfObject = locala.toString();
    AppMethodBeat.o(40745);
    return paramArrayOfObject;
  }
  
  public static String a(Object[] paramArrayOfObject, String paramString)
  {
    AppMethodBeat.i(40746);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(40746);
      return null;
    }
    paramArrayOfObject = a(paramArrayOfObject, paramString, paramArrayOfObject.length);
    AppMethodBeat.o(40746);
    return paramArrayOfObject;
  }
  
  private static String a(Object[] paramArrayOfObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(40747);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(40747);
      return null;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int j = paramInt + 0;
    if (j <= 0)
    {
      AppMethodBeat.o(40747);
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
          paramString.aRA(str);
        }
        if (paramArrayOfObject[i] != null) {
          paramString.fT(paramArrayOfObject[i]);
        }
        i += 1;
      }
    }
    paramArrayOfObject = paramString.toString();
    AppMethodBeat.o(40747);
    return paramArrayOfObject;
  }
  
  public static String gM(String paramString, int paramInt)
  {
    AppMethodBeat.i(186708);
    if (paramString == null)
    {
      AppMethodBeat.o(186708);
      return null;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + paramString.length();
    }
    if (i > paramString.length()) {}
    for (paramInt = paramString.length();; paramInt = i)
    {
      if (paramInt < 0)
      {
        AppMethodBeat.o(186708);
        return "";
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(186708);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.g
 * JD-Core Version:    0.7.0.1
 */