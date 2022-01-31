package com.tencent.pb.common.c;

import java.util.Iterator;

public final class g
{
  public static String a(Iterable<?> paramIterable, String paramString1, String paramString2)
  {
    paramIterable = paramIterable.iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramIterable.hasNext())
    {
      localStringBuilder.append(paramIterable.next().toString().replace(paramString1, paramString2));
      if (paramIterable.hasNext()) {
        localStringBuilder.append(paramString1);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String aws(String paramString)
  {
    String str = paramString;
    if (isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static boolean equals(String paramString1, String paramString2)
  {
    return (paramString1 == paramString2) || ((paramString1 != null) && (paramString2 != null) && (paramString1.equals(paramString2)));
  }
  
  public static boolean iN(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || ("".equals(paramString.trim()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.c.g
 * JD-Core Version:    0.7.0.1
 */