package com.tencent.ttpic.shader;

public class ShaderEncryptUtil
{
  private static final String TAG = ShaderEncryptUtil.class.getSimpleName();
  
  public static String decrypt(String paramString)
  {
    int i = 3;
    char[] arrayOfChar = paramString.toCharArray();
    int n = arrayOfChar.length;
    if (n < 3) {}
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    do
    {
      return paramString;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = new StringBuilder();
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
        return new String(localStringBuilder1);
      }
    } while ((arrayOfChar[0] != 'm') || (arrayOfChar[1] != 'e') || (arrayOfChar[2] != 'e'));
    while ((i < n) && (arrayOfChar[i] != 'x'))
    {
      localStringBuilder2.append(arrayOfChar[i]);
      i += 1;
    }
    int i1 = Integer.parseInt(localStringBuilder2.toString());
    paramString = new StringBuilder();
    int k = 0;
    int j = i + 1;
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
    return new String(localStringBuilder1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderEncryptUtil
 * JD-Core Version:    0.7.0.1
 */