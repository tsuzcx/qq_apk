package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class y
{
  private boolean epJ;
  private String filePath;
  private Map<Integer, Object> values;
  public boolean yxb;
  public boolean yxc;
  
  public y(String paramString)
  {
    AppMethodBeat.i(58952);
    this.epJ = false;
    this.filePath = "";
    this.yxb = false;
    this.yxc = false;
    if (!new File(paramString).exists()) {
      ab.e("MicroMsg.ConfigFileStorage", "ConfigFileStorage not exit path[%s]", new Object[] { paramString });
    }
    this.filePath = paramString;
    dwv();
    this.epJ = false;
    AppMethodBeat.o(58952);
  }
  
  /* Error */
  private void Ln()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 68
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 74	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   10: lstore_1
    //   11: new 76	java/io/FileOutputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 31	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   19: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_3
    //   23: new 79	java/io/ObjectOutputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 82	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 6
    //   33: aload 6
    //   35: astore 5
    //   37: aload_3
    //   38: astore 4
    //   40: aload 6
    //   42: aload_0
    //   43: getfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   46: invokevirtual 88	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   49: aload 6
    //   51: astore 5
    //   53: aload_3
    //   54: astore 4
    //   56: aload_3
    //   57: invokevirtual 91	java/io/FileOutputStream:flush	()V
    //   60: aload 6
    //   62: astore 5
    //   64: aload_3
    //   65: astore 4
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 35	com/tencent/mm/storage/y:yxc	Z
    //   72: aload 6
    //   74: astore 5
    //   76: aload_3
    //   77: astore 4
    //   79: ldc 45
    //   81: ldc 93
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: getfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   93: invokeinterface 99 1 0
    //   98: invokeinterface 105 1 0
    //   103: arraylength
    //   104: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: lload_1
    //   111: invokestatic 115	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   114: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   117: aastore
    //   118: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload 6
    //   123: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   126: aload_3
    //   127: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   130: ldc 68
    //   132: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: astore_3
    //   139: ldc 68
    //   141: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: goto -9 -> 135
    //   147: astore_3
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_3
    //   151: athrow
    //   152: astore 7
    //   154: aconst_null
    //   155: astore 6
    //   157: aconst_null
    //   158: astore_3
    //   159: aload 6
    //   161: astore 5
    //   163: aload_3
    //   164: astore 4
    //   166: ldc 45
    //   168: aload 7
    //   170: ldc 129
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload 6
    //   181: astore 5
    //   183: aload_3
    //   184: astore 4
    //   186: aload_0
    //   187: bipush 28
    //   189: invokespecial 136	com/tencent/mm/storage/y:kS	(I)V
    //   192: aload 6
    //   194: astore 5
    //   196: aload_3
    //   197: astore 4
    //   199: aload_0
    //   200: iconst_1
    //   201: putfield 35	com/tencent/mm/storage/y:yxc	Z
    //   204: aload 6
    //   206: ifnull +8 -> 214
    //   209: aload 6
    //   211: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   214: aload_3
    //   215: ifnull +7 -> 222
    //   218: aload_3
    //   219: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   222: ldc 68
    //   224: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: goto -92 -> 135
    //   230: astore_3
    //   231: ldc 68
    //   233: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: goto -101 -> 135
    //   239: astore 7
    //   241: aconst_null
    //   242: astore 6
    //   244: aconst_null
    //   245: astore_3
    //   246: aload 6
    //   248: astore 5
    //   250: aload_3
    //   251: astore 4
    //   253: ldc 45
    //   255: ldc 138
    //   257: iconst_1
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload 7
    //   265: invokestatic 142	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   268: aastore
    //   269: invokestatic 53	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aload 6
    //   274: astore 5
    //   276: aload_3
    //   277: astore 4
    //   279: ldc 45
    //   281: aload 7
    //   283: ldc 144
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: aload 6
    //   294: astore 5
    //   296: aload_3
    //   297: astore 4
    //   299: aload_0
    //   300: bipush 19
    //   302: invokespecial 136	com/tencent/mm/storage/y:kS	(I)V
    //   305: aload 6
    //   307: astore 5
    //   309: aload_3
    //   310: astore 4
    //   312: aload_0
    //   313: iconst_1
    //   314: putfield 35	com/tencent/mm/storage/y:yxc	Z
    //   317: aload 6
    //   319: ifnull +8 -> 327
    //   322: aload 6
    //   324: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   327: aload_3
    //   328: ifnull +7 -> 335
    //   331: aload_3
    //   332: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   335: ldc 68
    //   337: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: goto -205 -> 135
    //   343: astore_3
    //   344: ldc 68
    //   346: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: goto -214 -> 135
    //   352: astore 7
    //   354: aconst_null
    //   355: astore 6
    //   357: aconst_null
    //   358: astore_3
    //   359: aload 6
    //   361: astore 5
    //   363: aload_3
    //   364: astore 4
    //   366: ldc 45
    //   368: aload 7
    //   370: ldc 146
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   379: aload 6
    //   381: astore 5
    //   383: aload_3
    //   384: astore 4
    //   386: aload_0
    //   387: bipush 29
    //   389: invokespecial 136	com/tencent/mm/storage/y:kS	(I)V
    //   392: aload 6
    //   394: astore 5
    //   396: aload_3
    //   397: astore 4
    //   399: aload_0
    //   400: iconst_1
    //   401: putfield 35	com/tencent/mm/storage/y:yxc	Z
    //   404: aload 6
    //   406: ifnull +8 -> 414
    //   409: aload 6
    //   411: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   414: aload_3
    //   415: ifnull +7 -> 422
    //   418: aload_3
    //   419: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   422: ldc 68
    //   424: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: goto -292 -> 135
    //   430: astore_3
    //   431: ldc 68
    //   433: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: goto -301 -> 135
    //   439: astore 6
    //   441: aconst_null
    //   442: astore 5
    //   444: aconst_null
    //   445: astore_3
    //   446: aload 5
    //   448: ifnull +8 -> 456
    //   451: aload 5
    //   453: invokevirtual 126	java/io/ObjectOutputStream:close	()V
    //   456: aload_3
    //   457: ifnull +7 -> 464
    //   460: aload_3
    //   461: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   464: ldc 68
    //   466: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   469: aload 6
    //   471: athrow
    //   472: astore_3
    //   473: goto -9 -> 464
    //   476: astore 6
    //   478: aconst_null
    //   479: astore 5
    //   481: goto -35 -> 446
    //   484: astore 6
    //   486: aload 4
    //   488: astore_3
    //   489: goto -43 -> 446
    //   492: astore 7
    //   494: aconst_null
    //   495: astore 6
    //   497: goto -138 -> 359
    //   500: astore 7
    //   502: goto -143 -> 359
    //   505: astore 7
    //   507: aconst_null
    //   508: astore 6
    //   510: goto -264 -> 246
    //   513: astore 7
    //   515: goto -269 -> 246
    //   518: astore 7
    //   520: aconst_null
    //   521: astore 6
    //   523: goto -364 -> 159
    //   526: astore 7
    //   528: goto -369 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	y
    //   10	101	1	l	long
    //   22	105	3	localFileOutputStream	java.io.FileOutputStream
    //   138	1	3	localException1	java.lang.Exception
    //   147	4	3	localObject1	Object
    //   158	61	3	localObject2	Object
    //   230	1	3	localException2	java.lang.Exception
    //   245	87	3	localObject3	Object
    //   343	1	3	localException3	java.lang.Exception
    //   358	61	3	localObject4	Object
    //   430	1	3	localException4	java.lang.Exception
    //   445	16	3	localObject5	Object
    //   472	1	3	localException5	java.lang.Exception
    //   488	1	3	localObject6	Object
    //   38	449	4	localObject7	Object
    //   35	445	5	localObjectOutputStream1	java.io.ObjectOutputStream
    //   31	379	6	localObjectOutputStream2	java.io.ObjectOutputStream
    //   439	31	6	localObject8	Object
    //   476	1	6	localObject9	Object
    //   484	1	6	localObject10	Object
    //   495	27	6	localObject11	Object
    //   152	17	7	localConcurrentModificationException1	java.util.ConcurrentModificationException
    //   239	43	7	localIOException1	java.io.IOException
    //   352	17	7	localException6	java.lang.Exception
    //   492	1	7	localException7	java.lang.Exception
    //   500	1	7	localException8	java.lang.Exception
    //   505	1	7	localIOException2	java.io.IOException
    //   513	1	7	localIOException3	java.io.IOException
    //   518	1	7	localConcurrentModificationException2	java.util.ConcurrentModificationException
    //   526	1	7	localConcurrentModificationException3	java.util.ConcurrentModificationException
    // Exception table:
    //   from	to	target	type
    //   121	130	138	java/lang/Exception
    //   2	7	147	finally
    //   121	130	147	finally
    //   130	135	147	finally
    //   139	144	147	finally
    //   209	214	147	finally
    //   218	222	147	finally
    //   222	227	147	finally
    //   231	236	147	finally
    //   322	327	147	finally
    //   331	335	147	finally
    //   335	340	147	finally
    //   344	349	147	finally
    //   409	414	147	finally
    //   418	422	147	finally
    //   422	427	147	finally
    //   431	436	147	finally
    //   451	456	147	finally
    //   460	464	147	finally
    //   464	472	147	finally
    //   7	23	152	java/util/ConcurrentModificationException
    //   209	214	230	java/lang/Exception
    //   218	222	230	java/lang/Exception
    //   7	23	239	java/io/IOException
    //   322	327	343	java/lang/Exception
    //   331	335	343	java/lang/Exception
    //   7	23	352	java/lang/Exception
    //   409	414	430	java/lang/Exception
    //   418	422	430	java/lang/Exception
    //   7	23	439	finally
    //   451	456	472	java/lang/Exception
    //   460	464	472	java/lang/Exception
    //   23	33	476	finally
    //   40	49	484	finally
    //   56	60	484	finally
    //   67	72	484	finally
    //   79	121	484	finally
    //   166	179	484	finally
    //   186	192	484	finally
    //   199	204	484	finally
    //   253	272	484	finally
    //   279	292	484	finally
    //   299	305	484	finally
    //   312	317	484	finally
    //   366	379	484	finally
    //   386	392	484	finally
    //   399	404	484	finally
    //   23	33	492	java/lang/Exception
    //   40	49	500	java/lang/Exception
    //   56	60	500	java/lang/Exception
    //   67	72	500	java/lang/Exception
    //   79	121	500	java/lang/Exception
    //   23	33	505	java/io/IOException
    //   40	49	513	java/io/IOException
    //   56	60	513	java/io/IOException
    //   67	72	513	java/io/IOException
    //   79	121	513	java/io/IOException
    //   23	33	518	java/util/ConcurrentModificationException
    //   40	49	526	java/util/ConcurrentModificationException
    //   56	60	526	java/util/ConcurrentModificationException
    //   67	72	526	java/util/ConcurrentModificationException
    //   79	121	526	java/util/ConcurrentModificationException
  }
  
  /* Error */
  private void dwv()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 37	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: getfield 31	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   15: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 43	java/io/File:exists	()Z
    //   23: ifne +33 -> 56
    //   26: aload_2
    //   27: invokevirtual 150	java/io/File:createNewFile	()Z
    //   30: istore_1
    //   31: ldc 45
    //   33: ldc 152
    //   35: iconst_2
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: getfield 31	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: iload_1
    //   49: invokestatic 157	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   52: aastore
    //   53: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_2
    //   57: invokevirtual 163	java/io/File:length	()J
    //   60: lconst_0
    //   61: lcmp
    //   62: ifne +40 -> 102
    //   65: aload_0
    //   66: new 165	java/util/HashMap
    //   69: dup
    //   70: invokespecial 166	java/util/HashMap:<init>	()V
    //   73: putfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   76: ldc 45
    //   78: ldc 168
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: getfield 31	com/tencent/mm/storage/y:filePath	Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: ldc 147
    //   96: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: monitorexit
    //   101: return
    //   102: new 170	java/io/FileInputStream
    //   105: dup
    //   106: aload_2
    //   107: invokespecial 173	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   110: astore_3
    //   111: new 175	java/io/ObjectInputStream
    //   114: dup
    //   115: aload_3
    //   116: invokespecial 178	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore_2
    //   120: aload_2
    //   121: astore 5
    //   123: aload_3
    //   124: astore 4
    //   126: aload_0
    //   127: aload_2
    //   128: invokevirtual 182	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   131: checkcast 95	java/util/Map
    //   134: putfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   137: aload_2
    //   138: astore 5
    //   140: aload_3
    //   141: astore 4
    //   143: ldc 45
    //   145: ldc 184
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: getfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   157: invokeinterface 188 1 0
    //   162: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_2
    //   170: astore 5
    //   172: aload_3
    //   173: astore 4
    //   175: aload_0
    //   176: iconst_0
    //   177: putfield 33	com/tencent/mm/storage/y:yxb	Z
    //   180: aload_2
    //   181: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   184: aload_3
    //   185: invokevirtual 192	java/io/FileInputStream:close	()V
    //   188: ldc 147
    //   190: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: goto -94 -> 99
    //   196: astore_2
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_2
    //   200: athrow
    //   201: astore_2
    //   202: ldc 147
    //   204: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: goto -108 -> 99
    //   210: astore 6
    //   212: aconst_null
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_2
    //   217: astore 5
    //   219: aload_3
    //   220: astore 4
    //   222: aload_0
    //   223: new 165	java/util/HashMap
    //   226: dup
    //   227: invokespecial 166	java/util/HashMap:<init>	()V
    //   230: putfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   233: aload_2
    //   234: astore 5
    //   236: aload_3
    //   237: astore 4
    //   239: ldc 45
    //   241: aload 6
    //   243: ldc 194
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: aload_2
    //   253: astore 5
    //   255: aload_3
    //   256: astore 4
    //   258: aload_0
    //   259: iconst_1
    //   260: putfield 33	com/tencent/mm/storage/y:yxb	Z
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   271: aload_3
    //   272: ifnull +7 -> 279
    //   275: aload_3
    //   276: invokevirtual 192	java/io/FileInputStream:close	()V
    //   279: ldc 147
    //   281: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: goto -185 -> 99
    //   287: astore_2
    //   288: ldc 147
    //   290: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: goto -194 -> 99
    //   296: astore_2
    //   297: aconst_null
    //   298: astore 5
    //   300: aconst_null
    //   301: astore_3
    //   302: aload 5
    //   304: ifnull +8 -> 312
    //   307: aload 5
    //   309: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   312: aload_3
    //   313: ifnull +7 -> 320
    //   316: aload_3
    //   317: invokevirtual 192	java/io/FileInputStream:close	()V
    //   320: ldc 147
    //   322: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload_2
    //   326: athrow
    //   327: astore_3
    //   328: goto -8 -> 320
    //   331: astore_2
    //   332: aconst_null
    //   333: astore 5
    //   335: goto -33 -> 302
    //   338: astore_2
    //   339: aload 4
    //   341: astore_3
    //   342: goto -40 -> 302
    //   345: astore 6
    //   347: aconst_null
    //   348: astore_2
    //   349: goto -133 -> 216
    //   352: astore 6
    //   354: goto -138 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	y
    //   30	19	1	bool	boolean
    //   18	163	2	localObject1	Object
    //   196	4	2	localObject2	Object
    //   201	1	2	localException1	java.lang.Exception
    //   213	55	2	localObject3	Object
    //   287	1	2	localException2	java.lang.Exception
    //   296	30	2	localObject4	Object
    //   331	1	2	localObject5	Object
    //   338	1	2	localObject6	Object
    //   348	1	2	localObject7	Object
    //   110	207	3	localFileInputStream1	java.io.FileInputStream
    //   327	1	3	localException3	java.lang.Exception
    //   341	1	3	localObject8	Object
    //   124	216	4	localFileInputStream2	java.io.FileInputStream
    //   121	213	5	localObject9	Object
    //   210	32	6	localException4	java.lang.Exception
    //   345	1	6	localException5	java.lang.Exception
    //   352	1	6	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	196	finally
    //   94	99	196	finally
    //   180	188	196	finally
    //   188	193	196	finally
    //   202	207	196	finally
    //   267	271	196	finally
    //   275	279	196	finally
    //   279	284	196	finally
    //   288	293	196	finally
    //   307	312	196	finally
    //   316	320	196	finally
    //   320	327	196	finally
    //   180	188	201	java/lang/Exception
    //   7	56	210	java/lang/Exception
    //   56	94	210	java/lang/Exception
    //   102	111	210	java/lang/Exception
    //   267	271	287	java/lang/Exception
    //   275	279	287	java/lang/Exception
    //   7	56	296	finally
    //   56	94	296	finally
    //   102	111	296	finally
    //   307	312	327	java/lang/Exception
    //   316	320	327	java/lang/Exception
    //   111	120	331	finally
    //   126	137	338	finally
    //   143	169	338	finally
    //   175	180	338	finally
    //   222	233	338	finally
    //   239	252	338	finally
    //   258	263	338	finally
    //   111	120	345	java/lang/Exception
    //   126	137	352	java/lang/Exception
    //   143	169	352	java/lang/Exception
    //   175	180	352	java/lang/Exception
  }
  
  private void kS(int paramInt)
  {
    AppMethodBeat.i(146153);
    e.qrI.idkeyStat(1041L, paramInt, 1L, true);
    String str = String.format("%s,%s,%d,%d,%d,%s,%s,%s,%d,%s", new Object[] { this.filePath, "false", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(paramInt), "true" });
    e.qrI.kvStat(17208, str);
    ab.d("MicroMsg.ConfigFileStorage", "kv is %s", new Object[] { str });
    AppMethodBeat.o(146153);
  }
  
  /* Error */
  public final int Nr(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 228
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iload_1
    //   9: invokevirtual 232	com/tencent/mm/storage/y:get	(I)Ljava/lang/Object;
    //   12: checkcast 107	java/lang/Integer
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +14 -> 31
    //   20: iconst_0
    //   21: istore_1
    //   22: ldc 228
    //   24: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: aload_2
    //   32: invokevirtual 235	java/lang/Integer:intValue	()I
    //   35: istore_1
    //   36: ldc 228
    //   38: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -14 -> 27
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	y
    //   0	49	1	paramInt	int
    //   15	17	2	localInteger	Integer
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	44	finally
    //   22	27	44	finally
    //   31	41	44	finally
  }
  
  public final void dsr()
  {
    try
    {
      this.epJ = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dwu()
  {
    try
    {
      AppMethodBeat.i(58956);
      this.epJ = false;
      Ln();
      AppMethodBeat.o(58956);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object get(int paramInt)
  {
    try
    {
      AppMethodBeat.i(58954);
      Object localObject1 = this.values.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(58954);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /* Error */
  public final Object get(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 246
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   11: iload_1
    //   12: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: invokeinterface 244 2 0
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +12 -> 34
    //   25: ldc 246
    //   27: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: ldc 246
    //   36: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_3
    //   40: astore_2
    //   41: goto -11 -> 30
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	y
    //   0	49	1	paramInt	int
    //   0	49	2	paramObject	Object
    //   20	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   25	30	44	finally
    //   34	39	44	finally
  }
  
  /* Error */
  public long getLong(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 249
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iload_1
    //   9: invokevirtual 232	com/tencent/mm/storage/y:get	(I)Ljava/lang/Object;
    //   12: checkcast 117	java/lang/Long
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +12 -> 31
    //   22: ldc 249
    //   24: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: lload_2
    //   30: lreturn
    //   31: aload 4
    //   33: invokevirtual 252	java/lang/Long:longValue	()J
    //   36: lstore_2
    //   37: ldc 249
    //   39: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -15 -> 27
    //   45: astore 4
    //   47: aload_0
    //   48: monitorexit
    //   49: aload 4
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	y
    //   0	52	1	paramInt	int
    //   0	52	2	paramLong	long
    //   15	17	4	localLong	Long
    //   45	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	45	finally
    //   22	27	45	finally
    //   31	42	45	finally
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(58959);
      ab.i("MicroMsg.ConfigFileStorage", "ConfigFileStorage reset ");
      File localFile = new File(this.filePath);
      if (localFile.exists()) {
        localFile.delete();
      }
      this.values = new HashMap();
      AppMethodBeat.o(58959);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void set(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 265
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: ifnonnull +27 -> 36
    //   12: ldc 45
    //   14: ldc_w 267
    //   17: iload_1
    //   18: invokestatic 270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   21: invokevirtual 274	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokestatic 276	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: ldc_w 265
    //   30: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield 84	com/tencent/mm/storage/y:values	Ljava/util/Map;
    //   40: iload_1
    //   41: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_2
    //   45: invokeinterface 280 3 0
    //   50: pop
    //   51: aload_0
    //   52: getfield 27	com/tencent/mm/storage/y:epJ	Z
    //   55: ifne +7 -> 62
    //   58: aload_0
    //   59: invokespecial 240	com/tencent/mm/storage/y:Ln	()V
    //   62: ldc_w 265
    //   65: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -35 -> 33
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	y
    //   0	76	1	paramInt	int
    //   0	76	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	71	finally
    //   12	33	71	finally
    //   36	62	71	finally
    //   62	68	71	finally
  }
  
  public final void setInt(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(58960);
      set(paramInt1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(58960);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void setLong(int paramInt, long paramLong)
  {
    try
    {
      AppMethodBeat.i(58962);
      set(paramInt, Long.valueOf(paramLong));
      AppMethodBeat.o(58962);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */