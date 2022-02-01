package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.s;

final class b
  implements s
{
  public final int NN;
  public final p NO;
  public final s NP;
  
  public b(a parama, int paramInt, p paramp, s params)
  {
    this.NN = paramInt;
    this.NO = paramp;
    this.NP = params;
    paramp.a(this);
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    String str = String.valueOf(paramConnectionResult);
    Log.d("AutoManageHelper", String.valueOf(str).length() + 27 + "beginFailureResolution for " + str);
    this.NQ.b(paramConnectionResult, this.NN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.b
 * JD-Core Version:    0.7.0.1
 */