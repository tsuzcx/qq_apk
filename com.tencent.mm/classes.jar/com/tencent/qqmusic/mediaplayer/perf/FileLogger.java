package com.tencent.qqmusic.mediaplayer.perf;

public class FileLogger
{
  private static final String TAG = "FileLogger";
  
  /* Error */
  public static void write(java.lang.StringBuilder paramStringBuilder, java.io.File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 19	java/io/FileWriter
    //   3: dup
    //   4: aload_1
    //   5: iload_2
    //   6: invokespecial 22	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   9: astore_3
    //   10: aload_3
    //   11: astore_1
    //   12: aload_3
    //   13: aload_0
    //   14: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17: invokevirtual 31	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: astore_1
    //   22: aload_3
    //   23: invokevirtual 34	java/io/FileWriter:flush	()V
    //   26: aload_3
    //   27: invokevirtual 37	java/io/FileWriter:close	()V
    //   30: return
    //   31: astore 4
    //   33: aconst_null
    //   34: astore_0
    //   35: aload_0
    //   36: astore_1
    //   37: ldc 8
    //   39: ldc 39
    //   41: aload 4
    //   43: invokestatic 45	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   46: aload_0
    //   47: ifnull -17 -> 30
    //   50: aload_0
    //   51: invokevirtual 37	java/io/FileWriter:close	()V
    //   54: return
    //   55: astore_0
    //   56: return
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 37	java/io/FileWriter:close	()V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: return
    //   72: astore_1
    //   73: goto -5 -> 68
    //   76: astore_0
    //   77: goto -17 -> 60
    //   80: astore 4
    //   82: aload_3
    //   83: astore_0
    //   84: goto -49 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramStringBuilder	java.lang.StringBuilder
    //   0	87	1	paramFile	java.io.File
    //   0	87	2	paramBoolean	boolean
    //   9	74	3	localFileWriter	java.io.FileWriter
    //   31	11	4	localIOException1	java.io.IOException
    //   80	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	10	31	java/io/IOException
    //   50	54	55	java/io/IOException
    //   0	10	57	finally
    //   26	30	70	java/io/IOException
    //   64	68	72	java/io/IOException
    //   12	20	76	finally
    //   22	26	76	finally
    //   37	46	76	finally
    //   12	20	80	java/io/IOException
    //   22	26	80	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.FileLogger
 * JD-Core Version:    0.7.0.1
 */