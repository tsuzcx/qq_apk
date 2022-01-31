package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShareTinkerInternals
{
  private static final boolean Bwm = axg(System.getProperty("java.vm.version"));
  private static final boolean Bwn = dWI();
  private static Boolean Bwo = null;
  private static String Bwp = null;
  private static String Bwq = null;
  private static String processName = null;
  
  /* Error */
  public static java.util.Properties S(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 56	java/io/File:isFile	()Z
    //   4: ifeq +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 60	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 62	java/util/zip/ZipFile
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 65	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_1
    //   28: ldc 67
    //   30: invokevirtual 71	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnonnull +9 -> 44
    //   38: aload_1
    //   39: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   42: aconst_null
    //   43: areturn
    //   44: aload_1
    //   45: aload_0
    //   46: invokevirtual 81	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   49: astore_0
    //   50: new 83	java/util/Properties
    //   53: dup
    //   54: invokespecial 84	java/util/Properties:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: aload_0
    //   60: invokevirtual 88	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   63: aload_0
    //   64: invokestatic 92	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   67: aload_1
    //   68: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   71: aload_2
    //   72: areturn
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 92	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   80: aload_2
    //   81: athrow
    //   82: astore_2
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: new 94	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 96
    //   93: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_1
    //   97: invokevirtual 103	java/io/IOException:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_0
    //   105: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: goto -7 -> 113
    //   123: astore_1
    //   124: aload_0
    //   125: astore_2
    //   126: aload_1
    //   127: astore_0
    //   128: aload_2
    //   129: astore_1
    //   130: goto -17 -> 113
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: goto -49 -> 87
    //   139: astore_2
    //   140: goto -64 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramFile	File
    //   26	88	1	localObject1	Object
    //   123	4	1	localObject2	Object
    //   129	1	1	localObject3	Object
    //   133	1	1	localIOException1	java.io.IOException
    //   57	15	2	localProperties	java.util.Properties
    //   73	8	2	localObject4	Object
    //   82	4	2	localIOException2	java.io.IOException
    //   125	4	2	localFile	File
    //   139	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	73	finally
    //   27	34	82	java/io/IOException
    //   63	67	82	java/io/IOException
    //   76	82	82	java/io/IOException
    //   18	27	110	finally
    //   27	34	119	finally
    //   63	67	119	finally
    //   76	82	119	finally
    //   87	104	123	finally
    //   18	27	133	java/io/IOException
    //   50	63	139	finally
  }
  
  public static boolean Te(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean Tf(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean Tg(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static String Th(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 3: 
      return "dex";
    case 4: 
      return "dex_opt";
    case 5: 
      return "lib";
    case 1: 
      return "patch_file";
    case 2: 
      return "patch_info";
    }
    return "resource";
  }
  
  public static boolean Ti(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static int a(Context paramContext, int paramInt, File paramFile, ShareSecurityCheck paramShareSecurityCheck)
  {
    int i;
    int j;
    if (!paramShareSecurityCheck.at(paramFile))
    {
      i = -1;
      j = i;
      if (i == 0)
      {
        if (paramInt != 7) {
          break label159;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        paramContext = paramShareSecurityCheck.Bwk;
        if ((!Te(paramInt)) && (paramContext.containsKey("assets/dex_meta.txt")))
        {
          j = -9;
          return j;
          paramContext = jC(paramContext);
          if (paramContext == null)
          {
            i = -5;
            break;
          }
          paramFile = paramShareSecurityCheck.dWD();
          if (paramFile == null)
          {
            i = -2;
            break;
          }
          paramFile = (String)paramFile.get("TINKER_ID");
          if (paramFile == null)
          {
            i = -6;
            break;
          }
          if (!paramContext.equals(paramFile))
          {
            new StringBuilder("tinkerId is not equal, base is ").append(paramContext).append(", but patch is ").append(paramFile);
            i = -7;
            break;
          }
          i = 0;
          break;
          label159:
          i = 0;
          continue;
        }
        if ((!Tf(paramInt)) && (paramContext.containsKey("assets/so_meta.txt"))) {
          return -9;
        }
        if ((!Tg(paramInt)) && (paramContext.containsKey("assets/res_meta.txt"))) {
          return -9;
        }
      }
    }
    return 0;
  }
  
  public static ShareDexDiffPatchInfo a(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo, int paramInt)
  {
    if (paramShareDexDiffPatchInfo.BuQ.startsWith("test.dex"))
    {
      if (paramInt != 1) {}
      for (String str = "classes" + paramInt + ".dex";; str = "classes.dex") {
        return new ShareDexDiffPatchInfo(str, paramShareDexDiffPatchInfo.path, paramShareDexDiffPatchInfo.BuR, paramShareDexDiffPatchInfo.BuS, paramShareDexDiffPatchInfo.BuV, paramShareDexDiffPatchInfo.BuT, paramShareDexDiffPatchInfo.BuU, paramShareDexDiffPatchInfo.BuW);
      }
    }
    return null;
  }
  
  public static void aG(Context paramContext, int paramInt)
  {
    String str = "tinker_own_config_".concat(String.valueOf(aI(paramContext)));
    paramContext.getSharedPreferences(str, 0).edit().putInt("safe_mode_count_1.9.13.1", paramInt).commit();
    new StringBuilder("setSafeModeCount: preferName:").append(str).append(" count:").append(paramInt);
  }
  
  public static String aI(Context paramContext)
  {
    if (processName != null) {
      return processName;
    }
    paramContext = aJ(paramContext);
    processName = paramContext;
    return paramContext;
  }
  
  /* Error */
  private static String aJ(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 279	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +7 -> 16
    //   12: ldc_w 281
    //   15: areturn
    //   16: aload_0
    //   17: ldc_w 283
    //   20: invokevirtual 287	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 289	android/app/ActivityManager
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +79 -> 107
    //   31: aload_0
    //   32: invokevirtual 293	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +70 -> 107
    //   40: aload_0
    //   41: invokeinterface 299 1 0
    //   46: astore 4
    //   48: aload 4
    //   50: invokeinterface 304 1 0
    //   55: ifeq +232 -> 287
    //   58: aload 4
    //   60: invokeinterface 308 1 0
    //   65: checkcast 310	android/app/ActivityManager$RunningAppProcessInfo
    //   68: astore_0
    //   69: aload_0
    //   70: getfield 314	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   73: iload_1
    //   74: if_icmpne -26 -> 48
    //   77: aload_0
    //   78: ifnull +29 -> 107
    //   81: aload_0
    //   82: getfield 315	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: new 94	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 317
    //   96: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: sipush 128
    //   110: newarray byte
    //   112: astore 5
    //   114: new 320	java/io/FileInputStream
    //   117: dup
    //   118: new 94	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 322
    //   125: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: iload_1
    //   129: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc_w 324
    //   135: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   144: astore 4
    //   146: aload 4
    //   148: astore_0
    //   149: aload 4
    //   151: aload 5
    //   153: invokevirtual 329	java/io/FileInputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: ifle +43 -> 201
    //   161: iconst_0
    //   162: istore_1
    //   163: goto +129 -> 292
    //   166: aload 4
    //   168: astore_0
    //   169: new 165	java/lang/String
    //   172: dup
    //   173: aload 5
    //   175: iconst_0
    //   176: iload_2
    //   177: invokespecial 332	java/lang/String:<init>	([BII)V
    //   180: astore 5
    //   182: aload 4
    //   184: invokevirtual 335	java/io/FileInputStream:close	()V
    //   187: aload 5
    //   189: areturn
    //   190: astore_0
    //   191: aload 5
    //   193: areturn
    //   194: iload_1
    //   195: iconst_1
    //   196: iadd
    //   197: istore_1
    //   198: goto +94 -> 292
    //   201: aload 4
    //   203: invokevirtual 335	java/io/FileInputStream:close	()V
    //   206: ldc_w 281
    //   209: areturn
    //   210: astore 5
    //   212: aconst_null
    //   213: astore 4
    //   215: aload 4
    //   217: astore_0
    //   218: new 94	java/lang/StringBuilder
    //   221: dup
    //   222: ldc_w 317
    //   225: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload 5
    //   230: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 4
    //   239: ifnull -33 -> 206
    //   242: aload 4
    //   244: invokevirtual 335	java/io/FileInputStream:close	()V
    //   247: goto -41 -> 206
    //   250: astore_0
    //   251: goto -45 -> 206
    //   254: astore 4
    //   256: aconst_null
    //   257: astore_0
    //   258: aload_0
    //   259: ifnull +7 -> 266
    //   262: aload_0
    //   263: invokevirtual 335	java/io/FileInputStream:close	()V
    //   266: aload 4
    //   268: athrow
    //   269: astore_0
    //   270: goto -64 -> 206
    //   273: astore_0
    //   274: goto -8 -> 266
    //   277: astore 4
    //   279: goto -21 -> 258
    //   282: astore 5
    //   284: goto -69 -> 215
    //   287: aconst_null
    //   288: astore_0
    //   289: goto -212 -> 77
    //   292: iload_3
    //   293: istore_2
    //   294: iload_1
    //   295: iload_3
    //   296: if_icmpge -130 -> 166
    //   299: aload 5
    //   301: iload_1
    //   302: baload
    //   303: sipush 255
    //   306: iand
    //   307: sipush 128
    //   310: if_icmpgt +10 -> 320
    //   313: aload 5
    //   315: iload_1
    //   316: baload
    //   317: ifgt -123 -> 194
    //   320: iload_1
    //   321: istore_2
    //   322: goto -156 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramContext	Context
    //   3	318	1	i	int
    //   176	146	2	j	int
    //   156	141	3	k	int
    //   46	197	4	localObject1	Object
    //   254	13	4	localObject2	Object
    //   277	1	4	localObject3	Object
    //   112	80	5	localObject4	Object
    //   210	19	5	localException1	Exception
    //   282	32	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   31	36	88	java/lang/Exception
    //   40	48	88	java/lang/Exception
    //   48	77	88	java/lang/Exception
    //   81	86	88	java/lang/Exception
    //   182	187	190	java/lang/Exception
    //   114	146	210	java/lang/Exception
    //   242	247	250	java/lang/Exception
    //   114	146	254	finally
    //   201	206	269	java/lang/Exception
    //   262	266	273	java/lang/Exception
    //   149	157	277	finally
    //   169	182	277	finally
    //   218	237	277	finally
    //   149	157	282	java/lang/Exception
    //   169	182	282	java/lang/Exception
  }
  
  private static String apn(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    label66:
    for (;;)
    {
      return paramString;
      char[] arrayOfChar = paramString.toCharArray();
      if (arrayOfChar == null) {
        return null;
      }
      int i = 0;
      if (i < arrayOfChar.length) {
        if (arrayOfChar[i] > '') {
          arrayOfChar[i] = '\000';
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label66;
        }
        return new String(arrayOfChar, 0, i);
        i += 1;
        break;
      }
    }
  }
  
  public static boolean axf(String paramString)
  {
    String str = Build.FINGERPRINT;
    if ((paramString == null) || (paramString.equals("")) || (str == null) || (str.equals(""))) {
      new StringBuilder("fingerprint empty:").append(paramString).append(",current:").append(str);
    }
    while (paramString.equals(str)) {
      return false;
    }
    new StringBuilder("system OTA,fingerprint not equal:").append(paramString).append(",").append(str);
    return true;
  }
  
  private static boolean axg(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!paramString.matches()) {}
    }
    try
    {
      int i = Integer.parseInt(paramString.group(1));
      int j = Integer.parseInt(paramString.group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j <= 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public static String cg(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.equals("changing"))
    {
      if (jH(paramContext)) {
        str = "odex";
      }
    }
    else {
      return str;
    }
    return "interpet";
  }
  
  public static boolean dWE()
  {
    return (Bwm) || (Build.VERSION.SDK_INT >= 21);
  }
  
  public static boolean dWF()
  {
    return (Bwn) && (Build.VERSION.SDK_INT < 24);
  }
  
  public static boolean dWG()
  {
    return Build.VERSION.SDK_INT > 25;
  }
  
  public static String dWH()
  {
    if (Bwq != null) {
      return Bwq;
    }
    Bwq = (String)Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
    new StringBuilder("getCurrentInstructionSet:").append(Bwq);
    return Bwq;
  }
  
  private static boolean dWI()
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      String str = (String)((Method)localObject).invoke(null, new Object[] { "dalvik.vm.usejit" });
      localObject = (String)((Method)localObject).invoke(null, new Object[] { "dalvik.vm.usejitprofiles" });
      if ((!isNullOrNil(str)) && (isNullOrNil((String)localObject)))
      {
        boolean bool = str.equals("true");
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("isVmJitInternal ex:").append(localThrowable);
    }
    return false;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  private static String jC(Context paramContext)
  {
    if (Bwp != null) {
      return Bwp;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("TINKER_ID");
      if (paramContext != null) {}
      for (Bwp = String.valueOf(paramContext);; Bwp = null) {
        return Bwp;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("getManifestTinkerID exception:").append(paramContext.getMessage());
    }
  }
  
  public static void jD(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tinker_share_config", 4);
    paramContext = jF(paramContext);
    localSharedPreferences.edit().putBoolean(paramContext, false).commit();
  }
  
  public static boolean jE(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return paramContext.getSharedPreferences("tinker_share_config", 4).getBoolean(jF(paramContext), true);
  }
  
  private static String jF(Context paramContext)
  {
    String str = jC(paramContext);
    paramContext = str;
    if (isNullOrNil(str)) {
      paramContext = "@@";
    }
    return "tinker_enable_1.9.13.1_".concat(String.valueOf(paramContext));
  }
  
  public static int jG(Context paramContext)
  {
    String str = "tinker_own_config_".concat(String.valueOf(aI(paramContext)));
    int i = paramContext.getSharedPreferences(str, 0).getInt("safe_mode_count_1.9.13.1", 0);
    new StringBuilder("getSafeModeCount: preferName:").append(str).append(" count:").append(i);
    return i;
  }
  
  public static boolean jH(Context paramContext)
  {
    String str = null;
    Object localObject = paramContext.getApplicationInfo();
    if (localObject != null) {
      str = ((ApplicationInfo)localObject).processName;
    }
    localObject = str;
    if (isNullOrNil(str)) {
      localObject = paramContext.getPackageName();
    }
    str = aI(paramContext);
    if (str != null)
    {
      paramContext = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramContext = "";
    }
    return ((String)localObject).equals(paramContext);
  }
  
  public static boolean jI(Context paramContext)
  {
    if (Bwo != null) {
      return Bwo.booleanValue();
    }
    paramContext = Boolean.valueOf(aI(paramContext).endsWith(":patch"));
    Bwo = paramContext;
    return paramContext.booleanValue();
  }
  
  public static void jJ(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if ((localRunningAppProcessInfo.uid == Process.myUid()) && (localRunningAppProcessInfo.pid != Process.myPid())) {
            Process.killProcess(localRunningAppProcessInfo.pid);
          }
        }
      }
    }
  }
  
  public static void jK(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if ((localRunningAppProcessInfo.uid == Process.myUid()) && (!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()))) {
            Process.killProcess(localRunningAppProcessInfo.pid);
          }
        }
      }
    }
  }
  
  public static String m(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    try
    {
      for (;;)
      {
        Throwable localThrowable = paramThrowable.getCause();
        if (localThrowable == null) {
          break;
        }
        paramThrowable = localThrowable;
      }
      paramThrowable.printStackTrace(localPrintStream);
      paramThrowable = apn(localByteArrayOutputStream.toString());
      return paramThrowable;
    }
    finally
    {
      SharePatchFileUtil.V(localPrintStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareTinkerInternals
 * JD-Core Version:    0.7.0.1
 */