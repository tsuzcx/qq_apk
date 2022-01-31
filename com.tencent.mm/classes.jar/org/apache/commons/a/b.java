package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b
{
  private static final char COA;
  private static final char COB;
  public static final String COz;
  
  static
  {
    AppMethodBeat.i(136499);
    COz = Character.toString('.');
    char c = File.separatorChar;
    COA = c;
    if (c == '\\') {}
    for (int i = 1; i != 0; i = 0)
    {
      COB = '/';
      AppMethodBeat.o(136499);
      return;
    }
    COB = '\\';
    AppMethodBeat.o(136499);
  }
  
  private static int azD(String paramString)
  {
    AppMethodBeat.i(136494);
    if (paramString == null)
    {
      AppMethodBeat.o(136494);
      return -1;
    }
    int i = paramString.length();
    if (i == 0)
    {
      AppMethodBeat.o(136494);
      return 0;
    }
    char c1 = paramString.charAt(0);
    if (c1 == ':')
    {
      AppMethodBeat.o(136494);
      return -1;
    }
    if (i == 1)
    {
      if (c1 == '~')
      {
        AppMethodBeat.o(136494);
        return 2;
      }
      if (isSeparator(c1))
      {
        AppMethodBeat.o(136494);
        return 1;
      }
      AppMethodBeat.o(136494);
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
        AppMethodBeat.o(136494);
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
      AppMethodBeat.o(136494);
      return i + 1;
    }
    char c2 = paramString.charAt(1);
    if (c2 == ':')
    {
      j = Character.toUpperCase(c1);
      if ((j >= 65) && (j <= 90))
      {
        if ((i == 2) || (!isSeparator(paramString.charAt(2))))
        {
          AppMethodBeat.o(136494);
          return 2;
        }
        AppMethodBeat.o(136494);
        return 3;
      }
      if (j == 47)
      {
        AppMethodBeat.o(136494);
        return 1;
      }
      AppMethodBeat.o(136494);
      return -1;
    }
    if ((isSeparator(c1)) && (isSeparator(c2)))
    {
      i = paramString.indexOf('/', 2);
      j = paramString.indexOf('\\', 2);
      if (((i == -1) && (j == -1)) || (i == 2) || (j == 2))
      {
        AppMethodBeat.o(136494);
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
        AppMethodBeat.o(136494);
        return i + 1;
      }
    }
    if (isSeparator(c1))
    {
      AppMethodBeat.o(136494);
      return 1;
    }
    AppMethodBeat.o(136494);
    return 0;
  }
  
  private static int azE(String paramString)
  {
    AppMethodBeat.i(136495);
    if (paramString == null)
    {
      AppMethodBeat.o(136495);
      return -1;
    }
    int i = Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
    AppMethodBeat.o(136495);
    return i;
  }
  
  private static void azF(String paramString)
  {
    AppMethodBeat.i(136497);
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (paramString.charAt(i) == 0)
      {
        paramString = new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
        AppMethodBeat.o(136497);
        throw paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(136497);
  }
  
  public static String azG(String paramString)
  {
    AppMethodBeat.i(136498);
    if (paramString == null)
    {
      AppMethodBeat.o(136498);
      return null;
    }
    int i;
    if (paramString == null) {
      i = -1;
    }
    while (i == -1)
    {
      AppMethodBeat.o(136498);
      return "";
      int j = paramString.lastIndexOf('.');
      i = j;
      if (azE(paramString) > j) {
        i = -1;
      }
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(136498);
    return paramString;
  }
  
  public static String getName(String paramString)
  {
    AppMethodBeat.i(136496);
    if (paramString == null)
    {
      AppMethodBeat.o(136496);
      return null;
    }
    azF(paramString);
    paramString = paramString.substring(azE(paramString) + 1);
    AppMethodBeat.o(136496);
    return paramString;
  }
  
  private static boolean isSeparator(char paramChar)
  {
    return (paramChar == '/') || (paramChar == '\\');
  }
  
  public static String jE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136493);
    int i = azD(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(136493);
      return null;
    }
    if (i > 0)
    {
      paramString1 = normalize(paramString2);
      AppMethodBeat.o(136493);
      return paramString1;
    }
    if (paramString1 == null)
    {
      AppMethodBeat.o(136493);
      return null;
    }
    i = paramString1.length();
    if (i == 0)
    {
      paramString1 = normalize(paramString2);
      AppMethodBeat.o(136493);
      return paramString1;
    }
    if (isSeparator(paramString1.charAt(i - 1)))
    {
      paramString1 = normalize(paramString1 + paramString2);
      AppMethodBeat.o(136493);
      return paramString1;
    }
    paramString1 = normalize(paramString1 + '/' + paramString2);
    AppMethodBeat.o(136493);
    return paramString1;
  }
  
  private static String normalize(String paramString)
  {
    AppMethodBeat.i(136492);
    int i = COA;
    if (paramString == null)
    {
      AppMethodBeat.o(136492);
      return null;
    }
    azF(paramString);
    int m = paramString.length();
    if (m == 0)
    {
      AppMethodBeat.o(136492);
      return paramString;
    }
    int i3 = azD(paramString);
    if (i3 < 0)
    {
      AppMethodBeat.o(136492);
      return null;
    }
    char[] arrayOfChar = new char[m + 2];
    paramString.getChars(0, paramString.length(), arrayOfChar, 0);
    if (i == COA) {}
    int k;
    for (int j = COB;; j = COA)
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
                  AppMethodBeat.o(136492);
                  return null;
                }
                if (k == i1 - 1) {
                  j = 1;
                }
                m = k - 4;
                label504:
                if (m < i3) {
                  break label582;
                }
                if (arrayOfChar[m] != i) {
                  break label573;
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
          label573:
          m -= 1;
          break label504;
          label582:
          System.arraycopy(arrayOfChar, k + 1, arrayOfChar, i3, i1 - k);
          m = i1 - (k + 1 - i3);
          n = i3 + 1;
        }
      }
      if (i1 <= 0)
      {
        AppMethodBeat.o(136492);
        return "";
      }
      if (i1 <= i3)
      {
        paramString = new String(arrayOfChar, 0, i1);
        AppMethodBeat.o(136492);
        return paramString;
      }
      if (j != 0)
      {
        paramString = new String(arrayOfChar, 0, i1);
        AppMethodBeat.o(136492);
        return paramString;
      }
      paramString = new String(arrayOfChar, 0, i1 - 1);
      AppMethodBeat.o(136492);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.apache.commons.a.b
 * JD-Core Version:    0.7.0.1
 */