package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b
{
  static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222098);
    int i = paramInt2 - paramInt1;
    if (i < 0)
    {
      paramArrayOfByte = new IllegalArgumentException(paramInt1 + " > " + paramInt2);
      AppMethodBeat.o(222098);
      throw paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
    AppMethodBeat.o(222098);
    return arrayOfByte;
  }
  
  static int dx(byte[] paramArrayOfByte)
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
    AppMethodBeat.i(222090);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 15) && (paramArrayOfByte[13] == 45) && (dx(paramArrayOfByte) > 14))
    {
      AppMethodBeat.o(222090);
      return true;
    }
    AppMethodBeat.o(222090);
    return false;
  }
  
  static boolean isDue(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222089);
    if (hasDateInfo(paramArrayOfByte)) {
      paramArrayOfByte = new String[] { new String(copyOfRange(paramArrayOfByte, 0, 13)), new String(copyOfRange(paramArrayOfByte, 14, dx(paramArrayOfByte))) };
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
          AppMethodBeat.o(222089);
          return true;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(222089);
        return false;
      }
    }
    AppMethodBeat.o(222089);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.a.b
 * JD-Core Version:    0.7.0.1
 */