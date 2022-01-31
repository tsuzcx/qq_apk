package com.tencent.soter.a.g;

import com.tencent.soter.a.b.b;

public abstract class d
{
  boolean Bnh = false;
  public b Bnw;
  
  /* Error */
  final void b(com.tencent.soter.a.b.e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/tencent/soter/a/g/d:Bnh	Z
    //   6: ifeq +17 -> 23
    //   9: ldc 19
    //   11: ldc 21
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 27	com/tencent/soter/core/c/d:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 33	com/tencent/soter/a/g/f:dVD	()Lcom/tencent/soter/a/g/f;
    //   26: astore_2
    //   27: ldc 35
    //   29: ldc 37
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: invokevirtual 41	java/lang/Object:hashCode	()I
    //   41: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aastore
    //   45: invokestatic 50	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload_2
    //   49: getfield 54	com/tencent/soter/a/g/f:BnH	Ljava/lang/Object;
    //   52: astore_2
    //   53: aload_2
    //   54: monitorenter
    //   55: getstatic 58	com/tencent/soter/a/g/f:BnG	Landroid/util/SparseArray;
    //   58: aload_0
    //   59: invokevirtual 41	java/lang/Object:hashCode	()I
    //   62: invokevirtual 64	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   65: ifnonnull +49 -> 114
    //   68: ldc 35
    //   70: ldc 66
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_0
    //   79: invokevirtual 41	java/lang/Object:hashCode	()I
    //   82: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: invokestatic 50	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_2
    //   90: monitorexit
    //   91: invokestatic 72	com/tencent/soter/a/g/g:dVG	()Lcom/tencent/soter/a/g/g;
    //   94: new 74	com/tencent/soter/a/g/d$1
    //   97: dup
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 77	com/tencent/soter/a/g/d$1:<init>	(Lcom/tencent/soter/a/g/d;Lcom/tencent/soter/a/b/e;)V
    //   103: invokevirtual 81	com/tencent/soter/a/g/g:d	(Ljava/lang/Runnable;)V
    //   106: goto -86 -> 20
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic 58	com/tencent/soter/a/g/f:BnG	Landroid/util/SparseArray;
    //   117: aload_0
    //   118: invokevirtual 41	java/lang/Object:hashCode	()I
    //   121: invokevirtual 85	android/util/SparseArray:remove	(I)V
    //   124: goto -35 -> 89
    //   127: astore_1
    //   128: aload_2
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	d
    //   0	132	1	parame	com.tencent.soter.a.b.e
    // Exception table:
    //   from	to	target	type
    //   2	20	109	finally
    //   23	55	109	finally
    //   91	106	109	finally
    //   130	132	109	finally
    //   55	89	127	finally
    //   89	91	127	finally
    //   114	124	127	finally
    //   128	130	127	finally
  }
  
  abstract boolean dVB();
  
  abstract void dVC();
  
  abstract void execute();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.a.g.d
 * JD-Core Version:    0.7.0.1
 */