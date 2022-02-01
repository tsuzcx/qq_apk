package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaPlayer iAq;
  boolean stop;
  a wBG;
  
  public b()
  {
    AppMethodBeat.i(137303);
    this.stop = true;
    com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.b.class);
    if (localb != null) {
      this.iAq = localb.dwb();
    }
    for (;;)
    {
      if (this.iAq == null) {
        this.iAq = new MediaPlayer();
      }
      this.iAq.setAudioStreamType(3);
      this.iAq.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137298);
          ae.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
          b.this.pm(true);
          AppMethodBeat.o(137298);
        }
      });
      this.iAq.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137299);
          if ((b.this.iAq != null) && (b.this.iAq.isPlaying()))
          {
            ae.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try
            {
              b.this.iAq.start();
              AppMethodBeat.o(137299);
              return;
            }
            catch (Exception paramAnonymousMediaPlayer)
            {
              ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
          AppMethodBeat.o(137299);
        }
      });
      this.iAq.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137300);
          if (b.this.iAq != null) {
            ae.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
          }
          try
          {
            b.this.iAq.start();
            b.this.stop = false;
            b.this.onStart();
            if (b.this.wBG != null) {
              b.this.wBG.isStop = true;
            }
            b.this.wBG = new b.a(b.this, (byte)0);
            paramAnonymousMediaPlayer = b.this.wBG;
            paramAnonymousMediaPlayer.isStop = false;
            com.tencent.mm.sdk.g.b.c(paramAnonymousMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137300);
            return;
          }
          catch (Exception paramAnonymousMediaPlayer)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
        }
      });
      this.iAq.setOnErrorListener(new b.4(this));
      AppMethodBeat.o(137303);
      return;
      ae.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final void atY(String paramString)
  {
    AppMethodBeat.i(137305);
    ae.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.iAq.setDataSource(paramString);
      AppMethodBeat.o(137305);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137305);
    }
  }
  
  public final boolean dwJ()
  {
    return !this.stop;
  }
  
  public final int dwK()
  {
    AppMethodBeat.i(137306);
    try
    {
      int i = this.iAq.getCurrentPosition();
      AppMethodBeat.o(137306);
      return i;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getCurrentPos", new Object[0]);
      AppMethodBeat.o(137306);
    }
    return 0;
  }
  
  public final String dwL()
  {
    return null;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137307);
    try
    {
      int i = this.iAq.getDuration();
      AppMethodBeat.o(137307);
      return i;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getDuration", new Object[0]);
      AppMethodBeat.o(137307);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137304);
    try
    {
      boolean bool = this.iAq.isPlaying();
      AppMethodBeat.o(137304);
      return bool;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137304);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137310);
    ae.i("MicroMsg.Music.MMMediaPlayer", "pause");
    if (!dwJ())
    {
      AppMethodBeat.o(137310);
      return;
    }
    this.iAq.pause();
    AppMethodBeat.o(137310);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137308);
    ae.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (dwJ()) {
      try
      {
        if (!this.iAq.isPlaying())
        {
          this.iAq.start();
          AppMethodBeat.o(137308);
          return;
        }
        AppMethodBeat.o(137308);
        return;
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException1, "start", new Object[0]);
        AppMethodBeat.o(137308);
        return;
      }
    }
    try
    {
      this.iAq.prepareAsync();
      AppMethodBeat.o(137308);
      return;
    }
    catch (Exception localException2)
    {
      ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException2, "prepareAsync", new Object[0]);
      AppMethodBeat.o(137308);
    }
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137311);
    ae.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[] { Long.valueOf(paramLong) });
    this.iAq.seekTo((int)paramLong);
    AppMethodBeat.o(137311);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137309);
    ae.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.stop = true;
    try
    {
      if (this.iAq != null)
      {
        this.iAq.stop();
        this.iAq.release();
      }
      if (this.wBG != null)
      {
        this.wBG.isStop = true;
        this.wBG = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    pm(false);
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
      ae.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label128;
        }
        try
        {
          if ((b.this.iAq != null) && (b.this.iAq.isPlaying()))
          {
            int i = b.this.iAq.getCurrentPosition();
            int j = b.this.iAq.getDuration();
            if ((i > 0) && (j > 0))
            {
              i = i * 100 / j;
              b.this.Me(i);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "onPlayUpdate", new Object[0]);
          }
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ae.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localInterruptedException, "sleep", new Object[0]);
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