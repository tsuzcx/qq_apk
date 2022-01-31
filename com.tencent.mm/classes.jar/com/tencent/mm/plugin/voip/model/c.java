package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;

public final class c
{
  private static float azp = 0.0F;
  public AudioTrack ayN;
  private Timer cjY;
  private boolean cjZ;
  Context context;
  private int ene;
  int gah;
  private int gai;
  private Runnable gaj;
  private int gal;
  int gam;
  private boolean gan;
  private int jde;
  private int nSamplerate;
  private int ttA;
  private int ttB;
  private int ttC;
  private int ttD;
  private int ttE;
  private long ttF;
  private long ttG;
  private int ttH;
  private int ttI;
  private int ttJ;
  private int ttK;
  private long ttL;
  private int ttM;
  private int ttN;
  private final Object ttO;
  private int ttP;
  private int ttQ;
  private int ttR;
  private int ttS;
  public boolean ttj;
  boolean ttk;
  boolean ttl;
  k ttm;
  private int ttn;
  private byte[] tto;
  private byte[] ttp;
  private byte[] ttq;
  private byte[] ttr;
  private byte[] tts;
  private int ttt;
  public b ttu;
  private int ttv;
  private int ttw;
  private int ttx;
  private int tty;
  private int ttz;
  
  public c()
  {
    AppMethodBeat.i(4323);
    this.ttj = false;
    this.ttk = false;
    this.ttl = true;
    this.ttm = null;
    this.gah = 2;
    this.gal = 0;
    this.ttn = 0;
    this.tto = null;
    this.ttp = null;
    this.ttq = null;
    this.ttr = null;
    this.tts = null;
    this.nSamplerate = 0;
    this.ttt = 0;
    this.gai = 0;
    this.gam = 20;
    this.ayN = null;
    this.ttu = null;
    this.cjY = null;
    this.cjZ = false;
    this.ttv = 1;
    this.ttw = 1;
    this.ttx = 0;
    this.ene = 3;
    this.gan = false;
    this.tty = 0;
    this.ttz = 0;
    this.ttA = 0;
    this.ttB = 0;
    this.ttC = 0;
    this.ttD = 1;
    this.ttE = 0;
    this.ttF = 0L;
    this.ttG = 0L;
    this.ttH = 1;
    this.ttI = 0;
    this.ttJ = -1;
    this.ttK = 0;
    this.ttL = 0L;
    this.ttM = 1;
    this.ttN = 0;
    this.ttO = new Object();
    this.ttP = 0;
    this.ttQ = 0;
    this.jde = 0;
    this.ttR = 0;
    this.ttS = 0;
    AppMethodBeat.o(4323);
  }
  
  private int mK(boolean paramBoolean)
  {
    AppMethodBeat.i(4326);
    int j = 0;
    int i;
    if (ac.erv.emE > 0)
    {
      j = g.KC().bM(paramBoolean);
      if ((!paramBoolean) || (ac.erv.enh < 0)) {
        break label118;
      }
      i = ac.erv.enh;
      label45:
      j = i;
      if (1 == this.jde)
      {
        if (ac.erv.enH >= 0) {
          i = ac.erv.enH;
        }
        if ((!paramBoolean) || (ac.erv.enI < 0)) {
          break label145;
        }
        j = ac.erv.enI;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(4326);
      return j;
      if (ac.erv.eng < 0) {
        break;
      }
      j = ac.erv.eng;
      break;
      label118:
      i = j;
      if (paramBoolean) {
        break label45;
      }
      i = j;
      if (ac.erv.eni < 0) {
        break label45;
      }
      i = ac.erv.eni;
      break label45;
      label145:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (ac.erv.enJ >= 0) {
          j = ac.erv.enJ;
        }
      }
    }
  }
  
  public final int F(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (true == this.ttj) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.ttt = paramInt2;
    this.gai = paramInt3;
    this.jde = paramInt4;
    this.gam = (this.nSamplerate / 1000 * paramInt2 * this.gai * 2);
    this.ttK = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  public final int cLF()
  {
    return this.ttN / this.gam * this.gai;
  }
  
  public final int cLG()
  {
    AppMethodBeat.i(4327);
    if (this.ayN != null)
    {
      this.ayN.release();
      this.ayN = null;
    }
    this.ttj = false;
    this.ttk = false;
    AppMethodBeat.o(4327);
    return 1;
  }
  
  public final int cLH()
  {
    AppMethodBeat.i(4328);
    if (true == this.ttj)
    {
      AppMethodBeat.o(4328);
      return 1;
    }
    if (this.ayN == null)
    {
      ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      AppMethodBeat.o(4328);
      return 0;
    }
    this.ttj = true;
    try
    {
      this.ayN.play();
      if (this.ayN.getPlayState() != 3)
      {
        this.ttP = 4;
        ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
        AppMethodBeat.o(4328);
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[] { localException.getMessage() });
      }
      if (this.ayN.getState() == 0)
      {
        ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        AppMethodBeat.o(4328);
        return 0;
      }
      if (this.ttl)
      {
        int i;
        if ((this.cjZ) || (this.cjY != null))
        {
          ab.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.cjZ);
          i = -1;
        }
        while (i != 0)
        {
          ab.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          AppMethodBeat.o(4328);
          return 0;
          this.cjY = new Timer();
          if (this.cjY == null) {
            i = -1;
          } else {
            i = 0;
          }
        }
        this.cjY.scheduleAtFixedRate(new c.a(this), 0L, 20L);
        this.cjZ = true;
      }
      this.gaj = new c.1(this);
      d.f(this.gaj, "AudioPlayer_play");
      AppMethodBeat.o(4328);
    }
    return 1;
  }
  
  public final int cLI()
  {
    AppMethodBeat.i(4329);
    if (this.nSamplerate == 0)
    {
      ab.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
      AppMethodBeat.o(4329);
      return 0;
    }
    if (this.ayN == null)
    {
      ab.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.ttC + ",nSamplerate:" + this.nSamplerate);
      i = this.ttC * 1000 / this.nSamplerate;
      AppMethodBeat.o(4329);
      return i;
    }
    if ((this.ttj) && (this.ayN.getState() != 0)) {
      try
      {
        i = this.ayN.getPlaybackHeadPosition();
        i = (this.tty - i) * 1000 / this.nSamplerate;
        AppMethodBeat.o(4329);
        return i;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        i = this.ttC * 1000 / this.nSamplerate;
        AppMethodBeat.o(4329);
        return i;
      }
    }
    int i = this.ttC * 1000 / this.nSamplerate;
    AppMethodBeat.o(4329);
    return i;
  }
  
  /* Error */
  public final int cLJ()
  {
    // Byte code:
    //   0: sipush 4330
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 122	com/tencent/mm/plugin/voip/model/c:cjZ	Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 120	com/tencent/mm/plugin/voip/model/c:cjY	Ljava/util/Timer;
    //   17: ifnull +15 -> 32
    //   20: aload_0
    //   21: getfield 120	com/tencent/mm/plugin/voip/model/c:cjY	Ljava/util/Timer;
    //   24: invokevirtual 366	java/util/Timer:cancel	()V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 122	com/tencent/mm/plugin/voip/model/c:cjZ	Z
    //   32: aload_0
    //   33: getfield 84	com/tencent/mm/plugin/voip/model/c:ttj	Z
    //   36: ifne +11 -> 47
    //   39: sipush 4330
    //   42: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_1
    //   46: ireturn
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 84	com/tencent/mm/plugin/voip/model/c:ttj	Z
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 164	com/tencent/mm/plugin/voip/model/c:ttN	I
    //   57: aload_0
    //   58: getfield 331	com/tencent/mm/plugin/voip/model/c:gaj	Ljava/lang/Runnable;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +15 -> 78
    //   66: getstatic 370	com/tencent/mm/sdk/g/d:ysm	Lcom/tencent/mm/sdk/g/a/e;
    //   69: aload_0
    //   70: getfield 331	com/tencent/mm/plugin/voip/model/c:gaj	Ljava/lang/Runnable;
    //   73: invokeinterface 376 2 0
    //   78: aload_0
    //   79: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   82: ifnull +26 -> 108
    //   85: aload_0
    //   86: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   89: invokevirtual 379	android/media/AudioTrack:stop	()V
    //   92: aload_0
    //   93: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   96: invokevirtual 262	android/media/AudioTrack:release	()V
    //   99: ldc_w 267
    //   102: ldc_w 381
    //   105: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: sipush 4330
    //   111: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iconst_1
    //   115: ireturn
    //   116: astore_1
    //   117: ldc_w 267
    //   120: aload_1
    //   121: ldc_w 385
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 389	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: goto -53 -> 78
    //   134: astore_1
    //   135: ldc_w 267
    //   138: aload_1
    //   139: ldc_w 385
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 389	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: goto -71 -> 78
    //   152: astore_1
    //   153: ldc_w 267
    //   156: ldc_w 391
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: invokevirtual 288	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 291	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: goto -65 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	c
    //   61	2	1	localRunnable	Runnable
    //   116	5	1	localExecutionException	java.util.concurrent.ExecutionException
    //   134	5	1	localInterruptedException	java.lang.InterruptedException
    //   152	14	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   66	78	116	java/util/concurrent/ExecutionException
    //   57	62	134	java/lang/InterruptedException
    //   66	78	134	java/lang/InterruptedException
    //   117	131	134	java/lang/InterruptedException
    //   78	108	152	java/lang/Exception
  }
  
  public final int cLK()
  {
    AppMethodBeat.i(4331);
    ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.ttP);
    int i = this.ttP;
    AppMethodBeat.o(4331);
    return i;
  }
  
  public final int cLL()
  {
    AppMethodBeat.i(4332);
    if (this.ayN != null)
    {
      i = this.ayN.getStreamType();
      AppMethodBeat.o(4332);
      return i;
    }
    int i = mK(true);
    AppMethodBeat.o(4332);
    return i;
  }
  
  public final boolean mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(4325);
    ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = mK(paramBoolean);
    if (g.KC().KH()) {
      i = 0;
    }
    ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.ayN != null) && (i == this.ayN.getStreamType()))
    {
      ab.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      AppMethodBeat.o(4325);
      return false;
    }
    cLJ();
    this.gan = true;
    if (this.ttt == 2) {}
    for (this.gah = 3;; this.gah = 2)
    {
      this.gal = AudioTrack.getMinBufferSize(this.nSamplerate, this.gah, 2);
      if ((this.gal != -2) && (this.gal != -1)) {
        break;
      }
      this.gan = false;
      AppMethodBeat.o(4325);
      return false;
    }
    this.tty = 0;
    this.ttB = 0;
    this.ttD = 1;
    this.ttE = 0;
    this.ttF = 0L;
    this.ttG = 0L;
    this.ttH = 1;
    this.ttJ = -1;
    this.ttK = 0;
    this.ttC = this.gal;
    this.ttI = (this.ttC * this.ttH);
    this.gal *= this.ttM;
    float f = this.ttC / 16.0F;
    ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.gal + "  MinBufSizeInMs:" + f);
    if (this.ayN != null) {}
    try
    {
      this.ayN.stop();
      this.ayN.release();
      this.ayN = null;
      ab.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(g.KC().elW.getMode()), Boolean.valueOf(g.KC().elW.isSpeakerphoneOn()), Integer.valueOf(i), Integer.valueOf(this.gal), Integer.valueOf(this.nSamplerate) });
      this.ayN = new e(i, this.nSamplerate, this.gah, this.gal);
      if ((this.ayN != null) && (this.ayN.getState() == 0))
      {
        ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.ayN.release();
        this.ayN = null;
        AppMethodBeat.o(4325);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[] { localException.getMessage() });
      }
      ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
      if (this.ayN != null)
      {
        this.gan = false;
        cLH();
        AppMethodBeat.o(4325);
        return true;
      }
      this.gan = false;
      AppMethodBeat.o(4325);
    }
    return false;
  }
  
  /* Error */
  public final int x(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 4324
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 267
    //   9: ldc_w 471
    //   12: invokestatic 353	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 473	com/tencent/mm/plugin/voip/model/c:context	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 110	com/tencent/mm/plugin/voip/model/c:ttt	I
    //   24: iconst_2
    //   25: if_icmpne +54 -> 79
    //   28: aload_0
    //   29: iconst_3
    //   30: putfield 92	com/tencent/mm/plugin/voip/model/c:gah	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 108	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   38: aload_0
    //   39: getfield 92	com/tencent/mm/plugin/voip/model/c:gah	I
    //   42: iconst_2
    //   43: invokestatic 420	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: putfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   49: aload_0
    //   50: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   53: bipush 254
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   62: iconst_m1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 168	com/tencent/mm/plugin/voip/model/c:ttP	I
    //   71: sipush 4324
    //   74: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_0
    //   80: iconst_2
    //   81: putfield 92	com/tencent/mm/plugin/voip/model/c:gah	I
    //   84: goto -51 -> 33
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   92: putfield 142	com/tencent/mm/plugin/voip/model/c:ttC	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 142	com/tencent/mm/plugin/voip/model/c:ttC	I
    //   100: aload_0
    //   101: getfield 152	com/tencent/mm/plugin/voip/model/c:ttH	I
    //   104: imul
    //   105: putfield 154	com/tencent/mm/plugin/voip/model/c:ttI	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   113: aload_0
    //   114: getfield 162	com/tencent/mm/plugin/voip/model/c:ttM	I
    //   117: imul
    //   118: putfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   121: aload_0
    //   122: getfield 142	com/tencent/mm/plugin/voip/model/c:ttC	I
    //   125: iconst_1
    //   126: ishr
    //   127: i2f
    //   128: aload_0
    //   129: getfield 108	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   132: i2f
    //   133: fdiv
    //   134: fstore_3
    //   135: invokestatic 478	com/tencent/mm/compatible/e/m:Lo	()I
    //   138: istore 4
    //   140: getstatic 207	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   143: getfield 481	com/tencent/mm/compatible/e/b:enx	I
    //   146: istore 5
    //   148: iload 4
    //   150: sipush 1024
    //   153: iand
    //   154: ifeq +268 -> 422
    //   157: iload 5
    //   159: istore 4
    //   161: iload 5
    //   163: ifgt +6 -> 169
    //   166: iconst_0
    //   167: istore 4
    //   169: ldc_w 267
    //   172: ldc_w 483
    //   175: iload 4
    //   177: invokestatic 488	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   180: invokevirtual 492	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 493
    //   189: fload_3
    //   190: fmul
    //   191: ldc_w 494
    //   194: fcmpg
    //   195: iflt +10 -> 205
    //   198: aload_0
    //   199: getfield 172	com/tencent/mm/plugin/voip/model/c:jde	I
    //   202: ifeq +6 -> 208
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +218 -> 428
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: iload 6
    //   219: putfield 88	com/tencent/mm/plugin/voip/model/c:ttl	Z
    //   222: ldc_w 267
    //   225: new 298	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 496
    //   232: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_0
    //   236: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   239: invokevirtual 346	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc_w 425
    //   245: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: fload_3
    //   249: invokevirtual 428	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   252: ldc_w 498
    //   255: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 88	com/tencent/mm/plugin/voip/model/c:ttl	Z
    //   262: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   265: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 353	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: iload_2
    //   273: invokespecial 400	com/tencent/mm/plugin/voip/model/c:mK	(Z)I
    //   276: istore 4
    //   278: aload_0
    //   279: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull +10 -> 294
    //   287: aload_0
    //   288: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   291: invokevirtual 262	android/media/AudioTrack:release	()V
    //   294: aload_0
    //   295: new 457	com/tencent/mm/compatible/b/e
    //   298: dup
    //   299: iload 4
    //   301: aload_0
    //   302: getfield 108	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   305: aload_0
    //   306: getfield 92	com/tencent/mm/plugin/voip/model/c:gah	I
    //   309: aload_0
    //   310: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   313: invokespecial 460	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   316: putfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   319: aload_0
    //   320: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   323: ifnull +13 -> 336
    //   326: aload_0
    //   327: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   330: invokevirtual 294	android/media/AudioTrack:getState	()I
    //   333: ifne +60 -> 393
    //   336: aload_0
    //   337: iconst_2
    //   338: putfield 168	com/tencent/mm/plugin/voip/model/c:ttP	I
    //   341: ldc_w 267
    //   344: ldc_w 500
    //   347: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload_0
    //   351: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   354: ifnull +10 -> 364
    //   357: aload_0
    //   358: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   361: invokevirtual 262	android/media/AudioTrack:release	()V
    //   364: iload 4
    //   366: ifne +95 -> 461
    //   369: aload_0
    //   370: new 457	com/tencent/mm/compatible/b/e
    //   373: dup
    //   374: iconst_3
    //   375: aload_0
    //   376: getfield 108	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   379: aload_0
    //   380: getfield 92	com/tencent/mm/plugin/voip/model/c:gah	I
    //   383: aload_0
    //   384: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   387: invokespecial 460	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   390: putfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   393: aload_0
    //   394: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   397: ifnonnull +91 -> 488
    //   400: aload_0
    //   401: iconst_3
    //   402: putfield 168	com/tencent/mm/plugin/voip/model/c:ttP	I
    //   405: ldc_w 267
    //   408: ldc_w 502
    //   411: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: sipush 4324
    //   417: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: iconst_m1
    //   421: ireturn
    //   422: iconst_0
    //   423: istore 4
    //   425: goto -239 -> 186
    //   428: iconst_1
    //   429: istore 6
    //   431: goto -215 -> 216
    //   434: astore_1
    //   435: ldc_w 267
    //   438: ldc_w 504
    //   441: iconst_1
    //   442: anewarray 4	java/lang/Object
    //   445: dup
    //   446: iconst_0
    //   447: aload_1
    //   448: aastore
    //   449: invokestatic 506	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   452: aload_0
    //   453: bipush 6
    //   455: putfield 168	com/tencent/mm/plugin/voip/model/c:ttP	I
    //   458: goto -139 -> 319
    //   461: aload_0
    //   462: new 457	com/tencent/mm/compatible/b/e
    //   465: dup
    //   466: iconst_0
    //   467: aload_0
    //   468: getfield 108	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   471: aload_0
    //   472: getfield 92	com/tencent/mm/plugin/voip/model/c:gah	I
    //   475: aload_0
    //   476: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   479: invokespecial 460	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   482: putfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   485: goto -92 -> 393
    //   488: aload_0
    //   489: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   492: invokevirtual 294	android/media/AudioTrack:getState	()I
    //   495: ifne +37 -> 532
    //   498: aload_0
    //   499: iconst_3
    //   500: putfield 168	com/tencent/mm/plugin/voip/model/c:ttP	I
    //   503: ldc_w 267
    //   506: ldc_w 508
    //   509: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: getfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   516: invokevirtual 262	android/media/AudioTrack:release	()V
    //   519: aload_0
    //   520: aconst_null
    //   521: putfield 116	com/tencent/mm/plugin/voip/model/c:ayN	Landroid/media/AudioTrack;
    //   524: sipush 4324
    //   527: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: iconst_m1
    //   531: ireturn
    //   532: aload_0
    //   533: aload_0
    //   534: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   537: newarray byte
    //   539: putfield 98	com/tencent/mm/plugin/voip/model/c:tto	[B
    //   542: aload_0
    //   543: getfield 98	com/tencent/mm/plugin/voip/model/c:tto	[B
    //   546: ifnonnull +20 -> 566
    //   549: ldc_w 267
    //   552: ldc_w 510
    //   555: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: sipush 4324
    //   561: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   564: iconst_m1
    //   565: ireturn
    //   566: aload_0
    //   567: aload_0
    //   568: getfield 114	com/tencent/mm/plugin/voip/model/c:gam	I
    //   571: newarray byte
    //   573: putfield 104	com/tencent/mm/plugin/voip/model/c:ttr	[B
    //   576: aload_0
    //   577: getfield 104	com/tencent/mm/plugin/voip/model/c:ttr	[B
    //   580: ifnonnull +20 -> 600
    //   583: ldc_w 267
    //   586: ldc_w 512
    //   589: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: sipush 4324
    //   595: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   598: iconst_m1
    //   599: ireturn
    //   600: aload_0
    //   601: getfield 88	com/tencent/mm/plugin/voip/model/c:ttl	Z
    //   604: ifeq +113 -> 717
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   612: putfield 96	com/tencent/mm/plugin/voip/model/c:ttn	I
    //   615: aload_0
    //   616: aload_0
    //   617: getfield 96	com/tencent/mm/plugin/voip/model/c:ttn	I
    //   620: newarray byte
    //   622: putfield 100	com/tencent/mm/plugin/voip/model/c:ttp	[B
    //   625: aload_0
    //   626: getfield 100	com/tencent/mm/plugin/voip/model/c:ttp	[B
    //   629: ifnonnull +20 -> 649
    //   632: ldc_w 267
    //   635: ldc_w 514
    //   638: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: sipush 4324
    //   644: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   647: iconst_m1
    //   648: ireturn
    //   649: aload_0
    //   650: aload_0
    //   651: getfield 96	com/tencent/mm/plugin/voip/model/c:ttn	I
    //   654: newarray byte
    //   656: putfield 102	com/tencent/mm/plugin/voip/model/c:ttq	[B
    //   659: aload_0
    //   660: getfield 102	com/tencent/mm/plugin/voip/model/c:ttq	[B
    //   663: ifnonnull +20 -> 683
    //   666: ldc_w 267
    //   669: ldc_w 516
    //   672: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: sipush 4324
    //   678: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   681: iconst_m1
    //   682: ireturn
    //   683: aload_0
    //   684: aload_0
    //   685: getfield 114	com/tencent/mm/plugin/voip/model/c:gam	I
    //   688: newarray byte
    //   690: putfield 106	com/tencent/mm/plugin/voip/model/c:tts	[B
    //   693: aload_0
    //   694: getfield 106	com/tencent/mm/plugin/voip/model/c:tts	[B
    //   697: ifnonnull +20 -> 717
    //   700: ldc_w 267
    //   703: ldc_w 518
    //   706: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   709: sipush 4324
    //   712: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   715: iconst_m1
    //   716: ireturn
    //   717: aload_0
    //   718: iconst_0
    //   719: putfield 84	com/tencent/mm/plugin/voip/model/c:ttj	Z
    //   722: aload_0
    //   723: iconst_0
    //   724: putfield 86	com/tencent/mm/plugin/voip/model/c:ttk	Z
    //   727: ldc_w 267
    //   730: ldc_w 520
    //   733: iconst_5
    //   734: anewarray 4	java/lang/Object
    //   737: dup
    //   738: iconst_0
    //   739: invokestatic 218	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   742: getfield 434	com/tencent/mm/compatible/b/g:elW	Landroid/media/AudioManager;
    //   745: invokevirtual 439	android/media/AudioManager:getMode	()I
    //   748: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   751: aastore
    //   752: dup
    //   753: iconst_1
    //   754: invokestatic 218	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   757: getfield 434	com/tencent/mm/compatible/b/g:elW	Landroid/media/AudioManager;
    //   760: invokevirtual 448	android/media/AudioManager:isSpeakerphoneOn	()Z
    //   763: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   766: aastore
    //   767: dup
    //   768: iconst_2
    //   769: iload 4
    //   771: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: aastore
    //   775: dup
    //   776: iconst_3
    //   777: aload_0
    //   778: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   781: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   784: aastore
    //   785: dup
    //   786: iconst_4
    //   787: aload_0
    //   788: getfield 108	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   791: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   794: aastore
    //   795: invokestatic 455	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   798: aload_0
    //   799: getfield 94	com/tencent/mm/plugin/voip/model/c:gal	I
    //   802: sipush 1000
    //   805: imul
    //   806: aload_0
    //   807: getfield 108	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   810: iconst_2
    //   811: imul
    //   812: idiv
    //   813: istore 4
    //   815: sipush 4324
    //   818: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   821: iload 4
    //   823: ireturn
    //   824: astore_1
    //   825: goto -531 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	828	0	this	c
    //   0	828	1	paramContext	Context
    //   0	828	2	paramBoolean	boolean
    //   134	115	3	f	float
    //   138	684	4	i	int
    //   146	16	5	j	int
    //   214	216	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   278	283	434	java/lang/Exception
    //   294	319	434	java/lang/Exception
    //   287	294	824	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c
 * JD-Core Version:    0.7.0.1
 */