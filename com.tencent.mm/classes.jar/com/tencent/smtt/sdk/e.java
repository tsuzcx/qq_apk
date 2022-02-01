package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class e
{
  static int a = 0;
  static boolean b = false;
  private static e d = null;
  private static int g = 0;
  private static int h = 3;
  private static String j = null;
  private TbsWizard c = null;
  private boolean e = false;
  private boolean f = false;
  private File i = null;
  
  public static e a(boolean paramBoolean)
  {
    AppMethodBeat.i(54568);
    if ((d == null) && (paramBoolean)) {}
    try
    {
      if (d == null) {
        d = new e();
      }
      e locale = d;
      AppMethodBeat.o(54568);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(54568);
    }
  }
  
  static void a(int paramInt)
  {
    g = paramInt;
  }
  
  private void b(int paramInt)
  {
    AppMethodBeat.i(54573);
    TbsLog.d("SDKEngine", "setCountProp i = ".concat(String.valueOf(paramInt)));
    Properties localProperties = new Properties();
    localProperties.setProperty(j, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.i, "count.prop")), null);
      AppMethodBeat.o(54573);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      AppMethodBeat.o(54573);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(54573);
    }
  }
  
  public static int d()
  {
    return g;
  }
  
  /* Error */
  private int h()
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 64
    //   7: ldc 110
    //   9: invokestatic 81	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aconst_null
    //   13: astore 4
    //   15: new 92	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 46	com/tencent/smtt/sdk/e:i	Ljava/io/File;
    //   23: ldc 94
    //   25: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 114	java/io/File:exists	()Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifne +10 -> 45
    //   38: ldc 108
    //   40: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iconst_0
    //   44: ireturn
    //   45: new 116	java/io/BufferedInputStream
    //   48: dup
    //   49: new 118	java/io/FileInputStream
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 122	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_3
    //   61: new 83	java/util/Properties
    //   64: dup
    //   65: invokespecial 84	java/util/Properties:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: aload_3
    //   73: invokevirtual 125	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   76: aload 4
    //   78: getstatic 34	com/tencent/smtt/sdk/e:j	Ljava/lang/String;
    //   81: ldc 127
    //   83: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 136	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   89: invokevirtual 139	java/lang/Integer:intValue	()I
    //   92: istore_1
    //   93: aload_3
    //   94: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   97: ldc 108
    //   99: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iload_1
    //   103: ireturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   115: ldc 108
    //   117: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_3
    //   123: aload 4
    //   125: ifnull +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 142	java/io/BufferedInputStream:close	()V
    //   133: ldc 108
    //   135: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_3
    //   139: athrow
    //   140: astore_3
    //   141: goto -44 -> 97
    //   144: astore_3
    //   145: goto -30 -> 115
    //   148: astore 4
    //   150: goto -17 -> 133
    //   153: astore 5
    //   155: aload_3
    //   156: astore 4
    //   158: aload 5
    //   160: astore_3
    //   161: goto -38 -> 123
    //   164: astore 4
    //   166: goto -59 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	e
    //   92	11	1	k	int
    //   33	2	2	bool	boolean
    //   28	66	3	localObject1	Object
    //   104	1	3	localException1	java.lang.Exception
    //   106	6	3	localObject2	Object
    //   122	17	3	localObject3	Object
    //   140	1	3	localIOException1	IOException
    //   144	12	3	localIOException2	IOException
    //   160	1	3	localObject4	Object
    //   13	116	4	localProperties	Properties
    //   148	1	4	localIOException3	IOException
    //   156	1	4	localObject5	Object
    //   164	1	4	localException2	java.lang.Exception
    //   153	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   15	34	104	java/lang/Exception
    //   45	61	104	java/lang/Exception
    //   15	34	122	finally
    //   45	61	122	finally
    //   93	97	140	java/io/IOException
    //   111	115	144	java/io/IOException
    //   128	133	148	java/io/IOException
    //   61	93	153	finally
    //   61	93	164	java/lang/Exception
  }
  
  public TbsWizard a()
  {
    if (this.e) {
      return this.c;
    }
    return null;
  }
  
  /* Error */
  public void a(android.content.Context paramContext, boolean paramBoolean1, boolean paramBoolean2, n paramn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: sipush 999
    //   10: aconst_null
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 151	com/tencent/smtt/utils/TbsLog:addLog	(ILjava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_1
    //   19: invokestatic 155	com/tencent/smtt/utils/TbsLog:initIfNeed	(Landroid/content/Context;)V
    //   22: ldc 64
    //   24: new 157	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 159
    //   30: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 168
    //   39: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_3
    //   43: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: ldc 176
    //   48: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokestatic 182	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isOneModeAvailable	(Landroid/content/Context;)Z
    //   55: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: ldc 184
    //   60: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokestatic 187	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isTbsOneModeEnable	(Landroid/content/Context;)Z
    //   67: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   70: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 193	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: ldc 64
    //   78: new 157	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 195
    //   84: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: new 146	java/lang/Throwable
    //   90: dup
    //   91: ldc 197
    //   93: invokespecial 198	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   96: invokestatic 204	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   99: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 81	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: getstatic 28	com/tencent/smtt/sdk/e:a	I
    //   111: iconst_1
    //   112: iadd
    //   113: putstatic 28	com/tencent/smtt/sdk/e:a	I
    //   116: aload_1
    //   117: invokestatic 207	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:initExtension	(Landroid/content/Context;)V
    //   120: aload 4
    //   122: ifnull +20 -> 142
    //   125: getstatic 28	com/tencent/smtt/sdk/e:a	I
    //   128: iconst_1
    //   129: if_icmpne +213 -> 342
    //   132: iconst_1
    //   133: istore 6
    //   135: aload 4
    //   137: iload 6
    //   139: putfield 210	com/tencent/smtt/sdk/n:b	Z
    //   142: invokestatic 216	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   145: invokevirtual 218	com/tencent/smtt/sdk/TbsCoreLoadStat:a	()V
    //   148: aload 4
    //   150: ifnull +11 -> 161
    //   153: aload 4
    //   155: ldc 220
    //   157: iconst_1
    //   158: invokevirtual 223	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   161: invokestatic 228	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   164: astore 10
    //   166: getstatic 28	com/tencent/smtt/sdk/e:a	I
    //   169: iconst_1
    //   170: if_icmpne +178 -> 348
    //   173: iconst_1
    //   174: istore 6
    //   176: aload 10
    //   178: aload_1
    //   179: iload 6
    //   181: invokevirtual 231	com/tencent/smtt/sdk/o:b	(Landroid/content/Context;Z)V
    //   184: invokestatic 228	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   187: aload_1
    //   188: invokevirtual 234	com/tencent/smtt/sdk/o:k	(Landroid/content/Context;)V
    //   191: aload 4
    //   193: ifnull +11 -> 204
    //   196: aload 4
    //   198: ldc 220
    //   200: iconst_2
    //   201: invokevirtual 223	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   204: aload_1
    //   205: iconst_1
    //   206: invokestatic 239	com/tencent/smtt/sdk/TbsShareManager:forceToLoadX5ForThirdApp	(Landroid/content/Context;Z)V
    //   209: aload 4
    //   211: ifnull +11 -> 222
    //   214: aload 4
    //   216: ldc 241
    //   218: iconst_1
    //   219: invokevirtual 223	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   222: aload_1
    //   223: invokestatic 244	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:init	(Landroid/content/Context;)V
    //   226: aload_1
    //   227: iload_2
    //   228: iload_3
    //   229: invokestatic 249	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;ZZ)Z
    //   232: istore 7
    //   234: aload 4
    //   236: ifnull +11 -> 247
    //   239: aload 4
    //   241: ldc 241
    //   243: iconst_2
    //   244: invokevirtual 223	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   247: getstatic 254	android/os/Build$VERSION:SDK_INT	I
    //   250: bipush 7
    //   252: if_icmplt +102 -> 354
    //   255: iconst_1
    //   256: istore_3
    //   257: goto +685 -> 942
    //   260: iload_2
    //   261: istore 6
    //   263: iload_2
    //   264: ifeq +58 -> 322
    //   267: invokestatic 260	java/lang/System:currentTimeMillis	()J
    //   270: lstore 8
    //   272: invokestatic 228	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   275: aload_1
    //   276: invokestatic 262	com/tencent/smtt/sdk/e:d	()I
    //   279: invokevirtual 265	com/tencent/smtt/sdk/o:g	(Landroid/content/Context;I)Z
    //   282: istore 6
    //   284: ldc 64
    //   286: new 157	java/lang/StringBuilder
    //   289: dup
    //   290: ldc_w 267
    //   293: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   296: iload 6
    //   298: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   301: ldc_w 269
    //   304: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokestatic 260	java/lang/System:currentTimeMillis	()J
    //   310: lload 8
    //   312: lsub
    //   313: invokevirtual 272	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 193	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: iload 6
    //   324: ifeq +525 -> 849
    //   327: aload_0
    //   328: getfield 42	com/tencent/smtt/sdk/e:e	Z
    //   331: ifeq +33 -> 364
    //   334: ldc 147
    //   336: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aload_0
    //   340: monitorexit
    //   341: return
    //   342: iconst_0
    //   343: istore 6
    //   345: goto -210 -> 135
    //   348: iconst_0
    //   349: istore 6
    //   351: goto -175 -> 176
    //   354: iconst_0
    //   355: istore_3
    //   356: goto +586 -> 942
    //   359: iconst_0
    //   360: istore_2
    //   361: goto -101 -> 260
    //   364: aload_1
    //   365: invokestatic 275	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   368: ifeq +199 -> 567
    //   371: sipush 995
    //   374: aconst_null
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 151	com/tencent/smtt/utils/TbsLog:addLog	(ILjava/lang/String;[Ljava/lang/Object;)V
    //   382: aload 4
    //   384: ifnull +12 -> 396
    //   387: aload 4
    //   389: ldc_w 277
    //   392: iconst_1
    //   393: invokevirtual 223	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   396: aload_1
    //   397: invokestatic 279	com/tencent/smtt/sdk/TbsShareManager:j	(Landroid/content/Context;)Z
    //   400: istore_2
    //   401: aload 4
    //   403: ifnull +12 -> 415
    //   406: aload 4
    //   408: ldc_w 277
    //   411: iconst_2
    //   412: invokevirtual 223	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;B)V
    //   415: iload_2
    //   416: ifeq +61 -> 477
    //   419: new 92	java/io/File
    //   422: dup
    //   423: aload_1
    //   424: invokestatic 282	com/tencent/smtt/sdk/TbsShareManager:c	(Landroid/content/Context;)Ljava/lang/String;
    //   427: invokespecial 283	java/io/File:<init>	(Ljava/lang/String;)V
    //   430: astore 11
    //   432: invokestatic 228	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   435: aload_1
    //   436: invokevirtual 287	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   439: astore 12
    //   441: aload_1
    //   442: invokestatic 290	com/tencent/smtt/sdk/TbsShareManager:e	(Landroid/content/Context;)Landroid/content/Context;
    //   445: astore 10
    //   447: aload 12
    //   449: ifnonnull +48 -> 497
    //   452: aload_0
    //   453: iconst_0
    //   454: putfield 42	com/tencent/smtt/sdk/e:e	Z
    //   457: aload_1
    //   458: ldc_w 292
    //   461: invokestatic 295	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   464: ldc 147
    //   466: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   469: goto -130 -> 339
    //   472: astore_1
    //   473: aload_0
    //   474: monitorexit
    //   475: aload_1
    //   476: athrow
    //   477: aload_0
    //   478: iconst_0
    //   479: putfield 42	com/tencent/smtt/sdk/e:e	Z
    //   482: aload_1
    //   483: ldc_w 297
    //   486: invokestatic 295	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   489: ldc 147
    //   491: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   494: goto -155 -> 339
    //   497: aload_1
    //   498: aload 10
    //   500: aload 11
    //   502: invokevirtual 300	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   505: invokestatic 304	com/tencent/smtt/sdk/QbSdk:getDexLoaderFileList	(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/String;
    //   508: astore 13
    //   510: iconst_0
    //   511: istore 5
    //   513: iload 5
    //   515: aload 13
    //   517: arraylength
    //   518: if_icmpge +138 -> 656
    //   521: ldc 64
    //   523: new 157	java/lang/StringBuilder
    //   526: dup
    //   527: ldc_w 306
    //   530: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   533: iload 5
    //   535: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 311
    //   541: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 13
    //   546: iload 5
    //   548: aaload
    //   549: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 81	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: iload 5
    //   560: iconst_1
    //   561: iadd
    //   562: istore 5
    //   564: goto -51 -> 513
    //   567: sipush 996
    //   570: aconst_null
    //   571: iconst_0
    //   572: anewarray 4	java/lang/Object
    //   575: invokestatic 151	com/tencent/smtt/utils/TbsLog:addLog	(ILjava/lang/String;[Ljava/lang/Object;)V
    //   578: invokestatic 228	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   581: aload_1
    //   582: invokevirtual 287	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   585: astore 11
    //   587: getstatic 26	com/tencent/smtt/sdk/e:g	I
    //   590: sipush 25436
    //   593: if_icmpeq +363 -> 956
    //   596: getstatic 26	com/tencent/smtt/sdk/e:g	I
    //   599: sipush 25437
    //   602: if_icmpne +42 -> 644
    //   605: goto +351 -> 956
    //   608: iload 5
    //   610: ifeq +40 -> 650
    //   613: aload_1
    //   614: invokevirtual 317	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   617: astore 10
    //   619: aload 11
    //   621: ifnonnull +314 -> 935
    //   624: aload_0
    //   625: iconst_0
    //   626: putfield 42	com/tencent/smtt/sdk/e:e	Z
    //   629: aload_1
    //   630: ldc_w 319
    //   633: invokestatic 295	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   636: ldc 147
    //   638: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   641: goto -302 -> 339
    //   644: iconst_0
    //   645: istore 5
    //   647: goto -39 -> 608
    //   650: aload_1
    //   651: astore 10
    //   653: goto -34 -> 619
    //   656: invokestatic 322	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   659: ifnull +69 -> 728
    //   662: invokestatic 322	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   665: astore 12
    //   667: ldc 64
    //   669: ldc_w 324
    //   672: aload 12
    //   674: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   677: invokevirtual 76	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   680: invokestatic 193	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload_1
    //   684: invokestatic 182	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isOneModeAvailable	(Landroid/content/Context;)Z
    //   687: ifeq +51 -> 738
    //   690: aload_0
    //   691: new 329	com/tencent/smtt/sdk/TbsWizard
    //   694: dup
    //   695: aload_1
    //   696: invokespecial 331	com/tencent/smtt/sdk/TbsWizard:<init>	(Landroid/content/Context;)V
    //   699: putfield 40	com/tencent/smtt/sdk/e:c	Lcom/tencent/smtt/sdk/TbsWizard;
    //   702: aload_0
    //   703: iconst_1
    //   704: putfield 42	com/tencent/smtt/sdk/e:e	Z
    //   707: aload_0
    //   708: aload_1
    //   709: invokestatic 334	com/tencent/smtt/sdk/o:s	(Landroid/content/Context;)Ljava/io/File;
    //   712: putfield 46	com/tencent/smtt/sdk/e:i	Ljava/io/File;
    //   715: aload_0
    //   716: iconst_1
    //   717: putfield 44	com/tencent/smtt/sdk/e:f	Z
    //   720: ldc 147
    //   722: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   725: goto -386 -> 339
    //   728: aload 12
    //   730: invokevirtual 300	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   733: astore 12
    //   735: goto -68 -> 667
    //   738: aload_0
    //   739: new 329	com/tencent/smtt/sdk/TbsWizard
    //   742: dup
    //   743: aload_1
    //   744: aload 10
    //   746: aload 11
    //   748: invokevirtual 300	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   751: aload 12
    //   753: aload 13
    //   755: invokestatic 337	com/tencent/smtt/sdk/QbSdk:getLibraryPath	()Ljava/lang/String;
    //   758: aload 4
    //   760: invokespecial 340	com/tencent/smtt/sdk/TbsWizard:<init>	(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/tencent/smtt/sdk/n;)V
    //   763: putfield 40	com/tencent/smtt/sdk/e:c	Lcom/tencent/smtt/sdk/TbsWizard;
    //   766: goto -64 -> 702
    //   769: astore 4
    //   771: ldc 64
    //   773: ldc_w 342
    //   776: aload 4
    //   778: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   781: invokevirtual 76	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   784: invokestatic 344	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   787: aload_1
    //   788: invokestatic 182	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isOneModeAvailable	(Landroid/content/Context;)Z
    //   791: ifeq +23 -> 814
    //   794: ldc_w 346
    //   797: sipush 334
    //   800: invokestatic 352	com/tencent/tbs/one/impl/common/statistic/StatisticReport:create	(Ljava/lang/String;I)Lcom/tencent/tbs/one/impl/common/statistic/StatisticReport;
    //   803: ldc_w 354
    //   806: aload 4
    //   808: invokevirtual 358	com/tencent/tbs/one/impl/common/statistic/StatisticReport:setDescription	(Ljava/lang/String;Ljava/lang/Throwable;)Lcom/tencent/tbs/one/impl/common/statistic/StatisticReport;
    //   811: invokevirtual 361	com/tencent/tbs/one/impl/common/statistic/StatisticReport:report	()V
    //   814: invokestatic 216	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   817: aload_1
    //   818: sipush 327
    //   821: aload 4
    //   823: invokevirtual 365	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   826: aload_0
    //   827: iconst_0
    //   828: putfield 42	com/tencent/smtt/sdk/e:e	Z
    //   831: aload_1
    //   832: ldc_w 367
    //   835: aload 4
    //   837: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   840: invokevirtual 76	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   843: invokestatic 295	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   846: goto -139 -> 707
    //   849: new 157	java/lang/StringBuilder
    //   852: dup
    //   853: ldc_w 369
    //   856: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   859: iload 7
    //   861: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   864: ldc_w 371
    //   867: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: iload_3
    //   871: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   874: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: astore 4
    //   879: ldc 64
    //   881: ldc_w 373
    //   884: aload 4
    //   886: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   889: invokevirtual 76	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   892: invokestatic 344	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   895: getstatic 375	com/tencent/smtt/sdk/QbSdk:a	Z
    //   898: ifeq +10 -> 908
    //   901: aload_0
    //   902: getfield 42	com/tencent/smtt/sdk/e:e	Z
    //   905: ifne -198 -> 707
    //   908: aload_0
    //   909: iconst_0
    //   910: putfield 42	com/tencent/smtt/sdk/e:e	Z
    //   913: invokestatic 216	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   916: aload_1
    //   917: sipush 405
    //   920: new 146	java/lang/Throwable
    //   923: dup
    //   924: aload 4
    //   926: invokespecial 198	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   929: invokevirtual 365	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   932: goto -225 -> 707
    //   935: aload 11
    //   937: astore 12
    //   939: goto -442 -> 497
    //   942: iload 7
    //   944: ifeq -585 -> 359
    //   947: iload_3
    //   948: ifeq -589 -> 359
    //   951: iconst_1
    //   952: istore_2
    //   953: goto -693 -> 260
    //   956: iconst_1
    //   957: istore 5
    //   959: goto -351 -> 608
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	this	e
    //   0	962	1	paramContext	android.content.Context
    //   0	962	2	paramBoolean1	boolean
    //   0	962	3	paramBoolean2	boolean
    //   0	962	4	paramn	n
    //   511	447	5	k	int
    //   133	217	6	bool1	boolean
    //   232	711	7	bool2	boolean
    //   270	41	8	l	long
    //   164	581	10	localObject1	Object
    //   430	506	11	localFile	File
    //   439	499	12	localObject2	Object
    //   508	246	13	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   2	120	472	finally
    //   125	132	472	finally
    //   135	142	472	finally
    //   142	148	472	finally
    //   153	161	472	finally
    //   161	173	472	finally
    //   176	191	472	finally
    //   196	204	472	finally
    //   204	209	472	finally
    //   214	222	472	finally
    //   222	234	472	finally
    //   239	247	472	finally
    //   247	255	472	finally
    //   267	322	472	finally
    //   327	339	472	finally
    //   364	382	472	finally
    //   387	396	472	finally
    //   396	401	472	finally
    //   406	415	472	finally
    //   419	447	472	finally
    //   452	464	472	finally
    //   464	469	472	finally
    //   477	489	472	finally
    //   489	494	472	finally
    //   497	510	472	finally
    //   513	558	472	finally
    //   567	605	472	finally
    //   613	619	472	finally
    //   624	636	472	finally
    //   636	641	472	finally
    //   656	667	472	finally
    //   667	702	472	finally
    //   702	707	472	finally
    //   707	725	472	finally
    //   728	735	472	finally
    //   738	766	472	finally
    //   771	814	472	finally
    //   814	846	472	finally
    //   849	908	472	finally
    //   908	932	472	finally
    //   364	382	769	java/lang/Throwable
    //   387	396	769	java/lang/Throwable
    //   396	401	769	java/lang/Throwable
    //   406	415	769	java/lang/Throwable
    //   419	447	769	java/lang/Throwable
    //   452	464	769	java/lang/Throwable
    //   477	489	769	java/lang/Throwable
    //   497	510	769	java/lang/Throwable
    //   513	558	769	java/lang/Throwable
    //   567	605	769	java/lang/Throwable
    //   613	619	769	java/lang/Throwable
    //   624	636	769	java/lang/Throwable
    //   656	667	769	java/lang/Throwable
    //   667	702	769	java/lang/Throwable
    //   702	707	769	java/lang/Throwable
    //   728	735	769	java/lang/Throwable
    //   738	766	769	java/lang/Throwable
  }
  
  void a(String paramString)
  {
    j = paramString;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  boolean b(boolean paramBoolean)
  {
    b = paramBoolean;
    return paramBoolean;
  }
  
  TbsWizard c()
  {
    return this.c;
  }
  
  public String e()
  {
    AppMethodBeat.i(54570);
    if ((this.c == null) || (QbSdk.a))
    {
      AppMethodBeat.o(54570);
      return "system webview get nothing...";
    }
    String str = this.c.getCrashExtraMessage();
    AppMethodBeat.o(54570);
    return str;
  }
  
  boolean f()
  {
    AppMethodBeat.i(54571);
    TbsLog.d("SDKEngine", "getTbsNeedReboot");
    int k;
    if (b)
    {
      if (j == null)
      {
        AppMethodBeat.o(54571);
        return false;
      }
      k = h();
      if (k != 0) {
        break label60;
      }
      b(1);
    }
    for (;;)
    {
      boolean bool = b;
      AppMethodBeat.o(54571);
      return bool;
      label60:
      if (k + 1 > h) {
        break;
      }
      b(k + 1);
    }
    AppMethodBeat.o(54571);
    return false;
  }
  
  boolean g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.e
 * JD-Core Version:    0.7.0.1
 */