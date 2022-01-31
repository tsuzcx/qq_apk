package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class g
{
  public static final double a;
  public static final double b;
  private static final long c;
  private static final long d;
  private static final int e;
  private static final int f;
  
  static
  {
    AppMethodBeat.i(150438);
    c = Double.doubleToRawLongBits(0.0D);
    d = Double.doubleToRawLongBits(0.0D);
    e = Float.floatToRawIntBits(0.0F);
    f = Float.floatToRawIntBits(0.0F);
    a = Double.longBitsToDouble(4368491638549381120L);
    b = Double.longBitsToDouble(4503599627370496L);
    AppMethodBeat.o(150438);
  }
  
  public static int a(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(150437);
    int i = Arrays.hashCode(paramArrayOfObject);
    AppMethodBeat.o(150437);
    return i;
  }
  
  public static String a(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150435);
    paramString = paramString + "=" + String.valueOf(paramObject);
    AppMethodBeat.o(150435);
    return paramString;
  }
  
  public static String a(String... paramVarArgs)
  {
    AppMethodBeat.i(150436);
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
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(150436);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.g
 * JD-Core Version:    0.7.0.1
 */