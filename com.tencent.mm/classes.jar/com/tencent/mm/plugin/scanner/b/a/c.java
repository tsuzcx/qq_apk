package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static c OOB;
  public Object GXz;
  public Rect Gl;
  public b OOC;
  public Map OOo;
  public Object OOp;
  public ExecutorService OOq;
  public Rect OOr;
  public long OOu;
  public boolean OOw;
  public int OOx;
  public volatile boolean lYs;
  public int nSq;
  
  static
  {
    AppMethodBeat.i(118332);
    OOB = new c();
    AppMethodBeat.o(118332);
  }
  
  public c()
  {
    AppMethodBeat.i(118329);
    this.OOo = new HashMap();
    this.GXz = new Object();
    this.OOp = new Object();
    this.OOq = Executors.newSingleThreadExecutor();
    this.OOr = new Rect();
    this.Gl = new Rect();
    AppMethodBeat.o(118329);
  }
  
  public static c gQh()
  {
    return OOB;
  }
  
  public static boolean gQi()
  {
    AppMethodBeat.i(313408);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yRb, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LicenseCardDecodeQueue", "id_card_scan_v2: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(313408);
      return bool;
    }
  }
  
  public final void a(int paramInt, long paramLong, b paramb)
  {
    synchronized (this.GXz)
    {
      this.nSq = paramInt;
      this.OOu = paramLong;
      this.OOx = 0;
      this.OOC = paramb;
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(118330);
    Log.i("MicroMsg.LicenseCardDecodeQueue", "release");
    synchronized (this.OOp)
    {
      if (this.lYs) {
        LibCardRecog.recognizeCardRelease();
      }
      this.lYs = false;
      AppMethodBeat.o(118330);
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private boolean[] OOD;
    private byte[] OOy;
    private Point OOz;
    private long hBk;
    private int zTK;
    
    public a(long paramLong)
    {
      AppMethodBeat.i(118327);
      this.OOD = new boolean[4];
      this.hBk = paramLong;
      AppMethodBeat.o(118327);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 47
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   9: invokestatic 50	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   12: astore 6
      //   14: aload 6
      //   16: monitorenter
      //   17: aload_0
      //   18: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   21: iconst_1
      //   22: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   25: pop
      //   26: aload_0
      //   27: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:hBk	J
      //   30: aload_0
      //   31: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   34: invokestatic 57	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   37: lcmp
      //   38: ifne +614 -> 652
      //   41: aload_0
      //   42: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   45: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   48: invokeinterface 67 1 0
      //   53: ifne +98 -> 151
      //   56: aload_0
      //   57: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   60: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   63: ldc 69
      //   65: invokeinterface 73 2 0
      //   70: checkcast 74	[B
      //   73: astore 7
      //   75: aload_0
      //   76: aload 7
      //   78: aload 7
      //   80: arraylength
      //   81: invokestatic 80	java/util/Arrays:copyOf	([BI)[B
      //   84: putfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:OOy	[B
      //   87: aload_0
      //   88: new 84	android/graphics/Point
      //   91: dup
      //   92: aload_0
      //   93: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   96: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   99: ldc 86
      //   101: invokeinterface 73 2 0
      //   106: checkcast 84	android/graphics/Point
      //   109: invokespecial 89	android/graphics/Point:<init>	(Landroid/graphics/Point;)V
      //   112: putfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   115: aload_0
      //   116: aload_0
      //   117: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   120: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   123: ldc 93
      //   125: invokeinterface 73 2 0
      //   130: checkcast 95	java/lang/Integer
      //   133: invokevirtual 99	java/lang/Integer:intValue	()I
      //   136: putfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:zTK	I
      //   139: aload_0
      //   140: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   143: invokestatic 61	com/tencent/mm/plugin/scanner/b/a/c:c	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/util/Map;
      //   146: invokeinterface 104 1 0
      //   151: aload_0
      //   152: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   155: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   158: aload_0
      //   159: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   162: invokestatic 57	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   165: ldc2_w 109
      //   168: invokeinterface 116 5 0
      //   173: aload 6
      //   175: monitorexit
      //   176: iconst_0
      //   177: istore_2
      //   178: new 118	com/tencent/mm/plugin/licence/model/CardInfo
      //   181: dup
      //   182: aload_0
      //   183: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   186: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   189: invokevirtual 127	android/graphics/Rect:width	()I
      //   192: aload_0
      //   193: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   196: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   199: invokevirtual 130	android/graphics/Rect:height	()I
      //   202: invokespecial 133	com/tencent/mm/plugin/licence/model/CardInfo:<init>	(II)V
      //   205: astore 6
      //   207: aload_0
      //   208: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   211: invokestatic 136	com/tencent/mm/plugin/scanner/b/a/c:f	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   214: astore 7
      //   216: aload 7
      //   218: monitorenter
      //   219: iload_2
      //   220: istore_1
      //   221: aload_0
      //   222: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:OOy	[B
      //   225: ifnull +223 -> 448
      //   228: iload_2
      //   229: istore_1
      //   230: aload_0
      //   231: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:OOy	[B
      //   234: arraylength
      //   235: ifle +213 -> 448
      //   238: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   241: lstore_3
      //   242: aload_0
      //   243: getfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:zTK	I
      //   246: sipush 180
      //   249: irem
      //   250: ifeq +433 -> 683
      //   253: aload_0
      //   254: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   257: getfield 145	android/graphics/Point:x	I
      //   260: aload_0
      //   261: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   264: getfield 148	android/graphics/Point:y	I
      //   267: imul
      //   268: iconst_3
      //   269: imul
      //   270: iconst_2
      //   271: idiv
      //   272: newarray byte
      //   274: astore 8
      //   276: aload 8
      //   278: aload_0
      //   279: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:OOy	[B
      //   282: aload_0
      //   283: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   286: getfield 145	android/graphics/Point:x	I
      //   289: aload_0
      //   290: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   293: getfield 148	android/graphics/Point:y	I
      //   296: invokestatic 153	com/tencent/qbar/d:a	([B[BII)I
      //   299: pop
      //   300: aload 8
      //   302: aload_0
      //   303: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   306: getfield 145	android/graphics/Point:x	I
      //   309: aload_0
      //   310: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   313: getfield 148	android/graphics/Point:y	I
      //   316: aload_0
      //   317: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   320: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   323: getfield 156	android/graphics/Rect:left	I
      //   326: aload_0
      //   327: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   330: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   333: getfield 159	android/graphics/Rect:top	I
      //   336: aload_0
      //   337: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   340: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   343: invokevirtual 130	android/graphics/Rect:height	()I
      //   346: aload_0
      //   347: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   350: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   353: invokevirtual 127	android/graphics/Rect:width	()I
      //   356: aload 6
      //   358: aload_0
      //   359: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   362: invokestatic 165	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/CardInfo;[Z)I
      //   365: istore_2
      //   366: ldc 167
      //   368: ldc 169
      //   370: iconst_2
      //   371: anewarray 4	java/lang/Object
      //   374: dup
      //   375: iconst_0
      //   376: iload_2
      //   377: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   380: aastore
      //   381: dup
      //   382: iconst_1
      //   383: invokestatic 142	java/lang/System:currentTimeMillis	()J
      //   386: lload_3
      //   387: lsub
      //   388: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   391: aastore
      //   392: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   395: ldc 167
      //   397: ldc 185
      //   399: iconst_1
      //   400: anewarray 4	java/lang/Object
      //   403: dup
      //   404: iconst_0
      //   405: aload_0
      //   406: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   409: invokestatic 189	java/util/Arrays:toString	([Z)Ljava/lang/String;
      //   412: aastore
      //   413: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   416: aload_0
      //   417: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   420: invokestatic 193	com/tencent/mm/plugin/scanner/b/a/c:g	(Lcom/tencent/mm/plugin/scanner/b/a/c;)I
      //   423: pop
      //   424: iload_2
      //   425: istore_1
      //   426: invokestatic 196	com/tencent/mm/plugin/scanner/b/a/c:gQj	()Z
      //   429: ifeq +19 -> 448
      //   432: iload_2
      //   433: istore_1
      //   434: aload_0
      //   435: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   438: invokestatic 199	com/tencent/mm/plugin/scanner/b/a/c:h	(Lcom/tencent/mm/plugin/scanner/b/a/c;)I
      //   441: bipush 60
      //   443: if_icmpge +5 -> 448
      //   446: iconst_2
      //   447: istore_1
      //   448: aload 7
      //   450: monitorexit
      //   451: aload_0
      //   452: getfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:zTK	I
      //   455: sipush 180
      //   458: irem
      //   459: ifeq +59 -> 518
      //   462: aload_0
      //   463: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   466: iconst_0
      //   467: baload
      //   468: istore 5
      //   470: aload_0
      //   471: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   474: iconst_0
      //   475: aload_0
      //   476: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   479: iconst_2
      //   480: baload
      //   481: bastore
      //   482: aload_0
      //   483: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   486: iconst_2
      //   487: iload 5
      //   489: bastore
      //   490: aload_0
      //   491: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   494: iconst_1
      //   495: baload
      //   496: istore 5
      //   498: aload_0
      //   499: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   502: iconst_1
      //   503: aload_0
      //   504: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   507: iconst_3
      //   508: baload
      //   509: bastore
      //   510: aload_0
      //   511: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   514: iconst_3
      //   515: iload 5
      //   517: bastore
      //   518: aload_0
      //   519: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   522: invokestatic 50	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Ljava/lang/Object;
      //   525: astore 8
      //   527: aload 8
      //   529: monitorenter
      //   530: aload_0
      //   531: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:hBk	J
      //   534: aload_0
      //   535: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   538: invokestatic 57	com/tencent/mm/plugin/scanner/b/a/c:b	(Lcom/tencent/mm/plugin/scanner/b/a/c;)J
      //   541: lcmp
      //   542: ifne +551 -> 1093
      //   545: new 201	android/os/Bundle
      //   548: dup
      //   549: invokespecial 202	android/os/Bundle:<init>	()V
      //   552: astore 7
      //   554: aload 7
      //   556: ldc 204
      //   558: aload_0
      //   559: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   562: invokevirtual 208	android/os/Bundle:putBooleanArray	(Ljava/lang/String;[Z)V
      //   565: aload_0
      //   566: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   569: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   572: ifnull +21 -> 593
      //   575: aload_0
      //   576: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   579: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   582: aload_0
      //   583: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:hBk	J
      //   586: aload 7
      //   588: invokeinterface 211 4 0
      //   593: ldc 167
      //   595: ldc 213
      //   597: iconst_2
      //   598: anewarray 4	java/lang/Object
      //   601: dup
      //   602: iconst_0
      //   603: iload_1
      //   604: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   607: aastore
      //   608: dup
      //   609: iconst_1
      //   610: aload 6
      //   612: getfield 216	com/tencent/mm/plugin/licence/model/CardInfo:bitmapLen	I
      //   615: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   618: aastore
      //   619: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   622: iload_1
      //   623: iconst_1
      //   624: if_icmpeq +143 -> 767
      //   627: aload_0
      //   628: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   631: iconst_0
      //   632: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   635: pop
      //   636: aload_0
      //   637: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   640: invokestatic 219	com/tencent/mm/plugin/scanner/b/a/c:i	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   643: aload 8
      //   645: monitorexit
      //   646: ldc 47
      //   648: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   651: return
      //   652: aload_0
      //   653: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   656: iconst_0
      //   657: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   660: pop
      //   661: aload 6
      //   663: monitorexit
      //   664: ldc 47
      //   666: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   669: return
      //   670: astore 7
      //   672: aload 6
      //   674: monitorexit
      //   675: ldc 47
      //   677: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   680: aload 7
      //   682: athrow
      //   683: aload_0
      //   684: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:OOy	[B
      //   687: aload_0
      //   688: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   691: getfield 148	android/graphics/Point:y	I
      //   694: aload_0
      //   695: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   698: getfield 145	android/graphics/Point:x	I
      //   701: aload_0
      //   702: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   705: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   708: getfield 156	android/graphics/Rect:left	I
      //   711: aload_0
      //   712: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   715: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   718: getfield 159	android/graphics/Rect:top	I
      //   721: aload_0
      //   722: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   725: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   728: invokevirtual 130	android/graphics/Rect:height	()I
      //   731: aload_0
      //   732: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   735: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   738: invokevirtual 127	android/graphics/Rect:width	()I
      //   741: aload 6
      //   743: aload_0
      //   744: getfield 37	com/tencent/mm/plugin/scanner/b/a/c$a:OOD	[Z
      //   747: invokestatic 165	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/CardInfo;[Z)I
      //   750: istore_2
      //   751: goto -385 -> 366
      //   754: astore 6
      //   756: aload 7
      //   758: monitorexit
      //   759: ldc 47
      //   761: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   764: aload 6
      //   766: athrow
      //   767: new 221	android/graphics/BitmapFactory$Options
      //   770: dup
      //   771: invokespecial 222	android/graphics/BitmapFactory$Options:<init>	()V
      //   774: astore 7
      //   776: aload 7
      //   778: iconst_1
      //   779: putfield 225	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   782: aload 6
      //   784: getfield 228	com/tencent/mm/plugin/licence/model/CardInfo:bitmapData	[B
      //   787: iconst_0
      //   788: aload 6
      //   790: getfield 216	com/tencent/mm/plugin/licence/model/CardInfo:bitmapLen	I
      //   793: aload 7
      //   795: invokestatic 234	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   798: getstatic 240	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   801: iconst_1
      //   802: invokevirtual 246	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   805: astore 7
      //   807: invokestatic 196	com/tencent/mm/plugin/scanner/b/a/c:gQj	()Z
      //   810: ifeq +182 -> 992
      //   813: iconst_1
      //   814: aload_0
      //   815: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   818: invokestatic 249	com/tencent/mm/plugin/scanner/b/a/c:j	(Lcom/tencent/mm/plugin/scanner/b/a/c;)I
      //   821: if_icmpne +171 -> 992
      //   824: aload_0
      //   825: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:OOy	[B
      //   828: astore 6
      //   830: aload_0
      //   831: getfield 101	com/tencent/mm/plugin/scanner/b/a/c$a:zTK	I
      //   834: sipush 180
      //   837: irem
      //   838: ifeq +50 -> 888
      //   841: aload_0
      //   842: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   845: getfield 145	android/graphics/Point:x	I
      //   848: aload_0
      //   849: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   852: getfield 148	android/graphics/Point:y	I
      //   855: imul
      //   856: iconst_3
      //   857: imul
      //   858: iconst_2
      //   859: idiv
      //   860: newarray byte
      //   862: astore 6
      //   864: aload 6
      //   866: aload_0
      //   867: getfield 82	com/tencent/mm/plugin/scanner/b/a/c$a:OOy	[B
      //   870: aload_0
      //   871: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   874: getfield 145	android/graphics/Point:x	I
      //   877: aload_0
      //   878: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   881: getfield 148	android/graphics/Point:y	I
      //   884: invokestatic 153	com/tencent/qbar/d:a	([B[BII)I
      //   887: pop
      //   888: new 251	android/graphics/YuvImage
      //   891: dup
      //   892: aload 6
      //   894: bipush 17
      //   896: aload_0
      //   897: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   900: getfield 148	android/graphics/Point:y	I
      //   903: aload_0
      //   904: getfield 91	com/tencent/mm/plugin/scanner/b/a/c$a:OOz	Landroid/graphics/Point;
      //   907: getfield 145	android/graphics/Point:x	I
      //   910: aconst_null
      //   911: invokespecial 254	android/graphics/YuvImage:<init>	([BIII[I)V
      //   914: astore 6
      //   916: new 256	java/io/ByteArrayOutputStream
      //   919: dup
      //   920: invokespecial 257	java/io/ByteArrayOutputStream:<init>	()V
      //   923: astore 9
      //   925: aload 6
      //   927: aload_0
      //   928: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   931: invokestatic 122	com/tencent/mm/plugin/scanner/b/a/c:e	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Landroid/graphics/Rect;
      //   934: bipush 40
      //   936: aload 9
      //   938: invokevirtual 261	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
      //   941: pop
      //   942: aload 9
      //   944: invokevirtual 265	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   947: astore 6
      //   949: aload 6
      //   951: iconst_0
      //   952: aload 6
      //   954: arraylength
      //   955: invokestatic 268	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   958: astore 6
      //   960: aload 6
      //   962: ifnonnull +37 -> 999
      //   965: aload_0
      //   966: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   969: iconst_0
      //   970: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   973: pop
      //   974: aload_0
      //   975: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   978: invokestatic 219	com/tencent/mm/plugin/scanner/b/a/c:i	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   981: aload 8
      //   983: monitorexit
      //   984: ldc 47
      //   986: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   989: return
      //   990: astore 6
      //   992: aload 7
      //   994: astore 6
      //   996: goto -36 -> 960
      //   999: ldc 167
      //   1001: ldc_w 270
      //   1004: iconst_2
      //   1005: anewarray 4	java/lang/Object
      //   1008: dup
      //   1009: iconst_0
      //   1010: aload 6
      //   1012: invokevirtual 273	android/graphics/Bitmap:getWidth	()I
      //   1015: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1018: aastore
      //   1019: dup
      //   1020: iconst_1
      //   1021: aload 6
      //   1023: invokevirtual 276	android/graphics/Bitmap:getHeight	()I
      //   1026: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1029: aastore
      //   1030: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1033: new 201	android/os/Bundle
      //   1036: dup
      //   1037: invokespecial 202	android/os/Bundle:<init>	()V
      //   1040: astore 7
      //   1042: aload 7
      //   1044: ldc_w 278
      //   1047: aload 6
      //   1049: bipush 80
      //   1051: invokestatic 284	com/tencent/mm/sdk/platformtools/BitmapUtil:Bitmap2Bytes	(Landroid/graphics/Bitmap;I)[B
      //   1054: invokevirtual 288	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
      //   1057: aload_0
      //   1058: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1061: invokestatic 108	com/tencent/mm/plugin/scanner/b/a/c:d	(Lcom/tencent/mm/plugin/scanner/b/a/c;)Lcom/tencent/mm/plugin/scanner/b/a/c$b;
      //   1064: aload_0
      //   1065: getfield 39	com/tencent/mm/plugin/scanner/b/a/c$a:hBk	J
      //   1068: aload 7
      //   1070: invokeinterface 290 4 0
      //   1075: aload_0
      //   1076: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1079: iconst_0
      //   1080: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   1083: pop
      //   1084: aload 8
      //   1086: monitorexit
      //   1087: ldc 47
      //   1089: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1092: return
      //   1093: aload_0
      //   1094: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1097: iconst_0
      //   1098: invokestatic 53	com/tencent/mm/plugin/scanner/b/a/c:a	(Lcom/tencent/mm/plugin/scanner/b/a/c;Z)Z
      //   1101: pop
      //   1102: aload_0
      //   1103: getfield 25	com/tencent/mm/plugin/scanner/b/a/c$a:OOE	Lcom/tencent/mm/plugin/scanner/b/a/c;
      //   1106: invokestatic 219	com/tencent/mm/plugin/scanner/b/a/c:i	(Lcom/tencent/mm/plugin/scanner/b/a/c;)V
      //   1109: goto -25 -> 1084
      //   1112: astore 6
      //   1114: aload 8
      //   1116: monitorexit
      //   1117: ldc 47
      //   1119: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1122: aload 6
      //   1124: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1125	0	this	a
      //   220	405	1	i	int
      //   177	574	2	j	int
      //   241	146	3	l	long
      //   468	48	5	k	int
      //   12	730	6	localObject1	Object
      //   754	35	6	localObject2	Object
      //   828	133	6	localObject3	Object
      //   990	1	6	localRuntimeException	java.lang.RuntimeException
      //   994	54	6	localObject4	Object
      //   1112	11	6	localObject5	Object
      //   73	514	7	localObject6	Object
      //   670	87	7	localObject7	Object
      //   774	295	7	localObject8	Object
      //   923	20	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      // Exception table:
      //   from	to	target	type
      //   17	151	670	finally
      //   151	173	670	finally
      //   652	664	670	finally
      //   221	228	754	finally
      //   230	366	754	finally
      //   366	424	754	finally
      //   426	432	754	finally
      //   434	446	754	finally
      //   448	451	754	finally
      //   683	751	754	finally
      //   888	960	990	java/lang/RuntimeException
      //   530	593	1112	finally
      //   593	622	1112	finally
      //   627	646	1112	finally
      //   767	830	1112	finally
      //   830	888	1112	finally
      //   888	960	1112	finally
      //   965	984	1112	finally
      //   999	1084	1112	finally
      //   1084	1087	1112	finally
      //   1093	1109	1112	finally
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, Bundle paramBundle);
    
    public abstract void b(long paramLong, Bundle paramBundle);
    
    public abstract void bc(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.c
 * JD-Core Version:    0.7.0.1
 */