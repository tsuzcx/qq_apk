package io.flutter.plugin.a;

final class k$b
  implements c.b
{
  private final k.d vCo;
  
  k$b(k paramk, k.d paramd)
  {
    this.vCo = paramd;
  }
  
  /* Error */
  public final void I(java.nio.ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: sipush 9866
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +19 -> 26
    //   10: aload_0
    //   11: getfield 22	io/flutter/plugin/a/k$b:vCo	Lio/flutter/plugin/a/k$d;
    //   14: invokeinterface 40 1 0
    //   19: sipush 9866
    //   22: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: return
    //   26: aload_0
    //   27: getfield 22	io/flutter/plugin/a/k$b:vCo	Lio/flutter/plugin/a/k$d;
    //   30: aload_0
    //   31: getfield 17	io/flutter/plugin/a/k$b:MFV	Lio/flutter/plugin/a/k;
    //   34: getfield 47	io/flutter/plugin/a/k:MFN	Lio/flutter/plugin/a/l;
    //   37: aload_1
    //   38: invokeinterface 53 2 0
    //   43: invokeinterface 57 2 0
    //   48: sipush 9866
    //   51: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore_1
    //   56: new 59	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 61
    //   62: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 17	io/flutter/plugin/a/k$b:MFV	Lio/flutter/plugin/a/k;
    //   69: getfield 68	io/flutter/plugin/a/k:name	Ljava/lang/String;
    //   72: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: sipush 9866
    //   79: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 22	io/flutter/plugin/a/k$b:vCo	Lio/flutter/plugin/a/k$d;
    //   88: aload_1
    //   89: getfield 75	io/flutter/plugin/a/e:code	Ljava/lang/String;
    //   92: aload_1
    //   93: invokevirtual 79	io/flutter/plugin/a/e:getMessage	()Ljava/lang/String;
    //   96: aload_1
    //   97: getfield 83	io/flutter/plugin/a/e:tjB	Ljava/lang/Object;
    //   100: invokeinterface 87 4 0
    //   105: sipush 9866
    //   108: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	b
    //   0	112	1	paramByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   10	25	55	java/lang/RuntimeException
    //   26	48	55	java/lang/RuntimeException
    //   48	54	55	java/lang/RuntimeException
    //   84	105	55	java/lang/RuntimeException
    //   26	48	83	io/flutter/plugin/a/e
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.a.k.b
 * JD-Core Version:    0.7.0.1
 */