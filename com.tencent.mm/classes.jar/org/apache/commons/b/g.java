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
      locala.gA(localObject);
    }
    while (paramIterator.hasNext())
    {
      if (paramString != null) {
        locala.bfy(paramString);
      }
      localObject = paramIterator.next();
      if (localObject != null) {
        locala.gA(localObject);
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
          locala.L(paramChar);
        }
        if (paramArrayOfObject[i] != null) {
          locala.gA(paramArrayOfObject[i]);
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
          paramString.bfy(str);
        }
        if (paramArrayOfObject[i] != null) {
          paramString.gA(paramArrayOfObject[i]);
        }
        i += 1;
      }
    }
    paramArrayOfObject = paramString.toString();
    AppMethodBeat.o(40747);
    return paramArrayOfObject;
  }
  
  public static String bu(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(193966);
    paramString1 = k(paramString1, paramString2, paramString3, -1);
    AppMethodBeat.o(193966);
    return paramString1;
  }
  
  public static boolean ef(String paramString)
  {
    AppMethodBeat.i(193962);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(193962);
      return true;
    }
    AppMethodBeat.o(193962);
    return false;
  }
  
  public static boolean eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193964);
    if (paramString1 == null)
    {
      AppMethodBeat.o(193964);
      return false;
    }
    if (paramString1.indexOf(paramString2) >= 0)
    {
      AppMethodBeat.o(193964);
      return true;
    }
    AppMethodBeat.o(193964);
    return false;
  }
  
  public static boolean equals(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193963);
    if (paramString1 == null)
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(193963);
        return true;
      }
      AppMethodBeat.o(193963);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(193963);
    return bool;
  }
  
  public static String hH(String paramString, int paramInt)
  {
    AppMethodBeat.i(193965);
    if (paramString == null)
    {
      AppMethodBeat.o(193965);
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
        AppMethodBeat.o(193965);
        return "";
      }
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(193965);
      return paramString;
    }
  }
  
  private static String k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(193967);
    if ((ef(paramString1)) || (ef(paramString2)) || (paramString3 == null))
    {
      AppMethodBeat.o(193967);
      return paramString1;
    }
    int j = paramString1.indexOf(paramString2, 0);
    if (j == -1)
    {
      AppMethodBeat.o(193967);
      return paramString1;
    }
    int m = paramString2.length();
    int k = paramString3.length() - m;
    int i = k;
    if (k < 0) {
      i = 0;
    }
    a locala = new a(i * 16 + paramString1.length());
    k = 0;
    i = paramInt;
    paramInt = k;
    for (;;)
    {
      k = paramInt;
      if (j == -1) {
        break;
      }
      locala.bfy(paramString1.substring(paramInt, j)).bfy(paramString3);
      paramInt = j + m;
      i -= 1;
      k = paramInt;
      if (i == 0) {
        break;
      }
      j = paramString1.indexOf(paramString2, paramInt);
    }
    locala.bfy(paramString1.substring(k));
    paramString1 = locala.toString();
    AppMethodBeat.o(193967);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.g
 * JD-Core Version:    0.7.0.1
 */