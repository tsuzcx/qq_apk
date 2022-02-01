package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public class SharePatchFileUtil
{
  private static final String TAG = "Tinker.PatchFileUtil";
  private static char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static boolean checkIfMd5Valid(String paramString)
  {
    return (paramString != null) && (paramString.length() == 32);
  }
  
  /* Error */
  public static boolean checkResourceArscMd5(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 46	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 49	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   14: astore_3
    //   15: aload_3
    //   16: ldc 51
    //   18: invokevirtual 55	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +20 -> 45
    //   28: ldc 8
    //   30: ldc 57
    //   32: iconst_0
    //   33: anewarray 4	java/lang/Object
    //   36: invokestatic 63	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_3
    //   40: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   43: iconst_0
    //   44: ireturn
    //   45: aload 5
    //   47: astore_0
    //   48: aload_3
    //   49: aload 4
    //   51: invokevirtual 71	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   54: astore 4
    //   56: aload 4
    //   58: astore_0
    //   59: aload 4
    //   61: invokestatic 75	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +28 -> 96
    //   71: aload 4
    //   73: astore_0
    //   74: aload 5
    //   76: aload_1
    //   77: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: istore_2
    //   81: iload_2
    //   82: ifeq +14 -> 96
    //   85: aload 4
    //   87: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   90: aload_3
    //   91: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload 4
    //   98: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   101: aload_3
    //   102: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_1
    //   108: aload_0
    //   109: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   112: aload_1
    //   113: athrow
    //   114: astore_1
    //   115: aload_3
    //   116: astore_0
    //   117: ldc 8
    //   119: new 85	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 87
    //   125: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokevirtual 96	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 63	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_1
    //   152: aload_0
    //   153: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: aload 4
    //   161: astore_0
    //   162: goto -45 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramFile	File
    //   0	165	1	paramString	String
    //   80	2	2	bool	boolean
    //   14	102	3	localZipFile	ZipFile
    //   1	159	4	localObject	Object
    //   4	71	5	str	String
    // Exception table:
    //   from	to	target	type
    //   48	56	107	finally
    //   59	66	107	finally
    //   74	81	107	finally
    //   15	23	114	finally
    //   28	39	114	finally
    //   85	90	114	finally
    //   96	101	114	finally
    //   108	114	114	finally
    //   117	145	151	finally
    //   6	15	158	finally
  }
  
  /* Error */
  public static String checkTinkerLastUncaughtCrash(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 111	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchLastCrashFile	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_0
    //   6: invokestatic 115	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 117	java/lang/StringBuffer
    //   17: dup
    //   18: invokespecial 118	java/lang/StringBuffer:<init>	()V
    //   21: astore_2
    //   22: new 120	java/io/BufferedReader
    //   25: dup
    //   26: new 122	java/io/InputStreamReader
    //   29: dup
    //   30: new 124	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 128	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +50 -> 103
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: aload_3
    //   60: invokevirtual 137	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   63: pop
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: ldc 139
    //   69: invokevirtual 137	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: goto -28 -> 45
    //   76: astore_2
    //   77: aload_1
    //   78: astore_0
    //   79: ldc 8
    //   81: ldc 141
    //   83: aload_2
    //   84: invokestatic 145	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_1
    //   98: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   101: aconst_null
    //   102: areturn
    //   103: aload_1
    //   104: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   107: aload_2
    //   108: invokevirtual 153	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -7 -> 115
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: goto -51 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramContext	Context
    //   44	60	1	localBufferedReader	java.io.BufferedReader
    //   112	8	1	localObject1	Object
    //   121	1	1	localObject2	Object
    //   127	1	1	localObject3	Object
    //   21	46	2	localStringBuffer	java.lang.StringBuffer
    //   76	32	2	localException1	Exception
    //   125	1	2	localException2	Exception
    //   51	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   47	52	76	java/lang/Exception
    //   58	64	76	java/lang/Exception
    //   66	73	76	java/lang/Exception
    //   22	45	112	finally
    //   47	52	121	finally
    //   58	64	121	finally
    //   66	73	121	finally
    //   79	97	121	finally
    //   22	45	125	java/lang/Exception
  }
  
  public static void closeQuietly(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof Closeable)) {
      try
      {
        ((Closeable)paramObject).close();
      }
      finally
      {
        return;
      }
    }
    if ((Build.VERSION.SDK_INT >= 19) && ((paramObject instanceof AutoCloseable))) {
      try
      {
        ((AutoCloseable)paramObject).close();
      }
      finally
      {
        return;
      }
    }
    if ((paramObject instanceof ZipFile)) {
      try
      {
        ((ZipFile)paramObject).close();
      }
      finally
      {
        return;
      }
    }
    throw new IllegalArgumentException("obj: " + paramObject + " cannot be closed.");
  }
  
  public static void closeZip(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile)
    {
      ShareTinkerLog.w("Tinker.PatchFileUtil", "Failed to close resource", new Object[] { paramZipFile });
    }
  }
  
  /* Error */
  public static void copyFileUsingStream(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 115	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokevirtual 192	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 192	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne -12 -> 11
    //   26: aload_1
    //   27: invokevirtual 196	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +15 -> 47
    //   35: aload_3
    //   36: invokevirtual 200	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_3
    //   43: invokevirtual 203	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: new 124	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_3
    //   56: new 205	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: iconst_0
    //   62: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   65: astore_1
    //   66: sipush 16384
    //   69: newarray byte
    //   71: astore_0
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 212	java/io/FileInputStream:read	([B)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +24 -> 103
    //   82: aload_1
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 216	java/io/FileOutputStream:write	([BII)V
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: aload_3
    //   94: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   97: aload_1
    //   98: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   107: aload_1
    //   108: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   111: return
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_3
    //   117: goto -24 -> 93
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -30 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramFile1	File
    //   0	126	1	paramFile2	File
    //   77	9	2	i	int
    //   30	87	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	72	92	finally
    //   72	78	92	finally
    //   82	89	92	finally
    //   47	56	112	finally
    //   56	66	120	finally
  }
  
  public static final boolean deleteDir(File paramFile)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.isFile()) {
      safeDeleteFile(paramFile);
    }
    for (;;)
    {
      return true;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          while (i < j)
          {
            deleteDir(arrayOfFile[i]);
            i += 1;
          }
          safeDeleteFile(paramFile);
        }
      }
    }
  }
  
  public static final boolean deleteDir(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return deleteDir(new File(paramString));
  }
  
  public static void ensureFileDirectory(File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      return;
      paramFile = paramFile.getParentFile();
    } while (paramFile.exists());
    paramFile.mkdirs();
  }
  
  public static long getFileOrDirectorySize(File paramFile)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramFile != null)
    {
      if (paramFile.exists()) {
        break label22;
      }
      l2 = l1;
    }
    label22:
    int j;
    int i;
    do
    {
      do
      {
        return l2;
        if (paramFile.isFile()) {
          return paramFile.length();
        }
        paramFile = paramFile.listFiles();
        l2 = l1;
      } while (paramFile == null);
      j = paramFile.length;
      i = 0;
      l2 = l1;
    } while (i >= j);
    File localFile = paramFile[i];
    if (localFile.isDirectory()) {}
    for (l1 += getFileOrDirectorySize(localFile);; l1 += localFile.length())
    {
      i += 1;
      break;
    }
  }
  
  /* Error */
  public static String getMD5(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 200	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 124	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokestatic 75	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_1
    //   30: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: ldc 8
    //   42: aload_2
    //   43: invokevirtual 243	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_1
    //   54: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_1
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: goto -7 -> 62
    //   72: astore_2
    //   73: goto -35 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramFile	File
    //   21	33	1	localFileInputStream	java.io.FileInputStream
    //   59	8	1	localObject1	Object
    //   68	1	1	localObject2	Object
    //   28	6	2	str	String
    //   35	8	2	localException1	Exception
    //   72	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   13	22	35	java/lang/Exception
    //   13	22	59	finally
    //   24	29	68	finally
    //   40	53	68	finally
    //   24	29	72	java/lang/Exception
  }
  
  public static final String getMD5(InputStream paramInputStream)
  {
    int i = 0;
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      Object localObject = new BufferedInputStream(paramInputStream);
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      paramInputStream = new StringBuilder(32);
      byte[] arrayOfByte = new byte[102400];
      for (;;)
      {
        int j = ((BufferedInputStream)localObject).read(arrayOfByte);
        if (j == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, j);
      }
      localObject = localMessageDigest.digest();
      while (i < localObject.length)
      {
        paramInputStream.append(Integer.toString((localObject[i] & 0xFF) + 256, 16).substring(1));
        i += 1;
      }
      paramInputStream = paramInputStream.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
  }
  
  public static String getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      int k = paramArrayOfByte.length;
      localObject = new char[k * 2];
      int i = 0;
      int m;
      for (int j = 0; i < k; j = m + 1)
      {
        int n = paramArrayOfByte[i];
        m = j + 1;
        localObject[j] = hexDigits[(n >>> 4 & 0xF)];
        localObject[m] = hexDigits[(n & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static File getPatchDirectory(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    if (localApplicationInfo == null) {
      return null;
    }
    if (("oppo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 22)) {}
    for (paramContext = "wc_tinker_dir";; paramContext = "tinker") {
      return new File(localApplicationInfo.dataDir, paramContext);
    }
  }
  
  public static File getPatchInfoFile(String paramString)
  {
    return new File(paramString + "/patch.info");
  }
  
  public static File getPatchInfoLockFile(String paramString)
  {
    return new File(paramString + "/info.lock");
  }
  
  public static File getPatchLastCrashFile(Context paramContext)
  {
    paramContext = getPatchTempDirectory(paramContext);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, "tinker_last_crash");
  }
  
  public static File getPatchTempDirectory(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.dataDir, "tinker_temp");
  }
  
  public static String getPatchVersionDirectory(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 32)) {
      return null;
    }
    return "patch-" + paramString.substring(0, 8);
  }
  
  public static String getPatchVersionFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 32)) {
      return null;
    }
    return getPatchVersionDirectory(paramString) + ".apk";
  }
  
  public static final boolean isLegalFile(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.canRead()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static boolean isRawDexFile(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.endsWith(".dex");
  }
  
  public static String loadDigestes(JarFile paramJarFile, JarEntry paramJarEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramJarEntry = paramJarFile.getInputStream(paramJarEntry);
      paramJarFile = new byte[16384];
      paramJarEntry = new BufferedInputStream(paramJarEntry);
      try
      {
        for (;;)
        {
          int i = paramJarEntry.read(paramJarFile);
          if (i <= 0) {
            break;
          }
          localStringBuilder.append(new String(paramJarFile, 0, i));
        }
        closeQuietly(paramJarEntry);
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        paramJarEntry = null;
      }
    }
    throw paramJarFile;
    closeQuietly(paramJarEntry);
    return localStringBuilder.toString();
  }
  
  public static String optimizedPathFor(File paramFile1, File paramFile2)
  {
    int i;
    if (ShareTinkerInternals.isAfterAndroidO()) {
      try
      {
        str = ShareTinkerInternals.getCurrentInstructionSet();
        File localFile = paramFile1.getParentFile();
        paramFile2 = paramFile1.getName();
        i = paramFile2.lastIndexOf('.');
        paramFile1 = paramFile2;
        if (i > 0) {
          paramFile1 = paramFile2.substring(0, i);
        }
        return localFile.getAbsolutePath() + "/oat/" + str + "/" + paramFile1 + ".odex";
      }
      catch (Exception paramFile1)
      {
        throw new TinkerRuntimeException("getCurrentInstructionSet fail:", paramFile1);
      }
    }
    String str = paramFile1.getName();
    paramFile1 = str;
    if (!str.endsWith(".dex"))
    {
      i = str.lastIndexOf(".");
      if (i >= 0) {
        break label162;
      }
    }
    for (paramFile1 = str + ".dex";; paramFile1 = paramFile1.toString())
    {
      return new File(paramFile2, paramFile1).getPath();
      label162:
      paramFile1 = new StringBuilder(i + 4);
      paramFile1.append(str, 0, i);
      paramFile1.append(".dex");
    }
  }
  
  public static final boolean safeDeleteFile(File paramFile)
  {
    boolean bool1 = true;
    if (paramFile == null) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (!paramFile.exists());
      ShareTinkerLog.i("Tinker.PatchFileUtil", "safeDeleteFile, try to delete path: " + paramFile.getPath(), new Object[0]);
      bool2 = paramFile.delete();
      bool1 = bool2;
    } while (bool2);
    ShareTinkerLog.e("Tinker.PatchFileUtil", "Failed to delete file, try to delete when exit. path: " + paramFile.getPath(), new Object[0]);
    paramFile.deleteOnExit();
    return bool2;
  }
  
  public static final boolean shouldAcceptEvenIfIllegal(File paramFile)
  {
    boolean bool2 = false;
    int i;
    int j;
    if (("vivo".equalsIgnoreCase(Build.MANUFACTURER)) || ("oppo".equalsIgnoreCase(Build.MANUFACTURER)) || ("meizu".equalsIgnoreCase(Build.MANUFACTURER)))
    {
      i = 1;
      if ((Build.VERSION.SDK_INT < 29) && ((Build.VERSION.SDK_INT < 28) || (Build.VERSION.PREVIEW_SDK_INT == 0)) && (!ShareTinkerInternals.isArkHotRuning())) {
        break label120;
      }
      j = 1;
      label71:
      if ((paramFile.exists()) && (paramFile.length() != 0L)) {
        break label125;
      }
    }
    label120:
    label125:
    for (int k = 1;; k = 0)
    {
      boolean bool1;
      if (i == 0)
      {
        bool1 = bool2;
        if (j == 0) {}
      }
      else
      {
        bool1 = bool2;
        if (k != 0) {
          bool1 = true;
        }
      }
      return bool1;
      i = 0;
      break;
      j = 0;
      break label71;
    }
  }
  
  public static boolean verifyDexFileMd5(File paramFile, String paramString)
  {
    return verifyDexFileMd5(paramFile, "classes.dex", paramString);
  }
  
  /* Error */
  public static boolean verifyDexFileMd5(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnull +11 -> 18
    //   10: aload_2
    //   11: ifnull +7 -> 18
    //   14: aload_1
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: ldc_w 428
    //   23: astore 4
    //   25: aload_0
    //   26: invokevirtual 371	java/io/File:getName	()Ljava/lang/String;
    //   29: invokestatic 430	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isRawDexFile	(Ljava/lang/String;)Z
    //   32: ifeq +14 -> 46
    //   35: aload_0
    //   36: invokestatic 432	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/File;)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_2
    //   41: aload_0
    //   42: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ireturn
    //   46: new 46	java/util/zip/ZipFile
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 49	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   54: astore_3
    //   55: aload_3
    //   56: aload_1
    //   57: invokevirtual 55	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnonnull +38 -> 102
    //   67: ldc 8
    //   69: new 85	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 434
    //   76: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_0
    //   80: invokevirtual 192	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_3
    //   97: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   100: iconst_0
    //   101: ireturn
    //   102: aload 6
    //   104: astore_1
    //   105: aload_3
    //   106: aload 5
    //   108: invokevirtual 71	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   111: astore 5
    //   113: aload 5
    //   115: astore_1
    //   116: aload 5
    //   118: invokestatic 75	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   121: astore 6
    //   123: aload 6
    //   125: astore_1
    //   126: aload 5
    //   128: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   131: aload_1
    //   132: astore_0
    //   133: aload_3
    //   134: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   137: goto -97 -> 40
    //   140: astore 5
    //   142: ldc 8
    //   144: new 85	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 436
    //   151: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload_0
    //   155: invokevirtual 192	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: iconst_1
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload 5
    //   172: aastore
    //   173: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_1
    //   177: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   180: aload 4
    //   182: astore_0
    //   183: goto -50 -> 133
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: ldc 8
    //   191: new 85	java/lang/StringBuilder
    //   194: dup
    //   195: ldc_w 438
    //   198: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   201: aload_0
    //   202: invokevirtual 192	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: iconst_1
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_2
    //   218: aastore
    //   219: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: aload_1
    //   223: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_2
    //   229: aload_1
    //   230: invokestatic 83	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   233: aload_2
    //   234: athrow
    //   235: astore_0
    //   236: aload_1
    //   237: invokestatic 67	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   240: aload_0
    //   241: athrow
    //   242: astore_2
    //   243: aload 5
    //   245: astore_1
    //   246: goto -57 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramFile	File
    //   0	249	1	paramString1	String
    //   0	249	2	paramString2	String
    //   54	134	3	localZipFile	ZipFile
    //   23	158	4	str1	String
    //   1	126	5	localObject1	Object
    //   140	104	5	localObject2	Object
    //   4	120	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   105	113	140	finally
    //   116	123	140	finally
    //   55	62	186	finally
    //   67	96	186	finally
    //   126	131	186	finally
    //   176	180	186	finally
    //   229	235	186	finally
    //   142	176	228	finally
    //   189	222	235	finally
    //   46	55	242	finally
  }
  
  public static boolean verifyFileMd5(File paramFile, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramFile = getMD5(paramFile);
    } while (paramFile == null);
    return paramString.equals(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.SharePatchFileUtil
 * JD-Core Version:    0.7.0.1
 */