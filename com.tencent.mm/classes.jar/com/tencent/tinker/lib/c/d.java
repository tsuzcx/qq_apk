package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
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

public final class d
  extends b
{
  private static ArrayList<File> wVT = new ArrayList();
  private static ArrayList<ShareDexDiffPatchInfo> wVU = new ArrayList();
  private static HashMap<ShareDexDiffPatchInfo, File> wVV = new HashMap();
  private static boolean wVW = ShareTinkerInternals.cQP();
  
  /* Error */
  private static void a(ZipFile paramZipFile1, ZipFile paramZipFile2, ZipEntry paramZipEntry1, ZipEntry paramZipEntry2, ShareDexDiffPatchInfo paramShareDexDiffPatchInfo, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: new 43	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 49	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   15: invokespecial 52	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_3
    //   20: ifnull +181 -> 201
    //   23: new 43	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_1
    //   28: aload_3
    //   29: invokevirtual 49	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   32: invokespecial 52	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_0
    //   36: aload 4
    //   38: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   41: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:agn	(Ljava/lang/String;)Z
    //   44: istore 6
    //   46: iload 6
    //   48: ifeq +15 -> 63
    //   51: aload 4
    //   53: getfield 67	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYt	Z
    //   56: istore 7
    //   58: iload 7
    //   60: ifeq +200 -> 260
    //   63: new 69	java/util/zip/ZipOutputStream
    //   66: dup
    //   67: new 71	java/io/BufferedOutputStream
    //   70: dup
    //   71: new 73	java/io/FileOutputStream
    //   74: dup
    //   75: aload 5
    //   77: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   83: invokespecial 80	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore 4
    //   88: aload 4
    //   90: new 82	java/util/zip/ZipEntry
    //   93: dup
    //   94: ldc 84
    //   96: invokespecial 87	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 91	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   102: iload 6
    //   104: ifne +139 -> 243
    //   107: new 93	java/util/zip/ZipInputStream
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 94	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 98	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +15 -> 137
    //   125: ldc 84
    //   127: aload_1
    //   128: invokevirtual 102	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   131: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq -18 -> 116
    //   137: aload_1
    //   138: ifnonnull +68 -> 206
    //   141: new 110	com/tencent/tinker/loader/TinkerRuntimeException
    //   144: dup
    //   145: new 112	java/lang/StringBuilder
    //   148: dup
    //   149: ldc 114
    //   151: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload 5
    //   156: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 128	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: astore_1
    //   170: aload_3
    //   171: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload 4
    //   179: astore_3
    //   180: aload_3
    //   181: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   184: aload_1
    //   185: athrow
    //   186: astore_3
    //   187: aload_0
    //   188: astore_1
    //   189: aload_3
    //   190: astore_0
    //   191: aload_2
    //   192: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   195: aload_1
    //   196: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   199: aload_0
    //   200: athrow
    //   201: aconst_null
    //   202: astore_0
    //   203: goto -167 -> 36
    //   206: new 136	com/tencent/tinker/c/a/a
    //   209: dup
    //   210: aload_3
    //   211: aload_0
    //   212: invokespecial 139	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   215: aload 4
    //   217: invokevirtual 141	com/tencent/tinker/c/a/a:a	(Ljava/io/OutputStream;)V
    //   220: aload_3
    //   221: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   224: aload 4
    //   226: invokevirtual 144	java/util/zip/ZipOutputStream:closeEntry	()V
    //   229: aload 4
    //   231: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   234: aload_2
    //   235: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   238: aload_0
    //   239: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   242: return
    //   243: new 136	com/tencent/tinker/c/a/a
    //   246: dup
    //   247: aload_2
    //   248: aload_0
    //   249: invokespecial 139	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   252: aload 4
    //   254: invokevirtual 141	com/tencent/tinker/c/a/a:a	(Ljava/io/OutputStream;)V
    //   257: goto -33 -> 224
    //   260: new 136	com/tencent/tinker/c/a/a
    //   263: dup
    //   264: aload_2
    //   265: aload_0
    //   266: invokespecial 139	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   269: astore_1
    //   270: new 71	java/io/BufferedOutputStream
    //   273: dup
    //   274: new 73	java/io/FileOutputStream
    //   277: dup
    //   278: aload 5
    //   280: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   286: astore_3
    //   287: aload_1
    //   288: aload_3
    //   289: invokevirtual 141	com/tencent/tinker/c/a/a:a	(Ljava/io/OutputStream;)V
    //   292: aload_3
    //   293: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   296: goto -62 -> 234
    //   299: aload_3
    //   300: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
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
    //   0: getstatic 25	com/tencent/tinker/lib/c/d:wVU	Ljava/util/ArrayList;
    //   3: invokevirtual 150	java/util/ArrayList:isEmpty	()Z
    //   6: ifne +9 -> 15
    //   9: getstatic 38	com/tencent/tinker/lib/c/d:wVW	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: new 117	java/io/File
    //   20: dup
    //   21: aload_2
    //   22: ldc 152
    //   24: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore 10
    //   29: getstatic 30	com/tencent/tinker/lib/c/d:wVV	Ljava/util/HashMap;
    //   32: invokevirtual 156	java/util/HashMap:isEmpty	()Z
    //   35: ifeq +28 -> 63
    //   38: ldc 158
    //   40: ldc 160
    //   42: iconst_1
    //   43: anewarray 162	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: getstatic 30	com/tencent/tinker/lib/c/d:wVV	Ljava/util/HashMap;
    //   51: invokevirtual 166	java/util/HashMap:size	()I
    //   54: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   66: lstore_3
    //   67: aconst_null
    //   68: astore_2
    //   69: new 186	com/tencent/tinker/d/a/h
    //   72: dup
    //   73: new 71	java/io/BufferedOutputStream
    //   76: dup
    //   77: new 73	java/io/FileOutputStream
    //   80: dup
    //   81: aload 10
    //   83: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: invokespecial 187	com/tencent/tinker/d/a/h:<init>	(Ljava/io/OutputStream;)V
    //   92: astore 8
    //   94: getstatic 30	com/tencent/tinker/lib/c/d:wVV	Ljava/util/HashMap;
    //   97: invokevirtual 191	java/util/HashMap:keySet	()Ljava/util/Set;
    //   100: invokeinterface 197 1 0
    //   105: astore_2
    //   106: aload_2
    //   107: invokeinterface 202 1 0
    //   112: ifeq +328 -> 440
    //   115: aload_2
    //   116: invokeinterface 206 1 0
    //   121: checkcast 54	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   124: astore 7
    //   126: getstatic 30	com/tencent/tinker/lib/c/d:wVV	Ljava/util/HashMap;
    //   129: aload 7
    //   131: invokevirtual 210	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 117	java/io/File
    //   137: astore 9
    //   139: aload 7
    //   141: getfield 67	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYt	Z
    //   144: istore 5
    //   146: iload 5
    //   148: ifeq +262 -> 410
    //   151: new 212	com/tencent/tinker/d/a/g
    //   154: dup
    //   155: aload 9
    //   157: invokespecial 213	com/tencent/tinker/d/a/g:<init>	(Ljava/io/File;)V
    //   160: astore 9
    //   162: aload 9
    //   164: ldc 84
    //   166: invokevirtual 217	com/tencent/tinker/d/a/g:agq	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/f;
    //   169: astore 12
    //   171: new 219	com/tencent/tinker/d/a/f
    //   174: dup
    //   175: aload 12
    //   177: aload 7
    //   179: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   182: invokespecial 222	com/tencent/tinker/d/a/f:<init>	(Lcom/tencent/tinker/d/a/f;Ljava/lang/String;)V
    //   185: astore 11
    //   187: aload 9
    //   189: aload 12
    //   191: invokevirtual 225	com/tencent/tinker/d/a/g:a	(Lcom/tencent/tinker/d/a/f;)Ljava/io/InputStream;
    //   194: astore 7
    //   196: aload 11
    //   198: aload 7
    //   200: aload 8
    //   202: invokestatic 230	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/f;Ljava/io/InputStream;Lcom/tencent/tinker/d/a/h;)V
    //   205: aload 7
    //   207: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   210: aload 9
    //   212: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   215: goto -109 -> 106
    //   218: astore 7
    //   220: aload 8
    //   222: astore_2
    //   223: ldc 158
    //   225: aload 7
    //   227: ldc 232
    //   229: iconst_0
    //   230: anewarray 162	java/lang/Object
    //   233: invokestatic 236	com/tencent/tinker/lib/f/a:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload_2
    //   237: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   240: iconst_0
    //   241: istore 5
    //   243: iload 5
    //   245: istore 6
    //   247: iload 5
    //   249: ifeq +90 -> 339
    //   252: getstatic 30	com/tencent/tinker/lib/c/d:wVV	Ljava/util/HashMap;
    //   255: invokevirtual 191	java/util/HashMap:keySet	()Ljava/util/Set;
    //   258: invokeinterface 197 1 0
    //   263: astore_2
    //   264: iload 5
    //   266: istore 6
    //   268: aload_2
    //   269: invokeinterface 202 1 0
    //   274: ifeq +65 -> 339
    //   277: aload_2
    //   278: invokeinterface 206 1 0
    //   283: checkcast 54	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   286: astore 7
    //   288: aload 10
    //   290: aload 7
    //   292: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   295: aload 7
    //   297: getfield 239	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYo	Ljava/lang/String;
    //   300: invokestatic 243	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:b	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Z
    //   303: ifne -39 -> 264
    //   306: iconst_0
    //   307: istore 6
    //   309: ldc 158
    //   311: ldc 245
    //   313: iconst_2
    //   314: anewarray 162	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: aload 7
    //   321: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   324: aastore
    //   325: dup
    //   326: iconst_1
    //   327: aload 10
    //   329: invokevirtual 248	java/io/File:length	()J
    //   332: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   335: aastore
    //   336: invokestatic 256	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: iload 6
    //   341: ifeq +110 -> 451
    //   344: getstatic 30	com/tencent/tinker/lib/c/d:wVV	Ljava/util/HashMap;
    //   347: invokevirtual 260	java/util/HashMap:values	()Ljava/util/Collection;
    //   350: invokeinterface 263 1 0
    //   355: astore_0
    //   356: aload_0
    //   357: invokeinterface 202 1 0
    //   362: ifeq +129 -> 491
    //   365: aload_0
    //   366: invokeinterface 206 1 0
    //   371: checkcast 117	java/io/File
    //   374: invokestatic 267	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ah	(Ljava/io/File;)Z
    //   377: pop
    //   378: goto -22 -> 356
    //   381: astore_2
    //   382: aconst_null
    //   383: astore 7
    //   385: aconst_null
    //   386: astore 9
    //   388: aload 7
    //   390: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   393: aload 9
    //   395: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   398: aload_2
    //   399: athrow
    //   400: astore_0
    //   401: aload 8
    //   403: astore_1
    //   404: aload_1
    //   405: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   408: aload_0
    //   409: athrow
    //   410: new 219	com/tencent/tinker/d/a/f
    //   413: dup
    //   414: aload 7
    //   416: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   419: invokespecial 268	com/tencent/tinker/d/a/f:<init>	(Ljava/lang/String;)V
    //   422: aload 9
    //   424: aload 7
    //   426: getfield 271	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYq	Ljava/lang/String;
    //   429: invokestatic 275	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   432: aload 8
    //   434: invokestatic 278	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/f;Ljava/io/File;JLcom/tencent/tinker/d/a/h;)V
    //   437: goto -331 -> 106
    //   440: aload 8
    //   442: invokestatic 134	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   445: iconst_1
    //   446: istore 5
    //   448: goto -205 -> 243
    //   451: ldc 158
    //   453: ldc_w 280
    //   456: iconst_0
    //   457: anewarray 162	java/lang/Object
    //   460: invokestatic 256	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: aload 10
    //   465: invokestatic 267	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ah	(Ljava/io/File;)Z
    //   468: pop
    //   469: aload_0
    //   470: invokestatic 286	com/tencent/tinker/lib/e/a:hN	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   473: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   476: aload_1
    //   477: aload 10
    //   479: aload 10
    //   481: invokevirtual 291	java/io/File:getName	()Ljava/lang/String;
    //   484: bipush 7
    //   486: invokeinterface 296 5 0
    //   491: ldc 158
    //   493: ldc_w 298
    //   496: iconst_4
    //   497: anewarray 162	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: aload 10
    //   504: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   507: aastore
    //   508: dup
    //   509: iconst_1
    //   510: iload 6
    //   512: invokestatic 306	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   515: aastore
    //   516: dup
    //   517: iconst_2
    //   518: aload 10
    //   520: invokevirtual 248	java/io/File:length	()J
    //   523: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   526: aastore
    //   527: dup
    //   528: iconst_3
    //   529: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   532: lload_3
    //   533: lsub
    //   534: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   537: aastore
    //   538: invokestatic 309	com/tencent/tinker/lib/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: iload 6
    //   543: ireturn
    //   544: astore_0
    //   545: aconst_null
    //   546: astore_1
    //   547: goto -143 -> 404
    //   550: astore_0
    //   551: aload_2
    //   552: astore_1
    //   553: goto -149 -> 404
    //   556: astore 7
    //   558: goto -335 -> 223
    //   561: astore_2
    //   562: aconst_null
    //   563: astore 7
    //   565: goto -177 -> 388
    //   568: astore_2
    //   569: goto -181 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	paramContext	Context
    //   0	572	1	paramFile	File
    //   0	572	2	paramString	String
    //   66	467	3	l	long
    //   144	303	5	bool1	boolean
    //   245	297	6	bool2	boolean
    //   124	82	7	localObject1	Object
    //   218	8	7	localThrowable1	Throwable
    //   286	139	7	localShareDexDiffPatchInfo	ShareDexDiffPatchInfo
    //   556	1	7	localThrowable2	Throwable
    //   563	1	7	localObject2	Object
    //   92	349	8	localh	com.tencent.tinker.d.a.h
    //   137	286	9	localObject3	Object
    //   27	492	10	localFile	File
    //   185	12	11	localf1	com.tencent.tinker.d.a.f
    //   169	21	12	localf2	com.tencent.tinker.d.a.f
    // Exception table:
    //   from	to	target	type
    //   94	106	218	java/lang/Throwable
    //   106	146	218	java/lang/Throwable
    //   205	215	218	java/lang/Throwable
    //   388	400	218	java/lang/Throwable
    //   410	437	218	java/lang/Throwable
    //   151	162	381	finally
    //   94	106	400	finally
    //   106	146	400	finally
    //   205	215	400	finally
    //   388	400	400	finally
    //   410	437	400	finally
    //   69	94	544	finally
    //   223	236	550	finally
    //   69	94	556	java/lang/Throwable
    //   162	196	561	finally
    //   196	205	568	finally
  }
  
  private static boolean a(Context paramContext, List<File> paramList, String paramString, File paramFile)
  {
    paramContext = com.tencent.tinker.lib.e.a.hN(paramContext);
    wVT.clear();
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
      return false;
    }
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = SharePatchFileUtil.k((File)((Iterator)localObject).next(), localFile);
      wVT.add(new File(str));
    }
    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[] { Integer.valueOf(paramList.size()), paramString });
    paramString = new Vector();
    localObject = new Throwable[1];
    TinkerDexOptimizer.a(paramList, localFile, new d.1(paramString, (Throwable[])localObject));
    if (!paramString.isEmpty())
    {
      paramContext.wWm.a(paramFile, paramString, localObject[0]);
      return false;
    }
    return true;
  }
  
  protected static boolean a(com.tencent.tinker.lib.e.a parama, ShareSecurityCheck paramShareSecurityCheck, Context paramContext, String paramString, File paramFile)
  {
    if (!ShareTinkerInternals.Kk(parama.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
      return true;
    }
    parama = (String)paramShareSecurityCheck.wZE.get("assets/dex_meta.txt");
    if (parama == null)
    {
      com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
      return true;
    }
    long l = SystemClock.elapsedRealtime();
    paramShareSecurityCheck = paramString + "/dex/";
    if (!b(paramContext, paramShareSecurityCheck, parama, paramFile)) {
      com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
    }
    for (boolean bool = false;; bool = a(paramContext, paramShareSecurityCheck, paramString + "/odex/", paramFile))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", new Object[] { Boolean.valueOf(bool), Long.valueOf(SystemClock.elapsedRealtime() - l) });
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
      com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "legal files to do dexopt: " + paramShareSecurityCheck, new Object[0]);
    }
  }
  
  protected static boolean a(File paramFile, com.tencent.tinker.lib.e.a parama)
  {
    if (wVT.isEmpty()) {
      return true;
    }
    int j = wVU.size() * 30;
    int i = j;
    if (j > 120) {
      i = 120;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", new Object[] { Integer.valueOf(wVU.size()), Integer.valueOf(wVT.size()), Integer.valueOf(i) });
    j = 0;
    for (;;)
    {
      if (j < i)
      {
        Iterator localIterator1 = wVT.iterator();
        int k;
        for (;;)
        {
          if (localIterator1.hasNext())
          {
            localObject1 = (File)localIterator1.next();
            if ((!SharePatchFileUtil.ae((File)localObject1)) && (!SharePatchFileUtil.af((File)localObject1)))
            {
              com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", new Object[] { ((File)localObject1).getName(), Integer.valueOf(j + 1) });
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
            com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:" + localInterruptedException, new Object[0]);
          }
        }
      }
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator2 = wVT.iterator();
    Object localObject2;
    while (localIterator2.hasNext())
    {
      localObject2 = (File)localIterator2.next();
      com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", new Object[] { ((File)localObject2).getPath(), Long.valueOf(((File)localObject2).length()) });
      if ((!SharePatchFileUtil.ae((File)localObject2)) && (!SharePatchFileUtil.af((File)localObject2)))
      {
        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", new Object[] { ((File)localObject2).getName() });
        ((List)localObject1).add(localObject2);
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      parama.wWm.a(paramFile, (List)localObject1, new TinkerRuntimeException("checkDexOptExist failed"));
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject2 = wVT.iterator();
      localIterator2 = null;
    }
    for (;;)
    {
      File localFile;
      if (((Iterator)localObject2).hasNext())
      {
        localFile = (File)((Iterator)localObject2).next();
        if (!SharePatchFileUtil.af(localFile)) {
          com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", new Object[] { localFile.getName(), Long.valueOf(localFile.length()) });
        }
      }
      else
      {
        try
        {
          i = ShareElfFile.ac(localFile);
          if (i == 1)
          {
            try
            {
              ShareElfFile localShareElfFile = new ShareElfFile(localFile);
              com.tencent.tinker.c.b.a.S(localShareElfFile);
              continue;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not elf format, return false", new Object[] { localFile.getName() });
              ((List)localObject1).add(localFile);
              com.tencent.tinker.c.b.a.S(null);
              continue;
            }
            finally
            {
              com.tencent.tinker.c.b.a.S(null);
            }
            if (!((List)localObject1).isEmpty())
            {
              if (localThrowable == null) {}
              for (TinkerRuntimeException localTinkerRuntimeException = new TinkerRuntimeException("checkDexOptFormat failed");; localTinkerRuntimeException = new TinkerRuntimeException("checkDexOptFormat failed", localTinkerRuntimeException))
              {
                parama.wWm.a(paramFile, (List)localObject1, localTinkerRuntimeException);
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
    if (wVW) {}
    for (String str1 = paramShareDexDiffPatchInfo.wYo;; str1 = paramShareDexDiffPatchInfo.wYn)
    {
      String str2 = paramShareDexDiffPatchInfo.wYm;
      boolean bool = paramShareDexDiffPatchInfo.wYt;
      if ((!SharePatchFileUtil.agn(str2)) || (!bool)) {
        break;
      }
      return b(paramZipFile, paramZipEntry, paramFile, str1);
    }
    return a(paramZipFile, paramZipEntry, paramFile, str1, true);
  }
  
  private static boolean agd(String paramString)
  {
    if ((wVU.isEmpty()) || (!wVW)) {
      return false;
    }
    Iterator localIterator = wVU.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      ShareDexDiffPatchInfo localShareDexDiffPatchInfo = (ShareDexDiffPatchInfo)localIterator.next();
      File localFile = new File(paramString + localShareDexDiffPatchInfo.dBS);
      String str = localFile.getName();
      if (ShareConstants.wYl.matcher(str).matches()) {
        wVV.put(localShareDexDiffPatchInfo, localFile);
      }
      if (!localShareDexDiffPatchInfo.wYm.startsWith("test.dex")) {
        break label328;
      }
      localObject2 = localFile;
      localObject1 = localShareDexDiffPatchInfo;
    }
    label328:
    for (;;)
    {
      break;
      if (localObject1 != null) {
        wVV.put(ShareTinkerInternals.a((ShareDexDiffPatchInfo)localObject1, wVV.size() + 1), localObject2);
      }
      paramString = new File(paramString, "tinker_classN.apk");
      if (paramString.exists())
      {
        localObject1 = wVV.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ShareDexDiffPatchInfo)((Iterator)localObject1).next();
          if (!SharePatchFileUtil.b(paramString, ((ShareDexDiffPatchInfo)localObject2).wYm, ((ShareDexDiffPatchInfo)localObject2).wYo)) {
            com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[] { ((ShareDexDiffPatchInfo)localObject2).wYm, Long.valueOf(paramString.length()) });
          }
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!bool1) {
          SharePatchFileUtil.ah(paramString);
        }
        for (bool2 = bool1; bool2; bool2 = false)
        {
          paramString = wVV.values().iterator();
          while (paramString.hasNext()) {
            SharePatchFileUtil.ah((File)paramString.next());
          }
        }
        return bool2;
      }
    }
  }
  
  /* Error */
  private static boolean b(Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: getstatic 25	com/tencent/tinker/lib/c/d:wVU	Ljava/util/ArrayList;
    //   3: invokevirtual 313	java/util/ArrayList:clear	()V
    //   6: aload_2
    //   7: getstatic 25	com/tencent/tinker/lib/c/d:wVU	Ljava/util/ArrayList;
    //   10: invokestatic 516	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:m	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   13: getstatic 25	com/tencent/tinker/lib/c/d:wVU	Ljava/util/ArrayList;
    //   16: invokevirtual 150	java/util/ArrayList:isEmpty	()Z
    //   19: ifeq +24 -> 43
    //   22: ldc 158
    //   24: ldc_w 518
    //   27: iconst_1
    //   28: anewarray 162	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iconst_3
    //   34: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: iconst_1
    //   42: ireturn
    //   43: new 117	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 314	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 317	java/io/File:exists	()Z
    //   56: ifne +8 -> 64
    //   59: aload_2
    //   60: invokevirtual 320	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_0
    //   65: invokestatic 286	com/tencent/tinker/lib/e/a:hN	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
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
    //   85: ldc 158
    //   87: ldc_w 530
    //   90: iconst_0
    //   91: anewarray 162	java/lang/Object
    //   94: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   101: aconst_null
    //   102: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: new 45	java/util/zip/ZipFile
    //   110: dup
    //   111: aload_2
    //   112: getfield 538	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   115: invokespecial 539	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   118: astore_2
    //   119: new 45	java/util/zip/ZipFile
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 540	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   127: astore 7
    //   129: aload_1
    //   130: invokestatic 542	com/tencent/tinker/lib/c/d:agd	(Ljava/lang/String;)Z
    //   133: ifeq +31 -> 164
    //   136: ldc 158
    //   138: ldc_w 544
    //   141: iconst_1
    //   142: anewarray 162	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc 152
    //   149: aastore
    //   150: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   157: aload 7
    //   159: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   162: iconst_1
    //   163: ireturn
    //   164: getstatic 25	com/tencent/tinker/lib/c/d:wVU	Ljava/util/ArrayList;
    //   167: invokevirtual 424	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   170: astore 11
    //   172: aload 11
    //   174: invokeinterface 202 1 0
    //   179: ifeq +1220 -> 1399
    //   182: aload 11
    //   184: invokeinterface 206 1 0
    //   189: checkcast 54	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   192: astore 12
    //   194: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   197: lstore 4
    //   199: aload 12
    //   201: getfield 547	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   204: ldc_w 549
    //   207: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifeq +133 -> 343
    //   213: aload 12
    //   215: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   218: astore 8
    //   220: aload 12
    //   222: getfield 552	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYr	Ljava/lang/String;
    //   225: astore 14
    //   227: aload 12
    //   229: getfield 555	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYp	Ljava/lang/String;
    //   232: astore 13
    //   234: getstatic 38	com/tencent/tinker/lib/c/d:wVW	Z
    //   237: ifne +143 -> 380
    //   240: aload 12
    //   242: getfield 476	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYn	Ljava/lang/String;
    //   245: ldc_w 557
    //   248: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq +129 -> 380
    //   254: ldc 158
    //   256: ldc_w 559
    //   259: iconst_1
    //   260: anewarray 162	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload 8
    //   267: aastore
    //   268: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -99 -> 172
    //   274: astore_1
    //   275: aload_2
    //   276: astore_0
    //   277: aload 7
    //   279: astore_2
    //   280: new 110	com/tencent/tinker/loader/TinkerRuntimeException
    //   283: dup
    //   284: new 112	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 561
    //   291: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: iconst_3
    //   295: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   298: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 563
    //   304: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 566	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 568
    //   317: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aload_1
    //   324: invokespecial 469	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   327: athrow
    //   328: astore_3
    //   329: aload_0
    //   330: astore_1
    //   331: aload_3
    //   332: astore_0
    //   333: aload_1
    //   334: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   337: aload_2
    //   338: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   341: aload_0
    //   342: athrow
    //   343: new 112	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   350: aload 12
    //   352: getfield 547	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   355: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc_w 570
    //   361: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload 12
    //   366: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   369: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: astore 8
    //   377: goto -157 -> 220
    //   380: getstatic 38	com/tencent/tinker/lib/c/d:wVW	Z
    //   383: ifeq +76 -> 459
    //   386: aload 12
    //   388: getfield 239	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYo	Ljava/lang/String;
    //   391: astore 9
    //   393: aload 9
    //   395: invokestatic 573	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:agm	(Ljava/lang/String;)Z
    //   398: ifne +71 -> 469
    //   401: ldc 158
    //   403: ldc_w 575
    //   406: iconst_3
    //   407: anewarray 162	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: iconst_3
    //   413: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   416: aastore
    //   417: dup
    //   418: iconst_1
    //   419: aload 12
    //   421: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   424: aastore
    //   425: dup
    //   426: iconst_2
    //   427: aload 9
    //   429: aastore
    //   430: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: aload 10
    //   435: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   438: aload_3
    //   439: iconst_3
    //   440: invokestatic 579	com/tencent/tinker/lib/c/b:Kj	(I)I
    //   443: invokeinterface 583 3 0
    //   448: aload_2
    //   449: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   452: aload 7
    //   454: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   457: iconst_0
    //   458: ireturn
    //   459: aload 12
    //   461: getfield 476	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYn	Ljava/lang/String;
    //   464: astore 9
    //   466: goto -73 -> 393
    //   469: new 117	java/io/File
    //   472: dup
    //   473: new 112	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   480: aload_1
    //   481: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 12
    //   486: getfield 483	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:dBS	Ljava/lang/String;
    //   489: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokespecial 314	java/io/File:<init>	(Ljava/lang/String;)V
    //   498: astore 15
    //   500: aload 15
    //   502: invokevirtual 317	java/io/File:exists	()Z
    //   505: ifeq +162 -> 667
    //   508: aload 15
    //   510: aload 9
    //   512: invokestatic 587	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:g	(Ljava/io/File;Ljava/lang/String;)Z
    //   515: ifeq +26 -> 541
    //   518: ldc 158
    //   520: ldc_w 589
    //   523: iconst_1
    //   524: anewarray 162	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: aload 15
    //   531: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   534: aastore
    //   535: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: goto -366 -> 172
    //   541: ldc 158
    //   543: new 112	java/lang/StringBuilder
    //   546: dup
    //   547: ldc_w 591
    //   550: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   553: aload 15
    //   555: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   558: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: iconst_0
    //   565: anewarray 162	java/lang/Object
    //   568: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload 15
    //   573: invokevirtual 594	java/io/File:delete	()Z
    //   576: pop
    //   577: aload 7
    //   579: aload 8
    //   581: invokevirtual 598	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   584: astore 17
    //   586: aload_2
    //   587: aload 8
    //   589: invokevirtual 598	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   592: astore 16
    //   594: aload 13
    //   596: ldc_w 557
    //   599: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   602: ifeq +151 -> 753
    //   605: aload 17
    //   607: ifnonnull +72 -> 679
    //   610: ldc 158
    //   612: new 112	java/lang/StringBuilder
    //   615: dup
    //   616: ldc_w 600
    //   619: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   622: aload 8
    //   624: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: iconst_0
    //   631: anewarray 162	java/lang/Object
    //   634: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: aload 10
    //   639: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   642: aload_3
    //   643: aload 15
    //   645: aload 12
    //   647: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   650: iconst_3
    //   651: invokeinterface 296 5 0
    //   656: aload_2
    //   657: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   660: aload 7
    //   662: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   665: iconst_0
    //   666: ireturn
    //   667: aload 15
    //   669: invokevirtual 604	java/io/File:getParentFile	()Ljava/io/File;
    //   672: invokevirtual 320	java/io/File:mkdirs	()Z
    //   675: pop
    //   676: goto -99 -> 577
    //   679: aload 7
    //   681: aload 17
    //   683: aload 15
    //   685: aload 12
    //   687: invokestatic 606	com/tencent/tinker/lib/c/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   690: ifne -518 -> 172
    //   693: ldc 158
    //   695: new 112	java/lang/StringBuilder
    //   698: dup
    //   699: ldc_w 608
    //   702: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   705: aload 15
    //   707: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   710: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: iconst_0
    //   717: anewarray 162	java/lang/Object
    //   720: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   723: aload 10
    //   725: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   728: aload_3
    //   729: aload 15
    //   731: aload 12
    //   733: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   736: iconst_3
    //   737: invokeinterface 296 5 0
    //   742: aload_2
    //   743: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   746: aload 7
    //   748: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   751: iconst_0
    //   752: ireturn
    //   753: aload 14
    //   755: ldc_w 557
    //   758: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   761: ifeq +235 -> 996
    //   764: getstatic 38	com/tencent/tinker/lib/c/d:wVW	Z
    //   767: ifeq -595 -> 172
    //   770: aload 16
    //   772: ifnonnull +60 -> 832
    //   775: ldc 158
    //   777: new 112	java/lang/StringBuilder
    //   780: dup
    //   781: ldc_w 610
    //   784: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   787: aload 8
    //   789: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: iconst_0
    //   796: anewarray 162	java/lang/Object
    //   799: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   802: aload 10
    //   804: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   807: aload_3
    //   808: aload 15
    //   810: aload 12
    //   812: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   815: iconst_3
    //   816: invokeinterface 296 5 0
    //   821: aload_2
    //   822: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   825: aload 7
    //   827: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   830: iconst_0
    //   831: ireturn
    //   832: aload 16
    //   834: invokevirtual 613	java/util/zip/ZipEntry:getCrc	()J
    //   837: invokestatic 616	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   840: astore 14
    //   842: aload 14
    //   844: aload 13
    //   846: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   849: ifne +60 -> 909
    //   852: ldc 158
    //   854: ldc_w 618
    //   857: iconst_3
    //   858: anewarray 162	java/lang/Object
    //   861: dup
    //   862: iconst_0
    //   863: aload 8
    //   865: aastore
    //   866: dup
    //   867: iconst_1
    //   868: aload 13
    //   870: aastore
    //   871: dup
    //   872: iconst_2
    //   873: aload 14
    //   875: aastore
    //   876: invokestatic 256	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   879: aload 10
    //   881: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   884: aload_3
    //   885: aload 15
    //   887: aload 12
    //   889: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   892: iconst_3
    //   893: invokeinterface 296 5 0
    //   898: aload_2
    //   899: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   902: aload 7
    //   904: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   907: iconst_0
    //   908: ireturn
    //   909: aload_2
    //   910: aload 16
    //   912: aload 15
    //   914: aload 12
    //   916: invokestatic 606	com/tencent/tinker/lib/c/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   919: pop
    //   920: aload 15
    //   922: aload 9
    //   924: invokestatic 587	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:g	(Ljava/io/File;Ljava/lang/String;)Z
    //   927: ifne -755 -> 172
    //   930: ldc 158
    //   932: new 112	java/lang/StringBuilder
    //   935: dup
    //   936: ldc_w 620
    //   939: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   942: aload 15
    //   944: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   947: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: iconst_0
    //   954: anewarray 162	java/lang/Object
    //   957: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   960: aload 10
    //   962: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   965: aload_3
    //   966: aload 15
    //   968: aload 12
    //   970: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   973: iconst_3
    //   974: invokeinterface 296 5 0
    //   979: aload 15
    //   981: invokestatic 267	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ah	(Ljava/io/File;)Z
    //   984: pop
    //   985: aload_2
    //   986: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   989: aload 7
    //   991: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   994: iconst_0
    //   995: ireturn
    //   996: aload 17
    //   998: ifnonnull +60 -> 1058
    //   1001: ldc 158
    //   1003: new 112	java/lang/StringBuilder
    //   1006: dup
    //   1007: ldc_w 600
    //   1010: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1013: aload 8
    //   1015: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: iconst_0
    //   1022: anewarray 162	java/lang/Object
    //   1025: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1028: aload 10
    //   1030: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   1033: aload_3
    //   1034: aload 15
    //   1036: aload 12
    //   1038: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   1041: iconst_3
    //   1042: invokeinterface 296 5 0
    //   1047: aload_2
    //   1048: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1051: aload 7
    //   1053: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1056: iconst_0
    //   1057: ireturn
    //   1058: aload 14
    //   1060: invokestatic 573	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:agm	(Ljava/lang/String;)Z
    //   1063: ifne +61 -> 1124
    //   1066: ldc 158
    //   1068: ldc_w 575
    //   1071: iconst_3
    //   1072: anewarray 162	java/lang/Object
    //   1075: dup
    //   1076: iconst_0
    //   1077: iconst_3
    //   1078: invokestatic 522	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   1081: aastore
    //   1082: dup
    //   1083: iconst_1
    //   1084: aload 12
    //   1086: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   1089: aastore
    //   1090: dup
    //   1091: iconst_2
    //   1092: aload 14
    //   1094: aastore
    //   1095: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1098: aload 10
    //   1100: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   1103: aload_3
    //   1104: iconst_3
    //   1105: invokestatic 579	com/tencent/tinker/lib/c/b:Kj	(I)I
    //   1108: invokeinterface 583 3 0
    //   1113: aload_2
    //   1114: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1117: aload 7
    //   1119: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1122: iconst_0
    //   1123: ireturn
    //   1124: aload 16
    //   1126: ifnonnull +60 -> 1186
    //   1129: ldc 158
    //   1131: new 112	java/lang/StringBuilder
    //   1134: dup
    //   1135: ldc_w 610
    //   1138: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1141: aload 8
    //   1143: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: iconst_0
    //   1150: anewarray 162	java/lang/Object
    //   1153: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1156: aload 10
    //   1158: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   1161: aload_3
    //   1162: aload 15
    //   1164: aload 12
    //   1166: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   1169: iconst_3
    //   1170: invokeinterface 296 5 0
    //   1175: aload_2
    //   1176: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1179: aload 7
    //   1181: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1184: iconst_0
    //   1185: ireturn
    //   1186: aload 16
    //   1188: invokevirtual 613	java/util/zip/ZipEntry:getCrc	()J
    //   1191: invokestatic 616	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1194: astore 14
    //   1196: aload 14
    //   1198: aload 13
    //   1200: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1203: ifne +60 -> 1263
    //   1206: ldc 158
    //   1208: ldc_w 618
    //   1211: iconst_3
    //   1212: anewarray 162	java/lang/Object
    //   1215: dup
    //   1216: iconst_0
    //   1217: aload 8
    //   1219: aastore
    //   1220: dup
    //   1221: iconst_1
    //   1222: aload 13
    //   1224: aastore
    //   1225: dup
    //   1226: iconst_2
    //   1227: aload 14
    //   1229: aastore
    //   1230: invokestatic 256	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1233: aload 10
    //   1235: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   1238: aload_3
    //   1239: aload 15
    //   1241: aload 12
    //   1243: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   1246: iconst_3
    //   1247: invokeinterface 296 5 0
    //   1252: aload_2
    //   1253: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1256: aload 7
    //   1258: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1261: iconst_0
    //   1262: ireturn
    //   1263: aload_2
    //   1264: aload 7
    //   1266: aload 16
    //   1268: aload 17
    //   1270: aload 12
    //   1272: aload 15
    //   1274: invokestatic 622	com/tencent/tinker/lib/c/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipEntry;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;Ljava/io/File;)V
    //   1277: aload 15
    //   1279: aload 9
    //   1281: invokestatic 587	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:g	(Ljava/io/File;Ljava/lang/String;)Z
    //   1284: ifne +69 -> 1353
    //   1287: ldc 158
    //   1289: new 112	java/lang/StringBuilder
    //   1292: dup
    //   1293: ldc_w 620
    //   1296: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1299: aload 15
    //   1301: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   1304: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: iconst_0
    //   1311: anewarray 162	java/lang/Object
    //   1314: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1317: aload 10
    //   1319: getfield 290	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   1322: aload_3
    //   1323: aload 15
    //   1325: aload 12
    //   1327: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:wYm	Ljava/lang/String;
    //   1330: iconst_3
    //   1331: invokeinterface 296 5 0
    //   1336: aload 15
    //   1338: invokestatic 267	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ah	(Ljava/io/File;)Z
    //   1341: pop
    //   1342: aload_2
    //   1343: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1346: aload 7
    //   1348: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1351: iconst_0
    //   1352: ireturn
    //   1353: ldc 158
    //   1355: ldc_w 624
    //   1358: iconst_3
    //   1359: anewarray 162	java/lang/Object
    //   1362: dup
    //   1363: iconst_0
    //   1364: aload 15
    //   1366: invokevirtual 301	java/io/File:getPath	()Ljava/lang/String;
    //   1369: aastore
    //   1370: dup
    //   1371: iconst_1
    //   1372: aload 15
    //   1374: invokevirtual 248	java/io/File:length	()J
    //   1377: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1380: aastore
    //   1381: dup
    //   1382: iconst_2
    //   1383: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   1386: lload 4
    //   1388: lsub
    //   1389: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1392: aastore
    //   1393: invokestatic 178	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1396: goto -1224 -> 172
    //   1399: aload_0
    //   1400: aload_3
    //   1401: aload_1
    //   1402: invokestatic 626	com/tencent/tinker/lib/c/d:a	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z
    //   1405: istore 6
    //   1407: iload 6
    //   1409: ifne +14 -> 1423
    //   1412: aload_2
    //   1413: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1416: aload 7
    //   1418: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1421: iconst_0
    //   1422: ireturn
    //   1423: aload_2
    //   1424: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1427: aload 7
    //   1429: invokestatic 533	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1432: iconst_1
    //   1433: ireturn
    //   1434: astore_0
    //   1435: aconst_null
    //   1436: astore_1
    //   1437: aload 9
    //   1439: astore_2
    //   1440: goto -1107 -> 333
    //   1443: astore_0
    //   1444: aload_2
    //   1445: astore_1
    //   1446: aload 9
    //   1448: astore_2
    //   1449: goto -1116 -> 333
    //   1452: astore_1
    //   1453: aconst_null
    //   1454: astore_0
    //   1455: aload 8
    //   1457: astore_2
    //   1458: goto -1178 -> 280
    //   1461: astore_1
    //   1462: aload_2
    //   1463: astore_0
    //   1464: aload 8
    //   1466: astore_2
    //   1467: goto -1187 -> 280
    //   1470: astore_0
    //   1471: aload_2
    //   1472: astore_1
    //   1473: aload 7
    //   1475: astore_2
    //   1476: goto -1143 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1479	0	paramContext	Context
    //   0	1479	1	paramString1	String
    //   0	1479	2	paramString2	String
    //   0	1479	3	paramFile	File
    //   197	1190	4	l	long
    //   1405	3	6	bool	boolean
    //   127	1347	7	localZipFile	ZipFile
    //   74	1391	8	str1	String
    //   71	1376	9	str2	String
    //   68	1250	10	locala	com.tencent.tinker.lib.e.a
    //   170	13	11	localIterator	Iterator
    //   192	1134	12	localShareDexDiffPatchInfo	ShareDexDiffPatchInfo
    //   232	991	13	str3	String
    //   225	1003	14	str4	String
    //   498	875	15	localFile	File
    //   592	675	16	localZipEntry1	ZipEntry
    //   584	685	17	localZipEntry2	ZipEntry
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
    //   610	656	274	java/lang/Throwable
    //   667	676	274	java/lang/Throwable
    //   679	742	274	java/lang/Throwable
    //   753	770	274	java/lang/Throwable
    //   775	821	274	java/lang/Throwable
    //   832	898	274	java/lang/Throwable
    //   909	985	274	java/lang/Throwable
    //   1001	1047	274	java/lang/Throwable
    //   1058	1113	274	java/lang/Throwable
    //   1129	1175	274	java/lang/Throwable
    //   1186	1252	274	java/lang/Throwable
    //   1263	1342	274	java/lang/Throwable
    //   1353	1396	274	java/lang/Throwable
    //   1399	1407	274	java/lang/Throwable
    //   280	328	328	finally
    //   76	81	1434	finally
    //   85	97	1434	finally
    //   107	119	1434	finally
    //   119	129	1443	finally
    //   76	81	1452	java/lang/Throwable
    //   85	97	1452	java/lang/Throwable
    //   107	119	1452	java/lang/Throwable
    //   119	129	1461	java/lang/Throwable
    //   129	153	1470	finally
    //   164	172	1470	finally
    //   172	220	1470	finally
    //   220	271	1470	finally
    //   343	377	1470	finally
    //   380	393	1470	finally
    //   393	448	1470	finally
    //   459	466	1470	finally
    //   469	538	1470	finally
    //   541	577	1470	finally
    //   577	605	1470	finally
    //   610	656	1470	finally
    //   667	676	1470	finally
    //   679	742	1470	finally
    //   753	770	1470	finally
    //   775	821	1470	finally
    //   832	898	1470	finally
    //   909	985	1470	finally
    //   1001	1047	1470	finally
    //   1058	1113	1470	finally
    //   1129	1175	1470	finally
    //   1186	1252	1470	finally
    //   1263	1342	1470	finally
    //   1353	1396	1470	finally
    //   1399	1407	1470	finally
  }
  
  private static boolean b(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
  {
    boolean bool = false;
    int i = 0;
    if ((i < 2) && (!bool)) {
      com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "try Extracting " + paramFile.getPath(), new Object[0]);
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
            com.tencent.tinker.c.b.a.S(localBufferedInputStream);
            com.tencent.tinker.c.b.a.S(localZipOutputStream);
            bool = SharePatchFileUtil.g(paramFile, paramString);
            com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", new Object[] { Boolean.valueOf(bool) });
            if ((!bool) && ((!paramFile.delete()) || (paramFile.exists()))) {
              com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + paramFile.getPath(), new Object[0]);
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
      com.tencent.tinker.c.b.a.S(paramZipEntry);
      com.tencent.tinker.c.b.a.S(paramFile);
      throw paramZipFile;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.lib.c.d
 * JD-Core Version:    0.7.0.1
 */