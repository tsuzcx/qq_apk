package android.support.v4.media;

import android.os.Bundle;

public class ac<T>
{
  private int eT;
  private final Object jg;
  private boolean jh;
  private boolean ji;
  private boolean jj;
  
  ac(Object paramObject)
  {
    this.jg = paramObject;
  }
  
  public final void bb()
  {
    if ((this.ji) || (this.jj)) {
      throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.jg);
    }
    this.ji = true;
    h(null);
  }
  
  public final void bc()
  {
    if ((this.ji) || (this.jj)) {
      throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.jg);
    }
    this.jj = true;
    e(null);
  }
  
  void e(Bundle paramBundle)
  {
    throw new UnsupportedOperationException("It is not supported to send an error for " + this.jg);
  }
  
  final int getFlags()
  {
    return this.eT;
  }
  
  void h(T paramT) {}
  
  final boolean isDone()
  {
    return (this.jh) || (this.ji) || (this.jj);
  }
  
  final void setFlags(int paramInt)
  {
    this.eT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.ac
 * JD-Core Version:    0.7.0.1
 */