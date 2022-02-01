package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
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
  CommonPlayer AhJ;
  boolean AhL;
  private com.tencent.mm.plugin.music.g.a.b AhO;
  private long AhP;
  private boolean AhQ;
  private PlayerListenerCallback AhS;
  f Ajg;
  private c Ajh;
  public boolean Aju;
  a AlZ;
  private String Ama;
  AudioFormat.AudioType audioType;
  int bFM;
  String dus;
  int dvv;
  
  public e()
  {
    AppMethodBeat.i(137361);
    this.dus = "";
    this.bFM = 0;
    this.dvv = 0;
    this.AhP = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.AhQ = false;
    this.Aju = false;
    this.AhS = new PlayerListenerCallback()
    {
      f Amb = null;
      
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
        paramAnonymousBaseMediaPlayer = k.euj().etU();
        if (paramAnonymousBaseMediaPlayer == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        this.Amb = e.this.Ajg;
        if (this.Amb == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
          AppMethodBeat.o(137355);
          return;
        }
        boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          Log.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
        }
        if (e.this.bFM > 0)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.this.bFM) });
          AppMethodBeat.o(137355);
          return;
        }
        e locale = e.this;
        locale.bFM += 1;
        e.a(e.this);
        e.a(e.this, this.Amb, paramAnonymousInt2);
        if (paramAnonymousBaseMediaPlayer.f(this.Amb))
        {
          e.this.stopPlay();
          MMHandlerThread.postToMainThread(new e.1.1(this));
        }
        e.this.L(this.Amb);
        e.this.d(this.Amb, paramAnonymousInt2);
        if (e.this.AlZ != null)
        {
          e.this.AlZ.isStop = true;
          e.this.AlZ = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
          g.aHD(e.this.dus);
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
        if (e.this.dvv != 0)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.this.dvv) });
          e.this.dvv = 0;
          AppMethodBeat.o(137354);
          return;
        }
        Log.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
        if (this.Amb == null)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          AppMethodBeat.o(137354);
          return;
        }
        e.this.M(this.Amb);
        if (e.this.bec())
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
          e.this.J(this.Amb);
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
          this.Amb = e.this.Ajg;
          if (this.Amb == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.G(this.Amb);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
          if (e.this.dvv != 0)
          {
            Log.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.this.dvv) });
            e.this.tG(e.this.dvv);
          }
          Log.i("MicroMsg.Music.QQMusicPlayer", "start to play");
          if (k.eul().requestFocus())
          {
            if (e.this.Ajg == null)
            {
              Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
              AppMethodBeat.o(137357);
              return;
            }
            e.this.H(e.this.Ajg);
            try
            {
              if (e.this.AhJ != null)
              {
                e.this.AhJ.start();
                if ((e.this.AhJ.getCurrentAudioInformation() != null) && (e.this.AhJ.getCurrentAudioInformation().getAudioType() != null))
                {
                  Log.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.this.AhJ.getCurrentAudioInformation().getAudioType().getValue()) });
                  e.this.audioType = e.this.AhJ.getCurrentAudioInformation().getAudioType();
                  e.b(e.this);
                }
              }
              e.this.AhL = true;
              AppMethodBeat.o(137357);
              return;
            }
            catch (Exception paramAnonymousBaseMediaPlayer)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramAnonymousBaseMediaPlayer, "_onPrepared", new Object[0]);
                e.this.d(e.this.Ajg, 502);
                e.a(e.this, e.this.Ajg, 502);
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
          this.Amb = e.this.Ajg;
          if (this.Amb == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.this.iJF = SystemClock.elapsedRealtime();
          if (e.this.AlI == "pause") {
            e.this.J(this.Amb);
          }
          for (;;)
          {
            if (e.this.AlZ != null) {
              e.this.AlZ.isStop = true;
            }
            e.this.AlZ = new e.a(e.this, (byte)0);
            paramAnonymousBaseMediaPlayer = e.this.AlZ;
            paramAnonymousBaseMediaPlayer.isStop = false;
            ThreadPool.post(paramAnonymousBaseMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137357);
            return;
            e.this.I(this.Amb);
          }
        }
        if (paramAnonymousInt == 5)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
          if (this.Amb == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = e.this;
          paramAnonymousBaseMediaPlayer.AlL += SystemClock.elapsedRealtime() - e.this.iJF;
          e.this.K(this.Amb);
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.Amb == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = k.euj().etU();
          if (paramAnonymousBaseMediaPlayer == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          if (paramAnonymousBaseMediaPlayer.f(this.Amb))
          {
            e.this.L(this.Amb);
            AppMethodBeat.o(137357);
            return;
          }
          paramAnonymousBaseMediaPlayer = this.Amb;
          Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
          mx localmx = new mx();
          localmx.dSE.action = 18;
          localmx.dSE.dSy = paramAnonymousBaseMediaPlayer;
          EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
          AppMethodBeat.o(137357);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          Log.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
          Log.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
          if (this.Amb == null)
          {
            Log.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            AppMethodBeat.o(137357);
            return;
          }
          e.a(e.this);
          e.this.AhL = false;
          e.this.O(e.this.Ajg);
          if (e.this.AlZ != null)
          {
            e.this.AlZ.isStop = true;
            e.this.AlZ = null;
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
    com.tencent.mm.plugin.music.f.a.a.euV();
    AppMethodBeat.o(137361);
  }
  
  private boolean asa()
  {
    AppMethodBeat.i(198182);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 2)
      {
        AppMethodBeat.o(198182);
        return true;
      }
      AppMethodBeat.o(198182);
      return false;
    }
    AppMethodBeat.o(198182);
    return false;
  }
  
  private void bE(float paramFloat)
  {
    AppMethodBeat.i(198180);
    if (this.AhJ == null)
    {
      AppMethodBeat.o(198180);
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.AhJ.setSpeed(paramFloat);
      AppMethodBeat.o(198180);
      return;
    }
    this.AhJ.setSpeed(1.0F);
    AppMethodBeat.o(198180);
  }
  
  private boolean dFr()
  {
    AppMethodBeat.i(137369);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 3)
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
    if (this.AlJ != null) {
      this.AlJ.b(paramf, paramInt);
    }
    AppMethodBeat.o(137378);
  }
  
  private void euU()
  {
    AppMethodBeat.i(137379);
    if (this.AhJ != null)
    {
      this.bmy = etn();
      this.AlL += SystemClock.elapsedRealtime() - this.iJF;
      this.duration = getDuration();
      if (this.AlJ != null) {
        this.AlJ.a(this.Ajg, this.bmy, this.AlL, this.duration);
      }
    }
    AppMethodBeat.o(137379);
  }
  
  private boolean isPaused()
  {
    AppMethodBeat.i(198183);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 5)
      {
        AppMethodBeat.o(198183);
        return true;
      }
      AppMethodBeat.o(198183);
      return false;
    }
    AppMethodBeat.o(198183);
    return false;
  }
  
  private void setVolume(float paramFloat)
  {
    AppMethodBeat.i(198181);
    if ((this.AhJ != null) && (paramFloat >= 0.0F)) {
      this.AhJ.setVolume(paramFloat, paramFloat);
    }
    AppMethodBeat.o(198181);
  }
  
  public final boolean bec()
  {
    AppMethodBeat.i(137368);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 4)
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
  
  public final boolean bed()
  {
    return (this.AhL) && (this.Aju);
  }
  
  public final boolean bee()
  {
    AppMethodBeat.i(137370);
    if ((this.AhL) && (!dFr()))
    {
      AppMethodBeat.o(137370);
      return true;
    }
    AppMethodBeat.o(137370);
    return false;
  }
  
  public final void esU()
  {
    AppMethodBeat.i(137366);
    this.Aju = true;
    Log.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.AhJ != null) && (bec())) {
      try
      {
        this.AhJ.pause();
        AppMethodBeat.o(137366);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.Ajg, 503);
        e(this.Ajg, 503);
      }
    }
    AppMethodBeat.o(137366);
  }
  
  public final boolean esV()
  {
    return true;
  }
  
  public final c esW()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137375);
    int n = getDuration();
    int i1 = etn();
    boolean bool = bec();
    if (this.AhJ != null) {}
    for (int j = this.AhJ.getBufferedPercentage();; j = 0)
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
      if (this.Ajh != null)
      {
        localc = this.Ajh;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.t(n, i1, i, j);
      }
      for (;;)
      {
        this.Ajh.dSG = true;
        this.Ajh.jeQ = euQ();
        localc = this.Ajh;
        AppMethodBeat.o(137375);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.Ajh = new c(n, i1, i, j);
      }
    }
  }
  
  protected final void etM()
  {
    AppMethodBeat.i(137363);
    this.AlJ = ((d)com.tencent.mm.plugin.music.f.c.b.aS(d.class));
    this.AlK = k.euj().AjC;
    AppMethodBeat.o(137363);
  }
  
  public final void eth()
  {
    AppMethodBeat.i(137365);
    Log.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.eul().bLZ();
    AppMethodBeat.o(137365);
  }
  
  public final int etn()
  {
    AppMethodBeat.i(137372);
    if (this.AhJ != null)
    {
      int i = (int)this.AhJ.getCurrentPosition();
      AppMethodBeat.o(137372);
      return i;
    }
    AppMethodBeat.o(137372);
    return -1;
  }
  
  public final void etp()
  {
    AppMethodBeat.i(137377);
    f localf = k.euj().etU();
    if (localf == null)
    {
      AppMethodBeat.o(137377);
      return;
    }
    if ((localf.f(this.Ajg)) && (this.AhJ != null) && (bec()))
    {
      int i = (int)this.AhJ.getCurrentPosition();
      int j = this.AhJ.getDuration();
      if ((i > 0) && (j > 0)) {
        fn(i, j);
      }
    }
    AppMethodBeat.o(137377);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137373);
    if (this.AhJ != null)
    {
      int i = this.AhJ.getDuration();
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
    long l2 = l1 - this.AhP;
    if ((this.Ajg != null) && (this.Ajg.f(paramf)) && (l2 <= 20L))
    {
      this.Ajg = paramf;
      Log.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.dus, Long.valueOf(l2) });
      AppMethodBeat.o(137362);
      return;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137362);
      return;
    }
    this.bmy = 0L;
    this.iJF = SystemClock.elapsedRealtime();
    this.AlL = 0L;
    this.duration = 0L;
    if (this.AlJ != null) {
      this.AlJ.v(paramf);
    }
    this.AhP = l1;
    this.Ajg = paramf;
    Log.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.dvv) });
    if ((this.AhJ != null) && (bec())) {
      this.AhJ.stop();
    }
    com.tencent.mm.plugin.music.f.a.a.euW();
    this.bFM = 0;
    this.dvv = paramf.dvv;
    this.audioType = null;
    this.AhQ = false;
    Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.dus = this.Ajg.playUrl;
    this.Ama = this.Ajg.jfh;
    Log.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.dus, this.Ama });
    Log.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.Ajg.jfb });
    if ((!Util.isNullOrNil(this.dus)) && (Util.isNullOrNil(this.Ama)))
    {
      g.aHx(this.dus);
      g.eT(this.dus, 0);
      g.eU(this.dus, 0);
    }
    if (!Util.isNullOrNil(this.Ama))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.Ama });
      if (this.AhJ == null) {
        this.AhJ = new CommonPlayer(this.AhS);
      }
      this.AhJ.reset();
      if (this.Ama.startsWith("file://")) {
        this.Ama = this.Ama.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.AhJ.setDataSource(this.Ama);
        this.AhJ.prepare();
        bE((float)this.Ajg.iJH);
        setVolume(this.Ajg.volume);
        euP();
        AppMethodBeat.o(137362);
        return;
      }
      catch (Exception paramf)
      {
        Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
        d(this.Ajg, 501);
        e(this.Ajg, 501);
        continue;
      }
      paramf = null;
      try
      {
        URL localURL = new URL(this.dus);
        paramf = localURL;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "initPlayer", new Object[0]);
          Log.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + localException.getMessage());
        }
        if (this.AhJ != null) {
          break label677;
        }
        this.AhJ = new CommonPlayer(this.AhS);
        this.AhJ.reset();
        if (this.AhO != null) {
          break label702;
        }
        this.AhO = new com.tencent.mm.plugin.music.g.a.b();
        if (this.Ajg != null) {
          break label835;
        }
      }
      if (paramf != null) {
        break;
      }
      Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
      d(this.Ajg, 500);
      e(this.Ajg, 500);
    }
    label677:
    label702:
    label835:
    for (String str = "invalidReferrer";; str = this.Ajg.iJQ)
    {
      for (;;)
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "initPlayer, referrer: ".concat(String.valueOf(str)));
        this.AhO.jb(this.dus, str);
        try
        {
          this.AhJ.setDataSource(this.AhO, Uri.parse(paramf.toString()));
          this.AhJ.prepare();
        }
        catch (Exception paramf)
        {
          Log.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + paramf.getMessage());
          Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", paramf, "initPlayer", new Object[0]);
          d(this.Ajg, 501);
          e(this.Ajg, 501);
        }
      }
      break;
    }
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(198184);
    if ((this.Ajg != null) && (this.Ajg.f(paramf)))
    {
      Log.i("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.dus });
      if ((paramf.iJH > 0.0D) && (paramf.iJH != this.Ajg.iJH))
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(paramf.iJH) });
        bE((float)paramf.iJH);
        this.Ajg.iJH = paramf.iJH;
      }
      if ((paramf.volume >= 0.0F) && (paramf.volume != this.Ajg.volume))
      {
        Log.i("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(paramf.volume) });
        setVolume(paramf.volume);
        this.Ajg.volume = paramf.volume;
      }
    }
    AppMethodBeat.o(198184);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137364);
    this.Aju = false;
    Log.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.AhJ != null) && (bec())) {
      try
      {
        this.AhJ.pause();
        AppMethodBeat.o(137364);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.Ajg, 503);
        e(this.Ajg, 503);
      }
    }
    AppMethodBeat.o(137364);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137376);
    Log.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.AhJ != null)
    {
      this.AhJ.release();
      this.AhJ = null;
    }
    esT();
    AppMethodBeat.o(137376);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137367);
    this.bFM = 0;
    boolean bool1 = dFr();
    boolean bool2 = bec();
    Log.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, paused:%b, isPrepared:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(isPaused()), Boolean.valueOf(asa()) });
    if ((this.AhJ == null) || ((!isPaused()) && (!asa())) || (bool2) || (k.eul().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.AhJ.start();
        this.AhL = true;
        AppMethodBeat.o(137367);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.Ajg, 502);
        e(this.Ajg, 502);
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
      euU();
      if (this.AhJ != null) {
        this.AhJ.stop();
      }
      if (this.AlZ != null)
      {
        this.AlZ.isStop = true;
        this.AlZ = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.Ajg, 504);
        e(this.Ajg, 504);
      }
    }
    k.eul().bLZ();
    this.AhL = false;
    this.Aju = false;
    AppMethodBeat.o(137371);
  }
  
  public final boolean tG(int paramInt)
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
    if (this.AhJ != null)
    {
      N(this.Ajg);
      this.AhJ.seekTo(paramInt);
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
            if ((e.this.AhJ != null) && (e.this.bec())) {
              e.this.etp();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e
 * JD-Core Version:    0.7.0.1
 */