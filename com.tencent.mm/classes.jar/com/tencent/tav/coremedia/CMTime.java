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
    AppMethodBeat.i(219439);
    CMTimeZero = new CMTime(0L, 600);
    CMTimeOne = new CMTime(600L, 600);
    CMTimeInvalid = new CMTime(-9223372036854775808L, 600, -1.0F, -1L);
    AppMethodBeat.o(219439);
  }
  
  public CMTime()
  {
    this(0L, 600);
  }
  
  public CMTime(float paramFloat)
  {
    this((600.0F * paramFloat), 600);
    AppMethodBeat.i(219421);
    AppMethodBeat.o(219421);
  }
  
  public CMTime(long paramLong)
  {
    this(paramLong, 600);
  }
  
  public CMTime(long paramLong, int paramInt)
  {
    AppMethodBeat.i(219422);
    this.value = paramLong;
    this.timeScale = paramInt;
    this.time = ((float)paramLong * 1.0F / paramInt);
    this.timeUs = (1000000L * paramLong / paramInt);
    AppMethodBeat.o(219422);
  }
  
  private CMTime(long paramLong1, int paramInt, float paramFloat, long paramLong2)
  {
    this.value = paramLong1;
    this.timeUs = paramLong2;
    this.time = paramFloat;
    this.timeScale = paramInt;
  }
  
  public static CMTime add(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(219417);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime2.clone();
      AppMethodBeat.o(219417);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(219417);
      return paramCMTime1;
    }
    paramCMTime2 = convertTimeScale(paramCMTime2, paramCMTime1.timeScale);
    paramCMTime1 = new CMTime(paramCMTime1.getValue() + paramCMTime2.getValue(), paramCMTime1.timeScale);
    AppMethodBeat.o(219417);
    return paramCMTime1;
  }
  
  public static CMTime convertTimeScale(CMTime paramCMTime, int paramInt)
  {
    AppMethodBeat.i(219416);
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = CMTimeInvalid;
      AppMethodBeat.o(219416);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeZero)
    {
      paramCMTime = new CMTime(0L, paramInt);
      AppMethodBeat.o(219416);
      return paramCMTime;
    }
    paramCMTime = new CMTime(paramCMTime.getValue() * paramInt / paramCMTime.getTimeScale(), paramInt);
    AppMethodBeat.o(219416);
    return paramCMTime;
  }
  
  public static CMTime fromMs(long paramLong)
  {
    AppMethodBeat.i(219414);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000.0F);
    AppMethodBeat.o(219414);
    return localCMTime;
  }
  
  public static CMTime fromSeconds(float paramFloat)
  {
    AppMethodBeat.i(219413);
    CMTime localCMTime = new CMTime(paramFloat);
    AppMethodBeat.o(219413);
    return localCMTime;
  }
  
  public static CMTime fromUs(long paramLong)
  {
    AppMethodBeat.i(219415);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000000.0F);
    AppMethodBeat.o(219415);
    return localCMTime;
  }
  
  public static CMTime max(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(219420);
    if (paramCMTime1.bigThan(paramCMTime2))
    {
      AppMethodBeat.o(219420);
      return paramCMTime1;
    }
    AppMethodBeat.o(219420);
    return paramCMTime2;
  }
  
  public static CMTime min(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(219419);
    if (paramCMTime1.smallThan(paramCMTime2))
    {
      AppMethodBeat.o(219419);
      return paramCMTime1;
    }
    AppMethodBeat.o(219419);
    return paramCMTime2;
  }
  
  public static CMTime sub(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(219418);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = new CMTime(-paramCMTime2.getValue());
      AppMethodBeat.o(219418);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(219418);
      return paramCMTime1;
    }
    paramCMTime2 = convertTimeScale(paramCMTime2, paramCMTime1.timeScale);
    paramCMTime1 = new CMTime(paramCMTime1.getValue() - paramCMTime2.getValue(), paramCMTime1.timeScale);
    AppMethodBeat.o(219418);
    return paramCMTime1;
  }
  
  public CMTime add(long paramLong)
  {
    AppMethodBeat.i(219423);
    if (this == CMTimeInvalid)
    {
      localCMTime = clone();
      AppMethodBeat.o(219423);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(getValue() + this.timeScale * paramLong / TimeUnit.SECONDS.toMicros(1L), this.timeScale);
    AppMethodBeat.o(219423);
    return localCMTime;
  }
  
  public CMTime add(CMTime paramCMTime)
  {
    AppMethodBeat.i(219424);
    if (this == CMTimeInvalid)
    {
      paramCMTime = paramCMTime.clone();
      AppMethodBeat.o(219424);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = clone();
      AppMethodBeat.o(219424);
      return paramCMTime;
    }
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      paramCMTime = new CMTime(localCMTime1.getValue() + localCMTime2.getValue(), i);
      AppMethodBeat.o(219424);
      return paramCMTime;
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
  }
  
  public boolean bigThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(219430);
    if (getTimeUs() > paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(219430);
      return true;
    }
    AppMethodBeat.o(219430);
    return false;
  }
  
  public CMTime clone()
  {
    AppMethodBeat.i(219436);
    CMTime localCMTime = new CMTime(this.value, this.timeScale, this.time, this.timeUs);
    AppMethodBeat.o(219436);
    return localCMTime;
  }
  
  public int compare(CMTime paramCMTime)
  {
    AppMethodBeat.i(219433);
    long l = getTimeUs() - paramCMTime.getTimeUs();
    if (l > 0L)
    {
      AppMethodBeat.o(219433);
      return 1;
    }
    if (l == 0L)
    {
      AppMethodBeat.o(219433);
      return 0;
    }
    AppMethodBeat.o(219433);
    return -1;
  }
  
  public CMTime divide(float paramFloat)
  {
    AppMethodBeat.i(219428);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(219428);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() / paramFloat), this.timeScale);
    AppMethodBeat.o(219428);
    return localCMTime;
  }
  
  public CMTime divide(CMTime paramCMTime)
  {
    AppMethodBeat.i(219429);
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      paramCMTime = new CMTime(localCMTime1.getValue() / localCMTime2.getValue(), i);
      AppMethodBeat.o(219429);
      return paramCMTime;
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
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
    AppMethodBeat.i(219432);
    if (getTimeUs() == paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(219432);
      return true;
    }
    AppMethodBeat.o(219432);
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
    AppMethodBeat.i(219435);
    if (bigThan(paramCMTime))
    {
      AppMethodBeat.o(219435);
      return paramCMTime;
    }
    AppMethodBeat.o(219435);
    return this;
  }
  
  public CMTime limitMin(CMTime paramCMTime)
  {
    AppMethodBeat.i(219434);
    if (smallThan(paramCMTime))
    {
      AppMethodBeat.o(219434);
      return paramCMTime;
    }
    AppMethodBeat.o(219434);
    return this;
  }
  
  public CMTime multi(float paramFloat)
  {
    AppMethodBeat.i(219426);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(219426);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() * paramFloat), this.timeScale);
    AppMethodBeat.o(219426);
    return localCMTime;
  }
  
  public CMTime multi(CMTime paramCMTime)
  {
    AppMethodBeat.i(219427);
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      paramCMTime = new CMTime(localCMTime1.value * localCMTime2.value, i);
      AppMethodBeat.o(219427);
      return paramCMTime;
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
  }
  
  public boolean smallThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(219431);
    if (getTimeUs() < paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(219431);
      return true;
    }
    AppMethodBeat.o(219431);
    return false;
  }
  
  public CMTime sub(CMTime paramCMTime)
  {
    AppMethodBeat.i(219425);
    if (this == CMTimeInvalid)
    {
      paramCMTime = new CMTime(-paramCMTime.getValue());
      AppMethodBeat.o(219425);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = clone();
      AppMethodBeat.o(219425);
      return paramCMTime;
    }
    int j = this.timeScale;
    int i;
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (this.timeScale < paramCMTime.timeScale)
    {
      i = paramCMTime.timeScale;
      localCMTime1 = convertTimeScale(this, i);
      localCMTime2 = paramCMTime;
    }
    for (;;)
    {
      paramCMTime = new CMTime(localCMTime1.getValue() - localCMTime2.getValue(), i);
      AppMethodBeat.o(219425);
      return paramCMTime;
      i = j;
      localCMTime1 = this;
      localCMTime2 = paramCMTime;
      if (this.timeScale > paramCMTime.timeScale)
      {
        localCMTime2 = convertTimeScale(paramCMTime, j);
        i = j;
        localCMTime1 = this;
      }
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(219437);
    String str = "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + "]";
    AppMethodBeat.o(219437);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTime
 * JD-Core Version:    0.7.0.1
 */