package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public enum di
  implements dj
{
  private di() {}
  
  private static String a(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length()) {
      return paramChar + paramString.substring(paramInt);
    }
    return String.valueOf(paramChar);
  }
  
  private static String b(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    for (char c1 = paramString.charAt(0); (i < paramString.length() - 1) && (!Character.isLetter(c1)); c1 = paramString.charAt(i))
    {
      localStringBuilder.append(c1);
      i += 1;
    }
    String str;
    if (i == paramString.length()) {
      str = localStringBuilder.toString();
    }
    do
    {
      return str;
      str = paramString;
    } while (Character.isUpperCase(c1));
    return a(Character.toUpperCase(c1), paramString, i + 1);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString1.length())
    {
      char c1 = paramString1.charAt(i);
      if ((Character.isUpperCase(c1)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.di
 * JD-Core Version:    0.7.0.1
 */