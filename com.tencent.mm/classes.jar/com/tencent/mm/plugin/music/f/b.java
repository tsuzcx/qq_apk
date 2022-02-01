package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaPlayer ixx;
  boolean stop;
  a wlX;
  
  public b()
  {
    AppMethodBeat.i(137303);
    this.stop = true;
    com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.b.class);
    if (localb != null) {
      this.ixx = localb.dsM();
    }
    for (;;)
    {
      if (this.ixx == null) {
        this.ixx = new MediaPlayer();
      }
      this.ixx.setAudioStreamType(3);
      this.ixx.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137298);
          ad.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
          b.this.pe(true);
          AppMethodBeat.o(137298);
        }
      });
      this.ixx.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137299);
          if ((b.this.ixx != null) && (b.this.ixx.isPlaying()))
          {
            ad.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try
            {
              b.this.ixx.start();
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
      this.ixx.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137300);
          if (b.this.ixx != null) {
            ad.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
          }
          try
          {
            b.this.ixx.start();
            b.this.stop = false;
            b.this.onStart();
            if (b.this.wlX != null) {
              b.this.wlX.isStop = true;
            }
            b.this.wlX = new b.a(b.this, (byte)0);
            paramAnonymousMediaPlayer = b.this.wlX;
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
      this.ixx.setOnErrorListener(new b.4(this));
      AppMethodBeat.o(137303);
      return;
      ad.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final void asL(String paramString)
  {
    AppMethodBeat.i(137305);
    ad.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.ixx.setDataSource(paramString);
      AppMethodBeat.o(137305);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137305);
    }
  }
  
  public final boolean dtu()
  {
    return !this.stop;
  }
  
  public final int dtv()
  {
    AppMethodBeat.i(137306);
    try
    {
      int i = this.ixx.getCurrentPosition();
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
  
  public final String dtw()
  {
    return null;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137307);
    try
    {
      int i = this.ixx.getDuration();
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
      boolean bool = this.ixx.isPlaying();
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
    if (!dtu())
    {
      AppMethodBeat.o(137310);
      return;
    }
    this.ixx.pause();
    AppMethodBeat.o(137310);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137308);
    ad.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (dtu()) {
      try
      {
        if (!this.ixx.isPlaying())
        {
          this.ixx.start();
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
      this.ixx.prepareAsync();
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
    this.ixx.seekTo((int)paramLong);
    AppMethodBeat.o(137311);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137309);
    ad.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.stop = true;
    try
    {
      if (this.ixx != null)
      {
        this.ixx.stop();
        this.ixx.release();
      }
      if (this.wlX != null)
      {
        this.wlX.isStop = true;
        this.wlX = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    pe(false);
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
          if ((b.this.ixx != null) && (b.this.ixx.isPlaying()))
          {
            int i = b.this.ixx.getCurrentPosition();
            int j = b.this.ixx.getDuration();
            if ((i > 0) && (j > 0))
            {
              i = i * 100 / j;
              b.this.Lz(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b
 * JD-Core Version:    0.7.0.1
 */