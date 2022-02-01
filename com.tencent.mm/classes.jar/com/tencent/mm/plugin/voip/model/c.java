package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static float volume = 0.0F;
  private com.tencent.threadpool.i.b QSB;
  public boolean UvL;
  boolean UvM;
  boolean UvN;
  l UvO;
  private int UvP;
  private byte[] UvQ;
  private byte[] UvR;
  private byte[] UvS;
  private byte[] UvT;
  private byte[] UvU;
  public int UvV;
  AtomicBoolean UvW;
  public b UvX;
  private d<?> UvY;
  private int UvZ;
  private int Uwa;
  private int Uwb;
  String Uwc;
  private int Uwd;
  private int Uwe;
  private int Uwf;
  private int Uwg;
  private int Uwh;
  private int Uwi;
  private int Uwj;
  private long Uwk;
  private long Uwl;
  private int Uwm;
  private int Uwn;
  private int Uwo;
  private int Uwp;
  private long Uwq;
  private int Uwr;
  private int Uws;
  private final Object Uwt;
  private int Uwu;
  int Uwv;
  private int Uww;
  private int Uwx;
  private int Uwy;
  AudioTrack cIK;
  Context context;
  private int lRw;
  private int nSamplerate;
  private com.tencent.mm.audio.c.a.a pdT;
  int pel;
  private int pem;
  int pep;
  int peq;
  private boolean per;
  private int uzq;
  
  public c()
  {
    AppMethodBeat.i(114815);
    this.UvL = false;
    this.UvM = false;
    this.UvN = true;
    this.UvO = null;
    this.pel = 2;
    this.pep = 0;
    this.UvP = 0;
    this.UvQ = null;
    this.UvR = null;
    this.UvS = null;
    this.UvT = null;
    this.UvU = null;
    this.nSamplerate = 0;
    this.UvV = 0;
    this.pem = 0;
    this.peq = 20;
    this.cIK = null;
    this.UvW = new AtomicBoolean(false);
    this.UvX = null;
    this.UvY = null;
    this.UvZ = 1;
    this.Uwa = 1;
    this.Uwb = 0;
    this.Uwc = null;
    this.lRw = 3;
    this.per = false;
    this.Uwd = 0;
    this.Uwe = 0;
    this.Uwf = 0;
    this.Uwg = 0;
    this.Uwh = 0;
    this.Uwi = 1;
    this.Uwj = 0;
    this.Uwk = 0L;
    this.Uwl = 0L;
    this.Uwm = 1;
    this.Uwn = 0;
    this.Uwo = -1;
    this.Uwp = 0;
    this.Uwq = 0L;
    this.Uwr = 1;
    this.Uws = 0;
    this.Uwt = new Object();
    this.Uwu = 0;
    this.Uwv = 0;
    this.Uww = 0;
    this.uzq = 0;
    this.Uwx = 0;
    this.Uwy = 0;
    AppMethodBeat.o(114815);
  }
  
  private int Gk(boolean paramBoolean)
  {
    AppMethodBeat.i(114818);
    int j = 0;
    int i;
    if (af.lXZ.lQT > 0)
    {
      j = com.tencent.mm.plugin.audio.c.a.lS(paramBoolean);
      if ((!paramBoolean) || (af.lXZ.lRz < 0)) {
        break label113;
      }
      i = af.lXZ.lRz;
      label41:
      j = i;
      if (1 == this.uzq)
      {
        if (af.lXZ.lSo >= 0) {
          i = af.lXZ.lSo;
        }
        if ((!paramBoolean) || (af.lXZ.lSp < 0)) {
          break label140;
        }
        j = af.lXZ.lSp;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114818);
      return j;
      if (af.lXZ.lRy < 0) {
        break;
      }
      j = af.lXZ.lRy;
      break;
      label113:
      i = j;
      if (paramBoolean) {
        break label41;
      }
      i = j;
      if (af.lXZ.lRA < 0) {
        break label41;
      }
      i = af.lXZ.lRA;
      break label41;
      label140:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (af.lXZ.lSq >= 0) {
          j = af.lXZ.lSq;
        }
      }
    }
  }
  
  public final boolean Gj(boolean paramBoolean)
  {
    AppMethodBeat.i(114817);
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = Gk(paramBoolean);
    if (com.tencent.mm.plugin.audio.c.a.cTX()) {
      i = 0;
    }
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.cIK != null) && (i == this.cIK.getStreamType()))
    {
      Log.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      AppMethodBeat.o(114817);
      return false;
    }
    hVF();
    this.per = true;
    if (this.UvV == 2) {}
    for (this.pel = 3;; this.pel = 2)
    {
      this.pep = AudioTrack.getMinBufferSize(this.nSamplerate, this.pel, 2);
      if ((this.pep != -2) && (this.pep != -1)) {
        break;
      }
      this.per = false;
      AppMethodBeat.o(114817);
      return false;
    }
    this.Uwd = 0;
    this.Uwg = 0;
    this.Uwi = 1;
    this.Uwj = 0;
    this.Uwk = 0L;
    this.Uwl = 0L;
    this.Uwm = 1;
    this.Uwo = -1;
    this.Uwp = 0;
    this.Uwh = this.pep;
    this.Uwn = (this.Uwh * this.Uwm);
    this.pep *= this.Uwr;
    float f = this.Uwh / 16.0F;
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.pep + "  MinBufSizeInMs:" + f);
    if (this.cIK != null) {}
    try
    {
      this.UvW.compareAndSet(false, true);
      this.QSB.cancel();
      h.ahAA.bFQ("AudioPlayer_play");
      this.cIK.stop();
      this.cIK.release();
      this.cIK = null;
      Log.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTU()), Integer.valueOf(i), Integer.valueOf(this.pep), Integer.valueOf(this.nSamplerate) });
      this.cIK = new e(i, this.nSamplerate, this.pel, this.pep);
      if ((this.cIK != null) && (this.cIK.getState() == 0))
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.UvW.compareAndSet(false, true);
        this.cIK.release();
        this.cIK = null;
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
      if (this.cIK != null)
      {
        this.per = false;
        hVD();
        AppMethodBeat.o(114817);
        return true;
      }
      this.per = false;
      AppMethodBeat.o(114817);
    }
    return false;
  }
  
  public final int It()
  {
    AppMethodBeat.i(293346);
    AudioManager localAudioManager = (AudioManager)MMApplicationContext.getContext().getSystemService("audio");
    if ((localAudioManager != null) && (this.cIK != null))
    {
      int i = localAudioManager.getStreamVolume(this.cIK.getStreamType());
      AppMethodBeat.o(293346);
      return i;
    }
    AppMethodBeat.o(293346);
    return 0;
  }
  
  /* Error */
  public final int R(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 443
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 282
    //   9: ldc_w 445
    //   12: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 447	com/tencent/mm/plugin/voip/model/c:context	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 121	com/tencent/mm/plugin/voip/model/c:UvV	I
    //   24: iconst_2
    //   25: if_icmpne +54 -> 79
    //   28: aload_0
    //   29: iconst_3
    //   30: putfield 103	com/tencent/mm/plugin/voip/model/c:pel	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   38: aload_0
    //   39: getfield 103	com/tencent/mm/plugin/voip/model/c:pel	I
    //   42: iconst_2
    //   43: invokestatic 333	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: putfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   49: aload_0
    //   50: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   53: bipush 254
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   62: iconst_m1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 186	com/tencent/mm/plugin/voip/model/c:Uwu	I
    //   71: ldc_w 443
    //   74: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_0
    //   80: iconst_2
    //   81: putfield 103	com/tencent/mm/plugin/voip/model/c:pel	I
    //   84: goto -51 -> 33
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   92: putfield 160	com/tencent/mm/plugin/voip/model/c:Uwh	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 160	com/tencent/mm/plugin/voip/model/c:Uwh	I
    //   100: aload_0
    //   101: getfield 170	com/tencent/mm/plugin/voip/model/c:Uwm	I
    //   104: imul
    //   105: putfield 172	com/tencent/mm/plugin/voip/model/c:Uwn	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   113: aload_0
    //   114: getfield 180	com/tencent/mm/plugin/voip/model/c:Uwr	I
    //   117: imul
    //   118: putfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   121: aload_0
    //   122: getfield 160	com/tencent/mm/plugin/voip/model/c:Uwh	I
    //   125: iconst_1
    //   126: ishr
    //   127: i2f
    //   128: aload_0
    //   129: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   132: i2f
    //   133: fdiv
    //   134: fstore_3
    //   135: invokestatic 452	com/tencent/mm/compatible/deviceinfo/m:aOK	()I
    //   138: istore 4
    //   140: getstatic 215	com/tencent/mm/compatible/deviceinfo/af:lXZ	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   143: getfield 455	com/tencent/mm/compatible/deviceinfo/b:lSe	I
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
    //   169: ldc_w 282
    //   172: ldc_w 457
    //   175: iload 4
    //   177: invokestatic 462	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   180: invokevirtual 466	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 468	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 469
    //   189: fload_3
    //   190: fmul
    //   191: ldc_w 470
    //   194: fcmpg
    //   195: iflt +10 -> 205
    //   198: aload_0
    //   199: getfield 192	com/tencent/mm/plugin/voip/model/c:uzq	I
    //   202: ifeq +6 -> 208
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +263 -> 473
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: iload 6
    //   219: putfield 99	com/tencent/mm/plugin/voip/model/c:UvN	Z
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 99	com/tencent/mm/plugin/voip/model/c:UvN	Z
    //   227: ldc_w 282
    //   230: new 297	java/lang/StringBuilder
    //   233: dup
    //   234: ldc_w 472
    //   237: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   244: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 338
    //   250: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: fload_3
    //   254: invokevirtual 341	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   257: ldc_w 474
    //   260: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 99	com/tencent/mm/plugin/voip/model/c:UvN	Z
    //   267: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 468	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: iload_2
    //   278: invokespecial 291	com/tencent/mm/plugin/voip/model/c:Gk	(Z)I
    //   281: istore 4
    //   283: aload_0
    //   284: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +20 -> 309
    //   292: aload_0
    //   293: getfield 134	com/tencent/mm/plugin/voip/model/c:UvW	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: iconst_0
    //   297: iconst_1
    //   298: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   301: pop
    //   302: aload_0
    //   303: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   306: invokevirtual 372	android/media/AudioTrack:release	()V
    //   309: aload_0
    //   310: new 396	com/tencent/mm/compatible/b/e
    //   313: dup
    //   314: iload 4
    //   316: aload_0
    //   317: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   320: aload_0
    //   321: getfield 103	com/tencent/mm/plugin/voip/model/c:pel	I
    //   324: aload_0
    //   325: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   328: invokespecial 399	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   331: putfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   334: aload_0
    //   335: getfield 134	com/tencent/mm/plugin/voip/model/c:UvW	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: iconst_0
    //   340: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: pop
    //   344: aload_0
    //   345: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   348: ifnull +13 -> 361
    //   351: aload_0
    //   352: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   355: invokevirtual 402	android/media/AudioTrack:getState	()I
    //   358: ifne +80 -> 438
    //   361: aload_0
    //   362: iconst_2
    //   363: putfield 186	com/tencent/mm/plugin/voip/model/c:Uwu	I
    //   366: ldc_w 282
    //   369: ldc_w 476
    //   372: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   379: ifnull +20 -> 399
    //   382: aload_0
    //   383: getfield 134	com/tencent/mm/plugin/voip/model/c:UvW	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   386: iconst_0
    //   387: iconst_1
    //   388: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   396: invokevirtual 372	android/media/AudioTrack:release	()V
    //   399: iload 4
    //   401: ifne +105 -> 506
    //   404: aload_0
    //   405: new 396	com/tencent/mm/compatible/b/e
    //   408: dup
    //   409: iconst_3
    //   410: aload_0
    //   411: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   414: aload_0
    //   415: getfield 103	com/tencent/mm/plugin/voip/model/c:pel	I
    //   418: aload_0
    //   419: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   422: invokespecial 399	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   425: putfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   428: aload_0
    //   429: getfield 134	com/tencent/mm/plugin/voip/model/c:UvW	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_1
    //   433: iconst_0
    //   434: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   442: ifnonnull +91 -> 533
    //   445: aload_0
    //   446: iconst_3
    //   447: putfield 186	com/tencent/mm/plugin/voip/model/c:Uwu	I
    //   450: ldc_w 282
    //   453: ldc_w 478
    //   456: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: ldc_w 443
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
    //   480: ldc_w 282
    //   483: ldc_w 480
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload_1
    //   493: aastore
    //   494: invokestatic 482	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: aload_0
    //   498: bipush 6
    //   500: putfield 186	com/tencent/mm/plugin/voip/model/c:Uwu	I
    //   503: goto -159 -> 344
    //   506: aload_0
    //   507: new 396	com/tencent/mm/compatible/b/e
    //   510: dup
    //   511: iconst_0
    //   512: aload_0
    //   513: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   516: aload_0
    //   517: getfield 103	com/tencent/mm/plugin/voip/model/c:pel	I
    //   520: aload_0
    //   521: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   524: invokespecial 399	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   527: putfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   530: goto -102 -> 428
    //   533: aload_0
    //   534: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   537: invokevirtual 402	android/media/AudioTrack:getState	()I
    //   540: ifne +47 -> 587
    //   543: aload_0
    //   544: iconst_3
    //   545: putfield 186	com/tencent/mm/plugin/voip/model/c:Uwu	I
    //   548: ldc_w 282
    //   551: ldc_w 484
    //   554: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 134	com/tencent/mm/plugin/voip/model/c:UvW	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   561: iconst_0
    //   562: iconst_1
    //   563: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   566: pop
    //   567: aload_0
    //   568: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   571: invokevirtual 372	android/media/AudioTrack:release	()V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   579: ldc_w 443
    //   582: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: iconst_m1
    //   586: ireturn
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   592: newarray byte
    //   594: putfield 109	com/tencent/mm/plugin/voip/model/c:UvQ	[B
    //   597: aload_0
    //   598: getfield 109	com/tencent/mm/plugin/voip/model/c:UvQ	[B
    //   601: ifnonnull +20 -> 621
    //   604: ldc_w 282
    //   607: ldc_w 486
    //   610: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc_w 443
    //   616: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: iconst_m1
    //   620: ireturn
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 125	com/tencent/mm/plugin/voip/model/c:peq	I
    //   626: newarray byte
    //   628: putfield 115	com/tencent/mm/plugin/voip/model/c:UvT	[B
    //   631: aload_0
    //   632: getfield 115	com/tencent/mm/plugin/voip/model/c:UvT	[B
    //   635: ifnonnull +20 -> 655
    //   638: ldc_w 282
    //   641: ldc_w 488
    //   644: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: ldc_w 443
    //   650: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: iconst_m1
    //   654: ireturn
    //   655: aload_0
    //   656: getfield 99	com/tencent/mm/plugin/voip/model/c:UvN	Z
    //   659: ifeq +113 -> 772
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   667: putfield 107	com/tencent/mm/plugin/voip/model/c:UvP	I
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 107	com/tencent/mm/plugin/voip/model/c:UvP	I
    //   675: newarray byte
    //   677: putfield 111	com/tencent/mm/plugin/voip/model/c:UvR	[B
    //   680: aload_0
    //   681: getfield 111	com/tencent/mm/plugin/voip/model/c:UvR	[B
    //   684: ifnonnull +20 -> 704
    //   687: ldc_w 282
    //   690: ldc_w 490
    //   693: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: ldc_w 443
    //   699: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: iconst_m1
    //   703: ireturn
    //   704: aload_0
    //   705: aload_0
    //   706: getfield 107	com/tencent/mm/plugin/voip/model/c:UvP	I
    //   709: newarray byte
    //   711: putfield 113	com/tencent/mm/plugin/voip/model/c:UvS	[B
    //   714: aload_0
    //   715: getfield 113	com/tencent/mm/plugin/voip/model/c:UvS	[B
    //   718: ifnonnull +20 -> 738
    //   721: ldc_w 282
    //   724: ldc_w 492
    //   727: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: ldc_w 443
    //   733: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: iconst_m1
    //   737: ireturn
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 125	com/tencent/mm/plugin/voip/model/c:peq	I
    //   743: newarray byte
    //   745: putfield 117	com/tencent/mm/plugin/voip/model/c:UvU	[B
    //   748: aload_0
    //   749: getfield 117	com/tencent/mm/plugin/voip/model/c:UvU	[B
    //   752: ifnonnull +20 -> 772
    //   755: ldc_w 282
    //   758: ldc_w 494
    //   761: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: ldc_w 443
    //   767: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_m1
    //   771: ireturn
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield 95	com/tencent/mm/plugin/voip/model/c:UvL	Z
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 97	com/tencent/mm/plugin/voip/model/c:UvM	Z
    //   782: ldc_w 282
    //   785: ldc_w 496
    //   788: iconst_5
    //   789: anewarray 4	java/lang/Object
    //   792: dup
    //   793: iconst_0
    //   794: invokestatic 377	com/tencent/mm/plugin/audio/c/a:getMode	()I
    //   797: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: dup
    //   802: iconst_1
    //   803: invokestatic 386	com/tencent/mm/plugin/audio/c/a:cTU	()Z
    //   806: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   809: aastore
    //   810: dup
    //   811: iconst_2
    //   812: iload 4
    //   814: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: dup
    //   819: iconst_3
    //   820: aload_0
    //   821: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   824: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: aastore
    //   828: dup
    //   829: iconst_4
    //   830: aload_0
    //   831: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   834: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: aload_0
    //   842: getfield 105	com/tencent/mm/plugin/voip/model/c:pep	I
    //   845: sipush 1000
    //   848: imul
    //   849: aload_0
    //   850: getfield 119	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   853: iconst_2
    //   854: imul
    //   855: idiv
    //   856: istore 4
    //   858: ldc_w 443
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
  
  public final int ac(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (true == this.UvL) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.UvV = paramInt2;
    this.pem = paramInt3;
    this.uzq = paramInt4;
    this.peq = (this.nSamplerate / 1000 * paramInt2 * this.pem * 2);
    this.Uwp = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  public final int gdZ()
  {
    AppMethodBeat.i(114824);
    if (this.cIK != null)
    {
      i = this.cIK.getStreamType();
      AppMethodBeat.o(114824);
      return i;
    }
    int i = Gk(true);
    AppMethodBeat.o(114824);
    return i;
  }
  
  public final int hVB()
  {
    return this.Uws / this.peq * this.pem;
  }
  
  public final int hVC()
  {
    AppMethodBeat.i(114819);
    Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit");
    if (this.cIK != null)
    {
      this.UvW.compareAndSet(false, true);
      this.cIK.release();
      this.cIK = null;
    }
    for (;;)
    {
      this.UvL = false;
      this.UvM = false;
      AppMethodBeat.o(114819);
      return 1;
      Log.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit failed cause audio track is null");
    }
  }
  
  public final int hVD()
  {
    AppMethodBeat.i(114820);
    if (true == this.UvL)
    {
      AppMethodBeat.o(114820);
      return 1;
    }
    if (this.cIK == null)
    {
      Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      AppMethodBeat.o(114820);
      return 0;
    }
    this.UvL = true;
    try
    {
      this.cIK.play();
      if ((this.cIK != null) && (this.cIK.getPlayState() != 3))
      {
        this.Uwu = 4;
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
      if ((this.cIK != null) && (this.cIK.getState() == 0))
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        AppMethodBeat.o(114820);
        return 0;
      }
      if (this.UvN)
      {
        if (this.UvY != null) {
          Log.w("MicroMsg.Voip.AudioPlayer", "Task has been created. " + this.UvY);
        }
        for (int i = -1; i != 0; i = 0)
        {
          Log.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          AppMethodBeat.o(114820);
          return 0;
        }
        this.UvY = h.ahAA.a(new a(), 0L, 20L);
      }
      this.pdT = new com.tencent.mm.audio.c.a.a();
      this.QSB = new com.tencent.threadpool.i.b()
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
          while ((c.this.UvL) && (c.this.cIK != null) && (c.this.cIK.getPlayState() != 1) && (!c.this.UvW.get()))
          {
            int i;
            long l;
            try
            {
              i = c.this.cIK.getPlaybackHeadPosition();
              l = System.currentTimeMillis();
              c.d(c.this, c.i(c.this) - i);
              Log.d("MicroMsg.Voip.AudioPlayer", "m_iLefSamples value is %s and iPos value is %s", new Object[] { Integer.valueOf(c.j(c.this)), Integer.valueOf(i) });
              if (c.k(c.this) == 1)
              {
                c.e(c.this, i);
                c.a(c.this, l);
                c.b(c.this, l);
                c.l(c.this);
                c.c(c.this, l);
                if ((i != 0) && (c.this.UvN)) {
                  c.s(c.this);
                }
                if (c.this.UvX == null) {
                  break label1495;
                }
                c.j(c.this, c.this.peq);
                if (c.a(c.this) != 0) {
                  break label647;
                }
                if ((c.t(c.this) == 0) && (c.u(c.this) != null)) {
                  c.u(c.this).e(c.this.peq, c.v(c.this));
                }
                i = c.this.UvX.PlayDevDataCallBack(c.v(c.this), c.this.peq);
                if (i >= 0) {
                  break label1040;
                }
                g.ara(5);
                Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[] { localException });
                c.h(c.this);
                i = 0;
                continue;
                int k = i - c.m(c.this);
                if (k > c.n(c.this))
                {
                  c.f(c.this, k);
                  label402:
                  c.c(c.this, l);
                  if (c.j(c.this) != 0) {
                    break label549;
                  }
                  c.g(c.this, c.o(c.this));
                }
                for (;;)
                {
                  if (c.q(c.this) < c.r(c.this)) {
                    c.i(c.this, c.r(c.this));
                  }
                  if (c.q(c.this) < c.o(c.this)) {
                    c.i(c.this, c.o(c.this));
                  }
                  if (k <= 0) {
                    break;
                  }
                  c.e(c.this, i);
                  break;
                  c.f(c.this, (int)(c.n(c.this) * 49999.0F / 50000.0F + k / 50000.0F));
                  break label402;
                  label549:
                  if (l > c.p(c.this) + 5000L)
                  {
                    c.b(c.this, l);
                    if (c.n(c.this) < c.q(c.this) >> 1) {
                      c.h(c.this, c.o(c.this) >> 2);
                    }
                    if (c.n(c.this) > c.q(c.this)) {
                      c.i(c.this, c.n(c.this));
                    }
                  }
                }
                label647:
                System.currentTimeMillis();
                if (c.b(c.this) >= c.this.peq) {
                  Log.i("MicroMsg.Voip.AudioPlayer", "m_iTaskLeftByte value is %s and nFrameLen value is %s", new Object[] { Integer.valueOf(c.b(c.this)), Integer.valueOf(c.this.peq) });
                }
                synchronized (c.f(c.this))
                {
                  System.arraycopy(c.g(c.this), 0, c.v(c.this), 0, c.this.peq);
                  i = c.b(c.this) - c.this.peq;
                  System.arraycopy(c.g(c.this), c.this.peq, c.w(c.this), 0, i);
                  System.arraycopy(c.w(c.this), 0, c.g(c.this), 0, i);
                  c.k(c.this, c.this.peq);
                  Log.i("MicroMsg.Voip.AudioPlayer", "audio player has copy playTaskBuffer and left %s", new Object[] { Integer.valueOf(c.b(c.this)) });
                  i = 0;
                }
                c.l(c.this, 1);
                if ((c.t(c.this) == 0) && (c.u(c.this) != null)) {
                  c.u(c.this).e(c.this.peq, c.v(c.this));
                }
                i = c.this.UvX.PlayDevDataCallBack(c.v(c.this), c.this.peq);
                c.l(c.this, 0);
              }
              Log.i("MicroMsg.Voip.AudioPlayer", "play run too fast !,m_iLefSamples: " + c.j(c.this) + " ,m_iTaskLeftByte: " + c.b(c.this));
              g.ara(2);
            }
            continue;
            label1040:
            if (c.z(c.this))
            {
              Log.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.z(c.this));
              g.ara(10);
            }
            else
            {
              c.a(c.this, l);
              if (c.A(c.this) >= c.this.peq)
              {
                if (!c.z(c.this))
                {
                  c.m(c.this, c.B(c.this) + 1);
                  i = c.this.cIK.write(c.v(c.this), 0, c.this.peq);
                  if (i < 0)
                  {
                    c.n(c.this, i);
                    Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.o(c.this, c.this.peq >> 1);
                }
              }
              else
              {
                System.arraycopy(c.v(c.this), 0, c.C(c.this), j, c.A(c.this) - j);
                if (c.this.cIK != null)
                {
                  c.m(c.this, c.B(c.this) + 1);
                  i = c.this.cIK.write(c.C(c.this), 0, c.C(c.this).length);
                  if (i < 0)
                  {
                    c.n(c.this, i);
                    Log.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.o(c.this, c.C(c.this).length >> 1);
                  j = c.A(c.this) - j;
                  i = c.this.peq - j;
                  while ((i >= c.A(c.this)) && (c.this.cIK != null))
                  {
                    c.m(c.this, c.B(c.this) + 1);
                    c.this.cIK.write(c.v(c.this), j, c.A(c.this));
                    j += c.A(c.this);
                    i -= c.A(c.this);
                    c.o(c.this, c.A(c.this) >> 1);
                  }
                }
                AppMethodBeat.o(114813);
                return;
                System.arraycopy(c.v(c.this), j, c.C(c.this), 0, i);
                j = i;
                continue;
                label1495:
                g.ara(10);
              }
            }
          }
          if ((c.t(c.this) == 0) && (c.D(c.this) != null) && (c.u(c.this) != null))
          {
            c.u(c.this).b(1, c.D(c.this), c.this.gdZ());
            c.u(c.this).oo(1);
            c.u(c.this).op(1);
            c.u(c.this).on(1);
          }
          AppMethodBeat.o(114813);
        }
      };
      h.ahAA.bFQ("AudioPlayer_play");
      h.ahAA.g(this.QSB, "AudioPlayer_play");
      AppMethodBeat.o(114820);
    }
    return 1;
  }
  
  public final int hVE()
  {
    AppMethodBeat.i(114821);
    if (this.nSamplerate == 0)
    {
      Log.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
      AppMethodBeat.o(114821);
      return 0;
    }
    if (this.cIK == null)
    {
      Log.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.Uwh + ",nSamplerate:" + this.nSamplerate);
      i = this.Uwh * 1000 / this.nSamplerate;
      AppMethodBeat.o(114821);
      return i;
    }
    if ((this.UvL) && (this.cIK.getState() != 0)) {
      try
      {
        i = this.cIK.getPlaybackHeadPosition();
        i = (this.Uwd - i) * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        i = this.Uwh * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
    }
    int i = this.Uwh * 1000 / this.nSamplerate;
    AppMethodBeat.o(114821);
    return i;
  }
  
  /* Error */
  public final int hVF()
  {
    // Byte code:
    //   0: ldc_w 566
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 138	com/tencent/mm/plugin/voip/model/c:UvY	Lcom/tencent/threadpool/i/d;
    //   10: ifnull +19 -> 29
    //   13: aload_0
    //   14: getfield 138	com/tencent/mm/plugin/voip/model/c:UvY	Lcom/tencent/threadpool/i/d;
    //   17: iconst_0
    //   18: invokeinterface 570 2 0
    //   23: pop
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 138	com/tencent/mm/plugin/voip/model/c:UvY	Lcom/tencent/threadpool/i/d;
    //   29: ldc_w 282
    //   32: ldc_w 572
    //   35: invokestatic 468	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 95	com/tencent/mm/plugin/voip/model/c:UvL	Z
    //   42: ifne +20 -> 62
    //   45: ldc_w 282
    //   48: ldc_w 574
    //   51: invokestatic 468	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc_w 566
    //   57: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iconst_1
    //   61: ireturn
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 95	com/tencent/mm/plugin/voip/model/c:UvL	Z
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 182	com/tencent/mm/plugin/voip/model/c:Uws	I
    //   72: aload_0
    //   73: getfield 347	com/tencent/mm/plugin/voip/model/c:QSB	Lcom/tencent/threadpool/i/b;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +10 -> 88
    //   81: aload_0
    //   82: getfield 347	com/tencent/mm/plugin/voip/model/c:QSB	Lcom/tencent/threadpool/i/b;
    //   85: invokevirtual 577	com/tencent/threadpool/i/b:jZu	()V
    //   88: aload_0
    //   89: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   92: ifnull +56 -> 148
    //   95: aload_0
    //   96: getfield 134	com/tencent/mm/plugin/voip/model/c:UvW	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   99: iconst_0
    //   100: iconst_1
    //   101: invokevirtual 345	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 347	com/tencent/mm/plugin/voip/model/c:QSB	Lcom/tencent/threadpool/i/b;
    //   109: invokevirtual 352	com/tencent/threadpool/i/b:cancel	()Z
    //   112: pop
    //   113: getstatic 358	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   116: ldc_w 360
    //   119: invokeinterface 366 2 0
    //   124: pop
    //   125: aload_0
    //   126: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   129: invokevirtual 369	android/media/AudioTrack:stop	()V
    //   132: aload_0
    //   133: getfield 127	com/tencent/mm/plugin/voip/model/c:cIK	Landroid/media/AudioTrack;
    //   136: invokevirtual 372	android/media/AudioTrack:release	()V
    //   139: ldc_w 282
    //   142: ldc_w 579
    //   145: invokestatic 468	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: ldc_w 566
    //   151: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: ldc_w 282
    //   160: aload_1
    //   161: ldc_w 581
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 585	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: ldc_w 282
    //   178: aload_1
    //   179: ldc_w 581
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 585	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -101 -> 88
    //   192: astore_1
    //   193: ldc_w 282
    //   196: ldc_w 587
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_1
    //   206: invokevirtual 411	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: aastore
    //   210: invokestatic 413	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: goto -65 -> 148
    //   216: astore_1
    //   217: goto -42 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	c
    //   76	2	1	localb	com.tencent.threadpool.i.b
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
  
  public final int hVG()
  {
    AppMethodBeat.i(114823);
    Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.Uwu);
    int i = this.Uwu;
    AppMethodBeat.o(114823);
    return i;
  }
  
  final class a
    extends TimerTask
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(114814);
      System.currentTimeMillis();
      if ((c.a(c.this) == 1) && (c.this.UvL == true))
      {
        System.currentTimeMillis();
        if ((c.b(c.this) + c.this.peq < c.c(c.this)) && (c.d(c.this) == 0) && (c.this.UvX != null))
        {
          c.a(c.this, 1);
          int i = c.this.UvX.PlayDevDataCallBack(c.e(c.this), c.this.peq);
          c.a(c.this, 0);
          if (i < 0)
          {
            Log.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
            AppMethodBeat.o(114814);
            return;
          }
          synchronized (c.f(c.this))
          {
            System.arraycopy(c.e(c.this), 0, c.g(c.this), c.b(c.this), c.this.peq);
            c.b(c.this, c.this.peq);
            c.c(c.this, c.this.peq >> 1);
            AppMethodBeat.o(114814);
            return;
          }
        }
      }
      AppMethodBeat.o(114814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c
 * JD-Core Version:    0.7.0.1
 */