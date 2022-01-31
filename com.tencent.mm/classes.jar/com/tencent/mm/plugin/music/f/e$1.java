package com.tencent.mm.plugin.music.f;

import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;

final class e$1
  implements PlayerListenerCallback
{
  com.tencent.mm.av.e mAM = null;
  
  e$1(e parame) {}
  
  private void bnJ()
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
    if (this.mAN.startTime != 0)
    {
      y.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(this.mAN.startTime) });
      this.mAN.iV(this.mAN.startTime);
      return;
    }
    y.i("MicroMsg.Music.QQMusicPlayer", "start to play");
    if (k.bnn().requestFocus())
    {
      if (this.mAN.myB == null)
      {
        y.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        return;
      }
      this.mAN.z(this.mAN.myB);
      try
      {
        if (this.mAN.mxp != null)
        {
          this.mAN.mxp.start();
          if ((this.mAN.mxp.getCurrentAudioInformation() != null) && (this.mAN.mxp.getCurrentAudioInformation().getAudioType() != null))
          {
            y.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(this.mAN.mxp.getCurrentAudioInformation().getAudioType().getValue()) });
            this.mAN.audioType = this.mAN.mxp.getCurrentAudioInformation().getAudioType();
            e locale = this.mAN;
            if (locale.audioType != null)
            {
              y.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", new Object[] { Integer.valueOf(locale.audioType.getValue()), Boolean.valueOf(locale.mxy) });
              if (!locale.mxy)
              {
                y.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                locale.mxy = true;
                if (locale.mAu != null) {
                  locale.mAu.c(locale.myB, locale.audioType.getValue());
                }
              }
            }
          }
        }
        this.mAN.mxr = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "_onPrepared", new Object[0]);
          this.mAN.d(this.mAN.myB, 502);
          this.mAN.e(this.mAN.myB, 502);
        }
      }
    }
    y.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
  }
  
  public final void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public final void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
  }
  
  public final void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    y.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramBaseMediaPlayer = k.bnl().bmW();
    if (paramBaseMediaPlayer == null) {
      y.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
    }
    do
    {
      return;
      this.mAM = this.mAN.myB;
      if (this.mAM == null)
      {
        y.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
        return;
      }
      boolean bool = aq.isNetworkConnected(ae.getContext());
      if ((paramInt2 == 80) && (bool)) {
        y.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
      }
      if (this.mAN.aRY > 0)
      {
        y.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(this.mAN.aRY) });
        return;
      }
      e locale = this.mAN;
      locale.aRY += 1;
      this.mAN.e(this.mAM, paramInt2);
      if (paramBaseMediaPlayer.e(this.mAM))
      {
        this.mAN.stopPlay();
        ai.d(new e.1.1(this));
      }
      this.mAN.D(this.mAM);
      this.mAN.d(this.mAM, paramInt2);
      if (this.mAN.mAK != null)
      {
        this.mAN.mAK.isStop = true;
        this.mAN.mAK = null;
      }
    } while ((paramInt1 != 91) || (paramInt2 != 55));
    y.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
    g.deleteFile(this.mAN.mxv);
  }
  
  public final void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
  }
  
  public final void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.mAN.startTime != 0)
    {
      y.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(this.mAN.startTime) });
      this.mAN.startTime = 0;
      bnJ();
    }
    do
    {
      return;
      y.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
      if (this.mAM == null)
      {
        y.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        return;
      }
      this.mAN.E(this.mAM);
    } while (!this.mAN.Pu());
    y.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
    this.mAN.B(this.mAM);
  }
  
  public final void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
  }
  
  public final void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 3)
    {
      y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
      y.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
      this.mAM = this.mAN.myB;
      if (this.mAM == null) {
        y.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.mAN.y(this.mAM);
          return;
          if (paramInt == 2)
          {
            y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
            bnJ();
            return;
          }
          if (paramInt == 4)
          {
            y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
            y.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
            this.mAM = this.mAN.myB;
            if (this.mAM == null)
            {
              y.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
              return;
            }
            if (this.mAN.mAt == "pause") {
              this.mAN.B(this.mAM);
            }
            for (;;)
            {
              if (this.mAN.mAK != null) {
                this.mAN.mAK.isStop = true;
              }
              this.mAN.mAK = new e.a(this.mAN, (byte)0);
              paramBaseMediaPlayer = this.mAN.mAK;
              paramBaseMediaPlayer.isStop = false;
              com.tencent.mm.sdk.f.e.post(paramBaseMediaPlayer, "music_play_progress_runnable");
              return;
              this.mAN.A(this.mAM);
            }
          }
          if (paramInt == 5)
          {
            y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
            y.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
            if (this.mAM == null)
            {
              y.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
              return;
            }
            this.mAN.C(this.mAM);
            return;
          }
          if (paramInt != 6) {
            break;
          }
          y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
          y.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
          if (this.mAM == null)
          {
            y.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            return;
          }
          paramBaseMediaPlayer = k.bnl().bmW();
          if (paramBaseMediaPlayer == null)
          {
            y.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
            return;
          }
        } while (!paramBaseMediaPlayer.e(this.mAM));
        this.mAN.D(this.mAM);
        return;
        if (paramInt != 7) {
          break;
        }
        y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
        y.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
        if (this.mAM == null)
        {
          y.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
          return;
        }
        this.mAN.mxr = false;
        this.mAN.G(this.mAN.myB);
      } while (this.mAN.mAK == null);
      this.mAN.mAK.isStop = true;
      this.mAN.mAK = null;
      return;
      if (paramInt == 8)
      {
        y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
        y.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
        return;
      }
    } while (paramInt != 9);
    y.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e.1
 * JD-Core Version:    0.7.0.1
 */