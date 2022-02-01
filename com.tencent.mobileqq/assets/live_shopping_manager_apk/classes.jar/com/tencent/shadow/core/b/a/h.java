package com.tencent.shadow.core.b.a;

import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class h
{
  private static final Logger a = LoggerFactory.getLogger(h.class);
  
  /* Error */
  public static java.lang.String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 27	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 34	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: getstatic 40	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   20: lconst_0
    //   21: aload_0
    //   22: invokevirtual 46	java/io/File:length	()J
    //   25: invokevirtual 52	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   28: astore_0
    //   29: ldc 54
    //   31: invokestatic 60	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   34: astore_1
    //   35: aload_1
    //   36: aload_0
    //   37: invokevirtual 64	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   40: new 66	java/math/BigInteger
    //   43: dup
    //   44: iconst_1
    //   45: aload_1
    //   46: invokevirtual 70	java/security/MessageDigest:digest	()[B
    //   49: invokespecial 73	java/math/BigInteger:<init>	(I[B)V
    //   52: bipush 16
    //   54: invokevirtual 77	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   57: astore_0
    //   58: aload_2
    //   59: invokevirtual 80	java/io/FileInputStream:close	()V
    //   62: aload_0
    //   63: areturn
    //   64: astore_0
    //   65: goto +27 -> 92
    //   68: astore_0
    //   69: aload_2
    //   70: astore_1
    //   71: goto +12 -> 83
    //   74: astore_0
    //   75: aload_1
    //   76: astore_2
    //   77: goto +15 -> 92
    //   80: astore_0
    //   81: aload_3
    //   82: astore_1
    //   83: new 82	java/lang/RuntimeException
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 85	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   91: athrow
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 80	java/io/FileInputStream:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: areturn
    //   105: astore_1
    //   106: goto -6 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramFile	File
    //   3	80	1	localObject1	Object
    //   102	1	1	localIOException1	IOException
    //   105	1	1	localIOException2	IOException
    //   12	85	2	localObject2	Object
    //   1	81	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   13	58	64	finally
    //   13	58	68	java/lang/Exception
    //   4	13	74	finally
    //   83	92	74	finally
    //   4	13	80	java/lang/Exception
    //   58	62	102	java/io/IOException
    //   96	100	105	java/io/IOException
  }
  
  public static void b(File paramFile)
  {
    File[] arrayOfFile = e(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        c(localFile);
      }
      catch (IOException paramFile) {}
      i += 1;
    }
    if (paramFile == null) {
      return;
    }
    throw paramFile;
  }
  
  private static void c(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      d(paramFile);
      return;
    }
    boolean bool = paramFile.exists();
    if (!paramFile.delete())
    {
      if (!bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File does not exist: ");
        localStringBuilder.append(paramFile);
        throw new FileNotFoundException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to delete file: ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  private static void d(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    b(paramFile);
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to delete directory ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".");
    throw new IOException(localStringBuilder.toString());
  }
  
  private static File[] e(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        localObject = paramFile.listFiles();
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to list contents of ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(" is not a directory");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(" does not exist");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.h
 * JD-Core Version:    0.7.0.1
 */