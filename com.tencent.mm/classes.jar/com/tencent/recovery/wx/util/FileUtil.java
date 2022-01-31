package com.tencent.recovery.wx.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil
{
  /* Error */
  public static java.lang.String ac(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 17	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 20	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: new 22	java/lang/String
    //   12: dup
    //   13: aload_0
    //   14: invokestatic 26	com/tencent/recovery/wx/util/FileUtil:m	(Ljava/io/InputStream;)[B
    //   17: invokespecial 29	java/lang/String:<init>	([B)V
    //   20: astore_1
    //   21: aload_0
    //   22: invokevirtual 34	java/io/InputStream:close	()V
    //   25: aload_1
    //   26: areturn
    //   27: astore_0
    //   28: aconst_null
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +7 -> 38
    //   34: aload_0
    //   35: invokevirtual 34	java/io/InputStream:close	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_1
    //   41: aconst_null
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: invokevirtual 34	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: athrow
    //   53: astore_0
    //   54: aload_1
    //   55: areturn
    //   56: astore_0
    //   57: goto -19 -> 38
    //   60: astore_0
    //   61: goto -10 -> 51
    //   64: astore_1
    //   65: goto -22 -> 43
    //   68: astore_1
    //   69: goto -39 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramFile	java.io.File
    //   20	6	1	str1	java.lang.String
    //   40	15	1	str2	java.lang.String
    //   64	1	1	localObject	Object
    //   68	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	27	java/lang/Exception
    //   0	9	40	finally
    //   21	25	53	java/io/IOException
    //   34	38	56	java/io/IOException
    //   47	51	60	java/io/IOException
    //   9	21	64	finally
    //   9	21	68	java/lang/Exception
  }
  
  public static byte[] m(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    int i = 0;
    for (;;)
    {
      try
      {
        int j = paramInputStream.read(arrayOfByte, 0, 1024);
        i = j;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      if (i <= 0) {
        continue;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */