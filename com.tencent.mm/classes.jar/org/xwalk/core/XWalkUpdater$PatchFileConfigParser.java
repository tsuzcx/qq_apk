package org.xwalk.core;

public class XWalkUpdater$PatchFileConfigParser
{
  private static final String ADD_FLAG = "ADD:";
  private static final int ADD_TYPE = 1;
  private static final int APK_FILE_TYPE = 1;
  private static final String DEL_FLAG = "DEL:";
  private static final int DEL_TYPE = 3;
  private static final int EXTRACTED_FILE_TYPE = 2;
  private static final String MOD_FLAG = "MOD:";
  private static final int MOD_TYPE = 2;
  private static final String PATCH_SUFFIX = ".patch";
  
  /* Error */
  public static java.util.ArrayList<XWalkUpdater.PatchFileConfig> getPatchFileConfigList(int paramInt)
  {
    // Byte code:
    //   0: ldc 39
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 47	java/io/FileInputStream
    //   8: dup
    //   9: new 49	java/io/File
    //   12: dup
    //   13: iload_0
    //   14: invokestatic 55	org/xwalk/core/XWalkEnvironment:getPatchConfig	(I)Ljava/lang/String;
    //   17: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore 6
    //   25: new 63	java/io/InputStreamReader
    //   28: dup
    //   29: aload 6
    //   31: invokespecial 66	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: astore 5
    //   36: new 68	java/io/BufferedReader
    //   39: dup
    //   40: aload 5
    //   42: invokespecial 71	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore 4
    //   47: aload 4
    //   49: astore 9
    //   51: aload 5
    //   53: astore 8
    //   55: aload 6
    //   57: astore 7
    //   59: new 73	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 74	java/util/ArrayList:<init>	()V
    //   66: astore 10
    //   68: aload 4
    //   70: astore 9
    //   72: aload 5
    //   74: astore 8
    //   76: aload 6
    //   78: astore 7
    //   80: aload 4
    //   82: invokevirtual 78	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +524 -> 611
    //   90: aload_3
    //   91: ifnull -23 -> 68
    //   94: aload 4
    //   96: astore 9
    //   98: aload 5
    //   100: astore 8
    //   102: aload 6
    //   104: astore 7
    //   106: aload_3
    //   107: invokevirtual 84	java/lang/String:isEmpty	()Z
    //   110: ifne -42 -> 68
    //   113: aload 4
    //   115: astore 9
    //   117: aload 5
    //   119: astore 8
    //   121: aload 6
    //   123: astore 7
    //   125: aload_3
    //   126: ldc 11
    //   128: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   131: ifeq +305 -> 436
    //   134: aload 4
    //   136: astore 9
    //   138: aload 5
    //   140: astore 8
    //   142: aload 6
    //   144: astore 7
    //   146: aload_3
    //   147: iconst_4
    //   148: invokevirtual 91	java/lang/String:substring	(I)Ljava/lang/String;
    //   151: astore_3
    //   152: iconst_1
    //   153: istore_0
    //   154: aload 4
    //   156: astore 9
    //   158: aload 5
    //   160: astore 8
    //   162: aload 6
    //   164: astore 7
    //   166: aload_3
    //   167: ldc 93
    //   169: invokevirtual 97	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   172: astore_3
    //   173: aload 4
    //   175: astore 9
    //   177: aload 5
    //   179: astore 8
    //   181: aload 6
    //   183: astore 7
    //   185: aload_3
    //   186: arraylength
    //   187: istore_2
    //   188: iconst_0
    //   189: istore_1
    //   190: iload_1
    //   191: iload_2
    //   192: if_icmpge -124 -> 68
    //   195: aload_3
    //   196: iload_1
    //   197: aaload
    //   198: astore 11
    //   200: aload 11
    //   202: ifnull +532 -> 734
    //   205: aload 4
    //   207: astore 9
    //   209: aload 5
    //   211: astore 8
    //   213: aload 6
    //   215: astore 7
    //   217: aload 11
    //   219: invokevirtual 84	java/lang/String:isEmpty	()Z
    //   222: ifne +512 -> 734
    //   225: aload 4
    //   227: astore 9
    //   229: aload 5
    //   231: astore 8
    //   233: aload 6
    //   235: astore 7
    //   237: new 99	org/xwalk/core/XWalkUpdater$PatchFileConfig
    //   240: dup
    //   241: invokespecial 100	org/xwalk/core/XWalkUpdater$PatchFileConfig:<init>	()V
    //   244: astore 12
    //   246: aload 4
    //   248: astore 9
    //   250: aload 5
    //   252: astore 8
    //   254: aload 6
    //   256: astore 7
    //   258: aload 12
    //   260: aload 11
    //   262: putfield 103	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
    //   265: aload 4
    //   267: astore 9
    //   269: aload 5
    //   271: astore 8
    //   273: aload 6
    //   275: astore 7
    //   277: aload 12
    //   279: iload_0
    //   280: putfield 106	org/xwalk/core/XWalkUpdater$PatchFileConfig:type	I
    //   283: iload_0
    //   284: iconst_2
    //   285: if_icmpne +43 -> 328
    //   288: aload 4
    //   290: astore 9
    //   292: aload 5
    //   294: astore 8
    //   296: aload 6
    //   298: astore 7
    //   300: aload 12
    //   302: new 108	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   309: aload 12
    //   311: getfield 103	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
    //   314: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 29
    //   319: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: putfield 119	org/xwalk/core/XWalkUpdater$PatchFileConfig:patchFileName	Ljava/lang/String;
    //   328: iload_0
    //   329: iconst_2
    //   330: if_icmpne +194 -> 524
    //   333: aload 4
    //   335: astore 9
    //   337: aload 5
    //   339: astore 8
    //   341: aload 6
    //   343: astore 7
    //   345: aload 12
    //   347: getfield 103	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
    //   350: ldc 121
    //   352: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +169 -> 524
    //   358: aload 4
    //   360: astore 9
    //   362: aload 5
    //   364: astore 8
    //   366: aload 6
    //   368: astore 7
    //   370: aload 12
    //   372: iconst_1
    //   373: putfield 128	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileType	I
    //   376: aload 4
    //   378: astore 9
    //   380: aload 5
    //   382: astore 8
    //   384: aload 6
    //   386: astore 7
    //   388: ldc 130
    //   390: new 108	java/lang/StringBuilder
    //   393: dup
    //   394: ldc 132
    //   396: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   399: aload 12
    //   401: invokevirtual 134	org/xwalk/core/XWalkUpdater$PatchFileConfig:toString	()Ljava/lang/String;
    //   404: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 140	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload 4
    //   415: astore 9
    //   417: aload 5
    //   419: astore 8
    //   421: aload 6
    //   423: astore 7
    //   425: aload 10
    //   427: aload 12
    //   429: invokevirtual 143	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   432: pop
    //   433: goto +301 -> 734
    //   436: aload 4
    //   438: astore 9
    //   440: aload 5
    //   442: astore 8
    //   444: aload 6
    //   446: astore 7
    //   448: aload_3
    //   449: ldc 25
    //   451: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   454: ifeq +26 -> 480
    //   457: aload 4
    //   459: astore 9
    //   461: aload 5
    //   463: astore 8
    //   465: aload 6
    //   467: astore 7
    //   469: aload_3
    //   470: iconst_4
    //   471: invokevirtual 91	java/lang/String:substring	(I)Ljava/lang/String;
    //   474: astore_3
    //   475: iconst_2
    //   476: istore_0
    //   477: goto -323 -> 154
    //   480: aload 4
    //   482: astore 9
    //   484: aload 5
    //   486: astore 8
    //   488: aload 6
    //   490: astore 7
    //   492: aload_3
    //   493: ldc 18
    //   495: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   498: ifeq +231 -> 729
    //   501: aload 4
    //   503: astore 9
    //   505: aload 5
    //   507: astore 8
    //   509: aload 6
    //   511: astore 7
    //   513: aload_3
    //   514: iconst_4
    //   515: invokevirtual 91	java/lang/String:substring	(I)Ljava/lang/String;
    //   518: astore_3
    //   519: iconst_3
    //   520: istore_0
    //   521: goto -367 -> 154
    //   524: aload 4
    //   526: astore 9
    //   528: aload 5
    //   530: astore 8
    //   532: aload 6
    //   534: astore 7
    //   536: aload 12
    //   538: iconst_2
    //   539: putfield 128	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileType	I
    //   542: goto -166 -> 376
    //   545: astore 7
    //   547: aload 4
    //   549: astore_3
    //   550: aload 7
    //   552: astore 4
    //   554: aload_3
    //   555: astore 9
    //   557: aload 5
    //   559: astore 8
    //   561: aload 6
    //   563: astore 7
    //   565: ldc 130
    //   567: new 108	java/lang/StringBuilder
    //   570: dup
    //   571: ldc 145
    //   573: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   576: aload 4
    //   578: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   581: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 151	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload 6
    //   592: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   595: aload 5
    //   597: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   600: aload_3
    //   601: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   604: ldc 39
    //   606: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   609: aconst_null
    //   610: areturn
    //   611: aload 6
    //   613: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   616: aload 5
    //   618: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   621: aload 4
    //   623: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   626: ldc 39
    //   628: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   631: aload 10
    //   633: areturn
    //   634: astore_3
    //   635: aconst_null
    //   636: astore 4
    //   638: aconst_null
    //   639: astore 5
    //   641: aconst_null
    //   642: astore 6
    //   644: aload 6
    //   646: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   649: aload 5
    //   651: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   654: aload 4
    //   656: invokestatic 157	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   659: ldc 39
    //   661: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   664: aload_3
    //   665: athrow
    //   666: astore_3
    //   667: aconst_null
    //   668: astore 4
    //   670: aconst_null
    //   671: astore 5
    //   673: goto -29 -> 644
    //   676: astore_3
    //   677: aconst_null
    //   678: astore 4
    //   680: goto -36 -> 644
    //   683: astore_3
    //   684: aload 9
    //   686: astore 4
    //   688: aload 8
    //   690: astore 5
    //   692: aload 7
    //   694: astore 6
    //   696: goto -52 -> 644
    //   699: astore 4
    //   701: aconst_null
    //   702: astore_3
    //   703: aconst_null
    //   704: astore 5
    //   706: aconst_null
    //   707: astore 6
    //   709: goto -155 -> 554
    //   712: astore 4
    //   714: aconst_null
    //   715: astore_3
    //   716: aconst_null
    //   717: astore 5
    //   719: goto -165 -> 554
    //   722: astore 4
    //   724: aconst_null
    //   725: astore_3
    //   726: goto -172 -> 554
    //   729: iconst_0
    //   730: istore_0
    //   731: goto -577 -> 154
    //   734: iload_1
    //   735: iconst_1
    //   736: iadd
    //   737: istore_1
    //   738: goto -548 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	741	0	paramInt	int
    //   189	549	1	i	int
    //   187	6	2	j	int
    //   85	516	3	localObject1	Object
    //   634	31	3	localObject2	Object
    //   666	1	3	localObject3	Object
    //   676	1	3	localObject4	Object
    //   683	1	3	localObject5	Object
    //   702	24	3	localObject6	Object
    //   45	642	4	localObject7	Object
    //   699	1	4	localException1	java.lang.Exception
    //   712	1	4	localException2	java.lang.Exception
    //   722	1	4	localException3	java.lang.Exception
    //   34	684	5	localObject8	Object
    //   23	685	6	localObject9	Object
    //   57	478	7	localObject10	Object
    //   545	6	7	localException4	java.lang.Exception
    //   563	130	7	localObject11	Object
    //   53	636	8	localObject12	Object
    //   49	636	9	localObject13	Object
    //   66	566	10	localArrayList	java.util.ArrayList
    //   198	63	11	localObject14	Object
    //   244	293	12	localPatchFileConfig	XWalkUpdater.PatchFileConfig
    // Exception table:
    //   from	to	target	type
    //   59	68	545	java/lang/Exception
    //   80	86	545	java/lang/Exception
    //   106	113	545	java/lang/Exception
    //   125	134	545	java/lang/Exception
    //   146	152	545	java/lang/Exception
    //   166	173	545	java/lang/Exception
    //   185	188	545	java/lang/Exception
    //   217	225	545	java/lang/Exception
    //   237	246	545	java/lang/Exception
    //   258	265	545	java/lang/Exception
    //   277	283	545	java/lang/Exception
    //   300	328	545	java/lang/Exception
    //   345	358	545	java/lang/Exception
    //   370	376	545	java/lang/Exception
    //   388	413	545	java/lang/Exception
    //   425	433	545	java/lang/Exception
    //   448	457	545	java/lang/Exception
    //   469	475	545	java/lang/Exception
    //   492	501	545	java/lang/Exception
    //   513	519	545	java/lang/Exception
    //   536	542	545	java/lang/Exception
    //   5	25	634	finally
    //   25	36	666	finally
    //   36	47	676	finally
    //   59	68	683	finally
    //   80	86	683	finally
    //   106	113	683	finally
    //   125	134	683	finally
    //   146	152	683	finally
    //   166	173	683	finally
    //   185	188	683	finally
    //   217	225	683	finally
    //   237	246	683	finally
    //   258	265	683	finally
    //   277	283	683	finally
    //   300	328	683	finally
    //   345	358	683	finally
    //   370	376	683	finally
    //   388	413	683	finally
    //   425	433	683	finally
    //   448	457	683	finally
    //   469	475	683	finally
    //   492	501	683	finally
    //   513	519	683	finally
    //   536	542	683	finally
    //   565	590	683	finally
    //   5	25	699	java/lang/Exception
    //   25	36	712	java/lang/Exception
    //   36	47	722	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.PatchFileConfigParser
 * JD-Core Version:    0.7.0.1
 */