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
    //   0: ldc 33
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 41	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 44	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 48	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   18: invokevirtual 54	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +79 -> 102
    //   26: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   29: new 56	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 58
    //   35: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 79	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: new 2	com/tencent/smtt/sdk/a/f
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokespecial 81	com/tencent/smtt/sdk/a/f:<init>	(Ljava/io/File;Ljava/io/FileOutputStream;Ljava/nio/channels/FileLock;)V
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   66: ldc 33
    //   68: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_2
    //   72: areturn
    //   73: astore_0
    //   74: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   77: new 56	java/lang/StringBuilder
    //   80: dup
    //   81: ldc 89
    //   83: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 95	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: goto -33 -> 66
    //   102: aload_1
    //   103: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   106: ldc 33
    //   108: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   117: new 56	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 89
    //   123: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 95	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: goto -33 -> 106
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   148: new 56	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 97
    //   154: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 99
    //   166: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 102	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 95	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_1
    //   183: ifnull -77 -> 106
    //   186: aload_1
    //   187: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   190: goto -84 -> 106
    //   193: astore_0
    //   194: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   197: new 56	java/lang/StringBuilder
    //   200: dup
    //   201: ldc 89
    //   203: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
    //   210: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 95	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -113 -> 106
    //   222: astore_0
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   231: ldc 33
    //   233: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_0
    //   237: athrow
    //   238: astore_1
    //   239: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   242: new 56	java/lang/StringBuilder
    //   245: dup
    //   246: ldc 89
    //   248: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: aload_1
    //   252: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 95	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: goto -33 -> 231
    //   267: astore_2
    //   268: goto -123 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramFile	File
    //   13	215	1	localFileOutputStream	FileOutputStream
    //   238	14	1	localIOException	IOException
    //   21	51	2	localObject1	Object
    //   142	28	2	localObject2	Object
    //   267	1	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	66	73	java/io/IOException
    //   102	106	113	java/io/IOException
    //   5	14	142	finally
    //   186	190	193	java/io/IOException
    //   145	182	222	finally
    //   227	231	238	java/io/IOException
    //   14	22	267	finally
    //   26	62	267	finally
  }
  
  public void a()
  {
    AppMethodBeat.i(219688);
    TbsLog.i(a, "Deleting lock file: " + this.b.getAbsolutePath());
    this.d.release();
    this.c.close();
    if (!this.b.delete())
    {
      IOException localIOException = new IOException("Failed to delete lock file: " + this.b.getAbsolutePath());
      AppMethodBeat.o(219688);
      throw localIOException;
    }
    AppMethodBeat.o(219688);
  }
  
  public void b()
  {
    AppMethodBeat.i(219690);
    try
    {
      a();
      AppMethodBeat.o(219690);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(219690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */