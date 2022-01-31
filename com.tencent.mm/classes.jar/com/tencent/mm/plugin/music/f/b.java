package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaPlayer gaO;
  boolean oIr;
  b.a paD;
  
  public b()
  {
    AppMethodBeat.i(137553);
    this.oIr = true;
    com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.b.class);
    if (localb != null) {
      this.gaO = localb.bVt();
    }
    for (;;)
    {
      if (this.gaO == null) {
        this.gaO = new MediaPlayer();
      }
      this.gaO.setAudioStreamType(3);
      this.gaO.setOnCompletionListener(new b.1(this));
      this.gaO.setOnSeekCompleteListener(new b.2(this));
      this.gaO.setOnPreparedListener(new b.3(this));
      this.gaO.setOnErrorListener(new b.4(this));
      AppMethodBeat.o(137553);
      return;
      ab.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
  }
  
  public final void VE(String paramString)
  {
    AppMethodBeat.i(137555);
    ab.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.gaO.setDataSource(paramString);
      AppMethodBeat.o(137555);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137555);
    }
  }
  
  public final boolean bWb()
  {
    return !this.oIr;
  }
  
  public final int bWc()
  {
    AppMethodBeat.i(137556);
    try
    {
      int i = this.gaO.getCurrentPosition();
      AppMethodBeat.o(137556);
      return i;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getCurrentPos", new Object[0]);
      AppMethodBeat.o(137556);
    }
    return 0;
  }
  
  public final String bWd()
  {
    return null;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137557);
    try
    {
      int i = this.gaO.getDuration();
      AppMethodBeat.o(137557);
      return i;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "getDuration", new Object[0]);
      AppMethodBeat.o(137557);
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137554);
    try
    {
      boolean bool = this.gaO.isPlaying();
      AppMethodBeat.o(137554);
      return bool;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "setSourcePath", new Object[0]);
      AppMethodBeat.o(137554);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137560);
    ab.i("MicroMsg.Music.MMMediaPlayer", "pause");
    if (!bWb())
    {
      AppMethodBeat.o(137560);
      return;
    }
    this.gaO.pause();
    AppMethodBeat.o(137560);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137558);
    ab.i("MicroMsg.Music.MMMediaPlayer", "play");
    if (bWb()) {
      try
      {
        if (!this.gaO.isPlaying())
        {
          this.gaO.start();
          AppMethodBeat.o(137558);
          return;
        }
        AppMethodBeat.o(137558);
        return;
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException1, "start", new Object[0]);
        AppMethodBeat.o(137558);
        return;
      }
    }
    try
    {
      this.gaO.prepareAsync();
      AppMethodBeat.o(137558);
      return;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException2, "prepareAsync", new Object[0]);
      AppMethodBeat.o(137558);
    }
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137561);
    ab.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[] { Long.valueOf(paramLong) });
    this.gaO.seekTo((int)paramLong);
    AppMethodBeat.o(137561);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137559);
    ab.i("MicroMsg.Music.MMMediaPlayer", "stop");
    this.oIr = true;
    try
    {
      if (this.gaO != null)
      {
        this.gaO.stop();
        this.gaO.release();
      }
      if (this.paD != null)
      {
        this.paD.isStop = true;
        this.paD = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
      }
    }
    jQ(false);
    AppMethodBeat.o(137559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b
 * JD-Core Version:    0.7.0.1
 */