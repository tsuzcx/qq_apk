package com.tencent.mm.plugin.music.e;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.logic.d;
import com.tencent.mm.plugin.music.logic.j;
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
  CommonPlayer LJA;
  boolean LJC;
  private com.tencent.mm.plugin.music.g.a.b LJF;
  private long LJG;
  private boolean LJH;
  private String LJJ;
  private PlayerListenerCallback LJK;
  f LLa;
  private c LLb;
  public boolean LLo;
  a LOc;
  private String LOd;
  AudioFormat.AudioType audioType;
  int diT;
  String hrl;
  int startTime;
  
  public e()
  {
    AppMethodBeat.i(137361);
    this.hrl = "";
    this.diT = 0;
    this.startTime = 0;
    this.LJG = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.LJH = false;
    this.LJJ = "";
    this.LLo = false;
    this.LJK = new PlayerListenerCallback()
    {
      f LOe = null;
      
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
        paramAnonymousBaseMediaPlayer = j.gnw().gng();
        if (paramAnonymousBaseMediaPlayer == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        this.LOe = e.this.LLa;
        if (this.LOe == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          Log.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (e.this.diT > 0)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.this.diT) });
          AppMethodBeat.o(137355);
          return;
        }
        e locale = e.this;
        locale.diT += 1;
        e.a(e.this);
        e.a(e.this, this.LOe, paramAnonymousInt2);
        if (paramAnonymousBaseMediaPlayer.f(this.LOe))
        {
          e.this.stopPlay();
          MMHandlerThread.postToMainThread(new e.1.1(this));
        }
        e.this.Q(this.LOe);
        e.this.d(this.LOe, paramAnonymousInt2);
        if (e.this.LOc != null)
        {
          e.this.LOc.isStop = true;
          e.this.LOc = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
          g.aOJ(e.this.hrl);
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
        if (e.this.startTime != 0)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.this.startTime) });
          e.this.startTime = 0;
          AppMethodBeat.o(137354);
          return;
        }
        Log.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.LOe == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          AppMethodBeat.o(137354);
          return;
        }
        e.this.R(this.LOe);
        if (e.this.bLk())
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
          e.this.O(this.LOe);
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
          this.LOe = e.this.LLa;
          if (this.LOe == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.L(this.LOe);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
          if (e.this.startTime != 0)
          {
            Log.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.this.startTime) });
            e.this.wH(e.this.startTime);
          }
          Log.i("MicroMsg.Music.QQMusicPlayer", "start to play");
          if (j.gny().requestFocus())
          {
            if (e.this.LLa == null)
            {
              Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
              AppMethodBeat.o(137357);
              return;
            }
            e.this.M(e.this.LLa);
            try
            {
              if (e.this.LJA != null)
              {
                e.this.LJA.start();
                if ((e.this.LJA.getCurrentAudioInformation() != null) && (e.this.LJA.getCurrentAudioInformation().getAudioType() != null))
                {
                  Log.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.this.LJA.getCurrentAudioInformation().getAudioType().getValue()) });
                  e.this.audioType = e.this.LJA.getCurrentAudioInformation().getAudioType();
                  e.b(e.this);
                }
              }
              e.this.LJC = true;
              AppMethodBeat.o(137357);
              return;
            }
            catch (Exception paramAnonymousBaseMediaPlayer)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramAnonymousBaseMediaPlayer, "_onPrepared", new Object[0]);
                e.this.d(e.this.LLa, 502);
                e.a(e.this, e.this.LLa, 502);
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
          this.LOe = e.this.LLa;
          if (this.LOe == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.ork = SystemClock.elapsedRealtime();
          if (e.this.LNL == "pause") {
            e.this.O(this.LOe);
          }
          for (;;)
          {
            if (e.this.LOc != null) {
              e.this.LOc.isStop = true;
            }
            e.this.LOc = new e.a(e.this, (byte)0);
            paramAnonymousBaseMediaPlayer = e.this.LOc;
            paramAnonymousBaseMediaPlayer.isStop = false;
            ThreadPool.post(paramAnonymousBaseMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137357);
            return;
            e.this.N(this.LOe);
          }
        }
        if (paramAnonymousInt == 5)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
          if (this.LOe == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = e.this;
          paramAnonymousBaseMediaPlayer.LNO += SystemClock.elapsedRealtime() - e.this.ork;
          e.this.P(this.LOe);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.LOe == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = j.gnw().gng();
          if (paramAnonymousBaseMediaPlayer == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          if (paramAnonymousBaseMediaPlayer.f(this.LOe))
          {
            e.this.Q(this.LOe);
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = this.LOe;
          Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
          ox localox = new ox();
          localox.hRN.action = 18;
          localox.hRN.hRG = paramAnonymousBaseMediaPlayer;
          localox.asyncPublish(Looper.getMainLooper());
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
          if (this.LOe == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.a(e.this);
          e.this.LJC = false;
          e.this.T(e.this.LLa);
          if (e.this.LOc != null)
          {
            e.this.LOc.isStop = true;
            e.this.LOc = null;
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
    com.tencent.mm.plugin.music.e.a.a.goy();
    AppMethodBeat.o(137361);
  }
  
  private void cN(float paramFloat)
  {
    AppMethodBeat.i(270850);
    if (this.LJA == null)
    {
      AppMethodBeat.o(270850);
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.LJA.setSpeed(paramFloat);
      AppMethodBeat.o(270850);
      return;
    }
    this.LJA.setSpeed(1.0F);
    AppMethodBeat.o(270850);
  }
  
  private boolean cNW()
  {
    AppMethodBeat.i(137369);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 3)
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
  
  private boolean cxs()
  {
    AppMethodBeat.i(270851);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 2)
      {
        AppMethodBeat.o(270851);
        return true;
      }
      AppMethodBeat.o(270851);
      return false;
    }
    AppMethodBeat.o(270851);
    return false;
  }
  
  private void e(f paramf, int paramInt)
  {
    AppMethodBeat.i(137378);
    if (this.LNM != null) {
      this.LNM.b(paramf, paramInt);
    }
    AppMethodBeat.o(137378);
  }
  
  private void gox()
  {
    AppMethodBeat.i(137379);
    if (this.LJA != null)
    {
      this.cPW = gmA();
      this.LNO += SystemClock.elapsedRealtime() - this.ork;
      this.duration = getDuration();
      if (this.LNM != null) {
        this.LNM.a(this.LLa, this.cPW, this.LNO, this.duration);
      }
    }
    AppMethodBeat.o(137379);
  }
  
  private boolean isPaused()
  {
    AppMethodBeat.i(270853);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 5)
      {
        AppMethodBeat.o(270853);
        return true;
      }
      AppMethodBeat.o(270853);
      return false;
    }
    AppMethodBeat.o(270853);
    return false;
  }
  
  public final boolean bLk()
  {
    AppMethodBeat.i(137368);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 4)
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
  
  public final boolean bLl()
  {
    return (this.LJC) && (this.LLo);
  }
  
  public final boolean bLm()
  {
    AppMethodBeat.i(137370);
    if ((this.LJC) && (!cNW()))
    {
      AppMethodBeat.o(137370);
      return true;
    }
    AppMethodBeat.o(137370);
    return false;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137373);
    if (this.LJA != null)
    {
      int i = this.LJA.getDuration();
      AppMethodBeat.o(137373);
      return i;
    }
    AppMethodBeat.o(137373);
    return -1;
  }
  
  public final int gmA()
  {
    AppMethodBeat.i(137372);
    if (this.LJA != null)
    {
      int i = (int)this.LJA.getCurrentPosition();
      AppMethodBeat.o(137372);
      return i;
    }
    AppMethodBeat.o(137372);
    return -1;
  }
  
  public final void gmC()
  {
    AppMethodBeat.i(137377);
    f localf = j.gnw().gng();
    if (localf == null)
    {
      AppMethodBeat.o(137377);
      return;
    }
    if ((localf.f(this.LLa)) && (this.LJA != null) && (bLk()))
    {
      int i = (int)this.LJA.getCurrentPosition();
      int j = this.LJA.getDuration();
      if ((i > 0) && (j > 0)) {
        onProgress(i, j);
      }
    }
    AppMethodBeat.o(137377);
  }
  
  protected final void gmZ()
  {
    AppMethodBeat.i(137363);
    this.LNM = ((d)com.tencent.mm.plugin.music.e.c.b.bU(d.class));
    this.LNN = j.gnw().LLw;
    if (this.LNN != null) {
      this.LJJ = this.LNN.gmU();
    }
    AppMethodBeat.o(137363);
  }
  
  public final void gmh()
  {
    AppMethodBeat.i(137366);
    this.LLo = true;
    Log.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.LJA != null) && (bLk())) {
      try
      {
        this.LJA.pause();
        AppMethodBeat.o(137366);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.LLa, 503);
        e(this.LLa, 503);
      }
    }
    AppMethodBeat.o(137366);
  }
  
  public final boolean gmi()
  {
    return true;
  }
  
  public final c gmj()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137375);
    int n = getDuration();
    int i1 = gmA();
    boolean bool = bLk();
    if (this.LJA != null) {}
    for (int j = this.LJA.getBufferedPercentage();; j = 0)
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
      if (this.LLb != null)
      {
        localc = this.LLb;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.B(n, i1, i, j);
      }
      for (;;)
      {
        this.LLb.hRO = true;
        this.LLb.mLR = got();
        localc = this.LLb;
        AppMethodBeat.o(137375);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.LLb = new c(n, i1, i, j);
      }
    }
  }
  
  public final void gmu()
  {
    AppMethodBeat.i(137365);
    Log.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    j.gny().cyG();
    AppMethodBeat.o(137365);
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(137362);
    super.h(paramf);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.LJG;
    if ((this.LLa != null) && (this.LLa.f(paramf)) && (l2 <= 20L))
    {
      this.LLa = paramf;
      Log.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.hrl, Long.valueOf(l2) });
      AppMethodBeat.o(137362);
      return;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137362);
      return;
    }
    this.cPW = 0L;
    this.ork = SystemClock.elapsedRealtime();
    this.LNO = 0L;
    this.duration = 0L;
    if (this.LNM != null) {
      this.LNM.z(paramf);
    }
    this.LJG = l1;
    this.LLa = paramf;
    Log.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.startTime) });
    if ((this.LJA != null) && (bLk())) {
      this.LJA.stop();
    }
    com.tencent.mm.plugin.music.e.a.a.goz();
    this.diT = 0;
    this.startTime = paramf.startTime;
    this.audioType = null;
    this.LJH = false;
    Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.hrl = this.LLa.playUrl;
    this.LOd = this.LLa.oOH;
    Log.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.hrl, this.LOd });
    Log.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.LLa.oOB });
    if ((!Util.isNullOrNil(this.hrl)) && (Util.isNullOrNil(this.LOd)))
    {
      g.aOD(this.hrl);
      g.gn(this.hrl, 0);
      g.go(this.hrl, 0);
      g.cw(this.LLa.playUrl, this.LLa.oOX);
    }
    if (!Util.isNullOrNil(this.LOd))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.LOd });
      if (this.LJA == null) {
        this.LJA = new CommonPlayer(this.LJK);
      }
      this.LJA.reset();
      if (this.LOd.startsWith("file://")) {
        this.LOd = this.LOd.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.LJA.setDataSource(this.LOd);
        this.LJA.prepare();
        cN((float)this.LLa.orm);
        setVolume(this.LLa.volume);
        gos();
        AppMethodBeat.o(137362);
        return;
      }
      catch (Exception paramf)
      {
        Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
        d(this.LLa, 501);
        e(this.LLa, 501);
        continue;
      }
      paramf = null;
      try
      {
        URL localURL = new URL(this.hrl);
        paramf = localURL;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "initPlayer", new Object[0]);
          Log.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + localException.getMessage());
        }
        if (this.LJA != null) {
          break label694;
        }
        this.LJA = new CommonPlayer(this.LJK);
        this.LJA.reset();
        if (this.LJF != null) {
          break label719;
        }
        this.LJF = new com.tencent.mm.plugin.music.g.a.b();
        if (this.LLa != null) {
          break label892;
        }
      }
      if (paramf != null) {
        break;
      }
      Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
      d(this.LLa, 500);
      e(this.LLa, 500);
    }
    label694:
    label719:
    label892:
    for (String str = "invalidReferrer";; str = this.LLa.orv)
    {
      for (;;)
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
        this.LJF.kA(this.hrl, str);
        try
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "QQMusicPlayer temp cache dir:%s", new Object[] { this.LJJ });
          if (!TextUtils.isEmpty(this.LJJ)) {
            this.LJA.setOnlinePlayCacheDir(this.LJJ);
          }
          this.LJA.setDataSource(this.LJF, Uri.parse(paramf.toString()));
          this.LJA.prepare();
        }
        catch (Exception paramf)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
          Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
          d(this.LLa, 501);
          e(this.LLa, 501);
        }
      }
      break;
    }
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(270893);
    if ((this.LLa != null) && (this.LLa.f(paramf)))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.hrl });
      if ((paramf.orm > 0.0D) && (paramf.orm != this.LLa.orm))
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(paramf.orm) });
        cN((float)paramf.orm);
        this.LLa.orm = paramf.orm;
      }
      if ((paramf.volume >= 0.0F) && (paramf.volume != this.LLa.volume))
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(paramf.volume) });
        setVolume(paramf.volume);
        this.LLa.volume = paramf.volume;
      }
    }
    AppMethodBeat.o(270893);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137364);
    this.LLo = false;
    Log.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.LJA != null) && (bLk())) {
      try
      {
        this.LJA.pause();
        AppMethodBeat.o(137364);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.LLa, 503);
        e(this.LLa, 503);
      }
    }
    AppMethodBeat.o(137364);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137376);
    Log.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.LJA != null)
    {
      this.LJA.release();
      this.LJA = null;
    }
    gmg();
    AppMethodBeat.o(137376);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137367);
    this.diT = 0;
    boolean bool1 = cNW();
    boolean bool2 = bLk();
    Log.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, paused:%b, isPrepared:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(isPaused()), Boolean.valueOf(cxs()) });
    if ((this.LJA == null) || ((!isPaused()) && (!cxs())) || (bool2) || (j.gny().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.LJA.start();
        this.LJC = true;
        AppMethodBeat.o(137367);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.LLa, 502);
        e(this.LLa, 502);
        continue;
      }
      Log.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    }
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(270856);
    if ((this.LJA != null) && (paramFloat >= 0.0F)) {
      this.LJA.setVolume(paramFloat, paramFloat);
    }
    AppMethodBeat.o(270856);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137371);
    Log.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      gox();
      if (this.LJA != null) {
        this.LJA.stop();
      }
      if (this.LOc != null)
      {
        this.LOc.isStop = true;
        this.LOc = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.LLa, 504);
        e(this.LLa, 504);
      }
    }
    j.gny().cyG();
    this.LJC = false;
    this.LLo = false;
    AppMethodBeat.o(137371);
  }
  
  public final boolean wH(int paramInt)
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
    if (this.LJA != null)
    {
      S(this.LLa);
      this.LJA.seekTo(paramInt);
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
            if ((e.this.LJA != null) && (e.this.bLk())) {
              e.this.gmC();
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
 * Qualified Name:     com.tencent.mm.plugin.music.e.e
 * JD-Core Version:    0.7.0.1
 */