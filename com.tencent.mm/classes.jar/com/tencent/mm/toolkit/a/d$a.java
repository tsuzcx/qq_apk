package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$a
{
  private static final char[] fqR;
  
  static
  {
    AppMethodBeat.i(193031);
    fqR = "0123456789ABCDEF".toCharArray();
    AppMethodBeat.o(193031);
  }
  
  public static String Z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193030);
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = fqR[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = fqR[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(193030);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d.a
 * JD-Core Version:    0.7.0.1
 */