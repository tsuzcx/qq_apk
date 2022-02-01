package com.tencent.xweb.b;

public final class g
{
  static f MPD = null;
  
  /* Error */
  static f ggb()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 14
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 10	com/tencent/xweb/b/g:MPD	Lcom/tencent/xweb/b/f;
    //   11: ifnonnull +21 -> 32
    //   14: new 22	com/tencent/xweb/b/c
    //   17: dup
    //   18: invokespecial 25	com/tencent/xweb/b/c:<init>	()V
    //   21: astore_0
    //   22: ldc 14
    //   24: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: getstatic 10	com/tencent/xweb/b/g:MPD	Lcom/tencent/xweb/b/f;
    //   35: astore_0
    //   36: ldc 14
    //   38: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -14 -> 27
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	15	0	localObject1	Object
    //   44	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	27	44	finally
    //   32	41	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.b.g
 * JD-Core Version:    0.7.0.1
 */