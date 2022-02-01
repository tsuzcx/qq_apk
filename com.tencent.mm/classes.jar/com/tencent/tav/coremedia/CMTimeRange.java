package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CMTimeRange
  implements Cloneable
{
  public static CMTimeRange CMTimeRangeInvalid;
  private CMTime duration;
  private CMTime end;
  private CMTime start;
  
  static
  {
    AppMethodBeat.i(200257);
    CMTime localCMTime = CMTime.CMTimeZero;
    CMTimeRangeInvalid = new CMTimeRange(localCMTime, localCMTime);
    AppMethodBeat.o(200257);
  }
  
  public CMTimeRange(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(200240);
    this.start = paramCMTime1;
    this.duration = paramCMTime2;
    this.end = paramCMTime1.add(paramCMTime2);
    AppMethodBeat.o(200240);
  }
  
  public static CMTimeRange fromMs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(200238);
    CMTimeRange localCMTimeRange = new CMTimeRange(CMTime.fromMs(paramLong1), CMTime.fromMs(paramLong2));
    AppMethodBeat.o(200238);
    return localCMTimeRange;
  }
  
  public static CMTimeRange fromSeconds(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200237);
    CMTimeRange localCMTimeRange = new CMTimeRange(CMTime.fromSeconds(paramFloat1), CMTime.fromSeconds(paramFloat2));
    AppMethodBeat.o(200237);
    return localCMTimeRange;
  }
  
  public static CMTimeRange fromUs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(200239);
    CMTimeRange localCMTimeRange = new CMTimeRange(CMTime.fromUs(paramLong1), CMTime.fromUs(paramLong2));
    AppMethodBeat.o(200239);
    return localCMTimeRange;
  }
  
  public static CMTimeRange getIntersection(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(200241);
    if ((paramCMTimeRange1 == null) || (paramCMTimeRange2 == null))
    {
      paramCMTimeRange1 = CMTimeRangeInvalid;
      AppMethodBeat.o(200241);
      return paramCMTimeRange1;
    }
    paramCMTimeRange1 = paramCMTimeRange1.clone();
    paramCMTimeRange2 = paramCMTimeRange2.clone();
    if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs()) {}
    for (;;)
    {
      if ((paramCMTimeRange2.getEndUs() > paramCMTimeRange1.getStartUs()) && (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getEndUs()))
      {
        paramCMTimeRange1 = new CMTimeRange(paramCMTimeRange1.getStart(), paramCMTimeRange2.getEnd().sub(paramCMTimeRange1.getStart()));
        AppMethodBeat.o(200241);
        return paramCMTimeRange1;
      }
      if (paramCMTimeRange2.getEndUs() >= paramCMTimeRange1.getEndUs())
      {
        AppMethodBeat.o(200241);
        return paramCMTimeRange1;
      }
      if (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getStartUs())
      {
        paramCMTimeRange1 = CMTimeRangeInvalid;
        AppMethodBeat.o(200241);
        return paramCMTimeRange1;
      }
      paramCMTimeRange1 = CMTimeRangeInvalid;
      AppMethodBeat.o(200241);
      return paramCMTimeRange1;
      CMTimeRange localCMTimeRange = paramCMTimeRange1;
      paramCMTimeRange1 = paramCMTimeRange2;
      paramCMTimeRange2 = localCMTimeRange;
    }
  }
  
  public static CMTimeRange[] getUnions(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(200242);
    CMTimeRange[] arrayOfCMTimeRange = new CMTimeRange[2];
    if (paramCMTimeRange1 == null) {
      arrayOfCMTimeRange[0] = paramCMTimeRange2;
    }
    for (;;)
    {
      AppMethodBeat.o(200242);
      return arrayOfCMTimeRange;
      if (paramCMTimeRange2 != null) {
        break;
      }
      arrayOfCMTimeRange[0] = paramCMTimeRange1;
    }
    paramCMTimeRange1 = paramCMTimeRange1.clone();
    paramCMTimeRange2 = paramCMTimeRange2.clone();
    if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs()) {}
    for (;;)
    {
      arrayOfCMTimeRange[0] = paramCMTimeRange2;
      if ((paramCMTimeRange2.getEndUs() >= paramCMTimeRange1.getStartUs()) && (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getEndUs()))
      {
        arrayOfCMTimeRange[1] = new CMTimeRange(paramCMTimeRange2.getEnd(), paramCMTimeRange1.getEnd().sub(paramCMTimeRange2.getEnd()));
        break;
      }
      if (paramCMTimeRange2.getEndUs() >= paramCMTimeRange1.getEndUs())
      {
        arrayOfCMTimeRange[1] = null;
        break;
      }
      if (paramCMTimeRange2.getEndUs() >= paramCMTimeRange1.getStartUs()) {
        break;
      }
      arrayOfCMTimeRange[1] = paramCMTimeRange1;
      break;
      CMTimeRange localCMTimeRange = paramCMTimeRange1;
      paramCMTimeRange1 = paramCMTimeRange2;
      paramCMTimeRange2 = localCMTimeRange;
    }
  }
  
  public CMTimeRange clone()
  {
    AppMethodBeat.i(200251);
    CMTimeRange localCMTimeRange = new CMTimeRange(this.start, this.duration);
    AppMethodBeat.o(200251);
    return localCMTimeRange;
  }
  
  public boolean containsTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(200248);
    if ((getStartUs() <= paramCMTime.getTimeUs()) && (getEndUs() > paramCMTime.getTimeUs()))
    {
      AppMethodBeat.o(200248);
      return true;
    }
    AppMethodBeat.o(200248);
    return false;
  }
  
  public boolean containsTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(200249);
    if ((getStartUs() <= paramCMTimeRange.getStartUs()) && (getEndUs() >= paramCMTimeRange.getEndUs()))
    {
      AppMethodBeat.o(200249);
      return true;
    }
    AppMethodBeat.o(200249);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200250);
    if (!(paramObject instanceof CMTimeRange))
    {
      AppMethodBeat.o(200250);
      return false;
    }
    if ((this.start.equals(((CMTimeRange)paramObject).start)) && (this.duration.equals(((CMTimeRange)paramObject).duration)))
    {
      AppMethodBeat.o(200250);
      return true;
    }
    AppMethodBeat.o(200250);
    return false;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public long getDurationUs()
  {
    AppMethodBeat.i(200243);
    long l = this.duration.getTimeUs();
    AppMethodBeat.o(200243);
    return l;
  }
  
  public CMTime getEnd()
  {
    return this.end;
  }
  
  public long getEndUs()
  {
    AppMethodBeat.i(200245);
    long l1 = getStartUs();
    long l2 = getDurationUs();
    AppMethodBeat.o(200245);
    return l1 + l2;
  }
  
  public CMTime getStart()
  {
    return this.start;
  }
  
  public long getStartUs()
  {
    AppMethodBeat.i(200244);
    long l = this.start.getTimeUs();
    AppMethodBeat.o(200244);
    return l;
  }
  
  public boolean isLegal()
  {
    AppMethodBeat.i(200253);
    if ((getStartUs() >= 0L) && (getDurationUs() > 0L))
    {
      AppMethodBeat.o(200253);
      return true;
    }
    AppMethodBeat.o(200253);
    return false;
  }
  
  public void setDuration(CMTime paramCMTime)
  {
    AppMethodBeat.i(200247);
    this.duration = paramCMTime;
    this.end = this.start.add(this.duration);
    AppMethodBeat.o(200247);
  }
  
  public void setStart(CMTime paramCMTime)
  {
    AppMethodBeat.i(200246);
    this.start = paramCMTime;
    this.end = this.start.add(this.duration);
    AppMethodBeat.o(200246);
  }
  
  public CMTimeRange[] split(float paramFloat)
  {
    AppMethodBeat.i(200252);
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      CMTimeRange localCMTimeRange1 = new CMTimeRange(this.start, getDuration().multi(paramFloat));
      CMTimeRange localCMTimeRange2 = new CMTimeRange(localCMTimeRange1.getEnd(), getDuration().multi(1.0F - paramFloat));
      AppMethodBeat.o(200252);
      return new CMTimeRange[] { localCMTimeRange1, localCMTimeRange2 };
    }
    AppMethodBeat.o(200252);
    return null;
  }
  
  public String toSimpleString()
  {
    AppMethodBeat.i(200254);
    String str = "CMTimeRange{startUs=" + this.start.getTimeUs() + ", durationUs=" + this.duration.getTimeUs() + '}';
    AppMethodBeat.o(200254);
    return str;
  }
  
  public String toString()
  {
    AppMethodBeat.i(200255);
    String str = "CMTimeRange{start=" + this.start + ", duration=" + this.duration + ", end=" + this.end + '}';
    AppMethodBeat.o(200255);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTimeRange
 * JD-Core Version:    0.7.0.1
 */