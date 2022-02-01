package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static c IID;
  public Object Brg;
  public b IIE;
  public Map IIq;
  public Object IIr;
  public ExecutorService IIs;
  public Rect IIt;
  public long IIw;
  public boolean IIy;
  public int IIz;
  public volatile boolean jvb;
  public Rect kXj;
  public int lnm;
  
  static
  {
    AppMethodBeat.i(118332);
    IID = new c();
    AppMethodBeat.o(118332);
  }
  
  public c()
  {
    AppMethodBeat.i(118329);
    this.IIq = new HashMap();
    this.Brg = new Object();
    this.IIr = new Object();
    this.IIs = Executors.newSingleThreadExecutor();
    this.IIt = new Rect();
    this.kXj = new Rect();
    AppMethodBeat.o(118329);
  }
  
  public static c fCv()
  {
    return IID;
  }
  
  public static boolean fCw()
  {
    AppMethodBeat.i(243251);
    if (((b)h.ae(b.class)).a(b.a.vCF, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LicenseCardDecodeQueue", "id_card_scan_v2: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(243251);
      return bool;
    }
  }
  
  public final void a(int paramInt, long paramLong, b paramb)
  {
    synchronized (this.Brg)
    {
      this.lnm = paramInt;
      this.IIw = paramLong;
      this.IIz = 0;
      this.IIE = paramb;
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(118330);
    Log.i("MicroMsg.LicenseCardDecodeQueue", "release");
    synchronized (this.IIr)
    {
      if (this.jvb) {
        LibCardRecog.recognizeCardRelease();
      }
      this.jvb = false;
      AppMethodBeat.o(118330);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private byte[] IIA;
    private Point IIB;
    private boolean[] IIF;
    private long fwK;
    private int wxE;
    
    public a(long paramLong)
    {
      AppMethodBeat.i(118327);
      this.IIF = new boolean[4];
      this.fwK = paramLong;
      AppMethodBeat.o(118327);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 47
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   9: invokestatic 50	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   12: astore 6
      //   14: aload 6
      //   16: monitorenter
      //   17: aload_0
      //   18: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   21: iconst_1
      //   22: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   25: pop
      //   26: aload_0
      //   27: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:fwK	J
      //   30: aload_0
      //   31: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   34: invokestatic 57	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   37: lcmp
      //   38: ifne +617 -> 655
      //   41: aload_0
      //   42: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   45: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   48: invokeinterface 67 1 0
      //   53: ifne +101 -> 154
      //   56: aload_0
      //   57: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   60: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   63: ldc 69
      //   65: invokeinterface 73 2 0
      //   70: checkcast 74	[B
      //   73: checkcast 74	[B
      //   76: astore 7
      //   78: aload_0
      //   79: aload 7
      //   81: aload 7
      //   83: arraylength
      //   84: invokestatic 80	java/util/Arrays:copyOf	([BI)[B
      //   87: putfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:IIA	[B
      //   90: aload_0
      //   91: new 84	android/graphics/Point
      //   94: dup
      //   95: aload_0
      //   96: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   99: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   102: ldc 86
      //   104: invokeinterface 73 2 0
      //   109: checkcast 84	android/graphics/Point
      //   112: invokespecial 89	android/graphics/Point:<init>	(Landroid/graphics/Point;)V
      //   115: putfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   118: aload_0
      //   119: aload_0
      //   120: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   123: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   126: ldc 93
      //   128: invokeinterface 73 2 0
      //   133: checkcast 95	java/lang/Integer
      //   136: invokevirtual 99	java/lang/Integer:intValue	()I
      //   139: putfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:wxE	I
      //   142: aload_0
      //   143: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   146: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   149: invokeinterface 104 1 0
      //   154: aload_0
      //   155: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   158: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   161: aload_0
      //   162: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   165: invokestatic 57	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   168: ldc2_w 109
      //   171: invokeinterface 116 5 0
      //   176: aload 6
      //   178: monitorexit
      //   179: iconst_0
      //   180: istore_2
      //   181: new 118	com/tencent/mm/plugin/licence/model/CardInfo
      //   184: dup
      //   185: aload_0
      //   186: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   189: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   192: invokevirtual 127	android/graphics/Rect:width	()I
      //   195: aload_0
      //   196: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   199: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   202: invokevirtual 130	android/graphics/Rect:height	()I
      //   205: invokespecial 133	com/tencent/mm/plugin/licence/model/CardInfo:<init>	(II)V
      //   208: astore 6
      //   210: aload_0
      //   211: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   214: invokestatic 136	com/tencent/mm/plugin/scanner/b/a/c:f	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   217: astore 7
      //   219: aload 7
      //   221: monitorenter
      //   222: iload_2
      //   223: istore_1
      //   224: aload_0
      //   225: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:IIA	[B
      //   228: ifnull +223 -> 451
      //   231: iload_2
      //   232: istore_1
      //   233: aload_0
      //   234: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:IIA	[B
      //   237: arraylength
      //   238: ifle +213 -> 451
      //   241: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   244: lstore_3
      //   245: aload_0
      //   246: getfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:wxE	I
      //   249: sipush 180
      //   252: irem
      //   253: ifeq +433 -> 686
      //   256: aload_0
      //   257: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   260: getfield 145	android/graphics/Point:x	I
      //   263: aload_0
      //   264: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   267: getfield 148	android/graphics/Point:y	I
      //   270: imul
      //   271: iconst_3
      //   272: imul
      //   273: iconst_2
      //   274: idiv
      //   275: newarray byte
      //   277: astore 8
      //   279: aload 8
      //   281: aload_0
      //   282: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:IIA	[B
      //   285: aload_0
      //   286: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   289: getfield 145	android/graphics/Point:x	I
      //   292: aload_0
      //   293: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   296: getfield 148	android/graphics/Point:y	I
      //   299: invokestatic 153	com/tencent/qbar/d:a	([B[BII)I
      //   302: pop
      //   303: aload 8
      //   305: aload_0
      //   306: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   309: getfield 145	android/graphics/Point:x	I
      //   312: aload_0
      //   313: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   316: getfield 148	android/graphics/Point:y	I
      //   319: aload_0
      //   320: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   323: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   326: getfield 156	android/graphics/Rect:left	I
      //   329: aload_0
      //   330: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   333: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   336: getfield 159	android/graphics/Rect:top	I
      //   339: aload_0
      //   340: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   343: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   346: invokevirtual 130	android/graphics/Rect:height	()I
      //   349: aload_0
      //   350: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   353: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   356: invokevirtual 127	android/graphics/Rect:width	()I
      //   359: aload 6
      //   361: aload_0
      //   362: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   365: invokestatic 165	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/CardInfo;[Z)I
      //   368: istore_2
      //   369: ldc 167
      //   371: ldc 169
      //   373: iconst_2
      //   374: anewarray 4	java/lang/Object
      //   377: dup
      //   378: iconst_0
      //   379: iload_2
      //   380: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   383: aastore
      //   384: dup
      //   385: iconst_1
      //   386: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   389: lload_3
      //   390: lsub
      //   391: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   394: aastore
      //   395: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   398: ldc 167
      //   400: ldc 185
      //   402: iconst_1
      //   403: anewarray 4	java/lang/Object
      //   406: dup
      //   407: iconst_0
      //   408: aload_0
      //   409: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   412: invokestatic 189	java/util/Arrays:toString	([Z)Ljava/lang/String;
      //   415: aastore
      //   416: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   419: aload_0
      //   420: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   423: invokestatic 193	com/tencent/mm/plugin/scanner/b/a/c:g	(Lcom/tencent/mm/plugin/scanner/b/a/c;)I
      //   426: pop
      //   427: iload_2
      //   428: istore_1
      //   429: invokestatic 196	com/tencent/mm/plugin/scanner/b/a/c:fCx	()Z
      //   432: ifeq +19 -> 451
      //   435: iload_2
      //   436: istore_1
      //   437: aload_0
      //   438: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   441: invokestatic 199	com/tencent/mm/plugin/scanner/b/a/c:h	(Lcom/tencent/mm/plugin/scanner/b/a/c;)I
      //   444: bipush 60
      //   446: if_icmpge +5 -> 451
      //   449: iconst_2
      //   450: istore_1
      //   451: aload 7
      //   453: monitorexit
      //   454: aload_0
      //   455: getfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:wxE	I
      //   458: sipush 180
      //   461: irem
      //   462: ifeq +59 -> 521
      //   465: aload_0
      //   466: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   469: iconst_0
      //   470: baload
      //   471: istore 5
      //   473: aload_0
      //   474: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   477: iconst_0
      //   478: aload_0
      //   479: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   482: iconst_2
      //   483: baload
      //   484: bastore
      //   485: aload_0
      //   486: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   489: iconst_2
      //   490: iload 5
      //   492: bastore
      //   493: aload_0
      //   494: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   497: iconst_1
      //   498: baload
      //   499: istore 5
      //   501: aload_0
      //   502: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   505: iconst_1
      //   506: aload_0
      //   507: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   510: iconst_3
      //   511: baload
      //   512: bastore
      //   513: aload_0
      //   514: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   517: iconst_3
      //   518: iload 5
      //   520: bastore
      //   521: aload_0
      //   522: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   525: invokestatic 50	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   528: astore 8
      //   530: aload 8
      //   532: monitorenter
      //   533: aload_0
      //   534: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:fwK	J
      //   537: aload_0
      //   538: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   541: invokestatic 57	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   544: lcmp
      //   545: ifne +551 -> 1096
      //   548: new 201	android/os/Bundle
      //   551: dup
      //   552: invokespecial 202	android/os/Bundle:<init>	()V
      //   555: astore 7
      //   557: aload 7
      //   559: ldc 204
      //   561: aload_0
      //   562: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   565: invokevirtual 208	android/os/Bundle:putBooleanArray	(Ljava/lang/String;[Z)V
      //   568: aload_0
      //   569: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   572: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   575: ifnull +21 -> 596
      //   578: aload_0
      //   579: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   582: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   585: aload_0
      //   586: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:fwK	J
      //   589: aload 7
      //   591: invokeinterface 211 4 0
      //   596: ldc 167
      //   598: ldc 213
      //   600: iconst_2
      //   601: anewarray 4	java/lang/Object
      //   604: dup
      //   605: iconst_0
      //   606: iload_1
      //   607: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   610: aastore
      //   611: dup
      //   612: iconst_1
      //   613: aload 6
      //   615: getfield 216	com/tencent/mm/plugin/licence/model/CardInfo:bitmapLen	I
      //   618: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   621: aastore
      //   622: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   625: iload_1
      //   626: iconst_1
      //   627: if_icmpeq +143 -> 770
      //   630: aload_0
      //   631: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   634: iconst_0
      //   635: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   638: pop
      //   639: aload_0
      //   640: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   643: invokestatic 219	com/tencent/mm/plugin/scanner/b/a/c:i	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   646: aload 8
      //   648: monitorexit
      //   649: ldc 47
      //   651: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   654: return
      //   655: aload_0
      //   656: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   659: iconst_0
      //   660: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   663: pop
      //   664: aload 6
      //   666: monitorexit
      //   667: ldc 47
      //   669: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   672: return
      //   673: astore 7
      //   675: aload 6
      //   677: monitorexit
      //   678: ldc 47
      //   680: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   683: aload 7
      //   685: athrow
      //   686: aload_0
      //   687: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:IIA	[B
      //   690: aload_0
      //   691: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   694: getfield 148	android/graphics/Point:y	I
      //   697: aload_0
      //   698: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   701: getfield 145	android/graphics/Point:x	I
      //   704: aload_0
      //   705: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   708: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   711: getfield 156	android/graphics/Rect:left	I
      //   714: aload_0
      //   715: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   718: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   721: getfield 159	android/graphics/Rect:top	I
      //   724: aload_0
      //   725: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   728: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   731: invokevirtual 130	android/graphics/Rect:height	()I
      //   734: aload_0
      //   735: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   738: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   741: invokevirtual 127	android/graphics/Rect:width	()I
      //   744: aload 6
      //   746: aload_0
      //   747: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:IIF	[Z
      //   750: invokestatic 165	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/CardInfo;[Z)I
      //   753: istore_2
      //   754: goto -385 -> 369
      //   757: astore 6
      //   759: aload 7
      //   761: monitorexit
      //   762: ldc 47
      //   764: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   767: aload 6
      //   769: athrow
      //   770: new 221	android/graphics/BitmapFactory$Options
      //   773: dup
      //   774: invokespecial 222	android/graphics/BitmapFactory$Options:<init>	()V
      //   777: astore 7
      //   779: aload 7
      //   781: iconst_1
      //   782: putfield 225	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   785: aload 6
      //   787: getfield 228	com/tencent/mm/plugin/licence/model/CardInfo:bitmapData	[B
      //   790: iconst_0
      //   791: aload 6
      //   793: getfield 216	com/tencent/mm/plugin/licence/model/CardInfo:bitmapLen	I
      //   796: aload 7
      //   798: invokestatic 234	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   801: getstatic 240	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   804: iconst_1
      //   805: invokevirtual 246	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   808: astore 7
      //   810: invokestatic 196	com/tencent/mm/plugin/scanner/b/a/c:fCx	()Z
      //   813: ifeq +182 -> 995
      //   816: iconst_1
      //   817: aload_0
      //   818: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   821: invokestatic 249	com/tencent/mm/plugin/scanner/b/a/c:j	(Lcom/tencent/mm/plugin/scanner/b/a/c;)I
      //   824: if_icmpne +171 -> 995
      //   827: aload_0
      //   828: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:IIA	[B
      //   831: astore 6
      //   833: aload_0
      //   834: getfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:wxE	I
      //   837: sipush 180
      //   840: irem
      //   841: ifeq +50 -> 891
      //   844: aload_0
      //   845: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   848: getfield 145	android/graphics/Point:x	I
      //   851: aload_0
      //   852: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   855: getfield 148	android/graphics/Point:y	I
      //   858: imul
      //   859: iconst_3
      //   860: imul
      //   861: iconst_2
      //   862: idiv
      //   863: newarray byte
      //   865: astore 6
      //   867: aload 6
      //   869: aload_0
      //   870: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:IIA	[B
      //   873: aload_0
      //   874: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   877: getfield 145	android/graphics/Point:x	I
      //   880: aload_0
      //   881: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   884: getfield 148	android/graphics/Point:y	I
      //   887: invokestatic 153	com/tencent/qbar/d:a	([B[BII)I
      //   890: pop
      //   891: new 251	android/graphics/YuvImage
      //   894: dup
      //   895: aload 6
      //   897: bipush 17
      //   899: aload_0
      //   900: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   903: getfield 148	android/graphics/Point:y	I
      //   906: aload_0
      //   907: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:IIB	Landroid/graphics/Point;
      //   910: getfield 145	android/graphics/Point:x	I
      //   913: aconst_null
      //   914: invokespecial 254	android/graphics/YuvImage:<init>	([BIII[I)V
      //   917: astore 6
      //   919: new 256	java/io/ByteArrayOutputStream
      //   922: dup
      //   923: invokespecial 257	java/io/ByteArrayOutputStream:<init>	()V
      //   926: astore 9
      //   928: aload 6
      //   930: aload_0
      //   931: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   934: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   937: bipush 40
      //   939: aload 9
      //   941: invokevirtual 261	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
      //   944: pop
      //   945: aload 9
      //   947: invokevirtual 265	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   950: astore 6
      //   952: aload 6
      //   954: iconst_0
      //   955: aload 6
      //   957: arraylength
      //   958: invokestatic 268	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   961: astore 6
      //   963: aload 6
      //   965: ifnonnull +37 -> 1002
      //   968: aload_0
      //   969: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   972: iconst_0
      //   973: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   976: pop
      //   977: aload_0
      //   978: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   981: invokestatic 219	com/tencent/mm/plugin/scanner/b/a/c:i	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   984: aload 8
      //   986: monitorexit
      //   987: ldc 47
      //   989: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   992: return
      //   993: astore 6
      //   995: aload 7
      //   997: astore 6
      //   999: goto -36 -> 963
      //   1002: ldc 167
      //   1004: ldc_w 270
      //   1007: iconst_2
      //   1008: anewarray 4	java/lang/Object
      //   1011: dup
      //   1012: iconst_0
      //   1013: aload 6
      //   1015: invokevirtual 273	android/graphics/Bitmap:getWidth	()I
      //   1018: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1021: aastore
      //   1022: dup
      //   1023: iconst_1
      //   1024: aload 6
      //   1026: invokevirtual 276	android/graphics/Bitmap:getHeight	()I
      //   1029: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1032: aastore
      //   1033: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1036: new 201	android/os/Bundle
      //   1039: dup
      //   1040: invokespecial 202	android/os/Bundle:<init>	()V
      //   1043: astore 7
      //   1045: aload 7
      //   1047: ldc_w 278
      //   1050: aload 6
      //   1052: bipush 80
      //   1054: invokestatic 284	com/tencent/mm/sdk/platformtools/BitmapUtil:Bitmap2Bytes	(Landroid/graphics/Bitmap;I)[B
      //   1057: invokevirtual 288	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   1060: aload_0
      //   1061: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1064: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   1067: aload_0
      //   1068: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:fwK	J
      //   1071: aload 7
      //   1073: invokeinterface 290 4 0
      //   1078: aload_0
      //   1079: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1082: iconst_0
      //   1083: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   1086: pop
      //   1087: aload 8
      //   1089: monitorexit
      //   1090: ldc 47
      //   1092: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1095: return
      //   1096: aload_0
      //   1097: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1100: iconst_0
      //   1101: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   1104: pop
      //   1105: aload_0
      //   1106: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:IIG	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1109: invokestatic 219	com/tencent/mm/plugin/scanner/b/a/c:i	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   1112: goto -25 -> 1087
      //   1115: astore 6
      //   1117: aload 8
      //   1119: monitorexit
      //   1120: ldc 47
      //   1122: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1125: aload 6
      //   1127: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1128	0	this	a
      //   223	405	1	i	int
      //   180	574	2	j	int
      //   244	146	3	l	long
      //   471	48	5	k	int
      //   12	733	6	localObject1	Object
      //   757	35	6	localObject2	Object
      //   831	133	6	localObject3	Object
      //   993	1	6	localRuntimeException	java.lang.RuntimeException
      //   997	54	6	localObject4	Object
      //   1115	11	6	localObject5	Object
      //   76	514	7	localObject6	Object
      //   673	87	7	localObject7	Object
      //   777	295	7	localObject8	Object
      //   926	20	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      // Exception table:
      //   from	to	target	type
      //   17	154	673	finally
      //   154	176	673	finally
      //   655	667	673	finally
      //   224	231	757	finally
      //   233	369	757	finally
      //   369	427	757	finally
      //   429	435	757	finally
      //   437	449	757	finally
      //   451	454	757	finally
      //   686	754	757	finally
      //   891	963	993	java/lang/RuntimeException
      //   533	596	1115	finally
      //   596	625	1115	finally
      //   630	649	1115	finally
      //   770	833	1115	finally
      //   833	891	1115	finally
      //   891	963	1115	finally
      //   968	987	1115	finally
      //   1002	1087	1115	finally
      //   1087	1090	1115	finally
      //   1096	1112	1115	finally
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, Bundle paramBundle);
    
    public abstract void as(long paramLong1, long paramLong2);
    
    public abstract void b(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.c
 * JD-Core Version:    0.7.0.1
 */