package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class XWalkDecompressor
{
  private static final int LZMA_OUTSIZE = 8;
  private static final int LZMA_PROP_SIZE = 5;
  private static final String[] MANDATORY_LIBRARIES = { "libxwalkcore.so" };
  private static final String[] MANDATORY_RESOURCES = XWalkEnvironment.MANDATORY_RESOURCES;
  private static final int STREAM_BUFFER_SIZE = 1048576;
  private static final String TAG = "XWalkLib";
  
  /* Error */
  public static void copyApkToLocal(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 18
    //   7: ldc 48
    //   9: aload_0
    //   10: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 61	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: new 63	java/io/FileInputStream
    //   22: dup
    //   23: new 65	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 71	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_3
    //   35: new 65	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 75	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_0
    //   52: invokevirtual 78	java/io/File:delete	()Z
    //   55: pop
    //   56: new 80	java/io/FileOutputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore_0
    //   65: aload_0
    //   66: astore 4
    //   68: aload_3
    //   69: astore_1
    //   70: sipush 1024
    //   73: newarray byte
    //   75: astore 5
    //   77: aload_0
    //   78: astore 4
    //   80: aload_3
    //   81: astore_1
    //   82: aload_3
    //   83: aload 5
    //   85: invokevirtual 85	java/io/FileInputStream:read	([B)I
    //   88: istore_2
    //   89: iload_2
    //   90: ifle +50 -> 140
    //   93: aload_0
    //   94: astore 4
    //   96: aload_3
    //   97: astore_1
    //   98: aload_0
    //   99: aload 5
    //   101: iconst_0
    //   102: iload_2
    //   103: invokevirtual 89	java/io/FileOutputStream:write	([BII)V
    //   106: goto -29 -> 77
    //   109: astore 5
    //   111: aload_0
    //   112: astore 4
    //   114: aload_3
    //   115: astore_1
    //   116: ldc 91
    //   118: aload 5
    //   120: invokevirtual 95	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokestatic 98	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_3
    //   127: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   130: aload_0
    //   131: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   134: ldc 40
    //   136: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: aload_3
    //   141: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   144: aload_0
    //   145: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   148: ldc 40
    //   150: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore_0
    //   155: aconst_null
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   164: aload 4
    //   166: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   169: ldc 40
    //   171: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: aconst_null
    //   178: astore 4
    //   180: aload_3
    //   181: astore_1
    //   182: goto -22 -> 160
    //   185: astore_0
    //   186: goto -26 -> 160
    //   189: astore 5
    //   191: aconst_null
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_3
    //   195: goto -84 -> 111
    //   198: astore 5
    //   200: aconst_null
    //   201: astore_0
    //   202: goto -91 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramString1	String
    //   0	205	1	paramString2	String
    //   88	15	2	i	int
    //   34	161	3	localFileInputStream	java.io.FileInputStream
    //   66	113	4	str	String
    //   75	25	5	arrayOfByte	byte[]
    //   109	10	5	localException1	java.lang.Exception
    //   189	1	5	localException2	java.lang.Exception
    //   198	1	5	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   70	77	109	java/lang/Exception
    //   82	89	109	java/lang/Exception
    //   98	106	109	java/lang/Exception
    //   19	35	154	finally
    //   35	56	176	finally
    //   56	65	176	finally
    //   70	77	185	finally
    //   82	89	185	finally
    //   98	106	185	finally
    //   116	126	185	finally
    //   19	35	189	java/lang/Exception
    //   35	56	198	java/lang/Exception
    //   56	65	198	java/lang/Exception
  }
  
  /* Error */
  public static boolean decompressDownloadFullZip(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 112
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 18
    //   7: new 114	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 116
    //   13: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 123
    //   22: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 131	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore_3
    //   39: new 139	java/util/zip/ZipFile
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 140	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   47: astore 7
    //   49: aload 7
    //   51: invokevirtual 144	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   54: astore 6
    //   56: aload 6
    //   58: invokeinterface 149 1 0
    //   63: ifeq +385 -> 448
    //   66: aload 6
    //   68: invokeinterface 153 1 0
    //   73: checkcast 155	java/util/zip/ZipEntry
    //   76: astore 5
    //   78: aload 5
    //   80: invokevirtual 158	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   83: ldc 160
    //   85: invokestatic 166	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_0
    //   89: ldc 18
    //   91: ldc 168
    //   93: aload_0
    //   94: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokestatic 131	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: ldc 170
    //   106: invokevirtual 174	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: ifne -53 -> 56
    //   112: aload_0
    //   113: ldc 176
    //   115: invokevirtual 174	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: ifne -62 -> 56
    //   121: aload 5
    //   123: invokevirtual 179	java/util/zip/ZipEntry:isDirectory	()Z
    //   126: ifne -70 -> 56
    //   129: aload 7
    //   131: aload 5
    //   133: invokevirtual 183	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   136: astore 5
    //   138: aload_0
    //   139: ldc 185
    //   141: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifeq +133 -> 277
    //   147: new 65	java/io/File
    //   150: dup
    //   151: iload_1
    //   152: invokestatic 193	org/xwalk/core/XWalkEnvironment:getDownloadApkPath	(I)Ljava/lang/String;
    //   155: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 75	java/io/File:exists	()Z
    //   163: ifne +205 -> 368
    //   166: aload_0
    //   167: invokevirtual 197	java/io/File:getParentFile	()Ljava/io/File;
    //   170: astore 8
    //   172: aload 8
    //   174: invokevirtual 75	java/io/File:exists	()Z
    //   177: ifne +9 -> 186
    //   180: aload 8
    //   182: invokevirtual 200	java/io/File:mkdirs	()Z
    //   185: pop
    //   186: new 80	java/io/FileOutputStream
    //   189: dup
    //   190: aload_0
    //   191: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   194: astore_0
    //   195: aload_0
    //   196: astore 10
    //   198: aload 5
    //   200: astore 9
    //   202: aload 7
    //   204: astore 8
    //   206: ldc 14
    //   208: newarray byte
    //   210: astore 11
    //   212: aload_0
    //   213: astore 10
    //   215: aload 5
    //   217: astore 9
    //   219: aload 7
    //   221: astore 8
    //   223: aload 5
    //   225: aload 11
    //   227: invokevirtual 203	java/io/InputStream:read	([B)I
    //   230: istore_2
    //   231: iload_2
    //   232: iconst_m1
    //   233: if_icmpeq +192 -> 425
    //   236: aload_0
    //   237: astore 10
    //   239: aload 5
    //   241: astore 9
    //   243: aload 7
    //   245: astore 8
    //   247: aload_0
    //   248: aload 11
    //   250: iconst_0
    //   251: iload_2
    //   252: invokevirtual 206	java/io/OutputStream:write	([BII)V
    //   255: aload_0
    //   256: astore 10
    //   258: aload 5
    //   260: astore 9
    //   262: aload 7
    //   264: astore 8
    //   266: aload 5
    //   268: aload 11
    //   270: invokevirtual 203	java/io/InputStream:read	([B)I
    //   273: istore_2
    //   274: goto -43 -> 231
    //   277: new 65	java/io/File
    //   280: dup
    //   281: iload_1
    //   282: aload_0
    //   283: invokestatic 210	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   286: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore_0
    //   290: goto -131 -> 159
    //   293: astore 6
    //   295: aconst_null
    //   296: astore_0
    //   297: aload_0
    //   298: astore 10
    //   300: aload 5
    //   302: astore 9
    //   304: aload 7
    //   306: astore 8
    //   308: ldc 18
    //   310: new 114	java/lang/StringBuilder
    //   313: dup
    //   314: ldc 212
    //   316: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: aload 6
    //   321: invokevirtual 215	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   324: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 98	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 7
    //   335: ifnull +8 -> 343
    //   338: aload 7
    //   340: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   343: aload_0
    //   344: ifnull +7 -> 351
    //   347: aload_0
    //   348: invokevirtual 219	java/io/OutputStream:close	()V
    //   351: aload 5
    //   353: ifnull +8 -> 361
    //   356: aload 5
    //   358: invokevirtual 220	java/io/InputStream:close	()V
    //   361: ldc 112
    //   363: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: iconst_0
    //   367: ireturn
    //   368: aload_0
    //   369: invokevirtual 78	java/io/File:delete	()Z
    //   372: pop
    //   373: goto -187 -> 186
    //   376: astore_0
    //   377: aconst_null
    //   378: astore 8
    //   380: aload 5
    //   382: astore 6
    //   384: aload 8
    //   386: astore 5
    //   388: aload 7
    //   390: ifnull +8 -> 398
    //   393: aload 7
    //   395: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   398: aload 5
    //   400: ifnull +8 -> 408
    //   403: aload 5
    //   405: invokevirtual 219	java/io/OutputStream:close	()V
    //   408: aload 6
    //   410: ifnull +8 -> 418
    //   413: aload 6
    //   415: invokevirtual 220	java/io/InputStream:close	()V
    //   418: ldc 112
    //   420: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload_0
    //   424: athrow
    //   425: aload_0
    //   426: astore 10
    //   428: aload 5
    //   430: astore 9
    //   432: aload 7
    //   434: astore 8
    //   436: aload_0
    //   437: invokevirtual 219	java/io/OutputStream:close	()V
    //   440: aload 5
    //   442: invokevirtual 220	java/io/InputStream:close	()V
    //   445: goto -389 -> 56
    //   448: aload 7
    //   450: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   453: invokestatic 225	java/lang/System:gc	()V
    //   456: ldc 18
    //   458: new 114	java/lang/StringBuilder
    //   461: dup
    //   462: ldc 227
    //   464: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   470: lload_3
    //   471: lsub
    //   472: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   475: ldc 232
    //   477: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 61	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: ldc 112
    //   488: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   491: iconst_1
    //   492: ireturn
    //   493: astore_0
    //   494: goto -41 -> 453
    //   497: astore 5
    //   499: goto -81 -> 418
    //   502: astore_0
    //   503: aconst_null
    //   504: astore 5
    //   506: aconst_null
    //   507: astore 6
    //   509: aconst_null
    //   510: astore 7
    //   512: goto -124 -> 388
    //   515: astore_0
    //   516: aconst_null
    //   517: astore 5
    //   519: aconst_null
    //   520: astore 6
    //   522: goto -134 -> 388
    //   525: astore_0
    //   526: aload 10
    //   528: astore 5
    //   530: aload 9
    //   532: astore 6
    //   534: aload 8
    //   536: astore 7
    //   538: goto -150 -> 388
    //   541: astore_0
    //   542: goto -181 -> 361
    //   545: astore 6
    //   547: aconst_null
    //   548: astore_0
    //   549: aconst_null
    //   550: astore 5
    //   552: aconst_null
    //   553: astore 7
    //   555: goto -258 -> 297
    //   558: astore 6
    //   560: aconst_null
    //   561: astore_0
    //   562: aconst_null
    //   563: astore 5
    //   565: goto -268 -> 297
    //   568: astore 6
    //   570: goto -273 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	paramString	String
    //   0	573	1	paramInt	int
    //   230	44	2	i	int
    //   38	433	3	l	long
    //   76	365	5	localObject1	Object
    //   497	1	5	localException	java.lang.Exception
    //   504	60	5	localObject2	Object
    //   54	13	6	localEnumeration	java.util.Enumeration
    //   293	27	6	localIOException1	java.io.IOException
    //   382	151	6	localObject3	Object
    //   545	1	6	localIOException2	java.io.IOException
    //   558	1	6	localIOException3	java.io.IOException
    //   568	1	6	localIOException4	java.io.IOException
    //   47	507	7	localObject4	Object
    //   170	365	8	localObject5	Object
    //   200	331	9	localObject6	Object
    //   196	331	10	str	String
    //   210	59	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   138	159	293	java/io/IOException
    //   159	186	293	java/io/IOException
    //   186	195	293	java/io/IOException
    //   277	290	293	java/io/IOException
    //   368	373	293	java/io/IOException
    //   440	445	293	java/io/IOException
    //   138	159	376	finally
    //   159	186	376	finally
    //   186	195	376	finally
    //   277	290	376	finally
    //   368	373	376	finally
    //   440	445	376	finally
    //   448	453	493	java/lang/Exception
    //   393	398	497	java/lang/Exception
    //   403	408	497	java/lang/Exception
    //   413	418	497	java/lang/Exception
    //   39	49	502	finally
    //   49	56	515	finally
    //   56	138	515	finally
    //   206	212	525	finally
    //   223	231	525	finally
    //   247	255	525	finally
    //   266	274	525	finally
    //   308	333	525	finally
    //   436	440	525	finally
    //   338	343	541	java/lang/Exception
    //   347	351	541	java/lang/Exception
    //   356	361	541	java/lang/Exception
    //   39	49	545	java/io/IOException
    //   49	56	558	java/io/IOException
    //   56	138	558	java/io/IOException
    //   206	212	568	java/io/IOException
    //   223	231	568	java/io/IOException
    //   247	255	568	java/io/IOException
    //   266	274	568	java/io/IOException
    //   436	440	568	java/io/IOException
  }
  
  /* Error */
  public static boolean decompressDownloadPatchZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 237
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 18
    //   7: ldc 239
    //   9: aload_0
    //   10: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 61	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   22: lstore_3
    //   23: new 139	java/util/zip/ZipFile
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 140	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 7
    //   33: aload 7
    //   35: invokevirtual 144	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   38: astore 12
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_0
    //   46: astore 10
    //   48: aload 6
    //   50: astore 9
    //   52: aload_0
    //   53: astore 5
    //   55: aload 7
    //   57: astore 8
    //   59: aload 12
    //   61: invokeinterface 149 1 0
    //   66: ifeq +454 -> 520
    //   69: aload_0
    //   70: astore 10
    //   72: aload 6
    //   74: astore 9
    //   76: aload_0
    //   77: astore 5
    //   79: aload 7
    //   81: astore 8
    //   83: aload 12
    //   85: invokeinterface 153 1 0
    //   90: checkcast 155	java/util/zip/ZipEntry
    //   93: astore 13
    //   95: aload_0
    //   96: astore 10
    //   98: aload 6
    //   100: astore 9
    //   102: aload_0
    //   103: astore 5
    //   105: aload 7
    //   107: astore 8
    //   109: aload 13
    //   111: invokevirtual 158	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   114: ldc 160
    //   116: invokestatic 166	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 11
    //   121: aload_0
    //   122: astore 10
    //   124: aload 6
    //   126: astore 9
    //   128: aload_0
    //   129: astore 5
    //   131: aload 7
    //   133: astore 8
    //   135: aload 11
    //   137: ldc 170
    //   139: invokevirtual 174	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   142: ifne -97 -> 45
    //   145: aload_0
    //   146: astore 10
    //   148: aload 6
    //   150: astore 9
    //   152: aload_0
    //   153: astore 5
    //   155: aload 7
    //   157: astore 8
    //   159: aload 11
    //   161: ldc 176
    //   163: invokevirtual 174	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   166: ifne -121 -> 45
    //   169: aload_0
    //   170: astore 10
    //   172: aload 6
    //   174: astore 9
    //   176: aload_0
    //   177: astore 5
    //   179: aload 7
    //   181: astore 8
    //   183: aload 13
    //   185: invokevirtual 179	java/util/zip/ZipEntry:isDirectory	()Z
    //   188: ifne -143 -> 45
    //   191: aload_0
    //   192: astore 10
    //   194: aload 6
    //   196: astore 9
    //   198: aload_0
    //   199: astore 5
    //   201: aload 7
    //   203: astore 8
    //   205: aload_0
    //   206: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   209: aload_0
    //   210: astore 10
    //   212: aload 6
    //   214: astore 9
    //   216: aload_0
    //   217: astore 5
    //   219: aload 7
    //   221: astore 8
    //   223: aload 7
    //   225: aload 13
    //   227: invokevirtual 183	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   230: astore_0
    //   231: aload_0
    //   232: astore 10
    //   234: aload 6
    //   236: astore 9
    //   238: aload_0
    //   239: astore 5
    //   241: aload 7
    //   243: astore 8
    //   245: new 65	java/io/File
    //   248: dup
    //   249: aload_1
    //   250: aload 11
    //   252: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: astore 11
    //   257: aload_0
    //   258: astore 10
    //   260: aload 6
    //   262: astore 9
    //   264: aload_0
    //   265: astore 5
    //   267: aload 7
    //   269: astore 8
    //   271: aload 11
    //   273: invokevirtual 75	java/io/File:exists	()Z
    //   276: ifne +147 -> 423
    //   279: aload_0
    //   280: astore 10
    //   282: aload 6
    //   284: astore 9
    //   286: aload_0
    //   287: astore 5
    //   289: aload 7
    //   291: astore 8
    //   293: aload 11
    //   295: invokevirtual 197	java/io/File:getParentFile	()Ljava/io/File;
    //   298: astore 13
    //   300: aload_0
    //   301: astore 10
    //   303: aload 6
    //   305: astore 9
    //   307: aload_0
    //   308: astore 5
    //   310: aload 7
    //   312: astore 8
    //   314: aload 13
    //   316: invokevirtual 75	java/io/File:exists	()Z
    //   319: ifne +23 -> 342
    //   322: aload_0
    //   323: astore 10
    //   325: aload 6
    //   327: astore 9
    //   329: aload_0
    //   330: astore 5
    //   332: aload 7
    //   334: astore 8
    //   336: aload 13
    //   338: invokevirtual 200	java/io/File:mkdirs	()Z
    //   341: pop
    //   342: aload_0
    //   343: astore 10
    //   345: aload 6
    //   347: astore 9
    //   349: aload_0
    //   350: astore 5
    //   352: aload 7
    //   354: astore 8
    //   356: aload 6
    //   358: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   361: aload_0
    //   362: astore 10
    //   364: aload 6
    //   366: astore 9
    //   368: aload_0
    //   369: astore 5
    //   371: aload 7
    //   373: astore 8
    //   375: new 80	java/io/FileOutputStream
    //   378: dup
    //   379: aload 11
    //   381: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   384: astore 11
    //   386: ldc 14
    //   388: newarray byte
    //   390: astore 5
    //   392: aload_0
    //   393: aload 5
    //   395: invokevirtual 203	java/io/InputStream:read	([B)I
    //   398: istore_2
    //   399: iload_2
    //   400: iconst_m1
    //   401: if_icmpeq +112 -> 513
    //   404: aload 11
    //   406: aload 5
    //   408: iconst_0
    //   409: iload_2
    //   410: invokevirtual 206	java/io/OutputStream:write	([BII)V
    //   413: aload_0
    //   414: aload 5
    //   416: invokevirtual 203	java/io/InputStream:read	([B)I
    //   419: istore_2
    //   420: goto -21 -> 399
    //   423: aload_0
    //   424: astore 10
    //   426: aload 6
    //   428: astore 9
    //   430: aload_0
    //   431: astore 5
    //   433: aload 7
    //   435: astore 8
    //   437: aload 11
    //   439: invokevirtual 78	java/io/File:delete	()Z
    //   442: pop
    //   443: goto -101 -> 342
    //   446: astore 5
    //   448: aload 10
    //   450: astore_0
    //   451: aload 6
    //   453: astore_1
    //   454: aload 5
    //   456: astore 6
    //   458: aload_1
    //   459: astore 9
    //   461: aload_0
    //   462: astore 5
    //   464: aload 7
    //   466: astore 8
    //   468: ldc 18
    //   470: new 114	java/lang/StringBuilder
    //   473: dup
    //   474: ldc 212
    //   476: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   479: aload 6
    //   481: invokevirtual 215	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   484: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 98	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload 7
    //   495: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   498: aload_1
    //   499: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   502: aload_0
    //   503: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   506: ldc 237
    //   508: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: iconst_0
    //   512: ireturn
    //   513: aload 11
    //   515: astore 6
    //   517: goto -472 -> 45
    //   520: aload 7
    //   522: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   525: aload 6
    //   527: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   530: aload_0
    //   531: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   534: invokestatic 225	java/lang/System:gc	()V
    //   537: ldc 18
    //   539: new 114	java/lang/StringBuilder
    //   542: dup
    //   543: ldc 227
    //   545: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   548: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   551: lload_3
    //   552: lsub
    //   553: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   556: ldc 232
    //   558: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 61	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: ldc 237
    //   569: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: iconst_1
    //   573: ireturn
    //   574: astore_1
    //   575: aconst_null
    //   576: astore 6
    //   578: aconst_null
    //   579: astore_0
    //   580: aconst_null
    //   581: astore 7
    //   583: aload 7
    //   585: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   588: aload 6
    //   590: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   593: aload_0
    //   594: invokestatic 104	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   597: ldc 237
    //   599: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   602: aload_1
    //   603: athrow
    //   604: astore_1
    //   605: goto -80 -> 525
    //   608: astore_1
    //   609: goto -84 -> 525
    //   612: astore 5
    //   614: goto -116 -> 498
    //   617: astore 5
    //   619: goto -121 -> 498
    //   622: astore 5
    //   624: goto -36 -> 588
    //   627: astore 5
    //   629: goto -41 -> 588
    //   632: astore_1
    //   633: aconst_null
    //   634: astore 6
    //   636: aconst_null
    //   637: astore_0
    //   638: goto -55 -> 583
    //   641: astore_1
    //   642: aload 11
    //   644: astore 6
    //   646: goto -63 -> 583
    //   649: astore_1
    //   650: aload 9
    //   652: astore 6
    //   654: aload 5
    //   656: astore_0
    //   657: aload 8
    //   659: astore 7
    //   661: goto -78 -> 583
    //   664: astore 6
    //   666: aconst_null
    //   667: astore_1
    //   668: aconst_null
    //   669: astore_0
    //   670: aconst_null
    //   671: astore 7
    //   673: goto -215 -> 458
    //   676: astore 6
    //   678: aconst_null
    //   679: astore_1
    //   680: aconst_null
    //   681: astore_0
    //   682: goto -224 -> 458
    //   685: astore 6
    //   687: aload 11
    //   689: astore_1
    //   690: goto -232 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	693	0	paramString1	String
    //   0	693	1	paramString2	String
    //   398	22	2	i	int
    //   22	530	3	l	long
    //   53	379	5	localObject1	Object
    //   446	9	5	localIOException1	java.io.IOException
    //   462	1	5	str1	String
    //   612	1	5	localIOException2	java.io.IOException
    //   617	1	5	localNullPointerException1	java.lang.NullPointerException
    //   622	1	5	localIOException3	java.io.IOException
    //   627	28	5	localNullPointerException2	java.lang.NullPointerException
    //   41	612	6	localObject2	Object
    //   664	1	6	localIOException4	java.io.IOException
    //   676	1	6	localIOException5	java.io.IOException
    //   685	1	6	localIOException6	java.io.IOException
    //   31	641	7	localObject3	Object
    //   57	601	8	localObject4	Object
    //   50	601	9	localObject5	Object
    //   46	403	10	str2	String
    //   119	569	11	localObject6	Object
    //   38	46	12	localEnumeration	java.util.Enumeration
    //   93	244	13	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   59	69	446	java/io/IOException
    //   83	95	446	java/io/IOException
    //   109	121	446	java/io/IOException
    //   135	145	446	java/io/IOException
    //   159	169	446	java/io/IOException
    //   183	191	446	java/io/IOException
    //   205	209	446	java/io/IOException
    //   223	231	446	java/io/IOException
    //   245	257	446	java/io/IOException
    //   271	279	446	java/io/IOException
    //   293	300	446	java/io/IOException
    //   314	322	446	java/io/IOException
    //   336	342	446	java/io/IOException
    //   356	361	446	java/io/IOException
    //   375	386	446	java/io/IOException
    //   437	443	446	java/io/IOException
    //   23	33	574	finally
    //   520	525	604	java/io/IOException
    //   520	525	608	java/lang/NullPointerException
    //   493	498	612	java/io/IOException
    //   493	498	617	java/lang/NullPointerException
    //   583	588	622	java/io/IOException
    //   583	588	627	java/lang/NullPointerException
    //   33	40	632	finally
    //   386	399	641	finally
    //   404	420	641	finally
    //   59	69	649	finally
    //   83	95	649	finally
    //   109	121	649	finally
    //   135	145	649	finally
    //   159	169	649	finally
    //   183	191	649	finally
    //   205	209	649	finally
    //   223	231	649	finally
    //   245	257	649	finally
    //   271	279	649	finally
    //   293	300	649	finally
    //   314	322	649	finally
    //   336	342	649	finally
    //   356	361	649	finally
    //   375	386	649	finally
    //   437	443	649	finally
    //   468	493	649	finally
    //   23	33	664	java/io/IOException
    //   33	40	676	java/io/IOException
    //   386	399	685	java/io/IOException
    //   404	420	685	java/io/IOException
  }
  
  /* Error */
  private static void extractLzmaToFile(InputStream paramInputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 244
    //   4: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 246	java/io/BufferedInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 249	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 6
    //   17: new 251	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 80	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 254	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_0
    //   33: aload_0
    //   34: astore 7
    //   36: aload 6
    //   38: astore 8
    //   40: iconst_5
    //   41: newarray byte
    //   43: astore 9
    //   45: aload_0
    //   46: astore 7
    //   48: aload 6
    //   50: astore 8
    //   52: aload 6
    //   54: aload 9
    //   56: iconst_0
    //   57: iconst_5
    //   58: invokevirtual 257	java/io/InputStream:read	([BII)I
    //   61: iconst_5
    //   62: if_icmpeq +121 -> 183
    //   65: aload_0
    //   66: astore 7
    //   68: aload 6
    //   70: astore 8
    //   72: new 111	java/io/IOException
    //   75: dup
    //   76: ldc_w 259
    //   79: invokespecial 260	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   82: astore 9
    //   84: aload_0
    //   85: astore 7
    //   87: aload 6
    //   89: astore 8
    //   91: ldc 244
    //   93: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_0
    //   97: astore 7
    //   99: aload 6
    //   101: astore 8
    //   103: aload 9
    //   105: athrow
    //   106: astore 9
    //   108: aload_0
    //   109: astore 7
    //   111: aload 6
    //   113: astore 8
    //   115: aload_1
    //   116: invokevirtual 263	java/io/File:isFile	()Z
    //   119: ifeq +15 -> 134
    //   122: aload_0
    //   123: astore 7
    //   125: aload 6
    //   127: astore 8
    //   129: aload_1
    //   130: invokevirtual 78	java/io/File:delete	()Z
    //   133: pop
    //   134: aload_0
    //   135: astore 7
    //   137: aload 6
    //   139: astore 8
    //   141: ldc 244
    //   143: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_0
    //   147: astore 7
    //   149: aload 6
    //   151: astore 8
    //   153: aload 9
    //   155: athrow
    //   156: astore_0
    //   157: aload 8
    //   159: astore 6
    //   161: aload 7
    //   163: invokevirtual 266	java/io/OutputStream:flush	()V
    //   166: aload 7
    //   168: invokevirtual 219	java/io/OutputStream:close	()V
    //   171: aload 6
    //   173: invokevirtual 220	java/io/InputStream:close	()V
    //   176: ldc 244
    //   178: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_0
    //   182: athrow
    //   183: aload_0
    //   184: astore 7
    //   186: aload 6
    //   188: astore 8
    //   190: new 268	g/a/b/a
    //   193: dup
    //   194: invokespecial 269	g/a/b/a:<init>	()V
    //   197: astore 10
    //   199: aload_0
    //   200: astore 7
    //   202: aload 6
    //   204: astore 8
    //   206: aload 10
    //   208: aload 9
    //   210: invokevirtual 273	g/a/b/a:dx	([B)Z
    //   213: ifne +250 -> 463
    //   216: aload_0
    //   217: astore 7
    //   219: aload 6
    //   221: astore 8
    //   223: new 111	java/io/IOException
    //   226: dup
    //   227: ldc_w 275
    //   230: invokespecial 260	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   233: astore 9
    //   235: aload_0
    //   236: astore 7
    //   238: aload 6
    //   240: astore 8
    //   242: ldc 244
    //   244: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_0
    //   248: astore 7
    //   250: aload 6
    //   252: astore 8
    //   254: aload 9
    //   256: athrow
    //   257: iload_2
    //   258: bipush 8
    //   260: if_icmpge +38 -> 298
    //   263: aload_0
    //   264: astore 7
    //   266: aload 6
    //   268: astore 8
    //   270: aload 6
    //   272: invokevirtual 278	java/io/InputStream:read	()I
    //   275: istore_3
    //   276: iload_3
    //   277: ifge +192 -> 469
    //   280: aload_0
    //   281: astore 7
    //   283: aload 6
    //   285: astore 8
    //   287: ldc 18
    //   289: ldc_w 280
    //   292: invokestatic 283	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: goto +174 -> 469
    //   298: aload_0
    //   299: astore 7
    //   301: aload 6
    //   303: astore 8
    //   305: aload 10
    //   307: aload 6
    //   309: aload_0
    //   310: lload 4
    //   312: invokevirtual 287	g/a/b/a:a	(Ljava/io/InputStream;Ljava/io/OutputStream;J)Z
    //   315: ifne +44 -> 359
    //   318: aload_0
    //   319: astore 7
    //   321: aload 6
    //   323: astore 8
    //   325: new 111	java/io/IOException
    //   328: dup
    //   329: ldc_w 289
    //   332: invokespecial 260	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   335: astore 9
    //   337: aload_0
    //   338: astore 7
    //   340: aload 6
    //   342: astore 8
    //   344: ldc 244
    //   346: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_0
    //   350: astore 7
    //   352: aload 6
    //   354: astore 8
    //   356: aload 9
    //   358: athrow
    //   359: aload_0
    //   360: invokevirtual 266	java/io/OutputStream:flush	()V
    //   363: aload_0
    //   364: invokevirtual 219	java/io/OutputStream:close	()V
    //   367: aload 6
    //   369: invokevirtual 220	java/io/InputStream:close	()V
    //   372: ldc 244
    //   374: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: return
    //   378: astore_0
    //   379: ldc 244
    //   381: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: return
    //   385: astore_1
    //   386: goto -23 -> 363
    //   389: astore_1
    //   390: goto -27 -> 363
    //   393: astore_0
    //   394: goto -27 -> 367
    //   397: astore_0
    //   398: goto -31 -> 367
    //   401: astore_0
    //   402: goto -23 -> 379
    //   405: astore_1
    //   406: goto -240 -> 166
    //   409: astore_1
    //   410: goto -244 -> 166
    //   413: astore_1
    //   414: goto -243 -> 171
    //   417: astore_1
    //   418: goto -247 -> 171
    //   421: astore_1
    //   422: goto -246 -> 176
    //   425: astore_1
    //   426: goto -250 -> 176
    //   429: astore_0
    //   430: aconst_null
    //   431: astore 7
    //   433: aconst_null
    //   434: astore 6
    //   436: goto -275 -> 161
    //   439: astore_0
    //   440: aconst_null
    //   441: astore 7
    //   443: goto -282 -> 161
    //   446: astore 9
    //   448: aconst_null
    //   449: astore_0
    //   450: aconst_null
    //   451: astore 6
    //   453: goto -345 -> 108
    //   456: astore 9
    //   458: aconst_null
    //   459: astore_0
    //   460: goto -352 -> 108
    //   463: lconst_0
    //   464: lstore 4
    //   466: goto -209 -> 257
    //   469: lload 4
    //   471: iload_3
    //   472: i2l
    //   473: iload_2
    //   474: bipush 8
    //   476: imul
    //   477: lshl
    //   478: lor
    //   479: lstore 4
    //   481: iload_2
    //   482: iconst_1
    //   483: iadd
    //   484: istore_2
    //   485: goto -228 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramInputStream	InputStream
    //   0	488	1	paramFile	java.io.File
    //   1	484	2	i	int
    //   275	197	3	j	int
    //   310	1	4	localObject1	Object
    //   464	16	4	l	long
    //   15	437	6	localObject2	Object
    //   34	408	7	localInputStream	InputStream
    //   38	317	8	localObject3	Object
    //   43	61	9	localObject4	Object
    //   106	103	9	localIOException1	java.io.IOException
    //   233	124	9	localIOException2	java.io.IOException
    //   446	1	9	localIOException3	java.io.IOException
    //   456	1	9	localIOException4	java.io.IOException
    //   197	109	10	locala	g.a.b.a
    // Exception table:
    //   from	to	target	type
    //   40	45	106	java/io/IOException
    //   52	65	106	java/io/IOException
    //   72	84	106	java/io/IOException
    //   91	96	106	java/io/IOException
    //   103	106	106	java/io/IOException
    //   190	199	106	java/io/IOException
    //   206	216	106	java/io/IOException
    //   223	235	106	java/io/IOException
    //   242	247	106	java/io/IOException
    //   254	257	106	java/io/IOException
    //   270	276	106	java/io/IOException
    //   287	295	106	java/io/IOException
    //   305	318	106	java/io/IOException
    //   325	337	106	java/io/IOException
    //   344	349	106	java/io/IOException
    //   356	359	106	java/io/IOException
    //   40	45	156	finally
    //   52	65	156	finally
    //   72	84	156	finally
    //   91	96	156	finally
    //   103	106	156	finally
    //   115	122	156	finally
    //   129	134	156	finally
    //   141	146	156	finally
    //   153	156	156	finally
    //   190	199	156	finally
    //   206	216	156	finally
    //   223	235	156	finally
    //   242	247	156	finally
    //   254	257	156	finally
    //   270	276	156	finally
    //   287	295	156	finally
    //   305	318	156	finally
    //   325	337	156	finally
    //   344	349	156	finally
    //   356	359	156	finally
    //   367	372	378	java/io/IOException
    //   359	363	385	java/io/IOException
    //   359	363	389	java/lang/NullPointerException
    //   363	367	393	java/io/IOException
    //   363	367	397	java/lang/NullPointerException
    //   367	372	401	java/lang/NullPointerException
    //   161	166	405	java/io/IOException
    //   161	166	409	java/lang/NullPointerException
    //   166	171	413	java/io/IOException
    //   166	171	417	java/lang/NullPointerException
    //   171	176	421	java/io/IOException
    //   171	176	425	java/lang/NullPointerException
    //   7	17	429	finally
    //   17	33	439	finally
    //   7	17	446	java/io/IOException
    //   17	33	456	java/io/IOException
  }
  
  /* Error */
  public static boolean extractResource(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 291
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 18
    //   8: ldc_w 293
    //   11: aload_0
    //   12: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 131	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   24: lstore 4
    //   26: new 139	java/util/zip/ZipFile
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 140	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   34: astore 7
    //   36: aload 7
    //   38: astore_0
    //   39: getstatic 31	org/xwalk/core/XWalkDecompressor:MANDATORY_RESOURCES	[Ljava/lang/String;
    //   42: astore 8
    //   44: aload 7
    //   46: astore_0
    //   47: aload 8
    //   49: arraylength
    //   50: istore_3
    //   51: iconst_0
    //   52: istore_2
    //   53: iload_2
    //   54: iload_3
    //   55: if_icmpge +355 -> 410
    //   58: aload 8
    //   60: iload_2
    //   61: aaload
    //   62: astore 9
    //   64: aload 7
    //   66: astore_0
    //   67: aload 9
    //   69: invokestatic 297	org/xwalk/core/XWalkDecompressor:isNativeLibrary	(Ljava/lang/String;)Z
    //   72: ifeq +97 -> 169
    //   75: aload 7
    //   77: astore_0
    //   78: aload 7
    //   80: new 114	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 299
    //   87: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: getstatic 302	java/io/File:separator	Ljava/lang/String;
    //   93: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 304
    //   99: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: getstatic 302	java/io/File:separator	Ljava/lang/String;
    //   105: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 9
    //   110: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokevirtual 308	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnonnull +151 -> 274
    //   126: aload 7
    //   128: astore_0
    //   129: aload 9
    //   131: invokestatic 311	org/xwalk/core/XWalkDecompressor:isClassesDex	(Ljava/lang/String;)Z
    //   134: ifeq +98 -> 232
    //   137: aload 7
    //   139: astore_0
    //   140: ldc 18
    //   142: new 114	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   149: aload 9
    //   151: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 314
    //   157: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 131	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto +350 -> 516
    //   169: aload 7
    //   171: astore_0
    //   172: aload 9
    //   174: invokestatic 317	org/xwalk/core/XWalkDecompressor:isAsset	(Ljava/lang/String;)Z
    //   177: ifeq +40 -> 217
    //   180: aload 7
    //   182: astore_0
    //   183: aload 7
    //   185: new 114	java/lang/StringBuilder
    //   188: dup
    //   189: ldc_w 319
    //   192: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: getstatic 302	java/io/File:separator	Ljava/lang/String;
    //   198: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 9
    //   203: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokevirtual 308	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   212: astore 6
    //   214: goto -93 -> 121
    //   217: aload 7
    //   219: astore_0
    //   220: aload 7
    //   222: aload 9
    //   224: invokevirtual 308	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   227: astore 6
    //   229: goto -108 -> 121
    //   232: aload 7
    //   234: astore_0
    //   235: ldc 18
    //   237: new 114	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   244: aload 9
    //   246: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 321
    //   252: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 98	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload 7
    //   263: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   266: ldc_w 291
    //   269: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: iconst_0
    //   273: ireturn
    //   274: aload 7
    //   276: astore_0
    //   277: ldc 18
    //   279: ldc_w 323
    //   282: aload 9
    //   284: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   287: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   290: invokestatic 61	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload 7
    //   295: astore_0
    //   296: new 65	java/io/File
    //   299: dup
    //   300: aload_1
    //   301: aload 9
    //   303: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: astore 10
    //   308: aload 7
    //   310: astore_0
    //   311: aload 10
    //   313: invokevirtual 263	java/io/File:isFile	()Z
    //   316: ifeq +23 -> 339
    //   319: aload 7
    //   321: astore_0
    //   322: aload 10
    //   324: invokevirtual 75	java/io/File:exists	()Z
    //   327: ifeq +12 -> 339
    //   330: aload 7
    //   332: astore_0
    //   333: aload 10
    //   335: invokevirtual 78	java/io/File:delete	()Z
    //   338: pop
    //   339: aload 7
    //   341: astore_0
    //   342: aload 7
    //   344: aload 6
    //   346: invokevirtual 183	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   349: new 65	java/io/File
    //   352: dup
    //   353: aload_1
    //   354: aload 9
    //   356: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: invokestatic 326	org/xwalk/core/XWalkDecompressor:extractStreamToFile	(Ljava/io/InputStream;Ljava/io/File;)V
    //   362: goto +154 -> 516
    //   365: astore 6
    //   367: aload 7
    //   369: astore_1
    //   370: aload_1
    //   371: astore_0
    //   372: ldc 18
    //   374: new 114	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 328
    //   381: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload 6
    //   386: invokevirtual 215	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   389: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 98	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_1
    //   399: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   402: ldc_w 291
    //   405: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: iconst_0
    //   409: ireturn
    //   410: aload 7
    //   412: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   415: invokestatic 225	java/lang/System:gc	()V
    //   418: ldc 18
    //   420: new 114	java/lang/StringBuilder
    //   423: dup
    //   424: ldc_w 330
    //   427: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   430: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   433: lload 4
    //   435: lsub
    //   436: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   439: ldc 232
    //   441: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 61	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: ldc_w 291
    //   453: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: iconst_1
    //   457: ireturn
    //   458: astore_1
    //   459: aconst_null
    //   460: astore_0
    //   461: aload_0
    //   462: invokevirtual 218	java/util/zip/ZipFile:close	()V
    //   465: ldc_w 291
    //   468: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: aload_1
    //   472: athrow
    //   473: astore_0
    //   474: goto -208 -> 266
    //   477: astore_0
    //   478: goto -212 -> 266
    //   481: astore_0
    //   482: goto -67 -> 415
    //   485: astore_0
    //   486: goto -71 -> 415
    //   489: astore_0
    //   490: goto -88 -> 402
    //   493: astore_0
    //   494: goto -92 -> 402
    //   497: astore_0
    //   498: goto -33 -> 465
    //   501: astore_0
    //   502: goto -37 -> 465
    //   505: astore_1
    //   506: goto -45 -> 461
    //   509: astore 6
    //   511: aconst_null
    //   512: astore_1
    //   513: goto -143 -> 370
    //   516: iload_2
    //   517: iconst_1
    //   518: iadd
    //   519: istore_2
    //   520: goto -467 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramString1	String
    //   0	523	1	paramString2	String
    //   52	468	2	i	int
    //   50	6	3	j	int
    //   24	410	4	l	long
    //   119	226	6	localZipEntry	java.util.zip.ZipEntry
    //   365	20	6	localIOException1	java.io.IOException
    //   509	1	6	localIOException2	java.io.IOException
    //   34	377	7	localZipFile	java.util.zip.ZipFile
    //   42	17	8	arrayOfString	String[]
    //   62	293	9	str	String
    //   306	28	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   39	44	365	java/io/IOException
    //   47	51	365	java/io/IOException
    //   67	75	365	java/io/IOException
    //   78	121	365	java/io/IOException
    //   129	137	365	java/io/IOException
    //   140	166	365	java/io/IOException
    //   172	180	365	java/io/IOException
    //   183	214	365	java/io/IOException
    //   220	229	365	java/io/IOException
    //   235	261	365	java/io/IOException
    //   277	293	365	java/io/IOException
    //   296	308	365	java/io/IOException
    //   311	319	365	java/io/IOException
    //   322	330	365	java/io/IOException
    //   333	339	365	java/io/IOException
    //   342	362	365	java/io/IOException
    //   26	36	458	finally
    //   261	266	473	java/io/IOException
    //   261	266	477	java/lang/NullPointerException
    //   410	415	481	java/io/IOException
    //   410	415	485	java/lang/NullPointerException
    //   398	402	489	java/io/IOException
    //   398	402	493	java/lang/NullPointerException
    //   461	465	497	java/io/IOException
    //   461	465	501	java/lang/NullPointerException
    //   39	44	505	finally
    //   47	51	505	finally
    //   67	75	505	finally
    //   78	121	505	finally
    //   129	137	505	finally
    //   140	166	505	finally
    //   172	180	505	finally
    //   183	214	505	finally
    //   220	229	505	finally
    //   235	261	505	finally
    //   277	293	505	finally
    //   296	308	505	finally
    //   311	319	505	finally
    //   322	330	505	finally
    //   333	339	505	finally
    //   342	362	505	finally
    //   372	398	505	finally
    //   26	36	509	java/io/IOException
  }
  
  /* Error */
  private static void extractStreamToFile(InputStream paramInputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc_w 331
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 334	java/io/InputStream:available	()I
    //   10: pop
    //   11: new 80	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: ldc 14
    //   26: newarray byte
    //   28: astore 5
    //   30: aload 4
    //   32: astore_3
    //   33: aload_0
    //   34: aload 5
    //   36: invokevirtual 203	java/io/InputStream:read	([B)I
    //   39: istore_2
    //   40: iload_2
    //   41: iflt +74 -> 115
    //   44: aload 4
    //   46: astore_3
    //   47: aload 4
    //   49: aload 5
    //   51: iconst_0
    //   52: iload_2
    //   53: invokevirtual 206	java/io/OutputStream:write	([BII)V
    //   56: goto -26 -> 30
    //   59: astore 5
    //   61: aload 4
    //   63: astore_3
    //   64: aload_1
    //   65: invokevirtual 263	java/io/File:isFile	()Z
    //   68: ifeq +11 -> 79
    //   71: aload 4
    //   73: astore_3
    //   74: aload_1
    //   75: invokevirtual 78	java/io/File:delete	()Z
    //   78: pop
    //   79: aload 4
    //   81: astore_3
    //   82: ldc_w 331
    //   85: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload 4
    //   90: astore_3
    //   91: aload 5
    //   93: athrow
    //   94: astore_1
    //   95: aload_3
    //   96: invokevirtual 266	java/io/OutputStream:flush	()V
    //   99: aload_3
    //   100: invokevirtual 219	java/io/OutputStream:close	()V
    //   103: aload_0
    //   104: invokevirtual 220	java/io/InputStream:close	()V
    //   107: ldc_w 331
    //   110: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: aload 4
    //   117: invokevirtual 266	java/io/OutputStream:flush	()V
    //   120: aload 4
    //   122: invokevirtual 219	java/io/OutputStream:close	()V
    //   125: aload_0
    //   126: invokevirtual 220	java/io/InputStream:close	()V
    //   129: ldc_w 331
    //   132: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_0
    //   137: ldc_w 331
    //   140: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: return
    //   144: astore_1
    //   145: goto -25 -> 120
    //   148: astore_1
    //   149: goto -29 -> 120
    //   152: astore_1
    //   153: goto -28 -> 125
    //   156: astore_1
    //   157: goto -32 -> 125
    //   160: astore_0
    //   161: goto -24 -> 137
    //   164: astore 4
    //   166: goto -67 -> 99
    //   169: astore 4
    //   171: goto -72 -> 99
    //   174: astore_3
    //   175: goto -72 -> 103
    //   178: astore_3
    //   179: goto -76 -> 103
    //   182: astore_0
    //   183: goto -76 -> 107
    //   186: astore_0
    //   187: goto -80 -> 107
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_3
    //   193: goto -98 -> 95
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 4
    //   201: goto -140 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramInputStream	InputStream
    //   0	204	1	paramFile	java.io.File
    //   39	14	2	i	int
    //   23	77	3	localFileOutputStream1	java.io.FileOutputStream
    //   174	1	3	localIOException1	java.io.IOException
    //   178	1	3	localNullPointerException1	java.lang.NullPointerException
    //   192	1	3	localObject1	Object
    //   19	102	4	localFileOutputStream2	java.io.FileOutputStream
    //   164	1	4	localIOException2	java.io.IOException
    //   169	1	4	localNullPointerException2	java.lang.NullPointerException
    //   199	1	4	localObject2	Object
    //   28	22	5	arrayOfByte	byte[]
    //   59	33	5	localIOException3	java.io.IOException
    //   196	1	5	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   24	30	59	java/io/IOException
    //   33	40	59	java/io/IOException
    //   47	56	59	java/io/IOException
    //   24	30	94	finally
    //   33	40	94	finally
    //   47	56	94	finally
    //   64	71	94	finally
    //   74	79	94	finally
    //   82	88	94	finally
    //   91	94	94	finally
    //   125	129	136	java/io/IOException
    //   115	120	144	java/io/IOException
    //   115	120	148	java/lang/NullPointerException
    //   120	125	152	java/io/IOException
    //   120	125	156	java/lang/NullPointerException
    //   125	129	160	java/lang/NullPointerException
    //   95	99	164	java/io/IOException
    //   95	99	169	java/lang/NullPointerException
    //   99	103	174	java/io/IOException
    //   99	103	178	java/lang/NullPointerException
    //   103	107	182	java/io/IOException
    //   103	107	186	java/lang/NullPointerException
    //   6	21	190	finally
    //   6	21	196	java/io/IOException
  }
  
  private static boolean isAsset(String paramString)
  {
    AppMethodBeat.i(154687);
    if ((paramString.endsWith(".dat")) || (paramString.endsWith(".pak")) || (paramString.endsWith(".js")))
    {
      AppMethodBeat.o(154687);
      return true;
    }
    AppMethodBeat.o(154687);
    return false;
  }
  
  private static boolean isClassesDex(String paramString)
  {
    AppMethodBeat.i(154688);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(154688);
      return false;
    }
    boolean bool = paramString.endsWith("classes.dex");
    AppMethodBeat.o(154688);
    return bool;
  }
  
  private static boolean isNativeLibrary(String paramString)
  {
    AppMethodBeat.i(154686);
    boolean bool = paramString.endsWith(".so");
    AppMethodBeat.o(154686);
    return bool;
  }
  
  private static InputStream openRawResource(String paramString)
  {
    AppMethodBeat.i(154689);
    Context localContext = XWalkEnvironment.getApplicationContext();
    Resources localResources = localContext.getResources();
    paramString = localResources.openRawResource(localResources.getIdentifier(paramString.split("\\.")[0], "raw", localContext.getPackageName()));
    AppMethodBeat.o(154689);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkDecompressor
 * JD-Core Version:    0.7.0.1
 */