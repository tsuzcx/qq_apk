package org.apache.commons.c;

public final class g
{
  /* Error */
  public static void a(java.io.Serializable paramSerializable, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 17	java/io/ObjectOutputStream
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 21	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual 25	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   21: aload_2
    //   22: invokevirtual 29	java/io/ObjectOutputStream:close	()V
    //   25: ldc 9
    //   27: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: astore_0
    //   32: ldc 9
    //   34: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_0
    //   41: aload_0
    //   42: astore_1
    //   43: new 34	org/apache/commons/c/f
    //   46: dup
    //   47: aload_3
    //   48: invokespecial 37	org/apache/commons/c/f:<init>	(Ljava/lang/Throwable;)V
    //   51: astore_2
    //   52: aload_0
    //   53: astore_1
    //   54: ldc 9
    //   56: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: astore_1
    //   61: aload_2
    //   62: athrow
    //   63: astore_0
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 29	java/io/ObjectOutputStream:close	()V
    //   72: ldc 9
    //   74: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: athrow
    //   79: astore_1
    //   80: goto -8 -> 72
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_1
    //   86: goto -22 -> 64
    //   89: astore_3
    //   90: aload_2
    //   91: astore_0
    //   92: goto -51 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramSerializable	java.io.Serializable
    //   0	95	1	paramOutputStream	java.io.OutputStream
    //   13	78	2	localObject	Object
    //   38	10	3	localIOException1	java.io.IOException
    //   89	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	25	31	java/io/IOException
    //   5	14	38	java/io/IOException
    //   16	21	63	finally
    //   43	52	63	finally
    //   54	59	63	finally
    //   61	63	63	finally
    //   68	72	79	java/io/IOException
    //   5	14	83	finally
    //   16	21	89	java/io/IOException
  }
  
  /* Error */
  public static Object aj(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore_2
    //   9: new 45	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 48	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: aload_0
    //   19: astore_1
    //   20: aload_0
    //   21: invokevirtual 52	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   29: ldc 43
    //   31: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_2
    //   35: areturn
    //   36: astore_2
    //   37: aconst_null
    //   38: astore_0
    //   39: aload_0
    //   40: astore_1
    //   41: new 34	org/apache/commons/c/f
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 37	org/apache/commons/c/f:<init>	(Ljava/lang/Throwable;)V
    //   49: astore_2
    //   50: aload_0
    //   51: astore_1
    //   52: ldc 43
    //   54: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: astore_1
    //   59: aload_2
    //   60: athrow
    //   61: astore_0
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   70: ldc 43
    //   72: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: athrow
    //   77: astore_1
    //   78: aload_2
    //   79: astore_0
    //   80: aload_1
    //   81: astore_2
    //   82: aload_0
    //   83: astore_1
    //   84: new 34	org/apache/commons/c/f
    //   87: dup
    //   88: aload_2
    //   89: invokespecial 37	org/apache/commons/c/f:<init>	(Ljava/lang/Throwable;)V
    //   92: astore_2
    //   93: aload_0
    //   94: astore_1
    //   95: ldc 43
    //   97: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: astore_1
    //   102: aload_2
    //   103: athrow
    //   104: astore_0
    //   105: goto -43 -> 62
    //   108: astore_0
    //   109: goto -80 -> 29
    //   112: astore_1
    //   113: goto -43 -> 70
    //   116: astore_2
    //   117: goto -35 -> 82
    //   120: astore_2
    //   121: goto -82 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramInputStream	java.io.InputStream
    //   6	61	1	localInputStream1	java.io.InputStream
    //   77	4	1	localIOException1	java.io.IOException
    //   83	19	1	localInputStream2	java.io.InputStream
    //   112	1	1	localIOException2	java.io.IOException
    //   8	27	2	localObject1	Object
    //   36	10	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   49	54	2	localObject2	Object
    //   116	1	2	localIOException3	java.io.IOException
    //   120	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   9	18	36	java/lang/ClassNotFoundException
    //   20	25	61	finally
    //   41	50	61	finally
    //   52	57	61	finally
    //   59	61	61	finally
    //   9	18	77	java/io/IOException
    //   9	18	104	finally
    //   84	93	104	finally
    //   95	100	104	finally
    //   102	104	104	finally
    //   25	29	108	java/io/IOException
    //   66	70	112	java/io/IOException
    //   20	25	116	java/io/IOException
    //   20	25	120	java/lang/ClassNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.g
 * JD-Core Version:    0.7.0.1
 */