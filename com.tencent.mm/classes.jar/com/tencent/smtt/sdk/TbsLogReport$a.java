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
    //   0: new 26	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 28
    //   7: invokespecial 31	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_0
    //   11: ldc 33
    //   13: iconst_2
    //   14: invokestatic 39	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   17: istore_1
    //   18: aload_0
    //   19: ldc2_w 40
    //   22: invokevirtual 45	java/io/RandomAccessFile:seek	(J)V
    //   25: aload_0
    //   26: invokevirtual 49	java/io/RandomAccessFile:read	()I
    //   29: istore_2
    //   30: iload_2
    //   31: iload_1
    //   32: iand
    //   33: ifle +23 -> 56
    //   36: aload_0
    //   37: ldc2_w 40
    //   40: invokevirtual 45	java/io/RandomAccessFile:seek	(J)V
    //   43: aload_0
    //   44: iload_1
    //   45: iconst_m1
    //   46: ixor
    //   47: sipush 255
    //   50: iand
    //   51: iload_2
    //   52: iand
    //   53: invokevirtual 53	java/io/RandomAccessFile:write	(I)V
    //   56: aload_0
    //   57: invokevirtual 56	java/io/RandomAccessFile:close	()V
    //   60: return
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull -5 -> 60
    //   68: aload_0
    //   69: invokevirtual 56	java/io/RandomAccessFile:close	()V
    //   72: return
    //   73: astore_0
    //   74: return
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 56	java/io/RandomAccessFile:close	()V
    //   86: aload_0
    //   87: athrow
    //   88: astore_0
    //   89: return
    //   90: astore_3
    //   91: goto -5 -> 86
    //   94: astore_3
    //   95: aload_0
    //   96: astore 4
    //   98: aload_3
    //   99: astore_0
    //   100: aload 4
    //   102: astore_3
    //   103: goto -25 -> 78
    //   106: astore_3
    //   107: goto -43 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramFile	java.io.File
    //   17	30	1	i	int
    //   29	24	2	j	int
    //   77	6	3	localObject1	Object
    //   90	1	3	localIOException	java.io.IOException
    //   94	5	3	localObject2	Object
    //   102	1	3	localObject3	Object
    //   106	1	3	localException	java.lang.Exception
    //   96	5	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   0	11	61	java/lang/Exception
    //   68	72	73	java/io/IOException
    //   0	11	75	finally
    //   56	60	88	java/io/IOException
    //   82	86	90	java/io/IOException
    //   11	30	94	finally
    //   36	56	94	finally
    //   11	30	106	java/lang/Exception
    //   36	56	106	java/lang/Exception
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: new 58	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
    //   8: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 63	java/util/zip/ZipOutputStream
    //   15: dup
    //   16: new 65	java/io/BufferedOutputStream
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 68	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: invokespecial 69	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 5
    //   29: sipush 2048
    //   32: newarray byte
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 16	com/tencent/smtt/sdk/TbsLogReport$a:a	Ljava/lang/String;
    //   40: astore 7
    //   42: new 71	java/io/FileInputStream
    //   45: dup
    //   46: aload 7
    //   48: invokespecial 72	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: new 74	java/io/BufferedInputStream
    //   56: dup
    //   57: aload 4
    //   59: sipush 2048
    //   62: invokespecial 77	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   65: astore_3
    //   66: aload 5
    //   68: new 79	java/util/zip/ZipEntry
    //   71: dup
    //   72: aload 7
    //   74: aload 7
    //   76: ldc 81
    //   78: invokevirtual 87	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   81: iconst_1
    //   82: iadd
    //   83: invokevirtual 91	java/lang/String:substring	(I)Ljava/lang/String;
    //   86: invokespecial 92	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 96	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   92: aload_3
    //   93: aload 6
    //   95: iconst_0
    //   96: sipush 2048
    //   99: invokevirtual 99	java/io/BufferedInputStream:read	([BII)I
    //   102: istore_1
    //   103: iload_1
    //   104: iconst_m1
    //   105: if_icmpeq +59 -> 164
    //   108: aload 5
    //   110: aload 6
    //   112: iconst_0
    //   113: iload_1
    //   114: invokevirtual 102	java/util/zip/ZipOutputStream:write	([BII)V
    //   117: goto -25 -> 92
    //   120: astore 6
    //   122: aload_3
    //   123: ifnull +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 104	java/io/FileInputStream:close	()V
    //   140: new 106	java/io/File
    //   143: dup
    //   144: aload_0
    //   145: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
    //   148: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: invokestatic 109	com/tencent/smtt/sdk/TbsLogReport$a:a	(Ljava/io/File;)V
    //   154: aload 5
    //   156: invokevirtual 110	java/util/zip/ZipOutputStream:close	()V
    //   159: aload_2
    //   160: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   163: return
    //   164: aload 5
    //   166: invokevirtual 114	java/util/zip/ZipOutputStream:flush	()V
    //   169: aload 5
    //   171: invokevirtual 117	java/util/zip/ZipOutputStream:closeEntry	()V
    //   174: aload_3
    //   175: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   178: aload 4
    //   180: invokevirtual 104	java/io/FileInputStream:close	()V
    //   183: goto -43 -> 140
    //   186: astore_3
    //   187: goto -47 -> 140
    //   190: astore_3
    //   191: aconst_null
    //   192: astore 4
    //   194: aconst_null
    //   195: astore 6
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 103	java/io/BufferedInputStream:close	()V
    //   207: aload 6
    //   209: ifnull +8 -> 217
    //   212: aload 6
    //   214: invokevirtual 104	java/io/FileInputStream:close	()V
    //   217: aload_3
    //   218: athrow
    //   219: astore_3
    //   220: aload_2
    //   221: astore_3
    //   222: aload 5
    //   224: astore_2
    //   225: aload_2
    //   226: ifnull +7 -> 233
    //   229: aload_2
    //   230: invokevirtual 110	java/util/zip/ZipOutputStream:close	()V
    //   233: aload_3
    //   234: ifnull -71 -> 163
    //   237: aload_3
    //   238: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   241: return
    //   242: astore_2
    //   243: return
    //   244: astore_3
    //   245: aconst_null
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_2
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 110	java/util/zip/ZipOutputStream:close	()V
    //   260: aload_2
    //   261: ifnull +7 -> 268
    //   264: aload_2
    //   265: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   268: aload_3
    //   269: athrow
    //   270: astore_3
    //   271: goto -93 -> 178
    //   274: astore_3
    //   275: goto -145 -> 130
    //   278: astore_3
    //   279: goto -139 -> 140
    //   282: astore 4
    //   284: goto -77 -> 207
    //   287: astore 4
    //   289: goto -72 -> 217
    //   292: astore_3
    //   293: goto -134 -> 159
    //   296: astore_2
    //   297: return
    //   298: astore_2
    //   299: goto -66 -> 233
    //   302: astore 4
    //   304: goto -44 -> 260
    //   307: astore_2
    //   308: goto -40 -> 268
    //   311: astore_3
    //   312: aconst_null
    //   313: astore 4
    //   315: goto -65 -> 250
    //   318: astore_3
    //   319: aload 5
    //   321: astore 4
    //   323: goto -73 -> 250
    //   326: astore_2
    //   327: aconst_null
    //   328: astore_2
    //   329: aconst_null
    //   330: astore_3
    //   331: goto -106 -> 225
    //   334: astore_3
    //   335: aconst_null
    //   336: astore 4
    //   338: aload_2
    //   339: astore_3
    //   340: aload 4
    //   342: astore_2
    //   343: goto -118 -> 225
    //   346: astore_3
    //   347: aconst_null
    //   348: astore 7
    //   350: aload 4
    //   352: astore 6
    //   354: aload 7
    //   356: astore 4
    //   358: goto -161 -> 197
    //   361: astore 7
    //   363: aload_3
    //   364: astore 8
    //   366: aload 4
    //   368: astore 6
    //   370: aload 7
    //   372: astore_3
    //   373: aload 8
    //   375: astore 4
    //   377: goto -180 -> 197
    //   380: astore_3
    //   381: aconst_null
    //   382: astore_3
    //   383: aconst_null
    //   384: astore 4
    //   386: goto -264 -> 122
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_3
    //   392: goto -270 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	a
    //   102	12	1	i	int
    //   11	219	2	localObject1	Object
    //   242	1	2	localIOException1	java.io.IOException
    //   249	16	2	localObject2	Object
    //   296	1	2	localIOException2	java.io.IOException
    //   298	1	2	localIOException3	java.io.IOException
    //   307	1	2	localIOException4	java.io.IOException
    //   326	1	2	localException1	java.lang.Exception
    //   328	15	2	localObject3	Object
    //   65	110	3	localBufferedInputStream	java.io.BufferedInputStream
    //   186	1	3	localIOException5	java.io.IOException
    //   190	28	3	localObject4	Object
    //   219	1	3	localException2	java.lang.Exception
    //   221	17	3	localObject5	Object
    //   244	25	3	localObject6	Object
    //   270	1	3	localIOException6	java.io.IOException
    //   274	1	3	localIOException7	java.io.IOException
    //   278	1	3	localIOException8	java.io.IOException
    //   292	1	3	localIOException9	java.io.IOException
    //   311	1	3	localObject7	Object
    //   318	1	3	localObject8	Object
    //   330	1	3	localObject9	Object
    //   334	1	3	localException3	java.lang.Exception
    //   339	1	3	localObject10	Object
    //   346	18	3	localObject11	Object
    //   372	1	3	localObject12	Object
    //   380	1	3	localException4	java.lang.Exception
    //   382	1	3	localObject13	Object
    //   389	1	3	localException5	java.lang.Exception
    //   391	1	3	localObject14	Object
    //   51	205	4	localFileInputStream	java.io.FileInputStream
    //   282	1	4	localIOException10	java.io.IOException
    //   287	1	4	localIOException11	java.io.IOException
    //   302	1	4	localIOException12	java.io.IOException
    //   313	72	4	localObject15	Object
    //   27	293	5	localZipOutputStream	java.util.zip.ZipOutputStream
    //   34	77	6	arrayOfByte	byte[]
    //   120	1	6	localException6	java.lang.Exception
    //   195	174	6	localObject16	Object
    //   40	315	7	str	String
    //   361	10	7	localObject17	Object
    //   364	10	8	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   66	92	120	java/lang/Exception
    //   92	103	120	java/lang/Exception
    //   108	117	120	java/lang/Exception
    //   164	174	120	java/lang/Exception
    //   178	183	186	java/io/IOException
    //   42	53	190	finally
    //   29	42	219	java/lang/Exception
    //   126	130	219	java/lang/Exception
    //   135	140	219	java/lang/Exception
    //   140	154	219	java/lang/Exception
    //   174	178	219	java/lang/Exception
    //   178	183	219	java/lang/Exception
    //   202	207	219	java/lang/Exception
    //   212	217	219	java/lang/Exception
    //   217	219	219	java/lang/Exception
    //   237	241	242	java/io/IOException
    //   0	12	244	finally
    //   174	178	270	java/io/IOException
    //   126	130	274	java/io/IOException
    //   135	140	278	java/io/IOException
    //   202	207	282	java/io/IOException
    //   212	217	287	java/io/IOException
    //   154	159	292	java/io/IOException
    //   159	163	296	java/io/IOException
    //   229	233	298	java/io/IOException
    //   255	260	302	java/io/IOException
    //   264	268	307	java/io/IOException
    //   12	29	311	finally
    //   29	42	318	finally
    //   126	130	318	finally
    //   135	140	318	finally
    //   140	154	318	finally
    //   174	178	318	finally
    //   178	183	318	finally
    //   202	207	318	finally
    //   212	217	318	finally
    //   217	219	318	finally
    //   0	12	326	java/lang/Exception
    //   12	29	334	java/lang/Exception
    //   53	66	346	finally
    //   66	92	361	finally
    //   92	103	361	finally
    //   108	117	361	finally
    //   164	174	361	finally
    //   42	53	380	java/lang/Exception
    //   53	66	389	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.a
 * JD-Core Version:    0.7.0.1
 */