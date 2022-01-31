package com.tencent.mm.wear.a.e;

import com.tencent.mm.wear.a.c.d;

public final class a
  implements Thread.UncaughtExceptionHandler
{
  private static a ajj;
  private boolean ajk = false;
  
  private a()
  {
    d.c("MicroMsg.MMUncaughtExceptionHandler", "Create MMUncaughtExceptionHandler", new Object[0]);
  }
  
  public static a nM()
  {
    if (ajj == null) {
      ajj = new a();
    }
    return ajj;
  }
  
  /* Error */
  public final void uncaughtException(java.lang.Thread paramThread, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mm/wear/a/e/a:ajk	Z
    //   4: ifne +483 -> 487
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 16	com/tencent/mm/wear/a/e/a:ajk	Z
    //   12: new 40	java/util/HashMap
    //   15: dup
    //   16: invokespecial 41	java/util/HashMap:<init>	()V
    //   19: astore_3
    //   20: invokestatic 47	com/tencent/mm/wear/app/MMApplication:getContext	()Landroid/content/Context;
    //   23: invokevirtual 53	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   26: invokestatic 47	com/tencent/mm/wear/app/MMApplication:getContext	()Landroid/content/Context;
    //   29: invokevirtual 57	android/content/Context:getPackageName	()Ljava/lang/String;
    //   32: iconst_1
    //   33: invokevirtual 63	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnull +51 -> 91
    //   43: aload 4
    //   45: getfield 69	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   48: ifnonnull +229 -> 277
    //   51: ldc 71
    //   53: astore_1
    //   54: new 73	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   61: aload 4
    //   63: getfield 78	android/content/pm/PackageInfo:versionCode	I
    //   66: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 4
    //   74: aload_3
    //   75: ldc 87
    //   77: aload_1
    //   78: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload_3
    //   83: ldc 93
    //   85: aload 4
    //   87: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_3
    //   92: ldc 95
    //   94: new 97	java/text/SimpleDateFormat
    //   97: dup
    //   98: ldc 99
    //   100: invokespecial 102	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   103: new 104	java/util/Date
    //   106: dup
    //   107: invokespecial 105	java/util/Date:<init>	()V
    //   110: invokevirtual 111	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   113: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_3
    //   118: ldc 113
    //   120: getstatic 118	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   123: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload_3
    //   128: ldc 120
    //   130: getstatic 123	android/os/Build:SERIAL	Ljava/lang/String;
    //   133: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload_3
    //   138: ldc 125
    //   140: getstatic 128	android/os/Build:ID	Ljava/lang/String;
    //   143: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: aload_3
    //   148: ldc 130
    //   150: invokestatic 135	com/tencent/mm/wear/a/a:nH	()Ljava/lang/String;
    //   153: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload_3
    //   158: ldc 137
    //   160: getstatic 140	android/os/Build:MODEL	Ljava/lang/String;
    //   163: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: pop
    //   167: aload_3
    //   168: ldc 142
    //   170: getstatic 147	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   173: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: new 149	java/lang/StringBuffer
    //   180: dup
    //   181: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   184: astore_1
    //   185: aload_3
    //   186: invokevirtual 154	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   189: invokeinterface 160 1 0
    //   194: astore_3
    //   195: aload_3
    //   196: invokeinterface 166 1 0
    //   201: ifeq +85 -> 286
    //   204: aload_3
    //   205: invokeinterface 170 1 0
    //   210: checkcast 172	java/util/Map$Entry
    //   213: astore 5
    //   215: aload 5
    //   217: invokeinterface 175 1 0
    //   222: checkcast 177	java/lang/String
    //   225: astore 4
    //   227: aload 5
    //   229: invokeinterface 180 1 0
    //   234: checkcast 177	java/lang/String
    //   237: astore 5
    //   239: aload_1
    //   240: new 73	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   247: aload 4
    //   249: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 185
    //   254: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 5
    //   259: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 187
    //   264: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokevirtual 190	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   273: pop
    //   274: goto -79 -> 195
    //   277: aload 4
    //   279: getfield 69	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   282: astore_1
    //   283: goto -229 -> 54
    //   286: new 192	java/io/StringWriter
    //   289: dup
    //   290: invokespecial 193	java/io/StringWriter:<init>	()V
    //   293: astore_3
    //   294: new 195	java/io/PrintWriter
    //   297: dup
    //   298: aload_3
    //   299: invokespecial 198	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   302: astore 4
    //   304: aload_2
    //   305: aload 4
    //   307: invokevirtual 204	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   310: aload_2
    //   311: invokevirtual 208	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   314: astore_2
    //   315: aload_2
    //   316: ifnull +9 -> 325
    //   319: aload_2
    //   320: aload 4
    //   322: invokevirtual 204	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   325: aload 4
    //   327: invokevirtual 211	java/io/PrintWriter:close	()V
    //   330: aload_1
    //   331: aload_3
    //   332: invokevirtual 212	java/lang/Object:toString	()Ljava/lang/String;
    //   335: invokevirtual 190	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   338: pop
    //   339: aload_1
    //   340: ldc 187
    //   342: invokevirtual 190	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   345: pop
    //   346: aload_1
    //   347: ldc 214
    //   349: invokevirtual 190	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   352: pop
    //   353: ldc 18
    //   355: ldc 216
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload_1
    //   364: invokevirtual 217	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   367: aastore
    //   368: invokestatic 220	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload_1
    //   372: invokevirtual 217	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   375: astore_3
    //   376: new 222	java/io/File
    //   379: dup
    //   380: invokestatic 228	com/tencent/mm/wear/app/b/h:mj	()Ljava/io/File;
    //   383: ldc 230
    //   385: invokespecial 233	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 236	java/io/File:getParentFile	()Ljava/io/File;
    //   393: invokevirtual 239	java/io/File:exists	()Z
    //   396: ifne +11 -> 407
    //   399: aload_1
    //   400: invokevirtual 236	java/io/File:getParentFile	()Ljava/io/File;
    //   403: invokevirtual 242	java/io/File:mkdir	()Z
    //   406: pop
    //   407: aload_1
    //   408: invokevirtual 246	java/io/File:length	()J
    //   411: ldc2_w 247
    //   414: lcmp
    //   415: ifle +29 -> 444
    //   418: ldc 18
    //   420: ldc 250
    //   422: iconst_1
    //   423: anewarray 4	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: aload_1
    //   429: invokevirtual 246	java/io/File:length	()J
    //   432: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   435: aastore
    //   436: invokestatic 26	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: aload_1
    //   440: invokevirtual 259	java/io/File:delete	()Z
    //   443: pop
    //   444: ldc 18
    //   446: ldc_w 261
    //   449: iconst_1
    //   450: anewarray 4	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: aload_1
    //   456: invokevirtual 264	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   459: aastore
    //   460: invokestatic 26	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: new 266	java/io/FileOutputStream
    //   466: dup
    //   467: aload_1
    //   468: iconst_1
    //   469: invokespecial 269	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   472: astore_2
    //   473: aload_2
    //   474: astore_1
    //   475: aload_2
    //   476: aload_3
    //   477: invokevirtual 273	java/lang/String:getBytes	()[B
    //   480: invokevirtual 277	java/io/FileOutputStream:write	([B)V
    //   483: aload_2
    //   484: invokevirtual 278	java/io/FileOutputStream:close	()V
    //   487: invokestatic 281	com/tencent/mm/wear/a/c/d:nK	()V
    //   490: invokestatic 287	android/os/Process:myPid	()I
    //   493: invokestatic 291	android/os/Process:killProcess	(I)V
    //   496: iconst_0
    //   497: invokestatic 296	java/lang/System:exit	(I)V
    //   500: return
    //   501: astore_3
    //   502: aconst_null
    //   503: astore_2
    //   504: aload_2
    //   505: astore_1
    //   506: ldc 18
    //   508: aload_3
    //   509: ldc_w 298
    //   512: iconst_0
    //   513: anewarray 4	java/lang/Object
    //   516: invokestatic 302	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   519: aload_2
    //   520: ifnull -33 -> 487
    //   523: aload_2
    //   524: invokevirtual 278	java/io/FileOutputStream:close	()V
    //   527: goto -40 -> 487
    //   530: astore_1
    //   531: goto -44 -> 487
    //   534: astore_2
    //   535: aconst_null
    //   536: astore_1
    //   537: aload_1
    //   538: ifnull +7 -> 545
    //   541: aload_1
    //   542: invokevirtual 278	java/io/FileOutputStream:close	()V
    //   545: aload_2
    //   546: athrow
    //   547: astore_1
    //   548: goto -61 -> 487
    //   551: astore_1
    //   552: goto -7 -> 545
    //   555: astore_2
    //   556: goto -19 -> 537
    //   559: astore_3
    //   560: goto -56 -> 504
    //   563: astore_1
    //   564: goto -473 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	567	0	this	a
    //   0	567	1	paramThread	java.lang.Thread
    //   0	567	2	paramThrowable	java.lang.Throwable
    //   19	458	3	localObject1	Object
    //   501	8	3	localException1	java.lang.Exception
    //   559	1	3	localException2	java.lang.Exception
    //   36	290	4	localObject2	Object
    //   213	45	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   463	473	501	java/lang/Exception
    //   523	527	530	java/lang/Exception
    //   463	473	534	finally
    //   483	487	547	java/lang/Exception
    //   541	545	551	java/lang/Exception
    //   475	483	555	finally
    //   506	519	555	finally
    //   475	483	559	java/lang/Exception
    //   20	38	563	android/content/pm/PackageManager$NameNotFoundException
    //   43	51	563	android/content/pm/PackageManager$NameNotFoundException
    //   54	91	563	android/content/pm/PackageManager$NameNotFoundException
    //   277	283	563	android/content/pm/PackageManager$NameNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.e.a
 * JD-Core Version:    0.7.0.1
 */