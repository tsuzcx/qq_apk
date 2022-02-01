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
    AppMethodBeat.i(204379);
    CMTimeZero = new CMTime(0L, 600);
    CMTimeOne = new CMTime(600L, 600);
    CMTimeInvalid = new CMTime(-9223372036854775808L, 600, -1.0F, -1L);
    AppMethodBeat.o(204379);
  }
  
  public CMTime()
  {
    this(0L, 600);
  }
  
  public CMTime(float paramFloat)
  {
    this((600.0F * paramFloat), 600);
    AppMethodBeat.i(204358);
    AppMethodBeat.o(204358);
  }
  
  public CMTime(long paramLong)
  {
    this(paramLong, 600);
  }
  
  public CMTime(long paramLong, int paramInt)
  {
    AppMethodBeat.i(204359);
    this.value = paramLong;
    this.timeScale = paramInt;
    this.time = ((float)paramLong * 1.0F / paramInt);
    this.timeUs = (1000000L * paramLong / paramInt);
    AppMethodBeat.o(204359);
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
    AppMethodBeat.i(204373);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime2.clone();
      AppMethodBeat.o(204373);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(204373);
      return paramCMTime1;
    }
    paramCMTime2 = convertTimeScale(paramCMTime2, paramCMTime1.timeScale);
    paramCMTime1 = new CMTime(paramCMTime1.getValue() + paramCMTime2.getValue(), paramCMTime1.timeScale);
    AppMethodBeat.o(204373);
    return paramCMTime1;
  }
  
  public static CMTime convertTimeScale(CMTime paramCMTime, int paramInt)
  {
    AppMethodBeat.i(204372);
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = CMTimeInvalid;
      AppMethodBeat.o(204372);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeZero)
    {
      paramCMTime = new CMTime(0L, paramInt);
      AppMethodBeat.o(204372);
      return paramCMTime;
    }
    paramCMTime = new CMTime(paramCMTime.getValue() * paramInt / paramCMTime.getTimeScale(), paramInt);
    AppMethodBeat.o(204372);
    return paramCMTime;
  }
  
  public static CMTime fromMs(long paramLong)
  {
    AppMethodBeat.i(204356);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000.0F);
    AppMethodBeat.o(204356);
    return localCMTime;
  }
  
  public static CMTime fromSeconds(float paramFloat)
  {
    AppMethodBeat.i(204355);
    CMTime localCMTime = new CMTime(paramFloat);
    AppMethodBeat.o(204355);
    return localCMTime;
  }
  
  public static CMTime fromUs(long paramLong)
  {
    AppMethodBeat.i(204357);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000000.0F);
    AppMethodBeat.o(204357);
    return localCMTime;
  }
  
  public static CMTime max(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(204376);
    if (paramCMTime1.bigThan(paramCMTime2))
    {
      AppMethodBeat.o(204376);
      return paramCMTime1;
    }
    AppMethodBeat.o(204376);
    return paramCMTime2;
  }
  
  public static CMTime min(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(204375);
    if (paramCMTime1.smallThan(paramCMTime2))
    {
      AppMethodBeat.o(204375);
      return paramCMTime1;
    }
    AppMethodBeat.o(204375);
    return paramCMTime2;
  }
  
  public static CMTime sub(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(204374);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = new CMTime(-paramCMTime2.getValue());
      AppMethodBeat.o(204374);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(204374);
      return paramCMTime1;
    }
    paramCMTime2 = convertTimeScale(paramCMTime2, paramCMTime1.timeScale);
    paramCMTime1 = new CMTime(paramCMTime1.getValue() - paramCMTime2.getValue(), paramCMTime1.timeScale);
    AppMethodBeat.o(204374);
    return paramCMTime1;
  }
  
  public CMTime add(long paramLong)
  {
    AppMethodBeat.i(204360);
    if (this == CMTimeInvalid)
    {
      localCMTime = clone();
      AppMethodBeat.o(204360);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(getValue() + this.timeScale * paramLong / TimeUnit.SECONDS.toMicros(1L), this.timeScale);
    AppMethodBeat.o(204360);
    return localCMTime;
  }
  
  public CMTime add(CMTime paramCMTime)
  {
    AppMethodBeat.i(204361);
    if (this == CMTimeInvalid)
    {
      paramCMTime = paramCMTime.clone();
      AppMethodBeat.o(204361);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = clone();
      AppMethodBeat.o(204361);
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
      AppMethodBeat.o(204361);
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
    AppMethodBeat.i(204367);
    if (getTimeUs() > paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(204367);
      return true;
    }
    AppMethodBeat.o(204367);
    return false;
  }
  
  public CMTime clone()
  {
    AppMethodBeat.i(204371);
    CMTime localCMTime = new CMTime(this.value, this.timeScale, this.time, this.timeUs);
    AppMethodBeat.o(204371);
    return localCMTime;
  }
  
  public int compare(CMTime paramCMTime)
  {
    AppMethodBeat.i(204370);
    long l = getTimeUs() - paramCMTime.getTimeUs();
    if (l > 0L)
    {
      AppMethodBeat.o(204370);
      return 1;
    }
    if (l == 0L)
    {
      AppMethodBeat.o(204370);
      return 0;
    }
    AppMethodBeat.o(204370);
    return -1;
  }
  
  public CMTime divide(float paramFloat)
  {
    AppMethodBeat.i(204365);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(204365);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() / paramFloat), this.timeScale);
    AppMethodBeat.o(204365);
    return localCMTime;
  }
  
  public CMTime divide(CMTime paramCMTime)
  {
    AppMethodBeat.i(204366);
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
      AppMethodBeat.o(204366);
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
    AppMethodBeat.i(204369);
    if (getTimeUs() == paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(204369);
      return true;
    }
    AppMethodBeat.o(204369);
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
  
  public CMTime multi(float paramFloat)
  {
    AppMethodBeat.i(204363);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(204363);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() * paramFloat), this.timeScale);
    AppMethodBeat.o(204363);
    return localCMTime;
  }
  
  public CMTime multi(CMTime paramCMTime)
  {
    AppMethodBeat.i(204364);
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
      AppMethodBeat.o(204364);
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
    AppMethodBeat.i(204368);
    if (getTimeUs() < paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(204368);
      return true;
    }
    AppMethodBeat.o(204368);
    return false;
  }
  
  public CMTime sub(CMTime paramCMTime)
  {
    AppMethodBeat.i(204362);
    if (this == CMTimeInvalid)
    {
      paramCMTime = new CMTime(-paramCMTime.getValue());
      AppMethodBeat.o(204362);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = clone();
      AppMethodBeat.o(204362);
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
      AppMethodBeat.o(204362);
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
    AppMethodBeat.i(204377);
    String str = "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + "]";
    AppMethodBeat.o(204377);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTime
 * JD-Core Version:    0.7.0.1
 */