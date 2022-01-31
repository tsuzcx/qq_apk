package com.tencent.smtt.sdk;

class TbsLogReport$a
{
  private final String a;
  private final String b;
  
  public TbsLogReport$a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  /* Error */
  private static void a(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 33	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 35
    //   12: invokespecial 38	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: ldc 40
    //   18: iconst_2
    //   19: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   22: istore_1
    //   23: aload_0
    //   24: ldc2_w 47
    //   27: invokevirtual 52	java/io/RandomAccessFile:seek	(J)V
    //   30: aload_0
    //   31: invokevirtual 56	java/io/RandomAccessFile:read	()I
    //   34: istore_2
    //   35: iload_2
    //   36: iload_1
    //   37: iand
    //   38: ifle +23 -> 61
    //   41: aload_0
    //   42: ldc2_w 47
    //   45: invokevirtual 52	java/io/RandomAccessFile:seek	(J)V
    //   48: aload_0
    //   49: iload_1
    //   50: iconst_m1
    //   51: ixor
    //   52: sipush 255
    //   55: iand
    //   56: iload_2
    //   57: iand
    //   58: invokevirtual 59	java/io/RandomAccessFile:write	(I)V
    //   61: aload_0
    //   62: invokevirtual 62	java/io/RandomAccessFile:close	()V
    //   65: ldc 25
    //   67: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: astore_0
    //   72: ldc 25
    //   74: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +38 -> 120
    //   85: aload_0
    //   86: invokevirtual 62	java/io/RandomAccessFile:close	()V
    //   89: ldc 25
    //   91: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_0
    //   96: ldc 25
    //   98: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: return
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 62	java/io/RandomAccessFile:close	()V
    //   113: ldc 25
    //   115: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: athrow
    //   120: ldc 25
    //   122: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: return
    //   126: astore_3
    //   127: goto -14 -> 113
    //   130: astore_3
    //   131: aload_0
    //   132: astore 4
    //   134: aload_3
    //   135: astore_0
    //   136: aload 4
    //   138: astore_3
    //   139: goto -34 -> 105
    //   142: astore_3
    //   143: goto -62 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramFile	java.io.File
    //   22	30	1	i	int
    //   34	24	2	j	int
    //   104	6	3	localObject1	Object
    //   126	1	3	localIOException	java.io.IOException
    //   130	5	3	localObject2	Object
    //   138	1	3	localObject3	Object
    //   142	1	3	localException	java.lang.Exception
    //   132	5	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   61	65	71	java/io/IOException
    //   5	16	78	java/lang/Exception
    //   85	89	95	java/io/IOException
    //   5	16	102	finally
    //   109	113	126	java/io/IOException
    //   16	35	130	finally
    //   41	61	130	finally
    //   16	35	142	java/lang/Exception
    //   41	61	142	java/lang/Exception
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 68	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
    //   13: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: new 73	java/util/zip/ZipOutputStream
    //   20: dup
    //   21: new 75	java/io/BufferedOutputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 78	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: invokespecial 79	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 5
    //   34: sipush 2048
    //   37: newarray byte
    //   39: astore 6
    //   41: aload_0
    //   42: getfield 16	com/tencent/smtt/sdk/TbsLogReport$a:a	Ljava/lang/String;
    //   45: astore 7
    //   47: new 81	java/io/FileInputStream
    //   50: dup
    //   51: aload 7
    //   53: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore 4
    //   58: new 84	java/io/BufferedInputStream
    //   61: dup
    //   62: aload 4
    //   64: sipush 2048
    //   67: invokespecial 87	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   70: astore_3
    //   71: aload 5
    //   73: new 89	java/util/zip/ZipEntry
    //   76: dup
    //   77: aload 7
    //   79: aload 7
    //   81: ldc 91
    //   83: invokevirtual 97	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   86: iconst_1
    //   87: iadd
    //   88: invokevirtual 101	java/lang/String:substring	(I)Ljava/lang/String;
    //   91: invokespecial 102	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   94: invokevirtual 106	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   97: aload_3
    //   98: aload 6
    //   100: iconst_0
    //   101: sipush 2048
    //   104: invokevirtual 109	java/io/BufferedInputStream:read	([BII)I
    //   107: istore_1
    //   108: iload_1
    //   109: iconst_m1
    //   110: if_icmpeq +64 -> 174
    //   113: aload 5
    //   115: aload 6
    //   117: iconst_0
    //   118: iload_1
    //   119: invokevirtual 112	java/util/zip/ZipOutputStream:write	([BII)V
    //   122: goto -25 -> 97
    //   125: astore 6
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 113	java/io/BufferedInputStream:close	()V
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 114	java/io/FileInputStream:close	()V
    //   145: new 116	java/io/File
    //   148: dup
    //   149: aload_0
    //   150: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
    //   153: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   156: invokestatic 119	com/tencent/smtt/sdk/TbsLogReport$a:a	(Ljava/io/File;)V
    //   159: aload 5
    //   161: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
    //   164: aload_2
    //   165: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   168: ldc 66
    //   170: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: return
    //   174: aload 5
    //   176: invokevirtual 124	java/util/zip/ZipOutputStream:flush	()V
    //   179: aload 5
    //   181: invokevirtual 127	java/util/zip/ZipOutputStream:closeEntry	()V
    //   184: aload_3
    //   185: invokevirtual 113	java/io/BufferedInputStream:close	()V
    //   188: aload 4
    //   190: invokevirtual 114	java/io/FileInputStream:close	()V
    //   193: goto -48 -> 145
    //   196: astore_3
    //   197: goto -52 -> 145
    //   200: astore_3
    //   201: aconst_null
    //   202: astore 4
    //   204: aconst_null
    //   205: astore 6
    //   207: aload 4
    //   209: ifnull +8 -> 217
    //   212: aload 4
    //   214: invokevirtual 113	java/io/BufferedInputStream:close	()V
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 114	java/io/FileInputStream:close	()V
    //   227: ldc 66
    //   229: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_3
    //   233: athrow
    //   234: astore_3
    //   235: aload_2
    //   236: astore_3
    //   237: aload 5
    //   239: astore_2
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
    //   248: aload_3
    //   249: ifnull +58 -> 307
    //   252: aload_3
    //   253: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   256: ldc 66
    //   258: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: return
    //   262: astore_2
    //   263: ldc 66
    //   265: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: return
    //   269: astore_2
    //   270: ldc 66
    //   272: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: return
    //   276: astore_3
    //   277: aconst_null
    //   278: astore 4
    //   280: aconst_null
    //   281: astore_2
    //   282: aload 4
    //   284: ifnull +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
    //   292: aload_2
    //   293: ifnull +7 -> 300
    //   296: aload_2
    //   297: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   300: ldc 66
    //   302: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_3
    //   306: athrow
    //   307: ldc 66
    //   309: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: return
    //   313: astore_3
    //   314: goto -126 -> 188
    //   317: astore_3
    //   318: goto -183 -> 135
    //   321: astore_3
    //   322: goto -177 -> 145
    //   325: astore 4
    //   327: goto -110 -> 217
    //   330: astore 4
    //   332: goto -105 -> 227
    //   335: astore_3
    //   336: goto -172 -> 164
    //   339: astore_2
    //   340: goto -92 -> 248
    //   343: astore 4
    //   345: goto -53 -> 292
    //   348: astore_2
    //   349: goto -49 -> 300
    //   352: astore_3
    //   353: aconst_null
    //   354: astore 4
    //   356: goto -74 -> 282
    //   359: astore_3
    //   360: aload 5
    //   362: astore 4
    //   364: goto -82 -> 282
    //   367: astore_2
    //   368: aconst_null
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_3
    //   372: goto -132 -> 240
    //   375: astore_3
    //   376: aconst_null
    //   377: astore 4
    //   379: aload_2
    //   380: astore_3
    //   381: aload 4
    //   383: astore_2
    //   384: goto -144 -> 240
    //   387: astore_3
    //   388: aconst_null
    //   389: astore 7
    //   391: aload 4
    //   393: astore 6
    //   395: aload 7
    //   397: astore 4
    //   399: goto -192 -> 207
    //   402: astore 7
    //   404: aload_3
    //   405: astore 8
    //   407: aload 4
    //   409: astore 6
    //   411: aload 7
    //   413: astore_3
    //   414: aload 8
    //   416: astore 4
    //   418: goto -211 -> 207
    //   421: astore_3
    //   422: aconst_null
    //   423: astore_3
    //   424: aconst_null
    //   425: astore 4
    //   427: goto -300 -> 127
    //   430: astore_3
    //   431: aconst_null
    //   432: astore_3
    //   433: goto -306 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	a
    //   107	12	1	i	int
    //   16	229	2	localObject1	Object
    //   262	1	2	localIOException1	java.io.IOException
    //   269	1	2	localIOException2	java.io.IOException
    //   281	16	2	localObject2	Object
    //   339	1	2	localIOException3	java.io.IOException
    //   348	1	2	localIOException4	java.io.IOException
    //   367	1	2	localException1	java.lang.Exception
    //   369	15	2	localObject3	Object
    //   70	115	3	localBufferedInputStream	java.io.BufferedInputStream
    //   196	1	3	localIOException5	java.io.IOException
    //   200	33	3	localObject4	Object
    //   234	1	3	localException2	java.lang.Exception
    //   236	17	3	localObject5	Object
    //   276	30	3	localObject6	Object
    //   313	1	3	localIOException6	java.io.IOException
    //   317	1	3	localIOException7	java.io.IOException
    //   321	1	3	localIOException8	java.io.IOException
    //   335	1	3	localIOException9	java.io.IOException
    //   352	1	3	localObject7	Object
    //   359	1	3	localObject8	Object
    //   371	1	3	localObject9	Object
    //   375	1	3	localException3	java.lang.Exception
    //   380	1	3	localObject10	Object
    //   387	18	3	localObject11	Object
    //   413	1	3	localObject12	Object
    //   421	1	3	localException4	java.lang.Exception
    //   423	1	3	localObject13	Object
    //   430	1	3	localException5	java.lang.Exception
    //   432	1	3	localObject14	Object
    //   56	232	4	localFileInputStream	java.io.FileInputStream
    //   325	1	4	localIOException10	java.io.IOException
    //   330	1	4	localIOException11	java.io.IOException
    //   343	1	4	localIOException12	java.io.IOException
    //   354	72	4	localObject15	Object
    //   32	329	5	localZipOutputStream	java.util.zip.ZipOutputStream
    //   39	77	6	arrayOfByte	byte[]
    //   125	1	6	localException6	java.lang.Exception
    //   205	205	6	localObject16	Object
    //   45	351	7	str	String
    //   402	10	7	localObject17	Object
    //   405	10	8	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   71	97	125	java/lang/Exception
    //   97	108	125	java/lang/Exception
    //   113	122	125	java/lang/Exception
    //   174	184	125	java/lang/Exception
    //   188	193	196	java/io/IOException
    //   47	58	200	finally
    //   34	47	234	java/lang/Exception
    //   131	135	234	java/lang/Exception
    //   140	145	234	java/lang/Exception
    //   145	159	234	java/lang/Exception
    //   184	188	234	java/lang/Exception
    //   188	193	234	java/lang/Exception
    //   212	217	234	java/lang/Exception
    //   222	227	234	java/lang/Exception
    //   227	234	234	java/lang/Exception
    //   164	168	262	java/io/IOException
    //   252	256	269	java/io/IOException
    //   5	17	276	finally
    //   184	188	313	java/io/IOException
    //   131	135	317	java/io/IOException
    //   140	145	321	java/io/IOException
    //   212	217	325	java/io/IOException
    //   222	227	330	java/io/IOException
    //   159	164	335	java/io/IOException
    //   244	248	339	java/io/IOException
    //   287	292	343	java/io/IOException
    //   296	300	348	java/io/IOException
    //   17	34	352	finally
    //   34	47	359	finally
    //   131	135	359	finally
    //   140	145	359	finally
    //   145	159	359	finally
    //   184	188	359	finally
    //   188	193	359	finally
    //   212	217	359	finally
    //   222	227	359	finally
    //   227	234	359	finally
    //   5	17	367	java/lang/Exception
    //   17	34	375	java/lang/Exception
    //   58	71	387	finally
    //   71	97	402	finally
    //   97	108	402	finally
    //   113	122	402	finally
    //   174	184	402	finally
    //   47	58	421	java/lang/Exception
    //   58	71	430	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.a
 * JD-Core Version:    0.7.0.1
 */