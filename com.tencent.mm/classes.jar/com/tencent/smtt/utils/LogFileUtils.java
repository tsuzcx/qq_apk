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
    AppMethodBeat.i(54038);
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      AppMethodBeat.o(54038);
      return;
    }
    catch (IOException paramOutputStream)
    {
      AppMethodBeat.o(54038);
    }
  }
  
  public static byte[] createHeaderText(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54042);
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      paramString2 = String.format("%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      AppMethodBeat.o(54042);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(54042);
    }
    return null;
  }
  
  public static String createKey()
  {
    AppMethodBeat.i(54040);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(54040);
    return String.valueOf(l);
  }
  
  public static byte[] encrypt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54039);
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      AppMethodBeat.o(54039);
      return paramString1;
    }
    finally
    {
      new StringBuilder("encrypt exception:").append(paramString1.getMessage());
      AppMethodBeat.o(54039);
    }
    return null;
  }
  
  public static byte[] encryptKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54041);
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      AppMethodBeat.o(54041);
      return paramString1;
    }
    finally
    {
      new StringBuilder("encrypt exception:").append(paramString1.getMessage());
      AppMethodBeat.o(54041);
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
    //   108: ifnull +276 -> 384
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
    //   168: new 106	java/lang/StringBuilder
    //   171: dup
    //   172: ldc 175
    //   174: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: aload_3
    //   178: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc 177
    //   183: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_2
    //   187: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: ldc 182
    //   192: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: ldc 184
    //   201: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 4
    //   206: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   209: ldc 189
    //   211: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: new 106	java/lang/StringBuilder
    //   222: dup
    //   223: ldc 175
    //   225: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload_3
    //   229: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 177
    //   234: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: ldc 182
    //   243: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: ldc 184
    //   252: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload 4
    //   257: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   260: ldc 189
    //   262: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_0
    //   266: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   273: astore_0
    //   274: aload_0
    //   275: ifnull +109 -> 384
    //   278: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   281: invokevirtual 172	java/io/OutputStream:flush	()V
    //   284: ldc 124
    //   286: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: goto -167 -> 122
    //   292: astore_0
    //   293: ldc 2
    //   295: monitorexit
    //   296: aload_0
    //   297: athrow
    //   298: astore_0
    //   299: new 106	java/lang/StringBuilder
    //   302: dup
    //   303: ldc 191
    //   305: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload_0
    //   309: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 124
    //   315: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: goto -196 -> 122
    //   321: astore_0
    //   322: new 106	java/lang/StringBuilder
    //   325: dup
    //   326: ldc 191
    //   328: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_0
    //   332: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: ldc 124
    //   338: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: goto -219 -> 122
    //   344: astore_0
    //   345: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   348: astore_1
    //   349: aload_1
    //   350: ifnull +9 -> 359
    //   353: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   356: invokevirtual 172	java/io/OutputStream:flush	()V
    //   359: ldc 124
    //   361: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload_0
    //   365: athrow
    //   366: astore_1
    //   367: new 106	java/lang/StringBuilder
    //   370: dup
    //   371: ldc 191
    //   373: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload_1
    //   377: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: goto -22 -> 359
    //   384: ldc 124
    //   386: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: goto -267 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramFile	java.io.File
    //   0	392	1	paramString1	String
    //   0	392	2	paramArrayOfByte	byte[]
    //   0	392	3	paramString2	String
    //   0	392	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   20	63	167	finally
    //   63	89	167	finally
    //   93	103	167	finally
    //   131	164	167	finally
    //   3	14	292	finally
    //   103	107	292	finally
    //   117	122	292	finally
    //   270	274	292	finally
    //   284	289	292	finally
    //   299	318	292	finally
    //   322	341	292	finally
    //   345	349	292	finally
    //   359	366	292	finally
    //   367	381	292	finally
    //   384	389	292	finally
    //   111	117	298	finally
    //   278	284	321	finally
    //   168	270	344	finally
    //   353	359	366	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.LogFileUtils
 * JD-Core Version:    0.7.0.1
 */