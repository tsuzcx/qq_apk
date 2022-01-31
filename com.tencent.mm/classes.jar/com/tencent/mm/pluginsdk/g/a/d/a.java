package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public final class a
{
  public static long Jr(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return 0L;
      paramString = new File(paramString);
    } while (!paramString.isFile());
    return paramString.length();
  }
  
  /* Error */
  public static byte[] Wo(String paramString)
  {
    // Byte code:
    //   0: new 35	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 36	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 38	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 41	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload_0
    //   22: astore_2
    //   23: sipush 4096
    //   26: newarray byte
    //   28: astore 5
    //   30: aload 4
    //   32: astore_3
    //   33: aload_0
    //   34: astore_2
    //   35: aload_0
    //   36: aload 5
    //   38: invokevirtual 45	java/io/FileInputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_m1
    //   44: if_icmpeq +51 -> 95
    //   47: aload 4
    //   49: astore_3
    //   50: aload_0
    //   51: astore_2
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 49	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -31 -> 30
    //   64: astore 5
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: astore_2
    //   71: ldc 51
    //   73: aload 5
    //   75: ldc 53
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   88: aload 4
    //   90: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   93: aconst_null
    //   94: areturn
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: astore_2
    //   100: aload 4
    //   102: invokevirtual 66	java/io/ByteArrayOutputStream:flush	()V
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: astore_2
    //   110: aload 4
    //   112: invokevirtual 70	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   115: astore 5
    //   117: aload_0
    //   118: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   121: aload 4
    //   123: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   126: aload 5
    //   128: areturn
    //   129: astore 5
    //   131: aconst_null
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_0
    //   136: aload 4
    //   138: astore_3
    //   139: aload_0
    //   140: astore_2
    //   141: ldc 51
    //   143: aload 5
    //   145: ldc 53
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   158: aload 4
    //   160: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_0
    //   172: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   175: aload_3
    //   176: invokestatic 63	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   179: aload 4
    //   181: athrow
    //   182: astore 4
    //   184: aconst_null
    //   185: astore_3
    //   186: goto -15 -> 171
    //   189: astore 4
    //   191: aload_2
    //   192: astore_0
    //   193: goto -22 -> 171
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 4
    //   201: goto -65 -> 136
    //   204: astore 5
    //   206: goto -70 -> 136
    //   209: astore 5
    //   211: aconst_null
    //   212: astore 4
    //   214: aconst_null
    //   215: astore_0
    //   216: goto -150 -> 66
    //   219: astore 5
    //   221: aconst_null
    //   222: astore 4
    //   224: goto -158 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramString	String
    //   41	17	1	i	int
    //   22	170	2	str	String
    //   20	166	3	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   16	143	4	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   165	15	4	localObject1	Object
    //   182	1	4	localObject2	Object
    //   189	1	4	localObject3	Object
    //   199	24	4	localObject4	Object
    //   28	27	5	arrayOfByte1	byte[]
    //   64	10	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   115	12	5	arrayOfByte2	byte[]
    //   129	15	5	localIOException1	IOException
    //   196	1	5	localIOException2	IOException
    //   204	1	5	localIOException3	IOException
    //   209	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   219	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   23	30	64	java/io/FileNotFoundException
    //   35	42	64	java/io/FileNotFoundException
    //   52	61	64	java/io/FileNotFoundException
    //   100	105	64	java/io/FileNotFoundException
    //   110	117	64	java/io/FileNotFoundException
    //   0	9	129	java/io/IOException
    //   0	9	165	finally
    //   9	18	182	finally
    //   23	30	189	finally
    //   35	42	189	finally
    //   52	61	189	finally
    //   71	84	189	finally
    //   100	105	189	finally
    //   110	117	189	finally
    //   141	154	189	finally
    //   9	18	196	java/io/IOException
    //   23	30	204	java/io/IOException
    //   35	42	204	java/io/IOException
    //   52	61	204	java/io/IOException
    //   100	105	204	java/io/IOException
    //   110	117	204	java/io/IOException
    //   0	9	209	java/io/FileNotFoundException
    //   9	18	219	java/io/FileNotFoundException
  }
  
  public static boolean Wp(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString.exists()) && (!paramString.delete()));
    return true;
  }
  
  public static boolean bK(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isFile()));
    return true;
  }
  
  public static void e(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", localIOException, "", new Object[0]);
      y.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[] { paramCloseable.getClass().getSimpleName(), localIOException.getMessage() }));
    }
  }
  
  /* Error */
  public static boolean v(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 113	com/tencent/mm/sdk/platformtools/bk:bE	([B)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 14	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 77	java/io/File:delete	()Z
    //   22: pop
    //   23: aload_0
    //   24: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   27: invokevirtual 120	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aconst_null
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_3
    //   35: new 122	java/io/FileOutputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: astore_0
    //   44: aload_0
    //   45: astore_2
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 128	java/io/FileOutputStream:write	([B)V
    //   51: aload_0
    //   52: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   55: aload_0
    //   56: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_0
    //   62: ldc 51
    //   64: aload_0
    //   65: ldc 53
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -15 -> 59
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: astore_2
    //   82: ldc 51
    //   84: aload_1
    //   85: ldc 53
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: ifnull -88 -> 7
    //   98: aload_0
    //   99: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   102: aload_0
    //   103: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_0
    //   109: ldc 51
    //   111: aload_0
    //   112: ldc 53
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: aload_3
    //   125: astore_0
    //   126: aload_0
    //   127: astore_2
    //   128: ldc 51
    //   130: aload_1
    //   131: ldc 53
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_0
    //   141: ifnull -134 -> 7
    //   144: aload_0
    //   145: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   148: aload_0
    //   149: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_0
    //   155: ldc 51
    //   157: aload_0
    //   158: ldc 53
    //   160: iconst_0
    //   161: anewarray 4	java/lang/Object
    //   164: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_0
    //   170: aload_2
    //   171: ifnull +11 -> 182
    //   174: aload_2
    //   175: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   178: aload_2
    //   179: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_1
    //   185: ldc 51
    //   187: aload_1
    //   188: ldc 53
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 59	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: goto -15 -> 182
    //   200: astore_0
    //   201: goto -31 -> 170
    //   204: astore_1
    //   205: goto -79 -> 126
    //   208: astore_1
    //   209: goto -129 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramString	String
    //   0	212	1	paramArrayOfByte	byte[]
    //   32	147	2	str	String
    //   34	91	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   51	59	61	java/io/IOException
    //   35	44	77	java/io/FileNotFoundException
    //   98	106	108	java/io/IOException
    //   35	44	123	java/io/IOException
    //   144	152	154	java/io/IOException
    //   35	44	169	finally
    //   128	140	169	finally
    //   174	182	184	java/io/IOException
    //   46	51	200	finally
    //   82	94	200	finally
    //   46	51	204	java/io/IOException
    //   46	51	208	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.d.a
 * JD-Core Version:    0.7.0.1
 */