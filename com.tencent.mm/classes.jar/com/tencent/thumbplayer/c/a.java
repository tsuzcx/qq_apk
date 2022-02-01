package com.tencent.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public final class a
  implements ITPMediaTrackClip, Serializable
{
  private int RYH;
  private int RYI;
  private long mEndTime;
  private long mStartPosition;
  private long mStartTime;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(189103);
    this.mStartTime = 0L;
    this.mEndTime = 0L;
    this.RYH = paramInt;
    this.RYI = c.arm(this.RYH);
    AppMethodBeat.o(189103);
  }
  
  public final ITPMediaTrackClip clone(int paramInt)
  {
    AppMethodBeat.i(189106);
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 1))
    {
      AppMethodBeat.o(189106);
      return null;
    }
    a locala = new a(paramInt);
    locala.RYI = c.arm(paramInt);
    locala.mStartTime = this.mStartTime;
    locala.mEndTime = this.mEndTime;
    AppMethodBeat.o(189106);
    return locala;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189105);
    if (paramObject == null)
    {
      AppMethodBeat.o(189105);
      return false;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(189105);
      return false;
    }
    if ((this.RYI == ((a)paramObject).getClipId()) && (this.RYH == ((a)paramObject).getMediaType()))
    {
      AppMethodBeat.o(189105);
      return true;
    }
    AppMethodBeat.o(189105);
    return false;
  }
  
  public final int getClipId()
  {
    return this.RYI;
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
    return this.RYH;
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
    AppMethodBeat.i(189104);
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    if (l >= paramLong2)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
      AppMethodBeat.o(189104);
      throw localIllegalArgumentException;
    }
    this.mStartTime = l;
    this.mEndTime = paramLong2;
    AppMethodBeat.o(189104);
  }
  
  public final void setOriginalDurationMs(long paramLong) {}
  
  public final void setStartPositionMs(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */