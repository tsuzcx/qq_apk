package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.c;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
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
  int bxy;
  String cTT;
  int cUL;
  boolean rdQ;
  private PlayerListenerCallback tUB;
  CommonPlayer tUs;
  private com.tencent.mm.plugin.music.g.a.b tUw;
  private long tUy;
  private boolean tUz;
  f tVP;
  private c tVQ;
  public boolean tWc;
  a tYb;
  private String tYc;
  
  public e()
  {
    AppMethodBeat.i(137361);
    this.cTT = "";
    this.bxy = 0;
    this.cUL = 0;
    this.tUy = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.tUz = false;
    this.tWc = false;
    this.tUB = new PlayerListenerCallback()
    {
      f tYd = null;
      
      private void cVH()
      {
        AppMethodBeat.i(137359);
        ad.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
        if (e.this.cUL != 0)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.this.cUL) });
          e.this.ox(e.this.cUL);
          AppMethodBeat.o(137359);
          return;
        }
        ad.i("MicroMsg.Music.QQMusicPlayer", "start to play");
        if (k.cVk().requestFocus())
        {
          if (e.this.tVP == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137359);
            return;
          }
          e.this.C(e.this.tVP);
          try
          {
            if (e.this.tUs != null)
            {
              e.this.tUs.start();
              if ((e.this.tUs.getCurrentAudioInformation() != null) && (e.this.tUs.getCurrentAudioInformation().getAudioType() != null))
              {
                ad.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.this.tUs.getCurrentAudioInformation().getAudioType().getValue()) });
                e.this.audioType = e.this.tUs.getCurrentAudioInformation().getAudioType();
                e.b(e.this);
              }
            }
            e.this.rdQ = true;
            AppMethodBeat.o(137359);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "_onPrepared", new Object[0]);
              e.this.d(e.this.tVP, 502);
              e.a(e.this, e.this.tVP, 502);
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
        paramAnonymousBaseMediaPlayer = k.cVi().cUT();
        if (paramAnonymousBaseMediaPlayer == null)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        this.tYd = e.this.tVP;
        if (this.tYd == null)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        boolean bool = ay.isNetworkConnected(aj.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ad.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (e.this.bxy > 0)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.this.bxy) });
          AppMethodBeat.o(137355);
          return;
        }
        e locale = e.this;
        locale.bxy += 1;
        e.a(e.this);
        e.a(e.this, this.tYd, paramAnonymousInt2);
        if (paramAnonymousBaseMediaPlayer.f(this.tYd))
        {
          e.this.stopPlay();
          aq.f(new e.1.1(this));
        }
        e.this.G(this.tYd);
        e.this.d(this.tYd, paramAnonymousInt2);
        if (e.this.tYb != null)
        {
          e.this.tYb.isStop = true;
          e.this.tYb = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
          g.aiz(e.this.cTT);
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
        if (e.this.cUL != 0)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.this.cUL) });
          e.this.cUL = 0;
          cVH();
          AppMethodBeat.o(137354);
          return;
        }
        ad.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.tYd == null)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          AppMethodBeat.o(137354);
          return;
        }
        e.this.H(this.tYd);
        if (e.this.azF())
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
          e.this.E(this.tYd);
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
          this.tYd = e.this.tVP;
          if (this.tYd == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.B(this.tYd);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
          cVH();
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 4)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
          this.tYd = e.this.tVP;
          if (this.tYd == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.gSP = SystemClock.elapsedRealtime();
          if (e.this.tXK == "pause") {
            e.this.E(this.tYd);
          }
          for (;;)
          {
            if (e.this.tYb != null) {
              e.this.tYb.isStop = true;
            }
            e.this.tYb = new e.a(e.this, (byte)0);
            paramAnonymousBaseMediaPlayer = e.this.tYb;
            paramAnonymousBaseMediaPlayer.isStop = false;
            com.tencent.mm.sdk.g.b.c(paramAnonymousBaseMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137357);
            return;
            e.this.D(this.tYd);
          }
        }
        if (paramAnonymousInt == 5)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
          if (this.tYd == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = e.this;
          paramAnonymousBaseMediaPlayer.tXN += SystemClock.elapsedRealtime() - e.this.gSP;
          e.this.F(this.tYd);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.tYd == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = k.cVi().cUT();
          if (paramAnonymousBaseMediaPlayer == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          if (paramAnonymousBaseMediaPlayer.f(this.tYd))
          {
            e.this.G(this.tYd);
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = this.tYd;
          ad.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
          ln localln = new ln();
          localln.dql.action = 18;
          localln.dql.dqf = paramAnonymousBaseMediaPlayer;
          com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          ad.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
          ad.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
          if (this.tYd == null)
          {
            ad.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.a(e.this);
          e.this.rdQ = false;
          e.this.J(e.this.tVP);
          if (e.this.tYb != null)
          {
            e.this.tYb.isStop = true;
            e.this.tYb = null;
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
    com.tencent.mm.plugin.music.f.a.a.cVI();
    AppMethodBeat.o(137361);
  }
  
  private void bc(float paramFloat)
  {
    AppMethodBeat.i(193676);
    if (this.tUs == null)
    {
      AppMethodBeat.o(193676);
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      ad.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.tUs.setSpeed(paramFloat);
      AppMethodBeat.o(193676);
      return;
    }
    this.tUs.setSpeed(1.0F);
    AppMethodBeat.o(193676);
  }
  
  private boolean cUd()
  {
    AppMethodBeat.i(137369);
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 3)
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
  
  private void cVG()
  {
    AppMethodBeat.i(137379);
    if (this.tUs != null)
    {
      this.bbw = cUi();
      this.tXN += SystemClock.elapsedRealtime() - this.gSP;
      this.duration = getDuration();
      if (this.tXL != null) {
        this.tXL.a(this.tVP, this.bbw, this.tXN, this.duration);
      }
    }
    AppMethodBeat.o(137379);
  }
  
  private void e(f paramf, int paramInt)
  {
    AppMethodBeat.i(137378);
    if (this.tXL != null) {
      this.tXL.b(paramf, paramInt);
    }
    AppMethodBeat.o(137378);
  }
  
  private void setVolume(float paramFloat)
  {
    AppMethodBeat.i(193677);
    if ((this.tUs != null) && (paramFloat >= 0.0F)) {
      this.tUs.setVolume(paramFloat, paramFloat);
    }
    AppMethodBeat.o(193677);
  }
  
  public final boolean azF()
  {
    AppMethodBeat.i(137368);
    if (this.tUs != null)
    {
      if (this.tUs.getPlayerState() == 4)
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
  
  public final boolean azG()
  {
    return (this.rdQ) && (this.tWc);
  }
  
  public final boolean azH()
  {
    AppMethodBeat.i(137370);
    if ((this.rdQ) && (!cUd()))
    {
      AppMethodBeat.o(137370);
      return true;
    }
    AppMethodBeat.o(137370);
    return false;
  }
  
  public final void cTO()
  {
    AppMethodBeat.i(137366);
    this.tWc = true;
    ad.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.tUs != null) && (azF())) {
      try
      {
        this.tUs.pause();
        AppMethodBeat.o(137366);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.tVP, 503);
        e(this.tVP, 503);
      }
    }
    AppMethodBeat.o(137366);
  }
  
  public final boolean cTP()
  {
    return true;
  }
  
  public final c cTQ()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137375);
    int n = getDuration();
    int i1 = cUi();
    boolean bool = azF();
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
      c localc;
      if (this.tVQ != null)
      {
        localc = this.tVQ;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.t(n, i1, i, j);
      }
      for (;;)
      {
        this.tVQ.dqn = true;
        this.tVQ.hnk = cVB();
        localc = this.tVQ;
        AppMethodBeat.o(137375);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.tVQ = new c(n, i1, i, j);
      }
    }
  }
  
  protected final void cUL()
  {
    AppMethodBeat.i(137363);
    this.tXL = ((d)com.tencent.mm.plugin.music.f.c.b.aP(d.class));
    this.tXM = k.cVi().tWk;
    AppMethodBeat.o(137363);
  }
  
  public final void cUc()
  {
    AppMethodBeat.i(137365);
    ad.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.cVk().bfc();
    AppMethodBeat.o(137365);
  }
  
  public final int cUi()
  {
    AppMethodBeat.i(137372);
    if (this.tUs != null)
    {
      int i = (int)this.tUs.getCurrentPosition();
      AppMethodBeat.o(137372);
      return i;
    }
    AppMethodBeat.o(137372);
    return -1;
  }
  
  public final void cUk()
  {
    AppMethodBeat.i(137377);
    f localf = k.cVi().cUT();
    if (localf == null)
    {
      AppMethodBeat.o(137377);
      return;
    }
    if ((localf.f(this.tVP)) && (this.tUs != null) && (azF()))
    {
      int i = (int)this.tUs.getCurrentPosition();
      int j = this.tUs.getDuration();
      if ((i > 0) && (j > 0) && (this.tUq != null)) {
        this.tUq.eS(i, j);
      }
    }
    AppMethodBeat.o(137377);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137373);
    if (this.tUs != null)
    {
      int i = this.tUs.getDuration();
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
    long l2 = l1 - this.tUy;
    if ((this.tVP != null) && (this.tVP.f(paramf)) && (l2 <= 3000L))
    {
      this.tVP = paramf;
      ad.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.cTT, Long.valueOf(l2) });
      AppMethodBeat.o(137362);
      return;
    }
    if (paramf == null)
    {
      ad.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137362);
      return;
    }
    this.bbw = 0L;
    this.gSP = SystemClock.elapsedRealtime();
    this.tXN = 0L;
    this.duration = 0L;
    if (this.tXL != null) {
      this.tXL.v(paramf);
    }
    this.tUy = l1;
    this.tVP = paramf;
    ad.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.cUL) });
    if ((this.tUs != null) && (azF())) {
      this.tUs.stop();
    }
    com.tencent.mm.plugin.music.f.a.a.cVJ();
    this.bxy = 0;
    this.cUL = paramf.cUL;
    this.audioType = null;
    this.tUz = false;
    ad.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.cTT = this.tVP.playUrl;
    this.tYc = this.tVP.hnB;
    ad.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.cTT, this.tYc });
    ad.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.tVP.hnv });
    if ((!bt.isNullOrNil(this.cTT)) && (bt.isNullOrNil(this.tYc)))
    {
      g.ait(this.cTT);
      g.dX(this.cTT, 0);
      g.dY(this.cTT, 0);
    }
    if (!bt.isNullOrNil(this.tYc))
    {
      ad.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.tYc });
      if (this.tUs == null) {
        this.tUs = new CommonPlayer(this.tUB);
      }
      this.tUs.reset();
      if (this.tYc.startsWith("file://")) {
        this.tYc = this.tYc.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.tUs.setDataSource(this.tYc);
        this.tUs.prepare();
        bc((float)this.tVP.gSR);
        setVolume(this.tVP.volume);
        cVA();
        AppMethodBeat.o(137362);
        return;
      }
      catch (Exception paramf)
      {
        ad.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
        d(this.tVP, 501);
        e(this.tVP, 501);
        continue;
      }
      paramf = null;
      try
      {
        URL localURL = new URL(this.cTT);
        paramf = localURL;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "initPlayer", new Object[0]);
          ad.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + localException.getMessage());
        }
        if (this.tUs != null) {
          break label677;
        }
        this.tUs = new CommonPlayer(this.tUB);
        this.tUs.reset();
        if (this.tUw != null) {
          break label702;
        }
        this.tUw = new com.tencent.mm.plugin.music.g.a.b();
        if (this.tVP != null) {
          break label835;
        }
      }
      if (paramf != null) {
        break;
      }
      ad.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
      d(this.tVP, 500);
      e(this.tVP, 500);
    }
    label677:
    label702:
    label835:
    for (String str = "invalidReferrer";; str = this.tVP.gTa)
    {
      for (;;)
      {
        ad.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
        this.tUw.hG(this.cTT, str);
        try
        {
          this.tUs.setDataSource(this.tUw, Uri.parse(paramf.toString()));
          this.tUs.prepare();
        }
        catch (Exception paramf)
        {
          ad.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
          ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
          d(this.tVP, 501);
          e(this.tVP, 501);
        }
      }
      break;
    }
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(193678);
    if ((this.tVP != null) && (this.tVP.f(paramf)))
    {
      ad.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.cTT });
      if ((paramf.gSR > 0.0D) && (paramf.gSR != this.tVP.gSR))
      {
        ad.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(paramf.gSR) });
        bc((float)paramf.gSR);
        this.tVP.gSR = paramf.gSR;
      }
      if ((paramf.volume >= 0.0F) && (paramf.volume != this.tVP.volume))
      {
        ad.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(paramf.volume) });
        setVolume(paramf.volume);
        this.tVP.volume = paramf.volume;
      }
    }
    AppMethodBeat.o(193678);
  }
  
  public final boolean ox(int paramInt)
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
    if (this.tUs != null)
    {
      I(this.tVP);
      this.tUs.seekTo(paramInt);
    }
    AppMethodBeat.o(137374);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137364);
    this.tWc = false;
    ad.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.tUs != null) && (azF())) {
      try
      {
        this.tUs.pause();
        AppMethodBeat.o(137364);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.tVP, 503);
        e(this.tVP, 503);
      }
    }
    AppMethodBeat.o(137364);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137376);
    ad.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.tUs != null)
    {
      this.tUs.release();
      this.tUs = null;
    }
    cTN();
    AppMethodBeat.o(137376);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137367);
    this.bxy = 0;
    boolean bool1 = cUd();
    boolean bool2 = azF();
    ad.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((this.tUs == null) || (bool1) || (bool2) || (k.cVk().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.tUs.start();
        this.rdQ = true;
        AppMethodBeat.o(137367);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.tVP, 502);
        e(this.tVP, 502);
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
      cVG();
      if (this.tUs != null) {
        this.tUs.stop();
      }
      if (this.tYb != null)
      {
        this.tYb.isStop = true;
        this.tYb = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.tVP, 504);
        e(this.tVP, 504);
      }
    }
    k.cVk().bfc();
    this.rdQ = false;
    this.tWc = false;
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
            if ((e.this.tUs != null) && (e.this.azF())) {
              e.this.cUk();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e
 * JD-Core Version:    0.7.0.1
 */