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
    AppMethodBeat.i(215853);
    CMTimeZero = new CMTime(0L, 600);
    CMTimeOne = new CMTime(600L, 600);
    CMTimeInvalid = new CMTime(-9223372036854775808L, 600, -1.0F, -1L);
    AppMethodBeat.o(215853);
  }
  
  public CMTime()
  {
    this(0L, 600);
  }
  
  public CMTime(float paramFloat)
  {
    this((600.0F * paramFloat), 600);
    AppMethodBeat.i(215836);
    AppMethodBeat.o(215836);
  }
  
  public CMTime(long paramLong)
  {
    this(paramLong, 600);
  }
  
  public CMTime(long paramLong, int paramInt)
  {
    AppMethodBeat.i(215839);
    this.value = paramLong;
    this.timeScale = paramInt;
    this.time = ((float)paramLong * 1.0F / paramInt);
    this.timeUs = (1000000L * paramLong / paramInt);
    AppMethodBeat.o(215839);
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
    AppMethodBeat.i(215779);
    paramInt1 /= GCD(paramInt1, paramInt2);
    AppMethodBeat.o(215779);
    return paramInt1 * paramInt2;
  }
  
  public static CMTime add(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(215794);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime2.clone();
      AppMethodBeat.o(215794);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(215794);
      return paramCMTime1;
    }
    int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
    paramCMTime1 = convertTimeScale(paramCMTime1, i);
    paramCMTime2 = convertTimeScale(paramCMTime2, i);
    long l = paramCMTime1.getValue();
    paramCMTime1 = new CMTime(paramCMTime2.getValue() + l, paramCMTime1.timeScale);
    AppMethodBeat.o(215794);
    return paramCMTime1;
  }
  
  public static CMTime convertTimeScale(CMTime paramCMTime, int paramInt)
  {
    AppMethodBeat.i(215788);
    if (paramCMTime == CMTimeInvalid)
    {
      paramCMTime = CMTimeInvalid;
      AppMethodBeat.o(215788);
      return paramCMTime;
    }
    if (paramCMTime == CMTimeZero)
    {
      paramCMTime = new CMTime(0L, paramInt);
      AppMethodBeat.o(215788);
      return paramCMTime;
    }
    paramCMTime = new CMTime(paramCMTime.getValue() * paramInt / paramCMTime.getTimeScale(), paramInt);
    AppMethodBeat.o(215788);
    return paramCMTime;
  }
  
  public static CMTime fromMs(long paramLong)
  {
    AppMethodBeat.i(215760);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000.0F);
    AppMethodBeat.o(215760);
    return localCMTime;
  }
  
  public static CMTime fromSeconds(float paramFloat)
  {
    AppMethodBeat.i(215750);
    CMTime localCMTime = new CMTime(paramFloat);
    AppMethodBeat.o(215750);
    return localCMTime;
  }
  
  public static CMTime fromUs(long paramLong)
  {
    AppMethodBeat.i(215766);
    CMTime localCMTime = new CMTime((float)paramLong * 1.0F / 1000000.0F);
    AppMethodBeat.o(215766);
    return localCMTime;
  }
  
  public static CMTime max(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(215818);
    if (paramCMTime1.bigThan(paramCMTime2))
    {
      AppMethodBeat.o(215818);
      return paramCMTime1;
    }
    AppMethodBeat.o(215818);
    return paramCMTime2;
  }
  
  public static CMTime min(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(215810);
    if (paramCMTime1.smallThan(paramCMTime2))
    {
      AppMethodBeat.o(215810);
      return paramCMTime1;
    }
    AppMethodBeat.o(215810);
    return paramCMTime2;
  }
  
  public static CMTime sub(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(215802);
    if (paramCMTime1 == CMTimeInvalid)
    {
      paramCMTime1 = new CMTime(-paramCMTime2.getValue());
      AppMethodBeat.o(215802);
      return paramCMTime1;
    }
    if (paramCMTime2 == CMTimeInvalid)
    {
      paramCMTime1 = paramCMTime1.clone();
      AppMethodBeat.o(215802);
      return paramCMTime1;
    }
    int i = LCM(paramCMTime1.timeScale, paramCMTime2.timeScale);
    paramCMTime1 = convertTimeScale(paramCMTime1, i);
    paramCMTime2 = convertTimeScale(paramCMTime2, i);
    paramCMTime1 = new CMTime(paramCMTime1.getValue() - paramCMTime2.getValue(), paramCMTime1.timeScale);
    AppMethodBeat.o(215802);
    return paramCMTime1;
  }
  
  public CMTime add(long paramLong)
  {
    AppMethodBeat.i(215874);
    if (this == CMTimeInvalid)
    {
      localCMTime = clone();
      AppMethodBeat.o(215874);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(getValue() + this.timeScale * paramLong / TimeUnit.SECONDS.toMicros(1L), this.timeScale);
    AppMethodBeat.o(215874);
    return localCMTime;
  }
  
  public CMTime add(CMTime paramCMTime)
  {
    AppMethodBeat.i(215880);
    paramCMTime = add(this, paramCMTime);
    AppMethodBeat.o(215880);
    return paramCMTime;
  }
  
  public boolean bigThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(215908);
    if (getTimeUs() > paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(215908);
      return true;
    }
    AppMethodBeat.o(215908);
    return false;
  }
  
  public CMTime clone()
  {
    AppMethodBeat.i(215934);
    CMTime localCMTime = new CMTime(this.value, this.timeScale, this.time, this.timeUs);
    AppMethodBeat.o(215934);
    return localCMTime;
  }
  
  public int compare(CMTime paramCMTime)
  {
    AppMethodBeat.i(215913);
    long l = getTimeUs() - paramCMTime.getTimeUs();
    if (l > 0L)
    {
      AppMethodBeat.o(215913);
      return 1;
    }
    if (l == 0L)
    {
      AppMethodBeat.o(215913);
      return 0;
    }
    AppMethodBeat.o(215913);
    return -1;
  }
  
  public CMTime divide(float paramFloat)
  {
    AppMethodBeat.i(215900);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(215900);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() / paramFloat), this.timeScale);
    AppMethodBeat.o(215900);
    return localCMTime;
  }
  
  public CMTime divide(CMTime paramCMTime)
  {
    AppMethodBeat.i(215904);
    int i = LCM(this.timeScale, paramCMTime.timeScale);
    CMTime localCMTime = convertTimeScale(this, i);
    paramCMTime = convertTimeScale(paramCMTime, i);
    paramCMTime = new CMTime(localCMTime.value / paramCMTime.value, i);
    AppMethodBeat.o(215904);
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
    AppMethodBeat.i(215912);
    if (getTimeUs() == paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(215912);
      return true;
    }
    AppMethodBeat.o(215912);
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
    AppMethodBeat.i(215923);
    if (bigThan(paramCMTime))
    {
      AppMethodBeat.o(215923);
      return paramCMTime;
    }
    AppMethodBeat.o(215923);
    return this;
  }
  
  public CMTime limitMin(CMTime paramCMTime)
  {
    AppMethodBeat.i(215917);
    if (smallThan(paramCMTime))
    {
      AppMethodBeat.o(215917);
      return paramCMTime;
    }
    AppMethodBeat.o(215917);
    return this;
  }
  
  public CMTime multi(float paramFloat)
  {
    AppMethodBeat.i(215891);
    if (this == CMTimeInvalid)
    {
      localCMTime = CMTimeInvalid;
      AppMethodBeat.o(215891);
      return localCMTime;
    }
    CMTime localCMTime = new CMTime(((float)getValue() * paramFloat), this.timeScale);
    AppMethodBeat.o(215891);
    return localCMTime;
  }
  
  public CMTime multi(CMTime paramCMTime)
  {
    AppMethodBeat.i(215897);
    int i = LCM(this.timeScale, paramCMTime.timeScale);
    CMTime localCMTime = convertTimeScale(this, i);
    paramCMTime = convertTimeScale(paramCMTime, i);
    paramCMTime = new CMTime(localCMTime.value * paramCMTime.value, i);
    AppMethodBeat.o(215897);
    return paramCMTime;
  }
  
  public boolean smallThan(CMTime paramCMTime)
  {
    AppMethodBeat.i(215910);
    if (getTimeUs() < paramCMTime.getTimeUs())
    {
      AppMethodBeat.o(215910);
      return true;
    }
    AppMethodBeat.o(215910);
    return false;
  }
  
  public CMTime sub(CMTime paramCMTime)
  {
    AppMethodBeat.i(215885);
    paramCMTime = sub(this, paramCMTime);
    AppMethodBeat.o(215885);
    return paramCMTime;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215940);
    String str = "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + "]";
    AppMethodBeat.o(215940);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTime
 * JD-Core Version:    0.7.0.1
 */