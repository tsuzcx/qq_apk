package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
{
  public static final byte[] a = new byte[0];
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98963);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(98963);
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = b[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2 + 0)] = b[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(98963);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.g
 * JD-Core Version:    0.7.0.1
 */