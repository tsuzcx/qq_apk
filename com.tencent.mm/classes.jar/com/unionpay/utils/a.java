package com.unionpay.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207336);
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      localStringBuilder.append("0123456789abcdef".charAt(k >> 4));
      localStringBuilder.append("0123456789abcdef".charAt(k & 0xF));
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(207336);
    return paramArrayOfByte;
  }
  
  public static byte[] a(String paramString)
  {
    AppMethodBeat.i(207327);
    paramString = paramString.toCharArray();
    int m = paramString.length / 2;
    byte[] arrayOfByte = new byte[m];
    int i = 0;
    while (i < m)
    {
      int k = Character.digit(paramString[(i * 2)], 16) << 4 | Character.digit(paramString[(i * 2 + 1)], 16);
      int j = k;
      if (k > 127) {
        j = k - 256;
      }
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    AppMethodBeat.o(207327);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.unionpay.utils.a
 * JD-Core Version:    0.7.0.1
 */