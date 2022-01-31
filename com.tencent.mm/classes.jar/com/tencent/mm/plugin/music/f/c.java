package com.tencent.mm.plugin.music.f;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.f.a.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(16)
public final class c
  extends com.tencent.mm.plugin.music.f.a.b
{
  MediaCodec aMR;
  AudioTrack ayN;
  int cfE;
  String cfF;
  MediaExtractor cfO;
  String cfP;
  int channels;
  private Runnable cle;
  long duration;
  private boolean oIr;
  long presentationTimeUs;
  int sampleRate;
  
  public c()
  {
    AppMethodBeat.i(137563);
    this.oIr = true;
    this.cfP = null;
    this.sampleRate = 0;
    this.channels = 0;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    this.cfE = 0;
    this.cle = new c.1(this);
    AppMethodBeat.o(137563);
  }
  
  private void Ei()
  {
    try
    {
      AppMethodBeat.i(137566);
      ab.i("MicroMsg.Music.MMPlayer", "sync notify");
      try
      {
        notify();
        AppMethodBeat.o(137566);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Music.MMPlayer", localException, "syncNotify", new Object[0]);
          AppMethodBeat.o(137566);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void VE(String paramString)
  {
    this.cfF = paramString;
  }
  
  public final boolean bWb()
  {
    return !this.oIr;
  }
  
  public final int bWc()
  {
    return (int)(this.presentationTimeUs / 1000L);
  }
  
  public final String bWd()
  {
    return this.cfP;
  }
  
  public final void bWe()
  {
    try
    {
      AppMethodBeat.i(137570);
      while (bWb())
      {
        boolean bool = this.paX.bWj();
        if (!bool) {
          break;
        }
        try
        {
          ab.i("MicroMsg.Music.MMPlayer", "wait play");
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.printErrStackTrace("MicroMsg.Music.MMPlayer", localInterruptedException, "waitPlay", new Object[0]);
        }
      }
      AppMethodBeat.o(137570);
    }
    finally {}
  }
  
  final boolean createAudioTrack()
  {
    AppMethodBeat.i(137564);
    ab.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
    int i;
    if (this.channels == 1) {
      i = 4;
    }
    for (;;)
    {
      int j = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
      com.tencent.mm.plugin.music.e.b localb = (com.tencent.mm.plugin.music.e.b)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.b.class);
      if (localb != null)
      {
        this.ayN = localb.ab(this.sampleRate, i, j);
        label61:
        if (this.ayN == null)
        {
          ab.e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
          this.ayN = new AudioTrack(3, this.sampleRate, i, 2, j, 1);
        }
        if ((this.ayN != null) && (this.ayN.getState() == 1)) {
          break label157;
        }
        ab.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
        if (this.ayN == null) {}
      }
      try
      {
        this.ayN.release();
        label134:
        AppMethodBeat.o(137564);
        return false;
        i = 12;
        continue;
        ab.e("MicroMsg.Music.MMPlayer", "mediaResService null");
        break label61;
        label157:
        AppMethodBeat.o(137564);
        return true;
      }
      catch (Exception localException)
      {
        break label134;
      }
    }
  }
  
  public final int getDuration()
  {
    return (int)(this.duration / 1000L);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(137571);
    boolean bool = this.paX.isPlaying();
    AppMethodBeat.o(137571);
    return bool;
  }
  
  public final void jP(boolean paramBoolean)
  {
    AppMethodBeat.i(137572);
    this.paX.pbb = 4;
    this.oIr = true;
    super.jP(paramBoolean);
    AppMethodBeat.o(137572);
  }
  
  public final void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(137573);
    this.paX.pbb = 4;
    this.oIr = true;
    super.jQ(paramBoolean);
    AppMethodBeat.o(137573);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137568);
    ab.i("MicroMsg.Music.MMPlayer", "pause");
    if (!bWb())
    {
      AppMethodBeat.o(137568);
      return;
    }
    this.paX.pbb = 2;
    AppMethodBeat.o(137568);
  }
  
  public final void play()
  {
    AppMethodBeat.i(137565);
    ab.i("MicroMsg.Music.MMPlayer", "play");
    if (!bWb())
    {
      this.oIr = false;
      d.post(this.cle, "music_player");
      AppMethodBeat.o(137565);
      return;
    }
    if ((bWb()) && (this.paX.bWj()))
    {
      this.paX.pbb = 3;
      Ei();
    }
    AppMethodBeat.o(137565);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(137569);
    this.cfO.seekTo(1000L * paramLong, 2);
    AppMethodBeat.o(137569);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137567);
    ab.i("MicroMsg.Music.MMPlayer", "stop");
    this.oIr = true;
    if (this.paX.bWj()) {
      Ei();
    }
    AppMethodBeat.o(137567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.c
 * JD-Core Version:    0.7.0.1
 */