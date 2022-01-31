package com.tencent.shadow.core.manager.installplugin;

import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MinFileUtils
{
  private static final Logger mLogger = LoggerFactory.getLogger(MinFileUtils.class);
  
  public static void cleanDirectory(File paramFile)
  {
    File[] arrayOfFile = verifiedListFiles(paramFile);
    paramFile = null;
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        forceDelete(localFile);
        label27:
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        break label27;
      }
    }
  }
  
  private static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      cleanDirectory(paramFile);
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  public static void ensureParentDirExists(File paramFile)
  {
    File localFile = paramFile.getParentFile();
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {
      throw new IOException("创建父目录失败,文件目录:" + paramFile.getAbsolutePath() + " parent dir exists=" + localFile.exists());
    }
  }
  
  private static void forceDelete(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  /* Error */
  public static java.lang.String md5File(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 100	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 106	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: getstatic 112	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   18: lconst_0
    //   19: aload_0
    //   20: invokevirtual 116	java/io/File:length	()J
    //   23: invokevirtual 122	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   26: astore_0
    //   27: ldc 124
    //   29: invokestatic 130	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore_2
    //   33: aload_2
    //   34: aload_0
    //   35: invokevirtual 134	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   38: new 136	java/math/BigInteger
    //   41: dup
    //   42: iconst_1
    //   43: aload_2
    //   44: invokevirtual 140	java/security/MessageDigest:digest	()[B
    //   47: invokespecial 143	java/math/BigInteger:<init>	(I[B)V
    //   50: bipush 16
    //   52: invokevirtual 146	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   55: astore_0
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 149	java/io/FileInputStream:close	()V
    //   64: aload_0
    //   65: areturn
    //   66: astore_1
    //   67: aload_2
    //   68: astore_0
    //   69: new 151	java/lang/RuntimeException
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 154	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   77: athrow
    //   78: astore_2
    //   79: aload_0
    //   80: astore_1
    //   81: aload_2
    //   82: astore_0
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 149	java/io/FileInputStream:close	()V
    //   91: aload_0
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: areturn
    //   96: astore_1
    //   97: goto -6 -> 91
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: goto -20 -> 83
    //   106: astore_0
    //   107: goto -24 -> 83
    //   110: astore_2
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: astore_1
    //   115: goto -46 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramFile	File
    //   10	51	1	localFileInputStream	java.io.FileInputStream
    //   66	8	1	localException1	java.lang.Exception
    //   80	8	1	localFile	File
    //   93	1	1	localIOException1	IOException
    //   96	1	1	localIOException2	IOException
    //   102	13	1	localException2	java.lang.Exception
    //   1	67	2	localMessageDigest	java.security.MessageDigest
    //   78	4	2	localObject	Object
    //   110	4	2	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	66	java/lang/Exception
    //   69	78	78	finally
    //   60	64	93	java/io/IOException
    //   87	91	96	java/io/IOException
    //   2	11	100	finally
    //   11	56	106	finally
    //   11	56	110	java/lang/Exception
  }
  
  private static File[] verifiedListFiles(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    return arrayOfFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.MinFileUtils
 * JD-Core Version:    0.7.0.1
 */