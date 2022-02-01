package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
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
    //   24: invokestatic 41	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   58: invokestatic 50	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
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
    //   87: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   109: ifnull +160 -> 269
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
    //   173: invokestatic 83	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   176: astore 4
    //   178: aload 4
    //   180: astore 8
    //   182: aload 4
    //   184: astore 5
    //   186: aload 4
    //   188: astore 6
    //   190: aload 4
    //   192: astore_3
    //   193: aload 7
    //   195: aload 12
    //   197: iload_1
    //   198: aload 4
    //   200: invokevirtual 89	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   203: ifeq +66 -> 269
    //   206: aload 4
    //   208: astore 5
    //   210: aload 4
    //   212: astore 6
    //   214: aload 4
    //   216: astore_3
    //   217: ldc 11
    //   219: ldc 91
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload 11
    //   229: aastore
    //   230: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: aload 4
    //   235: astore 5
    //   237: aload 4
    //   239: astore 6
    //   241: aload 4
    //   243: astore_3
    //   244: aload 11
    //   246: aload_0
    //   247: iconst_1
    //   248: invokestatic 99	com/tencent/mm/sdk/platformtools/FilesCopy:copy	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   251: istore_2
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 104	java/io/OutputStream:close	()V
    //   262: ldc 23
    //   264: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: iload_2
    //   268: ireturn
    //   269: aload 8
    //   271: ifnull +8 -> 279
    //   274: aload 8
    //   276: invokevirtual 104	java/io/OutputStream:close	()V
    //   279: ldc 23
    //   281: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore_0
    //   287: aload 5
    //   289: astore_3
    //   290: ldc 11
    //   292: ldc 106
    //   294: iconst_1
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_0
    //   301: invokestatic 110	com/tencent/mm/sdk/platformtools/MMNativeJpeg:exception2String	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 41	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: aload 5
    //   310: ifnull -31 -> 279
    //   313: aload 5
    //   315: invokevirtual 104	java/io/OutputStream:close	()V
    //   318: goto -39 -> 279
    //   321: astore_0
    //   322: goto -43 -> 279
    //   325: astore_0
    //   326: aload 6
    //   328: astore_3
    //   329: ldc 11
    //   331: ldc 112
    //   333: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload 6
    //   338: ifnull -59 -> 279
    //   341: aload 6
    //   343: invokevirtual 104	java/io/OutputStream:close	()V
    //   346: goto -67 -> 279
    //   349: astore_0
    //   350: goto -71 -> 279
    //   353: astore_0
    //   354: aload_3
    //   355: ifnull +7 -> 362
    //   358: aload_3
    //   359: invokevirtual 104	java/io/OutputStream:close	()V
    //   362: ldc 23
    //   364: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aload_0
    //   368: athrow
    //   369: astore_0
    //   370: goto -108 -> 262
    //   373: astore_0
    //   374: goto -95 -> 279
    //   377: astore_3
    //   378: goto -16 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramString	String
    //   0	381	1	paramInt	int
    //   251	17	2	bool	boolean
    //   56	303	3	localObject1	Object
    //   377	1	3	localException	Exception
    //   35	223	4	localOutputStream1	java.io.OutputStream
    //   48	266	5	localOutputStream2	java.io.OutputStream
    //   52	290	6	localObject2	Object
    //   65	129	7	localObject3	Object
    //   44	231	8	localOutputStream3	java.io.OutputStream
    //   38	127	9	localObject4	Object
    //   41	128	10	localObject5	Object
    //   61	184	11	localObject6	Object
    //   158	38	12	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   57	63	286	java/lang/Exception
    //   83	90	286	java/lang/Exception
    //   101	107	286	java/lang/Exception
    //   123	144	286	java/lang/Exception
    //   155	160	286	java/lang/Exception
    //   171	178	286	java/lang/Exception
    //   193	206	286	java/lang/Exception
    //   217	233	286	java/lang/Exception
    //   244	252	286	java/lang/Exception
    //   313	318	321	java/lang/Exception
    //   57	63	325	java/lang/OutOfMemoryError
    //   83	90	325	java/lang/OutOfMemoryError
    //   101	107	325	java/lang/OutOfMemoryError
    //   123	144	325	java/lang/OutOfMemoryError
    //   155	160	325	java/lang/OutOfMemoryError
    //   171	178	325	java/lang/OutOfMemoryError
    //   193	206	325	java/lang/OutOfMemoryError
    //   217	233	325	java/lang/OutOfMemoryError
    //   244	252	325	java/lang/OutOfMemoryError
    //   341	346	349	java/lang/Exception
    //   57	63	353	finally
    //   83	90	353	finally
    //   101	107	353	finally
    //   123	144	353	finally
    //   155	160	353	finally
    //   171	178	353	finally
    //   193	206	353	finally
    //   217	233	353	finally
    //   244	252	353	finally
    //   290	308	353	finally
    //   329	336	353	finally
    //   257	262	369	java/lang/Exception
    //   274	279	373	java/lang/Exception
    //   358	362	377	java/lang/Exception
  }
  
  public static void Destroy() {}
  
  public static boolean IsJpegFile(String paramString)
  {
    AppMethodBeat.i(156201);
    try
    {
      if (mmjpeg.queryParams(toRealPath(paramString)) == null)
      {
        Log.e("MMJPEG.JAVA", "IsJpegFile : can't query jpeg parames.");
        AppMethodBeat.o(156201);
        return false;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MMJPEG.JAVA", "IsJpegFile exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(156201);
      return false;
    }
    AppMethodBeat.o(156201);
    return true;
  }
  
  private static boolean checkAndroidVersion()
  {
    AppMethodBeat.i(156194);
    if (Build.VERSION.SDK_INT < 11)
    {
      Log.i("MMJPEG.JAVA", "early version before android 3.0  unsupported.");
      AppMethodBeat.o(156194);
      return false;
    }
    AppMethodBeat.o(156194);
    return true;
  }
  
  public static boolean convertToProgressive(String paramString, int paramInt)
  {
    AppMethodBeat.i(156198);
    if (!checkAndroidVersion())
    {
      AppMethodBeat.o(156198);
      return false;
    }
    paramString = toRealPath(paramString);
    try
    {
      String str = paramString + ".prog.dat";
      Log.i("MMJPEG.JAVA", "convert %s to %s use progressive.quality:%d", new Object[] { paramString, str, Integer.valueOf(paramInt) });
      paramInt = mmjpeg.convertToProgressive(paramString, str);
      if (paramInt != 0)
      {
        Log.e("MMJPEG.JAVA", "convert failed. error:%d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(156198);
        return false;
      }
      boolean bool = u.oo(str, paramString);
      Log.i("MMJPEG.JAVA", "convert ret:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(156198);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("MMJPEG.JAVA", "convertToProgressive exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(156198);
    }
    return false;
  }
  
  public static Bitmap decodeAsBitmap(String paramString)
  {
    AppMethodBeat.i(156199);
    Log.i("MMJPEG.JAVA", "decodeAsBitmap:%s", new Object[] { paramString });
    paramString = toRealPath(paramString);
    try
    {
      Object localObject = mmjpeg.queryParams(paramString);
      if (localObject == null)
      {
        Log.e("MMJPEG.JAVA", "can't query jpeg parames.");
        AppMethodBeat.o(156199);
        return null;
      }
      localObject = Bitmap.createBitmap(((JpegParams)localObject).Width, ((JpegParams)localObject).Height, Bitmap.Config.ARGB_8888);
      if (mmjpeg.decodeToBitmap(paramString, (Bitmap)localObject))
      {
        Log.i("MMJPEG.JAVA", "decode bitmap successed.");
        AppMethodBeat.o(156199);
        return localObject;
      }
      Log.e("MMJPEG.JAVA", "can't decode to bmp.");
      AppMethodBeat.o(156199);
      return null;
    }
    catch (Exception paramString)
    {
      Log.e("MMJPEG.JAVA", "decodeAsBitmap exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(156199);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("MMJPEG.JAVA", "decodeAsBitmap OOM:%s", new Object[] { paramString });
      AppMethodBeat.o(156199);
    }
    return null;
  }
  
  private static String exception2String(Throwable paramThrowable)
  {
    AppMethodBeat.i(156193);
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    paramThrowable = localStringWriter.toString();
    AppMethodBeat.o(156193);
    return paramThrowable;
  }
  
  public static boolean isProgressive(String paramString)
  {
    AppMethodBeat.i(156197);
    Log.v("MMJPEG.JAVA", "isProgressive:%s", new Object[] { paramString });
    if (!checkAndroidVersion())
    {
      AppMethodBeat.o(156197);
      return false;
    }
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(156197);
      return false;
    }
    paramString = toRealPath(paramString);
    Log.d("MMJPEG.JAVA", "check progressive for file:%s", new Object[] { paramString });
    try
    {
      int i = mmjpeg.isProgressiveFile(paramString);
      if ((1 != i) && (i != 0))
      {
        Log.e("MMJPEG.JAVA", "check failed. error:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(156197);
        return false;
      }
      Log.i("MMJPEG.JAVA", "file:%s progressive:%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(156197);
        return true;
      }
      AppMethodBeat.o(156197);
      return false;
    }
    catch (Exception paramString)
    {
      Log.e("MMJPEG.JAVA", "isProgressive exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(156197);
    }
    return false;
  }
  
  public static int queryQuality(String paramString)
  {
    AppMethodBeat.i(156196);
    if (!checkAndroidVersion())
    {
      AppMethodBeat.o(156196);
      return 0;
    }
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(156196);
      return 0;
    }
    paramString = toRealPath(paramString);
    try
    {
      int i = mmjpeg.queryQuality(paramString);
      Log.i("MMJPEG.JAVA", "after query quality:%d", new Object[] { Integer.valueOf(i) });
      if ((i < 10000) && (i >= 24))
      {
        AppMethodBeat.o(156196);
        return i;
      }
      i = mmjpeg.isProgressiveFile(paramString);
      if (1 == i)
      {
        AppMethodBeat.o(156196);
        return 25;
      }
      Log.w("MMJPEG.JAVA", "invalid jpeg file or too small quality.");
      AppMethodBeat.o(156196);
      return 0;
    }
    catch (Exception paramString)
    {
      Log.e("MMJPEG.JAVA", "queryQuality failed. exception:%s", new Object[] { exception2String(paramString) });
      AppMethodBeat.o(156196);
      return 0;
    }
    catch (IncompatibleClassChangeError paramString)
    {
      Log.printErrStackTrace("MicroMsg.Crash", paramString, "May cause dvmFindCatchBlock crash!", new Object[0]);
      paramString = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramString);
      AppMethodBeat.o(156196);
      throw paramString;
    }
    catch (Error paramString)
    {
      Log.e("MMJPEG.JAVA", "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", new Object[] { paramString.toString() });
      AppMethodBeat.o(156196);
    }
    return 0;
  }
  
  private static String toRealPath(String paramString)
  {
    AppMethodBeat.i(156195);
    try
    {
      String str3 = u.n(paramString, false);
      str1 = paramString;
      if (str3 != null)
      {
        Log.i("MMJPEG.JAVA", "From %s to real path %s", new Object[] { paramString, str3 });
        str1 = str3;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        Log.printErrStackTrace("MMJPEG.JAVA", localThrowable, "to real path", new Object[0]);
        String str2 = paramString;
      }
    }
    AppMethodBeat.o(156195);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMNativeJpeg
 * JD-Core Version:    0.7.0.1
 */