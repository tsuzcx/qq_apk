package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.Callable;

public final class j
{
  private final File a;
  private final FileOutputStream b;
  private final FileLock c;
  
  private j(File paramFile, FileOutputStream paramFileOutputStream, FileLock paramFileLock)
  {
    this.a = paramFile;
    this.b = paramFileOutputStream;
    this.c = paramFileLock;
  }
  
  /* Error */
  public static j a(File paramFile)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 36	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 39	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 43	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   18: invokevirtual 49	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   21: astore_3
    //   22: aload_1
    //   23: astore_2
    //   24: aload_3
    //   25: ifnull +62 -> 87
    //   28: ldc 51
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   40: aastore
    //   41: invokestatic 62	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: new 2	com/tencent/tbs/one/impl/a/j
    //   47: dup
    //   48: aload_0
    //   49: aload_1
    //   50: aload_3
    //   51: invokespecial 64	com/tencent/tbs/one/impl/a/j:<init>	(Ljava/io/File;Ljava/io/FileOutputStream;Ljava/nio/channels/FileLock;)V
    //   54: astore_2
    //   55: ldc 28
    //   57: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: aconst_null
    //   64: astore_1
    //   65: ldc 69
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_0
    //   74: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: aload_2
    //   81: aastore
    //   82: invokestatic 71	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_1
    //   86: astore_2
    //   87: aload_2
    //   88: invokestatic 76	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   91: ldc 28
    //   93: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_2
    //   99: goto -34 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   13	73	1	localFileOutputStream1	FileOutputStream
    //   23	38	2	localObject	Object
    //   62	19	2	localThrowable1	java.lang.Throwable
    //   86	2	2	localFileOutputStream2	FileOutputStream
    //   98	1	2	localThrowable2	java.lang.Throwable
    //   21	30	3	localFileLock	FileLock
    // Exception table:
    //   from	to	target	type
    //   5	14	62	java/lang/Throwable
    //   14	22	98	java/lang/Throwable
    //   28	55	98	java/lang/Throwable
  }
  
  /* Error */
  static <T> T a(Callable<T> paramCallable, File paramFile, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 82
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload 4
    //   10: i2l
    //   11: lload_2
    //   12: ldc2_w 83
    //   15: ldiv
    //   16: lcmp
    //   17: ifge +98 -> 115
    //   20: aload_0
    //   21: invokeinterface 90 1 0
    //   26: astore 5
    //   28: aload 5
    //   30: ifnull +32 -> 62
    //   33: iload 4
    //   35: ifle +19 -> 54
    //   38: ldc 92
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   50: aastore
    //   51: invokestatic 62	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: ldc 82
    //   56: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload 5
    //   61: areturn
    //   62: iload 4
    //   64: ifne +19 -> 83
    //   67: ldc 94
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_1
    //   76: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 62	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: ldc2_w 83
    //   86: invokestatic 100	java/lang/Thread:sleep	(J)V
    //   89: iload 4
    //   91: iconst_1
    //   92: iadd
    //   93: istore 4
    //   95: goto -87 -> 8
    //   98: astore_0
    //   99: new 102	java/lang/RuntimeException
    //   102: dup
    //   103: aload_0
    //   104: invokespecial 105	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   107: astore_0
    //   108: ldc 82
    //   110: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: athrow
    //   115: new 102	java/lang/RuntimeException
    //   118: dup
    //   119: new 107	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 109
    //   125: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   132: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 120	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   141: astore_0
    //   142: ldc 82
    //   144: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_0
    //   148: athrow
    //   149: astore 5
    //   151: goto -62 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramCallable	Callable<T>
    //   0	154	1	paramFile	File
    //   0	154	2	paramLong	long
    //   1	93	4	i	int
    //   26	34	5	localObject	Object
    //   149	1	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   20	28	98	java/lang/Exception
    //   38	54	98	java/lang/Exception
    //   67	83	98	java/lang/Exception
    //   83	89	149	java/lang/InterruptedException
  }
  
  public final void a()
  {
    AppMethodBeat.i(173903);
    try
    {
      f.a("Deleting lock file: %s", new Object[] { this.a.getAbsolutePath() });
      this.c.release();
      this.b.close();
      if (!this.a.delete())
      {
        IOException localIOException1 = new IOException("Failed to delete lock file: " + this.a.getAbsolutePath());
        AppMethodBeat.o(173903);
        throw localIOException1;
      }
    }
    catch (IOException localIOException2)
    {
      f.c("Failed to release process lock file %s", new Object[] { this.a.getAbsolutePath(), localIOException2 });
      AppMethodBeat.o(173903);
      return;
    }
    AppMethodBeat.o(173903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.j
 * JD-Core Version:    0.7.0.1
 */