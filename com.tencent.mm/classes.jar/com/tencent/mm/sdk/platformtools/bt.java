package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStats.Bucket;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;

public final class bt
{
  private static final k BRS;
  private static final k BRT;
  private static long IAD;
  private static long IAE;
  private static long IAF;
  private static long IAG;
  private static long IAH;
  private static long IAI;
  private static long IAJ;
  private static long IAK;
  private static long IAL;
  private static long IAM;
  private static long IAN;
  private static long IAO;
  private static long IAP;
  private static long wXF;
  private static long wXG;
  private static long wXH;
  private static long wXI;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(157851);
    Object localObject1 = new k("/proc/" + Process.myPid() + "/net/dev");
    if (((k)localObject1).isFile()) {}
    for (;;)
    {
      BRS = (k)localObject1;
      k localk = new k("/proc/net/xt_qtaguid/stats");
      localObject1 = localObject2;
      if (localk.isFile()) {
        localObject1 = localk;
      }
      BRT = (k)localObject1;
      IAD = System.currentTimeMillis();
      AppMethodBeat.o(157851);
      return;
      localObject1 = null;
    }
  }
  
  public static long Dw(long paramLong)
  {
    long l = paramLong;
    if (wXH > paramLong) {
      l = wXH;
    }
    return l;
  }
  
  public static long Dx(long paramLong)
  {
    long l = paramLong;
    if (wXF > paramLong) {
      l = wXF;
    }
    return l;
  }
  
  public static long Dy(long paramLong)
  {
    long l = paramLong;
    if (wXG > paramLong) {
      l = wXG;
    }
    return l;
  }
  
  public static long fpA()
  {
    long l = 0L;
    if (IAP > 0L) {
      l = IAP;
    }
    return l;
  }
  
  public static long fpB()
  {
    long l = 0L;
    if (IAM > 0L) {
      l = IAM;
    }
    return l;
  }
  
  public static long fpC()
  {
    long l = 0L;
    if (IAN > 0L) {
      l = IAN;
    }
    return l;
  }
  
  public static long fpD()
  {
    long l = 0L;
    if (wXI > 0L) {
      l = wXI;
    }
    return l;
  }
  
  /* Error */
  private static void fpE()
  {
    // Byte code:
    //   0: ldc 112
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 115	com/tencent/mm/sdk/platformtools/bt:fpF	()Z
    //   8: ifeq +16 -> 24
    //   11: ldc 117
    //   13: ldc 119
    //   15: invokestatic 124	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc 112
    //   20: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: lconst_0
    //   25: lstore_3
    //   26: lconst_0
    //   27: lstore_1
    //   28: lconst_0
    //   29: lstore 7
    //   31: lconst_0
    //   32: lstore 13
    //   34: lconst_0
    //   35: lstore 11
    //   37: aconst_null
    //   38: astore 16
    //   40: getstatic 70	com/tencent/mm/sdk/platformtools/bt:BRS	Lcom/tencent/mm/vfs/k;
    //   43: astore 17
    //   45: aload 17
    //   47: ifnull +471 -> 518
    //   50: new 126	java/io/BufferedReader
    //   53: dup
    //   54: new 128	com/tencent/mm/vfs/q
    //   57: dup
    //   58: getstatic 70	com/tencent/mm/sdk/platformtools/bt:BRS	Lcom/tencent/mm/vfs/k;
    //   61: invokespecial 131	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/k;)V
    //   64: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore 17
    //   69: aload 17
    //   71: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: pop
    //   75: aload 17
    //   77: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: pop
    //   81: lconst_0
    //   82: lstore 5
    //   84: aload 17
    //   86: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 16
    //   91: aload 16
    //   93: ifnull +126 -> 219
    //   96: aload 16
    //   98: ldc 139
    //   100: invokevirtual 145	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: astore 16
    //   105: aload 16
    //   107: iconst_0
    //   108: aaload
    //   109: invokevirtual 148	java/lang/String:length	()I
    //   112: ifne +920 -> 1032
    //   115: iconst_1
    //   116: istore_0
    //   117: aload 16
    //   119: iload_0
    //   120: iconst_0
    //   121: iadd
    //   122: aaload
    //   123: ldc 150
    //   125: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifne -44 -> 84
    //   131: aload 16
    //   133: iload_0
    //   134: iconst_0
    //   135: iadd
    //   136: aaload
    //   137: ldc 156
    //   139: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifne +17 -> 159
    //   145: aload 16
    //   147: iload_0
    //   148: iconst_0
    //   149: iadd
    //   150: aaload
    //   151: ldc 162
    //   153: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   156: ifeq +31 -> 187
    //   159: lload_3
    //   160: aload 16
    //   162: iload_0
    //   163: bipush 9
    //   165: iadd
    //   166: aaload
    //   167: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   170: ladd
    //   171: lstore_3
    //   172: lload_1
    //   173: aload 16
    //   175: iload_0
    //   176: iconst_1
    //   177: iadd
    //   178: aaload
    //   179: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   182: ladd
    //   183: lstore_1
    //   184: goto -100 -> 84
    //   187: lload 7
    //   189: aload 16
    //   191: iload_0
    //   192: bipush 9
    //   194: iadd
    //   195: aaload
    //   196: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   199: ladd
    //   200: lstore 7
    //   202: lload 5
    //   204: aload 16
    //   206: iload_0
    //   207: iconst_1
    //   208: iadd
    //   209: aaload
    //   210: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   213: ladd
    //   214: lstore 5
    //   216: goto -132 -> 84
    //   219: getstatic 170	com/tencent/mm/sdk/platformtools/bt:IAE	J
    //   222: lconst_0
    //   223: lcmp
    //   224: ifge +25 -> 249
    //   227: lload_3
    //   228: putstatic 170	com/tencent/mm/sdk/platformtools/bt:IAE	J
    //   231: ldc 117
    //   233: ldc 172
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: lload_3
    //   242: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   245: aastore
    //   246: invokestatic 180	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: getstatic 182	com/tencent/mm/sdk/platformtools/bt:IAF	J
    //   252: lconst_0
    //   253: lcmp
    //   254: ifge +25 -> 279
    //   257: lload_1
    //   258: putstatic 182	com/tencent/mm/sdk/platformtools/bt:IAF	J
    //   261: ldc 117
    //   263: ldc 184
    //   265: iconst_1
    //   266: anewarray 4	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: lload_1
    //   272: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: invokestatic 180	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: getstatic 186	com/tencent/mm/sdk/platformtools/bt:IAG	J
    //   282: lconst_0
    //   283: lcmp
    //   284: ifge +27 -> 311
    //   287: lload 7
    //   289: putstatic 186	com/tencent/mm/sdk/platformtools/bt:IAG	J
    //   292: ldc 117
    //   294: ldc 188
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: lload 7
    //   304: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   307: aastore
    //   308: invokestatic 180	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: getstatic 190	com/tencent/mm/sdk/platformtools/bt:IAH	J
    //   314: lconst_0
    //   315: lcmp
    //   316: ifge +27 -> 343
    //   319: lload 5
    //   321: putstatic 190	com/tencent/mm/sdk/platformtools/bt:IAH	J
    //   324: ldc 117
    //   326: ldc 192
    //   328: iconst_1
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: lload 5
    //   336: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: aastore
    //   340: invokestatic 180	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: lload 5
    //   345: getstatic 190	com/tencent/mm/sdk/platformtools/bt:IAH	J
    //   348: lsub
    //   349: lconst_0
    //   350: lcmp
    //   351: ifge +26 -> 377
    //   354: ldc 117
    //   356: ldc 194
    //   358: iconst_1
    //   359: anewarray 4	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: lload 5
    //   366: getstatic 190	com/tencent/mm/sdk/platformtools/bt:IAH	J
    //   369: lsub
    //   370: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   373: aastore
    //   374: invokestatic 180	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: lload 7
    //   379: getstatic 186	com/tencent/mm/sdk/platformtools/bt:IAG	J
    //   382: lsub
    //   383: lconst_0
    //   384: lcmp
    //   385: ifge +26 -> 411
    //   388: ldc 117
    //   390: ldc 194
    //   392: iconst_1
    //   393: anewarray 4	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: lload 7
    //   400: getstatic 186	com/tencent/mm/sdk/platformtools/bt:IAG	J
    //   403: lsub
    //   404: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: aastore
    //   408: invokestatic 180	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: lload_3
    //   412: getstatic 170	com/tencent/mm/sdk/platformtools/bt:IAE	J
    //   415: lcmp
    //   416: iflt +250 -> 666
    //   419: lload_3
    //   420: getstatic 170	com/tencent/mm/sdk/platformtools/bt:IAE	J
    //   423: lsub
    //   424: lstore 9
    //   426: lload 9
    //   428: putstatic 102	com/tencent/mm/sdk/platformtools/bt:IAM	J
    //   431: lload_1
    //   432: getstatic 182	com/tencent/mm/sdk/platformtools/bt:IAF	J
    //   435: lcmp
    //   436: iflt +236 -> 672
    //   439: lload_1
    //   440: getstatic 182	com/tencent/mm/sdk/platformtools/bt:IAF	J
    //   443: lsub
    //   444: lstore 9
    //   446: lload 9
    //   448: putstatic 105	com/tencent/mm/sdk/platformtools/bt:IAN	J
    //   451: lload 7
    //   453: getstatic 186	com/tencent/mm/sdk/platformtools/bt:IAG	J
    //   456: lcmp
    //   457: iflt +221 -> 678
    //   460: lload 7
    //   462: getstatic 186	com/tencent/mm/sdk/platformtools/bt:IAG	J
    //   465: lsub
    //   466: lstore 9
    //   468: lload 9
    //   470: putstatic 196	com/tencent/mm/sdk/platformtools/bt:IAO	J
    //   473: lload 5
    //   475: getstatic 190	com/tencent/mm/sdk/platformtools/bt:IAH	J
    //   478: lcmp
    //   479: iflt +206 -> 685
    //   482: lload 5
    //   484: getstatic 190	com/tencent/mm/sdk/platformtools/bt:IAH	J
    //   487: lsub
    //   488: lstore 9
    //   490: lload 9
    //   492: putstatic 99	com/tencent/mm/sdk/platformtools/bt:IAP	J
    //   495: lload_3
    //   496: putstatic 170	com/tencent/mm/sdk/platformtools/bt:IAE	J
    //   499: lload_1
    //   500: putstatic 182	com/tencent/mm/sdk/platformtools/bt:IAF	J
    //   503: lload 7
    //   505: putstatic 186	com/tencent/mm/sdk/platformtools/bt:IAG	J
    //   508: lload 5
    //   510: putstatic 190	com/tencent/mm/sdk/platformtools/bt:IAH	J
    //   513: aload 17
    //   515: invokestatic 202	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   518: aconst_null
    //   519: astore 18
    //   521: getstatic 74	com/tencent/mm/sdk/platformtools/bt:BRT	Lcom/tencent/mm/vfs/k;
    //   524: astore 16
    //   526: aload 16
    //   528: ifnull +202 -> 730
    //   531: invokestatic 205	android/os/Process:myUid	()I
    //   534: istore_0
    //   535: new 126	java/io/BufferedReader
    //   538: dup
    //   539: new 128	com/tencent/mm/vfs/q
    //   542: dup
    //   543: getstatic 74	com/tencent/mm/sdk/platformtools/bt:BRT	Lcom/tencent/mm/vfs/k;
    //   546: invokespecial 131	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/k;)V
    //   549: invokespecial 134	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   552: astore 17
    //   554: aload 17
    //   556: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   559: pop
    //   560: lconst_0
    //   561: lstore 7
    //   563: lconst_0
    //   564: lstore 5
    //   566: lload 13
    //   568: lstore_1
    //   569: lload 11
    //   571: lstore_3
    //   572: aload 17
    //   574: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   577: astore 16
    //   579: aload 16
    //   581: ifnull +268 -> 849
    //   584: aload 16
    //   586: ldc 207
    //   588: invokevirtual 145	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   591: astore 16
    //   593: aload 16
    //   595: iconst_3
    //   596: aaload
    //   597: invokestatic 213	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   600: iload_0
    //   601: if_icmpne -29 -> 572
    //   604: aload 16
    //   606: iconst_1
    //   607: aaload
    //   608: astore 18
    //   610: aload 16
    //   612: iconst_5
    //   613: aaload
    //   614: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   617: lstore 11
    //   619: aload 16
    //   621: bipush 7
    //   623: aaload
    //   624: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   627: lstore 9
    //   629: aload 18
    //   631: ldc 156
    //   633: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   636: ifne +17 -> 653
    //   639: aload 18
    //   641: ldc 162
    //   643: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   646: istore 15
    //   648: iload 15
    //   650: ifeq +172 -> 822
    //   653: lload_3
    //   654: lload 11
    //   656: ladd
    //   657: lstore_3
    //   658: lload_1
    //   659: lload 9
    //   661: ladd
    //   662: lstore_1
    //   663: goto -91 -> 572
    //   666: lload_3
    //   667: lstore 9
    //   669: goto -243 -> 426
    //   672: lload_1
    //   673: lstore 9
    //   675: goto -229 -> 446
    //   678: lload 7
    //   680: lstore 9
    //   682: goto -214 -> 468
    //   685: lload 5
    //   687: lstore 9
    //   689: goto -199 -> 490
    //   692: astore 18
    //   694: aload 16
    //   696: astore 17
    //   698: aload 18
    //   700: astore 16
    //   702: aload 17
    //   704: invokestatic 202	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   707: ldc 112
    //   709: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   712: aload 16
    //   714: athrow
    //   715: astore 16
    //   717: ldc 117
    //   719: aload 16
    //   721: ldc 215
    //   723: iconst_0
    //   724: anewarray 4	java/lang/Object
    //   727: invokestatic 219	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   730: ldc 117
    //   732: ldc 221
    //   734: bipush 8
    //   736: anewarray 4	java/lang/Object
    //   739: dup
    //   740: iconst_0
    //   741: getstatic 99	com/tencent/mm/sdk/platformtools/bt:IAP	J
    //   744: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: getstatic 196	com/tencent/mm/sdk/platformtools/bt:IAO	J
    //   753: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   756: aastore
    //   757: dup
    //   758: iconst_2
    //   759: getstatic 105	com/tencent/mm/sdk/platformtools/bt:IAN	J
    //   762: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   765: aastore
    //   766: dup
    //   767: iconst_3
    //   768: getstatic 102	com/tencent/mm/sdk/platformtools/bt:IAM	J
    //   771: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   774: aastore
    //   775: dup
    //   776: iconst_4
    //   777: getstatic 108	com/tencent/mm/sdk/platformtools/bt:wXI	J
    //   780: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   783: aastore
    //   784: dup
    //   785: iconst_5
    //   786: getstatic 90	com/tencent/mm/sdk/platformtools/bt:wXH	J
    //   789: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   792: aastore
    //   793: dup
    //   794: bipush 6
    //   796: getstatic 96	com/tencent/mm/sdk/platformtools/bt:wXG	J
    //   799: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   802: aastore
    //   803: dup
    //   804: bipush 7
    //   806: getstatic 93	com/tencent/mm/sdk/platformtools/bt:wXF	J
    //   809: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   812: aastore
    //   813: invokestatic 223	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   816: ldc 112
    //   818: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   821: return
    //   822: aload 18
    //   824: ldc 150
    //   826: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   829: ifne -257 -> 572
    //   832: lload 7
    //   834: lload 11
    //   836: ladd
    //   837: lstore 7
    //   839: lload 5
    //   841: lload 9
    //   843: ladd
    //   844: lstore 5
    //   846: goto -274 -> 572
    //   849: getstatic 225	com/tencent/mm/sdk/platformtools/bt:IAJ	J
    //   852: lconst_0
    //   853: lcmp
    //   854: ifge +7 -> 861
    //   857: lload_3
    //   858: putstatic 225	com/tencent/mm/sdk/platformtools/bt:IAJ	J
    //   861: getstatic 227	com/tencent/mm/sdk/platformtools/bt:IAI	J
    //   864: lconst_0
    //   865: lcmp
    //   866: ifge +7 -> 873
    //   869: lload_1
    //   870: putstatic 227	com/tencent/mm/sdk/platformtools/bt:IAI	J
    //   873: getstatic 229	com/tencent/mm/sdk/platformtools/bt:IAL	J
    //   876: lconst_0
    //   877: lcmp
    //   878: ifge +8 -> 886
    //   881: lload 7
    //   883: putstatic 229	com/tencent/mm/sdk/platformtools/bt:IAL	J
    //   886: getstatic 231	com/tencent/mm/sdk/platformtools/bt:IAK	J
    //   889: lconst_0
    //   890: lcmp
    //   891: ifge +8 -> 899
    //   894: lload 5
    //   896: putstatic 231	com/tencent/mm/sdk/platformtools/bt:IAK	J
    //   899: lload_1
    //   900: getstatic 227	com/tencent/mm/sdk/platformtools/bt:IAI	J
    //   903: lcmp
    //   904: iflt +133 -> 1037
    //   907: lload_1
    //   908: getstatic 227	com/tencent/mm/sdk/platformtools/bt:IAI	J
    //   911: lsub
    //   912: lstore 9
    //   914: lload 9
    //   916: putstatic 93	com/tencent/mm/sdk/platformtools/bt:wXF	J
    //   919: lload_3
    //   920: getstatic 225	com/tencent/mm/sdk/platformtools/bt:IAJ	J
    //   923: lcmp
    //   924: iflt +119 -> 1043
    //   927: lload_3
    //   928: getstatic 225	com/tencent/mm/sdk/platformtools/bt:IAJ	J
    //   931: lsub
    //   932: lstore 9
    //   934: lload 9
    //   936: putstatic 96	com/tencent/mm/sdk/platformtools/bt:wXG	J
    //   939: lload 5
    //   941: getstatic 231	com/tencent/mm/sdk/platformtools/bt:IAK	J
    //   944: lcmp
    //   945: iflt +104 -> 1049
    //   948: lload 5
    //   950: getstatic 231	com/tencent/mm/sdk/platformtools/bt:IAK	J
    //   953: lsub
    //   954: lstore 9
    //   956: lload 9
    //   958: putstatic 90	com/tencent/mm/sdk/platformtools/bt:wXH	J
    //   961: lload 7
    //   963: getstatic 229	com/tencent/mm/sdk/platformtools/bt:IAL	J
    //   966: lcmp
    //   967: iflt +89 -> 1056
    //   970: lload 7
    //   972: getstatic 229	com/tencent/mm/sdk/platformtools/bt:IAL	J
    //   975: lsub
    //   976: lstore 9
    //   978: lload 9
    //   980: putstatic 108	com/tencent/mm/sdk/platformtools/bt:wXI	J
    //   983: lload_1
    //   984: putstatic 227	com/tencent/mm/sdk/platformtools/bt:IAI	J
    //   987: lload_3
    //   988: putstatic 225	com/tencent/mm/sdk/platformtools/bt:IAJ	J
    //   991: lload 5
    //   993: putstatic 231	com/tencent/mm/sdk/platformtools/bt:IAK	J
    //   996: lload 7
    //   998: putstatic 229	com/tencent/mm/sdk/platformtools/bt:IAL	J
    //   1001: aload 17
    //   1003: invokestatic 202	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   1006: goto -276 -> 730
    //   1009: aload 17
    //   1011: invokestatic 202	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   1014: ldc 112
    //   1016: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1019: aload 16
    //   1021: athrow
    //   1022: astore 16
    //   1024: goto -15 -> 1009
    //   1027: astore 16
    //   1029: goto -327 -> 702
    //   1032: iconst_0
    //   1033: istore_0
    //   1034: goto -917 -> 117
    //   1037: lload_1
    //   1038: lstore 9
    //   1040: goto -126 -> 914
    //   1043: lload_3
    //   1044: lstore 9
    //   1046: goto -112 -> 934
    //   1049: lload 5
    //   1051: lstore 9
    //   1053: goto -97 -> 956
    //   1056: lload 7
    //   1058: lstore 9
    //   1060: goto -82 -> 978
    //   1063: astore 16
    //   1065: aload 18
    //   1067: astore 17
    //   1069: goto -60 -> 1009
    // Local variable table:
    //   start	length	slot	name	signature
    //   116	918	0	i	int
    //   27	1011	1	l1	long
    //   25	1019	3	l2	long
    //   82	968	5	l3	long
    //   29	1028	7	l4	long
    //   424	635	9	l5	long
    //   35	800	11	l6	long
    //   32	535	13	l7	long
    //   646	3	15	bool	boolean
    //   38	675	16	localObject1	Object
    //   715	305	16	localException	Exception
    //   1022	1	16	localObject2	Object
    //   1027	1	16	localObject3	Object
    //   1063	1	16	localObject4	Object
    //   43	1025	17	localObject5	Object
    //   519	121	18	localObject6	Object
    //   692	374	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   50	69	692	finally
    //   40	45	715	java/lang/Exception
    //   513	518	715	java/lang/Exception
    //   521	526	715	java/lang/Exception
    //   702	715	715	java/lang/Exception
    //   1001	1006	715	java/lang/Exception
    //   1009	1022	715	java/lang/Exception
    //   554	560	1022	finally
    //   572	579	1022	finally
    //   584	604	1022	finally
    //   610	648	1022	finally
    //   822	832	1022	finally
    //   849	861	1022	finally
    //   861	873	1022	finally
    //   873	886	1022	finally
    //   886	899	1022	finally
    //   899	914	1022	finally
    //   914	934	1022	finally
    //   934	956	1022	finally
    //   956	978	1022	finally
    //   978	1001	1022	finally
    //   69	81	1027	finally
    //   84	91	1027	finally
    //   96	115	1027	finally
    //   117	159	1027	finally
    //   159	184	1027	finally
    //   187	216	1027	finally
    //   219	249	1027	finally
    //   249	279	1027	finally
    //   279	311	1027	finally
    //   311	343	1027	finally
    //   343	377	1027	finally
    //   377	411	1027	finally
    //   411	426	1027	finally
    //   426	446	1027	finally
    //   446	468	1027	finally
    //   468	490	1027	finally
    //   490	513	1027	finally
    //   531	554	1063	finally
  }
  
  private static boolean fpF()
  {
    AppMethodBeat.i(182968);
    if (System.currentTimeMillis() - IAD < 2000L)
    {
      AppMethodBeat.o(182968);
      return true;
    }
    IAD = System.currentTimeMillis();
    AppMethodBeat.o(182968);
    return false;
  }
  
  public static long fpz()
  {
    long l = 0L;
    if (IAO > 0L) {
      l = IAO;
    }
    return l;
  }
  
  @TargetApi(23)
  public static void ji(Context paramContext)
  {
    AppMethodBeat.i(200306);
    if (fpF())
    {
      ae.i("MicroMsg.SDK.TrafficStats", "updateNsm frequently just return");
      AppMethodBeat.o(200306);
      return;
    }
    long l5 = 0L;
    l6 = 0L;
    Object localObject = (NetworkStatsManager)paramContext.getSystemService("netstats");
    if (localObject == null)
    {
      AppMethodBeat.o(200306);
      return;
    }
    paramContext = new NetworkStats.Bucket();
    l1 = l6;
    l2 = l5;
    for (;;)
    {
      try
      {
        NetworkStats localNetworkStats = ((NetworkStatsManager)localObject).querySummary(1, null, 0L, System.currentTimeMillis());
        l3 = 0L;
        l4 = 0L;
        l1 = l6;
        l2 = l5;
        if (localNetworkStats.hasNextBucket())
        {
          l1 = l6;
          l2 = l5;
          localNetworkStats.getNextBucket(paramContext);
          l1 = l6;
          l2 = l5;
          if (paramContext.getUid() != Process.myUid()) {
            continue;
          }
          l1 = l6;
          l2 = l5;
          l4 += paramContext.getRxBytes();
          l1 = l6;
          l2 = l5;
          l3 += paramContext.getTxBytes();
          continue;
        }
        l7 = 0L + l4;
        l8 = 0L + l3;
        l1 = l7;
        l2 = l8;
        localNetworkStats.close();
        l5 = 0L;
        l4 = 0L;
        l1 = l7;
        l2 = l8;
        localObject = ((NetworkStatsManager)localObject).querySummary(0, null, 0L, System.currentTimeMillis());
        l1 = l7;
        l2 = l8;
        if (((NetworkStats)localObject).hasNextBucket())
        {
          l1 = l7;
          l2 = l8;
          ((NetworkStats)localObject).getNextBucket(paramContext);
          l1 = l7;
          l2 = l8;
          if (paramContext.getUid() != Process.myUid()) {
            continue;
          }
          l1 = l7;
          l2 = l8;
          l5 += paramContext.getRxBytes();
          l1 = l7;
          l2 = l8;
          l3 = paramContext.getTxBytes();
          l4 += l3;
          continue;
        }
        ae.printErrStackTrace("MicroMsg.SDK.TrafficStats", paramContext, "Failed retrieving NsmTrafficStats.", new Object[0]);
      }
      catch (Exception paramContext)
      {
        try
        {
          ((NetworkStats)localObject).close();
          l1 = TrafficStats.getTotalRxBytes();
          l2 = TrafficStats.getMobileRxBytes();
          l15 = l1 - l2;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            long l4;
            long l7;
            long l8;
            long l11;
            long l12;
            long l13;
            long l14;
            l6 = 0L;
            l3 = 0L;
            l2 = 0L;
            l1 = 0L;
          }
        }
        try
        {
          l1 = TrafficStats.getTotalTxBytes();
          l2 = TrafficStats.getMobileTxBytes();
          l16 = l1 - l2;
        }
        catch (Exception paramContext)
        {
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          l6 = l15;
          break label970;
        }
        try
        {
          l9 = TrafficStats.getMobileRxBytes();
        }
        catch (Exception paramContext)
        {
          l2 = 0L;
          l1 = 0L;
          l6 = l15;
          l3 = l16;
          break label970;
        }
        try
        {
          l10 = TrafficStats.getMobileTxBytes();
        }
        catch (Exception paramContext)
        {
          l1 = 0L;
          l6 = l15;
          l3 = l16;
          l2 = l9;
          break label970;
        }
        try
        {
          if (IAE < 0L)
          {
            IAE = l10;
            ae.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", new Object[] { Long.valueOf(l10) });
          }
          if (IAF < 0L)
          {
            IAF = l9;
            ae.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", new Object[] { Long.valueOf(l9) });
          }
          if (IAG < 0L)
          {
            IAG = l16;
            ae.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", new Object[] { Long.valueOf(l16) });
          }
          if (IAH < 0L)
          {
            IAH = l15;
            ae.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", new Object[] { Long.valueOf(l15) });
          }
          if (l15 - IAH < 0L) {
            ae.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l15 - IAH) });
          }
          l11 = l15;
          l12 = l16;
          l13 = l9;
          l14 = l10;
          l1 = l7;
          l2 = l8;
          l3 = l5;
          l6 = l4;
          if (l16 - IAG < 0L)
          {
            ae.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l16 - IAG) });
            l6 = l4;
            l3 = l5;
            l2 = l8;
            l1 = l7;
            l14 = l10;
            l13 = l9;
            l12 = l16;
            l11 = l15;
          }
          if (l14 < IAE) {
            break label1014;
          }
          l4 = l14 - IAE;
          IAM = l4;
          if (l13 < IAF) {
            break label1020;
          }
          l4 = l13 - IAF;
          IAN = l4;
          if (l12 < IAG) {
            break label1026;
          }
          l4 = l12 - IAG;
          IAO = l4;
          if (l11 < IAH) {
            break label1032;
          }
          l4 = l11 - IAH;
          IAP = l4;
          IAE = l14;
          IAF = l13;
          IAG = l12;
          IAH = l11;
          if (IAJ < 0L) {
            IAJ = l3;
          }
          if (IAI < 0L) {
            IAI = l6;
          }
          if (IAL < 0L) {
            IAL = l1;
          }
          if (IAK < 0L) {
            IAK = l2;
          }
          if (l6 < IAI) {
            break label1038;
          }
          l4 = l6 - IAI;
          wXF = l4;
          if (l3 < IAJ) {
            break label1045;
          }
          l4 = l3 - IAJ;
          wXG = l4;
          if (l2 < IAK) {
            break label1052;
          }
          l4 = l2 - IAK;
          wXH = l4;
          if (l1 < IAL) {
            break label1058;
          }
          l4 = l1 - IAL;
          wXI = l4;
          IAI = l6;
          IAJ = l3;
          IAK = l2;
          IAL = l1;
          ae.i("MicroMsg.SDK.TrafficStats", "updateNSm current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", new Object[] { Long.valueOf(IAP), Long.valueOf(IAO), Long.valueOf(IAN), Long.valueOf(IAM), Long.valueOf(wXI), Long.valueOf(wXH), Long.valueOf(wXG), Long.valueOf(wXF) });
          AppMethodBeat.o(200306);
          return;
        }
        catch (Exception paramContext)
        {
          l6 = l15;
          l3 = l16;
          l2 = l9;
          l1 = l10;
          break label970;
        }
        paramContext = paramContext;
        l6 = 0L;
        l3 = 0L;
        l9 = 0L;
        l10 = 0L;
        l5 = 0L;
        l4 = 0L;
        l8 = l2;
        l7 = l1;
        l1 = l10;
        l2 = l9;
      }
      label970:
      l11 = l6;
      l12 = l3;
      l13 = l2;
      l14 = l1;
      l1 = l7;
      l2 = l8;
      l3 = l5;
      l6 = l4;
      continue;
      label1014:
      l4 = 0L;
      continue;
      label1020:
      l4 = 0L;
      continue;
      label1026:
      l4 = 0L;
      continue;
      label1032:
      l4 = 0L;
      continue;
      label1038:
      l4 = l6;
      continue;
      label1045:
      l4 = l3;
      continue;
      label1052:
      l4 = l2;
      continue;
      label1058:
      l4 = l1;
    }
  }
  
  public static void reset()
  {
    AppMethodBeat.i(157847);
    IAE = -1L;
    IAF = -1L;
    IAG = -1L;
    IAH = -1L;
    IAJ = -1L;
    IAI = -1L;
    IAL = -1L;
    IAK = -1L;
    fpE();
    AppMethodBeat.o(157847);
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(200305);
    IAE = -1L;
    IAF = -1L;
    IAG = -1L;
    IAH = -1L;
    IAJ = -1L;
    IAI = -1L;
    IAL = -1L;
    IAK = -1L;
    if (Build.VERSION.SDK_INT >= 28)
    {
      ji(paramContext);
      AppMethodBeat.o(200305);
      return;
    }
    fpE();
    AppMethodBeat.o(200305);
  }
  
  public static void update()
  {
    AppMethodBeat.i(157850);
    fpE();
    AppMethodBeat.o(157850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bt
 * JD-Core Version:    0.7.0.1
 */