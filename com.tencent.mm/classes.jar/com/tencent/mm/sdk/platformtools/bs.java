package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStats.Bucket;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;

public final class bs
{
  private static long EXl;
  private static long EXm;
  private static long EXn;
  private static long EXo;
  private static long EXp;
  private static long EXq;
  private static long EXr;
  private static long EXs;
  private static long EXt;
  private static long EXu;
  private static long EXv;
  private static long EXw;
  private static long EXx;
  private static long usC;
  private static long usD;
  private static long usE;
  private static long usF;
  private static final e yUT;
  private static final e yUU;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(157851);
    Object localObject1 = new e("/proc/" + Process.myPid() + "/net/dev");
    if (((e)localObject1).isFile()) {}
    for (;;)
    {
      yUT = (e)localObject1;
      e locale = new e("/proc/net/xt_qtaguid/stats");
      localObject1 = localObject2;
      if (locale.isFile()) {
        localObject1 = locale;
      }
      yUU = (e)localObject1;
      EXl = System.currentTimeMillis();
      AppMethodBeat.o(157851);
      return;
      localObject1 = null;
    }
  }
  
  public static long eGA()
  {
    long l = 0L;
    if (EXx > 0L) {
      l = EXx;
    }
    return l;
  }
  
  public static long eGB()
  {
    long l = 0L;
    if (EXu > 0L) {
      l = EXu;
    }
    return l;
  }
  
  public static long eGC()
  {
    long l = 0L;
    if (EXv > 0L) {
      l = EXv;
    }
    return l;
  }
  
  public static long eGD()
  {
    long l = 0L;
    if (usF > 0L) {
      l = usF;
    }
    return l;
  }
  
  /* Error */
  private static void eGE()
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 105	com/tencent/mm/sdk/platformtools/bs:eGF	()Z
    //   8: ifeq +16 -> 24
    //   11: ldc 107
    //   13: ldc 109
    //   15: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc 102
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
    //   40: getstatic 70	com/tencent/mm/sdk/platformtools/bs:yUT	Lcom/tencent/mm/vfs/e;
    //   43: astore 17
    //   45: aload 17
    //   47: ifnull +471 -> 518
    //   50: new 116	java/io/BufferedReader
    //   53: dup
    //   54: new 118	com/tencent/mm/vfs/k
    //   57: dup
    //   58: getstatic 70	com/tencent/mm/sdk/platformtools/bs:yUT	Lcom/tencent/mm/vfs/e;
    //   61: invokespecial 121	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   64: invokespecial 124	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore 17
    //   69: aload 17
    //   71: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: pop
    //   75: aload 17
    //   77: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: pop
    //   81: lconst_0
    //   82: lstore 5
    //   84: aload 17
    //   86: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 16
    //   91: aload 16
    //   93: ifnull +126 -> 219
    //   96: aload 16
    //   98: ldc 129
    //   100: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: astore 16
    //   105: aload 16
    //   107: iconst_0
    //   108: aaload
    //   109: invokevirtual 138	java/lang/String:length	()I
    //   112: ifne +920 -> 1032
    //   115: iconst_1
    //   116: istore_0
    //   117: aload 16
    //   119: iload_0
    //   120: iconst_0
    //   121: iadd
    //   122: aaload
    //   123: ldc 140
    //   125: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifne -44 -> 84
    //   131: aload 16
    //   133: iload_0
    //   134: iconst_0
    //   135: iadd
    //   136: aaload
    //   137: ldc 146
    //   139: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifne +17 -> 159
    //   145: aload 16
    //   147: iload_0
    //   148: iconst_0
    //   149: iadd
    //   150: aaload
    //   151: ldc 152
    //   153: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   156: ifeq +31 -> 187
    //   159: lload_3
    //   160: aload 16
    //   162: iload_0
    //   163: bipush 9
    //   165: iadd
    //   166: aaload
    //   167: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   170: ladd
    //   171: lstore_3
    //   172: lload_1
    //   173: aload 16
    //   175: iload_0
    //   176: iconst_1
    //   177: iadd
    //   178: aaload
    //   179: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   182: ladd
    //   183: lstore_1
    //   184: goto -100 -> 84
    //   187: lload 7
    //   189: aload 16
    //   191: iload_0
    //   192: bipush 9
    //   194: iadd
    //   195: aaload
    //   196: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   199: ladd
    //   200: lstore 7
    //   202: lload 5
    //   204: aload 16
    //   206: iload_0
    //   207: iconst_1
    //   208: iadd
    //   209: aaload
    //   210: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   213: ladd
    //   214: lstore 5
    //   216: goto -132 -> 84
    //   219: getstatic 160	com/tencent/mm/sdk/platformtools/bs:EXm	J
    //   222: lconst_0
    //   223: lcmp
    //   224: ifge +25 -> 249
    //   227: lload_3
    //   228: putstatic 160	com/tencent/mm/sdk/platformtools/bs:EXm	J
    //   231: ldc 107
    //   233: ldc 162
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: lload_3
    //   242: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   245: aastore
    //   246: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: getstatic 172	com/tencent/mm/sdk/platformtools/bs:EXn	J
    //   252: lconst_0
    //   253: lcmp
    //   254: ifge +25 -> 279
    //   257: lload_1
    //   258: putstatic 172	com/tencent/mm/sdk/platformtools/bs:EXn	J
    //   261: ldc 107
    //   263: ldc 174
    //   265: iconst_1
    //   266: anewarray 4	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: lload_1
    //   272: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: getstatic 176	com/tencent/mm/sdk/platformtools/bs:EXo	J
    //   282: lconst_0
    //   283: lcmp
    //   284: ifge +27 -> 311
    //   287: lload 7
    //   289: putstatic 176	com/tencent/mm/sdk/platformtools/bs:EXo	J
    //   292: ldc 107
    //   294: ldc 178
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: lload 7
    //   304: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   307: aastore
    //   308: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: getstatic 180	com/tencent/mm/sdk/platformtools/bs:EXp	J
    //   314: lconst_0
    //   315: lcmp
    //   316: ifge +27 -> 343
    //   319: lload 5
    //   321: putstatic 180	com/tencent/mm/sdk/platformtools/bs:EXp	J
    //   324: ldc 107
    //   326: ldc 182
    //   328: iconst_1
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: lload 5
    //   336: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: aastore
    //   340: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: lload 5
    //   345: getstatic 180	com/tencent/mm/sdk/platformtools/bs:EXp	J
    //   348: lsub
    //   349: lconst_0
    //   350: lcmp
    //   351: ifge +26 -> 377
    //   354: ldc 107
    //   356: ldc 184
    //   358: iconst_1
    //   359: anewarray 4	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: lload 5
    //   366: getstatic 180	com/tencent/mm/sdk/platformtools/bs:EXp	J
    //   369: lsub
    //   370: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   373: aastore
    //   374: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: lload 7
    //   379: getstatic 176	com/tencent/mm/sdk/platformtools/bs:EXo	J
    //   382: lsub
    //   383: lconst_0
    //   384: lcmp
    //   385: ifge +26 -> 411
    //   388: ldc 107
    //   390: ldc 184
    //   392: iconst_1
    //   393: anewarray 4	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: lload 7
    //   400: getstatic 176	com/tencent/mm/sdk/platformtools/bs:EXo	J
    //   403: lsub
    //   404: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: aastore
    //   408: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: lload_3
    //   412: getstatic 160	com/tencent/mm/sdk/platformtools/bs:EXm	J
    //   415: lcmp
    //   416: iflt +250 -> 666
    //   419: lload_3
    //   420: getstatic 160	com/tencent/mm/sdk/platformtools/bs:EXm	J
    //   423: lsub
    //   424: lstore 9
    //   426: lload 9
    //   428: putstatic 92	com/tencent/mm/sdk/platformtools/bs:EXu	J
    //   431: lload_1
    //   432: getstatic 172	com/tencent/mm/sdk/platformtools/bs:EXn	J
    //   435: lcmp
    //   436: iflt +236 -> 672
    //   439: lload_1
    //   440: getstatic 172	com/tencent/mm/sdk/platformtools/bs:EXn	J
    //   443: lsub
    //   444: lstore 9
    //   446: lload 9
    //   448: putstatic 95	com/tencent/mm/sdk/platformtools/bs:EXv	J
    //   451: lload 7
    //   453: getstatic 176	com/tencent/mm/sdk/platformtools/bs:EXo	J
    //   456: lcmp
    //   457: iflt +221 -> 678
    //   460: lload 7
    //   462: getstatic 176	com/tencent/mm/sdk/platformtools/bs:EXo	J
    //   465: lsub
    //   466: lstore 9
    //   468: lload 9
    //   470: putstatic 186	com/tencent/mm/sdk/platformtools/bs:EXw	J
    //   473: lload 5
    //   475: getstatic 180	com/tencent/mm/sdk/platformtools/bs:EXp	J
    //   478: lcmp
    //   479: iflt +206 -> 685
    //   482: lload 5
    //   484: getstatic 180	com/tencent/mm/sdk/platformtools/bs:EXp	J
    //   487: lsub
    //   488: lstore 9
    //   490: lload 9
    //   492: putstatic 89	com/tencent/mm/sdk/platformtools/bs:EXx	J
    //   495: lload_3
    //   496: putstatic 160	com/tencent/mm/sdk/platformtools/bs:EXm	J
    //   499: lload_1
    //   500: putstatic 172	com/tencent/mm/sdk/platformtools/bs:EXn	J
    //   503: lload 7
    //   505: putstatic 176	com/tencent/mm/sdk/platformtools/bs:EXo	J
    //   508: lload 5
    //   510: putstatic 180	com/tencent/mm/sdk/platformtools/bs:EXp	J
    //   513: aload 17
    //   515: invokestatic 192	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   518: aconst_null
    //   519: astore 18
    //   521: getstatic 74	com/tencent/mm/sdk/platformtools/bs:yUU	Lcom/tencent/mm/vfs/e;
    //   524: astore 16
    //   526: aload 16
    //   528: ifnull +202 -> 730
    //   531: invokestatic 195	android/os/Process:myUid	()I
    //   534: istore_0
    //   535: new 116	java/io/BufferedReader
    //   538: dup
    //   539: new 118	com/tencent/mm/vfs/k
    //   542: dup
    //   543: getstatic 74	com/tencent/mm/sdk/platformtools/bs:yUU	Lcom/tencent/mm/vfs/e;
    //   546: invokespecial 121	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   549: invokespecial 124	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   552: astore 17
    //   554: aload 17
    //   556: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   574: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   577: astore 16
    //   579: aload 16
    //   581: ifnull +268 -> 849
    //   584: aload 16
    //   586: ldc 197
    //   588: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   591: astore 16
    //   593: aload 16
    //   595: iconst_3
    //   596: aaload
    //   597: invokestatic 203	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   600: iload_0
    //   601: if_icmpne -29 -> 572
    //   604: aload 16
    //   606: iconst_1
    //   607: aaload
    //   608: astore 18
    //   610: aload 16
    //   612: iconst_5
    //   613: aaload
    //   614: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   617: lstore 11
    //   619: aload 16
    //   621: bipush 7
    //   623: aaload
    //   624: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   627: lstore 9
    //   629: aload 18
    //   631: ldc 146
    //   633: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   636: ifne +17 -> 653
    //   639: aload 18
    //   641: ldc 152
    //   643: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
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
    //   704: invokestatic 192	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   707: ldc 102
    //   709: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   712: aload 16
    //   714: athrow
    //   715: astore 16
    //   717: ldc 107
    //   719: aload 16
    //   721: ldc 205
    //   723: iconst_0
    //   724: anewarray 4	java/lang/Object
    //   727: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   730: ldc 107
    //   732: ldc 211
    //   734: bipush 8
    //   736: anewarray 4	java/lang/Object
    //   739: dup
    //   740: iconst_0
    //   741: getstatic 89	com/tencent/mm/sdk/platformtools/bs:EXx	J
    //   744: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: getstatic 186	com/tencent/mm/sdk/platformtools/bs:EXw	J
    //   753: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   756: aastore
    //   757: dup
    //   758: iconst_2
    //   759: getstatic 95	com/tencent/mm/sdk/platformtools/bs:EXv	J
    //   762: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   765: aastore
    //   766: dup
    //   767: iconst_3
    //   768: getstatic 92	com/tencent/mm/sdk/platformtools/bs:EXu	J
    //   771: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   774: aastore
    //   775: dup
    //   776: iconst_4
    //   777: getstatic 98	com/tencent/mm/sdk/platformtools/bs:usF	J
    //   780: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   783: aastore
    //   784: dup
    //   785: iconst_5
    //   786: getstatic 213	com/tencent/mm/sdk/platformtools/bs:usE	J
    //   789: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   792: aastore
    //   793: dup
    //   794: bipush 6
    //   796: getstatic 215	com/tencent/mm/sdk/platformtools/bs:usD	J
    //   799: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   802: aastore
    //   803: dup
    //   804: bipush 7
    //   806: getstatic 217	com/tencent/mm/sdk/platformtools/bs:usC	J
    //   809: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   812: aastore
    //   813: invokestatic 219	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   816: ldc 102
    //   818: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   821: return
    //   822: aload 18
    //   824: ldc 140
    //   826: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   849: getstatic 221	com/tencent/mm/sdk/platformtools/bs:EXr	J
    //   852: lconst_0
    //   853: lcmp
    //   854: ifge +7 -> 861
    //   857: lload_3
    //   858: putstatic 221	com/tencent/mm/sdk/platformtools/bs:EXr	J
    //   861: getstatic 223	com/tencent/mm/sdk/platformtools/bs:EXq	J
    //   864: lconst_0
    //   865: lcmp
    //   866: ifge +7 -> 873
    //   869: lload_1
    //   870: putstatic 223	com/tencent/mm/sdk/platformtools/bs:EXq	J
    //   873: getstatic 225	com/tencent/mm/sdk/platformtools/bs:EXt	J
    //   876: lconst_0
    //   877: lcmp
    //   878: ifge +8 -> 886
    //   881: lload 7
    //   883: putstatic 225	com/tencent/mm/sdk/platformtools/bs:EXt	J
    //   886: getstatic 227	com/tencent/mm/sdk/platformtools/bs:EXs	J
    //   889: lconst_0
    //   890: lcmp
    //   891: ifge +8 -> 899
    //   894: lload 5
    //   896: putstatic 227	com/tencent/mm/sdk/platformtools/bs:EXs	J
    //   899: lload_1
    //   900: getstatic 223	com/tencent/mm/sdk/platformtools/bs:EXq	J
    //   903: lcmp
    //   904: iflt +133 -> 1037
    //   907: lload_1
    //   908: getstatic 223	com/tencent/mm/sdk/platformtools/bs:EXq	J
    //   911: lsub
    //   912: lstore 9
    //   914: lload 9
    //   916: putstatic 217	com/tencent/mm/sdk/platformtools/bs:usC	J
    //   919: lload_3
    //   920: getstatic 221	com/tencent/mm/sdk/platformtools/bs:EXr	J
    //   923: lcmp
    //   924: iflt +119 -> 1043
    //   927: lload_3
    //   928: getstatic 221	com/tencent/mm/sdk/platformtools/bs:EXr	J
    //   931: lsub
    //   932: lstore 9
    //   934: lload 9
    //   936: putstatic 215	com/tencent/mm/sdk/platformtools/bs:usD	J
    //   939: lload 5
    //   941: getstatic 227	com/tencent/mm/sdk/platformtools/bs:EXs	J
    //   944: lcmp
    //   945: iflt +104 -> 1049
    //   948: lload 5
    //   950: getstatic 227	com/tencent/mm/sdk/platformtools/bs:EXs	J
    //   953: lsub
    //   954: lstore 9
    //   956: lload 9
    //   958: putstatic 213	com/tencent/mm/sdk/platformtools/bs:usE	J
    //   961: lload 7
    //   963: getstatic 225	com/tencent/mm/sdk/platformtools/bs:EXt	J
    //   966: lcmp
    //   967: iflt +89 -> 1056
    //   970: lload 7
    //   972: getstatic 225	com/tencent/mm/sdk/platformtools/bs:EXt	J
    //   975: lsub
    //   976: lstore 9
    //   978: lload 9
    //   980: putstatic 98	com/tencent/mm/sdk/platformtools/bs:usF	J
    //   983: lload_1
    //   984: putstatic 223	com/tencent/mm/sdk/platformtools/bs:EXq	J
    //   987: lload_3
    //   988: putstatic 221	com/tencent/mm/sdk/platformtools/bs:EXr	J
    //   991: lload 5
    //   993: putstatic 227	com/tencent/mm/sdk/platformtools/bs:EXs	J
    //   996: lload 7
    //   998: putstatic 225	com/tencent/mm/sdk/platformtools/bs:EXt	J
    //   1001: aload 17
    //   1003: invokestatic 192	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   1006: goto -276 -> 730
    //   1009: aload 17
    //   1011: invokestatic 192	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   1014: ldc 102
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
    //   715	305	16	localException	java.lang.Exception
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
  
  private static boolean eGF()
  {
    AppMethodBeat.i(182968);
    if (System.currentTimeMillis() - EXl < 2000L)
    {
      AppMethodBeat.o(182968);
      return true;
    }
    EXl = System.currentTimeMillis();
    AppMethodBeat.o(182968);
    return false;
  }
  
  public static long eGz()
  {
    long l = 0L;
    if (EXw > 0L) {
      l = EXw;
    }
    return l;
  }
  
  public static void l(String paramString, Context paramContext)
  {
    AppMethodBeat.i(157846);
    EXm = -1L;
    EXn = -1L;
    EXo = -1L;
    EXp = -1L;
    EXr = -1L;
    EXq = -1L;
    EXt = -1L;
    EXs = -1L;
    if (Build.VERSION.SDK_INT < 29)
    {
      eGE();
      AppMethodBeat.o(157846);
      return;
    }
    m(paramString, paramContext);
    AppMethodBeat.o(157846);
  }
  
  @TargetApi(23)
  public static void m(String paramString, Context paramContext)
  {
    AppMethodBeat.i(157849);
    if (eGF())
    {
      ad.i("MicroMsg.SDK.TrafficStats", "updateNsm frequently just return");
      AppMethodBeat.o(157849);
      return;
    }
    long l5 = 0L;
    l6 = 0L;
    NetworkStatsManager localNetworkStatsManager = (NetworkStatsManager)paramContext.getSystemService("netstats");
    if (localNetworkStatsManager == null)
    {
      AppMethodBeat.o(157849);
      return;
    }
    paramContext = new NetworkStats.Bucket();
    l1 = l6;
    l2 = l5;
    for (;;)
    {
      try
      {
        NetworkStats localNetworkStats = localNetworkStatsManager.querySummary(1, "", 0L, System.currentTimeMillis());
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
        paramString = localNetworkStatsManager.querySummary(0, paramString, 0L, System.currentTimeMillis());
        l1 = l7;
        l2 = l8;
        if (paramString.hasNextBucket())
        {
          l1 = l7;
          l2 = l8;
          paramString.getNextBucket(paramContext);
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
        ad.printErrStackTrace("MicroMsg.SDK.TrafficStats", paramString, "Failed retrieving NsmTrafficStats.", new Object[0]);
      }
      catch (RemoteException paramString)
      {
        try
        {
          paramString.close();
          l1 = TrafficStats.getTotalRxBytes();
          l2 = TrafficStats.getMobileRxBytes();
          l15 = l1 - l2;
        }
        catch (RemoteException paramString)
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
        catch (RemoteException paramString)
        {
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          l6 = l15;
          break label994;
        }
        try
        {
          l9 = TrafficStats.getMobileRxBytes();
        }
        catch (RemoteException paramString)
        {
          l2 = 0L;
          l1 = 0L;
          l6 = l15;
          l3 = l16;
          break label994;
        }
        try
        {
          l10 = TrafficStats.getMobileTxBytes();
        }
        catch (RemoteException paramString)
        {
          l1 = 0L;
          l6 = l15;
          l3 = l16;
          l2 = l9;
          break label994;
        }
        try
        {
          if (EXm < 0L)
          {
            EXm = l10;
            ad.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", new Object[] { Long.valueOf(l10) });
          }
          if (EXn < 0L)
          {
            EXn = l9;
            ad.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", new Object[] { Long.valueOf(l9) });
          }
          if (EXo < 0L)
          {
            EXo = l16;
            ad.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", new Object[] { Long.valueOf(l16) });
          }
          if (EXp < 0L)
          {
            EXp = l15;
            ad.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", new Object[] { Long.valueOf(l15) });
          }
          if (l15 - EXp < 0L) {
            ad.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l15 - EXp) });
          }
          l11 = l15;
          l12 = l16;
          l13 = l9;
          l14 = l10;
          l1 = l7;
          l2 = l8;
          l3 = l5;
          l6 = l4;
          if (l16 - EXo < 0L)
          {
            ad.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l16 - EXo) });
            l6 = l4;
            l3 = l5;
            l2 = l8;
            l1 = l7;
            l14 = l10;
            l13 = l9;
            l12 = l16;
            l11 = l15;
          }
          if (l14 < EXm) {
            break label1040;
          }
          l4 = l14 - EXm;
          EXu = l4;
          if (l13 < EXn) {
            break label1046;
          }
          l4 = l13 - EXn;
          EXv = l4;
          if (l12 < EXo) {
            break label1052;
          }
          l4 = l12 - EXo;
          EXw = l4;
          if (l11 < EXp) {
            break label1058;
          }
          l4 = l11 - EXp;
          EXx = l4;
          EXm = l14;
          EXn = l13;
          EXo = l12;
          EXp = l11;
          if (EXr < 0L) {
            EXr = l3;
          }
          if (EXq < 0L) {
            EXq = l6;
          }
          if (EXt < 0L) {
            EXt = l1;
          }
          if (EXs < 0L) {
            EXs = l2;
          }
          if (l6 < EXq) {
            break label1064;
          }
          l4 = l6 - EXq;
          usC = l4;
          if (l3 < EXr) {
            break label1071;
          }
          l4 = l3 - EXr;
          usD = l4;
          if (l2 < EXs) {
            break label1078;
          }
          l4 = l2 - EXs;
          usE = l4;
          if (l1 < EXt) {
            break label1085;
          }
          l4 = l1 - EXt;
          usF = l4;
          EXq = l6;
          EXr = l3;
          EXs = l2;
          EXt = l1;
          ad.i("MicroMsg.SDK.TrafficStats", "updateNSm current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", new Object[] { Long.valueOf(EXx), Long.valueOf(EXw), Long.valueOf(EXv), Long.valueOf(EXu), Long.valueOf(usF), Long.valueOf(usE), Long.valueOf(usD), Long.valueOf(usC) });
          AppMethodBeat.o(157849);
          return;
        }
        catch (RemoteException paramString)
        {
          l6 = l15;
          l3 = l16;
          l2 = l9;
          l1 = l10;
          break label994;
        }
        paramString = paramString;
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
      label994:
      l11 = l6;
      l12 = l3;
      l13 = l2;
      l14 = l1;
      l1 = l7;
      l2 = l8;
      l3 = l5;
      l6 = l4;
      continue;
      label1040:
      l4 = 0L;
      continue;
      label1046:
      l4 = 0L;
      continue;
      label1052:
      l4 = 0L;
      continue;
      label1058:
      l4 = 0L;
      continue;
      label1064:
      l4 = l6;
      continue;
      label1071:
      l4 = l3;
      continue;
      label1078:
      l4 = l2;
      continue;
      label1085:
      l4 = l1;
    }
  }
  
  public static void reset()
  {
    AppMethodBeat.i(157847);
    EXm = -1L;
    EXn = -1L;
    EXo = -1L;
    EXp = -1L;
    EXr = -1L;
    EXq = -1L;
    EXt = -1L;
    EXs = -1L;
    eGE();
    AppMethodBeat.o(157847);
  }
  
  public static void update()
  {
    AppMethodBeat.i(157850);
    eGE();
    AppMethodBeat.o(157850);
  }
  
  public static long vF(long paramLong)
  {
    long l = paramLong;
    if (usE > paramLong) {
      l = usE;
    }
    return l;
  }
  
  public static long vG(long paramLong)
  {
    long l = paramLong;
    if (usC > paramLong) {
      l = usC;
    }
    return l;
  }
  
  public static long vH(long paramLong)
  {
    long l = paramLong;
    if (usD > paramLong) {
      l = usD;
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bs
 * JD-Core Version:    0.7.0.1
 */