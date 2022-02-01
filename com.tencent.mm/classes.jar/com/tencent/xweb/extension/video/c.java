package com.tencent.xweb.extension.video;

public final class c
{
  /* Error */
  public static java.lang.String kgA()
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 19
    //   7: invokestatic 25	com/tencent/xweb/xwalk/a/i:bHs	(Ljava/lang/String;)Lcom/tencent/xweb/xwalk/a/g;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +356 -> 368
    //   15: aload_1
    //   16: getfield 31	com/tencent/xweb/xwalk/a/g:aipK	I
    //   19: iconst_m1
    //   20: if_icmpeq +348 -> 368
    //   23: aload_1
    //   24: getfield 31	com/tencent/xweb/xwalk/a/g:aipK	I
    //   27: istore_0
    //   28: new 33	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: aload_1
    //   34: getfield 31	com/tencent/xweb/xwalk/a/g:aipK	I
    //   37: iconst_0
    //   38: invokevirtual 37	com/tencent/xweb/xwalk/a/g:dg	(IZ)Ljava/lang/String;
    //   41: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 45	java/io/File:isFile	()Z
    //   49: ifeq +196 -> 245
    //   52: aload_2
    //   53: invokevirtual 48	java/io/File:exists	()Z
    //   56: ifeq +189 -> 245
    //   59: new 50	java/io/FileInputStream
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +294 -> 363
    //   72: new 55	java/io/InputStreamReader
    //   75: dup
    //   76: aload_1
    //   77: ldc 57
    //   79: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   82: astore_3
    //   83: new 62	java/io/BufferedReader
    //   86: dup
    //   87: aload_3
    //   88: invokespecial 65	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   91: astore_2
    //   92: aload_3
    //   93: astore 5
    //   95: aload_2
    //   96: astore 4
    //   98: new 67	java/lang/StringBuffer
    //   101: dup
    //   102: ldc 69
    //   104: invokespecial 70	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   107: astore 6
    //   109: aload_3
    //   110: astore 5
    //   112: aload_2
    //   113: astore 4
    //   115: aload_2
    //   116: invokevirtual 73	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   119: astore 7
    //   121: aload 7
    //   123: ifnull +133 -> 256
    //   126: aload_3
    //   127: astore 5
    //   129: aload_2
    //   130: astore 4
    //   132: aload 6
    //   134: aload 7
    //   136: invokevirtual 77	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   139: pop
    //   140: aload_3
    //   141: astore 5
    //   143: aload_2
    //   144: astore 4
    //   146: aload 6
    //   148: ldc 79
    //   150: invokevirtual 77	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   153: pop
    //   154: goto -45 -> 109
    //   157: astore 6
    //   159: aload_3
    //   160: astore 5
    //   162: aload_2
    //   163: astore 4
    //   165: ldc 81
    //   167: ldc 83
    //   169: aload 6
    //   171: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   174: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokestatic 99	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_3
    //   181: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   184: aload_2
    //   185: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   188: aload_1
    //   189: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: ifnull +10 -> 205
    //   198: aload_1
    //   199: invokevirtual 108	java/lang/String:isEmpty	()Z
    //   202: ifeq +111 -> 313
    //   205: ldc 81
    //   207: ldc 110
    //   209: invokestatic 112	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: ldc 114
    //   214: astore_1
    //   215: invokestatic 120	com/tencent/xweb/util/l:kiE	()V
    //   218: ldc 11
    //   220: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_1
    //   224: areturn
    //   225: astore_1
    //   226: ldc 81
    //   228: ldc 83
    //   230: aload_1
    //   231: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 99	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aconst_null
    //   241: astore_1
    //   242: goto -174 -> 68
    //   245: aload_1
    //   246: iconst_m1
    //   247: invokevirtual 127	com/tencent/xweb/xwalk/a/g:aJM	(I)Z
    //   250: pop
    //   251: aconst_null
    //   252: astore_1
    //   253: goto -185 -> 68
    //   256: aload_3
    //   257: astore 5
    //   259: aload_2
    //   260: astore 4
    //   262: aload 6
    //   264: invokevirtual 130	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   267: astore 6
    //   269: aload_3
    //   270: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   273: aload_2
    //   274: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   277: aload_1
    //   278: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   281: aload 6
    //   283: astore_1
    //   284: goto -90 -> 194
    //   287: astore_2
    //   288: aconst_null
    //   289: astore_3
    //   290: aconst_null
    //   291: astore 4
    //   293: aload_3
    //   294: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   297: aload 4
    //   299: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   302: aload_1
    //   303: invokestatic 105	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   306: ldc 11
    //   308: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aload_2
    //   312: athrow
    //   313: ldc 81
    //   315: ldc 132
    //   317: iload_0
    //   318: invokestatic 135	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   321: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   324: invokestatic 112	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: invokestatic 138	com/tencent/xweb/util/l:kiD	()V
    //   330: goto -112 -> 218
    //   333: astore_2
    //   334: aconst_null
    //   335: astore 4
    //   337: goto -44 -> 293
    //   340: astore_2
    //   341: aload 5
    //   343: astore_3
    //   344: goto -51 -> 293
    //   347: astore 6
    //   349: aconst_null
    //   350: astore_3
    //   351: aconst_null
    //   352: astore_2
    //   353: goto -194 -> 159
    //   356: astore 6
    //   358: aconst_null
    //   359: astore_2
    //   360: goto -201 -> 159
    //   363: aconst_null
    //   364: astore_1
    //   365: goto -171 -> 194
    //   368: iconst_m1
    //   369: istore_0
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -304 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	343	0	i	int
    //   10	214	1	localObject1	Object
    //   225	6	1	localFileNotFoundException	java.io.FileNotFoundException
    //   241	131	1	localObject2	Object
    //   44	230	2	localObject3	Object
    //   287	25	2	localObject4	Object
    //   333	1	2	localObject5	Object
    //   340	1	2	localObject6	Object
    //   352	8	2	localObject7	Object
    //   82	269	3	localObject8	Object
    //   96	240	4	localObject9	Object
    //   93	249	5	localObject10	Object
    //   107	40	6	localStringBuffer	java.lang.StringBuffer
    //   157	106	6	localIOException1	java.io.IOException
    //   267	15	6	str1	java.lang.String
    //   347	1	6	localIOException2	java.io.IOException
    //   356	1	6	localIOException3	java.io.IOException
    //   119	16	7	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   98	109	157	java/io/IOException
    //   115	121	157	java/io/IOException
    //   132	140	157	java/io/IOException
    //   146	154	157	java/io/IOException
    //   262	269	157	java/io/IOException
    //   59	68	225	java/io/FileNotFoundException
    //   72	83	287	finally
    //   83	92	333	finally
    //   98	109	340	finally
    //   115	121	340	finally
    //   132	140	340	finally
    //   146	154	340	finally
    //   165	180	340	finally
    //   262	269	340	finally
    //   72	83	347	java/io/IOException
    //   83	92	356	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */