package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
  private static final String SAFEMODE_COUNT_REC_PREFIX = "safemode_count_rec_";
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
      ShareTinkerLog.e("Tinker.TinkerInternals", "tinkerId in patch is not matched with the one in base pack, base: %s, patch: %s.", new Object[] { paramContext, paramFile });
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
  
  public static void cleanPatch(Application paramApplication)
  {
    if (paramApplication == null) {
      throw new TinkerRuntimeException("app is null");
    }
    File localFile = SharePatchFileUtil.getPatchDirectory(paramApplication);
    if (!localFile.exists()) {
      ShareTinkerLog.printErrStackTrace("Tinker.TinkerInternals", new Throwable(), "try to clean patch while there're not any applied patches.", new Object[0]);
    }
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      paramApplication = SharePatchFileUtil.getPatchInfoFile(localFile.getAbsolutePath());
      if (!paramApplication.exists())
      {
        ShareTinkerLog.printErrStackTrace("Tinker.TinkerInternals", new Throwable(), "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile = SharePatchFileUtil.getPatchInfoLockFile(localFile.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(paramApplication, localFile);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(paramApplication, localSharePatchInfo, localFile);
  }
  
  /* Error */
  public static java.util.Properties fastGetPatchPackageMeta(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +19 -> 20
    //   4: aload_0
    //   5: invokevirtual 247	java/io/File:isFile	()Z
    //   8: ifeq +12 -> 20
    //   11: aload_0
    //   12: invokevirtual 251	java/io/File:length	()J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifne +16 -> 33
    //   20: ldc 14
    //   22: ldc 253
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 182	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aconst_null
    //   32: areturn
    //   33: new 255	java/util/zip/ZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 258	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   41: astore_1
    //   42: aload_1
    //   43: ldc_w 260
    //   46: invokevirtual 264	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnonnull +21 -> 72
    //   54: ldc 14
    //   56: ldc_w 266
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 182	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload_1
    //   67: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_1
    //   73: aload_0
    //   74: invokevirtual 274	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   77: astore_0
    //   78: new 276	java/util/Properties
    //   81: dup
    //   82: invokespecial 277	java/util/Properties:<init>	()V
    //   85: astore_2
    //   86: aload_2
    //   87: aload_0
    //   88: invokevirtual 281	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   91: aload_0
    //   92: invokestatic 285	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   95: aload_1
    //   96: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 285	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: astore_1
    //   115: ldc 14
    //   117: new 75	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 287
    //   124: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_1
    //   128: invokevirtual 290	java/io/IOException:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 182	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload_0
    //   145: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_1
    //   154: invokestatic 270	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: goto -7 -> 153
    //   163: astore_1
    //   164: aload_0
    //   165: astore_2
    //   166: aload_1
    //   167: astore_0
    //   168: aload_2
    //   169: astore_1
    //   170: goto -17 -> 153
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_0
    //   176: goto -61 -> 115
    //   179: astore_2
    //   180: goto -76 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramFile	File
    //   41	113	1	localObject1	Object
    //   163	4	1	localObject2	Object
    //   169	1	1	localObject3	Object
    //   173	1	1	localIOException1	java.io.IOException
    //   85	15	2	localProperties	java.util.Properties
    //   101	8	2	localObject4	Object
    //   110	4	2	localIOException2	java.io.IOException
    //   165	4	2	localFile	File
    //   179	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   72	78	101	finally
    //   42	50	110	java/io/IOException
    //   54	66	110	java/io/IOException
    //   91	95	110	java/io/IOException
    //   104	110	110	java/io/IOException
    //   33	42	150	finally
    //   42	50	159	finally
    //   54	66	159	finally
    //   91	95	159	finally
    //   104	110	159	finally
    //   115	144	163	finally
    //   33	42	173	java/io/IOException
    //   78	91	179	finally
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
    //   0: invokestatic 396	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +7 -> 16
    //   12: ldc_w 331
    //   15: areturn
    //   16: aload_0
    //   17: ldc_w 398
    //   20: invokevirtual 401	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 403	android/app/ActivityManager
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +90 -> 118
    //   31: aload_0
    //   32: invokevirtual 407	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +81 -> 118
    //   40: aload_0
    //   41: invokeinterface 413 1 0
    //   46: astore 4
    //   48: aload 4
    //   50: invokeinterface 418 1 0
    //   55: ifeq +254 -> 309
    //   58: aload 4
    //   60: invokeinterface 422 1 0
    //   65: checkcast 424	android/app/ActivityManager$RunningAppProcessInfo
    //   68: astore_0
    //   69: aload_0
    //   70: getfield 428	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   73: iload_1
    //   74: if_icmpne -26 -> 48
    //   77: aload_0
    //   78: ifnull +40 -> 118
    //   81: aload_0
    //   82: getfield 429	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: ldc 14
    //   91: new 75	java/lang/StringBuilder
    //   94: dup
    //   95: ldc_w 431
    //   98: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 386	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 182	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: sipush 128
    //   121: newarray byte
    //   123: astore 5
    //   125: new 433	java/io/FileInputStream
    //   128: dup
    //   129: new 75	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 435
    //   136: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: iload_1
    //   140: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc_w 437
    //   146: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 438	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   155: astore 4
    //   157: aload 4
    //   159: astore_0
    //   160: aload 4
    //   162: aload 5
    //   164: invokevirtual 442	java/io/FileInputStream:read	([B)I
    //   167: istore_3
    //   168: iload_3
    //   169: ifle +43 -> 212
    //   172: iconst_0
    //   173: istore_1
    //   174: goto +140 -> 314
    //   177: aload 4
    //   179: astore_0
    //   180: new 70	java/lang/String
    //   183: dup
    //   184: aload 5
    //   186: iconst_0
    //   187: iload_2
    //   188: invokespecial 445	java/lang/String:<init>	([BII)V
    //   191: astore 5
    //   193: aload 4
    //   195: invokevirtual 448	java/io/FileInputStream:close	()V
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
    //   214: invokevirtual 448	java/io/FileInputStream:close	()V
    //   217: ldc_w 331
    //   220: areturn
    //   221: astore 5
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: astore_0
    //   229: ldc 14
    //   231: new 75	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 431
    //   238: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload 5
    //   243: invokevirtual 386	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 182	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload 4
    //   261: ifnull -44 -> 217
    //   264: aload 4
    //   266: invokevirtual 448	java/io/FileInputStream:close	()V
    //   269: goto -52 -> 217
    //   272: astore_0
    //   273: goto -56 -> 217
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_0
    //   280: aload_0
    //   281: ifnull +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 448	java/io/FileInputStream:close	()V
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
    str = "safemode_count_rec_".concat(String.valueOf(getProcessName(paramContext)));
    Object localObject1 = new File(SharePatchFileUtil.getPatchDirectory(paramContext), str);
    paramContext = null;
    try
    {
      localObject1 = new DataInputStream(new FileInputStream((File)localObject1));
      try
      {
        int i;
        ShareTinkerLog.w("Tinker.TinkerInternals", "getSafeModeCount: recFileName:" + str + " failed, return 0 instead.", new Object[0]);
        return 0;
      }
      finally
      {
        SharePatchFileUtil.closeQuietly(paramContext);
      }
    }
    finally
    {
      try
      {
        paramContext = ((DataInputStream)localObject1).readUTF();
        if (!"safe_mode_count_1.9.14.19-beta4".equals(paramContext))
        {
          ShareTinkerLog.w("Tinker.TinkerInternals", "getSafeModeCount: key is not equal, expt: %s, actul: %s, return 0 instead.", new Object[] { "safe_mode_count_1.9.14.19-beta4", paramContext });
          SharePatchFileUtil.closeQuietly(localObject1);
          return 0;
        }
        i = ((DataInputStream)localObject1).readInt();
        ShareTinkerLog.i("Tinker.TinkerInternals", "getSafeModeCount: count: %s", new Object[] { Integer.valueOf(i) });
        SharePatchFileUtil.closeQuietly(localObject1);
        return i;
      }
      finally
      {
        for (;;)
        {
          paramContext = localObject3;
        }
      }
      localObject2 = finally;
    }
  }
  
  private static String getTinkerSwitchSPKey(Context paramContext)
  {
    String str = getManifestTinkerID(paramContext);
    paramContext = str;
    if (isNullOrNil(str)) {
      paramContext = "@@";
    }
    return "tinker_enable_1.9.14.19-beta4_".concat(String.valueOf(paramContext));
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
  
  public static boolean isNewerOrEqualThanVersion(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 23)) {
      if (Build.VERSION.SDK_INT < paramInt)
      {
        paramBoolean = bool;
        if (Build.VERSION.SDK_INT == paramInt - 1)
        {
          paramBoolean = bool;
          if (Build.VERSION.PREVIEW_SDK_INT <= 0) {}
        }
      }
      else
      {
        paramBoolean = true;
      }
    }
    do
    {
      return paramBoolean;
      paramBoolean = bool;
    } while (Build.VERSION.SDK_INT < paramInt);
    return true;
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
      Object localObject2 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      String str = (String)((Method)localObject2).invoke(null, new Object[] { "dalvik.vm.usejit" });
      localObject2 = (String)((Method)localObject2).invoke(null, new Object[] { "dalvik.vm.usejitprofiles" });
      if ((!isNullOrNil(str)) && (isNullOrNil((String)localObject2)))
      {
        boolean bool = str.equals("true");
        if (bool) {
          return true;
        }
      }
    }
    finally
    {
      ShareTinkerLog.e("Tinker.TinkerInternals", "isVmJitInternal ex:".concat(String.valueOf(localObject1)), new Object[0]);
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
    str = "safemode_count_rec_".concat(String.valueOf(getProcessName(paramContext)));
    paramContext = new File(SharePatchFileUtil.getPatchDirectory(paramContext), str);
    if (!paramContext.exists()) {
      paramContext.getParentFile().mkdirs();
    }
    try
    {
      paramContext = new DataOutputStream(new FileOutputStream(paramContext));
      try
      {
        ShareTinkerLog.w("Tinker.TinkerInternals", "setSafeModeCount: recFileName:" + str + " failed, return 0 instead.", new Object[0]);
        return;
      }
      finally
      {
        SharePatchFileUtil.closeQuietly(paramContext);
      }
    }
    finally
    {
      try
      {
        paramContext.writeUTF("safe_mode_count_1.9.14.19-beta4");
        paramContext.writeInt(paramInt);
        ShareTinkerLog.i("Tinker.TinkerInternals", "setSafeModeCount: count: %s", new Object[] { Integer.valueOf(paramInt) });
        SharePatchFileUtil.closeQuietly(paramContext);
        return;
      }
      finally {}
      paramContext = finally;
      paramContext = null;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareTinkerInternals
 * JD-Core Version:    0.7.0.1
 */