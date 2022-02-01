package com.google.android.gms.internal;

import com.google.android.gms.common.api.a;

public final class ef<O extends com.google.android.gms.common.api.b>
{
  private final a<O> JJ;
  private final O JK;
  private final boolean TH = true;
  private final int TI;
  
  private ef(a<O> parama)
  {
    this.JJ = parama;
    this.JK = null;
    this.TI = System.identityHashCode(this);
  }
  
  public static <O extends com.google.android.gms.common.api.b> ef<O> b(a<O> parama)
  {
    return new ef(parama);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ef)) {
        return false;
      }
      paramObject = (ef)paramObject;
    } while ((!this.TH) && (!paramObject.TH) && (com.google.android.gms.common.internal.b.c(this.JJ, paramObject.JJ)) && (com.google.android.gms.common.internal.b.c(this.JK, paramObject.JK)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.TI;
  }
  
  public final String kt()
  {
    return this.JJ.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ef
 * JD-Core Version:    0.7.0.1
 */