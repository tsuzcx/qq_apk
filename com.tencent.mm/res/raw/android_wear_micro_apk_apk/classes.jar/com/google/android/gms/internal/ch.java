package com.google.android.gms.internal;

import android.content.Context;

public final class ch
{
  private static ch RV = new ch();
  private cg Np = null;
  
  /* Error */
  private cg u(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/google/android/gms/internal/ch:Np	Lcom/google/android/gms/internal/cg;
    //   6: ifnonnull +22 -> 28
    //   9: aload_1
    //   10: invokevirtual 27	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   13: ifnonnull +24 -> 37
    //   16: aload_0
    //   17: new 29	com/google/android/gms/internal/cg
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 32	com/google/android/gms/internal/cg:<init>	(Landroid/content/Context;)V
    //   25: putfield 19	com/google/android/gms/internal/ch:Np	Lcom/google/android/gms/internal/cg;
    //   28: aload_0
    //   29: getfield 19	com/google/android/gms/internal/ch:Np	Lcom/google/android/gms/internal/cg;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_1
    //   38: invokevirtual 27	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   41: astore_1
    //   42: goto -26 -> 16
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ch
    //   0	50	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	16	45	finally
    //   16	28	45	finally
    //   28	33	45	finally
    //   37	42	45	finally
  }
  
  public static cg v(Context paramContext)
  {
    return RV.u(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ch
 * JD-Core Version:    0.7.0.1
 */