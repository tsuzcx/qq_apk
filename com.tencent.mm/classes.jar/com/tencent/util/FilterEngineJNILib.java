package com.tencent.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Environment;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterEngineJNILib
{
  private static long mLastDate = 0L;
  private static int mSameSecondCount = 0;
  
  public static String generateBundlePath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(86584);
    if (paramString2 != null) {}
    for (paramString2 = paramString1 + "." + paramString2;; paramString2 = paramString1)
    {
      if (new File(paramString2).exists())
      {
        AppMethodBeat.o(86584);
        return paramString2;
      }
      Object localObject = com.tencent.view.b.BzH;
      if (localObject == null)
      {
        AppMethodBeat.o(86584);
        return null;
      }
      localObject = ((Context)localObject).getDir("filter", 0);
      if ((!((File)localObject).isDirectory()) && (!((File)localObject).mkdirs()))
      {
        AppMethodBeat.o(86584);
        return null;
      }
      localObject = new File((File)localObject, paramString2);
      FileOutputStream localFileOutputStream;
      if (!((File)localObject).exists())
      {
        ((File)localObject).mkdirs();
        ((File)localObject).delete();
        try
        {
          paramString2 = com.tencent.view.b.axl(paramString2);
          if (paramString2 == null) {
            break label202;
          }
          paramString1 = new byte[1024];
          ((File)localObject).createNewFile();
          localFileOutputStream = new FileOutputStream((File)localObject);
          for (;;)
          {
            int i = paramString2.read(paramString1);
            if (i == -1) {
              break;
            }
            localFileOutputStream.write(paramString1, 0, i);
          }
          paramString1 = ((File)localObject).getAbsolutePath();
        }
        catch (IOException paramString1) {}
      }
      for (;;)
      {
        AppMethodBeat.o(86584);
        return paramString1;
        paramString2.close();
        localFileOutputStream.close();
      }
      label202:
      i.l("filter", "generateBundlePath notfound".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(86584);
      return null;
    }
  }
  
  /* Error */
  private static String generateName(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 130
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 132	java/text/SimpleDateFormat
    //   11: dup
    //   12: ldc 134
    //   14: invokespecial 135	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   17: new 137	java/util/Date
    //   20: dup
    //   21: lload_0
    //   22: invokespecial 140	java/util/Date:<init>	(J)V
    //   25: invokevirtual 144	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   28: astore_2
    //   29: lload_0
    //   30: ldc2_w 145
    //   33: ldiv
    //   34: getstatic 12	com/tencent/util/FilterEngineJNILib:mLastDate	J
    //   37: ldc2_w 145
    //   40: ldiv
    //   41: lcmp
    //   42: ifne +47 -> 89
    //   45: getstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   48: iconst_1
    //   49: iadd
    //   50: putstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   53: new 31	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   60: aload_2
    //   61: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 148
    //   66: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: getstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   72: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_2
    //   79: ldc 130
    //   81: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_2
    //   88: areturn
    //   89: lload_0
    //   90: putstatic 12	com/tencent/util/FilterEngineJNILib:mLastDate	J
    //   93: iconst_0
    //   94: putstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   97: goto -18 -> 79
    //   100: astore_2
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramLong	long
    //   28	60	2	str	String
    //   100	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	79	100	finally
    //   79	84	100	finally
    //   89	97	100	finally
  }
  
  public static byte[] getAssetContents(String paramString)
  {
    AppMethodBeat.i(86583);
    if (com.tencent.view.b.BzH == null)
    {
      AppMethodBeat.o(86583);
      return null;
    }
    paramString = com.tencent.view.b.BzH.getAssets().open(paramString, 3);
    byte[] arrayOfByte = new byte[paramString.available()];
    paramString.read(arrayOfByte);
    AppMethodBeat.o(86583);
    return arrayOfByte;
  }
  
  private static String getSDPath()
  {
    AppMethodBeat.i(86588);
    Object localObject = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localObject = Environment.getExternalStorageDirectory();
    }
    localObject = ((File)localObject).toString();
    AppMethodBeat.o(86588);
    return localObject;
  }
  
  public static native void nativeCopyImage(Bitmap paramBitmap, long paramLong);
  
  public static byte[] readBundleData(String paramString)
  {
    AppMethodBeat.i(86585);
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      InputStream localInputStream = com.tencent.view.b.axl(paramString);
      if (localInputStream == null)
      {
        localObject1 = localObject2;
        i.n("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
      }
      localObject1 = localObject2;
      paramString = e.L(localInputStream);
      localObject1 = paramString;
      g.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i.a("FilterDefault", "decodeBitmap  getStream", paramString);
        paramString = (String)localObject1;
      }
    }
    AppMethodBeat.o(86585);
    return paramString;
  }
  
  public static QImage readBundleImage(String paramString)
  {
    AppMethodBeat.i(86586);
    paramString = com.tencent.view.b.wv(paramString);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      QImage localQImage = QImage.Bitmap2QImage(paramString);
      b.recycle(paramString);
      AppMethodBeat.o(86586);
      return localQImage;
    }
    AppMethodBeat.o(86586);
    return null;
  }
  
  public static void recycleImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(86587);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    System.gc();
    AppMethodBeat.o(86587);
  }
  
  /* Error */
  private static int saveBitmap(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: ldc_w 259
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 62
    //   8: ldc_w 261
    //   11: aload_1
    //   12: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 121	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 127	com/tencent/util/i:l	(Ljava/lang/Object;Ljava/lang/String;)I
    //   21: pop
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore_2
    //   29: new 44	java/io/File
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 264	java/io/File:getParentFile	()Ljava/io/File;
    //   44: astore 6
    //   46: aload 6
    //   48: invokevirtual 51	java/io/File:exists	()Z
    //   51: ifne +9 -> 60
    //   54: aload 6
    //   56: invokevirtual 74	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload 5
    //   62: invokevirtual 51	java/io/File:exists	()Z
    //   65: ifne +9 -> 74
    //   68: aload 5
    //   70: invokevirtual 87	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: ldc 62
    //   76: new 31	java/lang/StringBuilder
    //   79: dup
    //   80: ldc_w 266
    //   83: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload 5
    //   88: invokevirtual 51	java/io/File:exists	()Z
    //   91: invokevirtual 269	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 127	com/tencent/util/i:l	(Ljava/lang/Object;Ljava/lang/String;)I
    //   100: pop
    //   101: new 89	java/io/FileOutputStream
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 270	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   109: astore_1
    //   110: aload_0
    //   111: ifnull +18 -> 129
    //   114: aload_0
    //   115: getstatic 276	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   118: bipush 95
    //   120: aload_1
    //   121: invokevirtual 280	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   124: pop
    //   125: aload_1
    //   126: invokevirtual 283	java/io/FileOutputStream:flush	()V
    //   129: aload_1
    //   130: invokestatic 286	com/tencent/util/g:closeQuietly	(Ljava/io/OutputStream;)V
    //   133: ldc_w 259
    //   136: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore_0
    //   142: aload_2
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 286	com/tencent/util/g:closeQuietly	(Ljava/io/OutputStream;)V
    //   148: ldc_w 259
    //   151: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_0
    //   157: aload_3
    //   158: astore_0
    //   159: aload_0
    //   160: invokestatic 286	com/tencent/util/g:closeQuietly	(Ljava/io/OutputStream;)V
    //   163: ldc_w 259
    //   166: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_0
    //   172: aload 4
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 286	com/tencent/util/g:closeQuietly	(Ljava/io/OutputStream;)V
    //   179: ldc_w 259
    //   182: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_0
    //   186: athrow
    //   187: astore_0
    //   188: goto -13 -> 175
    //   191: astore_0
    //   192: aload_1
    //   193: astore_0
    //   194: goto -35 -> 159
    //   197: astore_0
    //   198: aload_1
    //   199: astore_0
    //   200: goto -56 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramBitmap	Bitmap
    //   0	203	1	paramString	String
    //   28	115	2	localObject1	Object
    //   23	135	3	localObject2	Object
    //   25	148	4	localObject3	Object
    //   37	50	5	localFile1	File
    //   44	11	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   29	60	141	java/lang/Exception
    //   60	74	141	java/lang/Exception
    //   74	110	141	java/lang/Exception
    //   29	60	156	java/lang/OutOfMemoryError
    //   60	74	156	java/lang/OutOfMemoryError
    //   74	110	156	java/lang/OutOfMemoryError
    //   29	60	171	finally
    //   60	74	171	finally
    //   74	110	171	finally
    //   114	129	187	finally
    //   114	129	191	java/lang/OutOfMemoryError
    //   114	129	197	java/lang/Exception
  }
  
  public static void writeToAlbum(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86589);
    if (com.tencent.view.b.ENABLE_DEBUG)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      i.l("filter", "writeToAlbum: " + paramInt1 + " " + paramInt2);
      nativeCopyImage(localBitmap, paramLong);
      String str = generateName(System.currentTimeMillis());
      i.l("filter", "writeToAlbum ret: ".concat(String.valueOf(saveBitmap(localBitmap, getSDPath() + "/filter/" + str + ".jpg"))));
      localBitmap.recycle();
    }
    AppMethodBeat.o(86589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.util.FilterEngineJNILib
 * JD-Core Version:    0.7.0.1
 */