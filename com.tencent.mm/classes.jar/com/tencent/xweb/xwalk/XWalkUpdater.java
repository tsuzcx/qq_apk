package com.tencent.xweb.xwalk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetFileDescriptor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.a;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.b.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader.DownloadInfo;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWebCoreInfo;

public final class XWalkUpdater
{
  private static int aaiX = 0;
  static boolean aaiZ = false;
  public f aaiY;
  public Context mContext;
  
  public XWalkUpdater(f paramf, Context paramContext)
  {
    this.aaiY = paramf;
    this.mContext = paramContext;
  }
  
  public static Integer a(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(209025);
    String str = paramUpdateConfig.fst();
    Log.d("XWalkLib", "Download mode extract dir: ".concat(String.valueOf(XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.aajv))));
    if ((paramUpdateConfig.aajq) && (!com.tencent.xweb.util.d.pe(str, paramUpdateConfig.aajr)))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "downloaded apk md5 check failed");
      AppMethodBeat.o(209025);
      return Integer.valueOf(-2);
    }
    if (paramUpdateConfig.aajs)
    {
      if (!bc(str, paramUpdateConfig.aajt, paramUpdateConfig.aajv))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode ,but patch error");
        AppMethodBeat.o(209025);
        return Integer.valueOf(-3);
      }
      if ((paramUpdateConfig.aajq) && (!c.dB(paramUpdateConfig.aajv, XWalkEnvironment.getPatchFileListConfig(paramUpdateConfig.aajv))))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
        h.Xg(36L);
        AppMethodBeat.o(209025);
        return Integer.valueOf(-4);
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do patch sucsess");
    }
    do
    {
      paramUpdateConfig = b(paramUpdateConfig);
      AppMethodBeat.o(209025);
      return paramUpdateConfig;
      if (!XWalkDecompressor.decompressDownloadFullZip(str, paramUpdateConfig.aajv))
      {
        h.Xg(32L);
        AppMethodBeat.o(209025);
        return Integer.valueOf(-5);
      }
    } while ((!paramUpdateConfig.aajq) || (c.dB(paramUpdateConfig.aajv, XWalkEnvironment.getDownloadZipFileListConfig(paramUpdateConfig.aajv))));
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
    h.Xg(33L);
    AppMethodBeat.o(209025);
    return Integer.valueOf(-4);
  }
  
  /* Error */
  private static Map<String, String> a(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 169
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 171	java/util/HashMap
    //   8: dup
    //   9: invokespecial 172	java/util/HashMap:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: aload_1
    //   15: invokestatic 175	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   18: iconst_2
    //   19: iload_2
    //   20: ldc 177
    //   22: invokestatic 182	com/tencent/xweb/XWebCoreContentProvider:c	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   25: ldc 184
    //   27: invokevirtual 190	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +27 -> 59
    //   35: ldc 192
    //   37: invokestatic 195	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   40: aconst_null
    //   41: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   44: aconst_null
    //   45: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   48: aload_1
    //   49: invokestatic 204	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   52: ldc 169
    //   54: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_3
    //   58: areturn
    //   59: new 206	java/io/File
    //   62: dup
    //   63: iload_2
    //   64: ldc 177
    //   66: invokestatic 210	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   69: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 216	java/io/File:exists	()Z
    //   77: ifeq +8 -> 85
    //   80: aload_0
    //   81: invokevirtual 219	java/io/File:delete	()Z
    //   84: pop
    //   85: new 221	java/io/PrintWriter
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 224	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   93: astore 4
    //   95: new 226	java/io/BufferedReader
    //   98: dup
    //   99: new 228	java/io/InputStreamReader
    //   102: dup
    //   103: aload_1
    //   104: invokevirtual 234	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   107: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   110: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   113: astore_0
    //   114: aload 4
    //   116: astore 7
    //   118: aload_0
    //   119: astore 6
    //   121: aload_1
    //   122: astore 5
    //   124: aload_0
    //   125: invokevirtual 243	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   128: astore 8
    //   130: aload 8
    //   132: ifnull +210 -> 342
    //   135: aload 4
    //   137: astore 7
    //   139: aload_0
    //   140: astore 6
    //   142: aload_1
    //   143: astore 5
    //   145: aload 4
    //   147: aload 8
    //   149: invokevirtual 246	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   152: aload 4
    //   154: astore 7
    //   156: aload_0
    //   157: astore 6
    //   159: aload_1
    //   160: astore 5
    //   162: aload 8
    //   164: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   167: ifne -53 -> 114
    //   170: aload 4
    //   172: astore 7
    //   174: aload_0
    //   175: astore 6
    //   177: aload_1
    //   178: astore 5
    //   180: aload 8
    //   182: ldc 251
    //   184: invokevirtual 255	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   187: astore 8
    //   189: aload 4
    //   191: astore 7
    //   193: aload_0
    //   194: astore 6
    //   196: aload_1
    //   197: astore 5
    //   199: aload 8
    //   201: arraylength
    //   202: iconst_2
    //   203: if_icmpne -89 -> 114
    //   206: aload 8
    //   208: iconst_0
    //   209: aaload
    //   210: ifnull -96 -> 114
    //   213: aload 4
    //   215: astore 7
    //   217: aload_0
    //   218: astore 6
    //   220: aload_1
    //   221: astore 5
    //   223: aload 8
    //   225: iconst_0
    //   226: aaload
    //   227: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   230: ifne -116 -> 114
    //   233: aload 8
    //   235: iconst_1
    //   236: aaload
    //   237: ifnull -123 -> 114
    //   240: aload 4
    //   242: astore 7
    //   244: aload_0
    //   245: astore 6
    //   247: aload_1
    //   248: astore 5
    //   250: aload 8
    //   252: iconst_1
    //   253: aaload
    //   254: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   257: ifne -143 -> 114
    //   260: aload 4
    //   262: astore 7
    //   264: aload_0
    //   265: astore 6
    //   267: aload_1
    //   268: astore 5
    //   270: aload_3
    //   271: aload 8
    //   273: iconst_0
    //   274: aaload
    //   275: aload 8
    //   277: iconst_1
    //   278: aaload
    //   279: invokeinterface 261 3 0
    //   284: pop
    //   285: goto -171 -> 114
    //   288: astore_3
    //   289: aload 4
    //   291: astore 7
    //   293: aload_0
    //   294: astore 6
    //   296: aload_1
    //   297: astore 5
    //   299: new 263	java/lang/StringBuilder
    //   302: dup
    //   303: ldc_w 265
    //   306: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: aload_3
    //   310: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 195	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   322: aload 4
    //   324: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   327: aload_0
    //   328: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   331: aload_1
    //   332: invokestatic 204	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   335: ldc 169
    //   337: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aconst_null
    //   341: areturn
    //   342: aload 4
    //   344: astore 7
    //   346: aload_0
    //   347: astore 6
    //   349: aload_1
    //   350: astore 5
    //   352: aload 4
    //   354: invokevirtual 279	java/io/PrintWriter:flush	()V
    //   357: aload 4
    //   359: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   362: aload_0
    //   363: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   366: aload_1
    //   367: invokestatic 204	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   370: ldc 169
    //   372: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload_3
    //   376: areturn
    //   377: astore_0
    //   378: aconst_null
    //   379: astore_3
    //   380: aconst_null
    //   381: astore 4
    //   383: aconst_null
    //   384: astore_1
    //   385: aload_3
    //   386: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   389: aload 4
    //   391: invokestatic 201	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   394: aload_1
    //   395: invokestatic 204	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   398: ldc 169
    //   400: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_0
    //   404: athrow
    //   405: astore_0
    //   406: aconst_null
    //   407: astore_3
    //   408: aconst_null
    //   409: astore 4
    //   411: goto -26 -> 385
    //   414: astore_0
    //   415: aconst_null
    //   416: astore 5
    //   418: aload 4
    //   420: astore_3
    //   421: aload 5
    //   423: astore 4
    //   425: goto -40 -> 385
    //   428: astore_0
    //   429: aload 7
    //   431: astore_3
    //   432: aload 6
    //   434: astore 4
    //   436: aload 5
    //   438: astore_1
    //   439: goto -54 -> 385
    //   442: astore_3
    //   443: aconst_null
    //   444: astore 4
    //   446: aconst_null
    //   447: astore_0
    //   448: aconst_null
    //   449: astore_1
    //   450: goto -161 -> 289
    //   453: astore_3
    //   454: aconst_null
    //   455: astore 4
    //   457: aconst_null
    //   458: astore_0
    //   459: goto -170 -> 289
    //   462: astore_3
    //   463: aconst_null
    //   464: astore_0
    //   465: goto -176 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramContentResolver	ContentResolver
    //   0	468	1	paramString	String
    //   0	468	2	paramInt	int
    //   12	259	3	localHashMap	java.util.HashMap
    //   288	88	3	localException1	Exception
    //   379	53	3	localObject1	Object
    //   442	1	3	localException2	Exception
    //   453	1	3	localException3	Exception
    //   462	1	3	localException4	Exception
    //   93	363	4	localObject2	Object
    //   122	315	5	str	String
    //   119	314	6	localContentResolver	ContentResolver
    //   116	314	7	localObject3	Object
    //   128	148	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   124	130	288	java/lang/Exception
    //   145	152	288	java/lang/Exception
    //   162	170	288	java/lang/Exception
    //   180	189	288	java/lang/Exception
    //   199	206	288	java/lang/Exception
    //   223	233	288	java/lang/Exception
    //   250	260	288	java/lang/Exception
    //   270	285	288	java/lang/Exception
    //   352	357	288	java/lang/Exception
    //   13	31	377	finally
    //   35	40	405	finally
    //   59	85	405	finally
    //   85	95	405	finally
    //   95	114	414	finally
    //   124	130	428	finally
    //   145	152	428	finally
    //   162	170	428	finally
    //   180	189	428	finally
    //   199	206	428	finally
    //   223	233	428	finally
    //   250	260	428	finally
    //   270	285	428	finally
    //   299	322	428	finally
    //   352	357	428	finally
    //   13	31	442	java/lang/Exception
    //   35	40	453	java/lang/Exception
    //   59	85	453	java/lang/Exception
    //   85	95	453	java/lang/Exception
    //   95	114	462	java/lang/Exception
  }
  
  /* Error */
  private static boolean a(ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 283
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +14 -> 23
    //   12: aload_1
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc_w 283
    //   26: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 175	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   36: iconst_1
    //   37: iconst_0
    //   38: ldc 184
    //   40: invokestatic 182	com/tencent/xweb/XWebCoreContentProvider:c	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   43: ldc 184
    //   45: invokevirtual 190	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   48: astore_0
    //   49: aload_0
    //   50: invokestatic 204	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   53: ldc_w 283
    //   56: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iload_2
    //   60: ireturn
    //   61: astore_0
    //   62: aconst_null
    //   63: invokestatic 204	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   66: iconst_0
    //   67: istore_2
    //   68: goto -15 -> 53
    //   71: astore_0
    //   72: aconst_null
    //   73: invokestatic 204	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   76: ldc_w 283
    //   79: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramContentResolver	ContentResolver
    //   0	84	1	paramString	String
    //   1	67	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   31	49	61	java/lang/Exception
    //   31	49	71	finally
  }
  
  private static boolean a(ContentResolver paramContentResolver, String paramString, int paramInt, Map<String, String> paramMap, b paramb)
  {
    AppMethodBeat.i(209016);
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
          paramb.aajg += 1;
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion no file ".concat(String.valueOf(str1)));
          AppMethodBeat.o(209016);
          return false;
        }
        if ("base.apk".equals(str1)) {}
        for (paramMap = new File(XWalkEnvironment.getDownloadApkPath(paramInt)); !com.tencent.xweb.util.c.a(localAssetFileDescriptor, paramMap); paramMap = new File(XWalkEnvironment.getExtractedCoreFile(paramInt, str1)))
        {
          paramb.aajg += 1;
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error");
          AppMethodBeat.o(209016);
          return false;
        }
      } while (com.tencent.xweb.util.d.pe(paramMap.getAbsolutePath(), str2));
    }
    catch (Exception paramContentResolver)
    {
      XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error:" + paramContentResolver.getMessage());
      paramb.aajg += 1;
      AppMethodBeat.o(209016);
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion md5 error ".concat(String.valueOf(str1)));
    paramb.aajh += 1;
    if (paramMap.exists()) {
      paramMap.delete();
    }
    AppMethodBeat.o(209016);
    return false;
    AppMethodBeat.o(209016);
    return true;
  }
  
  private static boolean aCP(int paramInt)
  {
    AppMethodBeat.i(209032);
    try
    {
      i.aCO(paramInt);
      AppMethodBeat.o(209032);
      return true;
    }
    catch (Exception localException)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "dex output error");
      AppMethodBeat.o(209032);
    }
    return false;
  }
  
  /* Error */
  public static String[] aCQ(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 356
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 362	com/tencent/xweb/a:ivJ	()Lcom/tencent/xweb/a;
    //   9: ldc_w 364
    //   12: ldc_w 366
    //   15: invokevirtual 369	com/tencent/xweb/a:oP	(Ljava/lang/String;Ljava/lang/String;)Z
    //   18: ifeq +23 -> 41
    //   21: ldc 65
    //   23: ldc_w 371
    //   26: invokestatic 111	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: getstatic 375	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   32: astore_1
    //   33: ldc_w 356
    //   36: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: iload_0
    //   42: invokestatic 378	org/xwalk/core/XWalkEnvironment:getDownloadResFileListConfig	(I)Ljava/lang/String;
    //   45: astore_1
    //   46: new 206	java/io/File
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 216	java/io/File:exists	()Z
    //   59: ifne +36 -> 95
    //   62: ldc 65
    //   64: ldc_w 380
    //   67: aload_1
    //   68: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   71: invokevirtual 86	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokestatic 111	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: ldc2_w 381
    //   80: invokestatic 148	com/tencent/xweb/util/h:Xg	(J)V
    //   83: getstatic 375	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   86: astore_1
    //   87: ldc_w 356
    //   90: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: areturn
    //   95: new 384	java/io/FileInputStream
    //   98: dup
    //   99: aload_2
    //   100: invokespecial 385	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   103: astore 4
    //   105: new 228	java/io/InputStreamReader
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   114: astore_3
    //   115: new 226	java/io/BufferedReader
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   123: astore_1
    //   124: aload_1
    //   125: astore 7
    //   127: aload_3
    //   128: astore 6
    //   130: aload 4
    //   132: astore 5
    //   134: new 387	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 388	java/util/ArrayList:<init>	()V
    //   141: astore_2
    //   142: aload_1
    //   143: astore 7
    //   145: aload_3
    //   146: astore 6
    //   148: aload 4
    //   150: astore 5
    //   152: aload_1
    //   153: invokevirtual 243	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   156: astore 8
    //   158: aload 8
    //   160: ifnull +216 -> 376
    //   163: aload 8
    //   165: ifnull -23 -> 142
    //   168: aload_1
    //   169: astore 7
    //   171: aload_3
    //   172: astore 6
    //   174: aload 4
    //   176: astore 5
    //   178: aload 8
    //   180: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   183: ifne -41 -> 142
    //   186: aload_1
    //   187: astore 7
    //   189: aload_3
    //   190: astore 6
    //   192: aload 4
    //   194: astore 5
    //   196: aload 8
    //   198: ldc 251
    //   200: invokevirtual 255	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   203: astore 8
    //   205: aload 8
    //   207: ifnull -65 -> 142
    //   210: aload_1
    //   211: astore 7
    //   213: aload_3
    //   214: astore 6
    //   216: aload 4
    //   218: astore 5
    //   220: aload 8
    //   222: arraylength
    //   223: iconst_2
    //   224: if_icmpne -82 -> 142
    //   227: aload 8
    //   229: iconst_0
    //   230: aaload
    //   231: ifnull -89 -> 142
    //   234: aload_1
    //   235: astore 7
    //   237: aload_3
    //   238: astore 6
    //   240: aload 4
    //   242: astore 5
    //   244: aload 8
    //   246: iconst_0
    //   247: aaload
    //   248: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   251: ifne -109 -> 142
    //   254: aload_1
    //   255: astore 7
    //   257: aload_3
    //   258: astore 6
    //   260: aload 4
    //   262: astore 5
    //   264: aload_2
    //   265: aload 8
    //   267: iconst_0
    //   268: aaload
    //   269: invokevirtual 391	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   272: pop
    //   273: goto -131 -> 142
    //   276: astore_2
    //   277: aload_1
    //   278: astore 7
    //   280: aload_3
    //   281: astore 6
    //   283: aload 4
    //   285: astore 5
    //   287: ldc 65
    //   289: new 263	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 393
    //   296: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload_2
    //   300: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   303: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_1
    //   313: astore 7
    //   315: aload_3
    //   316: astore 6
    //   318: aload 4
    //   320: astore 5
    //   322: ldc2_w 381
    //   325: invokestatic 148	com/tencent/xweb/util/h:Xg	(J)V
    //   328: aload_1
    //   329: astore 7
    //   331: aload_3
    //   332: astore 6
    //   334: aload 4
    //   336: astore 5
    //   338: getstatic 375	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   341: astore_2
    //   342: aload 4
    //   344: ifnull +8 -> 352
    //   347: aload 4
    //   349: invokevirtual 398	java/io/FileInputStream:close	()V
    //   352: aload_3
    //   353: ifnull +7 -> 360
    //   356: aload_3
    //   357: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   360: aload_1
    //   361: ifnull +7 -> 368
    //   364: aload_1
    //   365: invokevirtual 400	java/io/BufferedReader:close	()V
    //   368: ldc_w 356
    //   371: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload_2
    //   375: areturn
    //   376: aload_1
    //   377: astore 7
    //   379: aload_3
    //   380: astore 6
    //   382: aload 4
    //   384: astore 5
    //   386: aload_2
    //   387: iconst_0
    //   388: anewarray 78	java/lang/String
    //   391: invokevirtual 404	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   394: checkcast 405	[Ljava/lang/String;
    //   397: astore_2
    //   398: aload_2
    //   399: ifnonnull +91 -> 490
    //   402: aload_1
    //   403: astore 7
    //   405: aload_3
    //   406: astore 6
    //   408: aload 4
    //   410: astore 5
    //   412: ldc2_w 381
    //   415: invokestatic 148	com/tencent/xweb/util/h:Xg	(J)V
    //   418: aload_1
    //   419: astore 7
    //   421: aload_3
    //   422: astore 6
    //   424: aload 4
    //   426: astore 5
    //   428: getstatic 375	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   431: astore_2
    //   432: aload 4
    //   434: invokevirtual 398	java/io/FileInputStream:close	()V
    //   437: aload_3
    //   438: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   441: aload_1
    //   442: invokevirtual 400	java/io/BufferedReader:close	()V
    //   445: ldc_w 356
    //   448: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: aload_2
    //   452: areturn
    //   453: astore 4
    //   455: ldc 65
    //   457: ldc_w 407
    //   460: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: goto -26 -> 437
    //   466: astore_3
    //   467: ldc 65
    //   469: ldc_w 409
    //   472: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: goto -34 -> 441
    //   478: astore_1
    //   479: ldc 65
    //   481: ldc_w 411
    //   484: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: goto -42 -> 445
    //   490: aload 4
    //   492: invokevirtual 398	java/io/FileInputStream:close	()V
    //   495: aload_3
    //   496: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   499: aload_1
    //   500: invokevirtual 400	java/io/BufferedReader:close	()V
    //   503: ldc_w 356
    //   506: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   509: aload_2
    //   510: areturn
    //   511: astore 4
    //   513: ldc 65
    //   515: ldc_w 407
    //   518: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: goto -26 -> 495
    //   524: astore_3
    //   525: ldc 65
    //   527: ldc_w 409
    //   530: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: goto -34 -> 499
    //   536: astore_1
    //   537: ldc 65
    //   539: ldc_w 411
    //   542: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: goto -42 -> 503
    //   548: astore 4
    //   550: ldc 65
    //   552: ldc_w 407
    //   555: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: goto -206 -> 352
    //   561: astore_3
    //   562: ldc 65
    //   564: ldc_w 409
    //   567: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: goto -210 -> 360
    //   573: astore_1
    //   574: ldc 65
    //   576: ldc_w 411
    //   579: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: goto -214 -> 368
    //   585: astore_1
    //   586: aconst_null
    //   587: astore_2
    //   588: aconst_null
    //   589: astore_3
    //   590: aconst_null
    //   591: astore 4
    //   593: aload 4
    //   595: ifnull +8 -> 603
    //   598: aload 4
    //   600: invokevirtual 398	java/io/FileInputStream:close	()V
    //   603: aload_3
    //   604: ifnull +7 -> 611
    //   607: aload_3
    //   608: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   611: aload_2
    //   612: ifnull +7 -> 619
    //   615: aload_2
    //   616: invokevirtual 400	java/io/BufferedReader:close	()V
    //   619: ldc_w 356
    //   622: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   625: aload_1
    //   626: athrow
    //   627: astore 4
    //   629: ldc 65
    //   631: ldc_w 407
    //   634: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: goto -34 -> 603
    //   640: astore_3
    //   641: ldc 65
    //   643: ldc_w 409
    //   646: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   649: goto -38 -> 611
    //   652: astore_2
    //   653: ldc 65
    //   655: ldc_w 411
    //   658: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   661: goto -42 -> 619
    //   664: astore_1
    //   665: aconst_null
    //   666: astore_2
    //   667: aconst_null
    //   668: astore_3
    //   669: goto -76 -> 593
    //   672: astore_1
    //   673: aconst_null
    //   674: astore_2
    //   675: goto -82 -> 593
    //   678: astore_1
    //   679: aload 7
    //   681: astore_2
    //   682: aload 6
    //   684: astore_3
    //   685: aload 5
    //   687: astore 4
    //   689: goto -96 -> 593
    //   692: astore_2
    //   693: aconst_null
    //   694: astore_1
    //   695: aconst_null
    //   696: astore_3
    //   697: aconst_null
    //   698: astore 4
    //   700: goto -423 -> 277
    //   703: astore_2
    //   704: aconst_null
    //   705: astore_1
    //   706: aconst_null
    //   707: astore_3
    //   708: goto -431 -> 277
    //   711: astore_2
    //   712: aconst_null
    //   713: astore_1
    //   714: goto -437 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	paramInt	int
    //   32	410	1	localObject1	Object
    //   478	22	1	localException1	Exception
    //   536	1	1	localException2	Exception
    //   573	1	1	localException3	Exception
    //   585	41	1	localObject2	Object
    //   664	1	1	localObject3	Object
    //   672	1	1	localObject4	Object
    //   678	1	1	localObject5	Object
    //   694	20	1	localObject6	Object
    //   54	211	2	localObject7	Object
    //   276	24	2	localException4	Exception
    //   341	275	2	arrayOfString	String[]
    //   652	1	2	localException5	Exception
    //   666	16	2	localObject8	Object
    //   692	1	2	localException6	Exception
    //   703	1	2	localException7	Exception
    //   711	1	2	localException8	Exception
    //   114	324	3	localInputStreamReader1	java.io.InputStreamReader
    //   466	30	3	localException9	Exception
    //   524	1	3	localException10	Exception
    //   561	1	3	localException11	Exception
    //   589	19	3	localObject9	Object
    //   640	1	3	localException12	Exception
    //   668	40	3	localObject10	Object
    //   103	330	4	localFileInputStream1	java.io.FileInputStream
    //   453	38	4	localException13	Exception
    //   511	1	4	localException14	Exception
    //   548	1	4	localException15	Exception
    //   591	8	4	localObject11	Object
    //   627	1	4	localException16	Exception
    //   687	12	4	localObject12	Object
    //   132	554	5	localFileInputStream2	java.io.FileInputStream
    //   128	555	6	localInputStreamReader2	java.io.InputStreamReader
    //   125	555	7	localObject13	Object
    //   156	110	8	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   134	142	276	java/lang/Exception
    //   152	158	276	java/lang/Exception
    //   178	186	276	java/lang/Exception
    //   196	205	276	java/lang/Exception
    //   220	227	276	java/lang/Exception
    //   244	254	276	java/lang/Exception
    //   264	273	276	java/lang/Exception
    //   386	398	276	java/lang/Exception
    //   412	418	276	java/lang/Exception
    //   428	432	276	java/lang/Exception
    //   432	437	453	java/lang/Exception
    //   437	441	466	java/lang/Exception
    //   441	445	478	java/lang/Exception
    //   490	495	511	java/lang/Exception
    //   495	499	524	java/lang/Exception
    //   499	503	536	java/lang/Exception
    //   347	352	548	java/lang/Exception
    //   356	360	561	java/lang/Exception
    //   364	368	573	java/lang/Exception
    //   46	87	585	finally
    //   95	105	585	finally
    //   598	603	627	java/lang/Exception
    //   607	611	640	java/lang/Exception
    //   615	619	652	java/lang/Exception
    //   105	115	664	finally
    //   115	124	672	finally
    //   134	142	678	finally
    //   152	158	678	finally
    //   178	186	678	finally
    //   196	205	678	finally
    //   220	227	678	finally
    //   244	254	678	finally
    //   264	273	678	finally
    //   287	312	678	finally
    //   322	328	678	finally
    //   338	342	678	finally
    //   386	398	678	finally
    //   412	418	678	finally
    //   428	432	678	finally
    //   46	87	692	java/lang/Exception
    //   95	105	692	java/lang/Exception
    //   105	115	703	java/lang/Exception
    //   115	124	711	java/lang/Exception
  }
  
  /* Error */
  public static boolean aJ(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 414
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 206	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 216	java/io/File:exists	()Z
    //   19: ifne +115 -> 134
    //   22: iload_2
    //   23: invokestatic 417	org/xwalk/core/XWalkEnvironment:isTestVersion	(I)Z
    //   26: ifne +766 -> 792
    //   29: iload_2
    //   30: sipush 362
    //   33: if_icmpge +33 -> 66
    //   36: goto +756 -> 792
    //   39: iload_2
    //   40: ifeq +31 -> 71
    //   43: ldc 65
    //   45: ldc_w 419
    //   48: aload_0
    //   49: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   52: invokevirtual 86	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokestatic 111	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc_w 414
    //   61: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_1
    //   65: ireturn
    //   66: iconst_0
    //   67: istore_2
    //   68: goto -29 -> 39
    //   71: ldc2_w 381
    //   74: invokestatic 148	com/tencent/xweb/util/h:Xg	(J)V
    //   77: ldc 65
    //   79: ldc_w 380
    //   82: aload_0
    //   83: invokestatic 82	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 86	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 111	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc_w 421
    //   95: ldc_w 423
    //   98: ldc_w 366
    //   101: invokestatic 427	com/tencent/xweb/a:oO	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   104: invokevirtual 431	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   107: ifeq +19 -> 126
    //   110: ldc 65
    //   112: ldc_w 433
    //   115: invokestatic 111	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: ldc_w 414
    //   121: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: iconst_1
    //   125: ireturn
    //   126: ldc_w 414
    //   129: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_0
    //   133: ireturn
    //   134: new 384	java/io/FileInputStream
    //   137: dup
    //   138: aload_3
    //   139: invokespecial 385	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   142: astore 4
    //   144: new 228	java/io/InputStreamReader
    //   147: dup
    //   148: aload 4
    //   150: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   153: astore_3
    //   154: new 226	java/io/BufferedReader
    //   157: dup
    //   158: aload_3
    //   159: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   162: astore_0
    //   163: aload_0
    //   164: astore 7
    //   166: aload_3
    //   167: astore 6
    //   169: aload 4
    //   171: astore 5
    //   173: aload_0
    //   174: invokevirtual 243	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   177: astore 8
    //   179: aload 8
    //   181: ifnull +316 -> 497
    //   184: aload 8
    //   186: ifnull -23 -> 163
    //   189: aload_0
    //   190: astore 7
    //   192: aload_3
    //   193: astore 6
    //   195: aload 4
    //   197: astore 5
    //   199: aload 8
    //   201: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   204: ifne -41 -> 163
    //   207: aload_0
    //   208: astore 7
    //   210: aload_3
    //   211: astore 6
    //   213: aload 4
    //   215: astore 5
    //   217: aload 8
    //   219: ldc 251
    //   221: invokevirtual 255	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   224: astore 8
    //   226: aload 8
    //   228: ifnull -65 -> 163
    //   231: aload_0
    //   232: astore 7
    //   234: aload_3
    //   235: astore 6
    //   237: aload 4
    //   239: astore 5
    //   241: aload 8
    //   243: arraylength
    //   244: iconst_2
    //   245: if_icmpne -82 -> 163
    //   248: aload 8
    //   250: iconst_0
    //   251: aaload
    //   252: ifnull -89 -> 163
    //   255: aload_0
    //   256: astore 7
    //   258: aload_3
    //   259: astore 6
    //   261: aload 4
    //   263: astore 5
    //   265: aload 8
    //   267: iconst_0
    //   268: aaload
    //   269: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   272: ifne -109 -> 163
    //   275: aload 8
    //   277: iconst_1
    //   278: aaload
    //   279: ifnull -116 -> 163
    //   282: aload_0
    //   283: astore 7
    //   285: aload_3
    //   286: astore 6
    //   288: aload 4
    //   290: astore 5
    //   292: aload 8
    //   294: iconst_1
    //   295: aaload
    //   296: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   299: ifne -136 -> 163
    //   302: aload_0
    //   303: astore 7
    //   305: aload_3
    //   306: astore 6
    //   308: aload 4
    //   310: astore 5
    //   312: new 206	java/io/File
    //   315: dup
    //   316: aload_1
    //   317: aload 8
    //   319: iconst_0
    //   320: aaload
    //   321: invokespecial 435	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: astore 9
    //   326: aload_0
    //   327: astore 7
    //   329: aload_3
    //   330: astore 6
    //   332: aload 4
    //   334: astore 5
    //   336: aload 9
    //   338: invokestatic 439	com/tencent/xweb/util/d:v	(Ljava/io/File;)Ljava/lang/String;
    //   341: astore 10
    //   343: aload_0
    //   344: astore 7
    //   346: aload_3
    //   347: astore 6
    //   349: aload 4
    //   351: astore 5
    //   353: aload 10
    //   355: aload 8
    //   357: iconst_1
    //   358: aaload
    //   359: invokevirtual 431	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   362: ifne -199 -> 163
    //   365: aload_0
    //   366: astore 7
    //   368: aload_3
    //   369: astore 6
    //   371: aload 4
    //   373: astore 5
    //   375: ldc 65
    //   377: new 263	java/lang/StringBuilder
    //   380: dup
    //   381: ldc_w 441
    //   384: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: aload 8
    //   389: iconst_0
    //   390: aaload
    //   391: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc_w 443
    //   397: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 8
    //   402: iconst_1
    //   403: aaload
    //   404: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 445
    //   410: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 10
    //   415: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 111	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload_0
    //   425: astore 7
    //   427: aload_3
    //   428: astore 6
    //   430: aload 4
    //   432: astore 5
    //   434: aload 9
    //   436: invokevirtual 219	java/io/File:delete	()Z
    //   439: pop
    //   440: aload 4
    //   442: invokevirtual 398	java/io/FileInputStream:close	()V
    //   445: aload_3
    //   446: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   449: aload_0
    //   450: invokevirtual 400	java/io/BufferedReader:close	()V
    //   453: ldc_w 414
    //   456: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: iconst_0
    //   460: ireturn
    //   461: astore_1
    //   462: ldc 65
    //   464: ldc_w 407
    //   467: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: goto -25 -> 445
    //   473: astore_1
    //   474: ldc 65
    //   476: ldc_w 409
    //   479: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -33 -> 449
    //   485: astore_0
    //   486: ldc 65
    //   488: ldc_w 411
    //   491: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: goto -41 -> 453
    //   497: aload 4
    //   499: invokevirtual 398	java/io/FileInputStream:close	()V
    //   502: aload_3
    //   503: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   506: aload_0
    //   507: invokevirtual 400	java/io/BufferedReader:close	()V
    //   510: ldc_w 414
    //   513: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: iconst_1
    //   517: ireturn
    //   518: astore_1
    //   519: ldc 65
    //   521: ldc_w 407
    //   524: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: goto -25 -> 502
    //   530: astore_1
    //   531: ldc 65
    //   533: ldc_w 409
    //   536: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: goto -33 -> 506
    //   542: astore_0
    //   543: ldc 65
    //   545: ldc_w 411
    //   548: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: goto -41 -> 510
    //   554: astore_1
    //   555: aconst_null
    //   556: astore_0
    //   557: aconst_null
    //   558: astore_3
    //   559: aconst_null
    //   560: astore 4
    //   562: aload_0
    //   563: astore 7
    //   565: aload_3
    //   566: astore 6
    //   568: aload 4
    //   570: astore 5
    //   572: ldc 65
    //   574: new 263	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 393
    //   581: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_1
    //   585: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   588: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload 4
    //   599: ifnull +8 -> 607
    //   602: aload 4
    //   604: invokevirtual 398	java/io/FileInputStream:close	()V
    //   607: aload_3
    //   608: ifnull +7 -> 615
    //   611: aload_3
    //   612: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   615: aload_0
    //   616: ifnull +7 -> 623
    //   619: aload_0
    //   620: invokevirtual 400	java/io/BufferedReader:close	()V
    //   623: ldc_w 414
    //   626: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   629: iconst_0
    //   630: ireturn
    //   631: astore_1
    //   632: ldc 65
    //   634: ldc_w 407
    //   637: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: goto -33 -> 607
    //   643: astore_1
    //   644: ldc 65
    //   646: ldc_w 409
    //   649: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: goto -37 -> 615
    //   655: astore_0
    //   656: ldc 65
    //   658: ldc_w 411
    //   661: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: goto -41 -> 623
    //   667: astore_0
    //   668: aconst_null
    //   669: astore_1
    //   670: aconst_null
    //   671: astore_3
    //   672: aconst_null
    //   673: astore 4
    //   675: aload 4
    //   677: ifnull +8 -> 685
    //   680: aload 4
    //   682: invokevirtual 398	java/io/FileInputStream:close	()V
    //   685: aload_3
    //   686: ifnull +7 -> 693
    //   689: aload_3
    //   690: invokevirtual 399	java/io/InputStreamReader:close	()V
    //   693: aload_1
    //   694: ifnull +7 -> 701
    //   697: aload_1
    //   698: invokevirtual 400	java/io/BufferedReader:close	()V
    //   701: ldc_w 414
    //   704: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   707: aload_0
    //   708: athrow
    //   709: astore 4
    //   711: ldc 65
    //   713: ldc_w 407
    //   716: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   719: goto -34 -> 685
    //   722: astore_3
    //   723: ldc 65
    //   725: ldc_w 409
    //   728: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: goto -38 -> 693
    //   734: astore_1
    //   735: ldc 65
    //   737: ldc_w 411
    //   740: invokestatic 395	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: goto -42 -> 701
    //   746: astore_0
    //   747: aconst_null
    //   748: astore_1
    //   749: aconst_null
    //   750: astore_3
    //   751: goto -76 -> 675
    //   754: astore_0
    //   755: aconst_null
    //   756: astore_1
    //   757: goto -82 -> 675
    //   760: astore_0
    //   761: aload 7
    //   763: astore_1
    //   764: aload 6
    //   766: astore_3
    //   767: aload 5
    //   769: astore 4
    //   771: goto -96 -> 675
    //   774: astore_1
    //   775: aconst_null
    //   776: astore_0
    //   777: aconst_null
    //   778: astore_3
    //   779: goto -217 -> 562
    //   782: astore_1
    //   783: aconst_null
    //   784: astore_0
    //   785: goto -223 -> 562
    //   788: astore_1
    //   789: goto -227 -> 562
    //   792: iconst_1
    //   793: istore_2
    //   794: goto -755 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	797	0	paramString1	String
    //   0	797	1	paramString2	String
    //   0	797	2	paramInt	int
    //   14	676	3	localObject1	Object
    //   722	1	3	localException1	Exception
    //   750	29	3	localObject2	Object
    //   142	539	4	localFileInputStream1	java.io.FileInputStream
    //   709	1	4	localException2	Exception
    //   769	1	4	localObject3	Object
    //   171	597	5	localFileInputStream2	java.io.FileInputStream
    //   167	598	6	localObject4	Object
    //   164	598	7	str1	String
    //   177	224	8	localObject5	Object
    //   324	111	9	localFile	File
    //   341	73	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   440	445	461	java/lang/Exception
    //   445	449	473	java/lang/Exception
    //   449	453	485	java/lang/Exception
    //   497	502	518	java/lang/Exception
    //   502	506	530	java/lang/Exception
    //   506	510	542	java/lang/Exception
    //   6	29	554	java/lang/Exception
    //   43	58	554	java/lang/Exception
    //   71	118	554	java/lang/Exception
    //   134	144	554	java/lang/Exception
    //   602	607	631	java/lang/Exception
    //   611	615	643	java/lang/Exception
    //   619	623	655	java/lang/Exception
    //   6	29	667	finally
    //   43	58	667	finally
    //   71	118	667	finally
    //   134	144	667	finally
    //   680	685	709	java/lang/Exception
    //   689	693	722	java/lang/Exception
    //   697	701	734	java/lang/Exception
    //   144	154	746	finally
    //   154	163	754	finally
    //   173	179	760	finally
    //   199	207	760	finally
    //   217	226	760	finally
    //   241	248	760	finally
    //   265	275	760	finally
    //   292	302	760	finally
    //   312	326	760	finally
    //   336	343	760	finally
    //   353	365	760	finally
    //   375	424	760	finally
    //   434	440	760	finally
    //   572	597	760	finally
    //   144	154	774	java/lang/Exception
    //   154	163	782	java/lang/Exception
    //   173	179	788	java/lang/Exception
    //   199	207	788	java/lang/Exception
    //   217	226	788	java/lang/Exception
    //   241	248	788	java/lang/Exception
    //   265	275	788	java/lang/Exception
    //   292	302	788	java/lang/Exception
    //   312	326	788	java/lang/Exception
    //   336	343	788	java/lang/Exception
    //   353	365	788	java/lang/Exception
    //   375	424	788	java/lang/Exception
    //   434	440	788	java/lang/Exception
  }
  
  private static Integer ai(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209031);
    for (;;)
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramInt);
      if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(paramInt), str, aCQ(paramInt)))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "extract faield");
        AppMethodBeat.o(209031);
        return Integer.valueOf(-5);
      }
      if (aJ(XWalkEnvironment.getDownloadResFileListConfig(paramInt), str, paramInt) == true)
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 success!!!!");
        p(paramInt, str, true);
        if ((!XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(paramString1)) || (aCP(paramInt))) {
          break label191;
        }
        h.Xg(251L);
        if (!"true".equalsIgnoreCase(a.oO("update_need_check_dex", "tools"))) {
          break label191;
        }
        AppMethodBeat.o(209031);
        return Integer.valueOf(-101);
      }
      if (aaiX > 0) {
        break;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 failed retry extractResource");
      aaiX += 1;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = " + aaiX);
    AppMethodBeat.o(209031);
    return Integer.valueOf(-12);
    label191:
    int i = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
    boolean bool = XWebCoreInfo.setVersionForAbi(paramInt, paramString2, paramString1);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do update sucsess");
    h.ixF();
    com.tencent.xweb.internal.c.bFv("CHECK_FILES_MD5_TIME_KEY");
    if (XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(paramString1)) {
      com.tencent.xweb.internal.c.cv("CLEAR_OLD_APK", 86400000L);
    }
    while (!bool)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "set version failed");
      AppMethodBeat.o(209031);
      return Integer.valueOf(-101);
      if ((i > 0) && (!a.ivJ().oP("NOT_CLEAR_PREVE_VER_IMEDEATLY", "tools")))
      {
        p.aCT(i);
        XWalkEnvironment.addXWalkInitializeLog("XWalkLib", "after installed prevedown runtime version, clear version = ".concat(String.valueOf(i)));
        h.u(577L, 65L, 1L);
      }
    }
    AppMethodBeat.o(209031);
    return Integer.valueOf(0);
  }
  
  private static Integer b(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(209030);
    paramUpdateConfig = ai(paramUpdateConfig.aajv, paramUpdateConfig.Sdd, paramUpdateConfig.aajw);
    AppMethodBeat.o(209030);
    return paramUpdateConfig;
  }
  
  private static void b(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(209029);
    String str1 = paramFile.getName();
    try
    {
      String str2 = paramFile.getAbsolutePath() + ".jar";
      File localFile = new File(str2);
      if (localFile.exists())
      {
        Log.i("XWalkLib", "generate .jar from " + str1 + " , but jar file exists , need remove =  " + paramBoolean);
        if (!paramBoolean)
        {
          AppMethodBeat.o(209029);
          return;
        }
        localFile.delete();
      }
      paramBoolean = u.k(paramFile, str2);
      Log.i("XWalkLib", "generate .jar from " + str1 + " ret =  " + paramBoolean);
      AppMethodBeat.o(209029);
      return;
    }
    catch (Exception paramFile)
    {
      Log.e("XWalkLib", "generate .jar from " + str1 + " failed. error is " + paramFile.getMessage());
      AppMethodBeat.o(209029);
    }
  }
  
  private static SharedPreferences bFO(String paramString)
  {
    AppMethodBeat.i(209021);
    paramString = XWalkEnvironment.getMMKVSharedPreferences("XWEB_EMBED_INSTALL_".concat(String.valueOf(paramString)));
    AppMethodBeat.o(209021);
    return paramString;
  }
  
  public static int bFP(String paramString)
  {
    AppMethodBeat.i(209024);
    int i = bFO(paramString).getInt("INSTALLED_EMBED_VERSION", -1);
    AppMethodBeat.o(209024);
    return i;
  }
  
  private static boolean bc(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209037);
    Log.i("XWalkLib", "onDoPatch:" + paramString + ",currentVersion:" + paramInt1 + ",newVersion:" + paramInt2);
    if (!new File(paramString).exists())
    {
      Log.e("XWalkLib", "onDoPatch no patch zip file");
      AppMethodBeat.o(209037);
      return false;
    }
    if (!XWalkDecompressor.decompressDownloadPatchZip(paramString, XWalkEnvironment.getPatchZipTempDecompressPath(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch decompress zip error");
      h.Xg(37L);
      AppMethodBeat.o(209037);
      return false;
    }
    paramString = e.aCR(paramInt2);
    if (paramString == null)
    {
      Log.e("XWalkLib", "onDoPatch patchFileConfigList = null");
      h.Xg(38L);
      AppMethodBeat.o(209037);
      return false;
    }
    if (!com.tencent.xweb.util.c.pc(XWalkEnvironment.getExtractedCoreDir(paramInt1), XWalkEnvironment.getExtractedCoreDir(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch copy all extraced file error");
      h.Xg(39L);
      AppMethodBeat.o(209037);
      return false;
    }
    Log.i("XWalkLib", "onDoPatch copy all extraced file finished");
    Object localObject1 = new ArrayList();
    Object localObject2 = paramString.iterator();
    d locald;
    int i;
    label252:
    while (((Iterator)localObject2).hasNext())
    {
      locald = (d)((Iterator)localObject2).next();
      if (locald.type == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label252;
        }
        ((ArrayList)localObject1).add(locald);
        break;
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (!com.tencent.xweb.util.c.copyFile(XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((d)localObject2).aajo), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((d)localObject2).aajo)))
      {
        Log.e("XWalkLib", "onDoPatch add file error:".concat(String.valueOf(localObject2)));
        h.Xg(40L);
        AppMethodBeat.o(209037);
        return false;
      }
      Log.i("XWalkLib", "onDoPatch add file:".concat(String.valueOf(localObject2)));
    }
    Log.i("XWalkLib", "onDoPatch add file finished");
    localObject1 = new ArrayList();
    localObject2 = paramString.iterator();
    label430:
    while (((Iterator)localObject2).hasNext())
    {
      locald = (d)((Iterator)localObject2).next();
      if (locald.type == 3) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label430;
        }
        ((ArrayList)localObject1).add(locald);
        break;
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      if (!com.tencent.xweb.util.c.deleteFile(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((d)localObject2).aajo)))
      {
        Log.e("XWalkLib", "onDoPatch delete file error:".concat(String.valueOf(localObject2)));
        h.Xg(41L);
      }
      else
      {
        Log.i("XWalkLib", "onDoPatch delete file:".concat(String.valueOf(localObject2)));
      }
    }
    Log.i("XWalkLib", "onDoPatch remove file finished");
    localObject1 = new ArrayList();
    paramString = paramString.iterator();
    label591:
    while (paramString.hasNext())
    {
      localObject2 = (d)paramString.next();
      if (((d)localObject2).type == 2) {}
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
      localObject2 = (d)paramString.next();
      if (((d)localObject2).aajn == 2) {}
      for (i = 1; i != 0; i = 0)
      {
        if (BSpatch.bt(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((d)localObject2).aajo), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((d)localObject2).aajl), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((d)localObject2).aajo)) >= 0) {
          break label696;
        }
        Log.e("XWalkLib", "onDoPatch patch error file:".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(209037);
        return false;
      }
      continue;
      label696:
      Log.i("XWalkLib", "onDoPatch patch file finished");
    }
    Log.i("XWalkLib", "onDoPatch patch file finished");
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (d)paramString.next();
      if (((d)localObject1).aajn == 1) {}
      for (i = 1; i != 0; i = 0)
      {
        if (BSpatch.bt(XWalkEnvironment.getDownloadApkPath(paramInt1), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((d)localObject1).aajl), XWalkEnvironment.getDownloadApkPath(paramInt2)) >= 0) {
          break label808;
        }
        Log.e("XWalkLib", "onDoPatch apk patch error file:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(209037);
        return false;
      }
    }
    label808:
    Log.i("XWalkLib", "onDoPatch apk patch finished");
    AppMethodBeat.o(209037);
    return true;
  }
  
  private static void ee(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209027);
    paramString = new File(paramString);
    if (!paramString.isDirectory())
    {
      AppMethodBeat.o(209027);
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramString[i];
      if (localFile != null)
      {
        if (!localFile.isDirectory()) {
          break label78;
        }
        ee(localFile.getAbsolutePath(), paramBoolean);
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        if (localFile.getName().endsWith(".dex")) {
          b(localFile, paramBoolean);
        }
      }
    }
    AppMethodBeat.o(209027);
  }
  
  public static void iyK()
  {
    AppMethodBeat.i(209017);
    a(new UpdateConfig("runtime_package.zip", false, 100000000, XWalkEnvironment.getRuntimeAbi(), 0));
    AppMethodBeat.o(209017);
  }
  
  public static void iyL() {}
  
  public static void iyM()
  {
    AppMethodBeat.i(209019);
    bFO("armeabi-v7a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    bFO("arm64-v8a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "do clearLastTryEmebedVersion");
    AppMethodBeat.o(209019);
  }
  
  public static void p(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209026);
    if (i.aCN(paramInt))
    {
      Log.i("XWalkLib", "apk load mode , no need generate_jar");
      AppMethodBeat.o(209026);
      return;
    }
    if ((Build.VERSION.SDK_INT < 29) || ("true".equalsIgnoreCase(a.oO("NOT_USE_JAR_REPLACE_DEX", "tools"))))
    {
      AppMethodBeat.o(209026);
      return;
    }
    ee(paramString, paramBoolean);
    AppMethodBeat.o(209026);
  }
  
  public final b a(k paramk)
  {
    com.tencent.xweb.xwalk.b.d locald;
    b localb;
    ContentResolver localContentResolver;
    UpdateConfig localUpdateConfig;
    int j;
    String str;
    ArrayList localArrayList;
    int k;
    int m;
    try
    {
      AppMethodBeat.i(209009);
      locald = paramk.izG();
      XWalkInitializer.addXWalkInitializeLog("updateFromProvider target ver " + locald.version);
      localb = new b();
      localb.aajd = locald.version;
      if (!locald.aajy)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
        localb.errorCode = -6;
        AppMethodBeat.o(209009);
      }
      for (;;)
      {
        return localb;
        if (locald.aala >= 2)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
          localb.errorCode = -7;
          AppMethodBeat.o(209009);
        }
        else
        {
          localContentResolver = XWalkEnvironment.getContentResolver();
          if (localContentResolver != null) {
            break;
          }
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
          localb.errorCode = -8;
          AppMethodBeat.o(209009);
        }
      }
      localUpdateConfig = paramk.f(locald);
      i = 0;
      String[] arrayOfString = XWalkEnvironment.XWALK_CORE_PROVIDER_LIST;
      int n = arrayOfString.length;
      j = 0;
      if (j >= n) {
        break label670;
      }
      str = arrayOfString[j];
      if (!a(localContentResolver, str)) {
        break label767;
      }
      XWalkInitializer.addXWalkInitializeLog("updateFromProvider find ".concat(String.valueOf(str)));
      paramk = a.oO("SHARE_CORE_LIST", "tools");
      Log.i("XWalkLib", "dump SHARE_CORE_LIST: ".concat(String.valueOf(paramk)));
      localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(localUpdateConfig.aajv));
      if ((!TextUtils.isEmpty(paramk)) && (!XWalkEnvironment.hasInstalledAvailableVersion()))
      {
        paramk = paramk.split(";");
        if (paramk != null)
        {
          k = paramk.length;
          i = 0;
          for (;;)
          {
            if (i < k)
            {
              CharSequence localCharSequence = paramk[i];
              if (!TextUtils.isEmpty(localCharSequence))
              {
                boolean bool = TextUtils.isEmpty(localCharSequence.trim());
                if (bool) {}
              }
              try
              {
                m = Integer.parseInt(localCharSequence);
                if (localUpdateConfig.aajv != m) {
                  localArrayList.add(Integer.valueOf(m));
                }
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.e("XWalkLib", "parse SHARE_CORE_LIST failed " + localException.getMessage());
                }
              }
            }
          }
        }
      }
      paramk = null;
    }
    finally {}
    int i = 0;
    label398:
    k localk;
    if (i < localArrayList.size())
    {
      m = ((Integer)localArrayList.get(i)).intValue();
      paramk = a(localContentResolver, str, m);
      if (paramk == null)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider read fileList failed ver = ".concat(String.valueOf(m)));
        localb.aaje += 1;
      }
      else
      {
        k = m;
        localk = paramk;
        if (paramk.size() == 0) {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider no matched version ver = ".concat(String.valueOf(m)));
        }
      }
    }
    for (;;)
    {
      if (k < 0)
      {
        localb.aajf += 1;
        i = 1;
        break label767;
      }
      XWalkInitializer.addXWalkInitializeLog("find share available ver = ".concat(String.valueOf(k)));
      if (!a(localContentResolver, str, k, localk, localb)) {
        break label774;
      }
      i = ai(k, localUpdateConfig.Sdd, k + "_install_from_share_mode").intValue();
      if (i == 0)
      {
        localb.errorCode = 0;
        AppMethodBeat.o(209009);
        break;
      }
      if (i == -5)
      {
        localb.aaji += 1;
        i = 1;
        break label767;
      }
      if (i == -12)
      {
        localb.aajk += 1;
        i = 1;
        break label767;
      }
      if (i != -101) {
        break label774;
      }
      localb.aajj += 1;
      break label774;
      label670:
      if (i == 0)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
        localb.errorCode = -9;
        AppMethodBeat.o(209009);
        break;
      }
      if ((XWalkEnvironment.hasAvailableVersion()) && (locald.aala + 1 < 2)) {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
      }
      for (localb.errorCode = -10;; localb.errorCode = -11)
      {
        AppMethodBeat.o(209009);
        break;
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
      }
      i += 1;
      break label398;
      k = -1;
      localk = paramk;
    }
    for (;;)
    {
      label767:
      j += 1;
      break;
      label774:
      i = 1;
    }
  }
  
  public static class UpdateConfig
  {
    public String Sdd;
    public String aajm;
    public com.tencent.xweb.xwalk.b.c aajp;
    public boolean aajq;
    public String aajr;
    public boolean aajs;
    public int aajt;
    public String aaju;
    public int aajv;
    public String aajw;
    public boolean aajx;
    public boolean aajy;
    
    public UpdateConfig(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(204939);
      this.aajv = -1;
      this.aajq = false;
      this.aajs = paramBoolean;
      this.aaju = paramString1;
      this.aajv = paramInt1;
      this.Sdd = paramString2;
      this.aajt = paramInt2;
      if (!checkValid())
      {
        paramString1 = new RuntimeException("royle:UpdateConfig is not valid");
        AppMethodBeat.o(204939);
        throw paramString1;
      }
      AppMethodBeat.o(204939);
    }
    
    public UpdateConfig(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
    {
      AppMethodBeat.i(204940);
      this.aajv = -1;
      this.aajq = true;
      this.aajr = paramString1;
      this.aajs = paramBoolean;
      this.aajm = paramString2;
      this.aaju = paramString3;
      this.aajv = paramInt1;
      this.Sdd = paramString4;
      this.aajt = paramInt2;
      if (!checkValid())
      {
        paramString1 = new RuntimeException("royle:UpdateConfig is not valid");
        AppMethodBeat.o(204940);
        throw paramString1;
      }
      AppMethodBeat.o(204940);
    }
    
    public boolean checkValid()
    {
      AppMethodBeat.i(204942);
      if ((this.aajq) && ((this.aajr == null) || (this.aajr.isEmpty())))
      {
        AppMethodBeat.o(204942);
        return false;
      }
      if ((this.aaju == null) || (this.aaju.isEmpty()))
      {
        AppMethodBeat.o(204942);
        return false;
      }
      if (this.aajv == -1)
      {
        AppMethodBeat.o(204942);
        return false;
      }
      if ((this.aajq) && (this.aajs) && ((this.aajm == null) || (this.aajm.isEmpty())))
      {
        AppMethodBeat.o(204942);
        return false;
      }
      AppMethodBeat.o(204942);
      return true;
    }
    
    public final String fst()
    {
      AppMethodBeat.i(204941);
      if (checkValid())
      {
        if (this.aajs)
        {
          localObject = XWalkEnvironment.getDownloadPatchPath(this.aajv);
          AppMethodBeat.o(204941);
          return localObject;
        }
        localObject = XWalkEnvironment.getDownloadZipDir(this.aajv);
        AppMethodBeat.o(204941);
        return localObject;
      }
      Object localObject = new RuntimeException("royle:UpdateConfig is not valid");
      AppMethodBeat.o(204941);
      throw ((Throwable)localObject);
    }
  }
  
  public final class a
    implements XWalkLibraryLoader.DownloadListener
  {
    private XWalkUpdater.UpdateConfig aaja;
    
    public a(XWalkUpdater.UpdateConfig paramUpdateConfig)
    {
      this.aaja = paramUpdateConfig;
    }
    
    private void a(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      int j = 1;
      AppMethodBeat.i(204817);
      int i;
      int k;
      int m;
      long l1;
      long l2;
      if (this.aaja.aajs)
      {
        i = 2;
        k = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        m = this.aaja.aajv;
        l1 = System.currentTimeMillis();
        l2 = paramDownloadInfo.mStartTimestamp;
        if (!paramDownloadInfo.mIsDownloadResume) {
          break label184;
        }
      }
      for (;;)
      {
        h.dA(15124, i + "," + k + "," + m + ",20210601," + paramDownloadInfo.mErrorCode + "," + paramDownloadInfo.mNetWorkType + "," + paramDownloadInfo.mRetryTimes + "," + (l1 - l2) + "," + paramDownloadInfo.mFileTotalSize + "," + paramDownloadInfo.mDownloadType + "," + j);
        AppMethodBeat.o(204817);
        return;
        i = 1;
        break;
        label184:
        j = 0;
      }
    }
    
    public final void onDownloadCancelled()
    {
      AppMethodBeat.i(204812);
      XWalkUpdater.a(XWalkUpdater.this).iyO();
      AppMethodBeat.o(204812);
    }
    
    public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(204816);
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk completed, apkver = " + this.aaja.aajv);
      if (this.aaja.aajs) {
        h.Xm(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
      }
      for (;;)
      {
        a(paramDownloadInfo);
        new AsyncTask() {}.execute(new Void[0]);
        AppMethodBeat.o(204816);
        return;
        h.Xk(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
      }
    }
    
    public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(204815);
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk failed");
      if (this.aaja.aajs) {
        h.iyf();
      }
      for (;;)
      {
        a(paramDownloadInfo);
        if ((this.aaja != null) && (this.aaja.aajp != null)) {
          this.aaja.aajp.aDf(-1);
        }
        XWalkUpdater.a(XWalkUpdater.this).a(-1, this.aaja.aajp);
        AppMethodBeat.o(204815);
        return;
        h.iya();
      }
    }
    
    public final void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(204807);
      StringBuilder localStringBuilder = new StringBuilder("DownloadTask started, type:").append(paramInt).append(" config:");
      Object localObject = this.aaja;
      if (((XWalkUpdater.UpdateConfig)localObject).checkValid())
      {
        localObject = "UpdateConfig isMatchMd5:" + ((XWalkUpdater.UpdateConfig)localObject).aajq + " downloadFileMd5:" + ((XWalkUpdater.UpdateConfig)localObject).aajr + ",isPatchUpdate:" + ((XWalkUpdater.UpdateConfig)localObject).aajs + ",downUrl:" + ((XWalkUpdater.UpdateConfig)localObject).aaju + ",apkVer:" + ((XWalkUpdater.UpdateConfig)localObject).aajv + ",useCDN:" + ((XWalkUpdater.UpdateConfig)localObject).aajx + ",downloadPath:" + ((XWalkUpdater.UpdateConfig)localObject).fst() + ".";
        Log.d("XWalkLib", (String)localObject);
        if (!this.aaja.aajs) {
          break label183;
        }
        h.iye();
      }
      for (;;)
      {
        XWalkUpdater.a(XWalkUpdater.this).iyN();
        AppMethodBeat.o(204807);
        return;
        localObject = "UpdateConfig is not valid";
        break;
        label183:
        h.ixZ();
      }
    }
    
    public final void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(204810);
      XWalkUpdater.a(XWalkUpdater.this).aCS(paramInt);
      AppMethodBeat.o(204810);
    }
  }
  
  public static final class b
  {
    public int aajd = -1;
    public int aaje = 0;
    public int aajf = 0;
    public int aajg = 0;
    public int aajh = 0;
    public int aaji = 0;
    public int aajj = 0;
    public int aajk = 0;
    public int errorCode = -11;
  }
  
  public static final class c
  {
    /* Error */
    public static boolean a(int paramInt, File paramFile)
    {
      // Byte code:
      //   0: ldc 12
      //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: ifnonnull +10 -> 16
      //   9: ldc 12
      //   11: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   14: iconst_0
      //   15: ireturn
      //   16: new 23	java/io/FileInputStream
      //   19: dup
      //   20: aload_1
      //   21: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   24: astore 5
      //   26: new 29	java/io/InputStreamReader
      //   29: dup
      //   30: aload 5
      //   32: invokespecial 32	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   35: astore 4
      //   37: new 34	java/io/BufferedReader
      //   40: dup
      //   41: aload 4
      //   43: invokespecial 37	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   46: astore_1
      //   47: aload_1
      //   48: astore 8
      //   50: aload 4
      //   52: astore 7
      //   54: aload 5
      //   56: astore 6
      //   58: aload_1
      //   59: invokevirtual 41	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   62: astore_3
      //   63: aload_3
      //   64: ifnull +372 -> 436
      //   67: aload_3
      //   68: ifnull -21 -> 47
      //   71: aload_1
      //   72: astore 8
      //   74: aload 4
      //   76: astore 7
      //   78: aload 5
      //   80: astore 6
      //   82: aload_3
      //   83: invokevirtual 47	java/lang/String:isEmpty	()Z
      //   86: ifne -39 -> 47
      //   89: aload_1
      //   90: astore 8
      //   92: aload 4
      //   94: astore 7
      //   96: aload 5
      //   98: astore 6
      //   100: aload_3
      //   101: ldc 49
      //   103: invokevirtual 53	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   106: astore 9
      //   108: aload 9
      //   110: ifnull -63 -> 47
      //   113: aload_1
      //   114: astore 8
      //   116: aload 4
      //   118: astore 7
      //   120: aload 5
      //   122: astore 6
      //   124: aload 9
      //   126: arraylength
      //   127: iconst_2
      //   128: if_icmpne -81 -> 47
      //   131: aload 9
      //   133: iconst_0
      //   134: aaload
      //   135: ifnull -88 -> 47
      //   138: aload_1
      //   139: astore 8
      //   141: aload 4
      //   143: astore 7
      //   145: aload 5
      //   147: astore 6
      //   149: aload 9
      //   151: iconst_0
      //   152: aaload
      //   153: invokevirtual 47	java/lang/String:isEmpty	()Z
      //   156: ifne -109 -> 47
      //   159: aload 9
      //   161: iconst_1
      //   162: aaload
      //   163: ifnull -116 -> 47
      //   166: aload_1
      //   167: astore 8
      //   169: aload 4
      //   171: astore 7
      //   173: aload 5
      //   175: astore 6
      //   177: aload 9
      //   179: iconst_1
      //   180: aaload
      //   181: invokevirtual 47	java/lang/String:isEmpty	()Z
      //   184: ifne -137 -> 47
      //   187: aload 9
      //   189: iconst_0
      //   190: aaload
      //   191: astore_3
      //   192: aload 9
      //   194: iconst_1
      //   195: aaload
      //   196: astore 10
      //   198: aload_1
      //   199: astore 8
      //   201: aload 4
      //   203: astore 7
      //   205: aload 5
      //   207: astore 6
      //   209: ldc 55
      //   211: aload_3
      //   212: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   215: ifeq +138 -> 353
      //   218: aload_1
      //   219: astore 8
      //   221: aload 4
      //   223: astore 7
      //   225: aload 5
      //   227: astore 6
      //   229: iload_0
      //   230: invokestatic 65	org/xwalk/core/XWalkEnvironment:getDownloadApkPath	(I)Ljava/lang/String;
      //   233: astore_3
      //   234: aload_1
      //   235: astore 8
      //   237: aload 4
      //   239: astore 7
      //   241: aload 5
      //   243: astore 6
      //   245: aload_3
      //   246: aload 10
      //   248: invokestatic 71	com/tencent/xweb/util/d:pe	(Ljava/lang/String;Ljava/lang/String;)Z
      //   251: ifeq +122 -> 373
      //   254: aload_1
      //   255: astore 8
      //   257: aload 4
      //   259: astore 7
      //   261: aload 5
      //   263: astore 6
      //   265: ldc 73
      //   267: ldc 75
      //   269: aload_3
      //   270: invokestatic 79	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   273: invokevirtual 83	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   276: invokestatic 88	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   279: iconst_1
      //   280: istore_2
      //   281: iload_2
      //   282: ifne -235 -> 47
      //   285: aload_1
      //   286: astore 8
      //   288: aload 4
      //   290: astore 7
      //   292: aload 5
      //   294: astore 6
      //   296: ldc 73
      //   298: new 90	java/lang/StringBuilder
      //   301: dup
      //   302: ldc 92
      //   304: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   307: aload 9
      //   309: iconst_0
      //   310: aaload
      //   311: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   314: ldc 101
      //   316: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   319: aload 9
      //   321: iconst_1
      //   322: aaload
      //   323: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   326: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   329: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   332: aload 5
      //   334: invokevirtual 111	java/io/FileInputStream:close	()V
      //   337: aload 4
      //   339: invokevirtual 112	java/io/InputStreamReader:close	()V
      //   342: aload_1
      //   343: invokevirtual 113	java/io/BufferedReader:close	()V
      //   346: ldc 12
      //   348: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   351: iconst_0
      //   352: ireturn
      //   353: aload_1
      //   354: astore 8
      //   356: aload 4
      //   358: astore 7
      //   360: aload 5
      //   362: astore 6
      //   364: iload_0
      //   365: aload_3
      //   366: invokestatic 117	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
      //   369: astore_3
      //   370: goto -136 -> 234
      //   373: aload_1
      //   374: astore 8
      //   376: aload 4
      //   378: astore 7
      //   380: aload 5
      //   382: astore 6
      //   384: ldc 73
      //   386: ldc 119
      //   388: aload_3
      //   389: invokestatic 79	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   392: invokevirtual 83	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   395: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   398: iconst_0
      //   399: istore_2
      //   400: goto -119 -> 281
      //   403: astore_3
      //   404: ldc 73
      //   406: ldc 121
      //   408: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   411: goto -74 -> 337
      //   414: astore_3
      //   415: ldc 73
      //   417: ldc 123
      //   419: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   422: goto -80 -> 342
      //   425: astore_1
      //   426: ldc 73
      //   428: ldc 125
      //   430: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   433: goto -87 -> 346
      //   436: aload 5
      //   438: invokevirtual 111	java/io/FileInputStream:close	()V
      //   441: aload 4
      //   443: invokevirtual 112	java/io/InputStreamReader:close	()V
      //   446: aload_1
      //   447: invokevirtual 113	java/io/BufferedReader:close	()V
      //   450: ldc 12
      //   452: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   455: iconst_1
      //   456: ireturn
      //   457: astore_3
      //   458: ldc 73
      //   460: ldc 121
      //   462: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   465: goto -24 -> 441
      //   468: astore_3
      //   469: ldc 73
      //   471: ldc 123
      //   473: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   476: goto -30 -> 446
      //   479: astore_1
      //   480: ldc 73
      //   482: ldc 125
      //   484: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   487: goto -37 -> 450
      //   490: astore_3
      //   491: aconst_null
      //   492: astore_1
      //   493: aconst_null
      //   494: astore 4
      //   496: aconst_null
      //   497: astore 5
      //   499: aload_1
      //   500: astore 8
      //   502: aload 4
      //   504: astore 7
      //   506: aload 5
      //   508: astore 6
      //   510: ldc 73
      //   512: new 90	java/lang/StringBuilder
      //   515: dup
      //   516: ldc 127
      //   518: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   521: aload_3
      //   522: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   525: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   528: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   531: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   534: aload 5
      //   536: ifnull +8 -> 544
      //   539: aload 5
      //   541: invokevirtual 111	java/io/FileInputStream:close	()V
      //   544: aload 4
      //   546: ifnull +8 -> 554
      //   549: aload 4
      //   551: invokevirtual 112	java/io/InputStreamReader:close	()V
      //   554: aload_1
      //   555: ifnull +7 -> 562
      //   558: aload_1
      //   559: invokevirtual 113	java/io/BufferedReader:close	()V
      //   562: ldc 12
      //   564: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   567: iconst_0
      //   568: ireturn
      //   569: astore_3
      //   570: ldc 73
      //   572: ldc 121
      //   574: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   577: goto -33 -> 544
      //   580: astore_3
      //   581: ldc 73
      //   583: ldc 123
      //   585: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   588: goto -34 -> 554
      //   591: astore_1
      //   592: ldc 73
      //   594: ldc 125
      //   596: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   599: goto -37 -> 562
      //   602: astore_1
      //   603: aconst_null
      //   604: astore_3
      //   605: aconst_null
      //   606: astore 4
      //   608: aconst_null
      //   609: astore 5
      //   611: aload 5
      //   613: ifnull +8 -> 621
      //   616: aload 5
      //   618: invokevirtual 111	java/io/FileInputStream:close	()V
      //   621: aload 4
      //   623: ifnull +8 -> 631
      //   626: aload 4
      //   628: invokevirtual 112	java/io/InputStreamReader:close	()V
      //   631: aload_3
      //   632: ifnull +7 -> 639
      //   635: aload_3
      //   636: invokevirtual 113	java/io/BufferedReader:close	()V
      //   639: ldc 12
      //   641: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   644: aload_1
      //   645: athrow
      //   646: astore 5
      //   648: ldc 73
      //   650: ldc 121
      //   652: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   655: goto -34 -> 621
      //   658: astore 4
      //   660: ldc 73
      //   662: ldc 123
      //   664: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   667: goto -36 -> 631
      //   670: astore_3
      //   671: ldc 73
      //   673: ldc 125
      //   675: invokestatic 107	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   678: goto -39 -> 639
      //   681: astore_1
      //   682: aconst_null
      //   683: astore_3
      //   684: aconst_null
      //   685: astore 4
      //   687: goto -76 -> 611
      //   690: astore_1
      //   691: aconst_null
      //   692: astore_3
      //   693: goto -82 -> 611
      //   696: astore_1
      //   697: aload 8
      //   699: astore_3
      //   700: aload 7
      //   702: astore 4
      //   704: aload 6
      //   706: astore 5
      //   708: goto -97 -> 611
      //   711: astore_3
      //   712: aconst_null
      //   713: astore_1
      //   714: aconst_null
      //   715: astore 4
      //   717: goto -218 -> 499
      //   720: astore_3
      //   721: aconst_null
      //   722: astore_1
      //   723: goto -224 -> 499
      //   726: astore_3
      //   727: goto -228 -> 499
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	730	0	paramInt	int
      //   0	730	1	paramFile	File
      //   280	120	2	i	int
      //   62	327	3	str1	String
      //   403	1	3	localException1	Exception
      //   414	1	3	localException2	Exception
      //   457	1	3	localException3	Exception
      //   468	1	3	localException4	Exception
      //   490	32	3	localException5	Exception
      //   569	1	3	localException6	Exception
      //   580	1	3	localException7	Exception
      //   604	32	3	localObject1	Object
      //   670	1	3	localException8	Exception
      //   683	17	3	localFile1	File
      //   711	1	3	localException9	Exception
      //   720	1	3	localException10	Exception
      //   726	1	3	localException11	Exception
      //   35	592	4	localInputStreamReader1	java.io.InputStreamReader
      //   658	1	4	localException12	Exception
      //   685	31	4	localObject2	Object
      //   24	593	5	localFileInputStream1	java.io.FileInputStream
      //   646	1	5	localException13	Exception
      //   706	1	5	localObject3	Object
      //   56	649	6	localFileInputStream2	java.io.FileInputStream
      //   52	649	7	localInputStreamReader2	java.io.InputStreamReader
      //   48	650	8	localFile2	File
      //   106	214	9	arrayOfString	String[]
      //   196	51	10	str2	String
      // Exception table:
      //   from	to	target	type
      //   332	337	403	java/lang/Exception
      //   337	342	414	java/lang/Exception
      //   342	346	425	java/lang/Exception
      //   436	441	457	java/lang/Exception
      //   441	446	468	java/lang/Exception
      //   446	450	479	java/lang/Exception
      //   16	26	490	java/lang/Exception
      //   539	544	569	java/lang/Exception
      //   549	554	580	java/lang/Exception
      //   558	562	591	java/lang/Exception
      //   16	26	602	finally
      //   616	621	646	java/lang/Exception
      //   626	631	658	java/lang/Exception
      //   635	639	670	java/lang/Exception
      //   26	37	681	finally
      //   37	47	690	finally
      //   58	63	696	finally
      //   82	89	696	finally
      //   100	108	696	finally
      //   124	131	696	finally
      //   149	159	696	finally
      //   177	187	696	finally
      //   209	218	696	finally
      //   229	234	696	finally
      //   245	254	696	finally
      //   265	279	696	finally
      //   296	332	696	finally
      //   364	370	696	finally
      //   384	398	696	finally
      //   510	534	696	finally
      //   26	37	711	java/lang/Exception
      //   37	47	720	java/lang/Exception
      //   58	63	726	java/lang/Exception
      //   82	89	726	java/lang/Exception
      //   100	108	726	java/lang/Exception
      //   124	131	726	java/lang/Exception
      //   149	159	726	java/lang/Exception
      //   177	187	726	java/lang/Exception
      //   209	218	726	java/lang/Exception
      //   229	234	726	java/lang/Exception
      //   245	254	726	java/lang/Exception
      //   265	279	726	java/lang/Exception
      //   296	332	726	java/lang/Exception
      //   364	370	726	java/lang/Exception
      //   384	398	726	java/lang/Exception
    }
    
    public static boolean dB(int paramInt, String paramString)
    {
      AppMethodBeat.i(206797);
      try
      {
        boolean bool = a(paramInt, new File(paramString));
        AppMethodBeat.o(206797);
        return bool;
      }
      catch (Exception paramString)
      {
        Log.e("XWalkLib", "checkFileListMd5 error:" + paramString.getMessage());
        AppMethodBeat.o(206797);
      }
      return false;
    }
  }
  
  public static final class d
  {
    public String aajl;
    public String aajm;
    public int aajn;
    public String aajo;
    public int type;
    
    public final String toString()
    {
      AppMethodBeat.i(204902);
      String str = "PatchFileConfig type:" + this.type + ",originalFileType:" + this.aajn + ",originalFileName:" + this.aajo + ",patchFileName:" + this.aajl + ",patchEndFileMd5:" + this.aajm;
      AppMethodBeat.o(204902);
      return str;
    }
  }
  
  public static final class e
  {
    /* Error */
    public static ArrayList<XWalkUpdater.d> aCR(int paramInt)
    {
      // Byte code:
      //   0: ldc 12
      //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 20	java/io/FileInputStream
      //   8: dup
      //   9: new 22	java/io/File
      //   12: dup
      //   13: iload_0
      //   14: invokestatic 28	org/xwalk/core/XWalkEnvironment:getPatchConfig	(I)Ljava/lang/String;
      //   17: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
      //   20: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   23: astore 6
      //   25: new 37	java/io/InputStreamReader
      //   28: dup
      //   29: aload 6
      //   31: invokespecial 40	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   34: astore 5
      //   36: new 42	java/io/BufferedReader
      //   39: dup
      //   40: aload 5
      //   42: invokespecial 45	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   45: astore 4
      //   47: aload 4
      //   49: astore 9
      //   51: aload 5
      //   53: astore 8
      //   55: aload 6
      //   57: astore 7
      //   59: new 47	java/util/ArrayList
      //   62: dup
      //   63: invokespecial 50	java/util/ArrayList:<init>	()V
      //   66: astore 10
      //   68: aload 4
      //   70: astore 9
      //   72: aload 5
      //   74: astore 8
      //   76: aload 6
      //   78: astore 7
      //   80: aload 4
      //   82: invokevirtual 54	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   85: astore_3
      //   86: aload_3
      //   87: ifnull +524 -> 611
      //   90: aload_3
      //   91: ifnull -23 -> 68
      //   94: aload 4
      //   96: astore 9
      //   98: aload 5
      //   100: astore 8
      //   102: aload 6
      //   104: astore 7
      //   106: aload_3
      //   107: invokevirtual 60	java/lang/String:isEmpty	()Z
      //   110: ifne -42 -> 68
      //   113: aload 4
      //   115: astore 9
      //   117: aload 5
      //   119: astore 8
      //   121: aload 6
      //   123: astore 7
      //   125: aload_3
      //   126: ldc 62
      //   128: invokevirtual 66	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   131: ifeq +305 -> 436
      //   134: aload 4
      //   136: astore 9
      //   138: aload 5
      //   140: astore 8
      //   142: aload 6
      //   144: astore 7
      //   146: aload_3
      //   147: iconst_4
      //   148: invokevirtual 69	java/lang/String:substring	(I)Ljava/lang/String;
      //   151: astore_3
      //   152: iconst_1
      //   153: istore_0
      //   154: aload 4
      //   156: astore 9
      //   158: aload 5
      //   160: astore 8
      //   162: aload 6
      //   164: astore 7
      //   166: aload_3
      //   167: ldc 71
      //   169: invokevirtual 75	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   172: astore_3
      //   173: aload 4
      //   175: astore 9
      //   177: aload 5
      //   179: astore 8
      //   181: aload 6
      //   183: astore 7
      //   185: aload_3
      //   186: arraylength
      //   187: istore_2
      //   188: iconst_0
      //   189: istore_1
      //   190: iload_1
      //   191: iload_2
      //   192: if_icmpge -124 -> 68
      //   195: aload_3
      //   196: iload_1
      //   197: aaload
      //   198: astore 11
      //   200: aload 11
      //   202: ifnull +532 -> 734
      //   205: aload 4
      //   207: astore 9
      //   209: aload 5
      //   211: astore 8
      //   213: aload 6
      //   215: astore 7
      //   217: aload 11
      //   219: invokevirtual 60	java/lang/String:isEmpty	()Z
      //   222: ifne +512 -> 734
      //   225: aload 4
      //   227: astore 9
      //   229: aload 5
      //   231: astore 8
      //   233: aload 6
      //   235: astore 7
      //   237: new 77	com/tencent/xweb/xwalk/XWalkUpdater$d
      //   240: dup
      //   241: invokespecial 78	com/tencent/xweb/xwalk/XWalkUpdater$d:<init>	()V
      //   244: astore 12
      //   246: aload 4
      //   248: astore 9
      //   250: aload 5
      //   252: astore 8
      //   254: aload 6
      //   256: astore 7
      //   258: aload 12
      //   260: aload 11
      //   262: putfield 82	com/tencent/xweb/xwalk/XWalkUpdater$d:aajo	Ljava/lang/String;
      //   265: aload 4
      //   267: astore 9
      //   269: aload 5
      //   271: astore 8
      //   273: aload 6
      //   275: astore 7
      //   277: aload 12
      //   279: iload_0
      //   280: putfield 86	com/tencent/xweb/xwalk/XWalkUpdater$d:type	I
      //   283: iload_0
      //   284: iconst_2
      //   285: if_icmpne +43 -> 328
      //   288: aload 4
      //   290: astore 9
      //   292: aload 5
      //   294: astore 8
      //   296: aload 6
      //   298: astore 7
      //   300: aload 12
      //   302: new 88	java/lang/StringBuilder
      //   305: dup
      //   306: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   309: aload 12
      //   311: getfield 82	com/tencent/xweb/xwalk/XWalkUpdater$d:aajo	Ljava/lang/String;
      //   314: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   317: ldc 95
      //   319: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   322: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   325: putfield 101	com/tencent/xweb/xwalk/XWalkUpdater$d:aajl	Ljava/lang/String;
      //   328: iload_0
      //   329: iconst_2
      //   330: if_icmpne +194 -> 524
      //   333: aload 4
      //   335: astore 9
      //   337: aload 5
      //   339: astore 8
      //   341: aload 6
      //   343: astore 7
      //   345: aload 12
      //   347: getfield 82	com/tencent/xweb/xwalk/XWalkUpdater$d:aajo	Ljava/lang/String;
      //   350: ldc 103
      //   352: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   355: ifeq +169 -> 524
      //   358: aload 4
      //   360: astore 9
      //   362: aload 5
      //   364: astore 8
      //   366: aload 6
      //   368: astore 7
      //   370: aload 12
      //   372: iconst_1
      //   373: putfield 110	com/tencent/xweb/xwalk/XWalkUpdater$d:aajn	I
      //   376: aload 4
      //   378: astore 9
      //   380: aload 5
      //   382: astore 8
      //   384: aload 6
      //   386: astore 7
      //   388: ldc 112
      //   390: new 88	java/lang/StringBuilder
      //   393: dup
      //   394: ldc 114
      //   396: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   399: aload 12
      //   401: invokevirtual 116	com/tencent/xweb/xwalk/XWalkUpdater$d:toString	()Ljava/lang/String;
      //   404: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   410: invokestatic 122	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   413: aload 4
      //   415: astore 9
      //   417: aload 5
      //   419: astore 8
      //   421: aload 6
      //   423: astore 7
      //   425: aload 10
      //   427: aload 12
      //   429: invokevirtual 125	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   432: pop
      //   433: goto +301 -> 734
      //   436: aload 4
      //   438: astore 9
      //   440: aload 5
      //   442: astore 8
      //   444: aload 6
      //   446: astore 7
      //   448: aload_3
      //   449: ldc 127
      //   451: invokevirtual 66	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   454: ifeq +26 -> 480
      //   457: aload 4
      //   459: astore 9
      //   461: aload 5
      //   463: astore 8
      //   465: aload 6
      //   467: astore 7
      //   469: aload_3
      //   470: iconst_4
      //   471: invokevirtual 69	java/lang/String:substring	(I)Ljava/lang/String;
      //   474: astore_3
      //   475: iconst_2
      //   476: istore_0
      //   477: goto -323 -> 154
      //   480: aload 4
      //   482: astore 9
      //   484: aload 5
      //   486: astore 8
      //   488: aload 6
      //   490: astore 7
      //   492: aload_3
      //   493: ldc 129
      //   495: invokevirtual 66	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   498: ifeq +231 -> 729
      //   501: aload 4
      //   503: astore 9
      //   505: aload 5
      //   507: astore 8
      //   509: aload 6
      //   511: astore 7
      //   513: aload_3
      //   514: iconst_4
      //   515: invokevirtual 69	java/lang/String:substring	(I)Ljava/lang/String;
      //   518: astore_3
      //   519: iconst_3
      //   520: istore_0
      //   521: goto -367 -> 154
      //   524: aload 4
      //   526: astore 9
      //   528: aload 5
      //   530: astore 8
      //   532: aload 6
      //   534: astore 7
      //   536: aload 12
      //   538: iconst_2
      //   539: putfield 110	com/tencent/xweb/xwalk/XWalkUpdater$d:aajn	I
      //   542: goto -166 -> 376
      //   545: astore 7
      //   547: aload 4
      //   549: astore_3
      //   550: aload 7
      //   552: astore 4
      //   554: aload_3
      //   555: astore 9
      //   557: aload 5
      //   559: astore 8
      //   561: aload 6
      //   563: astore 7
      //   565: ldc 112
      //   567: new 88	java/lang/StringBuilder
      //   570: dup
      //   571: ldc 131
      //   573: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   576: aload 4
      //   578: invokevirtual 134	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   581: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   584: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   587: invokestatic 136	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   590: aload 6
      //   592: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   595: aload 5
      //   597: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   600: aload_3
      //   601: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   604: ldc 12
      //   606: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   609: aconst_null
      //   610: areturn
      //   611: aload 6
      //   613: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   616: aload 5
      //   618: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   621: aload 4
      //   623: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   626: ldc 12
      //   628: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   631: aload 10
      //   633: areturn
      //   634: astore_3
      //   635: aconst_null
      //   636: astore 4
      //   638: aconst_null
      //   639: astore 5
      //   641: aconst_null
      //   642: astore 6
      //   644: aload 6
      //   646: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   649: aload 5
      //   651: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   654: aload 4
      //   656: invokestatic 142	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   659: ldc 12
      //   661: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   664: aload_3
      //   665: athrow
      //   666: astore_3
      //   667: aconst_null
      //   668: astore 4
      //   670: aconst_null
      //   671: astore 5
      //   673: goto -29 -> 644
      //   676: astore_3
      //   677: aconst_null
      //   678: astore 4
      //   680: goto -36 -> 644
      //   683: astore_3
      //   684: aload 9
      //   686: astore 4
      //   688: aload 8
      //   690: astore 5
      //   692: aload 7
      //   694: astore 6
      //   696: goto -52 -> 644
      //   699: astore 4
      //   701: aconst_null
      //   702: astore_3
      //   703: aconst_null
      //   704: astore 5
      //   706: aconst_null
      //   707: astore 6
      //   709: goto -155 -> 554
      //   712: astore 4
      //   714: aconst_null
      //   715: astore_3
      //   716: aconst_null
      //   717: astore 5
      //   719: goto -165 -> 554
      //   722: astore 4
      //   724: aconst_null
      //   725: astore_3
      //   726: goto -172 -> 554
      //   729: iconst_0
      //   730: istore_0
      //   731: goto -577 -> 154
      //   734: iload_1
      //   735: iconst_1
      //   736: iadd
      //   737: istore_1
      //   738: goto -548 -> 190
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	741	0	paramInt	int
      //   189	549	1	i	int
      //   187	6	2	j	int
      //   85	516	3	localObject1	Object
      //   634	31	3	localObject2	Object
      //   666	1	3	localObject3	Object
      //   676	1	3	localObject4	Object
      //   683	1	3	localObject5	Object
      //   702	24	3	localObject6	Object
      //   45	642	4	localObject7	Object
      //   699	1	4	localException1	Exception
      //   712	1	4	localException2	Exception
      //   722	1	4	localException3	Exception
      //   34	684	5	localObject8	Object
      //   23	685	6	localObject9	Object
      //   57	478	7	localObject10	Object
      //   545	6	7	localException4	Exception
      //   563	130	7	localObject11	Object
      //   53	636	8	localObject12	Object
      //   49	636	9	localObject13	Object
      //   66	566	10	localArrayList	ArrayList
      //   198	63	11	localObject14	Object
      //   244	293	12	locald	XWalkUpdater.d
      // Exception table:
      //   from	to	target	type
      //   59	68	545	java/lang/Exception
      //   80	86	545	java/lang/Exception
      //   106	113	545	java/lang/Exception
      //   125	134	545	java/lang/Exception
      //   146	152	545	java/lang/Exception
      //   166	173	545	java/lang/Exception
      //   185	188	545	java/lang/Exception
      //   217	225	545	java/lang/Exception
      //   237	246	545	java/lang/Exception
      //   258	265	545	java/lang/Exception
      //   277	283	545	java/lang/Exception
      //   300	328	545	java/lang/Exception
      //   345	358	545	java/lang/Exception
      //   370	376	545	java/lang/Exception
      //   388	413	545	java/lang/Exception
      //   425	433	545	java/lang/Exception
      //   448	457	545	java/lang/Exception
      //   469	475	545	java/lang/Exception
      //   492	501	545	java/lang/Exception
      //   513	519	545	java/lang/Exception
      //   536	542	545	java/lang/Exception
      //   5	25	634	finally
      //   25	36	666	finally
      //   36	47	676	finally
      //   59	68	683	finally
      //   80	86	683	finally
      //   106	113	683	finally
      //   125	134	683	finally
      //   146	152	683	finally
      //   166	173	683	finally
      //   185	188	683	finally
      //   217	225	683	finally
      //   237	246	683	finally
      //   258	265	683	finally
      //   277	283	683	finally
      //   300	328	683	finally
      //   345	358	683	finally
      //   370	376	683	finally
      //   388	413	683	finally
      //   425	433	683	finally
      //   448	457	683	finally
      //   469	475	683	finally
      //   492	501	683	finally
      //   513	519	683	finally
      //   536	542	683	finally
      //   565	590	683	finally
      //   5	25	699	java/lang/Exception
      //   25	36	712	java/lang/Exception
      //   36	47	722	java/lang/Exception
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(int paramInt, com.tencent.xweb.xwalk.b.c paramc);
    
    public abstract void a(com.tencent.xweb.xwalk.b.c paramc);
    
    public abstract void aCS(int paramInt);
    
    public abstract void iyN();
    
    public abstract void iyO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkUpdater
 * JD-Core Version:    0.7.0.1
 */