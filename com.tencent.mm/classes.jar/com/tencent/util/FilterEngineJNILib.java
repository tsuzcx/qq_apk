package com.tencent.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Environment;
import com.tencent.filter.QImage;
import com.tencent.view.b;
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
    if (paramString2 != null) {}
    for (paramString2 = paramString1 + "." + paramString2;; paramString2 = paramString1)
    {
      if (new File(paramString2).exists()) {
        return paramString2;
      }
      Object localObject = b.xcZ;
      if (localObject == null) {
        return null;
      }
      localObject = ((Context)localObject).getDir("filter", 0);
      if ((!((File)localObject).isDirectory()) && (!((File)localObject).mkdirs())) {
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
          paramString2 = b.agt(paramString2);
          if (paramString2 == null) {
            break label175;
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
          return ((File)localObject).getAbsolutePath();
        }
        catch (IOException paramString1) {}
      }
      for (;;)
      {
        paramString2.close();
        localFileOutputStream.close();
      }
      label175:
      g.h("filter", "generateBundlePath notfound" + paramString1);
      return null;
    }
  }
  
  /* Error */
  private static String generateName(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 112	java/text/SimpleDateFormat
    //   6: dup
    //   7: ldc 114
    //   9: invokespecial 115	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   12: new 117	java/util/Date
    //   15: dup
    //   16: lload_0
    //   17: invokespecial 120	java/util/Date:<init>	(J)V
    //   20: invokevirtual 124	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   23: astore_2
    //   24: lload_0
    //   25: ldc2_w 125
    //   28: ldiv
    //   29: getstatic 12	com/tencent/util/FilterEngineJNILib:mLastDate	J
    //   32: ldc2_w 125
    //   35: ldiv
    //   36: lcmp
    //   37: ifne +42 -> 79
    //   40: getstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   43: iconst_1
    //   44: iadd
    //   45: putstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   48: new 24	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   55: aload_2
    //   56: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 128
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   67: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore_2
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_2
    //   78: areturn
    //   79: lload_0
    //   80: putstatic 12	com/tencent/util/FilterEngineJNILib:mLastDate	J
    //   83: iconst_0
    //   84: putstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   87: goto -13 -> 74
    //   90: astore_2
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramLong	long
    //   23	55	2	str	String
    //   90	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	74	90	finally
    //   79	87	90	finally
  }
  
  public static byte[] getAssetContents(String paramString)
  {
    if (b.xcZ == null) {
      return null;
    }
    paramString = b.xcZ.getAssets().open(paramString, 3);
    byte[] arrayOfByte = new byte[paramString.available()];
    paramString.read(arrayOfByte);
    return arrayOfByte;
  }
  
  private static String getSDPath()
  {
    File localFile = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localFile = Environment.getExternalStorageDirectory();
    }
    return localFile.toString();
  }
  
  public static native void nativeCopyImage(Bitmap paramBitmap, long paramLong);
  
  public static byte[] readBundleData(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      InputStream localInputStream = b.agt(paramString);
      if (localInputStream == null)
      {
        localObject1 = localObject2;
        g.i("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
      }
      localObject1 = localObject2;
      paramString = c.decryptFile(localInputStream);
      localObject1 = paramString;
      e.closeQuietly(localInputStream);
      return paramString;
    }
    catch (Exception paramString)
    {
      g.a("FilterDefault", "decodeBitmap  getStream", paramString);
    }
    return localObject1;
  }
  
  public static QImage readBundleImage(String paramString)
  {
    paramString = b.pe(paramString);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      QImage localQImage = QImage.Bitmap2QImage(paramString);
      a.recycle(paramString);
      return localQImage;
    }
    return null;
  }
  
  public static void recycleImage(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    System.gc();
  }
  
  /* Error */
  private static int saveBitmap(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: ldc 52
    //   2: new 24	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 236
    //   8: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 108	com/tencent/util/g:h	(Ljava/lang/Object;Ljava/lang/String;)I
    //   21: pop
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore_2
    //   29: new 37	java/io/File
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 239	java/io/File:getParentFile	()Ljava/io/File;
    //   44: astore 6
    //   46: aload 6
    //   48: invokevirtual 44	java/io/File:exists	()Z
    //   51: ifne +9 -> 60
    //   54: aload 6
    //   56: invokevirtual 64	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload 5
    //   62: invokevirtual 44	java/io/File:exists	()Z
    //   65: ifne +9 -> 74
    //   68: aload 5
    //   70: invokevirtual 77	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: ldc 52
    //   76: new 24	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 241
    //   82: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload 5
    //   87: invokevirtual 44	java/io/File:exists	()Z
    //   90: invokevirtual 244	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 108	com/tencent/util/g:h	(Ljava/lang/Object;Ljava/lang/String;)I
    //   99: pop
    //   100: new 79	java/io/FileOutputStream
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 245	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_0
    //   110: ifnull +18 -> 128
    //   113: aload_0
    //   114: getstatic 251	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   117: bipush 95
    //   119: aload_1
    //   120: invokevirtual 255	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   123: pop
    //   124: aload_1
    //   125: invokevirtual 258	java/io/FileOutputStream:flush	()V
    //   128: aload_1
    //   129: invokestatic 261	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: aload_2
    //   136: astore_0
    //   137: aload_0
    //   138: invokestatic 261	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_0
    //   144: aload_3
    //   145: astore_0
    //   146: aload_0
    //   147: invokestatic 261	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_0
    //   153: aload 4
    //   155: astore_1
    //   156: aload_1
    //   157: invokestatic 261	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -7 -> 156
    //   166: astore_0
    //   167: aload_1
    //   168: astore_0
    //   169: goto -23 -> 146
    //   172: astore_0
    //   173: aload_1
    //   174: astore_0
    //   175: goto -38 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramBitmap	Bitmap
    //   0	178	1	paramString	String
    //   28	108	2	localObject1	Object
    //   23	122	3	localObject2	Object
    //   25	129	4	localObject3	Object
    //   37	49	5	localFile1	File
    //   44	11	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   29	60	134	java/lang/Exception
    //   60	74	134	java/lang/Exception
    //   74	109	134	java/lang/Exception
    //   29	60	143	java/lang/OutOfMemoryError
    //   60	74	143	java/lang/OutOfMemoryError
    //   74	109	143	java/lang/OutOfMemoryError
    //   29	60	152	finally
    //   60	74	152	finally
    //   74	109	152	finally
    //   113	128	162	finally
    //   113	128	166	java/lang/OutOfMemoryError
    //   113	128	172	java/lang/Exception
  }
  
  public static void writeToAlbum(long paramLong, int paramInt1, int paramInt2)
  {
    if (b.xdc)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      g.h("filter", "writeToAlbum: " + paramInt1 + " " + paramInt2);
      nativeCopyImage(localBitmap, paramLong);
      String str = generateName(System.currentTimeMillis());
      paramInt1 = saveBitmap(localBitmap, getSDPath() + "/filter/" + str + ".jpg");
      g.h("filter", "writeToAlbum ret: " + paramInt1);
      localBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.util.FilterEngineJNILib
 * JD-Core Version:    0.7.0.1
 */