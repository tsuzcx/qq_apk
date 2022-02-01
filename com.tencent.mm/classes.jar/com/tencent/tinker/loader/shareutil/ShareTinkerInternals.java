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
      ShareTinkerLog.e("Tinker.TinkerInternals", "tinkerId is not equal, base is " + paramContext + ", but patch is " + paramFile, new Object[0]);
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
    //   5: invokevirtual 196	java/io/File:isFile	()Z
    //   8: ifeq +12 -> 20
    //   11: aload_0
    //   12: invokevirtual 200	java/io/File:length	()J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifne +16 -> 33
    //   20: ldc 11
    //   22: ldc 202
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 181	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aconst_null
    //   32: areturn
    //   33: new 204	java/util/zip/ZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 207	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   41: astore_1
    //   42: aload_1
    //   43: ldc 209
    //   45: invokevirtual 213	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   48: astore_0
    //   49: aload_0
    //   50: ifnonnull +20 -> 70
    //   53: ldc 11
    //   55: ldc 215
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 181	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_1
    //   65: invokestatic 221	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_1
    //   71: aload_0
    //   72: invokevirtual 225	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore_0
    //   76: new 227	java/util/Properties
    //   79: dup
    //   80: invokespecial 228	java/util/Properties:<init>	()V
    //   83: astore_2
    //   84: aload_2
    //   85: aload_0
    //   86: invokevirtual 232	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   89: aload_0
    //   90: invokestatic 236	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   93: aload_1
    //   94: invokestatic 221	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   97: aload_2
    //   98: areturn
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: invokestatic 236	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_2
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: astore_1
    //   113: ldc 11
    //   115: new 72	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 238
    //   121: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 241	java/io/IOException:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 181	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_0
    //   142: invokestatic 221	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: invokestatic 221	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   154: aload_0
    //   155: athrow
    //   156: astore_0
    //   157: goto -7 -> 150
    //   160: astore_1
    //   161: aload_0
    //   162: astore_2
    //   163: aload_1
    //   164: astore_0
    //   165: aload_2
    //   166: astore_1
    //   167: goto -17 -> 150
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_0
    //   173: goto -60 -> 113
    //   176: astore_2
    //   177: goto -75 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramFile	File
    //   41	110	1	localObject1	Object
    //   160	4	1	localObject2	Object
    //   166	1	1	localObject3	Object
    //   170	1	1	localIOException1	java.io.IOException
    //   83	15	2	localProperties	java.util.Properties
    //   99	8	2	localObject4	Object
    //   108	4	2	localIOException2	java.io.IOException
    //   162	4	2	localFile	File
    //   176	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   70	76	99	finally
    //   42	49	108	java/io/IOException
    //   53	64	108	java/io/IOException
    //   89	93	108	java/io/IOException
    //   102	108	108	java/io/IOException
    //   33	42	147	finally
    //   42	49	156	finally
    //   53	64	156	finally
    //   89	93	156	finally
    //   102	108	156	finally
    //   113	141	160	finally
    //   33	42	170	java/io/IOException
    //   76	89	176	finally
  }
  
  public static String getCurrentInstructionSet()
  {
    if (currentInstructionSet != null) {
      return currentInstructionSet;
    }
    currentInstructionSet = (String)Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
    ShareTinkerLog.d("Tinker.TinkerInternals", "getCurrentInstructionSet:" + currentInstructionSet, new Object[0]);
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
      ShareTinkerLog.e("Tinker.TinkerInternals", "getManifestTinkerID exception:" + paramContext.getMessage(), new Object[0]);
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
    //   0: invokestatic 349	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +7 -> 16
    //   12: ldc_w 282
    //   15: areturn
    //   16: aload_0
    //   17: ldc_w 351
    //   20: invokevirtual 354	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 356	android/app/ActivityManager
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +90 -> 118
    //   31: aload_0
    //   32: invokevirtual 360	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +81 -> 118
    //   40: aload_0
    //   41: invokeinterface 366 1 0
    //   46: astore 4
    //   48: aload 4
    //   50: invokeinterface 371 1 0
    //   55: ifeq +254 -> 309
    //   58: aload 4
    //   60: invokeinterface 375 1 0
    //   65: checkcast 377	android/app/ActivityManager$RunningAppProcessInfo
    //   68: astore_0
    //   69: aload_0
    //   70: getfield 381	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   73: iload_1
    //   74: if_icmpne -26 -> 48
    //   77: aload_0
    //   78: ifnull +40 -> 118
    //   81: aload_0
    //   82: getfield 382	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: ldc 11
    //   91: new 72	java/lang/StringBuilder
    //   94: dup
    //   95: ldc_w 384
    //   98: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 339	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 181	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: sipush 128
    //   121: newarray byte
    //   123: astore 5
    //   125: new 386	java/io/FileInputStream
    //   128: dup
    //   129: new 72	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 388
    //   136: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: iload_1
    //   140: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc_w 390
    //   146: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 391	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   155: astore 4
    //   157: aload 4
    //   159: astore_0
    //   160: aload 4
    //   162: aload 5
    //   164: invokevirtual 395	java/io/FileInputStream:read	([B)I
    //   167: istore_3
    //   168: iload_3
    //   169: ifle +43 -> 212
    //   172: iconst_0
    //   173: istore_1
    //   174: goto +140 -> 314
    //   177: aload 4
    //   179: astore_0
    //   180: new 67	java/lang/String
    //   183: dup
    //   184: aload 5
    //   186: iconst_0
    //   187: iload_2
    //   188: invokespecial 398	java/lang/String:<init>	([BII)V
    //   191: astore 5
    //   193: aload 4
    //   195: invokevirtual 401	java/io/FileInputStream:close	()V
    //   198: aload 5
    //   200: areturn
    //   201: astore_0
    //   202: aload 5
    //   204: areturn
    //   205: iload_1
    //   206: iconst_1
    //   207: iadd
    //   208: istore_1
    //   209: goto +105 -> 314
    //   212: aload 4
    //   214: invokevirtual 401	java/io/FileInputStream:close	()V
    //   217: ldc_w 282
    //   220: areturn
    //   221: astore 5
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: astore_0
    //   229: ldc 11
    //   231: new 72	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 384
    //   238: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload 5
    //   243: invokevirtual 339	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 181	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload 4
    //   261: ifnull -44 -> 217
    //   264: aload 4
    //   266: invokevirtual 401	java/io/FileInputStream:close	()V
    //   269: goto -52 -> 217
    //   272: astore_0
    //   273: goto -56 -> 217
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_0
    //   280: aload_0
    //   281: ifnull +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 401	java/io/FileInputStream:close	()V
    //   288: aload 4
    //   290: athrow
    //   291: astore_0
    //   292: goto -75 -> 217
    //   295: astore_0
    //   296: goto -8 -> 288
    //   299: astore 4
    //   301: goto -21 -> 280
    //   304: astore 5
    //   306: goto -80 -> 226
    //   309: aconst_null
    //   310: astore_0
    //   311: goto -234 -> 77
    //   314: iload_3
    //   315: istore_2
    //   316: iload_1
    //   317: iload_3
    //   318: if_icmpge -141 -> 177
    //   321: aload 5
    //   323: iload_1
    //   324: baload
    //   325: sipush 255
    //   328: iand
    //   329: sipush 128
    //   332: if_icmpgt +10 -> 342
    //   335: aload 5
    //   337: iload_1
    //   338: baload
    //   339: ifgt -134 -> 205
    //   342: iload_1
    //   343: istore_2
    //   344: goto -167 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramContext	Context
    //   3	340	1	i	int
    //   187	157	2	j	int
    //   167	152	3	k	int
    //   46	219	4	localObject1	Object
    //   276	13	4	localObject2	Object
    //   299	1	4	localObject3	Object
    //   123	80	5	localObject4	Object
    //   221	21	5	localException1	Exception
    //   304	32	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   31	36	88	java/lang/Exception
    //   40	48	88	java/lang/Exception
    //   48	77	88	java/lang/Exception
    //   81	86	88	java/lang/Exception
    //   193	198	201	java/lang/Exception
    //   125	157	221	java/lang/Exception
    //   264	269	272	java/lang/Exception
    //   125	157	276	finally
    //   212	217	291	java/lang/Exception
    //   284	288	295	java/lang/Exception
    //   160	168	299	finally
    //   180	193	299	finally
    //   229	259	299	finally
    //   160	168	304	java/lang/Exception
    //   180	193	304	java/lang/Exception
  }
  
  public static int getSafeModeCount(Context paramContext)
  {
    String str = "tinker_own_config_".concat(String.valueOf(getProcessName(paramContext)));
    int i = paramContext.getSharedPreferences(str, 0).getInt("safe_mode_count_1.9.14.7-fix2-INTERNALv4", 0);
    ShareTinkerLog.w("Tinker.TinkerInternals", "getSafeModeCount: preferName:" + str + " count:" + i, new Object[0]);
    return i;
  }
  
  private static String getTinkerSwitchSPKey(Context paramContext)
  {
    String str = getManifestTinkerID(paramContext);
    paramContext = str;
    if (isNullOrNil(str)) {
      paramContext = "@@";
    }
    return "tinker_enable_1.9.14.7-fix2-INTERNALv4_".concat(String.valueOf(paramContext));
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
      return isARKHotRunning.booleanValue();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ShareTinkerLog.i("Tinker.TinkerInternals", "class not found exception", new Object[0]);
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        ShareTinkerLog.i("Tinker.TinkerInternals", "no such method exception", new Object[0]);
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        ShareTinkerLog.i("Tinker.TinkerInternals", "security exception", new Object[0]);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        ShareTinkerLog.i("Tinker.TinkerInternals", "illegal access exception", new Object[0]);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        ShareTinkerLog.i("Tinker.TinkerInternals", "invocation target exception", new Object[0]);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ShareTinkerLog.i("Tinker.TinkerInternals", "illegal argument exception", new Object[0]);
      }
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
    if ((paramString == null) || (paramString.equals("")) || (str == null) || (str.equals("")))
    {
      ShareTinkerLog.d("Tinker.TinkerInternals", "fingerprint empty:" + paramString + ",current:" + str, new Object[0]);
      return false;
    }
    if (paramString.equals(str))
    {
      ShareTinkerLog.d("Tinker.TinkerInternals", "same fingerprint:".concat(String.valueOf(str)), new Object[0]);
      return false;
    }
    ShareTinkerLog.d("Tinker.TinkerInternals", "system OTA,fingerprint not equal:" + paramString + "," + str, new Object[0]);
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
      ShareTinkerLog.e("Tinker.TinkerInternals", "isVmJitInternal ex:".concat(String.valueOf(localThrowable)), new Object[0]);
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
    paramContext.getSharedPreferences(str, 0).edit().putInt("safe_mode_count_1.9.14.7-fix2-INTERNALv4", paramInt).commit();
    ShareTinkerLog.w("Tinker.TinkerInternals", "setSafeModeCount: preferName:" + str + " count:" + paramInt, new Object[0]);
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