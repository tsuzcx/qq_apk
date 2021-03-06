package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;

public class YtSDKKitCommon$ProcessHelper
{
  public static float calcEyeScore(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(218087);
    float f1 = paramArrayOfFloat[32] - paramArrayOfFloat[40];
    float f2 = paramArrayOfFloat[33] - paramArrayOfFloat[41];
    float f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    float f8 = paramArrayOfFloat[44];
    float f9 = paramArrayOfFloat[40];
    float f10 = paramArrayOfFloat[45];
    float f11 = paramArrayOfFloat[41];
    float f4 = paramArrayOfFloat[36];
    float f5 = paramArrayOfFloat[40];
    float f6 = paramArrayOfFloat[37];
    float f7 = paramArrayOfFloat[41];
    f8 = Math.abs(crossProduct(f1, f2, f8 - f9, f10 - f11));
    f1 = (Math.abs(crossProduct(f1, f2, f4 - f5, f6 - f7)) + f8) / (f3 * f3);
    f2 = paramArrayOfFloat[56] - paramArrayOfFloat[48];
    f3 = paramArrayOfFloat[57] - paramArrayOfFloat[49];
    f4 = (float)Math.sqrt(f2 * f2 + f3 * f3);
    f9 = paramArrayOfFloat[60];
    f10 = paramArrayOfFloat[56];
    f11 = paramArrayOfFloat[61];
    float f12 = paramArrayOfFloat[57];
    f5 = paramArrayOfFloat[52];
    f6 = paramArrayOfFloat[56];
    f7 = paramArrayOfFloat[53];
    f8 = paramArrayOfFloat[57];
    f9 = Math.abs(crossProduct(f2, f3, f9 - f10, f11 - f12));
    f2 = (Math.abs(crossProduct(f2, f3, f5 - f6, f7 - f8)) + f9) / (f4 * f4);
    AppMethodBeat.o(218087);
    return f1 + f2;
  }
  
  public static float calcMouthScore(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(218096);
    float f = Math.abs((paramArrayOfFloat[''] + paramArrayOfFloat[109]) / 2.0F - (paramArrayOfFloat[119] + paramArrayOfFloat[97]) / 2.0F) / Math.abs(paramArrayOfFloat[90] - paramArrayOfFloat[102]);
    AppMethodBeat.o(218096);
    return f;
  }
  
  public static float[] convert90PTo5P(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(218107);
    YtLogger.d("ProcessHelper", "90 to 5 convert size:" + paramArrayOfFloat.length);
    float f1 = paramArrayOfFloat['°'];
    float f2 = paramArrayOfFloat['±'];
    float f3 = paramArrayOfFloat['²'];
    float f4 = paramArrayOfFloat['³'];
    float f5 = paramArrayOfFloat[64];
    float f6 = paramArrayOfFloat[65];
    float f7 = paramArrayOfFloat[90];
    float f8 = paramArrayOfFloat[91];
    float f9 = paramArrayOfFloat[102];
    float f10 = paramArrayOfFloat[103];
    AppMethodBeat.o(218107);
    return new float[] { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10 };
  }
  
  private static float crossProduct(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat4 - paramFloat3 * paramFloat2;
  }
  
  public static float preCheckCloseEyeScore(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(218076);
    float f1 = paramArrayOfFloat[32] - paramArrayOfFloat[40];
    float f2 = paramArrayOfFloat[33] - paramArrayOfFloat[41];
    float f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
    float f8 = paramArrayOfFloat[44];
    float f9 = paramArrayOfFloat[40];
    float f10 = paramArrayOfFloat[45];
    float f11 = paramArrayOfFloat[41];
    float f4 = paramArrayOfFloat[36];
    float f5 = paramArrayOfFloat[40];
    float f6 = paramArrayOfFloat[37];
    float f7 = paramArrayOfFloat[41];
    f8 = Math.abs(crossProduct(f1, f2, f8 - f9, f10 - f11));
    f1 = (Math.abs(crossProduct(f1, f2, f4 - f5, f6 - f7)) + f8) / (f3 * f3);
    f2 = paramArrayOfFloat[56] - paramArrayOfFloat[48];
    f3 = paramArrayOfFloat[57] - paramArrayOfFloat[49];
    f4 = (float)Math.sqrt(f2 * f2 + f3 * f3);
    f9 = paramArrayOfFloat[60];
    f10 = paramArrayOfFloat[56];
    f11 = paramArrayOfFloat[61];
    float f12 = paramArrayOfFloat[57];
    f5 = paramArrayOfFloat[52];
    f6 = paramArrayOfFloat[56];
    f7 = paramArrayOfFloat[53];
    f8 = paramArrayOfFloat[57];
    f9 = Math.abs(crossProduct(f2, f3, f9 - f10, f11 - f12));
    f2 = (Math.abs(crossProduct(f2, f3, f5 - f6, f7 - f8)) + f9) / (f4 * f4);
    if (f1 > f2)
    {
      AppMethodBeat.o(218076);
      return f2;
    }
    AppMethodBeat.o(218076);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper
 * JD-Core Version:    0.7.0.1
 */