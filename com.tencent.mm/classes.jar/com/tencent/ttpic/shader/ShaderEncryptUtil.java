package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShaderEncryptUtil
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(83734);
    TAG = ShaderEncryptUtil.class.getSimpleName();
    AppMethodBeat.o(83734);
  }
  
  public static String decrypt(String paramString)
  {
    int i = 3;
    AppMethodBeat.i(83733);
    char[] arrayOfChar = paramString.toCharArray();
    int n = arrayOfChar.length;
    if (n < 3)
    {
      AppMethodBeat.o(83733);
      return paramString;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int j;
    int k;
    if ((arrayOfChar[0] == 'h') && (arrayOfChar[1] == 'f') && (arrayOfChar[2] == 'e'))
    {
      i = 3;
      while ((i < n) && (arrayOfChar[i] != 'f'))
      {
        localStringBuilder2.append(arrayOfChar[i]);
        i += 1;
      }
      Integer.parseInt(localStringBuilder2.toString());
      paramString = new StringBuilder();
      i += 1;
      if (i < n)
      {
        j = -1;
        while ((j < 6) && (arrayOfChar[i] != "cdbhil".charAt(j))) {
          j += 1;
        }
        if (j == 6) {
          paramString.append(arrayOfChar[i]);
        }
        for (;;)
        {
          i += 1;
          break;
          paramString = getChars(Integer.parseInt(paramString.toString()) - j);
          k = paramString.length;
          j = 0;
          while (j < k)
          {
            char c = paramString[j];
            if (c != 0) {
              localStringBuilder1.append(c);
            }
            j += 1;
          }
          paramString = new StringBuilder();
        }
      }
      paramString = new String(localStringBuilder1);
      AppMethodBeat.o(83733);
      return paramString;
    }
    if ((arrayOfChar[0] == 'm') && (arrayOfChar[1] == 'e') && (arrayOfChar[2] == 'e'))
    {
      while ((i < n) && (arrayOfChar[i] != 'x'))
      {
        localStringBuilder2.append(arrayOfChar[i]);
        i += 1;
      }
      int i1 = Integer.parseInt(localStringBuilder2.toString());
      paramString = new StringBuilder();
      k = 0;
      j = i + 1;
      i = k;
      if (j < n)
      {
        if (arrayOfChar[j] == 'x')
        {
          paramString = getChars(Integer.parseInt(paramString.toString()));
          if (i1 - i >= 4) {}
          for (k = 4;; k = i1 - i)
          {
            int m = 0;
            while (m < k)
            {
              localStringBuilder1.append(paramString[m]);
              m += 1;
            }
          }
          i += 4;
          paramString = new StringBuilder();
        }
        for (;;)
        {
          j += 1;
          break;
          paramString.append(arrayOfChar[j]);
        }
      }
      paramString = new String(localStringBuilder1);
      AppMethodBeat.o(83733);
      return paramString;
    }
    AppMethodBeat.o(83733);
    return paramString;
  }
  
  private static char[] getChars(int paramInt)
  {
    char[] arrayOfChar = new char[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfChar[i] = ((char)(paramInt >>> i * 8 & 0xFF));
      i += 1;
    }
    return arrayOfChar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderEncryptUtil
 * JD-Core Version:    0.7.0.1
 */