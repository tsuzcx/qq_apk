package com.tencent.ttpic.baseutils;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64OutputStream;
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
  public static final FileUtils.AssetFileComparator SIMPLE_ASSET_COMPARATOR = new FileUtils.AssetFileComparator()
  {
    public final boolean equals(Context paramAnonymousContext, String paramAnonymousString, File paramAnonymousFile)
    {
      long l = FileUtils.getAssetLength(paramAnonymousContext, paramAnonymousString);
      return (l != -1L) && (l == paramAnonymousFile.length());
    }
  };
  private static final String TAG = FileUtils.class.getSimpleName();
  
  public static boolean Move(File paramFile, String paramString)
  {
    return paramFile.renameTo(new File(new File(paramString), paramFile.getName()));
  }
  
  public static void asyncCopyFile(InputStream paramInputStream, String paramString, FileUtils.OnFileCopyListener paramOnFileCopyListener)
  {
    paramInputStream = new FileUtils.FileCopyTask(paramInputStream, paramString);
    paramInputStream.setOnFileCopyListener(paramOnFileCopyListener);
    paramInputStream.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[0]);
  }
  
  /* Error */
  public static String checkAssetsPhoto(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 113	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore_0
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   24: aload_1
    //   25: areturn
    //   26: astore_2
    //   27: aconst_null
    //   28: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   31: aload_1
    //   32: ldc 127
    //   34: invokevirtual 131	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   37: iconst_m1
    //   38: if_icmpeq +68 -> 106
    //   41: new 133	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: iconst_0
    //   50: aload_1
    //   51: bipush 46
    //   53: invokevirtual 137	java/lang/String:lastIndexOf	(I)I
    //   56: iconst_1
    //   57: iadd
    //   58: invokevirtual 141	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 147
    //   66: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   104: aload_0
    //   105: athrow
    //   106: new 133	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   113: aload_1
    //   114: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 16
    //   119: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_2
    //   126: aload_0
    //   127: aload_2
    //   128: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore_3
    //   132: aload_3
    //   133: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: aconst_null
    //   140: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   143: new 133	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   150: aload_1
    //   151: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 22
    //   156: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_2
    //   163: aload_0
    //   164: aload_2
    //   165: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   168: astore_3
    //   169: aload_3
    //   170: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   173: aload_2
    //   174: areturn
    //   175: astore_0
    //   176: aconst_null
    //   177: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   180: aload_0
    //   181: athrow
    //   182: astore_2
    //   183: aconst_null
    //   184: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   187: new 133	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   194: aload_1
    //   195: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 19
    //   200: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore_1
    //   207: aload_0
    //   208: aload_1
    //   209: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   212: astore_0
    //   213: aload_0
    //   214: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   217: aload_1
    //   218: areturn
    //   219: astore_0
    //   220: aconst_null
    //   221: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   224: aload_0
    //   225: athrow
    //   226: astore_0
    //   227: aconst_null
    //   228: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   238: aload_0
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	Context
    //   0	240	1	paramString	String
    //   19	2	2	localInputStream1	InputStream
    //   26	1	2	localIOException1	IOException
    //   125	12	2	str1	String
    //   138	1	2	localIOException2	IOException
    //   162	12	2	str2	String
    //   182	1	2	localIOException3	IOException
    //   131	39	3	localInputStream2	InputStream
    // Exception table:
    //   from	to	target	type
    //   14	20	26	java/io/IOException
    //   14	20	85	finally
    //   73	79	92	java/io/IOException
    //   73	79	99	finally
    //   126	132	138	java/io/IOException
    //   126	132	175	finally
    //   163	169	182	java/io/IOException
    //   163	169	219	finally
    //   207	213	226	java/io/IOException
    //   207	213	233	finally
  }
  
  public static String checkPhoto(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = null;
    }
    String str2;
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = paramString;
        } while (new File(paramString).exists());
        str1 = paramString;
      } while (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") != -1);
      str1 = paramString + ".jpg";
      if (new File(str1).exists()) {
        return str1;
      }
      str2 = paramString + ".png";
      str1 = paramString;
    } while (!new File(str2).exists());
    return str2;
  }
  
  public static void clearDir(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
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
  }
  
  public static void clearDirs(File[] paramArrayOfFile)
  {
    if (paramArrayOfFile == null) {}
    for (;;)
    {
      return;
      int j = paramArrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        clearDir(paramArrayOfFile[i]);
        i += 1;
      }
    }
  }
  
  private static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    return copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_COMPARATOR);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    return performCopyAssetsFile(paramContext, paramString1, paramString2, paramAssetFileComparator);
  }
  
  public static boolean copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if ((paramInputStream == null) || (paramOutputStream == null)) {
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
      return true;
    }
    catch (Exception paramInputStream)
    {
      LogUtils.e(paramInputStream);
    }
    for (;;)
    {
      paramOutputStream.flush();
    }
  }
  
  /* Error */
  public static boolean copyFile(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: new 220	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: sipush 4096
    //   12: newarray byte
    //   14: astore_3
    //   15: aload_0
    //   16: aload_3
    //   17: invokevirtual 202	java/io/InputStream:read	([B)I
    //   20: istore_2
    //   21: iload_2
    //   22: ifle +24 -> 46
    //   25: aload_1
    //   26: aload_3
    //   27: iconst_0
    //   28: iload_2
    //   29: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   32: goto -17 -> 15
    //   35: astore_3
    //   36: aload_0
    //   37: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   40: aload_1
    //   41: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   50: aload_1
    //   51: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_0
    //   60: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   63: aload_1
    //   64: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   67: aload_3
    //   68: athrow
    //   69: astore_3
    //   70: goto -11 -> 59
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -40 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramInputStream	InputStream
    //   0	79	1	paramString	String
    //   20	9	2	i	int
    //   14	13	3	arrayOfByte	byte[]
    //   35	1	3	localException	Exception
    //   56	12	3	localObject1	Object
    //   69	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	15	35	java/lang/Exception
    //   15	21	35	java/lang/Exception
    //   25	32	35	java/lang/Exception
    //   0	9	56	finally
    //   9	15	69	finally
    //   15	21	69	finally
    //   25	32	69	finally
    //   0	9	73	java/lang/Exception
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 58	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 156	java/io/File:exists	()Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifne +13 -> 26
    //   16: aconst_null
    //   17: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   20: aconst_null
    //   21: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: new 227	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 228	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: new 220	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload_0
    //   46: astore 5
    //   48: aload 4
    //   50: astore_1
    //   51: sipush 4096
    //   54: newarray byte
    //   56: astore 6
    //   58: aload_0
    //   59: astore 5
    //   61: aload 4
    //   63: astore_1
    //   64: aload 4
    //   66: aload 6
    //   68: invokevirtual 202	java/io/InputStream:read	([B)I
    //   71: istore_2
    //   72: iload_2
    //   73: ifle +44 -> 117
    //   76: aload_0
    //   77: astore 5
    //   79: aload 4
    //   81: astore_1
    //   82: aload_0
    //   83: aload 6
    //   85: iconst_0
    //   86: iload_2
    //   87: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   90: goto -32 -> 58
    //   93: astore 6
    //   95: aload_0
    //   96: astore 5
    //   98: aload 4
    //   100: astore_1
    //   101: aload 6
    //   103: invokestatic 214	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   106: aload 4
    //   108: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   111: aload_0
    //   112: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 4
    //   119: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   122: aload_0
    //   123: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_1
    //   135: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   138: aload 5
    //   140: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: aconst_null
    //   147: astore 5
    //   149: aload 4
    //   151: astore_1
    //   152: goto -18 -> 134
    //   155: astore_0
    //   156: goto -22 -> 134
    //   159: astore 6
    //   161: aconst_null
    //   162: astore_0
    //   163: aconst_null
    //   164: astore 4
    //   166: goto -71 -> 95
    //   169: astore 6
    //   171: aconst_null
    //   172: astore_0
    //   173: goto -78 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    //   71	16	2	i	int
    //   11	2	3	bool	boolean
    //   34	131	4	localFileInputStream	FileInputStream
    //   46	102	5	str	String
    //   56	28	6	arrayOfByte	byte[]
    //   93	9	6	localException1	Exception
    //   159	1	6	localException2	Exception
    //   169	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   51	58	93	java/lang/Exception
    //   64	72	93	java/lang/Exception
    //   82	90	93	java/lang/Exception
    //   0	12	128	finally
    //   26	36	128	finally
    //   36	45	145	finally
    //   51	58	155	finally
    //   64	72	155	finally
    //   82	90	155	finally
    //   101	106	155	finally
    //   0	12	159	java/lang/Exception
    //   26	36	159	java/lang/Exception
    //   36	45	169	java/lang/Exception
  }
  
  /* Error */
  public static void copyRaw(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 234	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 240	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore 4
    //   10: new 220	java/io/FileOutputStream
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload 4
    //   21: aload_0
    //   22: invokestatic 242	com/tencent/ttpic/baseutils/FileUtils:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   25: pop
    //   26: aload 4
    //   28: invokevirtual 243	java/io/InputStream:close	()V
    //   31: aload_0
    //   32: invokevirtual 244	java/io/FileOutputStream:flush	()V
    //   35: aload_0
    //   36: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   39: return
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_0
    //   43: aload 4
    //   45: invokevirtual 243	java/io/InputStream:close	()V
    //   48: aload_0
    //   49: ifnull -10 -> 39
    //   52: aload_0
    //   53: invokevirtual 244	java/io/FileOutputStream:flush	()V
    //   56: aload_0
    //   57: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   60: return
    //   61: astore_0
    //   62: return
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_2
    //   66: aload 4
    //   68: invokevirtual 243	java/io/InputStream:close	()V
    //   71: aload_2
    //   72: ifnull +11 -> 83
    //   75: aload_2
    //   76: invokevirtual 244	java/io/FileOutputStream:flush	()V
    //   79: aload_2
    //   80: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_2
    //   86: goto -3 -> 83
    //   89: astore_2
    //   90: aload_0
    //   91: astore_3
    //   92: aload_2
    //   93: astore_0
    //   94: aload_3
    //   95: astore_2
    //   96: goto -30 -> 66
    //   99: astore_2
    //   100: goto -57 -> 43
    //   103: astore_0
    //   104: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramContext	Context
    //   0	105	1	paramInt	int
    //   0	105	2	paramString	String
    //   91	4	3	localContext	Context
    //   8	59	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   10	19	40	java/lang/Exception
    //   43	48	61	java/io/IOException
    //   52	60	61	java/io/IOException
    //   10	19	63	finally
    //   66	71	85	java/io/IOException
    //   75	83	85	java/io/IOException
    //   19	26	89	finally
    //   19	26	99	java/lang/Exception
    //   26	39	103	java/io/IOException
  }
  
  public static void delete(File paramFile)
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
      delete(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void delete(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    delete(new File(paramString));
  }
  
  public static void deleteAllFilesOfDir(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
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
  }
  
  public static void deleteFiles(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
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
    }
  }
  
  public static boolean exists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.indexOf("assets") < 0) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 113	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokevirtual 274	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 280	android/content/res/AssetFileDescriptor:getLength	()J
    //   20: lstore_3
    //   21: aload_0
    //   22: ifnull +7 -> 29
    //   25: aload_0
    //   26: invokevirtual 281	android/content/res/AssetFileDescriptor:close	()V
    //   29: lload_3
    //   30: lreturn
    //   31: astore_0
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 281	android/content/res/AssetFileDescriptor:close	()V
    //   42: aload 6
    //   44: aload_1
    //   45: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 285	java/io/InputStream:available	()I
    //   53: istore_2
    //   54: iload_2
    //   55: i2l
    //   56: lstore_3
    //   57: aload_0
    //   58: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   61: lload_3
    //   62: lreturn
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 281	android/content/res/AssetFileDescriptor:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_0
    //   77: aload 5
    //   79: astore_0
    //   80: aload_0
    //   81: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   84: ldc2_w 288
    //   87: lreturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_0
    //   98: lload_3
    //   99: lreturn
    //   100: astore_0
    //   101: goto -59 -> 42
    //   104: astore_0
    //   105: goto -31 -> 74
    //   108: astore_1
    //   109: goto -18 -> 91
    //   112: astore_1
    //   113: goto -33 -> 80
    //   116: astore_1
    //   117: goto -51 -> 66
    //   120: astore 7
    //   122: goto -88 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramContext	Context
    //   0	125	1	paramString	String
    //   53	2	2	i	int
    //   20	79	3	l	long
    //   1	77	5	localObject	Object
    //   7	36	6	localAssetManager	android.content.res.AssetManager
    //   120	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   9	16	31	java/io/IOException
    //   9	16	63	finally
    //   42	49	76	java/io/IOException
    //   42	49	88	finally
    //   25	29	97	java/io/IOException
    //   38	42	100	java/io/IOException
    //   70	74	104	java/io/IOException
    //   49	54	108	finally
    //   49	54	112	java/io/IOException
    //   16	21	116	finally
    //   16	21	120	java/io/IOException
  }
  
  public static String getFileNameByPath(String paramString)
  {
    LogUtils.v(TAG, "[getFileNameByPath] path = " + paramString);
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
    LogUtils.v(TAG, "[getFileNameByPath] return title = " + (String)localObject1);
    return localObject1;
  }
  
  public static String getFileNameFromUrl(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while ((i == -1) || (i == paramString.length() - 1));
    return paramString.substring(i + 1);
  }
  
  public static String getFileSuffixFromUrl(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf(".");
    } while ((i == -1) || (i == paramString.length() - 1));
    return paramString.substring(i + 1);
  }
  
  public static String getMD5(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists()) {}
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      int k;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        paramString1 = new FileInputStream(paramString1);
        byte[] arrayOfByte = new byte[4096];
        i = paramString1.read(arrayOfByte);
        if (i != -1)
        {
          ((MessageDigest)localObject).update(arrayOfByte, 0, i);
          continue;
        }
        ((MessageDigest)localObject).update(paramString2.getBytes());
        paramString1.close();
        paramString2 = new StringBuilder();
        localObject = ((MessageDigest)localObject).digest();
        j = localObject.length;
        i = 0;
      }
      catch (Exception paramString1) {}
      paramString2.append(paramString1);
      paramString2.append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label135;
      paramString1 = paramString2.toString();
      return paramString1;
      return null;
      label135:
      if (i < j)
      {
        k = localObject[i] & 0xFF;
        if (k < 16) {
          paramString1 = "0";
        } else {
          paramString1 = "";
        }
      }
    }
  }
  
  public static String getRealPath(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("assets://")) {
        str = paramString.substring(9);
      }
    }
    return str;
  }
  
  public static String getSHA1(String paramString)
  {
    if (new File(paramString).exists()) {}
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int i;
      int j;
      int k;
      try
      {
        localObject2 = MessageDigest.getInstance("SHA-1");
        paramString = new FileInputStream(paramString);
        localObject1 = new byte[4096];
        i = paramString.read((byte[])localObject1);
        if (i != -1)
        {
          ((MessageDigest)localObject2).update((byte[])localObject1, 0, i);
          continue;
        }
        paramString.close();
        localObject1 = new StringBuilder();
        localObject2 = ((MessageDigest)localObject2).digest();
        j = localObject2.length;
        i = 0;
      }
      catch (Exception paramString) {}
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label129;
      paramString = ((StringBuilder)localObject1).toString();
      return paramString;
      return null;
      label129:
      if (i < j)
      {
        k = localObject2[i] & 0xFF;
        if (k < 16) {
          paramString = "0";
        } else {
          paramString = "";
        }
      }
    }
  }
  
  public static boolean isDirectoryWritable(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory())) {}
    do
    {
      return false;
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
    } while (!paramString.isDirectory());
    try
    {
      boolean bool = paramString.canWrite();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String load(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    if (paramString1.startsWith("assets://")) {
      return loadAssetsString(paramContext, getRealPath(paramString1) + File.separator + paramString2);
    }
    return load(new File(paramString1 + File.separator + paramString2));
  }
  
  /* Error */
  private static String load(File paramFile)
  {
    // Byte code:
    //   0: new 227	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 371	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_0
    //   12: invokevirtual 373	java/io/File:length	()J
    //   15: l2i
    //   16: newarray byte
    //   18: astore_0
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 202	java/io/InputStream:read	([B)I
    //   26: pop
    //   27: aload_2
    //   28: astore_1
    //   29: new 93	java/lang/String
    //   32: dup
    //   33: aload_0
    //   34: ldc_w 375
    //   37: invokespecial 378	java/lang/String:<init>	([BLjava/lang/String;)V
    //   40: astore_0
    //   41: aload_2
    //   42: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 379	java/lang/Exception:toString	()Ljava/lang/String;
    //   65: pop
    //   66: aload_2
    //   67: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   70: goto -16 -> 54
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   80: aload_0
    //   81: athrow
    //   82: astore_0
    //   83: goto -7 -> 76
    //   86: astore_0
    //   87: goto -28 -> 59
    //   90: astore_0
    //   91: aload_2
    //   92: astore_0
    //   93: goto -43 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramFile	File
    //   10	67	1	localFileInputStream1	FileInputStream
    //   8	84	2	localFileInputStream2	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	9	47	java/io/FileNotFoundException
    //   0	9	56	java/lang/Exception
    //   0	9	73	finally
    //   11	19	82	finally
    //   21	27	82	finally
    //   29	41	82	finally
    //   61	66	82	finally
    //   11	19	86	java/lang/Exception
    //   21	27	86	java/lang/Exception
    //   29	41	86	java/lang/Exception
    //   11	19	90	java/io/FileNotFoundException
    //   21	27	90	java/io/FileNotFoundException
    //   29	41	90	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String loadAssetsString(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 133	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 113	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: aload_1
    //   13: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_0
    //   17: new 381	java/io/BufferedReader
    //   20: dup
    //   21: new 383	java/io/InputStreamReader
    //   24: dup
    //   25: aload_0
    //   26: ldc_w 375
    //   29: invokespecial 384	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   32: invokespecial 387	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +34 -> 76
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: ldc_w 392
    //   55: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -23 -> 36
    //   62: astore_3
    //   63: aload_1
    //   64: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   67: aload_0
    //   68: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   71: aload_2
    //   72: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: areturn
    //   76: aload_1
    //   77: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   80: aload_0
    //   81: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   84: goto -13 -> 71
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_1
    //   93: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   96: aload_2
    //   97: invokestatic 125	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   100: aload_0
    //   101: athrow
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: aload_1
    //   108: astore_0
    //   109: aload_3
    //   110: astore_1
    //   111: goto -19 -> 92
    //   114: astore_3
    //   115: aload_0
    //   116: astore_2
    //   117: aload_3
    //   118: astore_0
    //   119: goto -27 -> 92
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: goto -64 -> 63
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_1
    //   133: goto -70 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   0	136	1	paramString	String
    //   7	110	2	localObject1	Object
    //   40	7	3	str	String
    //   62	1	3	localIOException	IOException
    //   104	6	3	localObject2	Object
    //   114	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	62	java/io/IOException
    //   45	59	62	java/io/IOException
    //   8	17	87	finally
    //   17	36	102	finally
    //   36	41	114	finally
    //   45	59	114	finally
    //   8	17	122	java/io/IOException
    //   17	36	130	java/io/IOException
  }
  
  /* Error */
  public static String loadRawResourceString(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 383	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 234	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: iload_1
    //   9: invokevirtual 240	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   12: invokespecial 398	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: new 381	java/io/BufferedReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 387	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: new 133	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_2
    //   34: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +31 -> 72
    //   44: aload_3
    //   45: aload 4
    //   47: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: bipush 10
    //   54: invokevirtual 401	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -25 -> 33
    //   61: astore_3
    //   62: aload_0
    //   63: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   66: aload_2
    //   67: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   76: aload_2
    //   77: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   80: aload_3
    //   81: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: areturn
    //   85: astore_3
    //   86: aload_0
    //   87: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   90: aload_2
    //   91: invokestatic 394	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   94: aload_3
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramInt	int
    //   24	67	2	localBufferedReader	BufferedReader
    //   32	20	3	localStringBuilder	StringBuilder
    //   61	20	3	localIOException	IOException
    //   85	10	3	localObject	Object
    //   37	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   33	39	61	java/io/IOException
    //   44	58	61	java/io/IOException
    //   33	39	85	finally
    //   44	58	85	finally
  }
  
  public static String md5ForBase64Data(String paramString)
  {
    int j = 0;
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
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  /* Error */
  private static boolean performCopyAssetsFile(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_1
    //   7: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokevirtual 113	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   26: astore 9
    //   28: new 58	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 8
    //   38: aload 8
    //   40: invokevirtual 156	java/io/File:exists	()Z
    //   43: ifeq +47 -> 90
    //   46: aload_3
    //   47: ifnull +30 -> 77
    //   50: aload_3
    //   51: aload_0
    //   52: aload_1
    //   53: aload 8
    //   55: invokeinterface 442 4 0
    //   60: istore 6
    //   62: iload 6
    //   64: ifeq +13 -> 77
    //   67: aconst_null
    //   68: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload 8
    //   79: invokevirtual 164	java/io/File:isDirectory	()Z
    //   82: ifeq +8 -> 90
    //   85: aload 8
    //   87: invokestatic 250	com/tencent/ttpic/baseutils/FileUtils:delete	(Ljava/io/File;)V
    //   90: aload 8
    //   92: invokevirtual 446	java/io/File:getParentFile	()Ljava/io/File;
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 248	java/io/File:isFile	()Z
    //   100: ifeq +7 -> 107
    //   103: aload_0
    //   104: invokestatic 250	com/tencent/ttpic/baseutils/FileUtils:delete	(Ljava/io/File;)V
    //   107: aload_0
    //   108: invokevirtual 156	java/io/File:exists	()Z
    //   111: ifne +24 -> 135
    //   114: aload_0
    //   115: invokevirtual 351	java/io/File:mkdirs	()Z
    //   118: istore 6
    //   120: iload 6
    //   122: ifne +13 -> 135
    //   125: aconst_null
    //   126: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   129: aconst_null
    //   130: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 9
    //   137: aload_1
    //   138: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 285	java/io/InputStream:available	()I
    //   146: istore 4
    //   148: iload 4
    //   150: ifgt +17 -> 167
    //   153: aload 7
    //   155: astore_1
    //   156: aload_0
    //   157: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   160: aload_1
    //   161: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   164: iload 5
    //   166: ireturn
    //   167: new 448	java/io/BufferedOutputStream
    //   170: dup
    //   171: new 220	java/io/FileOutputStream
    //   174: dup
    //   175: aload 8
    //   177: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   180: invokespecial 451	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   183: astore_2
    //   184: sipush 1024
    //   187: newarray byte
    //   189: astore_1
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 202	java/io/InputStream:read	([B)I
    //   195: istore 4
    //   197: iload 4
    //   199: ifle +34 -> 233
    //   202: aload_2
    //   203: aload_1
    //   204: iconst_0
    //   205: iload 4
    //   207: invokevirtual 208	java/io/OutputStream:write	([BII)V
    //   210: goto -20 -> 190
    //   213: astore_1
    //   214: aload_0
    //   215: astore_1
    //   216: aload_2
    //   217: astore_0
    //   218: aload 8
    //   220: invokestatic 250	com/tencent/ttpic/baseutils/FileUtils:delete	(Ljava/io/File;)V
    //   223: aload_1
    //   224: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   227: aload_0
    //   228: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_2
    //   234: astore_1
    //   235: iconst_1
    //   236: istore 5
    //   238: goto -82 -> 156
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   250: aload_0
    //   251: invokestatic 287	com/tencent/ttpic/baseutils/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: aconst_null
    //   258: astore_3
    //   259: aload_0
    //   260: astore_2
    //   261: aload_3
    //   262: astore_0
    //   263: goto -17 -> 246
    //   266: astore_1
    //   267: aload_2
    //   268: astore_3
    //   269: aload_0
    //   270: astore_2
    //   271: aload_3
    //   272: astore_0
    //   273: goto -27 -> 246
    //   276: astore_2
    //   277: aload_1
    //   278: astore_3
    //   279: aload_2
    //   280: astore_1
    //   281: aload_3
    //   282: astore_2
    //   283: goto -37 -> 246
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_1
    //   291: goto -73 -> 218
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_0
    //   298: astore_1
    //   299: aload_2
    //   300: astore_0
    //   301: goto -83 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramString1	String
    //   0	304	2	paramString2	String
    //   0	304	3	paramAssetFileComparator	FileUtils.AssetFileComparator
    //   146	60	4	i	int
    //   1	236	5	bool1	boolean
    //   60	61	6	bool2	boolean
    //   4	150	7	localObject	Object
    //   36	183	8	localFile	File
    //   26	110	9	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   184	190	213	java/lang/Throwable
    //   190	197	213	java/lang/Throwable
    //   202	210	213	java/lang/Throwable
    //   38	46	241	finally
    //   50	62	241	finally
    //   77	90	241	finally
    //   90	107	241	finally
    //   107	120	241	finally
    //   135	142	241	finally
    //   142	148	256	finally
    //   167	184	256	finally
    //   184	190	266	finally
    //   190	197	266	finally
    //   202	210	266	finally
    //   218	223	276	finally
    //   38	46	286	java/lang/Throwable
    //   50	62	286	java/lang/Throwable
    //   77	90	286	java/lang/Throwable
    //   90	107	286	java/lang/Throwable
    //   107	120	286	java/lang/Throwable
    //   135	142	286	java/lang/Throwable
    //   142	148	294	java/lang/Throwable
    //   167	184	294	java/lang/Throwable
  }
  
  public static String readTextFileFromRaw(Context paramContext, int paramInt)
  {
    paramContext = new BufferedReader(new InputStreamReader(paramContext.getResources().openRawResource(paramInt)));
    localStringBuilder = new StringBuilder();
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
      return localStringBuilder.toString();
    }
    catch (IOException paramContext)
    {
      return null;
    }
  }
  
  /* Error */
  public static String readTxtFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 133	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_1
    //   20: ldc 25
    //   22: invokevirtual 344	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifeq +115 -> 140
    //   28: aload_0
    //   29: invokevirtual 113	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: aload_1
    //   33: bipush 9
    //   35: invokevirtual 159	java/lang/String:substring	(I)Ljava/lang/String;
    //   38: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore_0
    //   42: new 381	java/io/BufferedReader
    //   45: dup
    //   46: new 383	java/io/InputStreamReader
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 398	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 387	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +34 -> 98
    //   67: aload_3
    //   68: aload_2
    //   69: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -15 -> 58
    //   76: astore_2
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 454	java/io/BufferedReader:close	()V
    //   85: aload_0
    //   86: ifnull +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 243	java/io/InputStream:close	()V
    //   93: aload_3
    //   94: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: areturn
    //   98: aload_1
    //   99: invokevirtual 454	java/io/BufferedReader:close	()V
    //   102: aload_0
    //   103: ifnull -10 -> 93
    //   106: aload_0
    //   107: invokevirtual 243	java/io/InputStream:close	()V
    //   110: goto -17 -> 93
    //   113: astore_0
    //   114: goto -21 -> 93
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 454	java/io/BufferedReader:close	()V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 243	java/io/InputStream:close	()V
    //   138: aload_0
    //   139: athrow
    //   140: new 381	java/io/BufferedReader
    //   143: dup
    //   144: new 456	java/io/FileReader
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 457	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   152: invokespecial 387	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull +28 -> 190
    //   165: aload_3
    //   166: aload_1
    //   167: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: goto -15 -> 156
    //   174: astore_1
    //   175: aload_0
    //   176: ifnull -83 -> 93
    //   179: aload_0
    //   180: invokevirtual 454	java/io/BufferedReader:close	()V
    //   183: goto -90 -> 93
    //   186: astore_0
    //   187: goto -94 -> 93
    //   190: aload_0
    //   191: invokevirtual 454	java/io/BufferedReader:close	()V
    //   194: goto -101 -> 93
    //   197: astore_0
    //   198: goto -105 -> 93
    //   201: astore_0
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 454	java/io/BufferedReader:close	()V
    //   212: aload_0
    //   213: athrow
    //   214: astore_1
    //   215: goto -113 -> 102
    //   218: astore_1
    //   219: goto -134 -> 85
    //   222: astore_0
    //   223: goto -130 -> 93
    //   226: astore_1
    //   227: goto -97 -> 130
    //   230: astore_1
    //   231: goto -93 -> 138
    //   234: astore_1
    //   235: goto -23 -> 212
    //   238: astore_1
    //   239: aload_0
    //   240: astore_2
    //   241: aload_1
    //   242: astore_0
    //   243: aload_2
    //   244: astore_1
    //   245: goto -41 -> 204
    //   248: astore_0
    //   249: aload_2
    //   250: astore_0
    //   251: goto -76 -> 175
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_3
    //   257: aload_0
    //   258: astore_2
    //   259: aload_1
    //   260: astore_0
    //   261: aload_3
    //   262: astore_1
    //   263: goto -141 -> 122
    //   266: astore_3
    //   267: aload_0
    //   268: astore_2
    //   269: aload_3
    //   270: astore_0
    //   271: goto -149 -> 122
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_0
    //   279: goto -202 -> 77
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -208 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramContext	Context
    //   0	288	1	paramString	String
    //   1	68	2	str	String
    //   76	1	2	localIOException	IOException
    //   121	148	2	localContext	Context
    //   18	244	3	localStringBuilder	StringBuilder
    //   266	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   58	63	76	java/io/IOException
    //   67	73	76	java/io/IOException
    //   106	110	113	java/io/IOException
    //   28	42	117	finally
    //   156	161	174	java/io/IOException
    //   165	171	174	java/io/IOException
    //   179	183	186	java/io/IOException
    //   190	194	197	java/io/IOException
    //   140	156	201	finally
    //   98	102	214	java/io/IOException
    //   81	85	218	java/io/IOException
    //   89	93	222	java/io/IOException
    //   126	130	226	java/io/IOException
    //   134	138	230	java/io/IOException
    //   208	212	234	java/io/IOException
    //   156	161	238	finally
    //   165	171	238	finally
    //   140	156	248	java/io/IOException
    //   42	58	254	finally
    //   58	63	266	finally
    //   67	73	266	finally
    //   28	42	274	java/io/IOException
    //   42	58	282	java/io/IOException
  }
  
  /* Error */
  public static void save(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 220	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: new 460	java/io/BufferedWriter
    //   12: dup
    //   13: new 462	java/io/OutputStreamWriter
    //   16: dup
    //   17: aload_2
    //   18: ldc_w 375
    //   21: invokespecial 465	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   24: invokespecial 468	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   27: astore_0
    //   28: aload_0
    //   29: astore 4
    //   31: aload_2
    //   32: astore_3
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 470	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   42: aload_0
    //   43: invokestatic 472	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   46: return
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_0
    //   53: astore 4
    //   55: aload_2
    //   56: astore_3
    //   57: aload_1
    //   58: invokestatic 214	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   61: aload_2
    //   62: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   65: aload_0
    //   66: invokestatic 472	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   69: return
    //   70: astore_0
    //   71: aconst_null
    //   72: astore 4
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_2
    //   77: invokestatic 224	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   80: aload 4
    //   82: invokestatic 472	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   85: aload_0
    //   86: athrow
    //   87: astore_0
    //   88: aconst_null
    //   89: astore 4
    //   91: goto -15 -> 76
    //   94: astore_0
    //   95: aload_3
    //   96: astore_2
    //   97: goto -21 -> 76
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: goto -51 -> 52
    //   106: astore_1
    //   107: goto -55 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramFile	File
    //   0	110	1	paramString	String
    //   8	89	2	localObject1	Object
    //   32	64	3	localObject2	Object
    //   29	61	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   0	9	47	java/lang/Exception
    //   0	9	70	finally
    //   9	28	87	finally
    //   33	38	94	finally
    //   57	61	94	finally
    //   9	28	100	java/lang/Exception
    //   33	38	106	java/lang/Exception
  }
  
  public static String toBase64(String paramString)
  {
    try
    {
      paramString = new FileInputStream(new File(paramString));
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject = new Base64OutputStream(localByteArrayOutputStream, 2);
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        ((Base64OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      ((Base64OutputStream)localObject).flush();
      ((Base64OutputStream)localObject).close();
      localObject = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      try
      {
        localByteArrayOutputStream.close();
        paramString.close();
        return localObject;
      }
      catch (Exception paramString)
      {
        return localObject;
      }
      return null;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.FileUtils
 * JD-Core Version:    0.7.0.1
 */