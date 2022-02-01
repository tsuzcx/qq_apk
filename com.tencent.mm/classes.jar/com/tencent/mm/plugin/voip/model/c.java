package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static float volume = 0.0F;
  private com.tencent.f.i.b EgU;
  public boolean GSW;
  boolean GSX;
  boolean GSY;
  l GSZ;
  private long GTA;
  private int GTB;
  private int GTC;
  private final Object GTD;
  private int GTE;
  int GTF;
  private int GTG;
  private int GTH;
  private int GTI;
  private int GTa;
  private byte[] GTb;
  private byte[] GTc;
  private byte[] GTd;
  private byte[] GTe;
  private byte[] GTf;
  public int GTg;
  AtomicBoolean GTh;
  public b GTi;
  private int GTj;
  private int GTk;
  private int GTl;
  String GTm;
  private int GTn;
  private int GTo;
  private int GTp;
  private int GTq;
  private int GTr;
  private int GTs;
  private int GTt;
  private long GTu;
  private long GTv;
  private int GTw;
  private int GTx;
  private int GTy;
  private int GTz;
  AudioTrack bfn;
  Context context;
  private Timer dzR;
  private boolean dzS;
  private int gEe;
  private com.tencent.mm.audio.c.a.a juN;
  int juY;
  private int juZ;
  int jvb;
  int jvc;
  private boolean jvd;
  private int nSamplerate;
  private int omD;
  
  public c()
  {
    AppMethodBeat.i(114815);
    this.GSW = false;
    this.GSX = false;
    this.GSY = true;
    this.GSZ = null;
    this.juY = 2;
    this.jvb = 0;
    this.GTa = 0;
    this.GTb = null;
    this.GTc = null;
    this.GTd = null;
    this.GTe = null;
    this.GTf = null;
    this.nSamplerate = 0;
    this.GTg = 0;
    this.juZ = 0;
    this.jvc = 20;
    this.bfn = null;
    this.GTh = new AtomicBoolean(false);
    this.GTi = null;
    this.dzR = null;
    this.dzS = false;
    this.GTj = 1;
    this.GTk = 1;
    this.GTl = 0;
    this.GTm = null;
    this.gEe = 3;
    this.jvd = false;
    this.GTn = 0;
    this.GTo = 0;
    this.GTp = 0;
    this.GTq = 0;
    this.GTr = 0;
    this.GTs = 1;
    this.GTt = 0;
    this.GTu = 0L;
    this.GTv = 0L;
    this.GTw = 1;
    this.GTx = 0;
    this.GTy = -1;
    this.GTz = 0;
    this.GTA = 0L;
    this.GTB = 1;
    this.GTC = 0;
    this.GTD = new Object();
    this.GTE = 0;
    this.GTF = 0;
    this.GTG = 0;
    this.omD = 0;
    this.GTH = 0;
    this.GTI = 0;
    AppMethodBeat.o(114815);
  }
  
  private int wT(boolean paramBoolean)
  {
    AppMethodBeat.i(114818);
    int j = 0;
    int i;
    if (ae.gKu.gDB > 0)
    {
      j = com.tencent.mm.plugin.audio.c.a.jv(paramBoolean);
      if ((!paramBoolean) || (ae.gKu.gEh < 0)) {
        break label113;
      }
      i = ae.gKu.gEh;
      label41:
      j = i;
      if (1 == this.omD)
      {
        if (ae.gKu.gEW >= 0) {
          i = ae.gKu.gEW;
        }
        if ((!paramBoolean) || (ae.gKu.gEX < 0)) {
          break label140;
        }
        j = ae.gKu.gEX;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114818);
      return j;
      if (ae.gKu.gEg < 0) {
        break;
      }
      j = ae.gKu.gEg;
      break;
      label113:
      i = j;
      if (paramBoolean) {
        break label41;
      }
      i = j;
      if (ae.gKu.gEi < 0) {
        break label41;
      }
      i = ae.gKu.gEi;
      break label41;
      label140:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (ae.gKu.gEY >= 0) {
          j = ae.gKu.gEY;
        }
      }
    }
  }
  
  /* Error */
  public final int F(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 282
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 284
    //   9: ldc_w 286
    //   12: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 293	com/tencent/mm/plugin/voip/model/c:context	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 121	com/tencent/mm/plugin/voip/model/c:GTg	I
    //   24: iconst_2
    //   25: if_icmpne +54 -> 79
    //   28: aload_0
    //   29: iconst_3
    //   30: putfield 103	com/tencent/mm/plugin/voip/model/c:juY	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   38: aload_0
    //   39: getfield 103	com/tencent/mm/plugin/voip/model/c:juY	I
    //   42: iconst_2
    //   43: invokestatic 299	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: putfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   49: aload_0
    //   50: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   53: bipush 254
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   62: iconst_m1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 188	com/tencent/mm/plugin/voip/model/c:GTE	I
    //   71: ldc_w 282
    //   74: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_0
    //   80: iconst_2
    //   81: putfield 103	com/tencent/mm/plugin/voip/model/c:juY	I
    //   84: goto -51 -> 33
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   92: putfield 162	com/tencent/mm/plugin/voip/model/c:GTr	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 162	com/tencent/mm/plugin/voip/model/c:GTr	I
    //   100: aload_0
    //   101: getfield 172	com/tencent/mm/plugin/voip/model/c:GTw	I
    //   104: imul
    //   105: putfield 174	com/tencent/mm/plugin/voip/model/c:GTx	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   113: aload_0
    //   114: getfield 182	com/tencent/mm/plugin/voip/model/c:GTB	I
    //   117: imul
    //   118: putfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   121: aload_0
    //   122: getfield 162	com/tencent/mm/plugin/voip/model/c:GTr	I
    //   125: iconst_1
    //   126: ishr
    //   127: i2f
    //   128: aload_0
    //   129: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   132: i2f
    //   133: fdiv
    //   134: fstore_3
    //   135: invokestatic 305	com/tencent/mm/compatible/deviceinfo/m:aon	()I
    //   138: istore 4
    //   140: getstatic 247	com/tencent/mm/compatible/deviceinfo/ae:gKu	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   143: getfield 308	com/tencent/mm/compatible/deviceinfo/b:gEM	I
    //   146: istore 5
    //   148: iload 4
    //   150: sipush 1024
    //   153: iand
    //   154: ifeq +313 -> 467
    //   157: iload 5
    //   159: istore 4
    //   161: iload 5
    //   163: ifgt +6 -> 169
    //   166: iconst_0
    //   167: istore 4
    //   169: ldc_w 284
    //   172: ldc_w 310
    //   175: iload 4
    //   177: invokestatic 316	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   180: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 323
    //   189: fload_3
    //   190: fmul
    //   191: ldc_w 324
    //   194: fcmpg
    //   195: iflt +10 -> 205
    //   198: aload_0
    //   199: getfield 194	com/tencent/mm/plugin/voip/model/c:omD	I
    //   202: ifeq +6 -> 208
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +263 -> 473
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: iload 6
    //   219: putfield 99	com/tencent/mm/plugin/voip/model/c:GSY	Z
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 99	com/tencent/mm/plugin/voip/model/c:GSY	Z
    //   227: ldc_w 284
    //   230: new 326	java/lang/StringBuilder
    //   233: dup
    //   234: ldc_w 328
    //   237: invokespecial 331	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   244: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 337
    //   250: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: fload_3
    //   254: invokevirtual 343	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   257: ldc_w 345
    //   260: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 99	com/tencent/mm/plugin/voip/model/c:GSY	Z
    //   267: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: iload_2
    //   278: invokespecial 354	com/tencent/mm/plugin/voip/model/c:wT	(Z)I
    //   281: istore 4
    //   283: aload_0
    //   284: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +20 -> 309
    //   292: aload_0
    //   293: getfield 134	com/tencent/mm/plugin/voip/model/c:GTh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: iconst_0
    //   297: iconst_1
    //   298: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   301: pop
    //   302: aload_0
    //   303: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   306: invokevirtual 361	android/media/AudioTrack:release	()V
    //   309: aload_0
    //   310: new 363	com/tencent/mm/compatible/b/e
    //   313: dup
    //   314: iload 4
    //   316: aload_0
    //   317: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   320: aload_0
    //   321: getfield 103	com/tencent/mm/plugin/voip/model/c:juY	I
    //   324: aload_0
    //   325: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   328: invokespecial 366	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   331: putfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   334: aload_0
    //   335: getfield 134	com/tencent/mm/plugin/voip/model/c:GTh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: iconst_0
    //   340: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: pop
    //   344: aload_0
    //   345: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   348: ifnull +13 -> 361
    //   351: aload_0
    //   352: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   355: invokevirtual 369	android/media/AudioTrack:getState	()I
    //   358: ifne +80 -> 438
    //   361: aload_0
    //   362: iconst_2
    //   363: putfield 188	com/tencent/mm/plugin/voip/model/c:GTE	I
    //   366: ldc_w 284
    //   369: ldc_w 371
    //   372: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   379: ifnull +20 -> 399
    //   382: aload_0
    //   383: getfield 134	com/tencent/mm/plugin/voip/model/c:GTh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   386: iconst_0
    //   387: iconst_1
    //   388: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   396: invokevirtual 361	android/media/AudioTrack:release	()V
    //   399: iload 4
    //   401: ifne +105 -> 506
    //   404: aload_0
    //   405: new 363	com/tencent/mm/compatible/b/e
    //   408: dup
    //   409: iconst_3
    //   410: aload_0
    //   411: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   414: aload_0
    //   415: getfield 103	com/tencent/mm/plugin/voip/model/c:juY	I
    //   418: aload_0
    //   419: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   422: invokespecial 366	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   425: putfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   428: aload_0
    //   429: getfield 134	com/tencent/mm/plugin/voip/model/c:GTh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_1
    //   433: iconst_0
    //   434: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   442: ifnonnull +91 -> 533
    //   445: aload_0
    //   446: iconst_3
    //   447: putfield 188	com/tencent/mm/plugin/voip/model/c:GTE	I
    //   450: ldc_w 284
    //   453: ldc_w 375
    //   456: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: ldc_w 282
    //   462: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: iconst_m1
    //   466: ireturn
    //   467: iconst_0
    //   468: istore 4
    //   470: goto -284 -> 186
    //   473: iconst_1
    //   474: istore 6
    //   476: goto -260 -> 216
    //   479: astore_1
    //   480: ldc_w 284
    //   483: ldc_w 377
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload_1
    //   493: aastore
    //   494: invokestatic 380	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: aload_0
    //   498: bipush 6
    //   500: putfield 188	com/tencent/mm/plugin/voip/model/c:GTE	I
    //   503: goto -159 -> 344
    //   506: aload_0
    //   507: new 363	com/tencent/mm/compatible/b/e
    //   510: dup
    //   511: iconst_0
    //   512: aload_0
    //   513: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   516: aload_0
    //   517: getfield 103	com/tencent/mm/plugin/voip/model/c:juY	I
    //   520: aload_0
    //   521: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   524: invokespecial 366	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   527: putfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   530: goto -102 -> 428
    //   533: aload_0
    //   534: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   537: invokevirtual 369	android/media/AudioTrack:getState	()I
    //   540: ifne +47 -> 587
    //   543: aload_0
    //   544: iconst_3
    //   545: putfield 188	com/tencent/mm/plugin/voip/model/c:GTE	I
    //   548: ldc_w 284
    //   551: ldc_w 382
    //   554: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 134	com/tencent/mm/plugin/voip/model/c:GTh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   561: iconst_0
    //   562: iconst_1
    //   563: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   566: pop
    //   567: aload_0
    //   568: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   571: invokevirtual 361	android/media/AudioTrack:release	()V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   579: ldc_w 282
    //   582: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: iconst_m1
    //   586: ireturn
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   592: newarray byte
    //   594: putfield 109	com/tencent/mm/plugin/voip/model/c:GTb	[B
    //   597: aload_0
    //   598: getfield 109	com/tencent/mm/plugin/voip/model/c:GTb	[B
    //   601: ifnonnull +20 -> 621
    //   604: ldc_w 284
    //   607: ldc_w 384
    //   610: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc_w 282
    //   616: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: iconst_m1
    //   620: ireturn
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 125	com/tencent/mm/plugin/voip/model/c:jvc	I
    //   626: newarray byte
    //   628: putfield 115	com/tencent/mm/plugin/voip/model/c:GTe	[B
    //   631: aload_0
    //   632: getfield 115	com/tencent/mm/plugin/voip/model/c:GTe	[B
    //   635: ifnonnull +20 -> 655
    //   638: ldc_w 284
    //   641: ldc_w 386
    //   644: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: ldc_w 282
    //   650: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: iconst_m1
    //   654: ireturn
    //   655: aload_0
    //   656: getfield 99	com/tencent/mm/plugin/voip/model/c:GSY	Z
    //   659: ifeq +113 -> 772
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   667: putfield 107	com/tencent/mm/plugin/voip/model/c:GTa	I
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 107	com/tencent/mm/plugin/voip/model/c:GTa	I
    //   675: newarray byte
    //   677: putfield 111	com/tencent/mm/plugin/voip/model/c:GTc	[B
    //   680: aload_0
    //   681: getfield 111	com/tencent/mm/plugin/voip/model/c:GTc	[B
    //   684: ifnonnull +20 -> 704
    //   687: ldc_w 284
    //   690: ldc_w 388
    //   693: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: ldc_w 282
    //   699: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: iconst_m1
    //   703: ireturn
    //   704: aload_0
    //   705: aload_0
    //   706: getfield 107	com/tencent/mm/plugin/voip/model/c:GTa	I
    //   709: newarray byte
    //   711: putfield 113	com/tencent/mm/plugin/voip/model/c:GTd	[B
    //   714: aload_0
    //   715: getfield 113	com/tencent/mm/plugin/voip/model/c:GTd	[B
    //   718: ifnonnull +20 -> 738
    //   721: ldc_w 284
    //   724: ldc_w 390
    //   727: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: ldc_w 282
    //   733: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: iconst_m1
    //   737: ireturn
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 125	com/tencent/mm/plugin/voip/model/c:jvc	I
    //   743: newarray byte
    //   745: putfield 117	com/tencent/mm/plugin/voip/model/c:GTf	[B
    //   748: aload_0
    //   749: getfield 117	com/tencent/mm/plugin/voip/model/c:GTf	[B
    //   752: ifnonnull +20 -> 772
    //   755: ldc_w 284
    //   758: ldc_w 392
    //   761: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: ldc_w 282
    //   767: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_m1
    //   771: ireturn
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield 95	com/tencent/mm/plugin/voip/model/c:GSW	Z
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 97	com/tencent/mm/plugin/voip/model/c:GSX	Z
    //   782: ldc_w 284
    //   785: ldc_w 394
    //   788: iconst_5
    //   789: anewarray 4	java/lang/Object
    //   792: dup
    //   793: iconst_0
    //   794: invokestatic 397	com/tencent/mm/plugin/audio/c/a:getMode	()I
    //   797: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: dup
    //   802: iconst_1
    //   803: invokestatic 406	com/tencent/mm/plugin/audio/c/a:isSpeakerphoneOn	()Z
    //   806: invokestatic 411	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   809: aastore
    //   810: dup
    //   811: iconst_2
    //   812: iload 4
    //   814: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: dup
    //   819: iconst_3
    //   820: aload_0
    //   821: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   824: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: aastore
    //   828: dup
    //   829: iconst_4
    //   830: aload_0
    //   831: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   834: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: invokestatic 413	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: aload_0
    //   842: getfield 105	com/tencent/mm/plugin/voip/model/c:jvb	I
    //   845: sipush 1000
    //   848: imul
    //   849: aload_0
    //   850: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   853: iconst_2
    //   854: imul
    //   855: idiv
    //   856: istore 4
    //   858: ldc_w 282
    //   861: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   864: iload 4
    //   866: ireturn
    //   867: astore_1
    //   868: goto -559 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	871	0	this	c
    //   0	871	1	paramContext	Context
    //   0	871	2	paramBoolean	boolean
    //   134	120	3	f	float
    //   138	727	4	i	int
    //   146	16	5	j	int
    //   214	261	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   283	288	479	java/lang/Exception
    //   309	344	479	java/lang/Exception
    //   292	309	867	java/lang/Exception
  }
  
  public final int N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (true == this.GSW) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.GTg = paramInt2;
    this.juZ = paramInt3;
    this.omD = paramInt4;
    this.jvc = (this.nSamplerate / 1000 * paramInt2 * this.juZ * 2);
    this.GTz = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  public final void a(b paramb)
  {
    this.GTi = paramb;
  }
  
  public final int bhV()
  {
    AppMethodBeat.i(114824);
    if (this.bfn != null)
    {
      i = this.bfn.getStreamType();
      AppMethodBeat.o(114824);
      return i;
    }
    int i = wT(true);
    AppMethodBeat.o(114824);
    return i;
  }
  
  public final int fFn()
  {
    return this.GTC / this.jvc * this.juZ;
  }
  
  public final int fFo()
  {
    AppMethodBeat.i(114819);
    Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit");
    if (this.bfn != null)
    {
      this.GTh.compareAndSet(false, true);
      this.bfn.release();
      this.bfn = null;
    }
    for (;;)
    {
      this.GSW = false;
      this.GSX = false;
      AppMethodBeat.o(114819);
      return 1;
      Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit failed cause audio track is null");
    }
  }
  
  public final int fFp()
  {
    AppMethodBeat.i(114820);
    if (true == this.GSW)
    {
      AppMethodBeat.o(114820);
      return 1;
    }
    if (this.bfn == null)
    {
      Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      AppMethodBeat.o(114820);
      return 0;
    }
    this.GSW = true;
    try
    {
      this.bfn.play();
      if ((this.bfn != null) && (this.bfn.getPlayState() != 3))
      {
        this.GTE = 4;
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
        AppMethodBeat.o(114820);
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[] { localException.getMessage() });
      }
      if ((this.bfn != null) && (this.bfn.getState() == 0))
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        AppMethodBeat.o(114820);
        return 0;
      }
      if (this.GSY)
      {
        int i;
        if ((this.dzS) || (this.dzR != null))
        {
          Log.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.dzS);
          i = -1;
        }
        while (i != 0)
        {
          Log.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          AppMethodBeat.o(114820);
          return 0;
          this.dzR = new Timer();
          if (this.dzR == null) {
            i = -1;
          } else {
            i = 0;
          }
        }
        this.dzR.scheduleAtFixedRate(new a(), 0L, 20L);
        this.dzS = true;
      }
      this.juN = new com.tencent.mm.audio.c.a.a();
      this.EgU = new com.tencent.f.i.b()
      {
        public final String getKey()
        {
          return "AudioPlayer_play";
        }
        
        public final void run()
        {
          AppMethodBeat.i(114813);
          Process.setThreadPriority(-19);
          Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
          int j = 0;
          while ((c.this.GSW) && (c.this.bfn != null) && (c.this.bfn.getPlayState() != 1) && (!c.this.GTh.get()))
          {
            int i;
            long l;
            try
            {
              i = c.this.bfn.getPlaybackHeadPosition();
              l = System.currentTimeMillis();
              c.d(c.this, c.j(c.this) - i);
              Log.i("MicroMsg.Voip.AudioPlayer", "m_iLefSamples value is %s and iPos value is %s", new Object[] { Integer.valueOf(c.k(c.this)), Integer.valueOf(i) });
              if (c.l(c.this) == 1)
              {
                c.e(c.this, i);
                c.a(c.this, l);
                c.b(c.this, l);
                c.m(c.this);
                c.c(c.this, l);
                if ((i != 0) && (c.this.GSY)) {
                  c.t(c.this);
                }
                if (c.this.GTi == null) {
                  break label1644;
                }
                c.h(c.this, c.u(c.this) + c.this.jvc);
                if (c.a(c.this) != 0) {
                  break label715;
                }
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.jvc, c.x(c.this));
                  c.w(c.this).ck(1, com.tencent.mm.plugin.audio.c.a.cea().getStreamVolume(c.this.bhV()) * 100 / com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamMaxVolume(c.this.bhV()));
                }
                i = c.this.GTi.Q(c.x(c.this), c.this.jvc);
                if (i >= 0) {
                  break label1165;
                }
                com.tencent.mm.plugin.voip.b.e.adF(5);
                Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[] { localException });
                c.i(c.this);
                i = 0;
                continue;
                int k = i - c.n(c.this);
                if (k > c.o(c.this))
                {
                  c.f(c.this, k);
                  label454:
                  c.c(c.this, l);
                  if (c.k(c.this) != 0) {
                    break label609;
                  }
                  c.g(c.this, c.p(c.this) + c.q(c.this));
                }
                for (;;)
                {
                  if (c.p(c.this) < c.s(c.this)) {
                    c.g(c.this, c.s(c.this));
                  }
                  if (c.p(c.this) < c.q(c.this)) {
                    c.g(c.this, c.q(c.this));
                  }
                  if (k <= 0) {
                    break;
                  }
                  c.e(c.this, i);
                  break;
                  c.f(c.this, (int)(c.o(c.this) * 49999.0F / 50000.0F + k / 50000.0F));
                  break label454;
                  label609:
                  if (l > c.r(c.this) + 5000L)
                  {
                    c.b(c.this, l);
                    if (c.o(c.this) < c.p(c.this) >> 1) {
                      c.g(c.this, c.p(c.this) - (c.q(c.this) >> 2));
                    }
                    if (c.o(c.this) > c.p(c.this)) {
                      c.g(c.this, c.o(c.this));
                    }
                  }
                }
                label715:
                System.currentTimeMillis();
                if (c.b(c.this) >= c.this.jvc)
                {
                  Log.i("MicroMsg.Voip.AudioPlayer", "m_iTaskLeftByte value is %s and nFrameLen value is %s", new Object[] { Integer.valueOf(c.b(c.this)), Integer.valueOf(c.this.jvc) });
                  synchronized (c.f(c.this))
                  {
                    System.arraycopy(c.g(c.this), 0, c.x(c.this), 0, c.this.jvc);
                    i = c.b(c.this) - c.this.jvc;
                    System.arraycopy(c.g(c.this), c.this.jvc, c.y(c.this), 0, i);
                    System.arraycopy(c.y(c.this), 0, c.g(c.this), 0, i);
                    c.b(c.this, c.b(c.this) - c.this.jvc);
                    Log.i("MicroMsg.Voip.AudioPlayer", "audio player has copy playTaskBuffer and left %s", new Object[] { Integer.valueOf(c.b(c.this)) });
                    i = 0;
                  }
                }
                if ((c.k(c.this) >= c.z(c.this) * 5 / 1000) || (c.A(c.this) != 0)) {
                  break;
                }
                c.i(c.this, 1);
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.jvc, c.x(c.this));
                  c.w(c.this).ck(1, com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamVolume(c.this.bhV()) * 100 / com.tencent.mm.plugin.audio.c.a.cea().audioManager.getStreamMaxVolume(c.this.bhV()));
                }
                i = c.this.GTi.Q(c.x(c.this), c.this.jvc);
                c.i(c.this, 0);
              }
              Log.i("MicroMsg.Voip.AudioPlayer", "play run too fast !,m_iLefSamples: " + c.k(c.this) + " ,m_iTaskLeftByte: " + c.b(c.this));
              com.tencent.mm.plugin.voip.b.e.adF(2);
            }
            continue;
            label1165:
            if (c.B(c.this))
            {
              Log.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.B(c.this));
              com.tencent.mm.plugin.voip.b.e.adF(10);
            }
            else
            {
              c.a(c.this, l);
              if (c.C(c.this) >= c.this.jvc)
              {
                if (!c.B(c.this))
                {
                  c.j(c.this, c.D(c.this) + 1);
                  i = c.this.bfn.write(c.x(c.this), 0, c.this.jvc);
                  if (i < 0)
                  {
                    c.k(c.this, i);
                    Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.l(c.this, c.j(c.this) + (c.this.jvc >> 1));
                }
              }
              else
              {
                System.arraycopy(c.x(c.this), 0, c.E(c.this), j, c.C(c.this) - j);
                if (c.this.bfn != null)
                {
                  c.j(c.this, c.D(c.this) + 1);
                  i = c.this.bfn.write(c.E(c.this), 0, c.E(c.this).length);
                  if (i < 0)
                  {
                    c.k(c.this, i);
                    Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.l(c.this, c.j(c.this) + (c.E(c.this).length >> 1));
                  j = c.C(c.this) - j;
                  i = c.this.jvc - j;
                  while ((i >= c.C(c.this)) && (c.this.bfn != null))
                  {
                    c.j(c.this, c.D(c.this) + 1);
                    c.this.bfn.write(c.x(c.this), j, c.C(c.this));
                    j += c.C(c.this);
                    i -= c.C(c.this);
                    c.l(c.this, c.j(c.this) + (c.C(c.this) >> 1));
                  }
                }
                AppMethodBeat.o(114813);
                return;
                System.arraycopy(c.x(c.this), j, c.E(c.this), 0, i);
                j = i;
                continue;
                label1644:
                com.tencent.mm.plugin.voip.b.e.adF(10);
              }
            }
          }
          if ((c.v(c.this) == 0) && (c.F(c.this) != null) && (c.w(c.this) != null))
          {
            c.w(c.this).b(1, c.F(c.this), c.this.bhV());
            c.w(c.this).jm(1);
            c.w(c.this).jn(1);
            c.w(c.this).jo(1);
          }
          AppMethodBeat.o(114813);
        }
      };
      h.RTc.bqo("AudioPlayer_play");
      h.RTc.b(this.EgU, "AudioPlayer_play");
      AppMethodBeat.o(114820);
    }
    return 1;
  }
  
  public final int fFq()
  {
    AppMethodBeat.i(114821);
    if (this.nSamplerate == 0)
    {
      Log.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
      AppMethodBeat.o(114821);
      return 0;
    }
    if (this.bfn == null)
    {
      Log.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.GTr + ",nSamplerate:" + this.nSamplerate);
      i = this.GTr * 1000 / this.nSamplerate;
      AppMethodBeat.o(114821);
      return i;
    }
    if ((this.GSW) && (this.bfn.getState() != 0)) {
      try
      {
        i = this.bfn.getPlaybackHeadPosition();
        i = (this.GTn - i) * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        i = this.GTr * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
    }
    int i = this.GTr * 1000 / this.nSamplerate;
    AppMethodBeat.o(114821);
    return i;
  }
  
  /* Error */
  public final int fFr()
  {
    // Byte code:
    //   0: ldc_w 511
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 140	com/tencent/mm/plugin/voip/model/c:dzS	Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 138	com/tencent/mm/plugin/voip/model/c:dzR	Ljava/util/Timer;
    //   17: ifnull +15 -> 32
    //   20: aload_0
    //   21: getfield 138	com/tencent/mm/plugin/voip/model/c:dzR	Ljava/util/Timer;
    //   24: invokevirtual 514	java/util/Timer:cancel	()V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 140	com/tencent/mm/plugin/voip/model/c:dzS	Z
    //   32: ldc_w 284
    //   35: ldc_w 516
    //   38: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 95	com/tencent/mm/plugin/voip/model/c:GSW	Z
    //   45: ifne +20 -> 65
    //   48: ldc_w 284
    //   51: ldc_w 518
    //   54: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: ldc_w 511
    //   60: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_1
    //   64: ireturn
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 95	com/tencent/mm/plugin/voip/model/c:GSW	Z
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 184	com/tencent/mm/plugin/voip/model/c:GTC	I
    //   75: aload_0
    //   76: getfield 473	com/tencent/mm/plugin/voip/model/c:EgU	Lcom/tencent/f/i/b;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +10 -> 91
    //   84: aload_0
    //   85: getfield 473	com/tencent/mm/plugin/voip/model/c:EgU	Lcom/tencent/f/i/b;
    //   88: invokevirtual 523	com/tencent/f/i/b:hmy	()V
    //   91: aload_0
    //   92: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   95: ifnull +56 -> 151
    //   98: aload_0
    //   99: getfield 134	com/tencent/mm/plugin/voip/model/c:GTh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: pop
    //   108: aload_0
    //   109: getfield 473	com/tencent/mm/plugin/voip/model/c:EgU	Lcom/tencent/f/i/b;
    //   112: invokevirtual 525	com/tencent/f/i/b:cancel	()Z
    //   115: pop
    //   116: getstatic 479	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   119: ldc_w 481
    //   122: invokeinterface 487 2 0
    //   127: pop
    //   128: aload_0
    //   129: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   132: invokevirtual 528	android/media/AudioTrack:stop	()V
    //   135: aload_0
    //   136: getfield 127	com/tencent/mm/plugin/voip/model/c:bfn	Landroid/media/AudioTrack;
    //   139: invokevirtual 361	android/media/AudioTrack:release	()V
    //   142: ldc_w 284
    //   145: ldc_w 530
    //   148: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc_w 511
    //   154: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore_1
    //   160: ldc_w 284
    //   163: aload_1
    //   164: ldc_w 532
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 536	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -83 -> 91
    //   177: astore_1
    //   178: ldc_w 284
    //   181: aload_1
    //   182: ldc_w 532
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 536	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: goto -101 -> 91
    //   195: astore_1
    //   196: ldc_w 284
    //   199: ldc_w 538
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: invokevirtual 445	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: goto -65 -> 151
    //   219: astore_1
    //   220: goto -42 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	c
    //   79	2	1	localb	com.tencent.f.i.b
    //   159	5	1	localExecutionException	java.util.concurrent.ExecutionException
    //   177	5	1	localCancellationException	java.util.concurrent.CancellationException
    //   195	14	1	localException	Exception
    //   219	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   84	91	159	java/util/concurrent/ExecutionException
    //   75	80	177	java/util/concurrent/CancellationException
    //   84	91	177	java/util/concurrent/CancellationException
    //   160	174	177	java/util/concurrent/CancellationException
    //   91	151	195	java/lang/Exception
    //   75	80	219	java/lang/InterruptedException
    //   84	91	219	java/lang/InterruptedException
    //   160	174	219	java/lang/InterruptedException
  }
  
  public final int fFs()
  {
    AppMethodBeat.i(114823);
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.GTE);
    int i = this.GTE;
    AppMethodBeat.o(114823);
    return i;
  }
  
  public final int getVolume()
  {
    AppMethodBeat.i(235480);
    AudioManager localAudioManager = (AudioManager)MMApplicationContext.getContext().getSystemService("audio");
    if ((localAudioManager != null) && (this.bfn != null))
    {
      int i = localAudioManager.getStreamVolume(this.bfn.getStreamType());
      AppMethodBeat.o(235480);
      return i;
    }
    AppMethodBeat.o(235480);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    return this.GSW;
  }
  
  public final boolean wS(boolean paramBoolean)
  {
    AppMethodBeat.i(114817);
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = wT(paramBoolean);
    if (com.tencent.mm.plugin.audio.c.a.ceb()) {
      i = 0;
    }
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.bfn != null) && (i == this.bfn.getStreamType()))
    {
      Log.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      AppMethodBeat.o(114817);
      return false;
    }
    fFr();
    this.jvd = true;
    if (this.GTg == 2) {}
    for (this.juY = 3;; this.juY = 2)
    {
      this.jvb = AudioTrack.getMinBufferSize(this.nSamplerate, this.juY, 2);
      if ((this.jvb != -2) && (this.jvb != -1)) {
        break;
      }
      this.jvd = false;
      AppMethodBeat.o(114817);
      return false;
    }
    this.GTn = 0;
    this.GTq = 0;
    this.GTs = 1;
    this.GTt = 0;
    this.GTu = 0L;
    this.GTv = 0L;
    this.GTw = 1;
    this.GTy = -1;
    this.GTz = 0;
    this.GTr = this.jvb;
    this.GTx = (this.GTr * this.GTw);
    this.jvb *= this.GTB;
    float f = this.GTr / 16.0F;
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.jvb + "  MinBufSizeInMs:" + f);
    if (this.bfn != null) {}
    try
    {
      this.GTh.compareAndSet(false, true);
      this.EgU.cancel();
      h.RTc.bqo("AudioPlayer_play");
      this.bfn.stop();
      this.bfn.release();
      this.bfn = null;
      Log.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Integer.valueOf(i), Integer.valueOf(this.jvb), Integer.valueOf(this.nSamplerate) });
      this.bfn = new com.tencent.mm.compatible.b.e(i, this.nSamplerate, this.juY, this.jvb);
      if ((this.bfn != null) && (this.bfn.getState() == 0))
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.GTh.compareAndSet(false, true);
        this.bfn.release();
        this.bfn = null;
        AppMethodBeat.o(114817);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[] { localException.getMessage() });
      }
      Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
      if (this.bfn != null)
      {
        this.jvd = false;
        fFp();
        AppMethodBeat.o(114817);
        return true;
      }
      this.jvd = false;
      AppMethodBeat.o(114817);
    }
    return false;
  }
  
  final class a
    extends TimerTask
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(114814);
      System.currentTimeMillis();
      if ((c.a(c.this) == 1) && (c.this.GSW == true))
      {
        System.currentTimeMillis();
        if ((c.b(c.this) + c.this.jvc < c.c(c.this)) && (c.d(c.this) == 0) && (c.this.GTi != null))
        {
          c.a(c.this, 1);
          int i = c.this.GTi.Q(c.e(c.this), c.this.jvc);
          c.a(c.this, 0);
          if (i < 0)
          {
            Log.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
            AppMethodBeat.o(114814);
            return;
          }
          synchronized (c.f(c.this))
          {
            System.arraycopy(c.e(c.this), 0, c.g(c.this), c.b(c.this), c.this.jvc);
            c.b(c.this, c.b(c.this) + c.this.jvc);
            c.c(c.this, c.h(c.this) + (c.this.jvc >> 1));
            AppMethodBeat.o(114814);
            return;
          }
        }
      }
      AppMethodBeat.o(114814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c
 * JD-Core Version:    0.7.0.1
 */