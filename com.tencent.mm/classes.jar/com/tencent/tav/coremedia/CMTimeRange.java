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
    AppMethodBeat.i(195743);
    CMTime localCMTime = CMTime.CMTimeZero;
    CMTimeRangeInvalid = new CMTimeRange(localCMTime, localCMTime);
    AppMethodBeat.o(195743);
  }
  
  public CMTimeRange(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(195726);
    this.start = paramCMTime1;
    this.duration = paramCMTime2;
    this.end = paramCMTime1.add(paramCMTime2);
    AppMethodBeat.o(195726);
  }
  
  public static CMTimeRange fromMs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195724);
    CMTimeRange localCMTimeRange = new CMTimeRange(CMTime.fromMs(paramLong1), CMTime.fromMs(paramLong2));
    AppMethodBeat.o(195724);
    return localCMTimeRange;
  }
  
  public static CMTimeRange fromSeconds(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(195723);
    CMTimeRange localCMTimeRange = new CMTimeRange(CMTime.fromSeconds(paramFloat1), CMTime.fromSeconds(paramFloat2));
    AppMethodBeat.o(195723);
    return localCMTimeRange;
  }
  
  public static CMTimeRange fromUs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195725);
    CMTimeRange localCMTimeRange = new CMTimeRange(CMTime.fromUs(paramLong1), CMTime.fromUs(paramLong2));
    AppMethodBeat.o(195725);
    return localCMTimeRange;
  }
  
  public static CMTimeRange getIntersection(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(195727);
    if ((paramCMTimeRange1 == null) || (paramCMTimeRange2 == null))
    {
      paramCMTimeRange1 = CMTimeRangeInvalid;
      AppMethodBeat.o(195727);
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
        AppMethodBeat.o(195727);
        return paramCMTimeRange1;
      }
      if (paramCMTimeRange2.getEndUs() >= paramCMTimeRange1.getEndUs())
      {
        AppMethodBeat.o(195727);
        return paramCMTimeRange1;
      }
      if (paramCMTimeRange2.getEndUs() < paramCMTimeRange1.getStartUs())
      {
        paramCMTimeRange1 = CMTimeRangeInvalid;
        AppMethodBeat.o(195727);
        return paramCMTimeRange1;
      }
      paramCMTimeRange1 = CMTimeRangeInvalid;
      AppMethodBeat.o(195727);
      return paramCMTimeRange1;
      CMTimeRange localCMTimeRange = paramCMTimeRange1;
      paramCMTimeRange1 = paramCMTimeRange2;
      paramCMTimeRange2 = localCMTimeRange;
    }
  }
  
  public static CMTimeRange[] getUnions(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(195728);
    CMTimeRange[] arrayOfCMTimeRange = new CMTimeRange[2];
    if (paramCMTimeRange1 == null) {
      arrayOfCMTimeRange[0] = paramCMTimeRange2;
    }
    for (;;)
    {
      AppMethodBeat.o(195728);
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
    AppMethodBeat.i(195737);
    CMTimeRange localCMTimeRange = new CMTimeRange(this.start, this.duration);
    AppMethodBeat.o(195737);
    return localCMTimeRange;
  }
  
  public boolean containsTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(195734);
    if ((getStartUs() <= paramCMTime.getTimeUs()) && (getEndUs() > paramCMTime.getTimeUs()))
    {
      AppMethodBeat.o(195734);
      return true;
    }
    AppMethodBeat.o(195734);
    return false;
  }
  
  public boolean containsTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(195735);
    if ((getStartUs() <= paramCMTimeRange.getStartUs()) && (getEndUs() >= paramCMTimeRange.getEndUs()))
    {
      AppMethodBeat.o(195735);
      return true;
    }
    AppMethodBeat.o(195735);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195736);
    if (!(paramObject instanceof CMTimeRange))
    {
      AppMethodBeat.o(195736);
      return false;
    }
    if ((this.start.equals(((CMTimeRange)paramObject).start)) && (this.duration.equals(((CMTimeRange)paramObject).duration)))
    {
      AppMethodBeat.o(195736);
      return true;
    }
    AppMethodBeat.o(195736);
    return false;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public long getDurationUs()
  {
    AppMethodBeat.i(195729);
    long l = this.duration.getTimeUs();
    AppMethodBeat.o(195729);
    return l;
  }
  
  public CMTime getEnd()
  {
    return this.end;
  }
  
  public long getEndUs()
  {
    AppMethodBeat.i(195731);
    long l1 = getStartUs();
    long l2 = getDurationUs();
    AppMethodBeat.o(195731);
    return l1 + l2;
  }
  
  public CMTime getStart()
  {
    return this.start;
  }
  
  public long getStartUs()
  {
    AppMethodBeat.i(195730);
    long l = this.start.getTimeUs();
    AppMethodBeat.o(195730);
    return l;
  }
  
  public boolean isLegal()
  {
    AppMethodBeat.i(195739);
    if ((getStartUs() >= 0L) && (getDurationUs() > 0L))
    {
      AppMethodBeat.o(195739);
      return true;
    }
    AppMethodBeat.o(195739);
    return false;
  }
  
  public void setDuration(CMTime paramCMTime)
  {
    AppMethodBeat.i(195733);
    this.duration = paramCMTime;
    this.end = this.start.add(this.duration);
    AppMethodBeat.o(195733);
  }
  
  public void setStart(CMTime paramCMTime)
  {
    AppMethodBeat.i(195732);
    this.start = paramCMTime;
    this.end = this.start.add(this.duration);
    AppMethodBeat.o(195732);
  }
  
  public CMTimeRange[] split(float paramFloat)
  {
    AppMethodBeat.i(195738);
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      CMTimeRange localCMTimeRange1 = new CMTimeRange(this.start, getDuration().multi(paramFloat));
      CMTimeRange localCMTimeRange2 = new CMTimeRange(localCMTimeRange1.getEnd(), getDuration().multi(1.0F - paramFloat));
      AppMethodBeat.o(195738);
      return new CMTimeRange[] { localCMTimeRange1, localCMTimeRange2 };
    }
    AppMethodBeat.o(195738);
    return null;
  }
  
  public String toSimpleString()
  {
    AppMethodBeat.i(195740);
    String str = "CMTimeRange{startUs=" + this.start.getTimeUs() + ", durationUs=" + this.duration.getTimeUs() + '}';
    AppMethodBeat.o(195740);
    return str;
  }
  
  public String toString()
  {
    AppMethodBeat.i(195741);
    String str = "CMTimeRange{start=" + this.start + ", duration=" + this.duration + ", end=" + this.end + '}';
    AppMethodBeat.o(195741);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTimeRange
 * JD-Core Version:    0.7.0.1
 */