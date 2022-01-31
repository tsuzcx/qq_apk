package com.tencent.youtu.ytcommon.tools;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
    throw new AssertionError();
  }
  
  public static boolean copyAsset(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    try
    {
      paramAssetManager = paramAssetManager.open(paramString1);
      new File(paramString2).createNewFile();
      paramString1 = new FileOutputStream(paramString2);
      copyFile(paramAssetManager, paramString1);
      paramAssetManager.close();
      paramString1.flush();
      paramString1.close();
      return true;
    }
    catch (Exception paramAssetManager) {}
    return false;
  }
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void copyFileOrDir(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramAssetManager.list(paramString1);
        if (arrayOfString.length == 0)
        {
          copyAsset(paramAssetManager, paramString1, paramString2 + "/" + paramString1);
          return;
        }
        Object localObject;
        if (paramString2.endsWith(File.separator))
        {
          localObject = paramString2 + paramString1;
          localObject = new File((String)localObject);
          if (((File)localObject).exists()) {
            break label177;
          }
          ((File)localObject).mkdir();
          break label177;
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
        return;
      }
      catch (IOException paramAssetManager) {}
      label177:
      int i = 0;
    }
  }
  
  public static void deleteFile(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      deleteFile(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static String getLastPathComponent(String paramString)
  {
    paramString = paramString.split("/");
    if (paramString.length == 0) {
      return "";
    }
    return paramString[(paramString.length - 1)];
  }
  
  /* Error */
  public static java.lang.StringBuilder readAssetFile(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 67	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 170
    //   6: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: new 175	java/io/BufferedReader
    //   13: dup
    //   14: new 177	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokevirtual 183	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   22: invokevirtual 189	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   25: aload_1
    //   26: invokevirtual 22	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   32: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 198	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +68 -> 112
    //   47: aload_1
    //   48: astore_0
    //   49: aload_2
    //   50: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: ldc 170
    //   55: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +12 -> 70
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: ldc 204
    //   66: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: aload_3
    //   74: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -42 -> 36
    //   81: astore_2
    //   82: aload_1
    //   83: astore_0
    //   84: aload_2
    //   85: astore_1
    //   86: new 206	java/lang/RuntimeException
    //   89: dup
    //   90: ldc 208
    //   92: aload_1
    //   93: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: astore_1
    //   100: aload_2
    //   101: astore_0
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 212	java/io/BufferedReader:close	()V
    //   110: aload_0
    //   111: athrow
    //   112: aload_1
    //   113: invokevirtual 212	java/io/BufferedReader:close	()V
    //   116: aload_2
    //   117: areturn
    //   118: astore_0
    //   119: new 206	java/lang/RuntimeException
    //   122: dup
    //   123: ldc 208
    //   125: aload_0
    //   126: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: athrow
    //   130: astore_0
    //   131: new 206	java/lang/RuntimeException
    //   134: dup
    //   135: ldc 208
    //   137: aload_0
    //   138: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: athrow
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_1
    //   145: goto -43 -> 102
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: goto -65 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	android.content.Context
    //   0	154	1	paramString	String
    //   9	64	2	localStringBuilder1	java.lang.StringBuilder
    //   81	4	2	localIOException	IOException
    //   97	20	2	localStringBuilder2	java.lang.StringBuilder
    //   42	32	3	str	String
    // Exception table:
    //   from	to	target	type
    //   38	43	81	java/io/IOException
    //   49	61	81	java/io/IOException
    //   63	70	81	java/io/IOException
    //   72	78	81	java/io/IOException
    //   38	43	97	finally
    //   49	61	97	finally
    //   63	70	97	finally
    //   72	78	97	finally
    //   86	97	97	finally
    //   112	116	118	java/io/IOException
    //   106	110	130	java/io/IOException
    //   10	36	142	finally
    //   10	36	148	java/io/IOException
  }
  
  /* Error */
  public static java.lang.StringBuilder readFile(String paramString)
  {
    // Byte code:
    //   0: new 24	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 170
    //   15: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_0
    //   20: invokevirtual 103	java/io/File:isFile	()Z
    //   23: ifne +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: new 175	java/io/BufferedReader
    //   31: dup
    //   32: new 177	java/io/InputStreamReader
    //   35: dup
    //   36: new 215	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: invokevirtual 198	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull +64 -> 123
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: ldc 170
    //   70: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne +12 -> 85
    //   76: aload_1
    //   77: astore_0
    //   78: aload_2
    //   79: ldc 204
    //   81: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: astore_0
    //   87: aload_2
    //   88: aload_3
    //   89: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: goto -42 -> 51
    //   96: astore_2
    //   97: aload_1
    //   98: astore_0
    //   99: aload_2
    //   100: astore_1
    //   101: new 206	java/lang/RuntimeException
    //   104: dup
    //   105: ldc 208
    //   107: aload_1
    //   108: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: athrow
    //   112: astore_1
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 212	java/io/BufferedReader:close	()V
    //   121: aload_1
    //   122: athrow
    //   123: aload_1
    //   124: invokevirtual 212	java/io/BufferedReader:close	()V
    //   127: aload_2
    //   128: areturn
    //   129: astore_0
    //   130: new 206	java/lang/RuntimeException
    //   133: dup
    //   134: ldc 208
    //   136: aload_0
    //   137: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: athrow
    //   141: astore_0
    //   142: new 206	java/lang/RuntimeException
    //   145: dup
    //   146: ldc 208
    //   148: aload_0
    //   149: invokespecial 211	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: athrow
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_0
    //   156: goto -43 -> 113
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -61 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString	String
    //   50	58	1	localObject1	Object
    //   112	12	1	localObject2	Object
    //   153	1	1	localObject3	Object
    //   159	1	1	localIOException1	IOException
    //   18	70	2	localStringBuilder	java.lang.StringBuilder
    //   96	32	2	localIOException2	IOException
    //   57	32	3	str	String
    // Exception table:
    //   from	to	target	type
    //   53	58	96	java/io/IOException
    //   64	76	96	java/io/IOException
    //   78	85	96	java/io/IOException
    //   87	93	96	java/io/IOException
    //   53	58	112	finally
    //   64	76	112	finally
    //   78	85	112	finally
    //   87	93	112	finally
    //   101	112	112	finally
    //   123	127	129	java/io/IOException
    //   117	121	141	java/io/IOException
    //   28	51	153	finally
    //   28	51	159	java/io/IOException
  }
  
  public static boolean zipFileAtPath(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString1);
    try
    {
      paramString2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramString2)));
      if (((File)localObject).isDirectory())
      {
        zipSubFolder(paramString2, (File)localObject, ((File)localObject).getParent().length());
        paramString2.close();
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
    catch (Exception paramString1) {}
  }
  
  private static void zipSubFolder(ZipOutputStream paramZipOutputStream, File paramFile, int paramInt)
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTFileUtils
 * JD-Core Version:    0.7.0.1
 */