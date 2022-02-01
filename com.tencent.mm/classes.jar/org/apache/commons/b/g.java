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
      paramIterator = e.cG(localObject);
      AppMethodBeat.o(40748);
      return paramIterator;
    }
    a locala = new a(256);
    if (localObject != null) {
      locala.gX(localObject);
    }
    while (paramIterator.hasNext())
    {
      if (paramString != null) {
        locala.bIt(paramString);
      }
      localObject = paramIterator.next();
      if (localObject != null) {
        locala.gX(localObject);
      }
    }
    paramIterator = locala.toString();
    AppMethodBeat.o(40748);
    return paramIterator;
  }
  
  public static String a(Object[] paramArrayOfObject, char paramChar)
  {
    AppMethodBeat.i(292865);
    paramArrayOfObject = a(paramArrayOfObject, paramChar, paramArrayOfObject.length);
    AppMethodBeat.o(292865);
    return paramArrayOfObject;
  }
  
  public static String a(Object[] paramArrayOfObject, char paramChar, int paramInt)
  {
    AppMethodBeat.i(40745);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(40745);
      return null;
    }
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
          locala.V(paramChar);
        }
        if (paramArrayOfObject[i] != null) {
          locala.gX(paramArrayOfObject[i]);
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
          paramString.bIt(str);
        }
        if (paramArrayOfObject[i] != null) {
          paramString.gX(paramArrayOfObject[i]);
        }
        i += 1;
      }
    }
    paramArrayOfObject = paramString.toString();
    AppMethodBeat.o(40747);
    return paramArrayOfObject;
  }
  
  public static String b(int paramInt, char paramChar)
  {
    AppMethodBeat.i(218564);
    if (paramInt < 0)
    {
      localObject = new IndexOutOfBoundsException("Cannot pad a negative amount: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(218564);
      throw ((Throwable)localObject);
    }
    Object localObject = new char[paramInt];
    paramInt = 0;
    while (paramInt < localObject.length)
    {
      localObject[paramInt] = paramChar;
      paramInt += 1;
    }
    localObject = new String((char[])localObject);
    AppMethodBeat.o(218564);
    return localObject;
  }
  
  public static String b(String paramString, int paramInt, char paramChar)
  {
    AppMethodBeat.i(218566);
    int i;
    int j;
    for (;;)
    {
      if (paramString == null)
      {
        AppMethodBeat.o(218566);
        return null;
      }
      i = paramInt - paramString.length();
      if (i <= 0)
      {
        AppMethodBeat.o(218566);
        return paramString;
      }
      if (i <= 8192) {
        break label228;
      }
      localObject2 = String.valueOf(paramChar);
      if (paramString == null)
      {
        AppMethodBeat.o(218566);
        return null;
      }
      localObject1 = localObject2;
      if (fK((String)localObject2)) {
        localObject1 = " ";
      }
      i = ((String)localObject1).length();
      j = paramInt - paramString.length();
      if (j <= 0)
      {
        AppMethodBeat.o(218566);
        return paramString;
      }
      if ((i != 1) || (j > 8192)) {
        break;
      }
      paramChar = ((String)localObject1).charAt(0);
    }
    if (j == i)
    {
      paramString = ((String)localObject1).concat(paramString);
      AppMethodBeat.o(218566);
      return paramString;
    }
    if (j < i)
    {
      paramString = ((String)localObject1).substring(0, j).concat(paramString);
      AppMethodBeat.o(218566);
      return paramString;
    }
    Object localObject2 = new char[j];
    Object localObject1 = ((String)localObject1).toCharArray();
    paramInt = 0;
    while (paramInt < j)
    {
      localObject2[paramInt] = localObject1[(paramInt % i)];
      paramInt += 1;
    }
    paramString = new String((char[])localObject2).concat(paramString);
    AppMethodBeat.o(218566);
    return paramString;
    label228:
    paramString = b(i, paramChar).concat(paramString);
    AppMethodBeat.o(218566);
    return paramString;
  }
  
  public static String bB(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(218559);
    paramString1 = j(paramString1, paramString2, paramString3, -1);
    AppMethodBeat.o(218559);
    return paramString1;
  }
  
  public static String bIn(String paramString)
  {
    AppMethodBeat.i(218567);
    if (paramString == null)
    {
      AppMethodBeat.o(218567);
      return null;
    }
    paramString = paramString.toLowerCase();
    AppMethodBeat.o(218567);
    return paramString;
  }
  
  public static String bh(String paramString, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(218553);
    if (paramString == null)
    {
      AppMethodBeat.o(218553);
      return null;
    }
    if (paramInt2 < 0) {}
    for (int i = paramString.length() + paramInt2;; i = paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = paramInt1 + paramString.length();
      }
      paramInt1 = i;
      if (i > paramString.length()) {
        paramInt1 = paramString.length();
      }
      if (paramInt2 > paramInt1)
      {
        AppMethodBeat.o(218553);
        return "";
      }
      i = paramInt2;
      if (paramInt2 < 0) {
        i = 0;
      }
      if (paramInt1 < 0) {
        paramInt1 = j;
      }
      for (;;)
      {
        paramString = paramString.substring(i, paramInt1);
        AppMethodBeat.o(218553);
        return paramString;
      }
    }
  }
  
  public static boolean eV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218550);
    if (paramString1 == null)
    {
      AppMethodBeat.o(218550);
      return false;
    }
    if (paramString1.indexOf(paramString2) >= 0)
    {
      AppMethodBeat.o(218550);
      return true;
    }
    AppMethodBeat.o(218550);
    return false;
  }
  
  public static boolean fK(String paramString)
  {
    AppMethodBeat.i(218548);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(218548);
      return true;
    }
    AppMethodBeat.o(218548);
    return false;
  }
  
  private static String j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(218562);
    if ((fK(paramString1)) || (fK(paramString2)) || (paramString3 == null))
    {
      AppMethodBeat.o(218562);
      return paramString1;
    }
    int j = paramString1.indexOf(paramString2, 0);
    if (j == -1)
    {
      AppMethodBeat.o(218562);
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
      locala.bIt(paramString1.substring(paramInt, j)).bIt(paramString3);
      paramInt = j + m;
      i -= 1;
      k = paramInt;
      if (i == 0) {
        break;
      }
      j = paramString1.indexOf(paramString2, paramInt);
    }
    locala.bIt(paramString1.substring(k));
    paramString1 = locala.toString();
    AppMethodBeat.o(218562);
    return paramString1;
  }
  
  public static boolean oC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218549);
    if (paramString1 == null)
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(218549);
        return true;
      }
      AppMethodBeat.o(218549);
      return false;
    }
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(218549);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.g
 * JD-Core Version:    0.7.0.1
 */