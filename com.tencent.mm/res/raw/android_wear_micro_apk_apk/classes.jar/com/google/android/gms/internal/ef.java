package com.google.android.gms.internal;

import com.google.android.gms.common.api.a;

public final class ef<O extends com.google.android.gms.common.api.b>
{
  private final a<O> HU;
  private final O HV;
  private final boolean RS = true;
  private final int RT;
  
  private ef(a<O> parama)
  {
    this.HU = parama;
    this.HV = null;
    this.RT = System.identityHashCode(this);
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
    } while ((!this.RS) && (!paramObject.RS) && (com.google.android.gms.common.internal.b.b(this.HU, paramObject.HU)) && (com.google.android.gms.common.internal.b.b(this.HV, paramObject.HV)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.RT;
  }
  
  public final String kk()
  {
    return this.HU.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ef
 * JD-Core Version:    0.7.0.1
 */