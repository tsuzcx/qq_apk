package com.google.android.gms.common.internal;

import java.util.ArrayList;

public abstract class q<TListener>
{
  private TListener LA;
  private boolean LB;
  
  public q(TListener paramTListener)
  {
    Object localObject;
    this.LA = localObject;
    this.LB = false;
  }
  
  protected abstract void E(TListener paramTListener);
  
  /* Error */
  public final void hu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/google/android/gms/common/internal/q:LA	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 23	com/google/android/gms/common/internal/q:LB	Z
    //   11: ifeq +48 -> 59
    //   14: aload_0
    //   15: invokestatic 37	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore_2
    //   19: ldc 39
    //   21: new 41	java/lang/StringBuilder
    //   24: dup
    //   25: aload_2
    //   26: invokestatic 37	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 45	java/lang/String:length	()I
    //   32: bipush 47
    //   34: iadd
    //   35: invokespecial 48	java/lang/StringBuilder:<init>	(I)V
    //   38: ldc 50
    //   40: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 56
    //   49: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 66	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: ifnull +8 -> 70
    //   65: aload_0
    //   66: aload_1
    //   67: invokevirtual 68	com/google/android/gms/common/internal/q:E	(Ljava/lang/Object;)V
    //   70: aload_0
    //   71: monitorenter
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 23	com/google/android/gms/common/internal/q:LB	Z
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_0
    //   80: invokevirtual 71	com/google/android/gms/common/internal/q:unregister	()V
    //   83: return
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: astore_1
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	q
    //   6	61	1	localObject1	Object
    //   84	4	1	localObject2	Object
    //   89	2	1	localRuntimeException	java.lang.RuntimeException
    //   92	4	1	localObject3	Object
    //   18	26	2	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	59	84	finally
    //   59	61	84	finally
    //   85	87	84	finally
    //   65	70	89	java/lang/RuntimeException
    //   72	79	92	finally
    //   93	95	92	finally
  }
  
  public final void hv()
  {
    try
    {
      this.LA = null;
      return;
    }
    finally {}
  }
  
  public final void unregister()
  {
    hv();
    synchronized (l.c(this.Lz))
    {
      l.c(this.Lz).remove(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.q
 * JD-Core Version:    0.7.0.1
 */