package com.tencent.ttpic.baseutils;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils
{
  public static final String PIC_POSTFIX_JPEG = ".jpg";
  public static final String PIC_POSTFIX_PNG = ".png";
  public static final String PIC_POSTFIX_WEBP = ".webp";
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  public static final FileUtils.AssetFileComparator SIMPLE_ASSET_COMPARATOR;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(49716);
    TAG = FileUtils.class.getSimpleName();
    SIMPLE_ASSET_COMPARATOR = new FileUtils.2();
    AppMethodBeat.o(49716);
  }
  
  public static boolean Move(File paramFile, String paramString)
  {
    AppMethodBeat.i(49698);
    boolean bool = paramFile.renameTo(new File(new File(paramString), paramFile.getName()));
    AppMethodBeat.o(49698);
    return bool;
  }
  
  public static void asyncCopyFile(InputStream paramInputStream, String paramString, FileUtils.OnFileCopyListener paramOnFileCopyListener)
  {
    AppMethodBeat.i(49713);
    paramInputStream = new FileUtils.FileCopyTask(paramInputStream, paramString);
    paramInputStream.setOnFileCopyListener(paramOnFileCopyListener);
    paramInputStream.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[0]);
    AppMethodBeat.o(49713);
  }
  
  /* Error */
  public static String checkAssetsPhoto(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 115
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 115
    //   14: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 127	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: astore_0
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_2
    //   30: aload_2
    //   31: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   34: ldc 115
    //   36: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_2
    //   42: aconst_null
    //   43: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   46: aload_1
    //   47: ldc 141
    //   49: invokevirtual 145	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   52: iconst_m1
    //   53: if_icmpeq +88 -> 141
    //   56: new 147	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   63: aload_1
    //   64: iconst_0
    //   65: aload_1
    //   66: bipush 46
    //   68: invokevirtual 151	java/lang/String:lastIndexOf	(I)I
    //   71: iconst_1
    //   72: iadd
    //   73: invokevirtual 155	java/lang/String:substring	(II)Ljava/lang/String;
    //   76: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 161
    //   81: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_1
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   93: astore_0
    //   94: aload_0
    //   95: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   98: ldc 115
    //   100: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   110: ldc 115
    //   112: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: aconst_null
    //   119: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   122: ldc 115
    //   124: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   134: ldc 115
    //   136: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: athrow
    //   141: new 147	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   148: aload_1
    //   149: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 14
    //   154: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore_2
    //   161: aload_0
    //   162: aload_2
    //   163: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   166: astore_3
    //   167: aload_3
    //   168: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   171: ldc 115
    //   173: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_2
    //   177: areturn
    //   178: astore_2
    //   179: aconst_null
    //   180: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   183: new 147	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   190: aload_1
    //   191: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 20
    //   196: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: astore_2
    //   203: aload_0
    //   204: aload_2
    //   205: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   208: astore_3
    //   209: aload_3
    //   210: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   213: ldc 115
    //   215: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_2
    //   219: areturn
    //   220: astore_0
    //   221: aconst_null
    //   222: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   225: ldc 115
    //   227: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_0
    //   231: athrow
    //   232: astore_2
    //   233: aconst_null
    //   234: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   237: new 147	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   244: aload_1
    //   245: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 17
    //   250: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore_1
    //   257: aload_0
    //   258: aload_1
    //   259: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   262: astore_0
    //   263: aload_0
    //   264: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   267: ldc 115
    //   269: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload_1
    //   273: areturn
    //   274: astore_0
    //   275: aconst_null
    //   276: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   279: ldc 115
    //   281: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: aconst_null
    //   288: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   291: ldc 115
    //   293: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aconst_null
    //   297: areturn
    //   298: astore_0
    //   299: aconst_null
    //   300: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   303: ldc 115
    //   305: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload_0
    //   309: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramContext	Context
    //   0	310	1	paramString	String
    //   29	2	2	localInputStream1	InputStream
    //   41	1	2	localIOException1	IOException
    //   160	17	2	str1	String
    //   178	1	2	localIOException2	IOException
    //   202	17	2	str2	String
    //   232	1	2	localIOException3	IOException
    //   166	44	3	localInputStream2	InputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	41	java/io/IOException
    //   24	30	105	finally
    //   88	94	117	java/io/IOException
    //   88	94	129	finally
    //   161	167	178	java/io/IOException
    //   161	167	220	finally
    //   203	209	232	java/io/IOException
    //   203	209	274	finally
    //   257	263	286	java/io/IOException
    //   257	263	298	finally
  }
  
  public static String checkPhoto(String paramString)
  {
    AppMethodBeat.i(49678);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49678);
      return null;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(49678);
      return paramString;
    }
    if (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") == -1)
    {
      String str = paramString + ".jpg";
      if (new File(str).exists())
      {
        AppMethodBeat.o(49678);
        return str;
      }
      str = paramString + ".png";
      if (new File(str).exists())
      {
        AppMethodBeat.o(49678);
        return str;
      }
    }
    AppMethodBeat.o(49678);
    return paramString;
  }
  
  public static void clearDir(File paramFile)
  {
    AppMethodBeat.i(49695);
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      AppMethodBeat.o(49695);
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(49695);
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isDirectory()) {
        clearDir(localFile);
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    paramFile.delete();
    AppMethodBeat.o(49695);
  }
  
  public static void clearDirs(File[] paramArrayOfFile)
  {
    AppMethodBeat.i(49696);
    if (paramArrayOfFile == null)
    {
      AppMethodBeat.o(49696);
      return;
    }
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      clearDir(paramArrayOfFile[i]);
      i += 1;
    }
    AppMethodBeat.o(49696);
  }
  
  private static void closeSilently(Closeable paramCloseable)
  {
    AppMethodBeat.i(49704);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(49704);
        return;
      }
      catch (Throwable paramCloseable) {}
    }
    AppMethodBeat.o(49704);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(49690);
    boolean bool = copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_COMPARATOR);
    AppMethodBeat.o(49690);
    return bool;
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    AppMethodBeat.i(49691);
    boolean bool = performCopyAssetsFile(paramContext, paramString1, paramString2, paramAssetFileComparator);
    AppMethodBeat.o(49691);
    return bool;
  }
  
  public static boolean copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49711);
    if ((paramInputStream == null) || (paramOutputStream == null))
    {
      AppMethodBeat.o(49711);
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      AppMethodBeat.o(49711);
    }
    catch (Exception paramInputStream)
    {
      LogUtils.e(paramInputStream);
    }
    for (;;)
    {
      return true;
      paramOutputStream.flush();
    }
  }
  
  /* Error */
  public static boolean copyFile(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 242	java/io/FileOutputStream
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: sipush 4096
    //   17: newarray byte
    //   19: astore_3
    //   20: aload_0
    //   21: aload_3
    //   22: invokevirtual 223	java/io/InputStream:read	([B)I
    //   25: istore_2
    //   26: iload_2
    //   27: ifle +29 -> 56
    //   30: aload_1
    //   31: aload_3
    //   32: iconst_0
    //   33: iload_2
    //   34: invokevirtual 229	java/io/OutputStream:write	([BII)V
    //   37: goto -17 -> 20
    //   40: astore_3
    //   41: aload_0
    //   42: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   45: aload_1
    //   46: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   49: ldc 240
    //   51: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: ireturn
    //   56: aload_0
    //   57: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   60: aload_1
    //   61: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   64: ldc 240
    //   66: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_3
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_0
    //   75: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   78: aload_1
    //   79: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   82: ldc 240
    //   84: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: goto -16 -> 74
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_1
    //   96: goto -55 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramInputStream	InputStream
    //   0	99	1	paramString	String
    //   25	9	2	i	int
    //   19	13	3	arrayOfByte	byte[]
    //   40	1	3	localException	Exception
    //   71	17	3	localObject1	Object
    //   89	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	40	java/lang/Exception
    //   20	26	40	java/lang/Exception
    //   30	37	40	java/lang/Exception
    //   5	14	71	finally
    //   14	20	89	finally
    //   20	26	89	finally
    //   30	37	89	finally
    //   5	14	93	java/lang/Exception
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 248
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 69	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 171	java/io/File:exists	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifne +18 -> 36
    //   21: aconst_null
    //   22: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   25: aconst_null
    //   26: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   29: ldc 248
    //   31: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: new 250	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: new 242	java/io/FileOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_0
    //   55: aload_0
    //   56: astore 5
    //   58: aload 4
    //   60: astore_1
    //   61: sipush 4096
    //   64: newarray byte
    //   66: astore 6
    //   68: aload_0
    //   69: astore 5
    //   71: aload 4
    //   73: astore_1
    //   74: aload 4
    //   76: aload 6
    //   78: invokevirtual 223	java/io/InputStream:read	([B)I
    //   81: istore_2
    //   82: iload_2
    //   83: ifle +49 -> 132
    //   86: aload_0
    //   87: astore 5
    //   89: aload 4
    //   91: astore_1
    //   92: aload_0
    //   93: aload 6
    //   95: iconst_0
    //   96: iload_2
    //   97: invokevirtual 229	java/io/OutputStream:write	([BII)V
    //   100: goto -32 -> 68
    //   103: astore 6
    //   105: aload_0
    //   106: astore 5
    //   108: aload 4
    //   110: astore_1
    //   111: aload 6
    //   113: invokestatic 235	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   116: aload 4
    //   118: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   121: aload_0
    //   122: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   125: ldc 248
    //   127: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iconst_0
    //   131: ireturn
    //   132: aload 4
    //   134: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   137: aload_0
    //   138: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   141: ldc 248
    //   143: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_0
    //   149: aconst_null
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_1
    //   155: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   158: aload 5
    //   160: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   163: ldc 248
    //   165: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_0
    //   169: athrow
    //   170: astore_0
    //   171: aconst_null
    //   172: astore 5
    //   174: aload 4
    //   176: astore_1
    //   177: goto -23 -> 154
    //   180: astore_0
    //   181: goto -27 -> 154
    //   184: astore 6
    //   186: aconst_null
    //   187: astore_0
    //   188: aconst_null
    //   189: astore 4
    //   191: goto -86 -> 105
    //   194: astore 6
    //   196: aconst_null
    //   197: astore_0
    //   198: goto -93 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramString1	String
    //   0	201	1	paramString2	String
    //   81	16	2	i	int
    //   16	2	3	bool	boolean
    //   44	146	4	localFileInputStream	FileInputStream
    //   56	117	5	str	String
    //   66	28	6	arrayOfByte	byte[]
    //   103	9	6	localException1	Exception
    //   184	1	6	localException2	Exception
    //   194	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   61	68	103	java/lang/Exception
    //   74	82	103	java/lang/Exception
    //   92	100	103	java/lang/Exception
    //   5	17	148	finally
    //   36	46	148	finally
    //   46	55	170	finally
    //   61	68	180	finally
    //   74	82	180	finally
    //   92	100	180	finally
    //   111	116	180	finally
    //   5	17	184	java/lang/Exception
    //   36	46	184	java/lang/Exception
    //   46	55	194	java/lang/Exception
  }
  
  /* Error */
  public static void copyRaw(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc 254
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 258	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: iload_1
    //   10: invokevirtual 264	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   13: astore 4
    //   15: new 242	java/io/FileOutputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload 4
    //   26: aload_0
    //   27: invokestatic 266	com/tencent/ttpic/baseutils/FileUtils:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   30: pop
    //   31: aload 4
    //   33: invokevirtual 267	java/io/InputStream:close	()V
    //   36: aload_0
    //   37: invokevirtual 268	java/io/FileOutputStream:flush	()V
    //   40: aload_0
    //   41: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   44: ldc 254
    //   46: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: astore_0
    //   51: ldc 254
    //   53: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: return
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_0
    //   60: aload 4
    //   62: invokevirtual 267	java/io/InputStream:close	()V
    //   65: aload_0
    //   66: ifnull +11 -> 77
    //   69: aload_0
    //   70: invokevirtual 268	java/io/FileOutputStream:flush	()V
    //   73: aload_0
    //   74: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   77: ldc 254
    //   79: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: return
    //   83: astore_0
    //   84: ldc 254
    //   86: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: return
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_2
    //   93: aload 4
    //   95: invokevirtual 267	java/io/InputStream:close	()V
    //   98: aload_2
    //   99: ifnull +11 -> 110
    //   102: aload_2
    //   103: invokevirtual 268	java/io/FileOutputStream:flush	()V
    //   106: aload_2
    //   107: invokevirtual 269	java/io/FileOutputStream:close	()V
    //   110: ldc 254
    //   112: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_0
    //   116: athrow
    //   117: astore_2
    //   118: goto -8 -> 110
    //   121: astore_2
    //   122: aload_0
    //   123: astore_3
    //   124: aload_2
    //   125: astore_0
    //   126: aload_3
    //   127: astore_2
    //   128: goto -35 -> 93
    //   131: astore_2
    //   132: goto -72 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramContext	Context
    //   0	135	1	paramInt	int
    //   0	135	2	paramString	String
    //   123	4	3	localContext	Context
    //   13	81	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   31	44	50	java/io/IOException
    //   15	24	57	java/lang/Exception
    //   60	65	83	java/io/IOException
    //   69	77	83	java/io/IOException
    //   15	24	90	finally
    //   93	98	117	java/io/IOException
    //   102	110	117	java/io/IOException
    //   24	31	121	finally
    //   24	31	131	java/lang/Exception
  }
  
  public static void delete(File paramFile)
  {
    AppMethodBeat.i(49700);
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(49700);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length == 0))
      {
        paramFile.delete();
        AppMethodBeat.o(49700);
        return;
      }
      int i = 0;
      while (i < arrayOfFile.length)
      {
        delete(arrayOfFile[i]);
        i += 1;
      }
      paramFile.delete();
    }
    AppMethodBeat.o(49700);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(49701);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(49701);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(49701);
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(49701);
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      delete(arrayOfFile[i], paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramFile.delete();
    }
    AppMethodBeat.o(49701);
  }
  
  public static void delete(String paramString)
  {
    AppMethodBeat.i(49699);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49699);
      return;
    }
    delete(new File(paramString));
    AppMethodBeat.o(49699);
  }
  
  public static void deleteAllFilesOfDir(File paramFile)
  {
    AppMethodBeat.i(49703);
    if (!paramFile.exists())
    {
      AppMethodBeat.o(49703);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(49703);
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        deleteAllFilesOfDir(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
    AppMethodBeat.o(49703);
  }
  
  public static void deleteFiles(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49702);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(49702);
      return;
    }
    paramString1 = new File(paramString1).listFiles(new FileUtils.1(paramString2));
    if (paramString1 != null)
    {
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramString1[i].delete();
        i += 1;
      }
    }
    AppMethodBeat.o(49702);
  }
  
  public static boolean exists(String paramString)
  {
    AppMethodBeat.i(49697);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49697);
      return false;
    }
    if ((paramString.indexOf("assets") >= 0) || (new File(paramString).exists()))
    {
      AppMethodBeat.o(49697);
      return true;
    }
    AppMethodBeat.o(49697);
    return false;
  }
  
  /* Error */
  private static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 301
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 127	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore 6
    //   15: aload 6
    //   17: aload_1
    //   18: invokevirtual 305	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 311	android/content/res/AssetFileDescriptor:getLength	()J
    //   26: lstore_3
    //   27: aload_0
    //   28: ifnull +7 -> 35
    //   31: aload_0
    //   32: invokevirtual 312	android/content/res/AssetFileDescriptor:close	()V
    //   35: ldc_w 301
    //   38: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: lload_3
    //   42: lreturn
    //   43: astore_0
    //   44: aconst_null
    //   45: astore_0
    //   46: aload_0
    //   47: ifnull +7 -> 54
    //   50: aload_0
    //   51: invokevirtual 312	android/content/res/AssetFileDescriptor:close	()V
    //   54: aload 6
    //   56: aload_1
    //   57: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 316	java/io/InputStream:available	()I
    //   65: istore_2
    //   66: iload_2
    //   67: i2l
    //   68: lstore_3
    //   69: aload_0
    //   70: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   73: ldc_w 301
    //   76: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: lload_3
    //   80: lreturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 312	android/content/res/AssetFileDescriptor:close	()V
    //   92: ldc_w 301
    //   95: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_1
    //   99: athrow
    //   100: astore_0
    //   101: aload 5
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   108: ldc_w 301
    //   111: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: ldc2_w 319
    //   117: lreturn
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_0
    //   122: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   125: ldc_w 301
    //   128: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_0
    //   134: goto -99 -> 35
    //   137: astore_0
    //   138: goto -84 -> 54
    //   141: astore_0
    //   142: goto -50 -> 92
    //   145: astore_1
    //   146: goto -25 -> 121
    //   149: astore_1
    //   150: goto -46 -> 104
    //   153: astore_1
    //   154: goto -70 -> 84
    //   157: astore 7
    //   159: goto -113 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramContext	Context
    //   0	162	1	paramString	String
    //   65	2	2	i	int
    //   26	54	3	l	long
    //   1	101	5	localObject	Object
    //   13	42	6	localAssetManager	android.content.res.AssetManager
    //   157	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   15	22	43	java/io/IOException
    //   15	22	81	finally
    //   54	61	100	java/io/IOException
    //   54	61	118	finally
    //   31	35	133	java/io/IOException
    //   50	54	137	java/io/IOException
    //   88	92	141	java/io/IOException
    //   61	66	145	finally
    //   61	66	149	java/io/IOException
    //   22	27	153	finally
    //   22	27	157	java/io/IOException
  }
  
  public static String getFileNameByPath(String paramString)
  {
    AppMethodBeat.i(49682);
    LogUtils.v(TAG, "[getFileNameByPath] path = ".concat(String.valueOf(paramString)));
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(".");
      int j = paramString.lastIndexOf("/");
      localObject1 = localObject2;
      if (j >= 0)
      {
        localObject1 = localObject2;
        if (i > j) {
          localObject1 = paramString.substring(j + 1, i);
        }
      }
    }
    LogUtils.v(TAG, "[getFileNameByPath] return title = ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(49682);
    return localObject1;
  }
  
  public static String getFileNameFromUrl(String paramString)
  {
    AppMethodBeat.i(49683);
    if (paramString == null)
    {
      AppMethodBeat.o(49683);
      return null;
    }
    int i = paramString.lastIndexOf("/");
    if (i == -1)
    {
      AppMethodBeat.o(49683);
      return null;
    }
    if (i == paramString.length() - 1)
    {
      AppMethodBeat.o(49683);
      return null;
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(49683);
    return paramString;
  }
  
  public static String getFileSuffixFromUrl(String paramString)
  {
    AppMethodBeat.i(49684);
    if (paramString == null)
    {
      AppMethodBeat.o(49684);
      return null;
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1)
    {
      AppMethodBeat.o(49684);
      return null;
    }
    if (i == paramString.length() - 1)
    {
      AppMethodBeat.o(49684);
      return null;
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(49684);
    return paramString;
  }
  
  public static String getMD5(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49707);
    Object localObject;
    int i;
    int j;
    if (new File(paramString1).exists())
    {
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        paramString1 = new FileInputStream(paramString1);
        byte[] arrayOfByte = new byte[4096];
        for (;;)
        {
          i = paramString1.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          ((MessageDigest)localObject).update(arrayOfByte, 0, i);
        }
        ((MessageDigest)localObject).update(paramString2.getBytes());
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49707);
        return null;
      }
      paramString1.close();
      paramString2 = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      paramString2.append(paramString1);
      paramString2.append(Integer.toHexString(k).toLowerCase());
      i += 1;
      while (i >= j)
      {
        paramString1 = paramString2.toString();
        AppMethodBeat.o(49707);
        return paramString1;
        AppMethodBeat.o(49707);
        return null;
      }
      int k = localObject[i] & 0xFF;
      if (k < 16) {
        paramString1 = "0";
      } else {
        paramString1 = "";
      }
    }
  }
  
  public static String getRealPath(String paramString)
  {
    AppMethodBeat.i(49681);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://")))
    {
      paramString = paramString.substring(9);
      AppMethodBeat.o(49681);
      return paramString;
    }
    AppMethodBeat.o(49681);
    return paramString;
  }
  
  public static String getSHA1(String paramString)
  {
    AppMethodBeat.i(49706);
    Object localObject2;
    Object localObject1;
    int i;
    int j;
    if (new File(paramString).exists())
    {
      try
      {
        localObject2 = MessageDigest.getInstance("SHA-1");
        paramString = new FileInputStream(paramString);
        localObject1 = new byte[4096];
        for (;;)
        {
          i = paramString.read((byte[])localObject1);
          if (i == -1) {
            break;
          }
          ((MessageDigest)localObject2).update((byte[])localObject1, 0, i);
        }
        paramString.close();
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49706);
        return null;
      }
      localObject1 = new StringBuilder();
      localObject2 = ((MessageDigest)localObject2).digest();
      j = localObject2.length;
      i = 0;
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(Integer.toHexString(k).toLowerCase());
      i += 1;
      while (i >= j)
      {
        paramString = ((StringBuilder)localObject1).toString();
        AppMethodBeat.o(49706);
        return paramString;
        AppMethodBeat.o(49706);
        return null;
      }
      int k = localObject2[i] & 0xFF;
      if (k < 16) {
        paramString = "0";
      } else {
        paramString = "";
      }
    }
  }
  
  public static boolean isDirectoryWritable(String paramString)
  {
    AppMethodBeat.i(49680);
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory()))
    {
      AppMethodBeat.o(49680);
      return false;
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    if (paramString.isDirectory()) {
      try
      {
        boolean bool = paramString.canWrite();
        AppMethodBeat.o(49680);
        return bool;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(49680);
    return false;
  }
  
  public static String load(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(49686);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(49686);
      return "";
    }
    if (paramString1.startsWith("assets://"))
    {
      paramContext = loadAssetsString(paramContext, getRealPath(paramString1) + File.separator + paramString2);
      AppMethodBeat.o(49686);
      return paramContext;
    }
    paramContext = load(new File(paramString1 + File.separator + paramString2));
    AppMethodBeat.o(49686);
    return paramContext;
  }
  
  /* Error */
  private static String load(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 415
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 250	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 417	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: aload_0
    //   16: invokevirtual 419	java/io/File:length	()J
    //   19: l2i
    //   20: newarray byte
    //   22: astore_0
    //   23: aload_1
    //   24: aload_0
    //   25: invokevirtual 223	java/io/InputStream:read	([B)I
    //   28: pop
    //   29: new 106	java/lang/String
    //   32: dup
    //   33: aload_0
    //   34: ldc_w 421
    //   37: invokespecial 424	java/lang/String:<init>	([BLjava/lang/String;)V
    //   40: astore_0
    //   41: aload_1
    //   42: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   45: ldc_w 415
    //   48: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: areturn
    //   53: astore_0
    //   54: aconst_null
    //   55: astore_0
    //   56: aload_0
    //   57: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   60: ldc_w 415
    //   63: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   75: goto -15 -> 60
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   85: ldc_w 415
    //   88: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: athrow
    //   93: astore_0
    //   94: goto -13 -> 81
    //   97: astore_0
    //   98: goto -27 -> 71
    //   101: astore_0
    //   102: aload_1
    //   103: astore_0
    //   104: goto -48 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	File
    //   14	89	1	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   6	15	53	java/io/FileNotFoundException
    //   6	15	68	java/lang/Exception
    //   6	15	78	finally
    //   15	41	93	finally
    //   15	41	97	java/lang/Exception
    //   15	41	101	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String loadAssetsString(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 425
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 147	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 127	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: new 427	java/io/BufferedReader
    //   26: dup
    //   27: new 429	java/io/InputStreamReader
    //   30: dup
    //   31: aload_0
    //   32: ldc_w 421
    //   35: invokespecial 430	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 433	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 436	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +42 -> 90
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc_w 438
    //   61: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: goto -23 -> 42
    //   68: astore_3
    //   69: aload_1
    //   70: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   73: aload_0
    //   74: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   77: aload_2
    //   78: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_0
    //   82: ldc_w 425
    //   85: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_0
    //   89: areturn
    //   90: aload_1
    //   91: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   94: aload_0
    //   95: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   98: goto -21 -> 77
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_1
    //   107: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   110: aload_2
    //   111: invokestatic 139	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   114: ldc_w 425
    //   117: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_0
    //   126: astore_2
    //   127: aload_1
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: goto -25 -> 106
    //   134: astore_3
    //   135: aload_0
    //   136: astore_2
    //   137: aload_3
    //   138: astore_0
    //   139: goto -33 -> 106
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: goto -78 -> 69
    //   150: astore_1
    //   151: aconst_null
    //   152: astore_1
    //   153: goto -84 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramContext	Context
    //   0	156	1	paramString	String
    //   13	124	2	localObject1	Object
    //   46	7	3	str	String
    //   68	1	3	localIOException	IOException
    //   124	6	3	localObject2	Object
    //   134	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   42	47	68	java/io/IOException
    //   51	65	68	java/io/IOException
    //   14	23	101	finally
    //   23	42	122	finally
    //   42	47	134	finally
    //   51	65	134	finally
    //   14	23	142	java/io/IOException
    //   23	42	150	java/io/IOException
  }
  
  /* Error */
  public static String loadRawResourceString(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 443
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 429	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 258	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   14: iload_1
    //   15: invokevirtual 264	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   18: invokespecial 445	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: astore_0
    //   22: new 427	java/io/BufferedReader
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 433	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_2
    //   31: new 147	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: aload_2
    //   40: invokevirtual 436	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +37 -> 84
    //   50: aload_3
    //   51: aload 4
    //   53: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: bipush 10
    //   60: invokevirtual 448	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: goto -25 -> 39
    //   67: astore_3
    //   68: aload_0
    //   69: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   72: aload_2
    //   73: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   76: ldc_w 443
    //   79: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aconst_null
    //   83: areturn
    //   84: aload_0
    //   85: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   88: aload_2
    //   89: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   92: aload_3
    //   93: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_0
    //   97: ldc_w 443
    //   100: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: areturn
    //   105: astore_3
    //   106: aload_0
    //   107: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   110: aload_2
    //   111: invokestatic 440	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   114: ldc_w 443
    //   117: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_3
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramInt	int
    //   30	81	2	localBufferedReader	BufferedReader
    //   38	20	3	localStringBuilder	StringBuilder
    //   67	26	3	localIOException	IOException
    //   105	16	3	localObject	Object
    //   43	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   39	45	67	java/io/IOException
    //   50	64	67	java/io/IOException
    //   39	45	105	finally
    //   50	64	105	finally
  }
  
  public static String md5ForBase64Data(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(49708);
    paramString = new StringBuffer(paramString);
    int i = 0;
    while (i < 16)
    {
      paramString.append(new char[] { 114, 68, 122, 111, 105, 101, 53, 101, 51, 111, 110, 103, 102, 122, 49, 108 }[i]);
      i += 1;
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.toString().getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int k = paramString.length;
      i = j;
      while (i < k)
      {
        ((StringBuffer)localObject).append(String.format("%02x", new Object[] { Integer.valueOf(paramString[i] & 0xFF) }));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(49708);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      AppMethodBeat.o(49708);
    }
    return "";
  }
  
  /* Error */
  private static boolean performCopyAssetsFile(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: ldc_w 486
    //   12: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   15: aload_1
    //   16: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +10 -> 29
    //   22: aload_2
    //   23: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +11 -> 37
    //   29: ldc_w 486
    //   32: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: invokevirtual 127	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   41: astore 10
    //   43: new 69	java/io/File
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 9
    //   53: aload 9
    //   55: invokevirtual 171	java/io/File:exists	()Z
    //   58: ifeq +53 -> 111
    //   61: aload_3
    //   62: ifnull +36 -> 98
    //   65: aload_3
    //   66: aload_0
    //   67: aload_1
    //   68: aload 9
    //   70: invokeinterface 490 4 0
    //   75: istore 7
    //   77: iload 7
    //   79: ifeq +19 -> 98
    //   82: aconst_null
    //   83: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   86: aconst_null
    //   87: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   90: ldc_w 486
    //   93: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: iconst_1
    //   97: ireturn
    //   98: aload 9
    //   100: invokevirtual 180	java/io/File:isDirectory	()Z
    //   103: ifeq +8 -> 111
    //   106: aload 9
    //   108: invokestatic 275	com/tencent/ttpic/baseutils/FileUtils:delete	(Ljava/io/File;)V
    //   111: aload 9
    //   113: invokevirtual 494	java/io/File:getParentFile	()Ljava/io/File;
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 273	java/io/File:isFile	()Z
    //   121: ifeq +7 -> 128
    //   124: aload_0
    //   125: invokestatic 275	com/tencent/ttpic/baseutils/FileUtils:delete	(Ljava/io/File;)V
    //   128: aload_0
    //   129: invokevirtual 171	java/io/File:exists	()Z
    //   132: ifne +30 -> 162
    //   135: aload_0
    //   136: invokevirtual 395	java/io/File:mkdirs	()Z
    //   139: istore 7
    //   141: iload 7
    //   143: ifne +19 -> 162
    //   146: aconst_null
    //   147: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   150: aconst_null
    //   151: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   154: ldc_w 486
    //   157: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_0
    //   161: ireturn
    //   162: aload 10
    //   164: aload_1
    //   165: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 316	java/io/InputStream:available	()I
    //   173: istore 4
    //   175: iload 4
    //   177: ifgt +23 -> 200
    //   180: aload 8
    //   182: astore_1
    //   183: aload_0
    //   184: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   187: aload_1
    //   188: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   191: ldc_w 486
    //   194: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iload 5
    //   199: ireturn
    //   200: new 496	java/io/BufferedOutputStream
    //   203: dup
    //   204: new 242	java/io/FileOutputStream
    //   207: dup
    //   208: aload 9
    //   210: invokespecial 497	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   213: invokespecial 499	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   216: astore_2
    //   217: sipush 1024
    //   220: newarray byte
    //   222: astore_1
    //   223: aload_0
    //   224: aload_1
    //   225: invokevirtual 223	java/io/InputStream:read	([B)I
    //   228: istore 4
    //   230: iload 4
    //   232: ifle +39 -> 271
    //   235: aload_2
    //   236: aload_1
    //   237: iconst_0
    //   238: iload 4
    //   240: invokevirtual 229	java/io/OutputStream:write	([BII)V
    //   243: goto -20 -> 223
    //   246: astore_1
    //   247: aload_0
    //   248: astore_1
    //   249: aload_2
    //   250: astore_0
    //   251: aload 9
    //   253: invokestatic 275	com/tencent/ttpic/baseutils/FileUtils:delete	(Ljava/io/File;)V
    //   256: aload_1
    //   257: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   260: aload_0
    //   261: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   264: iload 6
    //   266: istore 5
    //   268: goto -77 -> 191
    //   271: aload_2
    //   272: astore_1
    //   273: iconst_1
    //   274: istore 5
    //   276: goto -93 -> 183
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_2
    //   284: aload_2
    //   285: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   288: aload_0
    //   289: invokestatic 318	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   292: ldc_w 486
    //   295: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_1
    //   299: athrow
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_3
    //   303: aload_0
    //   304: astore_2
    //   305: aload_3
    //   306: astore_0
    //   307: goto -23 -> 284
    //   310: astore_1
    //   311: aload_2
    //   312: astore_3
    //   313: aload_0
    //   314: astore_2
    //   315: aload_3
    //   316: astore_0
    //   317: goto -33 -> 284
    //   320: astore_2
    //   321: aload_1
    //   322: astore_3
    //   323: aload_2
    //   324: astore_1
    //   325: aload_3
    //   326: astore_2
    //   327: goto -43 -> 284
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_1
    //   335: goto -84 -> 251
    //   338: astore_1
    //   339: aconst_null
    //   340: astore_2
    //   341: aload_0
    //   342: astore_1
    //   343: aload_2
    //   344: astore_0
    //   345: goto -94 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramContext	Context
    //   0	348	1	paramString1	String
    //   0	348	2	paramString2	String
    //   0	348	3	paramAssetFileComparator	FileUtils.AssetFileComparator
    //   173	66	4	i	int
    //   4	271	5	bool1	boolean
    //   1	264	6	bool2	boolean
    //   75	67	7	bool3	boolean
    //   7	174	8	localObject	Object
    //   51	201	9	localFile	File
    //   41	122	10	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   217	223	246	java/lang/Throwable
    //   223	230	246	java/lang/Throwable
    //   235	243	246	java/lang/Throwable
    //   53	61	279	finally
    //   65	77	279	finally
    //   98	111	279	finally
    //   111	128	279	finally
    //   128	141	279	finally
    //   162	169	279	finally
    //   169	175	300	finally
    //   200	217	300	finally
    //   217	223	310	finally
    //   223	230	310	finally
    //   235	243	310	finally
    //   251	256	320	finally
    //   53	61	330	java/lang/Throwable
    //   65	77	330	java/lang/Throwable
    //   98	111	330	java/lang/Throwable
    //   111	128	330	java/lang/Throwable
    //   128	141	330	java/lang/Throwable
    //   162	169	330	java/lang/Throwable
    //   169	175	338	java/lang/Throwable
    //   200	217	338	java/lang/Throwable
  }
  
  public static String readTextFileFromRaw(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(49714);
    paramContext = new BufferedReader(new InputStreamReader(paramContext.getResources().openRawResource(paramInt)));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = paramContext.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append('\n');
      }
      paramContext = localStringBuilder.toString();
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(49714);
      return null;
    }
    AppMethodBeat.o(49714);
    return paramContext;
  }
  
  /* Error */
  public static String readTxtFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 503
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +11 -> 23
    //   15: ldc_w 503
    //   18: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 147	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_1
    //   32: ldc 23
    //   34: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   37: ifeq +129 -> 166
    //   40: aload_0
    //   41: invokevirtual 127	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   44: aload_1
    //   45: bipush 9
    //   47: invokevirtual 174	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: astore_0
    //   54: new 427	java/io/BufferedReader
    //   57: dup
    //   58: new 429	java/io/InputStreamReader
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 445	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   66: invokespecial 433	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 436	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +42 -> 118
    //   79: aload_3
    //   80: aload_2
    //   81: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: goto -15 -> 70
    //   88: astore_2
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 504	java/io/BufferedReader:close	()V
    //   97: aload_0
    //   98: ifnull +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 267	java/io/InputStream:close	()V
    //   105: aload_3
    //   106: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: ldc_w 503
    //   113: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_0
    //   117: areturn
    //   118: aload_1
    //   119: invokevirtual 504	java/io/BufferedReader:close	()V
    //   122: aload_0
    //   123: ifnull -18 -> 105
    //   126: aload_0
    //   127: invokevirtual 267	java/io/InputStream:close	()V
    //   130: goto -25 -> 105
    //   133: astore_0
    //   134: goto -29 -> 105
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 504	java/io/BufferedReader:close	()V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 267	java/io/InputStream:close	()V
    //   158: ldc_w 503
    //   161: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_0
    //   165: athrow
    //   166: new 427	java/io/BufferedReader
    //   169: dup
    //   170: new 506	java/io/FileReader
    //   173: dup
    //   174: aload_1
    //   175: invokespecial 507	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   178: invokespecial 433	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 436	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +28 -> 216
    //   191: aload_3
    //   192: aload_1
    //   193: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: goto -15 -> 182
    //   200: astore_1
    //   201: aload_0
    //   202: ifnull -97 -> 105
    //   205: aload_0
    //   206: invokevirtual 504	java/io/BufferedReader:close	()V
    //   209: goto -104 -> 105
    //   212: astore_0
    //   213: goto -108 -> 105
    //   216: aload_0
    //   217: invokevirtual 504	java/io/BufferedReader:close	()V
    //   220: goto -115 -> 105
    //   223: astore_0
    //   224: goto -119 -> 105
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 504	java/io/BufferedReader:close	()V
    //   238: ldc_w 503
    //   241: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload_0
    //   245: athrow
    //   246: astore_1
    //   247: goto -125 -> 122
    //   250: astore_1
    //   251: goto -154 -> 97
    //   254: astore_0
    //   255: goto -150 -> 105
    //   258: astore_1
    //   259: goto -109 -> 150
    //   262: astore_1
    //   263: goto -105 -> 158
    //   266: astore_1
    //   267: goto -29 -> 238
    //   270: astore_1
    //   271: aload_0
    //   272: astore_2
    //   273: aload_1
    //   274: astore_0
    //   275: aload_2
    //   276: astore_1
    //   277: goto -47 -> 230
    //   280: astore_0
    //   281: aload_2
    //   282: astore_0
    //   283: goto -82 -> 201
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_3
    //   289: aload_0
    //   290: astore_2
    //   291: aload_1
    //   292: astore_0
    //   293: aload_3
    //   294: astore_1
    //   295: goto -153 -> 142
    //   298: astore_3
    //   299: aload_0
    //   300: astore_2
    //   301: aload_3
    //   302: astore_0
    //   303: goto -161 -> 142
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_0
    //   311: goto -222 -> 89
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_1
    //   317: goto -228 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   0	320	1	paramString	String
    //   1	80	2	str	String
    //   88	1	2	localIOException	IOException
    //   141	160	2	localContext	Context
    //   30	264	3	localStringBuilder	StringBuilder
    //   298	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   70	75	88	java/io/IOException
    //   79	85	88	java/io/IOException
    //   126	130	133	java/io/IOException
    //   40	54	137	finally
    //   182	187	200	java/io/IOException
    //   191	197	200	java/io/IOException
    //   205	209	212	java/io/IOException
    //   216	220	223	java/io/IOException
    //   166	182	227	finally
    //   118	122	246	java/io/IOException
    //   93	97	250	java/io/IOException
    //   101	105	254	java/io/IOException
    //   146	150	258	java/io/IOException
    //   154	158	262	java/io/IOException
    //   234	238	266	java/io/IOException
    //   182	187	270	finally
    //   191	197	270	finally
    //   166	182	280	java/io/IOException
    //   54	70	286	finally
    //   70	75	298	finally
    //   79	85	298	finally
    //   40	54	306	java/io/IOException
    //   54	70	314	java/io/IOException
  }
  
  /* Error */
  public static void save(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 509
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 242	java/io/FileOutputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 497	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: astore_2
    //   15: new 511	java/io/BufferedWriter
    //   18: dup
    //   19: new 513	java/io/OutputStreamWriter
    //   22: dup
    //   23: aload_2
    //   24: ldc_w 421
    //   27: invokespecial 516	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   30: invokespecial 519	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   33: astore_0
    //   34: aload_0
    //   35: astore 4
    //   37: aload_2
    //   38: astore_3
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 521	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   44: aload_2
    //   45: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   48: aload_0
    //   49: invokestatic 523	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   52: ldc_w 509
    //   55: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore_1
    //   60: aconst_null
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_0
    //   65: astore 4
    //   67: aload_2
    //   68: astore_3
    //   69: aload_1
    //   70: invokestatic 235	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   73: aload_2
    //   74: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   77: aload_0
    //   78: invokestatic 523	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   81: ldc_w 509
    //   84: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: astore_0
    //   89: aconst_null
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_2
    //   95: invokestatic 246	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   98: aload 4
    //   100: invokestatic 523	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   103: ldc_w 509
    //   106: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: aconst_null
    //   113: astore 4
    //   115: goto -21 -> 94
    //   118: astore_0
    //   119: aload_3
    //   120: astore_2
    //   121: goto -27 -> 94
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: goto -63 -> 64
    //   130: astore_1
    //   131: goto -67 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramFile	File
    //   0	134	1	paramString	String
    //   14	107	2	localObject1	Object
    //   38	82	3	localObject2	Object
    //   35	79	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   6	15	59	java/lang/Exception
    //   6	15	88	finally
    //   15	34	111	finally
    //   39	44	118	finally
    //   69	73	118	finally
    //   15	34	124	java/lang/Exception
    //   39	44	130	java/lang/Exception
  }
  
  public static String toBase64(String paramString)
  {
    AppMethodBeat.i(49709);
    FileInputStream localFileInputStream;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localFileInputStream = new FileInputStream(new File(paramString));
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramString = new Base64OutputStream(localByteArrayOutputStream, 2);
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        paramString.write(arrayOfByte, 0, i);
      }
      AppMethodBeat.o(49709);
    }
    catch (Exception paramString)
    {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      paramString.flush();
      paramString.close();
      paramString = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      try
      {
        localByteArrayOutputStream.close();
        localFileInputStream.close();
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.FileUtils
 * JD-Core Version:    0.7.0.1
 */