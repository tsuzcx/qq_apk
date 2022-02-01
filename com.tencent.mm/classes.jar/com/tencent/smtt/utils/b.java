package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.a;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
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
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 31	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   8: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: getstatic 31	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   17: astore_0
    //   18: ldc 139
    //   20: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: areturn
    //   25: new 147	java/io/InputStreamReader
    //   28: dup
    //   29: invokestatic 153	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   32: ldc 155
    //   34: invokevirtual 159	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   37: invokevirtual 165	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 168	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: astore_1
    //   44: new 170	java/io/BufferedReader
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 173	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: ldc 178
    //   59: invokevirtual 181	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   62: ifeq +24 -> 86
    //   65: ldc 183
    //   67: invokestatic 186	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_0
    //   71: aload_2
    //   72: invokevirtual 189	java/io/BufferedReader:close	()V
    //   75: aload_1
    //   76: invokevirtual 190	java/io/InputStreamReader:close	()V
    //   79: ldc 139
    //   81: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: ldc 192
    //   88: invokestatic 197	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 186	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore_0
    //   95: goto -24 -> 71
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: ldc 192
    //   105: invokestatic 197	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokestatic 186	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore_2
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 189	java/io/BufferedReader:close	()V
    //   120: aload_2
    //   121: astore_0
    //   122: aload_1
    //   123: ifnull -44 -> 79
    //   126: aload_1
    //   127: invokevirtual 190	java/io/InputStreamReader:close	()V
    //   130: aload_2
    //   131: astore_0
    //   132: goto -53 -> 79
    //   135: astore_0
    //   136: aload_2
    //   137: astore_0
    //   138: goto -59 -> 79
    //   141: astore_2
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 189	java/io/BufferedReader:close	()V
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 190	java/io/InputStreamReader:close	()V
    //   158: ldc 139
    //   160: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: athrow
    //   165: astore_2
    //   166: goto -91 -> 75
    //   169: astore_1
    //   170: goto -91 -> 79
    //   173: astore_0
    //   174: goto -54 -> 120
    //   177: astore_0
    //   178: goto -28 -> 150
    //   181: astore_0
    //   182: goto -24 -> 158
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_0
    //   188: goto -85 -> 103
    //   191: astore_0
    //   192: aload_2
    //   193: astore_0
    //   194: goto -91 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	78	0	str	String
    //   98	1	0	localObject1	Object
    //   100	32	0	localObject2	Object
    //   135	1	0	localIOException1	java.io.IOException
    //   137	10	0	localObject3	Object
    //   173	1	0	localIOException2	java.io.IOException
    //   177	1	0	localIOException3	java.io.IOException
    //   181	1	0	localIOException4	java.io.IOException
    //   185	1	0	localObject4	Object
    //   187	1	0	localObject5	Object
    //   191	1	0	localObject6	Object
    //   193	1	0	localObject7	Object
    //   43	112	1	localInputStreamReader	java.io.InputStreamReader
    //   169	1	1	localIOException5	java.io.IOException
    //   52	85	2	localObject8	Object
    //   141	23	2	localObject9	Object
    //   165	28	2	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   25	44	98	finally
    //   126	130	135	java/io/IOException
    //   103	112	141	finally
    //   71	75	165	java/io/IOException
    //   75	79	169	java/io/IOException
    //   116	120	173	java/io/IOException
    //   146	150	177	java/io/IOException
    //   154	158	181	java/io/IOException
    //   44	53	185	finally
    //   53	71	191	finally
    //   86	95	191	finally
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
        label48:
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
      break label48;
    }
    AppMethodBeat.o(53961);
    return paramContext;
  }
  
  /* Error */
  public static String a(Context paramContext, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: ldc_w 288
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +10 -> 17
    //   10: aload_2
    //   11: invokevirtual 292	java/io/File:exists	()Z
    //   14: ifne +12 -> 26
    //   17: ldc_w 288
    //   20: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: ldc 23
    //   25: areturn
    //   26: iload_1
    //   27: ifeq +65 -> 92
    //   30: aconst_null
    //   31: astore 4
    //   33: iconst_2
    //   34: newarray byte
    //   36: astore 5
    //   38: new 294	java/io/RandomAccessFile
    //   41: dup
    //   42: aload_2
    //   43: ldc_w 296
    //   46: invokespecial 299	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore_3
    //   50: aload_3
    //   51: aload 5
    //   53: invokevirtual 303	java/io/RandomAccessFile:read	([B)I
    //   56: pop
    //   57: new 68	java/lang/String
    //   60: dup
    //   61: aload 5
    //   63: invokespecial 306	java/lang/String:<init>	([B)V
    //   66: ldc_w 308
    //   69: invokevirtual 312	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   72: ifne +16 -> 88
    //   75: aload_3
    //   76: invokevirtual 313	java/io/RandomAccessFile:close	()V
    //   79: ldc_w 288
    //   82: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: ldc 23
    //   87: areturn
    //   88: aload_3
    //   89: invokevirtual 313	java/io/RandomAccessFile:close	()V
    //   92: aload_0
    //   93: invokevirtual 317	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   96: invokevirtual 204	android/content/Context:getPackageName	()Ljava/lang/String;
    //   99: ldc_w 319
    //   102: invokevirtual 181	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +75 -> 180
    //   108: ldc 231
    //   110: ldc_w 321
    //   113: invokestatic 258	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokestatic 324	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +58 -> 180
    //   125: ldc 231
    //   127: ldc_w 326
    //   130: invokestatic 258	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: ldc_w 288
    //   136: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_3
    //   140: areturn
    //   141: astore_3
    //   142: aload 4
    //   144: astore_3
    //   145: aload_3
    //   146: invokevirtual 313	java/io/RandomAccessFile:close	()V
    //   149: goto -57 -> 92
    //   152: astore_3
    //   153: goto -61 -> 92
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: invokevirtual 313	java/io/RandomAccessFile:close	()V
    //   163: ldc_w 288
    //   166: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_0
    //   170: athrow
    //   171: astore_3
    //   172: ldc 231
    //   174: ldc_w 328
    //   177: invokestatic 258	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: ldc 231
    //   182: ldc_w 330
    //   185: invokestatic 258	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_0
    //   189: aload_2
    //   190: iconst_0
    //   191: invokestatic 332	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   194: astore 4
    //   196: ldc 231
    //   198: ldc_w 334
    //   201: aload 4
    //   203: invokestatic 279	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokevirtual 337	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   209: invokestatic 258	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 4
    //   214: astore_3
    //   215: aload 4
    //   217: ifnonnull +23 -> 240
    //   220: aload_2
    //   221: invokestatic 324	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   224: astore_3
    //   225: ldc 231
    //   227: ldc_w 339
    //   230: aload_3
    //   231: invokestatic 279	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: invokevirtual 337	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 258	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_3
    //   241: astore 4
    //   243: aload_3
    //   244: ifnonnull +27 -> 271
    //   247: aload_0
    //   248: aload_2
    //   249: iconst_1
    //   250: invokestatic 332	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   253: astore 4
    //   255: ldc 231
    //   257: ldc_w 341
    //   260: aload 4
    //   262: invokestatic 279	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   265: invokevirtual 337	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   268: invokestatic 258	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: ldc_w 288
    //   274: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload 4
    //   279: areturn
    //   280: astore_0
    //   281: goto -202 -> 79
    //   284: astore_3
    //   285: goto -193 -> 92
    //   288: astore_2
    //   289: goto -126 -> 163
    //   292: astore_0
    //   293: aload_3
    //   294: astore_2
    //   295: goto -136 -> 159
    //   298: astore 4
    //   300: goto -155 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramContext	Context
    //   0	303	1	paramBoolean	boolean
    //   0	303	2	paramFile	File
    //   49	91	3	localObject1	Object
    //   141	1	3	localException1	Exception
    //   144	2	3	localObject2	Object
    //   152	1	3	localIOException1	java.io.IOException
    //   171	1	3	localObject3	Object
    //   214	30	3	localObject4	Object
    //   284	10	3	localIOException2	java.io.IOException
    //   31	247	4	localObject5	Object
    //   298	1	4	localException2	Exception
    //   36	26	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	50	141	java/lang/Exception
    //   145	149	152	java/io/IOException
    //   33	50	156	finally
    //   92	121	171	finally
    //   125	133	171	finally
    //   75	79	280	java/io/IOException
    //   88	92	284	java/io/IOException
    //   159	163	288	java/io/IOException
    //   50	75	292	finally
    //   50	75	298	java/lang/Exception
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
  
  public static boolean b()
  {
    AppMethodBeat.i(219393);
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21) {
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null) {
        return false;
      }
      Object localObject3 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject3 == null) {
        return false;
      }
      localObject3 = ((Method)localObject3).invoke(null, new Object[0]);
      if (localObject3 == null) {
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject3, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        return bool;
      }
    }
    finally
    {
      AppMethodBeat.o(219393);
    }
    return false;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(53963);
    try
    {
      String str = new String(r.d(paramContext).getBytes("UTF-8"), "ISO8859-1");
      AppMethodBeat.o(53963);
      return str;
    }
    catch (Exception localException)
    {
      paramContext = r.d(paramContext);
      AppMethodBeat.o(53963);
    }
    return paramContext;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(53964);
    Object localObject = null;
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      AppMethodBeat.o(53964);
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
  
  public static int e(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(219341);
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
    AppMethodBeat.o(219341);
    return i;
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(53967);
    String str = "";
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("tbs_guid", "");
      AppMethodBeat.o(53967);
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
  
  public static boolean g(Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(219358);
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
          AppMethodBeat.i(219331);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("gi", true);
          localEditor.commit();
          TbsLog.e("TBSEmergency", "Execute command [1001](" + paramAnonymousString + ")");
          AppMethodBeat.o(219331);
        }
      });
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(219358);
    return bool1;
  }
  
  public static String h(Context paramContext)
  {
    AppMethodBeat.i(219361);
    if (!TextUtils.isEmpty(a))
    {
      paramContext = a;
      AppMethodBeat.o(219361);
      return paramContext;
    }
    try
    {
      a = l.a(paramContext);
      new StringBuilder(" getSDKUID is ").append(a);
      label51:
      paramContext = a;
      AppMethodBeat.o(219361);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label51;
    }
  }
  
  public static String i(Context paramContext)
  {
    return "";
  }
  
  public static String j(Context paramContext)
  {
    return "";
  }
  
  public static String k(Context paramContext)
  {
    AppMethodBeat.i(219372);
    if (!l(paramContext))
    {
      TbsLog.i("AppUtil", "getAndroidID isAndroidIDEnable is false");
      AppMethodBeat.o(219372);
      return "";
    }
    if (!TextUtils.isEmpty(e))
    {
      paramContext = e;
      AppMethodBeat.o(219372);
      return paramContext;
    }
    try
    {
      paramContext = paramContext.getContentResolver();
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("android_id").cG(paramContext);
      e = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), paramContext.aYi(), "com/tencent/smtt/utils/b", "k", "(Landroid/content/Context;)Ljava/lang/String;", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
      label112:
      TbsLog.i("AppUtil", "getAndroidID mAndroidID is " + e);
      paramContext = e;
      AppMethodBeat.o(219372);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label112;
    }
  }
  
  private static boolean l(Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(219376);
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("gpai", false);
      bool1 = bool2;
      TbsLog.i("AppUtil", "isAndroidIDEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c localc = c.a();
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1012), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219347);
          paramAnonymousString = this.a.getSharedPreferences("sai", 0).edit();
          paramAnonymousString.putBoolean("gpai", false);
          paramAnonymousString.commit();
          TbsLog.e("TBSEmergency", "Execute command [1012](+extra+)");
          AppMethodBeat.o(219347);
        }
      });
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1011), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219336);
          paramAnonymousString = this.a.getSharedPreferences("sai", 0).edit();
          paramAnonymousString.putBoolean("gpai", true);
          paramAnonymousString.commit();
          TbsLog.e("TBSEmergency", "Execute command [1011](+extra+)");
          AppMethodBeat.o(219336);
        }
      });
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(219376);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */