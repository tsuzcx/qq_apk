package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static float volume = 0.0F;
  private int CpA;
  private int CpB;
  private int CpC;
  private int CpD;
  private long CpE;
  private int CpF;
  private int CpG;
  private final Object CpH;
  private int CpI;
  int CpJ;
  private int CpK;
  private int CpL;
  private int CpM;
  public boolean Cpa;
  boolean Cpb;
  boolean Cpc;
  l Cpd;
  private int Cpe;
  private byte[] Cpf;
  private byte[] Cpg;
  private byte[] Cph;
  private byte[] Cpi;
  private byte[] Cpj;
  public int Cpk;
  AtomicBoolean Cpl;
  public b Cpm;
  private int Cpn;
  private int Cpo;
  private int Cpp;
  String Cpq;
  private int Cpr;
  private int Cps;
  private int Cpt;
  private int Cpu;
  private int Cpv;
  private int Cpw;
  private int Cpx;
  private long Cpy;
  private long Cpz;
  AudioTrack bfq;
  Context context;
  private Timer diG;
  private boolean diH;
  private int fYN;
  int izK;
  private int izL;
  int izN;
  int izO;
  private boolean izP;
  private com.tencent.mm.audio.c.a.a izz;
  private int nSamplerate;
  private int naN;
  private com.tencent.e.i.b zYD;
  
  public c()
  {
    AppMethodBeat.i(114815);
    this.Cpa = false;
    this.Cpb = false;
    this.Cpc = true;
    this.Cpd = null;
    this.izK = 2;
    this.izN = 0;
    this.Cpe = 0;
    this.Cpf = null;
    this.Cpg = null;
    this.Cph = null;
    this.Cpi = null;
    this.Cpj = null;
    this.nSamplerate = 0;
    this.Cpk = 0;
    this.izL = 0;
    this.izO = 20;
    this.bfq = null;
    this.Cpl = new AtomicBoolean(false);
    this.Cpm = null;
    this.diG = null;
    this.diH = false;
    this.Cpn = 1;
    this.Cpo = 1;
    this.Cpp = 0;
    this.Cpq = null;
    this.fYN = 3;
    this.izP = false;
    this.Cpr = 0;
    this.Cps = 0;
    this.Cpt = 0;
    this.Cpu = 0;
    this.Cpv = 0;
    this.Cpw = 1;
    this.Cpx = 0;
    this.Cpy = 0L;
    this.Cpz = 0L;
    this.CpA = 1;
    this.CpB = 0;
    this.CpC = -1;
    this.CpD = 0;
    this.CpE = 0L;
    this.CpF = 1;
    this.CpG = 0;
    this.CpH = new Object();
    this.CpI = 0;
    this.CpJ = 0;
    this.CpK = 0;
    this.naN = 0;
    this.CpL = 0;
    this.CpM = 0;
    AppMethodBeat.o(114815);
  }
  
  private int tj(boolean paramBoolean)
  {
    AppMethodBeat.i(114818);
    int j = 0;
    int i;
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYo > 0)
    {
      j = com.tencent.mm.plugin.audio.c.a.iv(paramBoolean);
      if ((!paramBoolean) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ < 0)) {
        break label113;
      }
      i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ;
      label41:
      j = i;
      if (1 == this.naN)
      {
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZF >= 0) {
          i = com.tencent.mm.compatible.deviceinfo.ae.geN.fZF;
        }
        if ((!paramBoolean) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fZG < 0)) {
          break label140;
        }
        j = com.tencent.mm.compatible.deviceinfo.ae.geN.fZG;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114818);
      return j;
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYP < 0) {
        break;
      }
      j = com.tencent.mm.compatible.deviceinfo.ae.geN.fYP;
      break;
      label113:
      i = j;
      if (paramBoolean) {
        break label41;
      }
      i = j;
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYR < 0) {
        break label41;
      }
      i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYR;
      break label41;
      label140:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZH >= 0) {
          j = com.tencent.mm.compatible.deviceinfo.ae.geN.fZH;
        }
      }
    }
  }
  
  /* Error */
  public final int C(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 282
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 284
    //   9: ldc_w 286
    //   12: invokestatic 291	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 293	com/tencent/mm/plugin/voip/model/c:context	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 121	com/tencent/mm/plugin/voip/model/c:Cpk	I
    //   24: iconst_2
    //   25: if_icmpne +54 -> 79
    //   28: aload_0
    //   29: iconst_3
    //   30: putfield 103	com/tencent/mm/plugin/voip/model/c:izK	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   38: aload_0
    //   39: getfield 103	com/tencent/mm/plugin/voip/model/c:izK	I
    //   42: iconst_2
    //   43: invokestatic 299	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: putfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   49: aload_0
    //   50: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   53: bipush 254
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   62: iconst_m1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 188	com/tencent/mm/plugin/voip/model/c:CpI	I
    //   71: ldc_w 282
    //   74: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_0
    //   80: iconst_2
    //   81: putfield 103	com/tencent/mm/plugin/voip/model/c:izK	I
    //   84: goto -51 -> 33
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   92: putfield 162	com/tencent/mm/plugin/voip/model/c:Cpv	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 162	com/tencent/mm/plugin/voip/model/c:Cpv	I
    //   100: aload_0
    //   101: getfield 172	com/tencent/mm/plugin/voip/model/c:CpA	I
    //   104: imul
    //   105: putfield 174	com/tencent/mm/plugin/voip/model/c:CpB	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   113: aload_0
    //   114: getfield 182	com/tencent/mm/plugin/voip/model/c:CpF	I
    //   117: imul
    //   118: putfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   121: aload_0
    //   122: getfield 162	com/tencent/mm/plugin/voip/model/c:Cpv	I
    //   125: iconst_1
    //   126: ishr
    //   127: i2f
    //   128: aload_0
    //   129: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   132: i2f
    //   133: fdiv
    //   134: fstore_3
    //   135: invokestatic 305	com/tencent/mm/compatible/deviceinfo/m:aao	()I
    //   138: istore 4
    //   140: getstatic 241	com/tencent/mm/compatible/deviceinfo/ae:geN	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   143: getfield 308	com/tencent/mm/compatible/deviceinfo/b:fZv	I
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
    //   183: invokestatic 322	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 323
    //   189: fload_3
    //   190: fmul
    //   191: ldc_w 324
    //   194: fcmpg
    //   195: iflt +10 -> 205
    //   198: aload_0
    //   199: getfield 194	com/tencent/mm/plugin/voip/model/c:naN	I
    //   202: ifeq +6 -> 208
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +263 -> 473
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: iload 6
    //   219: putfield 99	com/tencent/mm/plugin/voip/model/c:Cpc	Z
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 99	com/tencent/mm/plugin/voip/model/c:Cpc	Z
    //   227: ldc_w 284
    //   230: new 326	java/lang/StringBuilder
    //   233: dup
    //   234: ldc_w 328
    //   237: invokespecial 331	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   244: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 337
    //   250: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: fload_3
    //   254: invokevirtual 343	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   257: ldc_w 345
    //   260: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 99	com/tencent/mm/plugin/voip/model/c:Cpc	Z
    //   267: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 322	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: iload_2
    //   278: invokespecial 354	com/tencent/mm/plugin/voip/model/c:tj	(Z)I
    //   281: istore 4
    //   283: aload_0
    //   284: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +20 -> 309
    //   292: aload_0
    //   293: getfield 134	com/tencent/mm/plugin/voip/model/c:Cpl	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: iconst_0
    //   297: iconst_1
    //   298: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   301: pop
    //   302: aload_0
    //   303: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   306: invokevirtual 361	android/media/AudioTrack:release	()V
    //   309: aload_0
    //   310: new 363	com/tencent/mm/compatible/b/e
    //   313: dup
    //   314: iload 4
    //   316: aload_0
    //   317: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   320: aload_0
    //   321: getfield 103	com/tencent/mm/plugin/voip/model/c:izK	I
    //   324: aload_0
    //   325: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   328: invokespecial 366	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   331: putfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   334: aload_0
    //   335: getfield 134	com/tencent/mm/plugin/voip/model/c:Cpl	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: iconst_0
    //   340: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: pop
    //   344: aload_0
    //   345: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   348: ifnull +13 -> 361
    //   351: aload_0
    //   352: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   355: invokevirtual 369	android/media/AudioTrack:getState	()I
    //   358: ifne +80 -> 438
    //   361: aload_0
    //   362: iconst_2
    //   363: putfield 188	com/tencent/mm/plugin/voip/model/c:CpI	I
    //   366: ldc_w 284
    //   369: ldc_w 371
    //   372: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   379: ifnull +20 -> 399
    //   382: aload_0
    //   383: getfield 134	com/tencent/mm/plugin/voip/model/c:Cpl	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   386: iconst_0
    //   387: iconst_1
    //   388: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
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
    //   415: getfield 103	com/tencent/mm/plugin/voip/model/c:izK	I
    //   418: aload_0
    //   419: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   422: invokespecial 366	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   425: putfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   428: aload_0
    //   429: getfield 134	com/tencent/mm/plugin/voip/model/c:Cpl	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_1
    //   433: iconst_0
    //   434: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   442: ifnonnull +91 -> 533
    //   445: aload_0
    //   446: iconst_3
    //   447: putfield 188	com/tencent/mm/plugin/voip/model/c:CpI	I
    //   450: ldc_w 284
    //   453: ldc_w 375
    //   456: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   494: invokestatic 380	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: aload_0
    //   498: bipush 6
    //   500: putfield 188	com/tencent/mm/plugin/voip/model/c:CpI	I
    //   503: goto -159 -> 344
    //   506: aload_0
    //   507: new 363	com/tencent/mm/compatible/b/e
    //   510: dup
    //   511: iconst_0
    //   512: aload_0
    //   513: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   516: aload_0
    //   517: getfield 103	com/tencent/mm/plugin/voip/model/c:izK	I
    //   520: aload_0
    //   521: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   524: invokespecial 366	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   527: putfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   530: goto -102 -> 428
    //   533: aload_0
    //   534: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   537: invokevirtual 369	android/media/AudioTrack:getState	()I
    //   540: ifne +47 -> 587
    //   543: aload_0
    //   544: iconst_3
    //   545: putfield 188	com/tencent/mm/plugin/voip/model/c:CpI	I
    //   548: ldc_w 284
    //   551: ldc_w 382
    //   554: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 134	com/tencent/mm/plugin/voip/model/c:Cpl	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   561: iconst_0
    //   562: iconst_1
    //   563: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   566: pop
    //   567: aload_0
    //   568: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   571: invokevirtual 361	android/media/AudioTrack:release	()V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   579: ldc_w 282
    //   582: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: iconst_m1
    //   586: ireturn
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   592: newarray byte
    //   594: putfield 109	com/tencent/mm/plugin/voip/model/c:Cpf	[B
    //   597: aload_0
    //   598: getfield 109	com/tencent/mm/plugin/voip/model/c:Cpf	[B
    //   601: ifnonnull +20 -> 621
    //   604: ldc_w 284
    //   607: ldc_w 384
    //   610: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc_w 282
    //   616: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: iconst_m1
    //   620: ireturn
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 125	com/tencent/mm/plugin/voip/model/c:izO	I
    //   626: newarray byte
    //   628: putfield 115	com/tencent/mm/plugin/voip/model/c:Cpi	[B
    //   631: aload_0
    //   632: getfield 115	com/tencent/mm/plugin/voip/model/c:Cpi	[B
    //   635: ifnonnull +20 -> 655
    //   638: ldc_w 284
    //   641: ldc_w 386
    //   644: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: ldc_w 282
    //   650: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: iconst_m1
    //   654: ireturn
    //   655: aload_0
    //   656: getfield 99	com/tencent/mm/plugin/voip/model/c:Cpc	Z
    //   659: ifeq +113 -> 772
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   667: putfield 107	com/tencent/mm/plugin/voip/model/c:Cpe	I
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 107	com/tencent/mm/plugin/voip/model/c:Cpe	I
    //   675: newarray byte
    //   677: putfield 111	com/tencent/mm/plugin/voip/model/c:Cpg	[B
    //   680: aload_0
    //   681: getfield 111	com/tencent/mm/plugin/voip/model/c:Cpg	[B
    //   684: ifnonnull +20 -> 704
    //   687: ldc_w 284
    //   690: ldc_w 388
    //   693: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: ldc_w 282
    //   699: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: iconst_m1
    //   703: ireturn
    //   704: aload_0
    //   705: aload_0
    //   706: getfield 107	com/tencent/mm/plugin/voip/model/c:Cpe	I
    //   709: newarray byte
    //   711: putfield 113	com/tencent/mm/plugin/voip/model/c:Cph	[B
    //   714: aload_0
    //   715: getfield 113	com/tencent/mm/plugin/voip/model/c:Cph	[B
    //   718: ifnonnull +20 -> 738
    //   721: ldc_w 284
    //   724: ldc_w 390
    //   727: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: ldc_w 282
    //   733: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: iconst_m1
    //   737: ireturn
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 125	com/tencent/mm/plugin/voip/model/c:izO	I
    //   743: newarray byte
    //   745: putfield 117	com/tencent/mm/plugin/voip/model/c:Cpj	[B
    //   748: aload_0
    //   749: getfield 117	com/tencent/mm/plugin/voip/model/c:Cpj	[B
    //   752: ifnonnull +20 -> 772
    //   755: ldc_w 284
    //   758: ldc_w 392
    //   761: invokestatic 373	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: ldc_w 282
    //   767: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_m1
    //   771: ireturn
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield 95	com/tencent/mm/plugin/voip/model/c:Cpa	Z
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 97	com/tencent/mm/plugin/voip/model/c:Cpb	Z
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
    //   821: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
    //   824: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: aastore
    //   828: dup
    //   829: iconst_4
    //   830: aload_0
    //   831: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   834: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: invokestatic 413	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: aload_0
    //   842: getfield 105	com/tencent/mm/plugin/voip/model/c:izN	I
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
  
  public final int M(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (true == this.Cpa) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.Cpk = paramInt2;
    this.izL = paramInt3;
    this.naN = paramInt4;
    this.izO = (this.nSamplerate / 1000 * paramInt2 * this.izL * 2);
    this.CpD = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  public final void a(b paramb)
  {
    this.Cpm = paramb;
  }
  
  public final int aNQ()
  {
    AppMethodBeat.i(114824);
    if (this.bfq != null)
    {
      i = this.bfq.getStreamType();
      AppMethodBeat.o(114824);
      return i;
    }
    int i = tj(true);
    AppMethodBeat.o(114824);
    return i;
  }
  
  /* Error */
  public final int eyA()
  {
    // Byte code:
    //   0: ldc_w 429
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 140	com/tencent/mm/plugin/voip/model/c:diH	Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 138	com/tencent/mm/plugin/voip/model/c:diG	Ljava/util/Timer;
    //   17: ifnull +15 -> 32
    //   20: aload_0
    //   21: getfield 138	com/tencent/mm/plugin/voip/model/c:diG	Ljava/util/Timer;
    //   24: invokevirtual 434	java/util/Timer:cancel	()V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 140	com/tencent/mm/plugin/voip/model/c:diH	Z
    //   32: ldc_w 284
    //   35: ldc_w 436
    //   38: invokestatic 322	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 95	com/tencent/mm/plugin/voip/model/c:Cpa	Z
    //   45: ifne +20 -> 65
    //   48: ldc_w 284
    //   51: ldc_w 438
    //   54: invokestatic 322	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: ldc_w 429
    //   60: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_1
    //   64: ireturn
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 95	com/tencent/mm/plugin/voip/model/c:Cpa	Z
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 184	com/tencent/mm/plugin/voip/model/c:CpG	I
    //   75: aload_0
    //   76: getfield 440	com/tencent/mm/plugin/voip/model/c:zYD	Lcom/tencent/e/i/b;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +10 -> 91
    //   84: aload_0
    //   85: getfield 440	com/tencent/mm/plugin/voip/model/c:zYD	Lcom/tencent/e/i/b;
    //   88: invokevirtual 445	com/tencent/e/i/b:gan	()V
    //   91: aload_0
    //   92: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   95: ifnull +56 -> 151
    //   98: aload_0
    //   99: getfield 134	com/tencent/mm/plugin/voip/model/c:Cpl	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: pop
    //   108: aload_0
    //   109: getfield 440	com/tencent/mm/plugin/voip/model/c:zYD	Lcom/tencent/e/i/b;
    //   112: invokevirtual 447	com/tencent/e/i/b:cancel	()Z
    //   115: pop
    //   116: getstatic 453	com/tencent/e/h:MqF	Lcom/tencent/e/i;
    //   119: ldc_w 455
    //   122: invokeinterface 461 2 0
    //   127: pop
    //   128: aload_0
    //   129: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   132: invokevirtual 464	android/media/AudioTrack:stop	()V
    //   135: aload_0
    //   136: getfield 127	com/tencent/mm/plugin/voip/model/c:bfq	Landroid/media/AudioTrack;
    //   139: invokevirtual 361	android/media/AudioTrack:release	()V
    //   142: ldc_w 284
    //   145: ldc_w 466
    //   148: invokestatic 322	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc_w 429
    //   154: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore_1
    //   160: ldc_w 284
    //   163: aload_1
    //   164: ldc_w 468
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 472	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -83 -> 91
    //   177: astore_1
    //   178: ldc_w 284
    //   181: aload_1
    //   182: ldc_w 468
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 472	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: goto -101 -> 91
    //   195: astore_1
    //   196: ldc_w 284
    //   199: ldc_w 474
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: invokevirtual 477	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 479	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: goto -65 -> 151
    //   219: astore_1
    //   220: goto -42 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	c
    //   79	2	1	localb	com.tencent.e.i.b
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
  
  public final int eyB()
  {
    AppMethodBeat.i(114823);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.CpI);
    int i = this.CpI;
    AppMethodBeat.o(114823);
    return i;
  }
  
  public final int eyw()
  {
    return this.CpG / this.izO * this.izL;
  }
  
  public final int eyx()
  {
    AppMethodBeat.i(114819);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit");
    if (this.bfq != null)
    {
      this.Cpl.compareAndSet(false, true);
      this.bfq.release();
      this.bfq = null;
    }
    for (;;)
    {
      this.Cpa = false;
      this.Cpb = false;
      AppMethodBeat.o(114819);
      return 1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit failed cause audio track is null");
    }
  }
  
  public final int eyy()
  {
    AppMethodBeat.i(114820);
    if (true == this.Cpa)
    {
      AppMethodBeat.o(114820);
      return 1;
    }
    if (this.bfq == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      AppMethodBeat.o(114820);
      return 0;
    }
    this.Cpa = true;
    try
    {
      this.bfq.play();
      if ((this.bfq != null) && (this.bfq.getPlayState() != 3))
      {
        this.CpI = 4;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
        AppMethodBeat.o(114820);
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[] { localException.getMessage() });
      }
      if ((this.bfq != null) && (this.bfq.getState() == 0))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        AppMethodBeat.o(114820);
        return 0;
      }
      if (this.Cpc)
      {
        int i;
        if ((this.diH) || (this.diG != null))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.diH);
          i = -1;
        }
        while (i != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          AppMethodBeat.o(114820);
          return 0;
          this.diG = new Timer();
          if (this.diG == null) {
            i = -1;
          } else {
            i = 0;
          }
        }
        this.diG.scheduleAtFixedRate(new a(), 0L, 20L);
        this.diH = true;
      }
      this.izz = new com.tencent.mm.audio.c.a.a();
      this.zYD = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "AudioPlayer_play";
        }
        
        public final void run()
        {
          AppMethodBeat.i(114813);
          Process.setThreadPriority(-19);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
          int j = 0;
          while ((c.this.Cpa) && (c.this.bfq != null) && (c.this.bfq.getPlayState() != 1) && (!c.this.Cpl.get()))
          {
            int i;
            long l;
            try
            {
              i = c.this.bfq.getPlaybackHeadPosition();
              l = System.currentTimeMillis();
              c.d(c.this, c.j(c.this) - i);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.AudioPlayer", "m_iLefSamples value is %s and iPos value is %s", new Object[] { Integer.valueOf(c.k(c.this)), Integer.valueOf(i) });
              if (c.l(c.this) == 1)
              {
                c.e(c.this, i);
                c.a(c.this, l);
                c.b(c.this, l);
                c.m(c.this);
                c.c(c.this, l);
                if ((i != 0) && (c.this.Cpc)) {
                  c.t(c.this);
                }
                if (c.this.Cpm == null) {
                  break label1644;
                }
                c.h(c.this, c.u(c.this) + c.this.izO);
                if (c.a(c.this) != 0) {
                  break label715;
                }
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.izO, c.x(c.this));
                  c.w(c.this).ci(1, com.tencent.mm.plugin.audio.c.a.bHy().getStreamVolume(c.this.aNQ()) * 100 / com.tencent.mm.plugin.audio.c.a.bHy().audioManager.getStreamMaxVolume(c.this.aNQ()));
                }
                i = c.this.Cpm.O(c.x(c.this), c.this.izO);
                if (i >= 0) {
                  break label1165;
                }
                f.Vk(5);
                com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[] { localException });
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
                if (c.b(c.this) >= c.this.izO)
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.AudioPlayer", "m_iTaskLeftByte value is %s and nFrameLen value is %s", new Object[] { Integer.valueOf(c.b(c.this)), Integer.valueOf(c.this.izO) });
                  synchronized (c.f(c.this))
                  {
                    System.arraycopy(c.g(c.this), 0, c.x(c.this), 0, c.this.izO);
                    i = c.b(c.this) - c.this.izO;
                    System.arraycopy(c.g(c.this), c.this.izO, c.y(c.this), 0, i);
                    System.arraycopy(c.y(c.this), 0, c.g(c.this), 0, i);
                    c.b(c.this, c.b(c.this) - c.this.izO);
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.AudioPlayer", "audio player has copy playTaskBuffer and left %s", new Object[] { Integer.valueOf(c.b(c.this)) });
                    i = 0;
                  }
                }
                if ((c.k(c.this) >= c.z(c.this) * 5 / 1000) || (c.A(c.this) != 0)) {
                  break;
                }
                c.i(c.this, 1);
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.izO, c.x(c.this));
                  c.w(c.this).ci(1, com.tencent.mm.plugin.audio.c.a.bHy().audioManager.getStreamVolume(c.this.aNQ()) * 100 / com.tencent.mm.plugin.audio.c.a.bHy().audioManager.getStreamMaxVolume(c.this.aNQ()));
                }
                i = c.this.Cpm.O(c.x(c.this), c.this.izO);
                c.i(c.this, 0);
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.AudioPlayer", "play run too fast !,m_iLefSamples: " + c.k(c.this) + " ,m_iTaskLeftByte: " + c.b(c.this));
              f.Vk(2);
            }
            continue;
            label1165:
            if (c.B(c.this))
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.B(c.this));
              f.Vk(10);
            }
            else
            {
              c.a(c.this, l);
              if (c.C(c.this) >= c.this.izO)
              {
                if (!c.B(c.this))
                {
                  c.j(c.this, c.D(c.this) + 1);
                  i = c.this.bfq.write(c.x(c.this), 0, c.this.izO);
                  if (i < 0)
                  {
                    c.k(c.this, i);
                    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.l(c.this, c.j(c.this) + (c.this.izO >> 1));
                }
              }
              else
              {
                System.arraycopy(c.x(c.this), 0, c.E(c.this), j, c.C(c.this) - j);
                if (c.this.bfq != null)
                {
                  c.j(c.this, c.D(c.this) + 1);
                  i = c.this.bfq.write(c.E(c.this), 0, c.E(c.this).length);
                  if (i < 0)
                  {
                    c.k(c.this, i);
                    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.l(c.this, c.j(c.this) + (c.E(c.this).length >> 1));
                  j = c.C(c.this) - j;
                  i = c.this.izO - j;
                  while ((i >= c.C(c.this)) && (c.this.bfq != null))
                  {
                    c.j(c.this, c.D(c.this) + 1);
                    c.this.bfq.write(c.x(c.this), j, c.C(c.this));
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
                f.Vk(10);
              }
            }
          }
          if ((c.v(c.this) == 0) && (c.F(c.this) != null) && (c.w(c.this) != null))
          {
            c.w(c.this).b(1, c.F(c.this), c.this.aNQ());
            c.w(c.this).hS(1);
            c.w(c.this).hT(1);
            c.w(c.this).hU(1);
          }
          AppMethodBeat.o(114813);
        }
      };
      h.MqF.bbc("AudioPlayer_play");
      h.MqF.f(this.zYD, "AudioPlayer_play");
      AppMethodBeat.o(114820);
    }
    return 1;
  }
  
  public final int eyz()
  {
    AppMethodBeat.i(114821);
    if (this.nSamplerate == 0)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
      AppMethodBeat.o(114821);
      return 0;
    }
    if (this.bfq == null)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.Cpv + ",nSamplerate:" + this.nSamplerate);
      i = this.Cpv * 1000 / this.nSamplerate;
      AppMethodBeat.o(114821);
      return i;
    }
    if ((this.Cpa) && (this.bfq.getState() != 0)) {
      try
      {
        i = this.bfq.getPlaybackHeadPosition();
        i = (this.Cpr - i) * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        i = this.Cpv * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
    }
    int i = this.Cpv * 1000 / this.nSamplerate;
    AppMethodBeat.o(114821);
    return i;
  }
  
  public final int getVolume()
  {
    AppMethodBeat.i(209916);
    AudioManager localAudioManager = (AudioManager)ak.getContext().getSystemService("audio");
    if ((localAudioManager != null) && (this.bfq != null))
    {
      int i = localAudioManager.getStreamVolume(this.bfq.getStreamType());
      AppMethodBeat.o(209916);
      return i;
    }
    AppMethodBeat.o(209916);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    return this.Cpa;
  }
  
  public final boolean ti(boolean paramBoolean)
  {
    AppMethodBeat.i(114817);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = tj(paramBoolean);
    if (com.tencent.mm.plugin.audio.c.a.bHz()) {
      i = 0;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.bfq != null) && (i == this.bfq.getStreamType()))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      AppMethodBeat.o(114817);
      return false;
    }
    eyA();
    this.izP = true;
    if (this.Cpk == 2) {}
    for (this.izK = 3;; this.izK = 2)
    {
      this.izN = AudioTrack.getMinBufferSize(this.nSamplerate, this.izK, 2);
      if ((this.izN != -2) && (this.izN != -1)) {
        break;
      }
      this.izP = false;
      AppMethodBeat.o(114817);
      return false;
    }
    this.Cpr = 0;
    this.Cpu = 0;
    this.Cpw = 1;
    this.Cpx = 0;
    this.Cpy = 0L;
    this.Cpz = 0L;
    this.CpA = 1;
    this.CpC = -1;
    this.CpD = 0;
    this.Cpv = this.izN;
    this.CpB = (this.Cpv * this.CpA);
    this.izN *= this.CpF;
    float f = this.Cpv / 16.0F;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.izN + "  MinBufSizeInMs:" + f);
    if (this.bfq != null) {}
    try
    {
      this.Cpl.compareAndSet(false, true);
      this.zYD.cancel();
      h.MqF.bbc("AudioPlayer_play");
      this.bfq.stop();
      this.bfq.release();
      this.bfq = null;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Integer.valueOf(i), Integer.valueOf(this.izN), Integer.valueOf(this.nSamplerate) });
      this.bfq = new e(i, this.nSamplerate, this.izK, this.izN);
      if ((this.bfq != null) && (this.bfq.getState() == 0))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.Cpl.compareAndSet(false, true);
        this.bfq.release();
        this.bfq = null;
        AppMethodBeat.o(114817);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[] { localException.getMessage() });
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
      if (this.bfq != null)
      {
        this.izP = false;
        eyy();
        AppMethodBeat.o(114817);
        return true;
      }
      this.izP = false;
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
      if ((c.a(c.this) == 1) && (c.this.Cpa == true))
      {
        System.currentTimeMillis();
        if ((c.b(c.this) + c.this.izO < c.c(c.this)) && (c.d(c.this) == 0) && (c.this.Cpm != null))
        {
          c.a(c.this, 1);
          int i = c.this.Cpm.O(c.e(c.this), c.this.izO);
          c.a(c.this, 0);
          if (i < 0)
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
            AppMethodBeat.o(114814);
            return;
          }
          synchronized (c.f(c.this))
          {
            System.arraycopy(c.e(c.this), 0, c.g(c.this), c.b(c.this), c.this.izO);
            c.b(c.this, c.b(c.this) + c.this.izO);
            c.c(c.this, c.h(c.this) + (c.this.izO >> 1));
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