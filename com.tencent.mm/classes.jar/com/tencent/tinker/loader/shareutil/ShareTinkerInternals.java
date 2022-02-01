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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShareTinkerInternals
{
  private static final String PATCH_PROCESS_NAME = ":patch";
  private static final String TAG = "Tinker.TinkerInternals";
  private static final boolean VM_IS_ART = isVmArt(System.getProperty("java.vm.version"));
  private static final boolean VM_IS_JIT = isVmJitInternal();
  private static String currentInstructionSet = null;
  private static Boolean isARKHotRunning;
  private static Boolean isPatchProcess = null;
  private static String processName;
  private static String tinkerID;
  
  static
  {
    isARKHotRunning = null;
    processName = null;
    tinkerID = null;
  }
  
  public static ShareDexDiffPatchInfo changeTestDexToClassN(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo, int paramInt)
  {
    if (paramShareDexDiffPatchInfo.rawName.startsWith("test.dex"))
    {
      if (paramInt != 1) {}
      for (String str = "classes" + paramInt + ".dex";; str = "classes.dex") {
        return new ShareDexDiffPatchInfo(str, paramShareDexDiffPatchInfo.path, paramShareDexDiffPatchInfo.destMd5InDvm, paramShareDexDiffPatchInfo.destMd5InArt, paramShareDexDiffPatchInfo.dexDiffMd5, paramShareDexDiffPatchInfo.oldDexCrC, paramShareDexDiffPatchInfo.newOrPatchedDexCrC, paramShareDexDiffPatchInfo.dexMode);
      }
    }
    return null;
  }
  
  public static int checkPackageAndTinkerFlag(ShareSecurityCheck paramShareSecurityCheck, int paramInt)
  {
    if (isTinkerEnabledAll(paramInt)) {}
    do
    {
      return 0;
      paramShareSecurityCheck = paramShareSecurityCheck.getMetaContentMap();
      if ((!isTinkerEnabledForDex(paramInt)) && (paramShareSecurityCheck.containsKey("assets/dex_meta.txt"))) {
        return -9;
      }
      if ((!isTinkerEnabledForNativeLib(paramInt)) && (paramShareSecurityCheck.containsKey("assets/so_meta.txt"))) {
        return -9;
      }
    } while ((isTinkerEnabledForResource(paramInt)) || (!paramShareSecurityCheck.containsKey("assets/res_meta.txt")));
    return -9;
  }
  
  public static int checkSignatureAndTinkerID(Context paramContext, File paramFile, ShareSecurityCheck paramShareSecurityCheck)
  {
    if (!paramShareSecurityCheck.verifyPatchMetaSignature(paramFile)) {
      return -1;
    }
    paramContext = getManifestTinkerID(paramContext);
    if (paramContext == null) {
      return -5;
    }
    paramFile = paramShareSecurityCheck.getPackagePropertiesIfPresent();
    if (paramFile == null) {
      return -2;
    }
    paramFile = (String)paramFile.get("TINKER_ID");
    if (paramFile == null) {
      return -6;
    }
    if (!paramContext.equals(paramFile))
    {
      new StringBuilder("tinkerId is not equal, base is ").append(paramContext).append(", but patch is ").append(paramFile);
      return -7;
    }
    return 0;
  }
  
  public static int checkTinkerPackage(Context paramContext, int paramInt, File paramFile, ShareSecurityCheck paramShareSecurityCheck)
  {
    int j = checkSignatureAndTinkerID(paramContext, paramFile, paramShareSecurityCheck);
    int i = j;
    if (j == 0) {
      i = checkPackageAndTinkerFlag(paramShareSecurityCheck, paramInt);
    }
    return i;
  }
  
  /* Error */
  public static java.util.Properties fastGetPatchPackageMeta(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +19 -> 20
    //   4: aload_0
    //   5: invokevirtual 190	java/io/File:isFile	()Z
    //   8: ifeq +12 -> 20
    //   11: aload_0
    //   12: invokevirtual 194	java/io/File:length	()J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifne +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: new 196	java/util/zip/ZipFile
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 199	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 201
    //   34: invokevirtual 205	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   37: astore_0
    //   38: aload_0
    //   39: ifnonnull +9 -> 48
    //   42: aload_1
    //   43: invokestatic 211	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   46: aconst_null
    //   47: areturn
    //   48: aload_1
    //   49: aload_0
    //   50: invokevirtual 215	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   53: astore_0
    //   54: new 217	java/util/Properties
    //   57: dup
    //   58: invokespecial 218	java/util/Properties:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: aload_0
    //   64: invokevirtual 222	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   67: aload_0
    //   68: invokestatic 226	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   71: aload_1
    //   72: invokestatic 211	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   75: aload_2
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: invokestatic 226	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   84: aload_2
    //   85: athrow
    //   86: astore_2
    //   87: aload_1
    //   88: astore_0
    //   89: aload_2
    //   90: astore_1
    //   91: new 72	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 228
    //   97: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_0
    //   109: invokestatic 211	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: invokestatic 211	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   121: aload_0
    //   122: athrow
    //   123: astore_0
    //   124: goto -7 -> 117
    //   127: astore_1
    //   128: aload_0
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: goto -17 -> 117
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_0
    //   140: goto -49 -> 91
    //   143: astore_2
    //   144: goto -64 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramFile	File
    //   30	88	1	localObject1	Object
    //   127	4	1	localObject2	Object
    //   133	1	1	localObject3	Object
    //   137	1	1	localIOException1	java.io.IOException
    //   61	15	2	localProperties	java.util.Properties
    //   77	8	2	localObject4	Object
    //   86	4	2	localIOException2	java.io.IOException
    //   129	4	2	localFile	File
    //   143	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   48	54	77	finally
    //   31	38	86	java/io/IOException
    //   67	71	86	java/io/IOException
    //   80	86	86	java/io/IOException
    //   22	31	114	finally
    //   31	38	123	finally
    //   67	71	123	finally
    //   80	86	123	finally
    //   91	108	127	finally
    //   22	31	137	java/io/IOException
    //   54	67	143	finally
  }
  
  public static String getCurrentInstructionSet()
  {
    if (currentInstructionSet != null) {
      return currentInstructionSet;
    }
    currentInstructionSet = (String)Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
    new StringBuilder("getCurrentInstructionSet:").append(currentInstructionSet);
    return currentInstructionSet;
  }
  
  public static String getCurrentOatMode(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.equals("changing"))
    {
      if (isInMainProcess(paramContext)) {
        str = "odex";
      }
    }
    else {
      return str;
    }
    return "interpet";
  }
  
  public static String getExceptionCauseString(Throwable paramThrowable)
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
      paramThrowable = toVisualString(localByteArrayOutputStream.toString());
      return paramThrowable;
    }
    finally
    {
      SharePatchFileUtil.closeQuietly(localPrintStream);
    }
  }
  
  public static String getManifestTinkerID(Context paramContext)
  {
    if (tinkerID != null) {
      return tinkerID;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("TINKER_ID");
      if (paramContext != null) {}
      for (tinkerID = String.valueOf(paramContext);; tinkerID = null) {
        return tinkerID;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("getManifestTinkerID exception:").append(paramContext.getMessage());
    }
  }
  
  public static String getProcessName(Context paramContext)
  {
    if (processName != null) {
      return processName;
    }
    paramContext = getProcessNameInternal(paramContext);
    processName = paramContext;
    return paramContext;
  }
  
  /* Error */
  private static String getProcessNameInternal(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 336	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +7 -> 16
    //   12: ldc_w 269
    //   15: areturn
    //   16: aload_0
    //   17: ldc_w 338
    //   20: invokevirtual 341	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 343	android/app/ActivityManager
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +79 -> 107
    //   31: aload_0
    //   32: invokevirtual 347	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +70 -> 107
    //   40: aload_0
    //   41: invokeinterface 353 1 0
    //   46: astore 4
    //   48: aload 4
    //   50: invokeinterface 358 1 0
    //   55: ifeq +232 -> 287
    //   58: aload 4
    //   60: invokeinterface 362 1 0
    //   65: checkcast 364	android/app/ActivityManager$RunningAppProcessInfo
    //   68: astore_0
    //   69: aload_0
    //   70: getfield 368	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   73: iload_1
    //   74: if_icmpne -26 -> 48
    //   77: aload_0
    //   78: ifnull +29 -> 107
    //   81: aload_0
    //   82: getfield 369	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: new 72	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 371
    //   96: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 326	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: sipush 128
    //   110: newarray byte
    //   112: astore 5
    //   114: new 373	java/io/FileInputStream
    //   117: dup
    //   118: new 72	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 375
    //   125: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: iload_1
    //   129: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: ldc_w 377
    //   135: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokespecial 378	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   144: astore 4
    //   146: aload 4
    //   148: astore_0
    //   149: aload 4
    //   151: aload 5
    //   153: invokevirtual 382	java/io/FileInputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: ifle +43 -> 201
    //   161: iconst_0
    //   162: istore_1
    //   163: goto +129 -> 292
    //   166: aload 4
    //   168: astore_0
    //   169: new 67	java/lang/String
    //   172: dup
    //   173: aload 5
    //   175: iconst_0
    //   176: iload_2
    //   177: invokespecial 385	java/lang/String:<init>	([BII)V
    //   180: astore 5
    //   182: aload 4
    //   184: invokevirtual 388	java/io/FileInputStream:close	()V
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
    //   203: invokevirtual 388	java/io/FileInputStream:close	()V
    //   206: ldc_w 269
    //   209: areturn
    //   210: astore 5
    //   212: aconst_null
    //   213: astore 4
    //   215: aload 4
    //   217: astore_0
    //   218: new 72	java/lang/StringBuilder
    //   221: dup
    //   222: ldc_w 371
    //   225: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload 5
    //   230: invokevirtual 326	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 4
    //   239: ifnull -33 -> 206
    //   242: aload 4
    //   244: invokevirtual 388	java/io/FileInputStream:close	()V
    //   247: goto -41 -> 206
    //   250: astore_0
    //   251: goto -45 -> 206
    //   254: astore 4
    //   256: aconst_null
    //   257: astore_0
    //   258: aload_0
    //   259: ifnull +7 -> 266
    //   262: aload_0
    //   263: invokevirtual 388	java/io/FileInputStream:close	()V
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
  
  public static int getSafeModeCount(Context paramContext)
  {
    String str = "tinker_own_config_".concat(String.valueOf(getProcessName(paramContext)));
    int i = paramContext.getSharedPreferences(str, 0).getInt("safe_mode_count_1.9.14.6-INTERNALv1-mz", 0);
    new StringBuilder("getSafeModeCount: preferName:").append(str).append(" count:").append(i);
    return i;
  }
  
  private static String getTinkerSwitchSPKey(Context paramContext)
  {
    String str = getManifestTinkerID(paramContext);
    paramContext = str;
    if (isNullOrNil(str)) {
      paramContext = "@@";
    }
    return "tinker_enable_1.9.14.6-INTERNALv1-mz_".concat(String.valueOf(paramContext));
  }
  
  public static String getTypeString(int paramInt)
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
  
  public static boolean isAfterAndroidO()
  {
    return Build.VERSION.SDK_INT > 25;
  }
  
  public static boolean isArkHotRuning()
  {
    if (isARKHotRunning != null) {
      return isARKHotRunning.booleanValue();
    }
    isARKHotRunning = Boolean.FALSE;
    try
    {
      Method localMethod = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.app.ArkApplicationInfo").getDeclaredMethod("isRunningInArk", new Class[0]);
      localMethod.setAccessible(true);
      isARKHotRunning = (Boolean)localMethod.invoke(null, new Object[0]);
      label62:
      return isARKHotRunning.booleanValue();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label62;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label62;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label62;
    }
    catch (SecurityException localSecurityException)
    {
      break label62;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label62;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label62;
    }
  }
  
  public static boolean isInMainProcess(Context paramContext)
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
    str = getProcessName(paramContext);
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
  
  public static boolean isInPatchProcess(Context paramContext)
  {
    if (isPatchProcess != null) {
      return isPatchProcess.booleanValue();
    }
    paramContext = Boolean.valueOf(getProcessName(paramContext).endsWith(":patch"));
    isPatchProcess = paramContext;
    return paramContext.booleanValue();
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static boolean isSystemOTA(String paramString)
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
  
  public static boolean isTinkerEnableWithSharedPreferences(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return paramContext.getSharedPreferences("tinker_share_config", 4).getBoolean(getTinkerSwitchSPKey(paramContext), true);
  }
  
  public static boolean isTinkerEnabled(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static boolean isTinkerEnabledAll(int paramInt)
  {
    return paramInt == 15;
  }
  
  public static boolean isTinkerEnabledForArkHot(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean isTinkerEnabledForDex(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean isTinkerEnabledForNativeLib(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean isTinkerEnabledForResource(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean isVmArt()
  {
    return (VM_IS_ART) || (Build.VERSION.SDK_INT >= 21);
  }
  
  private static boolean isVmArt(String paramString)
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
  
  public static boolean isVmJit()
  {
    return (VM_IS_JIT) && (Build.VERSION.SDK_INT < 24);
  }
  
  private static boolean isVmJitInternal()
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
  
  public static void killAllOtherProcess(Context paramContext)
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
  
  public static void killProcessExceptMain(Context paramContext)
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
  
  public static void setSafeModeCount(Context paramContext, int paramInt)
  {
    String str = "tinker_own_config_".concat(String.valueOf(getProcessName(paramContext)));
    paramContext.getSharedPreferences(str, 0).edit().putInt("safe_mode_count_1.9.14.6-INTERNALv1-mz", paramInt).commit();
    new StringBuilder("setSafeModeCount: preferName:").append(str).append(" count:").append(paramInt);
  }
  
  public static void setTinkerDisableWithSharedPreferences(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tinker_share_config", 4);
    paramContext = getTinkerSwitchSPKey(paramContext);
    localSharedPreferences.edit().putBoolean(paramContext, false).commit();
  }
  
  public static String toVisualString(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareTinkerInternals
 * JD-Core Version:    0.7.0.1
 */