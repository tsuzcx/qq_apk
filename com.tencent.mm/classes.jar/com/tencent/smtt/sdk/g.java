package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class g
{
  static int a;
  static boolean b;
  private static g d;
  private static int g;
  private static int h;
  private static String j;
  private TbsWizard c = null;
  private boolean e = false;
  private boolean f = false;
  private File i = null;
  
  static
  {
    AppMethodBeat.i(55173);
    d = null;
    g = 0;
    a = 0;
    b = false;
    h = 3;
    j = null;
    AppMethodBeat.o(55173);
  }
  
  public static g a(boolean paramBoolean)
  {
    AppMethodBeat.i(188194);
    if ((d == null) && (paramBoolean)) {}
    try
    {
      if (d == null) {
        d = new g();
      }
      g localg = d;
      AppMethodBeat.o(188194);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(188194);
    }
  }
  
  static void a(int paramInt)
  {
    g = paramInt;
  }
  
  private void b(int paramInt)
  {
    AppMethodBeat.i(188200);
    TbsLog.d("SDKEngine", "setCountProp i = ".concat(String.valueOf(paramInt)));
    Properties localProperties = new Properties();
    localProperties.setProperty(j, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.i, "count.prop")), null);
      AppMethodBeat.o(188200);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      AppMethodBeat.o(188200);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(188200);
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
    //   0: ldc 109
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 65
    //   7: ldc 111
    //   9: invokestatic 82	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aconst_null
    //   13: astore 4
    //   15: new 93	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 55	com/tencent/smtt/sdk/g:i	Ljava/io/File;
    //   23: ldc 95
    //   25: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 115	java/io/File:exists	()Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifne +10 -> 45
    //   38: ldc 109
    //   40: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iconst_0
    //   44: ireturn
    //   45: new 117	java/io/BufferedInputStream
    //   48: dup
    //   49: new 119	java/io/FileInputStream
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 123	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_3
    //   61: new 84	java/util/Properties
    //   64: dup
    //   65: invokespecial 85	java/util/Properties:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: aload_3
    //   73: invokevirtual 126	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   76: aload 4
    //   78: getstatic 40	com/tencent/smtt/sdk/g:j	Ljava/lang/String;
    //   81: ldc 128
    //   83: invokevirtual 132	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 137	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   89: invokevirtual 140	java/lang/Integer:intValue	()I
    //   92: istore_1
    //   93: aload_3
    //   94: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   97: ldc 109
    //   99: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iload_1
    //   103: ireturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   115: ldc 109
    //   117: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_3
    //   123: aload 4
    //   125: ifnull +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 143	java/io/BufferedInputStream:close	()V
    //   133: ldc 109
    //   135: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	169	0	this	g
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
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, p paramp)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 148
    //   7: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: sipush 999
    //   13: aconst_null
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 152	com/tencent/smtt/utils/TbsLog:addLog	(ILjava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_1
    //   22: invokestatic 156	com/tencent/smtt/utils/TbsLog:initIfNeed	(Landroid/content/Context;)V
    //   25: ldc 65
    //   27: new 158	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 160
    //   33: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc 169
    //   42: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_3
    //   46: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: ldc 177
    //   51: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokestatic 183	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isOneModeAvailable	(Landroid/content/Context;)Z
    //   58: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: ldc 185
    //   63: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokestatic 188	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isTbsOneModeEnable	(Landroid/content/Context;)Z
    //   70: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 194	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: ldc 65
    //   81: new 158	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 196
    //   87: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: new 147	java/lang/Throwable
    //   93: dup
    //   94: ldc 198
    //   96: invokespecial 199	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   99: invokestatic 205	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   102: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 82	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: getstatic 34	com/tencent/smtt/sdk/g:a	I
    //   114: iconst_1
    //   115: iadd
    //   116: putstatic 34	com/tencent/smtt/sdk/g:a	I
    //   119: aload_1
    //   120: invokestatic 208	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:initExtension	(Landroid/content/Context;)V
    //   123: aload 4
    //   125: ifnull +20 -> 145
    //   128: getstatic 34	com/tencent/smtt/sdk/g:a	I
    //   131: iconst_1
    //   132: if_icmpne +213 -> 345
    //   135: iconst_1
    //   136: istore 5
    //   138: aload 4
    //   140: iload 5
    //   142: putfield 211	com/tencent/smtt/sdk/p:b	Z
    //   145: invokestatic 217	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   148: invokevirtual 219	com/tencent/smtt/sdk/TbsCoreLoadStat:a	()V
    //   151: aload 4
    //   153: ifnull +11 -> 164
    //   156: aload 4
    //   158: ldc 221
    //   160: iconst_1
    //   161: invokevirtual 224	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   164: invokestatic 229	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   167: astore 10
    //   169: getstatic 34	com/tencent/smtt/sdk/g:a	I
    //   172: iconst_1
    //   173: if_icmpne +178 -> 351
    //   176: iconst_1
    //   177: istore 5
    //   179: aload 10
    //   181: aload_1
    //   182: iload 5
    //   184: invokevirtual 232	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;Z)V
    //   187: invokestatic 229	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   190: aload_1
    //   191: invokevirtual 235	com/tencent/smtt/sdk/q:l	(Landroid/content/Context;)V
    //   194: aload 4
    //   196: ifnull +11 -> 207
    //   199: aload 4
    //   201: ldc 221
    //   203: iconst_2
    //   204: invokevirtual 224	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   207: aload_1
    //   208: iconst_1
    //   209: invokestatic 240	com/tencent/smtt/sdk/TbsShareManager:forceToLoadX5ForThirdApp	(Landroid/content/Context;Z)V
    //   212: aload 4
    //   214: ifnull +11 -> 225
    //   217: aload 4
    //   219: ldc 242
    //   221: iconst_1
    //   222: invokevirtual 224	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   225: aload_1
    //   226: invokestatic 245	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:init	(Landroid/content/Context;)V
    //   229: aload_1
    //   230: iload_2
    //   231: iload_3
    //   232: invokestatic 250	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;ZZ)Z
    //   235: istore 7
    //   237: aload 4
    //   239: ifnull +11 -> 250
    //   242: aload 4
    //   244: ldc 242
    //   246: iconst_2
    //   247: invokevirtual 224	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   250: getstatic 255	android/os/Build$VERSION:SDK_INT	I
    //   253: bipush 7
    //   255: if_icmplt +102 -> 357
    //   258: iconst_1
    //   259: istore_3
    //   260: goto +317 -> 577
    //   263: iload_2
    //   264: istore 5
    //   266: iload_2
    //   267: ifeq +58 -> 325
    //   270: invokestatic 261	java/lang/System:currentTimeMillis	()J
    //   273: lstore 8
    //   275: invokestatic 229	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   278: aload_1
    //   279: invokestatic 263	com/tencent/smtt/sdk/g:d	()I
    //   282: invokevirtual 266	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;I)Z
    //   285: istore 5
    //   287: ldc 65
    //   289: new 158	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 268
    //   296: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: iload 5
    //   301: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   304: ldc_w 270
    //   307: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokestatic 261	java/lang/System:currentTimeMillis	()J
    //   313: lload 8
    //   315: lsub
    //   316: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 194	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: iload 5
    //   327: ifeq +164 -> 491
    //   330: aload_0
    //   331: getfield 51	com/tencent/smtt/sdk/g:e	Z
    //   334: ifeq +33 -> 367
    //   337: ldc 148
    //   339: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload_0
    //   343: monitorexit
    //   344: return
    //   345: iconst_0
    //   346: istore 5
    //   348: goto -210 -> 138
    //   351: iconst_0
    //   352: istore 5
    //   354: goto -175 -> 179
    //   357: iconst_0
    //   358: istore_3
    //   359: goto +218 -> 577
    //   362: iconst_0
    //   363: istore_2
    //   364: goto -101 -> 263
    //   367: aload_0
    //   368: aload_0
    //   369: aload_1
    //   370: aload 4
    //   372: invokevirtual 276	com/tencent/smtt/sdk/g:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/p;)Z
    //   375: putfield 51	com/tencent/smtt/sdk/g:e	Z
    //   378: invokestatic 281	com/tencent/smtt/sdk/c:a	()Lcom/tencent/smtt/sdk/c;
    //   381: aload_1
    //   382: invokevirtual 283	com/tencent/smtt/sdk/c:a	(Landroid/content/Context;)V
    //   385: aload_0
    //   386: aload_1
    //   387: invokestatic 287	com/tencent/smtt/sdk/q:t	(Landroid/content/Context;)Ljava/io/File;
    //   390: putfield 55	com/tencent/smtt/sdk/g:i	Ljava/io/File;
    //   393: aload_0
    //   394: iconst_1
    //   395: putfield 53	com/tencent/smtt/sdk/g:f	Z
    //   398: ldc 148
    //   400: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: goto -61 -> 342
    //   406: astore_1
    //   407: aload_0
    //   408: monitorexit
    //   409: aload_1
    //   410: athrow
    //   411: astore 4
    //   413: ldc 65
    //   415: ldc_w 289
    //   418: aload 4
    //   420: invokestatic 292	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   423: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   426: invokestatic 294	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload_1
    //   430: invokestatic 183	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isOneModeAvailable	(Landroid/content/Context;)Z
    //   433: ifeq +23 -> 456
    //   436: ldc_w 296
    //   439: sipush 334
    //   442: invokestatic 302	com/tencent/tbs/one/impl/common/statistic/StatisticReport:create	(Ljava/lang/String;I)Lcom/tencent/tbs/one/impl/common/statistic/StatisticReport;
    //   445: ldc_w 304
    //   448: aload 4
    //   450: invokevirtual 308	com/tencent/tbs/one/impl/common/statistic/StatisticReport:setDescription	(Ljava/lang/String;Ljava/lang/Throwable;)Lcom/tencent/tbs/one/impl/common/statistic/StatisticReport;
    //   453: invokevirtual 311	com/tencent/tbs/one/impl/common/statistic/StatisticReport:report	()V
    //   456: invokestatic 217	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   459: aload_1
    //   460: sipush 327
    //   463: aload 4
    //   465: invokevirtual 315	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   468: aload_0
    //   469: iconst_0
    //   470: putfield 51	com/tencent/smtt/sdk/g:e	Z
    //   473: aload_1
    //   474: ldc_w 317
    //   477: aload 4
    //   479: invokestatic 292	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   482: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   485: invokestatic 320	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   488: goto -110 -> 378
    //   491: new 158	java/lang/StringBuilder
    //   494: dup
    //   495: ldc_w 322
    //   498: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   501: iload 7
    //   503: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   506: ldc_w 324
    //   509: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: iload_3
    //   513: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   516: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: astore 4
    //   521: ldc 65
    //   523: ldc_w 326
    //   526: aload 4
    //   528: invokestatic 292	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   531: invokevirtual 77	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokestatic 294	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: getstatic 328	com/tencent/smtt/sdk/QbSdk:a	Z
    //   540: ifeq +10 -> 550
    //   543: aload_0
    //   544: getfield 51	com/tencent/smtt/sdk/g:e	Z
    //   547: ifne -169 -> 378
    //   550: aload_0
    //   551: iconst_0
    //   552: putfield 51	com/tencent/smtt/sdk/g:e	Z
    //   555: invokestatic 217	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   558: aload_1
    //   559: sipush 405
    //   562: new 147	java/lang/Throwable
    //   565: dup
    //   566: aload 4
    //   568: invokespecial 199	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   571: invokevirtual 315	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   574: goto -196 -> 378
    //   577: iload 7
    //   579: ifeq -217 -> 362
    //   582: iload_3
    //   583: ifeq -221 -> 362
    //   586: iload 6
    //   588: istore_2
    //   589: goto -326 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	g
    //   0	592	1	paramContext	Context
    //   0	592	2	paramBoolean1	boolean
    //   0	592	3	paramBoolean2	boolean
    //   0	592	4	paramp	p
    //   136	217	5	bool1	boolean
    //   1	586	6	bool2	boolean
    //   235	343	7	bool3	boolean
    //   273	41	8	l	long
    //   167	13	10	localq	q
    // Exception table:
    //   from	to	target	type
    //   5	123	406	finally
    //   128	135	406	finally
    //   138	145	406	finally
    //   145	151	406	finally
    //   156	164	406	finally
    //   164	176	406	finally
    //   179	194	406	finally
    //   199	207	406	finally
    //   207	212	406	finally
    //   217	225	406	finally
    //   225	237	406	finally
    //   242	250	406	finally
    //   250	258	406	finally
    //   270	325	406	finally
    //   330	342	406	finally
    //   367	378	406	finally
    //   378	403	406	finally
    //   413	456	406	finally
    //   456	488	406	finally
    //   491	550	406	finally
    //   550	574	406	finally
    //   367	378	411	java/lang/Throwable
  }
  
  void a(String paramString)
  {
    j = paramString;
  }
  
  boolean a(Context paramContext, p paramp)
  {
    int k = 0;
    AppMethodBeat.i(188196);
    if (this.c != null)
    {
      AppMethodBeat.o(188196);
      return true;
    }
    TbsOneGreyInfoHelper.initExtension(paramContext);
    File localFile = q.a().r(paramContext);
    if (localFile == null)
    {
      this.e = false;
      QbSdk.a(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
      AppMethodBeat.o(188196);
      return false;
    }
    String[] arrayOfString = QbSdk.getDexLoaderFileList(paramContext, paramContext, localFile.getAbsolutePath());
    while (k < arrayOfString.length)
    {
      TbsLog.d("SDKEngine", "dexLoaderFileList[" + k + "]: " + arrayOfString[k]);
      k += 1;
    }
    String str = localFile.getAbsolutePath();
    TbsLog.i("SDKEngine", "SDKEngine init optDir is ".concat(String.valueOf(str)));
    if (TbsOneGreyInfoHelper.isOneModeAvailable(paramContext)) {}
    for (this.c = new TbsWizard(paramContext);; this.c = new TbsWizard(paramContext, paramContext, localFile.getAbsolutePath(), str, arrayOfString, QbSdk.getLibraryPath(), paramp))
    {
      AppMethodBeat.o(188196);
      return true;
    }
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
    AppMethodBeat.i(188197);
    if ((this.c == null) || (QbSdk.a))
    {
      AppMethodBeat.o(188197);
      return "system webview get nothing...";
    }
    String str = this.c.getCrashExtraMessage();
    AppMethodBeat.o(188197);
    return str;
  }
  
  boolean f()
  {
    AppMethodBeat.i(188198);
    TbsLog.d("SDKEngine", "getTbsNeedReboot");
    int k;
    if (b)
    {
      if (j == null)
      {
        AppMethodBeat.o(188198);
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
      AppMethodBeat.o(188198);
      return bool;
      label60:
      if (k + 1 > h) {
        break;
      }
      b(k + 1);
    }
    AppMethodBeat.o(188198);
    return false;
  }
  
  boolean g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.g
 * JD-Core Version:    0.7.0.1
 */