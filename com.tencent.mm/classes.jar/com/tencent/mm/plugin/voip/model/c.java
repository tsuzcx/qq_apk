package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static float volume = 0.0F;
  private int AyA;
  private int AyB;
  private long AyC;
  private long AyD;
  private int AyE;
  private int AyF;
  private int AyG;
  private int AyH;
  private long AyI;
  private int AyJ;
  private int AyK;
  private final Object AyL;
  private int AyM;
  private int AyN;
  private int AyO;
  private int AyP;
  public boolean Aye;
  boolean Ayf;
  boolean Ayg;
  l Ayh;
  private int Ayi;
  private byte[] Ayj;
  private byte[] Ayk;
  private byte[] Ayl;
  private byte[] Aym;
  private byte[] Ayn;
  public int Ayo;
  AtomicBoolean Ayp;
  public b Ayq;
  private int Ayr;
  private int Ays;
  private int Ayt;
  String Ayu;
  private int Ayv;
  private int Ayw;
  private int Ayx;
  private int Ayy;
  private int Ayz;
  public AudioTrack aUW;
  private Timer cWn;
  private boolean cWo;
  Context context;
  private int fDt;
  int idA;
  private boolean idB;
  private com.tencent.mm.audio.c.a.a idk;
  int idv;
  private int idw;
  int idz;
  private int mva;
  private int nSamplerate;
  private com.tencent.e.i.b yqm;
  
  public c()
  {
    AppMethodBeat.i(114815);
    this.Aye = false;
    this.Ayf = false;
    this.Ayg = true;
    this.Ayh = null;
    this.idv = 2;
    this.idz = 0;
    this.Ayi = 0;
    this.Ayj = null;
    this.Ayk = null;
    this.Ayl = null;
    this.Aym = null;
    this.Ayn = null;
    this.nSamplerate = 0;
    this.Ayo = 0;
    this.idw = 0;
    this.idA = 20;
    this.aUW = null;
    this.Ayp = new AtomicBoolean(false);
    this.Ayq = null;
    this.cWn = null;
    this.cWo = false;
    this.Ayr = 1;
    this.Ays = 1;
    this.Ayt = 0;
    this.Ayu = null;
    this.fDt = 3;
    this.idB = false;
    this.Ayv = 0;
    this.Ayw = 0;
    this.Ayx = 0;
    this.Ayy = 0;
    this.Ayz = 0;
    this.AyA = 1;
    this.AyB = 0;
    this.AyC = 0L;
    this.AyD = 0L;
    this.AyE = 1;
    this.AyF = 0;
    this.AyG = -1;
    this.AyH = 0;
    this.AyI = 0L;
    this.AyJ = 1;
    this.AyK = 0;
    this.AyL = new Object();
    this.AyM = 0;
    this.AyN = 0;
    this.mva = 0;
    this.AyO = 0;
    this.AyP = 0;
    AppMethodBeat.o(114815);
  }
  
  private int st(boolean paramBoolean)
  {
    AppMethodBeat.i(114818);
    int j = 0;
    int i;
    if (ae.fJe.fCU > 0)
    {
      j = com.tencent.mm.plugin.audio.c.a.io(paramBoolean);
      if ((!paramBoolean) || (ae.fJe.fDw < 0)) {
        break label113;
      }
      i = ae.fJe.fDw;
      label41:
      j = i;
      if (1 == this.mva)
      {
        if (ae.fJe.fEa >= 0) {
          i = ae.fJe.fEa;
        }
        if ((!paramBoolean) || (ae.fJe.fEb < 0)) {
          break label140;
        }
        j = ae.fJe.fEb;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114818);
      return j;
      if (ae.fJe.fDv < 0) {
        break;
      }
      j = ae.fJe.fDv;
      break;
      label113:
      i = j;
      if (paramBoolean) {
        break label41;
      }
      i = j;
      if (ae.fJe.fDx < 0) {
        break label41;
      }
      i = ae.fJe.fDx;
      break label41;
      label140:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (ae.fJe.fEc >= 0) {
          j = ae.fJe.fEc;
        }
      }
    }
  }
  
  /* Error */
  public final int A(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 279
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 281
    //   9: ldc_w 283
    //   12: invokestatic 288	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 290	com/tencent/mm/plugin/voip/model/c:context	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 120	com/tencent/mm/plugin/voip/model/c:Ayo	I
    //   24: iconst_2
    //   25: if_icmpne +54 -> 79
    //   28: aload_0
    //   29: iconst_3
    //   30: putfield 102	com/tencent/mm/plugin/voip/model/c:idv	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   38: aload_0
    //   39: getfield 102	com/tencent/mm/plugin/voip/model/c:idv	I
    //   42: iconst_2
    //   43: invokestatic 296	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: putfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   49: aload_0
    //   50: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   53: bipush 254
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   62: iconst_m1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 187	com/tencent/mm/plugin/voip/model/c:AyM	I
    //   71: ldc_w 279
    //   74: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_0
    //   80: iconst_2
    //   81: putfield 102	com/tencent/mm/plugin/voip/model/c:idv	I
    //   84: goto -51 -> 33
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   92: putfield 161	com/tencent/mm/plugin/voip/model/c:Ayz	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 161	com/tencent/mm/plugin/voip/model/c:Ayz	I
    //   100: aload_0
    //   101: getfield 171	com/tencent/mm/plugin/voip/model/c:AyE	I
    //   104: imul
    //   105: putfield 173	com/tencent/mm/plugin/voip/model/c:AyF	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   113: aload_0
    //   114: getfield 181	com/tencent/mm/plugin/voip/model/c:AyJ	I
    //   117: imul
    //   118: putfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   121: aload_0
    //   122: getfield 161	com/tencent/mm/plugin/voip/model/c:Ayz	I
    //   125: iconst_1
    //   126: ishr
    //   127: i2f
    //   128: aload_0
    //   129: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   132: i2f
    //   133: fdiv
    //   134: fstore_3
    //   135: invokestatic 302	com/tencent/mm/compatible/deviceinfo/m:XE	()I
    //   138: istore 4
    //   140: getstatic 237	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   143: getfield 305	com/tencent/mm/compatible/deviceinfo/b:fDQ	I
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
    //   169: ldc_w 281
    //   172: ldc_w 307
    //   175: iload 4
    //   177: invokestatic 313	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   180: invokevirtual 317	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 320
    //   189: fload_3
    //   190: fmul
    //   191: ldc_w 321
    //   194: fcmpg
    //   195: iflt +10 -> 205
    //   198: aload_0
    //   199: getfield 191	com/tencent/mm/plugin/voip/model/c:mva	I
    //   202: ifeq +6 -> 208
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +263 -> 473
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: iload 6
    //   219: putfield 98	com/tencent/mm/plugin/voip/model/c:Ayg	Z
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 98	com/tencent/mm/plugin/voip/model/c:Ayg	Z
    //   227: ldc_w 281
    //   230: new 323	java/lang/StringBuilder
    //   233: dup
    //   234: ldc_w 325
    //   237: invokespecial 328	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   244: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 334
    //   250: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: fload_3
    //   254: invokevirtual 340	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   257: ldc_w 342
    //   260: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 98	com/tencent/mm/plugin/voip/model/c:Ayg	Z
    //   267: invokevirtual 345	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: iload_2
    //   278: invokespecial 351	com/tencent/mm/plugin/voip/model/c:st	(Z)I
    //   281: istore 4
    //   283: aload_0
    //   284: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +20 -> 309
    //   292: aload_0
    //   293: getfield 133	com/tencent/mm/plugin/voip/model/c:Ayp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: iconst_0
    //   297: iconst_1
    //   298: invokevirtual 355	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   301: pop
    //   302: aload_0
    //   303: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   306: invokevirtual 358	android/media/AudioTrack:release	()V
    //   309: aload_0
    //   310: new 360	com/tencent/mm/compatible/b/e
    //   313: dup
    //   314: iload 4
    //   316: aload_0
    //   317: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   320: aload_0
    //   321: getfield 102	com/tencent/mm/plugin/voip/model/c:idv	I
    //   324: aload_0
    //   325: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   328: invokespecial 363	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   331: putfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   334: aload_0
    //   335: getfield 133	com/tencent/mm/plugin/voip/model/c:Ayp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: iconst_0
    //   340: invokevirtual 355	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: pop
    //   344: aload_0
    //   345: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   348: ifnull +13 -> 361
    //   351: aload_0
    //   352: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   355: invokevirtual 366	android/media/AudioTrack:getState	()I
    //   358: ifne +80 -> 438
    //   361: aload_0
    //   362: iconst_2
    //   363: putfield 187	com/tencent/mm/plugin/voip/model/c:AyM	I
    //   366: ldc_w 281
    //   369: ldc_w 368
    //   372: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   379: ifnull +20 -> 399
    //   382: aload_0
    //   383: getfield 133	com/tencent/mm/plugin/voip/model/c:Ayp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   386: iconst_0
    //   387: iconst_1
    //   388: invokevirtual 355	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   396: invokevirtual 358	android/media/AudioTrack:release	()V
    //   399: iload 4
    //   401: ifne +105 -> 506
    //   404: aload_0
    //   405: new 360	com/tencent/mm/compatible/b/e
    //   408: dup
    //   409: iconst_3
    //   410: aload_0
    //   411: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   414: aload_0
    //   415: getfield 102	com/tencent/mm/plugin/voip/model/c:idv	I
    //   418: aload_0
    //   419: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   422: invokespecial 363	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   425: putfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   428: aload_0
    //   429: getfield 133	com/tencent/mm/plugin/voip/model/c:Ayp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_1
    //   433: iconst_0
    //   434: invokevirtual 355	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   442: ifnonnull +91 -> 533
    //   445: aload_0
    //   446: iconst_3
    //   447: putfield 187	com/tencent/mm/plugin/voip/model/c:AyM	I
    //   450: ldc_w 281
    //   453: ldc_w 372
    //   456: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: ldc_w 279
    //   462: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: iconst_m1
    //   466: ireturn
    //   467: iconst_0
    //   468: istore 4
    //   470: goto -284 -> 186
    //   473: iconst_1
    //   474: istore 6
    //   476: goto -260 -> 216
    //   479: astore_1
    //   480: ldc_w 281
    //   483: ldc_w 374
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload_1
    //   493: aastore
    //   494: invokestatic 377	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: aload_0
    //   498: bipush 6
    //   500: putfield 187	com/tencent/mm/plugin/voip/model/c:AyM	I
    //   503: goto -159 -> 344
    //   506: aload_0
    //   507: new 360	com/tencent/mm/compatible/b/e
    //   510: dup
    //   511: iconst_0
    //   512: aload_0
    //   513: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   516: aload_0
    //   517: getfield 102	com/tencent/mm/plugin/voip/model/c:idv	I
    //   520: aload_0
    //   521: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   524: invokespecial 363	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   527: putfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   530: goto -102 -> 428
    //   533: aload_0
    //   534: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   537: invokevirtual 366	android/media/AudioTrack:getState	()I
    //   540: ifne +47 -> 587
    //   543: aload_0
    //   544: iconst_3
    //   545: putfield 187	com/tencent/mm/plugin/voip/model/c:AyM	I
    //   548: ldc_w 281
    //   551: ldc_w 379
    //   554: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 133	com/tencent/mm/plugin/voip/model/c:Ayp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   561: iconst_0
    //   562: iconst_1
    //   563: invokevirtual 355	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   566: pop
    //   567: aload_0
    //   568: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   571: invokevirtual 358	android/media/AudioTrack:release	()V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   579: ldc_w 279
    //   582: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: iconst_m1
    //   586: ireturn
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   592: newarray byte
    //   594: putfield 108	com/tencent/mm/plugin/voip/model/c:Ayj	[B
    //   597: aload_0
    //   598: getfield 108	com/tencent/mm/plugin/voip/model/c:Ayj	[B
    //   601: ifnonnull +20 -> 621
    //   604: ldc_w 281
    //   607: ldc_w 381
    //   610: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc_w 279
    //   616: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: iconst_m1
    //   620: ireturn
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 124	com/tencent/mm/plugin/voip/model/c:idA	I
    //   626: newarray byte
    //   628: putfield 114	com/tencent/mm/plugin/voip/model/c:Aym	[B
    //   631: aload_0
    //   632: getfield 114	com/tencent/mm/plugin/voip/model/c:Aym	[B
    //   635: ifnonnull +20 -> 655
    //   638: ldc_w 281
    //   641: ldc_w 383
    //   644: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: ldc_w 279
    //   650: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: iconst_m1
    //   654: ireturn
    //   655: aload_0
    //   656: getfield 98	com/tencent/mm/plugin/voip/model/c:Ayg	Z
    //   659: ifeq +113 -> 772
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   667: putfield 106	com/tencent/mm/plugin/voip/model/c:Ayi	I
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 106	com/tencent/mm/plugin/voip/model/c:Ayi	I
    //   675: newarray byte
    //   677: putfield 110	com/tencent/mm/plugin/voip/model/c:Ayk	[B
    //   680: aload_0
    //   681: getfield 110	com/tencent/mm/plugin/voip/model/c:Ayk	[B
    //   684: ifnonnull +20 -> 704
    //   687: ldc_w 281
    //   690: ldc_w 385
    //   693: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: ldc_w 279
    //   699: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: iconst_m1
    //   703: ireturn
    //   704: aload_0
    //   705: aload_0
    //   706: getfield 106	com/tencent/mm/plugin/voip/model/c:Ayi	I
    //   709: newarray byte
    //   711: putfield 112	com/tencent/mm/plugin/voip/model/c:Ayl	[B
    //   714: aload_0
    //   715: getfield 112	com/tencent/mm/plugin/voip/model/c:Ayl	[B
    //   718: ifnonnull +20 -> 738
    //   721: ldc_w 281
    //   724: ldc_w 387
    //   727: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: ldc_w 279
    //   733: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: iconst_m1
    //   737: ireturn
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 124	com/tencent/mm/plugin/voip/model/c:idA	I
    //   743: newarray byte
    //   745: putfield 116	com/tencent/mm/plugin/voip/model/c:Ayn	[B
    //   748: aload_0
    //   749: getfield 116	com/tencent/mm/plugin/voip/model/c:Ayn	[B
    //   752: ifnonnull +20 -> 772
    //   755: ldc_w 281
    //   758: ldc_w 389
    //   761: invokestatic 370	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: ldc_w 279
    //   767: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_m1
    //   771: ireturn
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield 94	com/tencent/mm/plugin/voip/model/c:Aye	Z
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 96	com/tencent/mm/plugin/voip/model/c:Ayf	Z
    //   782: ldc_w 281
    //   785: ldc_w 391
    //   788: iconst_5
    //   789: anewarray 4	java/lang/Object
    //   792: dup
    //   793: iconst_0
    //   794: invokestatic 394	com/tencent/mm/plugin/audio/c/a:getMode	()I
    //   797: invokestatic 399	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: dup
    //   802: iconst_1
    //   803: invokestatic 403	com/tencent/mm/plugin/audio/c/a:isSpeakerphoneOn	()Z
    //   806: invokestatic 408	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   809: aastore
    //   810: dup
    //   811: iconst_2
    //   812: iload 4
    //   814: invokestatic 399	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: dup
    //   819: iconst_3
    //   820: aload_0
    //   821: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   824: invokestatic 399	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: aastore
    //   828: dup
    //   829: iconst_4
    //   830: aload_0
    //   831: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   834: invokestatic 399	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: invokestatic 410	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: aload_0
    //   842: getfield 104	com/tencent/mm/plugin/voip/model/c:idz	I
    //   845: sipush 1000
    //   848: imul
    //   849: aload_0
    //   850: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   853: iconst_2
    //   854: imul
    //   855: idiv
    //   856: istore 4
    //   858: ldc_w 279
    //   861: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if (true == this.Aye) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.Ayo = paramInt2;
    this.idw = paramInt3;
    this.mva = paramInt4;
    this.idA = (this.nSamplerate / 1000 * paramInt2 * this.idw * 2);
    this.AyH = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  public final void a(b paramb)
  {
    this.Ayq = paramb;
  }
  
  public final int aKj()
  {
    AppMethodBeat.i(114824);
    if (this.aUW != null)
    {
      i = this.aUW.getStreamType();
      AppMethodBeat.o(114824);
      return i;
    }
    int i = st(true);
    AppMethodBeat.o(114824);
    return i;
  }
  
  public final int ehe()
  {
    return this.AyK / this.idA * this.idw;
  }
  
  public final int ehf()
  {
    AppMethodBeat.i(114819);
    ac.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit");
    if (this.aUW != null)
    {
      this.Ayp.compareAndSet(false, true);
      this.aUW.release();
      this.aUW = null;
    }
    for (;;)
    {
      this.Aye = false;
      this.Ayf = false;
      AppMethodBeat.o(114819);
      return 1;
      ac.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit failed cause audio track is null");
    }
  }
  
  public final int ehg()
  {
    AppMethodBeat.i(114820);
    if (true == this.Aye)
    {
      AppMethodBeat.o(114820);
      return 1;
    }
    if (this.aUW == null)
    {
      ac.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      AppMethodBeat.o(114820);
      return 0;
    }
    this.Aye = true;
    try
    {
      this.aUW.play();
      if ((this.aUW != null) && (this.aUW.getPlayState() != 3))
      {
        this.AyM = 4;
        ac.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
        AppMethodBeat.o(114820);
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[] { localException.getMessage() });
      }
      if ((this.aUW != null) && (this.aUW.getState() == 0))
      {
        ac.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        AppMethodBeat.o(114820);
        return 0;
      }
      if (this.Ayg)
      {
        int i;
        if ((this.cWo) || (this.cWn != null))
        {
          ac.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.cWo);
          i = -1;
        }
        while (i != 0)
        {
          ac.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          AppMethodBeat.o(114820);
          return 0;
          this.cWn = new Timer();
          if (this.cWn == null) {
            i = -1;
          } else {
            i = 0;
          }
        }
        this.cWn.scheduleAtFixedRate(new a(), 0L, 20L);
        this.cWo = true;
      }
      this.idk = new com.tencent.mm.audio.c.a.a();
      this.yqm = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "AudioPlayer_play";
        }
        
        public final void run()
        {
          AppMethodBeat.i(114813);
          Process.setThreadPriority(-19);
          ac.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
          int j = 0;
          while ((c.this.Aye) && (c.this.aUW != null) && (c.this.aUW.getPlayState() != 1) && (!c.this.Ayp.get()))
          {
            int i;
            long l;
            try
            {
              i = c.this.aUW.getPlaybackHeadPosition();
              l = System.currentTimeMillis();
              c.d(c.this, c.j(c.this) - i);
              ac.i("MicroMsg.Voip.AudioPlayer", "m_iLefSamples value is %s and iPos value is %s", new Object[] { Integer.valueOf(c.k(c.this)), Integer.valueOf(i) });
              if (c.l(c.this) == 1)
              {
                c.e(c.this, i);
                c.a(c.this, l);
                c.b(c.this, l);
                c.m(c.this);
                c.c(c.this, l);
                if ((i != 0) && (c.this.Ayg)) {
                  c.t(c.this);
                }
                if (c.this.Ayq == null) {
                  break label1593;
                }
                c.h(c.this, c.u(c.this) + c.this.idA);
                if (c.a(c.this) != 0) {
                  break label715;
                }
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.idA, c.x(c.this));
                  c.w(c.this).cg(1, com.tencent.mm.plugin.audio.c.a.bCx().getStreamVolume(c.this.aKj()) * 100 / com.tencent.mm.plugin.audio.c.a.bCx().audioManager.getStreamMaxVolume(c.this.aKj()));
                }
                i = c.this.Ayq.O(c.x(c.this), c.this.idA);
                if (i >= 0) {
                  break label1165;
                }
                d.SK(5);
                ac.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[] { localException });
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
                if (c.b(c.this) >= c.this.idA)
                {
                  ac.i("MicroMsg.Voip.AudioPlayer", "m_iTaskLeftByte value is %s and nFrameLen value is %s", new Object[] { Integer.valueOf(c.b(c.this)), Integer.valueOf(c.this.idA) });
                  synchronized (c.f(c.this))
                  {
                    System.arraycopy(c.g(c.this), 0, c.x(c.this), 0, c.this.idA);
                    i = c.b(c.this) - c.this.idA;
                    System.arraycopy(c.g(c.this), c.this.idA, c.y(c.this), 0, i);
                    System.arraycopy(c.y(c.this), 0, c.g(c.this), 0, i);
                    c.b(c.this, c.b(c.this) - c.this.idA);
                    ac.i("MicroMsg.Voip.AudioPlayer", "audio player has copy playTaskBuffer and left %s", new Object[] { Integer.valueOf(c.b(c.this)) });
                    i = 0;
                  }
                }
                if ((c.k(c.this) >= c.z(c.this) * 5 / 1000) || (c.A(c.this) != 0)) {
                  break;
                }
                c.i(c.this, 1);
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.idA, c.x(c.this));
                  c.w(c.this).cg(1, com.tencent.mm.plugin.audio.c.a.bCx().audioManager.getStreamVolume(c.this.aKj()) * 100 / com.tencent.mm.plugin.audio.c.a.bCx().audioManager.getStreamMaxVolume(c.this.aKj()));
                }
                i = c.this.Ayq.O(c.x(c.this), c.this.idA);
                c.i(c.this, 0);
              }
              ac.i("MicroMsg.Voip.AudioPlayer", "play run too fast !,m_iLefSamples: " + c.k(c.this) + " ,m_iTaskLeftByte: " + c.b(c.this));
              d.SK(2);
            }
            continue;
            label1165:
            if (c.B(c.this))
            {
              ac.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.B(c.this));
              d.SK(10);
            }
            else
            {
              c.a(c.this, l);
              if (c.C(c.this) >= c.this.idA)
              {
                if (!c.B(c.this))
                {
                  i = c.this.aUW.write(c.x(c.this), 0, c.this.idA);
                  if (i < 0)
                  {
                    c.j(c.this, i);
                    ac.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.k(c.this, c.j(c.this) + (c.this.idA >> 1));
                }
              }
              else
              {
                System.arraycopy(c.x(c.this), 0, c.D(c.this), j, c.C(c.this) - j);
                if (c.this.aUW != null)
                {
                  i = c.this.aUW.write(c.D(c.this), 0, c.D(c.this).length);
                  if (i < 0)
                  {
                    c.j(c.this, i);
                    ac.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.k(c.this, c.j(c.this) + (c.D(c.this).length >> 1));
                  j = c.C(c.this) - j;
                  i = c.this.idA - j;
                  while ((i >= c.C(c.this)) && (c.this.aUW != null))
                  {
                    c.this.aUW.write(c.x(c.this), j, c.C(c.this));
                    j += c.C(c.this);
                    i -= c.C(c.this);
                    c.k(c.this, c.j(c.this) + (c.C(c.this) >> 1));
                  }
                }
                AppMethodBeat.o(114813);
                return;
                System.arraycopy(c.x(c.this), j, c.D(c.this), 0, i);
                j = i;
                continue;
                label1593:
                d.SK(10);
              }
            }
          }
          if ((c.v(c.this) == 0) && (c.E(c.this) != null) && (c.w(c.this) != null))
          {
            c.w(c.this).b(1, c.E(c.this), c.this.aKj());
            c.w(c.this).hJ(1);
            c.w(c.this).hK(1);
            c.w(c.this).hL(1);
          }
          AppMethodBeat.o(114813);
        }
      };
      h.JZN.aTz("AudioPlayer_play");
      h.JZN.f(this.yqm, "AudioPlayer_play");
      AppMethodBeat.o(114820);
    }
    return 1;
  }
  
  public final int ehh()
  {
    AppMethodBeat.i(114821);
    if (this.nSamplerate == 0)
    {
      ac.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
      AppMethodBeat.o(114821);
      return 0;
    }
    if (this.aUW == null)
    {
      ac.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.Ayz + ",nSamplerate:" + this.nSamplerate);
      i = this.Ayz * 1000 / this.nSamplerate;
      AppMethodBeat.o(114821);
      return i;
    }
    if ((this.Aye) && (this.aUW.getState() != 0)) {
      try
      {
        i = this.aUW.getPlaybackHeadPosition();
        i = (this.Ayv - i) * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        i = this.Ayz * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
    }
    int i = this.Ayz * 1000 / this.nSamplerate;
    AppMethodBeat.o(114821);
    return i;
  }
  
  /* Error */
  public final int ehi()
  {
    // Byte code:
    //   0: ldc_w 508
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 139	com/tencent/mm/plugin/voip/model/c:cWo	Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 137	com/tencent/mm/plugin/voip/model/c:cWn	Ljava/util/Timer;
    //   17: ifnull +15 -> 32
    //   20: aload_0
    //   21: getfield 137	com/tencent/mm/plugin/voip/model/c:cWn	Ljava/util/Timer;
    //   24: invokevirtual 511	java/util/Timer:cancel	()V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 139	com/tencent/mm/plugin/voip/model/c:cWo	Z
    //   32: ldc_w 281
    //   35: ldc_w 513
    //   38: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 94	com/tencent/mm/plugin/voip/model/c:Aye	Z
    //   45: ifne +20 -> 65
    //   48: ldc_w 281
    //   51: ldc_w 515
    //   54: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: ldc_w 508
    //   60: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_1
    //   64: ireturn
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 94	com/tencent/mm/plugin/voip/model/c:Aye	Z
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 183	com/tencent/mm/plugin/voip/model/c:AyK	I
    //   75: aload_0
    //   76: getfield 470	com/tencent/mm/plugin/voip/model/c:yqm	Lcom/tencent/e/i/b;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +10 -> 91
    //   84: aload_0
    //   85: getfield 470	com/tencent/mm/plugin/voip/model/c:yqm	Lcom/tencent/e/i/b;
    //   88: invokevirtual 520	com/tencent/e/i/b:fEw	()V
    //   91: aload_0
    //   92: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   95: ifnull +56 -> 151
    //   98: aload_0
    //   99: getfield 133	com/tencent/mm/plugin/voip/model/c:Ayp	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 355	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: pop
    //   108: aload_0
    //   109: getfield 470	com/tencent/mm/plugin/voip/model/c:yqm	Lcom/tencent/e/i/b;
    //   112: invokevirtual 522	com/tencent/e/i/b:cancel	()Z
    //   115: pop
    //   116: getstatic 476	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   119: ldc_w 478
    //   122: invokeinterface 484 2 0
    //   127: pop
    //   128: aload_0
    //   129: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   132: invokevirtual 525	android/media/AudioTrack:stop	()V
    //   135: aload_0
    //   136: getfield 126	com/tencent/mm/plugin/voip/model/c:aUW	Landroid/media/AudioTrack;
    //   139: invokevirtual 358	android/media/AudioTrack:release	()V
    //   142: ldc_w 281
    //   145: ldc_w 527
    //   148: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc_w 508
    //   154: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore_1
    //   160: ldc_w 281
    //   163: aload_1
    //   164: ldc_w 529
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 533	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -83 -> 91
    //   177: astore_1
    //   178: ldc_w 281
    //   181: aload_1
    //   182: ldc_w 529
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 533	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: goto -101 -> 91
    //   195: astore_1
    //   196: ldc_w 281
    //   199: ldc_w 535
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: invokevirtual 442	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 444	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final int ehj()
  {
    AppMethodBeat.i(114823);
    ac.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.AyM);
    int i = this.AyM;
    AppMethodBeat.o(114823);
    return i;
  }
  
  public final boolean isPlaying()
  {
    return this.Aye;
  }
  
  public final boolean ss(boolean paramBoolean)
  {
    AppMethodBeat.i(114817);
    ac.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = st(paramBoolean);
    if (com.tencent.mm.plugin.audio.c.a.bCy()) {
      i = 0;
    }
    ac.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.aUW != null) && (i == this.aUW.getStreamType()))
    {
      ac.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      AppMethodBeat.o(114817);
      return false;
    }
    ehi();
    this.idB = true;
    if (this.Ayo == 2) {}
    for (this.idv = 3;; this.idv = 2)
    {
      this.idz = AudioTrack.getMinBufferSize(this.nSamplerate, this.idv, 2);
      if ((this.idz != -2) && (this.idz != -1)) {
        break;
      }
      this.idB = false;
      AppMethodBeat.o(114817);
      return false;
    }
    this.Ayv = 0;
    this.Ayy = 0;
    this.AyA = 1;
    this.AyB = 0;
    this.AyC = 0L;
    this.AyD = 0L;
    this.AyE = 1;
    this.AyG = -1;
    this.AyH = 0;
    this.Ayz = this.idz;
    this.AyF = (this.Ayz * this.AyE);
    this.idz *= this.AyJ;
    float f = this.Ayz / 16.0F;
    ac.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.idz + "  MinBufSizeInMs:" + f);
    if (this.aUW != null) {}
    try
    {
      this.Ayp.compareAndSet(false, true);
      this.yqm.cancel();
      h.JZN.aTz("AudioPlayer_play");
      this.aUW.stop();
      this.aUW.release();
      this.aUW = null;
      ac.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Integer.valueOf(i), Integer.valueOf(this.idz), Integer.valueOf(this.nSamplerate) });
      this.aUW = new e(i, this.nSamplerate, this.idv, this.idz);
      if ((this.aUW != null) && (this.aUW.getState() == 0))
      {
        ac.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.Ayp.compareAndSet(false, true);
        this.aUW.release();
        this.aUW = null;
        AppMethodBeat.o(114817);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[] { localException.getMessage() });
      }
      ac.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
      if (this.aUW != null)
      {
        this.idB = false;
        ehg();
        AppMethodBeat.o(114817);
        return true;
      }
      this.idB = false;
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
      if ((c.a(c.this) == 1) && (c.this.Aye == true))
      {
        System.currentTimeMillis();
        if ((c.b(c.this) + c.this.idA < c.c(c.this)) && (c.d(c.this) == 0) && (c.this.Ayq != null))
        {
          c.a(c.this, 1);
          int i = c.this.Ayq.O(c.e(c.this), c.this.idA);
          c.a(c.this, 0);
          if (i < 0)
          {
            ac.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
            AppMethodBeat.o(114814);
            return;
          }
          synchronized (c.f(c.this))
          {
            System.arraycopy(c.e(c.this), 0, c.g(c.this), c.b(c.this), c.this.idA);
            c.b(c.this, c.b(c.this) + c.this.idA);
            c.c(c.this, c.h(c.this) + (c.this.idA >> 1));
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