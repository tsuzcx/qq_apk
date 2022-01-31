package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class s
  extends ar
{
  private l JN;
  private final int JO;
  
  public s(l paraml, int paramInt)
  {
    this.JN = paraml;
    this.JO = paramInt;
  }
  
  public final void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    d.e(this.JN, "onPostInitComplete can be called only once per call to getRemoteService");
    this.JN.a(paramInt, paramIBinder, paramBundle, this.JO);
    this.JN = null;
  }
  
  public final void b(int paramInt, Bundle paramBundle)
  {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.s
 * JD-Core Version:    0.7.0.1
 */