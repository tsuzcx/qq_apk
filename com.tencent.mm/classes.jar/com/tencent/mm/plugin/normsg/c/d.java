package com.tencent.mm.plugin.normsg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String A(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149089);
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
    AppMethodBeat.o(149089);
    return paramArrayOfByte;
  }
  
  public static String ajp(String paramString)
  {
    AppMethodBeat.i(149090);
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
          AppMethodBeat.o(149090);
          return paramString;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(149090);
            throw paramString;
          }
          finally
          {
            paramString = localStringBuilder.toString();
            AppMethodBeat.o(149090);
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
        AppMethodBeat.o(149090);
      }
      char c = (char)j;
      try
      {
        localStringBuilder.append(c);
        AppMethodBeat.o(149090);
        throw paramString;
      }
      finally
      {
        AppMethodBeat.o(149090);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.d
 * JD-Core Version:    0.7.0.1
 */