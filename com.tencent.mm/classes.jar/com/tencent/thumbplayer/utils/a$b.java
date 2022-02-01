package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b
{
  static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227141);
    int i = paramInt2 - paramInt1;
    if (i < 0)
    {
      paramArrayOfByte = new IllegalArgumentException(paramInt1 + " > " + paramInt2);
      AppMethodBeat.o(227141);
      throw paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
    AppMethodBeat.o(227141);
    return arrayOfByte;
  }
  
  static int dz(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] == 32) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  static boolean hasDateInfo(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227125);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 15) && (paramArrayOfByte[13] == 45) && (dz(paramArrayOfByte) > 14))
    {
      AppMethodBeat.o(227125);
      return true;
    }
    AppMethodBeat.o(227125);
    return false;
  }
  
  static boolean isDue(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227112);
    if (hasDateInfo(paramArrayOfByte)) {
      paramArrayOfByte = new String[] { new String(copyOfRange(paramArrayOfByte, 0, 13)), new String(copyOfRange(paramArrayOfByte, 14, dz(paramArrayOfByte))) };
    }
    while (paramArrayOfByte != null)
    {
      byte b = paramArrayOfByte[0];
      String str;
      for (;;)
      {
        if (b.startsWith("0"))
        {
          str = b.substring(1, b.length());
          continue;
          paramArrayOfByte = null;
          break;
        }
      }
      try
      {
        long l1 = Long.valueOf(str).longValue();
        long l2 = Long.valueOf(paramArrayOfByte[1]).longValue();
        long l3 = System.currentTimeMillis();
        if (l3 > l1 + l2 * 1000L)
        {
          AppMethodBeat.o(227112);
          return true;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(227112);
        return false;
      }
    }
    AppMethodBeat.o(227112);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.a.b
 * JD-Core Version:    0.7.0.1
 */