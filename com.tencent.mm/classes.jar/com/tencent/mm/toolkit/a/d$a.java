package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$a
{
  private static final char[] fnx;
  
  static
  {
    AppMethodBeat.i(189810);
    fnx = "0123456789ABCDEF".toCharArray();
    AppMethodBeat.o(189810);
  }
  
  public static String aa(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189809);
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = fnx[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = fnx[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(189809);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d.a
 * JD-Core Version:    0.7.0.1
 */