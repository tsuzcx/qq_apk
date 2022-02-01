package com.tencent.smtt.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class f
{
  private static String a = "EmergencyManager";
  private final File b;
  private final FileOutputStream c;
  private final FileLock d;
  
  private f(File paramFile, FileOutputStream paramFileOutputStream, FileLock paramFileLock)
  {
    this.b = paramFile;
    this.c = paramFileOutputStream;
    this.d = paramFileLock;
  }
  
  /* Error */
  public static f a(File paramFile)
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 43	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: invokevirtual 50	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   20: invokevirtual 56	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +83 -> 108
    //   28: aload_2
    //   29: astore_1
    //   30: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   33: new 58	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 60
    //   39: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: invokevirtual 69	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 81	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_2
    //   56: astore_1
    //   57: new 2	com/tencent/smtt/sdk/a/f
    //   60: dup
    //   61: aload_0
    //   62: aload_2
    //   63: aload_3
    //   64: invokespecial 83	com/tencent/smtt/sdk/a/f:<init>	(Ljava/io/File;Ljava/io/FileOutputStream;Ljava/nio/channels/FileLock;)V
    //   67: astore_3
    //   68: aload_2
    //   69: invokevirtual 86	java/io/FileOutputStream:close	()V
    //   72: ldc 35
    //   74: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_3
    //   78: areturn
    //   79: astore_0
    //   80: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   83: new 58	java/lang/StringBuilder
    //   86: dup
    //   87: ldc 91
    //   89: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 94	java/io/IOException:getMessage	()Ljava/lang/String;
    //   96: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 97	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: goto -33 -> 72
    //   108: aload_2
    //   109: invokevirtual 86	java/io/FileOutputStream:close	()V
    //   112: ldc 35
    //   114: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   123: new 58	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 91
    //   129: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual 94	java/io/IOException:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 97	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: goto -33 -> 112
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: astore_1
    //   153: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   156: new 58	java/lang/StringBuilder
    //   159: dup
    //   160: ldc 99
    //   162: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload_0
    //   166: invokevirtual 69	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   169: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 101
    //   174: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_3
    //   178: invokevirtual 102	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 97	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_2
    //   191: ifnull -79 -> 112
    //   194: aload_2
    //   195: invokevirtual 86	java/io/FileOutputStream:close	()V
    //   198: goto -86 -> 112
    //   201: astore_0
    //   202: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   205: new 58	java/lang/StringBuilder
    //   208: dup
    //   209: ldc 91
    //   211: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_0
    //   215: invokevirtual 94	java/io/IOException:getMessage	()Ljava/lang/String;
    //   218: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 97	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: goto -115 -> 112
    //   230: astore_0
    //   231: aconst_null
    //   232: astore_1
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 86	java/io/FileOutputStream:close	()V
    //   241: ldc 35
    //   243: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_0
    //   247: athrow
    //   248: astore_1
    //   249: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   252: new 58	java/lang/StringBuilder
    //   255: dup
    //   256: ldc 91
    //   258: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: aload_1
    //   262: invokevirtual 94	java/io/IOException:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 97	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: goto -33 -> 241
    //   277: astore_0
    //   278: goto -45 -> 233
    //   281: astore_3
    //   282: goto -131 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramFile	File
    //   15	223	1	localFileOutputStream1	FileOutputStream
    //   248	14	1	localIOException	IOException
    //   13	182	2	localFileOutputStream2	FileOutputStream
    //   23	55	3	localObject	Object
    //   148	30	3	localThrowable1	java.lang.Throwable
    //   281	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   68	72	79	java/io/IOException
    //   108	112	119	java/io/IOException
    //   5	14	148	java/lang/Throwable
    //   194	198	201	java/io/IOException
    //   5	14	230	finally
    //   237	241	248	java/io/IOException
    //   16	24	277	finally
    //   30	55	277	finally
    //   57	68	277	finally
    //   153	190	277	finally
    //   16	24	281	java/lang/Throwable
    //   30	55	281	java/lang/Throwable
    //   57	68	281	java/lang/Throwable
  }
  
  public void a()
  {
    AppMethodBeat.i(188286);
    TbsLog.i(a, "Deleting lock file: " + this.b.getAbsolutePath());
    this.d.release();
    this.c.close();
    if (!this.b.delete())
    {
      IOException localIOException = new IOException("Failed to delete lock file: " + this.b.getAbsolutePath());
      AppMethodBeat.o(188286);
      throw localIOException;
    }
    AppMethodBeat.o(188286);
  }
  
  public void b()
  {
    AppMethodBeat.i(188287);
    try
    {
      a();
      AppMethodBeat.o(188287);
      return;
    }
    catch (IOException localIOException)
    {
      TbsLog.e(a, "Failed to release process lock file: " + this.b.getAbsolutePath() + " error: " + localIOException);
      AppMethodBeat.o(188287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */