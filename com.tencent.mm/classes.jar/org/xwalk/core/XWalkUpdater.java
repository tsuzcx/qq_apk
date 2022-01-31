package org.xwalk.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetFileDescriptor;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.e;
import com.tencent.xweb.xwalk.a.c.a;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class XWalkUpdater
{
  private static final String ANDROID_MARKET_DETAILS = "market://details?id=";
  public static final int ERROR_DOPATCH_FAILED = -3;
  public static final int ERROR_DOPATCH_MD5_FAILED = -4;
  public static final int ERROR_DOWNLOAD_FAILED = -1;
  public static final int ERROR_DOWNLOAD_MD5_FAILED = -2;
  public static final int ERROR_EXTRACT_RESOURCE_FAILED = -5;
  public static final int ERROR_EXTRACT_RESOURCE_FAILED_FOR_RETRY = -12;
  public static final int ERROR_NONE = 0;
  public static final int ERROR_SET_VERNUM = -101;
  public static final int ERROR_SHARED_MODE_EXCEED_MAX_COUNT = -7;
  public static final int ERROR_SHARED_MODE_FORCE_DOWNLOAD = -6;
  public static final int ERROR_SHARED_MODE_NO_CONTENT_RESOLVER = -8;
  public static final int ERROR_SHARED_MODE_NO_PROVIDER = -9;
  public static final int ERROR_SHARED_MODE_OTHER = -11;
  public static final int ERROR_SHARED_MODE_TRY_AGAIN = -10;
  private static final String GOOGLE_PLAY_PACKAGE = "com.android.vending";
  private static final int RES_EXTRACTOR_MAXTIMES = 1;
  private static final String TAG = "XWalkLib";
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PACKAGE = 1;
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PATCH = 2;
  private static int mCurrentTimeForRetryRes = 0;
  private XWalkUpdater.XWalkBackgroundUpdateListener mBackgroundUpdateListener;
  private Runnable mCancelCommand;
  private Context mContext;
  private XWalkDialogManager mDialogManager;
  private Runnable mDownloadCommand;
  private XWalkUpdater.XWalkUpdateListener mUpdateListener;
  
  public XWalkUpdater(XWalkUpdater.XWalkBackgroundUpdateListener paramXWalkBackgroundUpdateListener, Context paramContext)
  {
    this.mBackgroundUpdateListener = paramXWalkBackgroundUpdateListener;
    this.mContext = paramContext;
  }
  
  public XWalkUpdater(XWalkUpdater.XWalkUpdateListener paramXWalkUpdateListener, Context paramContext)
  {
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = new XWalkDialogManager(paramContext);
  }
  
  public XWalkUpdater(XWalkUpdater.XWalkUpdateListener paramXWalkUpdateListener, Context paramContext, XWalkDialogManager paramXWalkDialogManager)
  {
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = paramXWalkDialogManager;
  }
  
  /* Error */
  private static boolean checkExtractResFileLengtgAndMd5(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 109	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 116	java/io/File:exists	()Z
    //   13: ifne +26 -> 39
    //   16: ldc 62
    //   18: new 118	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 120
    //   24: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 135	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iconst_1
    //   38: ireturn
    //   39: new 137	java/io/FileInputStream
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_3
    //   48: new 142	java/io/InputStreamReader
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 145	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: astore_2
    //   57: new 147	java/io/BufferedReader
    //   60: dup
    //   61: aload_2
    //   62: invokespecial 150	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_0
    //   66: aload_0
    //   67: astore 6
    //   69: aload_2
    //   70: astore 5
    //   72: aload_3
    //   73: astore 4
    //   75: aload_0
    //   76: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 7
    //   81: aload 7
    //   83: ifnull +293 -> 376
    //   86: aload 7
    //   88: ifnull -22 -> 66
    //   91: aload_0
    //   92: astore 6
    //   94: aload_2
    //   95: astore 5
    //   97: aload_3
    //   98: astore 4
    //   100: aload 7
    //   102: invokevirtual 158	java/lang/String:isEmpty	()Z
    //   105: ifne -39 -> 66
    //   108: aload_0
    //   109: astore 6
    //   111: aload_2
    //   112: astore 5
    //   114: aload_3
    //   115: astore 4
    //   117: aload 7
    //   119: ldc 160
    //   121: invokevirtual 164	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   124: astore 7
    //   126: aload 7
    //   128: ifnull -62 -> 66
    //   131: aload_0
    //   132: astore 6
    //   134: aload_2
    //   135: astore 5
    //   137: aload_3
    //   138: astore 4
    //   140: aload 7
    //   142: arraylength
    //   143: iconst_2
    //   144: if_icmpne -78 -> 66
    //   147: aload 7
    //   149: iconst_0
    //   150: aaload
    //   151: ifnull -85 -> 66
    //   154: aload_0
    //   155: astore 6
    //   157: aload_2
    //   158: astore 5
    //   160: aload_3
    //   161: astore 4
    //   163: aload 7
    //   165: iconst_0
    //   166: aaload
    //   167: invokevirtual 158	java/lang/String:isEmpty	()Z
    //   170: ifne -104 -> 66
    //   173: aload 7
    //   175: iconst_1
    //   176: aaload
    //   177: ifnull -111 -> 66
    //   180: aload_0
    //   181: astore 6
    //   183: aload_2
    //   184: astore 5
    //   186: aload_3
    //   187: astore 4
    //   189: aload 7
    //   191: iconst_1
    //   192: aaload
    //   193: invokevirtual 158	java/lang/String:isEmpty	()Z
    //   196: ifne -130 -> 66
    //   199: aload_0
    //   200: astore 6
    //   202: aload_2
    //   203: astore 5
    //   205: aload_3
    //   206: astore 4
    //   208: new 109	java/io/File
    //   211: dup
    //   212: aload_1
    //   213: aload 7
    //   215: iconst_0
    //   216: aaload
    //   217: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: astore 8
    //   222: aload_0
    //   223: astore 6
    //   225: aload_2
    //   226: astore 5
    //   228: aload_3
    //   229: astore 4
    //   231: aload 8
    //   233: invokestatic 172	com/tencent/xweb/util/c:m	(Ljava/io/File;)Ljava/lang/String;
    //   236: astore 9
    //   238: aload_0
    //   239: astore 6
    //   241: aload_2
    //   242: astore 5
    //   244: aload_3
    //   245: astore 4
    //   247: aload 9
    //   249: aload 7
    //   251: iconst_1
    //   252: aaload
    //   253: invokevirtual 176	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   256: ifne -190 -> 66
    //   259: aload_0
    //   260: astore 6
    //   262: aload_2
    //   263: astore 5
    //   265: aload_3
    //   266: astore 4
    //   268: ldc 62
    //   270: new 118	java/lang/StringBuilder
    //   273: dup
    //   274: ldc 178
    //   276: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   279: aload 7
    //   281: iconst_0
    //   282: aaload
    //   283: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc 180
    //   288: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 7
    //   293: iconst_1
    //   294: aaload
    //   295: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc 182
    //   300: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 9
    //   305: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 135	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_0
    //   315: astore 6
    //   317: aload_2
    //   318: astore 5
    //   320: aload_3
    //   321: astore 4
    //   323: aload 8
    //   325: invokevirtual 185	java/io/File:delete	()Z
    //   328: pop
    //   329: aload_3
    //   330: invokevirtual 188	java/io/FileInputStream:close	()V
    //   333: aload_2
    //   334: invokevirtual 189	java/io/InputStreamReader:close	()V
    //   337: aload_0
    //   338: invokevirtual 190	java/io/BufferedReader:close	()V
    //   341: iconst_0
    //   342: ireturn
    //   343: astore_1
    //   344: ldc 62
    //   346: ldc 192
    //   348: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -18 -> 333
    //   354: astore_1
    //   355: ldc 62
    //   357: ldc 199
    //   359: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -25 -> 337
    //   365: astore_0
    //   366: ldc 62
    //   368: ldc 201
    //   370: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -32 -> 341
    //   376: aload_3
    //   377: invokevirtual 188	java/io/FileInputStream:close	()V
    //   380: aload_2
    //   381: invokevirtual 189	java/io/InputStreamReader:close	()V
    //   384: aload_0
    //   385: invokevirtual 190	java/io/BufferedReader:close	()V
    //   388: iconst_1
    //   389: ireturn
    //   390: astore_0
    //   391: ldc 62
    //   393: ldc 201
    //   395: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: iconst_1
    //   399: ireturn
    //   400: astore_1
    //   401: ldc 62
    //   403: ldc 192
    //   405: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: goto -28 -> 380
    //   411: astore_1
    //   412: ldc 62
    //   414: ldc 199
    //   416: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: goto -35 -> 384
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_0
    //   425: aconst_null
    //   426: astore_2
    //   427: aconst_null
    //   428: astore_3
    //   429: aload_0
    //   430: astore 6
    //   432: aload_2
    //   433: astore 5
    //   435: aload_3
    //   436: astore 4
    //   438: ldc 62
    //   440: new 118	java/lang/StringBuilder
    //   443: dup
    //   444: ldc 203
    //   446: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: aload_1
    //   450: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   453: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_3
    //   463: ifnull +7 -> 470
    //   466: aload_3
    //   467: invokevirtual 188	java/io/FileInputStream:close	()V
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 189	java/io/InputStreamReader:close	()V
    //   478: aload_0
    //   479: ifnull +7 -> 486
    //   482: aload_0
    //   483: invokevirtual 190	java/io/BufferedReader:close	()V
    //   486: iconst_0
    //   487: ireturn
    //   488: astore_1
    //   489: ldc 62
    //   491: ldc 192
    //   493: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: goto -26 -> 470
    //   499: astore_1
    //   500: ldc 62
    //   502: ldc 199
    //   504: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: goto -29 -> 478
    //   510: astore_0
    //   511: ldc 62
    //   513: ldc 201
    //   515: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: goto -32 -> 486
    //   521: astore_0
    //   522: aconst_null
    //   523: astore_1
    //   524: aconst_null
    //   525: astore_2
    //   526: aconst_null
    //   527: astore_3
    //   528: aload_3
    //   529: ifnull +7 -> 536
    //   532: aload_3
    //   533: invokevirtual 188	java/io/FileInputStream:close	()V
    //   536: aload_2
    //   537: ifnull +7 -> 544
    //   540: aload_2
    //   541: invokevirtual 189	java/io/InputStreamReader:close	()V
    //   544: aload_1
    //   545: ifnull +7 -> 552
    //   548: aload_1
    //   549: invokevirtual 190	java/io/BufferedReader:close	()V
    //   552: aload_0
    //   553: athrow
    //   554: astore_3
    //   555: ldc 62
    //   557: ldc 192
    //   559: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: goto -26 -> 536
    //   565: astore_2
    //   566: ldc 62
    //   568: ldc 199
    //   570: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: goto -29 -> 544
    //   576: astore_1
    //   577: ldc 62
    //   579: ldc 201
    //   581: invokestatic 197	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: goto -32 -> 552
    //   587: astore_0
    //   588: aconst_null
    //   589: astore_1
    //   590: aconst_null
    //   591: astore_2
    //   592: goto -64 -> 528
    //   595: astore_0
    //   596: aconst_null
    //   597: astore_1
    //   598: goto -70 -> 528
    //   601: astore_0
    //   602: aload 6
    //   604: astore_1
    //   605: aload 5
    //   607: astore_2
    //   608: aload 4
    //   610: astore_3
    //   611: goto -83 -> 528
    //   614: astore_1
    //   615: aconst_null
    //   616: astore_0
    //   617: aconst_null
    //   618: astore_2
    //   619: goto -190 -> 429
    //   622: astore_1
    //   623: aconst_null
    //   624: astore_0
    //   625: goto -196 -> 429
    //   628: astore_1
    //   629: goto -200 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	paramString1	String
    //   0	632	1	paramString2	String
    //   8	533	2	localObject1	Object
    //   565	1	2	localException1	Exception
    //   591	28	2	localObject2	Object
    //   47	486	3	localFileInputStream1	FileInputStream
    //   554	1	3	localException2	Exception
    //   610	1	3	localObject3	Object
    //   73	536	4	localFileInputStream2	FileInputStream
    //   70	536	5	localObject4	Object
    //   67	536	6	str1	String
    //   79	213	7	localObject5	Object
    //   220	104	8	localFile	File
    //   236	68	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   329	333	343	java/lang/Exception
    //   333	337	354	java/lang/Exception
    //   337	341	365	java/lang/Exception
    //   384	388	390	java/lang/Exception
    //   376	380	400	java/lang/Exception
    //   380	384	411	java/lang/Exception
    //   0	37	422	java/lang/Exception
    //   39	48	422	java/lang/Exception
    //   466	470	488	java/lang/Exception
    //   474	478	499	java/lang/Exception
    //   482	486	510	java/lang/Exception
    //   0	37	521	finally
    //   39	48	521	finally
    //   532	536	554	java/lang/Exception
    //   540	544	565	java/lang/Exception
    //   548	552	576	java/lang/Exception
    //   48	57	587	finally
    //   57	66	595	finally
    //   75	81	601	finally
    //   100	108	601	finally
    //   117	126	601	finally
    //   140	147	601	finally
    //   163	173	601	finally
    //   189	199	601	finally
    //   208	222	601	finally
    //   231	238	601	finally
    //   247	259	601	finally
    //   268	314	601	finally
    //   323	329	601	finally
    //   438	462	601	finally
    //   48	57	614	java/lang/Exception
    //   57	66	622	java/lang/Exception
    //   75	81	628	java/lang/Exception
    //   100	108	628	java/lang/Exception
    //   117	126	628	java/lang/Exception
    //   140	147	628	java/lang/Exception
    //   163	173	628	java/lang/Exception
    //   189	199	628	java/lang/Exception
    //   208	222	628	java/lang/Exception
    //   231	238	628	java/lang/Exception
    //   247	259	628	java/lang/Exception
    //   268	314	628	java/lang/Exception
    //   323	329	628	java/lang/Exception
  }
  
  private static Integer extractResource(XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    for (;;)
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.apkVer);
      if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(paramUpdateConfig.apkVer), str))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "extract faield");
        return Integer.valueOf(-5);
      }
      if (checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(paramUpdateConfig.apkVer), str) == true)
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 success!!!!");
        boolean bool = XWalkEnvironment.setAvailableVersion(paramUpdateConfig.apkVer, paramUpdateConfig.versionDetail);
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do update sucsess");
        generateOptDex(paramUpdateConfig.apkVer);
        if (bool) {
          break label155;
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "set version failed");
        return Integer.valueOf(-101);
      }
      if (mCurrentTimeForRetryRes > 0) {
        break;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 failed retry extractResource");
      mCurrentTimeForRetryRes += 1;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = " + mCurrentTimeForRetryRes);
    return Integer.valueOf(-12);
    label155:
    return Integer.valueOf(0);
  }
  
  private static void generateOptDex(int paramInt)
  {
    try
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramInt);
      new DexClassLoader(XWalkEnvironment.getClassDexFilePath(paramInt), XWalkEnvironment.getOptimizedDexDir(paramInt), str, ClassLoader.getSystemClassLoader());
      return;
    }
    catch (Exception localException)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "dex output error");
    }
  }
  
  private static boolean isProviderExist(ContentResolver paramContentResolver, String paramString)
  {
    if ((paramContentResolver == null) || (paramString == null) || (paramString.isEmpty())) {
      return false;
    }
    try
    {
      paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.b(paramString, XWalkEnvironment.getPackageName(), 1, 0, ""), "");
      return true;
    }
    catch (Exception paramContentResolver) {}
    return false;
  }
  
  public static boolean onDoPatch(String paramString, int paramInt1, int paramInt2)
  {
    Log.i("XWalkLib", "onDoPatch:" + paramString + ",currentVersion:" + paramInt1 + ",newVersion:" + paramInt2);
    if (!new File(paramString).exists())
    {
      Log.e("XWalkLib", "onDoPatch no patch zip file");
      return false;
    }
    if (!XWalkDecompressor.decompressDownloadPatchZip(paramString, XWalkEnvironment.getPatchZipTempDecompressPath(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch decompress zip error");
      e.it(37L);
      return false;
    }
    paramString = XWalkUpdater.PatchFileConfigParser.getPatchFileConfigList(paramInt2);
    if (paramString == null)
    {
      Log.e("XWalkLib", "onDoPatch patchFileConfigList = null");
      e.it(38L);
      return false;
    }
    if (!a.gQ(XWalkEnvironment.getExtractedCoreDir(paramInt1), XWalkEnvironment.getExtractedCoreDir(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch copy all extraced file error");
      e.it(39L);
      return false;
    }
    Log.i("XWalkLib", "onDoPatch copy all extraced file finished");
    Object localObject1 = new ArrayList();
    Object localObject2 = paramString.iterator();
    XWalkUpdater.PatchFileConfig localPatchFileConfig;
    while (((Iterator)localObject2).hasNext())
    {
      localPatchFileConfig = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (localPatchFileConfig.isTypeAdd()) {
        ((ArrayList)localObject1).add(localPatchFileConfig);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject1).next();
      if (!a.copyFile(XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch add file error:" + localObject2);
        e.it(40L);
        return false;
      }
      Log.i("XWalkLib", "onDoPatch add file:" + localObject2);
    }
    Log.i("XWalkLib", "onDoPatch add file finished");
    localObject1 = new ArrayList();
    localObject2 = paramString.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localPatchFileConfig = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (localPatchFileConfig.isTypeRemove()) {
        ((ArrayList)localObject1).add(localPatchFileConfig);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject1).next();
      if (!a.deleteFile(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch delete file error:" + localObject2);
        e.it(41L);
      }
      else
      {
        Log.i("XWalkLib", "onDoPatch delete file:" + localObject2);
      }
    }
    Log.i("XWalkLib", "onDoPatch remove file finished");
    localObject1 = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)paramString.next();
      if (((XWalkUpdater.PatchFileConfig)localObject2).isTypeModify()) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)paramString.next();
      if (((XWalkUpdater.PatchFileConfig)localObject2).isExtractedFile())
      {
        if (BSpatch.at(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).patchFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)) < 0)
        {
          Log.e("XWalkLib", "onDoPatch patch error file:" + localObject2);
          return false;
        }
        Log.i("XWalkLib", "onDoPatch patch file finished");
      }
    }
    Log.i("XWalkLib", "onDoPatch patch file finished");
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (XWalkUpdater.PatchFileConfig)paramString.next();
      if (((XWalkUpdater.PatchFileConfig)localObject1).isOriginalFileTypeApk()) {
        if (BSpatch.at(XWalkEnvironment.getDownloadApkPath(paramInt1), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject1).patchFileName), XWalkEnvironment.getDownloadApkPath(paramInt2)) < 0)
        {
          Log.e("XWalkLib", "onDoPatch apk patch error file:" + localObject1);
          return false;
        }
      }
    }
    Log.i("XWalkLib", "onDoPatch apk patch finished");
    return true;
  }
  
  public static Integer onHandleFile(XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    String str1 = paramUpdateConfig.getDownloadPath();
    String str2 = XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.apkVer);
    Log.d("XWalkLib", "Download mode extract dir: " + str2);
    if ((paramUpdateConfig.isMatchMd5) && (!c.gR(str1, paramUpdateConfig.downloadFileMd5)))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "downloaded apk md5 check failed");
      return Integer.valueOf(-2);
    }
    if (paramUpdateConfig.isPatchUpdate)
    {
      if (!onDoPatch(str1, XWalkEnvironment.getInstalledNewstVersion(), paramUpdateConfig.apkVer))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode ,but patch error");
        return Integer.valueOf(-3);
      }
      if ((paramUpdateConfig.isMatchMd5) && (!FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(paramUpdateConfig.apkVer))))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
        e.it(36L);
        return Integer.valueOf(-4);
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do patch sucsess");
    }
    do
    {
      return extractResource(paramUpdateConfig);
      if (!XWalkDecompressor.decompressDownloadFullZip(str1, paramUpdateConfig.apkVer))
      {
        e.it(32L);
        return Integer.valueOf(-5);
      }
    } while ((!paramUpdateConfig.isMatchMd5) || (FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(paramUpdateConfig.apkVer))));
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
    e.it(33L);
    return Integer.valueOf(-4);
  }
  
  private static boolean tryCopyVersion(ContentResolver paramContentResolver, String paramString, int paramInt, Map<String, String> paramMap, XWalkUpdater.ErrorInfo paramErrorInfo)
  {
    String str1;
    String str2;
    do
    {
      FileInputStream localFileInputStream;
      FileOutputStream localFileOutputStream;
      for (;;)
      {
        try
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break label329;
          }
          paramMap = (Map.Entry)localIterator.next();
          str1 = (String)paramMap.getKey();
          str2 = (String)paramMap.getValue();
          paramMap = paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.b(paramString, XWalkEnvironment.getPackageName(), 2, paramInt, str1), "");
          if (paramMap == null)
          {
            paramErrorInfo.copyFailedCount += 1;
            XWalkInitializer.addXWalkInitializeLog("tryCopyVersion no file " + str1);
            return false;
          }
          localFileInputStream = paramMap.createInputStream();
          if ("base.apk".equals(str1))
          {
            paramMap = new File(XWalkEnvironment.getDownloadApkPath(paramInt));
            if (paramMap.exists()) {
              paramMap.delete();
            }
            localFileOutputStream = new FileOutputStream(paramMap);
            byte[] arrayOfByte = new byte[1048576];
            int i = localFileInputStream.read(arrayOfByte);
            if (i == -1) {
              break;
            }
            localFileOutputStream.write(arrayOfByte, 0, i);
            continue;
          }
          paramMap = new File(XWalkEnvironment.getExtractedCoreFile(paramInt, str1));
        }
        catch (Exception paramContentResolver)
        {
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error:" + paramContentResolver.getMessage());
          paramErrorInfo.copyFailedCount += 1;
          return false;
        }
      }
      localFileOutputStream.flush();
      localFileInputStream.close();
      localFileOutputStream.close();
    } while (c.gR(paramMap.getAbsolutePath(), str2));
    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion md5 error " + str1);
    paramErrorInfo.md5FailedCount += 1;
    if (paramMap.exists()) {
      paramMap.delete();
    }
    return false;
    label329:
    return true;
  }
  
  private static Map<String, String> tryGetFileList(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramString = paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.b(paramString, XWalkEnvironment.getPackageName(), 2, paramInt, "filelist.config"), "");
      if (paramString == null)
      {
        XWalkInitializer.addXWalkInitializeLog("tryGetFileList no file list");
        return localHashMap;
      }
      paramContentResolver = new File(XWalkEnvironment.getExtractedCoreFile(paramInt, "filelist.config"));
      if (paramContentResolver.exists()) {
        paramContentResolver.delete();
      }
      paramContentResolver = new PrintWriter(paramContentResolver);
      paramString = new BufferedReader(new InputStreamReader(paramString.createInputStream()));
      for (;;)
      {
        Object localObject = paramString.readLine();
        if (localObject == null) {
          break;
        }
        paramContentResolver.println((String)localObject);
        if (!((String)localObject).isEmpty())
        {
          localObject = ((String)localObject).split(":");
          if ((localObject.length == 2) && (localObject[0] != null) && (!localObject[0].isEmpty()) && (localObject[1] != null) && (!localObject[1].isEmpty())) {
            localHashMap.put(localObject[0], localObject[1]);
          }
        }
      }
      paramContentResolver.flush();
    }
    catch (Exception paramContentResolver)
    {
      XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + paramContentResolver.getMessage());
      return null;
    }
    paramContentResolver.close();
    paramString.close();
    return localHashMap;
  }
  
  public static void updateLocalXWalkRuntime()
  {
    onHandleFile(new XWalkUpdater.UpdateConfig("runtime_package.zip", false, 999));
  }
  
  private boolean verifyDownloadedXWalkRuntime(String paramString)
  {
    paramString = this.mContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    if (paramString == null)
    {
      Log.e("XWalkLib", "The downloaded XWalkRuntimeLib.apk is invalid!");
      return false;
    }
    try
    {
      PackageInfo localPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
      if ((paramString.signatures == null) || (localPackageInfo.signatures == null))
      {
        Log.e("XWalkLib", "No signature in package info");
        return false;
      }
      if (paramString.signatures.length != localPackageInfo.signatures.length)
      {
        Log.e("XWalkLib", "signatures length not equal");
        return false;
      }
      int i = 0;
      while (i < paramString.signatures.length)
      {
        Log.d("XWalkLib", "Checking signature " + i);
        if (!localPackageInfo.signatures[i].equals(paramString.signatures[i]))
        {
          Log.e("XWalkLib", "signatures do not match");
          return false;
        }
        i += 1;
      }
      Log.d("XWalkLib", "Signature check passed");
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public boolean cancelBackgroundDownload()
  {
    return XWalkLibraryLoader.cancelHttpDownload();
  }
  
  public void cancelXWalkRuntimeDownload()
  {
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "canceled download apk");
      XWalkLibraryLoader.cancelHttpDownload();
    }
  }
  
  public boolean dismissDialog()
  {
    if ((this.mDialogManager == null) || (!this.mDialogManager.isShowingDialog())) {
      return false;
    }
    this.mDialogManager.dismissDialog();
    return true;
  }
  
  public XWalkUpdater.ErrorInfo updateRuntimeFromProvider(c.a parama)
  {
    label390:
    label458:
    label465:
    for (;;)
    {
      XWalkUpdater.ErrorInfo localErrorInfo;
      ContentResolver localContentResolver;
      XWalkUpdater.UpdateConfig localUpdateConfig;
      int i;
      String str;
      int k;
      Map localMap;
      try
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider target ver " + parama.xmZ);
        localErrorInfo = new XWalkUpdater.ErrorInfo();
        localErrorInfo.targetVer = parama.xmZ;
        if (!parama.bTryUseSharedCore)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
          localErrorInfo.errorCode = -6;
          return localErrorInfo;
        }
        if (parama.xnk >= 2)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
          localErrorInfo.errorCode = -7;
          continue;
        }
        localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver == null)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
          localErrorInfo.errorCode = -8;
          continue;
        }
        localUpdateConfig = parama.cTS();
        String[] arrayOfString = XWalkEnvironment.XWALK_CORE_PROVIDER_LIST;
        int m = arrayOfString.length;
        i = 0;
        j = 0;
        if (i >= m) {
          break label390;
        }
        str = arrayOfString[i];
        if (!isProviderExist(localContentResolver, str)) {
          break label458;
        }
        k = 1;
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider find " + str);
        localMap = tryGetFileList(localContentResolver, str, localUpdateConfig.apkVer);
        if (localMap == null)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider read fileList failed");
          localErrorInfo.readFileListFailedCount += 1;
          j = k;
        }
        else if (localMap.size() == 0)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider no matched version");
          localErrorInfo.noMatchedVersionCount += 1;
          j = k;
        }
      }
      finally {}
      int j = k;
      if (tryCopyVersion(localContentResolver, str, localUpdateConfig.apkVer, localMap, localErrorInfo))
      {
        int n = extractResource(localUpdateConfig).intValue();
        if (n == 0)
        {
          localErrorInfo.errorCode = 0;
          continue;
        }
        if (n == -5)
        {
          localErrorInfo.extractFailedCount += 1;
          j = k;
        }
        else if (n == -12)
        {
          localErrorInfo.extractRetryFailedCount += 1;
          j = k;
        }
        else
        {
          j = k;
          if (n == -101)
          {
            localErrorInfo.setVersionFailedCount += 1;
            j = k;
            break label458;
            if (j == 0)
            {
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
              localErrorInfo.errorCode = -9;
              continue;
            }
            if ((XWalkEnvironment.hasAvailableVersion()) && (parama.xnk + 1 < 2))
            {
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
              localErrorInfo.errorCode = -10;
              break label465;
            }
            XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
            localErrorInfo.errorCode = -11;
            break label465;
          }
        }
      }
      i += 1;
    }
  }
  
  public boolean updateXWalkRuntime(XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Other initialization or download is proceeding");
      return false;
    }
    if (this.mBackgroundUpdateListener != null)
    {
      if ((paramUpdateConfig == null) || (!paramUpdateConfig.checkValid()))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
        e.cTb();
        return false;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "start download apk");
      XWalkLibraryLoader.startHttpDownload(new XWalkUpdater.BackgroundListener(this, paramUpdateConfig), this.mContext, paramUpdateConfig);
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Update listener is null");
    return false;
  }
  
  public static class FileListMD5Checker
  {
    /* Error */
    public static boolean checkFileListMd5(int paramInt, File paramFile)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnonnull +5 -> 6
      //   4: iconst_0
      //   5: ireturn
      //   6: new 18	java/io/FileInputStream
      //   9: dup
      //   10: aload_1
      //   11: invokespecial 21	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   14: astore 4
      //   16: new 23	java/io/InputStreamReader
      //   19: dup
      //   20: aload 4
      //   22: invokespecial 26	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   25: astore_3
      //   26: new 28	java/io/BufferedReader
      //   29: dup
      //   30: aload_3
      //   31: invokespecial 31	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   34: astore_1
      //   35: aload_1
      //   36: astore 7
      //   38: aload_3
      //   39: astore 6
      //   41: aload 4
      //   43: astore 5
      //   45: aload_1
      //   46: invokevirtual 35	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   49: astore_2
      //   50: aload_2
      //   51: ifnull +225 -> 276
      //   54: aload_2
      //   55: ifnull -20 -> 35
      //   58: aload_1
      //   59: astore 7
      //   61: aload_3
      //   62: astore 6
      //   64: aload 4
      //   66: astore 5
      //   68: aload_2
      //   69: invokevirtual 41	java/lang/String:isEmpty	()Z
      //   72: ifne -37 -> 35
      //   75: aload_1
      //   76: astore 7
      //   78: aload_3
      //   79: astore 6
      //   81: aload 4
      //   83: astore 5
      //   85: aload_2
      //   86: ldc 43
      //   88: invokevirtual 47	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   91: astore_2
      //   92: aload_2
      //   93: ifnull -58 -> 35
      //   96: aload_1
      //   97: astore 7
      //   99: aload_3
      //   100: astore 6
      //   102: aload 4
      //   104: astore 5
      //   106: aload_2
      //   107: arraylength
      //   108: iconst_2
      //   109: if_icmpne -74 -> 35
      //   112: aload_2
      //   113: iconst_0
      //   114: aaload
      //   115: ifnull -80 -> 35
      //   118: aload_1
      //   119: astore 7
      //   121: aload_3
      //   122: astore 6
      //   124: aload 4
      //   126: astore 5
      //   128: aload_2
      //   129: iconst_0
      //   130: aaload
      //   131: invokevirtual 41	java/lang/String:isEmpty	()Z
      //   134: ifne -99 -> 35
      //   137: aload_2
      //   138: iconst_1
      //   139: aaload
      //   140: ifnull -105 -> 35
      //   143: aload_1
      //   144: astore 7
      //   146: aload_3
      //   147: astore 6
      //   149: aload 4
      //   151: astore 5
      //   153: aload_2
      //   154: iconst_1
      //   155: aaload
      //   156: invokevirtual 41	java/lang/String:isEmpty	()Z
      //   159: ifne -124 -> 35
      //   162: aload_1
      //   163: astore 7
      //   165: aload_3
      //   166: astore 6
      //   168: aload 4
      //   170: astore 5
      //   172: iload_0
      //   173: aload_2
      //   174: iconst_0
      //   175: aaload
      //   176: aload_2
      //   177: iconst_1
      //   178: aaload
      //   179: invokestatic 51	org/xwalk/core/XWalkUpdater$FileListMD5Checker:checkFileMd5	(ILjava/lang/String;Ljava/lang/String;)Z
      //   182: ifne -147 -> 35
      //   185: aload_1
      //   186: astore 7
      //   188: aload_3
      //   189: astore 6
      //   191: aload 4
      //   193: astore 5
      //   195: ldc 53
      //   197: new 55	java/lang/StringBuilder
      //   200: dup
      //   201: ldc 57
      //   203: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   206: aload_2
      //   207: iconst_0
      //   208: aaload
      //   209: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   212: ldc 66
      //   214: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   217: aload_2
      //   218: iconst_1
      //   219: aaload
      //   220: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   223: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   226: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   229: aload 4
      //   231: invokevirtual 78	java/io/FileInputStream:close	()V
      //   234: aload_3
      //   235: invokevirtual 79	java/io/InputStreamReader:close	()V
      //   238: aload_1
      //   239: invokevirtual 80	java/io/BufferedReader:close	()V
      //   242: iconst_0
      //   243: ireturn
      //   244: astore_1
      //   245: ldc 53
      //   247: ldc 82
      //   249: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   252: iconst_0
      //   253: ireturn
      //   254: astore_2
      //   255: ldc 53
      //   257: ldc 84
      //   259: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   262: goto -28 -> 234
      //   265: astore_2
      //   266: ldc 53
      //   268: ldc 86
      //   270: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   273: goto -35 -> 238
      //   276: aload 4
      //   278: invokevirtual 78	java/io/FileInputStream:close	()V
      //   281: aload_3
      //   282: invokevirtual 79	java/io/InputStreamReader:close	()V
      //   285: aload_1
      //   286: invokevirtual 80	java/io/BufferedReader:close	()V
      //   289: iconst_1
      //   290: ireturn
      //   291: astore_2
      //   292: ldc 53
      //   294: ldc 84
      //   296: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   299: goto -18 -> 281
      //   302: astore_2
      //   303: ldc 53
      //   305: ldc 86
      //   307: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   310: goto -25 -> 285
      //   313: astore_1
      //   314: ldc 53
      //   316: ldc 82
      //   318: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   321: goto -32 -> 289
      //   324: astore_2
      //   325: aconst_null
      //   326: astore_1
      //   327: aconst_null
      //   328: astore_3
      //   329: aconst_null
      //   330: astore 4
      //   332: aload_1
      //   333: astore 7
      //   335: aload_3
      //   336: astore 6
      //   338: aload 4
      //   340: astore 5
      //   342: ldc 53
      //   344: new 55	java/lang/StringBuilder
      //   347: dup
      //   348: ldc 88
      //   350: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   353: aload_2
      //   354: invokevirtual 91	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   357: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   363: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   366: aload 4
      //   368: ifnull +8 -> 376
      //   371: aload 4
      //   373: invokevirtual 78	java/io/FileInputStream:close	()V
      //   376: aload_3
      //   377: ifnull +7 -> 384
      //   380: aload_3
      //   381: invokevirtual 79	java/io/InputStreamReader:close	()V
      //   384: aload_1
      //   385: ifnull -381 -> 4
      //   388: aload_1
      //   389: invokevirtual 80	java/io/BufferedReader:close	()V
      //   392: iconst_0
      //   393: ireturn
      //   394: astore_1
      //   395: ldc 53
      //   397: ldc 82
      //   399: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   402: iconst_0
      //   403: ireturn
      //   404: astore_2
      //   405: ldc 53
      //   407: ldc 84
      //   409: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   412: goto -36 -> 376
      //   415: astore_2
      //   416: ldc 53
      //   418: ldc 86
      //   420: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   423: goto -39 -> 384
      //   426: astore_1
      //   427: aconst_null
      //   428: astore_2
      //   429: aconst_null
      //   430: astore_3
      //   431: aconst_null
      //   432: astore 4
      //   434: aload 4
      //   436: ifnull +8 -> 444
      //   439: aload 4
      //   441: invokevirtual 78	java/io/FileInputStream:close	()V
      //   444: aload_3
      //   445: ifnull +7 -> 452
      //   448: aload_3
      //   449: invokevirtual 79	java/io/InputStreamReader:close	()V
      //   452: aload_2
      //   453: ifnull +7 -> 460
      //   456: aload_2
      //   457: invokevirtual 80	java/io/BufferedReader:close	()V
      //   460: aload_1
      //   461: athrow
      //   462: astore 4
      //   464: ldc 53
      //   466: ldc 84
      //   468: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   471: goto -27 -> 444
      //   474: astore_3
      //   475: ldc 53
      //   477: ldc 86
      //   479: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   482: goto -30 -> 452
      //   485: astore_2
      //   486: ldc 53
      //   488: ldc 82
      //   490: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   493: goto -33 -> 460
      //   496: astore_1
      //   497: aconst_null
      //   498: astore_2
      //   499: aconst_null
      //   500: astore_3
      //   501: goto -67 -> 434
      //   504: astore_1
      //   505: aconst_null
      //   506: astore_2
      //   507: goto -73 -> 434
      //   510: astore_1
      //   511: aload 7
      //   513: astore_2
      //   514: aload 6
      //   516: astore_3
      //   517: aload 5
      //   519: astore 4
      //   521: goto -87 -> 434
      //   524: astore_2
      //   525: aconst_null
      //   526: astore_1
      //   527: aconst_null
      //   528: astore_3
      //   529: goto -197 -> 332
      //   532: astore_2
      //   533: aconst_null
      //   534: astore_1
      //   535: goto -203 -> 332
      //   538: astore_2
      //   539: goto -207 -> 332
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	542	0	paramInt	int
      //   0	542	1	paramFile	File
      //   49	169	2	localObject1	Object
      //   254	1	2	localException1	Exception
      //   265	1	2	localException2	Exception
      //   291	1	2	localException3	Exception
      //   302	1	2	localException4	Exception
      //   324	30	2	localException5	Exception
      //   404	1	2	localException6	Exception
      //   415	1	2	localException7	Exception
      //   428	29	2	localObject2	Object
      //   485	1	2	localException8	Exception
      //   498	16	2	localFile1	File
      //   524	1	2	localException9	Exception
      //   532	1	2	localException10	Exception
      //   538	1	2	localException11	Exception
      //   25	424	3	localInputStreamReader1	InputStreamReader
      //   474	1	3	localException12	Exception
      //   500	29	3	localObject3	Object
      //   14	426	4	localFileInputStream1	FileInputStream
      //   462	1	4	localException13	Exception
      //   519	1	4	localObject4	Object
      //   43	475	5	localFileInputStream2	FileInputStream
      //   39	476	6	localInputStreamReader2	InputStreamReader
      //   36	476	7	localFile2	File
      // Exception table:
      //   from	to	target	type
      //   238	242	244	java/lang/Exception
      //   229	234	254	java/lang/Exception
      //   234	238	265	java/lang/Exception
      //   276	281	291	java/lang/Exception
      //   281	285	302	java/lang/Exception
      //   285	289	313	java/lang/Exception
      //   6	16	324	java/lang/Exception
      //   388	392	394	java/lang/Exception
      //   371	376	404	java/lang/Exception
      //   380	384	415	java/lang/Exception
      //   6	16	426	finally
      //   439	444	462	java/lang/Exception
      //   448	452	474	java/lang/Exception
      //   456	460	485	java/lang/Exception
      //   16	26	496	finally
      //   26	35	504	finally
      //   45	50	510	finally
      //   68	75	510	finally
      //   85	92	510	finally
      //   106	112	510	finally
      //   128	137	510	finally
      //   153	162	510	finally
      //   172	185	510	finally
      //   195	229	510	finally
      //   342	366	510	finally
      //   16	26	524	java/lang/Exception
      //   26	35	532	java/lang/Exception
      //   45	50	538	java/lang/Exception
      //   68	75	538	java/lang/Exception
      //   85	92	538	java/lang/Exception
      //   106	112	538	java/lang/Exception
      //   128	137	538	java/lang/Exception
      //   153	162	538	java/lang/Exception
      //   172	185	538	java/lang/Exception
      //   195	229	538	java/lang/Exception
    }
    
    public static boolean checkFileListMd5(int paramInt, String paramString)
    {
      try
      {
        boolean bool = checkFileListMd5(paramInt, new File(paramString));
        return bool;
      }
      catch (Exception paramString)
      {
        Log.e("XWalkLib", "checkFileListMd5 error:" + paramString.getMessage());
      }
      return false;
    }
    
    private static boolean checkFileMd5(int paramInt, String paramString1, String paramString2)
    {
      if ("base.apk".equals(paramString1)) {}
      for (paramString1 = XWalkEnvironment.getDownloadApkPath(paramInt); c.gR(paramString1, paramString2); paramString1 = XWalkEnvironment.getExtractedCoreFile(paramInt, paramString1))
      {
        Log.i("XWalkLib", "checkFileMd5 successful path:" + paramString1);
        return true;
      }
      Log.e("XWalkLib", "checkFileMd5 error path:" + paramString1);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater
 * JD-Core Version:    0.7.0.1
 */