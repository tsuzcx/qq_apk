package com.tencent.mm.plugin.music.b;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bd;
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
  String ddI;
  String ddg;
  int dez;
  protected com.tencent.mm.ai.b dlD;
  long gyu;
  boolean hOO;
  aq lVY;
  int qgz;
  com.tencent.mm.plugin.music.b.a.d wxJ;
  CommonPlayer wyb;
  private com.tencent.mm.ai.d wyc;
  boolean wyd;
  boolean wye;
  a wyf;
  private com.tencent.mm.plugin.music.g.a.b wyg;
  private long wyh;
  boolean wyi;
  long wyj;
  private PlayerListenerCallback wyk;
  
  public h()
  {
    AppMethodBeat.i(137114);
    this.ddg = "";
    this.wye = false;
    this.hOO = false;
    this.ddI = "";
    this.bFv = 0;
    this.qgz = 0;
    this.dez = 0;
    this.autoPlay = false;
    this.wyh = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.wyi = false;
    this.wyj = 0L;
    this.gyu = 0L;
    this.wyk = new PlayerListenerCallback()
    {
      com.tencent.mm.ai.b wyl = null;
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137100);
        ae.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
        AppMethodBeat.o(137100);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137102);
        ae.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), h.this.ddg });
        if (this.wyl == null)
        {
          ae.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
          AppMethodBeat.o(137102);
          return;
        }
        boolean bool = az.isNetworkConnected(ak.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ae.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (h.this.bFv > 0)
        {
          ae.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(h.this.bFv) });
          AppMethodBeat.o(137102);
          return;
        }
        h.this.wyd = false;
        paramAnonymousBaseMediaPlayer = h.this;
        paramAnonymousBaseMediaPlayer.bFv += 1;
        h.this.qgz = paramAnonymousInt2;
        h.this.gyu = System.currentTimeMillis();
        h.a(h.this, paramAnonymousInt2);
        if (h.this.ddg.equalsIgnoreCase(this.wyl.ddg))
        {
          h.this.stopPlay();
          ar.f(new h.1.2(this));
        }
        h.this.Lv(paramAnonymousInt2);
        if (h.this.wyf != null)
        {
          h.this.wyf.isStop = true;
          h.this.wyf = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ae.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
          com.tencent.mm.plugin.music.cache.g.atH(h.this.ddI);
        }
        AppMethodBeat.o(137102);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137103);
        ae.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
        AppMethodBeat.o(137103);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137101);
        h.this.lVY.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137097);
            ae.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (h.this.dez != 0)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(h.this.dez) });
              h.this.dez = 0;
              h.1.a(h.1.this);
              AppMethodBeat.o(137097);
              return;
            }
            h.1 local1 = h.1.this;
            ae.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
            local1.wym.dvg();
            if (local1.wym.aJZ())
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
              local1.wym.dvd();
            }
            AppMethodBeat.o(137097);
          }
        });
        AppMethodBeat.o(137101);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137105);
        ae.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
        AppMethodBeat.o(137105);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137104);
        h.this.lVY.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137099);
            String str = h.this.ddg;
            ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            if (paramAnonymousInt == 3)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
              h.1.b(h.1.this);
              h.this.wyj = System.currentTimeMillis();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 2)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
              ae.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.wyj) });
              h.1.a(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 4)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
              ae.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.wyj) });
              h.1.c(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 5)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
              h.1.d(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 6)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
              h.1.e(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 7)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
              h.1.f(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 8)
            {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
              h.1.dvu();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 9) {
              ae.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
            }
            AppMethodBeat.o(137099);
          }
        });
        AppMethodBeat.o(137104);
      }
    };
    this.ddg = e.duJ();
    com.tencent.mm.plugin.music.f.a.a.dwP();
    if (android.support.v4.content.b.checkSelfPermission(ak.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
      ae.e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
    }
    for (;;)
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.lVY = new aq(Looper.myLooper());
      AppMethodBeat.o(137114);
      return;
      this.wxX = new bd();
      this.wxX.jg(ak.getContext());
      this.wxX.a(new g.1(this));
    }
  }
  
  private void Lw(int paramInt)
  {
    AppMethodBeat.i(137139);
    if (this.wxJ != null) {
      this.wxJ.gI(this.dlD.fromScene, paramInt);
    }
    AppMethodBeat.o(137139);
  }
  
  private void dvj()
  {
    AppMethodBeat.i(137118);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    if ((!TextUtils.isEmpty(this.dlD.filePath)) && (this.dlD.hOL == null))
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.dlD.filePath });
      if (this.wyb == null) {
        this.wyb = new CommonPlayer(this.wyk);
      }
      this.wyb.reset();
    }
    for (;;)
    {
      try
      {
        this.wyb.setDataSource(this.dlD.filePath);
        this.wyb.prepare();
        float f = 0.0F;
        if (this.dlD != null) {
          f = (float)this.dlD.hOB;
        }
        if (this.wyb == null) {
          break label613;
        }
        if ((f < 0.5F) || (f > 2.0F)) {
          break;
        }
        ae.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f) });
        this.wyb.setSpeed(f);
        AppMethodBeat.o(137118);
        return;
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer exception", new Object[0]);
        Lv(501);
        Lw(501);
        continue;
      }
      if ((!TextUtils.isEmpty(this.dlD.filePath)) && (this.dlD.hOL != null))
      {
        ae.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.dlD.filePath });
        if (this.wyb == null) {
          this.wyb = new CommonPlayer(this.wyk);
        }
        this.wyb.reset();
        com.tencent.mm.plugin.music.g.b localb = new com.tencent.mm.plugin.music.g.b(this.dlD.hOL);
        try
        {
          this.wyb.setDataSource(localb);
          this.wyb.prepare();
        }
        catch (Exception localException2)
        {
          ae.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException2.getMessage());
          ae.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer", new Object[0]);
          Lv(501);
          Lw(501);
        }
      }
      else
      {
        ae.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.dlD.der });
        dvk();
        try
        {
          URL localURL = new URL(this.ddI);
          if (localURL == null)
          {
            ae.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
            Lv(500);
            Lw(500);
            AppMethodBeat.o(137118);
            return;
          }
        }
        catch (Exception localException3)
        {
          Object localObject;
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
            localObject = null;
          }
          if (this.wyb == null) {
            this.wyb = new CommonPlayer(this.wyk);
          }
          this.wyb.reset();
          if (this.wyg == null) {
            this.wyg = new com.tencent.mm.plugin.music.g.a.b();
          }
          this.wyg.iq(this.ddI, this.dlD.hOK);
          try
          {
            this.wyb.setDataSource(this.wyg, Uri.parse(localObject.toString()));
            this.wyb.prepare();
          }
          catch (Exception localException4)
          {
            ae.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException4.getMessage());
            ae.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
            Lv(501);
            Lw(501);
          }
        }
      }
    }
    this.wyb.setSpeed(1.0F);
    label613:
    AppMethodBeat.o(137118);
  }
  
  private void dvk()
  {
    AppMethodBeat.i(137119);
    this.ddI = this.dlD.der;
    if (com.tencent.mm.plugin.music.h.e.aue(this.ddI)) {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.ddI });
      com.tencent.mm.plugin.music.cache.g.atB(this.ddI);
      com.tencent.mm.plugin.music.cache.g.bC(this.ddI, bool);
      AppMethodBeat.o(137119);
      return;
    }
  }
  
  private void dvq()
  {
    AppMethodBeat.i(137134);
    try
    {
      if (this.wyb != null)
      {
        this.wyb.setVolume(0.0F, 0.0F);
        this.wyb.stop();
      }
      if (this.wyf != null)
      {
        this.wyf.isStop = true;
        this.wyf = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        Lv(504);
        Lw(504);
      }
    }
    this.wyd = false;
    this.wye = true;
    this.gyu = System.currentTimeMillis();
    AppMethodBeat.o(137134);
  }
  
  public final void a(d.a parama) {}
  
  public final boolean aJZ()
  {
    AppMethodBeat.i(137123);
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 4)
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
  
  public final boolean aKb()
  {
    AppMethodBeat.i(137129);
    if ((this.wyd) && (!cOU()))
    {
      AppMethodBeat.o(137129);
      return true;
    }
    AppMethodBeat.o(137129);
    return false;
  }
  
  public final void ats(String paramString)
  {
    AppMethodBeat.i(137115);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.ddg = paramString;
    AppMethodBeat.o(137115);
  }
  
  public final void b(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137116);
    this.dlD = paramb;
    this.dez = paramb.dez;
    this.autoPlay = paramb.hOy;
    if ((this.wyb != null) && (aJZ()))
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.ddg, this.ddI, Double.valueOf(this.dlD.hOA) });
      this.wyb.setVolume((float)this.dlD.hOA, (float)this.dlD.hOA);
      if (this.dlD.hOB > 0.0D)
      {
        ae.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.dlD.hOB) });
        this.wyb.setSpeed((float)this.dlD.hOB);
        AppMethodBeat.o(137116);
        return;
      }
      this.wyb.setSpeed(1.0F);
    }
    AppMethodBeat.o(137116);
  }
  
  public final void b(d.a parama) {}
  
  public final boolean bpC()
  {
    AppMethodBeat.i(137125);
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 2)
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
  
  public final boolean cOU()
  {
    AppMethodBeat.i(137124);
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 3)
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
  
  public final boolean duY()
  {
    return true;
  }
  
  public final String dva()
  {
    return this.ddg;
  }
  
  public final void dvl()
  {
    AppMethodBeat.i(137121);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137121);
  }
  
  final void dvm()
  {
    AppMethodBeat.i(195457);
    this.wyb.setAudioStreamType(f.duL().getStreamType());
    this.wyb.start();
    AppMethodBeat.o(195457);
  }
  
  public final void dvn()
  {
    AppMethodBeat.i(137130);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.hOO = true;
    this.wye = true;
    AppMethodBeat.o(137130);
  }
  
  public final void dvo()
  {
    AppMethodBeat.i(137131);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.hOO = true;
    dvq();
    AppMethodBeat.o(137131);
  }
  
  public final void dvp()
  {
    AppMethodBeat.i(137132);
    this.hOO = false;
    this.wye = true;
    dvf();
    this.gyu = System.currentTimeMillis();
    AppMethodBeat.o(137132);
  }
  
  public final int dvr()
  {
    AppMethodBeat.i(137135);
    if (this.wyb != null)
    {
      int i = (int)this.wyb.getCurrentPosition();
      AppMethodBeat.o(137135);
      return i;
    }
    AppMethodBeat.o(137135);
    return -1;
  }
  
  public final com.tencent.mm.ai.d dvs()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137138);
    if (this.wyc == null) {
      this.wyc = new com.tencent.mm.ai.d();
    }
    int k = getDuration();
    int m = dvr();
    boolean bool2 = aJZ();
    if (this.wyb != null) {}
    for (int j = this.wyb.getBufferedPercentage();; j = 0)
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
      this.wyc.dlC = m;
      this.wyc.duration = k;
      com.tencent.mm.ai.d locald = this.wyc;
      if (bool2) {}
      for (;;)
      {
        locald.tG = bool1;
        this.wyc.hOO = this.hOO;
        this.wyc.hOP = (j * k / 100);
        if (this.dlD == null) {
          break;
        }
        this.wyc.dez = this.dlD.hOx;
        this.wyc.ddc = this.dlD.der;
        this.wyc.hOJ = this.dlD.hOJ;
        locald = this.wyc;
        AppMethodBeat.o(137138);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137138);
      return null;
    }
  }
  
  public final void dvt()
  {
    AppMethodBeat.i(137141);
    if ((this.ddg.equalsIgnoreCase(this.dlD.ddg)) && (this.wyb != null) && (aJZ()))
    {
      int i = (int)this.wyb.getCurrentPosition();
      int j = this.wyb.getDuration();
      if ((i > 0) && (j > 0) && (this.wxZ != null)) {
        this.wxZ.fa(i, j);
      }
    }
    AppMethodBeat.o(137141);
  }
  
  public final String getAppId()
  {
    if (this.dlD != null) {
      return this.dlD.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137136);
    if (this.wyb != null)
    {
      int i = this.wyb.getDuration();
      AppMethodBeat.o(137136);
      return i;
    }
    AppMethodBeat.o(137136);
    return -1;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137127);
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 7)
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
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 5)
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
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 6)
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
  
  public final void l(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137117);
    if (paramb == null)
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      dvi();
      AppMethodBeat.o(137117);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.wyh;
    if ((this.dlD != null) && (this.dlD.e(paramb)) && (l2 <= 100L))
    {
      this.dlD = paramb;
      this.dez = paramb.dez;
      this.autoPlay = paramb.hOy;
      ae.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.ddI, Long.valueOf(l2) });
      AppMethodBeat.o(137117);
      return;
    }
    this.wxJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.wxJ != null) {
      this.wxJ.Ly(paramb.fromScene);
    }
    this.wyh = l1;
    this.dlD = paramb;
    ae.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.dlD.fromScene), this.ddg });
    if ((this.wyb != null) && (aJZ())) {
      this.wyb.stop();
    }
    this.bFv = 0;
    this.dez = paramb.dez;
    this.autoPlay = paramb.hOy;
    this.audioType = null;
    this.wyi = false;
    this.hOO = false;
    this.wye = false;
    dvj();
    AppMethodBeat.o(137117);
  }
  
  public final boolean pR(int paramInt)
  {
    AppMethodBeat.i(137137);
    int i = getDuration();
    ae.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i < 0)
    {
      ae.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137137);
      return false;
    }
    if (paramInt > i)
    {
      ae.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137137);
      return false;
    }
    if (this.wyb != null)
    {
      ae.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      w localw = new w();
      localw.dlG.action = 10;
      localw.dlG.state = "seeking";
      localw.dlG.ddg = dva();
      localw.dlG.appId = getAppId();
      com.tencent.mm.sdk.b.a.IvT.a(localw, Looper.getMainLooper());
      this.wyb.seekTo(paramInt);
    }
    AppMethodBeat.o(137137);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137120);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.ddg });
    this.wye = true;
    if ((this.wyb != null) && (aJZ())) {
      try
      {
        ae.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.wyb.pause();
        AppMethodBeat.o(137120);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        Lv(503);
        Lw(503);
        AppMethodBeat.o(137120);
        return;
      }
    }
    if ((this.wyb != null) && (isCompleted()))
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.wyd = false;
    }
    AppMethodBeat.o(137120);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137140);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.wxQ = null;
    if (this.wyb != null)
    {
      this.wyb.release();
      this.wyb = null;
    }
    duW();
    AppMethodBeat.o(137140);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137122);
    this.bFv = 0;
    boolean bool1 = cOU();
    boolean bool2 = aJZ();
    this.wye = false;
    this.hOO = false;
    ae.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.wyd), this.ddg });
    if ((this.wyb != null) && (!bpC()) && (!bool1) && (!bool2) && (!this.wyd))
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.dez = 0;
      this.autoPlay = true;
      dvj();
      if (this.wxJ != null)
      {
        this.wxJ.Ly(this.dlD.fromScene);
        AppMethodBeat.o(137122);
      }
    }
    else if ((this.wyb != null) && ((isPaused()) || (bpC())) && (!bool2))
    {
      ae.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.wyb.setVolume((float)this.dlD.hOA, (float)this.dlD.hOA);
      dvm();
      this.wyd = true;
      AppMethodBeat.o(137122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        Lv(502);
        Lw(502);
      }
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137133);
    ae.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.hOO = false;
    dvq();
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
      ae.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((h.this.wyb != null) && (h.this.aJZ())) {
              h.this.dvt();
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
              ae.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + localException.getMessage());
            }
          }
        }
      }
      AppMethodBeat.o(137113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h
 * JD-Core Version:    0.7.0.1
 */