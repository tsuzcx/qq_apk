package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.c.b.b;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class e
  extends c
{
  private static ArrayList<File> ZMn = new ArrayList();
  private static ArrayList<ShareDexDiffPatchInfo> ZMo = new ArrayList();
  private static HashMap<ShareDexDiffPatchInfo, File> ZMp = new HashMap();
  private static boolean isVmArt = ShareTinkerInternals.isVmArt();
  
  /* Error */
  private static void a(ZipFile paramZipFile1, ZipFile paramZipFile2, ZipEntry paramZipEntry1, ZipEntry paramZipEntry2, ShareDexDiffPatchInfo paramShareDexDiffPatchInfo, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 44	java/io/BufferedInputStream
    //   6: dup
    //   7: aload_0
    //   8: aload_2
    //   9: invokevirtual 50	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   12: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: aload_3
    //   17: ifnull +181 -> 198
    //   20: new 44	java/io/BufferedInputStream
    //   23: dup
    //   24: aload_1
    //   25: aload_3
    //   26: invokevirtual 50	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   29: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_0
    //   33: aload 4
    //   35: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   38: invokestatic 65	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isRawDexFile	(Ljava/lang/String;)Z
    //   41: istore 6
    //   43: iload 6
    //   45: ifeq +15 -> 60
    //   48: aload 4
    //   50: getfield 68	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:isJarMode	Z
    //   53: istore 7
    //   55: iload 7
    //   57: ifeq +200 -> 257
    //   60: new 70	java/util/zip/ZipOutputStream
    //   63: dup
    //   64: new 72	java/io/BufferedOutputStream
    //   67: dup
    //   68: new 74	java/io/FileOutputStream
    //   71: dup
    //   72: aload 5
    //   74: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   77: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: invokespecial 81	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   83: astore 4
    //   85: aload 4
    //   87: new 83	java/util/zip/ZipEntry
    //   90: dup
    //   91: ldc 85
    //   93: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   96: invokevirtual 92	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   99: iload 6
    //   101: ifne +139 -> 240
    //   104: new 94	java/util/zip/ZipInputStream
    //   107: dup
    //   108: aload_2
    //   109: invokespecial 95	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   112: astore_3
    //   113: aload_3
    //   114: invokevirtual 99	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull +15 -> 134
    //   122: ldc 85
    //   124: aload_1
    //   125: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   128: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifeq -18 -> 113
    //   134: aload_1
    //   135: ifnonnull +68 -> 203
    //   138: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   141: dup
    //   142: new 113	java/lang/StringBuilder
    //   145: dup
    //   146: ldc 115
    //   148: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload 5
    //   153: invokevirtual 121	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokespecial 129	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   165: athrow
    //   166: astore_1
    //   167: aload_3
    //   168: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   171: aload_1
    //   172: athrow
    //   173: astore_1
    //   174: aload 4
    //   176: astore_3
    //   177: aload_3
    //   178: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_3
    //   184: aload_0
    //   185: astore_1
    //   186: aload_3
    //   187: astore_0
    //   188: aload_2
    //   189: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   192: aload_1
    //   193: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   196: aload_0
    //   197: athrow
    //   198: aconst_null
    //   199: astore_0
    //   200: goto -167 -> 33
    //   203: new 137	com/tencent/tinker/c/a/a
    //   206: dup
    //   207: aload_3
    //   208: aload_0
    //   209: invokespecial 140	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   212: aload 4
    //   214: invokevirtual 143	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
    //   217: aload_3
    //   218: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   221: aload 4
    //   223: invokevirtual 146	java/util/zip/ZipOutputStream:closeEntry	()V
    //   226: aload 4
    //   228: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   231: aload_2
    //   232: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   235: aload_0
    //   236: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   239: return
    //   240: new 137	com/tencent/tinker/c/a/a
    //   243: dup
    //   244: aload_2
    //   245: aload_0
    //   246: invokespecial 140	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   249: aload 4
    //   251: invokevirtual 143	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
    //   254: goto -33 -> 221
    //   257: new 137	com/tencent/tinker/c/a/a
    //   260: dup
    //   261: aload_2
    //   262: aload_0
    //   263: invokespecial 140	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   266: aload 5
    //   268: invokevirtual 149	com/tencent/tinker/c/a/a:V	(Ljava/io/File;)V
    //   271: goto -40 -> 231
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_2
    //   279: goto -91 -> 188
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -97 -> 188
    //   288: astore_1
    //   289: aload 8
    //   291: astore_3
    //   292: goto -115 -> 177
    //   295: astore_1
    //   296: aconst_null
    //   297: astore_3
    //   298: goto -131 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramZipFile1	ZipFile
    //   0	301	1	paramZipFile2	ZipFile
    //   0	301	2	paramZipEntry1	ZipEntry
    //   0	301	3	paramZipEntry2	ZipEntry
    //   0	301	4	paramShareDexDiffPatchInfo	ShareDexDiffPatchInfo
    //   0	301	5	paramFile	File
    //   41	59	6	bool1	boolean
    //   53	3	7	bool2	boolean
    //   1	289	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   113	118	166	finally
    //   122	134	166	finally
    //   138	166	166	finally
    //   203	217	166	finally
    //   85	99	173	finally
    //   167	173	173	finally
    //   217	221	173	finally
    //   221	226	173	finally
    //   240	254	173	finally
    //   33	43	183	finally
    //   48	55	183	finally
    //   177	183	183	finally
    //   226	231	183	finally
    //   257	271	183	finally
    //   3	16	274	finally
    //   20	33	282	finally
    //   60	85	288	finally
    //   104	113	295	finally
  }
  
  private static boolean a(Context paramContext, List<File> paramList, String paramString, File paramFile, com.tencent.tinker.lib.service.a parama)
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.mi(paramContext);
    ZMn.clear();
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
      return false;
    }
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = SharePatchFileUtil.optimizedPathFor((File)((Iterator)localObject1).next(), localFile);
      ZMn.add(new File((String)localObject2));
    }
    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[] { Integer.valueOf(paramList.size()), paramString });
    localObject1 = new Vector();
    Object localObject2 = new Throwable[1];
    if (parama != null) {
      parama.ZMv = System.currentTimeMillis();
    }
    boolean bool = TinkerApplication.getInstance().isUseDelegateLastClassLoader();
    paramString = new boolean[1];
    paramString[0] = 0;
    TinkerDexOptimizer.optimizeAll(paramContext, paramList, localFile, bool, new TinkerDexOptimizer.ResultCallback()
    {
      long startTime;
      
      public final void onFailed(File paramAnonymousFile1, File paramAnonymousFile2, Throwable paramAnonymousThrowable)
      {
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", new Object[] { paramAnonymousFile1.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime) });
        this.ZMr.add(paramAnonymousFile1);
        this.ZMs[0] = paramAnonymousThrowable;
      }
      
      public final void onStart(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        this.startTime = System.currentTimeMillis();
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", new Object[] { paramAnonymousFile1.getPath(), Long.valueOf(paramAnonymousFile1.length()) });
      }
      
      public final void onSuccess(File arg1, File paramAnonymousFile2, File paramAnonymousFile3)
      {
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", new Object[] { ???.getPath(), paramAnonymousFile3.getPath(), Long.valueOf(paramAnonymousFile3.length()), Long.valueOf(System.currentTimeMillis() - this.startTime) });
        if (!paramAnonymousFile3.exists()) {}
        synchronized (this.ZMq)
        {
          this.ZMq[0] = true;
          return;
        }
      }
    });
    if (parama != null) {
      if (paramString[0] != 0) {
        break label252;
      }
    }
    for (bool = true;; bool = false) {
      label252:
      try
      {
        parama.ZMw = bool;
        if (((List)localObject1).isEmpty()) {
          break;
        }
        return false;
      }
      finally {}
    }
    return true;
  }
  
  protected static boolean a(com.tencent.tinker.lib.e.a parama, ShareSecurityCheck paramShareSecurityCheck, Context paramContext, String paramString, File paramFile, com.tencent.tinker.lib.service.a parama1)
  {
    if (!ShareTinkerInternals.isTinkerEnabledForDex(parama.tinkerFlags))
    {
      ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
      return true;
    }
    parama = (String)paramShareSecurityCheck.getMetaContentMap().get("assets/dex_meta.txt");
    if (parama == null)
    {
      ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
      return true;
    }
    long l = SystemClock.elapsedRealtime();
    paramShareSecurityCheck = paramString + "/dex/";
    if (!b(paramContext, paramShareSecurityCheck, parama, paramFile)) {
      ShareTinkerLog.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
    }
    for (boolean bool = false;; bool = a(paramContext, paramShareSecurityCheck, paramString + "/odex/", paramFile, parama1))
    {
      ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", new Object[] { Boolean.valueOf(bool), Long.valueOf(SystemClock.elapsedRealtime() - l) });
      return bool;
      parama = new File(paramShareSecurityCheck).listFiles();
      paramShareSecurityCheck = new ArrayList();
      if (parama != null)
      {
        int j = parama.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = parama[i];
          String str = localObject.getName();
          if ((localObject.isFile()) && ((str.endsWith(".dex")) || (str.endsWith(".jar")) || (str.endsWith(".apk")))) {
            paramShareSecurityCheck.add(localObject);
          }
          i += 1;
        }
      }
      ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "legal files to do dexopt: ".concat(String.valueOf(paramShareSecurityCheck)), new Object[0]);
    }
  }
  
  protected static boolean a(File paramFile, com.tencent.tinker.lib.e.a parama)
  {
    if (ZMn.isEmpty()) {
      return true;
    }
    int j = ZMo.size() * 30;
    int i = j;
    if (j > 120) {
      i = 120;
    }
    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", new Object[] { Integer.valueOf(ZMo.size()), Integer.valueOf(ZMn.size()), Integer.valueOf(i) });
    j = 0;
    for (;;)
    {
      if (j < i)
      {
        Iterator localIterator1 = ZMn.iterator();
        int k;
        for (;;)
        {
          if (localIterator1.hasNext())
          {
            localObject1 = (File)localIterator1.next();
            if ((!SharePatchFileUtil.isLegalFile((File)localObject1)) && (!SharePatchFileUtil.shouldAcceptEvenIfIllegal((File)localObject1)))
            {
              ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", new Object[] { ((File)localObject1).getName(), Integer.valueOf(j + 1) });
              k = 0;
              if (k != 0) {
                break;
              }
            }
          }
        }
        try
        {
          Thread.sleep(10000L);
          j += 1;
          continue;
          k = 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:".concat(String.valueOf(localInterruptedException)), new Object[0]);
          }
        }
      }
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator2 = ZMn.iterator();
    Object localObject2;
    while (localIterator2.hasNext())
    {
      localObject2 = (File)localIterator2.next();
      ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", new Object[] { ((File)localObject2).getPath(), Long.valueOf(((File)localObject2).length()) });
      if ((!SharePatchFileUtil.isLegalFile((File)localObject2)) && (!SharePatchFileUtil.shouldAcceptEvenIfIllegal((File)localObject2)))
      {
        ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", new Object[] { ((File)localObject2).getName() });
        ((List)localObject1).add(localObject2);
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      parama.ZMG.a(paramFile, (List)localObject1, new TinkerRuntimeException("checkDexOptExist failed"));
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject2 = ZMn.iterator();
      localIterator2 = null;
    }
    for (;;)
    {
      File localFile;
      if (((Iterator)localObject2).hasNext())
      {
        localFile = (File)((Iterator)localObject2).next();
        if (!SharePatchFileUtil.shouldAcceptEvenIfIllegal(localFile)) {
          ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", new Object[] { localFile.getName(), Long.valueOf(localFile.length()) });
        }
      }
      else
      {
        try
        {
          i = ShareElfFile.getFileTypeByMagic(localFile);
          if (i == 1)
          {
            try
            {
              ShareElfFile localShareElfFile = new ShareElfFile(localFile);
              b.closeQuietly(localShareElfFile);
              continue;
            }
            catch (Throwable localThrowable)
            {
              ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not elf format, return false", new Object[] { localFile.getName() });
              ((List)localObject1).add(localFile);
              b.closeQuietly(null);
              continue;
            }
            finally
            {
              b.closeQuietly(null);
            }
            if (!((List)localObject1).isEmpty())
            {
              if (localThrowable == null) {}
              for (TinkerRuntimeException localTinkerRuntimeException = new TinkerRuntimeException("checkDexOptFormat failed");; localTinkerRuntimeException = new TinkerRuntimeException("checkDexOptFormat failed", localTinkerRuntimeException))
              {
                parama.ZMG.a(paramFile, (List)localObject1, localTinkerRuntimeException);
                return false;
              }
            }
            return true;
          }
        }
        catch (IOException localIOException) {}
      }
    }
  }
  
  private static boolean a(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (isVmArt) {}
    for (String str1 = paramShareDexDiffPatchInfo.destMd5InArt;; str1 = paramShareDexDiffPatchInfo.destMd5InDvm)
    {
      String str2 = paramShareDexDiffPatchInfo.rawName;
      boolean bool = paramShareDexDiffPatchInfo.isJarMode;
      if ((!SharePatchFileUtil.isRawDexFile(str2)) || (!bool)) {
        break;
      }
      return b(paramZipFile, paramZipEntry, paramFile, str1);
    }
    return a(paramZipFile, paramZipEntry, paramFile, str1, true);
  }
  
  /* Error */
  private static boolean b(Context paramContext, File paramFile, String paramString)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/tinker/lib/c/e:ZMo	Ljava/util/ArrayList;
    //   3: invokevirtual 355	java/util/ArrayList:isEmpty	()Z
    //   6: ifne +9 -> 15
    //   9: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: new 118	java/io/File
    //   20: dup
    //   21: aload_2
    //   22: ldc_w 430
    //   25: invokespecial 433	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore 10
    //   30: getstatic 32	com/tencent/tinker/lib/c/e:ZMp	Ljava/util/HashMap;
    //   33: invokevirtual 434	java/util/HashMap:isEmpty	()Z
    //   36: ifeq +29 -> 65
    //   39: ldc 168
    //   41: ldc_w 436
    //   44: iconst_1
    //   45: anewarray 172	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: getstatic 32	com/tencent/tinker/lib/c/e:ZMp	Ljava/util/HashMap;
    //   53: invokevirtual 437	java/util/HashMap:size	()I
    //   56: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: iconst_1
    //   64: ireturn
    //   65: invokestatic 226	java/lang/System:currentTimeMillis	()J
    //   68: lstore_3
    //   69: aconst_null
    //   70: astore_2
    //   71: new 439	com/tencent/tinker/d/a/a
    //   74: dup
    //   75: new 72	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 74	java/io/FileOutputStream
    //   82: dup
    //   83: aload 10
    //   85: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   91: invokespecial 440	com/tencent/tinker/d/a/a:<init>	(Ljava/io/OutputStream;)V
    //   94: astore 8
    //   96: getstatic 32	com/tencent/tinker/lib/c/e:ZMp	Ljava/util/HashMap;
    //   99: invokevirtual 444	java/util/HashMap:keySet	()Ljava/util/Set;
    //   102: invokeinterface 447 1 0
    //   107: astore_2
    //   108: aload_2
    //   109: invokeinterface 189 1 0
    //   114: ifeq +457 -> 571
    //   117: aload_2
    //   118: invokeinterface 193 1 0
    //   123: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   126: astore 7
    //   128: getstatic 32	com/tencent/tinker/lib/c/e:ZMp	Ljava/util/HashMap;
    //   131: aload 7
    //   133: invokevirtual 290	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 118	java/io/File
    //   139: astore 9
    //   141: aload 7
    //   143: getfield 68	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:isJarMode	Z
    //   146: istore 5
    //   148: iload 5
    //   150: ifeq +310 -> 460
    //   153: new 46	java/util/zip/ZipFile
    //   156: dup
    //   157: aload 9
    //   159: invokespecial 448	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   162: astore 9
    //   164: aload 9
    //   166: ldc 85
    //   168: invokevirtual 452	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   171: astore 12
    //   173: new 83	java/util/zip/ZipEntry
    //   176: dup
    //   177: aload 7
    //   179: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   182: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   185: astore 11
    //   187: aload 11
    //   189: iconst_0
    //   190: invokevirtual 456	java/util/zip/ZipEntry:setMethod	(I)V
    //   193: aload 11
    //   195: aload 12
    //   197: invokevirtual 459	java/util/zip/ZipEntry:getSize	()J
    //   200: invokevirtual 462	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   203: aload 11
    //   205: aload 12
    //   207: invokevirtual 459	java/util/zip/ZipEntry:getSize	()J
    //   210: invokevirtual 465	java/util/zip/ZipEntry:setSize	(J)V
    //   213: aload 11
    //   215: aload 12
    //   217: invokevirtual 468	java/util/zip/ZipEntry:getCrc	()J
    //   220: invokevirtual 471	java/util/zip/ZipEntry:setCrc	(J)V
    //   223: aload 9
    //   225: aload 12
    //   227: invokevirtual 50	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   230: astore 7
    //   232: aload 8
    //   234: aload 11
    //   236: invokevirtual 473	com/tencent/tinker/d/a/a:a	(Ljava/util/zip/ZipEntry;)V
    //   239: aload 7
    //   241: aload 8
    //   243: invokestatic 476	com/tencent/tinker/c/b/b:e	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   246: aload 8
    //   248: invokevirtual 479	com/tencent/tinker/d/a/a:isL	()V
    //   251: aload 7
    //   253: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   256: aload 9
    //   258: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   261: goto -153 -> 108
    //   264: astore 7
    //   266: aload 8
    //   268: astore_2
    //   269: ldc 168
    //   271: aload 7
    //   273: ldc_w 481
    //   276: iconst_0
    //   277: anewarray 172	java/lang/Object
    //   280: invokestatic 485	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: aload_2
    //   284: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   287: iconst_0
    //   288: istore 5
    //   290: iload 5
    //   292: istore 6
    //   294: iload 5
    //   296: ifeq +91 -> 387
    //   299: getstatic 32	com/tencent/tinker/lib/c/e:ZMp	Ljava/util/HashMap;
    //   302: invokevirtual 444	java/util/HashMap:keySet	()Ljava/util/Set;
    //   305: invokeinterface 447 1 0
    //   310: astore_2
    //   311: iload 5
    //   313: istore 6
    //   315: aload_2
    //   316: invokeinterface 189 1 0
    //   321: ifeq +66 -> 387
    //   324: aload_2
    //   325: invokeinterface 193 1 0
    //   330: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   333: astore 7
    //   335: aload 10
    //   337: aload 7
    //   339: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   342: aload 7
    //   344: getfield 418	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InArt	Ljava/lang/String;
    //   347: invokestatic 489	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Z
    //   350: ifne -39 -> 311
    //   353: iconst_0
    //   354: istore 6
    //   356: ldc 168
    //   358: ldc_w 491
    //   361: iconst_2
    //   362: anewarray 172	java/lang/Object
    //   365: dup
    //   366: iconst_0
    //   367: aload 7
    //   369: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   372: aastore
    //   373: dup
    //   374: iconst_1
    //   375: aload 10
    //   377: invokevirtual 389	java/io/File:length	()J
    //   380: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   383: aastore
    //   384: invokestatic 371	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: iload 6
    //   389: ifeq +193 -> 582
    //   392: getstatic 32	com/tencent/tinker/lib/c/e:ZMp	Ljava/util/HashMap;
    //   395: invokevirtual 495	java/util/HashMap:values	()Ljava/util/Collection;
    //   398: invokeinterface 498 1 0
    //   403: astore_0
    //   404: aload_0
    //   405: invokeinterface 189 1 0
    //   410: ifeq +212 -> 622
    //   413: aload_0
    //   414: invokeinterface 193 1 0
    //   419: checkcast 118	java/io/File
    //   422: invokestatic 501	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   425: pop
    //   426: goto -22 -> 404
    //   429: astore_2
    //   430: aload 8
    //   432: invokevirtual 479	com/tencent/tinker/d/a/a:isL	()V
    //   435: aload_2
    //   436: athrow
    //   437: astore_2
    //   438: aload 7
    //   440: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   443: aload 9
    //   445: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   448: aload_2
    //   449: athrow
    //   450: astore_0
    //   451: aload 8
    //   453: astore_1
    //   454: aload_1
    //   455: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   458: aload_0
    //   459: athrow
    //   460: new 83	java/util/zip/ZipEntry
    //   463: dup
    //   464: aload 7
    //   466: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   469: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   472: astore 11
    //   474: aload 11
    //   476: iconst_0
    //   477: invokevirtual 456	java/util/zip/ZipEntry:setMethod	(I)V
    //   480: aload 11
    //   482: aload 9
    //   484: invokevirtual 389	java/io/File:length	()J
    //   487: invokevirtual 462	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   490: aload 11
    //   492: aload 9
    //   494: invokevirtual 389	java/io/File:length	()J
    //   497: invokevirtual 465	java/util/zip/ZipEntry:setSize	(J)V
    //   500: aload 11
    //   502: aload 9
    //   504: invokestatic 507	com/tencent/tinker/c/b/a:W	(Ljava/io/File;)J
    //   507: invokevirtual 471	java/util/zip/ZipEntry:setCrc	(J)V
    //   510: new 44	java/io/BufferedInputStream
    //   513: dup
    //   514: new 509	java/io/FileInputStream
    //   517: dup
    //   518: aload 9
    //   520: invokespecial 510	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   523: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   526: astore 7
    //   528: aload 8
    //   530: aload 11
    //   532: invokevirtual 473	com/tencent/tinker/d/a/a:a	(Ljava/util/zip/ZipEntry;)V
    //   535: aload 7
    //   537: aload 8
    //   539: invokestatic 476	com/tencent/tinker/c/b/b:e	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   542: aload 8
    //   544: invokevirtual 479	com/tencent/tinker/d/a/a:isL	()V
    //   547: aload 7
    //   549: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   552: goto -444 -> 108
    //   555: astore_2
    //   556: aload 8
    //   558: invokevirtual 479	com/tencent/tinker/d/a/a:isL	()V
    //   561: aload_2
    //   562: athrow
    //   563: astore_2
    //   564: aload 7
    //   566: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   569: aload_2
    //   570: athrow
    //   571: aload 8
    //   573: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   576: iconst_1
    //   577: istore 5
    //   579: goto -289 -> 290
    //   582: ldc 168
    //   584: ldc_w 512
    //   587: iconst_0
    //   588: anewarray 172	java/lang/Object
    //   591: invokestatic 371	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   594: aload 10
    //   596: invokestatic 501	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   599: pop
    //   600: aload_0
    //   601: invokestatic 156	com/tencent/tinker/lib/e/a:mi	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   604: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   607: aload_1
    //   608: aload 10
    //   610: aload 10
    //   612: invokevirtual 323	java/io/File:getName	()Ljava/lang/String;
    //   615: bipush 7
    //   617: invokeinterface 515 5 0
    //   622: ldc 168
    //   624: ldc_w 517
    //   627: iconst_4
    //   628: anewarray 172	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: aload 10
    //   635: invokevirtual 386	java/io/File:getPath	()Ljava/lang/String;
    //   638: aastore
    //   639: dup
    //   640: iconst_1
    //   641: iload 6
    //   643: invokestatic 313	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   646: aastore
    //   647: dup
    //   648: iconst_2
    //   649: aload 10
    //   651: invokevirtual 389	java/io/File:length	()J
    //   654: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   657: aastore
    //   658: dup
    //   659: iconst_3
    //   660: invokestatic 226	java/lang/System:currentTimeMillis	()J
    //   663: lload_3
    //   664: lsub
    //   665: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: aastore
    //   669: invokestatic 215	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: iload 6
    //   674: ireturn
    //   675: astore_0
    //   676: aconst_null
    //   677: astore_1
    //   678: goto -224 -> 454
    //   681: astore_0
    //   682: aload_2
    //   683: astore_1
    //   684: goto -230 -> 454
    //   687: astore 7
    //   689: goto -420 -> 269
    //   692: astore_2
    //   693: aconst_null
    //   694: astore 7
    //   696: goto -132 -> 564
    //   699: astore_2
    //   700: aconst_null
    //   701: astore 7
    //   703: aconst_null
    //   704: astore 9
    //   706: goto -268 -> 438
    //   709: astore_2
    //   710: aconst_null
    //   711: astore 7
    //   713: goto -275 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	paramContext	Context
    //   0	716	1	paramFile	File
    //   0	716	2	paramString	String
    //   68	596	3	l	long
    //   146	432	5	bool1	boolean
    //   292	381	6	bool2	boolean
    //   126	126	7	localObject1	Object
    //   264	8	7	localThrowable1	Throwable
    //   333	232	7	localObject2	Object
    //   687	1	7	localThrowable2	Throwable
    //   694	18	7	localObject3	Object
    //   94	478	8	locala	com.tencent.tinker.d.a.a
    //   139	566	9	localObject4	Object
    //   28	622	10	localFile	File
    //   185	346	11	localZipEntry1	ZipEntry
    //   171	55	12	localZipEntry2	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   96	108	264	java/lang/Throwable
    //   108	148	264	java/lang/Throwable
    //   251	261	264	java/lang/Throwable
    //   438	450	264	java/lang/Throwable
    //   460	510	264	java/lang/Throwable
    //   547	552	264	java/lang/Throwable
    //   564	571	264	java/lang/Throwable
    //   232	246	429	finally
    //   246	251	437	finally
    //   430	437	437	finally
    //   96	108	450	finally
    //   108	148	450	finally
    //   251	261	450	finally
    //   438	450	450	finally
    //   460	510	450	finally
    //   547	552	450	finally
    //   564	571	450	finally
    //   528	542	555	finally
    //   542	547	563	finally
    //   556	563	563	finally
    //   71	96	675	finally
    //   269	283	681	finally
    //   71	96	687	java/lang/Throwable
    //   510	528	692	finally
    //   153	164	699	finally
    //   164	232	709	finally
  }
  
  /* Error */
  private static boolean b(Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/tinker/lib/c/e:ZMo	Ljava/util/ArrayList;
    //   3: invokevirtual 159	java/util/ArrayList:clear	()V
    //   6: aload_2
    //   7: getstatic 27	com/tencent/tinker/lib/c/e:ZMo	Ljava/util/ArrayList;
    //   10: invokestatic 521	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:parseDexDiffPatchInfo	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   13: getstatic 27	com/tencent/tinker/lib/c/e:ZMo	Ljava/util/ArrayList;
    //   16: invokevirtual 355	java/util/ArrayList:isEmpty	()Z
    //   19: ifeq +24 -> 43
    //   22: ldc 168
    //   24: ldc_w 523
    //   27: iconst_1
    //   28: anewarray 172	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iconst_3
    //   34: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: iconst_1
    //   42: ireturn
    //   43: new 118	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 163	java/io/File:exists	()Z
    //   56: ifne +8 -> 64
    //   59: aload_2
    //   60: invokevirtual 166	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_0
    //   65: invokestatic 156	com/tencent/tinker/lib/e/a:mi	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   68: astore 10
    //   70: aconst_null
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 8
    //   76: aload_0
    //   77: invokevirtual 533	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   80: astore_2
    //   81: aload_2
    //   82: ifnonnull +25 -> 107
    //   85: ldc 168
    //   87: ldc_w 535
    //   90: iconst_0
    //   91: anewarray 172	java/lang/Object
    //   94: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   101: aconst_null
    //   102: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: new 46	java/util/zip/ZipFile
    //   110: dup
    //   111: aload_2
    //   112: getfield 544	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   115: invokespecial 545	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   118: astore_2
    //   119: new 46	java/util/zip/ZipFile
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 448	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   127: astore 7
    //   129: aload_1
    //   130: invokestatic 548	com/tencent/tinker/lib/c/e:bDF	(Ljava/lang/String;)Z
    //   133: ifeq +32 -> 165
    //   136: ldc 168
    //   138: ldc_w 550
    //   141: iconst_1
    //   142: anewarray 172	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc_w 430
    //   150: aastore
    //   151: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload_2
    //   155: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   158: aload 7
    //   160: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   163: iconst_1
    //   164: ireturn
    //   165: getstatic 27	com/tencent/tinker/lib/c/e:ZMo	Ljava/util/ArrayList;
    //   168: invokevirtual 359	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   171: astore 11
    //   173: aload 11
    //   175: invokeinterface 189 1 0
    //   180: ifeq +1192 -> 1372
    //   183: aload 11
    //   185: invokeinterface 193 1 0
    //   190: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   193: astore 12
    //   195: invokestatic 226	java/lang/System:currentTimeMillis	()J
    //   198: lstore 4
    //   200: aload 12
    //   202: getfield 553	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   205: ldc_w 555
    //   208: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifeq +133 -> 344
    //   214: aload 12
    //   216: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   219: astore 8
    //   221: aload 12
    //   223: getfield 558	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:dexDiffMd5	Ljava/lang/String;
    //   226: astore 14
    //   228: aload 12
    //   230: getfield 561	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:oldDexCrC	Ljava/lang/String;
    //   233: astore 13
    //   235: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   238: ifne +143 -> 381
    //   241: aload 12
    //   243: getfield 424	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InDvm	Ljava/lang/String;
    //   246: ldc_w 563
    //   249: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   252: ifeq +129 -> 381
    //   255: ldc 168
    //   257: ldc_w 565
    //   260: iconst_1
    //   261: anewarray 172	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 8
    //   268: aastore
    //   269: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: goto -99 -> 173
    //   275: astore_1
    //   276: aload_2
    //   277: astore_0
    //   278: aload 7
    //   280: astore_2
    //   281: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   284: dup
    //   285: new 113	java/lang/StringBuilder
    //   288: dup
    //   289: ldc_w 567
    //   292: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   295: iconst_3
    //   296: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   299: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 569
    //   305: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_1
    //   309: invokevirtual 572	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   312: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 574
    //   318: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload_1
    //   325: invokespecial 414	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: athrow
    //   329: astore_3
    //   330: aload_0
    //   331: astore_1
    //   332: aload_3
    //   333: astore_0
    //   334: aload_1
    //   335: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   338: aload_2
    //   339: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   342: aload_0
    //   343: athrow
    //   344: new 113	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   351: aload 12
    //   353: getfield 553	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   356: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 576
    //   362: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 12
    //   367: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   370: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: astore 8
    //   378: goto -157 -> 221
    //   381: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   384: ifeq +76 -> 460
    //   387: aload 12
    //   389: getfield 418	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InArt	Ljava/lang/String;
    //   392: astore 9
    //   394: aload 9
    //   396: invokestatic 579	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   399: ifne +71 -> 470
    //   402: ldc 168
    //   404: ldc_w 581
    //   407: iconst_3
    //   408: anewarray 172	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: iconst_3
    //   414: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   417: aastore
    //   418: dup
    //   419: iconst_1
    //   420: aload 12
    //   422: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   425: aastore
    //   426: dup
    //   427: iconst_2
    //   428: aload 9
    //   430: aastore
    //   431: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: aload 10
    //   436: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   439: aload_3
    //   440: iconst_3
    //   441: invokestatic 585	com/tencent/tinker/lib/c/c:aCh	(I)I
    //   444: invokeinterface 589 3 0
    //   449: aload_2
    //   450: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   453: aload 7
    //   455: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   458: iconst_0
    //   459: ireturn
    //   460: aload 12
    //   462: getfield 424	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InDvm	Ljava/lang/String;
    //   465: astore 9
    //   467: goto -73 -> 394
    //   470: new 118	java/io/File
    //   473: dup
    //   474: new 113	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   481: aload_1
    //   482: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 12
    //   487: getfield 592	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:realName	Ljava/lang/String;
    //   490: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   499: astore 15
    //   501: aload 15
    //   503: invokevirtual 163	java/io/File:exists	()Z
    //   506: ifeq +155 -> 661
    //   509: aload 15
    //   511: aload 9
    //   513: invokestatic 595	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   516: ifeq +26 -> 542
    //   519: ldc 168
    //   521: ldc_w 597
    //   524: iconst_1
    //   525: anewarray 172	java/lang/Object
    //   528: dup
    //   529: iconst_0
    //   530: aload 15
    //   532: invokevirtual 386	java/io/File:getPath	()Ljava/lang/String;
    //   535: aastore
    //   536: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   539: goto -366 -> 173
    //   542: ldc 168
    //   544: new 113	java/lang/StringBuilder
    //   547: dup
    //   548: ldc_w 599
    //   551: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   554: aload 15
    //   556: invokevirtual 386	java/io/File:getPath	()Ljava/lang/String;
    //   559: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: iconst_0
    //   566: anewarray 172	java/lang/Object
    //   569: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: aload 15
    //   574: invokevirtual 602	java/io/File:delete	()Z
    //   577: pop
    //   578: aload 7
    //   580: aload 8
    //   582: invokevirtual 452	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   585: astore 17
    //   587: aload_2
    //   588: aload 8
    //   590: invokevirtual 452	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   593: astore 16
    //   595: aload 13
    //   597: ldc_w 563
    //   600: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   603: ifeq +144 -> 747
    //   606: aload 17
    //   608: ifnonnull +65 -> 673
    //   611: ldc 168
    //   613: ldc_w 604
    //   616: aload 8
    //   618: invokestatic 341	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   621: invokevirtual 345	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   624: iconst_0
    //   625: anewarray 172	java/lang/Object
    //   628: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: aload 10
    //   633: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   636: aload_3
    //   637: aload 15
    //   639: aload 12
    //   641: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   644: iconst_3
    //   645: invokeinterface 515 5 0
    //   650: aload_2
    //   651: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   654: aload 7
    //   656: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   659: iconst_0
    //   660: ireturn
    //   661: aload 15
    //   663: invokevirtual 608	java/io/File:getParentFile	()Ljava/io/File;
    //   666: invokevirtual 166	java/io/File:mkdirs	()Z
    //   669: pop
    //   670: goto -92 -> 578
    //   673: aload 7
    //   675: aload 17
    //   677: aload 15
    //   679: aload 12
    //   681: invokestatic 610	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   684: ifne -511 -> 173
    //   687: ldc 168
    //   689: new 113	java/lang/StringBuilder
    //   692: dup
    //   693: ldc_w 612
    //   696: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   699: aload 15
    //   701: invokevirtual 386	java/io/File:getPath	()Ljava/lang/String;
    //   704: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: iconst_0
    //   711: anewarray 172	java/lang/Object
    //   714: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   717: aload 10
    //   719: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   722: aload_3
    //   723: aload 15
    //   725: aload 12
    //   727: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   730: iconst_3
    //   731: invokeinterface 515 5 0
    //   736: aload_2
    //   737: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   740: aload 7
    //   742: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   745: iconst_0
    //   746: ireturn
    //   747: aload 14
    //   749: ldc_w 563
    //   752: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   755: ifeq +228 -> 983
    //   758: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   761: ifeq -588 -> 173
    //   764: aload 16
    //   766: ifnonnull +53 -> 819
    //   769: ldc 168
    //   771: ldc_w 614
    //   774: aload 8
    //   776: invokestatic 341	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   779: invokevirtual 345	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   782: iconst_0
    //   783: anewarray 172	java/lang/Object
    //   786: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   789: aload 10
    //   791: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   794: aload_3
    //   795: aload 15
    //   797: aload 12
    //   799: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   802: iconst_3
    //   803: invokeinterface 515 5 0
    //   808: aload_2
    //   809: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   812: aload 7
    //   814: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   817: iconst_0
    //   818: ireturn
    //   819: aload 16
    //   821: invokevirtual 468	java/util/zip/ZipEntry:getCrc	()J
    //   824: invokestatic 617	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   827: astore 14
    //   829: aload 14
    //   831: aload 13
    //   833: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   836: ifne +60 -> 896
    //   839: ldc 168
    //   841: ldc_w 619
    //   844: iconst_3
    //   845: anewarray 172	java/lang/Object
    //   848: dup
    //   849: iconst_0
    //   850: aload 8
    //   852: aastore
    //   853: dup
    //   854: iconst_1
    //   855: aload 13
    //   857: aastore
    //   858: dup
    //   859: iconst_2
    //   860: aload 14
    //   862: aastore
    //   863: invokestatic 371	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   866: aload 10
    //   868: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   871: aload_3
    //   872: aload 15
    //   874: aload 12
    //   876: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   879: iconst_3
    //   880: invokeinterface 515 5 0
    //   885: aload_2
    //   886: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   889: aload 7
    //   891: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   894: iconst_0
    //   895: ireturn
    //   896: aload_2
    //   897: aload 16
    //   899: aload 15
    //   901: aload 12
    //   903: invokestatic 610	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   906: pop
    //   907: aload 15
    //   909: aload 9
    //   911: invokestatic 595	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   914: ifne -741 -> 173
    //   917: ldc 168
    //   919: new 113	java/lang/StringBuilder
    //   922: dup
    //   923: ldc_w 621
    //   926: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   929: aload 15
    //   931: invokevirtual 386	java/io/File:getPath	()Ljava/lang/String;
    //   934: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: iconst_0
    //   941: anewarray 172	java/lang/Object
    //   944: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: aload 10
    //   949: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   952: aload_3
    //   953: aload 15
    //   955: aload 12
    //   957: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   960: iconst_3
    //   961: invokeinterface 515 5 0
    //   966: aload 15
    //   968: invokestatic 501	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   971: pop
    //   972: aload_2
    //   973: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   976: aload 7
    //   978: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   981: iconst_0
    //   982: ireturn
    //   983: aload 17
    //   985: ifnonnull +53 -> 1038
    //   988: ldc 168
    //   990: ldc_w 604
    //   993: aload 8
    //   995: invokestatic 341	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   998: invokevirtual 345	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1001: iconst_0
    //   1002: anewarray 172	java/lang/Object
    //   1005: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1008: aload 10
    //   1010: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   1013: aload_3
    //   1014: aload 15
    //   1016: aload 12
    //   1018: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1021: iconst_3
    //   1022: invokeinterface 515 5 0
    //   1027: aload_2
    //   1028: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1031: aload 7
    //   1033: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1036: iconst_0
    //   1037: ireturn
    //   1038: aload 14
    //   1040: invokestatic 579	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   1043: ifne +61 -> 1104
    //   1046: ldc 168
    //   1048: ldc_w 581
    //   1051: iconst_3
    //   1052: anewarray 172	java/lang/Object
    //   1055: dup
    //   1056: iconst_0
    //   1057: iconst_3
    //   1058: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   1061: aastore
    //   1062: dup
    //   1063: iconst_1
    //   1064: aload 12
    //   1066: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1069: aastore
    //   1070: dup
    //   1071: iconst_2
    //   1072: aload 14
    //   1074: aastore
    //   1075: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1078: aload 10
    //   1080: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   1083: aload_3
    //   1084: iconst_3
    //   1085: invokestatic 585	com/tencent/tinker/lib/c/c:aCh	(I)I
    //   1088: invokeinterface 589 3 0
    //   1093: aload_2
    //   1094: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1097: aload 7
    //   1099: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1102: iconst_0
    //   1103: ireturn
    //   1104: aload 16
    //   1106: ifnonnull +53 -> 1159
    //   1109: ldc 168
    //   1111: ldc_w 614
    //   1114: aload 8
    //   1116: invokestatic 341	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1119: invokevirtual 345	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1122: iconst_0
    //   1123: anewarray 172	java/lang/Object
    //   1126: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1129: aload 10
    //   1131: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   1134: aload_3
    //   1135: aload 15
    //   1137: aload 12
    //   1139: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1142: iconst_3
    //   1143: invokeinterface 515 5 0
    //   1148: aload_2
    //   1149: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1152: aload 7
    //   1154: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1157: iconst_0
    //   1158: ireturn
    //   1159: aload 16
    //   1161: invokevirtual 468	java/util/zip/ZipEntry:getCrc	()J
    //   1164: invokestatic 617	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1167: astore 14
    //   1169: aload 14
    //   1171: aload 13
    //   1173: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1176: ifne +60 -> 1236
    //   1179: ldc 168
    //   1181: ldc_w 619
    //   1184: iconst_3
    //   1185: anewarray 172	java/lang/Object
    //   1188: dup
    //   1189: iconst_0
    //   1190: aload 8
    //   1192: aastore
    //   1193: dup
    //   1194: iconst_1
    //   1195: aload 13
    //   1197: aastore
    //   1198: dup
    //   1199: iconst_2
    //   1200: aload 14
    //   1202: aastore
    //   1203: invokestatic 371	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1206: aload 10
    //   1208: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   1211: aload_3
    //   1212: aload 15
    //   1214: aload 12
    //   1216: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1219: iconst_3
    //   1220: invokeinterface 515 5 0
    //   1225: aload_2
    //   1226: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1229: aload 7
    //   1231: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1234: iconst_0
    //   1235: ireturn
    //   1236: aload_2
    //   1237: aload 7
    //   1239: aload 16
    //   1241: aload 17
    //   1243: aload 12
    //   1245: aload 15
    //   1247: invokestatic 623	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipEntry;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;Ljava/io/File;)V
    //   1250: aload 15
    //   1252: aload 9
    //   1254: invokestatic 595	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   1257: ifne +69 -> 1326
    //   1260: ldc 168
    //   1262: new 113	java/lang/StringBuilder
    //   1265: dup
    //   1266: ldc_w 621
    //   1269: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1272: aload 15
    //   1274: invokevirtual 386	java/io/File:getPath	()Ljava/lang/String;
    //   1277: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1283: iconst_0
    //   1284: anewarray 172	java/lang/Object
    //   1287: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1290: aload 10
    //   1292: getfield 260	com/tencent/tinker/lib/e/a:ZMG	Lcom/tencent/tinker/lib/d/d;
    //   1295: aload_3
    //   1296: aload 15
    //   1298: aload 12
    //   1300: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1303: iconst_3
    //   1304: invokeinterface 515 5 0
    //   1309: aload 15
    //   1311: invokestatic 501	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   1314: pop
    //   1315: aload_2
    //   1316: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1319: aload 7
    //   1321: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1324: iconst_0
    //   1325: ireturn
    //   1326: ldc 168
    //   1328: ldc_w 625
    //   1331: iconst_3
    //   1332: anewarray 172	java/lang/Object
    //   1335: dup
    //   1336: iconst_0
    //   1337: aload 15
    //   1339: invokevirtual 386	java/io/File:getPath	()Ljava/lang/String;
    //   1342: aastore
    //   1343: dup
    //   1344: iconst_1
    //   1345: aload 15
    //   1347: invokevirtual 389	java/io/File:length	()J
    //   1350: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1353: aastore
    //   1354: dup
    //   1355: iconst_2
    //   1356: invokestatic 226	java/lang/System:currentTimeMillis	()J
    //   1359: lload 4
    //   1361: lsub
    //   1362: invokestatic 318	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1365: aastore
    //   1366: invokestatic 178	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1369: goto -1196 -> 173
    //   1372: aload_0
    //   1373: aload_3
    //   1374: aload_1
    //   1375: invokestatic 627	com/tencent/tinker/lib/c/e:b	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z
    //   1378: istore 6
    //   1380: iload 6
    //   1382: ifne +14 -> 1396
    //   1385: aload_2
    //   1386: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1389: aload 7
    //   1391: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1394: iconst_0
    //   1395: ireturn
    //   1396: aload_2
    //   1397: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1400: aload 7
    //   1402: invokestatic 539	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1405: iconst_1
    //   1406: ireturn
    //   1407: astore_0
    //   1408: aconst_null
    //   1409: astore_1
    //   1410: aload 9
    //   1412: astore_2
    //   1413: goto -1079 -> 334
    //   1416: astore_0
    //   1417: aload_2
    //   1418: astore_1
    //   1419: aload 9
    //   1421: astore_2
    //   1422: goto -1088 -> 334
    //   1425: astore_1
    //   1426: aconst_null
    //   1427: astore_0
    //   1428: aload 8
    //   1430: astore_2
    //   1431: goto -1150 -> 281
    //   1434: astore_1
    //   1435: aload_2
    //   1436: astore_0
    //   1437: aload 8
    //   1439: astore_2
    //   1440: goto -1159 -> 281
    //   1443: astore_0
    //   1444: aload_2
    //   1445: astore_1
    //   1446: aload 7
    //   1448: astore_2
    //   1449: goto -1115 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1452	0	paramContext	Context
    //   0	1452	1	paramString1	String
    //   0	1452	2	paramString2	String
    //   0	1452	3	paramFile	File
    //   198	1162	4	l	long
    //   1378	3	6	bool	boolean
    //   127	1320	7	localZipFile	ZipFile
    //   74	1364	8	str1	String
    //   71	1349	9	str2	String
    //   68	1223	10	locala	com.tencent.tinker.lib.e.a
    //   171	13	11	localIterator	Iterator
    //   193	1106	12	localShareDexDiffPatchInfo	ShareDexDiffPatchInfo
    //   233	963	13	str3	String
    //   226	975	14	str4	String
    //   499	847	15	localFile	File
    //   593	647	16	localZipEntry1	ZipEntry
    //   585	657	17	localZipEntry2	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   129	154	275	java/lang/Throwable
    //   165	173	275	java/lang/Throwable
    //   173	221	275	java/lang/Throwable
    //   221	272	275	java/lang/Throwable
    //   344	378	275	java/lang/Throwable
    //   381	394	275	java/lang/Throwable
    //   394	449	275	java/lang/Throwable
    //   460	467	275	java/lang/Throwable
    //   470	539	275	java/lang/Throwable
    //   542	578	275	java/lang/Throwable
    //   578	606	275	java/lang/Throwable
    //   611	650	275	java/lang/Throwable
    //   661	670	275	java/lang/Throwable
    //   673	736	275	java/lang/Throwable
    //   747	764	275	java/lang/Throwable
    //   769	808	275	java/lang/Throwable
    //   819	885	275	java/lang/Throwable
    //   896	972	275	java/lang/Throwable
    //   988	1027	275	java/lang/Throwable
    //   1038	1093	275	java/lang/Throwable
    //   1109	1148	275	java/lang/Throwable
    //   1159	1225	275	java/lang/Throwable
    //   1236	1315	275	java/lang/Throwable
    //   1326	1369	275	java/lang/Throwable
    //   1372	1380	275	java/lang/Throwable
    //   281	329	329	finally
    //   76	81	1407	finally
    //   85	97	1407	finally
    //   107	119	1407	finally
    //   119	129	1416	finally
    //   76	81	1425	java/lang/Throwable
    //   85	97	1425	java/lang/Throwable
    //   107	119	1425	java/lang/Throwable
    //   119	129	1434	java/lang/Throwable
    //   129	154	1443	finally
    //   165	173	1443	finally
    //   173	221	1443	finally
    //   221	272	1443	finally
    //   344	378	1443	finally
    //   381	394	1443	finally
    //   394	449	1443	finally
    //   460	467	1443	finally
    //   470	539	1443	finally
    //   542	578	1443	finally
    //   578	606	1443	finally
    //   611	650	1443	finally
    //   661	670	1443	finally
    //   673	736	1443	finally
    //   747	764	1443	finally
    //   769	808	1443	finally
    //   819	885	1443	finally
    //   896	972	1443	finally
    //   988	1027	1443	finally
    //   1038	1093	1443	finally
    //   1109	1148	1443	finally
    //   1159	1225	1443	finally
    //   1236	1315	1443	finally
    //   1326	1369	1443	finally
    //   1372	1380	1443	finally
  }
  
  private static boolean b(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
  {
    boolean bool = false;
    int i = 0;
    if ((i < 2) && (!bool)) {
      ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "try Extracting " + paramFile.getPath(), new Object[0]);
    }
    try
    {
      localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile)));
    }
    finally
    {
      for (;;)
      {
        ZipOutputStream localZipOutputStream;
        BufferedInputStream localBufferedInputStream;
        try
        {
          localBufferedInputStream = new BufferedInputStream(paramZipFile.getInputStream(paramZipEntry));
        }
        finally
        {
          byte[] arrayOfByte;
          int j;
          paramZipEntry = null;
          paramFile = localZipOutputStream;
          continue;
        }
        try
        {
          arrayOfByte = new byte[16384];
          localZipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
          j = localBufferedInputStream.read(arrayOfByte);
          if (j != -1)
          {
            localZipOutputStream.write(arrayOfByte, 0, j);
            j = localBufferedInputStream.read(arrayOfByte);
          }
          else
          {
            localZipOutputStream.closeEntry();
            b.closeQuietly(localBufferedInputStream);
            b.closeQuietly(localZipOutputStream);
            bool = SharePatchFileUtil.verifyDexFileMd5(paramFile, paramString);
            ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", new Object[] { Boolean.valueOf(bool) });
            if ((!bool) && ((!paramFile.delete()) || (paramFile.exists()))) {
              ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + paramFile.getPath(), new Object[0]);
            }
            i += 1;
            break;
          }
        }
        finally
        {
          paramZipEntry = localBufferedInputStream;
          paramFile = localZipOutputStream;
        }
      }
      paramZipFile = finally;
      paramZipEntry = null;
      paramFile = null;
      b.closeQuietly(paramZipEntry);
      b.closeQuietly(paramFile);
      throw paramZipFile;
      return bool;
    }
  }
  
  private static boolean bDF(String paramString)
  {
    if ((ZMo.isEmpty()) || (!isVmArt)) {
      return false;
    }
    Iterator localIterator = ZMo.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      ShareDexDiffPatchInfo localShareDexDiffPatchInfo = (ShareDexDiffPatchInfo)localIterator.next();
      File localFile = new File(paramString + localShareDexDiffPatchInfo.realName);
      String str = localFile.getName();
      if (ShareConstants.CLASS_N_PATTERN.matcher(str).matches()) {
        ZMp.put(localShareDexDiffPatchInfo, localFile);
      }
      if (!localShareDexDiffPatchInfo.rawName.startsWith("test.dex")) {
        break label330;
      }
      localObject2 = localFile;
      localObject1 = localShareDexDiffPatchInfo;
    }
    label330:
    for (;;)
    {
      break;
      if (localObject1 != null) {
        ZMp.put(ShareTinkerInternals.changeTestDexToClassN((ShareDexDiffPatchInfo)localObject1, ZMp.size() + 1), localObject2);
      }
      paramString = new File(paramString, "tinker_classN.apk");
      if (paramString.exists())
      {
        localObject1 = ZMp.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ShareDexDiffPatchInfo)((Iterator)localObject1).next();
          if (!SharePatchFileUtil.verifyDexFileMd5(paramString, ((ShareDexDiffPatchInfo)localObject2).rawName, ((ShareDexDiffPatchInfo)localObject2).destMd5InArt)) {
            ShareTinkerLog.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[] { ((ShareDexDiffPatchInfo)localObject2).rawName, Long.valueOf(paramString.length()) });
          }
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!bool1) {
          SharePatchFileUtil.safeDeleteFile(paramString);
        }
        for (bool2 = bool1; bool2; bool2 = false)
        {
          paramString = ZMp.values().iterator();
          while (paramString.hasNext()) {
            SharePatchFileUtil.safeDeleteFile((File)paramString.next());
          }
        }
        return bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.c.e
 * JD-Core Version:    0.7.0.1
 */