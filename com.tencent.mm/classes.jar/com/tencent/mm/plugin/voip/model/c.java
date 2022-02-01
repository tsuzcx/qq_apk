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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  private static float volume = 0.0F;
  public AudioTrack aUg;
  private Timer cYR;
  private boolean cYS;
  Context context;
  private int fzM;
  private com.tencent.mm.audio.c.a.a hCJ;
  int hCU;
  private int hCV;
  int hCX;
  int hCY;
  private boolean hCZ;
  private int lSY;
  private int nSamplerate;
  private com.tencent.e.i.b xdx;
  l zfA;
  private int zfB;
  private byte[] zfC;
  private byte[] zfD;
  private byte[] zfE;
  private byte[] zfF;
  private byte[] zfG;
  public int zfH;
  AtomicBoolean zfI;
  public b zfJ;
  private int zfK;
  private int zfL;
  private int zfM;
  String zfN;
  private int zfO;
  private int zfP;
  private int zfQ;
  private int zfR;
  private int zfS;
  private int zfT;
  private int zfU;
  private long zfV;
  private long zfW;
  private int zfX;
  private int zfY;
  private int zfZ;
  public boolean zfx;
  boolean zfy;
  boolean zfz;
  private int zga;
  private long zgb;
  private int zgc;
  private int zgd;
  private final Object zge;
  private int zgf;
  private int zgg;
  private int zgh;
  private int zgi;
  
  public c()
  {
    AppMethodBeat.i(114815);
    this.zfx = false;
    this.zfy = false;
    this.zfz = true;
    this.zfA = null;
    this.hCU = 2;
    this.hCX = 0;
    this.zfB = 0;
    this.zfC = null;
    this.zfD = null;
    this.zfE = null;
    this.zfF = null;
    this.zfG = null;
    this.nSamplerate = 0;
    this.zfH = 0;
    this.hCV = 0;
    this.hCY = 20;
    this.aUg = null;
    this.zfI = new AtomicBoolean(false);
    this.zfJ = null;
    this.cYR = null;
    this.cYS = false;
    this.zfK = 1;
    this.zfL = 1;
    this.zfM = 0;
    this.zfN = null;
    this.fzM = 3;
    this.hCZ = false;
    this.zfO = 0;
    this.zfP = 0;
    this.zfQ = 0;
    this.zfR = 0;
    this.zfS = 0;
    this.zfT = 1;
    this.zfU = 0;
    this.zfV = 0L;
    this.zfW = 0L;
    this.zfX = 1;
    this.zfY = 0;
    this.zfZ = -1;
    this.zga = 0;
    this.zgb = 0L;
    this.zgc = 1;
    this.zgd = 0;
    this.zge = new Object();
    this.zgf = 0;
    this.zgg = 0;
    this.lSY = 0;
    this.zgh = 0;
    this.zgi = 0;
    AppMethodBeat.o(114815);
  }
  
  private int rs(boolean paramBoolean)
  {
    AppMethodBeat.i(114818);
    int j = 0;
    int i;
    if (ae.fFx.fzn > 0)
    {
      j = com.tencent.mm.plugin.audio.c.a.hO(paramBoolean);
      if ((!paramBoolean) || (ae.fFx.fzP < 0)) {
        break label113;
      }
      i = ae.fFx.fzP;
      label41:
      j = i;
      if (1 == this.lSY)
      {
        if (ae.fFx.fAt >= 0) {
          i = ae.fFx.fAt;
        }
        if ((!paramBoolean) || (ae.fFx.fAu < 0)) {
          break label140;
        }
        j = ae.fFx.fAu;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114818);
      return j;
      if (ae.fFx.fzO < 0) {
        break;
      }
      j = ae.fFx.fzO;
      break;
      label113:
      i = j;
      if (paramBoolean) {
        break label41;
      }
      i = j;
      if (ae.fFx.fzQ < 0) {
        break label41;
      }
      i = ae.fFx.fzQ;
      break label41;
      label140:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (ae.fFx.fAv >= 0) {
          j = ae.fFx.fAv;
        }
      }
    }
  }
  
  public final int K(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (true == this.zfx) {
      return 0;
    }
    this.nSamplerate = paramInt1;
    this.zfH = paramInt2;
    this.hCV = paramInt3;
    this.lSY = paramInt4;
    this.hCY = (this.nSamplerate / 1000 * paramInt2 * this.hCV * 2);
    this.zga = (this.nSamplerate * 60 / 1000);
    return 1;
  }
  
  public final void a(b paramb)
  {
    this.zfJ = paramb;
  }
  
  public final int aDs()
  {
    AppMethodBeat.i(114824);
    if (this.aUg != null)
    {
      i = this.aUg.getStreamType();
      AppMethodBeat.o(114824);
      return i;
    }
    int i = rs(true);
    AppMethodBeat.o(114824);
    return i;
  }
  
  public final int dRS()
  {
    return this.zgd / this.hCY * this.hCV;
  }
  
  public final int dRT()
  {
    AppMethodBeat.i(114819);
    ad.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit");
    if (this.aUg != null)
    {
      this.zfI.compareAndSet(false, true);
      this.aUg.release();
      this.aUg = null;
    }
    for (;;)
    {
      this.zfx = false;
      this.zfy = false;
      AppMethodBeat.o(114819);
      return 1;
      ad.i("MicroMsg.Voip.AudioPlayer", "audio player call uninit failed cause audio track is null");
    }
  }
  
  public final int dRU()
  {
    AppMethodBeat.i(114820);
    if (true == this.zfx)
    {
      AppMethodBeat.o(114820);
      return 1;
    }
    if (this.aUg == null)
    {
      ad.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
      AppMethodBeat.o(114820);
      return 0;
    }
    this.zfx = true;
    try
    {
      this.aUg.play();
      if ((this.aUg != null) && (this.aUg.getPlayState() != 3))
      {
        this.zgf = 4;
        ad.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
        AppMethodBeat.o(114820);
        return 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[] { localException.getMessage() });
      }
      if ((this.aUg != null) && (this.aUg.getState() == 0))
      {
        ad.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
        AppMethodBeat.o(114820);
        return 0;
      }
      if (this.zfz)
      {
        int i;
        if ((this.cYS) || (this.cYR != null))
        {
          ad.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.cYS);
          i = -1;
        }
        while (i != 0)
        {
          ad.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
          AppMethodBeat.o(114820);
          return 0;
          this.cYR = new Timer();
          if (this.cYR == null) {
            i = -1;
          } else {
            i = 0;
          }
        }
        this.cYR.scheduleAtFixedRate(new a(), 0L, 20L);
        this.cYS = true;
      }
      this.hCJ = new com.tencent.mm.audio.c.a.a();
      this.xdx = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "AudioPlayer_play";
        }
        
        public final void run()
        {
          AppMethodBeat.i(114813);
          Process.setThreadPriority(-19);
          ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
          int j = 0;
          while ((c.this.zfx) && (c.this.aUg != null) && (c.this.aUg.getPlayState() != 1) && (!c.this.zfI.get()))
          {
            int i;
            long l;
            try
            {
              i = c.this.aUg.getPlaybackHeadPosition();
              l = System.currentTimeMillis();
              c.d(c.this, c.j(c.this) - i);
              ad.i("MicroMsg.Voip.AudioPlayer", "m_iLefSamples value is %s and iPos value is %s", new Object[] { Integer.valueOf(c.k(c.this)), Integer.valueOf(i) });
              if (c.l(c.this) == 1)
              {
                c.e(c.this, i);
                c.a(c.this, l);
                c.b(c.this, l);
                c.m(c.this);
                c.c(c.this, l);
                if ((i != 0) && (c.this.zfz)) {
                  c.t(c.this);
                }
                if (c.this.zfJ == null) {
                  break label1593;
                }
                c.h(c.this, c.u(c.this) + c.this.hCY);
                if (c.a(c.this) != 0) {
                  break label715;
                }
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.hCY, c.x(c.this));
                  c.w(c.this).ci(1, com.tencent.mm.plugin.audio.c.a.bvB().getStreamVolume(c.this.aDs()) * 100 / com.tencent.mm.plugin.audio.c.a.bvB().audioManager.getStreamMaxVolume(c.this.aDs()));
                }
                i = c.this.zfJ.Q(c.x(c.this), c.this.hCY);
                if (i >= 0) {
                  break label1165;
                }
                com.tencent.mm.plugin.voip.b.c.QB(5);
                ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[] { localException });
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
                if (c.b(c.this) >= c.this.hCY)
                {
                  ad.i("MicroMsg.Voip.AudioPlayer", "m_iTaskLeftByte value is %s and nFrameLen value is %s", new Object[] { Integer.valueOf(c.b(c.this)), Integer.valueOf(c.this.hCY) });
                  synchronized (c.f(c.this))
                  {
                    System.arraycopy(c.g(c.this), 0, c.x(c.this), 0, c.this.hCY);
                    i = c.b(c.this) - c.this.hCY;
                    System.arraycopy(c.g(c.this), c.this.hCY, c.y(c.this), 0, i);
                    System.arraycopy(c.y(c.this), 0, c.g(c.this), 0, i);
                    c.b(c.this, c.b(c.this) - c.this.hCY);
                    ad.i("MicroMsg.Voip.AudioPlayer", "audio player has copy playTaskBuffer and left %s", new Object[] { Integer.valueOf(c.b(c.this)) });
                    i = 0;
                  }
                }
                if ((c.k(c.this) >= c.z(c.this) * 5 / 1000) || (c.A(c.this) != 0)) {
                  break;
                }
                c.i(c.this, 1);
                if ((c.v(c.this) == 0) && (c.w(c.this) != null))
                {
                  c.w(c.this).e(c.this.hCY, c.x(c.this));
                  c.w(c.this).ci(1, com.tencent.mm.plugin.audio.c.a.bvB().audioManager.getStreamVolume(c.this.aDs()) * 100 / com.tencent.mm.plugin.audio.c.a.bvB().audioManager.getStreamMaxVolume(c.this.aDs()));
                }
                i = c.this.zfJ.Q(c.x(c.this), c.this.hCY);
                c.i(c.this, 0);
              }
              ad.i("MicroMsg.Voip.AudioPlayer", "play run too fast !,m_iLefSamples: " + c.k(c.this) + " ,m_iTaskLeftByte: " + c.b(c.this));
              com.tencent.mm.plugin.voip.b.c.QB(2);
            }
            continue;
            label1165:
            if (c.B(c.this))
            {
              ad.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.B(c.this));
              com.tencent.mm.plugin.voip.b.c.QB(10);
            }
            else
            {
              c.a(c.this, l);
              if (c.C(c.this) >= c.this.hCY)
              {
                if (!c.B(c.this))
                {
                  i = c.this.aUg.write(c.x(c.this), 0, c.this.hCY);
                  if (i < 0)
                  {
                    c.j(c.this, i);
                    ad.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.k(c.this, c.j(c.this) + (c.this.hCY >> 1));
                }
              }
              else
              {
                System.arraycopy(c.x(c.this), 0, c.D(c.this), j, c.C(c.this) - j);
                if (c.this.aUg != null)
                {
                  i = c.this.aUg.write(c.D(c.this), 0, c.D(c.this).length);
                  if (i < 0)
                  {
                    c.j(c.this, i);
                    ad.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(i)));
                  }
                  c.k(c.this, c.j(c.this) + (c.D(c.this).length >> 1));
                  j = c.C(c.this) - j;
                  i = c.this.hCY - j;
                  while ((i >= c.C(c.this)) && (c.this.aUg != null))
                  {
                    c.this.aUg.write(c.x(c.this), j, c.C(c.this));
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
                com.tencent.mm.plugin.voip.b.c.QB(10);
              }
            }
          }
          if ((c.v(c.this) == 0) && (c.E(c.this) != null) && (c.w(c.this) != null))
          {
            c.w(c.this).b(1, c.E(c.this), c.this.aDs());
            c.w(c.this).hZ(1);
            c.w(c.this).ia(1);
            c.w(c.this).ib(1);
          }
          AppMethodBeat.o(114813);
        }
      };
      h.Iye.aNW("AudioPlayer_play");
      h.Iye.f(this.xdx, "AudioPlayer_play");
      AppMethodBeat.o(114820);
    }
    return 1;
  }
  
  public final int dRV()
  {
    AppMethodBeat.i(114821);
    if (this.nSamplerate == 0)
    {
      ad.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
      AppMethodBeat.o(114821);
      return 0;
    }
    if (this.aUg == null)
    {
      ad.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.zfS + ",nSamplerate:" + this.nSamplerate);
      i = this.zfS * 1000 / this.nSamplerate;
      AppMethodBeat.o(114821);
      return i;
    }
    if ((this.zfx) && (this.aUg.getState() != 0)) {
      try
      {
        i = this.aUg.getPlaybackHeadPosition();
        i = (this.zfO - i) * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[] { localException.getMessage() });
        i = this.zfS * 1000 / this.nSamplerate;
        AppMethodBeat.o(114821);
        return i;
      }
    }
    int i = this.zfS * 1000 / this.nSamplerate;
    AppMethodBeat.o(114821);
    return i;
  }
  
  /* Error */
  public final int dRW()
  {
    // Byte code:
    //   0: ldc_w 421
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 139	com/tencent/mm/plugin/voip/model/c:cYS	Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 137	com/tencent/mm/plugin/voip/model/c:cYR	Ljava/util/Timer;
    //   17: ifnull +15 -> 32
    //   20: aload_0
    //   21: getfield 137	com/tencent/mm/plugin/voip/model/c:cYR	Ljava/util/Timer;
    //   24: invokevirtual 424	java/util/Timer:cancel	()V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 139	com/tencent/mm/plugin/voip/model/c:cYS	Z
    //   32: ldc_w 293
    //   35: ldc_w 426
    //   38: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 94	com/tencent/mm/plugin/voip/model/c:zfx	Z
    //   45: ifne +20 -> 65
    //   48: ldc_w 293
    //   51: ldc_w 428
    //   54: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: ldc_w 421
    //   60: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_1
    //   64: ireturn
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 94	com/tencent/mm/plugin/voip/model/c:zfx	Z
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 183	com/tencent/mm/plugin/voip/model/c:zgd	I
    //   75: aload_0
    //   76: getfield 375	com/tencent/mm/plugin/voip/model/c:xdx	Lcom/tencent/e/i/b;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +10 -> 91
    //   84: aload_0
    //   85: getfield 375	com/tencent/mm/plugin/voip/model/c:xdx	Lcom/tencent/e/i/b;
    //   88: invokevirtual 433	com/tencent/e/i/b:fog	()V
    //   91: aload_0
    //   92: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   95: ifnull +56 -> 151
    //   98: aload_0
    //   99: getfield 133	com/tencent/mm/plugin/voip/model/c:zfI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: iconst_1
    //   104: invokevirtual 304	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   107: pop
    //   108: aload_0
    //   109: getfield 375	com/tencent/mm/plugin/voip/model/c:xdx	Lcom/tencent/e/i/b;
    //   112: invokevirtual 436	com/tencent/e/i/b:cancel	()Z
    //   115: pop
    //   116: getstatic 381	com/tencent/e/h:Iye	Lcom/tencent/e/i;
    //   119: ldc_w 383
    //   122: invokeinterface 389 2 0
    //   127: pop
    //   128: aload_0
    //   129: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   132: invokevirtual 439	android/media/AudioTrack:stop	()V
    //   135: aload_0
    //   136: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   139: invokevirtual 307	android/media/AudioTrack:release	()V
    //   142: ldc_w 293
    //   145: ldc_w 441
    //   148: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc_w 421
    //   154: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore_1
    //   160: ldc_w 293
    //   163: aload_1
    //   164: ldc_w 443
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 447	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -83 -> 91
    //   177: astore_1
    //   178: ldc_w 293
    //   181: aload_1
    //   182: ldc_w 443
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 447	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: goto -101 -> 91
    //   195: astore_1
    //   196: ldc_w 293
    //   199: ldc_w 449
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: invokevirtual 331	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final int dRX()
  {
    AppMethodBeat.i(114823);
    ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.zgf);
    int i = this.zgf;
    AppMethodBeat.o(114823);
    return i;
  }
  
  public final boolean isPlaying()
  {
    return this.zfx;
  }
  
  public final boolean rr(boolean paramBoolean)
  {
    AppMethodBeat.i(114817);
    ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
    int i = rs(paramBoolean);
    if (com.tencent.mm.plugin.audio.c.a.bvC()) {
      i = 0;
    }
    ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + paramBoolean + ":streamtype:" + i);
    if ((this.aUg != null) && (i == this.aUg.getStreamType()))
    {
      ad.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
      AppMethodBeat.o(114817);
      return false;
    }
    dRW();
    this.hCZ = true;
    if (this.zfH == 2) {}
    for (this.hCU = 3;; this.hCU = 2)
    {
      this.hCX = AudioTrack.getMinBufferSize(this.nSamplerate, this.hCU, 2);
      if ((this.hCX != -2) && (this.hCX != -1)) {
        break;
      }
      this.hCZ = false;
      AppMethodBeat.o(114817);
      return false;
    }
    this.zfO = 0;
    this.zfR = 0;
    this.zfT = 1;
    this.zfU = 0;
    this.zfV = 0L;
    this.zfW = 0L;
    this.zfX = 1;
    this.zfZ = -1;
    this.zga = 0;
    this.zfS = this.hCX;
    this.zfY = (this.zfS * this.zfX);
    this.hCX *= this.zgc;
    float f = this.zfS / 16.0F;
    ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.hCX + "  MinBufSizeInMs:" + f);
    if (this.aUg != null) {}
    try
    {
      this.zfI.compareAndSet(false, true);
      this.xdx.cancel();
      h.Iye.aNW("AudioPlayer_play");
      this.aUg.stop();
      this.aUg.release();
      this.aUg = null;
      ad.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.audio.c.a.getMode()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Integer.valueOf(i), Integer.valueOf(this.hCX), Integer.valueOf(this.nSamplerate) });
      this.aUg = new e(i, this.nSamplerate, this.hCU, this.hCX);
      if ((this.aUg != null) && (this.aUg.getState() == 0))
      {
        ad.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
        this.zfI.compareAndSet(false, true);
        this.aUg.release();
        this.aUg = null;
        AppMethodBeat.o(114817);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[] { localException.getMessage() });
      }
      ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
      if (this.aUg != null)
      {
        this.hCZ = false;
        dRU();
        AppMethodBeat.o(114817);
        return true;
      }
      this.hCZ = false;
      AppMethodBeat.o(114817);
    }
    return false;
  }
  
  /* Error */
  public final int z(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 518
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 293
    //   9: ldc_w 520
    //   12: invokestatic 408	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 522	com/tencent/mm/plugin/voip/model/c:context	Landroid/content/Context;
    //   20: aload_0
    //   21: getfield 120	com/tencent/mm/plugin/voip/model/c:zfH	I
    //   24: iconst_2
    //   25: if_icmpne +54 -> 79
    //   28: aload_0
    //   29: iconst_3
    //   30: putfield 102	com/tencent/mm/plugin/voip/model/c:hCU	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   38: aload_0
    //   39: getfield 102	com/tencent/mm/plugin/voip/model/c:hCU	I
    //   42: iconst_2
    //   43: invokestatic 474	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: putfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   49: aload_0
    //   50: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   53: bipush 254
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   62: iconst_m1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 187	com/tencent/mm/plugin/voip/model/c:zgf	I
    //   71: ldc_w 518
    //   74: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_0
    //   80: iconst_2
    //   81: putfield 102	com/tencent/mm/plugin/voip/model/c:hCU	I
    //   84: goto -51 -> 33
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   92: putfield 161	com/tencent/mm/plugin/voip/model/c:zfS	I
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 161	com/tencent/mm/plugin/voip/model/c:zfS	I
    //   100: aload_0
    //   101: getfield 171	com/tencent/mm/plugin/voip/model/c:zfX	I
    //   104: imul
    //   105: putfield 173	com/tencent/mm/plugin/voip/model/c:zfY	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   113: aload_0
    //   114: getfield 181	com/tencent/mm/plugin/voip/model/c:zgc	I
    //   117: imul
    //   118: putfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   121: aload_0
    //   122: getfield 161	com/tencent/mm/plugin/voip/model/c:zfS	I
    //   125: iconst_1
    //   126: ishr
    //   127: i2f
    //   128: aload_0
    //   129: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   132: i2f
    //   133: fdiv
    //   134: fstore_3
    //   135: invokestatic 527	com/tencent/mm/compatible/deviceinfo/m:WG	()I
    //   138: istore 4
    //   140: getstatic 236	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   143: getfield 530	com/tencent/mm/compatible/deviceinfo/b:fAj	I
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
    //   169: ldc_w 293
    //   172: ldc_w 532
    //   175: iload 4
    //   177: invokestatic 537	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   180: invokevirtual 541	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 542
    //   189: fload_3
    //   190: fmul
    //   191: ldc_w 543
    //   194: fcmpg
    //   195: iflt +10 -> 205
    //   198: aload_0
    //   199: getfield 191	com/tencent/mm/plugin/voip/model/c:lSY	I
    //   202: ifeq +6 -> 208
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +263 -> 473
    //   213: iconst_0
    //   214: istore 6
    //   216: aload_0
    //   217: iload 6
    //   219: putfield 98	com/tencent/mm/plugin/voip/model/c:zfz	Z
    //   222: aload_0
    //   223: iconst_0
    //   224: putfield 98	com/tencent/mm/plugin/voip/model/c:zfz	Z
    //   227: ldc_w 293
    //   230: new 341	java/lang/StringBuilder
    //   233: dup
    //   234: ldc_w 545
    //   237: invokespecial 346	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   244: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 479
    //   250: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: fload_3
    //   254: invokevirtual 482	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   257: ldc_w 547
    //   260: invokevirtual 406	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 98	com/tencent/mm/plugin/voip/model/c:zfz	Z
    //   267: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: iload_2
    //   278: invokespecial 288	com/tencent/mm/plugin/voip/model/c:rs	(Z)I
    //   281: istore 4
    //   283: aload_0
    //   284: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +20 -> 309
    //   292: aload_0
    //   293: getfield 133	com/tencent/mm/plugin/voip/model/c:zfI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: iconst_0
    //   297: iconst_1
    //   298: invokevirtual 304	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   301: pop
    //   302: aload_0
    //   303: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   306: invokevirtual 307	android/media/AudioTrack:release	()V
    //   309: aload_0
    //   310: new 505	com/tencent/mm/compatible/b/e
    //   313: dup
    //   314: iload 4
    //   316: aload_0
    //   317: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   320: aload_0
    //   321: getfield 102	com/tencent/mm/plugin/voip/model/c:hCU	I
    //   324: aload_0
    //   325: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   328: invokespecial 508	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   331: putfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   334: aload_0
    //   335: getfield 133	com/tencent/mm/plugin/voip/model/c:zfI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   338: iconst_1
    //   339: iconst_0
    //   340: invokevirtual 304	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   343: pop
    //   344: aload_0
    //   345: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   348: ifnull +13 -> 361
    //   351: aload_0
    //   352: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   355: invokevirtual 337	android/media/AudioTrack:getState	()I
    //   358: ifne +80 -> 438
    //   361: aload_0
    //   362: iconst_2
    //   363: putfield 187	com/tencent/mm/plugin/voip/model/c:zgf	I
    //   366: ldc_w 293
    //   369: ldc_w 549
    //   372: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   379: ifnull +20 -> 399
    //   382: aload_0
    //   383: getfield 133	com/tencent/mm/plugin/voip/model/c:zfI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   386: iconst_0
    //   387: iconst_1
    //   388: invokevirtual 304	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   396: invokevirtual 307	android/media/AudioTrack:release	()V
    //   399: iload 4
    //   401: ifne +105 -> 506
    //   404: aload_0
    //   405: new 505	com/tencent/mm/compatible/b/e
    //   408: dup
    //   409: iconst_3
    //   410: aload_0
    //   411: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   414: aload_0
    //   415: getfield 102	com/tencent/mm/plugin/voip/model/c:hCU	I
    //   418: aload_0
    //   419: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   422: invokespecial 508	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   425: putfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   428: aload_0
    //   429: getfield 133	com/tencent/mm/plugin/voip/model/c:zfI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_1
    //   433: iconst_0
    //   434: invokevirtual 304	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   442: ifnonnull +91 -> 533
    //   445: aload_0
    //   446: iconst_3
    //   447: putfield 187	com/tencent/mm/plugin/voip/model/c:zgf	I
    //   450: ldc_w 293
    //   453: ldc_w 551
    //   456: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: ldc_w 518
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
    //   480: ldc_w 293
    //   483: ldc_w 553
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload_1
    //   493: aastore
    //   494: invokestatic 555	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: aload_0
    //   498: bipush 6
    //   500: putfield 187	com/tencent/mm/plugin/voip/model/c:zgf	I
    //   503: goto -159 -> 344
    //   506: aload_0
    //   507: new 505	com/tencent/mm/compatible/b/e
    //   510: dup
    //   511: iconst_0
    //   512: aload_0
    //   513: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   516: aload_0
    //   517: getfield 102	com/tencent/mm/plugin/voip/model/c:hCU	I
    //   520: aload_0
    //   521: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   524: invokespecial 508	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   527: putfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   530: goto -102 -> 428
    //   533: aload_0
    //   534: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   537: invokevirtual 337	android/media/AudioTrack:getState	()I
    //   540: ifne +47 -> 587
    //   543: aload_0
    //   544: iconst_3
    //   545: putfield 187	com/tencent/mm/plugin/voip/model/c:zgf	I
    //   548: ldc_w 293
    //   551: ldc_w 557
    //   554: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 133	com/tencent/mm/plugin/voip/model/c:zfI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   561: iconst_0
    //   562: iconst_1
    //   563: invokevirtual 304	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   566: pop
    //   567: aload_0
    //   568: getfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   571: invokevirtual 307	android/media/AudioTrack:release	()V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 126	com/tencent/mm/plugin/voip/model/c:aUg	Landroid/media/AudioTrack;
    //   579: ldc_w 518
    //   582: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   585: iconst_m1
    //   586: ireturn
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   592: newarray byte
    //   594: putfield 108	com/tencent/mm/plugin/voip/model/c:zfC	[B
    //   597: aload_0
    //   598: getfield 108	com/tencent/mm/plugin/voip/model/c:zfC	[B
    //   601: ifnonnull +20 -> 621
    //   604: ldc_w 293
    //   607: ldc_w 559
    //   610: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc_w 518
    //   616: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: iconst_m1
    //   620: ireturn
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 124	com/tencent/mm/plugin/voip/model/c:hCY	I
    //   626: newarray byte
    //   628: putfield 114	com/tencent/mm/plugin/voip/model/c:zfF	[B
    //   631: aload_0
    //   632: getfield 114	com/tencent/mm/plugin/voip/model/c:zfF	[B
    //   635: ifnonnull +20 -> 655
    //   638: ldc_w 293
    //   641: ldc_w 561
    //   644: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: ldc_w 518
    //   650: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: iconst_m1
    //   654: ireturn
    //   655: aload_0
    //   656: getfield 98	com/tencent/mm/plugin/voip/model/c:zfz	Z
    //   659: ifeq +113 -> 772
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   667: putfield 106	com/tencent/mm/plugin/voip/model/c:zfB	I
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 106	com/tencent/mm/plugin/voip/model/c:zfB	I
    //   675: newarray byte
    //   677: putfield 110	com/tencent/mm/plugin/voip/model/c:zfD	[B
    //   680: aload_0
    //   681: getfield 110	com/tencent/mm/plugin/voip/model/c:zfD	[B
    //   684: ifnonnull +20 -> 704
    //   687: ldc_w 293
    //   690: ldc_w 563
    //   693: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: ldc_w 518
    //   699: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: iconst_m1
    //   703: ireturn
    //   704: aload_0
    //   705: aload_0
    //   706: getfield 106	com/tencent/mm/plugin/voip/model/c:zfB	I
    //   709: newarray byte
    //   711: putfield 112	com/tencent/mm/plugin/voip/model/c:zfE	[B
    //   714: aload_0
    //   715: getfield 112	com/tencent/mm/plugin/voip/model/c:zfE	[B
    //   718: ifnonnull +20 -> 738
    //   721: ldc_w 293
    //   724: ldc_w 565
    //   727: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: ldc_w 518
    //   733: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: iconst_m1
    //   737: ireturn
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 124	com/tencent/mm/plugin/voip/model/c:hCY	I
    //   743: newarray byte
    //   745: putfield 116	com/tencent/mm/plugin/voip/model/c:zfG	[B
    //   748: aload_0
    //   749: getfield 116	com/tencent/mm/plugin/voip/model/c:zfG	[B
    //   752: ifnonnull +20 -> 772
    //   755: ldc_w 293
    //   758: ldc_w 567
    //   761: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: ldc_w 518
    //   767: invokestatic 198	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_m1
    //   771: ireturn
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield 94	com/tencent/mm/plugin/voip/model/c:zfx	Z
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 96	com/tencent/mm/plugin/voip/model/c:zfy	Z
    //   782: ldc_w 293
    //   785: ldc_w 569
    //   788: iconst_5
    //   789: anewarray 4	java/lang/Object
    //   792: dup
    //   793: iconst_0
    //   794: invokestatic 487	com/tencent/mm/plugin/audio/c/a:getMode	()I
    //   797: invokestatic 493	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: dup
    //   802: iconst_1
    //   803: invokestatic 496	com/tencent/mm/plugin/audio/c/a:isSpeakerphoneOn	()Z
    //   806: invokestatic 501	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   809: aastore
    //   810: dup
    //   811: iconst_2
    //   812: iload 4
    //   814: invokestatic 493	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: dup
    //   819: iconst_3
    //   820: aload_0
    //   821: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   824: invokestatic 493	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: aastore
    //   828: dup
    //   829: iconst_4
    //   830: aload_0
    //   831: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   834: invokestatic 493	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: invokestatic 503	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: aload_0
    //   842: getfield 104	com/tencent/mm/plugin/voip/model/c:hCX	I
    //   845: sipush 1000
    //   848: imul
    //   849: aload_0
    //   850: getfield 118	com/tencent/mm/plugin/voip/model/c:nSamplerate	I
    //   853: iconst_2
    //   854: imul
    //   855: idiv
    //   856: istore 4
    //   858: ldc_w 518
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
  
  final class a
    extends TimerTask
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(114814);
      System.currentTimeMillis();
      if ((c.a(c.this) == 1) && (c.this.zfx == true))
      {
        System.currentTimeMillis();
        if ((c.b(c.this) + c.this.hCY < c.c(c.this)) && (c.d(c.this) == 0) && (c.this.zfJ != null))
        {
          c.a(c.this, 1);
          int i = c.this.zfJ.Q(c.e(c.this), c.this.hCY);
          c.a(c.this, 0);
          if (i < 0)
          {
            ad.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(i)));
            AppMethodBeat.o(114814);
            return;
          }
          synchronized (c.f(c.this))
          {
            System.arraycopy(c.e(c.this), 0, c.g(c.this), c.b(c.this), c.this.hCY);
            c.b(c.this, c.b(c.this) + c.this.hCY);
            c.c(c.this, c.h(c.this) + (c.this.hCY >> 1));
            AppMethodBeat.o(114814);
            return;
          }
        }
      }
      AppMethodBeat.o(114814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.c
 * JD-Core Version:    0.7.0.1
 */