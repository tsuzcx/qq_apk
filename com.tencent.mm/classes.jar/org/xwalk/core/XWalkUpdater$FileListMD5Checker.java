package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.d;
import java.io.File;

public class XWalkUpdater$FileListMD5Checker
{
  /* Error */
  public static boolean checkFileListMd5(int paramInt, File paramFile)
  {
    // Byte code:
    //   0: ldc 17
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 17
    //   11: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: iconst_0
    //   15: ireturn
    //   16: new 28	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore 4
    //   26: new 33	java/io/InputStreamReader
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 36	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   35: astore_3
    //   36: new 38	java/io/BufferedReader
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_1
    //   45: aload_1
    //   46: astore 7
    //   48: aload_3
    //   49: astore 6
    //   51: aload 4
    //   53: astore 5
    //   55: aload_1
    //   56: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +231 -> 292
    //   64: aload_2
    //   65: ifnull -20 -> 45
    //   68: aload_1
    //   69: astore 7
    //   71: aload_3
    //   72: astore 6
    //   74: aload 4
    //   76: astore 5
    //   78: aload_2
    //   79: invokevirtual 51	java/lang/String:isEmpty	()Z
    //   82: ifne -37 -> 45
    //   85: aload_1
    //   86: astore 7
    //   88: aload_3
    //   89: astore 6
    //   91: aload 4
    //   93: astore 5
    //   95: aload_2
    //   96: ldc 53
    //   98: invokevirtual 57	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull -58 -> 45
    //   106: aload_1
    //   107: astore 7
    //   109: aload_3
    //   110: astore 6
    //   112: aload 4
    //   114: astore 5
    //   116: aload_2
    //   117: arraylength
    //   118: iconst_2
    //   119: if_icmpne -74 -> 45
    //   122: aload_2
    //   123: iconst_0
    //   124: aaload
    //   125: ifnull -80 -> 45
    //   128: aload_1
    //   129: astore 7
    //   131: aload_3
    //   132: astore 6
    //   134: aload 4
    //   136: astore 5
    //   138: aload_2
    //   139: iconst_0
    //   140: aaload
    //   141: invokevirtual 51	java/lang/String:isEmpty	()Z
    //   144: ifne -99 -> 45
    //   147: aload_2
    //   148: iconst_1
    //   149: aaload
    //   150: ifnull -105 -> 45
    //   153: aload_1
    //   154: astore 7
    //   156: aload_3
    //   157: astore 6
    //   159: aload 4
    //   161: astore 5
    //   163: aload_2
    //   164: iconst_1
    //   165: aaload
    //   166: invokevirtual 51	java/lang/String:isEmpty	()Z
    //   169: ifne -124 -> 45
    //   172: aload_1
    //   173: astore 7
    //   175: aload_3
    //   176: astore 6
    //   178: aload 4
    //   180: astore 5
    //   182: iload_0
    //   183: aload_2
    //   184: iconst_0
    //   185: aaload
    //   186: aload_2
    //   187: iconst_1
    //   188: aaload
    //   189: invokestatic 61	org/xwalk/core/XWalkUpdater$FileListMD5Checker:checkFileMd5	(ILjava/lang/String;Ljava/lang/String;)Z
    //   192: ifne -147 -> 45
    //   195: aload_1
    //   196: astore 7
    //   198: aload_3
    //   199: astore 6
    //   201: aload 4
    //   203: astore 5
    //   205: ldc 63
    //   207: new 65	java/lang/StringBuilder
    //   210: dup
    //   211: ldc 67
    //   213: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload_2
    //   217: iconst_0
    //   218: aaload
    //   219: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc 76
    //   224: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_2
    //   228: iconst_1
    //   229: aaload
    //   230: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 4
    //   241: invokevirtual 88	java/io/FileInputStream:close	()V
    //   244: aload_3
    //   245: invokevirtual 89	java/io/InputStreamReader:close	()V
    //   248: aload_1
    //   249: invokevirtual 90	java/io/BufferedReader:close	()V
    //   252: ldc 17
    //   254: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_2
    //   260: ldc 63
    //   262: ldc 92
    //   264: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: goto -23 -> 244
    //   270: astore_2
    //   271: ldc 63
    //   273: ldc 94
    //   275: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: goto -30 -> 248
    //   281: astore_1
    //   282: ldc 63
    //   284: ldc 96
    //   286: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: goto -37 -> 252
    //   292: aload 4
    //   294: invokevirtual 88	java/io/FileInputStream:close	()V
    //   297: aload_3
    //   298: invokevirtual 89	java/io/InputStreamReader:close	()V
    //   301: aload_1
    //   302: invokevirtual 90	java/io/BufferedReader:close	()V
    //   305: ldc 17
    //   307: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: iconst_1
    //   311: ireturn
    //   312: astore_2
    //   313: ldc 63
    //   315: ldc 92
    //   317: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: goto -23 -> 297
    //   323: astore_2
    //   324: ldc 63
    //   326: ldc 94
    //   328: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: goto -30 -> 301
    //   334: astore_1
    //   335: ldc 63
    //   337: ldc 96
    //   339: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: goto -37 -> 305
    //   345: astore_2
    //   346: aconst_null
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_3
    //   350: aconst_null
    //   351: astore 4
    //   353: aload_1
    //   354: astore 7
    //   356: aload_3
    //   357: astore 6
    //   359: aload 4
    //   361: astore 5
    //   363: ldc 63
    //   365: new 65	java/lang/StringBuilder
    //   368: dup
    //   369: ldc 98
    //   371: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   374: aload_2
    //   375: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   378: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload 4
    //   389: ifnull +8 -> 397
    //   392: aload 4
    //   394: invokevirtual 88	java/io/FileInputStream:close	()V
    //   397: aload_3
    //   398: ifnull +7 -> 405
    //   401: aload_3
    //   402: invokevirtual 89	java/io/InputStreamReader:close	()V
    //   405: aload_1
    //   406: ifnull +7 -> 413
    //   409: aload_1
    //   410: invokevirtual 90	java/io/BufferedReader:close	()V
    //   413: ldc 17
    //   415: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: iconst_0
    //   419: ireturn
    //   420: astore_2
    //   421: ldc 63
    //   423: ldc 92
    //   425: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: goto -31 -> 397
    //   431: astore_2
    //   432: ldc 63
    //   434: ldc 94
    //   436: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: goto -34 -> 405
    //   442: astore_1
    //   443: ldc 63
    //   445: ldc 96
    //   447: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: goto -37 -> 413
    //   453: astore_1
    //   454: aconst_null
    //   455: astore_2
    //   456: aconst_null
    //   457: astore_3
    //   458: aconst_null
    //   459: astore 4
    //   461: aload 4
    //   463: ifnull +8 -> 471
    //   466: aload 4
    //   468: invokevirtual 88	java/io/FileInputStream:close	()V
    //   471: aload_3
    //   472: ifnull +7 -> 479
    //   475: aload_3
    //   476: invokevirtual 89	java/io/InputStreamReader:close	()V
    //   479: aload_2
    //   480: ifnull +7 -> 487
    //   483: aload_2
    //   484: invokevirtual 90	java/io/BufferedReader:close	()V
    //   487: ldc 17
    //   489: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   492: aload_1
    //   493: athrow
    //   494: astore 4
    //   496: ldc 63
    //   498: ldc 92
    //   500: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: goto -32 -> 471
    //   506: astore_3
    //   507: ldc 63
    //   509: ldc 94
    //   511: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -35 -> 479
    //   517: astore_2
    //   518: ldc 63
    //   520: ldc 96
    //   522: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: goto -38 -> 487
    //   528: astore_1
    //   529: aconst_null
    //   530: astore_2
    //   531: aconst_null
    //   532: astore_3
    //   533: goto -72 -> 461
    //   536: astore_1
    //   537: aconst_null
    //   538: astore_2
    //   539: goto -78 -> 461
    //   542: astore_1
    //   543: aload 7
    //   545: astore_2
    //   546: aload 6
    //   548: astore_3
    //   549: aload 5
    //   551: astore 4
    //   553: goto -92 -> 461
    //   556: astore_2
    //   557: aconst_null
    //   558: astore_1
    //   559: aconst_null
    //   560: astore_3
    //   561: goto -208 -> 353
    //   564: astore_2
    //   565: aconst_null
    //   566: astore_1
    //   567: goto -214 -> 353
    //   570: astore_2
    //   571: goto -218 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	paramInt	int
    //   0	574	1	paramFile	File
    //   59	169	2	localObject1	Object
    //   259	1	2	localException1	Exception
    //   270	1	2	localException2	Exception
    //   312	1	2	localException3	Exception
    //   323	1	2	localException4	Exception
    //   345	30	2	localException5	Exception
    //   420	1	2	localException6	Exception
    //   431	1	2	localException7	Exception
    //   455	29	2	localObject2	Object
    //   517	1	2	localException8	Exception
    //   530	16	2	localFile1	File
    //   556	1	2	localException9	Exception
    //   564	1	2	localException10	Exception
    //   570	1	2	localException11	Exception
    //   35	441	3	localInputStreamReader1	java.io.InputStreamReader
    //   506	1	3	localException12	Exception
    //   532	29	3	localObject3	Object
    //   24	443	4	localFileInputStream1	java.io.FileInputStream
    //   494	1	4	localException13	Exception
    //   551	1	4	localObject4	Object
    //   53	497	5	localFileInputStream2	java.io.FileInputStream
    //   49	498	6	localInputStreamReader2	java.io.InputStreamReader
    //   46	498	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   239	244	259	java/lang/Exception
    //   244	248	270	java/lang/Exception
    //   248	252	281	java/lang/Exception
    //   292	297	312	java/lang/Exception
    //   297	301	323	java/lang/Exception
    //   301	305	334	java/lang/Exception
    //   16	26	345	java/lang/Exception
    //   392	397	420	java/lang/Exception
    //   401	405	431	java/lang/Exception
    //   409	413	442	java/lang/Exception
    //   16	26	453	finally
    //   466	471	494	java/lang/Exception
    //   475	479	506	java/lang/Exception
    //   483	487	517	java/lang/Exception
    //   26	36	528	finally
    //   36	45	536	finally
    //   55	60	542	finally
    //   78	85	542	finally
    //   95	102	542	finally
    //   116	122	542	finally
    //   138	147	542	finally
    //   163	172	542	finally
    //   182	195	542	finally
    //   205	239	542	finally
    //   363	387	542	finally
    //   26	36	556	java/lang/Exception
    //   36	45	564	java/lang/Exception
    //   55	60	570	java/lang/Exception
    //   78	85	570	java/lang/Exception
    //   95	102	570	java/lang/Exception
    //   116	122	570	java/lang/Exception
    //   138	147	570	java/lang/Exception
    //   163	172	570	java/lang/Exception
    //   182	195	570	java/lang/Exception
    //   205	239	570	java/lang/Exception
  }
  
  public static boolean checkFileListMd5(int paramInt, String paramString)
  {
    AppMethodBeat.i(155011);
    try
    {
      boolean bool = checkFileListMd5(paramInt, new File(paramString));
      AppMethodBeat.o(155011);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkLib", "checkFileListMd5 error:" + paramString.getMessage());
      AppMethodBeat.o(155011);
    }
    return false;
  }
  
  private static boolean checkFileMd5(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(155012);
    if ("base.apk".equals(paramString1)) {}
    for (paramString1 = XWalkEnvironment.getDownloadApkPath(paramInt); d.oi(paramString1, paramString2); paramString1 = XWalkEnvironment.getExtractedCoreFile(paramInt, paramString1))
    {
      Log.i("XWalkLib", "checkFileMd5 successful path:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(155012);
      return true;
    }
    Log.e("XWalkLib", "checkFileMd5 error path:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(155012);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.FileListMD5Checker
 * JD-Core Version:    0.7.0.1
 */