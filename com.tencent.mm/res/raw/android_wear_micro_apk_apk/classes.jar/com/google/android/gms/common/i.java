package com.google.android.gms.common;

import android.content.Context;

final class i
{
  private static final Object Lm = new Object();
  private static Context Ln;
  
  /* Error */
  static void m(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/google/android/gms/common/i:Ln	Landroid/content/Context;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: invokevirtual 26	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: putstatic 20	com/google/android/gms/common/i:Ln	Landroid/content/Context;
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: ldc 28
    //   26: ldc 30
    //   28: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: goto -12 -> 20
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	9	35	finally
    //   13	20	35	finally
    //   24	32	35	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.i
 * JD-Core Version:    0.7.0.1
 */