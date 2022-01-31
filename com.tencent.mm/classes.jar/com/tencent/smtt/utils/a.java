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
    AppMethodBeat.i(65165);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 23) {
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
      AppMethodBeat.o(65165);
      return i;
      bool = false;
    }
  }
  
  public static int a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(65167);
    if (!b.a(paramContext, false, paramFile).equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a"))
    {
      k.b(paramFile);
      AppMethodBeat.o(65167);
      return 0;
    }
    if (paramFile != null) {}
    label257:
    for (;;)
    {
      int i;
      try
      {
        if (paramFile.exists())
        {
          if (paramFile.getName().contains("tbs.org"))
          {
            i = c(paramFile);
            if (i > 0)
            {
              AppMethodBeat.o(65167);
              return i;
            }
            if (!TbsShareManager.isThirdPartyApp(paramContext))
            {
              boolean bool = paramFile.getAbsolutePath().contains(paramContext.getApplicationInfo().packageName);
              if (!bool)
              {
                AppMethodBeat.o(65167);
                return 0;
              }
            }
          }
          if (((Build.VERSION.SDK_INT != 23) && (Build.VERSION.SDK_INT != 25)) || (!Build.MANUFACTURER.toLowerCase().contains("mi"))) {
            break label252;
          }
          i = 1;
          TbsPVConfig.releaseInstance();
          int k = TbsPVConfig.getInstance(paramContext).getReadApk();
          if (k == 1)
          {
            i = 0;
            paramBoolean = false;
            break label257;
            label164:
            i = b(paramFile);
            if (i > 0)
            {
              AppMethodBeat.o(65167);
              return i;
            }
          }
          else
          {
            if (k != 2) {
              break label257;
            }
            AppMethodBeat.o(65167);
            return 0;
          }
        }
      }
      catch (Throwable localThrowable) {}
      label252:
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
          AppMethodBeat.o(65167);
          return i;
        }
        catch (Throwable paramContext)
        {
          AppMethodBeat.o(65167);
          return -1;
        }
        i = 0;
        break;
        if (paramBoolean) {
          break label164;
        }
      } while (i == 0);
    }
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 159
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 16
    //   7: newarray char
    //   9: astore 5
    //   11: aload 5
    //   13: dup
    //   14: iconst_0
    //   15: ldc 160
    //   17: castore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 161
    //   22: castore
    //   23: dup
    //   24: iconst_2
    //   25: ldc 162
    //   27: castore
    //   28: dup
    //   29: iconst_3
    //   30: ldc 163
    //   32: castore
    //   33: dup
    //   34: iconst_4
    //   35: ldc 164
    //   37: castore
    //   38: dup
    //   39: iconst_5
    //   40: ldc 165
    //   42: castore
    //   43: dup
    //   44: bipush 6
    //   46: ldc 166
    //   48: castore
    //   49: dup
    //   50: bipush 7
    //   52: ldc 167
    //   54: castore
    //   55: dup
    //   56: bipush 8
    //   58: ldc 168
    //   60: castore
    //   61: dup
    //   62: bipush 9
    //   64: ldc 169
    //   66: castore
    //   67: dup
    //   68: bipush 10
    //   70: ldc 170
    //   72: castore
    //   73: dup
    //   74: bipush 11
    //   76: ldc 171
    //   78: castore
    //   79: dup
    //   80: bipush 12
    //   82: ldc 172
    //   84: castore
    //   85: dup
    //   86: bipush 13
    //   88: ldc 173
    //   90: castore
    //   91: dup
    //   92: bipush 14
    //   94: ldc 174
    //   96: castore
    //   97: dup
    //   98: bipush 15
    //   100: ldc 175
    //   102: castore
    //   103: pop
    //   104: bipush 32
    //   106: newarray char
    //   108: astore 6
    //   110: ldc 177
    //   112: invokestatic 182	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   115: astore 7
    //   117: new 184	java/io/FileInputStream
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore_0
    //   126: sipush 8192
    //   129: newarray byte
    //   131: astore 8
    //   133: aload_0
    //   134: aload 8
    //   136: invokevirtual 190	java/io/FileInputStream:read	([B)I
    //   139: istore_1
    //   140: iload_1
    //   141: iconst_m1
    //   142: if_icmpeq +32 -> 174
    //   145: aload 7
    //   147: aload 8
    //   149: iconst_0
    //   150: iload_1
    //   151: invokevirtual 194	java/security/MessageDigest:update	([BII)V
    //   154: goto -21 -> 133
    //   157: astore 5
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 197	java/io/FileInputStream:close	()V
    //   167: ldc 159
    //   169: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aconst_null
    //   173: areturn
    //   174: aload 7
    //   176: invokevirtual 201	java/security/MessageDigest:digest	()[B
    //   179: astore 7
    //   181: iconst_0
    //   182: istore_1
    //   183: iconst_0
    //   184: istore_2
    //   185: goto +69 -> 254
    //   188: new 65	java/lang/String
    //   191: dup
    //   192: aload 6
    //   194: invokespecial 204	java/lang/String:<init>	([C)V
    //   197: astore 5
    //   199: aload_0
    //   200: invokevirtual 197	java/io/FileInputStream:close	()V
    //   203: ldc 159
    //   205: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload 5
    //   210: areturn
    //   211: astore 5
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 197	java/io/FileInputStream:close	()V
    //   223: ldc 159
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
  
  public static boolean a(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    AppMethodBeat.i(65163);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(65163);
      return false;
    }
    if ((paramLong > 0L) && (paramLong != paramFile.length()))
    {
      AppMethodBeat.o(65163);
      return false;
    }
    try
    {
      int i = a(paramContext, paramFile);
      if (paramInt != i)
      {
        AppMethodBeat.o(65163);
        return false;
      }
      boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, true, paramFile));
      if (!bool)
      {
        AppMethodBeat.o(65163);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(65163);
      return false;
    }
    AppMethodBeat.o(65163);
    return true;
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: ldc 213
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: new 215	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 216	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_3
    //   17: new 218	java/io/BufferedReader
    //   20: dup
    //   21: new 220	java/io/InputStreamReader
    //   24: dup
    //   25: aload_3
    //   26: aload_3
    //   27: ldc 222
    //   29: invokevirtual 226	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   32: invokevirtual 230	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   35: invokespecial 233	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   38: invokespecial 236	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_2
    //   42: aload_2
    //   43: invokevirtual 239	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +57 -> 105
    //   51: aload_0
    //   52: ldc 241
    //   54: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifeq -15 -> 42
    //   60: aload_0
    //   61: ldc 243
    //   63: invokevirtual 247	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: astore_0
    //   67: aload_0
    //   68: ifnull -26 -> 42
    //   71: aload_0
    //   72: arraylength
    //   73: iconst_2
    //   74: if_icmpne -32 -> 42
    //   77: aload_0
    //   78: iconst_1
    //   79: aaload
    //   80: invokevirtual 250	java/lang/String:trim	()Ljava/lang/String;
    //   83: invokestatic 256	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   86: istore_1
    //   87: aload_2
    //   88: invokevirtual 257	java/io/BufferedReader:close	()V
    //   91: aload_3
    //   92: invokevirtual 258	java/util/jar/JarFile:close	()V
    //   95: ldc 2
    //   97: monitorexit
    //   98: ldc 213
    //   100: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iload_1
    //   104: ireturn
    //   105: aload_2
    //   106: invokevirtual 257	java/io/BufferedReader:close	()V
    //   109: aload_3
    //   110: invokevirtual 258	java/util/jar/JarFile:close	()V
    //   113: ldc 2
    //   115: monitorexit
    //   116: ldc 213
    //   118: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 257	java/io/BufferedReader:close	()V
    //   136: aload_3
    //   137: ifnull -24 -> 113
    //   140: aload_3
    //   141: invokevirtual 258	java/util/jar/JarFile:close	()V
    //   144: goto -31 -> 113
    //   147: astore_0
    //   148: goto -35 -> 113
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_3
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 257	java/io/BufferedReader:close	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 258	java/util/jar/JarFile:close	()V
    //   172: ldc 213
    //   174: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: athrow
    //   179: astore_0
    //   180: ldc 2
    //   182: monitorexit
    //   183: ldc 213
    //   185: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_0
    //   189: athrow
    //   190: astore_2
    //   191: goto -19 -> 172
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -41 -> 156
    //   200: astore_0
    //   201: goto -45 -> 156
    //   204: astore_0
    //   205: aconst_null
    //   206: astore_0
    //   207: goto -79 -> 128
    //   210: astore_0
    //   211: aload_2
    //   212: astore_0
    //   213: goto -85 -> 128
    //   216: astore_0
    //   217: goto -104 -> 113
    //   220: astore_0
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramFile	File
    //   86	18	1	i	int
    //   41	120	2	localBufferedReader	java.io.BufferedReader
    //   190	1	2	localException	Exception
    //   196	16	2	localObject	Object
    //   16	153	3	localJarFile	java.util.jar.JarFile
    // Exception table:
    //   from	to	target	type
    //   8	17	123	java/lang/Exception
    //   132	136	147	java/lang/Exception
    //   140	144	147	java/lang/Exception
    //   8	17	151	finally
    //   87	95	179	finally
    //   95	98	179	finally
    //   105	113	179	finally
    //   113	116	179	finally
    //   132	136	179	finally
    //   140	144	179	finally
    //   160	164	179	finally
    //   168	172	179	finally
    //   172	179	179	finally
    //   180	183	179	finally
    //   160	164	190	java/lang/Exception
    //   168	172	190	java/lang/Exception
    //   17	42	194	finally
    //   42	47	200	finally
    //   51	67	200	finally
    //   71	87	200	finally
    //   17	42	204	java/lang/Exception
    //   42	47	210	java/lang/Exception
    //   51	67	210	java/lang/Exception
    //   71	87	210	java/lang/Exception
    //   105	113	216	java/lang/Exception
    //   87	95	220	java/lang/Exception
  }
  
  private static int c(File paramFile)
  {
    AppMethodBeat.i(65166);
    try
    {
      paramFile = paramFile.getParentFile();
      if (paramFile != null)
      {
        paramFile = paramFile.listFiles();
        Pattern localPattern = Pattern.compile("x5.backup(.*)");
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          if ((localPattern.matcher(localObject.getName()).find()) && (localObject.isFile()) && (localObject.exists()))
          {
            i = Integer.parseInt(localObject.getName().substring(localObject.getName().lastIndexOf(".") + 1));
            AppMethodBeat.o(65166);
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(65166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.a
 * JD-Core Version:    0.7.0.1
 */