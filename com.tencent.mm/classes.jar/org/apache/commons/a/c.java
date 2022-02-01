package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
{
  public static final String abHQ;
  private static final char abHR;
  private static final char abHS;
  
  static
  {
    AppMethodBeat.i(10303);
    abHQ = Character.toString('.');
    char c = File.separatorChar;
    abHR = c;
    if (c == '\\') {}
    for (int i = 1; i != 0; i = 0)
    {
      abHS = '/';
      AppMethodBeat.o(10303);
      return;
    }
    abHS = '\\';
    AppMethodBeat.o(10303);
  }
  
  private static boolean T(char paramChar)
  {
    return (paramChar == '/') || (paramChar == '\\');
  }
  
  private static int bIc(String paramString)
  {
    AppMethodBeat.i(10298);
    if (paramString == null)
    {
      AppMethodBeat.o(10298);
      return -1;
    }
    int i = paramString.length();
    if (i == 0)
    {
      AppMethodBeat.o(10298);
      return 0;
    }
    char c1 = paramString.charAt(0);
    if (c1 == ':')
    {
      AppMethodBeat.o(10298);
      return -1;
    }
    if (i == 1)
    {
      if (c1 == '~')
      {
        AppMethodBeat.o(10298);
        return 2;
      }
      if (T(c1))
      {
        AppMethodBeat.o(10298);
        return 1;
      }
      AppMethodBeat.o(10298);
      return 0;
    }
    int k;
    int j;
    if (c1 == '~')
    {
      k = paramString.indexOf('/', 1);
      j = paramString.indexOf('\\', 1);
      if ((k == -1) && (j == -1))
      {
        AppMethodBeat.o(10298);
        return i + 1;
      }
      i = k;
      if (k == -1) {
        i = j;
      }
      k = j;
      if (j == -1) {
        k = i;
      }
      i = Math.min(i, k);
      AppMethodBeat.o(10298);
      return i + 1;
    }
    char c2 = paramString.charAt(1);
    if (c2 == ':')
    {
      j = Character.toUpperCase(c1);
      if ((j >= 65) && (j <= 90))
      {
        if ((i == 2) || (!T(paramString.charAt(2))))
        {
          AppMethodBeat.o(10298);
          return 2;
        }
        AppMethodBeat.o(10298);
        return 3;
      }
      if (j == 47)
      {
        AppMethodBeat.o(10298);
        return 1;
      }
      AppMethodBeat.o(10298);
      return -1;
    }
    if ((T(c1)) && (T(c2)))
    {
      i = paramString.indexOf('/', 2);
      j = paramString.indexOf('\\', 2);
      if (((i == -1) && (j == -1)) || (i == 2) || (j == 2))
      {
        AppMethodBeat.o(10298);
        return -1;
      }
      if (i == -1) {
        i = j;
      }
      for (;;)
      {
        k = j;
        if (j == -1) {
          k = i;
        }
        i = Math.min(i, k);
        AppMethodBeat.o(10298);
        return i + 1;
      }
    }
    if (T(c1))
    {
      AppMethodBeat.o(10298);
      return 1;
    }
    AppMethodBeat.o(10298);
    return 0;
  }
  
  private static int bId(String paramString)
  {
    AppMethodBeat.i(10299);
    if (paramString == null)
    {
      AppMethodBeat.o(10299);
      return -1;
    }
    int i = Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
    AppMethodBeat.o(10299);
    return i;
  }
  
  private static void bIe(String paramString)
  {
    AppMethodBeat.i(10301);
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (paramString.charAt(i) == 0)
      {
        paramString = new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
        AppMethodBeat.o(10301);
        throw paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(10301);
  }
  
  public static String bIf(String paramString)
  {
    AppMethodBeat.i(10302);
    if (paramString == null)
    {
      AppMethodBeat.o(10302);
      return null;
    }
    int i;
    if (paramString == null) {
      i = -1;
    }
    while (i == -1)
    {
      AppMethodBeat.o(10302);
      return "";
      int j = paramString.lastIndexOf('.');
      i = j;
      if (bId(paramString) > j) {
        i = -1;
      }
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(10302);
    return paramString;
  }
  
  public static String beJ(String paramString)
  {
    AppMethodBeat.i(10300);
    if (paramString == null)
    {
      AppMethodBeat.o(10300);
      return null;
    }
    bIe(paramString);
    paramString = paramString.substring(bId(paramString) + 1);
    AppMethodBeat.o(10300);
    return paramString;
  }
  
  private static String normalize(String paramString)
  {
    AppMethodBeat.i(10296);
    int i = abHR;
    if (paramString == null)
    {
      AppMethodBeat.o(10296);
      return null;
    }
    bIe(paramString);
    int m = paramString.length();
    if (m == 0)
    {
      AppMethodBeat.o(10296);
      return paramString;
    }
    int i3 = bIc(paramString);
    if (i3 < 0)
    {
      AppMethodBeat.o(10296);
      return null;
    }
    char[] arrayOfChar = new char[m + 2];
    paramString.getChars(0, paramString.length(), arrayOfChar, 0);
    if (i == abHR) {}
    int k;
    for (int j = abHS;; j = abHR)
    {
      k = 0;
      while (k < arrayOfChar.length)
      {
        if (arrayOfChar[k] == j) {
          arrayOfChar[k] = i;
        }
        k += 1;
      }
    }
    if (arrayOfChar[(m - 1)] != i)
    {
      j = m + 1;
      arrayOfChar[m] = i;
      k = 0;
      m = j;
    }
    for (j = k;; j = 1)
    {
      k = i3 + 1;
      int n;
      while (k < m)
      {
        n = m;
        i1 = k;
        if (arrayOfChar[k] == i)
        {
          n = m;
          i1 = k;
          if (arrayOfChar[(k - 1)] == i)
          {
            System.arraycopy(arrayOfChar, k, arrayOfChar, k - 1, m - k);
            n = m - 1;
            i1 = k - 1;
          }
        }
        k = i1 + 1;
        m = n;
      }
      k = i3 + 1;
      int i2;
      while (k < m)
      {
        i2 = j;
        n = m;
        i1 = k;
        if (arrayOfChar[k] == i)
        {
          i2 = j;
          n = m;
          i1 = k;
          if (arrayOfChar[(k - 1)] == '.') {
            if (k != i3 + 1)
            {
              i2 = j;
              n = m;
              i1 = k;
              if (arrayOfChar[(k - 2)] != i) {}
            }
            else
            {
              if (k == m - 1) {
                j = 1;
              }
              System.arraycopy(arrayOfChar, k + 1, arrayOfChar, k - 1, m - k);
              n = m - 2;
              i1 = k - 1;
              i2 = j;
            }
          }
        }
        k = i1 + 1;
        j = i2;
        m = n;
      }
      k = i3 + 2;
      int i1 = m;
      if (k < i1)
      {
        i2 = j;
        m = i1;
        n = k;
        if (arrayOfChar[k] == i)
        {
          i2 = j;
          m = i1;
          n = k;
          if (arrayOfChar[(k - 1)] == '.')
          {
            i2 = j;
            m = i1;
            n = k;
            if (arrayOfChar[(k - 2)] == '.') {
              if (k != i3 + 2)
              {
                i2 = j;
                m = i1;
                n = k;
                if (arrayOfChar[(k - 3)] != i) {}
              }
              else
              {
                if (k == i3 + 2)
                {
                  AppMethodBeat.o(10296);
                  return null;
                }
                if (k == i1 - 1) {
                  j = 1;
                }
                m = k - 4;
                label509:
                if (m < i3) {
                  break label587;
                }
                if (arrayOfChar[m] != i) {
                  break label578;
                }
                System.arraycopy(arrayOfChar, k + 1, arrayOfChar, m + 1, i1 - k);
                k = i1 - (k - m);
                n = m + 1;
                m = k;
              }
            }
          }
        }
        for (i2 = j;; i2 = j)
        {
          k = n + 1;
          j = i2;
          i1 = m;
          break;
          label578:
          m -= 1;
          break label509;
          label587:
          System.arraycopy(arrayOfChar, k + 1, arrayOfChar, i3, i1 - k);
          m = i1 - (k + 1 - i3);
          n = i3 + 1;
        }
      }
      if (i1 <= 0)
      {
        AppMethodBeat.o(10296);
        return "";
      }
      if (i1 <= i3)
      {
        paramString = new String(arrayOfChar, 0, i1);
        AppMethodBeat.o(10296);
        return paramString;
      }
      if (j != 0)
      {
        paramString = new String(arrayOfChar, 0, i1);
        AppMethodBeat.o(10296);
        return paramString;
      }
      paramString = new String(arrayOfChar, 0, i1 - 1);
      AppMethodBeat.o(10296);
      return paramString;
    }
  }
  
  public static String pD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10297);
    int i = bIc(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(10297);
      return null;
    }
    if (i > 0)
    {
      paramString1 = normalize(paramString2);
      AppMethodBeat.o(10297);
      return paramString1;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(10297);
      return null;
    }
    i = paramString1.length();
    if (i == 0)
    {
      paramString1 = normalize(paramString2);
      AppMethodBeat.o(10297);
      return paramString1;
    }
    if (T(paramString1.charAt(i - 1)))
    {
      paramString1 = normalize(paramString1 + paramString2);
      AppMethodBeat.o(10297);
      return paramString1;
    }
    paramString1 = normalize(paramString1 + '/' + paramString2);
    AppMethodBeat.o(10297);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.a.c
 * JD-Core Version:    0.7.0.1
 */