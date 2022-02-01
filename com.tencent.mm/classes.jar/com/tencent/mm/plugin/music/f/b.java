package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaPlayer hDA;
  boolean stop;
  a tXP;
  
  public b()
  {
    AppMethodBeat.i(137303);
    this.stop = true;
    com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.b.class);
    if (localb != null) {
      this.hDA = localb.cUU();
    }
    for (;;)
    {
      if (this.hDA == null) {
        this.hDA = new MediaPlayer();
      }
      this.hDA.setAudioStreamType(3);
      this.hDA.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137298);
          ad.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
          b.this.nL(true);
          AppMethodBeat.o(137298);
        }
      });
      this.hDA.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137299);
          if ((b.this.hDA != null) && (b.this.hDA.isPlaying()))
          {
            ad.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try
            {
              b.this.hDA.start();
              AppMethodBeat.o(137299);
              return;
            }
            catch (Exception paramAnonymousMediaPlayer)
            {
              ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
          AppMethodBeat.o(137299);
        }
      });
      this.hDA.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137300);
          if (b.this.hDA != null) {
            ad.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
          }
          try
          {
            b.this.hDA.start();
            b.this.stop = false;
            b.this.onStart();
            if (b.this.tXP != null) {
              b.this.tXP.isStop = true;
            }
            b.this.tXP = new b.a(b.this, (byte)0);
            paramAnonymousMediaPlayer = b.this.tXP;
            paramAnonymousMediaPlayer.isStop = false;
            com.tencent.mm.sdk.g.b.c(paramAnonymousMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137300);
            return;
          }
          catch (Exception paramAnonymousMediaPlayer)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
        }
      });
      this.hDA.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(137301);
          ad.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          b.this.nK(false);
          AppMethodBeat.o(137301);
          return false;
        }
      });
      AppMethodBeat.o(137303);
      return;
      ad.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final void aiR(String paramString)
  {
    AppMethodBeat.i(137305);
    ad.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.hDA.setDataSource(paramString);
      AppMethodBeat.o(137305);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137305);
    }
  }
  
  public final boolean cVC()
  {
    return !this.stop;
  }
  
  public final int cVD()
  {
    AppMethodBeat.i(137306);
    try
    {
      int i = this.hDA.getCurrentPosition();
      AppMethodBeat.o(137306);
      return i;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getCurrentPos", new Object[0]);
      AppMethodBeat.o(137306);
    }
    return 0;
  }
  
  public final String cVE()
  {
    return null;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137307);
    try
    {
      int i = this.hDA.getDuration();
      AppMethodBeat.o(137307);
      return i;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getDuration", new Object[0]);
      AppMethodBeat.o(137307);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137304);
    try
    {
      boolean bool = this.hDA.isPlaying();
      AppMethodBeat.o(137304);
      return bool;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137304);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137310);
    ad.i("MicroMsg.Music.MMMediaPlayer", "pause");
    if (!cVC())
    {
      AppMethodBeat.o(137310);
      return;
    }
    this.hDA.pause();
    AppMethodBeat.o(137310);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137308);
    ad.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (cVC()) {
      try
      {
        if (!this.hDA.isPlaying())
        {
          this.hDA.start();
          AppMethodBeat.o(137308);
          return;
        }
        AppMethodBeat.o(137308);
        return;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException1, "start", new Object[0]);
        AppMethodBeat.o(137308);
        return;
      }
    }
    try
    {
      this.hDA.prepareAsync();
      AppMethodBeat.o(137308);
      return;
    }
    catch (Exception localException2)
    {
      ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException2, "prepareAsync", new Object[0]);
      AppMethodBeat.o(137308);
    }
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137311);
    ad.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[] { Long.valueOf(paramLong) });
    this.hDA.seekTo((int)paramLong);
    AppMethodBeat.o(137311);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137309);
    ad.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.stop = true;
    try
    {
      if (this.hDA != null)
      {
        this.hDA.stop();
        this.hDA.release();
      }
      if (this.tXP != null)
      {
        this.tXP.isStop = true;
        this.tXP = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    nL(false);
    AppMethodBeat.o(137309);
  }
  
  final class a
    implements Runnable
  {
    boolean isStop = true;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(137302);
      ad.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label128;
        }
        try
        {
          if ((b.this.hDA != null) && (b.this.hDA.isPlaying()))
          {
            int i = b.this.hDA.getCurrentPosition();
            int j = b.this.hDA.getDuration();
            if ((i > 0) && (j > 0))
            {
              i = i * 100 / j;
              b.this.HY(i);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "onPlayUpdate", new Object[0]);
          }
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localInterruptedException, "sleep", new Object[0]);
        }
      }
      label128:
      AppMethodBeat.o(137302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b
 * JD-Core Version:    0.7.0.1
 */