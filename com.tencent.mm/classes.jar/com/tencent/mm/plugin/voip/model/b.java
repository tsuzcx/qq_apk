package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Timer;
import java.util.TimerTask;

public final class b
{
  private static float awZ = 0.0F;
  public AudioTrack awx = null;
  private Timer bDk = null;
  private boolean bDl = false;
  Context context;
  private int dvn = 3;
  int eKB = 2;
  private int eKC = 0;
  private Runnable eKD;
  private int eKF = 0;
  int eKG = 20;
  private boolean eKH = false;
  private int hpD = 0;
  private int nSamplerate = 0;
  private int pNA = 1;
  private int pNB = 0;
  private int pNC = 0;
  private int pND = 0;
  private int pNE = 0;
  private int pNF = 0;
  private int pNG = 0;
  private int pNH = 1;
  private int pNI = 0;
  private long pNJ = 0L;
  private long pNK = 0L;
  private int pNL = 1;
  private int pNM = 0;
  private int pNN = -1;
  private int pNO = 0;
  private long pNP = 0L;
  private int pNQ = 1;
  private int pNR = 0;
  private final Object pNS = new Object();
  private int pNT = 0;
  private int pNU = 0;
  private int pNV = 0;
  private int pNW = 0;
  public boolean pNn = false;
  boolean pNo = false;
  boolean pNp = true;
  j pNq = null;
  private int pNr = 0;
  private byte[] pNs = null;
  private byte[] pNt = null;
  private byte[] pNu = null;
  private byte[] pNv = null;
  private byte[] pNw = null;
  private int pNx = 0;
  public a pNy = null;
  private int pNz = 1;
  
  private int jR(boolean paramBoolean)
  {
    int j = 0;
    int i;
    if (q.dye.duO > 0)
    {
      j = f.yi().bm(paramBoolean);
      if ((!paramBoolean) || (q.dye.dvq < 0)) {
        break label106;
      }
      i = q.dye.dvq;
      label39:
      j = i;
      if (1 == this.hpD)
      {
        if (q.dye.dvQ >= 0) {
          i = q.dye.dvQ;
        }
        if ((!paramBoolean) || (q.dye.dvR < 0)) {
          break label133;
        }
        j = q.dye.dvR;
      }
    }
    label106:
    do
    {
      do
      {
        return j;
        if (q.dye.dvp < 0) {
          break;
        }
        j = q.dye.dvp;
        break;
        i = j;
        if (paramBoolean) {
          break label39;
        }
        i = j;
        if (q.dye.dvr < 0) {
          break label39;
        }
        i = q.dye.dvr;
        break label39;
        j = i;
      } while (paramBoolean);
      j = i;
    } while (q.dye.dvS < 0);
    label133:
    return q.dye.dvS;
  }
  
  public final int bPB()
  {
    return this.pNR / this.eKG * this.eKC;
  }
  
  public final int bPC()
  {
    if (this.awx != null)
    {
      this.awx.release();
      this.awx = null;
    }
    this.pNn = false;
    this.pNo = false;
    return 1;
  }
  
