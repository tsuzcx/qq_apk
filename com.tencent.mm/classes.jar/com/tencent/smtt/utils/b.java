package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 128
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   8: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: getstatic 20	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   17: astore_0
    //   18: ldc 128
    //   20: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: areturn
    //   25: new 136	java/io/InputStreamReader
    //   28: dup
    //   29: invokestatic 142	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   32: ldc 144
    //   34: invokevirtual 148	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   37: invokevirtual 154	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: astore_1
    //   44: new 159	java/io/BufferedReader
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 162	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload_1
    //   58: astore_2
    //   59: aload 4
    //   61: invokevirtual 165	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: ldc 167
    //   66: invokevirtual 170	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +30 -> 99
    //   72: aload 4
    //   74: astore_3
    //   75: aload_1
    //   76: astore_2
    //   77: ldc 172
    //   79: invokestatic 175	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_0
    //   83: aload 4
    //   85: invokevirtual 178	java/io/BufferedReader:close	()V
    //   88: aload_1
    //   89: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   92: ldc 128
    //   94: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: areturn
    //   99: aload 4
    //   101: astore_3
    //   102: aload_1
    //   103: astore_2
    //   104: ldc 181
    //   106: invokestatic 186	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokestatic 175	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_0
    //   113: goto -30 -> 83
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_0
    //   122: astore_3
    //   123: aload_1
    //   124: astore_2
    //   125: ldc 181
    //   127: invokestatic 186	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   130: invokestatic 175	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 4
    //   135: aload 4
    //   137: astore_2
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 178	java/io/BufferedReader:close	()V
    //   146: aload_2
    //   147: astore_0
    //   148: aload_1
    //   149: ifnull -57 -> 92
    //   152: aload_1
    //   153: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   156: aload_2
    //   157: astore_0
    //   158: goto -66 -> 92
    //   161: astore_0
    //   162: aload_2
    //   163: astore_0
    //   164: goto -72 -> 92
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 178	java/io/BufferedReader:close	()V
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 179	java/io/InputStreamReader:close	()V
    //   188: ldc 128
    //   190: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_0
    //   194: athrow
    //   195: astore_2
    //   196: goto -108 -> 88
    //   199: astore_1
    //   200: goto -108 -> 92
    //   203: astore_0
    //   204: goto -58 -> 146
    //   207: astore_2
    //   208: goto -28 -> 180
    //   211: astore_1
    //   212: goto -24 -> 188
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_2
    //   218: goto -46 -> 172
    //   221: astore_0
    //   222: aload_2
    //   223: astore_1
    //   224: aload_3
    //   225: astore_2
    //   226: goto -54 -> 172
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_0
    //   232: goto -111 -> 121
    //   235: astore_0
    //   236: aload 4
    //   238: astore_0
    //   239: goto -118 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	96	0	str	String
    //   116	1	0	localThrowable1	Throwable
    //   118	40	0	localObject1	Object
    //   161	1	0	localIOException1	java.io.IOException
    //   163	1	0	localObject2	Object
    //   167	27	0	localObject3	Object
    //   203	1	0	localIOException2	java.io.IOException
    //   215	1	0	localObject4	Object
    //   221	1	0	localObject5	Object
    //   229	1	0	localThrowable2	Throwable
    //   231	1	0	localObject6	Object
    //   235	1	0	localThrowable3	Throwable
    //   238	1	0	localObject7	Object
    //   43	142	1	localInputStreamReader	java.io.InputStreamReader
    //   199	1	1	localIOException3	java.io.IOException
    //   211	1	1	localIOException4	java.io.IOException
    //   223	1	1	localObject8	Object
    //   58	119	2	localObject9	Object
    //   195	1	2	localIOException5	java.io.IOException
    //   207	1	2	localIOException6	java.io.IOException
    //   217	9	2	localObject10	Object
    //   56	169	3	localObject11	Object
    //   52	185	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   25	44	116	java/lang/Throwable
    //   152	156	161	java/io/IOException
    //   25	44	167	finally
    //   83	88	195	java/io/IOException
    //   88	92	199	java/io/IOException
    //   142	146	203	java/io/IOException
    //   176	180	207	java/io/IOException
    //   184	188	211	java/io/IOException
    //   44	54	215	finally
    //   59	72	221	finally
    //   77	83	221	finally
    //   104	113	221	finally
    //   125	135	221	finally
    //   44	54	229	java/lang/Throwable
    //   59	72	235	java/lang/Throwable
    //   77	83	235	java/lang/Throwable
    //   104	113	235	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(53959);
    Object localObject = null;
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
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
    //   0: ldc_w 283
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +10 -> 17
    //   10: aload_2
    //   11: invokevirtual 287	java/io/File:exists	()Z
    //   14: ifne +12 -> 26
    //   17: ldc_w 283
    //   20: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: ldc 14
    //   25: areturn
    //   26: iload_1
    //   27: ifeq +65 -> 92
    //   30: aconst_null
    //   31: astore 4
    //   33: iconst_2
    //   34: newarray byte
    //   36: astore 5
    //   38: new 289	java/io/RandomAccessFile
    //   41: dup
    //   42: aload_2
    //   43: ldc_w 291
    //   46: invokespecial 294	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore_3
    //   50: aload_3
    //   51: aload 5
    //   53: invokevirtual 298	java/io/RandomAccessFile:read	([B)I
    //   56: pop
    //   57: new 55	java/lang/String
    //   60: dup
    //   61: aload 5
    //   63: invokespecial 301	java/lang/String:<init>	([B)V
    //   66: ldc_w 303
    //   69: invokevirtual 307	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   72: ifne +16 -> 88
    //   75: aload_3
    //   76: invokevirtual 308	java/io/RandomAccessFile:close	()V
    //   79: ldc_w 283
    //   82: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: ldc 14
    //   87: areturn
    //   88: aload_3
    //   89: invokevirtual 308	java/io/RandomAccessFile:close	()V
    //   92: aload_0
    //   93: invokevirtual 312	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   96: invokevirtual 193	android/content/Context:getPackageName	()Ljava/lang/String;
    //   99: ldc_w 314
    //   102: invokevirtual 170	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +75 -> 180
    //   108: ldc 226
    //   110: ldc_w 316
    //   113: invokestatic 253	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokestatic 319	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +58 -> 180
    //   125: ldc 226
    //   127: ldc_w 321
    //   130: invokestatic 253	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: ldc_w 283
    //   136: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_3
    //   140: areturn
    //   141: astore_3
    //   142: aload 4
    //   144: astore_3
    //   145: aload_3
    //   146: invokevirtual 308	java/io/RandomAccessFile:close	()V
    //   149: goto -57 -> 92
    //   152: astore_3
    //   153: goto -61 -> 92
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: invokevirtual 308	java/io/RandomAccessFile:close	()V
    //   163: ldc_w 283
    //   166: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_0
    //   170: athrow
    //   171: astore_3
    //   172: ldc 226
    //   174: ldc_w 323
    //   177: invokestatic 253	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: ldc 226
    //   182: ldc_w 325
    //   185: invokestatic 253	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_0
    //   189: aload_2
    //   190: iconst_0
    //   191: invokestatic 327	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   194: astore 4
    //   196: ldc 226
    //   198: ldc_w 329
    //   201: aload 4
    //   203: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokevirtual 332	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   209: invokestatic 253	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 4
    //   214: astore_3
    //   215: aload 4
    //   217: ifnonnull +23 -> 240
    //   220: aload_2
    //   221: invokestatic 319	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   224: astore_3
    //   225: ldc 226
    //   227: ldc_w 334
    //   230: aload_3
    //   231: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: invokevirtual 332	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 253	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_3
    //   241: astore 4
    //   243: aload_3
    //   244: ifnonnull +27 -> 271
    //   247: aload_0
    //   248: aload_2
    //   249: iconst_1
    //   250: invokestatic 327	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;Z)Ljava/lang/String;
    //   253: astore 4
    //   255: ldc 226
    //   257: ldc_w 336
    //   260: aload 4
    //   262: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   265: invokevirtual 332	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   268: invokestatic 253	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: ldc_w 283
    //   274: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   171	1	3	localThrowable	Throwable
    //   214	30	3	localObject3	Object
    //   284	10	3	localIOException2	java.io.IOException
    //   31	247	4	localObject4	Object
    //   298	1	4	localException2	Exception
    //   36	26	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	50	141	java/lang/Exception
    //   145	149	152	java/io/IOException
    //   33	50	156	finally
    //   92	121	171	java/lang/Throwable
    //   125	133	171	java/lang/Throwable
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
    int i = 0;
    AppMethodBeat.i(53960);
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
    AppMethodBeat.o(53960);
    return i;
  }
  
  public static String b()
  {
    AppMethodBeat.i(53968);
    try
    {
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if (localObject1 == null)
          {
            AppMethodBeat.o(53968);
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
          AppMethodBeat.o(53968);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(53968);
    }
    return "02:00:00:00:00:00";
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
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(53963);
    String str = "";
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("tbs_guid", "");
      AppMethodBeat.o(53963);
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
  
  public static boolean c()
  {
    AppMethodBeat.i(53976);
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21)
      {
        AppMethodBeat.o(53976);
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null)
      {
        AppMethodBeat.o(53976);
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(53976);
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null)
      {
        AppMethodBeat.o(53976);
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null)
      {
        AppMethodBeat.o(53976);
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(53976);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(53976);
    }
    return false;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(53964);
    if (!TextUtils.isEmpty(a)) {
      paramContext = a;
    }
    for (;;)
    {
      AppMethodBeat.o(53964);
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
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(53965);
    if (!TextUtils.isEmpty(b)) {
      paramContext = b;
    }
    for (;;)
    {
      AppMethodBeat.o(53965);
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
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(53967);
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
    for (d = paramContext;; d = b())
    {
      paramContext = d;
      AppMethodBeat.o(53967);
      return paramContext;
      paramContext = paramContext.getConnectionInfo();
      break label91;
      paramContext = paramContext.getMacAddress();
      break;
    }
  }
  
  public static String g(Context paramContext)
  {
    AppMethodBeat.i(53969);
    if (!TextUtils.isEmpty(e))
    {
      paramContext = e;
      AppMethodBeat.o(53969);
      return paramContext;
    }
    try
    {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      label40:
      paramContext = e;
      AppMethodBeat.o(53969);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label40;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */