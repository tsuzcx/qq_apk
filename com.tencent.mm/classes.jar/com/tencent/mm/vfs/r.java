package com.tencent.mm.vfs;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"forEachLine", "", "Lcom/tencent/mm/vfs/VFSFile;", "charset", "Ljava/nio/charset/Charset;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "readText", "reader", "Ljava/io/InputStreamReader;", "writeBytes", "array", "", "writeText", "text", "mmkernel_release"})
public final class r
{
  /* Error */
  private static java.lang.String a(q paramq, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 36
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 44
    //   10: invokestatic 50	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 51
    //   16: invokestatic 50	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: ldc 53
    //   22: invokestatic 50	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   25: aload_1
    //   26: ldc 51
    //   28: invokestatic 50	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload_0
    //   32: invokestatic 59	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   35: astore_0
    //   36: aload_0
    //   37: ldc 61
    //   39: invokestatic 64	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: new 66	java/io/InputStreamReader
    //   45: dup
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 70	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   51: checkcast 72	java/io/Closeable
    //   54: astore_3
    //   55: aload_3
    //   56: checkcast 66	java/io/InputStreamReader
    //   59: checkcast 74	java/io/Reader
    //   62: invokestatic 79	kotlin/f/d:a	(Ljava/io/Reader;)Ljava/lang/String;
    //   65: astore_0
    //   66: aload_3
    //   67: aconst_null
    //   68: invokestatic 84	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   71: ldc 36
    //   73: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: areturn
    //   78: astore_1
    //   79: ldc 36
    //   81: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_1
    //   85: athrow
    //   86: astore_0
    //   87: aload_3
    //   88: aload_1
    //   89: invokestatic 84	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   92: ldc 36
    //   94: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: aload_2
    //   101: astore_1
    //   102: goto -15 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramq	q
    //   0	105	1	paramCharset	java.nio.charset.Charset
    //   1	100	2	localObject	Object
    //   54	34	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   55	66	78	java/lang/Throwable
    //   79	86	86	finally
    //   55	66	99	finally
  }
  
  /* Error */
  public static final void b(q paramq, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 101
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 103
    //   10: invokestatic 50	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 104
    //   16: invokestatic 50	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokestatic 108	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   23: checkcast 72	java/io/Closeable
    //   26: astore_3
    //   27: aload_3
    //   28: checkcast 110	java/io/OutputStream
    //   31: aload_1
    //   32: invokevirtual 114	java/io/OutputStream:write	([B)V
    //   35: getstatic 120	kotlin/x:aazN	Lkotlin/x;
    //   38: astore_0
    //   39: aload_3
    //   40: aconst_null
    //   41: invokestatic 84	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   44: ldc 101
    //   46: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: astore_1
    //   51: ldc 101
    //   53: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_1
    //   57: athrow
    //   58: astore_0
    //   59: aload_3
    //   60: aload_1
    //   61: invokestatic 84	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   64: ldc 101
    //   66: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_0
    //   70: athrow
    //   71: astore_0
    //   72: aload_2
    //   73: astore_1
    //   74: goto -15 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramq	q
    //   0	77	1	paramArrayOfByte	byte[]
    //   1	72	2	localObject	Object
    //   26	34	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   27	39	50	java/lang/Throwable
    //   51	58	58	finally
    //   27	39	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.r
 * JD-Core Version:    0.7.0.1
 */