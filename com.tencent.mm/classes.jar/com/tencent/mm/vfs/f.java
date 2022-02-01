package com.tencent.mm.vfs;

import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"forEachLine", "", "Lcom/tencent/mm/vfs/VFSFile;", "charset", "Ljava/nio/charset/Charset;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "readText", "reader", "Ljava/io/InputStreamReader;", "writeBytes", "array", "", "writeText", "text", "mmkernel_release"})
public final class f
{
  /* Error */
  private static java.lang.String a(e parame, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: ldc 36
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 44
    //   8: invokestatic 50	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 51
    //   14: invokestatic 50	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_0
    //   18: ldc 53
    //   20: invokestatic 50	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_1
    //   24: ldc 51
    //   26: invokestatic 50	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokestatic 59	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   33: astore_0
    //   34: aload_0
    //   35: ldc 61
    //   37: invokestatic 64	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   40: new 66	java/io/InputStreamReader
    //   43: dup
    //   44: aload_0
    //   45: aload_1
    //   46: invokespecial 70	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   49: checkcast 72	java/io/Closeable
    //   52: astore_2
    //   53: aload_2
    //   54: checkcast 66	java/io/InputStreamReader
    //   57: checkcast 74	java/io/Reader
    //   60: astore_0
    //   61: aload_0
    //   62: ldc 44
    //   64: invokestatic 50	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   67: new 76	java/io/StringWriter
    //   70: dup
    //   71: invokespecial 79	java/io/StringWriter:<init>	()V
    //   74: astore_1
    //   75: aload_0
    //   76: aload_1
    //   77: checkcast 81	java/io/Writer
    //   80: invokestatic 86	d/f/c:a	(Ljava/io/Reader;Ljava/io/Writer;)J
    //   83: pop2
    //   84: aload_1
    //   85: invokevirtual 90	java/io/StringWriter:toString	()Ljava/lang/String;
    //   88: astore_0
    //   89: aload_0
    //   90: ldc 92
    //   92: invokestatic 64	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   95: aload_2
    //   96: aconst_null
    //   97: invokestatic 97	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   100: ldc 36
    //   102: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_1
    //   108: ldc 36
    //   110: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: astore_0
    //   116: aload_2
    //   117: aload_1
    //   118: invokestatic 97	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 36
    //   123: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -15 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	parame	e
    //   0	134	1	paramCharset	java.nio.charset.Charset
    //   52	65	2	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   53	95	107	java/lang/Throwable
    //   108	115	115	finally
    //   53	95	128	finally
  }
  
  /* Error */
  public static final void b(e parame, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 114
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 116
    //   10: invokestatic 50	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 117
    //   16: invokestatic 50	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokestatic 121	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   23: checkcast 72	java/io/Closeable
    //   26: astore_3
    //   27: aload_3
    //   28: checkcast 123	java/io/OutputStream
    //   31: aload_1
    //   32: invokevirtual 127	java/io/OutputStream:write	([B)V
    //   35: getstatic 133	d/y:KTp	Ld/y;
    //   38: astore_0
    //   39: aload_3
    //   40: aconst_null
    //   41: invokestatic 97	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   44: ldc 114
    //   46: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: astore_1
    //   51: ldc 114
    //   53: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_1
    //   57: athrow
    //   58: astore_0
    //   59: aload_3
    //   60: aload_1
    //   61: invokestatic 97	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   64: ldc 114
    //   66: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_0
    //   70: athrow
    //   71: astore_0
    //   72: aload_2
    //   73: astore_1
    //   74: goto -15 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	parame	e
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
 * Qualified Name:     com.tencent.mm.vfs.f
 * JD-Core Version:    0.7.0.1
 */