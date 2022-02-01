package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d
{
  public static final class a
  {
    private static final char[] lwC;
    
    static
    {
      AppMethodBeat.i(231999);
      lwC = "0123456789ABCDEF".toCharArray();
      AppMethodBeat.o(231999);
    }
    
    public static String toHexString(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(231994);
      char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i] & 0xFF;
        arrayOfChar[(i * 2)] = lwC[(j >>> 4)];
        arrayOfChar[(i * 2 + 1)] = lwC[(j & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar);
      AppMethodBeat.o(231994);
      return paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public static void R(File paramFile)
    {
      AppMethodBeat.i(231992);
      if (paramFile != null) {
        paramFile.delete();
      }
      AppMethodBeat.o(231992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d
 * JD-Core Version:    0.7.0.1
 */