package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.tinker.c.b.b;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
  private static ArrayList<File> ahRp = new ArrayList();
  private static ArrayList<ShareDexDiffPatchInfo> ahRq = new ArrayList();
  private static HashMap<ShareDexDiffPatchInfo, File> ahRr = new HashMap();
  private static boolean isVmArt = ShareTinkerInternals.isVmArt();
  
  /* Error */
  private static void a(ZipFile paramZipFile1, ZipFile paramZipFile2, ZipEntry paramZipEntry1, ZipEntry paramZipEntry2, ShareDexDiffPatchInfo paramShareDexDiffPatchInfo, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: new 44	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 50	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   15: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_3
    //   20: ifnull +181 -> 201
    //   23: new 44	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_1
    //   28: aload_3
    //   29: invokevirtual 50	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   32: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_0
    //   36: aload 4
    //   38: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   41: invokestatic 65	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isRawDexFile	(Ljava/lang/String;)Z
    //   44: istore 6
    //   46: iload 6
    //   48: ifeq +15 -> 63
    //   51: aload 4
    //   53: getfield 68	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:isJarMode	Z
    //   56: istore 7
    //   58: iload 7
    //   60: ifeq +200 -> 260
    //   63: new 70	java/util/zip/ZipOutputStream
    //   66: dup
    //   67: new 72	java/io/BufferedOutputStream
    //   70: dup
    //   71: new 74	java/io/FileOutputStream
    //   74: dup
    //   75: aload 5
    //   77: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   83: invokespecial 81	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore 4
    //   88: aload 4
    //   90: new 83	java/util/zip/ZipEntry
    //   93: dup
    //   94: ldc 85
    //   96: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 92	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   102: iload 6
    //   104: ifne +139 -> 243
    //   107: new 94	java/util/zip/ZipInputStream
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 95	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 99	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +15 -> 137
    //   125: ldc 85
    //   127: aload_1
    //   128: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   131: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq -18 -> 116
    //   137: aload_1
    //   138: ifnonnull +68 -> 206
    //   141: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   144: dup
    //   145: new 113	java/lang/StringBuilder
    //   148: dup
    //   149: ldc 115
    //   151: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload 5
    //   156: invokevirtual 121	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 129	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: astore_1
    //   170: aload_3
    //   171: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload 4
    //   179: astore_3
    //   180: aload_3
    //   181: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   184: aload_1
    //   185: athrow
    //   186: astore_3
    //   187: aload_0
    //   188: astore_1
    //   189: aload_3
    //   190: astore_0
    //   191: aload_2
    //   192: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   195: aload_1
    //   196: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   199: aload_0
    //   200: athrow
    //   201: aconst_null
    //   202: astore_0
    //   203: goto -167 -> 36
    //   206: new 137	com/tencent/tinker/c/a/a
    //   209: dup
    //   210: aload_3
    //   211: aload_0
    //   212: invokespecial 140	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   215: aload 4
    //   217: invokevirtual 143	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
    //   220: aload_3
    //   221: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   224: aload 4
    //   226: invokevirtual 146	java/util/zip/ZipOutputStream:closeEntry	()V
    //   229: aload 4
    //   231: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   234: aload_2
    //   235: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   238: aload_0
    //   239: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   242: return
    //   243: new 137	com/tencent/tinker/c/a/a
    //   246: dup
    //   247: aload_2
    //   248: aload_0
    //   249: invokespecial 140	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   252: aload 4
    //   254: invokevirtual 143	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
    //   257: goto -33 -> 224
    //   260: new 137	com/tencent/tinker/c/a/a
    //   263: dup
    //   264: aload_2
    //   265: aload_0
    //   266: invokespecial 140	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   269: astore_1
    //   270: new 72	java/io/BufferedOutputStream
    //   273: dup
    //   274: new 74	java/io/FileOutputStream
    //   277: dup
    //   278: aload 5
    //   280: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   286: astore_3
    //   287: aload_1
    //   288: aload_3
    //   289: invokevirtual 143	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
    //   292: aload_3
    //   293: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   296: goto -62 -> 234
    //   299: aload_3
    //   300: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   303: aload_1
    //   304: athrow
    //   305: astore_0
    //   306: aconst_null
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -119 -> 191
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_1
    //   316: goto -125 -> 191
    //   319: astore_1
    //   320: goto -21 -> 299
    //   323: astore_1
    //   324: aload 9
    //   326: astore_3
    //   327: goto -147 -> 180
    //   330: astore_1
    //   331: aconst_null
    //   332: astore_3
    //   333: goto -163 -> 170
    //   336: astore_1
    //   337: aload 8
    //   339: astore_3
    //   340: goto -41 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramZipFile1	ZipFile
    //   0	343	1	paramZipFile2	ZipFile
    //   0	343	2	paramZipEntry1	ZipEntry
    //   0	343	3	paramZipEntry2	ZipEntry
    //   0	343	4	paramShareDexDiffPatchInfo	ShareDexDiffPatchInfo
    //   0	343	5	paramFile	File
    //   44	59	6	bool1	boolean
    //   56	3	7	bool2	boolean
    //   1	337	8	localObject1	Object
    //   4	321	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   116	121	169	finally
    //   125	137	169	finally
    //   141	169	169	finally
    //   206	220	169	finally
    //   88	102	176	finally
    //   170	176	176	finally
    //   220	224	176	finally
    //   224	229	176	finally
    //   243	257	176	finally
    //   36	46	186	finally
    //   51	58	186	finally
    //   180	186	186	finally
    //   229	234	186	finally
    //   260	270	186	finally
    //   292	296	186	finally
    //   299	305	186	finally
    //   6	19	305	finally
    //   23	36	313	finally
    //   287	292	319	finally
    //   63	88	323	finally
    //   107	116	330	finally
    //   270	287	336	finally
  }
  
  private static boolean a(Context paramContext, List<File> paramList, String paramString, File paramFile, com.tencent.tinker.lib.service.a parama)
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.oy(paramContext);
    ahRp.clear();
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
      ahRp.add(new File((String)localObject2));
    }
    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[] { Integer.valueOf(paramList.size()), paramString });
    localObject1 = new Vector();
    Object localObject2 = new Throwable[1];
    if (parama != null) {
      parama.ahRx = System.currentTimeMillis();
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
        this.ahRt.add(paramAnonymousFile1);
        this.ahRu[0] = paramAnonymousThrowable;
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
        synchronized (this.ahRs)
        {
          this.ahRs[0] = true;
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
        parama.ahRy = bool;
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
  
  /* Error */
  protected static boolean a(File paramFile, com.tencent.tinker.lib.e.a parama)
  {
    // Byte code:
    //   0: getstatic 25	com/tencent/tinker/lib/c/e:ahRp	Ljava/util/ArrayList;
    //   3: invokevirtual 352	java/util/ArrayList:isEmpty	()Z
    //   6: ifeq +5 -> 11
    //   9: iconst_1
    //   10: ireturn
    //   11: getstatic 27	com/tencent/tinker/lib/c/e:ahRq	Ljava/util/ArrayList;
    //   14: invokevirtual 353	java/util/ArrayList:size	()I
    //   17: bipush 30
    //   19: imul
    //   20: istore_3
    //   21: iload_3
    //   22: istore_2
    //   23: iload_3
    //   24: bipush 120
    //   26: if_icmple +6 -> 32
    //   29: bipush 120
    //   31: istore_2
    //   32: ldc 165
    //   34: ldc_w 355
    //   37: iconst_3
    //   38: anewarray 169	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: getstatic 27	com/tencent/tinker/lib/c/e:ahRq	Ljava/util/ArrayList;
    //   46: invokevirtual 353	java/util/ArrayList:size	()I
    //   49: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: getstatic 25	com/tencent/tinker/lib/c/e:ahRp	Ljava/util/ArrayList;
    //   58: invokevirtual 353	java/util/ArrayList:size	()I
    //   61: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: iload_2
    //   68: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: invokestatic 212	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: iconst_0
    //   76: istore_3
    //   77: iload_3
    //   78: iload_2
    //   79: if_icmpge +130 -> 209
    //   82: getstatic 25	com/tencent/tinker/lib/c/e:ahRp	Ljava/util/ArrayList;
    //   85: invokevirtual 356	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   88: astore 5
    //   90: aload 5
    //   92: invokeinterface 186 1 0
    //   97: ifeq +81 -> 178
    //   100: aload 5
    //   102: invokeinterface 190 1 0
    //   107: checkcast 118	java/io/File
    //   110: astore 6
    //   112: aload 6
    //   114: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   117: ifne -27 -> 90
    //   120: aload 6
    //   122: invokestatic 363	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:shouldAcceptEvenIfIllegal	(Ljava/io/File;)Z
    //   125: ifne -35 -> 90
    //   128: ldc 165
    //   130: ldc_w 365
    //   133: iconst_2
    //   134: anewarray 169	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload 6
    //   141: invokevirtual 320	java/io/File:getName	()Ljava/lang/String;
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: iload_3
    //   148: iconst_1
    //   149: iadd
    //   150: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: aastore
    //   154: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: iconst_0
    //   158: istore 4
    //   160: iload 4
    //   162: ifne +9 -> 171
    //   165: ldc2_w 369
    //   168: invokestatic 376	java/lang/Thread:sleep	(J)V
    //   171: iload_3
    //   172: iconst_1
    //   173: iadd
    //   174: istore_3
    //   175: goto -98 -> 77
    //   178: iconst_1
    //   179: istore 4
    //   181: goto -21 -> 160
    //   184: astore 5
    //   186: ldc 165
    //   188: ldc_w 378
    //   191: aload 5
    //   193: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   199: iconst_0
    //   200: anewarray 169	java/lang/Object
    //   203: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -35 -> 171
    //   209: new 20	java/util/ArrayList
    //   212: dup
    //   213: invokespecial 23	java/util/ArrayList:<init>	()V
    //   216: astore 6
    //   218: getstatic 25	com/tencent/tinker/lib/c/e:ahRp	Ljava/util/ArrayList;
    //   221: invokevirtual 356	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   224: astore 5
    //   226: aload 5
    //   228: invokeinterface 186 1 0
    //   233: ifeq +95 -> 328
    //   236: aload 5
    //   238: invokeinterface 190 1 0
    //   243: checkcast 118	java/io/File
    //   246: astore 7
    //   248: ldc 165
    //   250: ldc_w 380
    //   253: iconst_2
    //   254: anewarray 169	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 7
    //   261: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: aload 7
    //   269: invokevirtual 386	java/io/File:length	()J
    //   272: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: invokestatic 212	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload 7
    //   281: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:isLegalFile	(Ljava/io/File;)Z
    //   284: ifne -58 -> 226
    //   287: aload 7
    //   289: invokestatic 363	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:shouldAcceptEvenIfIllegal	(Ljava/io/File;)Z
    //   292: ifne -66 -> 226
    //   295: ldc 165
    //   297: ldc_w 388
    //   300: iconst_1
    //   301: anewarray 169	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: aload 7
    //   308: invokevirtual 320	java/io/File:getName	()Ljava/lang/String;
    //   311: aastore
    //   312: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: aload 6
    //   317: aload 7
    //   319: invokeinterface 333 2 0
    //   324: pop
    //   325: goto -99 -> 226
    //   328: aload 6
    //   330: invokeinterface 253 1 0
    //   335: ifne +27 -> 362
    //   338: aload_1
    //   339: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   342: aload_0
    //   343: aload 6
    //   345: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   348: dup
    //   349: ldc_w 390
    //   352: invokespecial 129	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   355: invokeinterface 262 4 0
    //   360: iconst_0
    //   361: ireturn
    //   362: getstatic 395	android/os/Build$VERSION:SDK_INT	I
    //   365: bipush 21
    //   367: if_icmplt +211 -> 578
    //   370: getstatic 25	com/tencent/tinker/lib/c/e:ahRp	Ljava/util/ArrayList;
    //   373: invokevirtual 356	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   376: astore 7
    //   378: aconst_null
    //   379: astore 5
    //   381: aload 7
    //   383: invokeinterface 186 1 0
    //   388: ifeq +130 -> 518
    //   391: aload 7
    //   393: invokeinterface 190 1 0
    //   398: checkcast 118	java/io/File
    //   401: astore 8
    //   403: aload 8
    //   405: invokestatic 363	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:shouldAcceptEvenIfIllegal	(Ljava/io/File;)Z
    //   408: ifne -27 -> 381
    //   411: ldc 165
    //   413: ldc_w 397
    //   416: iconst_2
    //   417: anewarray 169	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload 8
    //   424: invokevirtual 320	java/io/File:getName	()Ljava/lang/String;
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: aload 8
    //   432: invokevirtual 386	java/io/File:length	()J
    //   435: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: invokestatic 212	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: aload 8
    //   444: invokestatic 403	com/tencent/tinker/loader/shareutil/ShareElfFile:getFileTypeByMagic	(Ljava/io/File;)I
    //   447: istore_2
    //   448: iload_2
    //   449: iconst_1
    //   450: if_icmpne -69 -> 381
    //   453: new 399	com/tencent/tinker/loader/shareutil/ShareElfFile
    //   456: dup
    //   457: aload 8
    //   459: invokespecial 404	com/tencent/tinker/loader/shareutil/ShareElfFile:<init>	(Ljava/io/File;)V
    //   462: astore 9
    //   464: aload 9
    //   466: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   469: goto -88 -> 381
    //   472: astore 5
    //   474: ldc 165
    //   476: ldc_w 406
    //   479: iconst_1
    //   480: anewarray 169	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: aload 8
    //   487: invokevirtual 320	java/io/File:getName	()Ljava/lang/String;
    //   490: aastore
    //   491: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   494: aload 6
    //   496: aload 8
    //   498: invokeinterface 333 2 0
    //   503: pop
    //   504: aconst_null
    //   505: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   508: goto -127 -> 381
    //   511: astore_0
    //   512: aconst_null
    //   513: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   516: aload_0
    //   517: athrow
    //   518: aload 6
    //   520: invokeinterface 253 1 0
    //   525: ifne +53 -> 578
    //   528: aload 5
    //   530: ifnonnull +31 -> 561
    //   533: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   536: dup
    //   537: ldc_w 408
    //   540: invokespecial 129	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   543: astore 5
    //   545: aload_1
    //   546: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   549: aload_0
    //   550: aload 6
    //   552: aload 5
    //   554: invokeinterface 262 4 0
    //   559: iconst_0
    //   560: ireturn
    //   561: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   564: dup
    //   565: ldc_w 408
    //   568: aload 5
    //   570: invokespecial 411	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   573: astore 5
    //   575: goto -30 -> 545
    //   578: iconst_1
    //   579: ireturn
    //   580: astore 8
    //   582: goto -201 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	paramFile	File
    //   0	585	1	parama	com.tencent.tinker.lib.e.a
    //   22	429	2	i	int
    //   20	155	3	j	int
    //   158	22	4	k	int
    //   88	13	5	localIterator1	Iterator
    //   184	8	5	localInterruptedException	java.lang.InterruptedException
    //   224	156	5	localIterator2	Iterator
    //   472	57	5	localObject1	Object
    //   543	31	5	localTinkerRuntimeException	com.tencent.tinker.loader.TinkerRuntimeException
    //   110	441	6	localObject2	Object
    //   246	146	7	localObject3	Object
    //   401	96	8	localFile	File
    //   580	1	8	localIOException	java.io.IOException
    //   462	3	9	localShareElfFile	com.tencent.tinker.loader.shareutil.ShareElfFile
    // Exception table:
    //   from	to	target	type
    //   165	171	184	java/lang/InterruptedException
    //   453	464	472	finally
    //   474	504	511	finally
    //   442	448	580	java/io/IOException
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
    //   0: getstatic 27	com/tencent/tinker/lib/c/e:ahRq	Ljava/util/ArrayList;
    //   3: invokevirtual 352	java/util/ArrayList:isEmpty	()Z
    //   6: ifne +9 -> 15
    //   9: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: new 118	java/io/File
    //   20: dup
    //   21: aload_2
    //   22: ldc_w 427
    //   25: invokespecial 430	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore 10
    //   30: getstatic 32	com/tencent/tinker/lib/c/e:ahRr	Ljava/util/HashMap;
    //   33: invokevirtual 431	java/util/HashMap:isEmpty	()Z
    //   36: ifeq +29 -> 65
    //   39: ldc 165
    //   41: ldc_w 433
    //   44: iconst_1
    //   45: anewarray 169	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: getstatic 32	com/tencent/tinker/lib/c/e:ahRr	Ljava/util/HashMap;
    //   53: invokevirtual 434	java/util/HashMap:size	()I
    //   56: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: iconst_1
    //   64: ireturn
    //   65: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   68: lstore_3
    //   69: aconst_null
    //   70: astore_2
    //   71: new 436	com/tencent/tinker/d/a/a
    //   74: dup
    //   75: new 72	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 74	java/io/FileOutputStream
    //   82: dup
    //   83: aload 10
    //   85: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   91: invokespecial 437	com/tencent/tinker/d/a/a:<init>	(Ljava/io/OutputStream;)V
    //   94: astore 9
    //   96: getstatic 32	com/tencent/tinker/lib/c/e:ahRr	Ljava/util/HashMap;
    //   99: invokevirtual 441	java/util/HashMap:keySet	()Ljava/util/Set;
    //   102: invokeinterface 444 1 0
    //   107: astore_2
    //   108: aload_2
    //   109: invokeinterface 186 1 0
    //   114: ifeq +447 -> 561
    //   117: aload_2
    //   118: invokeinterface 190 1 0
    //   123: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   126: astore 7
    //   128: getstatic 32	com/tencent/tinker/lib/c/e:ahRr	Ljava/util/HashMap;
    //   131: aload 7
    //   133: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 118	java/io/File
    //   139: astore 8
    //   141: aload 7
    //   143: getfield 68	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:isJarMode	Z
    //   146: istore 5
    //   148: iload 5
    //   150: ifeq +300 -> 450
    //   153: new 46	java/util/zip/ZipFile
    //   156: dup
    //   157: aload 8
    //   159: invokespecial 445	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   162: astore 8
    //   164: aload 8
    //   166: ldc 85
    //   168: invokevirtual 449	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   171: astore 12
    //   173: new 83	java/util/zip/ZipEntry
    //   176: dup
    //   177: aload 7
    //   179: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   182: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   185: astore 11
    //   187: aload 11
    //   189: iconst_0
    //   190: invokevirtual 453	java/util/zip/ZipEntry:setMethod	(I)V
    //   193: aload 11
    //   195: aload 12
    //   197: invokevirtual 456	java/util/zip/ZipEntry:getSize	()J
    //   200: invokevirtual 459	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   203: aload 11
    //   205: aload 12
    //   207: invokevirtual 456	java/util/zip/ZipEntry:getSize	()J
    //   210: invokevirtual 462	java/util/zip/ZipEntry:setSize	(J)V
    //   213: aload 11
    //   215: aload 12
    //   217: invokevirtual 465	java/util/zip/ZipEntry:getCrc	()J
    //   220: invokevirtual 468	java/util/zip/ZipEntry:setCrc	(J)V
    //   223: aload 8
    //   225: aload 12
    //   227: invokevirtual 50	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   230: astore 7
    //   232: aload 9
    //   234: aload 11
    //   236: invokevirtual 470	com/tencent/tinker/d/a/a:a	(Ljava/util/zip/ZipEntry;)V
    //   239: aload 7
    //   241: aload 9
    //   243: invokestatic 474	com/tencent/tinker/c/b/b:g	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   246: aload 9
    //   248: invokevirtual 477	com/tencent/tinker/d/a/a:kci	()V
    //   251: aload 7
    //   253: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   256: aload 8
    //   258: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   261: goto -153 -> 108
    //   264: astore 7
    //   266: aload 9
    //   268: astore_2
    //   269: ldc 165
    //   271: aload 7
    //   273: ldc_w 479
    //   276: iconst_0
    //   277: anewarray 169	java/lang/Object
    //   280: invokestatic 483	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: aload_2
    //   284: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   287: iconst_0
    //   288: istore 5
    //   290: iload 5
    //   292: istore 6
    //   294: iload 5
    //   296: ifeq +91 -> 387
    //   299: getstatic 32	com/tencent/tinker/lib/c/e:ahRr	Ljava/util/HashMap;
    //   302: invokevirtual 441	java/util/HashMap:keySet	()Ljava/util/Set;
    //   305: invokeinterface 444 1 0
    //   310: astore_2
    //   311: iload 5
    //   313: istore 6
    //   315: aload_2
    //   316: invokeinterface 186 1 0
    //   321: ifeq +66 -> 387
    //   324: aload_2
    //   325: invokeinterface 190 1 0
    //   330: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   333: astore 7
    //   335: aload 10
    //   337: aload 7
    //   339: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   342: aload 7
    //   344: getfield 415	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InArt	Ljava/lang/String;
    //   347: invokestatic 487	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Z
    //   350: ifne -39 -> 311
    //   353: iconst_0
    //   354: istore 6
    //   356: ldc 165
    //   358: ldc_w 489
    //   361: iconst_2
    //   362: anewarray 169	java/lang/Object
    //   365: dup
    //   366: iconst_0
    //   367: aload 7
    //   369: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   372: aastore
    //   373: dup
    //   374: iconst_1
    //   375: aload 10
    //   377: invokevirtual 386	java/io/File:length	()J
    //   380: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   383: aastore
    //   384: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: iload 6
    //   389: ifeq +190 -> 579
    //   392: getstatic 32	com/tencent/tinker/lib/c/e:ahRr	Ljava/util/HashMap;
    //   395: invokevirtual 493	java/util/HashMap:values	()Ljava/util/Collection;
    //   398: invokeinterface 496 1 0
    //   403: astore_0
    //   404: aload_0
    //   405: invokeinterface 186 1 0
    //   410: ifeq +209 -> 619
    //   413: aload_0
    //   414: invokeinterface 190 1 0
    //   419: checkcast 118	java/io/File
    //   422: invokestatic 499	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   425: pop
    //   426: goto -22 -> 404
    //   429: astore_2
    //   430: aload 9
    //   432: invokevirtual 477	com/tencent/tinker/d/a/a:kci	()V
    //   435: aload_2
    //   436: athrow
    //   437: astore_2
    //   438: aload 7
    //   440: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   443: aload 8
    //   445: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   448: aload_2
    //   449: athrow
    //   450: new 83	java/util/zip/ZipEntry
    //   453: dup
    //   454: aload 7
    //   456: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   459: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   462: astore 11
    //   464: aload 11
    //   466: iconst_0
    //   467: invokevirtual 453	java/util/zip/ZipEntry:setMethod	(I)V
    //   470: aload 11
    //   472: aload 8
    //   474: invokevirtual 386	java/io/File:length	()J
    //   477: invokevirtual 459	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   480: aload 11
    //   482: aload 8
    //   484: invokevirtual 386	java/io/File:length	()J
    //   487: invokevirtual 462	java/util/zip/ZipEntry:setSize	(J)V
    //   490: aload 11
    //   492: aload 8
    //   494: invokestatic 505	com/tencent/tinker/c/b/a:aa	(Ljava/io/File;)J
    //   497: invokevirtual 468	java/util/zip/ZipEntry:setCrc	(J)V
    //   500: new 44	java/io/BufferedInputStream
    //   503: dup
    //   504: new 507	java/io/FileInputStream
    //   507: dup
    //   508: aload 8
    //   510: invokespecial 508	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   513: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   516: astore 7
    //   518: aload 9
    //   520: aload 11
    //   522: invokevirtual 470	com/tencent/tinker/d/a/a:a	(Ljava/util/zip/ZipEntry;)V
    //   525: aload 7
    //   527: aload 9
    //   529: invokestatic 474	com/tencent/tinker/c/b/b:g	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   532: aload 9
    //   534: invokevirtual 477	com/tencent/tinker/d/a/a:kci	()V
    //   537: aload 7
    //   539: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   542: goto -434 -> 108
    //   545: astore_2
    //   546: aload 9
    //   548: invokevirtual 477	com/tencent/tinker/d/a/a:kci	()V
    //   551: aload_2
    //   552: athrow
    //   553: astore_2
    //   554: aload 7
    //   556: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   559: aload_2
    //   560: athrow
    //   561: aload 9
    //   563: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   566: iconst_1
    //   567: istore 5
    //   569: goto -279 -> 290
    //   572: astore_0
    //   573: aload_2
    //   574: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   577: aload_0
    //   578: athrow
    //   579: ldc 165
    //   581: ldc_w 510
    //   584: iconst_0
    //   585: anewarray 169	java/lang/Object
    //   588: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: aload 10
    //   593: invokestatic 499	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   596: pop
    //   597: aload_0
    //   598: invokestatic 153	com/tencent/tinker/lib/e/a:oy	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   601: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   604: aload_1
    //   605: aload 10
    //   607: aload 10
    //   609: invokevirtual 320	java/io/File:getName	()Ljava/lang/String;
    //   612: bipush 7
    //   614: invokeinterface 513 5 0
    //   619: ldc 165
    //   621: ldc_w 515
    //   624: iconst_4
    //   625: anewarray 169	java/lang/Object
    //   628: dup
    //   629: iconst_0
    //   630: aload 10
    //   632: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   635: aastore
    //   636: dup
    //   637: iconst_1
    //   638: iload 6
    //   640: invokestatic 310	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   643: aastore
    //   644: dup
    //   645: iconst_2
    //   646: aload 10
    //   648: invokevirtual 386	java/io/File:length	()J
    //   651: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   654: aastore
    //   655: dup
    //   656: iconst_3
    //   657: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   660: lload_3
    //   661: lsub
    //   662: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   665: aastore
    //   666: invokestatic 212	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   669: iload 6
    //   671: ireturn
    //   672: astore 7
    //   674: goto -405 -> 269
    //   677: astore_2
    //   678: aconst_null
    //   679: astore 7
    //   681: goto -127 -> 554
    //   684: astore_2
    //   685: aconst_null
    //   686: astore 7
    //   688: aconst_null
    //   689: astore 8
    //   691: goto -253 -> 438
    //   694: astore_2
    //   695: aconst_null
    //   696: astore 7
    //   698: goto -260 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	paramContext	Context
    //   0	701	1	paramFile	File
    //   0	701	2	paramString	String
    //   68	593	3	l	long
    //   146	422	5	bool1	boolean
    //   292	378	6	bool2	boolean
    //   126	126	7	localObject1	Object
    //   264	8	7	localThrowable	Throwable
    //   333	222	7	localObject2	Object
    //   672	1	7	localObject3	Object
    //   679	18	7	localObject4	Object
    //   139	551	8	localObject5	Object
    //   94	468	9	locala	com.tencent.tinker.d.a.a
    //   28	619	10	localFile	File
    //   185	336	11	localZipEntry1	ZipEntry
    //   171	55	12	localZipEntry2	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   96	108	264	finally
    //   108	148	264	finally
    //   251	261	264	finally
    //   438	450	264	finally
    //   450	500	264	finally
    //   537	542	264	finally
    //   554	561	264	finally
    //   232	246	429	finally
    //   246	251	437	finally
    //   430	437	437	finally
    //   518	532	545	finally
    //   532	537	553	finally
    //   546	553	553	finally
    //   269	283	572	finally
    //   71	96	672	finally
    //   500	518	677	finally
    //   153	164	684	finally
    //   164	232	694	finally
  }
  
  /* Error */
  private static boolean b(Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/tinker/lib/c/e:ahRq	Ljava/util/ArrayList;
    //   3: invokevirtual 156	java/util/ArrayList:clear	()V
    //   6: aload_2
    //   7: getstatic 27	com/tencent/tinker/lib/c/e:ahRq	Ljava/util/ArrayList;
    //   10: invokestatic 519	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:parseDexDiffPatchInfo	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   13: getstatic 27	com/tencent/tinker/lib/c/e:ahRq	Ljava/util/ArrayList;
    //   16: invokevirtual 352	java/util/ArrayList:isEmpty	()Z
    //   19: ifeq +24 -> 43
    //   22: ldc 165
    //   24: ldc_w 521
    //   27: iconst_1
    //   28: anewarray 169	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iconst_3
    //   34: invokestatic 525	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: iconst_1
    //   42: ireturn
    //   43: new 118	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 160	java/io/File:exists	()Z
    //   56: ifne +8 -> 64
    //   59: aload_2
    //   60: invokevirtual 163	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_0
    //   65: invokestatic 153	com/tencent/tinker/lib/e/a:oy	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   68: astore 10
    //   70: aconst_null
    //   71: astore 7
    //   73: aload_0
    //   74: invokevirtual 531	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   77: astore_2
    //   78: aload_2
    //   79: ifnonnull +25 -> 104
    //   82: ldc 165
    //   84: ldc_w 533
    //   87: iconst_0
    //   88: anewarray 169	java/lang/Object
    //   91: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aconst_null
    //   95: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   98: aconst_null
    //   99: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   102: iconst_0
    //   103: ireturn
    //   104: new 46	java/util/zip/ZipFile
    //   107: dup
    //   108: aload_2
    //   109: getfield 542	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   112: invokespecial 543	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: new 46	java/util/zip/ZipFile
    //   119: dup
    //   120: aload_3
    //   121: invokespecial 445	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   124: astore 9
    //   126: aload_1
    //   127: invokestatic 546	com/tencent/tinker/lib/c/e:bGl	(Ljava/lang/String;)Z
    //   130: ifeq +32 -> 162
    //   133: ldc 165
    //   135: ldc_w 548
    //   138: iconst_1
    //   139: anewarray 169	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: ldc_w 427
    //   147: aastore
    //   148: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_2
    //   152: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   155: aload 9
    //   157: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   160: iconst_1
    //   161: ireturn
    //   162: getstatic 27	com/tencent/tinker/lib/c/e:ahRq	Ljava/util/ArrayList;
    //   165: invokevirtual 356	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   168: astore 11
    //   170: aload 11
    //   172: invokeinterface 186 1 0
    //   177: ifeq +1192 -> 1369
    //   180: aload 11
    //   182: invokeinterface 190 1 0
    //   187: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   190: astore 12
    //   192: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   195: lstore 4
    //   197: aload 12
    //   199: getfield 551	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   202: ldc_w 553
    //   205: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: ifeq +133 -> 341
    //   211: aload 12
    //   213: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   216: astore 7
    //   218: aload 12
    //   220: getfield 556	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:dexDiffMd5	Ljava/lang/String;
    //   223: astore 14
    //   225: aload 12
    //   227: getfield 559	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:oldDexCrC	Ljava/lang/String;
    //   230: astore 13
    //   232: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   235: ifne +143 -> 378
    //   238: aload 12
    //   240: getfield 421	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InDvm	Ljava/lang/String;
    //   243: ldc_w 561
    //   246: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +129 -> 378
    //   252: ldc 165
    //   254: ldc_w 563
    //   257: iconst_1
    //   258: anewarray 169	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload 7
    //   265: aastore
    //   266: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: goto -99 -> 170
    //   272: astore_3
    //   273: aload 9
    //   275: astore_0
    //   276: aload_2
    //   277: astore_1
    //   278: aload_0
    //   279: astore_2
    //   280: aload_3
    //   281: astore_0
    //   282: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   285: dup
    //   286: new 113	java/lang/StringBuilder
    //   289: dup
    //   290: ldc_w 565
    //   293: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   296: iconst_3
    //   297: invokestatic 525	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   300: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc_w 567
    //   306: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: invokevirtual 570	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 572
    //   319: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: aload_0
    //   326: invokespecial 411	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: athrow
    //   330: astore_0
    //   331: aload_1
    //   332: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   335: aload_2
    //   336: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   339: aload_0
    //   340: athrow
    //   341: new 113	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   348: aload 12
    //   350: getfield 551	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   353: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc_w 574
    //   359: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 12
    //   364: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   367: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: astore 7
    //   375: goto -157 -> 218
    //   378: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   381: ifeq +76 -> 457
    //   384: aload 12
    //   386: getfield 415	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InArt	Ljava/lang/String;
    //   389: astore 8
    //   391: aload 8
    //   393: invokestatic 577	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   396: ifne +71 -> 467
    //   399: ldc 165
    //   401: ldc_w 579
    //   404: iconst_3
    //   405: anewarray 169	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: iconst_3
    //   411: invokestatic 525	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   414: aastore
    //   415: dup
    //   416: iconst_1
    //   417: aload 12
    //   419: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   422: aastore
    //   423: dup
    //   424: iconst_2
    //   425: aload 8
    //   427: aastore
    //   428: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload 10
    //   433: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   436: aload_3
    //   437: iconst_3
    //   438: invokestatic 583	com/tencent/tinker/lib/c/c:aIW	(I)I
    //   441: invokeinterface 587 3 0
    //   446: aload_2
    //   447: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   450: aload 9
    //   452: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   455: iconst_0
    //   456: ireturn
    //   457: aload 12
    //   459: getfield 421	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InDvm	Ljava/lang/String;
    //   462: astore 8
    //   464: goto -73 -> 391
    //   467: new 118	java/io/File
    //   470: dup
    //   471: new 113	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   478: aload_1
    //   479: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 12
    //   484: getfield 590	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:realName	Ljava/lang/String;
    //   487: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   496: astore 15
    //   498: aload 15
    //   500: invokevirtual 160	java/io/File:exists	()Z
    //   503: ifeq +155 -> 658
    //   506: aload 15
    //   508: aload 8
    //   510: invokestatic 593	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   513: ifeq +26 -> 539
    //   516: ldc 165
    //   518: ldc_w 595
    //   521: iconst_1
    //   522: anewarray 169	java/lang/Object
    //   525: dup
    //   526: iconst_0
    //   527: aload 15
    //   529: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   532: aastore
    //   533: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   536: goto -366 -> 170
    //   539: ldc 165
    //   541: new 113	java/lang/StringBuilder
    //   544: dup
    //   545: ldc_w 597
    //   548: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   551: aload 15
    //   553: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   556: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: iconst_0
    //   563: anewarray 169	java/lang/Object
    //   566: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   569: aload 15
    //   571: invokevirtual 600	java/io/File:delete	()Z
    //   574: pop
    //   575: aload 9
    //   577: aload 7
    //   579: invokevirtual 449	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   582: astore 17
    //   584: aload_2
    //   585: aload 7
    //   587: invokevirtual 449	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   590: astore 16
    //   592: aload 13
    //   594: ldc_w 561
    //   597: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   600: ifeq +144 -> 744
    //   603: aload 17
    //   605: ifnonnull +65 -> 670
    //   608: ldc 165
    //   610: ldc_w 602
    //   613: aload 7
    //   615: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   618: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   621: iconst_0
    //   622: anewarray 169	java/lang/Object
    //   625: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   628: aload 10
    //   630: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   633: aload_3
    //   634: aload 15
    //   636: aload 12
    //   638: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   641: iconst_3
    //   642: invokeinterface 513 5 0
    //   647: aload_2
    //   648: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   651: aload 9
    //   653: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   656: iconst_0
    //   657: ireturn
    //   658: aload 15
    //   660: invokevirtual 606	java/io/File:getParentFile	()Ljava/io/File;
    //   663: invokevirtual 163	java/io/File:mkdirs	()Z
    //   666: pop
    //   667: goto -92 -> 575
    //   670: aload 9
    //   672: aload 17
    //   674: aload 15
    //   676: aload 12
    //   678: invokestatic 608	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   681: ifne -511 -> 170
    //   684: ldc 165
    //   686: new 113	java/lang/StringBuilder
    //   689: dup
    //   690: ldc_w 610
    //   693: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   696: aload 15
    //   698: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   701: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: iconst_0
    //   708: anewarray 169	java/lang/Object
    //   711: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   714: aload 10
    //   716: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   719: aload_3
    //   720: aload 15
    //   722: aload 12
    //   724: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   727: iconst_3
    //   728: invokeinterface 513 5 0
    //   733: aload_2
    //   734: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   737: aload 9
    //   739: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   742: iconst_0
    //   743: ireturn
    //   744: aload 14
    //   746: ldc_w 561
    //   749: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   752: ifeq +228 -> 980
    //   755: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   758: ifeq -588 -> 170
    //   761: aload 16
    //   763: ifnonnull +53 -> 816
    //   766: ldc 165
    //   768: ldc_w 612
    //   771: aload 7
    //   773: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   776: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   779: iconst_0
    //   780: anewarray 169	java/lang/Object
    //   783: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   786: aload 10
    //   788: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   791: aload_3
    //   792: aload 15
    //   794: aload 12
    //   796: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   799: iconst_3
    //   800: invokeinterface 513 5 0
    //   805: aload_2
    //   806: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   809: aload 9
    //   811: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   814: iconst_0
    //   815: ireturn
    //   816: aload 16
    //   818: invokevirtual 465	java/util/zip/ZipEntry:getCrc	()J
    //   821: invokestatic 615	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   824: astore 14
    //   826: aload 14
    //   828: aload 13
    //   830: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   833: ifne +60 -> 893
    //   836: ldc 165
    //   838: ldc_w 617
    //   841: iconst_3
    //   842: anewarray 169	java/lang/Object
    //   845: dup
    //   846: iconst_0
    //   847: aload 7
    //   849: aastore
    //   850: dup
    //   851: iconst_1
    //   852: aload 13
    //   854: aastore
    //   855: dup
    //   856: iconst_2
    //   857: aload 14
    //   859: aastore
    //   860: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   863: aload 10
    //   865: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   868: aload_3
    //   869: aload 15
    //   871: aload 12
    //   873: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   876: iconst_3
    //   877: invokeinterface 513 5 0
    //   882: aload_2
    //   883: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   886: aload 9
    //   888: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   891: iconst_0
    //   892: ireturn
    //   893: aload_2
    //   894: aload 16
    //   896: aload 15
    //   898: aload 12
    //   900: invokestatic 608	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   903: pop
    //   904: aload 15
    //   906: aload 8
    //   908: invokestatic 593	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   911: ifne -741 -> 170
    //   914: ldc 165
    //   916: new 113	java/lang/StringBuilder
    //   919: dup
    //   920: ldc_w 619
    //   923: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   926: aload 15
    //   928: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   931: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: iconst_0
    //   938: anewarray 169	java/lang/Object
    //   941: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   944: aload 10
    //   946: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   949: aload_3
    //   950: aload 15
    //   952: aload 12
    //   954: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   957: iconst_3
    //   958: invokeinterface 513 5 0
    //   963: aload 15
    //   965: invokestatic 499	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   968: pop
    //   969: aload_2
    //   970: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   973: aload 9
    //   975: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   978: iconst_0
    //   979: ireturn
    //   980: aload 17
    //   982: ifnonnull +53 -> 1035
    //   985: ldc 165
    //   987: ldc_w 602
    //   990: aload 7
    //   992: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   995: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   998: iconst_0
    //   999: anewarray 169	java/lang/Object
    //   1002: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1005: aload 10
    //   1007: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   1010: aload_3
    //   1011: aload 15
    //   1013: aload 12
    //   1015: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1018: iconst_3
    //   1019: invokeinterface 513 5 0
    //   1024: aload_2
    //   1025: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1028: aload 9
    //   1030: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1033: iconst_0
    //   1034: ireturn
    //   1035: aload 14
    //   1037: invokestatic 577	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   1040: ifne +61 -> 1101
    //   1043: ldc 165
    //   1045: ldc_w 579
    //   1048: iconst_3
    //   1049: anewarray 169	java/lang/Object
    //   1052: dup
    //   1053: iconst_0
    //   1054: iconst_3
    //   1055: invokestatic 525	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   1058: aastore
    //   1059: dup
    //   1060: iconst_1
    //   1061: aload 12
    //   1063: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1066: aastore
    //   1067: dup
    //   1068: iconst_2
    //   1069: aload 14
    //   1071: aastore
    //   1072: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1075: aload 10
    //   1077: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   1080: aload_3
    //   1081: iconst_3
    //   1082: invokestatic 583	com/tencent/tinker/lib/c/c:aIW	(I)I
    //   1085: invokeinterface 587 3 0
    //   1090: aload_2
    //   1091: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1094: aload 9
    //   1096: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1099: iconst_0
    //   1100: ireturn
    //   1101: aload 16
    //   1103: ifnonnull +53 -> 1156
    //   1106: ldc 165
    //   1108: ldc_w 612
    //   1111: aload 7
    //   1113: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1116: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1119: iconst_0
    //   1120: anewarray 169	java/lang/Object
    //   1123: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1126: aload 10
    //   1128: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   1131: aload_3
    //   1132: aload 15
    //   1134: aload 12
    //   1136: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1139: iconst_3
    //   1140: invokeinterface 513 5 0
    //   1145: aload_2
    //   1146: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1149: aload 9
    //   1151: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1154: iconst_0
    //   1155: ireturn
    //   1156: aload 16
    //   1158: invokevirtual 465	java/util/zip/ZipEntry:getCrc	()J
    //   1161: invokestatic 615	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1164: astore 14
    //   1166: aload 14
    //   1168: aload 13
    //   1170: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1173: ifne +60 -> 1233
    //   1176: ldc 165
    //   1178: ldc_w 617
    //   1181: iconst_3
    //   1182: anewarray 169	java/lang/Object
    //   1185: dup
    //   1186: iconst_0
    //   1187: aload 7
    //   1189: aastore
    //   1190: dup
    //   1191: iconst_1
    //   1192: aload 13
    //   1194: aastore
    //   1195: dup
    //   1196: iconst_2
    //   1197: aload 14
    //   1199: aastore
    //   1200: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1203: aload 10
    //   1205: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   1208: aload_3
    //   1209: aload 15
    //   1211: aload 12
    //   1213: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1216: iconst_3
    //   1217: invokeinterface 513 5 0
    //   1222: aload_2
    //   1223: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1226: aload 9
    //   1228: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1231: iconst_0
    //   1232: ireturn
    //   1233: aload_2
    //   1234: aload 9
    //   1236: aload 16
    //   1238: aload 17
    //   1240: aload 12
    //   1242: aload 15
    //   1244: invokestatic 621	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipEntry;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;Ljava/io/File;)V
    //   1247: aload 15
    //   1249: aload 8
    //   1251: invokestatic 593	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   1254: ifne +69 -> 1323
    //   1257: ldc 165
    //   1259: new 113	java/lang/StringBuilder
    //   1262: dup
    //   1263: ldc_w 619
    //   1266: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1269: aload 15
    //   1271: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   1274: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: iconst_0
    //   1281: anewarray 169	java/lang/Object
    //   1284: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1287: aload 10
    //   1289: getfield 257	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   1292: aload_3
    //   1293: aload 15
    //   1295: aload 12
    //   1297: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1300: iconst_3
    //   1301: invokeinterface 513 5 0
    //   1306: aload 15
    //   1308: invokestatic 499	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   1311: pop
    //   1312: aload_2
    //   1313: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1316: aload 9
    //   1318: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1321: iconst_0
    //   1322: ireturn
    //   1323: ldc 165
    //   1325: ldc_w 623
    //   1328: iconst_3
    //   1329: anewarray 169	java/lang/Object
    //   1332: dup
    //   1333: iconst_0
    //   1334: aload 15
    //   1336: invokevirtual 383	java/io/File:getPath	()Ljava/lang/String;
    //   1339: aastore
    //   1340: dup
    //   1341: iconst_1
    //   1342: aload 15
    //   1344: invokevirtual 386	java/io/File:length	()J
    //   1347: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1350: aastore
    //   1351: dup
    //   1352: iconst_2
    //   1353: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   1356: lload 4
    //   1358: lsub
    //   1359: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1362: aastore
    //   1363: invokestatic 175	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1366: goto -1196 -> 170
    //   1369: aload_0
    //   1370: aload_3
    //   1371: aload_1
    //   1372: invokestatic 625	com/tencent/tinker/lib/c/e:b	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z
    //   1375: istore 6
    //   1377: iload 6
    //   1379: ifne +14 -> 1393
    //   1382: aload_2
    //   1383: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1386: aload 9
    //   1388: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1391: iconst_0
    //   1392: ireturn
    //   1393: aload_2
    //   1394: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1397: aload 9
    //   1399: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1402: iconst_1
    //   1403: ireturn
    //   1404: astore_0
    //   1405: aconst_null
    //   1406: astore_1
    //   1407: aload 7
    //   1409: astore_2
    //   1410: goto -1128 -> 282
    //   1413: astore_0
    //   1414: aload_2
    //   1415: astore_1
    //   1416: aload 7
    //   1418: astore_2
    //   1419: goto -1137 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1422	0	paramContext	Context
    //   0	1422	1	paramString1	String
    //   0	1422	2	paramString2	String
    //   0	1422	3	paramFile	File
    //   195	1162	4	l	long
    //   1375	3	6	bool	boolean
    //   71	1346	7	str1	String
    //   389	861	8	str2	String
    //   124	1274	9	localZipFile	ZipFile
    //   68	1220	10	locala	com.tencent.tinker.lib.e.a
    //   168	13	11	localIterator	Iterator
    //   190	1106	12	localShareDexDiffPatchInfo	ShareDexDiffPatchInfo
    //   230	963	13	str3	String
    //   223	975	14	str4	String
    //   496	847	15	localFile	File
    //   590	647	16	localZipEntry1	ZipEntry
    //   582	657	17	localZipEntry2	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   126	151	272	finally
    //   162	170	272	finally
    //   170	218	272	finally
    //   218	269	272	finally
    //   341	375	272	finally
    //   378	391	272	finally
    //   391	446	272	finally
    //   457	464	272	finally
    //   467	536	272	finally
    //   539	575	272	finally
    //   575	603	272	finally
    //   608	647	272	finally
    //   658	667	272	finally
    //   670	733	272	finally
    //   744	761	272	finally
    //   766	805	272	finally
    //   816	882	272	finally
    //   893	969	272	finally
    //   985	1024	272	finally
    //   1035	1090	272	finally
    //   1106	1145	272	finally
    //   1156	1222	272	finally
    //   1233	1312	272	finally
    //   1323	1366	272	finally
    //   1369	1377	272	finally
    //   282	330	330	finally
    //   73	78	1404	finally
    //   82	94	1404	finally
    //   104	116	1404	finally
    //   116	126	1413	finally
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
  
  private static boolean bGl(String paramString)
  {
    if ((ahRq.isEmpty()) || (!isVmArt)) {
      return false;
    }
    Iterator localIterator = ahRq.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      ShareDexDiffPatchInfo localShareDexDiffPatchInfo = (ShareDexDiffPatchInfo)localIterator.next();
      File localFile = new File(paramString + localShareDexDiffPatchInfo.realName);
      String str = localFile.getName();
      if (ShareConstants.CLASS_N_PATTERN.matcher(str).matches()) {
        ahRr.put(localShareDexDiffPatchInfo, localFile);
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
        ahRr.put(ShareTinkerInternals.changeTestDexToClassN((ShareDexDiffPatchInfo)localObject1, ahRr.size() + 1), localObject2);
      }
      paramString = new File(paramString, "tinker_classN.apk");
      if (paramString.exists())
      {
        localObject1 = ahRr.keySet().iterator();
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
          paramString = ahRr.values().iterator();
          while (paramString.hasNext()) {
            SharePatchFileUtil.safeDeleteFile((File)paramString.next());
          }
        }
        return bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.c.e
 * JD-Core Version:    0.7.0.1
 */