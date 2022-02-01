package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public final class e
  extends a
{
  AudioFormat.AudioType audioType;
  int bFv;
  String ddI;
  int dez;
  a wBS;
  private String wBT;
  CommonPlayer wyb;
  boolean wyd;
  private com.tencent.mm.plugin.music.g.a.b wyg;
  private long wyh;
  private boolean wyi;
  private PlayerListenerCallback wyk;
  public boolean wzM;
  f wzy;
  private c wzz;
  
  public e()
  {
    AppMethodBeat.i(137361);
    this.ddI = "";
    this.bFv = 0;
    this.dez = 0;
    this.wyh = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.wyi = false;
    this.wzM = false;
    this.wyk = new PlayerListenerCallback()
    {
      f wBU = null;
      
      private void dwO()
      {
        AppMethodBeat.i(137359);
        ae.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
        if (e.this.dez != 0)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.this.dez) });
          e.this.pR(e.this.dez);
          AppMethodBeat.o(137359);
          return;
        }
        ae.i("MicroMsg.Music.QQMusicPlayer", "start to play");
        if (k.dwr().requestFocus())
        {
          if (e.this.wzy == null)
          {
            ae.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137359);
            return;
          }
          e.this.D(e.this.wzy);
          try
          {
            if (e.this.wyb != null)
            {
              e.this.wyb.start();
              if ((e.this.wyb.getCurrentAudioInformation() != null) && (e.this.wyb.getCurrentAudioInformation().getAudioType() != null))
              {
                ae.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.this.wyb.getCurrentAudioInformation().getAudioType().getValue()) });
                e.this.audioType = e.this.wyb.getCurrentAudioInformation().getAudioType();
                e.b(e.this);
              }
            }
            e.this.wyd = true;
            AppMethodBeat.o(137359);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "_onPrepared", new Object[0]);
              e.this.d(e.this.wzy, 502);
              e.a(e.this, e.this.wzy, 502);
            }
          }
        }
        ae.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
        AppMethodBeat.o(137359);
      }
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137353);
        ae.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
        AppMethodBeat.o(137353);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137355);
        ae.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        paramAnonymousBaseMediaPlayer = k.dwp().dwa();
        if (paramAnonymousBaseMediaPlayer == null)
        {
          ae.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        this.wBU = e.this.wzy;
        if (this.wBU == null)
        {
          ae.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        boolean bool = az.isNetworkConnected(ak.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ae.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (e.this.bFv > 0)
        {
          ae.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.this.bFv) });
          AppMethodBeat.o(137355);
          return;
        }
        e locale = e.this;
        locale.bFv += 1;
        e.a(e.this);
        e.a(e.this, this.wBU, paramAnonymousInt2);
        if (paramAnonymousBaseMediaPlayer.f(this.wBU))
        {
          e.this.stopPlay();
          ar.f(new e.1.1(this));
        }
        e.this.H(this.wBU);
        e.this.d(this.wBU, paramAnonymousInt2);
        if (e.this.wBS != null)
        {
          e.this.wBS.isStop = true;
          e.this.wBS = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
          g.atH(e.this.ddI);
        }
        AppMethodBeat.o(137355);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137356);
        ae.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
        AppMethodBeat.o(137356);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137354);
        ae.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.this.dez != 0)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.this.dez) });
          e.this.dez = 0;
          dwO();
          AppMethodBeat.o(137354);
          return;
        }
        ae.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.wBU == null)
        {
          ae.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          AppMethodBeat.o(137354);
          return;
        }
        e.this.I(this.wBU);
        if (e.this.aJZ())
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
          e.this.F(this.wBU);
        }
        AppMethodBeat.o(137354);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137358);
        ae.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
        AppMethodBeat.o(137358);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137357);
        ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 3)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
          ae.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
          this.wBU = e.this.wzy;
          if (this.wBU == null)
          {
            ae.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.C(this.wBU);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
          dwO();
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 4)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
          ae.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
          this.wBU = e.this.wzy;
          if (this.wBU == null)
          {
            ae.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.hOz = SystemClock.elapsedRealtime();
          if (e.this.wBA == "pause") {
            e.this.F(this.wBU);
          }
          for (;;)
          {
            if (e.this.wBS != null) {
              e.this.wBS.isStop = true;
            }
            e.this.wBS = new e.a(e.this, (byte)0);
            paramAnonymousBaseMediaPlayer = e.this.wBS;
            paramAnonymousBaseMediaPlayer.isStop = false;
            com.tencent.mm.sdk.g.b.c(paramAnonymousBaseMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137357);
            return;
            e.this.E(this.wBU);
          }
        }
        if (paramAnonymousInt == 5)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
          ae.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
          if (this.wBU == null)
          {
            ae.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = e.this;
          paramAnonymousBaseMediaPlayer.wBD += SystemClock.elapsedRealtime() - e.this.hOz;
          e.this.G(this.wBU);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          ae.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.wBU == null)
          {
            ae.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = k.dwp().dwa();
          if (paramAnonymousBaseMediaPlayer == null)
          {
            ae.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          if (paramAnonymousBaseMediaPlayer.f(this.wBU))
          {
            e.this.H(this.wBU);
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = this.wBU;
          ae.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
          mg localmg = new mg();
          localmg.dAP.action = 18;
          localmg.dAP.dAJ = paramAnonymousBaseMediaPlayer;
          com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
          ae.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
          if (this.wBU == null)
          {
            ae.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.a(e.this);
          e.this.wyd = false;
          e.this.K(e.this.wzy);
          if (e.this.wBS != null)
          {
            e.this.wBS.isStop = true;
            e.this.wBS = null;
          }
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 8)
        {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
          ae.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 9) {
          ae.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
        }
        AppMethodBeat.o(137357);
      }
    };
    com.tencent.mm.plugin.music.f.a.a.dwP();
    AppMethodBeat.o(137361);
  }
  
  private void bm(float paramFloat)
  {
    AppMethodBeat.i(195459);
    if (this.wyb == null)
    {
      AppMethodBeat.o(195459);
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      ae.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.wyb.setSpeed(paramFloat);
      AppMethodBeat.o(195459);
      return;
    }
    this.wyb.setSpeed(1.0F);
    AppMethodBeat.o(195459);
  }
  
  private boolean cOU()
  {
    AppMethodBeat.i(137369);
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 3)
      {
        AppMethodBeat.o(137369);
        return true;
      }
      AppMethodBeat.o(137369);
      return false;
    }
    AppMethodBeat.o(137369);
    return false;
  }
  
  private void dwN()
  {
    AppMethodBeat.i(137379);
    if (this.wyb != null)
    {
      this.bmD = dvr();
      this.wBD += SystemClock.elapsedRealtime() - this.hOz;
      this.duration = getDuration();
      if (this.wBB != null) {
        this.wBB.a(this.wzy, this.bmD, this.wBD, this.duration);
      }
    }
    AppMethodBeat.o(137379);
  }
  
  private void e(f paramf, int paramInt)
  {
    AppMethodBeat.i(137378);
    if (this.wBB != null) {
      this.wBB.b(paramf, paramInt);
    }
    AppMethodBeat.o(137378);
  }
  
  private void setVolume(float paramFloat)
  {
    AppMethodBeat.i(195460);
    if ((this.wyb != null) && (paramFloat >= 0.0F)) {
      this.wyb.setVolume(paramFloat, paramFloat);
    }
    AppMethodBeat.o(195460);
  }
  
  public final boolean aJZ()
  {
    AppMethodBeat.i(137368);
    if (this.wyb != null)
    {
      if (this.wyb.getPlayerState() == 4)
      {
        AppMethodBeat.o(137368);
        return true;
      }
      AppMethodBeat.o(137368);
      return false;
    }
    AppMethodBeat.o(137368);
    return false;
  }
  
  public final boolean aKa()
  {
    return (this.wyd) && (this.wzM);
  }
  
  public final boolean aKb()
  {
    AppMethodBeat.i(137370);
    if ((this.wyd) && (!cOU()))
    {
      AppMethodBeat.o(137370);
      return true;
    }
    AppMethodBeat.o(137370);
    return false;
  }
  
  public final void duX()
  {
    AppMethodBeat.i(137366);
    this.wzM = true;
    ae.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.wyb != null) && (aJZ())) {
      try
      {
        this.wyb.pause();
        AppMethodBeat.o(137366);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.wzy, 503);
        e(this.wzy, 503);
      }
    }
    AppMethodBeat.o(137366);
  }
  
  public final boolean duY()
  {
    return true;
  }
  
  public final c duZ()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137375);
    int n = getDuration();
    int i1 = dvr();
    boolean bool = aJZ();
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
      c localc;
      if (this.wzz != null)
      {
        localc = this.wzz;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.t(n, i1, i, j);
      }
      for (;;)
      {
        this.wzz.dAR = true;
        this.wzz.ijU = dwI();
        localc = this.wzz;
        AppMethodBeat.o(137375);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.wzz = new c(n, i1, i, j);
      }
    }
  }
  
  protected final void dvS()
  {
    AppMethodBeat.i(137363);
    this.wBB = ((d)com.tencent.mm.plugin.music.f.c.b.aQ(d.class));
    this.wBC = k.dwp().wzU;
    AppMethodBeat.o(137363);
  }
  
  public final void dvl()
  {
    AppMethodBeat.i(137365);
    ae.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.dwr().bqr();
    AppMethodBeat.o(137365);
  }
  
  public final int dvr()
  {
    AppMethodBeat.i(137372);
    if (this.wyb != null)
    {
      int i = (int)this.wyb.getCurrentPosition();
      AppMethodBeat.o(137372);
      return i;
    }
    AppMethodBeat.o(137372);
    return -1;
  }
  
  public final void dvt()
  {
    AppMethodBeat.i(137377);
    f localf = k.dwp().dwa();
    if (localf == null)
    {
      AppMethodBeat.o(137377);
      return;
    }
    if ((localf.f(this.wzy)) && (this.wyb != null) && (aJZ()))
    {
      int i = (int)this.wyb.getCurrentPosition();
      int j = this.wyb.getDuration();
      if ((i > 0) && (j > 0)) {
        fa(i, j);
      }
    }
    AppMethodBeat.o(137377);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137373);
    if (this.wyb != null)
    {
      int i = this.wyb.getDuration();
      AppMethodBeat.o(137373);
      return i;
    }
    AppMethodBeat.o(137373);
    return -1;
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(137362);
    super.h(paramf);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.wyh;
    if ((this.wzy != null) && (this.wzy.f(paramf)) && (l2 <= 3000L))
    {
      this.wzy = paramf;
      ae.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.ddI, Long.valueOf(l2) });
      AppMethodBeat.o(137362);
      return;
    }
    if (paramf == null)
    {
      ae.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137362);
      return;
    }
    this.bmD = 0L;
    this.hOz = SystemClock.elapsedRealtime();
    this.wBD = 0L;
    this.duration = 0L;
    if (this.wBB != null) {
      this.wBB.v(paramf);
    }
    this.wyh = l1;
    this.wzy = paramf;
    ae.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.dez) });
    if ((this.wyb != null) && (aJZ())) {
      this.wyb.stop();
    }
    com.tencent.mm.plugin.music.f.a.a.dwQ();
    this.bFv = 0;
    this.dez = paramf.dez;
    this.audioType = null;
    this.wyi = false;
    ae.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.ddI = this.wzy.playUrl;
    this.wBT = this.wzy.ikl;
    ae.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.ddI, this.wBT });
    ae.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.wzy.ikf });
    if ((!bu.isNullOrNil(this.ddI)) && (bu.isNullOrNil(this.wBT)))
    {
      g.atB(this.ddI);
      g.eE(this.ddI, 0);
      g.eF(this.ddI, 0);
    }
    if (!bu.isNullOrNil(this.wBT))
    {
      ae.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.wBT });
      if (this.wyb == null) {
        this.wyb = new CommonPlayer(this.wyk);
      }
      this.wyb.reset();
      if (this.wBT.startsWith("file://")) {
        this.wBT = this.wBT.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.wyb.setDataSource(this.wBT);
        this.wyb.prepare();
        bm((float)this.wzy.hOB);
        setVolume(this.wzy.volume);
        dwH();
        AppMethodBeat.o(137362);
        return;
      }
      catch (Exception paramf)
      {
        ae.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
        ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
        d(this.wzy, 501);
        e(this.wzy, 501);
        continue;
      }
      paramf = null;
      try
      {
        URL localURL = new URL(this.ddI);
        paramf = localURL;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "initPlayer", new Object[0]);
          ae.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + localException.getMessage());
        }
        if (this.wyb != null) {
          break label677;
        }
        this.wyb = new CommonPlayer(this.wyk);
        this.wyb.reset();
        if (this.wyg != null) {
          break label702;
        }
        this.wyg = new com.tencent.mm.plugin.music.g.a.b();
        if (this.wzy != null) {
          break label835;
        }
      }
      if (paramf != null) {
        break;
      }
      ae.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
      d(this.wzy, 500);
      e(this.wzy, 500);
    }
    label677:
    label702:
    label835:
    for (String str = "invalidReferrer";; str = this.wzy.hOK)
    {
      for (;;)
      {
        ae.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
        this.wyg.iq(this.ddI, str);
        try
        {
          this.wyb.setDataSource(this.wyg, Uri.parse(paramf.toString()));
          this.wyb.prepare();
        }
        catch (Exception paramf)
        {
          ae.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
          ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
          d(this.wzy, 501);
          e(this.wzy, 501);
        }
      }
      break;
    }
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(195461);
    if ((this.wzy != null) && (this.wzy.f(paramf)))
    {
      ae.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.ddI });
      if ((paramf.hOB > 0.0D) && (paramf.hOB != this.wzy.hOB))
      {
        ae.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(paramf.hOB) });
        bm((float)paramf.hOB);
        this.wzy.hOB = paramf.hOB;
      }
      if ((paramf.volume >= 0.0F) && (paramf.volume != this.wzy.volume))
      {
        ae.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(paramf.volume) });
        setVolume(paramf.volume);
        this.wzy.volume = paramf.volume;
      }
    }
    AppMethodBeat.o(195461);
  }
  
  public final boolean pR(int paramInt)
  {
    AppMethodBeat.i(137374);
    int i = getDuration();
    ae.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ae.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137374);
      return false;
    }
    if (this.wyb != null)
    {
      J(this.wzy);
      this.wyb.seekTo(paramInt);
    }
    AppMethodBeat.o(137374);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137364);
    this.wzM = false;
    ae.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.wyb != null) && (aJZ())) {
      try
      {
        this.wyb.pause();
        AppMethodBeat.o(137364);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.wzy, 503);
        e(this.wzy, 503);
      }
    }
    AppMethodBeat.o(137364);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137376);
    ae.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.wyb != null)
    {
      this.wyb.release();
      this.wyb = null;
    }
    duW();
    AppMethodBeat.o(137376);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137367);
    this.bFv = 0;
    boolean bool1 = cOU();
    boolean bool2 = aJZ();
    ae.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((this.wyb == null) || (bool1) || (bool2) || (k.dwr().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.wyb.start();
        this.wyd = true;
        AppMethodBeat.o(137367);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.wzy, 502);
        e(this.wzy, 502);
        continue;
      }
      ae.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137371);
    ae.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      dwN();
      if (this.wyb != null) {
        this.wyb.stop();
      }
      if (this.wBS != null)
      {
        this.wBS.isStop = true;
        this.wBS = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.wzy, 504);
        e(this.wzy, 504);
      }
    }
    k.dwr().bqr();
    this.wyd = false;
    this.wzM = false;
    AppMethodBeat.o(137371);
  }
  
  final class a
    implements Runnable
  {
    boolean isStop = true;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(137360);
      ae.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((e.this.wyb != null) && (e.this.aJZ())) {
              e.this.dvt();
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
              ae.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + localException.getMessage());
            }
          }
        }
      }
      AppMethodBeat.o(137360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e
 * JD-Core Version:    0.7.0.1
 */