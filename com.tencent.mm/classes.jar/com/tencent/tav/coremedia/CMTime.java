package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public class CMTime
  implements Cloneable
{
  public static final CMTime CMTimeInvalid;
  public static final CMTime CMTimeOne;
  public static final CMTime CMTimeZero;
  public static final int DEFAULT_TIME_SCALE = 600;
  private static final long SECONDS_MS = 1000L;
  private static final long SECONDS_US = 1000000L;
  private final float time;
  public final int timeScale;
  private final long timeUs;
  public final long value;
  
  static
  {
    AppMethodBeat.i(203026);
    CMTimeZero = new CMTime(0L, 600);
    CMTimeOne = new CMTime(600L, 600);
    CMTimeInvalid = new CMTime(-9223372036854775808L, 600, -1.0F, -1L);
    AppMethodBeat.o(203026);
  }
  
  public CMTime()
  {
    this(0L, 600);
  }
  
  public CMTime(float paramFloat)
  {
    this((600.0F * paramFloat), 600);
    AppMethodBeat.i(202957);
    AppMethodBeat.o(202957);
  }
  
  public CMTime(long paramLong)
  {
    this(paramLong, 600);
  }
  
  public CMTime(long paramLong, int paramInt)
  {
    AppMethodBeat.i(202960);
    this.value = paramLong;
    this.timeScale = paramInt;
    this.time = ((float)paramLong * 1.0F / paramInt);
    this.timeUs = (1000000L * paramLong / paramInt);
    AppMethodBeat.o(202960);
  }
  
  private CMTime(long paramLong1, int paramInt, float paramFloat, long paramLong2)
  {
    this.value = paramLong1;
    this.timeUs = paramLong2;
    this.time = paramFloat;
    this.timeScale = paramInt;
  }
  
  public static int GCD(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 == 0) {
        return i;
      }
      paramInt2 = paramInt1;
      paramInt1 = i % paramInt1;
    }
  }
  
  public static int LCM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202933);
    paramInt1 /= GCD(paramInt1, paramInt2);
    AppMethodBeat.o(202933);
    return paramInt1 * paramInt2;
  }
  
  public static CMTime add(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(202941);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime2.clone();
      AppMethodBeat.o(202941);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(202941);
      return paramCMTime1;
    }
    int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
    paramCMTime1 = convertTimeScale(paramCMTime1, i);
    paramCMTime2 = convertTimeScale(paramCMTime2, i);
    long l = paramCMTime1.getValue();
    paramCMTime1 = new CMTime(paramCMTime2.getValue() + l, paramCMTime1.timeScale);
    AppMethodBeat.o(202941);
    return paramCMTime1;
  }
  
  public static CMTime convertTimeScale(CMTime paramCMTime, int paramInt)
  {
    AppMethodBeat.i(202939);
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = CMTimeInvalid;
      AppMethodBeat.o(202939);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeZero)
    {
      paramCMTime = new CMTime(0L, paramInt);
      AppMethodBeat.o(202939);
      return paramCMTime;
    }
    paramCMTime = new CMTime(paramCMTime.getValue() * paramInt / paramCMTime.getTimeScale(), paramInt);
    AppMethodBeat.o(202939);
    return paramCMTime;
  }
  
  public static CMTime fromMs(long paramLong)
  {
    AppMethodBeat.i(202926);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000.0F);
    AppMethodBeat.o(202926);
    return localCMTime;
  }
  
  public static CMTime fromSeconds(float paramFloat)
  {
    AppMethodBeat.i(202922);
    CMTime localCMTime = new CMTime(paramFloat);
    AppMethodBeat.o(202922);
    return localCMTime;
  }
  
  public static CMTime fromUs(long paramLong)
  {
    AppMethodBeat.i(202928);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000000.0F);
    AppMethodBeat.o(202928);
    return localCMTime;
  }
  
  public static CMTime max(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(202952);
    if (paramCMTime1.bigThan(paramCMTime2))
    {
      AppMethodBeat.o(202952);
      return paramCMTime1;
    }
    AppMethodBeat.o(202952);
    return paramCMTime2;
  }
  
  public static CMTime min(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(202949);
    if (paramCMTime1.smallThan(paramCMTime2))
    {
      AppMethodBeat.o(202949);
      return paramCMTime1;
    }
    AppMethodBeat.o(202949);
    return paramCMTime2;
  }
  
  public static CMTime sub(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(202946);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = new CMTime(-paramCMTime2.getValue());
      AppMethodBeat.o(202946);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(202946);
      return paramCMTime1;
    }
    int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
    paramCMTime1 = convertTimeScale(paramCMTime1, i);
    paramCMTime2 = convertTimeScale(paramCMTime2, i);
    paramCMTime1 = new CMTime(paramCMTime1.getValue() - paramCMTime2.getValue(), paramCMTime1.timeScale);
    AppMethodBeat.o(202946);
    return paramCMTime1;
  }
  
  public CMTime add(long paramLong)
  {
    AppMethodBeat.i(202972);
    if (this == CMTimeInvalid)
    {
      localCMTime = clone();
      AppMethodBeat.o(202972);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(getValue() + this.timeScale * paramLong / TimeUnit.SECONDS.toMicros(1L), this.timeScale);
    AppMethodBeat.o(202972);
    return localCMTime;
  }
  
  public CMTime add(CMTime paramCMTime)
  {
    AppMethodBeat.i(202975);
    paramCMTime = add(this, paramCMTime);
    AppMethodBeat.o(202975);
    return paramCMTime;
  }
  
  public boolean bigThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(202999);
    if (getTimeUs() > paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(202999);
      return true;
    }
    AppMethodBeat.o(202999);
    return false;
  }
  
  public CMTime clone()
  {
    AppMethodBeat.i(203016);
    CMTime localCMTime = new CMTime(this.value, this.timeScale, this.time, this.timeUs);
    AppMethodBeat.o(203016);
    return localCMTime;
  }
  
  public int compare(CMTime paramCMTime)
  {
    AppMethodBeat.i(203006);
    long l = getTimeUs() - paramCMTime.getTimeUs();
    if (l > 0L)
    {
      AppMethodBeat.o(203006);
      return 1;
    }
    if (l == 0L)
    {
      AppMethodBeat.o(203006);
      return 0;
    }
    AppMethodBeat.o(203006);
    return -1;
  }
  
  public CMTime divide(float paramFloat)
  {
    AppMethodBeat.i(202994);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(202994);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() / paramFloat), this.timeScale);
    AppMethodBeat.o(202994);
    return localCMTime;
  }
  
  public CMTime divide(CMTime paramCMTime)
  {
    AppMethodBeat.i(202997);
    int i = LCM(this.timeScale, paramCMTime.timeScale);
    CMTime localCMTime = convertTimeScale(this, i);
    paramCMTime = convertTimeScale(paramCMTime, i);
    paramCMTime = new CMTime(localCMTime.value / paramCMTime.value, i);
    AppMethodBeat.o(202997);
    return paramCMTime;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CMTime)) {
      return false;
    }
    return (this.value == ((CMTime)paramObject).value) && (this.timeScale == ((CMTime)paramObject).timeScale);
  }
  
  public boolean equalsTo(CMTime paramCMTime)
  {
    AppMethodBeat.i(203003);
    if (getTimeUs() == paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(203003);
      return true;
    }
    AppMethodBeat.o(203003);
    return false;
  }
  
  public int getTimeScale()
  {
    return this.timeScale;
  }
  
  public float getTimeSeconds()
  {
    return this.time;
  }
  
  public long getTimeUs()
  {
    return this.timeUs;
  }
  
  public long getValue()
  {
    return this.value;
  }
  
  public CMTime limitMax(CMTime paramCMTime)
  {
    AppMethodBeat.i(203010);
    if (bigThan(paramCMTime))
    {
      AppMethodBeat.o(203010);
      return paramCMTime;
    }
    AppMethodBeat.o(203010);
    return this;
  }
  
  public CMTime limitMin(CMTime paramCMTime)
  {
    AppMethodBeat.i(203007);
    if (smallThan(paramCMTime))
    {
      AppMethodBeat.o(203007);
      return paramCMTime;
    }
    AppMethodBeat.o(203007);
    return this;
  }
  
  public CMTime multi(float paramFloat)
  {
    AppMethodBeat.i(202982);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(202982);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() * paramFloat), this.timeScale);
    AppMethodBeat.o(202982);
    return localCMTime;
  }
  
  public CMTime multi(CMTime paramCMTime)
  {
    AppMethodBeat.i(202989);
    int i = LCM(this.timeScale, paramCMTime.timeScale);
    CMTime localCMTime = convertTimeScale(this, i);
    paramCMTime = convertTimeScale(paramCMTime, i);
    paramCMTime = new CMTime(localCMTime.value * paramCMTime.value, i);
    AppMethodBeat.o(202989);
    return paramCMTime;
  }
  
  public boolean smallThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(203000);
    if (getTimeUs() < paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(203000);
      return true;
    }
    AppMethodBeat.o(203000);
    return false;
  }
  
  public CMTime sub(CMTime paramCMTime)
  {
    AppMethodBeat.i(202978);
    paramCMTime = sub(this, paramCMTime);
    AppMethodBeat.o(202978);
    return paramCMTime;
  }
  
  public String toString()
  {
    AppMethodBeat.i(203020);
    String str = "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + "]";
    AppMethodBeat.o(203020);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTime
 * JD-Core Version:    0.7.0.1
 */