package com.tencent.xweb.xwalk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.internal.d;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.l;
import com.tencent.xweb.util.m;
import com.tencent.xweb.xwalk.b.c;
import com.tencent.xweb.xwalk.updater.UpdateConfig;
import com.tencent.xweb.xwalk.updater.f;
import com.tencent.xweb.xwalk.updater.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;
import org.xwalk.core.XWalkSharedPreferenceUtil;
import org.xwalk.core.XWebCoreInfo;

public final class o
{
  private static int aipo = 0;
  public final i aipp;
  public final Context mContext;
  
  public o(Context paramContext, i parami)
  {
    this.mContext = paramContext;
    this.aipp = parami;
  }
  
  /* Error */
  private static Map<String, String> a(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 36	java/util/HashMap
    //   8: dup
    //   9: invokespecial 37	java/util/HashMap:<init>	()V
    //   12: astore 5
    //   14: aload_0
    //   15: aload_1
    //   16: invokestatic 43	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   19: iconst_2
    //   20: iload_2
    //   21: ldc 45
    //   23: invokestatic 51	com/tencent/xweb/XWebCoreContentProvider:c	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   26: ldc 53
    //   28: invokevirtual 59	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +31 -> 66
    //   38: ldc 61
    //   40: ldc 63
    //   42: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aconst_null
    //   46: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   49: aconst_null
    //   50: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   53: aload 4
    //   55: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   58: ldc 28
    //   60: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload 5
    //   65: areturn
    //   66: new 78	java/io/File
    //   69: dup
    //   70: iload_2
    //   71: ldc 45
    //   73: invokestatic 84	org/xwalk/core/XWalkFileUtil:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   76: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 91	java/io/File:exists	()Z
    //   84: ifeq +8 -> 92
    //   87: aload_0
    //   88: invokevirtual 94	java/io/File:delete	()Z
    //   91: pop
    //   92: new 96	java/io/PrintWriter
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 99	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   100: astore_3
    //   101: new 101	java/io/BufferedReader
    //   104: dup
    //   105: new 103	java/io/InputStreamReader
    //   108: dup
    //   109: aload 4
    //   111: invokevirtual 109	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   114: invokespecial 112	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   117: invokespecial 115	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 118	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +110 -> 237
    //   130: aload_3
    //   131: aload_0
    //   132: invokevirtual 121	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   135: aload_0
    //   136: invokevirtual 126	java/lang/String:isEmpty	()Z
    //   139: ifne -18 -> 121
    //   142: aload_0
    //   143: ldc 128
    //   145: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   148: astore_0
    //   149: aload_0
    //   150: arraylength
    //   151: iconst_2
    //   152: if_icmpne -31 -> 121
    //   155: aload_0
    //   156: iconst_0
    //   157: aaload
    //   158: ifnull -37 -> 121
    //   161: aload_0
    //   162: iconst_0
    //   163: aaload
    //   164: invokevirtual 126	java/lang/String:isEmpty	()Z
    //   167: ifne -46 -> 121
    //   170: aload_0
    //   171: iconst_1
    //   172: aaload
    //   173: ifnull -52 -> 121
    //   176: aload_0
    //   177: iconst_1
    //   178: aaload
    //   179: invokevirtual 126	java/lang/String:isEmpty	()Z
    //   182: ifne -61 -> 121
    //   185: aload 5
    //   187: aload_0
    //   188: iconst_0
    //   189: aaload
    //   190: aload_0
    //   191: iconst_1
    //   192: aaload
    //   193: invokeinterface 138 3 0
    //   198: pop
    //   199: goto -78 -> 121
    //   202: astore_0
    //   203: ldc 61
    //   205: ldc 140
    //   207: aload_0
    //   208: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_3
    //   218: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   221: aload_1
    //   222: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   225: aload 4
    //   227: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   230: ldc 28
    //   232: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: aload_3
    //   238: invokevirtual 151	java/io/PrintWriter:flush	()V
    //   241: aload_3
    //   242: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   245: aload_1
    //   246: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   249: aload 4
    //   251: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   254: ldc 28
    //   256: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload 5
    //   261: areturn
    //   262: astore_0
    //   263: aload_3
    //   264: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   267: aload_1
    //   268: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   271: aload 4
    //   273: invokestatic 73	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   276: ldc 28
    //   278: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload_0
    //   282: athrow
    //   283: astore_0
    //   284: aconst_null
    //   285: astore_3
    //   286: aconst_null
    //   287: astore_1
    //   288: aconst_null
    //   289: astore 4
    //   291: goto -88 -> 203
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_1
    //   299: goto -96 -> 203
    //   302: astore_0
    //   303: aconst_null
    //   304: astore_1
    //   305: goto -102 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramContentResolver	ContentResolver
    //   0	308	1	paramString	String
    //   0	308	2	paramInt	int
    //   100	197	3	localPrintWriter	java.io.PrintWriter
    //   31	259	4	localAssetFileDescriptor	AssetFileDescriptor
    //   12	248	5	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   121	126	202	finally
    //   130	155	202	finally
    //   161	170	202	finally
    //   176	199	202	finally
    //   237	241	202	finally
    //   203	217	262	finally
    //   14	33	283	finally
    //   38	45	294	finally
    //   66	92	294	finally
    //   92	101	294	finally
    //   101	121	302	finally
  }
  
  private static boolean a(ContentResolver paramContentResolver, String paramString)
  {
    bool = true;
    AppMethodBeat.i(212826);
    if ((paramContentResolver == null) || (paramString == null) || (paramString.isEmpty()))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "isProviderExist, provider package is null");
      AppMethodBeat.o(212826);
      return false;
    }
    try
    {
      paramContentResolver = paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.c(paramString, XWalkEnvironment.getPackageName(), 1, 0, ""), "");
      g.d(paramContentResolver);
    }
    finally
    {
      for (;;)
      {
        g.d(null);
        bool = false;
      }
    }
    AppMethodBeat.o(212826);
    return bool;
  }
  
  private static boolean a(ContentResolver paramContentResolver, String paramString, int paramInt, Map<String, String> paramMap, a parama)
  {
    AppMethodBeat.i(212840);
    String str1;
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      String str2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)localIterator.next();
        str1 = (String)paramMap.getKey();
        str2 = (String)paramMap.getValue();
        AssetFileDescriptor localAssetFileDescriptor = paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.c(paramString, XWalkEnvironment.getPackageName(), 2, paramInt, str1), "");
        if (localAssetFileDescriptor == null)
        {
          XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "tryCopyVersionFiles, file not exist, fileName:".concat(String.valueOf(str1)));
          parama.aipt += 1;
          AppMethodBeat.o(212840);
          return false;
        }
        if ("base.apk".equals(str1)) {}
        for (paramMap = new File(XWalkFileUtil.getDownloadApkPath(paramInt)); !g.a(localAssetFileDescriptor, paramMap); paramMap = new File(XWalkFileUtil.getExtractedCoreFile(paramInt, str1)))
        {
          XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "tryCopyVersionFiles, copy file error, fileName:".concat(String.valueOf(str1)));
          parama.aipt += 1;
          AppMethodBeat.o(212840);
          return false;
        }
      } while (h.rb(paramMap.getAbsolutePath(), str2));
    }
    finally
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "tryCopyVersionFiles error:".concat(String.valueOf(paramContentResolver)));
      parama.aipt += 1;
      AppMethodBeat.o(212840);
      return false;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "tryCopyVersionFiles, md5 error, fileName:".concat(String.valueOf(str1)));
    parama.aipu += 1;
    if (paramMap.exists()) {
      paramMap.delete();
    }
    AppMethodBeat.o(212840);
    return false;
    AppMethodBeat.o(212840);
    return true;
  }
  
  private static Integer al(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212855);
    for (;;)
    {
      Log.i("XWalkUpdater", "tryInstallRuntimeInternal, version:" + paramInt + ", abi:" + paramString1 + ", versionDetail:" + paramString2);
      String str = XWalkFileUtil.getExtractedCoreDir(paramInt);
      String[] arrayOfString = com.tencent.xweb.xwalk.b.a.aJW(paramInt);
      if (arrayOfString == null)
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "reslist.config not exist");
        AppMethodBeat.o(212855);
        return Integer.valueOf(-5);
      }
      if (!XWalkDecompressor.extractResource(XWalkFileUtil.getDownloadApkPath(paramInt), str, arrayOfString))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "extractResource failed");
        AppMethodBeat.o(212855);
        return Integer.valueOf(-5);
      }
      if (com.tencent.xweb.xwalk.b.a.b(paramInt, new File(XWalkFileUtil.getDownloadResFileListConfig(paramInt))))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "checkAllResFileMd5 success");
        m.q(paramInt, str, true);
        if ((!com.tencent.xweb.util.b.khw().equalsIgnoreCase(paramString1)) || (m.aJH(paramInt))) {
          break label245;
        }
        l.Br(251L);
        if (!"true".equalsIgnoreCase(com.tencent.xweb.a.keX().qM("update_need_check_dex", "tools"))) {
          break label245;
        }
        AppMethodBeat.o(212855);
        return Integer.valueOf(-101);
      }
      if (aipo > 0) {
        break;
      }
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "checkAllResFileMd5 failed, retry install new runtime");
      aipo += 1;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "checkAllResFileMd5 failed, can not retry install new runtime");
    AppMethodBeat.o(212855);
    return Integer.valueOf(-12);
    label245:
    int i = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    boolean bool = XWebCoreInfo.setVersionInfo(paramInt, paramString2, paramString1);
    l.khH();
    d.bHP("CHECK_FILES_MD5_TIME_KEY");
    if (com.tencent.xweb.util.b.khw().equalsIgnoreCase(paramString1)) {
      d.cH("CLEAR_OLD_APK", 86400000L);
    }
    while (!bool)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "tryInstallRuntimeInternal, set runtime version failed");
      AppMethodBeat.o(212855);
      return Integer.valueOf(-101);
      if ((i > 0) && (!com.tencent.xweb.a.keX().Q("NOT_CLEAR_PREVE_VER_IMEDEATLY", "tools", false)))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "new runtime installed, clear pre version = ".concat(String.valueOf(i)));
        f.aJS(i);
        l.y(577L, 65L, 1L);
      }
    }
    XWalkEnvironment.refreshVersionInfo();
    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "tryInstallRuntimeInternal success");
    AppMethodBeat.o(212855);
    return Integer.valueOf(0);
  }
  
  public static int bIo(String paramString)
  {
    AppMethodBeat.i(212847);
    int i = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForEmbedInstall(paramString).getInt("INSTALLED_EMBED_VERSION", -1);
    AppMethodBeat.o(212847);
    return i;
  }
  
  private static boolean bm(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212865);
    Log.i("XWalkUpdater", "doPatch, pathZipPath:" + paramString + ", currentVersion:" + paramInt1 + ", newVersion:" + paramInt2);
    if (!new File(paramString).exists())
    {
      Log.e("XWalkUpdater", "doPatch, no patch zip file");
      AppMethodBeat.o(212865);
      return false;
    }
    if (!XWalkDecompressor.decompressDownloadPatchZip(paramString, XWalkFileUtil.getPatchZipTempDecompressDir(paramInt2)))
    {
      Log.e("XWalkUpdater", "doPatch, decompress zip error");
      l.Br(37L);
      AppMethodBeat.o(212865);
      return false;
    }
    paramString = c.aJX(paramInt2);
    if (paramString == null)
    {
      Log.e("XWalkUpdater", "doPatch, patchFileConfigList = null");
      l.Br(38L);
      AppMethodBeat.o(212865);
      return false;
    }
    if (!g.qZ(XWalkFileUtil.getExtractedCoreDir(paramInt1), XWalkFileUtil.getExtractedCoreDir(paramInt2)))
    {
      Log.e("XWalkUpdater", "doPatch, copy all extracted file from current version error");
      l.Br(39L);
      AppMethodBeat.o(212865);
      return false;
    }
    Log.i("XWalkUpdater", "doPatch, copy all extracted file finished");
    Object localObject1 = new ArrayList();
    Object localObject2 = paramString.iterator();
    com.tencent.xweb.xwalk.b.b localb;
    int i;
    label252:
    while (((Iterator)localObject2).hasNext())
    {
      localb = (com.tencent.xweb.xwalk.b.b)((Iterator)localObject2).next();
      if (localb.type == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label252;
        }
        ((ArrayList)localObject1).add(localb);
        break;
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.xweb.xwalk.b.b)((Iterator)localObject1).next();
      if (!g.copyFile(XWalkFileUtil.getPatchZipTempDecompressFilePath(paramInt2, ((com.tencent.xweb.xwalk.b.b)localObject2).aipT), XWalkFileUtil.getExtractedCoreFile(paramInt2, ((com.tencent.xweb.xwalk.b.b)localObject2).aipT)))
      {
        Log.e("XWalkUpdater", "doPatch, add file error:".concat(String.valueOf(localObject2)));
        l.Br(40L);
        AppMethodBeat.o(212865);
        return false;
      }
      Log.i("XWalkUpdater", "doPatch, add file:".concat(String.valueOf(localObject2)));
    }
    Log.i("XWalkUpdater", "doPatch, add files finished");
    localObject1 = new ArrayList();
    localObject2 = paramString.iterator();
    label430:
    while (((Iterator)localObject2).hasNext())
    {
      localb = (com.tencent.xweb.xwalk.b.b)((Iterator)localObject2).next();
      if (localb.type == 3) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label430;
        }
        ((ArrayList)localObject1).add(localb);
        break;
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.xweb.xwalk.b.b)((Iterator)localObject1).next();
      if (!g.deleteFile(XWalkFileUtil.getExtractedCoreFile(paramInt2, ((com.tencent.xweb.xwalk.b.b)localObject2).aipT)))
      {
        Log.e("XWalkUpdater", "doPatch, delete file error:".concat(String.valueOf(localObject2)));
        l.Br(41L);
      }
      else
      {
        Log.i("XWalkUpdater", "doPatch, delete file:".concat(String.valueOf(localObject2)));
      }
    }
    Log.i("XWalkUpdater", "doPatch, remove files finished");
    localObject1 = new ArrayList();
    paramString = paramString.iterator();
    label591:
    while (paramString.hasNext())
    {
      localObject2 = (com.tencent.xweb.xwalk.b.b)paramString.next();
      if (((com.tencent.xweb.xwalk.b.b)localObject2).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label591;
        }
        ((ArrayList)localObject1).add(localObject2);
        break;
      }
    }
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject2 = (com.tencent.xweb.xwalk.b.b)paramString.next();
      if (((com.tencent.xweb.xwalk.b.b)localObject2).airn == 2) {}
      for (i = 1; i != 0; i = 0)
      {
        if (BSpatch.bQ(XWalkFileUtil.getExtractedCoreFile(paramInt2, ((com.tencent.xweb.xwalk.b.b)localObject2).aipT), XWalkFileUtil.getPatchZipTempDecompressFilePath(paramInt2, ((com.tencent.xweb.xwalk.b.b)localObject2).aipS), XWalkFileUtil.getExtractedCoreFile(paramInt2, ((com.tencent.xweb.xwalk.b.b)localObject2).aipT)) >= 0) {
          break label696;
        }
        Log.e("XWalkUpdater", "doPatch, patch error file:".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(212865);
        return false;
      }
      continue;
      label696:
      Log.i("XWalkUpdater", "doPatch, patch file:".concat(String.valueOf(localObject2)));
    }
    Log.i("XWalkUpdater", "doPatch, patch files finished");
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (com.tencent.xweb.xwalk.b.b)paramString.next();
      if (((com.tencent.xweb.xwalk.b.b)localObject1).airn == 1) {}
      for (i = 1; i != 0; i = 0)
      {
        if (BSpatch.bQ(XWalkFileUtil.getDownloadApkPath(paramInt1), XWalkFileUtil.getPatchZipTempDecompressFilePath(paramInt2, ((com.tencent.xweb.xwalk.b.b)localObject1).aipS), XWalkFileUtil.getDownloadApkPath(paramInt2)) >= 0) {
          break label816;
        }
        Log.e("XWalkUpdater", "doPatch, apk patch error file:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(212865);
        return false;
      }
    }
    label816:
    Log.i("XWalkUpdater", "doPatch, apk patch finished");
    AppMethodBeat.o(212865);
    return true;
  }
  
  public static void kjl()
  {
    AppMethodBeat.i(212845);
    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "updateRuntimeFromEmbed, SHOULD_EMEBED_XWEB_CORE is false");
    AppMethodBeat.o(212845);
  }
  
  public static void kjm()
  {
    AppMethodBeat.i(212850);
    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "clearLastTryEmbedInstallVersion");
    XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForEmbedInstall("armeabi-v7a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForEmbedInstall("arm64-v8a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    AppMethodBeat.o(212850);
  }
  
  /* Error */
  public final a a(com.tencent.xweb.xwalk.updater.n paramn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 537
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokevirtual 543	com/tencent/xweb/xwalk/updater/n:kjY	()Lcom/tencent/xweb/xwalk/updater/d;
    //   12: astore 9
    //   14: ldc 61
    //   16: new 228	java/lang/StringBuilder
    //   19: dup
    //   20: ldc_w 545
    //   23: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload 9
    //   28: getfield 550	com/tencent/xweb/xwalk/updater/d:version	I
    //   31: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: new 6	com/tencent/xweb/xwalk/o$a
    //   43: dup
    //   44: invokespecial 551	com/tencent/xweb/xwalk/o$a:<init>	()V
    //   47: astore 10
    //   49: aload 10
    //   51: aload 9
    //   53: getfield 550	com/tencent/xweb/xwalk/updater/d:version	I
    //   56: putfield 554	com/tencent/xweb/xwalk/o$a:aipq	I
    //   59: aload 9
    //   61: getfield 558	com/tencent/xweb/xwalk/updater/d:aijL	Z
    //   64: ifne +29 -> 93
    //   67: ldc 61
    //   69: ldc_w 560
    //   72: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 10
    //   77: bipush 250
    //   79: putfield 563	com/tencent/xweb/xwalk/o$a:errorCode	I
    //   82: ldc_w 537
    //   85: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_0
    //   89: monitorexit
    //   90: aload 10
    //   92: areturn
    //   93: aload 9
    //   95: getfield 566	com/tencent/xweb/xwalk/updater/d:aiqE	I
    //   98: iconst_2
    //   99: if_icmplt +27 -> 126
    //   102: ldc 61
    //   104: ldc_w 568
    //   107: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 10
    //   112: bipush 249
    //   114: putfield 563	com/tencent/xweb/xwalk/o$a:errorCode	I
    //   117: ldc_w 537
    //   120: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: goto -35 -> 88
    //   126: invokestatic 572	org/xwalk/core/XWalkEnvironment:getContentResolver	()Landroid/content/ContentResolver;
    //   129: astore 11
    //   131: aload 11
    //   133: ifnonnull +27 -> 160
    //   136: ldc 61
    //   138: ldc_w 574
    //   141: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 10
    //   146: bipush 248
    //   148: putfield 563	com/tencent/xweb/xwalk/o$a:errorCode	I
    //   151: ldc_w 537
    //   154: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: goto -69 -> 88
    //   160: aload_1
    //   161: aload 9
    //   163: invokevirtual 578	com/tencent/xweb/xwalk/updater/n:f	(Lcom/tencent/xweb/xwalk/updater/d;)Lcom/tencent/xweb/xwalk/updater/UpdateConfig;
    //   166: astore 12
    //   168: iconst_0
    //   169: istore_2
    //   170: getstatic 582	com/tencent/xweb/XWebCoreContentProvider:aifP	[Ljava/lang/String;
    //   173: astore 13
    //   175: aload 13
    //   177: arraylength
    //   178: istore 6
    //   180: iconst_0
    //   181: istore_3
    //   182: iload_3
    //   183: iload 6
    //   185: if_icmpge +494 -> 679
    //   188: aload 13
    //   190: iload_3
    //   191: aaload
    //   192: astore 14
    //   194: aload 11
    //   196: aload 14
    //   198: invokestatic 584	com/tencent/xweb/xwalk/o:a	(Landroid/content/ContentResolver;Ljava/lang/String;)Z
    //   201: ifeq +581 -> 782
    //   204: ldc 61
    //   206: ldc_w 586
    //   209: aload 14
    //   211: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   214: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: invokestatic 317	com/tencent/xweb/a:keX	()Lcom/tencent/xweb/a;
    //   223: ldc_w 588
    //   226: ldc_w 321
    //   229: invokevirtual 325	com/tencent/xweb/a:qM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   232: astore_1
    //   233: ldc 61
    //   235: ldc_w 590
    //   238: aload_1
    //   239: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   242: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   245: invokestatic 249	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: new 449	java/util/ArrayList
    //   251: dup
    //   252: invokespecial 450	java/util/ArrayList:<init>	()V
    //   255: astore 15
    //   257: aload 15
    //   259: aload 12
    //   261: getfield 595	com/tencent/xweb/xwalk/updater/UpdateConfig:aiqN	I
    //   264: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: invokevirtual 459	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   270: pop
    //   271: aload_1
    //   272: invokestatic 600	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifne +122 -> 397
    //   278: invokestatic 603	org/xwalk/core/XWalkEnvironment:hasInstalledAvailableVersion	()Z
    //   281: ifne +116 -> 397
    //   284: aload_1
    //   285: ldc_w 605
    //   288: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   291: astore_1
    //   292: aload_1
    //   293: ifnull +104 -> 397
    //   296: aload_1
    //   297: arraylength
    //   298: istore 4
    //   300: iconst_0
    //   301: istore_2
    //   302: iload_2
    //   303: iload 4
    //   305: if_icmpge +92 -> 397
    //   308: aload_1
    //   309: iload_2
    //   310: aaload
    //   311: astore 8
    //   313: aload 8
    //   315: invokestatic 600	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   318: ifne +46 -> 364
    //   321: aload 8
    //   323: invokevirtual 608	java/lang/String:trim	()Ljava/lang/String;
    //   326: invokestatic 600	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   329: istore 7
    //   331: iload 7
    //   333: ifne +31 -> 364
    //   336: aload 8
    //   338: invokestatic 611	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   341: istore 5
    //   343: aload 12
    //   345: getfield 595	com/tencent/xweb/xwalk/updater/UpdateConfig:aiqN	I
    //   348: iload 5
    //   350: if_icmpeq +14 -> 364
    //   353: aload 15
    //   355: iload 5
    //   357: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: invokevirtual 459	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   363: pop
    //   364: iload_2
    //   365: iconst_1
    //   366: iadd
    //   367: istore_2
    //   368: goto -66 -> 302
    //   371: astore 8
    //   373: ldc 61
    //   375: ldc_w 613
    //   378: aload 8
    //   380: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   383: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   386: invokestatic 418	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: goto -25 -> 364
    //   392: astore_1
    //   393: aload_0
    //   394: monitorexit
    //   395: aload_1
    //   396: athrow
    //   397: aconst_null
    //   398: astore_1
    //   399: iconst_0
    //   400: istore_2
    //   401: iload_2
    //   402: aload 15
    //   404: invokevirtual 616	java/util/ArrayList:size	()I
    //   407: if_icmpge +366 -> 773
    //   410: aload 15
    //   412: iload_2
    //   413: invokevirtual 620	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   416: checkcast 262	java/lang/Integer
    //   419: invokevirtual 623	java/lang/Integer:intValue	()I
    //   422: istore 5
    //   424: aload 11
    //   426: aload 14
    //   428: iload 5
    //   430: invokestatic 625	com/tencent/xweb/xwalk/o:a	(Landroid/content/ContentResolver;Ljava/lang/String;I)Ljava/util/Map;
    //   433: astore_1
    //   434: aload_1
    //   435: ifnonnull +34 -> 469
    //   438: ldc 61
    //   440: ldc_w 627
    //   443: iload 5
    //   445: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   448: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   451: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload 10
    //   456: aload 10
    //   458: getfield 630	com/tencent/xweb/xwalk/o$a:aipr	I
    //   461: iconst_1
    //   462: iadd
    //   463: putfield 630	com/tencent/xweb/xwalk/o$a:aipr	I
    //   466: goto +300 -> 766
    //   469: iload 5
    //   471: istore 4
    //   473: aload_1
    //   474: astore 8
    //   476: aload_1
    //   477: invokeinterface 631 1 0
    //   482: ifne +22 -> 504
    //   485: ldc 61
    //   487: ldc_w 633
    //   490: iload 5
    //   492: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   495: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   498: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: goto +265 -> 766
    //   504: iload 4
    //   506: ifge +20 -> 526
    //   509: aload 10
    //   511: aload 10
    //   513: getfield 636	com/tencent/xweb/xwalk/o$a:aips	I
    //   516: iconst_1
    //   517: iadd
    //   518: putfield 636	com/tencent/xweb/xwalk/o$a:aips	I
    //   521: iconst_1
    //   522: istore_2
    //   523: goto +259 -> 782
    //   526: ldc 61
    //   528: ldc_w 638
    //   531: iload 4
    //   533: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   536: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload 11
    //   544: aload 14
    //   546: iload 4
    //   548: aload 8
    //   550: aload 10
    //   552: invokestatic 640	com/tencent/xweb/xwalk/o:a	(Landroid/content/ContentResolver;Ljava/lang/String;ILjava/util/Map;Lcom/tencent/xweb/xwalk/o$a;)Z
    //   555: ifeq +234 -> 789
    //   558: iload 4
    //   560: aload 12
    //   562: getfield 643	com/tencent/xweb/xwalk/updater/UpdateConfig:ZaV	Ljava/lang/String;
    //   565: new 228	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 644	java/lang/StringBuilder:<init>	()V
    //   572: iload 4
    //   574: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: ldc_w 646
    //   580: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 648	com/tencent/xweb/xwalk/o:al	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;
    //   589: invokevirtual 623	java/lang/Integer:intValue	()I
    //   592: istore_2
    //   593: iload_2
    //   594: ifne +18 -> 612
    //   597: aload 10
    //   599: iconst_0
    //   600: putfield 563	com/tencent/xweb/xwalk/o$a:errorCode	I
    //   603: ldc_w 537
    //   606: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   609: goto -521 -> 88
    //   612: iload_2
    //   613: bipush 251
    //   615: if_icmpne +20 -> 635
    //   618: aload 10
    //   620: aload 10
    //   622: getfield 651	com/tencent/xweb/xwalk/o$a:aipv	I
    //   625: iconst_1
    //   626: iadd
    //   627: putfield 651	com/tencent/xweb/xwalk/o$a:aipv	I
    //   630: iconst_1
    //   631: istore_2
    //   632: goto +150 -> 782
    //   635: iload_2
    //   636: bipush 244
    //   638: if_icmpne +20 -> 658
    //   641: aload 10
    //   643: aload 10
    //   645: getfield 654	com/tencent/xweb/xwalk/o$a:aipx	I
    //   648: iconst_1
    //   649: iadd
    //   650: putfield 654	com/tencent/xweb/xwalk/o$a:aipx	I
    //   653: iconst_1
    //   654: istore_2
    //   655: goto +127 -> 782
    //   658: iload_2
    //   659: bipush 155
    //   661: if_icmpne +128 -> 789
    //   664: aload 10
    //   666: aload 10
    //   668: getfield 657	com/tencent/xweb/xwalk/o$a:aipw	I
    //   671: iconst_1
    //   672: iadd
    //   673: putfield 657	com/tencent/xweb/xwalk/o$a:aipw	I
    //   676: goto +113 -> 789
    //   679: iload_2
    //   680: ifne +27 -> 707
    //   683: ldc 61
    //   685: ldc_w 659
    //   688: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload 10
    //   693: bipush 247
    //   695: putfield 563	com/tencent/xweb/xwalk/o$a:errorCode	I
    //   698: ldc_w 537
    //   701: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   704: goto -616 -> 88
    //   707: invokestatic 662	org/xwalk/core/XWalkEnvironment:hasAvailableVersion	()Z
    //   710: ifeq +38 -> 748
    //   713: aload 9
    //   715: getfield 566	com/tencent/xweb/xwalk/updater/d:aiqE	I
    //   718: iconst_1
    //   719: iadd
    //   720: iconst_2
    //   721: if_icmpge +27 -> 748
    //   724: ldc 61
    //   726: ldc_w 664
    //   729: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   732: aload 10
    //   734: bipush 246
    //   736: putfield 563	com/tencent/xweb/xwalk/o$a:errorCode	I
    //   739: ldc_w 537
    //   742: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   745: goto -657 -> 88
    //   748: ldc 61
    //   750: ldc_w 666
    //   753: invokestatic 67	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload 10
    //   758: bipush 245
    //   760: putfield 563	com/tencent/xweb/xwalk/o$a:errorCode	I
    //   763: goto -24 -> 739
    //   766: iload_2
    //   767: iconst_1
    //   768: iadd
    //   769: istore_2
    //   770: goto -369 -> 401
    //   773: iconst_m1
    //   774: istore 4
    //   776: aload_1
    //   777: astore 8
    //   779: goto -275 -> 504
    //   782: iload_3
    //   783: iconst_1
    //   784: iadd
    //   785: istore_3
    //   786: goto -604 -> 182
    //   789: iconst_1
    //   790: istore_2
    //   791: goto -9 -> 782
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	this	o
    //   0	794	1	paramn	com.tencent.xweb.xwalk.updater.n
    //   169	622	2	i	int
    //   181	605	3	j	int
    //   298	477	4	k	int
    //   341	150	5	m	int
    //   178	8	6	n	int
    //   329	3	7	bool	boolean
    //   311	26	8	localCharSequence	java.lang.CharSequence
    //   371	8	8	localObject	Object
    //   474	304	8	localn	com.tencent.xweb.xwalk.updater.n
    //   12	702	9	locald	com.tencent.xweb.xwalk.updater.d
    //   47	710	10	locala	a
    //   129	414	11	localContentResolver	ContentResolver
    //   166	395	12	localUpdateConfig	UpdateConfig
    //   173	16	13	arrayOfString	String[]
    //   192	353	14	str	String
    //   255	156	15	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   336	364	371	finally
    //   2	88	392	finally
    //   93	123	392	finally
    //   126	131	392	finally
    //   136	157	392	finally
    //   160	168	392	finally
    //   170	180	392	finally
    //   194	292	392	finally
    //   296	300	392	finally
    //   313	331	392	finally
    //   373	389	392	finally
    //   401	434	392	finally
    //   438	466	392	finally
    //   476	501	392	finally
    //   509	521	392	finally
    //   526	593	392	finally
    //   597	609	392	finally
    //   618	630	392	finally
    //   641	653	392	finally
    //   664	676	392	finally
    //   683	704	392	finally
    //   707	739	392	finally
    //   739	745	392	finally
    //   748	763	392	finally
  }
  
  public final Integer a(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(212881);
    String str1 = paramUpdateConfig.gEb();
    String str2 = XWalkFileUtil.getExtractedCoreDir(paramUpdateConfig.aiqN);
    Log.i("XWalkUpdater", "tryInstallRuntime, packageFile:" + str1 + ", extractDir:" + str2);
    if ((paramUpdateConfig.aiqJ) && (!h.rb(str1, paramUpdateConfig.aiqK)))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "downloaded zip md5 check failed");
      AppMethodBeat.o(212881);
      return Integer.valueOf(-2);
    }
    if (paramUpdateConfig.ailq)
    {
      if (!bm(str1, paramUpdateConfig.aiqy, paramUpdateConfig.aiqN))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "patch update mode, do patch error");
        AppMethodBeat.o(212881);
        return Integer.valueOf(-3);
      }
      if ((paramUpdateConfig.aiqJ) && (!com.tencent.xweb.xwalk.b.a.eA(paramUpdateConfig.aiqN, XWalkFileUtil.getPatchFileListConfig(paramUpdateConfig.aiqN))))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "patch update mode, md5 not match");
        l.Br(36L);
        AppMethodBeat.o(212881);
        return Integer.valueOf(-4);
      }
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "do patch update success");
    }
    for (;;)
    {
      paramUpdateConfig = al(paramUpdateConfig.aiqN, paramUpdateConfig.ZaV, paramUpdateConfig.aiqO);
      AppMethodBeat.o(212881);
      return paramUpdateConfig;
      if (!XWalkDecompressor.decompressDownloadFullZip(str1, paramUpdateConfig.aiqN))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "full update mode, decompress full zip error");
        l.Br(32L);
        AppMethodBeat.o(212881);
        return Integer.valueOf(-5);
      }
      if ((paramUpdateConfig.aiqJ) && (!com.tencent.xweb.xwalk.b.a.eA(paramUpdateConfig.aiqN, XWalkFileUtil.getDownloadZipFileListConfig(paramUpdateConfig.aiqN))))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "full update mode, md5 not match");
        l.Br(33L);
        AppMethodBeat.o(212881);
        return Integer.valueOf(-4);
      }
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "do full update success");
    }
  }
  
  public static final class a
  {
    public int aipq = -1;
    public int aipr = 0;
    public int aips = 0;
    public int aipt = 0;
    public int aipu = 0;
    public int aipv = 0;
    public int aipw = 0;
    public int aipx = 0;
    public int errorCode = -11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.o
 * JD-Core Version:    0.7.0.1
 */