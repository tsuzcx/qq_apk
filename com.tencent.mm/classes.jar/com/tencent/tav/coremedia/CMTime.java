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
    AppMethodBeat.i(199436);
    CMTimeZero = new CMTime(0L, 600);
    CMTimeOne = new CMTime(600L, 600);
    CMTimeInvalid = new CMTime(-9223372036854775808L, 600, -1.0F, -1L);
    AppMethodBeat.o(199436);
  }
  
  public CMTime()
  {
    this(0L, 600);
  }
  
  public CMTime(float paramFloat)
  {
    this((600.0F * paramFloat), 600);
    AppMethodBeat.i(199418);
    AppMethodBeat.o(199418);
  }
  
  public CMTime(long paramLong)
  {
    this(paramLong, 600);
  }
  
  public CMTime(long paramLong, int paramInt)
  {
    AppMethodBeat.i(199419);
    this.value = paramLong;
    this.timeScale = paramInt;
    this.time = ((float)paramLong * 1.0F / paramInt);
    this.timeUs = (1000000L * paramLong / paramInt);
    AppMethodBeat.o(199419);
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
    AppMethodBeat.i(199412);
    paramInt1 /= GCD(paramInt1, paramInt2);
    AppMethodBeat.o(199412);
    return paramInt1 * paramInt2;
  }
  
  public static CMTime add(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(199414);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime2.clone();
      AppMethodBeat.o(199414);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(199414);
      return paramCMTime1;
    }
    int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
    paramCMTime1 = convertTimeScale(paramCMTime1, i);
    paramCMTime2 = convertTimeScale(paramCMTime2, i);
    long l = paramCMTime1.getValue();
    paramCMTime1 = new CMTime(paramCMTime2.getValue() + l, paramCMTime1.timeScale);
    AppMethodBeat.o(199414);
    return paramCMTime1;
  }
  
  public static CMTime convertTimeScale(CMTime paramCMTime, int paramInt)
  {
    AppMethodBeat.i(199413);
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = CMTimeInvalid;
      AppMethodBeat.o(199413);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeZero)
    {
      paramCMTime = new CMTime(0L, paramInt);
      AppMethodBeat.o(199413);
      return paramCMTime;
    }
    paramCMTime = new CMTime(paramCMTime.getValue() * paramInt / paramCMTime.getTimeScale(), paramInt);
    AppMethodBeat.o(199413);
    return paramCMTime;
  }
  
  public static CMTime fromMs(long paramLong)
  {
    AppMethodBeat.i(199410);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000.0F);
    AppMethodBeat.o(199410);
    return localCMTime;
  }
  
  public static CMTime fromSeconds(float paramFloat)
  {
    AppMethodBeat.i(199409);
    CMTime localCMTime = new CMTime(paramFloat);
    AppMethodBeat.o(199409);
    return localCMTime;
  }
  
  public static CMTime fromUs(long paramLong)
  {
    AppMethodBeat.i(199411);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000000.0F);
    AppMethodBeat.o(199411);
    return localCMTime;
  }
  
  public static CMTime max(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(199417);
    if (paramCMTime1.bigThan(paramCMTime2))
    {
      AppMethodBeat.o(199417);
      return paramCMTime1;
    }
    AppMethodBeat.o(199417);
    return paramCMTime2;
  }
  
  public static CMTime min(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(199416);
    if (paramCMTime1.smallThan(paramCMTime2))
    {
      AppMethodBeat.o(199416);
      return paramCMTime1;
    }
    AppMethodBeat.o(199416);
    return paramCMTime2;
  }
  
  public static CMTime sub(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(199415);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = new CMTime(-paramCMTime2.getValue());
      AppMethodBeat.o(199415);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(199415);
      return paramCMTime1;
    }
    int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
    paramCMTime1 = convertTimeScale(paramCMTime1, i);
    paramCMTime2 = convertTimeScale(paramCMTime2, i);
    paramCMTime1 = new CMTime(paramCMTime1.getValue() - paramCMTime2.getValue(), paramCMTime1.timeScale);
    AppMethodBeat.o(199415);
    return paramCMTime1;
  }
  
  public CMTime add(long paramLong)
  {
    AppMethodBeat.i(199420);
    if (this == CMTimeInvalid)
    {
      localCMTime = clone();
      AppMethodBeat.o(199420);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(getValue() + this.timeScale * paramLong / TimeUnit.SECONDS.toMicros(1L), this.timeScale);
    AppMethodBeat.o(199420);
    return localCMTime;
  }
  
  public CMTime add(CMTime paramCMTime)
  {
    AppMethodBeat.i(199421);
    paramCMTime = add(this, paramCMTime);
    AppMethodBeat.o(199421);
    return paramCMTime;
  }
  
  public boolean bigThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(199427);
    if (getTimeUs() > paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(199427);
      return true;
    }
    AppMethodBeat.o(199427);
    return false;
  }
  
  public CMTime clone()
  {
    AppMethodBeat.i(199433);
    CMTime localCMTime = new CMTime(this.value, this.timeScale, this.time, this.timeUs);
    AppMethodBeat.o(199433);
    return localCMTime;
  }
  
  public int compare(CMTime paramCMTime)
  {
    AppMethodBeat.i(199430);
    long l = getTimeUs() - paramCMTime.getTimeUs();
    if (l > 0L)
    {
      AppMethodBeat.o(199430);
      return 1;
    }
    if (l == 0L)
    {
      AppMethodBeat.o(199430);
      return 0;
    }
    AppMethodBeat.o(199430);
    return -1;
  }
  
  public CMTime divide(float paramFloat)
  {
    AppMethodBeat.i(199425);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(199425);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() / paramFloat), this.timeScale);
    AppMethodBeat.o(199425);
    return localCMTime;
  }
  
  public CMTime divide(CMTime paramCMTime)
  {
    AppMethodBeat.i(199426);
    int i = LCM(this.timeScale, paramCMTime.timeScale);
    CMTime localCMTime = convertTimeScale(this, i);
    paramCMTime = convertTimeScale(paramCMTime, i);
    paramCMTime = new CMTime(localCMTime.value / paramCMTime.value, i);
    AppMethodBeat.o(199426);
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
    AppMethodBeat.i(199429);
    if (getTimeUs() == paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(199429);
      return true;
    }
    AppMethodBeat.o(199429);
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
    AppMethodBeat.i(199432);
    if (bigThan(paramCMTime))
    {
      AppMethodBeat.o(199432);
      return paramCMTime;
    }
    AppMethodBeat.o(199432);
    return this;
  }
  
  public CMTime limitMin(CMTime paramCMTime)
  {
    AppMethodBeat.i(199431);
    if (smallThan(paramCMTime))
    {
      AppMethodBeat.o(199431);
      return paramCMTime;
    }
    AppMethodBeat.o(199431);
    return this;
  }
  
  public CMTime multi(float paramFloat)
  {
    AppMethodBeat.i(199423);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(199423);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() * paramFloat), this.timeScale);
    AppMethodBeat.o(199423);
    return localCMTime;
  }
  
  public CMTime multi(CMTime paramCMTime)
  {
    AppMethodBeat.i(199424);
    int i = LCM(this.timeScale, paramCMTime.timeScale);
    CMTime localCMTime = convertTimeScale(this, i);
    paramCMTime = convertTimeScale(paramCMTime, i);
    paramCMTime = new CMTime(localCMTime.value * paramCMTime.value, i);
    AppMethodBeat.o(199424);
    return paramCMTime;
  }
  
  public boolean smallThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(199428);
    if (getTimeUs() < paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(199428);
      return true;
    }
    AppMethodBeat.o(199428);
    return false;
  }
  
  public CMTime sub(CMTime paramCMTime)
  {
    AppMethodBeat.i(199422);
    paramCMTime = sub(this, paramCMTime);
    AppMethodBeat.o(199422);
    return paramCMTime;
  }
  
  public String toString()
  {
    AppMethodBeat.i(199434);
    String str = "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + "]";
    AppMethodBeat.o(199434);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTime
 * JD-Core Version:    0.7.0.1
 */