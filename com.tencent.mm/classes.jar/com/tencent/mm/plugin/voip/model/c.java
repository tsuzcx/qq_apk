package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static float volume = 0.0F;
  private com.tencent.e.i.b Kub;
  private int NJA;
  private int NJB;
  private int NJC;
  private int NJD;
  private int NJE;
  private int NJF;
  private long NJG;
  private long NJH;
  private int NJI;
  private int NJJ;
  private int NJK;
  private int NJL;
  private long NJM;
  private int NJN;
  private int NJO;
  private final Object NJP;
  private int NJQ;
  int NJR;
  private int NJS;
  private int NJT;
  private int NJU;
  public boolean NJh;
  boolean NJi;
  boolean NJj;
  l NJk;
  private int NJl;
  private byte[] NJm;
  private byte[] NJn;
  private byte[] NJo;
  private byte[] NJp;
  private byte[] NJq;
  public int NJr;
  AtomicBoolean NJs;
  public b NJt;
  private d<?> NJu;
  private int NJv;
  private int NJw;
  private int NJx;
  String NJy;
  private int NJz;
  AudioTrack aOO;
  Context context;
  private int joo;
  int mkA;
  private int mkB;
  int mkE;
  int mkF;
  private boolean mkG;
  private com.tencent.mm.audio.c.a.a mkp;
  private int nSamplerate;
  private int rpf;
  
  public c()
  {
    AppMethodBeat.i(114815);
    this.NJh = false;
    this.NJi = false;
    this.NJj = true;
    this.NJk = null;
    this.mkA = 2;
    this.mkE = 0;
    this.NJl = 0;
    this.NJm = null;
    this.NJn = null;
    this.NJo = null;
    this.NJp = null;
    this.NJq = null;
    this.nSamplerate = 0;
    this.NJr = 0;
    this.mkB = 0;
    this.mkF = 20;
    this.aOO = null;
    this.NJs = new AtomicBoolean(false);
    this.NJt = null;
    this.NJu = null;
    this.NJv = 1;
    this.NJw = 1;
    this.NJx = 0;
    this.NJy = null;
    this.joo = 3;
    this.mkG = false;
    this.NJz = 0;
    this.NJA = 0;
    this.NJB = 0;
    this.NJC = 0;
    this.NJD = 0;
    this.NJE = 1;
    this.NJF = 0;
    this.NJG = 0L;
    this.NJH = 0L;
    this.NJI = 1;
    this.NJJ = 0;
    this.NJK = -1;
    this.NJL = 0;
    this.NJM = 0L;
    this.NJN = 1;
    this.NJO = 0;
    this.NJP = new Object();
    this.NJQ = 0;
    this.NJR = 0;
    this.NJS = 0;
    this.rpf = 0;
    this.NJT = 0;
    this.NJU = 0;
    AppMethodBeat.o(114815);
  }
  
  private int AL(boolean paramBoolean)
  {
    AppMethodBeat.i(114818);
    int j = 0;
    int i;
    if (af.juI.jnL > 0)
    {
      j = com.tencent.mm.plugin.audio.c.a.kG(paramBoolean);
      if ((!paramBoolean) || (af.juI.jor < 0)) {
        break label113;
      }
      i = af.juI.jor;
      label41:
      j = i;
      if (1 == this.rpf)
      {
        if (af.juI.jpg >= 0) {
          i = af.juI.jpg;
        }
        if ((!paramBoolean) || (af.juI.jph < 0)) {
          break label140;
        }
        j = af.juI.jph;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114818);
      return j;
      if (af.juI.joq < 0) {
        break;
      }
      j = af.juI.joq;
      break;
      label113:
      i = j;
      if (paramBoolean) {
        break label41;
      }
      i = j;
      if (af.juI.jos < 0) {
        break label41;
      }
      i = af.juI.jos;
      break label41;
      label140:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (af.juI.jpi >= 0) {
          j = af.juI.jpi;
        }
      }
    }
  }
  
  public final boolean AK(boolean paramBoolean)
  {
    AppMethodBeat.i(114817);
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = AL(paramBoolean);
    if (com.tencent.mm.plugin.audio.c.a.cro()) {
      i = 0;
    }
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.aOO != null) && (i == this.aOO.getStreamType()))
    {
      Log.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      AppMethodBeat.o(114817);
      return false;
    }
    gxD();
    this.mkG = true;
    if (this.NJr == 2) {}
    for (this.mkA = 3;; this.mkA = 2)
    {
      this.mkE = AudioTrack.getMinBufferSize(this.nSamplerate, this.mkA, 2);
      if ((this.mkE != -2) && (this.mkE != -1)) {
        break;
      }
      this.mkG = false;
      AppMethodBeat.o(114817);
      return false;
    }
    this.NJz = 0;
    this.NJC = 0;
    this.NJE = 1;
    this.NJF = 0;
    this.NJG = 0L;
    this.NJH = 0L;
    this.NJI = 1;
    this.NJK = -1;
    this.NJL = 0;
    this.NJD = this.mkE;
    this.NJJ = (this.NJD * this.NJI);
    this.mkE *= this.NJN;
    float f = this.NJD / 16.0F;
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.mkE + "  MinBufSizeInMs:" + f);
    if (this.aOO != null) {}
    try
    {
      this.NJs.compareAndSet(false, true);
      this.Kub.cancel();
      h.ZvG.bDh("AudioPlayer_play");
      this.aOO.stop();
      this.aOO.release();
      this.aOO = null;
      Log.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.crl()), Integer.valueOf(i), Integer.valueOf(this.mkE), Integer.valueOf(this.nSamplerate) });
      this.aOO = new com.tencent.mm.compatible.b.e(i, this.nSamplerate, this.mkA, this.mkE);
      if ((this.aOO != null) && (this.aOO.getState() == 0))
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.NJs.compareAndSet(false, true);
        this.aOO.release();
        this.aOO = null;
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
      if (this.aOO != null)
      {
        this.mkG = false;
        gxB();
        AppMethodBeat.o(114817);
        return true;
      }
      this.mkG = false;
      AppMethodBeat.o(114817);
    }
    return false;
  }
  
  /* Error */
  public final int K(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 422
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 283
    //   9: ldc_w 424
    //   12: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 426	com/tencent/mm/plugin/voip/model/c:context	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 121	com/tencent/mm/plugin/voip/model/c:NJr	I
    //   24: iconst_2
    //   25: if_icmpne +54 -> 79
    //   28: aload_0
    //   29: iconst_3
    //   30: putfield 103	com/tencent/mm/plugin/voip/model/c:mkA	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   38: aload_0
    //   39: getfield 103	com/tencent/mm/plugin/voip/model/c:mkA	I
    //   42: iconst_2
    //   43: invokestatic 334	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: putfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   49: aload_0
    //   50: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   53: bipush 254
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   62: iconst_m1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 186	com/tencent/mm/plugin/voip/model/c:NJQ	I
    //   71: ldc_w 422
    //   74: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_0
    //   80: iconst_2
    //   81: putfield 103	com/tencent/mm/plugin/voip/model/c:mkA	I
    //   84: goto -51 -> 33
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   92: putfield 160	com/tencent/mm/plugin/voip/model/c:NJD	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 160	com/tencent/mm/plugin/voip/model/c:NJD	I
    //   100: aload_0
    //   101: getfield 170	com/tencent/mm/plugin/voip/model/c:NJI	I
    //   104: imul
    //   105: putfield 172	com/tencent/mm/plugin/voip/model/c:NJJ	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   113: aload_0
    //   114: getfield 180	com/tencent/mm/plugin/voip/model/c:NJN	I
    //   117: imul
    //   118: putfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   121: aload_0
    //   122: getfield 160	com/tencent/mm/plugin/voip/model/c:NJD	I
    //   125: iconst_1
    //   126: ishr
    //   127: i2f
    //   128: aload_0
    //   129: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   132: i2f
    //   133: fdiv
    //   134: fstore_3
    //   135: invokestatic 431	com/tencent/mm/compatible/deviceinfo/m:aus	()I
    //   138: istore 4
    //   140: getstatic 210	com/tencent/mm/compatible/deviceinfo/af:juI	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   143: getfield 434	com/tencent/mm/compatible/deviceinfo/b:joW	I
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
    //   169: ldc_w 283
    //   172: ldc_w 436
    //   175: iload 4
    //   177: invokestatic 441	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   180: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 448
    //   189: fload_3
    //   190: fmul
    //   191: ldc_w 449
    //   194: fcmpg
    //   195: iflt +10 -> 205
    //   198: aload_0
    //   199: getfield 192	com/tencent/mm/plugin/voip/model/c:rpf	I
    //   202: ifeq +6 -> 208
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +263 -> 473
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: iload 6
    //   219: putfield 99	com/tencent/mm/plugin/voip/model/c:NJj	Z
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 99	com/tencent/mm/plugin/voip/model/c:NJj	Z
    //   227: ldc_w 283
    //   230: new 298	java/lang/StringBuilder
    //   233: dup
    //   234: ldc_w 451
    //   237: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   244: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 339
    //   250: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: fload_3
    //   254: invokevirtual 342	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   257: ldc_w 453
    //   260: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 99	com/tencent/mm/plugin/voip/model/c:NJj	Z
    //   267: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: iload_2
    //   278: invokespecial 292	com/tencent/mm/plugin/voip/model/c:AL	(Z)I
    //   281: istore 4
    //   283: aload_0
    //   284: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +20 -> 309
    //   292: aload_0
    //   293: getfield 134	com/tencent/mm/plugin/voip/model/c:NJs	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: iconst_0
    //   297: iconst_1
    //   298: invokevirtual 346	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   301: pop
    //   302: aload_0
    //   303: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   306: invokevirtual 373	android/media/AudioTrack:release	()V
    //   309: aload_0
    //   310: new 397	com/tencent/mm/compatible/b/e
    //   313: dup
    //   314: iload 4
    //   316: aload_0
    //   317: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   320: aload_0
    //   321: getfield 103	com/tencent/mm/plugin/voip/model/c:mkA	I
    //   324: aload_0
    //   325: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   328: invokespecial 400	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   331: putfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   334: aload_0
    //   335: getfield 134	com/tencent/mm/plugin/voip/model/c:NJs	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: iconst_0
    //   340: invokevirtual 346	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: pop
    //   344: aload_0
    //   345: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   348: ifnull +13 -> 361
    //   351: aload_0
    //   352: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   355: invokevirtual 403	android/media/AudioTrack:getState	()I
    //   358: ifne +80 -> 438
    //   361: aload_0
    //   362: iconst_2
    //   363: putfield 186	com/tencent/mm/plugin/voip/model/c:NJQ	I
    //   366: ldc_w 283
    //   369: ldc_w 455
    //   372: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   379: ifnull +20 -> 399
    //   382: aload_0
    //   383: getfield 134	com/tencent/mm/plugin/voip/model/c:NJs	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   386: iconst_0
    //   387: iconst_1
    //   388: invokevirtual 346	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   396: invokevirtual 373	android/media/AudioTrack:release	()V
    //   399: iload 4
    //   401: ifne +105 -> 506
    //   404: aload_0
    //   405: new 397	com/tencent/mm/compatible/b/e
    //   408: dup
    //   409: iconst_3
    //   410: aload_0
    //   411: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   414: aload_0
    //   415: getfield 103	com/tencent/mm/plugin/voip/model/c:mkA	I
    //   418: aload_0
    //   419: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   422: invokespecial 400	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   425: putfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   428: aload_0
    //   429: getfield 134	com/tencent/mm/plugin/voip/model/c:NJs	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_1
    //   433: iconst_0
    //   434: invokevirtual 346	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   442: ifnonnull +91 -> 533
    //   445: aload_0
    //   446: iconst_3
    //   447: putfield 186	com/tencent/mm/plugin/voip/model/c:NJQ	I
    //   450: ldc_w 283
    //   453: ldc_w 457
    //   456: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: ldc_w 422
    //   462: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: iconst_m1
    //   466: ireturn
    //   467: iconst_0
    //   468: istore 4
    //   470: goto -284 -> 186
    //   473: iconst_1
    //   474: istore 6
    //   476: goto -260 -> 216
    //   479: astore_1
    //   480: ldc_w 283
    //   483: ldc_w 459
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload_1
    //   493: aastore
    //   494: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: aload_0
    //   498: bipush 6
    //   500: putfield 186	com/tencent/mm/plugin/voip/model/c:NJQ	I
    //   503: goto -159 -> 344
    //   506: aload_0
    //   507: new 397	com/tencent/mm/compatible/b/e
    //   510: dup
    //   511: iconst_0
    //   512: aload_0
    //   513: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   516: aload_0
    //   517: getfield 103	com/tencent/mm/plugin/voip/model/c:mkA	I
    //   520: aload_0
    //   521: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   524: invokespecial 400	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   527: putfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   530: goto -102 -> 428
    //   533: aload_0
    //   534: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   537: invokevirtual 403	android/media/AudioTrack:getState	()I
    //   540: ifne +47 -> 587
    //   543: aload_0
    //   544: iconst_3
    //   545: putfield 186	com/tencent/mm/plugin/voip/model/c:NJQ	I
    //   548: ldc_w 283
    //   551: ldc_w 463
    //   554: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 134	com/tencent/mm/plugin/voip/model/c:NJs	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   561: iconst_0
    //   562: iconst_1
    //   563: invokevirtual 346	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   566: pop
    //   567: aload_0
    //   568: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   571: invokevirtual 373	android/media/AudioTrack:release	()V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   579: ldc_w 422
    //   582: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: iconst_m1
    //   586: ireturn
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   592: newarray byte
    //   594: putfield 109	com/tencent/mm/plugin/voip/model/c:NJm	[B
    //   597: aload_0
    //   598: getfield 109	com/tencent/mm/plugin/voip/model/c:NJm	[B
    //   601: ifnonnull +20 -> 621
    //   604: ldc_w 283
    //   607: ldc_w 465
    //   610: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc_w 422
    //   616: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: iconst_m1
    //   620: ireturn
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 125	com/tencent/mm/plugin/voip/model/c:mkF	I
    //   626: newarray byte
    //   628: putfield 115	com/tencent/mm/plugin/voip/model/c:NJp	[B
    //   631: aload_0
    //   632: getfield 115	com/tencent/mm/plugin/voip/model/c:NJp	[B
    //   635: ifnonnull +20 -> 655
    //   638: ldc_w 283
    //   641: ldc_w 467
    //   644: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: ldc_w 422
    //   650: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: iconst_m1
    //   654: ireturn
    //   655: aload_0
    //   656: getfield 99	com/tencent/mm/plugin/voip/model/c:NJj	Z
    //   659: ifeq +113 -> 772
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   667: putfield 107	com/tencent/mm/plugin/voip/model/c:NJl	I
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 107	com/tencent/mm/plugin/voip/model/c:NJl	I
    //   675: newarray byte
    //   677: putfield 111	com/tencent/mm/plugin/voip/model/c:NJn	[B
    //   680: aload_0
    //   681: getfield 111	com/tencent/mm/plugin/voip/model/c:NJn	[B
    //   684: ifnonnull +20 -> 704
    //   687: ldc_w 283
    //   690: ldc_w 469
    //   693: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: ldc_w 422
    //   699: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: iconst_m1
    //   703: ireturn
    //   704: aload_0
    //   705: aload_0
    //   706: getfield 107	com/tencent/mm/plugin/voip/model/c:NJl	I
    //   709: newarray byte
    //   711: putfield 113	com/tencent/mm/plugin/voip/model/c:NJo	[B
    //   714: aload_0
    //   715: getfield 113	com/tencent/mm/plugin/voip/model/c:NJo	[B
    //   718: ifnonnull +20 -> 738
    //   721: ldc_w 283
    //   724: ldc_w 471
    //   727: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: ldc_w 422
    //   733: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: iconst_m1
    //   737: ireturn
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 125	com/tencent/mm/plugin/voip/model/c:mkF	I
    //   743: newarray byte
    //   745: putfield 117	com/tencent/mm/plugin/voip/model/c:NJq	[B
    //   748: aload_0
    //   749: getfield 117	com/tencent/mm/plugin/voip/model/c:NJq	[B
    //   752: ifnonnull +20 -> 772
    //   755: ldc_w 283
    //   758: ldc_w 473
    //   761: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: ldc_w 422
    //   767: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_m1
    //   771: ireturn
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield 95	com/tencent/mm/plugin/voip/model/c:NJh	Z
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 97	com/tencent/mm/plugin/voip/model/c:NJi	Z
    //   782: ldc_w 283
    //   785: ldc_w 475
    //   788: iconst_5
    //   789: anewarray 4	java/lang/Object
    //   792: dup
    //   793: iconst_0
    //   794: invokestatic 378	com/tencent/mm/plugin/audio/c/a:getMode	()I
    //   797: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: dup
    //   802: iconst_1
    //   803: invokestatic 387	com/tencent/mm/plugin/audio/c/a:crl	()Z
    //   806: invokestatic 392	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   809: aastore
    //   810: dup
    //   811: iconst_2
    //   812: iload 4
    //   814: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: dup
    //   819: iconst_3
    //   820: aload_0
    //   821: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   824: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: aastore
    //   828: dup
    //   829: iconst_4
    //   830: aload_0
    //   831: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   834: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: aload_0
    //   842: getfield 105	com/tencent/mm/plugin/voip/model/c:mkE	I
    //   845: sipush 1000
    //   848: imul
    //   849: aload_0
    //   850: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   853: iconst_2
    //   854: imul
    //   855: idiv
    //   856: istore 4
    //   858: ldc_w 422
    //   861: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final int S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (true == this.NJh) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.NJr = paramInt2;
    this.mkB = paramInt3;
    this.rpf = paramInt4;
    this.mkF = (this.nSamplerate / 1000 * paramInt2 * this.mkB * 2);
    this.NJL = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  public final void a(b paramb)
  {
    this.NJt = paramb;
  }
  
  public final int gxA()
  {
    AppMethodBeat.i(114819);
    Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit");
    if (this.aOO != null)
    {
      this.NJs.compareAndSet(false, true);
      this.aOO.release();
      this.aOO = null;
    }
    for (;;)
    {
      this.NJh = false;
      this.NJi = false;
      AppMethodBeat.o(114819);
      return 1;
      Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit failed cause audio track is null");
    }
  }
  
  public final int gxB()
  {
    AppMethodBeat.i(114820);
    if (true == this.NJh)
    {
      AppMethodBeat.o(114820);
      return 1;
    }
    if (this.aOO == null)
    {
      Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      AppMethodBeat.o(114820);
      return 0;
    }
    this.NJh = true;
    try
    {
      this.aOO.play();
      if ((this.aOO != null) && (this.aOO.getPlayState() != 3))
      {
        this.NJQ = 4;
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
      if ((this.aOO != null) && (this.aOO.getState() == 0))
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        AppMethodBeat.o(114820);
        return 0;
      }
      if (this.NJj)
      {
        if (this.NJu != null) {
          Log.w("MicroMsg.Voip.AudioPlayer", "Task has been created. " + this.NJu);
        }
        for (int i = -1; i != 0; i = 0)
        {
          Log.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          AppMethodBeat.o(114820);
          return 0;
        }
        this.NJu = h.ZvG.a(new a(), 0L, 20L);
      }
      this.mkp = new com.tencent.mm.audio.c.a.a();
      this.Kub = new com.tencent.e.i.b()
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
          label1551:
          while ((c.this.NJh) && (c.this.aOO != null) && (c.this.aOO.getPlayState() != 1) && (!c.this.NJs.get()))
          {
            int i;
            long l;
            try
            {
              i = c.this.aOO.getPlaybackHeadPosition();
              l = System.currentTimeMillis();
              c.d(c.this, c.j(c.this) - i);
              Log.d("MicroMsg.Voip.AudioPlayer", "m_iLefSamples value is %s and iPos value is %s", new Object[] { Integer.valueOf(c.k(c.this)), Integer.valueOf(i) });
              if (c.l(c.this) == 1)
              {
                c.e(c.this, i);
                c.a(c.this, l);
                c.b(c.this, l);
                c.m(c.this);
                c.c(c.this, l);
                if ((i != 0) && (c.this.NJj)) {
                  c.t(c.this);
                }
                if (c.this.NJt == null) {
                  break label1551;
                }
                c.h(c.this, c.u(c.this) + c.this.mkF);
                if (c.a(c.this) != 0) {
                  break label671;
                }
                if ((c.v(c.this) == 0) && (c.w(c.this) != null)) {
                  c.w(c.this).e(c.this.mkF, c.x(c.this));
                }
                i = c.this.NJt.R(c.x(c.this), c.this.mkF);
                if (i >= 0) {
                  break label1072;
                }
                com.tencent.mm.plugin.voip.c.e.als(5);
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
                  label410:
                  c.c(c.this, l);
                  if (c.k(c.this) != 0) {
                    break label565;
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
                  break label410;
                  label565:
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
                label671:
                System.currentTimeMillis();
                if (c.b(c.this) >= c.this.mkF) {
                  Log.i("MicroMsg.Voip.AudioPlayer", "m_iTaskLeftByte value is %s and nFrameLen value is %s", new Object[] { Integer.valueOf(c.b(c.this)), Integer.valueOf(c.this.mkF) });
                }
                synchronized (c.f(c.this))
                {
                  System.arraycopy(c.g(c.this), 0, c.x(c.this), 0, c.this.mkF);
                  i = c.b(c.this) - c.this.mkF;
                  System.arraycopy(c.g(c.this), c.this.mkF, c.y(c.this), 0, i);
                  System.arraycopy(c.y(c.this), 0, c.g(c.this), 0, i);
                  c.b(c.this, c.b(c.this) - c.this.mkF);
                  Log.i("MicroMsg.Voip.AudioPlayer", "audio player has copy playTaskBuffer and left %s", new Object[] { Integer.valueOf(c.b(c.this)) });
                  i = 0;
                }
                c.i(c.this, 1);
                if ((c.v(c.this) == 0) && (c.w(c.this) != null)) {
                  c.w(c.this).e(c.this.mkF, c.x(c.this));
                }
                i = c.this.NJt.R(c.x(c.this), c.this.mkF);
                c.i(c.this, 0);
              }
              Log.i("MicroMsg.Voip.AudioPlayer", "play run too fast !,m_iLefSamples: " + c.k(c.this) + " ,m_iTaskLeftByte: " + c.b(c.this));
              com.tencent.mm.plugin.voip.c.e.als(2);
            }
            continue;
            label1072:
            if (c.B(c.this))
            {
              Log.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.B(c.this));
              com.tencent.mm.plugin.voip.c.e.als(10);
            }
            else
            {
              c.a(c.this, l);
              if (c.C(c.this) >= c.this.mkF)
              {
                if (!c.B(c.this))
                {
                  c.j(c.this, c.D(c.this) + 1);
                  i = c.this.aOO.write(c.x(c.this), 0, c.this.mkF);
                  if (i < 0)
                  {
                    c.k(c.this, i);
                    Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.l(c.this, c.j(c.this) + (c.this.mkF >> 1));
                }
              }
              else
              {
                System.arraycopy(c.x(c.this), 0, c.E(c.this), j, c.C(c.this) - j);
                if (c.this.aOO != null)
                {
                  c.j(c.this, c.D(c.this) + 1);
                  i = c.this.aOO.write(c.E(c.this), 0, c.E(c.this).length);
                  if (i < 0)
                  {
                    c.k(c.this, i);
                    Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.l(c.this, c.j(c.this) + (c.E(c.this).length >> 1));
                  j = c.C(c.this) - j;
                  i = c.this.mkF - j;
                  while ((i >= c.C(c.this)) && (c.this.aOO != null))
                  {
                    c.j(c.this, c.D(c.this) + 1);
                    c.this.aOO.write(c.x(c.this), j, c.C(c.this));
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
                com.tencent.mm.plugin.voip.c.e.als(10);
              }
            }
          }
          if ((c.v(c.this) == 0) && (c.F(c.this) != null) && (c.w(c.this) != null))
          {
            c.w(c.this).b(1, c.F(c.this), c.this.gxF());
            c.w(c.this).kH(1);
            c.w(c.this).kI(1);
            c.w(c.this).kG(1);
          }
          AppMethodBeat.o(114813);
        }
      };
      h.ZvG.bDh("AudioPlayer_play");
      h.ZvG.d(this.Kub, "AudioPlayer_play");
      AppMethodBeat.o(114820);
    }
    return 1;
  }
  
  public final int gxC()
  {
    AppMethodBeat.i(114821);
    if (this.nSamplerate == 0)
    {
      Log.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
      AppMethodBeat.o(114821);
      return 0;
    }
    if (this.aOO == null)
    {
      Log.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.NJD + ",nSamplerate:" + this.nSamplerate);
      i = this.NJD * 1000 / this.nSamplerate;
      AppMethodBeat.o(114821);
      return i;
    }
    if ((this.NJh) && (this.aOO.getState() != 0)) {
      try
      {
        i = this.aOO.getPlaybackHeadPosition();
        i = (this.NJz - i) * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        i = this.NJD * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
    }
    int i = this.NJD * 1000 / this.nSamplerate;
    AppMethodBeat.o(114821);
    return i;
  }
  
  /* Error */
  public final int gxD()
  {
    // Byte code:
    //   0: ldc_w 543
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 138	com/tencent/mm/plugin/voip/model/c:NJu	Lcom/tencent/e/i/d;
    //   10: ifnull +19 -> 29
    //   13: aload_0
    //   14: getfield 138	com/tencent/mm/plugin/voip/model/c:NJu	Lcom/tencent/e/i/d;
    //   17: iconst_0
    //   18: invokeinterface 547 2 0
    //   23: pop
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 138	com/tencent/mm/plugin/voip/model/c:NJu	Lcom/tencent/e/i/d;
    //   29: ldc_w 283
    //   32: ldc_w 549
    //   35: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 95	com/tencent/mm/plugin/voip/model/c:NJh	Z
    //   42: ifne +20 -> 62
    //   45: ldc_w 283
    //   48: ldc_w 551
    //   51: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc_w 543
    //   57: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iconst_1
    //   61: ireturn
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 95	com/tencent/mm/plugin/voip/model/c:NJh	Z
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 182	com/tencent/mm/plugin/voip/model/c:NJO	I
    //   72: aload_0
    //   73: getfield 348	com/tencent/mm/plugin/voip/model/c:Kub	Lcom/tencent/e/i/b;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +10 -> 88
    //   81: aload_0
    //   82: getfield 348	com/tencent/mm/plugin/voip/model/c:Kub	Lcom/tencent/e/i/b;
    //   85: invokevirtual 554	com/tencent/e/i/b:ipZ	()V
    //   88: aload_0
    //   89: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   92: ifnull +56 -> 148
    //   95: aload_0
    //   96: getfield 134	com/tencent/mm/plugin/voip/model/c:NJs	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   99: iconst_0
    //   100: iconst_1
    //   101: invokevirtual 346	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 348	com/tencent/mm/plugin/voip/model/c:Kub	Lcom/tencent/e/i/b;
    //   109: invokevirtual 353	com/tencent/e/i/b:cancel	()Z
    //   112: pop
    //   113: getstatic 359	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   116: ldc_w 361
    //   119: invokeinterface 367 2 0
    //   124: pop
    //   125: aload_0
    //   126: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   129: invokevirtual 370	android/media/AudioTrack:stop	()V
    //   132: aload_0
    //   133: getfield 127	com/tencent/mm/plugin/voip/model/c:aOO	Landroid/media/AudioTrack;
    //   136: invokevirtual 373	android/media/AudioTrack:release	()V
    //   139: ldc_w 283
    //   142: ldc_w 556
    //   145: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: ldc_w 543
    //   151: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: ldc_w 283
    //   160: aload_1
    //   161: ldc_w 558
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 562	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: ldc_w 283
    //   178: aload_1
    //   179: ldc_w 558
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 562	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -101 -> 88
    //   192: astore_1
    //   193: ldc_w 283
    //   196: ldc_w 564
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_1
    //   206: invokevirtual 412	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: aastore
    //   210: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: goto -65 -> 148
    //   216: astore_1
    //   217: goto -42 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	c
    //   76	2	1	localb	com.tencent.e.i.b
    //   156	5	1	localExecutionException	java.util.concurrent.ExecutionException
    //   174	5	1	localCancellationException	java.util.concurrent.CancellationException
    //   192	14	1	localException	Exception
    //   216	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   81	88	156	java/util/concurrent/ExecutionException
    //   72	77	174	java/util/concurrent/CancellationException
    //   81	88	174	java/util/concurrent/CancellationException
    //   157	171	174	java/util/concurrent/CancellationException
    //   88	148	192	java/lang/Exception
    //   72	77	216	java/lang/InterruptedException
    //   81	88	216	java/lang/InterruptedException
    //   157	171	216	java/lang/InterruptedException
  }
  
  public final int gxE()
  {
    AppMethodBeat.i(114823);
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.NJQ);
    int i = this.NJQ;
    AppMethodBeat.o(114823);
    return i;
  }
  
  public final int gxF()
  {
    AppMethodBeat.i(114824);
    if (this.aOO != null)
    {
      i = this.aOO.getStreamType();
      AppMethodBeat.o(114824);
      return i;
    }
    int i = AL(true);
    AppMethodBeat.o(114824);
    return i;
  }
  
  public final int gxz()
  {
    return this.NJO / this.mkF * this.mkB;
  }
  
  public final boolean isPlaying()
  {
    return this.NJh;
  }
  
  public final int jN()
  {
    AppMethodBeat.i(244593);
    AudioManager localAudioManager = (AudioManager)MMApplicationContext.getContext().getSystemService("audio");
    if ((localAudioManager != null) && (this.aOO != null))
    {
      int i = localAudioManager.getStreamVolume(this.aOO.getStreamType());
      AppMethodBeat.o(244593);
      return i;
    }
    AppMethodBeat.o(244593);
    return 0;
  }
  
  final class a
    extends TimerTask
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(114814);
      System.currentTimeMillis();
      if ((c.a(c.this) == 1) && (c.this.NJh == true))
      {
        System.currentTimeMillis();
        if ((c.b(c.this) + c.this.mkF < c.c(c.this)) && (c.d(c.this) == 0) && (c.this.NJt != null))
        {
          c.a(c.this, 1);
          int i = c.this.NJt.R(c.e(c.this), c.this.mkF);
          c.a(c.this, 0);
          if (i < 0)
          {
            Log.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
            AppMethodBeat.o(114814);
            return;
          }
          synchronized (c.f(c.this))
          {
            System.arraycopy(c.e(c.this), 0, c.g(c.this), c.b(c.this), c.this.mkF);
            c.b(c.this, c.b(c.this) + c.this.mkF);
            c.c(c.this, c.h(c.this) + (c.this.mkF >> 1));
            AppMethodBeat.o(114814);
            return;
          }
        }
      }
      AppMethodBeat.o(114814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c
 * JD-Core Version:    0.7.0.1
 */