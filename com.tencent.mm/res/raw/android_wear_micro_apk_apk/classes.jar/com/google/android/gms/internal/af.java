package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;

final class af
  implements r, s
{
  private af(aa paramaa) {}
  
  /* Error */
  public final void a(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/google/android/gms/internal/af:Pw	Lcom/google/android/gms/internal/aa;
    //   4: invokestatic 29	com/google/android/gms/internal/aa:c	(Lcom/google/android/gms/internal/aa;)Ljava/util/concurrent/locks/Lock;
    //   7: invokeinterface 34 1 0
    //   12: aload_0
    //   13: getfield 14	com/google/android/gms/internal/af:Pw	Lcom/google/android/gms/internal/aa;
    //   16: aload_1
    //   17: invokestatic 38	com/google/android/gms/internal/aa:b	(Lcom/google/android/gms/internal/aa;Lcom/google/android/gms/common/ConnectionResult;)Z
    //   20: ifeq +30 -> 50
    //   23: aload_0
    //   24: getfield 14	com/google/android/gms/internal/af:Pw	Lcom/google/android/gms/internal/aa;
    //   27: invokestatic 41	com/google/android/gms/internal/aa:i	(Lcom/google/android/gms/internal/aa;)V
    //   30: aload_0
    //   31: getfield 14	com/google/android/gms/internal/af:Pw	Lcom/google/android/gms/internal/aa;
    //   34: invokestatic 44	com/google/android/gms/internal/aa:j	(Lcom/google/android/gms/internal/aa;)V
    //   37: aload_0
    //   38: getfield 14	com/google/android/gms/internal/af:Pw	Lcom/google/android/gms/internal/aa;
    //   41: invokestatic 29	com/google/android/gms/internal/aa:c	(Lcom/google/android/gms/internal/aa;)Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 47 1 0
    //   49: return
    //   50: aload_0
    //   51: getfield 14	com/google/android/gms/internal/af:Pw	Lcom/google/android/gms/internal/aa;
    //   54: aload_1
    //   55: invokestatic 50	com/google/android/gms/internal/aa:a	(Lcom/google/android/gms/internal/aa;Lcom/google/android/gms/common/ConnectionResult;)V
    //   58: goto -21 -> 37
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 14	com/google/android/gms/internal/af:Pw	Lcom/google/android/gms/internal/aa;
    //   66: invokestatic 29	com/google/android/gms/internal/aa:c	(Lcom/google/android/gms/internal/aa;)Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 47 1 0
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	af
    //   0	76	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    // Exception table:
    //   from	to	target	type
    //   12	37	61	finally
    //   50	58	61	finally
  }
  
  public final void bx(int paramInt) {}
  
  public final void h(Bundle paramBundle)
  {
    aa.f(this.Pw).a(new ae(this.Pw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.af
 * JD-Core Version:    0.7.0.1
 */