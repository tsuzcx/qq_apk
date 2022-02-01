package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public final class h
  extends g
{
  AudioFormat.AudioType audioType;
  boolean autoPlay;
  int bFv;
  String dcG;
  String dce;
  int ddx;
  protected com.tencent.mm.aj.b dkB;
  long gvN;
  boolean hLV;
  ap lRx;
  int pZU;
  a wiA;
  private com.tencent.mm.plugin.music.g.a.b wiB;
  private long wiC;
  boolean wiD;
  long wiE;
  private PlayerListenerCallback wiF;
  com.tencent.mm.plugin.music.b.a.d wif;
  CommonPlayer wiw;
  private com.tencent.mm.aj.d wix;
  boolean wiy;
  boolean wiz;
  
  public h()
  {
    AppMethodBeat.i(137114);
    this.dce = "";
    this.wiz = false;
    this.hLV = false;
    this.dcG = "";
    this.bFv = 0;
    this.pZU = 0;
    this.ddx = 0;
    this.autoPlay = false;
    this.wiC = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.wiD = false;
    this.wiE = 0L;
    this.gvN = 0L;
    this.wiF = new PlayerListenerCallback()
    {
      com.tencent.mm.aj.b wiG = null;
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137100);
        ad.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
        AppMethodBeat.o(137100);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137102);
        ad.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), h.this.dce });
        if (this.wiG == null)
        {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
          AppMethodBeat.o(137102);
          return;
        }
        boolean bool = ay.isNetworkConnected(aj.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (h.this.bFv > 0)
        {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(h.this.bFv) });
          AppMethodBeat.o(137102);
          return;
        }
        h.this.wiy = false;
        paramAnonymousBaseMediaPlayer = h.this;
        paramAnonymousBaseMediaPlayer.bFv += 1;
        h.this.pZU = paramAnonymousInt2;
        h.this.gvN = System.currentTimeMillis();
        h.a(h.this, paramAnonymousInt2);
        if (h.this.dce.equalsIgnoreCase(this.wiG.dce))
        {
          h.this.stopPlay();
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137098);
              if (com.tencent.mm.plugin.music.cache.e.dsB()) {}
              for (boolean bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dsu();; bool = false)
              {
                if (bool) {
                  Toast.makeText(aj.getContext(), aj.getContext().getString(2131761469), 0).show();
                }
                AppMethodBeat.o(137098);
                return;
                ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
              }
            }
          });
        }
        h.this.KQ(paramAnonymousInt2);
        if (h.this.wiA != null)
        {
          h.this.wiA.isStop = true;
          h.this.wiA = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ad.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
          com.tencent.mm.plugin.music.cache.g.ast(h.this.dcG);
        }
        AppMethodBeat.o(137102);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137103);
        ad.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
        AppMethodBeat.o(137103);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137101);
        h.this.lRx.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137097);
            ad.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (h.this.ddx != 0)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(h.this.ddx) });
              h.this.ddx = 0;
              h.1.a(h.1.this);
              AppMethodBeat.o(137097);
              return;
            }
            h.1 local1 = h.1.this;
            ad.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
            local1.wiH.drS();
            if (local1.wiH.aJG())
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
              local1.wiH.drP();
            }
            AppMethodBeat.o(137097);
          }
        });
        AppMethodBeat.o(137101);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137105);
        ad.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
        AppMethodBeat.o(137105);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137104);
        h.this.lRx.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137099);
            String str = h.this.dce;
            ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            if (paramAnonymousInt == 3)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
              h.1.b(h.1.this);
              h.this.wiE = System.currentTimeMillis();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 2)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
              ad.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.wiE) });
              h.1.a(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 4)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
              ad.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.wiE) });
              h.1.c(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 5)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
              h.1.d(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 6)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
              h.1.e(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 7)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
              h.1.f(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 8)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
              h.1.dsf();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 9) {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
            }
            AppMethodBeat.o(137099);
          }
        });
        AppMethodBeat.o(137104);
      }
    };
    this.dce = e.drx();
    com.tencent.mm.plugin.music.f.a.a.dtA();
    if (android.support.v4.content.b.checkSelfPermission(aj.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
      ad.e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
    }
    for (;;)
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.lRx = new ap(Looper.myLooper());
      AppMethodBeat.o(137114);
      return;
      this.wis = new bc();
      this.wis.jb(aj.getContext());
      this.wis.a(new g.1(this));
    }
  }
  
  private void KR(int paramInt)
  {
    AppMethodBeat.i(137139);
    if (this.wif != null) {
      this.wif.gH(this.dkB.fromScene, paramInt);
    }
    AppMethodBeat.o(137139);
  }
  
  private void drV()
  {
    AppMethodBeat.i(137118);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    if ((!TextUtils.isEmpty(this.dkB.filePath)) && (this.dkB.hLS == null))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.dkB.filePath });
      if (this.wiw == null) {
        this.wiw = new CommonPlayer(this.wiF);
      }
      this.wiw.reset();
    }
    for (;;)
    {
      try
      {
        this.wiw.setDataSource(this.dkB.filePath);
        this.wiw.prepare();
        float f = 0.0F;
        if (this.dkB != null) {
          f = (float)this.dkB.hLI;
        }
        if (this.wiw == null) {
          break label613;
        }
        if ((f < 0.5F) || (f > 2.0F)) {
          break;
        }
        ad.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f) });
        this.wiw.setSpeed(f);
        AppMethodBeat.o(137118);
        return;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer exception", new Object[0]);
        KQ(501);
        KR(501);
        continue;
      }
      if ((!TextUtils.isEmpty(this.dkB.filePath)) && (this.dkB.hLS != null))
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.dkB.filePath });
        if (this.wiw == null) {
          this.wiw = new CommonPlayer(this.wiF);
        }
        this.wiw.reset();
        com.tencent.mm.plugin.music.g.b localb = new com.tencent.mm.plugin.music.g.b(this.dkB.hLS);
        try
        {
          this.wiw.setDataSource(localb);
          this.wiw.prepare();
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException2.getMessage());
          ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer", new Object[0]);
          KQ(501);
          KR(501);
        }
      }
      else
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.dkB.ddp });
        drW();
        try
        {
          URL localURL = new URL(this.dcG);
          if (localURL == null)
          {
            ad.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
            KQ(500);
            KR(500);
            AppMethodBeat.o(137118);
            return;
          }
        }
        catch (Exception localException3)
        {
          Object localObject;
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
            localObject = null;
          }
          if (this.wiw == null) {
            this.wiw = new CommonPlayer(this.wiF);
          }
          this.wiw.reset();
          if (this.wiB == null) {
            this.wiB = new com.tencent.mm.plugin.music.g.a.b();
          }
          this.wiB.ik(this.dcG, this.dkB.hLR);
          try
          {
            this.wiw.setDataSource(this.wiB, Uri.parse(localObject.toString()));
            this.wiw.prepare();
          }
          catch (Exception localException4)
          {
            ad.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException4.getMessage());
            ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
            KQ(501);
            KR(501);
          }
        }
      }
    }
    this.wiw.setSpeed(1.0F);
    label613:
    AppMethodBeat.o(137118);
  }
  
  private void drW()
  {
    AppMethodBeat.i(137119);
    this.dcG = this.dkB.ddp;
    if (com.tencent.mm.plugin.music.h.e.asR(this.dcG)) {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.dcG });
      com.tencent.mm.plugin.music.cache.g.asn(this.dcG);
      com.tencent.mm.plugin.music.cache.g.by(this.dcG, bool);
      AppMethodBeat.o(137119);
      return;
    }
  }
  
  private void dsb()
  {
    AppMethodBeat.i(137134);
    try
    {
      if (this.wiw != null)
      {
        this.wiw.setVolume(0.0F, 0.0F);
        this.wiw.stop();
      }
      if (this.wiA != null)
      {
        this.wiA.isStop = true;
        this.wiA = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        KQ(504);
        KR(504);
      }
    }
    this.wiy = false;
    this.wiz = true;
    this.gvN = System.currentTimeMillis();
    AppMethodBeat.o(137134);
  }
  
  public final void a(d.a parama) {}
  
  public final boolean aJG()
  {
    AppMethodBeat.i(137123);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 4)
      {
        AppMethodBeat.o(137123);
        return true;
      }
      AppMethodBeat.o(137123);
      return false;
    }
    AppMethodBeat.o(137123);
    return false;
  }
  
  public final boolean aJI()
  {
    AppMethodBeat.i(137129);
    if ((this.wiy) && (!cMm()))
    {
      AppMethodBeat.o(137129);
      return true;
    }
    AppMethodBeat.o(137129);
    return false;
  }
  
  public final void ase(String paramString)
  {
    AppMethodBeat.i(137115);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.dce = paramString;
    AppMethodBeat.o(137115);
  }
  
  public final void b(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137116);
    this.dkB = paramb;
    this.ddx = paramb.ddx;
    this.autoPlay = paramb.hLF;
    if ((this.wiw != null) && (aJG()))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.dce, this.dcG, Double.valueOf(this.dkB.hLH) });
      this.wiw.setVolume((float)this.dkB.hLH, (float)this.dkB.hLH);
      if (this.dkB.hLI > 0.0D)
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.dkB.hLI) });
        this.wiw.setSpeed((float)this.dkB.hLI);
        AppMethodBeat.o(137116);
        return;
      }
      this.wiw.setSpeed(1.0F);
    }
    AppMethodBeat.o(137116);
  }
  
  public final void b(d.a parama) {}
  
  public final boolean boS()
  {
    AppMethodBeat.i(137125);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 2)
      {
        AppMethodBeat.o(137125);
        return true;
      }
      AppMethodBeat.o(137125);
      return false;
    }
    AppMethodBeat.o(137125);
    return false;
  }
  
  public final boolean cMm()
  {
    AppMethodBeat.i(137124);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 3)
      {
        AppMethodBeat.o(137124);
        return true;
      }
      AppMethodBeat.o(137124);
      return false;
    }
    AppMethodBeat.o(137124);
    return false;
  }
  
  public final boolean drK()
  {
    return true;
  }
  
  public final String drM()
  {
    return this.dce;
  }
  
  public final void drX()
  {
    AppMethodBeat.i(137121);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137121);
  }
  
  public final void drY()
  {
    AppMethodBeat.i(137130);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.hLV = true;
    this.wiz = true;
    AppMethodBeat.o(137130);
  }
  
  public final void drZ()
  {
    AppMethodBeat.i(137131);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.hLV = true;
    dsb();
    AppMethodBeat.o(137131);
  }
  
  public final void dsa()
  {
    AppMethodBeat.i(137132);
    this.hLV = false;
    this.wiz = true;
    drR();
    this.gvN = System.currentTimeMillis();
    AppMethodBeat.o(137132);
  }
  
  public final int dsc()
  {
    AppMethodBeat.i(137135);
    if (this.wiw != null)
    {
      int i = (int)this.wiw.getCurrentPosition();
      AppMethodBeat.o(137135);
      return i;
    }
    AppMethodBeat.o(137135);
    return -1;
  }
  
  public final com.tencent.mm.aj.d dsd()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137138);
    if (this.wix == null) {
      this.wix = new com.tencent.mm.aj.d();
    }
    int k = getDuration();
    int m = dsc();
    boolean bool2 = aJG();
    if (this.wiw != null) {}
    for (int j = this.wiw.getBufferedPercentage();; j = 0)
    {
      int i;
      if (j >= 0)
      {
        i = j;
        if (j <= 100) {}
      }
      else
      {
        i = 0;
      }
      j = i;
      if (i < 0) {
        j = 0;
      }
      this.wix.dkA = m;
      this.wix.duration = k;
      com.tencent.mm.aj.d locald = this.wix;
      if (bool2) {}
      for (;;)
      {
        locald.tG = bool1;
        this.wix.hLV = this.hLV;
        this.wix.hLW = (j * k / 100);
        if (this.dkB == null) {
          break;
        }
        this.wix.ddx = this.dkB.hLE;
        this.wix.dca = this.dkB.ddp;
        this.wix.hLQ = this.dkB.hLQ;
        locald = this.wix;
        AppMethodBeat.o(137138);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137138);
      return null;
    }
  }
  
  public final void dse()
  {
    AppMethodBeat.i(137141);
    if ((this.dce.equalsIgnoreCase(this.dkB.dce)) && (this.wiw != null) && (aJG()))
    {
      int i = (int)this.wiw.getCurrentPosition();
      int j = this.wiw.getDuration();
      if ((i > 0) && (j > 0) && (this.wiu != null)) {
        this.wiu.eZ(i, j);
      }
    }
    AppMethodBeat.o(137141);
  }
  
  public final String getAppId()
  {
    if (this.dkB != null) {
      return this.dkB.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137136);
    if (this.wiw != null)
    {
      int i = this.wiw.getDuration();
      AppMethodBeat.o(137136);
      return i;
    }
    AppMethodBeat.o(137136);
    return -1;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137127);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 7)
      {
        AppMethodBeat.o(137127);
        return true;
      }
      AppMethodBeat.o(137127);
      return false;
    }
    AppMethodBeat.o(137127);
    return false;
  }
  
  public final boolean isPaused()
  {
    AppMethodBeat.i(137126);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 5)
      {
        AppMethodBeat.o(137126);
        return true;
      }
      AppMethodBeat.o(137126);
      return false;
    }
    AppMethodBeat.o(137126);
    return false;
  }
  
  public final boolean isStopped()
  {
    AppMethodBeat.i(137128);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 6)
      {
        AppMethodBeat.o(137128);
        return true;
      }
      AppMethodBeat.o(137128);
      return false;
    }
    AppMethodBeat.o(137128);
    return false;
  }
  
  public final void l(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137117);
    if (paramb == null)
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      drU();
      AppMethodBeat.o(137117);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.wiC;
    if ((this.dkB != null) && (this.dkB.e(paramb)) && (l2 <= 100L))
    {
      this.dkB = paramb;
      this.ddx = paramb.ddx;
      this.autoPlay = paramb.hLF;
      ad.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.dcG, Long.valueOf(l2) });
      AppMethodBeat.o(137117);
      return;
    }
    this.wif = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wif != null) {
      this.wif.KT(paramb.fromScene);
    }
    this.wiC = l1;
    this.dkB = paramb;
    ad.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.dkB.fromScene), this.dce });
    if ((this.wiw != null) && (aJG())) {
      this.wiw.stop();
    }
    this.bFv = 0;
    this.ddx = paramb.ddx;
    this.autoPlay = paramb.hLF;
    this.audioType = null;
    this.wiD = false;
    this.hLV = false;
    this.wiz = false;
    drV();
    AppMethodBeat.o(137117);
  }
  
  public final boolean pO(int paramInt)
  {
    AppMethodBeat.i(137137);
    int i = getDuration();
    ad.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i < 0)
    {
      ad.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137137);
      return false;
    }
    if (paramInt > i)
    {
      ad.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137137);
      return false;
    }
    if (this.wiw != null)
    {
      ad.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      w localw = new w();
      localw.dkE.action = 10;
      localw.dkE.state = "seeking";
      localw.dkE.dce = drM();
      localw.dkE.appId = getAppId();
      com.tencent.mm.sdk.b.a.IbL.a(localw, Looper.getMainLooper());
      this.wiw.seekTo(paramInt);
    }
    AppMethodBeat.o(137137);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137120);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.dce });
    this.wiz = true;
    if ((this.wiw != null) && (aJG())) {
      try
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.wiw.pause();
        AppMethodBeat.o(137120);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        KQ(503);
        KR(503);
        AppMethodBeat.o(137120);
        return;
      }
    }
    if ((this.wiw != null) && (isCompleted()))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.wiy = false;
    }
    AppMethodBeat.o(137120);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137140);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.wil = null;
    if (this.wiw != null)
    {
      this.wiw.release();
      this.wiw = null;
    }
    drI();
    AppMethodBeat.o(137140);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137122);
    this.bFv = 0;
    boolean bool1 = cMm();
    boolean bool2 = aJG();
    this.wiz = false;
    this.hLV = false;
    ad.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.wiy), this.dce });
    if ((this.wiw != null) && (!boS()) && (!bool1) && (!bool2) && (!this.wiy))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.ddx = 0;
      this.autoPlay = true;
      drV();
      if (this.wif != null)
      {
        this.wif.KT(this.dkB.fromScene);
        AppMethodBeat.o(137122);
      }
    }
    else if ((this.wiw != null) && ((isPaused()) || (boS())) && (!bool2))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.wiw.setVolume((float)this.dkB.hLH, (float)this.dkB.hLH);
      this.wiw.start();
      this.wiy = true;
      AppMethodBeat.o(137122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        KQ(502);
        KR(502);
      }
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137133);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.hLV = false;
    dsb();
    AppMethodBeat.o(137133);
  }
  
  final class a
    implements Runnable
  {
    boolean isStop = true;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(137113);
      ad.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((h.this.wiw != null) && (h.this.aJG())) {
              h.this.dse();
            }
            try
            {
              Thread.sleep(200L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + localException.getMessage());
            }
          }
        }
      }
      AppMethodBeat.o(137113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h
 * JD-Core Version:    0.7.0.1
 */