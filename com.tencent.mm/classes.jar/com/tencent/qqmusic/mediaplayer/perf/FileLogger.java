package com.tencent.qqmusic.mediaplayer.perf;

public class FileLogger
{
  private static final String TAG = "FileLogger";
  
  /* Error */
  public static void write(java.lang.StringBuilder paramStringBuilder, java.io.File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 26	java/io/FileWriter
    //   8: dup
    //   9: aload_1
    //   10: iload_2
    //   11: invokespecial 29	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   14: astore_3
    //   15: aload_3
    //   16: astore_1
    //   17: aload_3
    //   18: aload_0
    //   19: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokevirtual 38	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   25: aload_3
    //   26: astore_1
    //   27: aload_3
    //   28: invokevirtual 41	java/io/FileWriter:flush	()V
    //   31: aload_3
    //   32: invokevirtual 44	java/io/FileWriter:close	()V
    //   35: ldc 18
    //   37: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: astore_0
    //   42: ldc 18
    //   44: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore 4
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: astore_1
    //   54: ldc 8
    //   56: ldc 49
    //   58: aload 4
    //   60: invokestatic 55	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload_0
    //   64: ifnull +38 -> 102
    //   67: aload_0
    //   68: invokevirtual 44	java/io/FileWriter:close	()V
    //   71: ldc 18
    //   73: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: astore_0
    //   78: ldc 18
    //   80: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 44	java/io/FileWriter:close	()V
    //   95: ldc 18
    //   97: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: athrow
    //   102: ldc 18
    //   104: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore_1
    //   109: goto -14 -> 95
    //   112: astore_0
    //   113: goto -26 -> 87
    //   116: astore 4
    //   118: aload_3
    //   119: astore_0
    //   120: goto -68 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramStringBuilder	java.lang.StringBuilder
    //   0	123	1	paramFile	java.io.File
    //   0	123	2	paramBoolean	boolean
    //   14	105	3	localFileWriter	java.io.FileWriter
    //   48	11	4	localIOException1	java.io.IOException
    //   116	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   31	35	41	java/io/IOException
    //   5	15	48	java/io/IOException
    //   67	71	77	java/io/IOException
    //   5	15	84	finally
    //   91	95	108	java/io/IOException
    //   17	25	112	finally
    //   27	31	112	finally
    //   54	63	112	finally
    //   17	25	116	java/io/IOException
    //   27	31	116	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.FileLogger
 * JD-Core Version:    0.7.0.1
 */