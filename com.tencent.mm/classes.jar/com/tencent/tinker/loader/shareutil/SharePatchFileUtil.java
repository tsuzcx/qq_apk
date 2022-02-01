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
    //   27: ifnonnull +20 -> 47
    //   30: ldc 8
    //   32: ldc 59
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokestatic 65	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aload_0
    //   42: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload 5
    //   49: astore_3
    //   50: aload_0
    //   51: aload 4
    //   53: invokevirtual 73	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   56: astore 4
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +28 -> 98
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: aload_1
    //   79: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: istore_2
    //   83: iload_2
    //   84: ifeq +14 -> 98
    //   87: aload 4
    //   89: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   92: aload_0
    //   93: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   96: iconst_1
    //   97: ireturn
    //   98: aload 4
    //   100: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   103: aload_0
    //   104: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_1
    //   110: aload_3
    //   111: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aload_0
    //   118: astore_3
    //   119: ldc 8
    //   121: new 87	java/lang/StringBuilder
    //   124: dup
    //   125: ldc 89
    //   127: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 96	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 65	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload_0
    //   148: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_0
    //   154: aload_3
    //   155: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   158: aload_0
    //   159: athrow
    //   160: astore_1
    //   161: aload_0
    //   162: astore_3
    //   163: aload_1
    //   164: astore_0
    //   165: goto -11 -> 154
    //   168: astore_1
    //   169: aload 4
    //   171: astore_0
    //   172: goto -55 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramFile	File
    //   0	175	1	paramString	String
    //   82	2	2	bool	boolean
    //   4	159	3	localObject1	Object
    //   1	169	4	localObject2	Object
    //   6	71	5	str	String
    // Exception table:
    //   from	to	target	type
    //   50	58	109	finally
    //   61	68	109	finally
    //   76	83	109	finally
    //   17	25	116	java/lang/Throwable
    //   30	41	116	java/lang/Throwable
    //   87	92	116	java/lang/Throwable
    //   98	103	116	java/lang/Throwable
    //   110	116	116	java/lang/Throwable
    //   8	17	153	finally
    //   119	147	153	finally
    //   17	25	160	finally
    //   30	41	160	finally
    //   87	92	160	finally
    //   98	103	160	finally
    //   110	116	160	finally
    //   8	17	168	java/lang/Throwable
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
    //   98: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   101: aconst_null
    //   102: areturn
    //   103: aload_1
    //   104: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   107: aload_2
    //   108: invokevirtual 153	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
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
    //   13: invokevirtual 196	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 196	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne -12 -> 11
    //   26: aload_1
    //   27: invokevirtual 200	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +15 -> 47
    //   35: aload_3
    //   36: invokevirtual 204	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_3
    //   43: invokevirtual 207	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: new 124	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_3
    //   56: new 209	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: iconst_0
    //   62: invokespecial 212	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   65: astore_1
    //   66: sipush 16384
    //   69: newarray byte
    //   71: astore_0
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 216	java/io/FileInputStream:read	([B)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +24 -> 103
    //   82: aload_1
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 220	java/io/FileOutputStream:write	([BII)V
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: aload_3
    //   94: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   97: aload_1
    //   98: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   107: aload_1
    //   108: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
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
    //   5: invokevirtual 204	java/io/File:exists	()Z
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
    //   25: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_1
    //   30: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: ldc 8
    //   42: aload_2
    //   43: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_1
    //   54: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_1
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
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
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_0
    //   9: ifnull +11 -> 20
    //   12: aload_2
    //   13: ifnull +7 -> 20
    //   16: aload_1
    //   17: ifnonnull +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: ldc_w 432
    //   25: astore 6
    //   27: aload_0
    //   28: invokevirtual 375	java/io/File:getName	()Ljava/lang/String;
    //   31: invokestatic 434	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isRawDexFile	(Ljava/lang/String;)Z
    //   34: ifeq +14 -> 48
    //   37: aload_0
    //   38: invokestatic 436	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/File;)Ljava/lang/String;
    //   41: astore_0
    //   42: aload_2
    //   43: aload_0
    //   44: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ireturn
    //   48: new 48	java/util/zip/ZipFile
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 51	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   56: astore 4
    //   58: aload 4
    //   60: aload_1
    //   61: invokevirtual 57	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   64: astore 8
    //   66: aload 8
    //   68: ifnonnull +39 -> 107
    //   71: ldc 8
    //   73: new 87	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 438
    //   80: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_0
    //   84: invokevirtual 196	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload 4
    //   102: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 7
    //   109: astore_1
    //   110: aload 5
    //   112: astore_3
    //   113: aload 4
    //   115: aload 8
    //   117: invokevirtual 73	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   120: astore 5
    //   122: aload 5
    //   124: astore_1
    //   125: aload 5
    //   127: astore_3
    //   128: aload 5
    //   130: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   133: astore 7
    //   135: aload 7
    //   137: astore_1
    //   138: aload 5
    //   140: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   143: aload_1
    //   144: astore_0
    //   145: aload 4
    //   147: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   150: goto -108 -> 42
    //   153: astore 5
    //   155: aload_1
    //   156: astore_3
    //   157: ldc 8
    //   159: new 87	java/lang/StringBuilder
    //   162: dup
    //   163: ldc_w 440
    //   166: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload_0
    //   170: invokevirtual 196	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   173: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 5
    //   187: aastore
    //   188: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_1
    //   192: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   195: aload 6
    //   197: astore_0
    //   198: goto -53 -> 145
    //   201: astore_2
    //   202: aload 4
    //   204: astore_1
    //   205: ldc 8
    //   207: new 87	java/lang/StringBuilder
    //   210: dup
    //   211: ldc_w 442
    //   214: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: invokevirtual 196	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   221: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload_2
    //   234: aastore
    //   235: invokestatic 152	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: aload_1
    //   239: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_1
    //   245: aload_3
    //   246: invokestatic 85	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   249: aload_1
    //   250: athrow
    //   251: astore_0
    //   252: aload 4
    //   254: astore_1
    //   255: aload_1
    //   256: invokestatic 69	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   259: aload_0
    //   260: athrow
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_1
    //   264: goto -9 -> 255
    //   267: astore_0
    //   268: goto -13 -> 255
    //   271: astore_2
    //   272: aload_3
    //   273: astore_1
    //   274: goto -69 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramFile	File
    //   0	277	1	paramString1	String
    //   0	277	2	paramString2	String
    //   1	272	3	localObject	Object
    //   56	197	4	localZipFile	ZipFile
    //   3	136	5	localInputStream	InputStream
    //   153	33	5	localThrowable	Throwable
    //   25	171	6	str1	String
    //   6	130	7	str2	String
    //   64	52	8	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   113	122	153	java/lang/Throwable
    //   128	135	153	java/lang/Throwable
    //   58	66	201	java/lang/Throwable
    //   71	100	201	java/lang/Throwable
    //   138	143	201	java/lang/Throwable
    //   191	195	201	java/lang/Throwable
    //   245	251	201	java/lang/Throwable
    //   113	122	244	finally
    //   128	135	244	finally
    //   157	191	244	finally
    //   58	66	251	finally
    //   71	100	251	finally
    //   138	143	251	finally
    //   191	195	251	finally
    //   245	251	251	finally
    //   48	58	261	finally
    //   205	238	267	finally
    //   48	58	271	java/lang/Throwable
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