package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class u$a
{
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int k = paramArrayOfByte.length;
    int i = 0;
    int m;
    for (int j = 0; i < k >> 2; j = m + 1)
    {
      m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = ((paramArrayOfByte[m] & 0xFF) << 8 | n);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
      i += 1;
    }
    if (j < paramArrayOfByte.length)
    {
      k = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      j = 8;
      while (k < paramArrayOfByte.length)
      {
        paramArrayOfInt[i] |= (paramArrayOfByte[k] & 0xFF) << j;
        k += 1;
        j += 8;
      }
    }
  }
  
  private static byte[] cq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214063);
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte.length <= 16) {}
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      AppMethodBeat.o(214063);
      return localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;)
      {
        localObject = null;
      }
    }
  }
  
  public static byte[] cr(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214064);
    byte[] arrayOfByte = cq(getKey());
    if ((paramArrayOfByte == null) || (arrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(214064);
      return paramArrayOfByte;
    }
    if ((paramArrayOfByte.length % 4 != 0) || (paramArrayOfByte.length < 8))
    {
      AppMethodBeat.o(214064);
      return null;
    }
    int[] arrayOfInt = new int[paramArrayOfByte.length >>> 2];
    a(paramArrayOfByte, arrayOfInt);
    if (arrayOfByte.length % 4 == 0) {}
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte[i] = 0;
        i += 1;
      }
    }
    a(arrayOfByte, paramArrayOfByte);
    int n = arrayOfInt.length - 1;
    i = arrayOfInt[0];
    int j = (52 / (n + 1) + 6) * -1640531527;
    while (j != 0)
    {
      int i1 = j >>> 2 & 0x3;
      m = n;
      k = i;
      i = m;
      while (i > 0)
      {
        m = arrayOfInt[(i - 1)];
        k = arrayOfInt[i] - ((k ^ j) + (m ^ paramArrayOfByte[(i & 0x3 ^ i1)]) ^ (m >>> 5 ^ k << 2) + (k >>> 3 ^ m << 4));
        arrayOfInt[i] = k;
        i -= 1;
      }
      m = arrayOfInt[n];
      i = arrayOfInt[0] - ((paramArrayOfByte[(i & 0x3 ^ i1)] ^ m) + (k ^ j) ^ (m >>> 5 ^ k << 2) + (k >>> 3 ^ m << 4));
      arrayOfInt[0] = i;
      j += 1640531527;
    }
    i = arrayOfInt[n];
    if ((i < 0) || (i > arrayOfInt.length - 1 << 2))
    {
      AppMethodBeat.o(214064);
      return null;
    }
    paramArrayOfByte = new byte[i];
    int m = arrayOfInt.length - 1;
    int k = 0;
    i = paramArrayOfByte.length >> 2;
    j = i;
    if (i > m) {
      j = m;
    }
    i = 0;
    while (i < j)
    {
      n = k + 1;
      paramArrayOfByte[k] = ((byte)(arrayOfInt[i] & 0xFF));
      k = n + 1;
      paramArrayOfByte[n] = ((byte)(arrayOfInt[i] >>> 8 & 0xFF));
      n = k + 1;
      paramArrayOfByte[k] = ((byte)(arrayOfInt[i] >>> 16 & 0xFF));
      k = n + 1;
      paramArrayOfByte[n] = ((byte)(arrayOfInt[i] >>> 24 & 0xFF));
      i += 1;
    }
    if ((m > j) && (k < paramArrayOfByte.length))
    {
      j = k + 1;
      paramArrayOfByte[k] = ((byte)(arrayOfInt[i] & 0xFF));
      k = 8;
      while ((k <= 24) && (j < paramArrayOfByte.length))
      {
        paramArrayOfByte[j] = ((byte)(arrayOfInt[i] >>> k & 0xFF));
        k += 8;
        j += 1;
      }
    }
    AppMethodBeat.o(214064);
    return paramArrayOfByte;
  }
  
  private static byte[] getKey()
  {
    AppMethodBeat.i(214062);
    try
    {
      byte[] arrayOfByte = "DFG#$%^#%$RGHR(&*M<><".getBytes("UTF-8");
      AppMethodBeat.o(214062);
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(214062);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.u.a
 * JD-Core Version:    0.7.0.1
 */