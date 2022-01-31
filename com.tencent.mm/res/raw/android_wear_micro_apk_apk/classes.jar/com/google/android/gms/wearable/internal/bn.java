package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.h;

abstract class bn<T>
  extends a
{
  private h<T> TV;
  
  public bn(h<T> paramh)
  {
    this.TV = paramh;
  }
  
  public final void B(T paramT)
  {
    h localh = this.TV;
    if (localh != null)
    {
      localh.x(paramT);
      this.TV = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bn
 * JD-Core Version:    0.7.0.1
 */