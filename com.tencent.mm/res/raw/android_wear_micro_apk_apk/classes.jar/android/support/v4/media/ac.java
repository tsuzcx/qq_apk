package android.support.v4.media;

import android.os.Bundle;

public class ac<T>
{
  private int df;
  private final Object hh;
  private boolean hi;
  private boolean hj;
  private boolean hk;
  
  ac(Object paramObject)
  {
    this.hh = paramObject;
  }
  
  public final void aL()
  {
    if ((this.hj) || (this.hk)) {
      throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.hh);
    }
    this.hj = true;
    b(null);
  }
  
  public final void aM()
  {
    if ((this.hj) || (this.hk)) {
      throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.hh);
    }
    this.hk = true;
    e(null);
  }
  
  void b(T paramT) {}
  
  void e(Bundle paramBundle)
  {
    throw new UnsupportedOperationException("It is not supported to send an error for " + this.hh);
  }
  
  final int getFlags()
  {
    return this.df;
  }
  
  final boolean isDone()
  {
    return (this.hi) || (this.hj) || (this.hk);
  }
  
  final void setFlags(int paramInt)
  {
    this.df = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.ac
 * JD-Core Version:    0.7.0.1
 */