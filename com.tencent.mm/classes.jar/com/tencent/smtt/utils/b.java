package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  
  private static PackageInfo a(String paramString, int paramInt)
  {
    AppMethodBeat.i(53973);
    for (;;)
    {
      try
      {
        Object localObject2 = Class.forName("android.content.pm.PackageParser");
        Object localObject1 = ((Class)localObject2).getDeclaredClasses();
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          localMethod1 = localObject1[i];
          if (localMethod1.getName().compareTo("android.content.pm.PackageParser$Package") == 0)
          {
            Object localObject3 = ((Class)localObject2).getConstructor(new Class[] { String.class });
            Method localMethod2 = ((Class)localObject2).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
            localObject1 = ((Class)localObject2).getDeclaredMethod("collectCertificates", new Class[] { localMethod1, Integer.TYPE });
            localMethod1 = ((Class)localObject2).getDeclaredMethod("generatePackageInfo", new Class[] { localMethod1, [I.class, Integer.TYPE, Long.TYPE, Long.TYPE });
            ((Constructor)localObject3).setAccessible(true);
            localMethod2.setAccessible(true);
            ((Method)localObject1).setAccessible(true);
            localMethod1.setAccessible(true);
            localObject2 = ((Constructor)localObject3).newInstance(new Object[] { paramString });
            localObject3 = new DisplayMetrics();
            ((DisplayMetrics)localObject3).setToDefaults();
            paramString = localMethod2.invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
            if (paramString == null)
            {
              AppMethodBeat.o(53973);
              return null;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          if ((paramInt & 0x40) != 0) {
            ((Method)localObject1).invoke(localObject2, new Object[] { paramString, Integer.valueOf(0) });
          }
          paramString = (PackageInfo)localMethod1.invoke(null, new Object[] { paramString, null, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0) });
          AppMethodBeat.o(53973);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(53973);
        return null;
      }
      Method localMethod1 = null;
    }
  }
  
  public static String a()
  {
    AppMethodBeat.i(53966);
    try
    {
      String str1 = new String(Build.MODEL.getBytes("UTF-8"), "ISO8859-1");
      AppMethodBeat.o(53966);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = Build.MODEL;
      AppMethodBeat.o(53966);
      return str2;
    }
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(53959);
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageName();
      AppMethodBeat.o(53959);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static String a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    localObject2 = null;
    AppMethodBeat.i(53971);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramContext = a(paramFile.getAbsolutePath(), 65);
        if (paramContext == null) {
          continue;
        }
        if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0)) {
          continue;
        }
        paramContext = paramContext.signatures[0];
        localObject1 = localObject2;
        if (paramContext != null) {
          localObject1 = paramContext.toCharsString();
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.i("AppUtil", "getSign " + paramFile + "failed");
        Object localObject1 = localObject2;
        continue;
      }
      AppMethodBeat.o(53971);
      return localObject1;
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      continue;
      TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
      paramContext = null;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53961);
    localObject = null;
    try
    {
      String str = paramContext.getPackageName();
      paramContext = String.valueOf(paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.get(paramString));
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label47:
        paramContext = localObject;
      }
    }
    try
    {
      paramString = String.valueOf(Integer.toHexString(Integer.parseInt(paramContext)));
      paramContext = paramString;
    }
    catch (Exception paramString)
    {
      break label47;
    }
    AppMethodBeat.o(53961);
    return paramContext;
  }
  
  /* Error */
  public static String a(Context paramContext, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: ldc 235
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnull +10 -> 16
    //   9: aload_2
    //   10: invokevirtual 239	java/io/File:exists	()Z
    //   13: ifne +11 -> 24
    //   16: ldc 235
    //   18: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 14
    //   23: areturn
    //   24: iload_1
    //   25: ifeq +62 -> 87
    //   28: aconst_null
    //   29: astore 4
    //   31: iconst_2
    //   32: newarray byte
    //   34: astore 5
    //   36: new 241	java/io/RandomAccessFile
    //   39: dup
    //   40: aload_2
    //   41: ldc 243
    //   43: invokespecial 246	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore_3
    //   47: aload_3
    //   48: aload 5
    //   50: invokevirtual 250	java/io/RandomAccessFile:read	([B)I
    //   53: pop
    //   54: new 55	java/lang/String
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 253	java/lang/String:<init>	([B)V
    //   63: ldc 255
    //   65: invokevirtual 259	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   68: ifne +15 -> 83
    //   71: aload_3
    //   72: invokevirtual 262	java/io/RandomAccessFile:close	()V
    //   75: ldc 235
    //   77: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 14
    //   82: areturn
    //   83: aload_3
    //   84: invokevirtual 262	java/io/RandomAccessFile:close	()V
    //   87: aload_0
    //   88: invokevirtual 266	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   91: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   94: ldc_w 268
    //   97: invokevirtual 272	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifeq +73 -> 173
    //   103: ldc 174
    //   105: ldc_w 274
    //   108: invokestatic 201	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_2
    //   112: invokestatic 277	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull +56 -> 173
    //   120: ldc 174
    //   122: ldc_w 279
    //   125: invokestatic 201	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: ldc 235
    //   130: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_3
    //   134: areturn
    //   135: astore_3
    //   136: aload 4
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 262	java/io/RandomAccessFile:close	()V
    //   143: goto -56 -> 87
    //   146: astore_3
    //   147: goto -60 -> 87
    //   150: astore_0
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 262	java/io/RandomAccessFile:close	()V
    //   157: ldc 235
    //   159: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_0
    //   163: athrow
    //   164: astore_3
    //   165: ldc 174
    //   167: ldc_w 281
    //   170: invokestatic 201	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: ldc 174
    //   175: ldc_w 283
    //   178: invokestatic 201	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_0
    //   182: aload_2
    //   183: iconst_0
    //   184: invokestatic 285	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   187: astore 4
    //   189: ldc 174
    //   191: ldc_w 287
    //   194: aload 4
    //   196: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokevirtual 291	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 201	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload 4
    //   207: astore_3
    //   208: aload 4
    //   210: ifnonnull +23 -> 233
    //   213: aload_2
    //   214: invokestatic 277	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   217: astore_3
    //   218: ldc 174
    //   220: ldc_w 293
    //   223: aload_3
    //   224: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   227: invokevirtual 291	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   230: invokestatic 201	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_3
    //   234: astore 4
    //   236: aload_3
    //   237: ifnonnull +27 -> 264
    //   240: aload_0
    //   241: aload_2
    //   242: iconst_1
    //   243: invokestatic 285	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   246: astore 4
    //   248: ldc 174
    //   250: ldc_w 295
    //   253: aload 4
    //   255: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   258: invokevirtual 291	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   261: invokestatic 201	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc 235
    //   266: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload 4
    //   271: areturn
    //   272: astore_0
    //   273: goto -198 -> 75
    //   276: astore_3
    //   277: goto -190 -> 87
    //   280: astore_2
    //   281: goto -124 -> 157
    //   284: astore_0
    //   285: aload_3
    //   286: astore_2
    //   287: goto -134 -> 153
    //   290: astore 4
    //   292: goto -153 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramContext	Context
    //   0	295	1	paramBoolean	boolean
    //   0	295	2	paramFile	File
    //   46	88	3	localObject1	Object
    //   135	1	3	localException1	Exception
    //   138	2	3	localObject2	Object
    //   146	1	3	localIOException1	java.io.IOException
    //   164	1	3	localThrowable	Throwable
    //   207	30	3	localObject3	Object
    //   276	10	3	localIOException2	java.io.IOException
    //   29	241	4	localObject4	Object
    //   290	1	4	localException2	Exception
    //   34	25	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   31	47	135	java/lang/Exception
    //   139	143	146	java/io/IOException
    //   31	47	150	finally
    //   87	116	164	java/lang/Throwable
    //   120	128	164	java/lang/Throwable
    //   71	75	272	java/io/IOException
    //   83	87	276	java/io/IOException
    //   153	157	280	java/io/IOException
    //   47	71	284	finally
    //   47	71	290	java/lang/Exception
  }
  
  private static String a(File paramFile)
  {
    AppMethodBeat.i(53972);
    TbsLog.d("AppUtil", "[getSignatureFromApk]## file=".concat(String.valueOf(paramFile)));
    for (;;)
    {
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
        byte[] arrayOfByte = new byte[8192];
        str1 = a(a(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
        Enumeration localEnumeration = localJarFile.entries();
        if (!localEnumeration.hasMoreElements()) {
          continue;
        }
        paramFile = (JarEntry)localEnumeration.nextElement();
        String str2 = paramFile.getName();
        if (str2 == null) {
          continue;
        }
        TbsLog.d("AppUtil", "[getSignatureFromApk]## loadCertificates & check:".concat(String.valueOf(str2)));
        paramFile = a(localJarFile, paramFile, arrayOfByte);
        if (paramFile == null) {
          continue;
        }
        paramFile = a(paramFile[0].getEncoded());
        if (paramFile != null) {
          continue;
        }
        TbsLog.d("AppUtil", "[getSignatureFromApk]## loadCertificates failed!");
        bool = str2.startsWith("META-INF/");
        if (bool) {
          continue;
        }
        paramFile = null;
      }
      catch (Exception paramFile)
      {
        String str1;
        boolean bool;
        paramFile = null;
        continue;
      }
      AppMethodBeat.o(53972);
      return paramFile;
      TbsLog.d("AppUtil", "[getSignatureFromApk]## certs2 is null!");
      paramFile = null;
      continue;
      bool = paramFile.equals(str1);
      TbsLog.d("AppUtil", "[getSignatureFromApk]## loadCertificates check:".concat(String.valueOf(bool)));
      if (!bool)
      {
        paramFile = null;
        continue;
        paramFile = str1;
      }
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53975);
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label50:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label103;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label50;
        label103:
        j += 48;
      }
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(53975);
    return paramArrayOfByte;
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53974);
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null)
    {
      paramJarFile = paramJarEntry.getCertificates();
      AppMethodBeat.o(53974);
      return paramJarFile;
    }
    AppMethodBeat.o(53974);
    return null;
  }
  
  public static int b(Context paramContext)
  {
    AppMethodBeat.i(53960);
    int i = Build.VERSION.SDK_INT;
    AppMethodBeat.o(53960);
    return i;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: ldc_w 387
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   9: invokestatic 392	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +15 -> 27
    //   15: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   18: astore_0
    //   19: ldc_w 387
    //   22: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: areturn
    //   27: new 394	java/io/InputStreamReader
    //   30: dup
    //   31: invokestatic 400	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   34: ldc_w 402
    //   37: invokevirtual 406	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   40: invokevirtual 411	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: invokespecial 414	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: astore_1
    //   47: new 416	java/io/BufferedReader
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 419	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   55: astore 4
    //   57: aload 4
    //   59: astore_3
    //   60: aload_1
    //   61: astore_2
    //   62: aload 4
    //   64: invokevirtual 422	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: ldc_w 424
    //   70: invokevirtual 272	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifeq +32 -> 105
    //   76: aload 4
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: ldc_w 426
    //   84: invokestatic 428	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload 4
    //   90: invokevirtual 429	java/io/BufferedReader:close	()V
    //   93: aload_1
    //   94: invokevirtual 430	java/io/InputStreamReader:close	()V
    //   97: ldc_w 387
    //   100: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: areturn
    //   105: aload 4
    //   107: astore_3
    //   108: aload_1
    //   109: astore_2
    //   110: ldc_w 432
    //   113: invokestatic 437	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 428	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_0
    //   120: goto -32 -> 88
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_0
    //   129: astore_3
    //   130: aload_1
    //   131: astore_2
    //   132: ldc_w 432
    //   135: invokestatic 437	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokestatic 428	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 4
    //   143: aload 4
    //   145: astore_2
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 429	java/io/BufferedReader:close	()V
    //   154: aload_2
    //   155: astore_0
    //   156: aload_1
    //   157: ifnull -60 -> 97
    //   160: aload_1
    //   161: invokevirtual 430	java/io/InputStreamReader:close	()V
    //   164: aload_2
    //   165: astore_0
    //   166: goto -69 -> 97
    //   169: astore_0
    //   170: aload_2
    //   171: astore_0
    //   172: goto -75 -> 97
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 429	java/io/BufferedReader:close	()V
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 430	java/io/InputStreamReader:close	()V
    //   196: ldc_w 387
    //   199: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_0
    //   203: athrow
    //   204: astore_2
    //   205: goto -112 -> 93
    //   208: astore_1
    //   209: goto -112 -> 97
    //   212: astore_0
    //   213: goto -59 -> 154
    //   216: astore_2
    //   217: goto -29 -> 188
    //   220: astore_1
    //   221: goto -25 -> 196
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_2
    //   227: goto -47 -> 180
    //   230: astore_0
    //   231: aload_2
    //   232: astore_1
    //   233: aload_3
    //   234: astore_2
    //   235: goto -55 -> 180
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_0
    //   241: goto -113 -> 128
    //   244: astore_0
    //   245: aload 4
    //   247: astore_0
    //   248: goto -120 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	102	0	str	String
    //   123	1	0	localThrowable1	Throwable
    //   125	41	0	localObject1	Object
    //   169	1	0	localIOException1	java.io.IOException
    //   171	1	0	localObject2	Object
    //   175	28	0	localObject3	Object
    //   212	1	0	localIOException2	java.io.IOException
    //   224	1	0	localObject4	Object
    //   230	1	0	localObject5	Object
    //   238	1	0	localThrowable2	Throwable
    //   240	1	0	localObject6	Object
    //   244	1	0	localThrowable3	Throwable
    //   247	1	0	localObject7	Object
    //   46	147	1	localInputStreamReader	java.io.InputStreamReader
    //   208	1	1	localIOException3	java.io.IOException
    //   220	1	1	localIOException4	java.io.IOException
    //   232	1	1	localObject8	Object
    //   61	124	2	localObject9	Object
    //   204	1	2	localIOException5	java.io.IOException
    //   216	1	2	localIOException6	java.io.IOException
    //   226	9	2	localObject10	Object
    //   59	175	3	localObject11	Object
    //   55	191	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   27	47	123	java/lang/Throwable
    //   160	164	169	java/io/IOException
    //   27	47	175	finally
    //   88	93	204	java/io/IOException
    //   93	97	208	java/io/IOException
    //   150	154	212	java/io/IOException
    //   184	188	216	java/io/IOException
    //   192	196	220	java/io/IOException
    //   47	57	224	finally
    //   62	76	230	finally
    //   81	88	230	finally
    //   110	120	230	finally
    //   132	143	230	finally
    //   47	57	238	java/lang/Throwable
    //   62	76	244	java/lang/Throwable
    //   81	88	244	java/lang/Throwable
    //   110	120	244	java/lang/Throwable
  }
  
  public static void b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53962);
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext);
      paramContext.mSyncMap.put("tbs_guid", paramString);
      paramContext.commit();
      AppMethodBeat.o(53962);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(53962);
    }
  }
  
  public static String c()
  {
    AppMethodBeat.i(188550);
    try
    {
      if (!QbSdk.isEnableSensitiveApi())
      {
        TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
        AppMethodBeat.o(188550);
        return "";
      }
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if (localObject1 == null)
          {
            AppMethodBeat.o(188550);
            return "";
          }
          localObject2 = new StringBuilder();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject1 = ((StringBuilder)localObject2).toString();
          AppMethodBeat.o(188550);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(188550);
    }
    return "02:00:00:00:00:00";
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(53963);
    Object localObject = null;
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      AppMethodBeat.o(53963);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static int d(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(188548);
    try
    {
      String str = paramContext.getPackageName();
      int j = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      i = j;
    }
    catch (Exception paramContext)
    {
      label28:
      break label28;
    }
    AppMethodBeat.o(188548);
    return i;
  }
  
  public static boolean d()
  {
    AppMethodBeat.i(188552);
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21)
      {
        AppMethodBeat.o(188552);
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null)
      {
        AppMethodBeat.o(188552);
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(188552);
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(188552);
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null)
      {
        AppMethodBeat.o(188552);
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(188552);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(188552);
    }
    return false;
  }
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(53965);
    String str = "";
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("tbs_guid", "");
      AppMethodBeat.o(53965);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(53967);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
      AppMethodBeat.o(53967);
      return "";
    }
    if (!TextUtils.isEmpty(a)) {
      paramContext = a;
    }
    for (;;)
    {
      AppMethodBeat.o(53967);
      return paramContext;
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      }
      catch (Exception paramContext)
      {
        paramContext = "";
      }
    }
  }
  
  public static String g(Context paramContext)
  {
    AppMethodBeat.i(53969);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
      AppMethodBeat.o(53969);
      return "";
    }
    if (!TextUtils.isEmpty(b)) {
      paramContext = b;
    }
    for (;;)
    {
      AppMethodBeat.o(53969);
      return paramContext;
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      }
      catch (Exception paramContext)
      {
        paramContext = "";
      }
    }
  }
  
  public static String h(Context paramContext)
  {
    AppMethodBeat.i(188549);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
      AppMethodBeat.o(188549);
      return "";
    }
    if ((!TextUtils.isEmpty(d)) || (Build.VERSION.SDK_INT < 23)) {}
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null) {
        paramContext = null;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        continue;
        if (paramContext == null) {
          paramContext = "";
        }
      }
    }
    for (d = paramContext;; d = c())
    {
      paramContext = d;
      AppMethodBeat.o(188549);
      return paramContext;
      paramContext = paramContext.getConnectionInfo();
      break label114;
      paramContext = paramContext.getMacAddress();
      break;
    }
  }
  
  public static String i(Context paramContext)
  {
    AppMethodBeat.i(188551);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
      AppMethodBeat.o(188551);
      return "";
    }
    if (!TextUtils.isEmpty(e))
    {
      paramContext = e;
      AppMethodBeat.o(188551);
      return paramContext;
    }
    try
    {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      label63:
      paramContext = e;
      AppMethodBeat.o(188551);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */