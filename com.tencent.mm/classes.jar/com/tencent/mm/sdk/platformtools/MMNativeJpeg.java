package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MMNativeJpeg
{
  public static final int FAKE_PARTIAL_PROGRESSIVE_QUALITY = 25;
  public static final String TAG = "MMJPEG.JAVA";
  
  /* Error */
  public static boolean Convert2Baseline(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 33	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   9: ifne +25 -> 34
    //   12: ldc 11
    //   14: ldc 35
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 41	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: ldc 23
    //   29: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_1
    //   33: ireturn
    //   34: aconst_null
    //   35: astore 4
    //   37: aconst_null
    //   38: astore 9
    //   40: aconst_null
    //   41: astore 10
    //   43: aconst_null
    //   44: astore 8
    //   46: aload 4
    //   48: astore 5
    //   50: aload 9
    //   52: astore 6
    //   54: aload 10
    //   56: astore_3
    //   57: aload_0
    //   58: invokestatic 50	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   61: astore 11
    //   63: aload 11
    //   65: astore 7
    //   67: aload 11
    //   69: ifnonnull +38 -> 107
    //   72: aload 4
    //   74: astore 5
    //   76: aload 9
    //   78: astore 6
    //   80: aload 10
    //   82: astore_3
    //   83: ldc 11
    //   85: ldc 52
    //   87: invokestatic 55	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload 4
    //   92: astore 5
    //   94: aload 9
    //   96: astore 6
    //   98: aload 10
    //   100: astore_3
    //   101: aload_0
    //   102: invokestatic 58	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   105: astore 7
    //   107: aload 7
    //   109: ifnull +161 -> 270
    //   112: aload 4
    //   114: astore 5
    //   116: aload 9
    //   118: astore 6
    //   120: aload 10
    //   122: astore_3
    //   123: new 60	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   130: aload_0
    //   131: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 67
    //   136: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore 11
    //   144: aload 4
    //   146: astore 5
    //   148: aload 9
    //   150: astore 6
    //   152: aload 10
    //   154: astore_3
    //   155: getstatic 77	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   158: astore 12
    //   160: aload 4
    //   162: astore 5
    //   164: aload 9
    //   166: astore 6
    //   168: aload 10
    //   170: astore_3
    //   171: aload 11
    //   173: iconst_0
    //   174: invokestatic 83	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   177: astore 4
    //   179: aload 4
    //   181: astore 8
    //   183: aload 4
    //   185: astore 5
    //   187: aload 4
    //   189: astore 6
    //   191: aload 4
    //   193: astore_3
    //   194: aload 7
    //   196: aload 12
    //   198: iload_1
    //   199: aload 4
    //   201: invokevirtual 89	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   204: ifeq +66 -> 270
    //   207: aload 4
    //   209: astore 5
    //   211: aload 4
    //   213: astore 6
    //   215: aload 4
    //   217: astore_3
    //   218: ldc 11
    //   220: ldc 91
    //   222: iconst_1
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload 11
    //   230: aastore
    //   231: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload 4
    //   236: astore 5
    //   238: aload 4
    //   240: astore 6
    //   242: aload 4
    //   244: astore_3
    //   245: aload 11
    //   247: aload_0
    //   248: iconst_1
    //   249: invokestatic 99	com/tencent/mm/sdk/platformtools/m:C	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   252: istore_2
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 104	java/io/OutputStream:close	()V
    //   263: ldc 23
    //   265: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: iload_2
    //   269: ireturn
    //   270: aload 8
    //   272: ifnull +8 -> 280
    //   275: aload 8
    //   277: invokevirtual 104	java/io/OutputStream:close	()V
    //   280: ldc 23
    //   282: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_0
    //   286: ireturn
    //   287: astore_0
    //   288: aload 5
    //   290: astore_3
    //   291: ldc 11
    //   293: ldc 106
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload_0
    //   302: invokestatic 110	com/tencent/mm/sdk/platformtools/MMNativeJpeg:exception2String	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   305: aastore
    //   306: invokestatic 41	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: aload 5
    //   311: ifnull -31 -> 280
    //   314: aload 5
    //   316: invokevirtual 104	java/io/OutputStream:close	()V
    //   319: goto -39 -> 280
    //   322: astore_0
    //   323: goto -43 -> 280
    //   326: astore_0
    //   327: aload 6
    //   329: astore_3
    //   330: ldc 11
    //   332: ldc 112
    //   334: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload 6
    //   339: ifnull -59 -> 280
    //   342: aload 6
    //   344: invokevirtual 104	java/io/OutputStream:close	()V
    //   347: goto -67 -> 280
    //   350: astore_0
    //   351: goto -71 -> 280
    //   354: astore_0
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 104	java/io/OutputStream:close	()V
    //   363: ldc 23
    //   365: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: aload_0
    //   369: athrow
    //   370: astore_0
    //   371: goto -108 -> 263
    //   374: astore_0
    //   375: goto -95 -> 280
    //   378: astore_3
    //   379: goto -16 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramString	String
    //   0	382	1	paramInt	int
    //   252	17	2	bool	boolean
    //   56	304	3	localObject1	Object
    //   378	1	3	localException	Exception
    //   35	224	4	localOutputStream1	java.io.OutputStream
    //   48	267	5	localOutputStream2	java.io.OutputStream
    //   52	291	6	localObject2	Object
    //   65	130	7	localObject3	Object
    //   44	232	8	localOutputStream3	java.io.OutputStream
    //   38	127	9	localObject4	Object
    //   41	128	10	localObject5	Object
    //   61	185	11	localObject6	Object
    //   158	39	12	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   57	63	287	java/lang/Exception
    //   83	90	287	java/lang/Exception
    //   101	107	287	java/lang/Exception
    //   123	144	287	java/lang/Exception
    //   155	160	287	java/lang/Exception
    //   171	179	287	java/lang/Exception
    //   194	207	287	java/lang/Exception
    //   218	234	287	java/lang/Exception
    //   245	253	287	java/lang/Exception
    //   314	319	322	java/lang/Exception
    //   57	63	326	java/lang/OutOfMemoryError
    //   83	90	326	java/lang/OutOfMemoryError
    //   101	107	326	java/lang/OutOfMemoryError
    //   123	144	326	java/lang/OutOfMemoryError
    //   155	160	326	java/lang/OutOfMemoryError
    //   171	179	326	java/lang/OutOfMemoryError
    //   194	207	326	java/lang/OutOfMemoryError
    //   218	234	326	java/lang/OutOfMemoryError
    //   245	253	326	java/lang/OutOfMemoryError
    //   342	347	350	java/lang/Exception
    //   57	63	354	finally
    //   83	90	354	finally
    //   101	107	354	finally
    //   123	144	354	finally
    //   155	160	354	finally
    //   171	179	354	finally
    //   194	207	354	finally
    //   218	234	354	finally
    //   245	253	354	finally
    //   291	309	354	finally
    //   330	337	354	finally
    //   258	263	370	java/lang/Exception
    //   275	280	374	java/lang/Exception
    //   359	363	378	java/lang/Exception
  }
  
  public static void Destroy() {}
  
  public static boolean IsJpegFile(String paramString)
  {
    AppMethodBeat.i(93411);
    try
    {
      if (mmjpeg.queryParams(paramString) == null)
      {
        ab.e("MMJPEG.JAVA", "IsJpegFile : can't query jpeg parames.");
        AppMethodBeat.o(93411);
        return false;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MMJPEG.JAVA", "IsJpegFile exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  private static boolean checkAndroidVersion()
  {
    AppMethodBeat.i(93405);
    if (Build.VERSION.SDK_INT < 11)
    {
      ab.i("MMJPEG.JAVA", "early version before android 3.0  unsupported.");
      AppMethodBeat.o(93405);
      return false;
    }
    AppMethodBeat.o(93405);
    return true;
  }
  
  public static boolean convertToProgressive(String paramString, int paramInt)
  {
    AppMethodBeat.i(93408);
    if (!checkAndroidVersion())
    {
      AppMethodBeat.o(93408);
      return false;
    }
    try
    {
      String str = paramString + ".prog.dat";
      ab.d("MMJPEG.JAVA", "convert %s to %s use progressive.quality:%d", new Object[] { paramString, str, Integer.valueOf(paramInt) });
      paramInt = mmjpeg.convertToProgressive(paramString, str);
      if (paramInt != 0)
      {
        ab.e("MMJPEG.JAVA", "convert failed. error:%d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(93408);
        return false;
      }
      boolean bool = e.aT(str, paramString);
      ab.i("MMJPEG.JAVA", "convert ret:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93408);
      return bool;
    }
    catch (Exception paramString)
    {
      ab.e("MMJPEG.JAVA", "convertToProgressive exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(93408);
    }
    return false;
  }
  
  public static Bitmap decodeAsBitmap(String paramString)
  {
    AppMethodBeat.i(93409);
    ab.v("MMJPEG.JAVA", "decodeAsBitmap:%s", new Object[] { paramString });
    try
    {
      Object localObject = mmjpeg.queryParams(paramString);
      if (localObject == null)
      {
        ab.e("MMJPEG.JAVA", "can't query jpeg parames.");
        AppMethodBeat.o(93409);
        return null;
      }
      localObject = Bitmap.createBitmap(((JpegParams)localObject).Width, ((JpegParams)localObject).Height, Bitmap.Config.ARGB_8888);
      if (mmjpeg.decodeToBitmap(paramString, (Bitmap)localObject))
      {
        ab.i("MMJPEG.JAVA", "decode bitmap successed.");
        AppMethodBeat.o(93409);
        return localObject;
      }
      ab.e("MMJPEG.JAVA", "can't decode to bmp.");
      AppMethodBeat.o(93409);
      return null;
    }
    catch (Exception paramString)
    {
      ab.e("MMJPEG.JAVA", "decodeAsBitmap exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(93409);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ab.e("MMJPEG.JAVA", "decodeAsBitmap OOM:%s", new Object[] { paramString });
      AppMethodBeat.o(93409);
    }
    return null;
  }
  
  private static String exception2String(Throwable paramThrowable)
  {
    AppMethodBeat.i(93404);
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    paramThrowable = localStringWriter.toString();
    AppMethodBeat.o(93404);
    return paramThrowable;
  }
  
  public static boolean isProgressive(String paramString)
  {
    AppMethodBeat.i(93407);
    ab.v("MMJPEG.JAVA", "isProgressive:%s", new Object[] { paramString });
    if (!checkAndroidVersion())
    {
      AppMethodBeat.o(93407);
      return false;
    }
    if (!e.cN(paramString))
    {
      AppMethodBeat.o(93407);
      return false;
    }
    ab.d("MMJPEG.JAVA", "check progressive for file:%s", new Object[] { paramString });
    try
    {
      int i = mmjpeg.isProgressiveFile(paramString);
      if ((1 != i) && (i != 0))
      {
        ab.e("MMJPEG.JAVA", "check failed. error:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(93407);
        return false;
      }
      ab.i("MMJPEG.JAVA", "file:%s progressive:%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(93407);
        return true;
      }
      AppMethodBeat.o(93407);
      return false;
    }
    catch (Exception paramString)
    {
      ab.e("MMJPEG.JAVA", "isProgressive exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(93407);
    }
    return false;
  }
  
  public static int queryQuality(String paramString)
  {
    AppMethodBeat.i(93406);
    if (!checkAndroidVersion())
    {
      AppMethodBeat.o(93406);
      return 0;
    }
    if (!e.cN(paramString))
    {
      AppMethodBeat.o(93406);
      return 0;
    }
    try
    {
      int i = mmjpeg.queryQuality(paramString);
      ab.i("MMJPEG.JAVA", "after query quality:%d", new Object[] { Integer.valueOf(i) });
      if ((i < 10000) && (i >= 24))
      {
        AppMethodBeat.o(93406);
        return i;
      }
      i = mmjpeg.isProgressiveFile(paramString);
      if (1 == i)
      {
        AppMethodBeat.o(93406);
        return 25;
      }
      ab.w("MMJPEG.JAVA", "invalid jpeg file or too small quality.");
      AppMethodBeat.o(93406);
      return 0;
    }
    catch (Exception paramString)
    {
      ab.e("MMJPEG.JAVA", "queryQuality failed. exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(93406);
      return 0;
    }
    catch (IncompatibleClassChangeError paramString)
    {
      ab.printErrStackTrace("MicroMsg.Crash", paramString, "May cause dvmFindCatchBlock crash!", new Object[0]);
      paramString = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramString);
      AppMethodBeat.o(93406);
      throw paramString;
    }
    catch (Error paramString)
    {
      ab.e("MMJPEG.JAVA", "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(93406);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMNativeJpeg
 * JD-Core Version:    0.7.0.1
 */