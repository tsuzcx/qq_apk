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
  private static HashMap<ShareDexDiffPatchInfo, File> BsA = new HashMap();
  private static boolean BsB = ShareTinkerInternals.dWE();
  private static ArrayList<File> Bsy = new ArrayList();
  private static ArrayList<ShareDexDiffPatchInfo> Bsz = new ArrayList();
  
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
    //   38: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   41: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:axe	(Ljava/lang/String;)Z
    //   44: istore 6
    //   46: iload 6
    //   48: ifeq +15 -> 63
    //   51: aload 4
    //   53: getfield 67	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuX	Z
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
    //   171: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload 4
    //   179: astore_3
    //   180: aload_3
    //   181: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   184: aload_1
    //   185: athrow
    //   186: astore_3
    //   187: aload_0
    //   188: astore_1
    //   189: aload_3
    //   190: astore_0
    //   191: aload_2
    //   192: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   195: aload_1
    //   196: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
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
    //   217: invokevirtual 142	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
    //   220: aload_3
    //   221: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   224: aload 4
    //   226: invokevirtual 145	java/util/zip/ZipOutputStream:closeEntry	()V
    //   229: aload 4
    //   231: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   234: aload_2
    //   235: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   238: aload_0
    //   239: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   242: return
    //   243: new 136	com/tencent/tinker/c/a/a
    //   246: dup
    //   247: aload_2
    //   248: aload_0
    //   249: invokespecial 139	com/tencent/tinker/c/a/a:<init>	(Ljava/io/InputStream;Ljava/io/InputStream;)V
    //   252: aload 4
    //   254: invokevirtual 142	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
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
    //   289: invokevirtual 142	com/tencent/tinker/c/a/a:c	(Ljava/io/OutputStream;)V
    //   292: aload_3
    //   293: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   296: goto -62 -> 234
    //   299: aload_3
    //   300: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
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
    //   0: getstatic 25	com/tencent/tinker/lib/c/d:Bsz	Ljava/util/ArrayList;
    //   3: invokevirtual 151	java/util/ArrayList:isEmpty	()Z
    //   6: ifne +9 -> 15
    //   9: getstatic 38	com/tencent/tinker/lib/c/d:BsB	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: new 117	java/io/File
    //   20: dup
    //   21: aload_2
    //   22: ldc 153
    //   24: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore 10
    //   29: getstatic 30	com/tencent/tinker/lib/c/d:BsA	Ljava/util/HashMap;
    //   32: invokevirtual 157	java/util/HashMap:isEmpty	()Z
    //   35: ifeq +28 -> 63
    //   38: ldc 159
    //   40: ldc 161
    //   42: iconst_1
    //   43: anewarray 163	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: getstatic 30	com/tencent/tinker/lib/c/d:BsA	Ljava/util/HashMap;
    //   51: invokevirtual 167	java/util/HashMap:size	()I
    //   54: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   66: lstore_3
    //   67: aconst_null
    //   68: astore_2
    //   69: new 187	com/tencent/tinker/d/a/h
    //   72: dup
    //   73: new 71	java/io/BufferedOutputStream
    //   76: dup
    //   77: new 73	java/io/FileOutputStream
    //   80: dup
    //   81: aload 10
    //   83: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: invokespecial 188	com/tencent/tinker/d/a/h:<init>	(Ljava/io/OutputStream;)V
    //   92: astore 8
    //   94: getstatic 30	com/tencent/tinker/lib/c/d:BsA	Ljava/util/HashMap;
    //   97: invokevirtual 192	java/util/HashMap:keySet	()Ljava/util/Set;
    //   100: invokeinterface 198 1 0
    //   105: astore_2
    //   106: aload_2
    //   107: invokeinterface 203 1 0
    //   112: ifeq +328 -> 440
    //   115: aload_2
    //   116: invokeinterface 207 1 0
    //   121: checkcast 54	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   124: astore 7
    //   126: getstatic 30	com/tencent/tinker/lib/c/d:BsA	Ljava/util/HashMap;
    //   129: aload 7
    //   131: invokevirtual 211	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 117	java/io/File
    //   137: astore 9
    //   139: aload 7
    //   141: getfield 67	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuX	Z
    //   144: istore 5
    //   146: iload 5
    //   148: ifeq +262 -> 410
    //   151: new 213	com/tencent/tinker/d/a/g
    //   154: dup
    //   155: aload 9
    //   157: invokespecial 214	com/tencent/tinker/d/a/g:<init>	(Ljava/io/File;)V
    //   160: astore 9
    //   162: aload 9
    //   164: ldc 84
    //   166: invokevirtual 218	com/tencent/tinker/d/a/g:axh	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/f;
    //   169: astore 12
    //   171: new 220	com/tencent/tinker/d/a/f
    //   174: dup
    //   175: aload 12
    //   177: aload 7
    //   179: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   182: invokespecial 223	com/tencent/tinker/d/a/f:<init>	(Lcom/tencent/tinker/d/a/f;Ljava/lang/String;)V
    //   185: astore 11
    //   187: aload 9
    //   189: aload 12
    //   191: invokevirtual 226	com/tencent/tinker/d/a/g:a	(Lcom/tencent/tinker/d/a/f;)Ljava/io/InputStream;
    //   194: astore 7
    //   196: aload 11
    //   198: aload 7
    //   200: aload 8
    //   202: invokestatic 231	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/f;Ljava/io/InputStream;Lcom/tencent/tinker/d/a/h;)V
    //   205: aload 7
    //   207: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   210: aload 9
    //   212: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   215: goto -109 -> 106
    //   218: astore 7
    //   220: aload 8
    //   222: astore_2
    //   223: ldc 159
    //   225: aload 7
    //   227: ldc 233
    //   229: iconst_0
    //   230: anewarray 163	java/lang/Object
    //   233: invokestatic 237	com/tencent/tinker/lib/f/a:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload_2
    //   237: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   240: iconst_0
    //   241: istore 5
    //   243: iload 5
    //   245: istore 6
    //   247: iload 5
    //   249: ifeq +90 -> 339
    //   252: getstatic 30	com/tencent/tinker/lib/c/d:BsA	Ljava/util/HashMap;
    //   255: invokevirtual 192	java/util/HashMap:keySet	()Ljava/util/Set;
    //   258: invokeinterface 198 1 0
    //   263: astore_2
    //   264: iload 5
    //   266: istore 6
    //   268: aload_2
    //   269: invokeinterface 203 1 0
    //   274: ifeq +65 -> 339
    //   277: aload_2
    //   278: invokeinterface 207 1 0
    //   283: checkcast 54	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   286: astore 7
    //   288: aload 10
    //   290: aload 7
    //   292: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   295: aload 7
    //   297: getfield 240	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuS	Ljava/lang/String;
    //   300: invokestatic 244	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:b	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Z
    //   303: ifne -39 -> 264
    //   306: iconst_0
    //   307: istore 6
    //   309: ldc 159
    //   311: ldc 246
    //   313: iconst_2
    //   314: anewarray 163	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: aload 7
    //   321: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   324: aastore
    //   325: dup
    //   326: iconst_1
    //   327: aload 10
    //   329: invokevirtual 249	java/io/File:length	()J
    //   332: invokestatic 254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   335: aastore
    //   336: invokestatic 257	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   339: iload 6
    //   341: ifeq +110 -> 451
    //   344: getstatic 30	com/tencent/tinker/lib/c/d:BsA	Ljava/util/HashMap;
    //   347: invokevirtual 261	java/util/HashMap:values	()Ljava/util/Collection;
    //   350: invokeinterface 264 1 0
    //   355: astore_0
    //   356: aload_0
    //   357: invokeinterface 203 1 0
    //   362: ifeq +129 -> 491
    //   365: aload_0
    //   366: invokeinterface 207 1 0
    //   371: checkcast 117	java/io/File
    //   374: invokestatic 268	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:aq	(Ljava/io/File;)Z
    //   377: pop
    //   378: goto -22 -> 356
    //   381: astore_2
    //   382: aconst_null
    //   383: astore 7
    //   385: aconst_null
    //   386: astore 9
    //   388: aload 7
    //   390: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   393: aload 9
    //   395: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   398: aload_2
    //   399: athrow
    //   400: astore_0
    //   401: aload 8
    //   403: astore_1
    //   404: aload_1
    //   405: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   408: aload_0
    //   409: athrow
    //   410: new 220	com/tencent/tinker/d/a/f
    //   413: dup
    //   414: aload 7
    //   416: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   419: invokespecial 269	com/tencent/tinker/d/a/f:<init>	(Ljava/lang/String;)V
    //   422: aload 9
    //   424: aload 7
    //   426: getfield 272	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuU	Ljava/lang/String;
    //   429: invokestatic 276	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   432: aload 8
    //   434: invokestatic 279	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/f;Ljava/io/File;JLcom/tencent/tinker/d/a/h;)V
    //   437: goto -331 -> 106
    //   440: aload 8
    //   442: invokestatic 134	com/tencent/tinker/c/b/a:V	(Ljava/lang/Object;)V
    //   445: iconst_1
    //   446: istore 5
    //   448: goto -205 -> 243
    //   451: ldc 159
    //   453: ldc_w 281
    //   456: iconst_0
    //   457: anewarray 163	java/lang/Object
    //   460: invokestatic 257	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: aload 10
    //   465: invokestatic 268	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:aq	(Ljava/io/File;)Z
    //   468: pop
    //   469: aload_0
    //   470: invokestatic 287	com/tencent/tinker/lib/e/a:jo	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   473: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   476: aload_1
    //   477: aload 10
    //   479: aload 10
    //   481: invokevirtual 292	java/io/File:getName	()Ljava/lang/String;
    //   484: bipush 7
    //   486: invokeinterface 297 5 0
    //   491: ldc 159
    //   493: ldc_w 299
    //   496: iconst_4
    //   497: anewarray 163	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: aload 10
    //   504: invokevirtual 302	java/io/File:getPath	()Ljava/lang/String;
    //   507: aastore
    //   508: dup
    //   509: iconst_1
    //   510: iload 6
    //   512: invokestatic 307	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   515: aastore
    //   516: dup
    //   517: iconst_2
    //   518: aload 10
    //   520: invokevirtual 249	java/io/File:length	()J
    //   523: invokestatic 254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   526: aastore
    //   527: dup
    //   528: iconst_3
    //   529: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   532: lload_3
    //   533: lsub
    //   534: invokestatic 254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   537: aastore
    //   538: invokestatic 310	com/tencent/tinker/lib/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    paramContext = com.tencent.tinker.lib.e.a.jo(paramContext);
    Bsy.clear();
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
      Bsy.add(new File(str));
    }
    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[] { Integer.valueOf(paramList.size()), paramString });
    paramString = new Vector();
    localObject = new Throwable[1];
    TinkerDexOptimizer.a(paramList, localFile, new d.1(paramString, (Throwable[])localObject));
    if (!paramString.isEmpty())
    {
      paramContext.BsP.a(paramFile, paramString, localObject[0]);
      return false;
    }
    return true;
  }
  
  protected static boolean a(com.tencent.tinker.lib.e.a parama, ShareSecurityCheck paramShareSecurityCheck, Context paramContext, String paramString, File paramFile)
  {
    if (!ShareTinkerInternals.Te(parama.tinkerFlags))
    {
      com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
      return true;
    }
    parama = (String)paramShareSecurityCheck.Bwk.get("assets/dex_meta.txt");
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
      com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "legal files to do dexopt: ".concat(String.valueOf(paramShareSecurityCheck)), new Object[0]);
    }
  }
  
  protected static boolean a(File paramFile, com.tencent.tinker.lib.e.a parama)
  {
    if (Bsy.isEmpty()) {
      return true;
    }
    int j = Bsz.size() * 30;
    int i = j;
    if (j > 120) {
      i = 120;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", new Object[] { Integer.valueOf(Bsz.size()), Integer.valueOf(Bsy.size()), Integer.valueOf(i) });
    j = 0;
    for (;;)
    {
      if (j < i)
      {
        Iterator localIterator1 = Bsy.iterator();
        int k;
        for (;;)
        {
          if (localIterator1.hasNext())
          {
            localObject1 = (File)localIterator1.next();
            if ((!SharePatchFileUtil.an((File)localObject1)) && (!SharePatchFileUtil.ao((File)localObject1)))
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
            com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:".concat(String.valueOf(localInterruptedException)), new Object[0]);
          }
        }
      }
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator2 = Bsy.iterator();
    Object localObject2;
    while (localIterator2.hasNext())
    {
      localObject2 = (File)localIterator2.next();
      com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", new Object[] { ((File)localObject2).getPath(), Long.valueOf(((File)localObject2).length()) });
      if ((!SharePatchFileUtil.an((File)localObject2)) && (!SharePatchFileUtil.ao((File)localObject2)))
      {
        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", new Object[] { ((File)localObject2).getName() });
        ((List)localObject1).add(localObject2);
      }
    }
    if (!((List)localObject1).isEmpty())
    {
      parama.BsP.a(paramFile, (List)localObject1, new TinkerRuntimeException("checkDexOptExist failed"));
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject2 = Bsy.iterator();
      localIterator2 = null;
    }
    for (;;)
    {
      File localFile;
      if (((Iterator)localObject2).hasNext())
      {
        localFile = (File)((Iterator)localObject2).next();
        if (!SharePatchFileUtil.ao(localFile)) {
          com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", new Object[] { localFile.getName(), Long.valueOf(localFile.length()) });
        }
      }
      else
      {
        try
        {
          i = ShareElfFile.al(localFile);
          if (i == 1)
          {
            try
            {
              ShareElfFile localShareElfFile = new ShareElfFile(localFile);
              com.tencent.tinker.c.b.a.V(localShareElfFile);
              continue;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not elf format, return false", new Object[] { localFile.getName() });
              ((List)localObject1).add(localFile);
              com.tencent.tinker.c.b.a.V(null);
              continue;
            }
            finally
            {
              com.tencent.tinker.c.b.a.V(null);
            }
            if (!((List)localObject1).isEmpty())
            {
              if (localThrowable == null) {}
              for (TinkerRuntimeException localTinkerRuntimeException = new TinkerRuntimeException("checkDexOptFormat failed");; localTinkerRuntimeException = new TinkerRuntimeException("checkDexOptFormat failed", localTinkerRuntimeException))
              {
                parama.BsP.a(paramFile, (List)localObject1, localTinkerRuntimeException);
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
    if (BsB) {}
    for (String str1 = paramShareDexDiffPatchInfo.BuS;; str1 = paramShareDexDiffPatchInfo.BuR)
    {
      String str2 = paramShareDexDiffPatchInfo.BuQ;
      boolean bool = paramShareDexDiffPatchInfo.BuX;
      if ((!SharePatchFileUtil.axe(str2)) || (!bool)) {
        break;
      }
      return b(paramZipFile, paramZipEntry, paramFile, str1);
    }
    return a(paramZipFile, paramZipEntry, paramFile, str1, true);
  }
  
  private static boolean awS(String paramString)
  {
    if ((Bsz.isEmpty()) || (!BsB)) {
      return false;
    }
    Iterator localIterator = Bsz.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      ShareDexDiffPatchInfo localShareDexDiffPatchInfo = (ShareDexDiffPatchInfo)localIterator.next();
      File localFile = new File(paramString + localShareDexDiffPatchInfo.ezj);
      String str = localFile.getName();
      if (ShareConstants.BuP.matcher(str).matches()) {
        BsA.put(localShareDexDiffPatchInfo, localFile);
      }
      if (!localShareDexDiffPatchInfo.BuQ.startsWith("test.dex")) {
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
        BsA.put(ShareTinkerInternals.a((ShareDexDiffPatchInfo)localObject1, BsA.size() + 1), localObject2);
      }
      paramString = new File(paramString, "tinker_classN.apk");
      if (paramString.exists())
      {
        localObject1 = BsA.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ShareDexDiffPatchInfo)((Iterator)localObject1).next();
          if (!SharePatchFileUtil.b(paramString, ((ShareDexDiffPatchInfo)localObject2).BuQ, ((ShareDexDiffPatchInfo)localObject2).BuS)) {
            com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[] { ((ShareDexDiffPatchInfo)localObject2).BuQ, Long.valueOf(paramString.length()) });
          }
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!bool1) {
          SharePatchFileUtil.aq(paramString);
        }
        for (bool2 = bool1; bool2; bool2 = false)
        {
          paramString = BsA.values().iterator();
          while (paramString.hasNext()) {
            SharePatchFileUtil.aq((File)paramString.next());
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
    //   0: getstatic 25	com/tencent/tinker/lib/c/d:Bsz	Ljava/util/ArrayList;
    //   3: invokevirtual 314	java/util/ArrayList:clear	()V
    //   6: aload_2
    //   7: getstatic 25	com/tencent/tinker/lib/c/d:Bsz	Ljava/util/ArrayList;
    //   10: invokestatic 521	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:o	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   13: getstatic 25	com/tencent/tinker/lib/c/d:Bsz	Ljava/util/ArrayList;
    //   16: invokevirtual 151	java/util/ArrayList:isEmpty	()Z
    //   19: ifeq +24 -> 43
    //   22: ldc 159
    //   24: ldc_w 523
    //   27: iconst_1
    //   28: anewarray 163	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iconst_3
    //   34: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Th	(I)Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: iconst_1
    //   42: ireturn
    //   43: new 117	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 318	java/io/File:exists	()Z
    //   56: ifne +8 -> 64
    //   59: aload_2
    //   60: invokevirtual 321	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: aload_0
    //   65: invokestatic 287	com/tencent/tinker/lib/e/a:jo	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
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
    //   85: ldc 159
    //   87: ldc_w 535
    //   90: iconst_0
    //   91: anewarray 163	java/lang/Object
    //   94: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   101: aconst_null
    //   102: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: new 45	java/util/zip/ZipFile
    //   110: dup
    //   111: aload_2
    //   112: getfield 543	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   115: invokespecial 544	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   118: astore_2
    //   119: new 45	java/util/zip/ZipFile
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 545	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   127: astore 7
    //   129: aload_1
    //   130: invokestatic 547	com/tencent/tinker/lib/c/d:awS	(Ljava/lang/String;)Z
    //   133: ifeq +31 -> 164
    //   136: ldc 159
    //   138: ldc_w 549
    //   141: iconst_1
    //   142: anewarray 163	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc 153
    //   149: aastore
    //   150: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   157: aload 7
    //   159: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   162: iconst_1
    //   163: ireturn
    //   164: getstatic 25	com/tencent/tinker/lib/c/d:Bsz	Ljava/util/ArrayList;
    //   167: invokevirtual 429	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   170: astore 11
    //   172: aload 11
    //   174: invokeinterface 203 1 0
    //   179: ifeq +1192 -> 1371
    //   182: aload 11
    //   184: invokeinterface 207 1 0
    //   189: checkcast 54	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo
    //   192: astore 12
    //   194: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   197: lstore 4
    //   199: aload 12
    //   201: getfield 552	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   204: ldc_w 554
    //   207: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifeq +133 -> 343
    //   213: aload 12
    //   215: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   218: astore 8
    //   220: aload 12
    //   222: getfield 557	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuV	Ljava/lang/String;
    //   225: astore 14
    //   227: aload 12
    //   229: getfield 560	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuT	Ljava/lang/String;
    //   232: astore 13
    //   234: getstatic 38	com/tencent/tinker/lib/c/d:BsB	Z
    //   237: ifne +143 -> 380
    //   240: aload 12
    //   242: getfield 481	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuR	Ljava/lang/String;
    //   245: ldc_w 562
    //   248: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifeq +129 -> 380
    //   254: ldc 159
    //   256: ldc_w 564
    //   259: iconst_1
    //   260: anewarray 163	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload 8
    //   267: aastore
    //   268: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   288: ldc_w 566
    //   291: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: iconst_3
    //   295: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Th	(I)Ljava/lang/String;
    //   298: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 568
    //   304: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 571	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 573
    //   317: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aload_1
    //   324: invokespecial 474	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   327: athrow
    //   328: astore_3
    //   329: aload_0
    //   330: astore_1
    //   331: aload_3
    //   332: astore_0
    //   333: aload_1
    //   334: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   337: aload_2
    //   338: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   341: aload_0
    //   342: athrow
    //   343: new 112	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   350: aload 12
    //   352: getfield 552	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:path	Ljava/lang/String;
    //   355: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc_w 575
    //   361: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload 12
    //   366: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   369: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: astore 8
    //   377: goto -157 -> 220
    //   380: getstatic 38	com/tencent/tinker/lib/c/d:BsB	Z
    //   383: ifeq +76 -> 459
    //   386: aload 12
    //   388: getfield 240	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuS	Ljava/lang/String;
    //   391: astore 9
    //   393: aload 9
    //   395: invokestatic 578	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:axd	(Ljava/lang/String;)Z
    //   398: ifne +71 -> 469
    //   401: ldc 159
    //   403: ldc_w 580
    //   406: iconst_3
    //   407: anewarray 163	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: iconst_3
    //   413: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Th	(I)Ljava/lang/String;
    //   416: aastore
    //   417: dup
    //   418: iconst_1
    //   419: aload 12
    //   421: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   424: aastore
    //   425: dup
    //   426: iconst_2
    //   427: aload 9
    //   429: aastore
    //   430: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: aload 10
    //   435: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   438: aload_3
    //   439: iconst_3
    //   440: invokestatic 584	com/tencent/tinker/lib/c/b:Td	(I)I
    //   443: invokeinterface 587 3 0
    //   448: aload_2
    //   449: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   452: aload 7
    //   454: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   457: iconst_0
    //   458: ireturn
    //   459: aload 12
    //   461: getfield 481	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuR	Ljava/lang/String;
    //   464: astore 9
    //   466: goto -73 -> 393
    //   469: new 117	java/io/File
    //   472: dup
    //   473: new 112	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 381	java/lang/StringBuilder:<init>	()V
    //   480: aload_1
    //   481: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 12
    //   486: getfield 488	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:ezj	Ljava/lang/String;
    //   489: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   498: astore 15
    //   500: aload 15
    //   502: invokevirtual 318	java/io/File:exists	()Z
    //   505: ifeq +155 -> 660
    //   508: aload 15
    //   510: aload 9
    //   512: invokestatic 590	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:i	(Ljava/io/File;Ljava/lang/String;)Z
    //   515: ifeq +26 -> 541
    //   518: ldc 159
    //   520: ldc_w 592
    //   523: iconst_1
    //   524: anewarray 163	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: aload 15
    //   531: invokevirtual 302	java/io/File:getPath	()Ljava/lang/String;
    //   534: aastore
    //   535: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: goto -366 -> 172
    //   541: ldc 159
    //   543: new 112	java/lang/StringBuilder
    //   546: dup
    //   547: ldc_w 594
    //   550: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   553: aload 15
    //   555: invokevirtual 302	java/io/File:getPath	()Ljava/lang/String;
    //   558: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: iconst_0
    //   565: anewarray 163	java/lang/Object
    //   568: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload 15
    //   573: invokevirtual 597	java/io/File:delete	()Z
    //   576: pop
    //   577: aload 7
    //   579: aload 8
    //   581: invokevirtual 601	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   584: astore 17
    //   586: aload_2
    //   587: aload 8
    //   589: invokevirtual 601	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   592: astore 16
    //   594: aload 13
    //   596: ldc_w 562
    //   599: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   602: ifeq +144 -> 746
    //   605: aload 17
    //   607: ifnonnull +65 -> 672
    //   610: ldc 159
    //   612: ldc_w 603
    //   615: aload 8
    //   617: invokestatic 412	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   620: invokevirtual 416	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   623: iconst_0
    //   624: anewarray 163	java/lang/Object
    //   627: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   630: aload 10
    //   632: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   635: aload_3
    //   636: aload 15
    //   638: aload 12
    //   640: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   643: iconst_3
    //   644: invokeinterface 297 5 0
    //   649: aload_2
    //   650: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   653: aload 7
    //   655: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   658: iconst_0
    //   659: ireturn
    //   660: aload 15
    //   662: invokevirtual 607	java/io/File:getParentFile	()Ljava/io/File;
    //   665: invokevirtual 321	java/io/File:mkdirs	()Z
    //   668: pop
    //   669: goto -92 -> 577
    //   672: aload 7
    //   674: aload 17
    //   676: aload 15
    //   678: aload 12
    //   680: invokestatic 609	com/tencent/tinker/lib/c/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   683: ifne -511 -> 172
    //   686: ldc 159
    //   688: new 112	java/lang/StringBuilder
    //   691: dup
    //   692: ldc_w 611
    //   695: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   698: aload 15
    //   700: invokevirtual 302	java/io/File:getPath	()Ljava/lang/String;
    //   703: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: iconst_0
    //   710: anewarray 163	java/lang/Object
    //   713: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   716: aload 10
    //   718: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   721: aload_3
    //   722: aload 15
    //   724: aload 12
    //   726: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   729: iconst_3
    //   730: invokeinterface 297 5 0
    //   735: aload_2
    //   736: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   739: aload 7
    //   741: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   744: iconst_0
    //   745: ireturn
    //   746: aload 14
    //   748: ldc_w 562
    //   751: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   754: ifeq +228 -> 982
    //   757: getstatic 38	com/tencent/tinker/lib/c/d:BsB	Z
    //   760: ifeq -588 -> 172
    //   763: aload 16
    //   765: ifnonnull +53 -> 818
    //   768: ldc 159
    //   770: ldc_w 613
    //   773: aload 8
    //   775: invokestatic 412	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   778: invokevirtual 416	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   781: iconst_0
    //   782: anewarray 163	java/lang/Object
    //   785: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   788: aload 10
    //   790: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   793: aload_3
    //   794: aload 15
    //   796: aload 12
    //   798: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   801: iconst_3
    //   802: invokeinterface 297 5 0
    //   807: aload_2
    //   808: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   811: aload 7
    //   813: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   816: iconst_0
    //   817: ireturn
    //   818: aload 16
    //   820: invokevirtual 616	java/util/zip/ZipEntry:getCrc	()J
    //   823: invokestatic 619	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   826: astore 14
    //   828: aload 14
    //   830: aload 13
    //   832: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   835: ifne +60 -> 895
    //   838: ldc 159
    //   840: ldc_w 621
    //   843: iconst_3
    //   844: anewarray 163	java/lang/Object
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
    //   862: invokestatic 257	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   865: aload 10
    //   867: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   870: aload_3
    //   871: aload 15
    //   873: aload 12
    //   875: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   878: iconst_3
    //   879: invokeinterface 297 5 0
    //   884: aload_2
    //   885: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   888: aload 7
    //   890: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   893: iconst_0
    //   894: ireturn
    //   895: aload_2
    //   896: aload 16
    //   898: aload 15
    //   900: aload 12
    //   902: invokestatic 609	com/tencent/tinker/lib/c/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;)Z
    //   905: pop
    //   906: aload 15
    //   908: aload 9
    //   910: invokestatic 590	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:i	(Ljava/io/File;Ljava/lang/String;)Z
    //   913: ifne -741 -> 172
    //   916: ldc 159
    //   918: new 112	java/lang/StringBuilder
    //   921: dup
    //   922: ldc_w 623
    //   925: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   928: aload 15
    //   930: invokevirtual 302	java/io/File:getPath	()Ljava/lang/String;
    //   933: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: iconst_0
    //   940: anewarray 163	java/lang/Object
    //   943: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   946: aload 10
    //   948: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   951: aload_3
    //   952: aload 15
    //   954: aload 12
    //   956: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   959: iconst_3
    //   960: invokeinterface 297 5 0
    //   965: aload 15
    //   967: invokestatic 268	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:aq	(Ljava/io/File;)Z
    //   970: pop
    //   971: aload_2
    //   972: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   975: aload 7
    //   977: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   980: iconst_0
    //   981: ireturn
    //   982: aload 17
    //   984: ifnonnull +53 -> 1037
    //   987: ldc 159
    //   989: ldc_w 603
    //   992: aload 8
    //   994: invokestatic 412	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   997: invokevirtual 416	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1000: iconst_0
    //   1001: anewarray 163	java/lang/Object
    //   1004: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1007: aload 10
    //   1009: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   1012: aload_3
    //   1013: aload 15
    //   1015: aload 12
    //   1017: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   1020: iconst_3
    //   1021: invokeinterface 297 5 0
    //   1026: aload_2
    //   1027: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1030: aload 7
    //   1032: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1035: iconst_0
    //   1036: ireturn
    //   1037: aload 14
    //   1039: invokestatic 578	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:axd	(Ljava/lang/String;)Z
    //   1042: ifne +61 -> 1103
    //   1045: ldc 159
    //   1047: ldc_w 580
    //   1050: iconst_3
    //   1051: anewarray 163	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: iconst_3
    //   1057: invokestatic 527	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Th	(I)Ljava/lang/String;
    //   1060: aastore
    //   1061: dup
    //   1062: iconst_1
    //   1063: aload 12
    //   1065: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   1068: aastore
    //   1069: dup
    //   1070: iconst_2
    //   1071: aload 14
    //   1073: aastore
    //   1074: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1077: aload 10
    //   1079: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   1082: aload_3
    //   1083: iconst_3
    //   1084: invokestatic 584	com/tencent/tinker/lib/c/b:Td	(I)I
    //   1087: invokeinterface 587 3 0
    //   1092: aload_2
    //   1093: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1096: aload 7
    //   1098: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1101: iconst_0
    //   1102: ireturn
    //   1103: aload 16
    //   1105: ifnonnull +53 -> 1158
    //   1108: ldc 159
    //   1110: ldc_w 613
    //   1113: aload 8
    //   1115: invokestatic 412	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1118: invokevirtual 416	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1121: iconst_0
    //   1122: anewarray 163	java/lang/Object
    //   1125: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1128: aload 10
    //   1130: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   1133: aload_3
    //   1134: aload 15
    //   1136: aload 12
    //   1138: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   1141: iconst_3
    //   1142: invokeinterface 297 5 0
    //   1147: aload_2
    //   1148: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1151: aload 7
    //   1153: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1156: iconst_0
    //   1157: ireturn
    //   1158: aload 16
    //   1160: invokevirtual 616	java/util/zip/ZipEntry:getCrc	()J
    //   1163: invokestatic 619	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1166: astore 14
    //   1168: aload 14
    //   1170: aload 13
    //   1172: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1175: ifne +60 -> 1235
    //   1178: ldc 159
    //   1180: ldc_w 621
    //   1183: iconst_3
    //   1184: anewarray 163	java/lang/Object
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
    //   1202: invokestatic 257	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1205: aload 10
    //   1207: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   1210: aload_3
    //   1211: aload 15
    //   1213: aload 12
    //   1215: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   1218: iconst_3
    //   1219: invokeinterface 297 5 0
    //   1224: aload_2
    //   1225: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1228: aload 7
    //   1230: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1233: iconst_0
    //   1234: ireturn
    //   1235: aload_2
    //   1236: aload 7
    //   1238: aload 16
    //   1240: aload 17
    //   1242: aload 12
    //   1244: aload 15
    //   1246: invokestatic 625	com/tencent/tinker/lib/c/d:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/util/zip/ZipEntry;Lcom/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo;Ljava/io/File;)V
    //   1249: aload 15
    //   1251: aload 9
    //   1253: invokestatic 590	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:i	(Ljava/io/File;Ljava/lang/String;)Z
    //   1256: ifne +69 -> 1325
    //   1259: ldc 159
    //   1261: new 112	java/lang/StringBuilder
    //   1264: dup
    //   1265: ldc_w 623
    //   1268: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1271: aload 15
    //   1273: invokevirtual 302	java/io/File:getPath	()Ljava/lang/String;
    //   1276: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1282: iconst_0
    //   1283: anewarray 163	java/lang/Object
    //   1286: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1289: aload 10
    //   1291: getfield 291	com/tencent/tinker/lib/e/a:BsP	Lcom/tencent/tinker/lib/d/d;
    //   1294: aload_3
    //   1295: aload 15
    //   1297: aload 12
    //   1299: getfield 58	com/tencent/tinker/loader/shareutil/ShareDexDiffPatchInfo:BuQ	Ljava/lang/String;
    //   1302: iconst_3
    //   1303: invokeinterface 297 5 0
    //   1308: aload 15
    //   1310: invokestatic 268	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:aq	(Ljava/io/File;)Z
    //   1313: pop
    //   1314: aload_2
    //   1315: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1318: aload 7
    //   1320: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1323: iconst_0
    //   1324: ireturn
    //   1325: ldc 159
    //   1327: ldc_w 627
    //   1330: iconst_3
    //   1331: anewarray 163	java/lang/Object
    //   1334: dup
    //   1335: iconst_0
    //   1336: aload 15
    //   1338: invokevirtual 302	java/io/File:getPath	()Ljava/lang/String;
    //   1341: aastore
    //   1342: dup
    //   1343: iconst_1
    //   1344: aload 15
    //   1346: invokevirtual 249	java/io/File:length	()J
    //   1349: invokestatic 254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1352: aastore
    //   1353: dup
    //   1354: iconst_2
    //   1355: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   1358: lload 4
    //   1360: lsub
    //   1361: invokestatic 254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1364: aastore
    //   1365: invokestatic 179	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1368: goto -1196 -> 172
    //   1371: aload_0
    //   1372: aload_3
    //   1373: aload_1
    //   1374: invokestatic 629	com/tencent/tinker/lib/c/d:a	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z
    //   1377: istore 6
    //   1379: iload 6
    //   1381: ifne +14 -> 1395
    //   1384: aload_2
    //   1385: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1388: aload 7
    //   1390: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1393: iconst_0
    //   1394: ireturn
    //   1395: aload_2
    //   1396: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1399: aload 7
    //   1401: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
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
            com.tencent.tinker.c.b.a.V(localBufferedInputStream);
            com.tencent.tinker.c.b.a.V(localZipOutputStream);
            bool = SharePatchFileUtil.i(paramFile, paramString);
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
      com.tencent.tinker.c.b.a.V(paramZipEntry);
      com.tencent.tinker.c.b.a.V(paramFile);
      throw paramZipFile;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.lib.c.d
 * JD-Core Version:    0.7.0.1
 */