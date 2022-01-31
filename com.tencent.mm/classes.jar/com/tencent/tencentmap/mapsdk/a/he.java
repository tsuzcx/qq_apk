package com.tencent.tencentmap.mapsdk.a;

final class he
  implements Runnable
{
  he(gy paramgy) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 24	com/tencent/tencentmap/mapsdk/a/ey:e	()V
    //   3: invokestatic 28	com/tencent/tencentmap/mapsdk/a/ey:b	()Ljava/lang/String;
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 12	com/tencent/tencentmap/mapsdk/a/he:a	Lcom/tencent/tencentmap/mapsdk/a/gy;
    //   12: aload 4
    //   14: invokestatic 33	com/tencent/tencentmap/mapsdk/a/gy:a	(Lcom/tencent/tencentmap/mapsdk/a/gy;Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/a/gy$a;
    //   17: astore 4
    //   19: invokestatic 39	android/os/SystemClock:elapsedRealtime	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: getfield 12	com/tencent/tencentmap/mapsdk/a/he:a	Lcom/tencent/tencentmap/mapsdk/a/gy;
    //   27: aload 4
    //   29: getfield 44	com/tencent/tencentmap/mapsdk/a/gy$a:b	I
    //   32: invokestatic 47	com/tencent/tencentmap/mapsdk/a/gy:a	(Lcom/tencent/tencentmap/mapsdk/a/gy;I)I
    //   35: istore_1
    //   36: lload_2
    //   37: aload 4
    //   39: getfield 50	com/tencent/tencentmap/mapsdk/a/gy$a:a	J
    //   42: lsub
    //   43: iload_1
    //   44: i2l
    //   45: lcmp
    //   46: ifgt +13 -> 59
    //   49: lload_2
    //   50: aload 4
    //   52: getfield 50	com/tencent/tencentmap/mapsdk/a/gy$a:a	J
    //   55: lcmp
    //   56: ifge +43 -> 99
    //   59: iconst_2
    //   60: invokestatic 53	com/tencent/tencentmap/mapsdk/a/gy:b	(I)I
    //   63: pop
    //   64: aload_0
    //   65: getfield 12	com/tencent/tencentmap/mapsdk/a/he:a	Lcom/tencent/tencentmap/mapsdk/a/gy;
    //   68: invokestatic 57	com/tencent/tencentmap/mapsdk/a/gy:c	(Lcom/tencent/tencentmap/mapsdk/a/gy;)Landroid/os/Handler;
    //   71: aload_0
    //   72: getfield 12	com/tencent/tencentmap/mapsdk/a/he:a	Lcom/tencent/tencentmap/mapsdk/a/gy;
    //   75: invokestatic 60	com/tencent/tencentmap/mapsdk/a/gy:b	(Lcom/tencent/tencentmap/mapsdk/a/gy;)Ljava/lang/Runnable;
    //   78: invokevirtual 66	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   81: aload_0
    //   82: getfield 12	com/tencent/tencentmap/mapsdk/a/he:a	Lcom/tencent/tencentmap/mapsdk/a/gy;
    //   85: invokestatic 57	com/tencent/tencentmap/mapsdk/a/gy:c	(Lcom/tencent/tencentmap/mapsdk/a/gy;)Landroid/os/Handler;
    //   88: aload_0
    //   89: getfield 12	com/tencent/tencentmap/mapsdk/a/he:a	Lcom/tencent/tencentmap/mapsdk/a/gy;
    //   92: invokestatic 60	com/tencent/tencentmap/mapsdk/a/gy:b	(Lcom/tencent/tencentmap/mapsdk/a/gy;)Ljava/lang/Runnable;
    //   95: invokevirtual 70	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   98: pop
    //   99: return
    //   100: astore 4
    //   102: aload 4
    //   104: athrow
    //   105: astore 4
    //   107: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	he
    //   35	9	1	i	int
    //   22	28	2	l	long
    //   6	45	4	localObject1	Object
    //   100	3	4	localObject2	Object
    //   105	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	59	100	finally
    //   59	99	100	finally
    //   0	59	105	java/lang/Throwable
    //   59	99	105	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.he
 * JD-Core Version:    0.7.0.1
 */