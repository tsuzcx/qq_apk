package com.tencent.thumbplayer.d;

import java.io.Serializable;

public final class e
  implements com.tencent.thumbplayer.b.a.e, Serializable
{
  private int Mac;
  private int Mad;
  public String Mar;
  private long Mas;
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
    if (!(paramObject instanceof e)) {
      return false;
    }
    return (this.Mad == ((e)paramObject).Mad) && (this.Mac == ((e)paramObject).Mac);
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
    return this.Mas;
  }
  
  public final long fWI()
  {
    return this.mStartPosition;
  }
  
  public final String getFilePath()
  {
    return this.Mar;
  }
  
  public final int getMediaType()
  {
    return this.Mac;
  }
  
  public final String getUrl()
  {
    return this.Mar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.e
 * JD-Core Version:    0.7.0.1
 */