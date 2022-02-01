package com.tencent.mm.pluginsdk.h.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class a
{
  /* Error */
  public static byte[] aBs(String paramString)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 23	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: new 25	java/io/ByteArrayOutputStream
    //   13: dup
    //   14: invokespecial 29	java/io/ByteArrayOutputStream:<init>	()V
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload_0
    //   23: astore_2
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore 5
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: astore_2
    //   36: aload_0
    //   37: aload 5
    //   39: invokevirtual 35	java/io/InputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_m1
    //   45: if_icmpeq +56 -> 101
    //   48: aload 4
    //   50: astore_3
    //   51: aload_0
    //   52: astore_2
    //   53: aload 4
    //   55: aload 5
    //   57: iconst_0
    //   58: iload_1
    //   59: invokevirtual 39	java/io/ByteArrayOutputStream:write	([BII)V
    //   62: goto -31 -> 31
    //   65: astore 5
    //   67: aload 4
    //   69: astore_3
    //   70: aload_0
    //   71: astore_2
    //   72: ldc 41
    //   74: aload 5
    //   76: ldc 43
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 49	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_0
    //   86: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   89: aload 4
    //   91: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   94: ldc 11
    //   96: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload 4
    //   103: astore_3
    //   104: aload_0
    //   105: astore_2
    //   106: aload 4
    //   108: invokevirtual 59	java/io/ByteArrayOutputStream:flush	()V
    //   111: aload 4
    //   113: astore_3
    //   114: aload_0
    //   115: astore_2
    //   116: aload 4
    //   118: invokevirtual 63	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   121: astore 5
    //   123: aload_0
    //   124: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   127: aload 4
    //   129: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   132: ldc 11
    //   134: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload 5
    //   139: areturn
    //   140: astore 5
    //   142: aconst_null
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_0
    //   147: aload 4
    //   149: astore_3
    //   150: aload_0
    //   151: astore_2
    //   152: ldc 41
    //   154: aload 5
    //   156: ldc 43
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 49	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload_0
    //   166: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   169: aload 4
    //   171: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   174: goto -80 -> 94
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_3
    //   181: aconst_null
    //   182: astore_0
    //   183: aload_0
    //   184: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   187: aload_3
    //   188: invokestatic 53	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   191: ldc 11
    //   193: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload 4
    //   198: athrow
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_3
    //   203: goto -20 -> 183
    //   206: astore 4
    //   208: aload_2
    //   209: astore_0
    //   210: goto -27 -> 183
    //   213: astore 5
    //   215: aconst_null
    //   216: astore 4
    //   218: goto -71 -> 147
    //   221: astore 5
    //   223: goto -76 -> 147
    //   226: astore 5
    //   228: aconst_null
    //   229: astore 4
    //   231: aconst_null
    //   232: astore_0
    //   233: goto -166 -> 67
    //   236: astore 5
    //   238: aconst_null
    //   239: astore 4
    //   241: goto -174 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramString	String
    //   42	17	1	i	int
    //   23	186	2	str	String
    //   21	182	3	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   17	153	4	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   177	20	4	localObject1	Object
    //   199	1	4	localObject2	Object
    //   206	1	4	localObject3	Object
    //   216	24	4	localObject4	Object
    //   29	27	5	arrayOfByte1	byte[]
    //   65	10	5	localFileNotFoundException1	FileNotFoundException
    //   121	17	5	arrayOfByte2	byte[]
    //   140	15	5	localIOException1	IOException
    //   213	1	5	localIOException2	IOException
    //   221	1	5	localIOException3	IOException
    //   226	1	5	localFileNotFoundException2	FileNotFoundException
    //   236	1	5	localFileNotFoundException3	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   24	31	65	java/io/FileNotFoundException
    //   36	43	65	java/io/FileNotFoundException
    //   53	62	65	java/io/FileNotFoundException
    //   106	111	65	java/io/FileNotFoundException
    //   116	123	65	java/io/FileNotFoundException
    //   5	10	140	java/io/IOException
    //   5	10	177	finally
    //   10	19	199	finally
    //   24	31	206	finally
    //   36	43	206	finally
    //   53	62	206	finally
    //   72	85	206	finally
    //   106	111	206	finally
    //   116	123	206	finally
    //   152	165	206	finally
    //   10	19	213	java/io/IOException
    //   24	31	221	java/io/IOException
    //   36	43	221	java/io/IOException
    //   53	62	221	java/io/IOException
    //   106	111	221	java/io/IOException
    //   116	123	221	java/io/IOException
    //   5	10	226	java/io/FileNotFoundException
    //   10	19	236	java/io/FileNotFoundException
  }
  
  public static boolean aBt(String paramString)
  {
    AppMethodBeat.i(152088);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152088);
      return false;
    }
    paramString = new e(paramString);
    if ((!paramString.exists()) || (paramString.delete()))
    {
      AppMethodBeat.o(152088);
      return true;
    }
    AppMethodBeat.o(152088);
    return false;
  }
  
  public static void c(Closeable paramCloseable)
  {
    AppMethodBeat.i(152087);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(152087);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(152087);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", localIOException, "", new Object[0]);
      ad.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[] { paramCloseable.getClass().getSimpleName(), localIOException.getMessage() }));
      AppMethodBeat.o(152087);
    }
  }
  
  public static boolean eK(String paramString)
  {
    AppMethodBeat.i(152089);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152089);
      return false;
    }
    paramString = new e(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(152089);
      return true;
    }
    AppMethodBeat.o(152089);
    return false;
  }
  
  public static long fN(String paramString)
  {
    AppMethodBeat.i(152084);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152084);
      return 0L;
    }
    paramString = new e(paramString);
    if (paramString.isFile())
    {
      long l = paramString.length();
      AppMethodBeat.o(152084);
      return l;
    }
    AppMethodBeat.o(152084);
    return 0L;
  }
  
  public static boolean x(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152085);
    if (bt.cw(paramArrayOfByte))
    {
      AppMethodBeat.o(152085);
      return false;
    }
    Object localObject3 = new e(paramString);
    ((e)localObject3).delete();
    ((e)localObject3).fhT().mkdirs();
    Object localObject2 = null;
    paramString = null;
    Object localObject1 = null;
    try
    {
      localObject3 = i.ai((e)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramString = (String)localObject3;
      ((OutputStream)localObject3).write(paramArrayOfByte);
      if (localObject3 != null) {}
      try
      {
        ((OutputStream)localObject3).flush();
        ((OutputStream)localObject3).close();
        AppMethodBeat.o(152085);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", paramString, "", new Object[0]);
        }
      }
      try
      {
        paramString.flush();
        paramString.close();
        AppMethodBeat.o(152085);
        throw paramArrayOfByte;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", paramString, "", new Object[0]);
        }
      }
    }
    catch (FileNotFoundException paramArrayOfByte)
    {
      paramString = localObject1;
      ad.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", paramArrayOfByte, "", new Object[0]);
      if (localObject1 != null) {}
      try
      {
        localObject1.flush();
        localObject1.close();
        AppMethodBeat.o(152085);
        return false;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", paramString, "", new Object[0]);
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        paramString = localObject2;
        ad.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", paramArrayOfByte, "", new Object[0]);
        if (localObject2 != null) {
          try
          {
            localObject2.flush();
            localObject2.close();
          }
          catch (IOException paramString)
          {
            ad.printErrStackTrace("MicroMsg.ResDownloaderFileUtils", paramString, "", new Object[0]);
          }
        }
      }
    }
    finally
    {
      if (paramString == null) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.d.a
 * JD-Core Version:    0.7.0.1
 */