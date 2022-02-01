package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

final class d
{
  public static final class a
  {
    private static final char[] fLc;
    
    static
    {
      AppMethodBeat.i(189008);
      fLc = "0123456789ABCDEF".toCharArray();
      AppMethodBeat.o(189008);
    }
    
    public static String Z(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(189007);
      char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i] & 0xFF;
        arrayOfChar[(i * 2)] = fLc[(j >>> 4)];
        arrayOfChar[(i * 2 + 1)] = fLc[(j & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar);
      AppMethodBeat.o(189007);
      return paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public static void U(File paramFile)
    {
      AppMethodBeat.i(189009);
      if (paramFile != null) {
        paramFile.delete();
      }
      AppMethodBeat.o(189009);
    }
  }
  
  public static final class c
  {
    public static void closeQuietly(Closeable paramCloseable)
    {
      AppMethodBeat.i(189010);
      if (paramCloseable != null) {
        try
        {
          paramCloseable.close();
          AppMethodBeat.o(189010);
          return;
        }
        catch (IOException paramCloseable)
        {
          e.fyr();
        }
      }
      AppMethodBeat.o(189010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d
 * JD-Core Version:    0.7.0.1
 */