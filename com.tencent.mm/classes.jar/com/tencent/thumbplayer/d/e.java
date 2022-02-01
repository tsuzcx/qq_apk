package com.tencent.thumbplayer.d;

import java.io.Serializable;

public final class e
  implements com.tencent.thumbplayer.b.a.e, Serializable
{
  private int KgM;
  private int KgN;
  public String Khb;
  private long Khc;
  private long mEndTime;
  private long mStartPosition;
  private long mStartTime;
  
  public final void BX(long paramLong)
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
    return (this.KgN == ((e)paramObject).KgN) && (this.KgM == ((e)paramObject).KgM);
  }
  
  public final int fFp()
  {
    return this.KgN;
  }
  
  public final long fFq()
  {
    return this.mStartTime;
  }
  
  public final long fFr()
  {
    return this.mEndTime;
  }
  
  public final long fFs()
  {
    return this.Khc;
  }
  
  public final long fFt()
  {
    return this.mStartPosition;
  }
  
  public final String getFilePath()
  {
    return this.Khb;
  }
  
  public final int getMediaType()
  {
    return this.KgM;
  }
  
  public final String getUrl()
  {
    return this.Khb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.d.e
 * JD-Core Version:    0.7.0.1
 */