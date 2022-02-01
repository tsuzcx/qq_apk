package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static int a(Context paramContext, File paramFile)
  {
    int i = 0;
    AppMethodBeat.i(53856);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 20) {
          continue;
        }
        if (TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_get_apk_version_switch.txt")) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        int j;
        TbsLog.i("ApkUtil", "getApkVersion Failed");
        continue;
        boolean bool = false;
        continue;
      }
      j = a(paramContext, paramFile, bool);
      i = j;
      AppMethodBeat.o(53856);
      return i;
      bool = false;
    }
  }
  
  public static int a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(53859);
    if (paramFile != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramFile.exists())
        {
          boolean bool1 = paramFile.getName().contains("tbs.org");
          boolean bool2 = paramFile.getName().contains("x5.tbs.decouple");
          if ((bool1) || (bool2))
          {
            i = a(bool2, paramFile);
            if (i > 0)
            {
              AppMethodBeat.o(53859);
              return i;
            }
            if (!TbsShareManager.isThirdPartyApp(paramContext))
            {
              bool1 = paramFile.getAbsolutePath().contains(paramContext.getApplicationInfo().packageName);
              if (!bool1)
              {
                AppMethodBeat.o(53859);
                return 0;
              }
            }
          }
          if (((Build.VERSION.SDK_INT != 23) && (Build.VERSION.SDK_INT != 25)) || (!Build.MANUFACTURER.toLowerCase().contains("mi"))) {
            break label249;
          }
          i = 1;
          TbsPVConfig.releaseInstance();
          int k = TbsPVConfig.getInstance(paramContext).getReadApk();
          if (k == 1)
          {
            i = 0;
            paramBoolean = false;
            break label254;
            label161:
            i = b(paramFile);
            if (i > 0)
            {
              AppMethodBeat.o(53859);
              return i;
            }
          }
          else
          {
            if (k != 2) {
              break label254;
            }
            AppMethodBeat.o(53859);
            return 0;
          }
        }
      }
      catch (Throwable localThrowable) {}
      label249:
      label254:
      do
      {
        i = j;
        if (paramFile != null)
        {
          i = j;
          if (!paramFile.exists()) {}
        }
        try
        {
          paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
          i = j;
          if (paramContext != null) {
            i = paramContext.versionCode;
          }
          AppMethodBeat.o(53859);
          return i;
        }
        catch (Throwable paramContext)
        {
          AppMethodBeat.o(53859);
          return -1;
        }
        i = 0;
        break;
        if (paramBoolean) {
          break label161;
        }
      } while (i == 0);
    }
  }
  
  private static int a(boolean paramBoolean, File paramFile)
  {
    AppMethodBeat.i(53858);
    try
    {
      paramFile = paramFile.getParentFile();
      if (paramFile != null)
      {
        paramFile = paramFile.listFiles();
        Pattern localPattern = Pattern.compile(a(paramBoolean) + "(.*)");
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          if ((localPattern.matcher(localObject.getName()).find()) && (localObject.isFile()) && (localObject.exists()))
          {
            i = Integer.parseInt(localObject.getName().substring(localObject.getName().lastIndexOf(".") + 1));
            AppMethodBeat.o(53858);
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(53858);
    }
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 202
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 16
    //   7: newarray char
    //   9: astore 5
    //   11: aload 5
    //   13: dup
    //   14: iconst_0
    //   15: ldc 203
    //   17: castore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 204
    //   22: castore
    //   23: dup
    //   24: iconst_2
    //   25: ldc 205
    //   27: castore
    //   28: dup
    //   29: iconst_3
    //   30: ldc 206
    //   32: castore
    //   33: dup
    //   34: iconst_4
    //   35: ldc 207
    //   37: castore
    //   38: dup
    //   39: iconst_5
    //   40: ldc 208
    //   42: castore
    //   43: dup
    //   44: bipush 6
    //   46: ldc 209
    //   48: castore
    //   49: dup
    //   50: bipush 7
    //   52: ldc 210
    //   54: castore
    //   55: dup
    //   56: bipush 8
    //   58: ldc 211
    //   60: castore
    //   61: dup
    //   62: bipush 9
    //   64: ldc 212
    //   66: castore
    //   67: dup
    //   68: bipush 10
    //   70: ldc 213
    //   72: castore
    //   73: dup
    //   74: bipush 11
    //   76: ldc 214
    //   78: castore
    //   79: dup
    //   80: bipush 12
    //   82: ldc 215
    //   84: castore
    //   85: dup
    //   86: bipush 13
    //   88: ldc 216
    //   90: castore
    //   91: dup
    //   92: bipush 14
    //   94: ldc 217
    //   96: castore
    //   97: dup
    //   98: bipush 15
    //   100: ldc 218
    //   102: castore
    //   103: pop
    //   104: bipush 32
    //   106: newarray char
    //   108: astore 6
    //   110: ldc 220
    //   112: invokestatic 225	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   115: astore 7
    //   117: new 227	java/io/FileInputStream
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore_0
    //   126: sipush 8192
    //   129: newarray byte
    //   131: astore 8
    //   133: aload_0
    //   134: aload 8
    //   136: invokevirtual 234	java/io/FileInputStream:read	([B)I
    //   139: istore_1
    //   140: iload_1
    //   141: iconst_m1
    //   142: if_icmpeq +32 -> 174
    //   145: aload 7
    //   147: aload 8
    //   149: iconst_0
    //   150: iload_1
    //   151: invokevirtual 238	java/security/MessageDigest:update	([BII)V
    //   154: goto -21 -> 133
    //   157: astore 5
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 241	java/io/FileInputStream:close	()V
    //   167: ldc 202
    //   169: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aconst_null
    //   173: areturn
    //   174: aload 7
    //   176: invokevirtual 245	java/security/MessageDigest:digest	()[B
    //   179: astore 7
    //   181: iconst_0
    //   182: istore_1
    //   183: iconst_0
    //   184: istore_2
    //   185: goto +69 -> 254
    //   188: new 70	java/lang/String
    //   191: dup
    //   192: aload 6
    //   194: invokespecial 248	java/lang/String:<init>	([C)V
    //   197: astore 5
    //   199: aload_0
    //   200: invokevirtual 241	java/io/FileInputStream:close	()V
    //   203: ldc 202
    //   205: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload 5
    //   210: areturn
    //   211: astore 5
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 241	java/io/FileInputStream:close	()V
    //   223: ldc 202
    //   225: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload 5
    //   230: athrow
    //   231: astore_0
    //   232: goto -29 -> 203
    //   235: astore_0
    //   236: goto -69 -> 167
    //   239: astore_0
    //   240: goto -17 -> 223
    //   243: astore 5
    //   245: goto -30 -> 215
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -92 -> 159
    //   254: iload_1
    //   255: bipush 16
    //   257: if_icmpge -69 -> 188
    //   260: aload 7
    //   262: iload_1
    //   263: baload
    //   264: istore 4
    //   266: iload_2
    //   267: iconst_1
    //   268: iadd
    //   269: istore_3
    //   270: aload 6
    //   272: iload_2
    //   273: aload 5
    //   275: iload 4
    //   277: iconst_4
    //   278: iushr
    //   279: bipush 15
    //   281: iand
    //   282: caload
    //   283: castore
    //   284: aload 6
    //   286: iload_3
    //   287: aload 5
    //   289: iload 4
    //   291: bipush 15
    //   293: iand
    //   294: caload
    //   295: castore
    //   296: iload_1
    //   297: iconst_1
    //   298: iadd
    //   299: istore_1
    //   300: iload_3
    //   301: iconst_1
    //   302: iadd
    //   303: istore_2
    //   304: goto -50 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramFile	File
    //   139	161	1	i	int
    //   184	120	2	j	int
    //   269	34	3	k	int
    //   264	30	4	m	int
    //   9	3	5	arrayOfChar1	char[]
    //   157	1	5	localException	Exception
    //   197	12	5	str	String
    //   211	18	5	localObject1	Object
    //   243	45	5	localObject2	Object
    //   108	177	6	arrayOfChar2	char[]
    //   115	146	7	localObject3	Object
    //   131	17	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   126	133	157	java/lang/Exception
    //   133	140	157	java/lang/Exception
    //   145	154	157	java/lang/Exception
    //   174	181	157	java/lang/Exception
    //   188	199	157	java/lang/Exception
    //   110	126	211	finally
    //   199	203	231	java/io/IOException
    //   163	167	235	java/io/IOException
    //   219	223	239	java/io/IOException
    //   126	133	243	finally
    //   133	140	243	finally
    //   145	154	243	finally
    //   174	181	243	finally
    //   188	199	243	finally
    //   110	126	248	java/lang/Exception
  }
  
  public static final String a(boolean paramBoolean)
  {
    AppMethodBeat.i(53857);
    String str = a(paramBoolean, 0);
    AppMethodBeat.o(53857);
    return str;
  }
  
  public static final String a(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(200189);
    boolean bool;
    if (paramInt == 64) {
      bool = true;
    }
    while (bool) {
      if (paramBoolean)
      {
        AppMethodBeat.o(200189);
        return "x5.64.decouple.backup";
        if (paramInt == 32) {
          bool = false;
        } else {
          bool = b.d();
        }
      }
      else
      {
        AppMethodBeat.o(200189);
        return "x5.64.backup";
      }
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(200189);
      return "x5.decouple.backup";
    }
    AppMethodBeat.o(200189);
    return "x5.backup";
  }
  
  public static boolean a(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    AppMethodBeat.i(53854);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(53854);
      return false;
    }
    if ((paramLong > 0L) && (paramLong != paramFile.length()))
    {
      AppMethodBeat.o(53854);
      return false;
    }
    try
    {
      int i = a(paramContext, paramFile);
      if (paramInt != i)
      {
        AppMethodBeat.o(53854);
        return false;
      }
      boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, true, paramFile));
      if (!bool)
      {
        AppMethodBeat.o(53854);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(53854);
      return false;
    }
    AppMethodBeat.o(53854);
    return true;
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 284
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 286
    //   9: new 152	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 288
    //   16: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: ldc_w 296
    //   26: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 62	java/io/File:exists	()Z
    //   33: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: ldc_w 301
    //   39: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 304	java/io/File:canRead	()Z
    //   46: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc 2
    //   57: monitorenter
    //   58: new 306	java/util/jar/JarFile
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 307	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   66: astore_3
    //   67: new 309	java/io/BufferedReader
    //   70: dup
    //   71: new 311	java/io/InputStreamReader
    //   74: dup
    //   75: aload_3
    //   76: aload_3
    //   77: ldc_w 313
    //   80: invokevirtual 317	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   83: invokevirtual 321	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   86: invokespecial 324	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   89: invokespecial 327	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 330	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +78 -> 177
    //   102: aload_0
    //   103: ldc_w 332
    //   106: invokevirtual 74	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: ifeq -16 -> 93
    //   112: aload_0
    //   113: ldc_w 334
    //   116: invokevirtual 338	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   119: astore_0
    //   120: aload_0
    //   121: ifnull -28 -> 93
    //   124: aload_0
    //   125: arraylength
    //   126: iconst_2
    //   127: if_icmpne -34 -> 93
    //   130: aload_0
    //   131: iconst_1
    //   132: aaload
    //   133: invokevirtual 341	java/lang/String:trim	()Ljava/lang/String;
    //   136: astore_0
    //   137: ldc_w 286
    //   140: ldc_w 343
    //   143: aload_0
    //   144: invokestatic 347	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   147: invokevirtual 351	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   150: invokestatic 53	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   157: istore_1
    //   158: aload_2
    //   159: invokevirtual 352	java/io/BufferedReader:close	()V
    //   162: aload_3
    //   163: invokevirtual 353	java/util/jar/JarFile:close	()V
    //   166: ldc 2
    //   168: monitorexit
    //   169: ldc_w 284
    //   172: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: iload_1
    //   176: ireturn
    //   177: aload_2
    //   178: invokevirtual 352	java/io/BufferedReader:close	()V
    //   181: aload_3
    //   182: invokevirtual 353	java/util/jar/JarFile:close	()V
    //   185: ldc 2
    //   187: monitorexit
    //   188: ldc_w 284
    //   191: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: iconst_m1
    //   195: ireturn
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_3
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 352	java/io/BufferedReader:close	()V
    //   209: aload_3
    //   210: ifnull -25 -> 185
    //   213: aload_3
    //   214: invokevirtual 353	java/util/jar/JarFile:close	()V
    //   217: goto -32 -> 185
    //   220: astore_0
    //   221: goto -36 -> 185
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_2
    //   230: ifnull +7 -> 237
    //   233: aload_2
    //   234: invokevirtual 352	java/io/BufferedReader:close	()V
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 353	java/util/jar/JarFile:close	()V
    //   245: ldc_w 284
    //   248: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_0
    //   252: athrow
    //   253: astore_0
    //   254: ldc 2
    //   256: monitorexit
    //   257: ldc_w 284
    //   260: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_0
    //   264: athrow
    //   265: astore_2
    //   266: goto -21 -> 245
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_2
    //   272: goto -43 -> 229
    //   275: astore_0
    //   276: goto -47 -> 229
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_0
    //   282: goto -81 -> 201
    //   285: astore_0
    //   286: aload_2
    //   287: astore_0
    //   288: goto -87 -> 201
    //   291: astore_0
    //   292: goto -107 -> 185
    //   295: astore_0
    //   296: goto -130 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramFile	File
    //   157	19	1	i	int
    //   92	142	2	localBufferedReader	java.io.BufferedReader
    //   265	1	2	localException	Exception
    //   271	16	2	localObject	Object
    //   66	176	3	localJarFile	java.util.jar.JarFile
    // Exception table:
    //   from	to	target	type
    //   58	67	196	java/lang/Exception
    //   205	209	220	java/lang/Exception
    //   213	217	220	java/lang/Exception
    //   58	67	224	finally
    //   158	166	253	finally
    //   166	169	253	finally
    //   177	185	253	finally
    //   185	188	253	finally
    //   205	209	253	finally
    //   213	217	253	finally
    //   233	237	253	finally
    //   241	245	253	finally
    //   245	253	253	finally
    //   233	237	265	java/lang/Exception
    //   241	245	265	java/lang/Exception
    //   67	93	269	finally
    //   93	98	275	finally
    //   102	120	275	finally
    //   124	158	275	finally
    //   67	93	279	java/lang/Exception
    //   93	98	285	java/lang/Exception
    //   102	120	285	java/lang/Exception
    //   124	158	285	java/lang/Exception
    //   177	185	291	java/lang/Exception
    //   158	166	295	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.a
 * JD-Core Version:    0.7.0.1
 */