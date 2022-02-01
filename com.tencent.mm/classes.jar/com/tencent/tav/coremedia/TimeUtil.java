package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil
{
  private static final long DEVIATION = 10000L;
  public static final long SECOND_TO_US = 1000000L;
  public static final String YYYY2MM2DD_HH1MM1SS = "yyyy-MM-dd HH:mm:ss";
  
  public static boolean equals(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(199467);
    if (Math.abs(paramLong1 - paramLong2) < 10000L)
    {
      AppMethodBeat.o(199467);
      return true;
    }
    AppMethodBeat.o(199467);
    return false;
  }
  
  public static long getAudioDuration(long paramLong, int paramInt1, int paramInt2)
  {
    return 1000000L * paramLong / (paramInt1 * 2 * paramInt2);
  }
  
  public static String long2str(long paramLong, String paramString)
  {
    AppMethodBeat.i(199470);
    String str = paramString;
    if (paramString == null) {
      str = "yyyy-M-d  HH:mm";
    }
    paramString = new SimpleDateFormat(str, Locale.getDefault()).format(new Date(paramLong));
    AppMethodBeat.o(199470);
    return paramString;
  }
  
  public static float milli2Second(long paramLong)
  {
    return (float)paramLong * 1.0F / 1000.0F;
  }
  
  public static long milli2Us(long paramLong)
  {
    return 1000L * paramLong;
  }
  
  public static String milliToSecond(long paramLong)
  {
    AppMethodBeat.i(199468);
    float f = Math.round(milli2Second(paramLong) * 10.0F) / 10.0F;
    String str = String.format(Locale.CHINA, "%1$.1f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(199468);
    return str;
  }
  
  public static long second2Ms(float paramFloat)
  {
    return (1000.0F * paramFloat);
  }
  
  public static String second2String(int paramInt)
  {
    AppMethodBeat.i(199469);
    Object localObject = new StringBuilder();
    int i = paramInt / 60;
    if (i > 0) {
      ((StringBuilder)localObject).append(i + "'");
    }
    paramInt %= 60;
    if (paramInt >= 10) {
      ((StringBuilder)localObject).append(paramInt + "\"");
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(199469);
      return localObject;
      if (paramInt >= 0) {
        ((StringBuilder)localObject).append("0" + paramInt + "\"");
      }
    }
  }
  
  public static long second2Us(float paramFloat)
  {
    return (1000000.0F * paramFloat);
  }
  
  public static CMTime us2CMTime(long paramLong)
  {
    AppMethodBeat.i(199471);
    CMTime localCMTime = new CMTime((us2Second(paramLong) * 600.0F));
    AppMethodBeat.o(199471);
    return localCMTime;
  }
  
  public static long us2Milli(long paramLong)
  {
    return paramLong / 1000L;
  }
  
  public static float us2Second(long paramLong)
  {
    return (float)paramLong * 1.0F / 1000000.0F;
  }
  
  public static String usToSecond(long paramLong)
  {
    AppMethodBeat.i(199466);
    float f = Math.round(us2Second(paramLong) * 10.0F) / 10.0F;
    String str = String.format(Locale.CHINA, "%1$.1f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(199466);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tav.coremedia.TimeUtil
 * JD-Core Version:    0.7.0.1
 */