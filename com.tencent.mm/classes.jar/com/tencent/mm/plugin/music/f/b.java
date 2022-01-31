package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaPlayer eLh;
  b.a mAx;
  boolean stop = true;
  
  public b()
  {
    com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.b.class);
    if (localb != null) {
      this.eLh = localb.bmX();
    }
    for (;;)
    {
      if (this.eLh == null) {
        this.eLh = new MediaPlayer();
      }
      this.eLh.setAudioStreamType(3);
      this.eLh.setOnCompletionListener(new b.1(this));
      this.eLh.setOnSeekCompleteListener(new b.2(this));
      this.eLh.setOnPreparedListener(new b.3(this));
      this.eLh.setOnErrorListener(new b.4(this));
      return;
      y.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final void JG(String paramString)
  {
    y.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.eLh.setDataSource(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
    }
  }
  
  public final boolean bnE()
  {
    return !this.stop;
  }
  
  public final int bnF()
  {
    return this.eLh.getCurrentPosition();
  }
  
  public final String bnG()
  {
    return null;
  }
  
  public final int getDuration()
  {
    return this.eLh.getDuration();
  }
  
  public final boolean isPlaying()
  {
    try
    {
      boolean bool = this.eLh.isPlaying();
      return bool;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "setSourcePath", new Object[0]);
    }
    return false;
  }
  
  public final void pause()
  {
    y.i("MicroMsg.Music.MMMediaPlayer", "pause");
    if (!bnE()) {
      return;
    }
    this.eLh.pause();
  }
  
  public final void play()
  {
    y.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (bnE()) {
      try
      {
        if (!this.eLh.isPlaying()) {
          this.eLh.start();
        }
        return;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException1, "start", new Object[0]);
        return;
      }
    }
    try
    {
      this.eLh.prepareAsync();
      return;
    }
    catch (Exception localException2)
    {
      y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException2, "prepareAsync", new Object[0]);
    }
  }
  
  public final void seek(long paramLong)
  {
    y.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[] { Long.valueOf(paramLong) });
    this.eLh.seekTo((int)paramLong);
  }
  
  public final void stop()
  {
    y.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.stop = true;
    try
    {
      if (this.eLh != null)
      {
        this.eLh.stop();
        this.eLh.release();
      }
      if (this.mAx != null)
      {
        this.mAx.isStop = true;
        this.mAx = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    hT(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b
 * JD-Core Version:    0.7.0.1
 */