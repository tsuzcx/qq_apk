package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.l;

public final class i<T extends IInterface>
  extends ac<T>
{
  private final l<T> Jl;
  
  protected final T e(IBinder paramIBinder)
  {
    return this.Jl.gx();
  }
  
  protected final String gv()
  {
    return this.Jl.gv();
  }
  
  protected final String gw()
  {
    return this.Jl.gw();
  }
  
  public final l<T> hc()
  {
    return this.Jl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.i
 * JD-Core Version:    0.7.0.1
 */