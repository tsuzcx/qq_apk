package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.a;
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
  private static String f = "";
  private static boolean g = false;
  
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
    //   0: ldc 246
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnull +10 -> 16
    //   9: aload_2
    //   10: invokevirtual 250	java/io/File:exists	()Z
    //   13: ifne +11 -> 24
    //   16: ldc 246
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 21
    //   23: areturn
    //   24: iload_1
    //   25: ifeq +63 -> 88
    //   28: aconst_null
    //   29: astore 4
    //   31: iconst_2
    //   32: newarray byte
    //   34: astore 5
    //   36: new 252	java/io/RandomAccessFile
    //   39: dup
    //   40: aload_2
    //   41: ldc 254
    //   43: invokespecial 257	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore_3
    //   47: aload_3
    //   48: aload 5
    //   50: invokevirtual 261	java/io/RandomAccessFile:read	([B)I
    //   53: pop
    //   54: new 66	java/lang/String
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 264	java/lang/String:<init>	([B)V
    //   63: ldc_w 266
    //   66: invokevirtual 270	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   69: ifne +15 -> 84
    //   72: aload_3
    //   73: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   76: ldc 246
    //   78: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: ldc 21
    //   83: areturn
    //   84: aload_3
    //   85: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   88: aload_0
    //   89: invokevirtual 277	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   92: invokevirtual 158	android/content/Context:getPackageName	()Ljava/lang/String;
    //   95: ldc_w 279
    //   98: invokevirtual 283	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +73 -> 174
    //   104: ldc 185
    //   106: ldc_w 285
    //   109: invokestatic 212	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokestatic 288	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   116: astore_3
    //   117: aload_3
    //   118: ifnull +56 -> 174
    //   121: ldc 185
    //   123: ldc_w 290
    //   126: invokestatic 212	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: ldc 246
    //   131: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_3
    //   135: areturn
    //   136: astore_3
    //   137: aload 4
    //   139: astore_3
    //   140: aload_3
    //   141: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   144: goto -56 -> 88
    //   147: astore_3
    //   148: goto -60 -> 88
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_2
    //   155: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   158: ldc 246
    //   160: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_0
    //   164: athrow
    //   165: astore_3
    //   166: ldc 185
    //   168: ldc_w 292
    //   171: invokestatic 212	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: ldc 185
    //   176: ldc_w 294
    //   179: invokestatic 212	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: aload_2
    //   184: iconst_0
    //   185: invokestatic 296	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   188: astore 4
    //   190: ldc 185
    //   192: ldc_w 298
    //   195: aload 4
    //   197: invokestatic 233	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   200: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 212	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload 4
    //   208: astore_3
    //   209: aload 4
    //   211: ifnonnull +23 -> 234
    //   214: aload_2
    //   215: invokestatic 288	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   218: astore_3
    //   219: ldc 185
    //   221: ldc_w 304
    //   224: aload_3
    //   225: invokestatic 233	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   228: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   231: invokestatic 212	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_3
    //   235: astore 4
    //   237: aload_3
    //   238: ifnonnull +27 -> 265
    //   241: aload_0
    //   242: aload_2
    //   243: iconst_1
    //   244: invokestatic 296	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   247: astore 4
    //   249: ldc 185
    //   251: ldc_w 306
    //   254: aload 4
    //   256: invokestatic 233	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   259: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokestatic 212	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: ldc 246
    //   267: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload 4
    //   272: areturn
    //   273: astore_0
    //   274: goto -198 -> 76
    //   277: astore_3
    //   278: goto -190 -> 88
    //   281: astore_2
    //   282: goto -124 -> 158
    //   285: astore_0
    //   286: aload_3
    //   287: astore_2
    //   288: goto -134 -> 154
    //   291: astore 4
    //   293: goto -153 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramContext	Context
    //   0	296	1	paramBoolean	boolean
    //   0	296	2	paramFile	File
    //   46	89	3	localObject1	Object
    //   136	1	3	localException1	Exception
    //   139	2	3	localObject2	Object
    //   147	1	3	localIOException1	java.io.IOException
    //   165	1	3	localThrowable	Throwable
    //   208	30	3	localObject3	Object
    //   277	10	3	localIOException2	java.io.IOException
    //   29	242	4	localObject4	Object
    //   291	1	4	localException2	Exception
    //   34	25	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   31	47	136	java/lang/Exception
    //   140	144	147	java/io/IOException
    //   31	47	151	finally
    //   88	117	165	java/lang/Throwable
    //   121	129	165	java/lang/Throwable
    //   72	76	273	java/io/IOException
    //   84	88	277	java/io/IOException
    //   154	158	281	java/io/IOException
    //   47	72	285	finally
    //   47	72	291	java/lang/Exception
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
    //   0: ldc_w 398
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 29	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   9: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +15 -> 27
    //   15: getstatic 29	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   18: astore_0
    //   19: ldc_w 398
    //   22: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: areturn
    //   27: new 405	java/io/InputStreamReader
    //   30: dup
    //   31: invokestatic 411	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   34: ldc_w 413
    //   37: invokevirtual 417	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   40: invokevirtual 422	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: invokespecial 425	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: astore_1
    //   47: new 427	java/io/BufferedReader
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 430	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   55: astore 4
    //   57: aload 4
    //   59: astore_3
    //   60: aload_1
    //   61: astore_2
    //   62: aload 4
    //   64: invokevirtual 433	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: ldc_w 435
    //   70: invokevirtual 283	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifeq +32 -> 105
    //   76: aload 4
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: ldc_w 437
    //   84: invokestatic 439	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload 4
    //   90: invokevirtual 440	java/io/BufferedReader:close	()V
    //   93: aload_1
    //   94: invokevirtual 441	java/io/InputStreamReader:close	()V
    //   97: ldc_w 398
    //   100: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: areturn
    //   105: aload 4
    //   107: astore_3
    //   108: aload_1
    //   109: astore_2
    //   110: ldc_w 443
    //   113: invokestatic 448	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 439	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
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
    //   132: ldc_w 443
    //   135: invokestatic 448	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokestatic 439	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 4
    //   143: aload 4
    //   145: astore_2
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 440	java/io/BufferedReader:close	()V
    //   154: aload_2
    //   155: astore_0
    //   156: aload_1
    //   157: ifnull -60 -> 97
    //   160: aload_1
    //   161: invokevirtual 441	java/io/InputStreamReader:close	()V
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
    //   185: invokevirtual 440	java/io/BufferedReader:close	()V
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 441	java/io/InputStreamReader:close	()V
    //   196: ldc_w 398
    //   199: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(200359);
    try
    {
      if (!QbSdk.isEnableSensitiveApi())
      {
        TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
        AppMethodBeat.o(200359);
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
            AppMethodBeat.o(200359);
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
          AppMethodBeat.o(200359);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(200359);
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
    AppMethodBeat.i(200324);
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
    AppMethodBeat.o(200324);
    return i;
  }
  
  public static boolean d()
  {
    AppMethodBeat.i(200405);
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21)
      {
        AppMethodBeat.o(200405);
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null)
      {
        AppMethodBeat.o(200405);
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(200405);
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(200405);
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null)
      {
        AppMethodBeat.o(200405);
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(200405);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(200405);
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
  
  public static boolean f(Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(200333);
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("gi", false);
      bool1 = bool2;
      TbsLog.i("AppUtil", "getImeiEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1001), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(201211);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("gi", true);
          localEditor.commit();
          TbsLog.e("TBSEmergency", "Execute command [1001](" + paramAnonymousString + ")");
          AppMethodBeat.o(201211);
        }
      });
      bool1 = bool2;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(200333);
    return bool1;
  }
  
  public static String g(Context paramContext)
  {
    AppMethodBeat.i(53969);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "getImei isEnableSensitiveApi = false");
      AppMethodBeat.o(53969);
      return "";
    }
    if (!g) {}
    try
    {
      a = k(paramContext);
      new StringBuilder(" getDeviceID is ").append(a);
      if (TextUtils.isEmpty(a))
      {
        a = l.a(paramContext);
        new StringBuilder(" getSDKUID is ").append(a);
      }
      label92:
      g = true;
      paramContext = a;
      AppMethodBeat.o(53969);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label92;
    }
  }
  
  public static String h(Context paramContext)
  {
    AppMethodBeat.i(200345);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
      AppMethodBeat.o(200345);
      return "";
    }
    if (!TextUtils.isEmpty(b)) {
      paramContext = b;
    }
    for (;;)
    {
      AppMethodBeat.o(200345);
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
  
  public static String i(Context paramContext)
  {
    AppMethodBeat.i(200353);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
      AppMethodBeat.o(200353);
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
      AppMethodBeat.o(200353);
      return paramContext;
      paramContext = (WifiInfo)a.a(paramContext, "com/tencent/smtt/utils/b", "i", "(Landroid/content/Context;)Ljava/lang/String;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
      break label135;
      paramContext = paramContext.getMacAddress();
      break;
    }
  }
  
  public static String j(Context paramContext)
  {
    AppMethodBeat.i(200360);
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
      AppMethodBeat.o(200360);
      return "";
    }
    if (!TextUtils.isEmpty(e))
    {
      paramContext = e;
      AppMethodBeat.o(200360);
      return paramContext;
    }
    try
    {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      label63:
      paramContext = e;
      AppMethodBeat.o(200360);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label63;
    }
  }
  
  private static String k(Context paramContext)
  {
    AppMethodBeat.i(200340);
    try
    {
      if (!l(paramContext))
      {
        TbsLog.i("AppUtil", "getDeviceID isDeviceIDEnable is false");
        AppMethodBeat.o(200340);
        return "";
      }
      f = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Exception paramContext)
    {
      label46:
      break label46;
    }
    paramContext = f;
    AppMethodBeat.o(200340);
    return paramContext;
  }
  
  private static boolean l(Context paramContext)
  {
    boolean bool1 = true;
    AppMethodBeat.i(200344);
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("pdi", true);
      bool1 = bool2;
      TbsLog.i("AppUtil", "isDeviceIDEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1004), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(200592);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("pdi", false);
          localEditor.commit();
          TbsLog.e("TBSEmergency", "Execute command [1004](" + paramAnonymousString + ")");
          AppMethodBeat.o(200592);
        }
      });
      bool1 = bool2;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(200344);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */