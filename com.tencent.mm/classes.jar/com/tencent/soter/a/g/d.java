package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.e;

public abstract class d
{
  public b JXG;
  boolean JXq = false;
  
  abstract void b(e parame);
  
  /* Error */
  final void c(final e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/soter/a/g/d:JXq	Z
    //   6: ifeq +17 -> 23
    //   9: ldc 22
    //   11: ldc 24
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 30	com/tencent/soter/core/c/d:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 32	com/tencent/soter/a/g/d:b	(Lcom/tencent/soter/a/b/e;)V
    //   28: invokestatic 38	com/tencent/soter/a/g/f:fDM	()Lcom/tencent/soter/a/g/f;
    //   31: astore_2
    //   32: ldc 40
    //   34: ldc 42
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: invokevirtual 46	java/lang/Object:hashCode	()I
    //   46: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: invokestatic 55	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_2
    //   54: getfield 59	com/tencent/soter/a/g/f:JXS	Ljava/lang/Object;
    //   57: astore_2
    //   58: aload_2
    //   59: monitorenter
    //   60: getstatic 63	com/tencent/soter/a/g/f:JXR	Landroid/util/SparseArray;
    //   63: aload_0
    //   64: invokevirtual 46	java/lang/Object:hashCode	()I
    //   67: invokevirtual 69	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   70: ifnonnull +49 -> 119
    //   73: ldc 40
    //   75: ldc 71
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: invokevirtual 46	java/lang/Object:hashCode	()I
    //   87: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 55	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_2
    //   95: monitorexit
    //   96: invokestatic 77	com/tencent/soter/a/g/g:fDP	()Lcom/tencent/soter/a/g/g;
    //   99: new 6	com/tencent/soter/a/g/d$1
    //   102: dup
    //   103: aload_0
    //   104: aload_1
    //   105: invokespecial 80	com/tencent/soter/a/g/d$1:<init>	(Lcom/tencent/soter/a/g/d;Lcom/tencent/soter/a/b/e;)V
    //   108: invokevirtual 84	com/tencent/soter/a/g/g:f	(Ljava/lang/Runnable;)V
    //   111: goto -91 -> 20
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    //   119: getstatic 63	com/tencent/soter/a/g/f:JXR	Landroid/util/SparseArray;
    //   122: aload_0
    //   123: invokevirtual 46	java/lang/Object:hashCode	()I
    //   126: invokevirtual 88	android/util/SparseArray:remove	(I)V
    //   129: goto -35 -> 94
    //   132: astore_1
    //   133: aload_2
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	d
    //   0	137	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	20	114	finally
    //   23	60	114	finally
    //   96	111	114	finally
    //   135	137	114	finally
    //   60	94	132	finally
    //   94	96	132	finally
    //   119	129	132	finally
    //   133	135	132	finally
  }
  
  abstract void execute();
  
  abstract boolean fDK();
  
  abstract void fDL();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.d
 * JD-Core Version:    0.7.0.1
 */