package com.tencent.thumbplayer.d;

import com.tencent.thumbplayer.b.a.e;
import java.io.Serializable;

public final class a
  implements e, Serializable
{
  private int MwX;
  private int MwY;
  private long mEndTime;
  private long mStartPosition;
  private long mStartTime;
  
  public final void FB(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    return (this.MwY == ((a)paramObject).MwY) && (this.MwX == ((a)paramObject).MwX);
  }
  
  public final long evQ()
  {
    return this.mStartTime;
  }
  
  public final long evR()
  {
    return this.mEndTime;
  }
  
  public final int gbf()
  {
    return this.MwY;
  }
  
  public final long gbg()
  {
    return this.mEndTime - this.mStartTime;
  }
  
  public final long gbh()
  {
    return this.mStartPosition;
  }
  
  public final String getFilePath()
  {
    return null;
  }
  
  public final int getMediaType()
  {
    return this.MwX;
  }
  
  public final String getUrl()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.a
 * JD-Core Version:    0.7.0.1
 */