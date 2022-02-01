package com.tencent.thumbplayer.d;

import com.tencent.thumbplayer.b.a.e;
import java.io.Serializable;

public final class a
  implements e, Serializable
{
  private int Mac;
  private int Mad;
  private long mEndTime;
  private long mStartPosition;
  private long mStartTime;
  
  public final void EZ(long paramLong)
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
    return (this.Mad == ((a)paramObject).Mad) && (this.Mac == ((a)paramObject).Mac);
  }
  
  public final long esj()
  {
    return this.mStartTime;
  }
  
  public final long esk()
  {
    return this.mEndTime;
  }
  
  public final int fWG()
  {
    return this.Mad;
  }
  
  public final long fWH()
  {
    return this.mEndTime - this.mStartTime;
  }
  
  public final long fWI()
  {
    return this.mStartPosition;
  }
  
  public final String getFilePath()
  {
    return null;
  }
  
  public final int getMediaType()
  {
    return this.Mac;
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