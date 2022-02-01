package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class m
  extends q<Boolean>
{
  public final Bundle Ly;
  public final int statusCode;
  
  protected m(l paraml, int paramInt, Bundle paramBundle)
  {
    super(paraml, Boolean.TRUE);
    this.statusCode = paramInt;
    this.Ly = paramBundle;
  }
  
  protected abstract void b(ConnectionResult paramConnectionResult);
  
  protected abstract boolean ht();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.m
 * JD-Core Version:    0.7.0.1
 */