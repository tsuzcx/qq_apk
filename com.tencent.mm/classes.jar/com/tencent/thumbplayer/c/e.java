package com.tencent.thumbplayer.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public final class e
  implements ITPMediaTrackClip, Serializable
{
  public String ZBG;
  private long ZBH;
  private int ZBr;
  private int ZBs;
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
    AppMethodBeat.i(220179);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("TPMediaCompositionTrackClip : clipPath empty");
      AppMethodBeat.o(220179);
      throw paramString;
    }
    this.ZBr = paramInt;
    this.ZBG = paramString;
    this.mStartTime = paramLong1;
    this.mEndTime = paramLong2;
    if (this.mStartTime < 0L) {
      this.mStartTime = 0L;
    }
    if (this.mEndTime <= 0L) {
      this.mEndTime = getOriginalDurationMs();
    }
    this.ZBs = c.aAZ(this.ZBr);
    AppMethodBeat.o(220179);
  }
  
  public final ITPMediaTrackClip clone(int paramInt)
  {
    AppMethodBeat.i(220201);
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 1))
    {
      AppMethodBeat.o(220201);
      return null;
    }
    e locale = new e();
    locale.ZBr = paramInt;
    locale.ZBs = c.aAZ(this.ZBr);
    locale.mStartTime = this.mStartTime;
    locale.mEndTime = this.mEndTime;
    locale.ZBG = this.ZBG;
    AppMethodBeat.o(220201);
    return locale;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220199);
    if (paramObject == null)
    {
      AppMethodBeat.o(220199);
      return false;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(220199);
      return false;
    }
    if ((this.ZBs == ((e)paramObject).getClipId()) && (this.ZBr == ((e)paramObject).getMediaType()))
    {
      AppMethodBeat.o(220199);
      return true;
    }
    AppMethodBeat.o(220199);
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
    return this.ZBG;
  }
  
  public final int getMediaType()
  {
    return this.ZBr;
  }
  
  public final long getOriginalDurationMs()
  {
    return this.ZBH;
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
    return this.ZBG;
  }
  
  public final void setCutTimeRange(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220185);
    IllegalArgumentException localIllegalArgumentException;
    if (paramLong1 >= getOriginalDurationMs())
    {
      localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
      AppMethodBeat.o(220185);
      throw localIllegalArgumentException;
    }
    if (paramLong2 > getOriginalDurationMs())
    {
      localIllegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
      AppMethodBeat.o(220185);
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
      AppMethodBeat.o(220185);
      throw localIllegalArgumentException;
    }
    this.mStartTime = l;
    this.mEndTime = paramLong1;
    AppMethodBeat.o(220185);
  }
  
  public final void setOriginalDurationMs(long paramLong)
  {
    this.ZBH = paramLong;
  }
  
  public final void setStartPositionMs(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.c.e
 * JD-Core Version:    0.7.0.1
 */