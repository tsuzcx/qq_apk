package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static c ylB;
  public volatile boolean gcX;
  public int hBd;
  public Rect hmm;
  public b ylC;
  public Map yln;
  public Object ylo;
  public Object ylp;
  public ExecutorService ylq;
  public Rect ylr;
  public long ylu;
  public boolean ylw;
  public int ylx;
  
  static
  {
    AppMethodBeat.i(118332);
    ylB = new c();
    AppMethodBeat.o(118332);
  }
  
  public c()
  {
    AppMethodBeat.i(118329);
    this.yln = new HashMap();
    this.ylo = new Object();
    this.ylp = new Object();
    this.ylq = Executors.newSingleThreadExecutor();
    this.ylr = new Rect();
    this.hmm = new Rect();
    AppMethodBeat.o(118329);
  }
  
  public static c dKM()
  {
    return ylB;
  }
  
  public final void a(int paramInt, long paramLong, b paramb)
  {
    synchronized (this.ylo)
    {
      this.hBd = paramInt;
      this.ylu = paramLong;
      this.ylx = 0;
      this.ylC = paramb;
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(118330);
    ad.i("MicroMsg.LicenseCardDecodeQueue", "release");
    synchronized (this.ylp)
    {
      if (this.gcX) {
        LibCardRecog.recognizeCardRelease();
      }
      this.gcX = false;
      AppMethodBeat.o(118330);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private long dlI;
    private int rih;
    private boolean[] ylD;
    private byte[] yly;
    private Point ylz;
    
    public a(long paramLong)
    {
      AppMethodBeat.i(118327);
      this.ylD = new boolean[4];
      this.dlI = paramLong;
      AppMethodBeat.o(118327);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 45
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   9: invokestatic 48	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   12: astore 6
      //   14: aload 6
      //   16: monitorenter
      //   17: aload_0
      //   18: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   21: iconst_1
      //   22: invokestatic 51	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   25: pop
      //   26: aload_0
      //   27: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:dlI	J
      //   30: aload_0
      //   31: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   34: invokestatic 55	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   37: lcmp
      //   38: ifne +593 -> 631
      //   41: aload_0
      //   42: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   45: invokestatic 59	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   48: invokeinterface 65 1 0
      //   53: ifne +101 -> 154
      //   56: aload_0
      //   57: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   60: invokestatic 59	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   63: ldc 67
      //   65: invokeinterface 71 2 0
      //   70: checkcast 72	[B
      //   73: checkcast 72	[B
      //   76: astore 7
      //   78: aload_0
      //   79: aload 7
      //   81: aload 7
      //   83: arraylength
      //   84: invokestatic 78	java/util/Arrays:copyOf	([BI)[B
      //   87: putfield 80	com/tencent/mm/plugin/scanner/b/a/c$a:yly	[B
      //   90: aload_0
      //   91: new 82	android/graphics/Point
      //   94: dup
      //   95: aload_0
      //   96: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   99: invokestatic 59	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   102: ldc 84
      //   104: invokeinterface 71 2 0
      //   109: checkcast 82	android/graphics/Point
      //   112: invokespecial 87	android/graphics/Point:<init>	(Landroid/graphics/Point;)V
      //   115: putfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   118: aload_0
      //   119: aload_0
      //   120: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   123: invokestatic 59	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   126: ldc 91
      //   128: invokeinterface 71 2 0
      //   133: checkcast 93	java/lang/Integer
      //   136: invokevirtual 97	java/lang/Integer:intValue	()I
      //   139: putfield 99	com/tencent/mm/plugin/scanner/b/a/c$a:rih	I
      //   142: aload_0
      //   143: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   146: invokestatic 59	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   149: invokeinterface 102 1 0
      //   154: aload_0
      //   155: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   158: invokestatic 106	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   161: aload_0
      //   162: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   165: invokestatic 55	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   168: ldc2_w 107
      //   171: invokeinterface 114 5 0
      //   176: aload 6
      //   178: monitorexit
      //   179: iconst_0
      //   180: istore_2
      //   181: new 116	com/tencent/mm/plugin/licence/model/CardInfo
      //   184: dup
      //   185: aload_0
      //   186: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   189: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   192: invokevirtual 125	android/graphics/Rect:width	()I
      //   195: aload_0
      //   196: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   199: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   202: invokevirtual 128	android/graphics/Rect:height	()I
      //   205: invokespecial 131	com/tencent/mm/plugin/licence/model/CardInfo:<init>	(II)V
      //   208: astore 7
      //   210: aload_0
      //   211: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   214: invokestatic 134	com/tencent/mm/plugin/scanner/b/a/c:f	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   217: astore 6
      //   219: aload 6
      //   221: monitorenter
      //   222: iload_2
      //   223: istore_1
      //   224: aload_0
      //   225: getfield 80	com/tencent/mm/plugin/scanner/b/a/c$a:yly	[B
      //   228: ifnull +199 -> 427
      //   231: iload_2
      //   232: istore_1
      //   233: aload_0
      //   234: getfield 80	com/tencent/mm/plugin/scanner/b/a/c$a:yly	[B
      //   237: arraylength
      //   238: ifle +189 -> 427
      //   241: invokestatic 140	java/lang/System:currentTimeMillis	()J
      //   244: lstore_3
      //   245: aload_0
      //   246: getfield 99	com/tencent/mm/plugin/scanner/b/a/c$a:rih	I
      //   249: sipush 180
      //   252: irem
      //   253: ifeq +409 -> 662
      //   256: aload_0
      //   257: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   260: getfield 143	android/graphics/Point:x	I
      //   263: aload_0
      //   264: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   267: getfield 146	android/graphics/Point:y	I
      //   270: imul
      //   271: iconst_3
      //   272: imul
      //   273: iconst_2
      //   274: idiv
      //   275: newarray byte
      //   277: astore 8
      //   279: aload 8
      //   281: aload_0
      //   282: getfield 80	com/tencent/mm/plugin/scanner/b/a/c$a:yly	[B
      //   285: aload_0
      //   286: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   289: getfield 143	android/graphics/Point:x	I
      //   292: aload_0
      //   293: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   296: getfield 146	android/graphics/Point:y	I
      //   299: invokestatic 151	com/tencent/qbar/d:a	([B[BII)I
      //   302: pop
      //   303: aload 8
      //   305: aload_0
      //   306: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   309: getfield 143	android/graphics/Point:x	I
      //   312: aload_0
      //   313: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   316: getfield 146	android/graphics/Point:y	I
      //   319: aload_0
      //   320: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   323: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   326: getfield 154	android/graphics/Rect:left	I
      //   329: aload_0
      //   330: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   333: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   336: getfield 157	android/graphics/Rect:top	I
      //   339: aload_0
      //   340: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   343: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   346: invokevirtual 128	android/graphics/Rect:height	()I
      //   349: aload_0
      //   350: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   353: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   356: invokevirtual 125	android/graphics/Rect:width	()I
      //   359: aload 7
      //   361: aload_0
      //   362: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   365: invokestatic 163	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/CardInfo;[Z)I
      //   368: istore_1
      //   369: ldc 165
      //   371: ldc 167
      //   373: iconst_2
      //   374: anewarray 4	java/lang/Object
      //   377: dup
      //   378: iconst_0
      //   379: iload_1
      //   380: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   383: aastore
      //   384: dup
      //   385: iconst_1
      //   386: invokestatic 140	java/lang/System:currentTimeMillis	()J
      //   389: lload_3
      //   390: lsub
      //   391: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   394: aastore
      //   395: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   398: ldc 165
      //   400: ldc 183
      //   402: iconst_1
      //   403: anewarray 4	java/lang/Object
      //   406: dup
      //   407: iconst_0
      //   408: aload_0
      //   409: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   412: invokestatic 187	java/util/Arrays:toString	([Z)Ljava/lang/String;
      //   415: aastore
      //   416: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   419: aload_0
      //   420: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   423: invokestatic 191	com/tencent/mm/plugin/scanner/b/a/c:g	(Lcom/tencent/mm/plugin/scanner/b/a/c;)I
      //   426: pop
      //   427: aload 6
      //   429: monitorexit
      //   430: aload_0
      //   431: getfield 99	com/tencent/mm/plugin/scanner/b/a/c$a:rih	I
      //   434: sipush 180
      //   437: irem
      //   438: ifeq +59 -> 497
      //   441: aload_0
      //   442: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   445: iconst_0
      //   446: baload
      //   447: istore 5
      //   449: aload_0
      //   450: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   453: iconst_0
      //   454: aload_0
      //   455: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   458: iconst_2
      //   459: baload
      //   460: bastore
      //   461: aload_0
      //   462: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   465: iconst_2
      //   466: iload 5
      //   468: bastore
      //   469: aload_0
      //   470: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   473: iconst_1
      //   474: baload
      //   475: istore 5
      //   477: aload_0
      //   478: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   481: iconst_1
      //   482: aload_0
      //   483: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   486: iconst_3
      //   487: baload
      //   488: bastore
      //   489: aload_0
      //   490: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   493: iconst_3
      //   494: iload 5
      //   496: bastore
      //   497: aload_0
      //   498: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   501: invokestatic 48	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   504: astore 6
      //   506: aload 6
      //   508: monitorenter
      //   509: aload_0
      //   510: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:dlI	J
      //   513: aload_0
      //   514: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   517: invokestatic 55	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   520: lcmp
      //   521: ifne +387 -> 908
      //   524: new 193	android/os/Bundle
      //   527: dup
      //   528: invokespecial 194	android/os/Bundle:<init>	()V
      //   531: astore 8
      //   533: aload 8
      //   535: ldc 196
      //   537: aload_0
      //   538: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   541: invokevirtual 200	android/os/Bundle:putBooleanArray	(Ljava/lang/String;[Z)V
      //   544: aload_0
      //   545: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   548: invokestatic 106	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   551: ifnull +21 -> 572
      //   554: aload_0
      //   555: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   558: invokestatic 106	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   561: aload_0
      //   562: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:dlI	J
      //   565: aload 8
      //   567: invokeinterface 203 4 0
      //   572: ldc 165
      //   574: ldc 205
      //   576: iconst_2
      //   577: anewarray 4	java/lang/Object
      //   580: dup
      //   581: iconst_0
      //   582: iload_1
      //   583: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   586: aastore
      //   587: dup
      //   588: iconst_1
      //   589: aload 7
      //   591: getfield 208	com/tencent/mm/plugin/licence/model/CardInfo:bitmapLen	I
      //   594: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   597: aastore
      //   598: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   601: iload_1
      //   602: iconst_1
      //   603: if_icmpeq +143 -> 746
      //   606: aload_0
      //   607: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   610: iconst_0
      //   611: invokestatic 51	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   614: pop
      //   615: aload_0
      //   616: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   619: invokestatic 212	com/tencent/mm/plugin/scanner/b/a/c:h	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   622: aload 6
      //   624: monitorexit
      //   625: ldc 45
      //   627: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   630: return
      //   631: aload_0
      //   632: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   635: iconst_0
      //   636: invokestatic 51	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   639: pop
      //   640: aload 6
      //   642: monitorexit
      //   643: ldc 45
      //   645: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   648: return
      //   649: astore 7
      //   651: aload 6
      //   653: monitorexit
      //   654: ldc 45
      //   656: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   659: aload 7
      //   661: athrow
      //   662: aload_0
      //   663: getfield 80	com/tencent/mm/plugin/scanner/b/a/c$a:yly	[B
      //   666: aload_0
      //   667: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   670: getfield 146	android/graphics/Point:y	I
      //   673: aload_0
      //   674: getfield 89	com/tencent/mm/plugin/scanner/b/a/c$a:ylz	Landroid/graphics/Point;
      //   677: getfield 143	android/graphics/Point:x	I
      //   680: aload_0
      //   681: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   684: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   687: getfield 154	android/graphics/Rect:left	I
      //   690: aload_0
      //   691: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   694: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   697: getfield 157	android/graphics/Rect:top	I
      //   700: aload_0
      //   701: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   704: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   707: invokevirtual 128	android/graphics/Rect:height	()I
      //   710: aload_0
      //   711: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   714: invokestatic 120	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   717: invokevirtual 125	android/graphics/Rect:width	()I
      //   720: aload 7
      //   722: aload_0
      //   723: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:ylD	[Z
      //   726: invokestatic 163	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/CardInfo;[Z)I
      //   729: istore_1
      //   730: goto -361 -> 369
      //   733: astore 7
      //   735: aload 6
      //   737: monitorexit
      //   738: ldc 45
      //   740: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   743: aload 7
      //   745: athrow
      //   746: new 214	android/graphics/BitmapFactory$Options
      //   749: dup
      //   750: invokespecial 215	android/graphics/BitmapFactory$Options:<init>	()V
      //   753: astore 8
      //   755: aload 8
      //   757: iconst_1
      //   758: putfield 218	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   761: aload 7
      //   763: getfield 221	com/tencent/mm/plugin/licence/model/CardInfo:bitmapData	[B
      //   766: iconst_0
      //   767: aload 7
      //   769: getfield 208	com/tencent/mm/plugin/licence/model/CardInfo:bitmapLen	I
      //   772: aload 8
      //   774: invokestatic 227	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   777: getstatic 233	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   780: iconst_1
      //   781: invokevirtual 239	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   784: astore 7
      //   786: aload 7
      //   788: ifnonnull +28 -> 816
      //   791: aload_0
      //   792: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   795: iconst_0
      //   796: invokestatic 51	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   799: pop
      //   800: aload_0
      //   801: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   804: invokestatic 212	com/tencent/mm/plugin/scanner/b/a/c:h	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   807: aload 6
      //   809: monitorexit
      //   810: ldc 45
      //   812: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   815: return
      //   816: ldc 165
      //   818: ldc 241
      //   820: iconst_2
      //   821: anewarray 4	java/lang/Object
      //   824: dup
      //   825: iconst_0
      //   826: aload 7
      //   828: invokevirtual 244	android/graphics/Bitmap:getWidth	()I
      //   831: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   834: aastore
      //   835: dup
      //   836: iconst_1
      //   837: aload 7
      //   839: invokevirtual 247	android/graphics/Bitmap:getHeight	()I
      //   842: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   845: aastore
      //   846: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   849: new 193	android/os/Bundle
      //   852: dup
      //   853: invokespecial 194	android/os/Bundle:<init>	()V
      //   856: astore 8
      //   858: aload 8
      //   860: ldc 249
      //   862: aload 7
      //   864: bipush 80
      //   866: invokestatic 255	com/tencent/mm/sdk/platformtools/g:j	(Landroid/graphics/Bitmap;I)[B
      //   869: invokevirtual 259	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   872: aload_0
      //   873: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   876: invokestatic 106	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   879: aload_0
      //   880: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:dlI	J
      //   883: aload 8
      //   885: invokeinterface 261 4 0
      //   890: aload_0
      //   891: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   894: iconst_0
      //   895: invokestatic 51	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   898: pop
      //   899: aload 6
      //   901: monitorexit
      //   902: ldc 45
      //   904: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   907: return
      //   908: aload_0
      //   909: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   912: iconst_0
      //   913: invokestatic 51	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   916: pop
      //   917: aload_0
      //   918: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:ylE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   921: invokestatic 212	com/tencent/mm/plugin/scanner/b/a/c:h	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   924: goto -25 -> 899
      //   927: astore 7
      //   929: aload 6
      //   931: monitorexit
      //   932: ldc 45
      //   934: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   937: aload 7
      //   939: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	940	0	this	a
      //   223	507	1	i	int
      //   180	52	2	j	int
      //   244	146	3	l	long
      //   447	48	5	k	int
      //   76	514	7	localObject2	Object
      //   649	72	7	localCardInfo	com.tencent.mm.plugin.licence.model.CardInfo
      //   733	35	7	localObject3	Object
      //   784	79	7	localBitmap	android.graphics.Bitmap
      //   927	11	7	localObject4	Object
      //   277	607	8	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   17	154	649	finally
      //   154	179	649	finally
      //   631	643	649	finally
      //   651	654	649	finally
      //   224	231	733	finally
      //   233	369	733	finally
      //   369	427	733	finally
      //   427	430	733	finally
      //   662	730	733	finally
      //   735	738	733	finally
      //   509	572	927	finally
      //   572	601	927	finally
      //   606	625	927	finally
      //   746	786	927	finally
      //   791	810	927	finally
      //   816	899	927	finally
      //   899	902	927	finally
      //   908	924	927	finally
      //   929	932	927	finally
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, Bundle paramBundle);
    
    public abstract void ag(long paramLong1, long paramLong2);
    
    public abstract void b(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.c
 * JD-Core Version:    0.7.0.1
 */