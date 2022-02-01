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
  private static ArrayList<File> SjC = new ArrayList();
  private static ArrayList<ShareDexDiffPatchInfo> SjD = new ArrayList();
  private static HashMap<ShareDexDiffPatchInfo, File> SjE = new HashMap();
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
  
  /* Error */
  private static boolean a(Context paramContext, File paramFile, String paramString)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/tinker/lib/c/e:SjD	Ljava/util/ArrayList;
    //   3: invokevirtual 152	java/util/ArrayList:isEmpty	()Z
    //   6: ifne +9 -> 15
    //   9: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: new 118	java/io/File
    //   20: dup
    //   21: aload_2
    //   22: ldc 154
    //   24: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore 10
    //   29: getstatic 32	com/tencent/tinker/lib/c/e:SjE	Ljava/util/HashMap;
    //   32: invokevirtual 158	java/util/HashMap:isEmpty	()Z
    //   35: ifeq +28 -> 63
    //   38: ldc 160
    //   40: ldc 162
    //   42: iconst_1
    //   43: anewarray 164	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: getstatic 32	com/tencent/tinker/lib/c/e:SjE	Ljava/util/HashMap;
    //   51: invokevirtual 168	java/util/HashMap:size	()I
    //   54: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   66: lstore_3
    //   67: aconst_null
    //   68: astore_2
    //   69: new 188	com/tencent/tinker/d/a/a
    //   72: dup
    //   73: new 72	java/io/BufferedOutputStream
    //   76: dup
    //   77: new 74	java/io/FileOutputStream
    //   80: dup
    //   81: aload 10
    //   83: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: invokespecial 189	com/tencent/tinker/d/a/a:<init>	(Ljava/io/OutputStream;)V
    //   92: astore 8
    //   94: getstatic 32	com/tencent/tinker/lib/c/e:SjE	Ljava/util/HashMap;
    //   97: invokevirtual 193	java/util/HashMap:keySet	()Ljava/util/Set;
    //   100: invokeinterface 199 1 0
    //   105: astore_2
    //   106: aload_2
    //   107: invokeinterface 204 1 0
    //   112: ifeq +456 -> 568
    //   115: aload_2
    //   116: invokeinterface 208 1 0
    //   121: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   124: astore 7
    //   126: getstatic 32	com/tencent/tinker/lib/c/e:SjE	Ljava/util/HashMap;
    //   129: aload 7
    //   131: invokevirtual 212	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 118	java/io/File
    //   137: astore 9
    //   139: aload 7
    //   141: getfield 68	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:isJarMode	Z
    //   144: istore 5
    //   146: iload 5
    //   148: ifeq +309 -> 457
    //   151: new 46	java/util/zip/ZipFile
    //   154: dup
    //   155: aload 9
    //   157: invokespecial 213	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   160: astore 9
    //   162: aload 9
    //   164: ldc 85
    //   166: invokevirtual 217	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   169: astore 12
    //   171: new 83	java/util/zip/ZipEntry
    //   174: dup
    //   175: aload 7
    //   177: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   180: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   183: astore 11
    //   185: aload 11
    //   187: iconst_0
    //   188: invokevirtual 221	java/util/zip/ZipEntry:setMethod	(I)V
    //   191: aload 11
    //   193: aload 12
    //   195: invokevirtual 224	java/util/zip/ZipEntry:getSize	()J
    //   198: invokevirtual 228	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   201: aload 11
    //   203: aload 12
    //   205: invokevirtual 224	java/util/zip/ZipEntry:getSize	()J
    //   208: invokevirtual 231	java/util/zip/ZipEntry:setSize	(J)V
    //   211: aload 11
    //   213: aload 12
    //   215: invokevirtual 234	java/util/zip/ZipEntry:getCrc	()J
    //   218: invokevirtual 237	java/util/zip/ZipEntry:setCrc	(J)V
    //   221: aload 9
    //   223: aload 12
    //   225: invokevirtual 50	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   228: astore 7
    //   230: aload 8
    //   232: aload 11
    //   234: invokevirtual 238	com/tencent/tinker/d/a/a:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   237: aload 7
    //   239: aload 8
    //   241: invokestatic 242	com/tencent/tinker/c/b/b:d	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   244: aload 8
    //   246: invokevirtual 243	com/tencent/tinker/d/a/a:closeEntry	()V
    //   249: aload 7
    //   251: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   254: aload 9
    //   256: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   259: goto -153 -> 106
    //   262: astore 7
    //   264: aload 8
    //   266: astore_2
    //   267: ldc 160
    //   269: aload 7
    //   271: ldc 245
    //   273: iconst_0
    //   274: anewarray 164	java/lang/Object
    //   277: invokestatic 249	com/tencent/tinker/loader/shareutil/ShareTinkerLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: aload_2
    //   281: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   284: iconst_0
    //   285: istore 5
    //   287: iload 5
    //   289: istore 6
    //   291: iload 5
    //   293: ifeq +91 -> 384
    //   296: getstatic 32	com/tencent/tinker/lib/c/e:SjE	Ljava/util/HashMap;
    //   299: invokevirtual 193	java/util/HashMap:keySet	()Ljava/util/Set;
    //   302: invokeinterface 199 1 0
    //   307: astore_2
    //   308: iload 5
    //   310: istore 6
    //   312: aload_2
    //   313: invokeinterface 204 1 0
    //   318: ifeq +66 -> 384
    //   321: aload_2
    //   322: invokeinterface 208 1 0
    //   327: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   330: astore 7
    //   332: aload 10
    //   334: aload 7
    //   336: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   339: aload 7
    //   341: getfield 252	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InArt	Ljava/lang/String;
    //   344: invokestatic 256	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Z
    //   347: ifne -39 -> 308
    //   350: iconst_0
    //   351: istore 6
    //   353: ldc 160
    //   355: ldc_w 258
    //   358: iconst_2
    //   359: anewarray 164	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: aload 7
    //   366: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   369: aastore
    //   370: dup
    //   371: iconst_1
    //   372: aload 10
    //   374: invokevirtual 261	java/io/File:length	()J
    //   377: invokestatic 266	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   380: aastore
    //   381: invokestatic 269	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: iload 6
    //   386: ifeq +193 -> 579
    //   389: getstatic 32	com/tencent/tinker/lib/c/e:SjE	Ljava/util/HashMap;
    //   392: invokevirtual 273	java/util/HashMap:values	()Ljava/util/Collection;
    //   395: invokeinterface 276 1 0
    //   400: astore_0
    //   401: aload_0
    //   402: invokeinterface 204 1 0
    //   407: ifeq +212 -> 619
    //   410: aload_0
    //   411: invokeinterface 208 1 0
    //   416: checkcast 118	java/io/File
    //   419: invokestatic 280	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   422: pop
    //   423: goto -22 -> 401
    //   426: astore_2
    //   427: aload 8
    //   429: invokevirtual 243	com/tencent/tinker/d/a/a:closeEntry	()V
    //   432: aload_2
    //   433: athrow
    //   434: astore_2
    //   435: aload 7
    //   437: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   440: aload 9
    //   442: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   445: aload_2
    //   446: athrow
    //   447: astore_0
    //   448: aload 8
    //   450: astore_1
    //   451: aload_1
    //   452: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   455: aload_0
    //   456: athrow
    //   457: new 83	java/util/zip/ZipEntry
    //   460: dup
    //   461: aload 7
    //   463: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   466: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   469: astore 11
    //   471: aload 11
    //   473: iconst_0
    //   474: invokevirtual 221	java/util/zip/ZipEntry:setMethod	(I)V
    //   477: aload 11
    //   479: aload 9
    //   481: invokevirtual 261	java/io/File:length	()J
    //   484: invokevirtual 228	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   487: aload 11
    //   489: aload 9
    //   491: invokevirtual 261	java/io/File:length	()J
    //   494: invokevirtual 231	java/util/zip/ZipEntry:setSize	(J)V
    //   497: aload 11
    //   499: aload 9
    //   501: invokestatic 286	com/tencent/tinker/c/b/a:ac	(Ljava/io/File;)J
    //   504: invokevirtual 237	java/util/zip/ZipEntry:setCrc	(J)V
    //   507: new 44	java/io/BufferedInputStream
    //   510: dup
    //   511: new 288	java/io/FileInputStream
    //   514: dup
    //   515: aload 9
    //   517: invokespecial 289	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   520: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   523: astore 7
    //   525: aload 8
    //   527: aload 11
    //   529: invokevirtual 238	com/tencent/tinker/d/a/a:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   532: aload 7
    //   534: aload 8
    //   536: invokestatic 242	com/tencent/tinker/c/b/b:d	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   539: aload 8
    //   541: invokevirtual 243	com/tencent/tinker/d/a/a:closeEntry	()V
    //   544: aload 7
    //   546: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   549: goto -443 -> 106
    //   552: astore_2
    //   553: aload 8
    //   555: invokevirtual 243	com/tencent/tinker/d/a/a:closeEntry	()V
    //   558: aload_2
    //   559: athrow
    //   560: astore_2
    //   561: aload 7
    //   563: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   566: aload_2
    //   567: athrow
    //   568: aload 8
    //   570: invokestatic 135	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   573: iconst_1
    //   574: istore 5
    //   576: goto -289 -> 287
    //   579: ldc 160
    //   581: ldc_w 291
    //   584: iconst_0
    //   585: anewarray 164	java/lang/Object
    //   588: invokestatic 269	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: aload 10
    //   593: invokestatic 280	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   596: pop
    //   597: aload_0
    //   598: invokestatic 297	com/tencent/tinker/lib/e/a:lk	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   601: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   604: aload_1
    //   605: aload 10
    //   607: aload 10
    //   609: invokevirtual 302	java/io/File:getName	()Ljava/lang/String;
    //   612: bipush 7
    //   614: invokeinterface 307 5 0
    //   619: ldc 160
    //   621: ldc_w 309
    //   624: iconst_4
    //   625: anewarray 164	java/lang/Object
    //   628: dup
    //   629: iconst_0
    //   630: aload 10
    //   632: invokevirtual 312	java/io/File:getPath	()Ljava/lang/String;
    //   635: aastore
    //   636: dup
    //   637: iconst_1
    //   638: iload 6
    //   640: invokestatic 317	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   643: aastore
    //   644: dup
    //   645: iconst_2
    //   646: aload 10
    //   648: invokevirtual 261	java/io/File:length	()J
    //   651: invokestatic 266	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   654: aastore
    //   655: dup
    //   656: iconst_3
    //   657: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   660: lload_3
    //   661: lsub
    //   662: invokestatic 266	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   665: aastore
    //   666: invokestatic 320	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   669: iload 6
    //   671: ireturn
    //   672: astore_0
    //   673: aconst_null
    //   674: astore_1
    //   675: goto -224 -> 451
    //   678: astore_0
    //   679: aload_2
    //   680: astore_1
    //   681: goto -230 -> 451
    //   684: astore 7
    //   686: goto -419 -> 267
    //   689: astore_2
    //   690: aconst_null
    //   691: astore 7
    //   693: goto -132 -> 561
    //   696: astore_2
    //   697: aconst_null
    //   698: astore 7
    //   700: aconst_null
    //   701: astore 9
    //   703: goto -268 -> 435
    //   706: astore_2
    //   707: aconst_null
    //   708: astore 7
    //   710: goto -275 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	paramContext	Context
    //   0	713	1	paramFile	File
    //   0	713	2	paramString	String
    //   66	595	3	l	long
    //   144	431	5	bool1	boolean
    //   289	381	6	bool2	boolean
    //   124	126	7	localObject1	Object
    //   262	8	7	localThrowable1	Throwable
    //   330	232	7	localObject2	Object
    //   684	1	7	localThrowable2	Throwable
    //   691	18	7	localObject3	Object
    //   92	477	8	locala	com.tencent.tinker.d.a.a
    //   137	565	9	localObject4	Object
    //   27	620	10	localFile	File
    //   183	345	11	localZipEntry1	ZipEntry
    //   169	55	12	localZipEntry2	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   94	106	262	java/lang/Throwable
    //   106	146	262	java/lang/Throwable
    //   249	259	262	java/lang/Throwable
    //   435	447	262	java/lang/Throwable
    //   457	507	262	java/lang/Throwable
    //   544	549	262	java/lang/Throwable
    //   561	568	262	java/lang/Throwable
    //   230	244	426	finally
    //   244	249	434	finally
    //   427	434	434	finally
    //   94	106	447	finally
    //   106	146	447	finally
    //   249	259	447	finally
    //   435	447	447	finally
    //   457	507	447	finally
    //   544	549	447	finally
    //   561	568	447	finally
    //   525	539	552	finally
    //   539	544	560	finally
    //   553	560	560	finally
    //   69	94	672	finally
    //   267	280	678	finally
    //   69	94	684	java/lang/Throwable
    //   507	525	689	finally
    //   151	162	696	finally
    //   162	230	706	finally
  }
  
  private static boolean a(Context paramContext, List<File> paramList, String paramString, File paramFile, com.tencent.tinker.lib.service.a parama)
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lk(paramContext);
    SjC.clear();
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
      SjC.add(new File((String)localObject2));
    }
    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[] { Integer.valueOf(paramList.size()), paramString });
    localObject1 = new Vector();
    Object localObject2 = new Throwable[1];
    if (parama != null) {
      parama.SjK = System.currentTimeMillis();
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
        this.SjG.add(paramAnonymousFile1);
        this.SjH[0] = paramAnonymousThrowable;
      }
      
      public final void onStart(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        this.startTime = System.currentTimeMillis();
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", new Object[] { paramAnonymousFile1.getPath(), Long.valueOf(paramAnonymousFile1.length()) });
      }
      
      public final void onSuccess(File arg1, File paramAnonymousFile2, File paramAnonymousFile3)
      {
        ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", new Object[] { ???.getPath(), paramAnonymousFile3.getPath(), Long.valueOf(paramAnonymousFile3.length()), Long.valueOf(System.currentTimeMillis() - this.startTime) });
        if (!paramAnonymousFile3.exists()) {
          synchronized (this.SjF)
          {
            this.SjF[0] = true;
            return;
          }
        }
      }
    });
    if (parama != null) {
      if (paramString[0] != 0) {
        break label254;
      }
    }
    for (bool = true;; bool = false) {
      label254:
      try
      {
        parama.SjL = bool;
        if (((List)localObject1).isEmpty()) {
          break;
        }
        locala.SjV.a(paramFile, (List)localObject1, localObject2[0]);
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
    if (SjC.isEmpty()) {
      return true;
    }
    int j = SjD.size() * 30;
    int i = j;
    if (j > 120) {
      i = 120;
    }
    ShareTinkerLog.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", new Object[] { Integer.valueOf(SjD.size()), Integer.valueOf(SjC.size()), Integer.valueOf(i) });
    j = 0;
    for (;;)
    {
      if (j < i)
      {
        Iterator localIterator1 = SjC.iterator();
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
    Iterator localIterator2 = SjC.iterator();
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
      parama.SjV.a(paramFile, (List)localObject1, new TinkerRuntimeException("checkDexOptExist failed"));
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject2 = SjC.iterator();
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
                parama.SjV.a(paramFile, (List)localObject1, localTinkerRuntimeException);
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
  private static boolean b(Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/tinker/lib/c/e:SjD	Ljava/util/ArrayList;
    //   3: invokevirtual 324	java/util/ArrayList:clear	()V
    //   6: aload_2
    //   7: getstatic 27	com/tencent/tinker/lib/c/e:SjD	Ljava/util/ArrayList;
    //   10: invokestatic 516	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:parseDexDiffPatchInfo	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   13: getstatic 27	com/tencent/tinker/lib/c/e:SjD	Ljava/util/ArrayList;
    //   16: invokevirtual 152	java/util/ArrayList:isEmpty	()Z
    //   19: ifeq +24 -> 43
    //   22: ldc 160
    //   24: ldc_w 518
    //   27: iconst_1
    //   28: anewarray 164	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iconst_3
    //   34: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: iconst_1
    //   42: ireturn
    //   43: new 118	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 328	java/io/File:exists	()Z
    //   56: ifne +8 -> 64
    //   59: aload_2
    //   60: invokevirtual 331	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_0
    //   65: invokestatic 297	com/tencent/tinker/lib/e/a:lk	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   68: astore 10
    //   70: aconst_null
    //   71: astore 9
    //   73: aconst_null
    //   74: astore 8
    //   76: aload_0
    //   77: invokevirtual 528	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   80: astore_2
    //   81: aload_2
    //   82: ifnonnull +25 -> 107
    //   85: ldc 160
    //   87: ldc_w 530
    //   90: iconst_0
    //   91: anewarray 164	java/lang/Object
    //   94: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   101: aconst_null
    //   102: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: new 46	java/util/zip/ZipFile
    //   110: dup
    //   111: aload_2
    //   112: getfield 539	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   115: invokespecial 540	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   118: astore_2
    //   119: new 46	java/util/zip/ZipFile
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 213	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   127: astore 7
    //   129: aload_1
    //   130: invokestatic 543	com/tencent/tinker/lib/c/e:bqI	(Ljava/lang/String;)Z
    //   133: ifeq +31 -> 164
    //   136: ldc 160
    //   138: ldc_w 545
    //   141: iconst_1
    //   142: anewarray 164	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc 154
    //   149: aastore
    //   150: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   157: aload 7
    //   159: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   162: iconst_1
    //   163: ireturn
    //   164: getstatic 27	com/tencent/tinker/lib/c/e:SjD	Ljava/util/ArrayList;
    //   167: invokevirtual 458	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   170: astore 11
    //   172: aload 11
    //   174: invokeinterface 204 1 0
    //   179: ifeq +1192 -> 1371
    //   182: aload 11
    //   184: invokeinterface 208 1 0
    //   189: checkcast 55	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   192: astore 12
    //   194: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   197: lstore 4
    //   199: aload 12
    //   201: getfield 548	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   204: ldc_w 550
    //   207: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifeq +133 -> 343
    //   213: aload 12
    //   215: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   218: astore 8
    //   220: aload 12
    //   222: getfield 553	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:dexDiffMd5	Ljava/lang/String;
    //   225: astore 14
    //   227: aload 12
    //   229: getfield 556	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:oldDexCrC	Ljava/lang/String;
    //   232: astore 13
    //   234: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   237: ifne +143 -> 380
    //   240: aload 12
    //   242: getfield 509	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InDvm	Ljava/lang/String;
    //   245: ldc_w 558
    //   248: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq +129 -> 380
    //   254: ldc 160
    //   256: ldc_w 560
    //   259: iconst_1
    //   260: anewarray 164	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload 8
    //   267: aastore
    //   268: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -99 -> 172
    //   274: astore_1
    //   275: aload_2
    //   276: astore_0
    //   277: aload 7
    //   279: astore_2
    //   280: new 111	com/tencent/tinker/loader/TinkerRuntimeException
    //   283: dup
    //   284: new 113	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 562
    //   291: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: iconst_3
    //   295: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   298: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 564
    //   304: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 567	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 569
    //   317: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aload_1
    //   324: invokespecial 502	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   327: athrow
    //   328: astore_3
    //   329: aload_0
    //   330: astore_1
    //   331: aload_3
    //   332: astore_0
    //   333: aload_1
    //   334: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   337: aload_2
    //   338: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   341: aload_0
    //   342: athrow
    //   343: new 113	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   350: aload 12
    //   352: getfield 548	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   355: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc_w 571
    //   361: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload 12
    //   366: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   369: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: astore 8
    //   377: goto -157 -> 220
    //   380: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   383: ifeq +76 -> 459
    //   386: aload 12
    //   388: getfield 252	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InArt	Ljava/lang/String;
    //   391: astore 9
    //   393: aload 9
    //   395: invokestatic 574	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   398: ifne +71 -> 469
    //   401: ldc 160
    //   403: ldc_w 576
    //   406: iconst_3
    //   407: anewarray 164	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: iconst_3
    //   413: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   416: aastore
    //   417: dup
    //   418: iconst_1
    //   419: aload 12
    //   421: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   424: aastore
    //   425: dup
    //   426: iconst_2
    //   427: aload 9
    //   429: aastore
    //   430: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: aload 10
    //   435: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   438: aload_3
    //   439: iconst_3
    //   440: invokestatic 580	com/tencent/tinker/lib/c/c:asu	(I)I
    //   443: invokeinterface 583 3 0
    //   448: aload_2
    //   449: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   452: aload 7
    //   454: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   457: iconst_0
    //   458: ireturn
    //   459: aload 12
    //   461: getfield 509	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:destMd5InDvm	Ljava/lang/String;
    //   464: astore 9
    //   466: goto -73 -> 393
    //   469: new 118	java/io/File
    //   472: dup
    //   473: new 113	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   480: aload_1
    //   481: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 12
    //   486: getfield 586	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:realName	Ljava/lang/String;
    //   489: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   498: astore 15
    //   500: aload 15
    //   502: invokevirtual 328	java/io/File:exists	()Z
    //   505: ifeq +155 -> 660
    //   508: aload 15
    //   510: aload 9
    //   512: invokestatic 589	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   515: ifeq +26 -> 541
    //   518: ldc 160
    //   520: ldc_w 591
    //   523: iconst_1
    //   524: anewarray 164	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: aload 15
    //   531: invokevirtual 312	java/io/File:getPath	()Ljava/lang/String;
    //   534: aastore
    //   535: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: goto -366 -> 172
    //   541: ldc 160
    //   543: new 113	java/lang/StringBuilder
    //   546: dup
    //   547: ldc_w 593
    //   550: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   553: aload 15
    //   555: invokevirtual 312	java/io/File:getPath	()Ljava/lang/String;
    //   558: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: iconst_0
    //   565: anewarray 164	java/lang/Object
    //   568: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload 15
    //   573: invokevirtual 596	java/io/File:delete	()Z
    //   576: pop
    //   577: aload 7
    //   579: aload 8
    //   581: invokevirtual 217	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   584: astore 17
    //   586: aload_2
    //   587: aload 8
    //   589: invokevirtual 217	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   592: astore 16
    //   594: aload 13
    //   596: ldc_w 558
    //   599: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   602: ifeq +144 -> 746
    //   605: aload 17
    //   607: ifnonnull +65 -> 672
    //   610: ldc 160
    //   612: ldc_w 598
    //   615: aload 8
    //   617: invokestatic 441	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   620: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   623: iconst_0
    //   624: anewarray 164	java/lang/Object
    //   627: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   630: aload 10
    //   632: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   635: aload_3
    //   636: aload 15
    //   638: aload 12
    //   640: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   643: iconst_3
    //   644: invokeinterface 307 5 0
    //   649: aload_2
    //   650: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   653: aload 7
    //   655: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   658: iconst_0
    //   659: ireturn
    //   660: aload 15
    //   662: invokevirtual 602	java/io/File:getParentFile	()Ljava/io/File;
    //   665: invokevirtual 331	java/io/File:mkdirs	()Z
    //   668: pop
    //   669: goto -92 -> 577
    //   672: aload 7
    //   674: aload 17
    //   676: aload 15
    //   678: aload 12
    //   680: invokestatic 604	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   683: ifne -511 -> 172
    //   686: ldc 160
    //   688: new 113	java/lang/StringBuilder
    //   691: dup
    //   692: ldc_w 606
    //   695: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   698: aload 15
    //   700: invokevirtual 312	java/io/File:getPath	()Ljava/lang/String;
    //   703: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: iconst_0
    //   710: anewarray 164	java/lang/Object
    //   713: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   716: aload 10
    //   718: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   721: aload_3
    //   722: aload 15
    //   724: aload 12
    //   726: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   729: iconst_3
    //   730: invokeinterface 307 5 0
    //   735: aload_2
    //   736: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   739: aload 7
    //   741: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   744: iconst_0
    //   745: ireturn
    //   746: aload 14
    //   748: ldc_w 558
    //   751: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   754: ifeq +228 -> 982
    //   757: getstatic 39	com/tencent/tinker/lib/c/e:isVmArt	Z
    //   760: ifeq -588 -> 172
    //   763: aload 16
    //   765: ifnonnull +53 -> 818
    //   768: ldc 160
    //   770: ldc_w 608
    //   773: aload 8
    //   775: invokestatic 441	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   778: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   781: iconst_0
    //   782: anewarray 164	java/lang/Object
    //   785: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   788: aload 10
    //   790: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   793: aload_3
    //   794: aload 15
    //   796: aload 12
    //   798: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   801: iconst_3
    //   802: invokeinterface 307 5 0
    //   807: aload_2
    //   808: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   811: aload 7
    //   813: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   816: iconst_0
    //   817: ireturn
    //   818: aload 16
    //   820: invokevirtual 234	java/util/zip/ZipEntry:getCrc	()J
    //   823: invokestatic 611	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   826: astore 14
    //   828: aload 14
    //   830: aload 13
    //   832: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   835: ifne +60 -> 895
    //   838: ldc 160
    //   840: ldc_w 613
    //   843: iconst_3
    //   844: anewarray 164	java/lang/Object
    //   847: dup
    //   848: iconst_0
    //   849: aload 8
    //   851: aastore
    //   852: dup
    //   853: iconst_1
    //   854: aload 13
    //   856: aastore
    //   857: dup
    //   858: iconst_2
    //   859: aload 14
    //   861: aastore
    //   862: invokestatic 269	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   865: aload 10
    //   867: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   870: aload_3
    //   871: aload 15
    //   873: aload 12
    //   875: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   878: iconst_3
    //   879: invokeinterface 307 5 0
    //   884: aload_2
    //   885: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   888: aload 7
    //   890: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   893: iconst_0
    //   894: ireturn
    //   895: aload_2
    //   896: aload 16
    //   898: aload 15
    //   900: aload 12
    //   902: invokestatic 604	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   905: pop
    //   906: aload 15
    //   908: aload 9
    //   910: invokestatic 589	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   913: ifne -741 -> 172
    //   916: ldc 160
    //   918: new 113	java/lang/StringBuilder
    //   921: dup
    //   922: ldc_w 615
    //   925: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   928: aload 15
    //   930: invokevirtual 312	java/io/File:getPath	()Ljava/lang/String;
    //   933: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: iconst_0
    //   940: anewarray 164	java/lang/Object
    //   943: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   946: aload 10
    //   948: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   951: aload_3
    //   952: aload 15
    //   954: aload 12
    //   956: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   959: iconst_3
    //   960: invokeinterface 307 5 0
    //   965: aload 15
    //   967: invokestatic 280	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   970: pop
    //   971: aload_2
    //   972: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   975: aload 7
    //   977: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   980: iconst_0
    //   981: ireturn
    //   982: aload 17
    //   984: ifnonnull +53 -> 1037
    //   987: ldc 160
    //   989: ldc_w 598
    //   992: aload 8
    //   994: invokestatic 441	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   997: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1000: iconst_0
    //   1001: anewarray 164	java/lang/Object
    //   1004: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1007: aload 10
    //   1009: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   1012: aload_3
    //   1013: aload 15
    //   1015: aload 12
    //   1017: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1020: iconst_3
    //   1021: invokeinterface 307 5 0
    //   1026: aload_2
    //   1027: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1030: aload 7
    //   1032: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1035: iconst_0
    //   1036: ireturn
    //   1037: aload 14
    //   1039: invokestatic 574	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   1042: ifne +61 -> 1103
    //   1045: ldc 160
    //   1047: ldc_w 576
    //   1050: iconst_3
    //   1051: anewarray 164	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: iconst_3
    //   1057: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   1060: aastore
    //   1061: dup
    //   1062: iconst_1
    //   1063: aload 12
    //   1065: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1068: aastore
    //   1069: dup
    //   1070: iconst_2
    //   1071: aload 14
    //   1073: aastore
    //   1074: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1077: aload 10
    //   1079: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   1082: aload_3
    //   1083: iconst_3
    //   1084: invokestatic 580	com/tencent/tinker/lib/c/c:asu	(I)I
    //   1087: invokeinterface 583 3 0
    //   1092: aload_2
    //   1093: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1096: aload 7
    //   1098: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1101: iconst_0
    //   1102: ireturn
    //   1103: aload 16
    //   1105: ifnonnull +53 -> 1158
    //   1108: ldc 160
    //   1110: ldc_w 608
    //   1113: aload 8
    //   1115: invokestatic 441	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1118: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1121: iconst_0
    //   1122: anewarray 164	java/lang/Object
    //   1125: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1128: aload 10
    //   1130: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   1133: aload_3
    //   1134: aload 15
    //   1136: aload 12
    //   1138: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1141: iconst_3
    //   1142: invokeinterface 307 5 0
    //   1147: aload_2
    //   1148: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1151: aload 7
    //   1153: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1156: iconst_0
    //   1157: ireturn
    //   1158: aload 16
    //   1160: invokevirtual 234	java/util/zip/ZipEntry:getCrc	()J
    //   1163: invokestatic 611	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1166: astore 14
    //   1168: aload 14
    //   1170: aload 13
    //   1172: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1175: ifne +60 -> 1235
    //   1178: ldc 160
    //   1180: ldc_w 613
    //   1183: iconst_3
    //   1184: anewarray 164	java/lang/Object
    //   1187: dup
    //   1188: iconst_0
    //   1189: aload 8
    //   1191: aastore
    //   1192: dup
    //   1193: iconst_1
    //   1194: aload 13
    //   1196: aastore
    //   1197: dup
    //   1198: iconst_2
    //   1199: aload 14
    //   1201: aastore
    //   1202: invokestatic 269	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1205: aload 10
    //   1207: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   1210: aload_3
    //   1211: aload 15
    //   1213: aload 12
    //   1215: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1218: iconst_3
    //   1219: invokeinterface 307 5 0
    //   1224: aload_2
    //   1225: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1228: aload 7
    //   1230: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1233: iconst_0
    //   1234: ireturn
    //   1235: aload_2
    //   1236: aload 7
    //   1238: aload 16
    //   1240: aload 17
    //   1242: aload 12
    //   1244: aload 15
    //   1246: invokestatic 617	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipEntry;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;Ljava/io/File;)V
    //   1249: aload 15
    //   1251: aload 9
    //   1253: invokestatic 589	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyDexFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   1256: ifne +69 -> 1325
    //   1259: ldc 160
    //   1261: new 113	java/lang/StringBuilder
    //   1264: dup
    //   1265: ldc_w 615
    //   1268: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1271: aload 15
    //   1273: invokevirtual 312	java/io/File:getPath	()Ljava/lang/String;
    //   1276: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1282: iconst_0
    //   1283: anewarray 164	java/lang/Object
    //   1286: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1289: aload 10
    //   1291: getfield 301	com/tencent/tinker/lib/e/a:SjV	Lcom/tencent/tinker/lib/d/d;
    //   1294: aload_3
    //   1295: aload 15
    //   1297: aload 12
    //   1299: getfield 59	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:rawName	Ljava/lang/String;
    //   1302: iconst_3
    //   1303: invokeinterface 307 5 0
    //   1308: aload 15
    //   1310: invokestatic 280	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   1313: pop
    //   1314: aload_2
    //   1315: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1318: aload 7
    //   1320: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1323: iconst_0
    //   1324: ireturn
    //   1325: ldc 160
    //   1327: ldc_w 619
    //   1330: iconst_3
    //   1331: anewarray 164	java/lang/Object
    //   1334: dup
    //   1335: iconst_0
    //   1336: aload 15
    //   1338: invokevirtual 312	java/io/File:getPath	()Ljava/lang/String;
    //   1341: aastore
    //   1342: dup
    //   1343: iconst_1
    //   1344: aload 15
    //   1346: invokevirtual 261	java/io/File:length	()J
    //   1349: invokestatic 266	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1352: aastore
    //   1353: dup
    //   1354: iconst_2
    //   1355: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   1358: lload 4
    //   1360: lsub
    //   1361: invokestatic 266	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1364: aastore
    //   1365: invokestatic 180	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1368: goto -1196 -> 172
    //   1371: aload_0
    //   1372: aload_3
    //   1373: aload_1
    //   1374: invokestatic 621	com/tencent/tinker/lib/c/e:a	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z
    //   1377: istore 6
    //   1379: iload 6
    //   1381: ifne +14 -> 1395
    //   1384: aload_2
    //   1385: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1388: aload 7
    //   1390: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1393: iconst_0
    //   1394: ireturn
    //   1395: aload_2
    //   1396: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1399: aload 7
    //   1401: invokestatic 534	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1404: iconst_1
    //   1405: ireturn
    //   1406: astore_0
    //   1407: aconst_null
    //   1408: astore_1
    //   1409: aload 9
    //   1411: astore_2
    //   1412: goto -1079 -> 333
    //   1415: astore_0
    //   1416: aload_2
    //   1417: astore_1
    //   1418: aload 9
    //   1420: astore_2
    //   1421: goto -1088 -> 333
    //   1424: astore_1
    //   1425: aconst_null
    //   1426: astore_0
    //   1427: aload 8
    //   1429: astore_2
    //   1430: goto -1150 -> 280
    //   1433: astore_1
    //   1434: aload_2
    //   1435: astore_0
    //   1436: aload 8
    //   1438: astore_2
    //   1439: goto -1159 -> 280
    //   1442: astore_0
    //   1443: aload_2
    //   1444: astore_1
    //   1445: aload 7
    //   1447: astore_2
    //   1448: goto -1115 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1451	0	paramContext	Context
    //   0	1451	1	paramString1	String
    //   0	1451	2	paramString2	String
    //   0	1451	3	paramFile	File
    //   197	1162	4	l	long
    //   1377	3	6	bool	boolean
    //   127	1319	7	localZipFile	ZipFile
    //   74	1363	8	str1	String
    //   71	1348	9	str2	String
    //   68	1222	10	locala	com.tencent.tinker.lib.e.a
    //   170	13	11	localIterator	Iterator
    //   192	1106	12	localShareDexDiffPatchInfo	ShareDexDiffPatchInfo
    //   232	963	13	str3	String
    //   225	975	14	str4	String
    //   498	847	15	localFile	File
    //   592	647	16	localZipEntry1	ZipEntry
    //   584	657	17	localZipEntry2	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   129	153	274	java/lang/Throwable
    //   164	172	274	java/lang/Throwable
    //   172	220	274	java/lang/Throwable
    //   220	271	274	java/lang/Throwable
    //   343	377	274	java/lang/Throwable
    //   380	393	274	java/lang/Throwable
    //   393	448	274	java/lang/Throwable
    //   459	466	274	java/lang/Throwable
    //   469	538	274	java/lang/Throwable
    //   541	577	274	java/lang/Throwable
    //   577	605	274	java/lang/Throwable
    //   610	649	274	java/lang/Throwable
    //   660	669	274	java/lang/Throwable
    //   672	735	274	java/lang/Throwable
    //   746	763	274	java/lang/Throwable
    //   768	807	274	java/lang/Throwable
    //   818	884	274	java/lang/Throwable
    //   895	971	274	java/lang/Throwable
    //   987	1026	274	java/lang/Throwable
    //   1037	1092	274	java/lang/Throwable
    //   1108	1147	274	java/lang/Throwable
    //   1158	1224	274	java/lang/Throwable
    //   1235	1314	274	java/lang/Throwable
    //   1325	1368	274	java/lang/Throwable
    //   1371	1379	274	java/lang/Throwable
    //   280	328	328	finally
    //   76	81	1406	finally
    //   85	97	1406	finally
    //   107	119	1406	finally
    //   119	129	1415	finally
    //   76	81	1424	java/lang/Throwable
    //   85	97	1424	java/lang/Throwable
    //   107	119	1424	java/lang/Throwable
    //   119	129	1433	java/lang/Throwable
    //   129	153	1442	finally
    //   164	172	1442	finally
    //   172	220	1442	finally
    //   220	271	1442	finally
    //   343	377	1442	finally
    //   380	393	1442	finally
    //   393	448	1442	finally
    //   459	466	1442	finally
    //   469	538	1442	finally
    //   541	577	1442	finally
    //   577	605	1442	finally
    //   610	649	1442	finally
    //   660	669	1442	finally
    //   672	735	1442	finally
    //   746	763	1442	finally
    //   768	807	1442	finally
    //   818	884	1442	finally
    //   895	971	1442	finally
    //   987	1026	1442	finally
    //   1037	1092	1442	finally
    //   1108	1147	1442	finally
    //   1158	1224	1442	finally
    //   1235	1314	1442	finally
    //   1325	1368	1442	finally
    //   1371	1379	1442	finally
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
  
  private static boolean bqI(String paramString)
  {
    if ((SjD.isEmpty()) || (!isVmArt)) {
      return false;
    }
    Iterator localIterator = SjD.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      ShareDexDiffPatchInfo localShareDexDiffPatchInfo = (ShareDexDiffPatchInfo)localIterator.next();
      File localFile = new File(paramString + localShareDexDiffPatchInfo.realName);
      String str = localFile.getName();
      if (ShareConstants.CLASS_N_PATTERN.matcher(str).matches()) {
        SjE.put(localShareDexDiffPatchInfo, localFile);
      }
      if (!localShareDexDiffPatchInfo.rawName.startsWith("test.dex")) {
        break label329;
      }
      localObject2 = localFile;
      localObject1 = localShareDexDiffPatchInfo;
    }
    label329:
    for (;;)
    {
      break;
      if (localObject1 != null) {
        SjE.put(ShareTinkerInternals.changeTestDexToClassN((ShareDexDiffPatchInfo)localObject1, SjE.size() + 1), localObject2);
      }
      paramString = new File(paramString, "tinker_classN.apk");
      if (paramString.exists())
      {
        localObject1 = SjE.keySet().iterator();
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
          paramString = SjE.values().iterator();
          while (paramString.hasNext()) {
            SharePatchFileUtil.safeDeleteFile((File)paramString.next());
          }
        }
        return bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.c.e
 * JD-Core Version:    0.7.0.1
 */