package com.tencent.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public final class a
  implements ITPMediaTrackClip, Serializable
{
  private int ZBr;
  private int ZBs;
  private long mEndTime;
  private long mStartPosition;
  private long mStartTime;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(220093);
    this.mStartTime = 0L;
    this.mEndTime = 0L;
    this.ZBr = paramInt;
    this.ZBs = c.aAZ(this.ZBr);
    AppMethodBeat.o(220093);
  }
  
  public final ITPMediaTrackClip clone(int paramInt)
  {
    AppMethodBeat.i(220102);
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 1))
    {
      AppMethodBeat.o(220102);
      return null;
    }
    a locala = new a(paramInt);
    locala.ZBs = c.aAZ(paramInt);
    locala.mStartTime = this.mStartTime;
    locala.mEndTime = this.mEndTime;
    AppMethodBeat.o(220102);
    return locala;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220100);
    if (paramObject == null)
    {
      AppMethodBeat.o(220100);
      return false;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(220100);
      return false;
    }
    if ((this.ZBs == ((a)paramObject).getClipId()) && (this.ZBr == ((a)paramObject).getMediaType()))
    {
      AppMethodBeat.o(220100);
      return true;
    }
    AppMethodBeat.o(220100);
    return false;
  }
  
  public final int getClipId()
  {
    return this.ZBs;
  }
  
  public final long getEndTimeMs()
  {
    return this.mEndTime;
  }
  
  public final String getFilePath()
  {
    return null;
  }
  
  public final int getMediaType()
  {
    return this.ZBr;
  }
  
  public final long getOriginalDurationMs()
  {
    return this.mEndTime - this.mStartTime;
  }
  
  public final long getStartPositionMs()
  {
    return this.mStartPosition;
  }
  
  public final long getStartTimeMs()
  {
    return this.mStartTime;
  }
  
  public final String getUrl()
  {
    return null;
  }
  
  public final void setCutTimeRange(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220096);
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    if (l >= paramLong2)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
      AppMethodBeat.o(220096);
      throw localIllegalArgumentException;
    }
    this.mStartTime = l;
    this.mEndTime = paramLong2;
    AppMethodBeat.o(220096);
  }
  
  public final void setOriginalDurationMs(long paramLong) {}
  
  public final void setStartPositionMs(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */