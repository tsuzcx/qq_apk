package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

final class d
{
  public static final class a
  {
    private static final char[] gqp;
    
    static
    {
      AppMethodBeat.i(196820);
      gqp = "0123456789ABCDEF".toCharArray();
      AppMethodBeat.o(196820);
    }
    
    public static String toHexString(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(196819);
      char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i] & 0xFF;
        arrayOfChar[(i * 2)] = gqp[(j >>> 4)];
        arrayOfChar[(i * 2 + 1)] = gqp[(j & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar);
      AppMethodBeat.o(196819);
      return paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public static void U(File paramFile)
    {
      AppMethodBeat.i(196821);
      if (paramFile != null) {
        paramFile.delete();
      }
      AppMethodBeat.o(196821);
    }
  }
  
  public static final class c
  {
    public static void closeQuietly(Closeable paramCloseable)
    {
      AppMethodBeat.i(196822);
      if (paramCloseable != null) {
        try
        {
          paramCloseable.close();
          AppMethodBeat.o(196822);
          return;
        }
        catch (IOException paramCloseable)
        {
          e.gGf();
        }
      }
      AppMethodBeat.o(196822);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d
 * JD-Core Version:    0.7.0.1
 */