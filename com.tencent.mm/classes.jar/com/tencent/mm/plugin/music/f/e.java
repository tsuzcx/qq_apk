package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  int bvh;
  String cRq;
  int cSh;
  CommonPlayer vda;
  boolean vdc;
  private com.tencent.mm.plugin.music.g.a.b vdf;
  private long vdg;
  private boolean vdh;
  private PlayerListenerCallback vdj;
  public boolean veM;
  f vey;
  private c vez;
  a vgO;
  private String vgP;
  
  public e()
  {
    AppMethodBeat.i(137361);
    this.cRq = "";
    this.bvh = 0;
    this.cSh = 0;
    this.vdg = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.vdh = false;
    this.veM = false;
    this.vdj = new PlayerListenerCallback()
    {
      f vgQ = null;
      
      private void djn()
      {
        AppMethodBeat.i(137359);
        ac.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
        if (e.this.cSh != 0)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.this.cSh) });
          e.this.pl(e.this.cSh);
          AppMethodBeat.o(137359);
          return;
        }
        ac.i("MicroMsg.Music.QQMusicPlayer", "start to play");
        if (k.diQ().requestFocus())
        {
          if (e.this.vey == null)
          {
            ac.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137359);
            return;
          }
          e.this.D(e.this.vey);
          try
          {
            if (e.this.vda != null)
            {
              e.this.vda.start();
              if ((e.this.vda.getCurrentAudioInformation() != null) && (e.this.vda.getCurrentAudioInformation().getAudioType() != null))
              {
                ac.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.this.vda.getCurrentAudioInformation().getAudioType().getValue()) });
                e.this.audioType = e.this.vda.getCurrentAudioInformation().getAudioType();
                e.b(e.this);
              }
            }
            e.this.vdc = true;
            AppMethodBeat.o(137359);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "_onPrepared", new Object[0]);
              e.this.d(e.this.vey, 502);
              e.a(e.this, e.this.vey, 502);
            }
          }
        }
        ac.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
        AppMethodBeat.o(137359);
      }
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137353);
        ac.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
        AppMethodBeat.o(137353);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137355);
        ac.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        paramAnonymousBaseMediaPlayer = k.diO().diz();
        if (paramAnonymousBaseMediaPlayer == null)
        {
          ac.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        this.vgQ = e.this.vey;
        if (this.vgQ == null)
        {
          ac.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        boolean bool = ax.isNetworkConnected(ai.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ac.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (e.this.bvh > 0)
        {
          ac.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.this.bvh) });
          AppMethodBeat.o(137355);
          return;
        }
        e locale = e.this;
        locale.bvh += 1;
        e.a(e.this);
        e.a(e.this, this.vgQ, paramAnonymousInt2);
        if (paramAnonymousBaseMediaPlayer.f(this.vgQ))
        {
          e.this.stopPlay();
          ap.f(new e.1.1(this));
        }
        e.this.H(this.vgQ);
        e.this.d(this.vgQ, paramAnonymousInt2);
        if (e.this.vgO != null)
        {
          e.this.vgO.isStop = true;
          e.this.vgO = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
          g.anu(e.this.cRq);
        }
        AppMethodBeat.o(137355);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137356);
        ac.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
        AppMethodBeat.o(137356);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137354);
        ac.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.this.cSh != 0)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.this.cSh) });
          e.this.cSh = 0;
          djn();
          AppMethodBeat.o(137354);
          return;
        }
        ac.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.vgQ == null)
        {
          ac.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          AppMethodBeat.o(137354);
          return;
        }
        e.this.I(this.vgQ);
        if (e.this.aGv())
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
          e.this.F(this.vgQ);
        }
        AppMethodBeat.o(137354);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137358);
        ac.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
        AppMethodBeat.o(137358);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137357);
        ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 3)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
          ac.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
          this.vgQ = e.this.vey;
          if (this.vgQ == null)
          {
            ac.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.C(this.vgQ);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
          djn();
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 4)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
          ac.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
          this.vgQ = e.this.vey;
          if (this.vgQ == null)
          {
            ac.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.hto = SystemClock.elapsedRealtime();
          if (e.this.vgw == "pause") {
            e.this.F(this.vgQ);
          }
          for (;;)
          {
            if (e.this.vgO != null) {
              e.this.vgO.isStop = true;
            }
            e.this.vgO = new e.a(e.this, (byte)0);
            paramAnonymousBaseMediaPlayer = e.this.vgO;
            paramAnonymousBaseMediaPlayer.isStop = false;
            com.tencent.mm.sdk.g.b.c(paramAnonymousBaseMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137357);
            return;
            e.this.E(this.vgQ);
          }
        }
        if (paramAnonymousInt == 5)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
          ac.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
          if (this.vgQ == null)
          {
            ac.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = e.this;
          paramAnonymousBaseMediaPlayer.vgz += SystemClock.elapsedRealtime() - e.this.hto;
          e.this.G(this.vgQ);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          ac.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.vgQ == null)
          {
            ac.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = k.diO().diz();
          if (paramAnonymousBaseMediaPlayer == null)
          {
            ac.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          if (paramAnonymousBaseMediaPlayer.f(this.vgQ))
          {
            e.this.H(this.vgQ);
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = this.vgQ;
          ac.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
          lw locallw = new lw();
          locallw.dnW.action = 18;
          locallw.dnW.dnQ = paramAnonymousBaseMediaPlayer;
          com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
          ac.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
          if (this.vgQ == null)
          {
            ac.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.a(e.this);
          e.this.vdc = false;
          e.this.K(e.this.vey);
          if (e.this.vgO != null)
          {
            e.this.vgO.isStop = true;
            e.this.vgO = null;
          }
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 8)
        {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
          ac.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 9) {
          ac.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
        }
        AppMethodBeat.o(137357);
      }
    };
    com.tencent.mm.plugin.music.f.a.a.djo();
    AppMethodBeat.o(137361);
  }
  
  private void bj(float paramFloat)
  {
    AppMethodBeat.i(191309);
    if (this.vda == null)
    {
      AppMethodBeat.o(191309);
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      ac.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.vda.setSpeed(paramFloat);
      AppMethodBeat.o(191309);
      return;
    }
    this.vda.setSpeed(1.0F);
    AppMethodBeat.o(191309);
  }
  
  private boolean cDT()
  {
    AppMethodBeat.i(137369);
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 3)
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
  
  private void djm()
  {
    AppMethodBeat.i(137379);
    if (this.vda != null)
    {
      this.bci = dhO();
      this.vgz += SystemClock.elapsedRealtime() - this.hto;
      this.duration = getDuration();
      if (this.vgx != null) {
        this.vgx.a(this.vey, this.bci, this.vgz, this.duration);
      }
    }
    AppMethodBeat.o(137379);
  }
  
  private void e(f paramf, int paramInt)
  {
    AppMethodBeat.i(137378);
    if (this.vgx != null) {
      this.vgx.b(paramf, paramInt);
    }
    AppMethodBeat.o(137378);
  }
  
  private void setVolume(float paramFloat)
  {
    AppMethodBeat.i(191310);
    if ((this.vda != null) && (paramFloat >= 0.0F)) {
      this.vda.setVolume(paramFloat, paramFloat);
    }
    AppMethodBeat.o(191310);
  }
  
  public final void EM()
  {
    AppMethodBeat.i(137366);
    this.veM = true;
    ac.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.vda != null) && (aGv())) {
      try
      {
        this.vda.pause();
        AppMethodBeat.o(137366);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.vey, 503);
        e(this.vey, 503);
      }
    }
    AppMethodBeat.o(137366);
  }
  
  public final boolean aGv()
  {
    AppMethodBeat.i(137368);
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 4)
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
  
  public final boolean aGw()
  {
    return (this.vdc) && (this.veM);
  }
  
  public final boolean aGx()
  {
    AppMethodBeat.i(137370);
    if ((this.vdc) && (!cDT()))
    {
      AppMethodBeat.o(137370);
      return true;
    }
    AppMethodBeat.o(137370);
    return false;
  }
  
  public final void dhJ()
  {
    AppMethodBeat.i(137365);
    ac.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.diQ().bjF();
    AppMethodBeat.o(137365);
  }
  
  public final int dhO()
  {
    AppMethodBeat.i(137372);
    if (this.vda != null)
    {
      int i = (int)this.vda.getCurrentPosition();
      AppMethodBeat.o(137372);
      return i;
    }
    AppMethodBeat.o(137372);
    return -1;
  }
  
  public final void dhQ()
  {
    AppMethodBeat.i(137377);
    f localf = k.diO().diz();
    if (localf == null)
    {
      AppMethodBeat.o(137377);
      return;
    }
    if ((localf.f(this.vey)) && (this.vda != null) && (aGv()))
    {
      int i = (int)this.vda.getCurrentPosition();
      int j = this.vda.getDuration();
      if ((i > 0) && (j > 0)) {
        eV(i, j);
      }
    }
    AppMethodBeat.o(137377);
  }
  
  public final boolean dhw()
  {
    return true;
  }
  
  public final c dhx()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137375);
    int n = getDuration();
    int i1 = dhO();
    boolean bool = aGv();
    if (this.vda != null) {}
    for (int j = this.vda.getBufferedPercentage();; j = 0)
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
      if (this.vez != null)
      {
        localc = this.vez;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.t(n, i1, i, j);
      }
      for (;;)
      {
        this.vez.dnY = true;
        this.vez.hNN = djh();
        localc = this.vez;
        AppMethodBeat.o(137375);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.vez = new c(n, i1, i, j);
      }
    }
  }
  
  protected final void dir()
  {
    AppMethodBeat.i(137363);
    this.vgx = ((d)com.tencent.mm.plugin.music.f.c.b.aQ(d.class));
    this.vgy = k.diO().veU;
    AppMethodBeat.o(137363);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137373);
    if (this.vda != null)
    {
      int i = this.vda.getDuration();
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
    long l2 = l1 - this.vdg;
    if ((this.vey != null) && (this.vey.f(paramf)) && (l2 <= 3000L))
    {
      this.vey = paramf;
      ac.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.cRq, Long.valueOf(l2) });
      AppMethodBeat.o(137362);
      return;
    }
    if (paramf == null)
    {
      ac.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137362);
      return;
    }
    this.bci = 0L;
    this.hto = SystemClock.elapsedRealtime();
    this.vgz = 0L;
    this.duration = 0L;
    if (this.vgx != null) {
      this.vgx.v(paramf);
    }
    this.vdg = l1;
    this.vey = paramf;
    ac.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.cSh) });
    if ((this.vda != null) && (aGv())) {
      this.vda.stop();
    }
    com.tencent.mm.plugin.music.f.a.a.djp();
    this.bvh = 0;
    this.cSh = paramf.cSh;
    this.audioType = null;
    this.vdh = false;
    ac.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.cRq = this.vey.playUrl;
    this.vgP = this.vey.hOe;
    ac.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.cRq, this.vgP });
    ac.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.vey.hNY });
    if ((!bs.isNullOrNil(this.cRq)) && (bs.isNullOrNil(this.vgP)))
    {
      g.ano(this.cRq);
      g.ee(this.cRq, 0);
      g.ef(this.cRq, 0);
    }
    if (!bs.isNullOrNil(this.vgP))
    {
      ac.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.vgP });
      if (this.vda == null) {
        this.vda = new CommonPlayer(this.vdj);
      }
      this.vda.reset();
      if (this.vgP.startsWith("file://")) {
        this.vgP = this.vgP.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.vda.setDataSource(this.vgP);
        this.vda.prepare();
        bj((float)this.vey.htq);
        setVolume(this.vey.volume);
        djg();
        AppMethodBeat.o(137362);
        return;
      }
      catch (Exception paramf)
      {
        ac.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
        ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
        d(this.vey, 501);
        e(this.vey, 501);
        continue;
      }
      paramf = null;
      try
      {
        URL localURL = new URL(this.cRq);
        paramf = localURL;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "initPlayer", new Object[0]);
          ac.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + localException.getMessage());
        }
        if (this.vda != null) {
          break label677;
        }
        this.vda = new CommonPlayer(this.vdj);
        this.vda.reset();
        if (this.vdf != null) {
          break label702;
        }
        this.vdf = new com.tencent.mm.plugin.music.g.a.b();
        if (this.vey != null) {
          break label835;
        }
      }
      if (paramf != null) {
        break;
      }
      ac.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
      d(this.vey, 500);
      e(this.vey, 500);
    }
    label677:
    label702:
    label835:
    for (String str = "invalidReferrer";; str = this.vey.htz)
    {
      for (;;)
      {
        ac.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
        this.vdf.hZ(this.cRq, str);
        try
        {
          this.vda.setDataSource(this.vdf, Uri.parse(paramf.toString()));
          this.vda.prepare();
        }
        catch (Exception paramf)
        {
          ac.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
          ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
          d(this.vey, 501);
          e(this.vey, 501);
        }
      }
      break;
    }
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(191311);
    if ((this.vey != null) && (this.vey.f(paramf)))
    {
      ac.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.cRq });
      if ((paramf.htq > 0.0D) && (paramf.htq != this.vey.htq))
      {
        ac.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(paramf.htq) });
        bj((float)paramf.htq);
        this.vey.htq = paramf.htq;
      }
      if ((paramf.volume >= 0.0F) && (paramf.volume != this.vey.volume))
      {
        ac.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(paramf.volume) });
        setVolume(paramf.volume);
        this.vey.volume = paramf.volume;
      }
    }
    AppMethodBeat.o(191311);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137364);
    this.veM = false;
    ac.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.vda != null) && (aGv())) {
      try
      {
        this.vda.pause();
        AppMethodBeat.o(137364);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.vey, 503);
        e(this.vey, 503);
      }
    }
    AppMethodBeat.o(137364);
  }
  
  public final boolean pl(int paramInt)
  {
    AppMethodBeat.i(137374);
    int i = getDuration();
    ac.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ac.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137374);
      return false;
    }
    if (this.vda != null)
    {
      J(this.vey);
      this.vda.seekTo(paramInt);
    }
    AppMethodBeat.o(137374);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(137376);
    ac.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.vda != null)
    {
      this.vda.release();
      this.vda = null;
    }
    dhv();
    AppMethodBeat.o(137376);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137367);
    this.bvh = 0;
    boolean bool1 = cDT();
    boolean bool2 = aGv();
    ac.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((this.vda == null) || (bool1) || (bool2) || (k.diQ().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.vda.start();
        this.vdc = true;
        AppMethodBeat.o(137367);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.vey, 502);
        e(this.vey, 502);
        continue;
      }
      ac.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137371);
    ac.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      djm();
      if (this.vda != null) {
        this.vda.stop();
      }
      if (this.vgO != null)
      {
        this.vgO.isStop = true;
        this.vgO = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.vey, 504);
        e(this.vey, 504);
      }
    }
    k.diQ().bjF();
    this.vdc = false;
    this.veM = false;
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
      ac.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((e.this.vda != null) && (e.this.aGv())) {
              e.this.dhQ();
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
              ac.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + localException.getMessage());
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