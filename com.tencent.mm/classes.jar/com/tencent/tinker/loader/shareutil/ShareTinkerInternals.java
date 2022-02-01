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
    //   5: invokevirtual 199	java/io/File:isFile	()Z
    //   8: ifeq +12 -> 20
    //   11: aload_0
    //   12: invokevirtual 203	java/io/File:length	()J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifne +16 -> 33
    //   20: ldc 14
    //   22: ldc 205
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 184	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aconst_null
    //   32: areturn
    //   33: new 207	java/util/zip/ZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 210	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   41: astore_1
    //   42: aload_1
    //   43: ldc 212
    //   45: invokevirtual 216	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   48: astore_0
    //   49: aload_0
    //   50: ifnonnull +20 -> 70
    //   53: ldc 14
    //   55: ldc 218
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 184	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_1
    //   65: invokestatic 224	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_1
    //   71: aload_0
    //   72: invokevirtual 228	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore_0
    //   76: new 230	java/util/Properties
    //   79: dup
    //   80: invokespecial 231	java/util/Properties:<init>	()V
    //   83: astore_2
    //   84: aload_2
    //   85: aload_0
    //   86: invokevirtual 235	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   89: aload_0
    //   90: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   93: aload_1
    //   94: invokestatic 224	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   97: aload_2
    //   98: areturn
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_2
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: astore_1
    //   113: ldc 14
    //   115: new 75	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 241
    //   121: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 244	java/io/IOException:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 184	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_0
    //   142: invokestatic 224	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: invokestatic 224	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
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
    //   0: invokestatic 352	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +7 -> 16
    //   12: ldc_w 285
    //   15: areturn
    //   16: aload_0
    //   17: ldc_w 354
    //   20: invokevirtual 357	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 359	android/app/ActivityManager
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +90 -> 118
    //   31: aload_0
    //   32: invokevirtual 363	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +81 -> 118
    //   40: aload_0
    //   41: invokeinterface 369 1 0
    //   46: astore 4
    //   48: aload 4
    //   50: invokeinterface 374 1 0
    //   55: ifeq +254 -> 309
    //   58: aload 4
    //   60: invokeinterface 378 1 0
    //   65: checkcast 380	android/app/ActivityManager$RunningAppProcessInfo
    //   68: astore_0
    //   69: aload_0
    //   70: getfield 384	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   73: iload_1
    //   74: if_icmpne -26 -> 48
    //   77: aload_0
    //   78: ifnull +40 -> 118
    //   81: aload_0
    //   82: getfield 385	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: ldc 14
    //   91: new 75	java/lang/StringBuilder
    //   94: dup
    //   95: ldc_w 387
    //   98: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 184	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: sipush 128
    //   121: newarray byte
    //   123: astore 5
    //   125: new 389	java/io/FileInputStream
    //   128: dup
    //   129: new 75	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 391
    //   136: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: iload_1
    //   140: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc_w 393
    //   146: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 394	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   155: astore 4
    //   157: aload 4
    //   159: astore_0
    //   160: aload 4
    //   162: aload 5
    //   164: invokevirtual 398	java/io/FileInputStream:read	([B)I
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
    //   188: invokespecial 401	java/lang/String:<init>	([BII)V
    //   191: astore 5
    //   193: aload 4
    //   195: invokevirtual 404	java/io/FileInputStream:close	()V
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
    //   214: invokevirtual 404	java/io/FileInputStream:close	()V
    //   217: ldc_w 285
    //   220: areturn
    //   221: astore 5
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: astore_0
    //   229: ldc 14
    //   231: new 75	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 387
    //   238: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload 5
    //   243: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 184	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload 4
    //   261: ifnull -44 -> 217
    //   264: aload 4
    //   266: invokevirtual 404	java/io/FileInputStream:close	()V
    //   269: goto -52 -> 217
    //   272: astore_0
    //   273: goto -56 -> 217
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_0
    //   280: aload_0
    //   281: ifnull +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 404	java/io/FileInputStream:close	()V
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
  
  /* Error */
  public static int getSafeModeCount(Context paramContext)
  {
    // Byte code:
    //   0: ldc 11
    //   2: aload_0
    //   3: invokestatic 408	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   6: invokestatic 339	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9: invokevirtual 411	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_3
    //   13: new 196	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokestatic 415	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   21: aload_3
    //   22: invokespecial 418	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   25: astore_2
    //   26: aconst_null
    //   27: astore_0
    //   28: new 420	java/io/DataInputStream
    //   31: dup
    //   32: new 389	java/io/FileInputStream
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 421	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 423	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 426	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   48: astore_0
    //   49: ldc_w 428
    //   52: aload_0
    //   53: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifne +31 -> 87
    //   59: ldc 14
    //   61: ldc_w 430
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: ldc_w 428
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_0
    //   77: aastore
    //   78: invokestatic 433	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_2
    //   82: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload_2
    //   88: invokevirtual 436	java/io/DataInputStream:readInt	()I
    //   91: istore_1
    //   92: ldc 14
    //   94: ldc_w 438
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: iload_1
    //   104: invokestatic 443	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: invokestatic 446	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_2
    //   112: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   115: iload_1
    //   116: ireturn
    //   117: astore_2
    //   118: ldc 14
    //   120: new 75	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 448
    //   127: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_3
    //   131: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 450
    //   137: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 433	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_0
    //   151: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   163: aload_0
    //   164: athrow
    //   165: astore_0
    //   166: goto -7 -> 159
    //   169: astore_3
    //   170: aload_0
    //   171: astore_2
    //   172: aload_3
    //   173: astore_0
    //   174: goto -15 -> 159
    //   177: astore_0
    //   178: aload_2
    //   179: astore_0
    //   180: goto -62 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramContext	Context
    //   91	25	1	i	int
    //   25	87	2	localObject1	Object
    //   117	1	2	localThrowable	Throwable
    //   158	21	2	localObject2	Object
    //   12	119	3	str	String
    //   169	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	44	117	java/lang/Throwable
    //   28	44	156	finally
    //   44	81	165	finally
    //   87	111	165	finally
    //   118	150	169	finally
    //   44	81	177	java/lang/Throwable
    //   87	111	177	java/lang/Throwable
  }
  
  private static String getTinkerSwitchSPKey(Context paramContext)
  {
    String str = getManifestTinkerID(paramContext);
    paramContext = str;
    if (isNullOrNil(str)) {
      paramContext = "@@";
    }
    return "tinker_enable_1.9.14.7-fix7-INTERNALv4_".concat(String.valueOf(paramContext));
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
  
  /* Error */
  public static void setSafeModeCount(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 11
    //   2: aload_0
    //   3: invokestatic 408	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   6: invokestatic 339	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9: invokevirtual 411	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_3
    //   13: new 196	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokestatic 415	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   21: aload_3
    //   22: invokespecial 418	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 635	java/io/File:exists	()Z
    //   30: ifne +11 -> 41
    //   33: aload_0
    //   34: invokevirtual 639	java/io/File:getParentFile	()Ljava/io/File;
    //   37: invokevirtual 642	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: new 644	java/io/DataOutputStream
    //   44: dup
    //   45: new 646	java/io/FileOutputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 647	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 648	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_0
    //   59: aload_2
    //   60: ldc_w 428
    //   63: invokevirtual 651	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: iload_1
    //   70: invokevirtual 654	java/io/DataOutputStream:writeInt	(I)V
    //   73: aload_2
    //   74: astore_0
    //   75: ldc 14
    //   77: ldc_w 656
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: iload_1
    //   87: invokestatic 443	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 446	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_2
    //   95: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   98: return
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: astore_0
    //   104: ldc 14
    //   106: new 75	java/lang/StringBuilder
    //   109: dup
    //   110: ldc_w 658
    //   113: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_3
    //   117: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 450
    //   123: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 433	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_2
    //   137: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   140: return
    //   141: astore_0
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_2
    //   145: invokestatic 239	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   148: aload_0
    //   149: athrow
    //   150: astore_2
    //   151: aload_0
    //   152: astore_3
    //   153: aload_2
    //   154: astore_0
    //   155: aload_3
    //   156: astore_2
    //   157: goto -13 -> 144
    //   160: astore_0
    //   161: goto -59 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramContext	Context
    //   0	164	1	paramInt	int
    //   56	89	2	localDataOutputStream	java.io.DataOutputStream
    //   150	4	2	localObject1	Object
    //   156	1	2	localObject2	Object
    //   12	144	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   41	57	99	java/lang/Throwable
    //   41	57	141	finally
    //   59	66	150	finally
    //   68	73	150	finally
    //   75	94	150	finally
    //   104	136	150	finally
    //   59	66	160	java/lang/Throwable
    //   68	73	160	java/lang/Throwable
    //   75	94	160	java/lang/Throwable
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