package com.tencent.mm.plugin.music.e;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class b
  extends com.tencent.mm.plugin.music.e.a.b
{
  boolean EAm;
  a LNR;
  MediaPlayer peU;
  boolean stop;
  
  public b()
  {
    AppMethodBeat.i(137303);
    this.stop = true;
    this.EAm = false;
    com.tencent.mm.plugin.music.logic.b localb = (com.tencent.mm.plugin.music.logic.b)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.b.class);
    if (localb != null) {
      this.peU = localb.gni();
    }
    for (;;)
    {
      if (this.peU == null) {
        this.peU = new MediaPlayer();
      }
      this.peU.setAudioStreamType(3);
      this.peU.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137298);
          Log.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
          if (b.this.EAm)
          {
            b.this.zM(false);
            AppMethodBeat.o(137298);
            return;
          }
          b.this.zM(true);
          AppMethodBeat.o(137298);
        }
      });
      this.peU.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137299);
          if ((b.this.peU != null) && (b.this.peU.isPlaying()))
          {
            Log.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try
            {
              b.this.peU.start();
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
      this.peU.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137300);
          if (b.this.peU != null) {
            Log.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
          }
          try
          {
            b.this.peU.start();
            b.this.stop = false;
            b.this.onStart();
            if (b.this.LNR != null) {
              b.this.LNR.isStop = true;
            }
            b.this.LNR = new b.a(b.this, (byte)0);
            paramAnonymousMediaPlayer = b.this.LNR;
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
      this.peU.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(137301);
          Log.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          b.this.EAm = true;
          b.this.zL(false);
          AppMethodBeat.o(137301);
          return false;
        }
      });
      AppMethodBeat.o(137303);
      return;
      Log.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final String aGC()
  {
    return null;
  }
  
  public final void aPi(String paramString)
  {
    AppMethodBeat.i(137305);
    Log.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.peU.setDataSource(paramString);
      AppMethodBeat.o(137305);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137305);
    }
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137307);
    try
    {
      int i = this.peU.getDuration();
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
  
  public final boolean gou()
  {
    return !this.stop;
  }
  
  public final int gov()
  {
    AppMethodBeat.i(137306);
    try
    {
      int i = this.peU.getCurrentPosition();
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
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137304);
    try
    {
      boolean bool = this.peU.isPlaying();
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
    if (!gou())
    {
      AppMethodBeat.o(137310);
      return;
    }
    this.peU.pause();
    AppMethodBeat.o(137310);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137308);
    Log.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (gou()) {
      try
      {
        if (!this.peU.isPlaying())
        {
          this.peU.start();
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
      this.peU.prepareAsync();
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
    this.peU.seekTo((int)paramLong);
    AppMethodBeat.o(137311);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137309);
    Log.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.stop = true;
    try
    {
      if (this.peU != null)
      {
        this.peU.stop();
        this.peU.release();
      }
      if (this.LNR != null)
      {
        this.LNR.isStop = true;
        this.LNR = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    zM(false);
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
          if ((b.this.peU != null) && (b.this.peU.isPlaying()))
          {
            int i = b.this.peU.getCurrentPosition();
            int j = b.this.peU.getDuration();
            if ((i > 0) && (j > 0))
            {
              i = i * 100 / j;
              b.this.adJ(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.b
 * JD-Core Version:    0.7.0.1
 */