package com.tencent.mm.plugin.music.b;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
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
  int bxy;
  String cTT;
  String cTr;
  int cUL;
  protected com.tencent.mm.aj.b dbK;
  long fXw;
  boolean gTe;
  ap kQO;
  int oTe;
  boolean rdQ;
  long tUA;
  private PlayerListenerCallback tUB;
  com.tencent.mm.plugin.music.b.a.d tUb;
  CommonPlayer tUs;
  private com.tencent.mm.aj.d tUt;
  boolean tUu;
  a tUv;
  private com.tencent.mm.plugin.music.g.a.b tUw;
  private long tUy;
  boolean tUz;
  
  public h()
  {
    AppMethodBeat.i(137114);
    this.cTr = "";
    this.tUu = false;
    this.gTe = false;
    this.cTT = "";
    this.bxy = 0;
    this.oTe = 0;
    this.cUL = 0;
    this.autoPlay = false;
    this.tUy = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.tUz = false;
    this.tUA = 0L;
    this.fXw = 0L;
    this.tUB = new PlayerListenerCallback()
    {
      com.tencent.mm.aj.b tUC = null;
      
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
        ad.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), h.this.cTr });
        if (this.tUC == null)
        {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
          AppMethodBeat.o(137102);
          return;
        }
        boolean bool = ay.isNetworkConnected(aj.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (h.this.bxy > 0)
        {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(h.this.bxy) });
          AppMethodBeat.o(137102);
          return;
        }
        h.this.rdQ = false;
        paramAnonymousBaseMediaPlayer = h.this;
        paramAnonymousBaseMediaPlayer.bxy += 1;
        h.this.oTe = paramAnonymousInt2;
        h.this.fXw = System.currentTimeMillis();
        h.a(h.this, paramAnonymousInt2);
        if (h.this.cTr.equalsIgnoreCase(this.tUC.cTr))
        {
          h.this.stopPlay();
          aq.f(new h.1.2(this));
        }
        h.this.Hp(paramAnonymousInt2);
        if (h.this.tUv != null)
        {
          h.this.tUv.isStop = true;
          h.this.tUv = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ad.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
          com.tencent.mm.plugin.music.cache.g.aiz(h.this.cTT);
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
        h.this.kQO.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137097);
            ad.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (h.this.cUL != 0)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(h.this.cUL) });
              h.this.cUL = 0;
              h.1.a(h.1.this);
              AppMethodBeat.o(137097);
              return;
            }
            h.1 local1 = h.1.this;
            ad.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
            local1.tUD.cTX();
            if (local1.tUD.azF())
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
              local1.tUD.cTU();
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
        h.this.kQO.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137099);
            String str = h.this.cTr;
            ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            if (paramAnonymousInt == 3)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
              h.1.b(h.1.this);
              h.this.tUA = System.currentTimeMillis();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 2)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
              ad.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.tUA) });
              h.1.a(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 4)
            {
              ad.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
              ad.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.tUA) });
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
              h.1.cUl();
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
    this.cTr = e.cTA();
    com.tencent.mm.plugin.music.f.a.a.cVI();
    if (android.support.v4.content.b.checkSelfPermission(aj.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
      ad.e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
    }
    for (;;)
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.kQO = new ap(Looper.myLooper());
      AppMethodBeat.o(137114);
      return;
      this.tUo = new bc();
      this.tUo.iG(aj.getContext());
      this.tUo.a(new g.1(this));
    }
  }
  
  private void Hq(int paramInt)
  {
    AppMethodBeat.i(137139);
    if (this.tUb != null) {
      this.tUb.gi(this.dbK.fromScene, paramInt);
    }
    AppMethodBeat.o(137139);
  }
  
  private void cUa()
  {
    AppMethodBeat.i(137118);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    if ((!TextUtils.isEmpty(this.dbK.filePath)) && (this.dbK.gTb == null))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.dbK.filePath });
      if (this.tUs == null) {
        this.tUs = new CommonPlayer(this.tUB);
      }
      this.tUs.reset();
    }
    for (;;)
    {
      try
      {
        this.tUs.setDataSource(this.dbK.filePath);
        this.tUs.prepare();
        float f = 0.0F;
        if (this.dbK != null) {
          f = (float)this.dbK.gSR;
        }
        if (this.tUs == null) {
          break label613;
        }
        if ((f < 0.5F) || (f > 2.0F)) {
          break;
        }
        ad.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f) });
        this.tUs.setSpeed(f);
        AppMethodBeat.o(137118);
        return;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer exception", new Object[0]);
        Hp(501);
        Hq(501);
        continue;
      }
      if ((!TextUtils.isEmpty(this.dbK.filePath)) && (this.dbK.gTb != null))
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.dbK.filePath });
        if (this.tUs == null) {
          this.tUs = new CommonPlayer(this.tUB);
        }
        this.tUs.reset();
        com.tencent.mm.plugin.music.g.b localb = new com.tencent.mm.plugin.music.g.b(this.dbK.gTb);
        try
        {
          this.tUs.setDataSource(localb);
          this.tUs.prepare();
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException2.getMessage());
          ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer", new Object[0]);
          Hp(501);
          Hq(501);
        }
      }
      else
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.dbK.cUD });
        cUb();
        try
        {
          URL localURL = new URL(this.cTT);
          if (localURL == null)
          {
            ad.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
            Hp(500);
            Hq(500);
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
          if (this.tUs == null) {
            this.tUs = new CommonPlayer(this.tUB);
          }
          this.tUs.reset();
          if (this.tUw == null) {
            this.tUw = new com.tencent.mm.plugin.music.g.a.b();
          }
          this.tUw.hG(this.cTT, this.dbK.gTa);
          try
          {
            this.tUs.setDataSource(this.tUw, Uri.parse(localObject.toString()));
            this.tUs.prepare();
          }
          catch (Exception localException4)
          {
            ad.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException4.getMessage());
            ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
            Hp(501);
            Hq(501);
          }
        }
      }
    }
    this.tUs.setSpeed(1.0F);
    label613:
    AppMethodBeat.o(137118);
  }
  
  private void cUb()
  {
    AppMethodBeat.i(137119);
    this.cTT = this.dbK.cUD;
    if (com.tencent.mm.plugin.music.h.e.aiW(this.cTT)) {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.cTT });
      com.tencent.mm.plugin.music.cache.g.ait(this.cTT);
      com.tencent.mm.plugin.music.cache.g.bk(this.cTT, bool);
      AppMethodBeat.o(137119);
      return;
    }
  }
  
  private void cUh()
  {
    AppMethodBeat.i(137134);
    try
    {
      if (this.tUs != null)
      {
        this.tUs.setVolume(0.0F, 0.0F);
        this.tUs.stop();
      }
      if (this.tUv != null)
      {
        this.tUv.isStop = true;
        this.tUv = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        Hp(504);
        Hq(504);
      }
    }
    this.rdQ = false;
    this.tUu = true;
    this.fXw = System.currentTimeMillis();
    AppMethodBeat.o(137134);
  }
  
  public final void aik(String paramString)
  {
    AppMethodBeat.i(137115);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.cTr = paramString;
    AppMethodBeat.o(137115);
  }
  
  public final boolean azF()
  {
    AppMethodBeat.i(137123);
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 4)
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
  
  public final boolean azH()
  {
    AppMethodBeat.i(137129);
    if ((this.rdQ) && (!cUd()))
    {
      AppMethodBeat.o(137129);
      return true;
    }
    AppMethodBeat.o(137129);
    return false;
  }
  
  public final void b(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(137116);
    this.dbK = paramb;
    this.cUL = paramb.cUL;
    this.autoPlay = paramb.gSN;
    if ((this.tUs != null) && (azF()))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.cTr, this.cTT, Double.valueOf(this.dbK.gSQ) });
      this.tUs.setVolume((float)this.dbK.gSQ, (float)this.dbK.gSQ);
      if (this.dbK.gSR > 0.0D)
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.dbK.gSR) });
        this.tUs.setSpeed((float)this.dbK.gSR);
        AppMethodBeat.o(137116);
        return;
      }
      this.tUs.setSpeed(1.0F);
    }
    AppMethodBeat.o(137116);
  }
  
  public final boolean ben()
  {
    AppMethodBeat.i(137125);
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 2)
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
  
  public final boolean cTP()
  {
    return true;
  }
  
  public final String cTR()
  {
    return this.cTr;
  }
  
  public final void cUc()
  {
    AppMethodBeat.i(137121);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137121);
  }
  
  public final boolean cUd()
  {
    AppMethodBeat.i(137124);
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 3)
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
  
  public final void cUe()
  {
    AppMethodBeat.i(137130);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.gTe = true;
    this.tUu = true;
    AppMethodBeat.o(137130);
  }
  
  public final void cUf()
  {
    AppMethodBeat.i(137131);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.gTe = true;
    cUh();
    AppMethodBeat.o(137131);
  }
  
  public final void cUg()
  {
    AppMethodBeat.i(137132);
    this.gTe = false;
    this.tUu = true;
    cTW();
    this.fXw = System.currentTimeMillis();
    AppMethodBeat.o(137132);
  }
  
  public final int cUi()
  {
    AppMethodBeat.i(137135);
    if (this.tUs != null)
    {
      int i = (int)this.tUs.getCurrentPosition();
      AppMethodBeat.o(137135);
      return i;
    }
    AppMethodBeat.o(137135);
    return -1;
  }
  
  public final com.tencent.mm.aj.d cUj()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137138);
    if (this.tUt == null) {
      this.tUt = new com.tencent.mm.aj.d();
    }
    int k = getDuration();
    int m = cUi();
    boolean bool2 = azF();
    if (this.tUs != null) {}
    for (int j = this.tUs.getBufferedPercentage();; j = 0)
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
      this.tUt.dbJ = m;
      this.tUt.duration = k;
      com.tencent.mm.aj.d locald = this.tUt;
      if (bool2) {}
      for (;;)
      {
        locald.qM = bool1;
        this.tUt.gTe = this.gTe;
        this.tUt.gTf = (j * k / 100);
        if (this.dbK == null) {
          break;
        }
        this.tUt.cUL = this.dbK.gSM;
        this.tUt.cTn = this.dbK.cUD;
        this.tUt.gSZ = this.dbK.gSZ;
        locald = this.tUt;
        AppMethodBeat.o(137138);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137138);
      return null;
    }
  }
  
  public final void cUk()
  {
    AppMethodBeat.i(137141);
    if ((this.cTr.equalsIgnoreCase(this.dbK.cTr)) && (this.tUs != null) && (azF()))
    {
      int i = (int)this.tUs.getCurrentPosition();
      int j = this.tUs.getDuration();
      if ((i > 0) && (j > 0) && (this.tUq != null)) {
        this.tUq.eS(i, j);
      }
    }
    AppMethodBeat.o(137141);
  }
  
  public final String getAppId()
  {
    if (this.dbK != null) {
      return this.dbK.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137136);
    if (this.tUs != null)
    {
      int i = this.tUs.getDuration();
      AppMethodBeat.o(137136);
      return i;
    }
    AppMethodBeat.o(137136);
    return -1;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137127);
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 7)
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
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 5)
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
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 6)
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
      cTZ();
      AppMethodBeat.o(137117);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.tUy;
    if ((this.dbK != null) && (this.dbK.e(paramb)) && (l2 <= 100L))
    {
      this.dbK = paramb;
      this.cUL = paramb.cUL;
      this.autoPlay = paramb.gSN;
      ad.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.cTT, Long.valueOf(l2) });
      AppMethodBeat.o(137117);
      return;
    }
    this.tUb = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.tUb != null) {
      this.tUb.Hs(paramb.fromScene);
    }
    this.tUy = l1;
    this.dbK = paramb;
    ad.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.dbK.fromScene), this.cTr });
    if ((this.tUs != null) && (azF())) {
      this.tUs.stop();
    }
    this.bxy = 0;
    this.cUL = paramb.cUL;
    this.autoPlay = paramb.gSN;
    this.audioType = null;
    this.tUz = false;
    this.gTe = false;
    this.tUu = false;
    cUa();
    AppMethodBeat.o(137117);
  }
  
  public final boolean ox(int paramInt)
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
    if (this.tUs != null)
    {
      ad.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      v localv = new v();
      localv.dbN.action = 10;
      localv.dbN.state = "seeking";
      localv.dbN.cTr = cTR();
      localv.dbN.appId = getAppId();
      com.tencent.mm.sdk.b.a.ESL.a(localv, Looper.getMainLooper());
      this.tUs.seekTo(paramInt);
    }
    AppMethodBeat.o(137137);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137120);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.cTr });
    this.tUu = true;
    if ((this.tUs != null) && (azF())) {
      try
      {
        ad.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.tUs.pause();
        AppMethodBeat.o(137120);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        Hp(503);
        Hq(503);
        AppMethodBeat.o(137120);
        return;
      }
    }
    if ((this.tUs != null) && (isCompleted()))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.rdQ = false;
    }
    AppMethodBeat.o(137120);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137140);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.tUh = null;
    if (this.tUs != null)
    {
      this.tUs.release();
      this.tUs = null;
    }
    cTN();
    AppMethodBeat.o(137140);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137122);
    this.bxy = 0;
    boolean bool1 = cUd();
    boolean bool2 = azF();
    this.tUu = false;
    this.gTe = false;
    ad.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.rdQ), this.cTr });
    if ((this.tUs != null) && (!ben()) && (!bool1) && (!bool2) && (!this.rdQ))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.cUL = 0;
      this.autoPlay = true;
      cUa();
      if (this.tUb != null)
      {
        this.tUb.Hs(this.dbK.fromScene);
        AppMethodBeat.o(137122);
      }
    }
    else if ((this.tUs != null) && ((isPaused()) || (ben())) && (!bool2))
    {
      ad.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.tUs.setVolume((float)this.dbK.gSQ, (float)this.dbK.gSQ);
      this.tUs.start();
      this.rdQ = true;
      AppMethodBeat.o(137122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        Hp(502);
        Hq(502);
      }
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137133);
    ad.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.gTe = false;
    cUh();
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
            if ((h.this.tUs != null) && (h.this.azF())) {
              h.this.cUk();
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