package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

final class d
{
  public static final class a
  {
    private static final char[] fIY;
    
    static
    {
      AppMethodBeat.i(211577);
      fIY = "0123456789ABCDEF".toCharArray();
      AppMethodBeat.o(211577);
    }
    
    public static String Z(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(211576);
      char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i] & 0xFF;
        arrayOfChar[(i * 2)] = fIY[(j >>> 4)];
        arrayOfChar[(i * 2 + 1)] = fIY[(j & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar);
      AppMethodBeat.o(211576);
      return paramArrayOfByte;
    }
  }
  
  public static final class b
  {
    public static void U(File paramFile)
    {
      AppMethodBeat.i(211578);
      if (paramFile != null) {
        paramFile.delete();
      }
      AppMethodBeat.o(211578);
    }
  }
  
  public static final class c
  {
    public static void closeQuietly(Closeable paramCloseable)
    {
      AppMethodBeat.i(211579);
      if (paramCloseable != null) {
        try
        {
          paramCloseable.close();
          AppMethodBeat.o(211579);
          return;
        }
        catch (IOException paramCloseable)
        {
          e.fuq();
        }
      }
      AppMethodBeat.o(211579);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.d
 * JD-Core Version:    0.7.0.1
 */