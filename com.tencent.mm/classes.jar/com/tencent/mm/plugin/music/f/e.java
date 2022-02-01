package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.c;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  String dcG;
  int ddx;
  private com.tencent.mm.plugin.music.g.a.b wiB;
  private long wiC;
  private boolean wiD;
  private PlayerListenerCallback wiF;
  CommonPlayer wiw;
  boolean wiy;
  f wjT;
  private c wjU;
  public boolean wkh;
  a wmj;
  private String wmk;
  
  public e()
  {
    AppMethodBeat.i(137361);
    this.dcG = "";
    this.bFv = 0;
    this.ddx = 0;
    this.wiC = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.wiD = false;
    this.wkh = false;
    this.wiF = new PlayerListenerCallback()
    {
      f wml = null;
      
      private void dtz()
      {
        AppMethodBeat.i(137359);
        ad.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
        if (e.this.ddx != 0)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.this.ddx) });
          e.this.pO(e.this.ddx);
          AppMethodBeat.o(137359);
          return;
        }
        ad.i("MicroMsg.Music.QQMusicPlayer", "start to play");
        if (k.dtc().requestFocus())
        {
          if (e.this.wjT == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137359);
            return;
          }
          e.this.D(e.this.wjT);
          try
          {
            if (e.this.wiw != null)
            {
              e.this.wiw.start();
              if ((e.this.wiw.getCurrentAudioInformation() != null) && (e.this.wiw.getCurrentAudioInformation().getAudioType() != null))
              {
                ad.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.this.wiw.getCurrentAudioInformation().getAudioType().getValue()) });
                e.this.audioType = e.this.wiw.getCurrentAudioInformation().getAudioType();
                e.b(e.this);
              }
            }
            e.this.wiy = true;
            AppMethodBeat.o(137359);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "_onPrepared", new Object[0]);
              e.this.d(e.this.wjT, 502);
              e.a(e.this, e.this.wjT, 502);
            }
          }
        }
        ad.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
        AppMethodBeat.o(137359);
      }
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137353);
        ad.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
        AppMethodBeat.o(137353);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137355);
        ad.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        paramAnonymousBaseMediaPlayer = k.dta().dsL();
        if (paramAnonymousBaseMediaPlayer == null)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        this.wml = e.this.wjT;
        if (this.wml == null)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        boolean bool = ay.isNetworkConnected(aj.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ad.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (e.this.bFv > 0)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.this.bFv) });
          AppMethodBeat.o(137355);
          return;
        }
        e locale = e.this;
        locale.bFv += 1;
        e.a(e.this);
        e.a(e.this, this.wml, paramAnonymousInt2);
        if (paramAnonymousBaseMediaPlayer.f(this.wml))
        {
          e.this.stopPlay();
          aq.f(new e.1.1(this));
        }
        e.this.H(this.wml);
        e.this.d(this.wml, paramAnonymousInt2);
        if (e.this.wmj != null)
        {
          e.this.wmj.isStop = true;
          e.this.wmj = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
          g.ast(e.this.dcG);
        }
        AppMethodBeat.o(137355);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137356);
        ad.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
        AppMethodBeat.o(137356);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137354);
        ad.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.this.ddx != 0)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.this.ddx) });
          e.this.ddx = 0;
          dtz();
          AppMethodBeat.o(137354);
          return;
        }
        ad.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.wml == null)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          AppMethodBeat.o(137354);
          return;
        }
        e.this.I(this.wml);
        if (e.this.aJG())
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
          e.this.F(this.wml);
        }
        AppMethodBeat.o(137354);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137358);
        ad.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
        AppMethodBeat.o(137358);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137357);
        ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 3)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
          this.wml = e.this.wjT;
          if (this.wml == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.C(this.wml);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
          dtz();
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 4)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
          this.wml = e.this.wjT;
          if (this.wml == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.hLG = SystemClock.elapsedRealtime();
          if (e.this.wlR == "pause") {
            e.this.F(this.wml);
          }
          for (;;)
          {
            if (e.this.wmj != null) {
              e.this.wmj.isStop = true;
            }
            e.this.wmj = new e.a(e.this, (byte)0);
            paramAnonymousBaseMediaPlayer = e.this.wmj;
            paramAnonymousBaseMediaPlayer.isStop = false;
            com.tencent.mm.sdk.g.b.c(paramAnonymousBaseMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137357);
            return;
            e.this.E(this.wml);
          }
        }
        if (paramAnonymousInt == 5)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
          if (this.wml == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = e.this;
          paramAnonymousBaseMediaPlayer.wlU += SystemClock.elapsedRealtime() - e.this.hLG;
          e.this.G(this.wml);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.wml == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = k.dta().dsL();
          if (paramAnonymousBaseMediaPlayer == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          if (paramAnonymousBaseMediaPlayer.f(this.wml))
          {
            e.this.H(this.wml);
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = this.wml;
          ad.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
          mf localmf = new mf();
          localmf.dzK.action = 18;
          localmf.dzK.dzE = paramAnonymousBaseMediaPlayer;
          com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
          if (this.wml == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.a(e.this);
          e.this.wiy = false;
          e.this.K(e.this.wjT);
          if (e.this.wmj != null)
          {
            e.this.wmj.isStop = true;
            e.this.wmj = null;
          }
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 8)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 9) {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
        }
        AppMethodBeat.o(137357);
      }
    };
    com.tencent.mm.plugin.music.f.a.a.dtA();
    AppMethodBeat.o(137361);
  }
  
  private void bm(float paramFloat)
  {
    AppMethodBeat.i(194990);
    if (this.wiw == null)
    {
      AppMethodBeat.o(194990);
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      ad.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.wiw.setSpeed(paramFloat);
      AppMethodBeat.o(194990);
      return;
    }
    this.wiw.setSpeed(1.0F);
    AppMethodBeat.o(194990);
  }
  
  private boolean cMm()
  {
    AppMethodBeat.i(137369);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 3)
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
  
  private void dty()
  {
    AppMethodBeat.i(137379);
    if (this.wiw != null)
    {
      this.bmD = dsc();
      this.wlU += SystemClock.elapsedRealtime() - this.hLG;
      this.duration = getDuration();
      if (this.wlS != null) {
        this.wlS.a(this.wjT, this.bmD, this.wlU, this.duration);
      }
    }
    AppMethodBeat.o(137379);
  }
  
  private void e(f paramf, int paramInt)
  {
    AppMethodBeat.i(137378);
    if (this.wlS != null) {
      this.wlS.b(paramf, paramInt);
    }
    AppMethodBeat.o(137378);
  }
  
  private void setVolume(float paramFloat)
  {
    AppMethodBeat.i(194991);
    if ((this.wiw != null) && (paramFloat >= 0.0F)) {
      this.wiw.setVolume(paramFloat, paramFloat);
    }
    AppMethodBeat.o(194991);
  }
  
  public final boolean aJG()
  {
    AppMethodBeat.i(137368);
    if (this.wiw != null)
    {
      if (this.wiw.getPlayerState() == 4)
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
  
  public final boolean aJH()
  {
    return (this.wiy) && (this.wkh);
  }
  
  public final boolean aJI()
  {
    AppMethodBeat.i(137370);
    if ((this.wiy) && (!cMm()))
    {
      AppMethodBeat.o(137370);
      return true;
    }
    AppMethodBeat.o(137370);
    return false;
  }
  
  public final void drJ()
  {
    AppMethodBeat.i(137366);
    this.wkh = true;
    ad.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.wiw != null) && (aJG())) {
      try
      {
        this.wiw.pause();
        AppMethodBeat.o(137366);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.wjT, 503);
        e(this.wjT, 503);
      }
    }
    AppMethodBeat.o(137366);
  }
  
  public final boolean drK()
  {
    return true;
  }
  
  public final c drL()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137375);
    int n = getDuration();
    int i1 = dsc();
    boolean bool = aJG();
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
      c localc;
      if (this.wjU != null)
      {
        localc = this.wjU;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.t(n, i1, i, j);
      }
      for (;;)
      {
        this.wjU.dzM = true;
        this.wjU.ihb = dtt();
        localc = this.wjU;
        AppMethodBeat.o(137375);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.wjU = new c(n, i1, i, j);
      }
    }
  }
  
  public final void drX()
  {
    AppMethodBeat.i(137365);
    ad.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.dtc().bpH();
    AppMethodBeat.o(137365);
  }
  
  protected final void dsD()
  {
    AppMethodBeat.i(137363);
    this.wlS = ((d)com.tencent.mm.plugin.music.f.c.b.aQ(d.class));
    this.wlT = k.dta().wkp;
    AppMethodBeat.o(137363);
  }
  
  public final int dsc()
  {
    AppMethodBeat.i(137372);
    if (this.wiw != null)
    {
      int i = (int)this.wiw.getCurrentPosition();
      AppMethodBeat.o(137372);
      return i;
    }
    AppMethodBeat.o(137372);
    return -1;
  }
  
  public final void dse()
  {
    AppMethodBeat.i(137377);
    f localf = k.dta().dsL();
    if (localf == null)
    {
      AppMethodBeat.o(137377);
      return;
    }
    if ((localf.f(this.wjT)) && (this.wiw != null) && (aJG()))
    {
      int i = (int)this.wiw.getCurrentPosition();
      int j = this.wiw.getDuration();
      if ((i > 0) && (j > 0)) {
        eZ(i, j);
      }
    }
    AppMethodBeat.o(137377);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137373);
    if (this.wiw != null)
    {
      int i = this.wiw.getDuration();
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
    long l2 = l1 - this.wiC;
    if ((this.wjT != null) && (this.wjT.f(paramf)) && (l2 <= 3000L))
    {
      this.wjT = paramf;
      ad.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.dcG, Long.valueOf(l2) });
      AppMethodBeat.o(137362);
      return;
    }
    if (paramf == null)
    {
      ad.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137362);
      return;
    }
    this.bmD = 0L;
    this.hLG = SystemClock.elapsedRealtime();
    this.wlU = 0L;
    this.duration = 0L;
    if (this.wlS != null) {
      this.wlS.v(paramf);
    }
    this.wiC = l1;
    this.wjT = paramf;
    ad.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.ddx) });
    if ((this.wiw != null) && (aJG())) {
      this.wiw.stop();
    }
    com.tencent.mm.plugin.music.f.a.a.dtB();
    this.bFv = 0;
    this.ddx = paramf.ddx;
    this.audioType = null;
    this.wiD = false;
    ad.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.dcG = this.wjT.playUrl;
    this.wmk = this.wjT.ihs;
    ad.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.dcG, this.wmk });
    ad.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.wjT.ihm });
    if ((!bt.isNullOrNil(this.dcG)) && (bt.isNullOrNil(this.wmk)))
    {
      g.asn(this.dcG);
      g.ew(this.dcG, 0);
      g.ex(this.dcG, 0);
    }
    if (!bt.isNullOrNil(this.wmk))
    {
      ad.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.wmk });
      if (this.wiw == null) {
        this.wiw = new CommonPlayer(this.wiF);
      }
      this.wiw.reset();
      if (this.wmk.startsWith("file://")) {
        this.wmk = this.wmk.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.wiw.setDataSource(this.wmk);
        this.wiw.prepare();
        bm((float)this.wjT.hLI);
        setVolume(this.wjT.volume);
        dts();
        AppMethodBeat.o(137362);
        return;
      }
      catch (Exception paramf)
      {
        ad.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
        d(this.wjT, 501);
        e(this.wjT, 501);
        continue;
      }
      paramf = null;
      try
      {
        URL localURL = new URL(this.dcG);
        paramf = localURL;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "initPlayer", new Object[0]);
          ad.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + localException.getMessage());
        }
        if (this.wiw != null) {
          break label677;
        }
        this.wiw = new CommonPlayer(this.wiF);
        this.wiw.reset();
        if (this.wiB != null) {
          break label702;
        }
        this.wiB = new com.tencent.mm.plugin.music.g.a.b();
        if (this.wjT != null) {
          break label835;
        }
      }
      if (paramf != null) {
        break;
      }
      ad.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
      d(this.wjT, 500);
      e(this.wjT, 500);
    }
    label677:
    label702:
    label835:
    for (String str = "invalidReferrer";; str = this.wjT.hLR)
    {
      for (;;)
      {
        ad.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
        this.wiB.ik(this.dcG, str);
        try
        {
          this.wiw.setDataSource(this.wiB, Uri.parse(paramf.toString()));
          this.wiw.prepare();
        }
        catch (Exception paramf)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
          ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
          d(this.wjT, 501);
          e(this.wjT, 501);
        }
      }
      break;
    }
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(194992);
    if ((this.wjT != null) && (this.wjT.f(paramf)))
    {
      ad.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.dcG });
      if ((paramf.hLI > 0.0D) && (paramf.hLI != this.wjT.hLI))
      {
        ad.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(paramf.hLI) });
        bm((float)paramf.hLI);
        this.wjT.hLI = paramf.hLI;
      }
      if ((paramf.volume >= 0.0F) && (paramf.volume != this.wjT.volume))
      {
        ad.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(paramf.volume) });
        setVolume(paramf.volume);
        this.wjT.volume = paramf.volume;
      }
    }
    AppMethodBeat.o(194992);
  }
  
  public final boolean pO(int paramInt)
  {
    AppMethodBeat.i(137374);
    int i = getDuration();
    ad.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ad.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137374);
      return false;
    }
    if (this.wiw != null)
    {
      J(this.wjT);
      this.wiw.seekTo(paramInt);
    }
    AppMethodBeat.o(137374);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137364);
    this.wkh = false;
    ad.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.wiw != null) && (aJG())) {
      try
      {
        this.wiw.pause();
        AppMethodBeat.o(137364);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.wjT, 503);
        e(this.wjT, 503);
      }
    }
    AppMethodBeat.o(137364);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137376);
    ad.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.wiw != null)
    {
      this.wiw.release();
      this.wiw = null;
    }
    drI();
    AppMethodBeat.o(137376);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137367);
    this.bFv = 0;
    boolean bool1 = cMm();
    boolean bool2 = aJG();
    ad.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((this.wiw == null) || (bool1) || (bool2) || (k.dtc().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.wiw.start();
        this.wiy = true;
        AppMethodBeat.o(137367);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.wjT, 502);
        e(this.wjT, 502);
        continue;
      }
      ad.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137371);
    ad.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      dty();
      if (this.wiw != null) {
        this.wiw.stop();
      }
      if (this.wmj != null)
      {
        this.wmj.isStop = true;
        this.wmj = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.wjT, 504);
        e(this.wjT, 504);
      }
    }
    k.dtc().bpH();
    this.wiy = false;
    this.wkh = false;
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
      ad.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((e.this.wiw != null) && (e.this.aJG())) {
              e.this.dse();
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
              ad.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + localException.getMessage());
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