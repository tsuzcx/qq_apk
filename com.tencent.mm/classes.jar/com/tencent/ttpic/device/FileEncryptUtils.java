package com.tencent.ttpic.device;

import com.tencent.ttpic.baseutils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileEncryptUtils
{
  public static final byte[] ENCRYPE_HEAD = { 69, 78, 67, 82 };
  public static final int ENCRYPT_SIZE = 1024;
  public static final String KEY = "1@gU5m7Z9k1d";
  
  /* Error */
  public static void decryptFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 31	java/io/FileOutputStream
    //   5: dup
    //   6: new 33	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 39	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_1
    //   20: aload_0
    //   21: invokestatic 42	com/tencent/ttpic/device/FileEncryptUtils:decryptFile	(Ljava/lang/String;)[B
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +10 -> 36
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 46	java/io/FileOutputStream:write	([B)V
    //   36: aload_2
    //   37: invokestatic 52	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   40: return
    //   41: astore_3
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: astore_1
    //   46: aload_3
    //   47: invokestatic 58	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   50: aload_0
    //   51: invokestatic 52	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   54: return
    //   55: astore_0
    //   56: aload_3
    //   57: astore_1
    //   58: aload_1
    //   59: invokestatic 52	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: goto -7 -> 58
    //   68: astore_3
    //   69: aload_2
    //   70: astore_0
    //   71: goto -27 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramString1	String
    //   0	74	1	paramString2	String
    //   17	53	2	localFileOutputStream	java.io.FileOutputStream
    //   1	1	3	localObject	Object
    //   41	16	3	localThrowable1	java.lang.Throwable
    //   68	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	18	41	java/lang/Throwable
    //   2	18	55	finally
    //   20	25	64	finally
    //   31	36	64	finally
    //   46	50	64	finally
    //   20	25	68	java/lang/Throwable
    //   31	36	68	java/lang/Throwable
  }
  
  public static byte[] decryptFile(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = new byte[4];
      paramInputStream.read((byte[])localObject1);
      if ((localObject1[0] == ENCRYPE_HEAD[0]) && (localObject1[1] == ENCRYPE_HEAD[1]) && (localObject1[2] == ENCRYPE_HEAD[2]) && (localObject1[3] == ENCRYPE_HEAD[3]))
      {
        localObject1 = new ByteArrayOutputStream(readInt(paramInputStream));
        int i = readInt(paramInputStream);
        localObject2 = new byte[i];
        paramInputStream.read((byte[])localObject2, 0, i);
        localObject2 = EncryptUtils.decrypt((byte[])localObject2, "1@gU5m7Z9k1d");
        ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, localObject2.length);
        IOUtils.copy(paramInputStream, (OutputStream)localObject1);
        return ((ByteArrayOutputStream)localObject1).toByteArray();
      }
      Object localObject2 = new ByteArrayOutputStream();
      ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
      IOUtils.copy(paramInputStream, (OutputStream)localObject2);
      paramInputStream = ((ByteArrayOutputStream)localObject2).toByteArray();
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      LogUtils.e(paramInputStream);
    }
    return null;
  }
  
  public static byte[] decryptFile(String paramString)
  {
    try
    {
      paramString = new DataInputStream(new FileInputStream(new File(paramString)));
      byte[] arrayOfByte = decryptFile(paramString);
      paramString.close();
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  static int readInt(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if ((i | j | k | m) < 0) {
      throw new EOFException();
    }
    return (i << 24) + (j << 16) + (k << 8) + (m << 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.FileEncryptUtils
 * JD-Core Version:    0.7.0.1
 */