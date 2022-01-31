package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class o
{
  static int a = 0;
  static boolean b = false;
  private static o e = null;
  private static int h = 0;
  private static int i = 3;
  private static String k = null;
  private bl c = null;
  private bl d = null;
  private boolean f = false;
  private boolean g = false;
  private File j = null;
  
  public static o a(boolean paramBoolean)
  {
    AppMethodBeat.i(64072);
    if ((e == null) && (paramBoolean)) {}
    try
    {
      if (e == null) {
        e = new o();
      }
      o localo = e;
      AppMethodBeat.o(64072);
      return localo;
    }
    finally
    {
      AppMethodBeat.o(64072);
    }
  }
  
  static void a(int paramInt)
  {
    h = paramInt;
  }
  
  private void b(int paramInt)
  {
    AppMethodBeat.i(64077);
    Properties localProperties = new Properties();
    localProperties.setProperty(k, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.j, "count.prop")), null);
      AppMethodBeat.o(64077);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      AppMethodBeat.o(64077);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(64077);
    }
  }
  
  public static int d()
  {
    return h;
  }
  
  /* Error */
  private int i()
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: new 82	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: getfield 49	com/tencent/smtt/sdk/o:j	Ljava/io/File;
    //   16: ldc 84
    //   18: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload_3
    //   23: invokevirtual 102	java/io/File:exists	()Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifne +10 -> 38
    //   31: ldc 98
    //   33: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: iconst_0
    //   37: ireturn
    //   38: new 104	java/io/BufferedInputStream
    //   41: dup
    //   42: new 106	java/io/FileInputStream
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 110	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_3
    //   54: new 67	java/util/Properties
    //   57: dup
    //   58: invokespecial 68	java/util/Properties:<init>	()V
    //   61: astore 4
    //   63: aload 4
    //   65: aload_3
    //   66: invokevirtual 113	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload 4
    //   71: getstatic 35	com/tencent/smtt/sdk/o:k	Ljava/lang/String;
    //   74: ldc 115
    //   76: invokevirtual 119	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   82: invokevirtual 127	java/lang/Integer:intValue	()I
    //   85: istore_1
    //   86: aload_3
    //   87: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   90: ldc 98
    //   92: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iload_1
    //   96: ireturn
    //   97: astore_3
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_3
    //   101: ifnull +7 -> 108
    //   104: aload_3
    //   105: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   108: ldc 98
    //   110: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_3
    //   116: aload 4
    //   118: ifnull +8 -> 126
    //   121: aload 4
    //   123: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   126: ldc 98
    //   128: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_3
    //   132: athrow
    //   133: astore_3
    //   134: goto -44 -> 90
    //   137: astore_3
    //   138: goto -30 -> 108
    //   141: astore 4
    //   143: goto -17 -> 126
    //   146: astore 5
    //   148: aload_3
    //   149: astore 4
    //   151: aload 5
    //   153: astore_3
    //   154: goto -38 -> 116
    //   157: astore 4
    //   159: goto -59 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	o
    //   85	11	1	m	int
    //   26	2	2	bool	boolean
    //   21	66	3	localObject1	Object
    //   97	1	3	localException1	java.lang.Exception
    //   99	6	3	localObject2	Object
    //   115	17	3	localObject3	Object
    //   133	1	3	localIOException1	IOException
    //   137	12	3	localIOException2	IOException
    //   153	1	3	localObject4	Object
    //   6	116	4	localProperties	Properties
    //   141	1	4	localIOException3	IOException
    //   149	1	4	localObject5	Object
    //   157	1	4	localException2	java.lang.Exception
    //   146	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   8	27	97	java/lang/Exception
    //   38	54	97	java/lang/Exception
    //   8	27	115	finally
    //   38	54	115	finally
    //   86	90	133	java/io/IOException
    //   104	108	137	java/io/IOException
    //   121	126	141	java/io/IOException
    //   54	86	146	finally
    //   54	86	157	java/lang/Exception
  }
  
  public bl a()
  {
    if (this.f) {
      return this.c;
    }
    return null;
  }
  
  /* Error */
  public void a(android.content.Context paramContext, boolean paramBoolean1, boolean paramBoolean2, an paraman)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 135
    //   4: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: sipush 999
    //   10: aconst_null
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 141	com/tencent/smtt/utils/TbsLog:addLog	(ILjava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_1
    //   19: invokestatic 145	com/tencent/smtt/utils/TbsLog:initIfNeed	(Landroid/content/Context;)V
    //   22: ldc 147
    //   24: new 149	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 151
    //   30: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 160
    //   39: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_3
    //   43: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 173	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: getstatic 29	com/tencent/smtt/sdk/o:a	I
    //   55: iconst_1
    //   56: iadd
    //   57: putstatic 29	com/tencent/smtt/sdk/o:a	I
    //   60: aload 4
    //   62: ifnull +20 -> 82
    //   65: getstatic 29	com/tencent/smtt/sdk/o:a	I
    //   68: iconst_1
    //   69: if_icmpne +207 -> 276
    //   72: iconst_1
    //   73: istore 6
    //   75: aload 4
    //   77: iload 6
    //   79: putfield 176	com/tencent/smtt/sdk/an:b	Z
    //   82: invokestatic 182	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   85: invokevirtual 184	com/tencent/smtt/sdk/TbsCoreLoadStat:a	()V
    //   88: aload 4
    //   90: ifnull +11 -> 101
    //   93: aload 4
    //   95: ldc 186
    //   97: iconst_1
    //   98: invokevirtual 189	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   101: invokestatic 194	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   104: astore 10
    //   106: getstatic 29	com/tencent/smtt/sdk/o:a	I
    //   109: iconst_1
    //   110: if_icmpne +172 -> 282
    //   113: iconst_1
    //   114: istore 6
    //   116: aload 10
    //   118: aload_1
    //   119: iload 6
    //   121: invokevirtual 197	com/tencent/smtt/sdk/ao:b	(Landroid/content/Context;Z)V
    //   124: invokestatic 194	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   127: aload_1
    //   128: invokevirtual 199	com/tencent/smtt/sdk/ao:k	(Landroid/content/Context;)V
    //   131: aload 4
    //   133: ifnull +11 -> 144
    //   136: aload 4
    //   138: ldc 186
    //   140: iconst_2
    //   141: invokevirtual 189	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   144: aload_1
    //   145: iconst_1
    //   146: invokestatic 204	com/tencent/smtt/sdk/TbsShareManager:forceToLoadX5ForThirdApp	(Landroid/content/Context;Z)V
    //   149: aload 4
    //   151: ifnull +11 -> 162
    //   154: aload 4
    //   156: ldc 206
    //   158: iconst_1
    //   159: invokevirtual 189	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   162: aload_1
    //   163: iload_2
    //   164: iload_3
    //   165: invokestatic 211	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;ZZ)Z
    //   168: istore 7
    //   170: aload 4
    //   172: ifnull +11 -> 183
    //   175: aload 4
    //   177: ldc 206
    //   179: iconst_2
    //   180: invokevirtual 189	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   183: getstatic 216	android/os/Build$VERSION:SDK_INT	I
    //   186: bipush 7
    //   188: if_icmplt +100 -> 288
    //   191: iconst_1
    //   192: istore_3
    //   193: goto +616 -> 809
    //   196: iload_2
    //   197: istore 6
    //   199: iload_2
    //   200: ifeq +56 -> 256
    //   203: invokestatic 222	java/lang/System:currentTimeMillis	()J
    //   206: lstore 8
    //   208: invokestatic 194	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   211: aload_1
    //   212: invokestatic 224	com/tencent/smtt/sdk/o:d	()I
    //   215: invokevirtual 227	com/tencent/smtt/sdk/ao:g	(Landroid/content/Context;I)Z
    //   218: istore 6
    //   220: ldc 147
    //   222: new 149	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 229
    //   228: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: iload 6
    //   233: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   236: ldc 231
    //   238: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokestatic 222	java/lang/System:currentTimeMillis	()J
    //   244: lload 8
    //   246: lsub
    //   247: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   250: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 173	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: iload 6
    //   258: ifeq +458 -> 716
    //   261: aload_0
    //   262: getfield 45	com/tencent/smtt/sdk/o:f	Z
    //   265: ifeq +33 -> 298
    //   268: ldc 135
    //   270: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_0
    //   274: monitorexit
    //   275: return
    //   276: iconst_0
    //   277: istore 6
    //   279: goto -204 -> 75
    //   282: iconst_0
    //   283: istore 6
    //   285: goto -169 -> 116
    //   288: iconst_0
    //   289: istore_3
    //   290: goto +519 -> 809
    //   293: iconst_0
    //   294: istore_2
    //   295: goto -99 -> 196
    //   298: aload_1
    //   299: invokestatic 238	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   302: ifeq +231 -> 533
    //   305: sipush 995
    //   308: aconst_null
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 141	com/tencent/smtt/utils/TbsLog:addLog	(ILjava/lang/String;[Ljava/lang/Object;)V
    //   316: aload 4
    //   318: ifnull +11 -> 329
    //   321: aload 4
    //   323: ldc 240
    //   325: iconst_1
    //   326: invokevirtual 189	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   329: aload_1
    //   330: invokestatic 242	com/tencent/smtt/sdk/TbsShareManager:j	(Landroid/content/Context;)Z
    //   333: istore_2
    //   334: aload 4
    //   336: ifnull +11 -> 347
    //   339: aload 4
    //   341: ldc 240
    //   343: iconst_2
    //   344: invokevirtual 189	com/tencent/smtt/sdk/an:a	(Ljava/lang/String;B)V
    //   347: iload_2
    //   348: ifeq +60 -> 408
    //   351: new 82	java/io/File
    //   354: dup
    //   355: aload_1
    //   356: invokestatic 245	com/tencent/smtt/sdk/TbsShareManager:c	(Landroid/content/Context;)Ljava/lang/String;
    //   359: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: astore 11
    //   364: invokestatic 194	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   367: aload_1
    //   368: invokevirtual 250	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   371: astore 12
    //   373: aload_1
    //   374: invokestatic 253	com/tencent/smtt/sdk/TbsShareManager:e	(Landroid/content/Context;)Landroid/content/Context;
    //   377: astore 10
    //   379: aload 12
    //   381: ifnonnull +47 -> 428
    //   384: aload_0
    //   385: iconst_0
    //   386: putfield 45	com/tencent/smtt/sdk/o:f	Z
    //   389: aload_1
    //   390: ldc 255
    //   392: invokestatic 258	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   395: ldc 135
    //   397: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: goto -127 -> 273
    //   403: astore_1
    //   404: aload_0
    //   405: monitorexit
    //   406: aload_1
    //   407: athrow
    //   408: aload_0
    //   409: iconst_0
    //   410: putfield 45	com/tencent/smtt/sdk/o:f	Z
    //   413: aload_1
    //   414: ldc_w 260
    //   417: invokestatic 258	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   420: ldc 135
    //   422: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: goto -152 -> 273
    //   428: aload_1
    //   429: aload 10
    //   431: aload 11
    //   433: invokevirtual 263	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   436: invokestatic 267	com/tencent/smtt/sdk/QbSdk:getDexLoaderFileList	(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/String;
    //   439: astore 13
    //   441: invokestatic 270	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   444: ifnull +178 -> 622
    //   447: invokestatic 270	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   450: astore 12
    //   452: ldc 147
    //   454: ldc_w 272
    //   457: aload 12
    //   459: invokestatic 275	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   462: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   465: invokestatic 173	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload_0
    //   469: getfield 43	com/tencent/smtt/sdk/o:d	Lcom/tencent/smtt/sdk/bl;
    //   472: ifnull +160 -> 632
    //   475: aload_0
    //   476: aload_0
    //   477: getfield 43	com/tencent/smtt/sdk/o:d	Lcom/tencent/smtt/sdk/bl;
    //   480: putfield 41	com/tencent/smtt/sdk/o:c	Lcom/tencent/smtt/sdk/bl;
    //   483: aload_0
    //   484: getfield 41	com/tencent/smtt/sdk/o:c	Lcom/tencent/smtt/sdk/bl;
    //   487: aload_1
    //   488: aload 10
    //   490: aload 11
    //   492: invokevirtual 263	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   495: aload 12
    //   497: aload 13
    //   499: getstatic 281	com/tencent/smtt/sdk/QbSdk:d	Ljava/lang/String;
    //   502: aload 4
    //   504: invokevirtual 286	com/tencent/smtt/sdk/bl:a	(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/tencent/smtt/sdk/an;)V
    //   507: aload_0
    //   508: iconst_1
    //   509: putfield 45	com/tencent/smtt/sdk/o:f	Z
    //   512: aload_0
    //   513: aload_1
    //   514: invokestatic 289	com/tencent/smtt/sdk/ao:s	(Landroid/content/Context;)Ljava/io/File;
    //   517: putfield 49	com/tencent/smtt/sdk/o:j	Ljava/io/File;
    //   520: aload_0
    //   521: iconst_1
    //   522: putfield 47	com/tencent/smtt/sdk/o:g	Z
    //   525: ldc 135
    //   527: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: goto -257 -> 273
    //   533: sipush 996
    //   536: aconst_null
    //   537: iconst_0
    //   538: anewarray 4	java/lang/Object
    //   541: invokestatic 141	com/tencent/smtt/utils/TbsLog:addLog	(ILjava/lang/String;[Ljava/lang/Object;)V
    //   544: invokestatic 194	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   547: aload_1
    //   548: invokevirtual 250	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   551: astore 11
    //   553: getstatic 27	com/tencent/smtt/sdk/o:h	I
    //   556: sipush 25436
    //   559: if_icmpeq +264 -> 823
    //   562: getstatic 27	com/tencent/smtt/sdk/o:h	I
    //   565: sipush 25437
    //   568: if_icmpne +42 -> 610
    //   571: goto +252 -> 823
    //   574: iload 5
    //   576: ifeq +40 -> 616
    //   579: aload_1
    //   580: invokevirtual 295	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   583: astore 10
    //   585: aload 11
    //   587: ifnonnull +215 -> 802
    //   590: aload_0
    //   591: iconst_0
    //   592: putfield 45	com/tencent/smtt/sdk/o:f	Z
    //   595: aload_1
    //   596: ldc_w 297
    //   599: invokestatic 258	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   602: ldc 135
    //   604: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   607: goto -334 -> 273
    //   610: iconst_0
    //   611: istore 5
    //   613: goto -39 -> 574
    //   616: aload_1
    //   617: astore 10
    //   619: goto -34 -> 585
    //   622: aload 12
    //   624: invokevirtual 263	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   627: astore 12
    //   629: goto -177 -> 452
    //   632: aload_0
    //   633: new 283	com/tencent/smtt/sdk/bl
    //   636: dup
    //   637: aload_1
    //   638: aload 10
    //   640: aload 11
    //   642: invokevirtual 263	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   645: aload 12
    //   647: aload 13
    //   649: getstatic 281	com/tencent/smtt/sdk/QbSdk:d	Ljava/lang/String;
    //   652: aload 4
    //   654: invokespecial 299	com/tencent/smtt/sdk/bl:<init>	(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/tencent/smtt/sdk/an;)V
    //   657: putfield 41	com/tencent/smtt/sdk/o:c	Lcom/tencent/smtt/sdk/bl;
    //   660: goto -153 -> 507
    //   663: astore 4
    //   665: ldc 147
    //   667: ldc_w 301
    //   670: aload 4
    //   672: invokestatic 275	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   675: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   678: invokestatic 303	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: invokestatic 182	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   684: aload_1
    //   685: sipush 327
    //   688: aload 4
    //   690: invokevirtual 306	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   693: aload_0
    //   694: iconst_0
    //   695: putfield 45	com/tencent/smtt/sdk/o:f	Z
    //   698: aload_1
    //   699: ldc_w 308
    //   702: aload 4
    //   704: invokestatic 275	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   707: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   710: invokestatic 258	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   713: goto -201 -> 512
    //   716: new 149	java/lang/StringBuilder
    //   719: dup
    //   720: ldc_w 310
    //   723: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: iload 7
    //   728: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   731: ldc_w 312
    //   734: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: iload_3
    //   738: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   741: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: astore 4
    //   746: ldc 147
    //   748: ldc_w 314
    //   751: aload 4
    //   753: invokestatic 275	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   756: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   759: invokestatic 303	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: getstatic 316	com/tencent/smtt/sdk/QbSdk:a	Z
    //   765: ifeq +10 -> 775
    //   768: aload_0
    //   769: getfield 45	com/tencent/smtt/sdk/o:f	Z
    //   772: ifne -260 -> 512
    //   775: aload_0
    //   776: iconst_0
    //   777: putfield 45	com/tencent/smtt/sdk/o:f	Z
    //   780: invokestatic 182	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   783: aload_1
    //   784: sipush 405
    //   787: new 134	java/lang/Throwable
    //   790: dup
    //   791: aload 4
    //   793: invokespecial 317	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   796: invokevirtual 306	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   799: goto -287 -> 512
    //   802: aload 11
    //   804: astore 12
    //   806: goto -378 -> 428
    //   809: iload 7
    //   811: ifeq -518 -> 293
    //   814: iload_3
    //   815: ifeq -522 -> 293
    //   818: iconst_1
    //   819: istore_2
    //   820: goto -624 -> 196
    //   823: iconst_1
    //   824: istore 5
    //   826: goto -252 -> 574
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	829	0	this	o
    //   0	829	1	paramContext	android.content.Context
    //   0	829	2	paramBoolean1	boolean
    //   0	829	3	paramBoolean2	boolean
    //   0	829	4	paraman	an
    //   574	251	5	m	int
    //   73	211	6	bool1	boolean
    //   168	642	7	bool2	boolean
    //   206	39	8	l	long
    //   104	535	10	localObject1	Object
    //   362	441	11	localFile	File
    //   371	434	12	localObject2	Object
    //   439	209	13	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   2	60	403	finally
    //   65	72	403	finally
    //   75	82	403	finally
    //   82	88	403	finally
    //   93	101	403	finally
    //   101	113	403	finally
    //   116	131	403	finally
    //   136	144	403	finally
    //   144	149	403	finally
    //   154	162	403	finally
    //   162	170	403	finally
    //   175	183	403	finally
    //   183	191	403	finally
    //   203	256	403	finally
    //   261	273	403	finally
    //   298	316	403	finally
    //   321	329	403	finally
    //   329	334	403	finally
    //   339	347	403	finally
    //   351	379	403	finally
    //   384	395	403	finally
    //   395	400	403	finally
    //   408	420	403	finally
    //   420	425	403	finally
    //   428	452	403	finally
    //   452	507	403	finally
    //   507	512	403	finally
    //   512	530	403	finally
    //   533	571	403	finally
    //   579	585	403	finally
    //   590	602	403	finally
    //   602	607	403	finally
    //   622	629	403	finally
    //   632	660	403	finally
    //   665	713	403	finally
    //   716	775	403	finally
    //   775	799	403	finally
    //   298	316	663	java/lang/Throwable
    //   321	329	663	java/lang/Throwable
    //   329	334	663	java/lang/Throwable
    //   339	347	663	java/lang/Throwable
    //   351	379	663	java/lang/Throwable
    //   384	395	663	java/lang/Throwable
    //   408	420	663	java/lang/Throwable
    //   428	452	663	java/lang/Throwable
    //   452	507	663	java/lang/Throwable
    //   507	512	663	java/lang/Throwable
    //   533	571	663	java/lang/Throwable
    //   579	585	663	java/lang/Throwable
    //   590	602	663	java/lang/Throwable
    //   622	629	663	java/lang/Throwable
    //   632	660	663	java/lang/Throwable
  }
  
  void a(String paramString)
  {
    k = paramString;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  boolean b(boolean paramBoolean)
  {
    b = paramBoolean;
    return paramBoolean;
  }
  
  bl c()
  {
    return this.c;
  }
  
  public String e()
  {
    AppMethodBeat.i(64074);
    if ((this.c == null) || (QbSdk.a))
    {
      AppMethodBeat.o(64074);
      return "system webview get nothing...";
    }
    String str = this.c.a();
    AppMethodBeat.o(64074);
    return str;
  }
  
  boolean f()
  {
    AppMethodBeat.i(64075);
    int m;
    if (b)
    {
      if (k == null)
      {
        AppMethodBeat.o(64075);
        return false;
      }
      m = i();
      if (m != 0) {
        break label52;
      }
      b(1);
    }
    for (;;)
    {
      boolean bool = b;
      AppMethodBeat.o(64075);
      return bool;
      label52:
      if (m + 1 > i) {
        break;
      }
      b(m + 1);
    }
    AppMethodBeat.o(64075);
    return false;
  }
  
  boolean g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    AppMethodBeat.i(64078);
    boolean bool = QbSdk.useSoftWare();
    AppMethodBeat.o(64078);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.o
 * JD-Core Version:    0.7.0.1
 */