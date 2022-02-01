package com.tencent.thumbplayer.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public final class e
  implements ITPMediaTrackClip, Serializable
{
  private int RYH;
  private int RYI;
  public String RYW;
  private long RYX;
  private long mEndTime;
  private long mStartPosition;
  private long mStartTime;
  
  private e() {}
  
  public e(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0L, -1L);
  }
  
  public e(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189130);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("TPMediaCompositionTrackClip : clipPath empty");
      AppMethodBeat.o(189130);
      throw paramString;
    }
    this.RYH = paramInt;
    this.RYW = paramString;
    this.mStartTime = paramLong1;
    this.mEndTime = paramLong2;
    if (this.mStartTime < 0L) {
      this.mStartTime = 0L;
    }
    if (this.mEndTime <= 0L) {
      this.mEndTime = getOriginalDurationMs();
    }
    this.RYI = c.arm(this.RYH);
    AppMethodBeat.o(189130);
  }
  
  public final ITPMediaTrackClip clone(int paramInt)
  {
    AppMethodBeat.i(189133);
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 1))
    {
      AppMethodBeat.o(189133);
      return null;
    }
    e locale = new e();
    locale.RYH = paramInt;
    locale.RYI = c.arm(this.RYH);
    locale.mStartTime = this.mStartTime;
    locale.mEndTime = this.mEndTime;
    locale.RYW = this.RYW;
    AppMethodBeat.o(189133);
    return locale;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189132);
    if (paramObject == null)
    {
      AppMethodBeat.o(189132);
      return false;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(189132);
      return false;
    }
    if ((this.RYI == ((e)paramObject).getClipId()) && (this.RYH == ((e)paramObject).getMediaType()))
    {
      AppMethodBeat.o(189132);
      return true;
    }
    AppMethodBeat.o(189132);
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
    return this.RYW;
  }
  
  public final int getMediaType()
  {
    return this.RYH;
  }
  
  public final long getOriginalDurationMs()
  {
    return this.RYX;
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
    return this.RYW;
  }
  
  public final void setCutTimeRange(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189131);
    IllegalArgumentException localIllegalArgumentException;
    if (paramLong1 >= getOriginalDurationMs())
    {
      localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
      AppMethodBeat.o(189131);
      throw localIllegalArgumentException;
    }
    if (paramLong2 > getOriginalDurationMs())
    {
      localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
      AppMethodBeat.o(189131);
      throw localIllegalArgumentException;
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    paramLong1 = paramLong2;
    if (paramLong2 <= 0L) {
      paramLong1 = getOriginalDurationMs();
    }
    if (l >= paramLong1)
    {
      localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
      AppMethodBeat.o(189131);
      throw localIllegalArgumentException;
    }
    this.mStartTime = l;
    this.mEndTime = paramLong1;
    AppMethodBeat.o(189131);
  }
  
  public final void setOriginalDurationMs(long paramLong)
  {
    this.RYX = paramLong;
  }
  
  public final void setStartPositionMs(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.e
 * JD-Core Version:    0.7.0.1
 */