  public final int bPD()
  {
    if (true == this.pNn) {
      return 1;
    }
    if (this.awx == null)
    {
      y.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      return 0;
    }
    this.pNn = true;
    try
    {
      this.awx.play();
      if (this.awx.getPlayState() != 3)
      {
        this.pNT = 4;
        y.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[] { localException.getMessage() });
      }
      if (this.awx.getState() == 0)
      {
        y.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        return 0;
      }
      if (this.pNp)
      {
        int i;
        if ((this.bDl) || (this.bDk != null))
        {
          y.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.bDl);
          i = -1;
        }
        while (i != 0)
        {
          y.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          return 0;
          this.bDk = new Timer();
          if (this.bDk == null) {
            i = -1;
          } else {
            i = 0;
          }
        }
        this.bDk.scheduleAtFixedRate(new a(), 0L, 20L);
        this.bDl = true;
      }
      this.eKD = new b.1(this);
      e.a(this.eKD, "AudioPlayer_play", 10);
    }
    return 1;
  }
  
  public final int bPE()
  {
    if (this.awx == null)
    {
      y.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.pNG + ",nSamplerate:" + this.nSamplerate);
      return this.pNG * 1000 / this.nSamplerate;
    }
    if ((this.pNn) && (this.awx.getState() != 0)) {
      try
      {
        int i = this.awx.getPlaybackHeadPosition();
        i = (this.pNC - i) * 1000 / this.nSamplerate;
        return i;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        return this.pNG * 1000 / this.nSamplerate;
      }
    }
    return this.pNG * 1000 / this.nSamplerate;
  }
  
  public final int bPF()
  {
    if ((this.bDl) && (this.bDk != null))
    {
      this.bDk.cancel();
      this.bDl = false;
    }
    if (!this.pNn) {}
    for (;;)
    {
      return 1;
      this.pNn = false;
      this.pNR = 0;
      try
      {
        if (this.eKD != null) {
          e.aa(this.eKD);
        }
        try
        {
          if (this.awx == null) {
            continue;
          }
          this.awx.stop();
          this.awx.release();
          y.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
          return 1;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", new Object[] { localException.getMessage() });
          return 1;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Voip.AudioPlayer", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final int bPG()
  {
    y.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.pNT);
    return this.pNT;
  }
  
  public final int bPH()
  {
    if (this.awx != null) {
      return this.awx.getStreamType();
    }
    return jR(true);
  }
  
  public final boolean jQ(boolean paramBoolean)
  {
    y.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = jR(paramBoolean);
    if (f.yi().yn()) {
      i = 0;
    }
    y.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.awx != null) && (i == this.awx.getStreamType()))
    {
      y.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      return false;
    }
    bPF();
    this.eKH = true;
    if (this.pNx == 2) {}
    for (this.eKB = 3;; this.eKB = 2)
    {
      this.eKF = AudioTrack.getMinBufferSize(this.nSamplerate, this.eKB, 2);
      if ((this.eKF != -2) && (this.eKF != -1)) {
        break;
      }
      this.eKH = false;
      return false;
    }
    this.pNC = 0;
    this.pNF = 0;
    this.pNH = 1;
    this.pNI = 0;
    this.pNJ = 0L;
    this.pNK = 0L;
    this.pNL = 1;
    this.pNN = -1;
    this.pNO = 0;
    this.pNG = this.eKF;
    this.pNM = (this.pNG * this.pNL);
    this.eKF *= this.pNQ;
    float f = this.pNG / 16.0F;
    y.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.eKF + "  MinBufSizeInMs:" + f);
    if (this.awx != null) {}
    try
    {
      this.awx.stop();
      this.awx.release();
      this.awx = null;
      y.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(f.yi().dui.getMode()), Boolean.valueOf(f.yi().dui.isSpeakerphoneOn()), Integer.valueOf(i), Integer.valueOf(this.eKF), Integer.valueOf(this.nSamplerate) });
      this.awx = new d(i, this.nSamplerate, this.eKB, this.eKF);
      if ((this.awx != null) && (this.awx.getState() == 0))
      {
        y.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.awx.release();
        this.awx = null;
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[] { localException.getMessage() });
      }
      y.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
      if (this.awx != null)
      {
        this.eKH = false;
        bPD();
        return true;
      }
      this.eKH = false;
    }
    return false;
  }
  
  /* Error */
  public final int t(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 259
    //   3: ldc_w 453
    //   6: invokestatic 343	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 455	com/tencent/mm/plugin/voip/model/b:context	Landroid/content/Context;
    //   14: aload_0
    //   15: getfield 105	com/tencent/mm/plugin/voip/model/b:pNx	I
    //   18: iconst_2
    //   19: if_icmpne +48 -> 67
    //   22: aload_0
    //   23: iconst_3
    //   24: putfield 87	com/tencent/mm/plugin/voip/model/b:eKB	I
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 103	com/tencent/mm/plugin/voip/model/b:nSamplerate	I
    //   32: aload_0
    //   33: getfield 87	com/tencent/mm/plugin/voip/model/b:eKB	I
    //   36: iconst_2
    //   37: invokestatic 402	android/media/AudioTrack:getMinBufferSize	(III)I
    //   40: putfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   43: aload_0
    //   44: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   47: bipush 254
    //   49: if_icmpeq +11 -> 60
    //   52: aload_0
    //   53: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   56: iconst_m1
    //   57: if_icmpne +18 -> 75
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 163	com/tencent/mm/plugin/voip/model/b:pNT	I
    //   65: iconst_m1
    //   66: ireturn
    //   67: aload_0
    //   68: iconst_2
    //   69: putfield 87	com/tencent/mm/plugin/voip/model/b:eKB	I
    //   72: goto -45 -> 27
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   80: putfield 137	com/tencent/mm/plugin/voip/model/b:pNG	I
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 137	com/tencent/mm/plugin/voip/model/b:pNG	I
    //   88: aload_0
    //   89: getfield 147	com/tencent/mm/plugin/voip/model/b:pNL	I
    //   92: imul
    //   93: putfield 149	com/tencent/mm/plugin/voip/model/b:pNM	I
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   101: aload_0
    //   102: getfield 157	com/tencent/mm/plugin/voip/model/b:pNQ	I
    //   105: imul
    //   106: putfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   109: aload_0
    //   110: getfield 137	com/tencent/mm/plugin/voip/model/b:pNG	I
    //   113: iconst_1
    //   114: ishr
    //   115: i2f
    //   116: aload_0
    //   117: getfield 103	com/tencent/mm/plugin/voip/model/b:nSamplerate	I
    //   120: i2f
    //   121: fdiv
    //   122: fstore_3
    //   123: invokestatic 460	com/tencent/mm/compatible/e/m:yR	()I
    //   126: istore 4
    //   128: getstatic 196	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   131: getfield 463	com/tencent/mm/compatible/e/b:dvG	I
    //   134: istore 5
    //   136: iload 4
    //   138: sipush 1024
    //   141: iand
    //   142: ifeq +269 -> 411
    //   145: iload 5
    //   147: istore 4
    //   149: iload 5
    //   151: ifgt +6 -> 157
    //   154: iconst_0
    //   155: istore 4
    //   157: ldc_w 259
    //   160: new 290	java/lang/StringBuilder
    //   163: dup
    //   164: ldc_w 465
    //   167: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: iload 4
    //   172: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 365	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: ldc_w 466
    //   184: fload_3
    //   185: fmul
    //   186: ldc_w 467
    //   189: fcmpg
    //   190: iflt +10 -> 200
    //   193: aload_0
    //   194: getfield 167	com/tencent/mm/plugin/voip/model/b:hpD	I
    //   197: ifeq +6 -> 203
    //   200: iconst_0
    //   201: istore 4
    //   203: iload 4
    //   205: ifne +212 -> 417
    //   208: iconst_0
    //   209: istore 6
    //   211: aload_0
    //   212: iload 6
    //   214: putfield 83	com/tencent/mm/plugin/voip/model/b:pNp	Z
    //   217: ldc_w 259
    //   220: new 290	java/lang/StringBuilder
    //   223: dup
    //   224: ldc_w 469
    //   227: invokespecial 295	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   234: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: ldc_w 407
    //   240: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: fload_3
    //   244: invokevirtual 410	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   247: ldc_w 471
    //   250: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_0
    //   254: getfield 83	com/tencent/mm/plugin/voip/model/b:pNp	Z
    //   257: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   260: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 343	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_0
    //   267: iload_2
    //   268: invokespecial 382	com/tencent/mm/plugin/voip/model/b:jR	(Z)I
    //   271: istore 4
    //   273: aload_0
    //   274: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   277: astore_1
    //   278: aload_1
    //   279: ifnull +10 -> 289
    //   282: aload_0
    //   283: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   286: invokevirtual 254	android/media/AudioTrack:release	()V
    //   289: aload_0
    //   290: new 439	com/tencent/mm/compatible/b/d
    //   293: dup
    //   294: iload 4
    //   296: aload_0
    //   297: getfield 103	com/tencent/mm/plugin/voip/model/b:nSamplerate	I
    //   300: aload_0
    //   301: getfield 87	com/tencent/mm/plugin/voip/model/b:eKB	I
    //   304: aload_0
    //   305: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   308: invokespecial 442	com/tencent/mm/compatible/b/d:<init>	(IIII)V
    //   311: putfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   314: aload_0
    //   315: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   318: ifnull +13 -> 331
    //   321: aload_0
    //   322: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   325: invokevirtual 286	android/media/AudioTrack:getState	()I
    //   328: ifne +60 -> 388
    //   331: aload_0
    //   332: iconst_2
    //   333: putfield 163	com/tencent/mm/plugin/voip/model/b:pNT	I
    //   336: ldc_w 259
    //   339: ldc_w 473
    //   342: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   349: ifnull +10 -> 359
    //   352: aload_0
    //   353: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   356: invokevirtual 254	android/media/AudioTrack:release	()V
    //   359: iload 4
    //   361: ifne +89 -> 450
    //   364: aload_0
    //   365: new 439	com/tencent/mm/compatible/b/d
    //   368: dup
    //   369: iconst_3
    //   370: aload_0
    //   371: getfield 103	com/tencent/mm/plugin/voip/model/b:nSamplerate	I
    //   374: aload_0
    //   375: getfield 87	com/tencent/mm/plugin/voip/model/b:eKB	I
    //   378: aload_0
    //   379: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   382: invokespecial 442	com/tencent/mm/compatible/b/d:<init>	(IIII)V
    //   385: putfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   388: aload_0
    //   389: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   392: ifnonnull +85 -> 477
    //   395: aload_0
    //   396: iconst_3
    //   397: putfield 163	com/tencent/mm/plugin/voip/model/b:pNT	I
    //   400: ldc_w 259
    //   403: ldc_w 475
    //   406: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: iconst_m1
    //   410: ireturn
    //   411: iconst_0
    //   412: istore 4
    //   414: goto -233 -> 181
    //   417: iconst_1
    //   418: istore 6
    //   420: goto -209 -> 211
    //   423: astore_1
    //   424: ldc_w 259
    //   427: ldc_w 477
    //   430: iconst_1
    //   431: anewarray 4	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload_1
    //   437: aastore
    //   438: invokestatic 479	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: aload_0
    //   442: bipush 6
    //   444: putfield 163	com/tencent/mm/plugin/voip/model/b:pNT	I
    //   447: goto -133 -> 314
    //   450: aload_0
    //   451: new 439	com/tencent/mm/compatible/b/d
    //   454: dup
    //   455: iconst_0
    //   456: aload_0
    //   457: getfield 103	com/tencent/mm/plugin/voip/model/b:nSamplerate	I
    //   460: aload_0
    //   461: getfield 87	com/tencent/mm/plugin/voip/model/b:eKB	I
    //   464: aload_0
    //   465: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   468: invokespecial 442	com/tencent/mm/compatible/b/d:<init>	(IIII)V
    //   471: putfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   474: goto -86 -> 388
    //   477: aload_0
    //   478: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   481: invokevirtual 286	android/media/AudioTrack:getState	()I
    //   484: ifne +31 -> 515
    //   487: aload_0
    //   488: iconst_3
    //   489: putfield 163	com/tencent/mm/plugin/voip/model/b:pNT	I
    //   492: ldc_w 259
    //   495: ldc_w 481
    //   498: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: aload_0
    //   502: getfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   505: invokevirtual 254	android/media/AudioTrack:release	()V
    //   508: aload_0
    //   509: aconst_null
    //   510: putfield 111	com/tencent/mm/plugin/voip/model/b:awx	Landroid/media/AudioTrack;
    //   513: iconst_m1
    //   514: ireturn
    //   515: aload_0
    //   516: aload_0
    //   517: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   520: newarray byte
    //   522: putfield 93	com/tencent/mm/plugin/voip/model/b:pNs	[B
    //   525: aload_0
    //   526: getfield 93	com/tencent/mm/plugin/voip/model/b:pNs	[B
    //   529: ifnonnull +14 -> 543
    //   532: ldc_w 259
    //   535: ldc_w 483
    //   538: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: iconst_m1
    //   542: ireturn
    //   543: aload_0
    //   544: aload_0
    //   545: getfield 109	com/tencent/mm/plugin/voip/model/b:eKG	I
    //   548: newarray byte
    //   550: putfield 99	com/tencent/mm/plugin/voip/model/b:pNv	[B
    //   553: aload_0
    //   554: getfield 99	com/tencent/mm/plugin/voip/model/b:pNv	[B
    //   557: ifnonnull +14 -> 571
    //   560: ldc_w 259
    //   563: ldc_w 485
    //   566: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: iconst_m1
    //   570: ireturn
    //   571: aload_0
    //   572: getfield 83	com/tencent/mm/plugin/voip/model/b:pNp	Z
    //   575: ifeq +95 -> 670
    //   578: aload_0
    //   579: aload_0
    //   580: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   583: putfield 91	com/tencent/mm/plugin/voip/model/b:pNr	I
    //   586: aload_0
    //   587: aload_0
    //   588: getfield 91	com/tencent/mm/plugin/voip/model/b:pNr	I
    //   591: newarray byte
    //   593: putfield 95	com/tencent/mm/plugin/voip/model/b:pNt	[B
    //   596: aload_0
    //   597: getfield 95	com/tencent/mm/plugin/voip/model/b:pNt	[B
    //   600: ifnonnull +14 -> 614
    //   603: ldc_w 259
    //   606: ldc_w 487
    //   609: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: iconst_m1
    //   613: ireturn
    //   614: aload_0
    //   615: aload_0
    //   616: getfield 91	com/tencent/mm/plugin/voip/model/b:pNr	I
    //   619: newarray byte
    //   621: putfield 97	com/tencent/mm/plugin/voip/model/b:pNu	[B
    //   624: aload_0
    //   625: getfield 97	com/tencent/mm/plugin/voip/model/b:pNu	[B
    //   628: ifnonnull +14 -> 642
    //   631: ldc_w 259
    //   634: ldc_w 489
    //   637: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: iconst_m1
    //   641: ireturn
    //   642: aload_0
    //   643: aload_0
    //   644: getfield 109	com/tencent/mm/plugin/voip/model/b:eKG	I
    //   647: newarray byte
    //   649: putfield 101	com/tencent/mm/plugin/voip/model/b:pNw	[B
    //   652: aload_0
    //   653: getfield 101	com/tencent/mm/plugin/voip/model/b:pNw	[B
    //   656: ifnonnull +14 -> 670
    //   659: ldc_w 259
    //   662: ldc_w 491
    //   665: invokestatic 266	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: iconst_m1
    //   669: ireturn
    //   670: aload_0
    //   671: iconst_0
    //   672: putfield 79	com/tencent/mm/plugin/voip/model/b:pNn	Z
    //   675: aload_0
    //   676: iconst_0
    //   677: putfield 81	com/tencent/mm/plugin/voip/model/b:pNo	Z
    //   680: ldc_w 259
    //   683: ldc_w 493
    //   686: iconst_5
    //   687: anewarray 4	java/lang/Object
    //   690: dup
    //   691: iconst_0
    //   692: invokestatic 207	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
    //   695: getfield 416	com/tencent/mm/compatible/b/f:dui	Landroid/media/AudioManager;
    //   698: invokevirtual 421	android/media/AudioManager:getMode	()I
    //   701: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   704: aastore
    //   705: dup
    //   706: iconst_1
    //   707: invokestatic 207	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
    //   710: getfield 416	com/tencent/mm/compatible/b/f:dui	Landroid/media/AudioManager;
    //   713: invokevirtual 430	android/media/AudioManager:isSpeakerphoneOn	()Z
    //   716: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   719: aastore
    //   720: dup
    //   721: iconst_2
    //   722: iload 4
    //   724: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   727: aastore
    //   728: dup
    //   729: iconst_3
    //   730: aload_0
    //   731: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   734: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   737: aastore
    //   738: dup
    //   739: iconst_4
    //   740: aload_0
    //   741: getfield 103	com/tencent/mm/plugin/voip/model/b:nSamplerate	I
    //   744: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   747: aastore
    //   748: invokestatic 437	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   751: aload_0
    //   752: getfield 89	com/tencent/mm/plugin/voip/model/b:eKF	I
    //   755: sipush 1000
    //   758: imul
    //   759: aload_0
    //   760: getfield 103	com/tencent/mm/plugin/voip/model/b:nSamplerate	I
    //   763: iconst_2
    //   764: imul
    //   765: idiv
    //   766: ireturn
    //   767: astore_1
    //   768: goto -479 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	771	0	this	b
    //   0	771	1	paramContext	Context
    //   0	771	2	paramBoolean	boolean
    //   122	122	3	f	float
    //   126	597	4	i	int
    //   134	16	5	j	int
    //   209	210	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   273	278	423	java/lang/Exception
    //   289	314	423	java/lang/Exception
    //   282	289	767	java/lang/Exception
  }
  
  public final int z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (true == this.pNn) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.pNx = paramInt2;
    this.eKC = paramInt3;
    this.hpD = paramInt4;
    this.eKG = (this.nSamplerate / 1000 * paramInt2 * this.eKC * 2);
    this.pNO = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  final class a
    extends TimerTask
  {
    a() {}
    
    public final void run()
    {
      System.currentTimeMillis();
      if ((b.a(b.this) == 1) && (b.this.pNn == true))
      {
        System.currentTimeMillis();
        if ((b.b(b.this) + b.this.eKG < b.c(b.this)) && (b.d(b.this) == 0))
        {
          b.a(b.this, 1);
          int i = b.this.pNy.L(b.e(b.this), b.this.eKG);
          b.a(b.this, 0);
          if (i >= 0) {
            break label136;
          }
          y.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + i);
        }
      }
      return;
      label136:
      synchronized (b.f(b.this))
      {
        System.arraycopy(b.e(b.this), 0, b.g(b.this), b.b(b.this), b.this.eKG);
        b.b(b.this, b.b(b.this) + b.this.eKG);
        b.c(b.this, b.h(b.this) + (b.this.eKG >> 1));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.b
 * JD-Core Version:    0.7.0.1
 */