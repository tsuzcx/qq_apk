package com.tencent.tinker.loader.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
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

public final class f
{
  private static char[] amg = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static File M(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.dataDir, "tinker");
  }
  
  public static File N(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext.dataDir, "tinker_temp");
  }
  
  public static File O(Context paramContext)
  {
    paramContext = N(paramContext);
    if (paramContext == null) {
      return null;
    }
    return new File(paramContext, "tinker_last_crash");
  }
  
  @SuppressLint({"NewApi"})
  public static void R(Object paramObject)
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
        R(paramJarEntry);
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
    R(paramJarEntry);
    return localStringBuilder.toString();
  }
  
  private static void a(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile)
    {
      Log.w("Tinker.PatchFileUtil", "Failed to close resource", paramZipFile);
    }
  }
  
  public static boolean a(File paramFile, String paramString)
  {
    return a(paramFile, "classes.dex", paramString);
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString1, String paramString2)
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
    //   22: ldc 157
    //   24: astore 6
    //   26: aload_0
    //   27: invokevirtual 160	java/io/File:getName	()Ljava/lang/String;
    //   30: invokestatic 164	com/tencent/tinker/loader/a/f:ai	(Ljava/lang/String;)Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokestatic 168	com/tencent/tinker/loader/a/f:n	(Ljava/io/File;)Ljava/lang/String;
    //   40: astore_0
    //   41: aload_2
    //   42: aload_0
    //   43: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ireturn
    //   47: new 83	java/util/zip/ZipFile
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 175	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   55: astore 4
    //   57: aload 4
    //   59: aload_1
    //   60: invokevirtual 179	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   63: astore 8
    //   65: aload 8
    //   67: ifnonnull +35 -> 102
    //   70: ldc 141
    //   72: new 88	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 181
    //   78: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   85: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 188	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload 4
    //   97: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   100: iconst_0
    //   101: ireturn
    //   102: aload 7
    //   104: astore_1
    //   105: aload 5
    //   107: astore_3
    //   108: aload 4
    //   110: aload 8
    //   112: invokevirtual 191	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   115: astore 5
    //   117: aload 5
    //   119: astore_1
    //   120: aload 5
    //   122: astore_3
    //   123: aload 5
    //   125: invokestatic 194	com/tencent/tinker/loader/a/f:e	(Ljava/io/InputStream;)Ljava/lang/String;
    //   128: astore 7
    //   130: aload 7
    //   132: astore_1
    //   133: aload 5
    //   135: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   138: aload_1
    //   139: astore_0
    //   140: aload 4
    //   142: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   145: goto -104 -> 41
    //   148: astore 5
    //   150: aload_1
    //   151: astore_3
    //   152: ldc 141
    //   154: new 88	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 196
    //   160: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   167: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: aload 5
    //   175: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   178: pop
    //   179: aload_1
    //   180: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   183: aload 6
    //   185: astore_0
    //   186: goto -46 -> 140
    //   189: astore_2
    //   190: aload 4
    //   192: astore_1
    //   193: ldc 141
    //   195: new 88	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 200
    //   201: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload_0
    //   205: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   208: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: aload_2
    //   215: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   218: pop
    //   219: aload_1
    //   220: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_1
    //   226: aload_3
    //   227: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   230: aload_1
    //   231: athrow
    //   232: astore_0
    //   233: aload 4
    //   235: astore_1
    //   236: aload_1
    //   237: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_1
    //   245: goto -9 -> 236
    //   248: astore_0
    //   249: goto -13 -> 236
    //   252: astore_2
    //   253: aload_3
    //   254: astore_1
    //   255: goto -62 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramFile	File
    //   0	258	1	paramString1	String
    //   0	258	2	paramString2	String
    //   1	253	3	localObject	Object
    //   55	179	4	localZipFile	ZipFile
    //   3	131	5	localInputStream	InputStream
    //   148	26	5	localThrowable	Throwable
    //   24	160	6	str1	String
    //   6	125	7	str2	String
    //   63	48	8	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   108	117	148	java/lang/Throwable
    //   123	130	148	java/lang/Throwable
    //   57	65	189	java/lang/Throwable
    //   70	95	189	java/lang/Throwable
    //   133	138	189	java/lang/Throwable
    //   179	183	189	java/lang/Throwable
    //   226	232	189	java/lang/Throwable
    //   108	117	225	finally
    //   123	130	225	finally
    //   152	179	225	finally
    //   57	65	232	finally
    //   70	95	232	finally
    //   133	138	232	finally
    //   179	183	232	finally
    //   226	232	232	finally
    //   47	57	242	finally
    //   193	219	248	finally
    //   47	57	252	java/lang/Throwable
  }
  
  public static File ac(String paramString)
  {
    return new File(paramString + "/patch.info");
  }
  
  public static File ad(String paramString)
  {
    return new File(paramString + "/info.lock");
  }
  
  public static String ae(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 32)) {
      return null;
    }
    return "patch-" + paramString.substring(0, 8);
  }
  
  public static String af(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 32)) {
      return null;
    }
    return ae(paramString) + ".apk";
  }
  
  public static boolean ag(String paramString)
  {
    return (paramString != null) && (paramString.length() == 32);
  }
  
  public static final boolean ah(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return m(new File(paramString));
  }
  
  public static boolean ai(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.endsWith(".dex");
  }
  
  /* Error */
  public static void b(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 241	com/tencent/tinker/loader/a/f:j	(Ljava/io/File;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne -12 -> 11
    //   26: aload_1
    //   27: invokevirtual 245	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +15 -> 47
    //   35: aload_3
    //   36: invokevirtual 249	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_3
    //   43: invokevirtual 252	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: new 254	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 255	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_3
    //   56: new 257	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: iconst_0
    //   62: invokespecial 260	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   65: astore_1
    //   66: sipush 16384
    //   69: newarray byte
    //   71: astore_0
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 261	java/io/FileInputStream:read	([B)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +24 -> 103
    //   82: aload_1
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 264	java/io/FileOutputStream:write	([BII)V
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: aload_3
    //   94: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   97: aload_1
    //   98: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   107: aload_1
    //   108: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
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
  public static boolean b(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: new 83	java/util/zip/ZipFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 175	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: ldc_w 266
    //   21: invokevirtual 179	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnonnull +18 -> 46
    //   31: ldc 141
    //   33: ldc_w 268
    //   36: invokestatic 271	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   39: pop
    //   40: aload_0
    //   41: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload 5
    //   48: astore_3
    //   49: aload_0
    //   50: aload 4
    //   52: invokevirtual 191	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   55: astore 4
    //   57: aload 4
    //   59: astore_3
    //   60: aload 4
    //   62: invokestatic 194	com/tencent/tinker/loader/a/f:e	(Ljava/io/InputStream;)Ljava/lang/String;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +28 -> 97
    //   72: aload 4
    //   74: astore_3
    //   75: aload 5
    //   77: aload_1
    //   78: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: istore_2
    //   82: iload_2
    //   83: ifeq +14 -> 97
    //   86: aload 4
    //   88: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   91: aload_0
    //   92: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload 4
    //   99: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   102: aload_0
    //   103: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aload_3
    //   110: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: astore_3
    //   118: ldc 141
    //   120: new 88	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 273
    //   127: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 276	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 271	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: aload_0
    //   145: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload_3
    //   152: invokestatic 190	com/tencent/tinker/loader/a/f:a	(Ljava/util/zip/ZipFile;)V
    //   155: aload_0
    //   156: athrow
    //   157: astore_1
    //   158: aload_0
    //   159: astore_3
    //   160: aload_1
    //   161: astore_0
    //   162: goto -11 -> 151
    //   165: astore_1
    //   166: aload 4
    //   168: astore_0
    //   169: goto -53 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramFile	File
    //   0	172	1	paramString	String
    //   81	2	2	bool	boolean
    //   4	156	3	localObject1	Object
    //   1	166	4	localObject2	Object
    //   6	70	5	str	String
    // Exception table:
    //   from	to	target	type
    //   49	57	108	finally
    //   60	67	108	finally
    //   75	82	108	finally
    //   17	26	115	java/lang/Throwable
    //   31	40	115	java/lang/Throwable
    //   86	91	115	java/lang/Throwable
    //   97	102	115	java/lang/Throwable
    //   109	115	115	java/lang/Throwable
    //   8	17	150	finally
    //   118	144	150	finally
    //   17	26	157	finally
    //   31	40	157	finally
    //   86	91	157	finally
    //   97	102	157	finally
    //   109	115	157	finally
    //   8	17	165	java/lang/Throwable
  }
  
  public static String c(File paramFile1, File paramFile2)
  {
    int i;
    if (k.oo()) {
      try
      {
        str = k.op();
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
  
  private static String e(InputStream paramInputStream)
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
  
  public static final boolean j(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.canRead()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static final boolean k(File paramFile)
  {
    return (("vivo".equalsIgnoreCase(Build.MANUFACTURER)) || ("oppo".equalsIgnoreCase(Build.MANUFACTURER))) && ((!paramFile.exists()) || (paramFile.length() == 0L));
  }
  
  public static final boolean l(File paramFile)
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
      Log.i("Tinker.PatchFileUtil", "safeDeleteFile, try to delete path: " + paramFile.getPath());
      bool2 = paramFile.delete();
      bool1 = bool2;
    } while (bool2);
    Log.e("Tinker.PatchFileUtil", "Failed to delete file, try to delete when exit. path: " + paramFile.getPath());
    paramFile.deleteOnExit();
    return bool2;
  }
  
  private static boolean m(File paramFile)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.isFile()) {
      l(paramFile);
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
            m(arrayOfFile[i]);
            i += 1;
          }
          l(paramFile);
        }
      }
    }
  }
  
  /* Error */
  public static String n(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 249	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 254	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 255	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokestatic 194	com/tencent/tinker/loader/a/f:e	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_0
    //   28: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   31: aload_1
    //   32: areturn
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   40: aconst_null
    //   41: areturn
    //   42: astore_0
    //   43: aconst_null
    //   44: astore_1
    //   45: aload_1
    //   46: invokestatic 136	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
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
  
  public static String p(byte[] paramArrayOfByte)
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
        localObject[j] = amg[(n >>> 4 & 0xF)];
        localObject[m] = amg[(n & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.f
 * JD-Core Version:    0.7.0.1
 */