package com.tencent.smtt.utils;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static OutputStream a = null;
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  public static byte[] createHeaderText(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      paramString2 = String.format("%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static String createKey()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  public static byte[] encrypt(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      new StringBuilder("encrypt exception:").append(paramString1.getMessage());
    }
    return null;
  }
  
  public static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      new StringBuilder("encrypt exception:").append(paramString1.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: aload_3
    //   5: invokestatic 111	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;Ljava/lang/String;)[B
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +106 -> 116
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   19: invokevirtual 121	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: aload_0
    //   24: invokevirtual 124	java/io/File:isFile	()Z
    //   27: ifeq +31 -> 58
    //   30: aload_0
    //   31: invokevirtual 127	java/io/File:exists	()Z
    //   34: ifeq +24 -> 58
    //   37: aload_0
    //   38: invokevirtual 130	java/io/File:length	()J
    //   41: ldc2_w 131
    //   44: lcmp
    //   45: ifle +13 -> 58
    //   48: aload_0
    //   49: invokevirtual 135	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_0
    //   54: invokevirtual 138	java/io/File:createNewFile	()Z
    //   57: pop
    //   58: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   61: ifnonnull +23 -> 84
    //   64: new 140	java/io/BufferedOutputStream
    //   67: dup
    //   68: new 142	java/io/FileOutputStream
    //   71: dup
    //   72: aload_0
    //   73: iload 4
    //   75: invokespecial 145	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   78: invokespecial 147	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   81: putstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   84: aload_3
    //   85: ifnull +36 -> 121
    //   88: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   91: aload_3
    //   92: invokevirtual 150	java/lang/String:getBytes	()[B
    //   95: invokevirtual 154	java/io/OutputStream:write	([B)V
    //   98: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   109: invokevirtual 157	java/io/OutputStream:flush	()V
    //   112: ldc 2
    //   114: monitorexit
    //   115: return
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -103 -> 15
    //   121: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   124: aload_2
    //   125: invokevirtual 154	java/io/OutputStream:write	([B)V
    //   128: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   131: aload_1
    //   132: invokevirtual 154	java/io/OutputStream:write	([B)V
    //   135: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   138: iconst_2
    //   139: newarray byte
    //   141: dup
    //   142: iconst_0
    //   143: ldc 158
    //   145: bastore
    //   146: dup
    //   147: iconst_1
    //   148: ldc 158
    //   150: bastore
    //   151: invokevirtual 154	java/io/OutputStream:write	([B)V
    //   154: goto -56 -> 98
    //   157: astore_0
    //   158: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull -51 -> 112
    //   166: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   169: invokevirtual 157	java/io/OutputStream:flush	()V
    //   172: goto -60 -> 112
    //   175: astore_0
    //   176: goto -64 -> 112
    //   179: astore_0
    //   180: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   183: astore_1
    //   184: aload_1
    //   185: ifnull +9 -> 194
    //   188: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   191: invokevirtual 157	java/io/OutputStream:flush	()V
    //   194: aload_0
    //   195: athrow
    //   196: astore_0
    //   197: ldc 2
    //   199: monitorexit
    //   200: aload_0
    //   201: athrow
    //   202: astore_1
    //   203: goto -9 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramFile	java.io.File
    //   0	206	1	paramString1	String
    //   0	206	2	paramArrayOfByte	byte[]
    //   0	206	3	paramString2	String
    //   0	206	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   15	58	157	java/lang/Throwable
    //   58	84	157	java/lang/Throwable
    //   88	98	157	java/lang/Throwable
    //   121	154	157	java/lang/Throwable
    //   106	112	175	java/lang/Throwable
    //   166	172	175	java/lang/Throwable
    //   15	58	179	finally
    //   58	84	179	finally
    //   88	98	179	finally
    //   121	154	179	finally
    //   3	9	196	finally
    //   98	102	196	finally
    //   106	112	196	finally
    //   158	162	196	finally
    //   166	172	196	finally
    //   180	184	196	finally
    //   188	194	196	finally
    //   194	196	196	finally
    //   188	194	202	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.utils.LogFileUtils
 * JD-Core Version:    0.7.0.1
 */