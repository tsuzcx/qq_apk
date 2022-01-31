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
  private static String processName = null;
  private static final boolean wZG = agp(System.getProperty("java.vm.version"));
  private static final boolean wZH = cQT();
  private static Boolean wZI = null;
  private static String wZJ = null;
  private static String wZK = null;
  
  /* Error */
  public static java.util.Properties K(File paramFile)
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
    //   64: invokestatic 92	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   67: aload_1
    //   68: invokestatic 77	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   71: aload_2
    //   72: areturn
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 92	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
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
  
  public static boolean Kk(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean Kl(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean Km(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static String Kn(int paramInt)
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
  
  public static boolean Ko(int paramInt)
  {
    return paramInt != 0;
  }
  
  private static String Zp(String paramString)
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
  
  public static int a(Context paramContext, int paramInt, File paramFile, ShareSecurityCheck paramShareSecurityCheck)
  {
    int i;
    int j;
    if (!paramShareSecurityCheck.al(paramFile))
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
        paramContext = paramShareSecurityCheck.wZE;
        if ((!Kk(paramInt)) && (paramContext.containsKey("assets/dex_meta.txt")))
        {
          j = -9;
          return j;
          paramContext = ib(paramContext);
          if (paramContext == null)
          {
            i = -5;
            break;
          }
          paramFile = paramShareSecurityCheck.cQO();
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
        if ((!Kl(paramInt)) && (paramContext.containsKey("assets/so_meta.txt"))) {
          return -9;
        }
        if ((!Km(paramInt)) && (paramContext.containsKey("assets/res_meta.txt"))) {
          return -9;
        }
      }
    }
    return 0;
  }
  
  public static ShareDexDiffPatchInfo a(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo, int paramInt)
  {
    if (paramShareDexDiffPatchInfo.wYm.startsWith("test.dex"))
    {
      if (paramInt != 1) {}
      for (String str = "classes" + paramInt + ".dex";; str = "classes.dex") {
        return new ShareDexDiffPatchInfo(str, paramShareDexDiffPatchInfo.path, paramShareDexDiffPatchInfo.wYn, paramShareDexDiffPatchInfo.wYo, paramShareDexDiffPatchInfo.wYr, paramShareDexDiffPatchInfo.wYp, paramShareDexDiffPatchInfo.wYq, paramShareDexDiffPatchInfo.wYs);
      }
    }
    return null;
  }
  
  public static boolean ago(String paramString)
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
  
  private static boolean agp(String paramString)
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
  
  public static String ak(Context paramContext)
  {
    if (processName != null) {
      return processName;
    }
    paramContext = al(paramContext);
    processName = paramContext;
    return paramContext;
  }
  
  /* Error */
  private static String al(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 290	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +6 -> 15
    //   12: ldc 243
    //   14: areturn
    //   15: aload_0
    //   16: ldc_w 292
    //   19: invokevirtual 298	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 300	android/app/ActivityManager
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +79 -> 106
    //   30: aload_0
    //   31: invokevirtual 304	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull +70 -> 106
    //   39: aload_0
    //   40: invokeinterface 310 1 0
    //   45: astore 4
    //   47: aload 4
    //   49: invokeinterface 315 1 0
    //   54: ifeq +231 -> 285
    //   57: aload 4
    //   59: invokeinterface 319 1 0
    //   64: checkcast 321	android/app/ActivityManager$RunningAppProcessInfo
    //   67: astore_0
    //   68: aload_0
    //   69: getfield 325	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   72: iload_1
    //   73: if_icmpne -26 -> 47
    //   76: aload_0
    //   77: ifnull +29 -> 106
    //   80: aload_0
    //   81: getfield 326	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: new 94	java/lang/StringBuilder
    //   91: dup
    //   92: ldc_w 328
    //   95: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: invokevirtual 329	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: sipush 128
    //   109: newarray byte
    //   111: astore 5
    //   113: new 331	java/io/FileInputStream
    //   116: dup
    //   117: new 94	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 333
    //   124: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: iload_1
    //   128: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: ldc_w 335
    //   134: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 336	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   143: astore 4
    //   145: aload 4
    //   147: astore_0
    //   148: aload 4
    //   150: aload 5
    //   152: invokevirtual 340	java/io/FileInputStream:read	([B)I
    //   155: istore_3
    //   156: iload_3
    //   157: ifle +43 -> 200
    //   160: iconst_0
    //   161: istore_1
    //   162: goto +128 -> 290
    //   165: aload 4
    //   167: astore_0
    //   168: new 131	java/lang/String
    //   171: dup
    //   172: aload 5
    //   174: iconst_0
    //   175: iload_2
    //   176: invokespecial 343	java/lang/String:<init>	([BII)V
    //   179: astore 5
    //   181: aload 4
    //   183: invokevirtual 346	java/io/FileInputStream:close	()V
    //   186: aload 5
    //   188: areturn
    //   189: astore_0
    //   190: aload 5
    //   192: areturn
    //   193: iload_1
    //   194: iconst_1
    //   195: iadd
    //   196: istore_1
    //   197: goto +93 -> 290
    //   200: aload 4
    //   202: invokevirtual 346	java/io/FileInputStream:close	()V
    //   205: ldc 243
    //   207: areturn
    //   208: astore 5
    //   210: aconst_null
    //   211: astore 4
    //   213: aload 4
    //   215: astore_0
    //   216: new 94	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 328
    //   223: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload 5
    //   228: invokevirtual 329	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 4
    //   237: ifnull -32 -> 205
    //   240: aload 4
    //   242: invokevirtual 346	java/io/FileInputStream:close	()V
    //   245: goto -40 -> 205
    //   248: astore_0
    //   249: goto -44 -> 205
    //   252: astore 4
    //   254: aconst_null
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +7 -> 264
    //   260: aload_0
    //   261: invokevirtual 346	java/io/FileInputStream:close	()V
    //   264: aload 4
    //   266: athrow
    //   267: astore_0
    //   268: goto -63 -> 205
    //   271: astore_0
    //   272: goto -8 -> 264
    //   275: astore 4
    //   277: goto -21 -> 256
    //   280: astore 5
    //   282: goto -69 -> 213
    //   285: aconst_null
    //   286: astore_0
    //   287: goto -211 -> 76
    //   290: iload_3
    //   291: istore_2
    //   292: iload_1
    //   293: iload_3
    //   294: if_icmpge -129 -> 165
    //   297: aload 5
    //   299: iload_1
    //   300: baload
    //   301: sipush 255
    //   304: iand
    //   305: sipush 128
    //   308: if_icmpgt +10 -> 318
    //   311: aload 5
    //   313: iload_1
    //   314: baload
    //   315: ifgt -122 -> 193
    //   318: iload_1
    //   319: istore_2
    //   320: goto -155 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramContext	Context
    //   3	316	1	i	int
    //   175	145	2	j	int
    //   155	140	3	k	int
    //   45	196	4	localObject1	Object
    //   252	13	4	localObject2	Object
    //   275	1	4	localObject3	Object
    //   111	80	5	localObject4	Object
    //   208	19	5	localException1	Exception
    //   280	32	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   30	35	87	java/lang/Exception
    //   39	47	87	java/lang/Exception
    //   47	76	87	java/lang/Exception
    //   80	85	87	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   113	145	208	java/lang/Exception
    //   240	245	248	java/lang/Exception
    //   113	145	252	finally
    //   200	205	267	java/lang/Exception
    //   260	264	271	java/lang/Exception
    //   148	156	275	finally
    //   168	181	275	finally
    //   216	235	275	finally
    //   148	156	280	java/lang/Exception
    //   168	181	280	java/lang/Exception
  }
  
  public static String bT(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.equals("changing"))
    {
      if (ie(paramContext)) {
        str = "odex";
      }
    }
    else {
      return str;
    }
    return "interpet";
  }
  
  public static boolean bl(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static boolean cQP()
  {
    return (wZG) || (Build.VERSION.SDK_INT >= 21);
  }
  
  public static boolean cQQ()
  {
    return (wZH) && (Build.VERSION.SDK_INT < 24);
  }
  
  public static boolean cQR()
  {
    return Build.VERSION.SDK_INT > 25;
  }
  
  public static String cQS()
  {
    if (wZK != null) {
      return wZK;
    }
    wZK = (String)Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
    new StringBuilder("getCurrentInstructionSet:").append(wZK);
    return wZK;
  }
  
  private static boolean cQT()
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      String str = (String)((Method)localObject).invoke(null, new Object[] { "dalvik.vm.usejit" });
      localObject = (String)((Method)localObject).invoke(null, new Object[] { "dalvik.vm.usejitprofiles" });
      if ((!bl(str)) && (bl((String)localObject)))
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
  
  private static String ib(Context paramContext)
  {
    if (wZJ != null) {
      return wZJ;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("TINKER_ID");
      if (paramContext != null) {}
      for (wZJ = String.valueOf(paramContext);; wZJ = null) {
        return wZJ;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("getManifestTinkerID exception:").append(paramContext.getMessage());
    }
  }
  
  public static void ic(Context paramContext)
  {
    paramContext.getSharedPreferences("tinker_share_config", 4).edit().putBoolean("tinker_enable_1.9.8", false).commit();
  }
  
  public static boolean id(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return paramContext.getSharedPreferences("tinker_share_config", 4).getBoolean("tinker_enable_1.9.8", true);
  }
  
  public static boolean ie(Context paramContext)
  {
    String str = null;
    Object localObject = paramContext.getApplicationInfo();
    if (localObject != null) {
      str = ((ApplicationInfo)localObject).processName;
    }
    localObject = str;
    if (bl(str)) {
      localObject = paramContext.getPackageName();
    }
    str = ak(paramContext);
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
  
  public static boolean jdMethod_if(Context paramContext)
  {
    if (wZI != null) {
      return wZI.booleanValue();
    }
    paramContext = Boolean.valueOf(ak(paramContext).endsWith(":patch"));
    wZI = paramContext;
    return paramContext.booleanValue();
  }
  
  public static void ig(Context paramContext)
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
  
  public static void ih(Context paramContext)
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
  
  public static String k(Throwable paramThrowable)
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
      paramThrowable = Zp(localByteArrayOutputStream.toString());
      return paramThrowable;
    }
    finally
    {
      SharePatchFileUtil.S(localPrintStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareTinkerInternals
 * JD-Core Version:    0.7.0.1
 */