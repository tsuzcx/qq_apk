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
  private static final int STREAM_BUFFER_SIZE = 1048576;
  private static final String TAG = "XWalkLib";
  
  /* Error */
  public static void copyApkToLocal(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 17
    //   7: ldc 42
    //   9: aload_0
    //   10: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 50	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 55	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: new 57	java/io/FileInputStream
    //   22: dup
    //   23: new 59	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 65	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_3
    //   35: new 59	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 69	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_0
    //   52: invokevirtual 72	java/io/File:delete	()Z
    //   55: pop
    //   56: new 74	java/io/FileOutputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
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
    //   85: invokevirtual 79	java/io/FileInputStream:read	([B)I
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
    //   103: invokevirtual 83	java/io/FileOutputStream:write	([BII)V
    //   106: goto -29 -> 77
    //   109: astore 5
    //   111: aload_0
    //   112: astore 4
    //   114: aload_3
    //   115: astore_1
    //   116: ldc 85
    //   118: aload 5
    //   120: invokevirtual 89	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_3
    //   127: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   130: aload_0
    //   131: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   134: ldc 34
    //   136: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: aload_3
    //   141: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   144: aload_0
    //   145: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   148: ldc 34
    //   150: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore_0
    //   155: aconst_null
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   164: aload 4
    //   166: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   169: ldc 34
    //   171: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0: ldc 106
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 17
    //   7: new 108	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 110
    //   13: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 117
    //   22: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore_3
    //   39: new 133	java/util/zip/ZipFile
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 134	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   47: astore 7
    //   49: aload 7
    //   51: invokevirtual 138	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   54: astore 6
    //   56: aload 6
    //   58: invokeinterface 143 1 0
    //   63: ifeq +385 -> 448
    //   66: aload 6
    //   68: invokeinterface 147 1 0
    //   73: checkcast 149	java/util/zip/ZipEntry
    //   76: astore 5
    //   78: aload 5
    //   80: invokevirtual 152	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   83: ldc 154
    //   85: invokestatic 160	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: astore_0
    //   89: ldc 17
    //   91: ldc 162
    //   93: aload_0
    //   94: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokevirtual 50	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: ldc 164
    //   106: invokevirtual 168	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: ifne -53 -> 56
    //   112: aload_0
    //   113: ldc 170
    //   115: invokevirtual 168	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: ifne -62 -> 56
    //   121: aload 5
    //   123: invokevirtual 173	java/util/zip/ZipEntry:isDirectory	()Z
    //   126: ifne -70 -> 56
    //   129: aload 7
    //   131: aload 5
    //   133: invokevirtual 177	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   136: astore 5
    //   138: aload_0
    //   139: ldc 179
    //   141: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifeq +133 -> 277
    //   147: new 59	java/io/File
    //   150: dup
    //   151: iload_1
    //   152: invokestatic 189	org/xwalk/core/XWalkEnvironment:getDownloadApkPath	(I)Ljava/lang/String;
    //   155: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 69	java/io/File:exists	()Z
    //   163: ifne +205 -> 368
    //   166: aload_0
    //   167: invokevirtual 193	java/io/File:getParentFile	()Ljava/io/File;
    //   170: astore 8
    //   172: aload 8
    //   174: invokevirtual 69	java/io/File:exists	()Z
    //   177: ifne +9 -> 186
    //   180: aload 8
    //   182: invokevirtual 196	java/io/File:mkdirs	()Z
    //   185: pop
    //   186: new 74	java/io/FileOutputStream
    //   189: dup
    //   190: aload_0
    //   191: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   194: astore_0
    //   195: aload_0
    //   196: astore 10
    //   198: aload 5
    //   200: astore 9
    //   202: aload 7
    //   204: astore 8
    //   206: ldc 13
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
    //   227: invokevirtual 199	java/io/InputStream:read	([B)I
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
    //   252: invokevirtual 202	java/io/OutputStream:write	([BII)V
    //   255: aload_0
    //   256: astore 10
    //   258: aload 5
    //   260: astore 9
    //   262: aload 7
    //   264: astore 8
    //   266: aload 5
    //   268: aload 11
    //   270: invokevirtual 199	java/io/InputStream:read	([B)I
    //   273: istore_2
    //   274: goto -43 -> 231
    //   277: new 59	java/io/File
    //   280: dup
    //   281: iload_1
    //   282: aload_0
    //   283: invokestatic 206	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   286: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
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
    //   308: ldc 17
    //   310: new 108	java/lang/StringBuilder
    //   313: dup
    //   314: ldc 208
    //   316: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: aload 6
    //   321: invokevirtual 211	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   324: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 7
    //   335: ifnull +8 -> 343
    //   338: aload 7
    //   340: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   343: aload_0
    //   344: ifnull +7 -> 351
    //   347: aload_0
    //   348: invokevirtual 215	java/io/OutputStream:close	()V
    //   351: aload 5
    //   353: ifnull +8 -> 361
    //   356: aload 5
    //   358: invokevirtual 216	java/io/InputStream:close	()V
    //   361: ldc 106
    //   363: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: iconst_0
    //   367: ireturn
    //   368: aload_0
    //   369: invokevirtual 72	java/io/File:delete	()Z
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
    //   395: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   398: aload 5
    //   400: ifnull +8 -> 408
    //   403: aload 5
    //   405: invokevirtual 215	java/io/OutputStream:close	()V
    //   408: aload 6
    //   410: ifnull +8 -> 418
    //   413: aload 6
    //   415: invokevirtual 216	java/io/InputStream:close	()V
    //   418: ldc 106
    //   420: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload_0
    //   424: athrow
    //   425: aload_0
    //   426: astore 10
    //   428: aload 5
    //   430: astore 9
    //   432: aload 7
    //   434: astore 8
    //   436: aload_0
    //   437: invokevirtual 215	java/io/OutputStream:close	()V
    //   440: aload 5
    //   442: invokevirtual 216	java/io/InputStream:close	()V
    //   445: goto -389 -> 56
    //   448: aload 7
    //   450: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   453: invokestatic 221	java/lang/System:gc	()V
    //   456: ldc 17
    //   458: new 108	java/lang/StringBuilder
    //   461: dup
    //   462: ldc 223
    //   464: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   470: lload_3
    //   471: lsub
    //   472: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   475: ldc 228
    //   477: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 55	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: ldc 106
    //   488: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0: ldc 233
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 17
    //   7: ldc 235
    //   9: aload_0
    //   10: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 50	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 55	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   22: lstore_3
    //   23: new 133	java/util/zip/ZipFile
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 134	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 7
    //   33: aload 7
    //   35: invokevirtual 138	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
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
    //   61: invokeinterface 143 1 0
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
    //   85: invokeinterface 147 1 0
    //   90: checkcast 149	java/util/zip/ZipEntry
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
    //   111: invokevirtual 152	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   114: ldc 154
    //   116: invokestatic 160	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   137: ldc 164
    //   139: invokevirtual 168	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   161: ldc 170
    //   163: invokevirtual 168	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   185: invokevirtual 173	java/util/zip/ZipEntry:isDirectory	()Z
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
    //   206: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
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
    //   227: invokevirtual 177	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   230: astore_0
    //   231: aload_0
    //   232: astore 10
    //   234: aload 6
    //   236: astore 9
    //   238: aload_0
    //   239: astore 5
    //   241: aload 7
    //   243: astore 8
    //   245: new 59	java/io/File
    //   248: dup
    //   249: aload_1
    //   250: aload 11
    //   252: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   273: invokevirtual 69	java/io/File:exists	()Z
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
    //   295: invokevirtual 193	java/io/File:getParentFile	()Ljava/io/File;
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
    //   316: invokevirtual 69	java/io/File:exists	()Z
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
    //   338: invokevirtual 196	java/io/File:mkdirs	()Z
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
    //   358: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   361: aload_0
    //   362: astore 10
    //   364: aload 6
    //   366: astore 9
    //   368: aload_0
    //   369: astore 5
    //   371: aload 7
    //   373: astore 8
    //   375: new 74	java/io/FileOutputStream
    //   378: dup
    //   379: aload 11
    //   381: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   384: astore 11
    //   386: ldc 13
    //   388: newarray byte
    //   390: astore 5
    //   392: aload_0
    //   393: aload 5
    //   395: invokevirtual 199	java/io/InputStream:read	([B)I
    //   398: istore_2
    //   399: iload_2
    //   400: iconst_m1
    //   401: if_icmpeq +112 -> 513
    //   404: aload 11
    //   406: aload 5
    //   408: iconst_0
    //   409: iload_2
    //   410: invokevirtual 202	java/io/OutputStream:write	([BII)V
    //   413: aload_0
    //   414: aload 5
    //   416: invokevirtual 199	java/io/InputStream:read	([B)I
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
    //   439: invokevirtual 72	java/io/File:delete	()Z
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
    //   468: ldc 17
    //   470: new 108	java/lang/StringBuilder
    //   473: dup
    //   474: ldc 208
    //   476: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   479: aload 6
    //   481: invokevirtual 211	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   484: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload 7
    //   495: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   498: aload_1
    //   499: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   502: aload_0
    //   503: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   506: ldc 233
    //   508: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: iconst_0
    //   512: ireturn
    //   513: aload 11
    //   515: astore 6
    //   517: goto -472 -> 45
    //   520: aload 7
    //   522: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   525: aload 6
    //   527: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   530: aload_0
    //   531: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   534: invokestatic 221	java/lang/System:gc	()V
    //   537: ldc 17
    //   539: new 108	java/lang/StringBuilder
    //   542: dup
    //   543: ldc 223
    //   545: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   548: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   551: lload_3
    //   552: lsub
    //   553: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   556: ldc 228
    //   558: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 55	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: ldc 233
    //   569: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   585: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   588: aload 6
    //   590: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   593: aload_0
    //   594: invokestatic 98	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   597: ldc 233
    //   599: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc 240
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 242	java/io/BufferedInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 245	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 6
    //   17: new 247	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 74	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 250	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
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
    //   58: invokevirtual 253	java/io/InputStream:read	([BII)I
    //   61: iconst_5
    //   62: if_icmpeq +120 -> 182
    //   65: aload_0
    //   66: astore 7
    //   68: aload 6
    //   70: astore 8
    //   72: new 105	java/io/IOException
    //   75: dup
    //   76: ldc 255
    //   78: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   81: astore 9
    //   83: aload_0
    //   84: astore 7
    //   86: aload 6
    //   88: astore 8
    //   90: ldc 240
    //   92: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: astore 7
    //   98: aload 6
    //   100: astore 8
    //   102: aload 9
    //   104: athrow
    //   105: astore 9
    //   107: aload_0
    //   108: astore 7
    //   110: aload 6
    //   112: astore 8
    //   114: aload_1
    //   115: invokevirtual 259	java/io/File:isFile	()Z
    //   118: ifeq +15 -> 133
    //   121: aload_0
    //   122: astore 7
    //   124: aload 6
    //   126: astore 8
    //   128: aload_1
    //   129: invokevirtual 72	java/io/File:delete	()Z
    //   132: pop
    //   133: aload_0
    //   134: astore 7
    //   136: aload 6
    //   138: astore 8
    //   140: ldc 240
    //   142: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_0
    //   146: astore 7
    //   148: aload 6
    //   150: astore 8
    //   152: aload 9
    //   154: athrow
    //   155: astore_0
    //   156: aload 8
    //   158: astore 6
    //   160: aload 7
    //   162: invokevirtual 262	java/io/OutputStream:flush	()V
    //   165: aload 7
    //   167: invokevirtual 215	java/io/OutputStream:close	()V
    //   170: aload 6
    //   172: invokevirtual 216	java/io/InputStream:close	()V
    //   175: ldc 240
    //   177: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_0
    //   181: athrow
    //   182: aload_0
    //   183: astore 7
    //   185: aload 6
    //   187: astore 8
    //   189: new 264	i/a/b/a
    //   192: dup
    //   193: invokespecial 265	i/a/b/a:<init>	()V
    //   196: astore 10
    //   198: aload_0
    //   199: astore 7
    //   201: aload 6
    //   203: astore 8
    //   205: aload 10
    //   207: aload 9
    //   209: invokevirtual 269	i/a/b/a:dz	([B)Z
    //   212: ifne +250 -> 462
    //   215: aload_0
    //   216: astore 7
    //   218: aload 6
    //   220: astore 8
    //   222: new 105	java/io/IOException
    //   225: dup
    //   226: ldc_w 271
    //   229: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   232: astore 9
    //   234: aload_0
    //   235: astore 7
    //   237: aload 6
    //   239: astore 8
    //   241: ldc 240
    //   243: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_0
    //   247: astore 7
    //   249: aload 6
    //   251: astore 8
    //   253: aload 9
    //   255: athrow
    //   256: iload_2
    //   257: bipush 8
    //   259: if_icmpge +38 -> 297
    //   262: aload_0
    //   263: astore 7
    //   265: aload 6
    //   267: astore 8
    //   269: aload 6
    //   271: invokevirtual 274	java/io/InputStream:read	()I
    //   274: istore_3
    //   275: iload_3
    //   276: ifge +192 -> 468
    //   279: aload_0
    //   280: astore 7
    //   282: aload 6
    //   284: astore 8
    //   286: ldc 17
    //   288: ldc_w 276
    //   291: invokestatic 279	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: goto +174 -> 468
    //   297: aload_0
    //   298: astore 7
    //   300: aload 6
    //   302: astore 8
    //   304: aload 10
    //   306: aload 6
    //   308: aload_0
    //   309: lload 4
    //   311: invokevirtual 283	i/a/b/a:a	(Ljava/io/InputStream;Ljava/io/OutputStream;J)Z
    //   314: ifne +44 -> 358
    //   317: aload_0
    //   318: astore 7
    //   320: aload 6
    //   322: astore 8
    //   324: new 105	java/io/IOException
    //   327: dup
    //   328: ldc_w 285
    //   331: invokespecial 256	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   334: astore 9
    //   336: aload_0
    //   337: astore 7
    //   339: aload 6
    //   341: astore 8
    //   343: ldc 240
    //   345: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload_0
    //   349: astore 7
    //   351: aload 6
    //   353: astore 8
    //   355: aload 9
    //   357: athrow
    //   358: aload_0
    //   359: invokevirtual 262	java/io/OutputStream:flush	()V
    //   362: aload_0
    //   363: invokevirtual 215	java/io/OutputStream:close	()V
    //   366: aload 6
    //   368: invokevirtual 216	java/io/InputStream:close	()V
    //   371: ldc 240
    //   373: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: return
    //   377: astore_0
    //   378: ldc 240
    //   380: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: return
    //   384: astore_1
    //   385: goto -23 -> 362
    //   388: astore_1
    //   389: goto -27 -> 362
    //   392: astore_0
    //   393: goto -27 -> 366
    //   396: astore_0
    //   397: goto -31 -> 366
    //   400: astore_0
    //   401: goto -23 -> 378
    //   404: astore_1
    //   405: goto -240 -> 165
    //   408: astore_1
    //   409: goto -244 -> 165
    //   412: astore_1
    //   413: goto -243 -> 170
    //   416: astore_1
    //   417: goto -247 -> 170
    //   420: astore_1
    //   421: goto -246 -> 175
    //   424: astore_1
    //   425: goto -250 -> 175
    //   428: astore_0
    //   429: aconst_null
    //   430: astore 7
    //   432: aconst_null
    //   433: astore 6
    //   435: goto -275 -> 160
    //   438: astore_0
    //   439: aconst_null
    //   440: astore 7
    //   442: goto -282 -> 160
    //   445: astore 9
    //   447: aconst_null
    //   448: astore_0
    //   449: aconst_null
    //   450: astore 6
    //   452: goto -345 -> 107
    //   455: astore 9
    //   457: aconst_null
    //   458: astore_0
    //   459: goto -352 -> 107
    //   462: lconst_0
    //   463: lstore 4
    //   465: goto -209 -> 256
    //   468: lload 4
    //   470: iload_3
    //   471: i2l
    //   472: iload_2
    //   473: bipush 8
    //   475: imul
    //   476: lshl
    //   477: lor
    //   478: lstore 4
    //   480: iload_2
    //   481: iconst_1
    //   482: iadd
    //   483: istore_2
    //   484: goto -228 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramInputStream	InputStream
    //   0	487	1	paramFile	java.io.File
    //   1	483	2	i	int
    //   274	197	3	j	int
    //   309	1	4	localObject1	Object
    //   463	16	4	l	long
    //   15	436	6	localObject2	Object
    //   34	407	7	localInputStream	InputStream
    //   38	316	8	localObject3	Object
    //   43	60	9	localObject4	Object
    //   105	103	9	localIOException1	java.io.IOException
    //   232	124	9	localIOException2	java.io.IOException
    //   445	1	9	localIOException3	java.io.IOException
    //   455	1	9	localIOException4	java.io.IOException
    //   196	109	10	locala	i.a.b.a
    // Exception table:
    //   from	to	target	type
    //   40	45	105	java/io/IOException
    //   52	65	105	java/io/IOException
    //   72	83	105	java/io/IOException
    //   90	95	105	java/io/IOException
    //   102	105	105	java/io/IOException
    //   189	198	105	java/io/IOException
    //   205	215	105	java/io/IOException
    //   222	234	105	java/io/IOException
    //   241	246	105	java/io/IOException
    //   253	256	105	java/io/IOException
    //   269	275	105	java/io/IOException
    //   286	294	105	java/io/IOException
    //   304	317	105	java/io/IOException
    //   324	336	105	java/io/IOException
    //   343	348	105	java/io/IOException
    //   355	358	105	java/io/IOException
    //   40	45	155	finally
    //   52	65	155	finally
    //   72	83	155	finally
    //   90	95	155	finally
    //   102	105	155	finally
    //   114	121	155	finally
    //   128	133	155	finally
    //   140	145	155	finally
    //   152	155	155	finally
    //   189	198	155	finally
    //   205	215	155	finally
    //   222	234	155	finally
    //   241	246	155	finally
    //   253	256	155	finally
    //   269	275	155	finally
    //   286	294	155	finally
    //   304	317	155	finally
    //   324	336	155	finally
    //   343	348	155	finally
    //   355	358	155	finally
    //   366	371	377	java/io/IOException
    //   358	362	384	java/io/IOException
    //   358	362	388	java/lang/NullPointerException
    //   362	366	392	java/io/IOException
    //   362	366	396	java/lang/NullPointerException
    //   366	371	400	java/lang/NullPointerException
    //   160	165	404	java/io/IOException
    //   160	165	408	java/lang/NullPointerException
    //   165	170	412	java/io/IOException
    //   165	170	416	java/lang/NullPointerException
    //   170	175	420	java/io/IOException
    //   170	175	424	java/lang/NullPointerException
    //   7	17	428	finally
    //   17	33	438	finally
    //   7	17	445	java/io/IOException
    //   17	33	455	java/io/IOException
  }
  
  /* Error */
  public static boolean extractResource(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc_w 288
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 17
    //   8: ldc_w 290
    //   11: aload_0
    //   12: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 50	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   24: lstore 5
    //   26: new 133	java/util/zip/ZipFile
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 134	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   34: astore 8
    //   36: aload 8
    //   38: astore_0
    //   39: aload_2
    //   40: arraylength
    //   41: istore 4
    //   43: iconst_0
    //   44: istore_3
    //   45: iload_3
    //   46: iload 4
    //   48: if_icmpge +352 -> 400
    //   51: aload_2
    //   52: iload_3
    //   53: aaload
    //   54: astore 9
    //   56: aload 8
    //   58: astore_0
    //   59: aload 9
    //   61: invokestatic 294	org/xwalk/core/XWalkDecompressor:isNativeLibrary	(Ljava/lang/String;)Z
    //   64: ifeq +97 -> 161
    //   67: aload 8
    //   69: astore_0
    //   70: aload 8
    //   72: new 108	java/lang/StringBuilder
    //   75: dup
    //   76: ldc_w 296
    //   79: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: getstatic 299	java/io/File:separator	Ljava/lang/String;
    //   85: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 301
    //   91: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: getstatic 299	java/io/File:separator	Ljava/lang/String;
    //   97: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 9
    //   102: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokevirtual 305	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   111: astore 7
    //   113: aload 7
    //   115: ifnonnull +151 -> 266
    //   118: aload 8
    //   120: astore_0
    //   121: aload 9
    //   123: invokestatic 308	org/xwalk/core/XWalkDecompressor:isClassesDex	(Ljava/lang/String;)Z
    //   126: ifeq +98 -> 224
    //   129: aload 8
    //   131: astore_0
    //   132: ldc 17
    //   134: new 108	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   141: aload 9
    //   143: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 311
    //   149: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto +347 -> 505
    //   161: aload 8
    //   163: astore_0
    //   164: aload 9
    //   166: invokestatic 314	org/xwalk/core/XWalkDecompressor:isAsset	(Ljava/lang/String;)Z
    //   169: ifeq +40 -> 209
    //   172: aload 8
    //   174: astore_0
    //   175: aload 8
    //   177: new 108	java/lang/StringBuilder
    //   180: dup
    //   181: ldc_w 316
    //   184: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: getstatic 299	java/io/File:separator	Ljava/lang/String;
    //   190: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 9
    //   195: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokevirtual 305	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   204: astore 7
    //   206: goto -93 -> 113
    //   209: aload 8
    //   211: astore_0
    //   212: aload 8
    //   214: aload 9
    //   216: invokevirtual 305	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   219: astore 7
    //   221: goto -108 -> 113
    //   224: aload 8
    //   226: astore_0
    //   227: ldc 17
    //   229: new 108	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   236: aload 9
    //   238: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 318
    //   244: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 8
    //   255: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   258: ldc_w 288
    //   261: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: iconst_0
    //   265: ireturn
    //   266: aload 8
    //   268: astore_0
    //   269: ldc 17
    //   271: ldc_w 320
    //   274: aload 9
    //   276: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokevirtual 50	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokestatic 55	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 8
    //   287: astore_0
    //   288: new 59	java/io/File
    //   291: dup
    //   292: aload_1
    //   293: aload 9
    //   295: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: astore 10
    //   300: aload 8
    //   302: astore_0
    //   303: aload 10
    //   305: invokevirtual 259	java/io/File:isFile	()Z
    //   308: ifeq +23 -> 331
    //   311: aload 8
    //   313: astore_0
    //   314: aload 10
    //   316: invokevirtual 69	java/io/File:exists	()Z
    //   319: ifeq +12 -> 331
    //   322: aload 8
    //   324: astore_0
    //   325: aload 10
    //   327: invokevirtual 72	java/io/File:delete	()Z
    //   330: pop
    //   331: aload 8
    //   333: astore_0
    //   334: aload 8
    //   336: aload 7
    //   338: invokevirtual 177	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   341: new 59	java/io/File
    //   344: dup
    //   345: aload_1
    //   346: aload 9
    //   348: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: invokestatic 323	org/xwalk/core/XWalkDecompressor:extractStreamToFile	(Ljava/io/InputStream;Ljava/io/File;)V
    //   354: goto +151 -> 505
    //   357: astore_2
    //   358: aload 8
    //   360: astore_1
    //   361: aload_1
    //   362: astore_0
    //   363: ldc 17
    //   365: new 108	java/lang/StringBuilder
    //   368: dup
    //   369: ldc_w 325
    //   372: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   375: aload_2
    //   376: invokevirtual 211	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   379: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 92	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload_1
    //   389: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   392: ldc_w 288
    //   395: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: iconst_0
    //   399: ireturn
    //   400: aload 8
    //   402: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   405: invokestatic 221	java/lang/System:gc	()V
    //   408: ldc 17
    //   410: new 108	java/lang/StringBuilder
    //   413: dup
    //   414: ldc_w 327
    //   417: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   420: invokestatic 131	android/os/SystemClock:uptimeMillis	()J
    //   423: lload 5
    //   425: lsub
    //   426: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   429: ldc 228
    //   431: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 55	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: ldc_w 288
    //   443: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: iconst_1
    //   447: ireturn
    //   448: astore_1
    //   449: aconst_null
    //   450: astore_0
    //   451: aload_0
    //   452: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   455: ldc_w 288
    //   458: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload_1
    //   462: athrow
    //   463: astore_0
    //   464: goto -206 -> 258
    //   467: astore_0
    //   468: goto -210 -> 258
    //   471: astore_0
    //   472: goto -67 -> 405
    //   475: astore_0
    //   476: goto -71 -> 405
    //   479: astore_0
    //   480: goto -88 -> 392
    //   483: astore_0
    //   484: goto -92 -> 392
    //   487: astore_0
    //   488: goto -33 -> 455
    //   491: astore_0
    //   492: goto -37 -> 455
    //   495: astore_1
    //   496: goto -45 -> 451
    //   499: astore_2
    //   500: aconst_null
    //   501: astore_1
    //   502: goto -141 -> 361
    //   505: iload_3
    //   506: iconst_1
    //   507: iadd
    //   508: istore_3
    //   509: goto -464 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	paramString1	String
    //   0	512	1	paramString2	String
    //   0	512	2	paramArrayOfString	String[]
    //   44	465	3	i	int
    //   41	8	4	j	int
    //   24	400	5	l	long
    //   111	226	7	localZipEntry	java.util.zip.ZipEntry
    //   34	367	8	localZipFile	java.util.zip.ZipFile
    //   54	293	9	str	String
    //   298	28	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   39	43	357	java/io/IOException
    //   59	67	357	java/io/IOException
    //   70	113	357	java/io/IOException
    //   121	129	357	java/io/IOException
    //   132	158	357	java/io/IOException
    //   164	172	357	java/io/IOException
    //   175	206	357	java/io/IOException
    //   212	221	357	java/io/IOException
    //   227	253	357	java/io/IOException
    //   269	285	357	java/io/IOException
    //   288	300	357	java/io/IOException
    //   303	311	357	java/io/IOException
    //   314	322	357	java/io/IOException
    //   325	331	357	java/io/IOException
    //   334	354	357	java/io/IOException
    //   26	36	448	finally
    //   253	258	463	java/io/IOException
    //   253	258	467	java/lang/NullPointerException
    //   400	405	471	java/io/IOException
    //   400	405	475	java/lang/NullPointerException
    //   388	392	479	java/io/IOException
    //   388	392	483	java/lang/NullPointerException
    //   451	455	487	java/io/IOException
    //   451	455	491	java/lang/NullPointerException
    //   39	43	495	finally
    //   59	67	495	finally
    //   70	113	495	finally
    //   121	129	495	finally
    //   132	158	495	finally
    //   164	172	495	finally
    //   175	206	495	finally
    //   212	221	495	finally
    //   227	253	495	finally
    //   269	285	495	finally
    //   288	300	495	finally
    //   303	311	495	finally
    //   314	322	495	finally
    //   325	331	495	finally
    //   334	354	495	finally
    //   363	388	495	finally
    //   26	36	499	java/io/IOException
  }
  
  /* Error */
  private static void extractStreamToFile(InputStream paramInputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc_w 328
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 331	java/io/InputStream:available	()I
    //   10: pop
    //   11: new 74	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: ldc 13
    //   26: newarray byte
    //   28: astore 5
    //   30: aload 4
    //   32: astore_3
    //   33: aload_0
    //   34: aload 5
    //   36: invokevirtual 199	java/io/InputStream:read	([B)I
    //   39: istore_2
    //   40: iload_2
    //   41: iflt +74 -> 115
    //   44: aload 4
    //   46: astore_3
    //   47: aload 4
    //   49: aload 5
    //   51: iconst_0
    //   52: iload_2
    //   53: invokevirtual 202	java/io/OutputStream:write	([BII)V
    //   56: goto -26 -> 30
    //   59: astore 5
    //   61: aload 4
    //   63: astore_3
    //   64: aload_1
    //   65: invokevirtual 259	java/io/File:isFile	()Z
    //   68: ifeq +11 -> 79
    //   71: aload 4
    //   73: astore_3
    //   74: aload_1
    //   75: invokevirtual 72	java/io/File:delete	()Z
    //   78: pop
    //   79: aload 4
    //   81: astore_3
    //   82: ldc_w 328
    //   85: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload 4
    //   90: astore_3
    //   91: aload 5
    //   93: athrow
    //   94: astore_1
    //   95: aload_3
    //   96: invokevirtual 262	java/io/OutputStream:flush	()V
    //   99: aload_3
    //   100: invokevirtual 215	java/io/OutputStream:close	()V
    //   103: aload_0
    //   104: invokevirtual 216	java/io/InputStream:close	()V
    //   107: ldc_w 328
    //   110: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: aload 4
    //   117: invokevirtual 262	java/io/OutputStream:flush	()V
    //   120: aload 4
    //   122: invokevirtual 215	java/io/OutputStream:close	()V
    //   125: aload_0
    //   126: invokevirtual 216	java/io/InputStream:close	()V
    //   129: ldc_w 328
    //   132: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_0
    //   137: ldc_w 328
    //   140: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkDecompressor
 * JD-Core Version:    0.7.0.1
 */