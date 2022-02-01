package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.c;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public final class e
  extends a
{
  CommonPlayer FOF;
  boolean FOH;
  private com.tencent.mm.plugin.music.g.a.b FOK;
  private long FOL;
  private boolean FOM;
  private PlayerListenerCallback FOO;
  f FQe;
  private c FQf;
  public boolean FQs;
  a FTg;
  private String FTh;
  AudioFormat.AudioType audioType;
  int bpq;
  String fna;
  int fod;
  
  public e()
  {
    AppMethodBeat.i(137361);
    this.fna = "";
    this.bpq = 0;
    this.fod = 0;
    this.FOL = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.FOM = false;
    this.FQs = false;
    this.FOO = new PlayerListenerCallback()
    {
      f FTi = null;
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137353);
        Log.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
        AppMethodBeat.o(137353);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137355);
        Log.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        paramAnonymousBaseMediaPlayer = k.fet().fed();
        if (paramAnonymousBaseMediaPlayer == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        this.FTi = e.this.FQe;
        if (this.FTi == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          Log.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (e.this.bpq > 0)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.this.bpq) });
          AppMethodBeat.o(137355);
          return;
        }
        e locale = e.this;
        locale.bpq += 1;
        e.a(e.this);
        e.a(e.this, this.FTi, paramAnonymousInt2);
        if (paramAnonymousBaseMediaPlayer.f(this.FTi))
        {
          e.this.stopPlay();
          MMHandlerThread.postToMainThread(new e.1.1(this));
        }
        e.this.L(this.FTi);
        e.this.d(this.FTi, paramAnonymousInt2);
        if (e.this.FTg != null)
        {
          e.this.FTg.isStop = true;
          e.this.FTg = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
          g.aRR(e.this.fna);
        }
        AppMethodBeat.o(137355);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137356);
        Log.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
        AppMethodBeat.o(137356);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137354);
        Log.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (e.this.fod != 0)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.this.fod) });
          e.this.fod = 0;
          AppMethodBeat.o(137354);
          return;
        }
        Log.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.FTi == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          AppMethodBeat.o(137354);
          return;
        }
        e.this.M(this.FTi);
        if (e.this.bnx())
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
          e.this.J(this.FTi);
        }
        AppMethodBeat.o(137354);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137358);
        Log.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
        AppMethodBeat.o(137358);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(137357);
        Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 3)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
          this.FTi = e.this.FQe;
          if (this.FTi == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.G(this.FTi);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
          if (e.this.fod != 0)
          {
            Log.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.this.fod) });
            e.this.wG(e.this.fod);
          }
          Log.i("MicroMsg.Music.QQMusicPlayer", "start to play");
          if (k.fev().avy())
          {
            if (e.this.FQe == null)
            {
              Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
              AppMethodBeat.o(137357);
              return;
            }
            e.this.H(e.this.FQe);
            try
            {
              if (e.this.FOF != null)
              {
                e.this.FOF.start();
                if ((e.this.FOF.getCurrentAudioInformation() != null) && (e.this.FOF.getCurrentAudioInformation().getAudioType() != null))
                {
                  Log.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.this.FOF.getCurrentAudioInformation().getAudioType().getValue()) });
                  e.this.audioType = e.this.FOF.getCurrentAudioInformation().getAudioType();
                  e.b(e.this);
                }
              }
              e.this.FOH = true;
              AppMethodBeat.o(137357);
              return;
            }
            catch (Exception paramAnonymousBaseMediaPlayer)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramAnonymousBaseMediaPlayer, "_onPrepared", new Object[0]);
                e.this.d(e.this.FQe, 502);
                e.a(e.this, e.this.FQe, 502);
              }
            }
          }
          Log.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 4)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
          this.FTi = e.this.FQe;
          if (this.FTi == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.lzJ = SystemClock.elapsedRealtime();
          if (e.this.FSP == "pause") {
            e.this.J(this.FTi);
          }
          for (;;)
          {
            if (e.this.FTg != null) {
              e.this.FTg.isStop = true;
            }
            e.this.FTg = new e.a(e.this, (byte)0);
            paramAnonymousBaseMediaPlayer = e.this.FTg;
            paramAnonymousBaseMediaPlayer.isStop = false;
            ThreadPool.post(paramAnonymousBaseMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137357);
            return;
            e.this.I(this.FTi);
          }
        }
        if (paramAnonymousInt == 5)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
          if (this.FTi == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = e.this;
          paramAnonymousBaseMediaPlayer.FSS += SystemClock.elapsedRealtime() - e.this.lzJ;
          e.this.K(this.FTi);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.FTi == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = k.fet().fed();
          if (paramAnonymousBaseMediaPlayer == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          if (paramAnonymousBaseMediaPlayer.f(this.FTi))
          {
            e.this.L(this.FTi);
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = this.FTi;
          Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
          np localnp = new np();
          localnp.fMc.action = 18;
          localnp.fMc.fLV = paramAnonymousBaseMediaPlayer;
          EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
          if (this.FTi == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.a(e.this);
          e.this.FOH = false;
          e.this.O(e.this.FQe);
          if (e.this.FTg != null)
          {
            e.this.FTg.isStop = true;
            e.this.FTg = null;
          }
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 8)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 9) {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
        }
        AppMethodBeat.o(137357);
      }
    };
    com.tencent.mm.plugin.music.f.a.a.ffp();
    AppMethodBeat.o(137361);
  }
  
  private boolean ayN()
  {
    AppMethodBeat.i(256921);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 2)
      {
        AppMethodBeat.o(256921);
        return true;
      }
      AppMethodBeat.o(256921);
      return false;
    }
    AppMethodBeat.o(256921);
    return false;
  }
  
  private void bJ(float paramFloat)
  {
    AppMethodBeat.i(256918);
    if (this.FOF == null)
    {
      AppMethodBeat.o(256918);
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.FOF.setSpeed(paramFloat);
      AppMethodBeat.o(256918);
      return;
    }
    this.FOF.setSpeed(1.0F);
    AppMethodBeat.o(256918);
  }
  
  private boolean cmp()
  {
    AppMethodBeat.i(137369);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 3)
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
  
  private void e(f paramf, int paramInt)
  {
    AppMethodBeat.i(137378);
    if (this.FSQ != null) {
      this.FSQ.b(paramf, paramInt);
    }
    AppMethodBeat.o(137378);
  }
  
  private void ffo()
  {
    AppMethodBeat.i(137379);
    if (this.FOF != null)
    {
      this.aWa = fdx();
      this.FSS += SystemClock.elapsedRealtime() - this.lzJ;
      this.duration = getDuration();
      if (this.FSQ != null) {
        this.FSQ.a(this.FQe, this.aWa, this.FSS, this.duration);
      }
    }
    AppMethodBeat.o(137379);
  }
  
  private boolean isPaused()
  {
    AppMethodBeat.i(256922);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 5)
      {
        AppMethodBeat.o(256922);
        return true;
      }
      AppMethodBeat.o(256922);
      return false;
    }
    AppMethodBeat.o(256922);
    return false;
  }
  
  private void setVolume(float paramFloat)
  {
    AppMethodBeat.i(256919);
    if ((this.FOF != null) && (paramFloat >= 0.0F)) {
      this.FOF.setVolume(paramFloat, paramFloat);
    }
    AppMethodBeat.o(256919);
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(137368);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 4)
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
  
  public final boolean bny()
  {
    return (this.FOH) && (this.FQs);
  }
  
  public final boolean bnz()
  {
    AppMethodBeat.i(137370);
    if ((this.FOH) && (!cmp()))
    {
      AppMethodBeat.o(137370);
      return true;
    }
    AppMethodBeat.o(137370);
    return false;
  }
  
  protected final void fdW()
  {
    AppMethodBeat.i(137363);
    this.FSQ = ((d)com.tencent.mm.plugin.music.f.c.b.bm(d.class));
    this.FSR = k.fet().FQA;
    AppMethodBeat.o(137363);
  }
  
  public final void fde()
  {
    AppMethodBeat.i(137366);
    this.FQs = true;
    Log.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.FOF != null) && (bnx())) {
      try
      {
        this.FOF.pause();
        AppMethodBeat.o(137366);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.FQe, 503);
        e(this.FQe, 503);
      }
    }
    AppMethodBeat.o(137366);
  }
  
  public final boolean fdf()
  {
    return true;
  }
  
  public final c fdg()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137375);
    int n = getDuration();
    int i1 = fdx();
    boolean bool = bnx();
    if (this.FOF != null) {}
    for (int j = this.FOF.getBufferedPercentage();; j = 0)
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
      if (this.FQf != null)
      {
        localc = this.FQf;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.v(n, i1, i, j);
      }
      for (;;)
      {
        this.FQf.fMe = true;
        this.FQf.kkV = ffk();
        localc = this.FQf;
        AppMethodBeat.o(137375);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.FQf = new c(n, i1, i, j);
      }
    }
  }
  
  public final void fdr()
  {
    AppMethodBeat.i(137365);
    Log.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.fev().bYq();
    AppMethodBeat.o(137365);
  }
  
  public final int fdx()
  {
    AppMethodBeat.i(137372);
    if (this.FOF != null)
    {
      int i = (int)this.FOF.getCurrentPosition();
      AppMethodBeat.o(137372);
      return i;
    }
    AppMethodBeat.o(137372);
    return -1;
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(137377);
    f localf = k.fet().fed();
    if (localf == null)
    {
      AppMethodBeat.o(137377);
      return;
    }
    if ((localf.f(this.FQe)) && (this.FOF != null) && (bnx()))
    {
      int i = (int)this.FOF.getCurrentPosition();
      int j = this.FOF.getDuration();
      if ((i > 0) && (j > 0)) {
        fK(i, j);
      }
    }
    AppMethodBeat.o(137377);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137373);
    if (this.FOF != null)
    {
      int i = this.FOF.getDuration();
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
    long l2 = l1 - this.FOL;
    if ((this.FQe != null) && (this.FQe.f(paramf)) && (l2 <= 20L))
    {
      this.FQe = paramf;
      Log.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.fna, Long.valueOf(l2) });
      AppMethodBeat.o(137362);
      return;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137362);
      return;
    }
    this.aWa = 0L;
    this.lzJ = SystemClock.elapsedRealtime();
    this.FSS = 0L;
    this.duration = 0L;
    if (this.FSQ != null) {
      this.FSQ.v(paramf);
    }
    this.FOL = l1;
    this.FQe = paramf;
    Log.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.fod) });
    if ((this.FOF != null) && (bnx())) {
      this.FOF.stop();
    }
    com.tencent.mm.plugin.music.f.a.a.ffq();
    this.bpq = 0;
    this.fod = paramf.fod;
    this.audioType = null;
    this.FOM = false;
    Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.fna = this.FQe.playUrl;
    this.FTh = this.FQe.lVF;
    Log.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.fna, this.FTh });
    Log.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.FQe.lVz });
    if ((!Util.isNullOrNil(this.fna)) && (Util.isNullOrNil(this.FTh)))
    {
      g.aRL(this.fna);
      g.fu(this.fna, 0);
      g.fv(this.fna, 0);
      g.ca(this.FQe.playUrl, this.FQe.lVV);
    }
    if (!Util.isNullOrNil(this.FTh))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.FTh });
      if (this.FOF == null) {
        this.FOF = new CommonPlayer(this.FOO);
      }
      this.FOF.reset();
      if (this.FTh.startsWith("file://")) {
        this.FTh = this.FTh.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.FOF.setDataSource(this.FTh);
        this.FOF.prepare();
        bJ((float)this.FQe.lzL);
        setVolume(this.FQe.volume);
        ffj();
        AppMethodBeat.o(137362);
        return;
      }
      catch (Exception paramf)
      {
        Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
        d(this.FQe, 501);
        e(this.FQe, 501);
        continue;
      }
      paramf = null;
      try
      {
        URL localURL = new URL(this.fna);
        paramf = localURL;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "initPlayer", new Object[0]);
          Log.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + localException.getMessage());
        }
        if (this.FOF != null) {
          break label694;
        }
        this.FOF = new CommonPlayer(this.FOO);
        this.FOF.reset();
        if (this.FOK != null) {
          break label719;
        }
        this.FOK = new com.tencent.mm.plugin.music.g.a.b();
        if (this.FQe != null) {
          break label852;
        }
      }
      if (paramf != null) {
        break;
      }
      Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
      d(this.FQe, 500);
      e(this.FQe, 500);
    }
    label694:
    label719:
    label852:
    for (String str = "invalidReferrer";; str = this.FQe.lzU)
    {
      for (;;)
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
        this.FOK.jl(this.fna, str);
        try
        {
          this.FOF.setDataSource(this.FOK, Uri.parse(paramf.toString()));
          this.FOF.prepare();
        }
        catch (Exception paramf)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
          Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
          d(this.FQe, 501);
          e(this.FQe, 501);
        }
      }
      break;
    }
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(256924);
    if ((this.FQe != null) && (this.FQe.f(paramf)))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.fna });
      if ((paramf.lzL > 0.0D) && (paramf.lzL != this.FQe.lzL))
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(paramf.lzL) });
        bJ((float)paramf.lzL);
        this.FQe.lzL = paramf.lzL;
      }
      if ((paramf.volume >= 0.0F) && (paramf.volume != this.FQe.volume))
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(paramf.volume) });
        setVolume(paramf.volume);
        this.FQe.volume = paramf.volume;
      }
    }
    AppMethodBeat.o(256924);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137364);
    this.FQs = false;
    Log.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.FOF != null) && (bnx())) {
      try
      {
        this.FOF.pause();
        AppMethodBeat.o(137364);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.FQe, 503);
        e(this.FQe, 503);
      }
    }
    AppMethodBeat.o(137364);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137376);
    Log.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.FOF != null)
    {
      this.FOF.release();
      this.FOF = null;
    }
    fdd();
    AppMethodBeat.o(137376);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137367);
    this.bpq = 0;
    boolean bool1 = cmp();
    boolean bool2 = bnx();
    Log.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, paused:%b, isPrepared:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(isPaused()), Boolean.valueOf(ayN()) });
    if ((this.FOF == null) || ((!isPaused()) && (!ayN())) || (bool2) || (k.fev().avy())) {}
    for (;;)
    {
      try
      {
        this.FOF.start();
        this.FOH = true;
        AppMethodBeat.o(137367);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.FQe, 502);
        e(this.FQe, 502);
        continue;
      }
      Log.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137371);
    Log.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      ffo();
      if (this.FOF != null) {
        this.FOF.stop();
      }
      if (this.FTg != null)
      {
        this.FTg.isStop = true;
        this.FTg = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.FQe, 504);
        e(this.FQe, 504);
      }
    }
    k.fev().bYq();
    this.FOH = false;
    this.FQs = false;
    AppMethodBeat.o(137371);
  }
  
  public final boolean wG(int paramInt)
  {
    AppMethodBeat.i(137374);
    int i = getDuration();
    Log.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      Log.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137374);
      return false;
    }
    if (this.FOF != null)
    {
      N(this.FQe);
      this.FOF.seekTo(paramInt);
    }
    AppMethodBeat.o(137374);
    return true;
  }
  
  final class a
    implements Runnable
  {
    boolean isStop = true;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(137360);
      Log.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((e.this.FOF != null) && (e.this.bnx())) {
              e.this.fdz();
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
              Log.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + localException.getMessage());
            }
          }
        }
      }
      AppMethodBeat.o(137360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e
 * JD-Core Version:    0.7.0.1
 */