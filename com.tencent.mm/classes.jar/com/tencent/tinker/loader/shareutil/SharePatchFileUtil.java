package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
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
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: new 48	java/util/zip/ZipFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 51	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: ldc 53
    //   20: invokevirtual 57	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   23: astore 4
    //   25: aload 4
    //   27: ifnonnull +9 -> 36
    //   30: aload_0
    //   31: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aload 5
    //   38: astore_3
    //   39: aload_0
    //   40: aload 4
    //   42: invokevirtual 65	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   45: astore 4
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +28 -> 87
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: aload_1
    //   68: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: istore_2
    //   72: iload_2
    //   73: ifeq +14 -> 87
    //   76: aload 4
    //   78: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   81: aload_0
    //   82: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   85: iconst_1
    //   86: ireturn
    //   87: aload 4
    //   89: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   92: aload_0
    //   93: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_1
    //   99: aload_3
    //   100: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: astore_3
    //   108: new 79	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 81
    //   114: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 88	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_0
    //   126: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_3
    //   133: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   136: aload_0
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: astore_3
    //   141: aload_1
    //   142: astore_0
    //   143: goto -11 -> 132
    //   146: astore_1
    //   147: aload 4
    //   149: astore_0
    //   150: goto -44 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramFile	File
    //   0	153	1	paramString	String
    //   71	2	2	bool	boolean
    //   4	137	3	localObject1	Object
    //   1	147	4	localObject2	Object
    //   6	60	5	str	String
    // Exception table:
    //   from	to	target	type
    //   39	47	98	finally
    //   50	57	98	finally
    //   65	72	98	finally
    //   17	25	105	java/lang/Throwable
    //   76	81	105	java/lang/Throwable
    //   87	92	105	java/lang/Throwable
    //   99	105	105	java/lang/Throwable
    //   8	17	131	finally
    //   108	125	131	finally
    //   17	25	138	finally
    //   76	81	138	finally
    //   87	92	138	finally
    //   99	105	138	finally
    //   8	17	146	java/lang/Throwable
  }
  
  /* Error */
  public static String checkTinkerLastUncaughtCrash(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 100	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchLastCrashFile	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_0
    //   6: invokestatic 104	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 106	java/lang/StringBuffer
    //   17: dup
    //   18: invokespecial 107	java/lang/StringBuffer:<init>	()V
    //   21: astore_2
    //   22: new 109	java/io/BufferedReader
    //   25: dup
    //   26: new 111	java/io/InputStreamReader
    //   29: dup
    //   30: new 113	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 117	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: invokespecial 120	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 123	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +46 -> 99
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: aload_3
    //   60: invokevirtual 126	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   63: pop
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: ldc 128
    //   69: invokevirtual 126	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: goto -28 -> 45
    //   76: astore_2
    //   77: aload_1
    //   78: astore_0
    //   79: new 79	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 130
    //   85: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: areturn
    //   99: aload_1
    //   100: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   103: aload_2
    //   104: invokevirtual 136	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: goto -7 -> 111
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_1
    //   124: goto -47 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramContext	Context
    //   44	56	1	localBufferedReader	java.io.BufferedReader
    //   108	8	1	localObject1	Object
    //   117	1	1	localObject2	Object
    //   123	1	1	localObject3	Object
    //   21	46	2	localStringBuffer	java.lang.StringBuffer
    //   76	28	2	localException1	Exception
    //   121	1	2	localException2	Exception
    //   51	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   47	52	76	java/lang/Exception
    //   58	64	76	java/lang/Exception
    //   66	73	76	java/lang/Exception
    //   22	45	108	finally
    //   47	52	117	finally
    //   58	64	117	finally
    //   66	73	117	finally
    //   79	93	117	finally
    //   22	45	121	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public static void closeQuietly(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof Closeable)) {
      try
      {
        ((Closeable)paramObject).close();
        return;
      }
      catch (Throwable paramObject)
      {
        return;
      }
    }
    if ((Build.VERSION.SDK_INT >= 19) && ((paramObject instanceof AutoCloseable))) {
      try
      {
        ((AutoCloseable)paramObject).close();
        return;
      }
      catch (Throwable paramObject)
      {
        return;
      }
    }
    if ((paramObject instanceof ZipFile)) {
      try
      {
        ((ZipFile)paramObject).close();
        return;
      }
      catch (Throwable paramObject)
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
    catch (IOException paramZipFile) {}
  }
  
  /* Error */
  public static void copyFileUsingStream(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 104	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne -12 -> 11
    //   26: aload_1
    //   27: invokevirtual 176	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +15 -> 47
    //   35: aload_3
    //   36: invokevirtual 180	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_3
    //   43: invokevirtual 183	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: new 113	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_3
    //   56: new 185	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: iconst_0
    //   62: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   65: astore_1
    //   66: sipush 16384
    //   69: newarray byte
    //   71: astore_0
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 192	java/io/FileInputStream:read	([B)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +24 -> 103
    //   82: aload_1
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 196	java/io/FileOutputStream:write	([BII)V
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: aload_3
    //   94: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   97: aload_1
    //   98: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   107: aload_1
    //   108: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
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
    //   5: invokevirtual 180	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 113	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_1
    //   30: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: aload_2
    //   41: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   44: pop
    //   45: aload_1
    //   46: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: goto -7 -> 54
    //   64: astore_2
    //   65: goto -27 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramFile	File
    //   21	25	1	localFileInputStream	java.io.FileInputStream
    //   51	8	1	localObject1	Object
    //   60	1	1	localObject2	Object
    //   28	6	2	str	String
    //   35	6	2	localException1	Exception
    //   64	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   13	22	35	java/lang/Exception
    //   13	22	51	finally
    //   24	29	60	finally
    //   40	45	60	finally
    //   24	29	64	java/lang/Exception
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
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.dataDir, "tinker");
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
      new StringBuilder("safeDeleteFile, try to delete path: ").append(paramFile.getPath());
      bool2 = paramFile.delete();
      bool1 = bool2;
    } while (bool2);
    new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(paramFile.getPath());
    paramFile.deleteOnExit();
    return bool2;
  }
  
  public static final boolean shouldAcceptEvenIfIllegal(File paramFile)
  {
    boolean bool2 = false;
    int i;
    int j;
    if (("vivo".equalsIgnoreCase(Build.MANUFACTURER)) || ("oppo".equalsIgnoreCase(Build.MANUFACTURER)))
    {
      i = 1;
      if ((Build.VERSION.SDK_INT < 29) && ((Build.VERSION.SDK_INT < 28) || (Build.VERSION.PREVIEW_SDK_INT == 0)) && (!ShareTinkerInternals.isArkHotRuning())) {
        break label108;
      }
      j = 1;
      label59:
      if ((paramFile.exists()) && (paramFile.length() != 0L)) {
        break label113;
      }
    }
    label108:
    label113:
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
      break label59;
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
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: ifnull +11 -> 20
    //   12: aload_2
    //   13: ifnull +7 -> 20
    //   16: aload_1
    //   17: ifnonnull +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: ldc_w 405
    //   25: astore 6
    //   27: aload_0
    //   28: invokevirtual 340	java/io/File:getName	()Ljava/lang/String;
    //   31: invokestatic 407	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isRawDexFile	(Ljava/lang/String;)Z
    //   34: ifeq +14 -> 48
    //   37: aload_0
    //   38: invokestatic 409	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/File;)Ljava/lang/String;
    //   41: astore_0
    //   42: aload_2
    //   43: aload_0
    //   44: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ireturn
    //   48: new 48	java/util/zip/ZipFile
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 51	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   56: astore 4
    //   58: aload 4
    //   60: aload_1
    //   61: invokevirtual 57	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   64: astore 7
    //   66: aload 7
    //   68: ifnonnull +28 -> 96
    //   71: new 79	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 411
    //   78: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   85: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 4
    //   91: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 5
    //   98: astore_1
    //   99: aload 4
    //   101: aload 7
    //   103: invokevirtual 65	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   106: astore 5
    //   108: aload 5
    //   110: astore_1
    //   111: aload 5
    //   113: astore_3
    //   114: aload 5
    //   116: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   119: astore 7
    //   121: aload 7
    //   123: astore_1
    //   124: aload 5
    //   126: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   129: aload_1
    //   130: astore_0
    //   131: aload 4
    //   133: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   136: goto -94 -> 42
    //   139: astore_3
    //   140: aload_1
    //   141: astore_3
    //   142: new 79	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 413
    //   149: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_1
    //   161: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   164: aload 6
    //   166: astore_0
    //   167: goto -36 -> 131
    //   170: astore_1
    //   171: aload 4
    //   173: astore_1
    //   174: new 79	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 415
    //   181: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual 172	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_1
    //   193: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_1
    //   199: aload_3
    //   200: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   203: aload_1
    //   204: athrow
    //   205: astore_0
    //   206: aload 4
    //   208: astore_1
    //   209: aload_1
    //   210: invokestatic 61	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   213: aload_0
    //   214: athrow
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_1
    //   218: goto -9 -> 209
    //   221: astore_0
    //   222: goto -13 -> 209
    //   225: astore_1
    //   226: aload 7
    //   228: astore_1
    //   229: goto -55 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramFile	File
    //   0	232	1	paramString1	String
    //   0	232	2	paramString2	String
    //   4	110	3	localObject1	Object
    //   139	1	3	localThrowable	Throwable
    //   141	59	3	str1	String
    //   56	151	4	localZipFile	ZipFile
    //   6	119	5	localInputStream	InputStream
    //   25	140	6	str2	String
    //   1	226	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   99	108	139	java/lang/Throwable
    //   114	121	139	java/lang/Throwable
    //   58	66	170	java/lang/Throwable
    //   71	89	170	java/lang/Throwable
    //   124	129	170	java/lang/Throwable
    //   160	164	170	java/lang/Throwable
    //   199	205	170	java/lang/Throwable
    //   99	108	198	finally
    //   114	121	198	finally
    //   142	160	198	finally
    //   58	66	205	finally
    //   71	89	205	finally
    //   124	129	205	finally
    //   160	164	205	finally
    //   199	205	205	finally
    //   48	58	215	finally
    //   174	192	221	finally
    //   48	58	225	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.SharePatchFileUtil
 * JD-Core Version:    0.7.0.1
 */