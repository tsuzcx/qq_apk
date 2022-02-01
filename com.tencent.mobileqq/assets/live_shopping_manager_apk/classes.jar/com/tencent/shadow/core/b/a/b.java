package com.tencent.shadow.core.b.a;

import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static final Logger a = LoggerFactory.getLogger(b.class);
  private static ConcurrentHashMap<String, Object> b = new ConcurrentHashMap();
  
  /* Error */
  public static java.io.File a(java.io.File paramFile1, java.io.File paramFile2, java.io.File paramFile3, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore 8
    //   6: getstatic 26	com/tencent/shadow/core/b/a/b:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   9: aload 8
    //   11: invokevirtual 43	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore 6
    //   16: aload 6
    //   18: astore 7
    //   20: aload 6
    //   22: ifnonnull +23 -> 45
    //   25: new 4	java/lang/Object
    //   28: dup
    //   29: invokespecial 28	java/lang/Object:<init>	()V
    //   32: astore 7
    //   34: getstatic 26	com/tencent/shadow/core/b/a/b:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: aload 8
    //   39: aload 7
    //   41: invokevirtual 47	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload 7
    //   47: monitorenter
    //   48: aload_3
    //   49: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +441 -> 493
    //   55: aload_2
    //   56: invokevirtual 57	java/io/File:exists	()Z
    //   59: ifeq +6 -> 65
    //   62: goto +431 -> 493
    //   65: aload_1
    //   66: invokevirtual 57	java/io/File:exists	()Z
    //   69: ifeq +56 -> 125
    //   72: aload_1
    //   73: invokevirtual 60	java/io/File:isFile	()Z
    //   76: ifne +6 -> 82
    //   79: goto +46 -> 125
    //   82: new 62	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   89: astore_0
    //   90: aload_0
    //   91: ldc 65
    //   93: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_0
    //   98: aload_1
    //   99: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   102: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_0
    //   107: ldc 71
    //   109: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: new 73	com/tencent/shadow/core/b/a/c
    //   116: dup
    //   117: aload_0
    //   118: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 79	com/tencent/shadow/core/b/a/c:<init>	(Ljava/lang/String;)V
    //   124: athrow
    //   125: aload_1
    //   126: invokevirtual 82	java/io/File:mkdirs	()Z
    //   129: pop
    //   130: aconst_null
    //   131: astore 6
    //   133: aconst_null
    //   134: astore 10
    //   136: aconst_null
    //   137: astore 9
    //   139: new 84	com/tencent/shadow/core/b/a/k
    //   142: dup
    //   143: new 86	java/io/FileInputStream
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   151: invokespecial 92	com/tencent/shadow/core/b/a/k:<init>	(Ljava/io/InputStream;)V
    //   154: astore 8
    //   156: aload 8
    //   158: invokevirtual 96	com/tencent/shadow/core/b/a/k:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   161: astore 6
    //   163: aload 6
    //   165: ifnull +132 -> 297
    //   168: aload 6
    //   170: invokevirtual 101	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   173: aload_3
    //   174: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   177: istore 5
    //   179: iload 5
    //   181: ifeq -25 -> 156
    //   184: new 109	java/io/BufferedOutputStream
    //   187: dup
    //   188: new 111	java/io/FileOutputStream
    //   191: dup
    //   192: new 35	java/io/File
    //   195: dup
    //   196: aload_1
    //   197: aload 6
    //   199: invokevirtual 101	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   202: aload_3
    //   203: invokevirtual 115	java/lang/String:length	()I
    //   206: invokevirtual 119	java/lang/String:substring	(I)Ljava/lang/String;
    //   209: invokespecial 122	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   212: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   215: invokespecial 126	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   218: astore 6
    //   220: new 128	java/io/BufferedInputStream
    //   223: dup
    //   224: aload 8
    //   226: invokespecial 129	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   229: astore 10
    //   231: sipush 8192
    //   234: newarray byte
    //   236: astore 11
    //   238: aload 10
    //   240: aload 11
    //   242: iconst_0
    //   243: sipush 8192
    //   246: invokevirtual 133	java/io/BufferedInputStream:read	([BII)I
    //   249: istore 4
    //   251: iload 4
    //   253: iflt +16 -> 269
    //   256: aload 6
    //   258: aload 11
    //   260: iconst_0
    //   261: iload 4
    //   263: invokevirtual 137	java/io/BufferedOutputStream:write	([BII)V
    //   266: goto -28 -> 238
    //   269: aload 8
    //   271: invokevirtual 140	com/tencent/shadow/core/b/a/k:closeEntry	()V
    //   274: aload 6
    //   276: invokevirtual 143	java/io/BufferedOutputStream:close	()V
    //   279: goto -123 -> 156
    //   282: aload 8
    //   284: invokevirtual 140	com/tencent/shadow/core/b/a/k:closeEntry	()V
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 143	java/io/BufferedOutputStream:close	()V
    //   295: aload_2
    //   296: athrow
    //   297: aload_2
    //   298: invokevirtual 146	java/io/File:createNewFile	()Z
    //   301: pop
    //   302: aload 8
    //   304: invokevirtual 147	com/tencent/shadow/core/b/a/k:close	()V
    //   307: goto +15 -> 322
    //   310: astore_0
    //   311: getstatic 19	com/tencent/shadow/core/b/a/b:a	Lcom/tencent/shadow/core/common/Logger;
    //   314: ldc 149
    //   316: aload_0
    //   317: invokeinterface 155 3 0
    //   322: aload 7
    //   324: monitorexit
    //   325: aload_1
    //   326: areturn
    //   327: astore_1
    //   328: new 62	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   335: astore 6
    //   337: aload 6
    //   339: ldc 157
    //   341: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 6
    //   347: aload_2
    //   348: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   351: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: new 73	com/tencent/shadow/core/b/a/c
    //   358: dup
    //   359: aload 6
    //   361: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: aload_1
    //   365: invokespecial 159	com/tencent/shadow/core/b/a/c:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   368: athrow
    //   369: astore_0
    //   370: goto +96 -> 466
    //   373: astore_2
    //   374: aload 8
    //   376: astore_1
    //   377: goto +15 -> 392
    //   380: astore_0
    //   381: aload 6
    //   383: astore 8
    //   385: goto +81 -> 466
    //   388: astore_2
    //   389: aload 10
    //   391: astore_1
    //   392: aload_1
    //   393: astore 6
    //   395: new 62	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   402: astore 8
    //   404: aload_1
    //   405: astore 6
    //   407: aload 8
    //   409: ldc 161
    //   411: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_1
    //   416: astore 6
    //   418: aload 8
    //   420: aload_0
    //   421: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   424: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload_1
    //   429: astore 6
    //   431: aload 8
    //   433: ldc 163
    //   435: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload_1
    //   440: astore 6
    //   442: aload 8
    //   444: aload_3
    //   445: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_1
    //   450: astore 6
    //   452: new 73	com/tencent/shadow/core/b/a/c
    //   455: dup
    //   456: aload 8
    //   458: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: aload_2
    //   462: invokespecial 159	com/tencent/shadow/core/b/a/c:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   465: athrow
    //   466: aload 8
    //   468: ifnull +23 -> 491
    //   471: aload 8
    //   473: invokevirtual 147	com/tencent/shadow/core/b/a/k:close	()V
    //   476: goto +15 -> 491
    //   479: astore_1
    //   480: getstatic 19	com/tencent/shadow/core/b/a/b:a	Lcom/tencent/shadow/core/common/Logger;
    //   483: ldc 149
    //   485: aload_1
    //   486: invokeinterface 155 3 0
    //   491: aload_0
    //   492: athrow
    //   493: aload 7
    //   495: monitorexit
    //   496: aload_1
    //   497: areturn
    //   498: astore_0
    //   499: aload 7
    //   501: monitorexit
    //   502: aload_0
    //   503: athrow
    //   504: astore_2
    //   505: aload 6
    //   507: astore_1
    //   508: goto -226 -> 282
    //   511: astore_2
    //   512: aload 9
    //   514: astore_1
    //   515: goto -233 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramFile1	java.io.File
    //   0	518	1	paramFile2	java.io.File
    //   0	518	2	paramFile3	java.io.File
    //   0	518	3	paramString	String
    //   249	13	4	i	int
    //   177	3	5	bool	boolean
    //   14	492	6	localObject1	Object
    //   18	482	7	localObject2	Object
    //   4	468	8	localObject3	Object
    //   137	376	9	localObject4	Object
    //   134	256	10	localBufferedInputStream	java.io.BufferedInputStream
    //   236	23	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   302	307	310	java/io/IOException
    //   297	302	327	java/io/IOException
    //   156	163	369	finally
    //   168	179	369	finally
    //   269	279	369	finally
    //   282	287	369	finally
    //   291	295	369	finally
    //   295	297	369	finally
    //   297	302	369	finally
    //   328	369	369	finally
    //   156	163	373	java/lang/Exception
    //   168	179	373	java/lang/Exception
    //   269	279	373	java/lang/Exception
    //   282	287	373	java/lang/Exception
    //   291	295	373	java/lang/Exception
    //   295	297	373	java/lang/Exception
    //   297	302	373	java/lang/Exception
    //   328	369	373	java/lang/Exception
    //   139	156	380	finally
    //   395	404	380	finally
    //   407	415	380	finally
    //   418	428	380	finally
    //   431	439	380	finally
    //   442	449	380	finally
    //   452	466	380	finally
    //   139	156	388	java/lang/Exception
    //   471	476	479	java/io/IOException
    //   48	62	498	finally
    //   65	79	498	finally
    //   82	125	498	finally
    //   125	130	498	finally
    //   302	307	498	finally
    //   311	322	498	finally
    //   322	325	498	finally
    //   471	476	498	finally
    //   480	491	498	finally
    //   491	493	498	finally
    //   493	496	498	finally
    //   499	502	498	finally
    //   220	238	504	finally
    //   238	251	504	finally
    //   256	266	504	finally
    //   184	220	511	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */