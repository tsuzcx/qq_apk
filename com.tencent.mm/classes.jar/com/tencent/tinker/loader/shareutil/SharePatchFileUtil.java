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
  private static char[] bUg = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static String J(InputStream paramInputStream)
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
  
  @SuppressLint({"NewApi"})
  public static void V(Object paramObject)
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
  
  public static String a(JarFile paramJarFile, JarEntry paramJarEntry)
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
        V(paramJarEntry);
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
    V(paramJarEntry);
    return localStringBuilder.toString();
  }
  
  public static void a(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile) {}
  }
  
  public static final boolean an(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.canRead()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static final boolean ao(File paramFile)
  {
    boolean bool2 = false;
    int i;
    int j;
    if (("vivo".equalsIgnoreCase(Build.MANUFACTURER)) || ("oppo".equalsIgnoreCase(Build.MANUFACTURER)))
    {
      i = 1;
      if ((Build.VERSION.SDK_INT < 29) && ((Build.VERSION.SDK_INT < 28) || (Build.VERSION.PREVIEW_SDK_INT == 0))) {
        break label100;
      }
      j = 1;
      label51:
      if ((paramFile.exists()) && (paramFile.length() != 0L)) {
        break label105;
      }
    }
    label100:
    label105:
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
      break label51;
    }
  }
  
  public static long ap(File paramFile)
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
    for (l1 += ap(localFile);; l1 += localFile.length())
    {
      i += 1;
      break;
    }
  }
  
  public static final boolean aq(File paramFile)
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
  
  public static void ar(File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      return;
      paramFile = paramFile.getParentFile();
    } while (paramFile.exists());
    paramFile.mkdirs();
  }
  
  public static File awZ(String paramString)
  {
    return new File(paramString + "/patch.info");
  }
  
  public static File axa(String paramString)
  {
    return new File(paramString + "/info.lock");
  }
  
  public static String axb(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 32)) {
      return null;
    }
    return "patch-" + paramString.substring(0, 8);
  }
  
  public static String axc(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 32)) {
      return null;
    }
    return axb(paramString) + ".apk";
  }
  
  public static boolean axd(String paramString)
  {
    return (paramString != null) && (paramString.length() == 32);
  }
  
  public static boolean axe(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.endsWith(".dex");
  }
  
  /* Error */
  public static boolean b(File paramFile, String paramString1, String paramString2)
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
    //   22: ldc 244
    //   24: astore 6
    //   26: aload_0
    //   27: invokevirtual 247	java/io/File:getName	()Ljava/lang/String;
    //   30: invokestatic 249	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:axe	(Ljava/lang/String;)Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokestatic 253	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:q	(Ljava/io/File;)Ljava/lang/String;
    //   40: astore_0
    //   41: aload_2
    //   42: aload_0
    //   43: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ireturn
    //   47: new 107	java/util/zip/ZipFile
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 259	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   55: astore 4
    //   57: aload 4
    //   59: aload_1
    //   60: invokevirtual 263	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   63: astore 7
    //   65: aload 7
    //   67: ifnonnull +28 -> 95
    //   70: new 49	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 265
    //   77: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_0
    //   81: invokevirtual 268	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   84: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: astore_1
    //   98: aload 4
    //   100: aload 7
    //   102: invokevirtual 271	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   105: astore 5
    //   107: aload 5
    //   109: astore_1
    //   110: aload 5
    //   112: astore_3
    //   113: aload 5
    //   115: invokestatic 273	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:J	(Ljava/io/InputStream;)Ljava/lang/String;
    //   118: astore 7
    //   120: aload 7
    //   122: astore_1
    //   123: aload 5
    //   125: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   128: aload_1
    //   129: astore_0
    //   130: aload 4
    //   132: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   135: goto -94 -> 41
    //   138: astore_3
    //   139: aload_1
    //   140: astore_3
    //   141: new 49	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 275
    //   148: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokevirtual 268	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   163: aload 6
    //   165: astore_0
    //   166: goto -36 -> 130
    //   169: astore_1
    //   170: aload 4
    //   172: astore_1
    //   173: new 49	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 277
    //   180: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_0
    //   184: invokevirtual 268	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   187: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: aload_3
    //   199: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   202: aload_1
    //   203: athrow
    //   204: astore_0
    //   205: aload 4
    //   207: astore_1
    //   208: aload_1
    //   209: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: aconst_null
    //   216: astore_1
    //   217: goto -9 -> 208
    //   220: astore_0
    //   221: goto -13 -> 208
    //   224: astore_1
    //   225: aload 7
    //   227: astore_1
    //   228: goto -55 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramFile	File
    //   0	231	1	paramString1	String
    //   0	231	2	paramString2	String
    //   4	109	3	localObject1	Object
    //   138	1	3	localThrowable	Throwable
    //   140	59	3	str1	String
    //   55	151	4	localZipFile	ZipFile
    //   6	118	5	localInputStream	InputStream
    //   24	140	6	str2	String
    //   1	225	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   98	107	138	java/lang/Throwable
    //   113	120	138	java/lang/Throwable
    //   57	65	169	java/lang/Throwable
    //   70	88	169	java/lang/Throwable
    //   123	128	169	java/lang/Throwable
    //   159	163	169	java/lang/Throwable
    //   198	204	169	java/lang/Throwable
    //   98	107	197	finally
    //   113	120	197	finally
    //   141	159	197	finally
    //   57	65	204	finally
    //   70	88	204	finally
    //   123	128	204	finally
    //   159	163	204	finally
    //   198	204	204	finally
    //   47	57	214	finally
    //   173	191	220	finally
    //   47	57	224	java/lang/Throwable
  }
  
  public static final boolean cO(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return o(new File(paramString));
  }
  
  public static String ct(byte[] paramArrayOfByte)
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
        localObject[j] = bUg[(n >>> 4 & 0xF)];
        localObject[m] = bUg[(n & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static boolean h(File paramFile, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramFile = q(paramFile);
    } while (paramFile == null);
    return paramString.equals(paramFile);
  }
  
  public static boolean i(File paramFile, String paramString)
  {
    return b(paramFile, "classes.dex", paramString);
  }
  
  /* Error */
  public static void j(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 300	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:an	(Ljava/io/File;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokevirtual 268	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 268	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne -12 -> 11
    //   26: aload_1
    //   27: invokevirtual 208	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +15 -> 47
    //   35: aload_3
    //   36: invokevirtual 149	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_3
    //   43: invokevirtual 211	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: new 302	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_3
    //   56: new 305	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: iconst_0
    //   62: invokespecial 308	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   65: astore_1
    //   66: sipush 16384
    //   69: newarray byte
    //   71: astore_0
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 309	java/io/FileInputStream:read	([B)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +24 -> 103
    //   82: aload_1
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 312	java/io/FileOutputStream:write	([BII)V
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: aload_3
    //   94: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   97: aload_1
    //   98: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   107: aload_1
    //   108: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
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
  
  /* Error */
  public static boolean j(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: new 107	java/util/zip/ZipFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 259	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: ldc_w 314
    //   21: invokevirtual 263	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnonnull +9 -> 37
    //   31: aload_0
    //   32: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload 5
    //   39: astore_3
    //   40: aload_0
    //   41: aload 4
    //   43: invokevirtual 271	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   46: astore 4
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: invokestatic 273	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:J	(Ljava/io/InputStream;)Ljava/lang/String;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull +28 -> 88
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: aload_1
    //   69: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: istore_2
    //   73: iload_2
    //   74: ifeq +14 -> 88
    //   77: aload 4
    //   79: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   82: aload_0
    //   83: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   86: iconst_1
    //   87: ireturn
    //   88: aload 4
    //   90: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   93: aload_0
    //   94: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_1
    //   100: aload_3
    //   101: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: astore_3
    //   109: new 49	java/lang/StringBuilder
    //   112: dup
    //   113: ldc_w 316
    //   116: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokevirtual 319	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_0
    //   128: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aload_3
    //   135: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   138: aload_0
    //   139: athrow
    //   140: astore_1
    //   141: aload_0
    //   142: astore_3
    //   143: aload_1
    //   144: astore_0
    //   145: goto -11 -> 134
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: goto -45 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramFile	File
    //   0	155	1	paramString	String
    //   72	2	2	bool	boolean
    //   4	139	3	localObject1	Object
    //   1	149	4	localObject2	Object
    //   6	61	5	str	String
    // Exception table:
    //   from	to	target	type
    //   40	48	99	finally
    //   51	58	99	finally
    //   66	73	99	finally
    //   17	26	106	java/lang/Throwable
    //   77	82	106	java/lang/Throwable
    //   88	93	106	java/lang/Throwable
    //   100	106	106	java/lang/Throwable
    //   8	17	133	finally
    //   109	127	133	finally
    //   17	26	140	finally
    //   77	82	140	finally
    //   88	93	140	finally
    //   100	106	140	finally
    //   8	17	148	java/lang/Throwable
  }
  
  public static File jA(Context paramContext)
  {
    paramContext = jz(paramContext);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, "tinker_last_crash");
  }
  
  /* Error */
  public static String jB(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 333	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:jA	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_0
    //   6: invokestatic 300	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:an	(Ljava/io/File;)Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 335	java/lang/StringBuffer
    //   17: dup
    //   18: invokespecial 336	java/lang/StringBuffer:<init>	()V
    //   21: astore_2
    //   22: new 338	java/io/BufferedReader
    //   25: dup
    //   26: new 340	java/io/InputStreamReader
    //   29: dup
    //   30: new 302	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 341	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: invokespecial 344	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 347	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +48 -> 101
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: aload_3
    //   60: invokevirtual 350	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   63: pop
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: ldc_w 352
    //   70: invokevirtual 350	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: goto -29 -> 45
    //   77: astore_2
    //   78: aload_1
    //   79: astore_0
    //   80: new 49	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 354
    //   87: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_2
    //   91: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_1
    //   102: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   105: aload_2
    //   106: invokevirtual 355	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   109: areturn
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_0
    //   114: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: goto -7 -> 113
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -48 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   44	58	1	localBufferedReader	java.io.BufferedReader
    //   110	8	1	localObject1	Object
    //   119	1	1	localObject2	Object
    //   125	1	1	localObject3	Object
    //   21	46	2	localStringBuffer	java.lang.StringBuffer
    //   77	29	2	localException1	Exception
    //   123	1	2	localException2	Exception
    //   51	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   47	52	77	java/lang/Exception
    //   58	64	77	java/lang/Exception
    //   66	74	77	java/lang/Exception
    //   22	45	110	finally
    //   47	52	119	finally
    //   58	64	119	finally
    //   66	74	119	finally
    //   80	95	119	finally
    //   22	45	123	java/lang/Exception
  }
  
  public static File jy(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.dataDir, "tinker");
  }
  
  public static File jz(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.dataDir, "tinker_temp");
  }
  
  public static String k(File paramFile1, File paramFile2)
  {
    int i;
    if (ShareTinkerInternals.dWG()) {
      try
      {
        str = ShareTinkerInternals.dWH();
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
        break label160;
      }
    }
    for (paramFile1 = str + ".dex";; paramFile1 = paramFile1.toString())
    {
      return new File(paramFile2, paramFile1).getPath();
      label160:
      paramFile1 = new StringBuilder(i + 4);
      paramFile1.append(str, 0, i);
      paramFile1.append(".dex");
    }
  }
  
  public static final boolean o(File paramFile)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.isFile()) {
      aq(paramFile);
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
            o(arrayOfFile[i]);
            i += 1;
          }
          aq(paramFile);
        }
      }
    }
  }
  
  /* Error */
  public static String q(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 149	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 302	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokestatic 273	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:J	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_0
    //   28: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   31: aload_1
    //   32: areturn
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   40: aconst_null
    //   41: areturn
    //   42: astore_0
    //   43: aconst_null
    //   44: astore_1
    //   45: aload_1
    //   46: invokestatic 138	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   49: aload_0
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: astore_2
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: goto -13 -> 45
    //   61: astore_1
    //   62: goto -26 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramFile	File
    //   26	20	1	str	String
    //   51	4	1	localObject1	Object
    //   57	1	1	localObject2	Object
    //   61	1	1	localException	Exception
    //   53	4	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   13	22	33	java/lang/Exception
    //   13	22	42	finally
    //   22	27	51	finally
    //   22	27	61	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.SharePatchFileUtil
 * JD-Core Version:    0.7.0.1
 */