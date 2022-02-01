package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class w
  extends m
{
  public w(l paraml, int paramInt, Bundle paramBundle)
  {
    super(paraml, paramInt, null);
  }
  
  protected final void b(ConnectionResult paramConnectionResult)
  {
    this.Lz.Ln.c(paramConnectionResult);
    this.Lz.a(paramConnectionResult);
  }
  
  protected final boolean ht()
  {
    this.Lz.Ln.c(ConnectionResult.IQ);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.w
 * JD-Core Version:    0.7.0.1
 */