package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaPlayer iec;
  boolean stop;
  a vgC;
  
  public b()
  {
    AppMethodBeat.i(137303);
    this.stop = true;
    com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.b.class);
    if (localb != null) {
      this.iec = localb.diA();
    }
    for (;;)
    {
      if (this.iec == null) {
        this.iec = new MediaPlayer();
      }
      this.iec.setAudioStreamType(3);
      this.iec.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137298);
          ac.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
          b.this.oF(true);
          AppMethodBeat.o(137298);
        }
      });
      this.iec.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137299);
          if ((b.this.iec != null) && (b.this.iec.isPlaying()))
          {
            ac.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
            try
            {
              b.this.iec.start();
              AppMethodBeat.o(137299);
              return;
            }
            catch (Exception paramAnonymousMediaPlayer)
            {
              ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
          AppMethodBeat.o(137299);
        }
      });
      this.iec.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(137300);
          if (b.this.iec != null) {
            ac.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
          }
          try
          {
            b.this.iec.start();
            b.this.stop = false;
            b.this.onStart();
            if (b.this.vgC != null) {
              b.this.vgC.isStop = true;
            }
            b.this.vgC = new b.a(b.this, (byte)0);
            paramAnonymousMediaPlayer = b.this.vgC;
            paramAnonymousMediaPlayer.isStop = false;
            com.tencent.mm.sdk.g.b.c(paramAnonymousMediaPlayer, "music_play_progress_runnable");
            AppMethodBeat.o(137300);
            return;
          }
          catch (Exception paramAnonymousMediaPlayer)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramAnonymousMediaPlayer, "start", new Object[0]);
            }
          }
        }
      });
      this.iec.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(137301);
          ac.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          b.this.oE(false);
          AppMethodBeat.o(137301);
          return false;
        }
      });
      AppMethodBeat.o(137303);
      return;
      ac.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final void anM(String paramString)
  {
    AppMethodBeat.i(137305);
    ac.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.iec.setDataSource(paramString);
      AppMethodBeat.o(137305);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137305);
    }
  }
  
  public final boolean dji()
  {
    return !this.stop;
  }
  
  public final int djj()
  {
    AppMethodBeat.i(137306);
    try
    {
      int i = this.iec.getCurrentPosition();
      AppMethodBeat.o(137306);
      return i;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getCurrentPos", new Object[0]);
      AppMethodBeat.o(137306);
    }
    return 0;
  }
  
  public final String djk()
  {
    return null;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137307);
    try
    {
      int i = this.iec.getDuration();
      AppMethodBeat.o(137307);
      return i;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getDuration", new Object[0]);
      AppMethodBeat.o(137307);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137304);
    try
    {
      boolean bool = this.iec.isPlaying();
      AppMethodBeat.o(137304);
      return bool;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137304);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137310);
    ac.i("MicroMsg.Music.MMMediaPlayer", "pause");
    if (!dji())
    {
      AppMethodBeat.o(137310);
      return;
    }
    this.iec.pause();
    AppMethodBeat.o(137310);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137308);
    ac.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (dji()) {
      try
      {
        if (!this.iec.isPlaying())
        {
          this.iec.start();
          AppMethodBeat.o(137308);
          return;
        }
        AppMethodBeat.o(137308);
        return;
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException1, "start", new Object[0]);
        AppMethodBeat.o(137308);
        return;
      }
    }
    try
    {
      this.iec.prepareAsync();
      AppMethodBeat.o(137308);
      return;
    }
    catch (Exception localException2)
    {
      ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException2, "prepareAsync", new Object[0]);
      AppMethodBeat.o(137308);
    }
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137311);
    ac.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[] { Long.valueOf(paramLong) });
    this.iec.seekTo((int)paramLong);
    AppMethodBeat.o(137311);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137309);
    ac.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.stop = true;
    try
    {
      if (this.iec != null)
      {
        this.iec.stop();
        this.iec.release();
      }
      if (this.vgC != null)
      {
        this.vgC.isStop = true;
        this.vgC = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    oF(false);
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
      ac.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
      for (;;)
      {
        if (this.isStop) {
          break label128;
        }
        try
        {
          if ((b.this.iec != null) && (b.this.iec.isPlaying()))
          {
            int i = b.this.iec.getCurrentPosition();
            int j = b.this.iec.getDuration();
            if ((i > 0) && (j > 0))
            {
              i = i * 100 / j;
              b.this.JX(i);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "onPlayUpdate", new Object[0]);
          }
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ac.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localInterruptedException, "sleep", new Object[0]);
        }
      }
      label128:
      AppMethodBeat.o(137302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b
 * JD-Core Version:    0.7.0.1
 */