package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class b
  extends com.tencent.mm.plugin.music.f.a.b
{
  a AlO;
  MediaPlayer jvF;
  boolean stop;
  
  public b()
  {
    AppMethodBeat.i(137303);
    this.stop = true;
    com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.b.class);
    if (localb != null) {
      this.jvF = localb.etV();
    }
    for (;;)
    {
      if (this.jvF == null) {
        this.jvF = new MediaPlayer();
      }
      this.jvF.setAudioStreamType(3);
      this.jvF.setOnCompletionListener(new b.1(this));
      this.jvF.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137299);
          if ((b.this.jvF != null) && (b.this.jvF.isPlaying()))
          {
            Log.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try
            {
              b.this.jvF.start();
              AppMethodBeat.o(137299);
              return;
            }
            catch (Exception paramAnonymousMediaPlayer)
            {
              Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
          AppMethodBeat.o(137299);
        }
      });
      this.jvF.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137300);
          if (b.this.jvF != null) {
            Log.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
          }
          try
          {
            b.this.jvF.start();
            b.this.stop = false;
            b.this.onStart();
            if (b.this.AlO != null) {
              b.this.AlO.isStop = true;
            }
            b.this.AlO = new b.a(b.this, (byte)0);
            paramAnonymousMediaPlayer = b.this.AlO;
            paramAnonymousMediaPlayer.isStop = false;
            ThreadPool.post(paramAnonymousMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137300);
            return;
          }
          catch (Exception paramAnonymousMediaPlayer)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
        }
      });
      this.jvF.setOnErrorListener(new b.4(this));
      AppMethodBeat.o(137303);
      return;
      Log.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final String ZV()
  {
    return null;
  }
  
  public final void aHY(String paramString)
  {
    AppMethodBeat.i(137305);
    Log.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.jvF.setDataSource(paramString);
      AppMethodBeat.o(137305);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137305);
    }
  }
  
  public final boolean euR()
  {
    return !this.stop;
  }
  
  public final int euS()
  {
    AppMethodBeat.i(137306);
    try
    {
      int i = this.jvF.getCurrentPosition();
      AppMethodBeat.o(137306);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getCurrentPos", new Object[0]);
      AppMethodBeat.o(137306);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137307);
    try
    {
      int i = this.jvF.getDuration();
      AppMethodBeat.o(137307);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getDuration", new Object[0]);
      AppMethodBeat.o(137307);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137304);
    try
    {
      boolean bool = this.jvF.isPlaying();
      AppMethodBeat.o(137304);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137304);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137310);
    Log.i("MicroMsg.Music.MMMediaPlayer", "pause");
    if (!euR())
    {
      AppMethodBeat.o(137310);
      return;
    }
    this.jvF.pause();
    AppMethodBeat.o(137310);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137308);
    Log.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (euR()) {
      try
      {
        if (!this.jvF.isPlaying())
        {
          this.jvF.start();
          AppMethodBeat.o(137308);
          return;
        }
        AppMethodBeat.o(137308);
        return;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException1, "start", new Object[0]);
        AppMethodBeat.o(137308);
        return;
      }
    }
    try
    {
      this.jvF.prepareAsync();
      AppMethodBeat.o(137308);
      return;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException2, "prepareAsync", new Object[0]);
      AppMethodBeat.o(137308);
    }
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137311);
    Log.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[] { Long.valueOf(paramLong) });
    this.jvF.seekTo((int)paramLong);
    AppMethodBeat.o(137311);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137309);
    Log.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.stop = true;
    try
    {
      if (this.jvF != null)
      {
        this.jvF.stop();
        this.jvF.release();
      }
      if (this.AlO != null)
      {
        this.AlO.isStop = true;
        this.AlO = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    so(false);
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
      Log.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label128;
        }
        try
        {
          if ((b.this.jvF != null) && (b.this.jvF.isPlaying()))
          {
            int i = b.this.jvF.getCurrentPosition();
            int j = b.this.jvF.getDuration();
            if ((i > 0) && (j > 0))
            {
              i = i * 100 / j;
              b.this.Tb(i);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "onPlayUpdate", new Object[0]);
          }
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localInterruptedException, "sleep", new Object[0]);
        }
      }
      label128:
      AppMethodBeat.o(137302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b
 * JD-Core Version:    0.7.0.1
 */