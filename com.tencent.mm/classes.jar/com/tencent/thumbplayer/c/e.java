package com.tencent.thumbplayer.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public final class e
  implements ITPMediaTrackClip, Serializable
{
  public String ahGJ;
  private long ahGK;
  private int ahGu;
  private int ahGv;
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
    AppMethodBeat.i(226979);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("TPMediaCompositionTrackClip : clipPath empty");
      AppMethodBeat.o(226979);
      throw paramString;
    }
    this.ahGu = paramInt;
    this.ahGJ = paramString;
    this.mStartTime = paramLong1;
    this.mEndTime = paramLong2;
    if (this.mStartTime < 0L) {
      this.mStartTime = 0L;
    }
    if (this.mEndTime <= 0L) {
      this.mEndTime = getOriginalDurationMs();
    }
    this.ahGv = c.aHM(this.ahGu);
    AppMethodBeat.o(226979);
  }
  
  public final ITPMediaTrackClip clone(int paramInt)
  {
    AppMethodBeat.i(227056);
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 1))
    {
      AppMethodBeat.o(227056);
      return null;
    }
    e locale = new e();
    locale.ahGu = paramInt;
    locale.ahGv = c.aHM(this.ahGu);
    locale.mStartTime = this.mStartTime;
    locale.mEndTime = this.mEndTime;
    locale.ahGJ = this.ahGJ;
    AppMethodBeat.o(227056);
    return locale;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(227045);
    if (paramObject == null)
    {
      AppMethodBeat.o(227045);
      return false;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(227045);
      return false;
    }
    if ((this.ahGv == ((e)paramObject).getClipId()) && (this.ahGu == ((e)paramObject).getMediaType()))
    {
      AppMethodBeat.o(227045);
      return true;
    }
    AppMethodBeat.o(227045);
    return false;
  }
  
  public final int getClipId()
  {
    return this.ahGv;
  }
  
  public final long getEndTimeMs()
  {
    return this.mEndTime;
  }
  
  public final String getFilePath()
  {
    return this.ahGJ;
  }
  
  public final int getMediaType()
  {
    return this.ahGu;
  }
  
  public final long getOriginalDurationMs()
  {
    return this.ahGK;
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
    return this.ahGJ;
  }
  
  public final void setCutTimeRange(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(226991);
    IllegalArgumentException localIllegalArgumentException;
    if (paramLong1 >= getOriginalDurationMs())
    {
      localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
      AppMethodBeat.o(226991);
      throw localIllegalArgumentException;
    }
    if (paramLong2 > getOriginalDurationMs())
    {
      localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
      AppMethodBeat.o(226991);
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
      AppMethodBeat.o(226991);
      throw localIllegalArgumentException;
    }
    this.mStartTime = l;
    this.mEndTime = paramLong1;
    AppMethodBeat.o(226991);
  }
  
  public final void setOriginalDurationMs(long paramLong)
  {
    this.ahGK = paramLong;
  }
  
  public final void setStartPositionMs(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.c.e
 * JD-Core Version:    0.7.0.1
 */