package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String Wd(String paramString)
  {
    AppMethodBeat.i(10437);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 1;
    int k = 0;
    int j = k;
    try
    {
      int m = paramString.charAt(i);
      j = k;
      k = paramString.charAt(i - 1) ^ m;
      j = k;
      m = paramString.length();
      if (i + 1 == m)
      {
        c = (char)k;
        try
        {
          localStringBuilder.append(c);
          paramString = localStringBuilder.toString();
          AppMethodBeat.o(10437);
          return paramString;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(10437);
            throw paramString;
          }
          finally
          {
            paramString = localStringBuilder.toString();
            AppMethodBeat.o(10437);
            return paramString;
          }
        }
      }
      c = (char)k;
    }
    finally
    {
      try
      {
        localStringBuilder.append(c);
        i += 1;
      }
      finally
      {
        AppMethodBeat.o(10437);
      }
      char c = (char)j;
      try
      {
        localStringBuilder.append(c);
        AppMethodBeat.o(10437);
        throw paramString;
      }
      finally
      {
        AppMethodBeat.o(10437);
      }
    }
  }
  
  public static String w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10436);
    char[] arrayOfChar = new char[(paramInt2 - paramInt1) * 2];
    int i = 0;
    while (paramInt1 < paramInt2)
    {
      int j = paramArrayOfByte[paramInt1];
      int k = i + 1;
      arrayOfChar[i] = HEX_DIGITS[(j >>> 4 & 0xF)];
      i = k + 1;
      arrayOfChar[k] = HEX_DIGITS[(j & 0xF)];
      paramInt1 += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(10436);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.d
 * JD-Core Version:    0.7.0.1
 */