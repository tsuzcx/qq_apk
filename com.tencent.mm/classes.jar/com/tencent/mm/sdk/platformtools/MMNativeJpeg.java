package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
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
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: invokestatic 26	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   6: ifne +20 -> 26
    //   9: ldc 11
    //   11: ldc 28
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: aastore
    //   21: invokestatic 34	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iload_2
    //   25: ireturn
    //   26: aconst_null
    //   27: astore 5
    //   29: aconst_null
    //   30: astore 10
    //   32: aconst_null
    //   33: astore 11
    //   35: aconst_null
    //   36: astore 9
    //   38: aload 5
    //   40: astore 6
    //   42: aload 10
    //   44: astore 7
    //   46: aload 11
    //   48: astore 4
    //   50: aload_0
    //   51: invokestatic 40	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   54: astore 12
    //   56: aload 12
    //   58: astore 8
    //   60: aload 12
    //   62: ifnonnull +40 -> 102
    //   65: aload 5
    //   67: astore 6
    //   69: aload 10
    //   71: astore 7
    //   73: aload 11
    //   75: astore 4
    //   77: ldc 11
    //   79: ldc 42
    //   81: invokestatic 46	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 5
    //   86: astore 6
    //   88: aload 10
    //   90: astore 7
    //   92: aload 11
    //   94: astore 4
    //   96: aload_0
    //   97: invokestatic 49	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   100: astore 8
    //   102: aload 8
    //   104: ifnull +167 -> 271
    //   107: aload 5
    //   109: astore 6
    //   111: aload 10
    //   113: astore 7
    //   115: aload 11
    //   117: astore 4
    //   119: new 51	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   126: aload_0
    //   127: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 58
    //   132: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 12
    //   140: aload 5
    //   142: astore 6
    //   144: aload 10
    //   146: astore 7
    //   148: aload 11
    //   150: astore 4
    //   152: getstatic 68	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   155: astore 13
    //   157: aload 5
    //   159: astore 6
    //   161: aload 10
    //   163: astore 7
    //   165: aload 11
    //   167: astore 4
    //   169: aload 12
    //   171: iconst_0
    //   172: invokestatic 73	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   175: astore 5
    //   177: aload 5
    //   179: astore 9
    //   181: aload 5
    //   183: astore 6
    //   185: aload 5
    //   187: astore 7
    //   189: aload 5
    //   191: astore 4
    //   193: aload 8
    //   195: aload 13
    //   197: iload_1
    //   198: aload 5
    //   200: invokevirtual 79	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   203: ifeq +68 -> 271
    //   206: aload 5
    //   208: astore 6
    //   210: aload 5
    //   212: astore 7
    //   214: aload 5
    //   216: astore 4
    //   218: ldc 11
    //   220: ldc 81
    //   222: iconst_1
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload 12
    //   230: aastore
    //   231: invokestatic 83	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload 5
    //   236: astore 6
    //   238: aload 5
    //   240: astore 7
    //   242: aload 5
    //   244: astore 4
    //   246: aload 12
    //   248: aload_0
    //   249: iconst_1
    //   250: invokestatic 89	com/tencent/mm/sdk/platformtools/j:u	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   253: istore_3
    //   254: iload_3
    //   255: istore_2
    //   256: aload 5
    //   258: ifnull -234 -> 24
    //   261: aload 5
    //   263: invokevirtual 94	java/io/OutputStream:close	()V
    //   266: iload_3
    //   267: ireturn
    //   268: astore_0
    //   269: iload_3
    //   270: ireturn
    //   271: aload 9
    //   273: ifnull +8 -> 281
    //   276: aload 9
    //   278: invokevirtual 94	java/io/OutputStream:close	()V
    //   281: iconst_0
    //   282: ireturn
    //   283: astore_0
    //   284: aload 6
    //   286: astore 4
    //   288: ldc 11
    //   290: ldc 96
    //   292: iconst_1
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_0
    //   299: invokestatic 100	com/tencent/mm/sdk/platformtools/MMNativeJpeg:exception2String	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: aastore
    //   303: invokestatic 34	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: aload 6
    //   308: ifnull -27 -> 281
    //   311: aload 6
    //   313: invokevirtual 94	java/io/OutputStream:close	()V
    //   316: goto -35 -> 281
    //   319: astore_0
    //   320: goto -39 -> 281
    //   323: astore_0
    //   324: aload 7
    //   326: astore 4
    //   328: ldc 11
    //   330: ldc 102
    //   332: invokestatic 104	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 7
    //   337: ifnull -56 -> 281
    //   340: aload 7
    //   342: invokevirtual 94	java/io/OutputStream:close	()V
    //   345: goto -64 -> 281
    //   348: astore_0
    //   349: goto -68 -> 281
    //   352: astore_0
    //   353: aload 4
    //   355: ifnull +8 -> 363
    //   358: aload 4
    //   360: invokevirtual 94	java/io/OutputStream:close	()V
    //   363: aload_0
    //   364: athrow
    //   365: astore_0
    //   366: goto -85 -> 281
    //   369: astore 4
    //   371: goto -8 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramString	String
    //   0	374	1	paramInt	int
    //   1	255	2	bool1	boolean
    //   253	17	3	bool2	boolean
    //   48	311	4	localObject1	Object
    //   369	1	4	localException	Exception
    //   27	235	5	localOutputStream1	java.io.OutputStream
    //   40	272	6	localOutputStream2	java.io.OutputStream
    //   44	297	7	localObject2	Object
    //   58	136	8	localObject3	Object
    //   36	241	9	localOutputStream3	java.io.OutputStream
    //   30	132	10	localObject4	Object
    //   33	133	11	localObject5	Object
    //   54	193	12	localObject6	Object
    //   155	41	13	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   261	266	268	java/lang/Exception
    //   50	56	283	java/lang/Exception
    //   77	84	283	java/lang/Exception
    //   96	102	283	java/lang/Exception
    //   119	140	283	java/lang/Exception
    //   152	157	283	java/lang/Exception
    //   169	177	283	java/lang/Exception
    //   193	206	283	java/lang/Exception
    //   218	234	283	java/lang/Exception
    //   246	254	283	java/lang/Exception
    //   311	316	319	java/lang/Exception
    //   50	56	323	java/lang/OutOfMemoryError
    //   77	84	323	java/lang/OutOfMemoryError
    //   96	102	323	java/lang/OutOfMemoryError
    //   119	140	323	java/lang/OutOfMemoryError
    //   152	157	323	java/lang/OutOfMemoryError
    //   169	177	323	java/lang/OutOfMemoryError
    //   193	206	323	java/lang/OutOfMemoryError
    //   218	234	323	java/lang/OutOfMemoryError
    //   246	254	323	java/lang/OutOfMemoryError
    //   340	345	348	java/lang/Exception
    //   50	56	352	finally
    //   77	84	352	finally
    //   96	102	352	finally
    //   119	140	352	finally
    //   152	157	352	finally
    //   169	177	352	finally
    //   193	206	352	finally
    //   218	234	352	finally
    //   246	254	352	finally
    //   288	306	352	finally
    //   328	335	352	finally
    //   276	281	365	java/lang/Exception
    //   358	363	369	java/lang/Exception
  }
  
  public static void Destroy() {}
  
  public static boolean IsJpegFile(String paramString)
  {
    try
    {
      if (mmjpeg.queryParams(paramString) == null)
      {
        y.e("MMJPEG.JAVA", "IsJpegFile : can't query jpeg parames.");
        return false;
      }
    }
    catch (Exception paramString)
    {
      y.e("MMJPEG.JAVA", "IsJpegFile exception:%s", new Object[] { exception2String(paramString) });
      return false;
    }
    return true;
  }
  
  private static boolean checkAndroidVersion()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      y.i("MMJPEG.JAVA", "early version before android 3.0  unsupported.");
      return false;
    }
    return true;
  }
  
  public static boolean convertToProgressive(String paramString, int paramInt)
  {
    if (!checkAndroidVersion()) {
      return false;
    }
    String str;
    try
    {
      str = paramString + ".prog.dat";
      y.d("MMJPEG.JAVA", "convert %s to %s use progressive.quality:%d", new Object[] { paramString, str, Integer.valueOf(paramInt) });
      paramInt = mmjpeg.convertToProgressive(paramString, str);
      if (paramInt != 0)
      {
        y.e("MMJPEG.JAVA", "convert failed. error:%d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
    }
    catch (Exception paramString)
    {
      y.e("MMJPEG.JAVA", "convertToProgressive exception:%s", new Object[] { exception2String(paramString) });
      return false;
    }
    boolean bool = e.aA(str, paramString);
    y.i("MMJPEG.JAVA", "convert ret:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static Bitmap decodeAsBitmap(String paramString)
  {
    y.v("MMJPEG.JAVA", "decodeAsBitmap:%s", new Object[] { paramString });
    try
    {
      Object localObject = mmjpeg.queryParams(paramString);
      if (localObject == null)
      {
        y.e("MMJPEG.JAVA", "can't query jpeg parames.");
        return null;
      }
      localObject = Bitmap.createBitmap(((JpegParams)localObject).Width, ((JpegParams)localObject).Height, Bitmap.Config.ARGB_8888);
      if (mmjpeg.decodeToBitmap(paramString, (Bitmap)localObject))
      {
        y.i("MMJPEG.JAVA", "decode bitmap successed.");
        return localObject;
      }
      y.e("MMJPEG.JAVA", "can't decode to bmp.");
      return null;
    }
    catch (Exception paramString)
    {
      y.e("MMJPEG.JAVA", "decodeAsBitmap exception:%s", new Object[] { exception2String(paramString) });
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      y.e("MMJPEG.JAVA", "decodeAsBitmap OOM:%s", new Object[] { paramString });
    }
    return null;
  }
  
  private static String exception2String(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static boolean isProgressive(String paramString)
  {
    y.v("MMJPEG.JAVA", "isProgressive:%s", new Object[] { paramString });
    if (!checkAndroidVersion()) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (!e.bK(paramString));
      y.d("MMJPEG.JAVA", "check progressive for file:%s", new Object[] { paramString });
      try
      {
        i = mmjpeg.isProgressiveFile(paramString);
        if ((1 != i) && (i != 0))
        {
          y.e("MMJPEG.JAVA", "check failed. error:%d", new Object[] { Integer.valueOf(i) });
          return false;
        }
      }
      catch (Exception paramString)
      {
        y.e("MMJPEG.JAVA", "isProgressive exception:%s", new Object[] { exception2String(paramString) });
        return false;
      }
      y.i("MMJPEG.JAVA", "file:%s progressive:%d", new Object[] { paramString, Integer.valueOf(i) });
    } while (i != 1);
    return true;
  }
  
  public static int queryQuality(String paramString)
  {
    if (!checkAndroidVersion()) {}
    while (!e.bK(paramString)) {
      return 0;
    }
    try
    {
      int i = mmjpeg.queryQuality(paramString);
      y.i("MMJPEG.JAVA", "after query quality:%d", new Object[] { Integer.valueOf(i) });
      if ((i < 10000) && (i >= 24)) {
        return i;
      }
      if (1 == mmjpeg.isProgressiveFile(paramString)) {
        return 25;
      }
      y.w("MMJPEG.JAVA", "invalid jpeg file or too small quality.");
      return 0;
    }
    catch (Exception paramString)
    {
      y.e("MMJPEG.JAVA", "queryQuality failed. exception:%s", new Object[] { exception2String(paramString) });
      return 0;
    }
    catch (IncompatibleClassChangeError paramString)
    {
      y.printErrStackTrace("MicroMsg.Crash", paramString, "May cause dvmFindCatchBlock crash!", new Object[0]);
      throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramString));
    }
    catch (Error paramString)
    {
      y.e("MMJPEG.JAVA", "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", new Object[] { paramString.toString() });
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMNativeJpeg
 * JD-Core Version:    0.7.0.1
 */