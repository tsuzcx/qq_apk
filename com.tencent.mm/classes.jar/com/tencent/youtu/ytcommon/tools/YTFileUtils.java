package com.tencent.youtu.ytcommon.tools;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class YTFileUtils
{
  private YTFileUtils()
  {
    AppMethodBeat.i(73377);
    AssertionError localAssertionError = new AssertionError();
    AppMethodBeat.o(73377);
    throw localAssertionError;
  }
  
  public static boolean copyAsset(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73380);
    try
    {
      paramAssetManager = paramAssetManager.open(paramString1);
      new File(paramString2).createNewFile();
      paramString1 = new FileOutputStream(paramString2);
      copyFile(paramAssetManager, paramString1);
      paramAssetManager.close();
      paramString1.flush();
      paramString1.close();
      AppMethodBeat.o(73380);
      return true;
    }
    catch (Exception paramAssetManager)
    {
      AppMethodBeat.o(73380);
    }
    return false;
  }
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(73382);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(73382);
  }
  
  public static void copyFileOrDir(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73381);
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramAssetManager.list(paramString1);
        if (arrayOfString.length == 0)
        {
          copyAsset(paramAssetManager, paramString1, paramString2 + "/" + paramString1);
          AppMethodBeat.o(73381);
          return;
        }
        Object localObject;
        if (paramString2.endsWith(File.separator))
        {
          localObject = paramString2 + paramString1;
          localObject = new File((String)localObject);
          if (((File)localObject).exists()) {
            break label198;
          }
          ((File)localObject).mkdir();
          break label198;
          if (i < arrayOfString.length)
          {
            copyFileOrDir(paramAssetManager, paramString1 + "/" + arrayOfString[i], paramString2);
            i += 1;
            continue;
          }
        }
        else
        {
          localObject = paramString2 + File.separator + paramString1;
          continue;
        }
        AppMethodBeat.o(73381);
        return;
      }
      catch (IOException paramAssetManager)
      {
        AppMethodBeat.o(73381);
        return;
      }
      label198:
      int i = 0;
    }
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(73383);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null)
      {
        paramDrawable = ((BitmapDrawable)localObject).getBitmap();
        AppMethodBeat.o(73383);
        return paramDrawable;
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(73383);
      return localObject;
    }
  }
  
  public static String getLastPathComponent(String paramString)
  {
    AppMethodBeat.i(73386);
    paramString = paramString.split("/");
    if (paramString.length == 0)
    {
      AppMethodBeat.o(73386);
      return "";
    }
    paramString = paramString[(paramString.length - 1)];
    AppMethodBeat.o(73386);
    return paramString;
  }
  
  /* Error */
  public static java.lang.StringBuilder readAssetFile(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 171
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 80	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 168
    //   11: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: new 174	java/io/BufferedReader
    //   18: dup
    //   19: new 176	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokevirtual 182	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: invokevirtual 188	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   30: aload_1
    //   31: invokevirtual 33	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: invokespecial 191	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 194	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: invokevirtual 197	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +82 -> 131
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: ldc 168
    //   60: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +12 -> 75
    //   66: aload_1
    //   67: astore_0
    //   68: aload_2
    //   69: ldc 203
    //   71: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: astore_0
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: goto -42 -> 41
    //   86: astore_2
    //   87: aload_1
    //   88: astore_0
    //   89: new 205	java/lang/RuntimeException
    //   92: dup
    //   93: ldc 207
    //   95: aload_2
    //   96: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: astore_2
    //   100: aload_1
    //   101: astore_0
    //   102: ldc 171
    //   104: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: astore_0
    //   109: aload_2
    //   110: athrow
    //   111: astore_2
    //   112: aload_0
    //   113: astore_1
    //   114: aload_2
    //   115: astore_0
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 211	java/io/BufferedReader:close	()V
    //   124: ldc 171
    //   126: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_0
    //   130: athrow
    //   131: aload_1
    //   132: invokevirtual 211	java/io/BufferedReader:close	()V
    //   135: ldc 171
    //   137: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_2
    //   141: areturn
    //   142: astore_0
    //   143: new 205	java/lang/RuntimeException
    //   146: dup
    //   147: ldc 207
    //   149: aload_0
    //   150: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: astore_0
    //   154: ldc 171
    //   156: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: new 205	java/lang/RuntimeException
    //   165: dup
    //   166: ldc 207
    //   168: aload_0
    //   169: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: astore_0
    //   173: ldc 171
    //   175: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_0
    //   179: athrow
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_1
    //   183: goto -67 -> 116
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -102 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	android.content.Context
    //   0	192	1	paramString	String
    //   14	64	2	localStringBuilder1	java.lang.StringBuilder
    //   86	10	2	localIOException1	IOException
    //   99	11	2	localRuntimeException	java.lang.RuntimeException
    //   111	30	2	localStringBuilder2	java.lang.StringBuilder
    //   186	1	2	localIOException2	IOException
    //   47	32	3	str	String
    // Exception table:
    //   from	to	target	type
    //   43	48	86	java/io/IOException
    //   54	66	86	java/io/IOException
    //   68	75	86	java/io/IOException
    //   77	83	86	java/io/IOException
    //   43	48	111	finally
    //   54	66	111	finally
    //   68	75	111	finally
    //   77	83	111	finally
    //   89	100	111	finally
    //   102	107	111	finally
    //   109	111	111	finally
    //   131	135	142	java/io/IOException
    //   120	124	161	java/io/IOException
    //   15	41	180	finally
    //   15	41	186	java/io/IOException
  }
  
  /* Error */
  public static java.lang.StringBuilder readFile(String paramString)
  {
    // Byte code:
    //   0: ldc 213
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 35	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 80	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 168
    //   20: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_0
    //   25: invokevirtual 216	java/io/File:isFile	()Z
    //   28: ifne +10 -> 38
    //   31: ldc 213
    //   33: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 174	java/io/BufferedReader
    //   41: dup
    //   42: new 176	java/io/InputStreamReader
    //   45: dup
    //   46: new 218	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 221	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 191	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 194	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 197	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +78 -> 147
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: ldc 168
    //   80: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne +12 -> 95
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: ldc 203
    //   91: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: aload_3
    //   99: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: goto -42 -> 61
    //   106: astore_2
    //   107: aload_1
    //   108: astore_0
    //   109: new 205	java/lang/RuntimeException
    //   112: dup
    //   113: ldc 207
    //   115: aload_2
    //   116: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: astore_2
    //   120: aload_1
    //   121: astore_0
    //   122: ldc 213
    //   124: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_1
    //   128: astore_0
    //   129: aload_2
    //   130: athrow
    //   131: astore_1
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 211	java/io/BufferedReader:close	()V
    //   140: ldc 213
    //   142: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    //   147: aload_1
    //   148: invokevirtual 211	java/io/BufferedReader:close	()V
    //   151: ldc 213
    //   153: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_2
    //   157: areturn
    //   158: astore_0
    //   159: new 205	java/lang/RuntimeException
    //   162: dup
    //   163: ldc 207
    //   165: aload_0
    //   166: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: astore_0
    //   170: ldc 213
    //   172: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_0
    //   176: athrow
    //   177: astore_0
    //   178: new 205	java/lang/RuntimeException
    //   181: dup
    //   182: ldc 207
    //   184: aload_0
    //   185: invokespecial 210	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: astore_0
    //   189: ldc 213
    //   191: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_0
    //   195: athrow
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_0
    //   199: goto -67 -> 132
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_1
    //   205: goto -98 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   60	68	1	localBufferedReader	java.io.BufferedReader
    //   131	17	1	localObject1	Object
    //   196	1	1	localObject2	Object
    //   204	1	1	localObject3	Object
    //   23	75	2	localStringBuilder	java.lang.StringBuilder
    //   106	10	2	localIOException1	IOException
    //   119	38	2	localRuntimeException	java.lang.RuntimeException
    //   202	1	2	localIOException2	IOException
    //   67	32	3	str	String
    // Exception table:
    //   from	to	target	type
    //   63	68	106	java/io/IOException
    //   74	86	106	java/io/IOException
    //   88	95	106	java/io/IOException
    //   97	103	106	java/io/IOException
    //   63	68	131	finally
    //   74	86	131	finally
    //   88	95	131	finally
    //   97	103	131	finally
    //   109	120	131	finally
    //   122	127	131	finally
    //   129	131	131	finally
    //   147	151	158	java/io/IOException
    //   136	140	177	java/io/IOException
    //   38	61	196	finally
    //   38	61	202	java/io/IOException
  }
  
  public static boolean zipFileAtPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73384);
    Object localObject = new File(paramString1);
    try
    {
      paramString2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramString2)));
      if (((File)localObject).isDirectory())
      {
        zipSubFolder(paramString2, (File)localObject, ((File)localObject).getParent().length());
        paramString2.close();
        AppMethodBeat.o(73384);
        return true;
      }
      localObject = new byte[2048];
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString1), 2048);
      paramString2.putNextEntry(new ZipEntry(getLastPathComponent(paramString1)));
      for (;;)
      {
        int i = localBufferedInputStream.read((byte[])localObject, 0, 2048);
        if (i == -1) {
          break;
        }
        paramString2.write((byte[])localObject, 0, i);
      }
      return false;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(73384);
    }
  }
  
  private static void zipSubFolder(ZipOutputStream paramZipOutputStream, File paramFile, int paramInt)
  {
    AppMethodBeat.i(73385);
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = paramFile[i];
      if (((File)localObject1).isDirectory()) {
        zipSubFolder(paramZipOutputStream, (File)localObject1, paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        byte[] arrayOfByte = new byte[2048];
        Object localObject2 = ((File)localObject1).getPath();
        localObject1 = ((String)localObject2).substring(paramInt);
        localObject2 = new BufferedInputStream(new FileInputStream((String)localObject2), 2048);
        paramZipOutputStream.putNextEntry(new ZipEntry((String)localObject1));
        for (;;)
        {
          int k = ((BufferedInputStream)localObject2).read(arrayOfByte, 0, 2048);
          if (k == -1) {
            break;
          }
          paramZipOutputStream.write(arrayOfByte, 0, k);
        }
        ((BufferedInputStream)localObject2).close();
      }
    }
    AppMethodBeat.o(73385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTFileUtils
 * JD-Core Version:    0.7.0.1
 */