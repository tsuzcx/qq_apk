package com.tencent.mm.plugin.music.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.h.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;

final class e$1
  implements PlayerListenerCallback
{
  com.tencent.mm.aw.e paQ = null;
  
  e$1(e parame) {}
  
  private void bWf()
  {
    AppMethodBeat.i(137609);
    ab.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
    if (this.paR.startTime != 0)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(this.paR.startTime) });
      this.paR.lN(this.paR.startTime);
      AppMethodBeat.o(137609);
      return;
    }
    ab.i("MicroMsg.Music.QQMusicPlayer", "start to play");
    if (k.bVJ().requestFocus())
    {
      if (this.paR.oYI == null)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        AppMethodBeat.o(137609);
        return;
      }
      this.paR.z(this.paR.oYI);
      try
      {
        if (this.paR.oXm != null)
        {
          this.paR.oXm.start();
          if ((this.paR.oXm.getCurrentAudioInformation() != null) && (this.paR.oXm.getCurrentAudioInformation().getAudioType() != null))
          {
            ab.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(this.paR.oXm.getCurrentAudioInformation().getAudioType().getValue()) });
            this.paR.audioType = this.paR.oXm.getCurrentAudioInformation().getAudioType();
            e.a(this.paR);
          }
        }
        this.paR.oXo = true;
        AppMethodBeat.o(137609);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "_onPrepared", new Object[0]);
          this.paR.d(this.paR.oYI, 502);
          e.a(this.paR, this.paR.oYI, 502);
        }
      }
    }
    ab.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    AppMethodBeat.o(137609);
  }
  
  public final void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public final void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(137603);
    ab.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
    AppMethodBeat.o(137603);
  }
  
  public final void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137605);
    ab.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramBaseMediaPlayer = k.bVH().bVs();
    if (paramBaseMediaPlayer == null)
    {
      ab.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
      AppMethodBeat.o(137605);
      return;
    }
    this.paQ = this.paR.oYI;
    if (this.paQ == null)
    {
      ab.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
      AppMethodBeat.o(137605);
      return;
    }
    boolean bool = at.isNetworkConnected(ah.getContext());
    if ((paramInt2 == 80) && (bool)) {
      ab.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
    }
    if (this.paR.aZy > 0)
    {
      ab.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(this.paR.aZy) });
      AppMethodBeat.o(137605);
      return;
    }
    e locale = this.paR;
    locale.aZy += 1;
    e.a(this.paR, this.paQ, paramInt2);
    if (paramBaseMediaPlayer.e(this.paQ))
    {
      this.paR.stopPlay();
      al.d(new e.1.1(this));
    }
    this.paR.D(this.paQ);
    this.paR.d(this.paQ, paramInt2);
    if (this.paR.paO != null)
    {
      this.paR.paO.isStop = true;
      this.paR.paO = null;
    }
    if ((paramInt1 == 91) && (paramInt2 == 55))
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
      g.Jg(this.paR.ceU);
    }
    AppMethodBeat.o(137605);
  }
  
  public final void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(137606);
    ab.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
    AppMethodBeat.o(137606);
  }
  
  public final void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(137604);
    ab.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.paR.startTime != 0)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(this.paR.startTime) });
      this.paR.startTime = 0;
      bWf();
      AppMethodBeat.o(137604);
      return;
    }
    ab.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
    if (this.paQ == null)
    {
      ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      AppMethodBeat.o(137604);
      return;
    }
    this.paR.E(this.paQ);
    if (this.paR.aiw())
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
      this.paR.B(this.paQ);
    }
    AppMethodBeat.o(137604);
  }
  
  public final void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    AppMethodBeat.i(137608);
    ab.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
    AppMethodBeat.o(137608);
  }
  
  public final void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(137607);
    ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 3)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
      ab.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
      this.paQ = this.paR.oYI;
      if (this.paQ == null)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        AppMethodBeat.o(137607);
        return;
      }
      this.paR.y(this.paQ);
      AppMethodBeat.o(137607);
      return;
    }
    if (paramInt == 2)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
      bWf();
      AppMethodBeat.o(137607);
      return;
    }
    if (paramInt == 4)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
      ab.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
      this.paQ = this.paR.oYI;
      if (this.paQ == null)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        AppMethodBeat.o(137607);
        return;
      }
      if (this.paR.paz == "pause") {
        this.paR.B(this.paQ);
      }
      for (;;)
      {
        if (this.paR.paO != null) {
          this.paR.paO.isStop = true;
        }
        this.paR.paO = new e.a(this.paR, (byte)0);
        paramBaseMediaPlayer = this.paR.paO;
        paramBaseMediaPlayer.isStop = false;
        d.post(paramBaseMediaPlayer, "music_play_progress_runnable");
        AppMethodBeat.o(137607);
        return;
        this.paR.A(this.paQ);
      }
    }
    if (paramInt == 5)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
      ab.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
      if (this.paQ == null)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        AppMethodBeat.o(137607);
        return;
      }
      this.paR.C(this.paQ);
      AppMethodBeat.o(137607);
      return;
    }
    if (paramInt == 6)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
      ab.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
      if (this.paQ == null)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        AppMethodBeat.o(137607);
        return;
      }
      paramBaseMediaPlayer = k.bVH().bVs();
      if (paramBaseMediaPlayer == null)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
        AppMethodBeat.o(137607);
        return;
      }
      if (paramBaseMediaPlayer.e(this.paQ)) {
        this.paR.D(this.paQ);
      }
      AppMethodBeat.o(137607);
      return;
    }
    if (paramInt == 7)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
      ab.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
      if (this.paQ == null)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        AppMethodBeat.o(137607);
        return;
      }
      this.paR.oXo = false;
      this.paR.G(this.paR.oYI);
      if (this.paR.paO != null)
      {
        this.paR.paO.isStop = true;
        this.paR.paO = null;
      }
      AppMethodBeat.o(137607);
      return;
    }
    if (paramInt == 8)
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
      ab.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
      AppMethodBeat.o(137607);
      return;
    }
    if (paramInt == 9) {
      ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
    }
    AppMethodBeat.o(137607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e.1
 * JD-Core Version:    0.7.0.1
 */