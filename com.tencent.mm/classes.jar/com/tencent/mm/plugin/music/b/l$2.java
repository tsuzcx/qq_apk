package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;

final class l$2
  implements IAudioListener
{
  private int channel;
  private a.a etg;
  private int samplerate;
  
  l$2(l paraml)
  {
    AppMethodBeat.i(270858);
    this.channel = 0;
    this.samplerate = 0;
    this.etg = new a.a(2, this.LJN.hqQ);
    AppMethodBeat.o(270858);
  }
  
  public final long getActualTime(long paramLong)
  {
    return 0L;
  }
  
  public final boolean isEnabled()
  {
    return this.LJN.ete != null;
  }
  
  public final boolean isTerminal()
  {
    return false;
  }
  
  public final boolean onPcm(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong)
  {
    AppMethodBeat.i(270860);
    if (this.LJN.ete != null) {
      this.LJN.ete.a(this.etg, this.channel, this.samplerate, paramBufferInfo1.byteBuffer);
    }
    AppMethodBeat.o(270860);
    return false;
  }
  
  public final boolean onPcm(FloatBufferInfo paramFloatBufferInfo1, FloatBufferInfo paramFloatBufferInfo2, long paramLong)
  {
    AppMethodBeat.i(270862);
    if (this.LJN.ete != null) {
      this.LJN.ete.a(this.etg, this.channel, this.samplerate, paramFloatBufferInfo1.floatBuffer);
    }
    AppMethodBeat.o(270862);
    return false;
  }
  
  public final long onPlayerReady(int paramInt, AudioInformation paramAudioInformation, long paramLong)
  {
    AppMethodBeat.i(270864);
    this.channel = paramAudioInformation.getChannels();
    this.samplerate = ((int)paramAudioInformation.getSampleRate());
    if (this.LJN.ete != null) {
      this.LJN.ete.a(this.etg);
    }
    AppMethodBeat.o(270864);
    return 0L;
  }
  
  public final void onPlayerSeekComplete(long paramLong) {}
  
  public final void onPlayerStopped()
  {
    AppMethodBeat.i(270869);
    if (this.LJN.ete != null) {
      this.LJN.ete.b(this.etg);
    }
    if (this.LJN.LJA != null) {
      this.LJN.LJA.removeAudioListener(this);
    }
    AppMethodBeat.o(270869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.l.2
 * JD-Core Version:    0.7.0.1
 */