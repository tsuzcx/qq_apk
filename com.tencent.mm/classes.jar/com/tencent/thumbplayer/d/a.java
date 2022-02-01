package com.tencent.thumbplayer.d;

import com.tencent.thumbplayer.b.a.e;
import java.io.Serializable;

public final class a
  implements e, Serializable
{
  private int KgM;
  private int KgN;
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
    if (!(paramObject instanceof a)) {
      return false;
    }
    return (this.KgN == ((a)paramObject).KgN) && (this.KgM == ((a)paramObject).KgM);
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
    return this.mEndTime - this.mStartTime;
  }
  
  public final long fFt()
  {
    return this.mStartPosition;
  }
  
  public final String getFilePath()
  {
    return null;
  }
  
  public final int getMediaType()
  {
    return this.KgM;
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