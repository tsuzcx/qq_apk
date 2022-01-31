package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public final class a
{
  /* Error */
  public static boolean D(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 23	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 11
    //   14: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: new 28	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 36	java/io/File:delete	()Z
    //   32: pop
    //   33: aload_0
    //   34: invokevirtual 40	java/io/File:getParentFile	()Ljava/io/File;
    //   37: invokevirtual 43	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: aconst_null
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_3
    //   45: new 45	java/io/FileOutputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: astore_0
    //   54: aload_0
    //   55: astore_2
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 52	java/io/FileOutputStream:write	([B)V
    //   61: aload_0
    //   62: invokevirtual 56	java/io/FileOutputStream:flush	()V
    //   65: aload_0
    //   66: invokevirtual 59	java/io/FileOutputStream:close	()V
    //   69: ldc 11
    //   71: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_0
    //   77: ldc 61
    //   79: aload_0
    //   80: ldc 63
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: goto -20 -> 69
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: astore_2
    //   97: ldc 61
    //   99: aload_1
    //   100: ldc 63
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: ifnull +11 -> 121
    //   113: aload_0
    //   114: invokevirtual 56	java/io/FileOutputStream:flush	()V
    //   117: aload_0
    //   118: invokevirtual 59	java/io/FileOutputStream:close	()V
    //   121: ldc 11
    //   123: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_0
    //   129: ldc 61
    //   131: aload_0
    //   132: ldc 63
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: goto -20 -> 121
    //   144: astore_1
    //   145: aload_3
    //   146: astore_0
    //   147: aload_0
    //   148: astore_2
    //   149: ldc 61
    //   151: aload_1
    //   152: ldc 63
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_0
    //   162: ifnull -41 -> 121
    //   165: aload_0
    //   166: invokevirtual 56	java/io/FileOutputStream:flush	()V
    //   169: aload_0
    //   170: invokevirtual 59	java/io/FileOutputStream:close	()V
    //   173: goto -52 -> 121
    //   176: astore_0
    //   177: ldc 61
    //   179: aload_0
    //   180: ldc 63
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -68 -> 121
    //   192: astore_0
    //   193: aload_2
    //   194: ifnull +11 -> 205
    //   197: aload_2
    //   198: invokevirtual 56	java/io/FileOutputStream:flush	()V
    //   201: aload_2
    //   202: invokevirtual 59	java/io/FileOutputStream:close	()V
    //   205: ldc 11
    //   207: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_0
    //   211: athrow
    //   212: astore_1
    //   213: ldc 61
    //   215: aload_1
    //   216: ldc 63
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -20 -> 205
    //   228: astore_0
    //   229: goto -36 -> 193
    //   232: astore_1
    //   233: goto -86 -> 147
    //   236: astore_1
    //   237: goto -142 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramArrayOfByte	byte[]
    //   42	160	2	str	String
    //   44	102	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	69	76	java/io/IOException
    //   45	54	92	java/io/FileNotFoundException
    //   113	121	128	java/io/IOException
    //   45	54	144	java/io/IOException
    //   165	173	176	java/io/IOException
    //   45	54	192	finally
    //   149	161	192	finally
    //   197	205	212	java/io/IOException
    //   56	61	228	finally
    //   97	109	228	finally
    //   56	61	232	java/io/IOException
    //   56	61	236	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] alS(String paramString)
  {
    // Byte code:
    //   0: ldc 73
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 75	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 78	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: invokespecial 80	java/io/ByteArrayOutputStream:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload_0
    //   27: astore_2
    //   28: sipush 4096
    //   31: newarray byte
    //   33: astore 5
    //   35: aload 4
    //   37: astore_3
    //   38: aload_0
    //   39: astore_2
    //   40: aload_0
    //   41: aload 5
    //   43: invokevirtual 84	java/io/FileInputStream:read	([B)I
    //   46: istore_1
    //   47: iload_1
    //   48: iconst_m1
    //   49: if_icmpeq +56 -> 105
    //   52: aload 4
    //   54: astore_3
    //   55: aload_0
    //   56: astore_2
    //   57: aload 4
    //   59: aload 5
    //   61: iconst_0
    //   62: iload_1
    //   63: invokevirtual 87	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -31 -> 35
    //   69: astore 5
    //   71: aload 4
    //   73: astore_3
    //   74: aload_0
    //   75: astore_2
    //   76: ldc 61
    //   78: aload 5
    //   80: ldc 63
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_0
    //   90: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   93: aload 4
    //   95: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   98: ldc 73
    //   100: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aconst_null
    //   104: areturn
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: astore_2
    //   110: aload 4
    //   112: invokevirtual 92	java/io/ByteArrayOutputStream:flush	()V
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: astore_2
    //   120: aload 4
    //   122: invokevirtual 96	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   125: astore 5
    //   127: aload_0
    //   128: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   131: aload 4
    //   133: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   136: ldc 73
    //   138: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload 5
    //   143: areturn
    //   144: astore 5
    //   146: aconst_null
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_0
    //   151: aload 4
    //   153: astore_3
    //   154: aload_0
    //   155: astore_2
    //   156: ldc 61
    //   158: aload 5
    //   160: ldc 63
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   173: aload 4
    //   175: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   178: goto -80 -> 98
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   191: aload_3
    //   192: invokestatic 91	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   195: ldc 73
    //   197: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload 4
    //   202: athrow
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_3
    //   207: goto -20 -> 187
    //   210: astore 4
    //   212: aload_2
    //   213: astore_0
    //   214: goto -27 -> 187
    //   217: astore 5
    //   219: aconst_null
    //   220: astore 4
    //   222: goto -71 -> 151
    //   225: astore 5
    //   227: goto -76 -> 151
    //   230: astore 5
    //   232: aconst_null
    //   233: astore 4
    //   235: aconst_null
    //   236: astore_0
    //   237: goto -166 -> 71
    //   240: astore 5
    //   242: aconst_null
    //   243: astore 4
    //   245: goto -174 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramString	String
    //   46	17	1	i	int
    //   27	186	2	str	String
    //   25	182	3	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   21	153	4	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   181	20	4	localObject1	Object
    //   203	1	4	localObject2	Object
    //   210	1	4	localObject3	Object
    //   220	24	4	localObject4	Object
    //   33	27	5	arrayOfByte1	byte[]
    //   69	10	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   125	17	5	arrayOfByte2	byte[]
    //   144	15	5	localIOException1	IOException
    //   217	1	5	localIOException2	IOException
    //   225	1	5	localIOException3	IOException
    //   230	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   240	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   28	35	69	java/io/FileNotFoundException
    //   40	47	69	java/io/FileNotFoundException
    //   57	66	69	java/io/FileNotFoundException
    //   110	115	69	java/io/FileNotFoundException
    //   120	127	69	java/io/FileNotFoundException
    //   5	14	144	java/io/IOException
    //   5	14	181	finally
    //   14	23	203	finally
    //   28	35	210	finally
    //   40	47	210	finally
    //   57	66	210	finally
    //   76	89	210	finally
    //   110	115	210	finally
    //   120	127	210	finally
    //   156	169	210	finally
    //   14	23	217	java/io/IOException
    //   28	35	225	java/io/IOException
    //   40	47	225	java/io/IOException
    //   57	66	225	java/io/IOException
    //   110	115	225	java/io/IOException
    //   120	127	225	java/io/IOException
    //   5	14	230	java/io/FileNotFoundException
    //   14	23	240	java/io/FileNotFoundException
  }
  
  public static boolean alT(String paramString)
  {
    AppMethodBeat.i(79645);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79645);
      return false;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) || (paramString.delete()))
    {
      AppMethodBeat.o(79645);
      return true;
    }
    AppMethodBeat.o(79645);
    return false;
  }
  
  public static boolean cN(String paramString)
  {
    AppMethodBeat.i(79646);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79646);
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(79646);
      return true;
    }
    AppMethodBeat.o(79646);
    return false;
  }
  
  public static void e(Closeable paramCloseable)
  {
    AppMethodBeat.i(79644);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(79644);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(79644);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", localIOException, "", new Object[0]);
      ab.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[] { paramCloseable.getClass().getSimpleName(), localIOException.getMessage() }));
      AppMethodBeat.o(79644);
    }
  }
  
  public static long eG(String paramString)
  {
    AppMethodBeat.i(79641);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79641);
      return 0L;
    }
    paramString = new File(paramString);
    if (paramString.isFile())
    {
      long l = paramString.length();
      AppMethodBeat.o(79641);
      return l;
    }
    AppMethodBeat.o(79641);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.d.a
 * JD-Core Version:    0.7.0.1
 */