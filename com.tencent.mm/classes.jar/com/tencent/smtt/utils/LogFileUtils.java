package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static OutputStream a = null;
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(65262);
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      AppMethodBeat.o(65262);
      return;
    }
    catch (IOException paramOutputStream)
    {
      AppMethodBeat.o(65262);
    }
  }
  
  public static byte[] createHeaderText(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65266);
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      paramString2 = String.format("%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      AppMethodBeat.o(65266);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(65266);
    }
    return null;
  }
  
  public static String createKey()
  {
    AppMethodBeat.i(65264);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(65264);
    return String.valueOf(l);
  }
  
  public static byte[] encrypt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65263);
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      AppMethodBeat.o(65263);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      new StringBuilder("encrypt exception:").append(paramString1.getMessage());
      AppMethodBeat.o(65263);
    }
    return null;
  }
  
  public static byte[] encryptKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65265);
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      AppMethodBeat.o(65265);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      new StringBuilder("encrypt exception:").append(paramString1.getMessage());
      AppMethodBeat.o(65265);
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 124
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: aload_3
    //   10: invokestatic 126	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;Ljava/lang/String;)[B
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +111 -> 126
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 132	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokevirtual 136	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: aload_0
    //   29: invokevirtual 139	java/io/File:isFile	()Z
    //   32: ifeq +31 -> 63
    //   35: aload_0
    //   36: invokevirtual 142	java/io/File:exists	()Z
    //   39: ifeq +24 -> 63
    //   42: aload_0
    //   43: invokevirtual 145	java/io/File:length	()J
    //   46: ldc2_w 146
    //   49: lcmp
    //   50: ifle +13 -> 63
    //   53: aload_0
    //   54: invokevirtual 150	java/io/File:delete	()Z
    //   57: pop
    //   58: aload_0
    //   59: invokevirtual 153	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   66: ifnonnull +23 -> 89
    //   69: new 155	java/io/BufferedOutputStream
    //   72: dup
    //   73: new 157	java/io/FileOutputStream
    //   76: dup
    //   77: aload_0
    //   78: iload 4
    //   80: invokespecial 160	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   83: invokespecial 162	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: putstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   89: aload_3
    //   90: ifnull +41 -> 131
    //   93: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   96: aload_3
    //   97: invokevirtual 165	java/lang/String:getBytes	()[B
    //   100: invokevirtual 169	java/io/OutputStream:write	([B)V
    //   103: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +128 -> 236
    //   111: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   114: invokevirtual 172	java/io/OutputStream:flush	()V
    //   117: ldc 124
    //   119: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: ldc 2
    //   124: monitorexit
    //   125: return
    //   126: aconst_null
    //   127: astore_1
    //   128: goto -108 -> 20
    //   131: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   134: aload_2
    //   135: invokevirtual 169	java/io/OutputStream:write	([B)V
    //   138: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   141: aload_1
    //   142: invokevirtual 169	java/io/OutputStream:write	([B)V
    //   145: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   148: iconst_2
    //   149: newarray byte
    //   151: dup
    //   152: iconst_0
    //   153: ldc 173
    //   155: bastore
    //   156: dup
    //   157: iconst_1
    //   158: ldc 173
    //   160: bastore
    //   161: invokevirtual 169	java/io/OutputStream:write	([B)V
    //   164: goto -61 -> 103
    //   167: astore_0
    //   168: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   171: astore_0
    //   172: aload_0
    //   173: ifnull +63 -> 236
    //   176: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   179: invokevirtual 172	java/io/OutputStream:flush	()V
    //   182: ldc 124
    //   184: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: goto -65 -> 122
    //   190: astore_0
    //   191: ldc 2
    //   193: monitorexit
    //   194: aload_0
    //   195: athrow
    //   196: astore_0
    //   197: ldc 124
    //   199: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: goto -80 -> 122
    //   205: astore_0
    //   206: ldc 124
    //   208: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: goto -89 -> 122
    //   214: astore_0
    //   215: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   218: astore_1
    //   219: aload_1
    //   220: ifnull +9 -> 229
    //   223: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   226: invokevirtual 172	java/io/OutputStream:flush	()V
    //   229: ldc 124
    //   231: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: athrow
    //   236: ldc 124
    //   238: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: goto -119 -> 122
    //   244: astore_1
    //   245: goto -16 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramFile	java.io.File
    //   0	248	1	paramString1	String
    //   0	248	2	paramArrayOfByte	byte[]
    //   0	248	3	paramString2	String
    //   0	248	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   20	63	167	java/lang/Throwable
    //   63	89	167	java/lang/Throwable
    //   93	103	167	java/lang/Throwable
    //   131	164	167	java/lang/Throwable
    //   3	14	190	finally
    //   103	107	190	finally
    //   111	117	190	finally
    //   117	122	190	finally
    //   168	172	190	finally
    //   176	182	190	finally
    //   182	187	190	finally
    //   197	202	190	finally
    //   206	211	190	finally
    //   215	219	190	finally
    //   223	229	190	finally
    //   229	236	190	finally
    //   236	241	190	finally
    //   111	117	196	java/lang/Throwable
    //   176	182	205	java/lang/Throwable
    //   20	63	214	finally
    //   63	89	214	finally
    //   93	103	214	finally
    //   131	164	214	finally
    //   223	229	244	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.utils.LogFileUtils
 * JD-Core Version:    0.7.0.1
 */