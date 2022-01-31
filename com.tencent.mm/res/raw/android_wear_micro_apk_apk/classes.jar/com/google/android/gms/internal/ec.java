package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

public final class ec<A extends g<? extends com.google.android.gms.common.api.w, com.google.android.gms.common.api.g>>
  extends ea
{
  protected final A RQ;
  
  public ec(int paramInt, A paramA)
  {
    super(paramInt);
    this.RQ = paramA;
  }
  
  public final void a(w paramw, boolean paramBoolean)
  {
    paramw.a(this.RQ, paramBoolean);
  }
  
  public final void c(ar<?> paramar)
  {
    this.RQ.a(paramar.io());
  }
  
  public final void i(Status paramStatus)
  {
    this.RQ.a(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ec
 * JD-Core Version:    0.7.0.1
 */