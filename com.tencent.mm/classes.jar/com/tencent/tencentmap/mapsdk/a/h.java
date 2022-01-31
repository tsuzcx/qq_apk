package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public class h
{
  public static final double a = Double.longBitsToDouble(4368491638549381120L);
  public static final double b = Double.longBitsToDouble(4503599627370496L);
  private static final long c = Double.doubleToRawLongBits(0.0D);
  private static final long d = Double.doubleToRawLongBits(0.0D);
  private static final int e = Float.floatToRawIntBits(0.0F);
  private static final int f = Float.floatToRawIntBits(0.0F);
  
  public static int a(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }
  
  public static String a(String paramString, Object paramObject)
  {
    return paramString + "=" + String.valueOf(paramObject);
  }
  
  public static String a(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramVarArgs.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      localStringBuilder.append(paramVarArgs[j]);
      if (i != paramVarArgs.length - 1) {
        localStringBuilder.append(",");
      }
      j += 1;
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.h
 * JD-Core Version:    0.7.0.1
 */