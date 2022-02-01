package com.tencent.thumbplayer.d;

import java.io.Serializable;

public final class e
  implements com.tencent.thumbplayer.b.a.e, Serializable
{
  private int MwX;
  private int MwY;
  public String Mxm;
  private long Mxn;
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
    if (!(paramObject instanceof e)) {
      return false;
    }
    return (this.MwY == ((e)paramObject).MwY) && (this.MwX == ((e)paramObject).MwX);
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
    return this.Mxn;
  }
  
  public final long gbh()
  {
    return this.mStartPosition;
  }
  
  public final String getFilePath()
  {
    return this.Mxm;
  }
  
  public final int getMediaType()
  {
    return this.MwX;
  }
  
  public final String getUrl()
  {
    return this.Mxm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.e
 * JD-Core Version:    0.7.0.1
 */