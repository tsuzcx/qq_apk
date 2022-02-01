package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ak;
import kotlin.g.b.s;

public class a
{
  private static final boolean ajdW;
  
  static
  {
    AppMethodBeat.i(59224);
    boolean bool;
    if (!a.class.desiredAssertionStatus()) {
      bool = true;
    }
    for (;;)
    {
      $assertionsDisabled = bool;
      try
      {
        String str = System.getProperty("kotlin.jvm.serialization.use8to7");
        ajdW = "true".equals(str);
        AppMethodBeat.o(59224);
        return;
        bool = false;
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static byte[] an(String[] paramArrayOfString)
  {
    int n = 0;
    AppMethodBeat.i(59220);
    if (paramArrayOfString == null) {
      aKu(7);
    }
    Object localObject = paramArrayOfString;
    int i;
    int k;
    int j;
    String str;
    int i2;
    if (paramArrayOfString.length > 0)
    {
      localObject = paramArrayOfString;
      if (!paramArrayOfString[0].isEmpty())
      {
        i = paramArrayOfString[0].charAt(0);
        if (i == 0)
        {
          paramArrayOfString = ao(paramArrayOfString);
          s.u(paramArrayOfString, "strings");
          k = paramArrayOfString.length;
          i = 0;
          j = 0;
          while (i < k)
          {
            j += paramArrayOfString[i].length();
            i += 1;
          }
          localObject = new byte[j];
          int i1 = paramArrayOfString.length;
          i = 0;
          j = 0;
          if (j < i1)
          {
            str = paramArrayOfString[j];
            j += 1;
            i2 = str.length() - 1;
            if (i2 < 0) {
              break label247;
            }
            k = 0;
          }
        }
      }
    }
    for (;;)
    {
      int m = i + 1;
      localObject[i] = ((byte)str.charAt(k));
      if (k == i2)
      {
        i = m;
        break;
        j = n;
        if (i == localObject.length) {
          j = 1;
        }
        if ((ak.aiuY) && (j == 0))
        {
          paramArrayOfString = (Throwable)new AssertionError("Should have reached the end");
          AppMethodBeat.o(59220);
          throw paramArrayOfString;
        }
        AppMethodBeat.o(59220);
        return localObject;
        localObject = paramArrayOfString;
        if (i == 65535) {
          localObject = ao(paramArrayOfString);
        }
        paramArrayOfString = ap((String[])localObject);
        dH(paramArrayOfString);
        paramArrayOfString = dI(paramArrayOfString);
        AppMethodBeat.o(59220);
        return paramArrayOfString;
        label247:
        break;
      }
      i = m;
      k += 1;
    }
  }
  
  private static String[] ao(String[] paramArrayOfString)
  {
    AppMethodBeat.i(59221);
    if (paramArrayOfString == null) {
      aKu(9);
    }
    paramArrayOfString = (String[])paramArrayOfString.clone();
    paramArrayOfString[0] = paramArrayOfString[0].substring(1);
    if (paramArrayOfString == null) {
      aKu(10);
    }
    AppMethodBeat.o(59221);
    return paramArrayOfString;
  }
  
  private static byte[] ap(String[] paramArrayOfString)
  {
    AppMethodBeat.i(59222);
    if (paramArrayOfString == null) {
      aKu(11);
    }
    int k = paramArrayOfString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localObject = paramArrayOfString[i];
      if ((!$assertionsDisabled) && (((String)localObject).length() > 65535))
      {
        paramArrayOfString = new AssertionError("String is too long: " + ((String)localObject).length());
        AppMethodBeat.o(59222);
        throw paramArrayOfString;
      }
      j += ((String)localObject).length();
      i += 1;
    }
    Object localObject = new byte[j];
    int m = paramArrayOfString.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      String str = paramArrayOfString[i];
      int n = str.length();
      k = 0;
      while (k < n)
      {
        localObject[j] = ((byte)str.charAt(k));
        k += 1;
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(59222);
    return localObject;
  }
  
  private static void dH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59219);
    if (paramArrayOfByte == null) {
      aKu(4);
    }
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] + 127 & 0x7F));
      i += 1;
    }
    AppMethodBeat.o(59219);
  }
  
  private static byte[] dI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59223);
    if (paramArrayOfByte == null) {
      aKu(13);
    }
    int m = paramArrayOfByte.length * 7 / 8;
    byte[] arrayOfByte = new byte[m];
    int k = 0;
    int j = 0;
    int i = 0;
    if (k < m)
    {
      int n = paramArrayOfByte[i];
      i += 1;
      arrayOfByte[k] = ((byte)(((n & 0xFF) >>> j) + ((paramArrayOfByte[i] & (1 << j + 1) - 1) << 7 - j)));
      if (j == 6)
      {
        i += 1;
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += 1;
      }
    }
    AppMethodBeat.o(59223);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.a
 * JD-Core Version:    0.7.0.1
 */