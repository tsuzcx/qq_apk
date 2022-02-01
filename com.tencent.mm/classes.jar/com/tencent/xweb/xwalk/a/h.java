package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  /* Error */
  public static java.util.List<a> ak(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 12
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 20	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 24	java/util/ArrayList:<init>	()V
    //   12: astore 6
    //   14: new 26	java/io/BufferedReader
    //   17: dup
    //   18: new 28	java/io/FileReader
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 31	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   26: invokespecial 34	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore 5
    //   31: aload 5
    //   33: astore_0
    //   34: aload 5
    //   36: invokevirtual 38	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +287 -> 330
    //   46: aload 5
    //   48: astore_0
    //   49: aload 4
    //   51: invokevirtual 44	java/lang/String:isEmpty	()Z
    //   54: ifne -23 -> 31
    //   57: aload 5
    //   59: astore_0
    //   60: aload 4
    //   62: ldc 46
    //   64: invokevirtual 50	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifeq +175 -> 242
    //   70: aload 5
    //   72: astore_0
    //   73: aload 4
    //   75: iconst_4
    //   76: invokevirtual 54	java/lang/String:substring	(I)Ljava/lang/String;
    //   79: astore 4
    //   81: iconst_1
    //   82: istore_1
    //   83: aload 5
    //   85: astore_0
    //   86: aload 4
    //   88: ldc 56
    //   90: invokevirtual 60	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   93: astore 4
    //   95: aload 5
    //   97: astore_0
    //   98: aload 4
    //   100: arraylength
    //   101: istore_3
    //   102: iconst_0
    //   103: istore_2
    //   104: iload_2
    //   105: iload_3
    //   106: if_icmpge -75 -> 31
    //   109: aload 4
    //   111: iload_2
    //   112: aaload
    //   113: astore 7
    //   115: aload 7
    //   117: ifnull +301 -> 418
    //   120: aload 5
    //   122: astore_0
    //   123: aload 7
    //   125: invokevirtual 44	java/lang/String:isEmpty	()Z
    //   128: ifne +290 -> 418
    //   131: aload 5
    //   133: astore_0
    //   134: new 6	com/tencent/xweb/xwalk/a/h$a
    //   137: dup
    //   138: invokespecial 61	com/tencent/xweb/xwalk/a/h$a:<init>	()V
    //   141: astore 8
    //   143: aload 5
    //   145: astore_0
    //   146: aload 8
    //   148: aload 7
    //   150: putfield 65	com/tencent/xweb/xwalk/a/h$a:originalFileName	Ljava/lang/String;
    //   153: aload 5
    //   155: astore_0
    //   156: aload 8
    //   158: iload_1
    //   159: putfield 69	com/tencent/xweb/xwalk/a/h$a:type	I
    //   162: iload_1
    //   163: iconst_2
    //   164: if_icmpne +34 -> 198
    //   167: aload 5
    //   169: astore_0
    //   170: aload 8
    //   172: new 71	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   179: aload 8
    //   181: getfield 65	com/tencent/xweb/xwalk/a/h$a:originalFileName	Ljava/lang/String;
    //   184: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 78
    //   189: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: putfield 84	com/tencent/xweb/xwalk/a/h$a:patchFileName	Ljava/lang/String;
    //   198: aload 5
    //   200: astore_0
    //   201: ldc 86
    //   203: new 71	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 88
    //   209: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload 8
    //   214: invokevirtual 92	com/tencent/xweb/xwalk/a/h$a:toString	()Ljava/lang/String;
    //   217: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 97	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 5
    //   228: astore_0
    //   229: aload 6
    //   231: aload 8
    //   233: invokeinterface 103 2 0
    //   238: pop
    //   239: goto +179 -> 418
    //   242: aload 5
    //   244: astore_0
    //   245: aload 4
    //   247: ldc 105
    //   249: invokevirtual 50	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   252: ifeq +19 -> 271
    //   255: aload 5
    //   257: astore_0
    //   258: aload 4
    //   260: iconst_4
    //   261: invokevirtual 54	java/lang/String:substring	(I)Ljava/lang/String;
    //   264: astore 4
    //   266: iconst_2
    //   267: istore_1
    //   268: goto -185 -> 83
    //   271: aload 5
    //   273: astore_0
    //   274: aload 4
    //   276: ldc 107
    //   278: invokevirtual 50	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   281: ifeq +19 -> 300
    //   284: aload 5
    //   286: astore_0
    //   287: aload 4
    //   289: iconst_4
    //   290: invokevirtual 54	java/lang/String:substring	(I)Ljava/lang/String;
    //   293: astore 4
    //   295: iconst_3
    //   296: istore_1
    //   297: goto -214 -> 83
    //   300: aload 5
    //   302: astore_0
    //   303: ldc 86
    //   305: ldc 109
    //   307: aload 4
    //   309: invokestatic 113	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   312: invokevirtual 117	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokestatic 120	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload 5
    //   320: invokestatic 126	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   323: ldc 12
    //   325: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aconst_null
    //   329: areturn
    //   330: aload 5
    //   332: invokestatic 126	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   335: ldc 12
    //   337: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload 6
    //   342: areturn
    //   343: astore 6
    //   345: aconst_null
    //   346: astore 4
    //   348: aload 4
    //   350: astore_0
    //   351: ldc 86
    //   353: new 71	java/lang/StringBuilder
    //   356: dup
    //   357: ldc 131
    //   359: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: aload 6
    //   364: invokevirtual 134	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   367: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 120	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload 4
    //   378: invokestatic 126	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   381: ldc 12
    //   383: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: aconst_null
    //   387: areturn
    //   388: astore 4
    //   390: aconst_null
    //   391: astore_0
    //   392: aload_0
    //   393: invokestatic 126	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   396: ldc 12
    //   398: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload 4
    //   403: athrow
    //   404: astore 4
    //   406: goto -14 -> 392
    //   409: astore 6
    //   411: aload 5
    //   413: astore 4
    //   415: goto -67 -> 348
    //   418: iload_2
    //   419: iconst_1
    //   420: iadd
    //   421: istore_2
    //   422: goto -318 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	paramFile	java.io.File
    //   82	215	1	i	int
    //   103	319	2	j	int
    //   101	6	3	k	int
    //   39	338	4	localObject1	Object
    //   388	14	4	localObject2	Object
    //   404	1	4	localObject3	Object
    //   413	1	4	localBufferedReader1	java.io.BufferedReader
    //   29	383	5	localBufferedReader2	java.io.BufferedReader
    //   12	329	6	localArrayList	java.util.ArrayList
    //   343	20	6	localException1	java.lang.Exception
    //   409	1	6	localException2	java.lang.Exception
    //   113	36	7	localObject4	Object
    //   141	91	8	locala	a
    // Exception table:
    //   from	to	target	type
    //   14	31	343	java/lang/Exception
    //   14	31	388	finally
    //   34	41	404	finally
    //   49	57	404	finally
    //   60	70	404	finally
    //   73	81	404	finally
    //   86	95	404	finally
    //   98	102	404	finally
    //   123	131	404	finally
    //   134	143	404	finally
    //   146	153	404	finally
    //   156	162	404	finally
    //   170	198	404	finally
    //   201	226	404	finally
    //   229	239	404	finally
    //   245	255	404	finally
    //   258	266	404	finally
    //   274	284	404	finally
    //   287	295	404	finally
    //   303	318	404	finally
    //   351	376	404	finally
    //   34	41	409	java/lang/Exception
    //   49	57	409	java/lang/Exception
    //   60	70	409	java/lang/Exception
    //   73	81	409	java/lang/Exception
    //   86	95	409	java/lang/Exception
    //   98	102	409	java/lang/Exception
    //   123	131	409	java/lang/Exception
    //   134	143	409	java/lang/Exception
    //   146	153	409	java/lang/Exception
    //   156	162	409	java/lang/Exception
    //   170	198	409	java/lang/Exception
    //   201	226	409	java/lang/Exception
    //   229	239	409	java/lang/Exception
    //   245	255	409	java/lang/Exception
    //   258	266	409	java/lang/Exception
    //   274	284	409	java/lang/Exception
    //   287	295	409	java/lang/Exception
    //   303	318	409	java/lang/Exception
  }
  
  public static final class a
  {
    public String originalFileName;
    public String patchFileName;
    public int type;
    
    public final String toString()
    {
      AppMethodBeat.i(157196);
      String str = "PluginPatchConfig type:" + this.type + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName;
      AppMethodBeat.o(157196);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.h
 * JD-Core Version:    0.7.0.1
 */